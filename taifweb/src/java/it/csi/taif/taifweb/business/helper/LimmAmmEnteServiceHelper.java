/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper;

import java.io.IOException;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.GinevraConstants;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.LimammEnteServiceLocator;
import it.csi.taif.taifweb.util.service.integration.svista.LimammEnte_PortType;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;
import it.csi.taif.taifweb.util.xml.XmlSerializer;
import it.csi.wso2.apiman.oauth2.helper.GenericWrapperFactoryBean;
import it.csi.wso2.apiman.oauth2.helper.OauthHelper;
import it.csi.wso2.apiman.oauth2.helper.TokenRetryManager;
import it.csi.wso2.apiman.oauth2.helper.WsProvider;
import it.csi.wso2.apiman.oauth2.helper.extra.axis1.Axis1Impl;

public class LimmAmmEnteServiceHelper extends AbstractServiceHelper {

	private LimammEnte_PortType service;

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

	public LimmAmmEnteServiceHelper(String urlService) {

		this.urlService = urlService;

	}

	public Provincia[] cercaProvinceDelPiemonte()
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaProvinceDelPiemonte] BEGIN");
		try {
		return normalizeProvinceReturnType(
				this.getService().cercaProvincePerIdRegione(GinevraConstants.ID_REGIONE_PIEMONTE));
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaProvinceDelPiemonte] END");
		}
	}
	
	public Provincia[] cercaProvince()
			throws ServiceException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaProvince] BEGIN");
		try {
			LimammEnte_PortType service = this.getService();
			
			Provincia[] result = service.cercaTutteLeProvince();
			
			return result;
		}
		catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaProvince] END");
		}
	}

	public Provincia cercaProvinciaPerCodiceIstat(String codiceIstatProvincia)
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaProvinciaPerCodiceIstat] BEGIN");
		try {
			return this.getService().cercaProvinciaPerCodiceIstat(codiceIstatProvincia);
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaProvinciaPerCodiceIstat] END");
		}
	}
	
	public Provincia cercaProvinciaPerIdProvincia(long idProvincia)
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaProvinciaPerIdProvincia] BEGIN");
		try {
			return this.getService().cercaProvinciaPerIdProvincia(idProvincia);
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaProvinciaPerIdProvincia] END");
		}
	}

	public Comune[] cercaComuniPerIdProvincia(long idProvincia)
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComuniPerIdProvincia] BEGIN");
		try {
			return normalizeProvinceReturnType(this.getService().cercaComuniPerIdProvincia(idProvincia));
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComuniPerIdProvincia] END");
		}
	}
	
	public Comune[] cercaComuniPerCodiceIstatProvincia(String codiceIstatProvincia) throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComuniPerCodiceIstatProvincia] BEGIN");
		try {
			Provincia p = this.cercaProvinciaPerCodiceIstat(codiceIstatProvincia);
			return this.cercaComuniPerIdProvincia(p.getId());
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComuniPerCodiceIstatProvincia] BEGIN");			
		}
	}

	public Comune[] cercaComuniPerDescrizioneCheIniziaPer(String nomeComune)
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComuniPerDescrizioneCheIniziaPer] BEGIN");
		try {
			return normalizeProvinceReturnType(
				this.getService().cercaComuniPerNome(nomeComune, GinevraConstants.MATCH_STARTS_WITH));
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComuniPerDescrizioneCheIniziaPer] END");
		}
	}

	public Comune[] cercaComuniPerNomeEsatto(String nomeComune)
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComuniPerNomeEsatto] BEGIN");
		try {
			return normalizeProvinceReturnType(
				this.getService().cercaComuniPerNome(nomeComune, GinevraConstants.MATCH_EXACTLY));
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComuniPerNomeEsatto] END");
		}
	}
	
	public Comune[] cercaTuttiIComuni() 
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaTuttiIComuni] BEGIN");
		try {
			return normalizeProvinceReturnType(
				this.getService().cercaTuttiIComuni());
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaTuttiIComuni] END");
		}
	}

	public Comune cercaComunePerCodiceIstat(String codIstatComune)
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComunePerCodiceIstat] BEGIN");
		try {
			return this.getService().cercaComunePerCodiceIstat(codIstatComune);
		}
		finally {
			LOGGER.debug("[LimmAmmEnteServiceHelper::cercaComunePerCodiceIstat] END");
		}
	}

	private LimammEnte_PortType getService()
			throws DbManagerException, ServiceException, IOException, ClassNotFoundException {
		LOGGER.debug("[LimmAmmEnteServiceHelper::getService] BEGIN");

		//if (this.service == null) {
			LimammEnteServiceLocator serviceLoc = new LimammEnteServiceLocator();

			LimammEnte_PortType port = serviceLoc.getlimammEnte();

			final TokenRetryManager trm = new TokenRetryManager();
			trm.setOauthHelper(getApiManagerServiceHelper().getOauthHelper());
//			trm.setOauthHelper(new OauthHelper("http://tst-api-ent.ecosis.csi.it/api/token", 
//					"HBxosGiK8fYHHMfZW6qWYyjt_SAa",
//				"2qZSNCr5KIa44gRbuYCa4t64DXMa"));

			final WsProvider wsp = new Axis1Impl();
			trm.setWsProvider(wsp);

			GenericWrapperFactoryBean gwfb = new GenericWrapperFactoryBean();
			LOGGER.debug("url service " + this.urlService);
			gwfb.setEndPoint(this.urlService);
//			gwfb.setEndPoint("http://tst-api-ent.ecosis.csi.it:80/api/territorio_svista_limamm_ente/2.0");
			gwfb.setWrappedInterface(LimammEnte_PortType.class);
//			gwfb.setWrappedClass(LimammEnte_PortType.class.getName());
			gwfb.setPort(port);
			gwfb.setTokenRetryManager(trm);

			this.service = (LimammEnte_PortType) gwfb.create();

			LOGGER.debug("[LimmAmmEnteServiceHelper::getService] Service 'LimammEnte_PortType' INITIALIZED");
		//}

		LOGGER.debug("[LimmAmmEnteServiceHelper::getService] END");

		return this.service;
	}

	/**
	 * Utility method to normalize the return type of <code>LimammEnte</code>
	 * service returning <code>array</code> of {@link Provincia} instances.
	 * 
	 * @param vie
	 *            <code>array</code>s of {@link Provincia} instances
	 * @return <code>array</code>s of {@link Provincia} instances
	 */
	private Provincia[] normalizeProvinceReturnType(Provincia[] array) {
		return array == null ? new Provincia[0] : array;
	}

	/**
	 * Utility method to normalize the return type of <code>LimammEnte</code>
	 * service returning <code>array</code> of {@link Comune} instances.
	 * 
	 * @param vie
	 *            <code>array</code>s of {@link Comune} instances
	 * @return <code>array</code>s of {@link Comune} instances
	 */
	private Comune[] normalizeProvinceReturnType(Comune[] array) {
		return array == null ? new Comune[0] : array;
	}

}
