/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.gestore;

import java.util.*;

import it.csi.taif.topforweb.dto.*;
import it.csi.taif.topforweb.dto.common.*;
import it.csi.taif.topforweb.dto.gestore.*;
import it.csi.taif.topforweb.dto.operatore.*;
import it.csi.taif.topforweb.dto.corsoprofessionale.*;
import it.csi.taif.topforweb.dto.qualifica.*;
import it.csi.taif.topforweb.dto.riconoscimento.*;
import it.csi.taif.topforweb.dto.allegato.*;

import org.apache.log4j.*;
import it.csi.taif.topforweb.util.*;
import it.csi.taif.topforweb.business.*;

/*PROTECTED REGION ID(R-1717552753) ENABLED START*/
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.business.common.ExportElencoOperatoriToExcel;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import it.csi.taif.topforweb.exception.ManagerException;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
/*PROTECTED REGION END*/

public class CPBECpElencoOperatori {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [idSezioneSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSEZIONESELEZIONATA_CODE = "appDataidSezioneSelezionata";

	// ApplicationData: [cognomeRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_COGNOMERICERCAOPERATORE_CODE = "appDatacognomeRicercaOperatore";

	// ApplicationData: [dataPeriodoSvolgimentoA, scope:USER_SESSION]
	public static final String APPDATA_DATAPERIODOSVOLGIMENTOA_CODE = "appDatadataPeriodoSvolgimentoA";

	// ApplicationData: [dataPeriodoSvolgimentoDa, scope:USER_SESSION]
	public static final String APPDATA_DATAPERIODOSVOLGIMENTODA_CODE = "appDatadataPeriodoSvolgimentoDa";

	// ApplicationData: [dettaglioOperatoreSelezionato, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOOPERATORESELEZIONATO_CODE = "appDatadettaglioOperatoreSelezionato";

	// ApplicationData: [elencoAgenziaFormativaRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAGENZIAFORMATIVARICERCAOPERATORE_CODE = "appDataelencoAgenziaFormativaRicercaOperatore";

	// ApplicationData: [elencoAlbiRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBIRICERCAOPERATORE_CODE = "appDataelencoAlbiRicercaOperatore";

	// ApplicationData: [elencoAlbiSelezionatiRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBISELEZIONATIRICERCAOPERATORE_CODE = "appDataelencoAlbiSelezionatiRicercaOperatore";

	// ApplicationData: [elencoAltriCorsi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTRICORSI_CODE = "appDataelencoAltriCorsi";

	// ApplicationData: [elencoComuniRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRICERCAOPERATOREGESTORE_CODE = "appDataelencoComuniRicercaOperatoreGestore";

	// ApplicationData: [elencoCorsiProfessionaliFinanziatiDaRegione, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSIPROFESSIONALIFINANZIATIDAREGIONE_CODE = "appDataelencoCorsiProfessionaliFinanziatiDaRegione";

	// ApplicationData: [elencoQualifiche, scope:USER_SESSION]
	public static final String APPDATA_ELENCOQUALIFICHE_CODE = "appDataelencoQualifiche";

	// ApplicationData: [elencoRiconoscimento, scope:USER_SESSION]
	public static final String APPDATA_ELENCORICONOSCIMENTO_CODE = "appDataelencoRiconoscimento";

	// ApplicationData: [elencoRisultatiRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAOPERATOREGESTORE_CODE = "appDataelencoRisultatiRicercaOperatoreGestore";

	// ApplicationData: [elencoStatoOperatoreRicerca, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOOPERATORERICERCA_CODE = "appDataelencoStatoOperatoreRicerca";

	// ApplicationData: [elencoStatoSchedaRicerca, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATOSCHEDARICERCA_CODE = "appDataelencoStatoSchedaRicerca";

	// ApplicationData: [elencoUnitaFormativaRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAFORMATIVARICERCAOPERATORE_CODE = "appDataelencoUnitaFormativaRicercaOperatore";

	// ApplicationData: [idAgenziaFormativaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAGENZIAFORMATIVASELEZIONATA_CODE = "appDataidAgenziaFormativaSelezionata";

	// ApplicationData: [idComuneSelezionatoRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESELEZIONATORICERCAOPERATOREGESTORE_CODE = "appDataidComuneSelezionatoRicercaOperatoreGestore";

	// ApplicationData: [idStatoOperatoreSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOOPERATORESELEZIONATO_CODE = "appDataidStatoOperatoreSelezionato";

	// ApplicationData: [idStatoSchedaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOSCHEDASELEZIONATO_CODE = "appDataidStatoSchedaSelezionato";

	// ApplicationData: [idUnitaFormativaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAFORMATIVASELEZIONATA_CODE = "appDataidUnitaFormativaSelezionata";

	// ApplicationData: [isIstruttoreOperatore, scope:USER_SESSION]
	public static final String APPDATA_ISISTRUTTOREOPERATORE_CODE = "appDataisIstruttoreOperatore";

	// ApplicationData: [isOperatoreConQualifica, scope:USER_SESSION]
	public static final String APPDATA_ISOPERATORECONQUALIFICA_CODE = "appDataisOperatoreConQualifica";

	// ApplicationData: [numeroAlboOperatore, scope:USER_SESSION]
	public static final String APPDATA_NUMEROALBOOPERATORE_CODE = "appDatanumeroAlboOperatore";

	// ApplicationData: [numeroRisultatiRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_NUMERORISULTATIRICERCAOPERATOREGESTORE_CODE = "appDatanumeroRisultatiRicercaOperatoreGestore";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [profiloUtente, scope:USER_SESSION]
	public static final String APPDATA_PROFILOUTENTE_CODE = "appDataprofiloUtente";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [login, scope:USER_ACTION]
	public static final String APPDATA_LOGIN_CODE = "appDatalogin";

	// ApplicationData: [msgError, scope:USER_ACTION]
	public static final String APPDATA_MSGERROR_CODE = "appDatamsgError";

	// ApplicationData: [primoIngresso, scope:USER_SESSION]
	public static final String APPDATA_PRIMOINGRESSO_CODE = "appDataprimoIngresso";

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [datiOperatore, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATORE_CODE = "appDatadatiOperatore";

	// ApplicationData: [idStatoSchedaSelezionatoRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOSCHEDASELEZIONATORICERCAOPERATORE_CODE = "appDataidStatoSchedaSelezionatoRicercaOperatore";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [datiOperatoreFromDB, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATOREFROMDB_CODE = "appDatadatiOperatoreFromDB";

	// ApplicationData: [elencoNazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCONAZIONI_CODE = "appDataelencoNazioni";

	// ApplicationData: [consensoPubblicazione, scope:USER_SESSION]
	public static final String APPDATA_CONSENSOPUBBLICAZIONE_CODE = "appDataconsensoPubblicazione";

	// ApplicationData: [privacy, scope:USER_SESSION]
	public static final String APPDATA_PRIVACY_CODE = "appDataprivacy";

	// ApplicationData: [ricercaLibera, scope:USER_SESSION]
	public static final String APPDATA_RICERCALIBERA_CODE = "appDataricercaLibera";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoOperatori";

	public static final String MULTIPANEL_MPCAPTCHA = "mpCaptcha";
	public static final String MPI_MPCAPTCHA_FPCAPTCHA = CPNAME + "_" + MULTIPANEL_MPCAPTCHA + "_" + "fpCaptcha";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoOperatori definito in un ExecCommand del
	 * ContentPanel cpElencoOperatori
	 */
	public ExecResults onClickTabellaElencoOperatori(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOOPERATORI_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLAELENCOOPERATORI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1424779435) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			Operatore operatore = new Operatore();

			Integer idPersona = ConvertUtil.convertToInteger(theModel.getIdRiga());

			theModel = ConvertUtil.recuperaDatiDettaglioOperatore(idPersona, theModel, topForfMgr);

			/*
			 * // clono l'oggetto che sto caricando da DB per poi poterlo confrontare con //
			 * quello che arriva dal front-end e vedere quali valori sono cambiati
			 * 
			 * Operatore oper = (Operatore) DTOUtils.deepClone(operatore);
			 * theModel.setAppDatadatiOperatoreFromDB(oper); result.setModel(theModel);
			 */

			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOOPERATORI_OUTCOME_CODE__DETAIL);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoOperatori] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroRicerca definito in un ExecCommand del
	 * ContentPanel cpElencoOperatori
	 */
	public ExecResults indietroRicerca(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRORICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R253563787) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INDIETRORICERCA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroRicerca] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo exportRicercaOperatori definito in un ExecCommand del
	 * ContentPanel cpElencoOperatori
	 */
	public ExecResults exportRicercaOperatori(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPORTRICERCAOPERATORI_OUTCOME_CODE__NORMALE = //NOSONAR  Reason:EIAS
				"Normale"; //NOSONAR  Reason:EIAS
		final String EXPORTRICERCAOPERATORI_OUTCOME_CODE__RIDOTTO = //NOSONAR  Reason:EIAS
				"Ridotto"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1582840202) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDataricercaLibera()) {
				result.setResultCode(EXPORTRICERCAOPERATORI_OUTCOME_CODE__RIDOTTO);
			} else {
				// impostazione del result code 
				result.setResultCode(EXPORTRICERCAOPERATORI_OUTCOME_CODE__NORMALE);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::exportRicercaOperatori] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicerca definito in un ExecCommand del
	 * ContentPanel cpElencoOperatori
	 */
	public ExecResults nuovaRicerca(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R367927976) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDatacognomeRicercaOperatore("");
			theModel.setAppDatadataPeriodoSvolgimentoA("");
			theModel.setAppDatadataPeriodoSvolgimentoDa("");
			theModel.setAppDataelencoAlbiSelezionatiRicercaOperatore((new ArrayList<String>()));
			theModel.setAppDataidAgenziaFormativaSelezionata("");
			theModel.setAppDataidComuneSelezionatoRicercaOperatoreGestore("");
			theModel.setAppDataidSezioneSelezionata("");
			theModel.setAppDataidStatoOperatoreSelezionato("");
			theModel.setAppDataidStatoSchedaSelezionato("");
			theModel.setAppDataidUnitaFormativaSelezionata("");
			theModel.setAppDataisIstruttoreOperatore("");
			theModel.setAppDataisOperatoreConQualifica("");
			theModel.setAppDatanumeroRisultatiRicercaOperatoreGestore("");
			// impostazione del result code 
			result.setResultCode(NUOVARICERCA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::nuovaRicerca] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo exportRicercaLibera definito in un ExecCommand del
	 * ContentPanel cpElencoOperatori
	 */
	public ExecResults exportRicercaLibera(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPORTRICERCALIBERA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String EXPORTRICERCALIBERA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-833926) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String captcha = theModel.getWidg_tfVerificaCaptchaRicercaLibera();
			if (captcha != null && theModel.validateAnswerForWidg_captchaExportRicercaLibera(captcha)) {
				// impostazione del result code 
				result.setResultCode(EXPORTRICERCALIBERA_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Il testo immesso NON corrisponde all'immagine");
				result.setResultCode(EXPORTRICERCALIBERA_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::exportRicercaLibera] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaOperatore definito in un ExecCommand del
	 * ContentPanel cpElencoOperatori
	 */
	public ExecResults eliminaOperatore(

			it.csi.taif.topforweb.dto.gestore.CpElencoOperatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAOPERATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ELIMINAOPERATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R10454012) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ELIMINAOPERATORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaOperatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoOperatori
	 */
	public static void resetClearStatus_widg_tblElencoOperatori(java.util.Map session) {
		session.put("cpElencoOperatori_tblElencoOperatori_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1844468991) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private TopForMgr topForfMgr;

	@Autowired
	private ExportElencoOperatoriToExcel exportToExcel;

	public TopForMgr getTopForfMgr() {
		return topForfMgr;
	}

	public void setTopForfMgr(TopForMgr topForfMgr) {
		this.topForfMgr = topForfMgr;
	}

	public DozerBeanMapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}

	public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
	}

	public ExportElencoOperatoriToExcel getExportToExcel() {
		return exportToExcel;
	}

	public void setExportToExcel(ExportElencoOperatoriToExcel exportToExcel) {
		this.exportToExcel = exportToExcel;
	}

	public ByteArrayOutputStream makeExportToExcel(List<Integer> listOperatoriTrovati, String tracciato)
			throws ManagerException {
		try {
			return exportToExcel.exportToExcel(listOperatoriTrovati, tracciato);
		} catch (Exception e) {
			throw new ManagerException(new Message());

		}

	}

	public ByteArrayOutputStream makeExportToExcelRidotto(List<Integer> listOperatoriTrovati, String tracciato)
			throws ManagerException {
		try {
			return exportToExcel.exportToExcelRidotto(listOperatoriTrovati, tracciato);
		} catch (Exception e) {
			throw new ManagerException(new Message());

		}

	}

	/*PROTECTED REGION END*/
}
