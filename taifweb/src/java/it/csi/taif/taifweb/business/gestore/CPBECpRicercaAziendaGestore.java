/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.gestore;

import java.util.*;

import it.csi.taif.taifweb.dto.*;
import it.csi.taif.taifweb.dto.domanda.*;
import it.csi.taif.taifweb.dto.common.*;
import it.csi.taif.taifweb.dto.gestore.*;
import it.csi.taif.taifweb.dto.allegato.*;
import it.csi.taif.taifweb.dto.allegatodownload.*;

import org.apache.log4j.*;
import it.csi.taif.taifweb.util.*;
import it.csi.taif.taifweb.business.*;

/*PROTECTED REGION ID(R-1285431308) ENABLED START*/
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.business.BEException;
import it.csi.taif.taifweb.business.common.ExportToExcel;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaRicercaAziendaAvanzataDto;
import it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SoggettoGestoreFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.manager.validation.Validator;
import it.csi.taif.taifweb.dto.ExecResults;
import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.domanda.Attivita;
import it.csi.taif.taifweb.dto.gestore.Azienda;
import it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;
/*PROTECTED REGION END*/

public class CPBECpRicercaAziendaGestore {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [elencoAlbiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBIRICERCAAZIENDA_CODE = "appDataelencoAlbiRicercaAzienda";

	// ApplicationData: [elencoAlbiSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAlbiSelezionatiRicercaAzienda";

	// ApplicationData: [elencoStatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIRICERCAAZIENDA_CODE = "appDataelencoStatiRicercaAzienda";

	// ApplicationData: [elencoSottostatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSOTTOSTATIRICERCAAZIENDA_CODE = "appDataelencoSottostatiRicercaAzienda";

	// ApplicationData: [elencoAssociazioniCertificazioneRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONERICERCAAZIENDA_CODE = "appDataelencoAssociazioniCertificazioneRicercaAzienda";

	// ApplicationData: [elencoCategorieImpresaRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESARICERCAAZIENDA_CODE = "appDataelencoCategorieImpresaRicercaAzienda";

	// ApplicationData: [elencoAttivitaSvolteRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTERICERCAAZIENDA_CODE = "appDataelencoAttivitaSvolteRicercaAzienda";

	// ApplicationData: [elencoSezioniRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONIRICERCAAZIENDA_CODE = "appDataelencoSezioniRicercaAzienda";

	// ApplicationData: [elencoRisultatiRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAAZIENDAGESTORE_CODE = "appDataelencoRisultatiRicercaAziendaGestore";

	// ApplicationData: [elencoDomande, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOMANDE_CODE = "appDataelencoDomande";

	// ApplicationData: [elencoComuniRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRICERCAAZIENDAGESTORE_CODE = "appDataelencoComuniRicercaAziendaGestore";

	// ApplicationData: [idComuneSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidComuneSelezionatoRicercaAziendaGestore";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [idSottoStatoPraticaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSOTTOSTATOPRATICASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore";

	// ApplicationData: [idStatoPraticaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOPRATICASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidStatoPraticaSelezionatoRicercaAziendaGestore";

	// ApplicationData: [numeroRisultatiRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_NUMERORISULTATIRICERCAAZIENDAGESTORE_CODE = "appDatanumeroRisultatiRicercaAziendaGestore";

	// ApplicationData: [numeroAlboAzienda, scope:USER_SESSION]
	public static final String APPDATA_NUMEROALBOAZIENDA_CODE = "appDatanumeroAlboAzienda";

	// ApplicationData: [codFisPivaAzienda, scope:USER_SESSION]
	public static final String APPDATA_CODFISPIVAAZIENDA_CODE = "appDatacodFisPivaAzienda";

	// ApplicationData: [dataIscrizioneAlboAziendaA, scope:USER_SESSION]
	public static final String APPDATA_DATAISCRIZIONEALBOAZIENDAA_CODE = "appDatadataIscrizioneAlboAziendaA";

	// ApplicationData: [dataIscrizioneAlboAziendaDa, scope:USER_SESSION]
	public static final String APPDATA_DATAISCRIZIONEALBOAZIENDADA_CODE = "appDatadataIscrizioneAlboAziendaDa";

	// ApplicationData: [denominazioneAzienda, scope:USER_SESSION]
	public static final String APPDATA_DENOMINAZIONEAZIENDA_CODE = "appDatadenominazioneAzienda";

	// ApplicationData: [titolareLegaleRappresentanteAzienda, scope:USER_SESSION]
	public static final String APPDATA_TITOLARELEGALERAPPRESENTANTEAZIENDA_CODE = "appDatatitolareLegaleRappresentanteAzienda";

	// ApplicationData: [elencoAssociazioniCertificazioniSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda";

	// ApplicationData: [elencoAttivitaSvolteSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTESELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAttivitaSvolteSelezionatiRicercaAzienda";

	// ApplicationData: [elencoCategorieImpresaSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESASELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoCategorieImpresaSelezionatiRicercaAzienda";

	// ApplicationData: [elencoSezioniSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoSezioniSelezionatiRicercaAzienda";

	// ApplicationData: [idProvinciaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDPROVINCIASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidProvinciaSelezionatoRicercaAziendaGestore";

	// ApplicationData: [elencoProvinciaRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCIARICERCAAZIENDAGESTORE_CODE = "appDataelencoProvinciaRicercaAziendaGestore";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaAziendaGestore";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuni definito in un ExecCommand del
	 * ContentPanel cpRicercaAziendaGestore
	 */
	public ExecResults loadComuni(

			it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String LOADCOMUNI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1192076626) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String idProvincia = theModel.getAppDataidProvinciaSelezionatoRicercaAziendaGestore();
			if (StringUtils.isNotEmpty(idProvincia)
					&& !Constants.NULL_VALUE_ISTAT_PROVINCIA.equalsIgnoreCase(idProvincia)) {
				theModel.setAppDataelencoComuniRicercaAziendaGestore(this.taifMgr.getElencoComuniPerIstatProvincia(
						theModel.getAppDataidProvinciaSelezionatoRicercaAziendaGestore()));
			} else {
				theModel.setAppDataelencoComuniRicercaAziendaGestore(this.taifMgr.getElencoComuni());
			}
			// impostazione del result code 
			result.setResultCode(LOADCOMUNI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadComuni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadSottoStatoPratica definito in un ExecCommand del
	 * ContentPanel cpRicercaAziendaGestore
	 */
	public ExecResults loadSottoStatoPratica(

			it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADSOTTOSTATOPRATICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String LOADSOTTOSTATOPRATICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R403487661) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			ArrayList<CodeDescription> t = new ArrayList<CodeDescription>();
			String linguaDati = ConvertUtil.getLinguaFromSoggettoGestore(
					theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore());

			if (theModel.getAppDataidStatoPraticaSelezionatoRicercaAziendaGestore() != null
					&& !theModel.getAppDataidStatoPraticaSelezionatoRicercaAziendaGestore().equalsIgnoreCase("")) {
				statoPraticaFilter = getStatoPraticaFilter(theModel, linguaDati);
				statoPraticaFilter.setfKStatoPraticaPadre(
						new Integer(theModel.getAppDataidStatoPraticaSelezionatoRicercaAziendaGestore()));

				if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.itaLang)) {
					t = taifMgr.getElencoSottoStatiPraticaIta(statoPraticaFilter);
				} else {
					t = taifMgr.getElencoSottoStatiPraticaFra(statoPraticaFilter);
				}

				// impostazione del result code 
				if (t.size() != 0) {
					result.setResultCode(LOADSOTTOSTATOPRATICA_OUTCOME_CODE__OK);
				} else {
					result.setResultCode(LOADSOTTOSTATOPRATICA_OUTCOME_CODE__KO);
					theModel.setAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore("");
				}
			} else {
				result.setResultCode(LOADSOTTOSTATOPRATICA_OUTCOME_CODE__KO);
				theModel.setAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore("");
			}

			// impostazione del result code 

			theModel.setAppDataelencoSottostatiRicercaAzienda(t);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadSottoStatoPratica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAziende definito in un ExecCommand del
	 * ContentPanel cpRicercaAziendaGestore
	 */
	public ExecResults ricercaAziende(

			it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAAZIENDE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String RICERCAAZIENDE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1660763260) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				ArrayList<Azienda> listAziendaTrovate = this.ricercaAziendaByCriteria(theModel, false);
				theModel.setAppDataelencoRisultatiRicercaAziendaGestore(listAziendaTrovate);
				result.setResultCode(RICERCAAZIENDE_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, RICERCAAZIENDE_OUTCOME_CODE__KO);
			}
			//theModel.setAppDataelencoRisultatiRicercaAziendaGestore(this.taifMgr.ricercaAziende());
			//theModel.setAppDataelencoDomande(this.dummyMgr.getElencoDomande());
			// impostazione del result code 
			ActionContext.getContext().getSession().put("aziendeList",
					theModel.getAppDataelencoRisultatiRicercaAziendaGestore());

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAziende] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel cpRicercaAziendaGestore
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.gestore.CpRicercaAziendaGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK_ITA = //NOSONAR  Reason:EIAS
				"OK_ITA"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_FRA = //NOSONAR  Reason:EIAS
				"OK_FRA"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1610081940) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			///////////////////////////////////////////////////
			///////////////////////////////////////////////////
			///////////////////////////////////////////////////
			//theModel.getAppDatacurrentUser().getProfiloUtenteTaif().setIdSoggettoGestore(1);
			///////////////////////////////////////////////////
			///////////////////////////////////////////////////
			///////////////////////////////////////////////////
			///////////////////////////////////////////////////

			theModel.getSession().remove("idAziendeTrovate");

			String linguaDati = ConvertUtil.getLinguaFromSoggettoGestore(
					theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore());

			int idConfigUtente;
			if (ActionContext.getContext().getSession().get("idConfigUtente") != null) {
				Integer interConfigUtente = (Integer) ActionContext.getContext().getSession().get("idConfigUtente");
				idConfigUtente = interConfigUtente;
			}

			visibileOrdinFilter = getVisibileOrdinFilter(theModel, linguaDati);
			soggettoGestoreFilter = getSoggettoGestoreFilter(theModel);

			if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif()
					.getIdSoggettoGestore() == it.csi.taif.taifweb.business.dao.util.Constants.GESTORE_SUPERADMIN) {
				soggettoGestoreFilter.setFlagVisibile(0);
			}

			theModel.setAppDataelencoAlbiRicercaAzienda(taifMgr.getElencoAlbi(soggettoGestoreFilter));

			statoPraticaFilter = getStatoPraticaFilter(theModel, linguaDati);
			if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif() != null) {
				if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.fraLang)) {
					theModel.setAppDataelencoStatiRicercaAzienda(taifMgr.getElencoStatiPraticaFra(statoPraticaFilter));
				} else {
					theModel.setAppDataelencoStatiRicercaAzienda(taifMgr.getElencoStatiPraticaIta(statoPraticaFilter));
				}
			} else {
				theModel.setAppDataelencoStatiRicercaAzienda(taifMgr.getElencoStatiPraticaIta(statoPraticaFilter));
			}

			theModel.setAppDataelencoSottostatiRicercaAzienda(new ArrayList<CodeDescription>());

			theModel.setAppDataelencoSezioniRicercaAzienda(this.taifMgr.getElencoSezioni());

			// se il soggetto gestore è = 0 sono superadmin e devo tutte le categorie impresa
			// e attività scolte (sia italiane che francesi) quindi tolgo il flag sulla nazione

			if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore() == 0) {
				visibileOrdinFilter.setFlagItaFr(null);
			}

			theModel.setAppDataelencoCategorieImpresaRicercaAzienda(
					this.taifMgr.getElencoCategorieImpresaRicerca(visibileOrdinFilter));
			theModel.setAppDataelencoAttivitaSvolteRicercaAzienda(
					this.taifMgr.getElencoTipoAttivita(visibileOrdinFilter));

			theModel.setAppDataelencoAssociazioniCertificazioneRicercaAzienda(
					this.taifMgr.getElencoAssociazioniCertificazioni(linguaDati));

			theModel.setAppDataelencoComuniRicercaAziendaGestore(this.taifMgr.getElencoComuni());

			theModel.setAppDataelencoProvinciaRicercaAziendaGestore(
					ListUtils.addFirstEmptyElement(this.taifMgr.getElencoProvinceIstat()));

			// impostazione del result code 
			if (ConvertUtil.checkIsNullOrEmpty(linguaDati)) {
				if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.itaLang)) {
					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_ITA);
				} else {
					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_FRA);
				}
			} else {
				result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_ITA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-450870598) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	@Autowired
	private VisibileOrdinFilter visibileOrdinFilter;

	@Autowired
	private SoggettoGestoreFilter soggettoGestoreFilter;

	@Autowired
	private StatoPraticaFilter statoPraticaFilter;

	@Autowired
	private TaifMgr taifMgr;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private ExportToExcel exportToExcel;

	public ExportToExcel getExportToExcel() {
		return exportToExcel;
	}

	public void setExportToExcel(ExportToExcel exportToExcel) {
		this.exportToExcel = exportToExcel;
	}

	public DozerBeanMapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}

	public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
	}

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	public void setVisibileOrdinFilter(VisibileOrdinFilter visibileOrdinFilter) {
		this.visibileOrdinFilter = visibileOrdinFilter;
	}

	public void setSoggettoGestoreFilter(SoggettoGestoreFilter soggettoGestoreFilter) {
		this.soggettoGestoreFilter = soggettoGestoreFilter;
	}

	public void setStatoPraticaFilter(StatoPraticaFilter statoPraticaFilter) {
		this.statoPraticaFilter = statoPraticaFilter;
	}

	private VisibileOrdinFilter getVisibileOrdinFilter(CpRicercaAziendaGestoreModel theModel, String linguaDati) {
		if (ConvertUtil.checkIsNullOrEmpty(linguaDati)) {
			if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.itaLang)) {
				visibileOrdinFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
			} else {
				visibileOrdinFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.fLang);
			}
		} else {
			visibileOrdinFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
		}
		visibileOrdinFilter.setFlagVisibile(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		return visibileOrdinFilter;
	}

	private SoggettoGestoreFilter getSoggettoGestoreFilter(CpRicercaAziendaGestoreModel theModel) {
		soggettoGestoreFilter
				.setIdSoggetto(theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore());
		return soggettoGestoreFilter;
	}

	private StatoPraticaFilter getStatoPraticaFilter(CpRicercaAziendaGestoreModel theModel, String linguaDati) {
		if (ConvertUtil.checkIsNullOrEmpty(linguaDati)) {
			if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.itaLang)) {
				statoPraticaFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
			} else {
				statoPraticaFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.fLang);
			}
		} else {
			statoPraticaFilter.setFlagItaFr(it.csi.taif.taifweb.business.dao.util.Constants.iLang);
		}
		statoPraticaFilter.setFlagVisibile(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		return statoPraticaFilter;
	}

	private ArrayList<Azienda> ricercaAziendaByCriteria(CpRicercaAziendaGestoreModel theModel, boolean isRicercaLibera)
			throws ManagerException, ParseException {
		RicercaAziendaFilter ricercaAziendaFilter = new RicercaAziendaFilter();
		ArrayList<Azienda> aziendeList = new ArrayList<Azienda>();
		ricercaAziendaFilter.setIdRuolo(new Integer("1"));
		ricercaAziendaFilter.setTipoSede(new Integer("1"));
		//albo di appartenenza
		List<String> listAlboAppartenenza = new ArrayList<String>();
		if (ConvertUtil.checkListIsNullOrEmpty(theModel.getAppDataelencoAlbiSelezionatiRicercaAzienda())) {
			for (int i = 0; i < theModel.getAppDataelencoAlbiSelezionatiRicercaAzienda().size(); i++) {
				String id = theModel.getAppDataelencoAlbiSelezionatiRicercaAzienda().get(i);
				listAlboAppartenenza.add(id);
			}
			ricercaAziendaFilter.setAlboAppartenenza(listAlboAppartenenza);
		} else {
			for (int i = 0; i < theModel.getAppDataelencoAlbiRicercaAzienda().size(); i++) {
				String id = theModel.getAppDataelencoAlbiRicercaAzienda().get(i).getCode();
				listAlboAppartenenza.add(id);
			}
			ricercaAziendaFilter.setAlboAppartenenza(listAlboAppartenenza);
		}
		ricercaAziendaFilter.setCodiceFiscaleAzienda(theModel.getAppDatacodFisPivaAzienda());
		ricercaAziendaFilter.setNumeroAlbo(theModel.getAppDatanumeroAlboAzienda());
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatadataIscrizioneAlboAziendaA())) {
			Date dataIscrizioneAlboA = df.parse(theModel.getAppDatadataIscrizioneAlboAziendaA());
			ricercaAziendaFilter.setDataA(dataIscrizioneAlboA);
		}
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatadataIscrizioneAlboAziendaDa())) {
			Date dataIscrizioneAlboDa = df.parse(theModel.getAppDatadataIscrizioneAlboAziendaDa());
			ricercaAziendaFilter.setDataDa(dataIscrizioneAlboDa);
		}
		ricercaAziendaFilter.setIstatComune(theModel.getAppDataidComuneSelezionatoRicercaAziendaGestore());
		String istatProvincia = theModel.getAppDataidProvinciaSelezionatoRicercaAziendaGestore();
		if (StringUtils.isNotEmpty(istatProvincia)
				&& !Constants.NULL_VALUE_ISTAT_PROVINCIA.equalsIgnoreCase(istatProvincia)) {
			ricercaAziendaFilter.setIstatProvincia(istatProvincia);
		} else {
			ricercaAziendaFilter.setIstatProvincia(null);
		}
		ricercaAziendaFilter.setTitolare(theModel.getAppDatatitolareLegaleRappresentanteAzienda());
		ricercaAziendaFilter.setDenominazioneAzienda(theModel.getAppDatadenominazioneAzienda());

		// stato pratica
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore())) {
			ricercaAziendaFilter.setStatoPratica(
					new Integer(theModel.getAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore()));
		} else if (ConvertUtil
				.checkIsNullOrEmpty(theModel.getAppDataidStatoPraticaSelezionatoRicercaAziendaGestore())) {
			ricercaAziendaFilter
					.setStatoPratica(new Integer(theModel.getAppDataidStatoPraticaSelezionatoRicercaAziendaGestore()));
		}
		// sezione
		List<String> listSezione = new ArrayList<String>();

		if (ConvertUtil.checkListIsNullOrEmpty(theModel.getAppDataelencoSezioniSelezionatiRicercaAzienda())) {
			for (int i = 0; i < theModel.getAppDataelencoSezioniSelezionatiRicercaAzienda().size(); i++) {
				String id = theModel.getAppDataelencoSezioniSelezionatiRicercaAzienda().get(i);
				listSezione.add(id);
			}
			ricercaAziendaFilter.setSezione(listSezione);
		}

		// categorie d'impresa
		List<String> listCategorieImpresa = new ArrayList<String>();

		if (ConvertUtil.checkListIsNullOrEmpty(theModel.getAppDataelencoCategorieImpresaSelezionatiRicercaAzienda())) {
			for (int i = 0; i < theModel.getAppDataelencoCategorieImpresaSelezionatiRicercaAzienda().size(); i++) {
				String id = theModel.getAppDataelencoCategorieImpresaSelezionatiRicercaAzienda().get(i);
				listCategorieImpresa.add(id);
			}
			ricercaAziendaFilter.setListaCategoriaImpresa(listCategorieImpresa);
		}

		// Associazione e certificazione
		List<String> listAssociazioneCertificazione = new ArrayList<String>();

		if (ConvertUtil.checkListIsNullOrEmpty(
				theModel.getAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda())) {
			for (int i = 0; i < theModel.getAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda()
					.size(); i++) {
				String code = theModel.getAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda().get(i);
				if (code.equalsIgnoreCase(Constants.FILTRO_RICERCA_ALTRI_ALBI)) {
					ricercaAziendaFilter.setAppartenenzaAltriAlbi(Constants.FILTRO_RICERCA_ALTRI_ALBI);
				}
				if (code.equalsIgnoreCase(Constants.FILTRO_RICERCA_CERTIFICAZIONI)) {
					ricercaAziendaFilter.setAppartenenzaCertificazioni(Constants.FILTRO_RICERCA_CERTIFICAZIONI);
				}
			}
		}

		// Attività svolte
		List<Attivita> listAttivitaSvolte = new ArrayList<Attivita>();

		if (ConvertUtil.checkListIsNullOrEmpty(theModel.getAppDataelencoAttivitaSvolteSelezionatiRicercaAzienda())) {
			for (int i = 0; i < theModel.getAppDataelencoAttivitaSvolteSelezionatiRicercaAzienda().size(); i++) {
				Attivita attivita = new Attivita();
				attivita.setIdAttivita(
						new Integer(theModel.getAppDataelencoAttivitaSvolteSelezionatiRicercaAzienda().get(i)));
				listAttivitaSvolte.add(attivita);
			}
			ricercaAziendaFilter.setAttivitaSvolteList(listAttivitaSvolte);
		}

		// prarametro ricerca libera = false
		ricercaAziendaFilter.setRicercaLibera(false);

		ricercaAziendaFilter
				.setIdSoggettoGestore(theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore());
		List<TaifTAziendaRicercaAziendaAvanzataDto> elencoAziendeTrovate = this.taifMgr
				.ricercaAziende(ricercaAziendaFilter);
		theModel.getSession().put(Constants.SESSION_FILTRO_RICERCA_AZIENDE, ricercaAziendaFilter);

		for (TaifTAziendaRicercaAziendaAvanzataDto aziendaDto : elencoAziendeTrovate) {
			//aziendeList.add(dozerBeanMapper.map(aziendaDto, Azienda.class));
			Azienda azienda = new Azienda();
			azienda = convertFromDtoToObject(aziendaDto, theModel);
			aziendeList.add(azienda);
		}
		theModel.setAppDataelencoRisultatiRicercaAziendaGestore(aziendeList);
		List<Integer> idAziendeTrovate = new ArrayList<Integer>();
		for (TaifTAziendaRicercaAziendaAvanzataDto taifTAziendaRicercaAziendaAvanzataDto : elencoAziendeTrovate) {
			idAziendeTrovate.add(taifTAziendaRicercaAziendaAvanzataDto.getId());
		}
		ActionContext.getContext().getSession().put("idAziendeTrovate", idAziendeTrovate);
		return aziendeList;
	}

	private Azienda convertFromDtoToObject(TaifTAziendaRicercaAziendaAvanzataDto aziendaDto,
			CpRicercaAziendaGestoreModel theModel) {
		Azienda azienda = new Azienda();
		String linguaDati = ConvertUtil.getLinguaFromSoggettoGestore(
				theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore());
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getCodiceFiscaleAzienda())) {
			azienda.setCodiceFiscale(aziendaDto.getCodiceFiscaleAzienda());
		} else if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getPivaAzienda())) {
			azienda.setCodiceFiscale(aziendaDto.getPivaAzienda());
		} else if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getNSiret())) {
			azienda.setCodiceFiscale(aziendaDto.getNSiret());
		} else if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getNTva())) {
			azienda.setCodiceFiscale(aziendaDto.getNTva());
		}
		azienda.setDenominazione(aziendaDto.getDenominazioneAzienda());
		azienda.setIdAlbo(aziendaDto.getIdAlboAppartenenza());
		azienda.setDsAlbo(aziendaDto.getDsAlboAppartenenza());
		azienda.setIdStato(aziendaDto.getIdStatoPratica());
		azienda.setIdSoggettoGestore(aziendaDto.getIdSoggettoGestore());
		if (ConvertUtil.checkIsNullOrEmpty(linguaDati)) {
			if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.itaLang)) {
				azienda.setDsStato(aziendaDto.getDsStatoPraticaIta());
			} else {
				azienda.setDsStato(aziendaDto.getDsStatoPraticaFra());
			}
		} else {
			azienda.setDsStato(aziendaDto.getDsStatoPraticaIta());
		}
		azienda.setIdAlbo(aziendaDto.getIdAlboAppartenenza());
		azienda.setIdAzienda(aziendaDto.getId());
		azienda.setNumeroAlbo(aziendaDto.getNumeroAlbo());
		azienda.setTitolare(aziendaDto.getCognomeTitolare() + " " + aziendaDto.getNomeTitolare());
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getIstatComuneSede())) {
			azienda.setComune(getDenominazioneComuneFromCodiceIstat(aziendaDto.getIstatComuneSede(), theModel));
		} else {
			azienda.setComune(aziendaDto.getComuneSedeEstero());
		}
		//azienda.setIconaCancella(val);
		azienda.setIdPratica(aziendaDto.getIdPratica());
		return azienda;
	}

	private String getDenominazioneComuneFromCodiceIstat(String codiceIstatComune,
			CpRicercaAziendaGestoreModel theModel) {
		String denominazioneComune = "";
		for (CodeDescription element : theModel.getAppDataelencoComuniRicercaAziendaGestore()) {
			if (element.getCode().equalsIgnoreCase(codiceIstatComune)) {
				denominazioneComune = element.getDescription();
				break;
			}
		}
		return denominazioneComune;
	}

	/*PROTECTED REGION END*/
}
