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

/*PROTECTED REGION ID(R-170537530) ENABLED START*/
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.DocumentException;
import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.topforweb.business.BEException;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaByUnitaFormativaPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByCodiceFiscalePersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByFilterDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDatiIdentificativiOperatoreDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaExtRicercaNumeroAlboForestaleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaProfiloUtenteByCodiceFiscaleDto;
import it.csi.taif.topforweb.business.dao.topfor.filter.AgenziaFormativaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.ConfigProfiloFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.CorsoFormazioneFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.CorsoProfessionaleFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.PersonaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.TipoAllegatoFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaPersona;
import it.csi.taif.topforweb.business.dao.topfor.filter.VisibileOrdinFilter;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.manager.db.DbMgr;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.topforweb.business.manager.message.MsgMgr;
import it.csi.taif.topforweb.business.manager.validation.ValidationMgr;
import it.csi.taif.topforweb.business.manager.validation.Validator;
import it.csi.taif.topforweb.business.report.AttestazioneFrequenzaConProfitto;
import it.csi.taif.topforweb.dto.ExecResults;
import it.csi.taif.topforweb.dto.allegato.Allegato;
import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel;
import it.csi.taif.topforweb.dto.operatore.Operatore;
import it.csi.taif.topforweb.dto.qualifica.Qualifica;
import it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.exception.ServiceException;
import it.csi.taif.topforweb.exception.ValidationException;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import it.csi.taif.topforweb.util.GenericUtil;
/*PROTECTED REGION END*/

public class CPBECpInserimentoOperatore {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

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

	// ApplicationData: [elencoNazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCONAZIONI_CODE = "appDataelencoNazioni";

	// ApplicationData: [idComuneNascitaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNENASCITASELEZIONATO_CODE = "appDataidComuneNascitaSelezionato";

	// ApplicationData: [idComuneResidenzaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNERESIDENZASELEZIONATO_CODE = "appDataidComuneResidenzaSelezionato";

	// ApplicationData: [idNazioneNascitaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDNAZIONENASCITASELEZIONATA_CODE = "appDataidNazioneNascitaSelezionata";

	// ApplicationData: [elencoTitoloCorso, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTITOLOCORSO_CODE = "appDataelencoTitoloCorso";

	// ApplicationData: [idTitoloCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDTITOLOCORSOSELEZIONATO_CODE = "appDataidTitoloCorsoSelezionato";

	// ApplicationData: [elencoSedeCorso, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEDECORSO_CODE = "appDataelencoSedeCorso";

	// ApplicationData: [idSedeCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDSEDECORSOSELEZIONATO_CODE = "appDataidSedeCorsoSelezionato";

	// ApplicationData: [elencoEsitoCorso, scope:USER_SESSION]
	public static final String APPDATA_ELENCOESITOCORSO_CODE = "appDataelencoEsitoCorso";

	// ApplicationData: [elencoPeriodoSvolgimentoCorso, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPERIODOSVOLGIMENTOCORSO_CODE = "appDataelencoPeriodoSvolgimentoCorso";

	// ApplicationData: [idEsitoCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDESITOCORSOSELEZIONATO_CODE = "appDataidEsitoCorsoSelezionato";

	// ApplicationData: [idPeriodoSvolgimentoCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDPERIODOSVOLGIMENTOCORSOSELEZIONATO_CODE = "appDataidPeriodoSvolgimentoCorsoSelezionato";

	// ApplicationData: [numeroOreCorso, scope:USER_SESSION]
	public static final String APPDATA_NUMEROORECORSO_CODE = "appDatanumeroOreCorso";

	// ApplicationData: [elencoAttestatoConScadenzaInserimento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTESTATOCONSCADENZAINSERIMENTO_CODE = "appDataelencoAttestatoConScadenzaInserimento";

	// ApplicationData: [idAttestatoConScadenzaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDATTESTATOCONSCADENZASELEZIONATO_CODE = "appDataidAttestatoConScadenzaSelezionato";

	// ApplicationData: [idQualificaSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDQUALIFICASELEZIONATO_CODE = "appDataidQualificaSelezionato";

	// ApplicationData: [elencoCorsiFinanziatiFromUnitaFormativa, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCORSIFINANZIATIFROMUNITAFORMATIVA_CODE = "appDataelencoCorsiFinanziatiFromUnitaFormativa";

	// ApplicationData: [idAgenziaFormativaQualificaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAGENZIAFORMATIVAQUALIFICASELEZIONATA_CODE = "appDataidAgenziaFormativaQualificaSelezionata";

	// ApplicationData: [profiloUtente, scope:USER_SESSION]
	public static final String APPDATA_PROFILOUTENTE_CODE = "appDataprofiloUtente";

	// ApplicationData: [corsoSelezionatoInserimento, scope:USER_SESSION]
	public static final String APPDATA_CORSOSELEZIONATOINSERIMENTO_CODE = "appDatacorsoSelezionatoInserimento";

	// ApplicationData: [altroCorsoSelezionatoInserimento, scope:USER_SESSION]
	public static final String APPDATA_ALTROCORSOSELEZIONATOINSERIMENTO_CODE = "appDataaltroCorsoSelezionatoInserimento";

	// ApplicationData: [qualificaSelezionataInserimento, scope:USER_SESSION]
	public static final String APPDATA_QUALIFICASELEZIONATAINSERIMENTO_CODE = "appDataqualificaSelezionataInserimento";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [riconoscimentoSelezionatoInserimento, scope:USER_SESSION]
	public static final String APPDATA_RICONOSCIMENTOSELEZIONATOINSERIMENTO_CODE = "appDatariconoscimentoSelezionatoInserimento";

	// ApplicationData: [idUnitaFormativaRiconoscimentoSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDUNITAFORMATIVARICONOSCIMENTOSELEZIONATA_CODE = "appDataidUnitaFormativaRiconoscimentoSelezionata";

	// ApplicationData: [elencoAltriCorsiDenominazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALTRICORSIDENOMINAZIONI_CODE = "appDataelencoAltriCorsiDenominazioni";

	// ApplicationData: [elencoUnitaFormativaRiconoscimento, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAFORMATIVARICONOSCIMENTO_CODE = "appDataelencoUnitaFormativaRiconoscimento";

	// ApplicationData: [idAgenziaFormativaRiconoscimentoSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDAGENZIAFORMATIVARICONOSCIMENTOSELEZIONATA_CODE = "appDataidAgenziaFormativaRiconoscimentoSelezionata";

	// ApplicationData: [datiOperatore, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATORE_CODE = "appDatadatiOperatore";

	// ApplicationData: [elencoQualificheDenominazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOQUALIFICHEDENOMINAZIONI_CODE = "appDataelencoQualificheDenominazioni";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [login, scope:USER_ACTION]
	public static final String APPDATA_LOGIN_CODE = "appDatalogin";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [idStatoSchedaSelezionatoRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOSCHEDASELEZIONATORICERCAOPERATORE_CODE = "appDataidStatoSchedaSelezionatoRicercaOperatore";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [primoIngresso, scope:USER_SESSION]
	public static final String APPDATA_PRIMOINGRESSO_CODE = "appDataprimoIngresso";

	// ApplicationData: [fromModifica, scope:USER_SESSION]
	public static final String APPDATA_FROMMODIFICA_CODE = "appDatafromModifica";

	// ApplicationData: [datiOperatoreFromDB, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATOREFROMDB_CODE = "appDatadatiOperatoreFromDB";

	// ApplicationData: [motivazioneRifiutoValidazione, scope:USER_SESSION]
	public static final String APPDATA_MOTIVAZIONERIFIUTOVALIDAZIONE_CODE = "appDatamotivazioneRifiutoValidazione";

	// ApplicationData: [elencoUnitaFormativaCorsiFinanziati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOUNITAFORMATIVACORSIFINANZIATI_CODE = "appDataelencoUnitaFormativaCorsiFinanziati";

	// ApplicationData: [isNuovoInserimentoOperatore, scope:USER_SESSION]
	public static final String APPDATA_ISNUOVOINSERIMENTOOPERATORE_CODE = "appDataisNuovoInserimentoOperatore";

	// ApplicationData: [arrivoDaModifica, scope:USER_SESSION]
	public static final String APPDATA_ARRIVODAMODIFICA_CODE = "appDataarrivoDaModifica";

	// ApplicationData: [privacy, scope:USER_SESSION]
	public static final String APPDATA_PRIVACY_CODE = "appDataprivacy";

	// ApplicationData: [urlPrivacy, scope:USER_SESSION]
	public static final String APPDATA_URLPRIVACY_CODE = "appDataurlPrivacy";

	// ApplicationData: [consensoPubblicazione, scope:USER_SESSION]
	public static final String APPDATA_CONSENSOPUBBLICAZIONE_CODE = "appDataconsensoPubblicazione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpInserimentoOperatore";

	public static final String WIZARD_WZPOPERATORE = "wzpOperatore";
	public static final String STEP_WZPOPERATORE_FPWIZARDDATIANAGRAFICIOPERATORE = CPNAME + "_" + WIZARD_WZPOPERATORE
			+ "_" + "fpWizardDatiAnagraficiOperatore";
	public static final String STEP_WZPOPERATORE_FPWIZARDCORSIFINANZIATIREGIONEOPERATORE = CPNAME + "_"
			+ WIZARD_WZPOPERATORE + "_" + "fpWizardCorsiFinanziatiRegioneOperatore";
	public static final String STEP_WZPOPERATORE_FPWIZARDALTRICORSIOPERATORE = CPNAME + "_" + WIZARD_WZPOPERATORE + "_"
			+ "fpWizardAltriCorsiOperatore";
	public static final String STEP_WZPOPERATORE_FPWIZARDQUALIFICHEOPERATORE = CPNAME + "_" + WIZARD_WZPOPERATORE + "_"
			+ "fpWizardQualificheOperatore";
	public static final String STEP_WZPOPERATORE_FPWIZARDRICONOSCIMENTIOPERATORE = CPNAME + "_" + WIZARD_WZPOPERATORE
			+ "_" + "fpWizardRiconoscimentiOperatore";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeSwitchWizardOperatore definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults executeSwitchWizardOperatore(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTESWITCHWIZARDOPERATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2089900536) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("TAB SELEZIONATO *" + theModel.getSelectedTabKey() + "* - *" + theModel.getSelectedTabValue()
					+ "*");

			try {
				this.switchTabAndInit(theModel);
			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, EXECUTESWITCHWIZARDOPERATORE_OUTCOME_CODE__OK);
			}

			// impostazione del result code 
			result.setResultCode(EXECUTESWITCHWIZARDOPERATORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeSwitchWizardOperatore] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaOperatoreInAnagraficaIt definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults ricercaOperatoreInAnagraficaIt(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATOREXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_IT_operatorExists"; //NOSONAR  Reason:EIAS
		final String RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_IT_operatorNoExists"; //NOSONAR  Reason:EIAS
		final String RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R689600152) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// impostazione del result code 

			// inserire qui la logica applicativa da eseguire:
			Operatore operatore = new Operatore();
			Operatore operatoreBlank = new Operatore();

			RicercaOperatoreFilter ricercaOperatoreFilter = new RicercaOperatoreFilter();
			ricercaOperatoreFilter.setIdSoggettoGestore(
					theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore() + "");
			// anche se non trovo nessun risultato fisso cmq il codice fiscale inserito 
			String codiceFiscaleCercato = theModel.getAppDatadatiOperatore().getCodiceFiscaleOperatore();

			// cerco prima se esiste come operatore
			operatore = cercaOperatoreInAnagrafica(theModel, ricercaOperatoreFilter, codiceFiscaleCercato,
					Constants.NAZIONE_IT);
			// se non esiste come operatore cerco se esiste come persona
			if (!ConvertUtil.checkIsNullOrEmpty(operatore.getIdSoggettoGestore())) {
				operatore = cercaPersonaInAnagrafica(theModel, ricercaOperatoreFilter, codiceFiscaleCercato,
						Constants.NAZIONE_IT);
				if (!ConvertUtil.checkIsNullOrEmpty(operatore.getIdPersonaOperatore())) {
					result.setResultCode(RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS);
					final Message m = this.msgMgr.getMessage(MsgCodeEnum.G0043);
					ServiceException e = new ServiceException(m);
					result.setResultCode(RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS);
					Validator.gestisciEccezione(result, e,
							RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS);
					result.setResultCode(RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS);
					resetDatiOperatoreCaricato(theModel);
					operatoreBlank.setCodiceFiscaleOperatore(codiceFiscaleCercato);
					theModel.setAppDatadatiOperatore(operatoreBlank);
					result.setModel(theModel);
					return result;
				} else {
					result.setResultCode(RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATOREXISTS);
					theModel.setAppDatadatiOperatore(operatore);
					result.setModel(theModel);
					return result;
				}
			} else {
				final Message m = this.msgMgr.getMessage(MsgCodeEnum.G0042);
				ServiceException e = new ServiceException(m);
				result.setResultCode(RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS);
				Validator.gestisciEccezione(result, e,
						RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS);
				result.setResultCode(RICERCAOPERATOREINANAGRAFICAIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS);
				resetDatiOperatoreCaricato(theModel);
				operatoreBlank.setCodiceFiscaleOperatore(codiceFiscaleCercato);
				theModel.setAppDatadatiOperatore(operatoreBlank);
				result.setModel(theModel);
				return result;
			}
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaOperatoreInAnagraficaIt] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaOperatoreInAnagraficaFr definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults ricercaOperatoreInAnagraficaFr(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATOREXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_FR_operatorExists"; //NOSONAR  Reason:EIAS
		final String RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATORNOEXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_FR_operatorNoExists"; //NOSONAR  Reason:EIAS
		final String RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2030169193) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			// impostazione del result code 

			// inserire qui la logica applicativa da eseguire:
			Operatore operatore = new Operatore();
			Operatore operatoreBlack = new Operatore();

			RicercaOperatoreFilter ricercaOperatoreFilter = new RicercaOperatoreFilter();
			ricercaOperatoreFilter.setIdSoggettoGestore(
					theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore() + "");
			// anche se non trovo nessun risultato fisso cmq il codice fiscale inserito 
			String codiceFiscaleCercato = theModel.getAppDatadatiOperatore().getCodiceFiscaleOperatore();

			// cerco prima se esiste come operatore
			operatore = cercaOperatoreInAnagrafica(theModel, ricercaOperatoreFilter, codiceFiscaleCercato,
					Constants.NAZIONE_IT);
			// se non esiste come operatore cerco se esiste come persona
			if (!ConvertUtil.checkIsNullOrEmpty(operatore.getIdSoggettoGestore())) {
				operatore = cercaPersonaInAnagrafica(theModel, ricercaOperatoreFilter, codiceFiscaleCercato,
						Constants.NAZIONE_IT);
				if (!ConvertUtil.checkIsNullOrEmpty(operatore.getIdPersonaOperatore())) {
					result.setResultCode(RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATORNOEXISTS);
					final Message m = this.msgMgr.getMessage(MsgCodeEnum.G0043);
					ServiceException e = new ServiceException(m);
					result.setResultCode(RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATORNOEXISTS);
					Validator.gestisciEccezione(result, e,
							RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATORNOEXISTS);
					result.setResultCode(RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATORNOEXISTS);
					resetDatiOperatoreCaricato(theModel);
					operatoreBlack.setCodiceFiscaleOperatore(codiceFiscaleCercato);
					theModel.setAppDatadatiOperatore(operatoreBlack);
					result.setModel(theModel);
					return result;
				} else {
					result.setResultCode(RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATOREXISTS);
					theModel.setAppDatadatiOperatore(operatore);
					result.setModel(theModel);
					return result;
				}
			} else {
				final Message m = this.msgMgr.getMessage(MsgCodeEnum.G0042);
				ServiceException e = new ServiceException(m);
				result.setResultCode(RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATOREXISTS);
				Validator.gestisciEccezione(result, e,
						RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATOREXISTS);
				result.setResultCode(RICERCAOPERATOREINANAGRAFICAFR_OUTCOME_CODE__OK_OPERATORE_FR_OPERATOREXISTS);
				resetDatiOperatoreCaricato(theModel);
				operatoreBlack.setCodiceFiscaleOperatore(codiceFiscaleCercato);
				theModel.setAppDatadatiOperatore(operatoreBlack);
				result.setModel(theModel);
				return result;
			}
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaOperatoreInAnagraficaFr] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeStatoNascita definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeStatoNascita(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGESTATONASCITA_OUTCOME_CODE__ITALIA = //NOSONAR  Reason:EIAS
				"italia"; //NOSONAR  Reason:EIAS
		final String ONCHANGESTATONASCITA_OUTCOME_CODE__ESTERO = //NOSONAR  Reason:EIAS
				"estero"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-63630674) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONCHANGESTATONASCITA_OUTCOME_CODE__ITALIA);

			// se stato nascita è diverso da italia, quindi diverso da 1
			if (!theModel.getAppDataidNazioneNascitaSelezionata().equalsIgnoreCase("1")) {
				result.setResultCode(ONCHANGESTATONASCITA_OUTCOME_CODE__ESTERO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onChangeStatoNascita] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadSoggettoGestoreFromIstat definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults loadSoggettoGestoreFromIstat(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADSOGGETTOGESTOREFROMISTAT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1001628103) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			int sogg = this.getIdSoggettoFromCodiceIstat(theModel.getAppDataidComuneResidenzaSelezionato());

			theModel.getAppDatadatiOperatore().setIdSoggettoGestore(sogg + "");

			soggettoGestoreVisibleOrdinFilter.setIdSoggettoGestore(sogg);

			String linguaDati = theModel.getAppDatacurrentUser().getLingua();
			theModel.setAppDataelencoAgenziaFormativaRicercaOperatore(this.topForfMgr
					.getElencoAgenziaFormativaFromSoggettoGestore(soggettoGestoreVisibleOrdinFilter, linguaDati));

			// impostazione del result code 
			result.setResultCode(LOADSOGGETTOGESTOREFROMISTAT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadSoggettoGestoreFromIstat] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeStatoScheda definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeStatoScheda(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGESTATOSCHEDA_OUTCOME_CODE__VALIDATA = //NOSONAR  Reason:EIAS
				"validata"; //NOSONAR  Reason:EIAS
		final String ONCHANGESTATOSCHEDA_OUTCOME_CODE__NONVALIDATA = //NOSONAR  Reason:EIAS
				"nonValidata"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1107396461) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONCHANGESTATOSCHEDA_OUTCOME_CODE__VALIDATA);
			theModel.setAppDatamotivazioneRifiutoValidazione("");

			if (theModel.getAppDataidStatoSchedaSelezionato()
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.ID_STATO_SCHEDA_NON_VALIDATA)) {
				result.setResultCode(ONCHANGESTATOSCHEDA_OUTCOME_CODE__NONVALIDATA);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onChangeStatoScheda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeAgenziaFormativa definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeAgenziaFormativa(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGEAGENZIAFORMATIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-889898772) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONCHANGEAGENZIAFORMATIVA_OUTCOME_CODE__OK);
			agenziaFormativaFilter.setIdAgenziaFormativa(theModel.getAppDataidAgenziaFormativaSelezionata());
			ArrayList<CodeDescription> elencoUnitaFormativa = new ArrayList<CodeDescription>();
			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidAgenziaFormativaSelezionata())) {
				elencoUnitaFormativa = this.topForfMgr
						.getElencoUnitaFormativaFromAgenziaFormativa(agenziaFormativaFilter);
			}
			theModel.setAppDataelencoUnitaFormativaCorsiFinanziati(elencoUnitaFormativa);

			CorsoProfessionale obj = new CorsoProfessionale();
			ArrayList<CodeDescription> listBlank = new ArrayList<CodeDescription>();

			theModel.setAppDataidUnitaFormativaSelezionata("");
			theModel.setAppDataelencoTitoloCorso(listBlank);
			theModel.setAppDataidTitoloCorsoSelezionato("");
			theModel.setAppDatacorsoSelezionatoInserimento(obj);
			theModel.setAppDataidEsitoCorsoSelezionato("");
			//theModel.getAppDataelencoAgenziaFormativaRicercaOperatore();
			//theModel.setAppDataelencoQualificheDenominazioni(listBlank);
			theModel.setAppDataelencoSedeCorso(listBlank);
			theModel.setAppDataelencoPeriodoSvolgimentoCorso(listBlank);

			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onChangeAgenziaFormativa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeUnitaFormativa definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeUnitaFormativa(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGEUNITAFORMATIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2098126822) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONCHANGEUNITAFORMATIVA_OUTCOME_CODE__OK);

			unitaFormativaFilter.setIdUnitaFormativa(theModel.getAppDataidAgenziaFormativaSelezionata());
			ArrayList<CodeDescription> elencoCorsi = new ArrayList<CodeDescription>();
			/*if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidUnitaFormativaSelezionata())) {
				elencoCorsi = this.topForfMgr.getElencoCorsiFromUnitaFormativa(unitaFormativaFilter);
			}*/

			corsoFormazioneFilter.setFlagItaFr(theModel.getAppDatatracciato());
			corsoFormazioneFilter.setFlagVisibile(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
			corsoFormazioneFilter
					.setIdUnitaFormativa(Integer.parseInt(theModel.getAppDataidUnitaFormativaSelezionata()));
			corsoFormazioneFilter
					.setIdAgenziaFormativa(Integer.parseInt(theModel.getAppDataidAgenziaFormativaSelezionata()));

			elencoCorsi = topForfMgr.findCorsiPerAgenziaUnita(corsoFormazioneFilter);

			theModel.setAppDataelencoTitoloCorso(elencoCorsi);

			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onChangeUnitaFormativa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeTitoloCorso definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeTitoloCorso(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGETITOLOCORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1870871101) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				this.validationMgr.checkCorsoFinanziatoRegioneGiaInserito(theModel);
			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, ONCHANGETITOLOCORSO_OUTCOME_CODE__OK);
				result.setResultCode(ONCHANGETITOLOCORSO_OUTCOME_CODE__OK);
				result.setModel(theModel);
				return result;
			}

			CorsoProfessionale corsoSelezionato = new CorsoProfessionale();

			corsoProfessionaleFilter.setIdCorso(theModel.getAppDataidTitoloCorsoSelezionato());

			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidTitoloCorsoSelezionato())) {
				corsoSelezionato = this.topForfMgr.getCorsoSelezionato(corsoProfessionaleFilter, theModel);
			}

			theModel.setAppDatacorsoSelezionatoInserimento(corsoSelezionato);

			// impostazione del result code 
			result.setResultCode(ONCHANGETITOLOCORSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onChangeTitoloCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addCorsoFinanziatoRegione definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults addCorsoFinanziatoRegione(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDCORSOFINANZIATOREGIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1148100872) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				this.validationMgr.checkValiditaSchedaCorsiFinanziatiRegione(theModel);
				this.validationMgr.checkCorsoFinanziatoRegioneGiaInserito(theModel);
			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, ADDCORSOFINANZIATOREGIONE_OUTCOME_CODE__OK);
				result.setResultCode(ADDCORSOFINANZIATOREGIONE_OUTCOME_CODE__OK);
				result.setModel(theModel);
				return result;
			}

			int idConfigUtente = 0;

			if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor() != null) {
				idConfigUtente = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdConfigUtente();
			}

			tipoAllegatoFilter = new TipoAllegatoFilter();
			/*			if (ActionContext.getContext().getSession().get("idConfigUtente") != null) {
							String interConfigUtente = ActionContext.getContext().getSession().get("idConfigUtente")+"";
							idConfigUtente = Integer.parseInt(interConfigUtente);
						}*/
			String extensionFile = theModel.getWidg_updFileAttestatoCorsoRegioneContentType();

			// se l'estensione è uguale a null non c'è allegato

			Allegato allegato = null;

			if (extensionFile != null && !extensionFile.equalsIgnoreCase("")) {
				extensionFile = extensionFile.substring(extensionFile.length() - 3, extensionFile.length());
				tipoAllegatoFilter.setEstensioneFile(extensionFile);
				this.validationMgr.validazioneDocumentazioneAllegati(theModel, tipoAllegatoFilter);
				allegato = new Allegato();
				allegato.setNomeFile(theModel.getWidg_updFileAttestatoCorsoRegioneFileName());
				allegato.setDimensioneFileKb(
						ConvertUtil.convertToString(theModel.getWidg_updFileAttestatoCorsoRegione().length()));
				try {
					this.validationMgr.checkNomeAllegatoFile(theModel, allegato);
				} catch (ValidationException e) {
					Validator.gestisciEccezione(result, e, ADDCORSOFINANZIATOREGIONE_OUTCOME_CODE__OK);
					result.setResultCode(ADDCORSOFINANZIATOREGIONE_OUTCOME_CODE__OK);
					result.setModel(theModel);
					return result;
				}
			}

			//				TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = (TaifTPersonaProfiloUtenteByCodiceFiscaleDto) ActionContext
			//						.getContext().getSession().get("profiloUtente");

			//			ProfiloUtenteTopFor put = topForfMgr
			//					.getProfiloUtente(theModel.getAppDatadatiOperatore().getCodiceFiscaleOperatore(), true);
			//			put.setIdConfigUtente(idConfigUtente);
			//			GenericUtil.stampaVO(put, true);

			CorsoProfessionale obj = new CorsoProfessionale();
			obj.setIdCorsoProfessionale(theModel.getAppDatacorsoSelezionatoInserimento().getIdCorsoProfessionale());
			obj.setTitoloCorso(theModel.getAppDatacorsoSelezionatoInserimento().getTitoloCorso());
			//obj.setAttestatoConScadenza("SI");
			obj.setAgenziaFormativa(theModel.getAppDataidAgenziaFormativaSelezionata());
			obj.setDsAgenziaFormativa(it.csi.taif.topforweb.util.ConvertUtil.getDescriptionById(
					theModel.getAppDataidAgenziaFormativaSelezionata(),
					theModel.getAppDataelencoAgenziaFormativaRicercaOperatore()));
			obj.setUnitaFormativa(theModel.getAppDataidUnitaFormativaSelezionata());
			obj.setDsUnitaFormativa(it.csi.taif.topforweb.util.ConvertUtil.getDescriptionById(
					theModel.getAppDataidUnitaFormativaSelezionata(),
					theModel.getAppDataelencoUnitaFormativaCorsiFinanziati()));

			obj.setNumeroOre(theModel.getAppDatacorsoSelezionatoInserimento().getNumeroOre());

			obj.setSedeCorso(theModel.getAppDatacorsoSelezionatoInserimento().getSedeCorso());
			obj.setIstatSedeCorso(theModel.getAppDatacorsoSelezionatoInserimento().getIstatSedeCorso());

			obj.setEsitoCorso(theModel.getAppDataidEsitoCorsoSelezionato());
			obj.setDsEsitoCorso(it.csi.taif.topforweb.util.ConvertUtil.getDescriptionById(
					theModel.getAppDataidEsitoCorsoSelezionato(), theModel.getAppDataelencoEsitoCorso()));

			obj.setPeriodoSvolgimento(theModel.getAppDatacorsoSelezionatoInserimento().getPeriodoSvolgimento());

			String idAllegato = "0";

			try {
				idAllegato = this.topForfMgr.salvaCorso(
						new Integer(theModel.getAppDatacorsoSelezionatoInserimento().getIdCorsoProfessionale()),
						new Integer(theModel.getAppDatadatiOperatore().getIdPersonaOperatore()), allegato, obj,
						idConfigUtente, theModel.getWidg_updFileAttestatoCorsoRegione(),
						theModel.getWidg_updFileAttestatoCorsoRegioneContentType());
			} catch (ServiceException e) {
				Validator.gestisciEccezione(result, e, ADDCORSOFINANZIATOREGIONE_OUTCOME_CODE__OK);
				result.setResultCode(ADDCORSOFINANZIATOREGIONE_OUTCOME_CODE__OK);
				result.setModel(theModel);
				return result;
			}

			if (!idAllegato.equalsIgnoreCase("0")) {
				obj.setIconaAllegato(idAllegato);
			} else {
				obj.setIconaAllegato("");
			}
			obj.setIconaAttestato(theModel.getAppDatacorsoSelezionatoInserimento().getIdCorsoProfessionale());
			//obj.setIconaAllegato(idAllegato);
			obj.setIconaCancella(theModel.getAppDatacorsoSelezionatoInserimento().getIdCorsoProfessionale());

			if (theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione() == null) {
				ArrayList<CorsoProfessionale> ter = new ArrayList<CorsoProfessionale>();
				ter.add(obj);
				theModel.setAppDataelencoCorsiProfessionaliFinanziatiDaRegione(ter);
			} else {
				theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione().add(obj);
			}

			cleanCorsoFinanziatoRegione(theModel);

			// impostazione del result code 
			result.setResultCode(ADDCORSOFINANZIATOREGIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addCorsoFinanziatoRegione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoCorsiFinanziatiRegione definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onClickTabellaElencoCorsiFinanziatiRegione(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOCORSIFINANZIATIREGIONE_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLAELENCOCORSIFINANZIATIREGIONE_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1376164939) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());
			String idAllegatoSelezionato = theModel.getIdRiga();
			String colonna = theModel.getIdColonna();

			log.debug("+++++++++++++++ ID ALLEGATO SELEZIONATO +++++++++++ *" + idAllegatoSelezionato + "*");
			theModel.getSession().put(it.csi.taif.topforweb.util.Constants.INDEX_ID_ALLEGATO_SELEZIONATO,
					idAllegatoSelezionato);

			if (colonna.contentEquals(Constants.ICONA_ATTESTATO)) {

				result.setResultCode(ONCLICKTABELLAELENCOCORSIFINANZIATIREGIONE_OUTCOME_CODE__DETAIL);
			} else if (colonna.contentEquals(Constants.ICONA_CANCELLA)) {
				for (CorsoProfessionale corsoDto : theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione()) {
					if ((Integer.parseInt(corsoDto.getIdCorsoProfessionale())) == Integer
							.parseInt(theModel.getIdRiga())) {
						theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione().remove(corsoDto);
						this.topForfMgr.removeCorso(corsoDto.getIdCorsoProfessionale(),
								theModel.getAppDatadatiOperatore().getIdPersonaOperatore(),
								corsoDto.getIconaAllegato());
						break;
					}
				}
				result.setResultCode(ONCLICKTABELLAELENCOCORSIFINANZIATIREGIONE_OUTCOME_CODE__DELETE);

			}
			// impostazione del result code 
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
	 * Implementazione del metodo eliminaCorsoFinanziatoRegione definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults eliminaCorsoFinanziatoRegione(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINACORSOFINANZIATOREGIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ELIMINACORSOFINANZIATOREGIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1705232440) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ELIMINACORSOFINANZIATOREGIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaCorsoFinanziatoRegione] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeTitoloAltroCorso definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeTitoloAltroCorso(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGETITOLOALTROCORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-213695625) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 

			try {
				this.validationMgr.checkAltroCorsoGiaInserito(theModel);
			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, ONCHANGETITOLOALTROCORSO_OUTCOME_CODE__OK);
				result.setResultCode(ONCHANGETITOLOALTROCORSO_OUTCOME_CODE__OK);
				result.setModel(theModel);
				return result;
			}

			CorsoProfessionale corsoSelezionato = new CorsoProfessionale();

			corsoProfessionaleFilter.setIdCorso(theModel.getAppDataidTitoloCorsoSelezionato());

			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidTitoloCorsoSelezionato())) {
				corsoSelezionato = this.topForfMgr.getCorsoSelezionato(corsoProfessionaleFilter, theModel);
			}

			theModel.setAppDatacorsoSelezionatoInserimento(corsoSelezionato);

			// impostazione del result code 
			result.setResultCode(ONCHANGETITOLOALTROCORSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onChangeTitoloAltroCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addAltroCorso definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults addAltroCorso(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDALTROCORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R349928518) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {

				try {
					this.validationMgr.checkValiditaSchedaAltriCorsi(theModel);
					this.validationMgr.checkAltroCorsoGiaInserito(theModel);
				} catch (ValidationException e) {
					Validator.gestisciEccezione(result, e, ADDALTROCORSO_OUTCOME_CODE__OK);
					result.setResultCode(ADDALTROCORSO_OUTCOME_CODE__OK);
					result.setModel(theModel);
					return result;
				}

				int idConfigUtente = 0;
				tipoAllegatoFilter = new TipoAllegatoFilter();

				if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor() != null) {
					idConfigUtente = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdConfigUtente();
				}
				tipoAllegatoFilter = new TipoAllegatoFilter();
				/*			if (ActionContext.getContext().getSession().get("idConfigUtente") != null) {
								String interConfigUtente = ActionContext.getContext().getSession().get("idConfigUtente")+"";
								idConfigUtente = Integer.parseInt(interConfigUtente);
							}*/
				String extensionFile = theModel.getWidg_updFileAttestatoAltriCorsiContentType();

				// se l'estensione è uguale a null non c'è allegato

				Allegato allegato = null;

				if (extensionFile != null && !extensionFile.equalsIgnoreCase("")) {
					extensionFile = extensionFile.substring(extensionFile.length() - 3, extensionFile.length());
					tipoAllegatoFilter.setEstensioneFile(extensionFile);
					this.validationMgr.validazioneDocumentazioneAllegati(theModel, tipoAllegatoFilter);
					allegato = new Allegato();
					allegato.setNomeFile(theModel.getWidg_updFileAttestatoAltriCorsiFileName());
					allegato.setDimensioneFileKb(
							ConvertUtil.convertToString(theModel.getWidg_updFileAttestatoAltriCorsi().length()));
					try {
						this.validationMgr.checkNomeAllegatoFile(theModel, allegato);
					} catch (ValidationException e) {
						Validator.gestisciEccezione(result, e, ADDALTROCORSO_OUTCOME_CODE__OK);
						result.setResultCode(ADDALTROCORSO_OUTCOME_CODE__OK);
						result.setModel(theModel);
						return result;
					}
				}

				CorsoProfessionale altroCorso = new CorsoProfessionale();
				altroCorso.setIdCorsoProfessionale(
						theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale());
				altroCorso.setTitoloCorso(it.csi.taif.topforweb.util.ConvertUtil.getDescriptionAltroCorsoById(
						theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale(),
						theModel.getAppDataelencoAltriCorsiDenominazioni()));

				altroCorso.setDescrizioneAltroCorso(
						theModel.getAppDataaltroCorsoSelezionatoInserimento().getDescrizioneAltroCorso());
				altroCorso.setAttestatoConScadenza(
						theModel.getAppDataaltroCorsoSelezionatoInserimento().getAttestatoConScadenza());
				altroCorso.setDsAttestatoConScadenza(it.csi.taif.topforweb.util.ConvertUtil.getDescriptionById(
						theModel.getAppDataaltroCorsoSelezionatoInserimento().getAttestatoConScadenza(),
						theModel.getAppDataelencoAttestatoConScadenzaInserimento()));
				altroCorso.setEsitoCorso(theModel.getAppDataidEsitoCorsoSelezionato());
				altroCorso.setDsEsitoCorso(it.csi.taif.topforweb.util.ConvertUtil.getDescriptionById(
						theModel.getAppDataidEsitoCorsoSelezionato(), theModel.getAppDataelencoEsitoCorso()));

				altroCorso.setEsitoCorso(theModel.getAppDataaltroCorsoSelezionatoInserimento().getEsitoCorso());
				altroCorso.setDsEsitoCorso(it.csi.taif.topforweb.util.ConvertUtil.getDescriptionById(
						theModel.getAppDataaltroCorsoSelezionatoInserimento().getEsitoCorso(),
						theModel.getAppDataelencoEsitoCorso()));

				altroCorso.setDescrizioneAltroCorso(
						theModel.getAppDataaltroCorsoSelezionatoInserimento().getDescrizioneAltroCorso());

				String idAllegato = "0";

				try {
					idAllegato = this.topForfMgr.salvaCorso(
							new Integer(
									theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale()),
							new Integer(theModel.getAppDatadatiOperatore().getIdPersonaOperatore()), allegato,
							altroCorso, idConfigUtente, theModel.getWidg_updFileAttestatoAltriCorsi(),
							theModel.getWidg_updFileAttestatoAltriCorsiContentType());
				} catch (ServiceException e) {
					Validator.gestisciEccezione(result, e, ADDALTROCORSO_OUTCOME_CODE__OK);
					result.setResultCode(ADDALTROCORSO_OUTCOME_CODE__OK);
					result.setModel(theModel);
					return result;
				}

				// dopo il salvataggio, in caso di altro corso, aggiorno il titolo del corso con la descrizione
				// solo in visualizzazione, in modo da farlo vedere nella tabella 
				if (ConvertUtil.checkIsNullOrEmpty(altroCorso.getDescrizioneAltroCorso())) {
					String titoloEDesc = altroCorso.getTitoloCorso() + " - " + altroCorso.getDescrizioneAltroCorso();
					altroCorso.setTitoloCorso(titoloEDesc);
				}

				if (!idAllegato.equalsIgnoreCase("0")) {
					altroCorso.setIconaAllegato(idAllegato);
				} else {
					altroCorso.setIconaAllegato("");
				}
				altroCorso.setIconaCancella(
						theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale());

				if (theModel.getAppDataelencoAltriCorsi() == null) {
					ArrayList<CorsoProfessionale> arrList = new ArrayList<CorsoProfessionale>();
					arrList.add(altroCorso);
					theModel.setAppDataelencoAltriCorsi(arrList);
				} else {
					theModel.getAppDataelencoAltriCorsi().add(altroCorso);
				}

				cleanAltroCorso(theModel);

				result.setResultCode(ADDALTROCORSO_OUTCOME_CODE__OK);

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, ADDALTROCORSO_OUTCOME_CODE__OK);
				return result;
			}

			// impostazione del result code 
			result.setResultCode(ADDALTROCORSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addAltroCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAltriCorsi definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onClickTabellaElencoAltriCorsi(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOALTRICORSI_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLAELENCOALTRICORSI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2080043093) ENABLED START*/
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());
			String idAllegatoSelezionato = theModel.getIdRiga();
			String colonna = theModel.getIdColonna();

			log.debug("+++++++++++++++ ID ALLEGATO SELEZIONATO +++++++++++ *" + idAllegatoSelezionato + "*");
			theModel.getSession().put(it.csi.taif.topforweb.util.Constants.INDEX_ID_ALLEGATO_SELEZIONATO,
					idAllegatoSelezionato);

			if (colonna.contentEquals(Constants.ICONA_ATTESTATO)) {
				result.setResultCode(ONCLICKTABELLAELENCOALTRICORSI_OUTCOME_CODE__DETAIL);
			} else if (colonna.contentEquals(Constants.ICONA_CANCELLA)) {
				for (CorsoProfessionale corsoDto : theModel.getAppDataelencoAltriCorsi()) {
					if ((Integer.parseInt(corsoDto.getIdCorsoProfessionale())) == Integer
							.parseInt(theModel.getIdRiga())) {
						theModel.getAppDataelencoAltriCorsi().remove(corsoDto);
						this.topForfMgr.removeCorso(corsoDto.getIdCorsoProfessionale(),
								theModel.getAppDatadatiOperatore().getIdPersonaOperatore(),
								corsoDto.getIconaAllegato());
						break;
					}
				}
				result.setResultCode(ONCLICKTABELLAELENCOALTRICORSI_OUTCOME_CODE__DELETE);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoAltriCorsi] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaAltroCorso definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults eliminaAltroCorso(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAALTROCORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ELIMINAALTROCORSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-659690634) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ELIMINAALTROCORSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaAltroCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addQualifica definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults addQualifica(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDQUALIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ADDQUALIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1208439749) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			int idConfigUtente = 0;
			if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor() != null) {
				idConfigUtente = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdConfigUtente();
			}

			try {

				validationMgr.validitaSchedaQualifiche(theModel.getAppDataqualificaSelezionataInserimento());

				// controllo se la qualifica è stata già inserita
				this.validationMgr.checkQualificaGiaInserita(theModel);
			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, ADDQUALIFICA_OUTCOME_CODE__OK);
				result.setResultCode(ADDQUALIFICA_OUTCOME_CODE__OK);
				result.setModel(theModel);
				return result;
			}

			int idQualificaOperatore = topForfMgr.insertQualificaOperatore(
					theModel.getAppDataqualificaSelezionataInserimento(),
					theModel.getAppDatadatiOperatore().getIdPersonaOperatore(), idConfigUtente);
			// impostazione del result code 
			ArrayList<Qualifica> qualificheList = new ArrayList<Qualifica>();

			if (idQualificaOperatore != 0) {
				Qualifica qualificaInserita = topForfMgr.findQualificaByPrimaryKey(idQualificaOperatore);

				if (theModel.getAppDataelencoQualifiche().isEmpty()) {
					qualificheList.add(qualificaInserita);
					theModel.setAppDataelencoQualifiche(qualificheList);
				} else {
					theModel.getAppDataelencoQualifiche().add(qualificaInserita);
				}
			}

			cleanQualificaPersona(theModel);

			result.setResultCode(ADDQUALIFICA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addQualifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoQualifica definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onClickTabellaElencoQualifica(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOQUALIFICA_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLAELENCOQUALIFICA_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-802148852) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());
			String idAllegatoSelezionato = theModel.getIdRiga();
			String colonna = theModel.getIdColonna();

			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLAELENCOQUALIFICA_OUTCOME_CODE__DETAIL);

			for (Qualifica qualificaDto : theModel.getAppDataelencoQualifiche()) {
				if ((Integer.parseInt(qualificaDto.getIdQualifica())) == Integer.parseInt(theModel.getIdRiga())) {
					theModel.getAppDataelencoQualifiche().remove(qualificaDto);
					topForfMgr.deleteQualificaPersonale(Integer.parseInt(qualificaDto.getIdQualifica()));
					break;
				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoQualifica] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaQualifica definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults eliminaQualifica(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAQUALIFICA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ELIMINAQUALIFICA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1518102773) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ELIMINAQUALIFICA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaQualifica] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeAgenziaFormativaRiconoscimento definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeAgenziaFormativaRiconoscimento(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGEAGENZIAFORMATIVARICONOSCIMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R188048912) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONCHANGEAGENZIAFORMATIVARICONOSCIMENTO_OUTCOME_CODE__OK);
			agenziaFormativaFilter.setIdAgenziaFormativa(
					theModel.getAppDatariconoscimentoSelezionatoInserimento().getAgenziaFormativa());
			ArrayList<CodeDescription> elencoUnitaFormativa = new ArrayList<CodeDescription>();
			if (ConvertUtil.checkIsNullOrEmpty(
					theModel.getAppDatariconoscimentoSelezionatoInserimento().getAgenziaFormativa())) {
				elencoUnitaFormativa = this.topForfMgr
						.getElencoUnitaFormativaFromAgenziaFormativa(agenziaFormativaFilter);
			}
			theModel.setAppDataelencoUnitaFormativaRiconoscimento(elencoUnitaFormativa);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::onChangeAgenziaFormativaRiconoscimento] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onChangeUnitaFormativaRiconoscimento definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onChangeUnitaFormativaRiconoscimento(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCHANGEUNITAFORMATIVARICONOSCIMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1531293814) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONCHANGEUNITAFORMATIVARICONOSCIMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onChangeUnitaFormativaRiconoscimento] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addRiconoscimento definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults addRiconoscimento(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDRICONOSCIMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ADDRICONOSCIMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1912623462) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			int idConfigUtente = 0;
			if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor() != null) {
				idConfigUtente = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdConfigUtente();
			}

			try {
				validationMgr.validaSchedaRiconoscimento(theModel.getAppDatariconoscimentoSelezionatoInserimento());

				// controllo se il riconoscimento è stato già inserito
				this.validationMgr.checkRiconoscimentoGiaInserito(theModel);

			} catch (ValidationException e) {
				Validator.gestisciEccezione(result, e, ADDRICONOSCIMENTO_OUTCOME_CODE__OK);
				result.setResultCode(ADDRICONOSCIMENTO_OUTCOME_CODE__OK);
				result.setModel(theModel);
				return result;
			}

			int idRiconoscimento = topForfMgr.insertRiconoscimentoCorso(
					theModel.getAppDatariconoscimentoSelezionatoInserimento(),
					theModel.getAppDatadatiOperatore().getIdPersonaOperatore(), idConfigUtente);
			// impostazione del result code 
			ArrayList<Riconoscimento> riconiscimentoList = new ArrayList<Riconoscimento>();

			if (idRiconoscimento != 0) {
				Riconoscimento riconoscimentoInserito = topForfMgr.findRiconoscimentoByPrimaryKey(idRiconoscimento);

				if (theModel.getAppDataelencoRiconoscimento().isEmpty()) {
					riconiscimentoList.add(riconoscimentoInserito);
					theModel.setAppDataelencoRiconoscimento(riconiscimentoList);
				} else {
					theModel.getAppDataelencoRiconoscimento().add(riconoscimentoInserito);
				}
			}

			cleanSchedaRiconoscimento(theModel);
			// impostazione del result code 
			result.setResultCode(ADDRICONOSCIMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addRiconoscimento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaRiconoscimenti definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults onClickTabellaRiconoscimenti(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLARICONOSCIMENTI_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLARICONOSCIMENTI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1497079593) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ONCLICKTABELLARICONOSCIMENTI_OUTCOME_CODE__DETAIL);

			for (Riconoscimento riconoscimentoDto : theModel.getAppDataelencoRiconoscimento()) {
				if ((Integer.parseInt(riconoscimentoDto.getIdRiconoscimento())) == Integer
						.parseInt(theModel.getIdRiga())) {
					theModel.getAppDataelencoRiconoscimento().remove(riconoscimentoDto);
					topForfMgr.deleteRiconoscimentoCorso(Integer.parseInt(riconoscimentoDto.getIdRiconoscimento()));
					break;
				}
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaRiconoscimenti] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaRiconoscimento definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults eliminaRiconoscimento(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINARICONOSCIMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ELIMINARICONOSCIMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R463972502) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ELIMINARICONOSCIMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaRiconoscimento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goBackElencoOperatore definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults goBackElencoOperatore(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOBACKELENCOOPERATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String GOBACKELENCOOPERATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1479326963) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GOBACKELENCOOPERATORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::goBackElencoOperatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goBack definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults goBack(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOBACK_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDDATIANAGRAFICIOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDCORSIFINANZIATIREGIONEOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDALTRICORSIOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDQUALIFICHEOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R888697574) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataidStatoSchedaSelezionato(new String());
			theModel.setAppDatacognomeRicercaOperatore(new String());
			// impostazione del result code 
			result.setResultCode(
					GOBACK_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDDATIANAGRAFICIOPERATORE);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::goBack] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaInBozza definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults salvaInBozza(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAINBOZZA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String SALVAINBOZZA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1478590417) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(SALVAINBOZZA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaInBozza] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaProsegui definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults salvaProsegui(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAPROSEGUI_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDDATIANAGRAFICIOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDCORSIFINANZIATIREGIONEOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDALTRICORSIOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDQUALIFICHEOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__CPINSERIMENTOOPERATORE_WZPOPERATORE_FPWIZARDRICONOSCIMENTIOPERATORE = //NOSONAR  Reason:EIAS
				"CpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		final String SALVAPROSEGUI_OUTCOME_CODE__NEXT = //NOSONAR  Reason:EIAS
				"Next"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1226995678) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {

				// se arrivo da modifica salto questa parte perchè posso sicuramente salvare
				// altrimenti se non arrivo da modifica controllo se sono operatore
				// se si vedo se il codice fiscale inserito è di un operatore già esistente
				// se si faccio vedere il messaggio che obbliga a passare dalla modifica per il salvataggio
				// se non è operatore esistente allora o è solo presente su taif_t_persona o neanche su quella
				// e quindi posso salvare 
				// String tipoAccesso = "3"; // only for Test mm
				if (theModel.getAppDatacurrentUser().getTipoAccesso()
						.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_IT)
						|| theModel.getAppDatacurrentUser().getTipoAccesso().equalsIgnoreCase(
								it.csi.taif.topforweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_FR)) {

					if (theModel.getAppDataarrivoDaModifica() == false) {

						Operatore operatore = new Operatore();
						Operatore operatoreBlank = new Operatore();

						RicercaOperatoreFilter ricercaOperatoreFilter = new RicercaOperatoreFilter();
						ricercaOperatoreFilter.setIdSoggettoGestore(
								theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore() + "");
						// anche se non trovo nessun risultato fisso cmq il codice fiscale inserito 
						String codiceFiscaleCercato = theModel.getAppDatadatiOperatore().getCodiceFiscaleOperatore();

						// cerco prima se esiste come operatore
						operatore = cercaOperatoreInAnagrafica(theModel, ricercaOperatoreFilter, codiceFiscaleCercato,
								Constants.NAZIONE_IT);
						// se non esiste come operatore, allora posso salvare senza passare dalla modifica
						if (!ConvertUtil.checkIsNullOrEmpty(operatore.getIdSoggettoGestore())) {
							theModel.setAppDataarrivoDaModifica(true);
							log.debug("NEXT ELEMENT --> salvataggio");
						} else {
							final Message m = this.msgMgr.getMessage(MsgCodeEnum.G0042);
							ServiceException e = new ServiceException(m);
							result.setResultCode(SALVAPROSEGUI_OUTCOME_CODE__KO);
							Validator.gestisciEccezione(result, e, SALVAPROSEGUI_OUTCOME_CODE__KO);
							result.setResultCode(SALVAPROSEGUI_OUTCOME_CODE__KO);
							operatoreBlank.setCodiceFiscaleOperatore(codiceFiscaleCercato);
							theModel.setAppDatadatiOperatore(operatoreBlank);
							result.setModel(theModel);
							return result;
						}
					}

				}

				String currentTab = this.salvaOperatore(theModel);
				String next = getNextElement(currentTab);
				log.debug("NEXT ELEMENT *" + next + "*");
				// impostazione del result code 
				result.setResultCode(next == null ? SALVAPROSEGUI_OUTCOME_CODE__NEXT : next);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, SALVAPROSEGUI_OUTCOME_CODE__KO);
			}
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaProsegui] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel cpInserimentoOperatore
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATOREXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_IT_operatorExists"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_IT_OPERATORNOEXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_IT_operatorNoExists"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_FR_OPERATOREXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_FR_operatorExists"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_FR_OPERATORNOEXISTS = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_FR_operatorNoExists"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_IT = //NOSONAR  Reason:EIAS
				"OK_GESTORE_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_FR = //NOSONAR  Reason:EIAS
				"OK_GESTORE_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_IT_FROMELENCO = //NOSONAR  Reason:EIAS
				"OK_GESTORE_IT_fromElenco"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_FR_FROMELENCO = //NOSONAR  Reason:EIAS
				"OK_GESTORE_FR_fromElenco"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__SUPERADMIN = //NOSONAR  Reason:EIAS
				"superadmin"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1949144898) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<CodeDescription> listEsitoCorso = new ArrayList<CodeDescription>();
			CodeDescription itemEsito1 = new CodeDescription();
			CodeDescription itemEsito2 = new CodeDescription();
			itemEsito1.setCode(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA);
			itemEsito2.setCode(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO);
			if (theModel.getAppDatacurrentUser().getLingua()
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
				itemEsito1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_DESC_FRA);
				itemEsito2.setDescription(
						it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO_DESC_ITA);
			} else {
				itemEsito1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_DESC_FRA);
				itemEsito2.setDescription(
						it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO_DESC_ITA);
			}
			listEsitoCorso.add(itemEsito1);
			listEsitoCorso.add(itemEsito2);

			theModel.setAppDataelencoComuni(this.topForfMgr.getElencoComuni());
			int idConfigUtente;
			if (ActionContext.getContext().getSession().get("idConfigUtente") != null) {
				Integer idConfigUtenteSess = (Integer) ActionContext.getContext().getSession().get("idConfigUtente");
				idConfigUtente = idConfigUtenteSess.intValue();
			}

			//  all'init della pagina controllo se l'utente è operatore, se si, in base al codice fiscale italiano o francese,
			// recupera dal db  gli eventuali dati salvati in precedenza password
			Operatore operatore = new Operatore();
			RicercaOperatoreFilter filtro = new RicercaOperatoreFilter();
			String esito = theModel.getAppDataprofiloUtente();

			executeInit2(theModel);
			executeInit3(theModel);

			if (theModel.getAppDataprofiloUtente()
					.equalsIgnoreCase(Constants.EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_IT)) {
				operatore = cercaOperatoreInAnagrafica(theModel, filtro, theModel.getAppDatacurrentUser().getCodFisc(),
						Constants.NAZIONE_IT);
				theModel.setAppDatadatiOperatore(operatore);

				//if (ConvertUtil.checkIsNullOrEmpty(operatore.getIdPersonaOperatore())) {
				if (ConvertUtil.checkIsNullOrEmpty(operatore.getIdSoggettoGestore())) {
					theModel = (CpInserimentoOperatoreModel) ConvertUtil.caricaDatiOperatore(this.topForfMgr, theModel,
							operatore.getIdPersonaOperatore());
				}
				if (ConvertUtil.checkIsNullOrEmpty(operatore.getCodiceFiscaleOperatore())) {
					esito = theModel.getAppDataprofiloUtente() + "_operatorExists";
				} else {
					esito = theModel.getAppDataprofiloUtente() + "_operatorNoExists";
				}
			} else if (theModel.getAppDataprofiloUtente()
					.equalsIgnoreCase(Constants.EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_FR)) {
				operatore = cercaOperatoreInAnagrafica(theModel, filtro, theModel.getAppDatacurrentUser().getCodFisc(),
						Constants.NAZIONE_FR);
				theModel.setAppDatadatiOperatore(operatore);
				if (ConvertUtil.checkIsNullOrEmpty(operatore.getNRsiMsa())) {
					esito = theModel.getAppDataprofiloUtente() + "_operatorExists";
				} else {
					esito = theModel.getAppDataprofiloUtente() + "_operatorNoExists";
				}
			} else {
				esito = theModel.getAppDataprofiloUtente();
				// entro in questo if se sono gestore. se non sono in modifica allora l'oggetto operatore lo ripulisco
				if (theModel.getAppDatafromModifica() != null && theModel.getAppDatafromModifica()) {
					esito = theModel.getAppDataprofiloUtente() + "_fromElenco";
					theModel.setAppDatafromModifica(false);
				} else {
					theModel = resetDatiOperatoreCaricato(theModel);
				}
			}

			this.executeLocalInit(theModel);

			result.setResultCode(esito);

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

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblInserimentoCorsiProfessionaliFinanziatiRegione
	 */
	public static void resetClearStatus_widg_tblInserimentoCorsiProfessionaliFinanziatiRegione(java.util.Map session) {
		session.put("cpInserimentoOperatore_tblInserimentoCorsiProfessionaliFinanziatiRegione_clearStatus",
				Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblInserimentoAltriCorsi
	 */
	public static void resetClearStatus_widg_tblInserimentoAltriCorsi(java.util.Map session) {
		session.put("cpInserimentoOperatore_tblInserimentoAltriCorsi_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblQualifiche
	 */
	public static void resetClearStatus_widg_tblQualifiche(java.util.Map session) {
		session.put("cpInserimentoOperatore_tblQualifiche_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblInserimentoRiconoscimenti
	 */
	public static void resetClearStatus_widg_tblInserimentoRiconoscimenti(java.util.Map session) {
		session.put("cpInserimentoOperatore_tblInserimentoRiconoscimenti_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2078348690) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private SoggettoGestoreVisibleOrdinFilter soggettoGestoreVisibleOrdinFilter;

	@Autowired
	private VisibileOrdinFilter visibleOrdinFilter;

	@Autowired
	private AgenziaFormativaFilter agenziaFormativaFilter;

	@Autowired
	private TopForMgr topForfMgr;

	@Autowired
	private DbMgr dbMgr;

	@Autowired
	private MsgMgr msgMgr;

	@Autowired
	private UnitaFormativaFilter unitaFormativaFilter;

	@Autowired
	private CorsoProfessionaleFilter corsoProfessionaleFilter;

	@Autowired
	private ConfigProfiloFilter configProfiloFilter;

	@Autowired
	private TipoAllegatoFilter tipoAllegatoFilter;

	@Autowired
	private ValidationMgr validationMgr;

	@Autowired
	private PersonaFilter personaFilter;

	@Autowired
	private AttestazioneFrequenzaConProfitto attestazioneFrequenzaConProfitto;

	@Autowired
	private CorsoFormazioneFilter corsoFormazioneFilter;

	public CorsoFormazioneFilter getCorsoFormazioneFilter() {
		return corsoFormazioneFilter;
	}

	public void setCorsoFormazioneFilter(CorsoFormazioneFilter corsoFormazioneFilter) {
		this.corsoFormazioneFilter = corsoFormazioneFilter;
	}

	public VisibileOrdinFilter getVisibleOrdinFilter() {
		return visibleOrdinFilter;
	}

	public void setVisibleOrdinFilter(VisibileOrdinFilter visibleOrdinFilter) {
		this.visibleOrdinFilter = visibleOrdinFilter;
	}

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public TipoAllegatoFilter getTipoAllegatoFilter() {
		return tipoAllegatoFilter;
	}

	public void setTipoAllegatoFilter(TipoAllegatoFilter tipoAllegatoFilter) {
		this.tipoAllegatoFilter = tipoAllegatoFilter;
	}

	public CorsoProfessionaleFilter getCorsoProfessionaleFilter() {
		return corsoProfessionaleFilter;
	}

	public void setCorsoProfessionaleFilter(CorsoProfessionaleFilter corsoProfessionaleFilter) {
		this.corsoProfessionaleFilter = corsoProfessionaleFilter;
	}

	public SoggettoGestoreVisibleOrdinFilter getSoggettoGestoreVisibleOrdinFilter() {
		return soggettoGestoreVisibleOrdinFilter;
	}

	public void setSoggettoGestoreVisibleOrdinFilter(
			SoggettoGestoreVisibleOrdinFilter soggettoGestoreVisibleOrdinFilter) {
		this.soggettoGestoreVisibleOrdinFilter = soggettoGestoreVisibleOrdinFilter;
	}

	public AgenziaFormativaFilter getAgenziaFormativaFilter() {
		return agenziaFormativaFilter;
	}

	public void setAgenziaFormativaFilter(AgenziaFormativaFilter agenziaFormativaFilter) {
		this.agenziaFormativaFilter = agenziaFormativaFilter;
	}

	public TopForMgr getTopForfMgr() {
		return topForfMgr;
	}

	public void setTopForfMgr(TopForMgr topForfMgr) {
		this.topForfMgr = topForfMgr;
	}

	public UnitaFormativaFilter getUnitaFormativaFilter() {
		return unitaFormativaFilter;
	}

	public void setUnitaFormativaFilter(UnitaFormativaFilter unitaFormativaFilter) {
		this.unitaFormativaFilter = unitaFormativaFilter;
	}

	public void setConfigProfiloFilter(ConfigProfiloFilter configProfiloFilter) {
		this.configProfiloFilter = configProfiloFilter;
	}

	public PersonaFilter getPersonaFilter() {
		return personaFilter;
	}

	public void setPersonaFilter(PersonaFilter personaFilter) {
		this.personaFilter = personaFilter;
	}

	public AttestazioneFrequenzaConProfitto getAttestazioneFrequenzaConProfitto() {
		return attestazioneFrequenzaConProfitto;
	}

	public void setAttestazioneFrequenzaConProfitto(AttestazioneFrequenzaConProfitto attestazioneFrequenzaConProfitto) {
		this.attestazioneFrequenzaConProfitto = attestazioneFrequenzaConProfitto;
	}

	public MsgMgr getMsgMgr() {
		return msgMgr;
	}

	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}

	private SoggettoGestoreVisibleOrdinFilter getSoggettoGestoreVisibleOrdinFilter(CpInserimentoOperatoreModel theModel,
			String linguaDati) {
		if (ConvertUtil.checkIsNullOrEmpty(linguaDati)) {
			if (linguaDati.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				soggettoGestoreVisibleOrdinFilter.setFlagItaFr(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
			} else {
				soggettoGestoreVisibleOrdinFilter.setFlagItaFr(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
			}
		} else {
			soggettoGestoreVisibleOrdinFilter.setFlagItaFr(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
		}
		soggettoGestoreVisibleOrdinFilter
				.setFlagVisibile(Integer.parseInt(it.csi.taif.topforweb.business.dao.util.Constants.one));
		return soggettoGestoreVisibleOrdinFilter;
	}

	private void setSoggettoGestore(CpInserimentoOperatoreModel theModel) {
		if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor() != null
				&& theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore() != null
				&& theModel.getAppDatacurrentUser().getProfiloUtenteTopFor()
						.getIdSoggettoGestore() == it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_SUPERADMIN) {
			soggettoGestoreVisibleOrdinFilter.setFlagVisibile(0);
			soggettoGestoreVisibleOrdinFilter.setFlagItaFr(null);
		} else {
			soggettoGestoreVisibleOrdinFilter = getSoggettoGestoreVisibleOrdinFilter(theModel,
					theModel.getAppDatacurrentUser().getLingua());
			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatadatiOperatore().getIdSoggettoGestore())) {
				soggettoGestoreVisibleOrdinFilter
						.setIdSoggettoGestore(new Integer(theModel.getAppDatadatiOperatore().getIdSoggettoGestore()));
			}
			soggettoGestoreVisibleOrdinFilter.setFlagVisibile(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
		}

	}

	private SoggettoGestoreVisibleOrdinFilter getSoggettoGestoreVisibleOrdinFilter(
			CpInserimentoOperatoreModel theModel) {
		soggettoGestoreVisibleOrdinFilter
				.setIdSoggettoGestore(theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore());
		return soggettoGestoreVisibleOrdinFilter;
	}

	private Operatore cercaOperatoreInAnagrafica(CpInserimentoOperatoreModel theModel, RicercaOperatoreFilter filtro,
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

		// se codice fiscale diverso da null allora operatore è stato trovato
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getCodiceFiscale())
				|| ConvertUtil.checkIsNullOrEmpty(operatoreDto.getNRsiMsa())) {
			operatore = convertFromDtoToObject(operatoreDto, theModel);
			//operatore = dozerBeanMapper.map(dto,Operatore.class);
		} else {
			operatore = this.convertFromUser(theModel.getAppDatacurrentUser());
		}

		return operatore;

	}

	private Operatore convertFromUser(UserInfo user) {
		Operatore result = new Operatore();
		result.setCodiceFiscaleOperatore(user.getCodFisc());
		result.setCognomeOperatore(user.getCognome());
		result.setNomeOperatore(user.getNome());
		result.setIdPersonaOperatore(ConvertUtil.convertToString(user.getProfiloUtenteTopFor().getIdPersona()));
		return result;
	}

	private Operatore cercaPersonaInAnagrafica(CpInserimentoOperatoreModel theModel, RicercaOperatoreFilter filtro,
			String codFisNrsiMsa, String nazione) throws ManagerException {
		Operatore operatore = new Operatore();
		// se nazione è IT allora cerco per codice fiscale altrimenti per nRsiMsa
		if (nazione.equalsIgnoreCase(Constants.NAZIONE_IT)) {
			filtro.setCodiceFiscale(codFisNrsiMsa);
		} else {
			filtro.setnRsiMsa(codFisNrsiMsa);
		}

		// se codice fiscale diverso da null allora la persona è stato trovato
		TaifTPersonaByCodiceFiscalePersonaDto personaDto = this.topForfMgr.findDatiIdentificativiPersona(filtro);
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getCodiceFiscale())
				|| ConvertUtil.checkIsNullOrEmpty(personaDto.getNsiMsa())) {
			operatore = convertFromDtoToObject(personaDto, theModel);
		}
		return operatore;
	}

	private Operatore convertFromDtoToObject(TaifTPersonaDatiIdentificativiOperatoreDto operatoreDto,
			CpInserimentoOperatoreModel theModel) throws ManagerException {
		Operatore operatore = new Operatore();
		operatore.setIdPersonaOperatore(operatoreDto.getIdPersona() + "");

		operatore.setIdSoggettoGestore(operatoreDto.getIdSoggettoGestore() + "");

		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getCodiceFiscale())) {
			operatore.setCodiceFiscaleOperatore(operatoreDto.getCodiceFiscale());
		} else if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getNRsiMsa())) {
			operatore.setNRsiMsa(operatoreDto.getNRsiMsa());
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
			operatore.setComuneNascitaOperatore(operatoreDto.getIstatComuneNascita() + "");
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getComuneEsteroNascita())) {
			operatore.setComuneEsteroNascitaOperatore(operatoreDto.getComuneEsteroNascita());
		}
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getIstatComuneResidenza())) {
			theModel.setAppDataidComuneResidenzaSelezionato(operatoreDto.getIstatComuneResidenza());
			operatore.setComuneResidenzaOperatore(operatoreDto.getIstatComuneResidenza());
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

		if (operatoreDto.getPubblico().intValue() == it.csi.taif.topforweb.business.dao.util.Constants.zeroInt) {
			operatore.setStatoOperatore(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_NO);
		} else if (operatoreDto.getPubblico().intValue() == it.csi.taif.topforweb.business.dao.util.Constants.oneInt) {
			operatore.setStatoOperatore(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_SI);
		}

		theModel.setAppDataidStatoOperatoreSelezionato(operatore.getStatoOperatore());

		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getStatoSchedaIta())
				|| ConvertUtil.checkIsNullOrEmpty(operatoreDto.getStatoSchedaFra())) {
			String statoScheda = "";
			if (theModel.getAppDatacurrentUser().getLingua()
					.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
				statoScheda = operatoreDto.getStatoSchedaIta();
			} else {
				statoScheda = operatoreDto.getStatoSchedaFra();
			}
			operatore.setStatoScheda(statoScheda);
			ArrayList<CodeDescription> temp = this.topForfMgr.getElencoStatoScheda(soggettoGestoreVisibleOrdinFilter,
					theModel.getAppDatacurrentUser().getLingua());
			String idStatoSchedaSelezionato = ConvertUtil.getIdByDescription(statoScheda, temp);
			theModel.setAppDataidStatoSchedaSelezionato(idStatoSchedaSelezionato);
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

		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getUrlPrivacy())) {
			theModel.setAppDataurlPrivacy(operatoreDto.getUrlPrivacy());
		}

		return operatore;
	}

	private Operatore convertFromDtoToObject(TaifTPersonaByCodiceFiscalePersonaDto personaDto,
			CpInserimentoOperatoreModel theModel) throws ManagerException {
		Operatore operatore = new Operatore();
		operatore.setIdPersonaOperatore(personaDto.getIdPersona() + "");
		// Modifica 04/02/2020
		operatore.setIdSoggettoGestore(
				ConvertUtil.convertToString(this.getIdSoggettoFromCodiceIstat(personaDto.getIstatComuneResidenza())));

		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getCodiceFiscale())) {
			operatore.setCodiceFiscaleOperatore(personaDto.getCodiceFiscale());
		} else if (ConvertUtil.checkIsNullOrEmpty(personaDto.getNsiMsa())) {
			operatore.setNRsiMsa(personaDto.getNsiMsa());
		}
		operatore.setCognomeNomeOperatore(personaDto.getCognome() + " " + personaDto.getNome());
		operatore.setCognomeOperatore(personaDto.getCognome());
		operatore.setNomeOperatore(personaDto.getNome());
		if (ConvertUtil.checkDateIsNullOrZero(personaDto.getDataNascita())) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			operatore.setDataNascitaOperatore(df.format(personaDto.getDataNascita()));
		}
		if (ConvertUtil.checkIntIsNullOrZero(personaDto.getIdNazione())) {
			theModel.setAppDataidNazioneNascitaSelezionata(personaDto.getIdNazione() + "");
			operatore.setStatoNascitaOperatore(personaDto.getIdNazione() + "");
		}
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getIstatComuneNascita())) {
			theModel.setAppDataidComuneNascitaSelezionato(personaDto.getIstatComuneNascita() + "");
			operatore.setComuneNascitaOperatore(personaDto.getIstatComuneNascita() + "");
		}
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getComuneEsteroNascita())) {
			operatore.setComuneEsteroNascitaOperatore(personaDto.getComuneEsteroNascita() + "");
		}
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getIstatComuneResidenza())) {
			theModel.setAppDataidComuneResidenzaSelezionato(personaDto.getIstatComuneResidenza() + "");
			operatore.setComuneResidenzaOperatore(personaDto.getIstatComuneResidenza() + "");
		}
		/*
		 * if (ConvertUtil.checkIsNullOrEmpty(personaDto.geti)) {
		 * operatore.setComuneEsteroResidenzaOperatore(personaDto.
		 * getComuneEsteroResidenza()); }
		 */
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getIndirizzoResidenza())) {
			operatore.setIndirizzoResidenzaOperatore(personaDto.getIndirizzoResidenza());
		}
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getCivicoResidenza())) {
			operatore.setCivicoResidenzaOperatore(personaDto.getCivicoResidenza());
		}
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getCap())) {
			operatore.setCapResidenzaOperatore(personaDto.getCap());
		}
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getTelefono())) {
			operatore.setTelefonoOperatore(personaDto.getTelefono());
		}
		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getCellulare())) {
			operatore.setCellulareOperatore(personaDto.getCellulare());
		}

		if (ConvertUtil.checkIsNullOrEmpty(personaDto.getEMail())) {
			operatore.setEmailOperatore(personaDto.getEMail());
		}

		if (ConvertUtil.checkIntIsNullOrZero(personaDto.getIdTitoloStudio())) {
			operatore.setIdTitoloStudioIta(personaDto.getIdTitoloStudio() + "");
		} else {
			operatore.setIdTitoloStudioIta(it.csi.taif.topforweb.business.dao.util.Constants.zero);
		}
		if (ConvertUtil.checkIntIsNullOrZero(personaDto.getIdTitoloFra())) {
			operatore.setIdTitoloStudioFra(personaDto.getIdTitoloFra() + "");
		} else {
			operatore.setIdTitoloStudioFra(it.csi.taif.topforweb.business.dao.util.Constants.zero);
		}

		theModel.setAppDataidStatoOperatoreSelezionato(operatore.getStatoOperatore());

		RicercaOperatoreFilter filtroIdPersona = new RicercaOperatoreFilter();
		filtroIdPersona.setIdPersona(personaDto.getIdPersona() + "");

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

	private String salvaOperatore(CpInserimentoOperatoreModel theModel) throws Exception {

		String selected = (String) theModel.getSession().get(Constants.WIZARD_OPERATORE);
		log.debug("SELECTED MAIN " + selected);
		log.debug("SELECTED 1 " + theModel.getSession().get(Constants.WIZARD_SEL_1));
		log.debug("SELECTED 2 " + theModel.getSession().get(Constants.WIZARD_SEL_2));
		log.debug("SELECTED 3 " + theModel.getSession().get(Constants.WIZARD_SEL_3));
		log.debug("SELECTED 4 " + theModel.getSession().get(Constants.WIZARD_SEL_4));
		log.debug("SELECTED 5 " + theModel.getSession().get(Constants.WIZARD_SEL_5));

		WizardDomandaStatus d = WizardDomandaStatus.getByName(selected);
		//WizardDomandaStatus subD = null;
		String result = null;
		Integer idProfilo = 0;
		if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor() != null) {
			if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdProfilo() != null) {
				idProfilo = ConvertUtil
						.convertToInteger(theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdProfilo());
			}
		} else {
			idProfilo = 1;
		}
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = topForfMgr
				.getConfigProfiloUtenteByCodiceFiscale(getConfigProfiloUtente(theModel), idProfilo);

		ActionContext.getContext().getSession().put("profiloUtente", profiloUtente);
		setProfiloUtente(theModel, profiloUtente);

		//Integer idPersona = this.getIdPersona(theModel);
		//Integer idPersona = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdPersona();

		//		Integer idPersona = null;
		//		if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdPersona() != null
		//				&& theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdPersona() != 0) {
		//			idPersona = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdPersona();
		//		} else {
		//			idPersona = Integer.parseInt(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
		//		}

		//theModel = ConvertUtil.recuperaDatiOperatore(idPersona, theModel, topForfMgr);

		switch (d) {
			case WIZARD_VAL_1 :
				result = d.getName();
				log.debug("SALVA 1");
				theModel.getAppDatadatiOperatore()
						.setStatoNascitaOperatore(theModel.getAppDataidNazioneNascitaSelezionata());
				theModel.getAppDatadatiOperatore()
						.setComuneNascitaOperatore(theModel.getAppDataidComuneNascitaSelezionato());
				theModel.getAppDatadatiOperatore()
						.setComuneResidenzaOperatore(theModel.getAppDataidComuneResidenzaSelezionato());
				theModel.getAppDatadatiOperatore().setStatoScheda(theModel.getAppDataidStatoSchedaSelezionato());

				if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidStatoSchedaSelezionato())) {
					theModel.setAppDataidStatoSchedaSelezionato(
							it.csi.taif.topforweb.business.dao.util.Constants.ID_STATO_SCHEDA_BOZZA);
				}
				theModel.getAppDatadatiOperatore().setStatoScheda(theModel.getAppDataidStatoSchedaSelezionato());

				String cognomeUpperCase = "";
				if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatadatiOperatore().getCognomeOperatore())) {
					cognomeUpperCase = theModel.getAppDatadatiOperatore().getCognomeOperatore().toUpperCase();
				}

				theModel.getAppDatadatiOperatore().setCognomeOperatore(cognomeUpperCase);
				Integer idPersona = this.topForfMgr.salvaDatiAnagraficiOperatore(theModel.getAppDatadatiOperatore(),
						theModel.getAppDatadettaglioOperatoreSelezionato(),
						theModel.getAppDataidStatoSchedaSelezionato(), theModel.getAppDataidNazioneNascitaSelezionata(),
						theModel.getAppDataidComuneResidenzaSelezionato(),
						theModel.getAppDataidComuneNascitaSelezionato(),
						theModel.getAppDatacurrentUser().getProfiloUtenteTopFor(), theModel.getAppDatatracciato(),
						theModel.getAppDatafromModifica(), theModel.getAppDataprivacy(),
						theModel.getAppDataconsensoPubblicazione());
				ActionContext.getContext().getSession().put("idPersona", idPersona);
				theModel.getAppDatadatiOperatore().setIdPersonaOperatore(ConvertUtil.convertToString(idPersona));
				//theModel.setAppDatadatiOperatoreFromDB(ConvertUtil.recuperaOperatore(idPersona, theModel, topForfMgr));
				theModel = (CpInserimentoOperatoreModel) ConvertUtil.caricaDatiOperatore(this.topForfMgr, theModel,
						idPersona);

				this.executeInit2(theModel);
				break;
			case WIZARD_VAL_2 :
				result = d.getName();
				log.debug("SALVA 2");
				//				this.topForfMgr.salvaCorsiFinanzatiRegione(this.getIdPersona(theModel),
				//						theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione(),
				//						theModel.getAppDatacurrentUser().getProfiloUtenteTopFor(), theModel.getAppDatatracciato());
				this.executeInit3(theModel);
				break;
			case WIZARD_VAL_3 :
				result = d.getName();
				log.debug("SALVA 3");
				this.topForfMgr.salvaAltriCorsi();
				this.executeInit4(theModel);
				break;
			case WIZARD_VAL_4 :
				result = d.getName();
				log.debug("SALVA 4");
				this.topForfMgr.salvaQualifiche();
				this.executeInit5(theModel);
				break;
			case WIZARD_VAL_5 :
				result = d.getName();
				log.debug("SALVA 5");
				//this.topForfMgr.salva;
				break;
			default :
				WizardDomandaStatus.WIZARD_VAL_1.getName();
				log.debug("SALVA 1.1 DEFAULT");
				break;

		}

		// invio mail notifica OPERATORE IT

		if (theModel.getAppDatacurrentUser().getTipoAccesso()
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TIPO_ACCESSO_OPERATORE_IT)) {
			String testoPerMail = createTextForMail(theModel);

			// se il testo è diverso da quallo inziale allora ci sono state modifiche 
			// ed invio la mai di notifica
			if (!testoPerMail.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				this.topForfMgr.invioMailOperatore(theModel, testoPerMail, getIdPersona(theModel));
			}
		}

		// invio mail notifica GESTORE IT

		if (theModel.getAppDatacurrentUser().getTipoAccesso()
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_IT)) {

			String idStatoSchedaDB = "";
			// se il gestore ha modificato lo stato della scheda invio la mail di notifica
			if (theModel.getAppDatadatiOperatoreFromDB() == null
					|| !ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatadatiOperatoreFromDB().getStatoScheda())) {
				idStatoSchedaDB = it.csi.taif.topforweb.business.dao.util.Constants.ID_STATO_SCHEDA_BOZZA;
			} else {
				idStatoSchedaDB = ConvertUtil.getIdByDescription(
						theModel.getAppDatadatiOperatoreFromDB().getStatoScheda(),
						theModel.getAppDataelencoStatoSchedaRicerca());
			}
			if (!idStatoSchedaDB.equalsIgnoreCase(theModel.getAppDataidStatoSchedaSelezionato())) {
				if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatamotivazioneRifiutoValidazione())) {
					theModel.setAppDatamotivazioneRifiutoValidazione("");
				}
				this.topForfMgr.invioMailGestore(theModel, getIdPersona(theModel));
			}
		}

		//theModel = ConvertUtil.recuperaDatiOperatore(new Integer(idPersona), theModel, topForfMgr);

		return result;
	}

	private void setProfiloUtente(CpInserimentoOperatoreModel theModel,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente) {

		ProfiloUtenteTopFor put = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor();
		if (put == null) {
			put = new ProfiloUtenteTopFor();
		}
		put.setIdProfilo(ConvertUtil.convertToString(profiloUtente.getIdProfiloUtente()));
		put.setDsProfilo(profiloUtente.getProfiloUtente());
		put.setIdSoggettoGestore(profiloUtente.getIdSoggettoGestore());
		theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(put);

	}

	private void executeInit1(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel)
			throws ManagerException, CloneNotSupportedException {

		int idPersona = getIdPersona(theModel);
		String dataTracciato = theModel.getAppDatatracciato();
		if (dataTracciato == null) {
			Integer idSoggettoGestore = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor()
					.getIdSoggettoGestore();
			if (idSoggettoGestore != null) {
				theModel.setAppDatatracciato(
						GenericUtil.getTracciatoFromSoggettoGestore(ConvertUtil.convertToString(idSoggettoGestore)));
			} else {
				theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
			}
		}
		theModel.setAppDataelencoComuniRicercaOperatoreGestore(topForfMgr.getElencoComuni());
		theModel.setAppDataelencoNazioni(topForfMgr
				.getElencoNazioniPerLingua(it.csi.taif.topforweb.business.dao.util.Constants.oneInt, dataTracciato));
		theModel.setAppDataelencoStatoSchedaRicerca(topForfMgr.getElencoStatoSchedaPerLingua(
				it.csi.taif.topforweb.business.dao.util.Constants.oneInt, dataTracciato));

		theModel.setAppDataelencoStatoOperatoreRicerca(ConvertUtil.createElencoStatoOperatore(dataTracciato));

		if (idPersona != 0
				&& (!theModel.getAppDatacurrentUser().getTipoAccesso()
						.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_IT))
				&& (!theModel.getAppDatacurrentUser().getTipoAccesso()
						.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_FR))) {
			Operatore operatoreCarica = topForfMgr.getOperatoreFromPersona(idPersona, dataTracciato);
			theModel.setAppDatadatiOperatore(operatoreCarica);
			theModel.setAppDataconsensoPubblicazione(true);
			theModel.setAppDataprivacy(true);
		}

		if (theModel.getAppDataisNuovoInserimentoOperatore() != null
				&& theModel.getAppDataisNuovoInserimentoOperatore()) {
			resetDatiOperatoreCaricato(theModel);

			theModel.setAppDataisNuovoInserimentoOperatore(false);
		}
	}

	private int getIdPersona(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel)
			throws ManagerException {
		//		String codiceFiscale;
		int idPersona = 0;
		//		if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdPersona() != null) {
		//			idPersona = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdPersona();
		//		} else {
		//			codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
		//			TaifTPersonaByFilterDto personaCercata = topForfMgr.findPersonaPerCodiceFiscale(getPersonaFilter(theModel));
		//			if (personaCercata != null) {
		//				idPersona = personaCercata.getIdPersona();
		//			}
		//		}
		if (theModel.getAppDatadatiOperatore() != null
				&& theModel.getAppDatadatiOperatore().getIdPersonaOperatore() != null) {

			idPersona = ConvertUtil.convertToInteger(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
		}
		//		else {
		//			theModel.setAppDataisNuovoInserimentoOperatore(true);
		//		}
		return idPersona;
	}

	private ArrayList<CodeDescription> createElencoStatoOperatore(String linguaDati) {
		ArrayList<CodeDescription> list = new ArrayList<CodeDescription>();
		CodeDescription obj1 = new CodeDescription();
		CodeDescription obj2 = new CodeDescription();
		obj1.setCode(it.csi.taif.topforweb.business.dao.util.Constants.zero);
		obj2.setCode(it.csi.taif.topforweb.business.dao.util.Constants.one);
		if (linguaDati.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
			obj1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_PUBBLICO_FRA);
			obj2.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_NON_PUBBLICO_FRA);
		} else {
			obj1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_PUBBLICO_ITA);
			obj2.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_NON_PUBBLICO_ITA);
		}
		list.add(obj1);
		list.add(obj2);
		return list;
	}

	private void executeInit2(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel)
			throws ManagerException {

		String linguaDati = theModel.getAppDatacurrentUser().getLingua();
		ArrayList<CodeDescription> listBlank = new ArrayList<CodeDescription>();
		ArrayList<CodeDescription> listEsitoCorso = new ArrayList<CodeDescription>();
		CodeDescription itemEsito1 = new CodeDescription();
		CodeDescription itemEsito2 = new CodeDescription();

		int idPersona = getIdPersona(theModel);
		//theModel.getAppDatadatiOperatore().setElencoCorsiProfessionaliFinanziatiRegione(this.topForfMgr.getElencoCorsiPerPersona(idPersona));
		theModel.setAppDataelencoCorsiProfessionaliFinanziatiDaRegione(
				this.topForfMgr.getElencoCorsiPerPersona(idPersona));

		itemEsito1.setCode(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA);
		itemEsito2.setCode(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO);
		if (theModel.getAppDatacurrentUser().getLingua()
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
			itemEsito1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_DESC_FRA);
			itemEsito2.setDescription(
					it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO_DESC_FRA);
		} else {
			itemEsito1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_DESC_ITA);
			itemEsito2.setDescription(
					it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO_DESC_ITA);
		}
		listEsitoCorso.add(itemEsito1);
		listEsitoCorso.add(itemEsito2);

		soggettoGestoreVisibleOrdinFilter = getSoggettoGestoreVisibleOrdinFilter(theModel, linguaDati);

		theModel.setAppDataelencoAgenziaFormativaRicercaOperatore(
				this.topForfMgr.getElencoAgenziaFormativa(soggettoGestoreVisibleOrdinFilter));

		theModel.setAppDataelencoUnitaFormativaCorsiFinanziati(listBlank);

		theModel.setAppDataelencoTitoloCorso(listBlank);

		theModel.setAppDataelencoSedeCorso(listBlank);

		theModel.setAppDataelencoPeriodoSvolgimentoCorso(listBlank);

		theModel.setAppDataelencoEsitoCorso(listEsitoCorso);

		ActionContext.getContext().getSession().put("idOperatore", idPersona);
		ActionContext.getContext().getSession().put("dataTracciato", theModel.getAppDatatracciato());

	}

	private void executeInit3(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel)
			throws ManagerException {
		String linguaDati = theModel.getAppDatacurrentUser().getLingua();
		visibleOrdinFilter.setFlagVisibile(1);
		theModel.setAppDataelencoAttestatoConScadenzaInserimento(topForfMgr.getElencoSINO());
		theModel.setAppDataelencoAltriCorsiDenominazioni(
				this.topForfMgr.getElencoAltriCorsiDenominazioni(visibleOrdinFilter, linguaDati));
		ArrayList<CodeDescription> listEsitoCorso = new ArrayList<CodeDescription>();

		int idPersona = getIdPersona(theModel);
		theModel.setAppDataelencoAltriCorsi(this.topForfMgr.getElencoAltriCorsiPerPersona(idPersona));

		CodeDescription itemEsito1 = new CodeDescription();
		CodeDescription itemEsito2 = new CodeDescription();
		itemEsito1.setCode(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA);
		itemEsito2.setCode(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO);
		if (theModel.getAppDatacurrentUser().getLingua()
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
			itemEsito1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_DESC_FRA);
			itemEsito2.setDescription(
					it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO_DESC_FRA);
		} else {
			itemEsito1.setDescription(it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_DESC_ITA);
			itemEsito2.setDescription(
					it.csi.taif.topforweb.business.dao.util.Constants.ESITO_FREQUENZA_CON_PROFITTO_DESC_ITA);
		}
		listEsitoCorso.add(itemEsito1);
		listEsitoCorso.add(itemEsito2);
		theModel.setAppDataelencoEsitoCorso(listEsitoCorso);

	}

	private void executeInit4(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel)
			throws ManagerException {
		String linguaDati = theModel.getAppDatacurrentUser().getLingua();
		soggettoGestoreVisibleOrdinFilter = getSoggettoGestoreVisibleOrdinFilter(theModel, linguaDati);
		theModel.setAppDataelencoQualificheDenominazioni(
				this.topForfMgr.getElencoQualifiche(soggettoGestoreVisibleOrdinFilter, linguaDati));

		//		ArrayList<Qualifica> qualificaPerPersona = topForfMgr
		//				.findQualificaPerPersona(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
		ArrayList<Qualifica> qualificaPerPersona = topForfMgr.findQualificaPerPersona(this.getIdPersona(theModel));
		theModel.setAppDataelencoQualifiche(qualificaPerPersona);
	}

	private void executeInit5(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel)
			throws ManagerException {

		ArrayList<CodeDescription> elencoUnitaFormativa = new ArrayList<CodeDescription>();
		theModel.setAppDataelencoUnitaFormativaRiconoscimento(elencoUnitaFormativa);

		//		ArrayList<Riconoscimento> riconoscimentoInseritoList = topForfMgr
		//				.findRiconoscimentoPerPersona(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());

		ArrayList<Riconoscimento> riconoscimentoInseritoList = topForfMgr
				.findRiconoscimentoPerPersona(this.getIdPersona(theModel));
		theModel.setAppDataelencoRiconoscimento(riconoscimentoInseritoList);
	}

	private ConfigProfiloFilter getConfigProfiloUtente(CpInserimentoOperatoreModel theModel) {

		configProfiloFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
		configProfiloFilter.setFlagAttivo(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
		configProfiloFilter.setIdProcedura(it.csi.taif.topforweb.business.dao.util.Constants.twoInt);
		configProfiloFilter.setDataTracciato(theModel.getAppDatatracciato());
		return configProfiloFilter;
	}

	private void cleanAltroCorso(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) {
		CorsoProfessionale obj = new CorsoProfessionale();
		theModel.setAppDataaltroCorsoSelezionatoInserimento(obj);
	}

	private void cleanCorsoFinanziatoRegione(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) {
		ArrayList<CodeDescription> listBlank = new ArrayList<CodeDescription>();
		CorsoProfessionale obj = new CorsoProfessionale();

		theModel.setAppDataidAgenziaFormativaSelezionata("");
		theModel.setAppDataelencoUnitaFormativaCorsiFinanziati(listBlank);
		theModel.setAppDataidUnitaFormativaSelezionata("");
		theModel.setAppDataelencoTitoloCorso(listBlank);
		theModel.setAppDataidTitoloCorsoSelezionato("");
		theModel.setAppDatacorsoSelezionatoInserimento(obj);
		theModel.setAppDataidEsitoCorsoSelezionato("");
		//theModel.getAppDataelencoAgenziaFormativaRicercaOperatore();
		theModel.setAppDataelencoSedeCorso(listBlank);
		theModel.setAppDataelencoPeriodoSvolgimentoCorso(listBlank);
		theModel.setAppDataelencoQualificheDenominazioni(listBlank);
	}

	private void cleanQualificaPersona(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) {
		ArrayList<CodeDescription> listBlank = new ArrayList<CodeDescription>();
		Qualifica qualifica = new Qualifica();
		theModel.setAppDataqualificaSelezionataInserimento(qualifica);
		theModel.getAppDataelencoAgenziaFormativaRicercaOperatore();
		theModel.setAppDataidAgenziaFormativaSelezionata("");
		theModel.getAppDataelencoQualifiche();
		theModel.setAppDataidQualificaSelezionato("");

	}

	private void cleanSchedaRiconoscimento(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) {
		ArrayList<CodeDescription> listBlank = new ArrayList<CodeDescription>();
		Riconoscimento riconoscimento = new Riconoscimento();
		theModel.setAppDatariconoscimentoSelezionatoInserimento(riconoscimento);
		theModel.getAppDataelencoAgenziaFormativaRicercaOperatore();
		theModel.setAppDataidAgenziaFormativaSelezionata("");
		theModel.setAppDataidUnitaFormativaSelezionata("");

	}

	private CorsoProfessionale loadCorsoFinanziatoRegione(
			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel, String idRiga) {
		CorsoProfessionale corsoSelezionato = new CorsoProfessionale();
		for (CorsoProfessionale c : theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione()) {
			if (c.getIdCorsoProfessionale().equalsIgnoreCase(idRiga)) {
				corsoSelezionato.setAgenziaFormativa(c.getAgenziaFormativa());
				corsoSelezionato.setAttestatoConScadenza(c.getAttestatoConScadenza());
				corsoSelezionato.setDataFineCorso(c.getDataFineCorso());
				corsoSelezionato.setDataInizioCorso(c.getDataInizioCorso());
				corsoSelezionato.setDescrizioneAltroCorso(c.getDataFineCorso());
				break;
			}
		}

		return corsoSelezionato;

	}

	private Object copyObject(Object objSource, Object objDest) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(objSource);
			oos.flush();
			oos.close();
			bos.close();
			byte[] byteData = bos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(byteData);
			try {
				objDest = new ObjectInputStream(bais).readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objDest;

	}

	private void switchTabAndInit(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel)
			throws Exception {
		log.debug("[CPBECpDomanda::switchTabAndInit] BEGIN");
		log.debug("[TAB] theModel.getSelectedTabValue() *" + theModel.getSelectedTabValue() + "*");
		setSoggettoGestore(theModel);
		WizardDomandaStatus d = WizardDomandaStatus.getByName(theModel.getSelectedTabValue());
		switch (d) {
			case WIZARD_VAL_1 :
				this.validationMgr.checkOperatoreSalvato(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
				this.executeInit1(theModel);
				break;
			case WIZARD_VAL_2 :
				this.validationMgr.checkOperatoreSalvato(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
				this.executeInit2(theModel);
				break;
			case WIZARD_VAL_3 :
				this.validationMgr.checkOperatoreSalvato(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
				//this.validationMgr.checkElencoCorsiFinanziatiRegione(theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione());
				this.executeInit3(theModel);
				break;
			case WIZARD_VAL_4 :
				this.validationMgr.checkOperatoreSalvato(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
				//this.validationMgr.checkElencoCorsiFinanziatiRegione(theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione());
				this.executeInit4(theModel);
				break;
			case WIZARD_VAL_5 :
				this.validationMgr.checkOperatoreSalvato(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
				//this.validationMgr.checkElencoCorsiFinanziatiRegione(theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione());
				this.executeInit5(theModel);
				break;

			default :
				this.executeInit1(theModel);
		}
		log.debug("[CPBECpDomanda::switchTabAndInit] END");
	}

	private void executeLocalInit(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel)
			throws Exception {
		log.debug("     +++++++++++++ theModel.getSession().get(Constants.WIZARD_DOMANDA) +"
				+ theModel.getSession().get(Constants.WIZARD_OPERATORE) + "+");
		log.debug("     +++++++++++++ theModel.getSelectedTabKey() +" + theModel.getSelectedTabKey() + "+");
		log.debug("     +++++++++++++ theModel.getSelectedTabValue +" + theModel.getSelectedTabValue() + "+");

		String selected = (String) theModel.getSession().get(Constants.WIZARD_OPERATORE);

		WizardDomandaStatus d = WizardDomandaStatus.getByName(selected);

		switch (d) {
			case WIZARD_VAL_1 :
				this.executeInit1(theModel);
				break;
			case WIZARD_VAL_2 :
				this.executeInit2(theModel);
				break;
			case WIZARD_VAL_3 :
				this.executeInit3(theModel);
				break;
			case WIZARD_VAL_4 :
				this.executeInit4(theModel);
				break;
			case WIZARD_VAL_5 :
				this.executeInit5(theModel);
				break;
			default :
				this.executeInit1(theModel);
		}

		String tipoAccesso = (String) theModel.getAppDatacurrentUser().getTipoAccesso();
		Integer idProfilo = Integer.parseInt(theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdProfilo());
		//idProfilo = 4;  // Only per TEST MM
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = topForfMgr
				.getConfigProfiloUtenteByCodiceFiscale(getConfigProfiloUtente(theModel), idProfilo);
		ActionContext.getContext().getSession().put("profiloUtente", profiloUtente);
		this.setProfiloUtente(theModel, profiloUtente);

	}

	private String getCurrentElement(CpInserimentoOperatoreModel theModel) {
		String selected = (String) theModel.getSession().get(Constants.WIZARD_OPERATORE);
		WizardDomandaStatus d = WizardDomandaStatus.getByName(selected);
		String result = null;
		switch (d) {
			case WIZARD_VAL_1 :
			case WIZARD_VAL_2 :
			case WIZARD_VAL_3 :
			case WIZARD_VAL_4 :
			case WIZARD_VAL_5 :
				result = d.getName();
				break;
			default :
				log.debug("SALVA 1 DEFAULT DEFAULT");
				result = d.WIZARD_VAL_1.getName();
				break;
		}
		return result;
	}

	private String getNextElement(CpInserimentoOperatoreModel theModel) {
		return WizardDomandaStatus.getNextElement(getCurrentElement(theModel));
	}

	private String getPreviousElement(CpInserimentoOperatoreModel theModel) {
		return WizardDomandaStatus.getPreviousElement(getCurrentElement(theModel));
	}

	private String getNextElement(String current) {
		return WizardDomandaStatus.getNextElement(current);
	}

	private String getPreviousElement(String current) {
		return WizardDomandaStatus.getPreviousElement(current);
	}

	public PersonaFilter getPersonaFilter(CpInserimentoOperatoreModel theModel) {
		if (theModel.getAppDatatracciato().equals(it.csi.taif.topforweb.business.dao.util.Constants.iLang)) {
			personaFilter.setIdNazione(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
		} else {
			personaFilter.setIdNazione(it.csi.taif.topforweb.business.dao.util.Constants.twoInt);
		}
		personaFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
		return personaFilter;
	}

	public CpInserimentoOperatoreModel resetDatiOperatoreCaricato(CpInserimentoOperatoreModel theModel) {
		Operatore op = new Operatore();
		ArrayList<CorsoProfessionale> listCorsoBlank = new ArrayList<CorsoProfessionale>();
		ArrayList<CorsoProfessionale> listCorsoBlank2 = new ArrayList<CorsoProfessionale>();
		ArrayList<Qualifica> listQualificaBlank = new ArrayList<Qualifica>();
		ArrayList<Riconoscimento> listRiconoscimentoBlank = new ArrayList<Riconoscimento>();
		cleanCorsoFinanziatoRegione(theModel);
		cleanAltroCorso(theModel);
		cleanQualificaPersona(theModel);
		cleanSchedaRiconoscimento(theModel);
		CorsoProfessionale c = new CorsoProfessionale();
		Qualifica q = new Qualifica();
		Riconoscimento r = new Riconoscimento();
		theModel.setAppDatadatiOperatore(op);
		theModel.setAppDataidNazioneNascitaSelezionata("");
		theModel.setAppDataidComuneNascitaSelezionato("");
		theModel.setAppDataidComuneResidenzaSelezionato("");
		theModel.setAppDataidStatoSchedaSelezionato("");
		theModel.setAppDataidAgenziaFormativaSelezionata("");
		theModel.setAppDataidUnitaFormativaSelezionata("");
		theModel.setAppDataidTitoloCorsoSelezionato("");
		theModel.setAppDataidEsitoCorsoSelezionato("");
		theModel.setAppDataelencoCorsiProfessionaliFinanziatiDaRegione(listCorsoBlank);
		theModel.setAppDataaltroCorsoSelezionatoInserimento(c);
		theModel.setAppDataelencoAltriCorsi(listCorsoBlank2);
		theModel.setAppDataqualificaSelezionataInserimento(q);
		theModel.setAppDataelencoQualifiche(listQualificaBlank);
		theModel.setAppDatariconoscimentoSelezionatoInserimento(r);
		theModel.setAppDataelencoRiconoscimento(listRiconoscimentoBlank);
		theModel.setAppDatamotivazioneRifiutoValidazione("");
		theModel.setAppDataarrivoDaModifica(false);
		theModel.setAppDataprivacy(false);
		theModel.setAppDataconsensoPubblicazione(false);

		return theModel;
	}

	private String createTextForMail(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) {
		Operatore opFromDB = theModel.getAppDatadatiOperatoreFromDB();
		Operatore opFromApp = theModel.getAppDatadatiOperatore();
		String testo = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING;

		testo = testo + createDatiAnagraficiTextForMail(theModel, opFromDB, opFromApp, testo);
		testo = testo + createCorsiFinanziatiDaRegioneTextForMail(theModel, opFromDB, opFromApp, testo);
		testo = testo + createAltriCorsieTextForMail(theModel, opFromDB, opFromApp, testo);
		testo = testo + createQualificheTextForMail(theModel, opFromDB, opFromApp, testo);
		testo = testo + createRiconoscimentiTextForMail(theModel, opFromDB, opFromApp, testo);

		return testo;
	}

	private String createDatiAnagraficiTextForMail(
			it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel, Operatore opFromDB,
			Operatore opFromApp, String testoDatiAnagrafici) {
		testoDatiAnagrafici = isModifiedField(opFromDB.getCodiceFiscaleOperatore(),
				opFromApp.getCodiceFiscaleOperatore())
						? (testoDatiAnagrafici + "- codice fiscale \t\n")
						: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getNRsiMsa(), opFromApp.getNRsiMsa())
				? (testoDatiAnagrafici + "- Rsi Msa \t\n")
				: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getCognomeOperatore(), opFromApp.getCognomeOperatore())
				? (testoDatiAnagrafici + "- cognome operatore \t\n")
				: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getNomeOperatore(), opFromApp.getNomeOperatore())
				? (testoDatiAnagrafici + "- nome operatore \t\n")
				: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getDataNascitaOperatore(), opFromApp.getDataNascitaOperatore())
				? (testoDatiAnagrafici + "- data di nascita operatore \t\n")
				: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getStatoNascitaOperatore(),
				theModel.getAppDataidNazioneNascitaSelezionata())
						? (testoDatiAnagrafici + "- stato nascita operatore \t\n")
						: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getComuneNascitaOperatore(),
				theModel.getAppDataidComuneNascitaSelezionato())
						? (testoDatiAnagrafici + "- comune nascita operatore \t\n")
						: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getComuneEsteroNascitaOperatore(),
				opFromApp.getComuneEsteroNascitaOperatore())
						? (testoDatiAnagrafici + "- luogo estero operatore \t\n")
						: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getComuneResidenzaOperatore(),
				theModel.getAppDataidComuneResidenzaSelezionato())
						? (testoDatiAnagrafici + "- comune residenza operatore \t\n")
						: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getComuneEsteroResidenzaOperatore(),
				opFromApp.getComuneEsteroResidenzaOperatore())
						? (testoDatiAnagrafici + "- comune estero residenza operatore \t\n")
						: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getIndirizzoResidenzaOperatore(),
				opFromApp.getIndirizzoResidenzaOperatore())
						? (testoDatiAnagrafici + "- indirizzo residenza operatore \t\n")
						: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getCivicoResidenzaOperatore(),
				opFromApp.getCivicoResidenzaOperatore())
						? (testoDatiAnagrafici + "- civico residenza operatore \t\n")
						: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getCapResidenzaOperatore(), opFromApp.getCapResidenzaOperatore())
				? (testoDatiAnagrafici + "- cap residenza operatore \t\n")
				: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getTelefonoOperatore(), opFromApp.getTelefonoOperatore())
				? (testoDatiAnagrafici + "- telefono operatore \t\n")
				: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getCellulareOperatore(), opFromApp.getCellulareOperatore())
				? (testoDatiAnagrafici + "- cellulare operatore \t\n")
				: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getEmailOperatore(), opFromApp.getEmailOperatore())
				? (testoDatiAnagrafici + "- email operatore \t\n")
				: testoDatiAnagrafici;
		testoDatiAnagrafici = isModifiedField(opFromDB.getAssociatoAziendaIscrittaAlboForestaleENumeroAlbo(),
				opFromApp.getAssociatoAziendaIscrittaAlboForestaleENumeroAlbo())
						? (testoDatiAnagrafici + "- opertore associato ad azienda iscritto all'albo forestale \t\n")
						: testoDatiAnagrafici;
		if (opFromApp.getStatoOperatore()
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.STATO_OPERATORE_RB_SI)) {
			opFromApp.setStatoOperatore("1");
		} else {
			opFromApp.setStatoOperatore("0");
		}
		testoDatiAnagrafici = isModifiedField(opFromDB.getStatoOperatore(), opFromApp.getStatoOperatore())
				? (testoDatiAnagrafici + "- pubblicabilità \t\n")
				: testoDatiAnagrafici;

		testoDatiAnagrafici = isModifiedField(opFromDB.getStatoScheda(), theModel.getAppDataidStatoSchedaSelezionato())
				? (testoDatiAnagrafici + "- stato scheda \t\n")
				: testoDatiAnagrafici;

		if (!testoDatiAnagrafici
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
			testoDatiAnagrafici = "\n" + it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_5
					+ it.csi.taif.topforweb.business.dao.util.Constants.LABEL_SEZIONE_1
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_6
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + testoDatiAnagrafici;
		}

		return testoDatiAnagrafici;
	}

	private String createCorsiFinanziatiDaRegioneTextForMail(CpInserimentoOperatoreModel theModel, Operatore opFromDB,
			Operatore opFromApp, String testo) {

		String textMailCorsiFinanziati = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING;

		ArrayList<CorsoProfessionale> app = theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione();
		ArrayList<CorsoProfessionale> db = opFromDB.getElencoCorsiProfessionaliFinanziatiRegione();

		for (CorsoProfessionale corsoApp : app) {
			Boolean trovato = false;
			String textTemp = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_BLANK;
			for (CorsoProfessionale corsoDb : db) {
				if (corsoApp.getIdCorsoProfessionale().equalsIgnoreCase(corsoDb.getIdCorsoProfessionale())) {
					trovato = true;
					/*textTemp = isModifiedField(corsoApp.getAgenziaFormativa(), corsoDb.getAgenziaFormativa())
					? (textTemp + "agenzia formativa,")
					: textTemp;
					textTemp = isModifiedField(corsoApp.getUnitaFormativa(), corsoDb.getUnitaFormativa())
					? (textTemp + " unità formativa,")
					: textTemp;	
					textTemp = isModifiedField(corsoApp.getTitoloCorso(), corsoDb.getTitoloCorso())
					? (textTemp + " titolo corso,")
					: textTemp;
					textTemp = isModifiedField(corsoApp.getNumeroOre(), corsoDb.getNumeroOre())
					? (textTemp + " numero ore corso,")
					: textTemp;
					textTemp = isModifiedField(corsoApp.getSedeCorso(), corsoDb.getSedeCorso())
					? (textTemp + " sede corso,")
					: textTemp;*/
					textTemp = isModifiedField(corsoApp.getDsAttestatoConScadenza(),
							corsoDb.getDsAttestatoConScadenza()) ? (textTemp + " scadenza attestato corso,") : textTemp;
					textTemp = isModifiedField(corsoApp.getEsitoCorso(), corsoDb.getEsitoCorso())
							? (textTemp + " esito corso,")
							: textTemp;
					textTemp = isModifiedField(corsoApp.getIconaAllegato(), corsoDb.getIconaAllegato())
							? (textTemp + " file allegato corso,")
							: textTemp;
					break;
				}
			}
			textTemp = textTemp.substring(0, textTemp.length() - 1);
			if (trovato && !textTemp.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				textMailCorsiFinanziati = textMailCorsiFinanziati + "MODIFICA del corso " + corsoApp.getTitoloCorso()
						+ " (" + corsoApp.getPeriodoSvolgimento() + ")" + " nei campi: " + textTemp + ";\n";
			} else if (trovato == false) {
				textMailCorsiFinanziati = textMailCorsiFinanziati + "AGGIUNTA del corso " + corsoApp.getTitoloCorso()
						+ " (" + corsoApp.getPeriodoSvolgimento() + ");\n";
			} else if (!textTemp.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				textMailCorsiFinanziati = textMailCorsiFinanziati + textTemp + "\n";
			}
		}

		for (CorsoProfessionale obj : db) {
			Boolean trovato = false;
			for (CorsoProfessionale objApp : app) {
				if (obj.getIdCorsoProfessionale().equalsIgnoreCase(objApp.getIdCorsoProfessionale())) {
					trovato = true;
					break;
				}
			}
			if (!trovato) {
				textMailCorsiFinanziati = textMailCorsiFinanziati + "ELIMINAZIONE del corso " + obj.getTitoloCorso()
						+ " (" + obj.getPeriodoSvolgimento() + ");\n";
			}

		}

		if (!textMailCorsiFinanziati
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
			textMailCorsiFinanziati = "\n" + it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_5
					+ it.csi.taif.topforweb.business.dao.util.Constants.LABEL_SEZIONE_2
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_6
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + textMailCorsiFinanziati;
		}

		return textMailCorsiFinanziati;
	}

	private String createAltriCorsieTextForMail(CpInserimentoOperatoreModel theModel, Operatore opFromDB,
			Operatore opFromApp, String testo) {

		String textMailAltriCorsi = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING;

		ArrayList<CorsoProfessionale> app = theModel.getAppDataelencoAltriCorsi();
		ArrayList<CorsoProfessionale> db = opFromDB.getElencoAltriCorsi();

		for (CorsoProfessionale corsoApp : app) {
			Boolean trovato = false;
			String textTemp = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_BLANK;
			for (CorsoProfessionale corsoDb : db) {
				if (corsoApp.getIdCorsoProfessionale().equalsIgnoreCase(corsoDb.getIdCorsoProfessionale())) {
					trovato = true;
					/*textTemp = isModifiedField(corsoApp.getAgenziaFormativa(), corsoDb.getAgenziaFormativa())
					? (textTemp + "agenzia formativa,")
					: textTemp;
					textTemp = isModifiedField(corsoApp.getUnitaFormativa(), corsoDb.getUnitaFormativa())
					? (textTemp + " unità formativa,")
					: textTemp;	
					textTemp = isModifiedField(corsoApp.getTitoloCorso(), corsoDb.getTitoloCorso())
					? (textTemp + " titolo corso,")
					: textTemp;
					textTemp = isModifiedField(corsoApp.getNumeroOre(), corsoDb.getNumeroOre())
					? (textTemp + " numero ore corso,")
					: textTemp;
					textTemp = isModifiedField(corsoApp.getSedeCorso(), corsoDb.getSedeCorso())
					? (textTemp + " sede corso,")
					: textTemp;*/
					textTemp = isModifiedField(corsoApp.getDescrizioneAltroCorso(), corsoDb.getDescrizioneAltroCorso())
							? (textTemp + " descrizione corso,")
							: textTemp;
					textTemp = isModifiedField(corsoApp.getDsAttestatoConScadenza(),
							corsoDb.getDsAttestatoConScadenza()) ? (textTemp + " scadenza attestato corso,") : textTemp;
					textTemp = isModifiedField(corsoApp.getEsitoCorso(), corsoDb.getEsitoCorso())
							? (textTemp + " esito corso,")
							: textTemp;
					textTemp = isModifiedField(corsoApp.getIconaAllegato(), corsoDb.getIconaAllegato())
							? (textTemp + " file allegato corso,")
							: textTemp;
					break;
				}
			}
			textTemp = textTemp.substring(0, textTemp.length() - 1);
			if (trovato && !textTemp.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				textMailAltriCorsi = textMailAltriCorsi + "MODIFICA del corso " + corsoApp.getTitoloCorso() + " ("
						+ corsoApp.getPeriodoSvolgimento() + ")" + " nei campi: " + textTemp + ";\n";
			} else if (trovato == false) {
				textMailAltriCorsi = textMailAltriCorsi + "AGGIUNTA del corso " + corsoApp.getTitoloCorso() + ";\n";
			} else if (!textTemp.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				textMailAltriCorsi = textMailAltriCorsi + textTemp + "\n";
			}
		}
		if (!textMailAltriCorsi
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
			textMailAltriCorsi = "\n" + it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_5
					+ it.csi.taif.topforweb.business.dao.util.Constants.LABEL_SEZIONE_3
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_6
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + textMailAltriCorsi;
		}

		return textMailAltriCorsi;
	}

	private String createQualificheTextForMail(CpInserimentoOperatoreModel theModel, Operatore opFromDB,
			Operatore opFromApp, String testo) {

		String textMailQualifiche = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING;

		ArrayList<Qualifica> app = theModel.getAppDataelencoQualifiche();
		ArrayList<Qualifica> db = opFromDB.getElencoQualifiche();

		for (Qualifica corsoApp : app) {
			Boolean trovato = false;
			String textTemp = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_BLANK;
			for (Qualifica corsoDb : db) {
				if (corsoApp.getTipoQualifica().equalsIgnoreCase(corsoDb.getTipoQualifica())
						&& corsoApp.getAgenziaFormativa().equalsIgnoreCase(corsoDb.getAgenziaFormativa())) {
					trovato = true;
					/*		    		textTemp = isModifiedField(corsoApp.getIdQualifica(), corsoDb.getIdQualifica())
										? (textTemp + " qualifica,") : textTemp;
							    		textTemp = isModifiedField(corsoApp.getAgenziaFormativa(), corsoDb.getAgenziaFormativa())
										? (textTemp + " agenzia formativa qualifica,") : textTemp;*/
					textTemp = isModifiedField(corsoApp.getDataQualifica(), corsoDb.getDataQualifica())
							? (textTemp + " data qualifica,")
							: textTemp;
					break;
				}
			}
			textTemp = textTemp.substring(0, textTemp.length() - 1);
			if (trovato && !textTemp.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				textMailQualifiche = textMailQualifiche + "MODIFICA della qualifica " + corsoApp.getTipoQualifica()
						+ " per l'unità formativa " + corsoApp.getAgenziaFormativa() + " nei campi: " + textTemp
						+ ";\n";
			} else if (trovato == false) {
				textMailQualifiche = textMailQualifiche + "AGGIUNTA della qualifica " + corsoApp.getTipoQualifica()
						+ " per l'unità formativa " + corsoApp.getAgenziaFormativa() + ";\n";
			} else if (!textTemp.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				textMailQualifiche = textMailQualifiche + textTemp + "\n";
			}
		}
		if (!textMailQualifiche
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
			textMailQualifiche = "\n" + it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_5
					+ it.csi.taif.topforweb.business.dao.util.Constants.LABEL_SEZIONE_4
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_6
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + textMailQualifiche;
		}

		return textMailQualifiche;
	}

	private String createRiconoscimentiTextForMail(CpInserimentoOperatoreModel theModel, Operatore opFromDB,
			Operatore opFromApp, String testo) {

		String textMailRiconoscimenti = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING;

		ArrayList<Riconoscimento> app = theModel.getAppDataelencoRiconoscimento();
		ArrayList<Riconoscimento> db = opFromDB.getElencoRiconoscimenti();

		for (Riconoscimento riconoscimentoApp : app) {
			Boolean trovato = false;
			String textTemp = it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_BLANK;
			for (Riconoscimento riconoscimentoDb : db) {
				if (riconoscimentoApp.getAgenziaFormativa().equalsIgnoreCase(riconoscimentoDb.getAgenziaFormativa())
						&& riconoscimentoApp.getUnitaFormativa()
								.equalsIgnoreCase(riconoscimentoDb.getUnitaFormativa())) {
					trovato = true;
					textTemp = isModifiedField(riconoscimentoApp.getNote(), riconoscimentoDb.getNote())
							? (textTemp + " note riconoscimento,")
							: textTemp;
					textTemp = isModifiedField(riconoscimentoApp.getDataRiconoscimento(),
							riconoscimentoDb.getDataRiconoscimento()) ? (textTemp + " data riconoscimento,") : textTemp;
					break;
				}
			}
			textTemp = textTemp.substring(0, textTemp.length() - 1);
			if (trovato && !textTemp.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				textMailRiconoscimenti = textMailRiconoscimenti
						+ "MODIFICA del riconoscimento per dell'unità formativa "
						+ riconoscimentoApp.getDsUnitaFormativa() + " nei campi: " + textTemp + ";\n";
			} else if (trovato == false) {
				textMailRiconoscimenti = textMailRiconoscimenti
						+ "AGGIUNTA del riconoscimento per dell'unità formativa "
						+ riconoscimentoApp.getDsUnitaFormativa() + ";\n";
			} else if (!textTemp.equalsIgnoreCase(
					it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
				textMailRiconoscimenti = textMailRiconoscimenti + textTemp + "\n";
			}
		}
		if (!textMailRiconoscimenti
				.equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_EMPTY_STRING)) {
			textMailRiconoscimenti = "\n" + it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_5
					+ it.csi.taif.topforweb.business.dao.util.Constants.LABEL_SEZIONE_5
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_6
					+ it.csi.taif.topforweb.business.dao.util.Constants.TESTO_MAIL_STATICO_1 + textMailRiconoscimenti;
		}

		return textMailRiconoscimenti;
	}

	private Boolean isModifiedField(String db, String app) {
		if (db == null && app != null)
			return true;
		if (db != null && app == null)
			return true;
		if (db != null && app != null && !db.equalsIgnoreCase(app))
			return true;
		return false;
	}

	public ByteArrayOutputStream createPdfAttestato(int idCorsoProfessionale, Operatore operatoreSelezionato)
			throws DocumentException, IOException, ManagerException {
		try {
			int idUnitaFormativa = 0;
			String istatSedeCorso = null;
			log.debug("[createPdfAttestato ::execute] idCorsoProfessionale  " + idCorsoProfessionale);
			TaifTCorsoDto corsoDto = topForfMgr.findUnitaFormativaByIdCorso(idCorsoProfessionale);

			log.debug("[createPdfAttestato ::execute] corsoDto  " + corsoDto.getCorso());

			if (corsoDto != null) {
				idUnitaFormativa = corsoDto.getFkUnitaFormativa();
				istatSedeCorso = corsoDto.getIstatSede();
			}

			TaifTPersonaByCodiceFiscalePersonaDto persoanaByCodiceFiscale = topForfMgr
					.findPersonaPerCodiceFiscale(operatoreSelezionato.getCodiceFiscaleOperatore());

			log.debug("[createPdfAttestato ::execute] idUnitaFormativa  " + idUnitaFormativa);
			UnitaFormativaPersona unitaFormativaPers = new UnitaFormativaPersona();
			unitaFormativaPers.setIdPersona(persoanaByCodiceFiscale.getIdPersona());
			unitaFormativaPers.setIdUnitaFormativa(idUnitaFormativa);

			List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> listAgenziaFormativa = topForfMgr
					.findByUnitaFormativaPersona(unitaFormativaPers);
			String filePath = extractPicture();

			log.debug("[createPdfAttestato ::execute] listAgenziaFormativa  " + listAgenziaFormativa.size());

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

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	//	private Integer getIdPersona(CpInserimentoOperatoreModel theModel) {
	//		Integer idPersona = null;
	//		int tipoAccesso = ConvertUtil.convertToInteger(theModel.getAppDatacurrentUser().getTipoAccesso());
	//		switch (tipoAccesso) {
	//			case 1 :
	//			case 2 :
	//				idPersona = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdPersona();
	//				break;
	//			default :
	//				idPersona = Integer.parseInt(theModel.getAppDatadatiOperatore().getIdPersonaOperatore());
	//		}
	//		return idPersona;
	//	}
	
	private int getIdSoggettoFromCodiceIstat(String codIstat) {
		int r = 0;
		if (codIstat != null) {
			codIstat = codIstat.substring(0, 3);
			r = new Integer(codIstat);
		}
		return ConvertUtil.getSoggettoGestoreFromIstat(r);
	}
	
	/*PROTECTED REGION END*/
}
