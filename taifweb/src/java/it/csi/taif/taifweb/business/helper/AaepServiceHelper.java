/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.taif.taifweb.business.helper.dto.factory.AaepFactory;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.dto.domanda.ImportAziendaAAEP;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.service.integration.aaep.AziendaAAEP;
import it.csi.taif.taifweb.util.service.integration.aaep.JavaServiceDesc;
import it.csi.taif.taifweb.util.service.integration.aaep.JavaServiceDescServiceLocator;
import it.csi.taif.taifweb.util.service.integration.aaep.ListaAttEconProd;
import it.csi.taif.taifweb.util.service.integration.aaep.ListaSediAAEP;
import it.csi.taif.taifweb.util.service.integration.aaep.Sede;
import it.csi.taif.taifweb.util.service.integration.aaep.UserException;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;

public class AaepServiceHelper extends AbstractServiceHelper {

	private static final String AAEP_CERCA_PER_CODICE_FISCALE_EXCEPTION_MSG = "it.csi.csi.wrapper.UserException:cercaPerCodiceFiscaleAAEP: Nessun record trovato";
	private static final String AAEP_CERCA_PER_FILTRI_EXCEPTION_MSG = "it.csi.csi.wrapper.UserException:cercaPerFiltri: Nessun record trovato";
	

	private JavaServiceDesc service;

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".service");

	private ApiManagerServiceHelper apiManagerServiceHelper;

	/**
	 * @return the apiManagerServiceHelper
	 */
	public ApiManagerServiceHelper getApiManagerServiceHelper() {
		return apiManagerServiceHelper;
	}

	/**
	 * @param apiManagerServiceHelper
	 *            the apiManagerServiceHelper to set
	 */
	public void setApiManagerServiceHelper(ApiManagerServiceHelper apiManagerServiceHelper) {
		this.apiManagerServiceHelper = apiManagerServiceHelper;
	}

	protected String urlService = null;

	public AaepServiceHelper(String urlService) {
		this.urlService = urlService;
	}

	private JavaServiceDesc getService()
			throws ServiceException, DbManagerException, IOException, ClassNotFoundException {
		LOGGER.debug("[AaepServiceHelper::getService] BEGIN");

		// if (this.service == null) {
		JavaServiceDescServiceLocator serviceLoc = new JavaServiceDescServiceLocator();

		JavaServiceDesc port = serviceLoc.getAAEPCSI();

		final TokenRetryManager trm = new TokenRetryManager();
		trm.setOauthHelper(getApiManagerServiceHelper().getOauthHelper());
		// trm.setOauthHelper(new
		// OauthHelper("http://tst-api-ent.ecosis.csi.it/api/token",
		// "HBxosGiK8fYHHMfZW6qWYyjt_SAa",
		// "2qZSNCr5KIa44gRbuYCa4t64DXMa"));

		final WsProvider wsp = new Axis1Impl();
		trm.setWsProvider(wsp);

		GenericWrapperFactoryBean gwfb = new GenericWrapperFactoryBean();
		LOGGER.debug("url service " + this.urlService);
		gwfb.setEndPoint(this.urlService);
		gwfb.setWrappedInterface(JavaServiceDesc.class);
		gwfb.setPort(port);
		gwfb.setTokenRetryManager(trm);

		this.service = (JavaServiceDesc) gwfb.create();

		LOGGER.debug("[AaepServiceHelper::getService] Service 'JavaServiceDesc' INITIALIZED");
		// }

		LOGGER.debug("[AaepServiceHelper::getService] END");

		return this.service;
	}

	public ListaAttEconProd[] cercaAziendeAAEPByCodiceFiscale(String codiceFiscaleSoggetto)
			throws it.csi.taif.taifweb.exception.ServiceException {
		LOGGER.debug("[AaepServiceHelper::cercaAziendeAAEPByCodiceFiscale] BEGIN");
		ListaAttEconProd[] result = null;
		/*
		 * Stando alla documentazione ufficiale i 15 parametri di ricerca sono: 1
		 * sottosistema (AAEP, INFOCAMERE o FP) obbligatorio 2 stato cessazione (0, 1,
		 * 2) obbligatorio 3 codice fiscale azienda 4 tipo codice fiscale 5 ragione
		 * sociale 6 tipo ragione sociale 7 carattere di ricerca jolly 8 codice ATECO 9
		 * tipo codice ATECO 10 codice fiscale persona 11 codice natura giuridica 12
		 * sigla provincia 13 codice comune 14 nome località 15 tipo sede
		 */
		try {
			result = this.getService().cercaPerFiltri("AAEP", "0", "", "", "", "", "", "", "", codiceFiscaleSoggetto,
					"", "", "", "", "");

		} catch (Exception e) {
			if (StringUtils.startsWithIgnoreCase(e.getMessage(), AAEP_CERCA_PER_FILTRI_EXCEPTION_MSG)) {
				// Come insegna Magister Cornacchia, è una soluzione orrenda ma AAEP gestisce
				// così gli errori
				return null;
			} else {
				getServiceException(e, Constants.ERR_AAEP, "AaepServiceHelper::cercaAziendeAAEPByCodiceFiscale");
			}
		} finally {
			LOGGER.debug("[AaepServiceHelper::cercaAziendeAAEPByCodiceFiscale] END");
		}
		return result;
	}

	private it.csi.taif.taifweb.exception.ServiceException getServiceException(Exception e, String codeService,
			String methodName) throws it.csi.taif.taifweb.exception.ServiceException {
		final Message errorMessage = this.buildMessage(MsgCodeEnum.G002, codeService);
		final String errorLog = "[" + methodName + "]ERROR (%s): " + errorMessage.getText();
		LOGGER.error(String.format(errorLog, e.getClass().getName()), e);
		throw new it.csi.taif.taifweb.exception.ServiceException(e, errorMessage);
	}

	public ImportAziendaAAEP dettaglioAziendaAAEPByCodiceFiscale(String codiceFiscale)
			throws it.csi.taif.taifweb.exception.ServiceException {
		LOGGER.debug("[AaepServiceHelper::dettaglioAziendaAAEPByCodiceFiscale] BEGIN");
		ImportAziendaAAEP result = null;
		try {
			AziendaAAEP azienda = this.getService().cercaPerCodiceFiscaleAAEP(codiceFiscale, null, null);
			List<Sede> sedi = this.getSedi(azienda);
			result = AaepFactory.createImportAziendaAAEP(azienda, sedi);

		} catch (Exception e) {
			if (StringUtils.startsWithIgnoreCase(e.getMessage(), AAEP_CERCA_PER_CODICE_FISCALE_EXCEPTION_MSG)) {
				// Come insegna Magister Cornacchia, è una soluzione orrenda ma AAEP gestisce
				// così gli errori
				return null;
			} else {
				getServiceException(e, Constants.ERR_AAEP, "AaepServiceHelper::dettaglioAziendaAAEPByCodiceFiscale");
			}
		} finally {
			LOGGER.debug("[AaepServiceHelper::dettaglioAziendaAAEPByCodiceFiscale] END");
		}
		return result;
	}

	private List<Sede> getSedi(AziendaAAEP azienda) throws it.csi.taif.taifweb.exception.ServiceException {
		List<Sede> result = new ArrayList<Sede>();
		if (azienda != null) {
			for (final ListaSediAAEP sede : azienda.getListaSediAAEP()) {
				final Sede sedeAAEP = this.cercaPuntualeSede(sede.getIdAAEPAzienda(), sede.getIdAAEPSede(),
						sede.getDataInizioVal());

				if (sedeAAEP != null && sedeAAEP.getDataFineAttivita() == null) {
					result.add(sedeAAEP);
				}
			}
		}
		return result;

	}

	private Sede cercaPuntualeSede(String idAzienda, String idSede, String dataInizioVal)
			throws it.csi.taif.taifweb.exception.ServiceException {
		LOGGER.debug("[AaepServiceHelper::cercaPuntualeSede] BEGIN");
		Sede result = null;
		try {
			result = this.getService().cercaPuntualeSedeAAEP(idAzienda, idSede, dataInizioVal);
		} catch (Exception e) {
			final Message errorMessage = this.buildMessage(MsgCodeEnum.G002, Constants.ERR_AAEP);
			final String errorLog = "[AaepServiceHelper::cercaPuntualeSede] ERROR (%s): " + errorMessage.getText();

			LOGGER.error(String.format(errorLog, e.getClass().getName()), e);

			this.getServiceException(e, Constants.ERR_AAEP, "cercaPuntualeSede");
		} finally {
			LOGGER.debug("[AaepServiceHelper::cercaPuntualeSede] END");
		}
		return result;
	}
}
