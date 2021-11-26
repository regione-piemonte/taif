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

/*PROTECTED REGION ID(R1737513242) ENABLED START*/

import com.lowagie.text.DocumentException;
import com.opensymphony.xwork2.ActionContext;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.business.BEException;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaByUnitaFormativaPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByCodiceFiscalePersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDatiIdentificativiOperatoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaExtRicercaNumeroAlboForestaleDto;
import it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaPersona;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.report.AttestazioneFrequenzaConProfitto;
import it.csi.taif.topforweb.dto.ExecResults;
import it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel;
import it.csi.taif.topforweb.dto.operatore.Operatore;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;

import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

/*PROTECTED REGION END*/

public class CPBECpOperatoreDettaglio {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [msgError, scope:USER_ACTION]
	public static final String APPDATA_MSGERROR_CODE = "appDatamsgError";

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

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [primoIngresso, scope:USER_SESSION]
	public static final String APPDATA_PRIMOINGRESSO_CODE = "appDataprimoIngresso";

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [idStatoSchedaSelezionatoRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOSCHEDASELEZIONATORICERCAOPERATORE_CODE = "appDataidStatoSchedaSelezionatoRicercaOperatore";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [datiOperatore, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATORE_CODE = "appDatadatiOperatore";

	// ApplicationData: [idComuneNascitaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNENASCITASELEZIONATO_CODE = "appDataidComuneNascitaSelezionato";

	// ApplicationData: [idComuneResidenzaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNERESIDENZASELEZIONATO_CODE = "appDataidComuneResidenzaSelezionato";

	// ApplicationData: [idNazioneNascitaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDNAZIONENASCITASELEZIONATA_CODE = "appDataidNazioneNascitaSelezionata";

	// ApplicationData: [fromModifica, scope:USER_SESSION]
	public static final String APPDATA_FROMMODIFICA_CODE = "appDatafromModifica";

	// ApplicationData: [datiOperatoreFromDB, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATOREFROMDB_CODE = "appDatadatiOperatoreFromDB";

	// ApplicationData: [arrivoDaModifica, scope:USER_SESSION]
	public static final String APPDATA_ARRIVODAMODIFICA_CODE = "appDataarrivoDaModifica";

	// ApplicationData: [consensoPubblicazione, scope:USER_SESSION]
	public static final String APPDATA_CONSENSOPUBBLICAZIONE_CODE = "appDataconsensoPubblicazione";

	// ApplicationData: [privacy, scope:USER_SESSION]
	public static final String APPDATA_PRIVACY_CODE = "appDataprivacy";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpOperatoreDettaglio";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoCorsiFinanziatiRegione definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults onClickTabellaElencoCorsiFinanziatiRegione(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOCORSIFINANZIATIREGIONE_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLAELENCOCORSIFINANZIATIREGIONE_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-90579081) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOCORSIFINANZIATIREGIONE_OUTCOME_CODE__DETAIL);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onClickTabellaElencoCorsiFinanziatiRegione] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onTableClickAltriCorsi definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults onTableClickAltriCorsi(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTABLECLICKALTRICORSI_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONTABLECLICKALTRICORSI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1227618476) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONTABLECLICKALTRICORSI_OUTCOME_CODE__DETAIL);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onTableClickAltriCorsi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaOperatore definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults modificaOperatore(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICAOPERATORE_OUTCOME_CODE__OK_OPERATORE_IT_OPERATOREXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_IT_operatorExists"; //NOSONAR  Reason:EIAS
		final String MODIFICAOPERATORE_OUTCOME_CODE__OK_OPERATORE_FR_OPERATOREXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_FR_operatorExists"; //NOSONAR  Reason:EIAS
		final String MODIFICAOPERATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R389237470) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Operatore op = new Operatore();
			RicercaOperatoreFilter filtro = new RicercaOperatoreFilter();
			String esito = "";

			if (ConvertUtil.checkIsNullOrEmpty(
					theModel.getAppDatadettaglioOperatoreSelezionato().getCodiceFiscaleOperatore())) {
				op = cercaOperatoreInAnagrafica(theModel, filtro,
						theModel.getAppDatadettaglioOperatoreSelezionato().getCodiceFiscaleOperatore(),
						Constants.NAZIONE_IT);
				esito = MODIFICAOPERATORE_OUTCOME_CODE__OK_OPERATORE_IT_OPERATOREXISTS;
			} else {
				op = cercaOperatoreInAnagrafica(theModel, filtro,
						theModel.getAppDatadettaglioOperatoreSelezionato().getNRsiMsa(), Constants.NAZIONE_FR);
				esito = MODIFICAOPERATORE_OUTCOME_CODE__OK_OPERATORE_FR_OPERATOREXISTS;
			}

			theModel.setAppDataprivacy(true);
			theModel.setAppDataconsensoPubblicazione(true);
			theModel.setAppDatafromModifica(true);
			theModel.setAppDataarrivoDaModifica(true);
			theModel.setAppDatadatiOperatore(op);
			Operatore opFromDB = new Operatore();
			opFromDB.setStatoScheda(op.getStatoScheda());
			theModel.setAppDatadatiOperatoreFromDB(opFromDB);

			// clono l'oggetto che sto caricando da DB per poi poterlo confrontare con 
			// quello che arriva dal front-end e vedere quali valori sono cambiati

			/*
			 * Operatore oper = (Operatore) DTOUtils.deepClone(op);
			 * theModel.setAppDatadatiOperatoreFromDB(oper);
			 */
			// impostazione del result code 
			result.setResultCode(esito);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::modificaOperatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaOperatore definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults eliminaOperatore(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAOPERATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1195311855) ENABLED START*/
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

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroDettaglioOperatore definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults indietroDettaglioOperatore(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRODETTAGLIOOPERATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R750327925) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INDIETRODETTAGLIOOPERATORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroDettaglioOperatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicerca definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults nuovaRicerca(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-495358403) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
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
	 * Implementazione del metodo eliminaAttestato definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults eliminaAttestato(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-164750885) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ELIMINAATTESTATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaAttestato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_OP_IT = //NOSONAR  Reason:EIAS
				"OK_GESTORE_OP_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_OP_FR = //NOSONAR  Reason:EIAS
				"OK_GESTORE_OP_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_OP_IT = //NOSONAR  Reason:EIAS
				"OK_LIBERO_OP_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_OP_FR = //NOSONAR  Reason:EIAS
				"OK_LIBERO_OP_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1524245742) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_OP_IT);

			if (theModel.getAppDataprofiloUtente().equalsIgnoreCase(Constants.EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_IT)
					|| theModel.getAppDataprofiloUtente()
							.equalsIgnoreCase(Constants.EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_FR)) {
				if (ConvertUtil.checkIsNullOrEmpty(
						theModel.getAppDatadettaglioOperatoreSelezionato().getCodiceFiscaleOperatore())) {
					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_OP_IT);
				} else if (ConvertUtil
						.checkIsNullOrEmpty(theModel.getAppDatadettaglioOperatoreSelezionato().getNRsiMsa())) {
					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_OP_FR);
				}
			} else {
				if (ConvertUtil.checkIsNullOrEmpty(
						theModel.getAppDatadettaglioOperatoreSelezionato().getCodiceFiscaleOperatore())) {
					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_OP_IT);
				} else if (ConvertUtil
						.checkIsNullOrEmpty(theModel.getAppDatadettaglioOperatoreSelezionato().getNRsiMsa())) {
					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_OP_FR);
				}
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

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeRefresh definito in un ExecCommand del
	 * ContentPanel cpOperatoreDettaglio
	 */
	public ExecResults executeRefresh(

			it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEREFRESH_OUTCOME_CODE__OK_ITA = //NOSONAR  Reason:EIAS
				"OK_ITA"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__OK_FRA = //NOSONAR  Reason:EIAS
				"OK_FRA"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R630386107) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(EXECUTEREFRESH_OUTCOME_CODE__OK_ITA);

			if (ConvertUtil.checkIsNullOrEmpty(
					theModel.getAppDatadettaglioOperatoreSelezionato().getCodiceFiscaleOperatore())) {
				result.setResultCode(EXECUTEREFRESH_OUTCOME_CODE__OK_ITA);
			} else if (ConvertUtil
					.checkIsNullOrEmpty(theModel.getAppDatadettaglioOperatoreSelezionato().getNRsiMsa())) {
				result.setResultCode(EXECUTEREFRESH_OUTCOME_CODE__OK_FRA);
			} else {

			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeRefresh] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblCorsiProfessionaliFinanziatiRegione
	 */
	public static void resetClearStatus_widg_tblCorsiProfessionaliFinanziatiRegione(java.util.Map session) {
		session.put("cpOperatoreDettaglio_tblCorsiProfessionaliFinanziatiRegione_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAltriCorsi
	 */
	public static void resetClearStatus_widg_tblAltriCorsi(java.util.Map session) {
		session.put("cpOperatoreDettaglio_tblAltriCorsi_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblQualifiche
	 */
	public static void resetClearStatus_widg_tblQualifiche(java.util.Map session) {
		session.put("cpOperatoreDettaglio_tblQualifiche_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRiconoscimenti
	 */
	public static void resetClearStatus_widg_tblRiconoscimenti(java.util.Map session) {
		session.put("cpOperatoreDettaglio_tblRiconoscimenti_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2082359462) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	@Autowired
	private TopForMgr topForfMgr;

	public TopForMgr getTopForfMgr() {
		return topForfMgr;
	}

	public void setTopForfMgr(TopForMgr topForfMgr) {
		this.topForfMgr = topForfMgr;
	}

	@Autowired
	private AttestazioneFrequenzaConProfitto attestazioneFrequenzaConProfitto;

	public AttestazioneFrequenzaConProfitto getAttestazioneFrequenzaConProfitto() {
		return attestazioneFrequenzaConProfitto;
	}

	public void setAttestazioneFrequenzaConProfitto(AttestazioneFrequenzaConProfitto attestazioneFrequenzaConProfitto) {
		this.attestazioneFrequenzaConProfitto = attestazioneFrequenzaConProfitto;
	}

	private void caricaDatiOperatorePerModifica(it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel theModel) {

	}

	private Operatore cercaOperatoreInAnagrafica(CpOperatoreDettaglioModel theModel, RicercaOperatoreFilter filtro,
			String codFisNrsiMsa, String nazione) throws ManagerException {
		Operatore operatore = new Operatore();
		// se nazione è IT allora cerco per codice fiscale altrimenti per nRsiMsa
		if (nazione.equalsIgnoreCase(Constants.NAZIONE_IT)) {
			filtro.setCodiceFiscale(codFisNrsiMsa);
		} else {
			filtro.setnRsiMsa(codFisNrsiMsa);
		}
		TaifTPersonaDatiIdentificativiOperatoreDto operatoreDto = this.topForfMgr
				.findDatiIdentificativiOperatore(filtro);

		// se codice fiscale diverso da null allora operatore è stato trovatoo
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getCodiceFiscale())) {
			operatore = convertFromDtoToObject(operatoreDto, theModel);
		}
		return operatore;

	}

	private Operatore convertFromDtoToObject(TaifTPersonaDatiIdentificativiOperatoreDto operatoreDto,
			CpOperatoreDettaglioModel theModel) throws ManagerException {
		Operatore operatore = new Operatore();
		operatore.setIdPersonaOperatore(operatoreDto.getIdPersona() + "");

		operatore.setIdSoggettoGestore(operatoreDto.getIdSoggettoGestore() + "");

		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getCodiceFiscale())) {
			operatore.setCodiceFiscaleOperatore(operatoreDto.getCodiceFiscale());
		} else if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getNRsiMsa())) {
			operatore.setCodiceFiscaleOperatore(operatoreDto.getNRsiMsa());
		}
		operatore.setCognomeNomeOperatore(operatoreDto.getCognome() + " " + operatoreDto.getNome());
		operatore.setCognomeOperatore(operatoreDto.getCognome());
		operatore.setNomeOperatore(operatoreDto.getNome());
		if (ConvertUtil.checkDateIsNullOrZero(operatoreDto.getDataNascita())) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			operatore.setDataNascitaOperatore(df.format(operatoreDto.getDataNascita()));
		}
		if (ConvertUtil.checkIntIsNullOrZero(operatoreDto.getIdNazione())) {
			theModel.setAppDataidNazioneNascitaSelezionata(operatoreDto.getIdNazione() + "");
			operatore.setStatoNascitaOperatore(operatoreDto.getIdNazione() + "");
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getIstatComuneNascita())) {
			theModel.setAppDataidComuneNascitaSelezionato(operatoreDto.getIstatComuneNascita() + "");
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getComuneEsteroNascita())) {
			operatore.setComuneEsteroNascitaOperatore(operatoreDto.getComuneEsteroNascita());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getIstatComuneResidenza())) {
			theModel.setAppDataidComuneResidenzaSelezionato(operatoreDto.getIstatComuneResidenza());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getComuneEsteroResidenza())) {
			operatore.setComuneEsteroResidenzaOperatore(operatoreDto.getComuneEsteroResidenza());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getIndirizzoResidenza())) {
			operatore.setIndirizzoResidenzaOperatore(operatoreDto.getIndirizzoResidenza());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getCivicoResidenza())) {
			operatore.setCivicoResidenzaOperatore(operatoreDto.getCivicoResidenza());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getCapResidenza())) {
			operatore.setCapResidenzaOperatore(operatoreDto.getCapResidenza());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getTelefono())) {
			operatore.setTelefonoOperatore(operatoreDto.getTelefono());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getCellulare())) {
			operatore.setCellulareOperatore(operatoreDto.getCellulare());
		}

		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getEmailPersonale())) {
			operatore.setEmailOperatore(operatoreDto.getEmailPersonale());
		}

		if (ConvertUtil.checkIntIsNullOrZero(operatoreDto.getIdTitoloStudio())) {
			operatore.setIdTitoloStudioIta(operatoreDto.getIdTitoloStudio() + "");
		} else {
			operatore.setIdTitoloStudioIta(it.csi.taif.topforweb.business.dao.util.Constants.zero);
		}
		if (ConvertUtil.checkIntIsNullOrZero(operatoreDto.getIdTitoloStudioFra())) {
			operatore.setIdTitoloStudioFra(operatoreDto.getIdTitoloStudioFra() + "");
		} else {
			operatore.setIdTitoloStudioFra(it.csi.taif.topforweb.business.dao.util.Constants.zero);
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getTitoloStudioIta())) {
			operatore.setIdTitoloStudioIta(operatoreDto.getTitoloStudioIta());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getTitoloStudioFra())) {
			operatore.setIdTitoloStudioIta(operatoreDto.getTitoloStudioFra());
		}

		if (operatoreDto.getPubblico().intValue() == it.csi.taif.topforweb.business.dao.util.Constants.oneInt) {
			operatore.setStatoOperatore(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_SI);
		} else if (operatoreDto.getPubblico().intValue() == it.csi.taif.topforweb.business.dao.util.Constants.zeroInt) {
			operatore.setStatoOperatore(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_NO);
		}

		theModel.setAppDataidStatoOperatoreSelezionato(operatore.getStatoOperatore());

		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getStatoSchedaIta())) {
			String statoScheda = "";
			if (theModel.getAppDatacurrentUser().getLingua()
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				statoScheda = operatoreDto.getStatoSchedaIta();
			} else {
				statoScheda = operatoreDto.getStatoSchedaFra();
			}
			operatore.setStatoScheda(statoScheda);
		}

		RicercaOperatoreFilter filtroIdPersona = new RicercaOperatoreFilter();
		filtroIdPersona.setIdPersona(operatoreDto.getIdPersona() + "");

		List<TaifTPersonaExtRicercaNumeroAlboForestaleDto> associatoAziendaIscrittaAlboRegione = this.topForfMgr
				.findRicercaNumeroAlboForestale(filtroIdPersona);

		String numeroAlboForestale = "NO";
		if (associatoAziendaIscrittaAlboRegione != null && associatoAziendaIscrittaAlboRegione.size() != 0) {
			String numero = associatoAziendaIscrittaAlboRegione.get(0).getNumeroAlboForestale();
			numeroAlboForestale = ConvertUtil.checkIsNullOrEmpty(numero)
					? "SI &emsp;&emsp;<b>numero albo<b>:    " + numero
					: "NO";
		}
		operatore.setAssociatoAziendaIscrittaAlboForestaleENumeroAlbo(numeroAlboForestale);

		return operatore;
	}

	public ByteArrayOutputStream createPdfAttestato(int idCorsoProfessionale, Operatore operatoreSelezionato)
			throws DocumentException, IOException, ManagerException {
		try {

			int idUnitaFormativa = 0;
			String istatSedeCorso = null;
			TaifTCorsoDto corsoDto = topForfMgr.findUnitaFormativaByIdCorso(idCorsoProfessionale);
			if (corsoDto != null) {
				idUnitaFormativa = corsoDto.getFkUnitaFormativa();
				istatSedeCorso = corsoDto.getIstatSede();
			}
			TaifTPersonaByCodiceFiscalePersonaDto persoanaByCodiceFiscale = topForfMgr
					.findPersonaPerCodiceFiscale(operatoreSelezionato.getCodiceFiscaleOperatore());

			UnitaFormativaPersona unitaFormativaPers = new UnitaFormativaPersona();
			unitaFormativaPers.setIdPersona(persoanaByCodiceFiscale.getIdPersona());
			unitaFormativaPers.setIdUnitaFormativa(idUnitaFormativa);

			List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> listAgenziaFormativa = topForfMgr
					.findByUnitaFormativaPersona(unitaFormativaPers);
			String filePath = extractPicture();
			if (!listAgenziaFormativa.isEmpty() && listAgenziaFormativa.size() > 0) {
				return attestazioneFrequenzaConProfitto.createPdf(listAgenziaFormativa, istatSedeCorso, filePath);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ManagerException(new Message());
		}
		return null;

	}

	private String extractPicture() {
		String filePath = ((ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT))
				.getRealPath("/WEB-INF/stampaAttestatoFrequenzaCorso.png");
		return filePath;
	}

	/*PROTECTED REGION END*/
}
