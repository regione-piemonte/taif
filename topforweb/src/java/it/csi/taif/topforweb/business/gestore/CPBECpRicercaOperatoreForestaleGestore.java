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

/*PROTECTED REGION ID(R-768038860) ENABLED START*/
import it.csi.iride2.policy.entity.Identita;
import it.csi.iride2.policy.exceptions.MalformedIdTokenException;

import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTOpfoRicercaOperatoreAvanzataDto;
import it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.manager.DummyMgr;
import org.dozer.DozerBeanMapper;
import it.csi.taif.topforweb.exception.ManagerException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
/*PROTECTED REGION END*/

public class CPBECpRicercaOperatoreForestaleGestore {

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

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

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

	// ApplicationData: [profiloUtente, scope:USER_SESSION]
	public static final String APPDATA_PROFILOUTENTE_CODE = "appDataprofiloUtente";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

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

	// ApplicationData: [elencoNazioni, scope:USER_SESSION]
	public static final String APPDATA_ELENCONAZIONI_CODE = "appDataelencoNazioni";

	// ApplicationData: [urlPrivacy, scope:USER_SESSION]
	public static final String APPDATA_URLPRIVACY_CODE = "appDataurlPrivacy";

	// ApplicationData: [privacy, scope:USER_SESSION]
	public static final String APPDATA_PRIVACY_CODE = "appDataprivacy";

	// ApplicationData: [consensoPubblicazione, scope:USER_SESSION]
	public static final String APPDATA_CONSENSOPUBBLICAZIONE_CODE = "appDataconsensoPubblicazione";

	// ApplicationData: [elencoProvinceRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCERICERCAOPERATOREGESTORE_CODE = "appDataelencoProvinceRicercaOperatoreGestore";

	// ApplicationData: [elencoAmbitoFormativoRicercaOperatore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAMBITOFORMATIVORICERCAOPERATORE_CODE = "appDataelencoAmbitoFormativoRicercaOperatore";

	// ApplicationData: [idAmbitoFormativoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDAMBITOFORMATIVOSELEZIONATO_CODE = "appDataidAmbitoFormativoSelezionato";

	// ApplicationData: [idProvinciaSelezionatoRicercaOperatoreGestore, scope:USER_SESSION]
	public static final String APPDATA_IDPROVINCIASELEZIONATORICERCAOPERATOREGESTORE_CODE = "appDataidProvinciaSelezionatoRicercaOperatoreGestore";

	// ApplicationData: [ricercaLibera, scope:USER_SESSION]
	public static final String APPDATA_RICERCALIBERA_CODE = "appDataricercaLibera";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaOperatoreForestaleGestore";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadUnitaFormative definito in un ExecCommand del
	 * ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults loadUnitaFormative(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADUNITAFORMATIVE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R410720861) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String lingua = theModel.getAppDatacurrentUser().getLingua();
			SoggettoGestoreVisibleOrdinFilter filter = this.getSoggettoGestoreVisibileOrdinFilter(theModel, lingua);
			String idAmbitoFormativo = theModel.getAppDataidAmbitoFormativoSelezionato();

			if (StringUtils.isNotEmpty(idAmbitoFormativo)
					&& !Constants.NULL_VALUE_ID_AMBITO_FORMATIVO.equalsIgnoreCase(idAmbitoFormativo)) {
				theModel.setAppDataelencoUnitaFormativaRicercaOperatore(
						this.topForfMgr.getElencoUnitaFormativaByAmbito(idAmbitoFormativo, filter, lingua));
			} else {
				theModel.setAppDataelencoUnitaFormativaRicercaOperatore(
						this.topForfMgr.getElencoUnitaFormativa(filter, lingua));
			}

			// impostazione del result code 
			result.setResultCode(LOADUNITAFORMATIVE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadUnitaFormative] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadComuni definito in un ExecCommand del
	 * ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults loadComuni(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-340515566) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idProvincia = theModel.getAppDataidProvinciaSelezionatoRicercaOperatoreGestore();
			if (StringUtils.isNotEmpty(idProvincia)
					&& !Constants.NULL_VALUE_ISTAT_PROVINCIA.equalsIgnoreCase(idProvincia)) {
				theModel.setAppDataelencoComuniRicercaOperatoreGestore(
						this.topForfMgr.getElencoComuniPerIstatProvincia(idProvincia));
			} else {
				theModel.setAppDataelencoComuniRicercaOperatoreGestore(topForfMgr.getElencoComuni());
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
	 * Implementazione del metodo goBack definito in un ExecCommand del
	 * ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults goBack(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOBACK_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2113737416) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GOBACK_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			theModel.setAppDataidStatoSchedaSelezionatoRicercaOperatore(new String());
			theModel.setAppDatacognomeRicercaOperatore(new String());

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
	 * Implementazione del metodo ricercaOperatore definito in un ExecCommand del
	 * ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults ricercaOperatore(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAOPERATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String RICERCAOPERATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1335413475) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<Operatore> listOperatoriTrovati = this.ricercaOperatoreByCriteria(theModel, false);
			theModel.setAppDataelencoRisultatiRicercaOperatoreGestore(listOperatoriTrovati);
			result.setResultCode(RICERCAOPERATORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaOperatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel cpRicercaOperatoreForestaleGestore
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT = //NOSONAR  Reason:EIAS
				"OK_LIBERO_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_FR = //NOSONAR  Reason:EIAS
				"OK_LIBERO_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_IT = //NOSONAR  Reason:EIAS
				"OK_GESTORE_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_FR = //NOSONAR  Reason:EIAS
				"OK_GESTORE_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__SUPERADMIN = //NOSONAR  Reason:EIAS
				"superadmin"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1875799636) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String linguaDati = theModel.getAppDatacurrentUser().getLingua();

			int idConfigUtente;
			if (ActionContext.getContext().getSession().get("idConfigUtente") != null) {
				String interConfigUtente = ActionContext.getContext().getSession().get("idConfigUtente") + "";
				idConfigUtente = Integer.parseInt(interConfigUtente);
			}

			// se il soggetto gestore è = 0 sono superadmin e devo tutte le categorie impresa
			// e attività svolte (sia italiane che francesi) quindi tolgo il flag sulla nazione

			if (theModel.getAppDatacurrentUser().getProfiloUtenteTopFor() != null
					&& theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore() != null
					&& theModel.getAppDatacurrentUser().getProfiloUtenteTopFor()
							.getIdSoggettoGestore() == it.csi.taif.topforweb.business.dao.util.Constants.GESTORE_SUPERADMIN) {
				soggettoGestoreVisibleOrdinFilter.setFlagVisibile(0);
				soggettoGestoreVisibleOrdinFilter.setFlagItaFr(null);
				soggettoGestoreVisibleOrdinFilter.setIdSoggettoGestore(0);
				result.setResultCode(EXECUTEINIT_OUTCOME_CODE__SUPERADMIN);
			} else if (theModel.getAppDataprofiloUtente()
					.equalsIgnoreCase(Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT)
					|| theModel.getAppDataprofiloUtente()
							.equalsIgnoreCase(Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_FR)) {
				// se utente libero IT vedo tutti gli elenchi di appartenenza e con il flag visible = 1
				soggettoGestoreVisibleOrdinFilter = getSoggettoGestoreVisibileOrdinFilter(theModel, linguaDati);
				soggettoGestoreVisibleOrdinFilter.setIdSoggettoGestore(0);
				this.setRicercaLibera(true);
				this.createFakeIdentita();

			} else {
				soggettoGestoreVisibleOrdinFilter = getSoggettoGestoreVisibileOrdinFilter(theModel, linguaDati);
				int soggettoGestore = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore();
				soggettoGestoreVisibleOrdinFilter.setIdSoggettoGestore(soggettoGestore);
				this.setRicercaLibera(false);
			}
			theModel.setAppDataricercaLibera(this.isRicercaLibera());
			theModel.setAppDataelencoAlbiRicercaOperatore(topForfMgr.getElencoAlbi(soggettoGestoreVisibleOrdinFilter));

			theModel.setAppDataelencoProvinceRicercaOperatoreGestore(
					ListUtils.addFirstEmptyElement(Constants.NULL_VALUE_ISTAT_PROVINCIA, Constants.NULL_VALUE_PROVINCIA,
							topForfMgr.getElencoProvinceIstat()));
			theModel.setAppDataelencoComuniRicercaOperatoreGestore(topForfMgr.getElencoComuni());

			theModel.setAppDataelencoAmbitoFormativoRicercaOperatore(ListUtils.addFirstEmptyElement(
					Constants.NULL_VALUE_ID_AMBITO_FORMATIVO, Constants.NULL_VALUE_AMBITO_FORMATIVO,
					topForfMgr.getElencoAmbitiFormativi(soggettoGestoreVisibleOrdinFilter)));

			theModel.setAppDataelencoUnitaFormativaRicercaOperatore(
					this.topForfMgr.getElencoUnitaFormativa(soggettoGestoreVisibleOrdinFilter, linguaDati));

			theModel.setAppDataelencoNazioni(topForfMgr
					.getElencoNazioniPerLingua(it.csi.taif.topforweb.business.dao.util.Constants.oneInt, linguaDati));

			theModel.setAppDataelencoAgenziaFormativaRicercaOperatore(
					this.topForfMgr.getElencoAgenziaFormativa(soggettoGestoreVisibleOrdinFilter));

			theModel.setAppDataelencoStatoSchedaRicerca(
					this.topForfMgr.getElencoStatoScheda(soggettoGestoreVisibleOrdinFilter, linguaDati));

			theModel.setAppDataelencoStatoOperatoreRicerca(ConvertUtil.createElencoStatoOperatore(linguaDati));

			// se utente libero blocco le combo stato scheda e stato operatore a validata e pubblico
			if (theModel.getAppDataprofiloUtente().equalsIgnoreCase(Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT)
					|| theModel.getAppDataprofiloUtente()
							.equalsIgnoreCase(Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_FR)) {
				theModel.setAppDataidStatoSchedaSelezionatoRicercaOperatore(
						it.csi.taif.topforweb.business.dao.util.Constants.ID_STATO_SCHEDA_VALIDATA);
				theModel.setAppDataidStatoOperatoreSelezionato(
						it.csi.taif.topforweb.business.dao.util.Constants.ID_STATO_OPERATORE_PUBBLICO + "");
			}

			// impostazione del result code 
			result.setResultCode(theModel.getAppDataprofiloUtente());

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
	/*PROTECTED REGION ID(R29920448) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	@Autowired
	private DummyMgr dummyMgr = null;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private SoggettoGestoreVisibleOrdinFilter soggettoGestoreVisibleOrdinFilter;

	@Autowired
	private TopForMgr topForfMgr;

	public TopForMgr getTopForfMgr() {
		return topForfMgr;
	}

	public void setTopForfMgr(TopForMgr topForfMgr) {
		this.topForfMgr = topForfMgr;
	}

	private SoggettoGestoreVisibleOrdinFilter getSoggettoGestoreVisibileOrdinFilter(
			CpRicercaOperatoreForestaleGestoreModel theModel, String linguaDati) {
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

	private SoggettoGestoreVisibleOrdinFilter getSoggettoGestoreUnitaFormativaFilter(
			CpRicercaOperatoreForestaleGestoreModel theModel) {
		soggettoGestoreVisibleOrdinFilter
				.setIdSoggettoGestore(theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().getIdSoggettoGestore());
		return soggettoGestoreVisibleOrdinFilter;
	}

	private ArrayList<Operatore> ricercaOperatoreByCriteria(CpRicercaOperatoreForestaleGestoreModel theModel,
			boolean isRicercaLibera) throws ManagerException, ParseException {
		RicercaOperatoreFilter ricercaOperatoreFilter = new RicercaOperatoreFilter();
		ArrayList<Operatore> operatoreList = new ArrayList<Operatore>();
		/*	ricercaAziendaFilter.setIdRuolo(new Integer("1"));
			ricercaAziendaFilter.setTipoSede(new Integer("1"));*/
		//albo di appartenenza
		List<String> listAlboOperatore = new ArrayList<String>();
		if (ConvertUtil.checkListIsNullOrEmpty(theModel.getAppDataelencoAlbiSelezionatiRicercaOperatore())) {
			for (int i = 0; i < theModel.getAppDataelencoAlbiSelezionatiRicercaOperatore().size(); i++) {
				String id = theModel.getAppDataelencoAlbiSelezionatiRicercaOperatore().get(i);
				listAlboOperatore.add(id);
			}
			ricercaOperatoreFilter.setAlboOperatore(listAlboOperatore);
		} else {
			for (int i = 0; i < theModel.getAppDataelencoAlbiRicercaOperatore().size(); i++) {
				String id = theModel.getAppDataelencoAlbiRicercaOperatore().get(i).getCode();
				listAlboOperatore.add(id);
			}
			ricercaOperatoreFilter.setAlboOperatore(listAlboOperatore);
		}
		String idAmbitoFormativo = theModel.getAppDataidAmbitoFormativoSelezionato();
		if (StringUtils.isNotEmpty(idAmbitoFormativo)
				&& !Constants.NULL_VALUE_ID_AMBITO_FORMATIVO.equalsIgnoreCase(idAmbitoFormativo)) {
			ricercaOperatoreFilter.setIdAmbitoFormativo(idAmbitoFormativo);
		} else {
			ricercaOperatoreFilter.setIdAmbitoFormativo(null);
		}
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidUnitaFormativaSelezionata())) {
			ricercaOperatoreFilter.setUnitaFormativa(theModel.getAppDataidUnitaFormativaSelezionata());
		}
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatacognomeRicercaOperatore())) {
			ricercaOperatoreFilter.setCognome(theModel.getAppDatacognomeRicercaOperatore());
		}
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidAgenziaFormativaSelezionata())) {
			ricercaOperatoreFilter.setAgenziaFormativa(theModel.getAppDataidAgenziaFormativaSelezionata());
		}

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatadataPeriodoSvolgimentoA())) {
			Date dataPeriodoSvolgimentoA = df.parse(theModel.getAppDatadataPeriodoSvolgimentoA());
			ricercaOperatoreFilter.setDataA(dataPeriodoSvolgimentoA);
		}
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatadataPeriodoSvolgimentoDa())) {
			Date dataPeriodoSvolgimentoDa = df.parse(theModel.getAppDatadataPeriodoSvolgimentoDa());
			ricercaOperatoreFilter.setDataDa(dataPeriodoSvolgimentoDa);
		}
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataisOperatoreConQualifica())) {
			ricercaOperatoreFilter
					.setOperatoreConQualifica(Boolean.valueOf(theModel.getAppDataisOperatoreConQualifica()));
		}
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataisIstruttoreOperatore())) {
			ricercaOperatoreFilter.setIstruttore(Boolean.valueOf(theModel.getAppDataisIstruttoreOperatore()));
		}

		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidStatoOperatoreSelezionato())) {
			ricercaOperatoreFilter.setStatoOperatore(theModel.getAppDataidStatoOperatoreSelezionato());
		}
		if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidStatoSchedaSelezionatoRicercaOperatore())) {
			ricercaOperatoreFilter.setStatoScheda(theModel.getAppDataidStatoSchedaSelezionatoRicercaOperatore());
		}

		String istatProvincia = theModel.getAppDataidProvinciaSelezionatoRicercaOperatoreGestore();
		if (StringUtils.isNotEmpty(istatProvincia)
				&& !Constants.NULL_VALUE_ISTAT_PROVINCIA.equalsIgnoreCase(istatProvincia)) {
			ricercaOperatoreFilter.setIstatProvincia(istatProvincia);
		} else {
			ricercaOperatoreFilter.setIstatProvincia(null);
		}
		ricercaOperatoreFilter.setIstatComune(theModel.getAppDataidComuneSelezionatoRicercaOperatoreGestore());

		// prarametro ricerca libera = false
		ricercaOperatoreFilter.setRicercaLibera(this.isRicercaLibera());

		List<TaifTOpfoRicercaOperatoreAvanzataDto> elencoOperatoreTrovati = this.topForfMgr
				.ricercaOperatoreAvanzata(ricercaOperatoreFilter);
		List<Integer> idOperatoriTrovati = new ArrayList<Integer>();
		for (TaifTOpfoRicercaOperatoreAvanzataDto operatoreDto : elencoOperatoreTrovati) {
			//operatoreList.add(dozerBeanMapper.map(operatoreDto, Operatore.class));
			idOperatoriTrovati.add(operatoreDto.getIdPersona());
			Operatore operatore = new Operatore();
			operatore = convertFromDtoToObject(operatoreDto, theModel);
			operatoreList.add(operatore);
			if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getUrlPrivacy())) {
				theModel.setAppDataurlPrivacy(operatoreDto.getUrlPrivacy());
			}
		}
		ActionContext.getContext().getSession().put("tracciatoExp", theModel.getAppDatatracciato());
		ActionContext.getContext().getSession().put("idOperatoriTrovati", idOperatoriTrovati);

		return operatoreList;
	}

	private Operatore convertFromDtoToObject(TaifTOpfoRicercaOperatoreAvanzataDto operatoreDto,
			CpRicercaOperatoreForestaleGestoreModel theModel) {
		Operatore operatore = new Operatore();
		if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getCodiceFiscale())) {
			operatore.setCodiceFiscaleOperatore(operatoreDto.getCodiceFiscale());
		} else if (ConvertUtil.checkIsNullOrEmpty(operatoreDto.getNRsiMsa())) {
			operatore.setCodiceFiscaleOperatore(operatoreDto.getNRsiMsa());
		}
		operatore.setCognomeNomeOperatore(operatoreDto.getCognomeOperatore() + " " + operatoreDto.getNomeOperatore());
		operatore.setIdPersonaOperatore(operatoreDto.getIdPersona() + "");
		operatore.setIdElencoAmministrazioneCompetenza(operatoreDto.getIdSoggettoGestore());
		operatore.setDsElencoAmministrazioneCompetenza(operatoreDto.getDenominazioneBreve());
		operatore.setCorsiSostenutiOperatore(operatoreDto.getElencoCorso());

		return operatore;
	}

	public DozerBeanMapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}

	public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
	}

	public DummyMgr getDummyMgr() {
		return dummyMgr;
	}

	public void setDummyMgr(DummyMgr dummyMgr) {
		this.dummyMgr = dummyMgr;
	}

	public SoggettoGestoreVisibleOrdinFilter getSoggettoGestoreVisibleOrdinFilter() {
		return soggettoGestoreVisibleOrdinFilter;
	}

	public void setSoggettoGestoreVisibleOrdinFilter(
			SoggettoGestoreVisibleOrdinFilter soggettoGestoreVisibleOrdinFilter) {
		this.soggettoGestoreVisibleOrdinFilter = soggettoGestoreVisibleOrdinFilter;
	}

	private static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	private void createFakeIdentita() {

		StringBuilder token = new StringBuilder();
		token.append("RCRLBR77HL219V");
		token.append("/");
		token.append("RICERCA");
		token.append("/");
		token.append("LIBERA");
		token.append("/INFOCERT/");
		token.append(DateUtil.getTokenDataCorrente());
		token.append("/16/JqUoGcC+E9q0jQKl1zeRew==");

		try {
			Identita identita = new Identita(token.toString());
			ActionContext.getContext().getSession().put(IRIDE_ID_SESSIONATTR, identita);
		} catch (MalformedIdTokenException e) {
			log.error("[CPBECpRicercaOperatoreForestaleGestore::createFakeHeader] " + e.toString(), e);
		}

	}

	private boolean ricercaLibera;

	/**
	 * @return the ricercaLibera
	 */
	public boolean isRicercaLibera() {
		return ricercaLibera;
	}

	/**
	 * @param ricercaLibera the ricercaLibera to set
	 */
	public void setRicercaLibera(boolean ricercaLibera) {
		this.ricercaLibera = ricercaLibera;
	}

	/*PROTECTED REGION END*/
}
