/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.home;

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

/*PROTECTED REGION ID(R-1185626779) ENABLED START*/
import it.csi.iride2.policy.entity.Identita;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.topforweb.business.common.ProfiloEnum;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaProfiloUtenteByCodiceFiscaleDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.topforweb.business.dao.topfor.filter.ConfigProfiloFilter;
import it.csi.taif.topforweb.business.dao.topfor.filter.PersonaFilter;
import it.csi.taif.topforweb.business.manager.TopForMgr;
import it.csi.taif.topforweb.business.manager.db.DbMgr;
import it.csi.taif.topforweb.business.manager.validation.Validator;
import it.csi.taif.topforweb.dto.ExecResults;
import it.csi.taif.topforweb.dto.home.CpHomeModel;
import it.csi.taif.topforweb.exception.ManagerException;

/*PROTECTED REGION END*/

public class CPBECpHome {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [profiloUtente, scope:USER_SESSION]
	public static final String APPDATA_PROFILOUTENTE_CODE = "appDataprofiloUtente";

	// ApplicationData: [datiOperatore, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATORE_CODE = "appDatadatiOperatore";

	// ApplicationData: [fromModifica, scope:USER_SESSION]
	public static final String APPDATA_FROMMODIFICA_CODE = "appDatafromModifica";

	// ApplicationData: [datiOperatoreFromDB, scope:USER_SESSION]
	public static final String APPDATA_DATIOPERATOREFROMDB_CODE = "appDatadatiOperatoreFromDB";

	// ApplicationData: [isNuovoInserimentoOperatore, scope:USER_SESSION]
	public static final String APPDATA_ISNUOVOINSERIMENTOOPERATORE_CODE = "appDataisNuovoInserimentoOperatore";

	// ApplicationData: [urlPrivacy, scope:USER_SESSION]
	public static final String APPDATA_URLPRIVACY_CODE = "appDataurlPrivacy";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpHome";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo resetDatiOperatore definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults resetDatiOperatore(

			it.csi.taif.topforweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RESETDATIOPERATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R711639190) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataisNuovoInserimentoOperatore(true);
			// impostazione del result code 
			result.setResultCode(RESETDATIOPERATORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::resetDatiOperatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults executeInit(

			it.csi.taif.topforweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_IT = //NOSONAR  Reason:EIAS
				"OK_GESTORE_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_FR = //NOSONAR  Reason:EIAS
				"OK_GESTORE_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_IT = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_FR = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT = //NOSONAR  Reason:EIAS
				"OK_LIBERO_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_FR = //NOSONAR  Reason:EIAS
				"OK_LIBERO_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__GESTORE_KO = //NOSONAR  Reason:EIAS
				"GESTORE_KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1403804259) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("---------- Home EXECUTE Init --------------");
			try {
				String tipoAccesso = theModel.getAppDatacurrentUser().getTipoAccesso();
				if (tipoAccesso == null) {
					//tipoAccesso = "3"; // only for Test mm
				}
				int idProfilo = 0;

				//se l'Accesso è 1/2 (operatore) il profilo è 6 (operatore)
				//se l'Accesso è 3/4 (gestore) il profilo può essere  7 (agenzia), 8 (admin) o 9 (superadmin)

				if (tipoAccesso.equals(it.csi.taif.topforweb.business.dao.util.Constants.one)
						|| tipoAccesso.equals(it.csi.taif.topforweb.business.dao.util.Constants.two)) {
					idProfilo = it.csi.taif.topforweb.business.dao.util.Constants.sixInt;
				} else if (tipoAccesso.equals(it.csi.taif.topforweb.business.dao.util.Constants.three)
						|| tipoAccesso.equals(it.csi.taif.topforweb.business.dao.util.Constants.four)) {
					idProfilo = it.csi.taif.topforweb.business.dao.util.Constants.sevenInt;
				}
				String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
				// testmm
				//codiceFiscale = "RNLPRX90A01L219X";
				PersonaFilter filterPersona = new PersonaFilter();
				filterPersona.setCodiceFiscale(codiceFiscale);
				filterPersona.setNome(theModel.getAppDatacurrentUser().getNome());
				filterPersona.setCognome(theModel.getAppDatacurrentUser().getCognome());
				String naz = theModel.getAppDatacurrentUser().getNazionalita();
				if (naz.equals(it.csi.taif.topforweb.business.dao.util.Constants.fLang)) {
					filterPersona.setIdNazione(it.csi.taif.topforweb.business.dao.util.Constants.twoInt);
					theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
				} else {
					filterPersona.setIdNazione(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
					theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
				}
				//filterPersona.setIdNazione(2);
				// ONLY PER TEST MM
				// idProfilo = 4;
				filterPersona.setIdProfiloUtente(idProfilo);
				if (codiceFiscale != null && StringUtils.isNotBlank(codiceFiscale)) {
					String tracciato = theModel.getAppDatatracciato();
					Integer idConfigUtente = topForMgr.findUserCollegatoPerCodiceFiscale(filterPersona, tracciato);
					topForMgr.updateNumeroAccessi(idConfigUtente);
					Integer idPersona = topForMgr.getPersonaFromCnfUtente(idConfigUtente);
					int idNazione = topForMgr.getPersonaByIdPersona(idPersona).getFkNazione();
					TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = topForMgr
							.getConfigProfiloUtenteByCodiceFiscale(getConfigProfiloUtente(theModel, idNazione),
									idProfilo);
					profiloUtente.setIdConfigUtente(idConfigUtente);
					profiloUtente.setIdNazione(idNazione);
					theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().setIdProfilo(String.valueOf(idProfilo));
					theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().setIdPersona(idPersona);
					theModel.getAppDatacurrentUser().getProfiloUtenteTopFor().setIdConfigUtente(idConfigUtente);
					result.setResultCode(theModel.getAppDataprofiloUtente());
				}

				ProfiloEnum profiloEnum = ProfiloEnum.getByProfilo(tipoAccesso);
				ActionContext.getContext().getSession().put("tipoAccesso", theModel.getAppDatatipoAccesso());
				ProfiloUtenteTopFor profiloUtenteTopFor = new ProfiloUtenteTopFor();
				String code = Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT;
				Locale locale = null;
				Integer idSoggettoGestore = 0;
				TaifTSoggettoGestoreDto sogg = new TaifTSoggettoGestoreDto();
				switch (profiloEnum) {
					case OPERATORE_IT :
						log.debug("Entro OPERATORE_IT");
						code = this.identificaOperatore(theModel, Constants.EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_IT);
						theModel.getAppDatacurrentUser()
								.setLingua(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
						break;
					case OPERATORE_FR :
						log.debug("Entro OPERATORE_FR");
						code = this.identificaOperatore(theModel, Constants.EXECUTEINIT_OUTCOME_CODE__OK_OPERATORE_FR);
						profiloUtenteTopFor.setIdProfilo(it.csi.taif.topforweb.business.dao.util.Constants.two);
						theModel.getAppDatacurrentUser()
								.setLingua(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
						theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
						theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(profiloUtenteTopFor);
						locale = Locale.FRANCE;
						break;
					case GESTORE_IT :
						log.debug("Entro GESTORE_IT");
						code = this.identificaGestore(theModel, Constants.EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_IT);
						theModel.getAppDatacurrentUser()
								.setLingua(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
						idSoggettoGestore = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor()
								.getIdSoggettoGestore();
						sogg = this.dbMgr.findSoggettoGestoreById(idSoggettoGestore);
						theModel.setAppDataurlPrivacy(sogg.getUrlDocPrivacy());
						break;
					case GESTORE_FR :
						log.debug("Entro GESTORE_FR");
						code = this.identificaGestore(theModel, Constants.EXECUTEINIT_OUTCOME_CODE__OK_GESTORE_FR);
						theModel.getAppDatacurrentUser()
								.setLingua(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
						theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
						locale = Locale.FRANCE;
						idSoggettoGestore = theModel.getAppDatacurrentUser().getProfiloUtenteTopFor()
								.getIdSoggettoGestore();
						sogg = this.dbMgr.findSoggettoGestoreById(idSoggettoGestore);
						theModel.setAppDataurlPrivacy(sogg.getUrlDocPrivacy());
					case LIBERO_IT :
						log.debug("Entro LIBERO_IT");
						code = Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_IT;
						theModel.getAppDatacurrentUser()
								.setLingua(it.csi.taif.topforweb.business.dao.util.Constants.iLang);
						break;
					case LIBERO_FR :
						log.debug("Entro LIBERO_FR");
						code = Constants.EXECUTEINIT_OUTCOME_CODE__OK_LIBERO_FR;
						profiloUtenteTopFor.setIdProfilo(it.csi.taif.topforweb.business.dao.util.Constants.six);
						theModel.getAppDatacurrentUser()
								.setLingua(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
						theModel.setAppDatatracciato(it.csi.taif.topforweb.business.dao.util.Constants.fLang);
						theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(profiloUtenteTopFor);
						locale = Locale.FRANCE;
						break;
				}
				theModel.setAppDataprofiloUtente(code);
				result.setResultCode(code);
				result.setModel(theModel);
				return result;

				// impostazione del result code 
				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, EXECUTEINIT_OUTCOME_CODE__GESTORE_KO);
			}
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
	 * ContentPanel cpHome
	 */
	public ExecResults executeRefresh(

			it.csi.taif.topforweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEREFRESH_OUTCOME_CODE__OK_GESTORE_IT = //NOSONAR  Reason:EIAS
				"OK_GESTORE_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__OK_GESTORE_FR = //NOSONAR  Reason:EIAS
				"OK_GESTORE_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__OK_OPERATORE_IT = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__OK_OPERATORE_FR = //NOSONAR  Reason:EIAS
				"OK_OPERATORE_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__OK_LIBERO_IT = //NOSONAR  Reason:EIAS
				"OK_LIBERO_IT"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__OK_LIBERO_FR = //NOSONAR  Reason:EIAS
				"OK_LIBERO_FR"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__GESTORE_KO = //NOSONAR  Reason:EIAS
				"GESTORE_KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1890053296) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(EXECUTEREFRESH_OUTCOME_CODE__OK_GESTORE_IT);

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

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1358798737) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	@Autowired
	private TopForMgr topForMgr;

	private DbMgr dbMgr;

	public TopForMgr getTopForMgr() {
		return topForMgr;
	}

	public void setTopForMgr(TopForMgr topForMgr) {
		this.topForMgr = topForMgr;
	}

	public DbMgr getDbMgr() {
		return dbMgr;
	}

	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}

	private ConfigProfiloFilter getConfigProfiloUtente(CpHomeModel theModel, int nazione) {
		ConfigProfiloFilter configProfiloFilter = new ConfigProfiloFilter();
		configProfiloFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
		configProfiloFilter.setFlagAttivo(it.csi.taif.topforweb.business.dao.util.Constants.oneInt);
		configProfiloFilter.setIdProcedura(it.csi.taif.topforweb.business.dao.util.Constants.twoInt);
		if (nazione == 1) {
			configProfiloFilter.setDataTracciato("I");
		} else {
			configProfiloFilter.setDataTracciato("F");
		}
		return configProfiloFilter;
	}

	public String identificaGestore(it.csi.taif.topforweb.dto.home.CpHomeModel theModel, String resultCode)
			throws Exception {
		final String EXECUTEINIT_OUTCOME_CODE_GESTORE_KO = //NOSONAR  Reason:EIAS
				Constants.EXECUTEINIT_OUTCOME_CODE__GESTORE_KO; //NOSONAR  Reason:EIAS
		SecurityHelper sh = new SecurityHelper();
		Identita identita = sh.getCurrUser(theModel.getSession());
		ProfiloUtenteTopFor pu = this.getTopForMgr().getProfiloUtente(identita.getCodFiscale(), false);
		if (pu == null) {
			return Constants.EXECUTEINIT_OUTCOME_CODE__GESTORE_KO;
		} else {
			theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(pu);
			return resultCode;
		}
	}

	public String identificaOperatore(it.csi.taif.topforweb.dto.home.CpHomeModel theModel, String resultCode)
			throws ManagerException, BEException {
		final String IDENTIFICAPROFILO_OUTCOME_CODE__INITKO = //NOSONAR  Reason:EIAS
				Constants.IDENTIFICAPROFILO_OUTCOME_CODE__INITKO; //NOSONAR  Reason:EIAS
		SecurityHelper sh = new SecurityHelper();
		Identita identita = sh.getCurrUser(theModel.getSession());
		ProfiloUtenteTopFor pu = this.getTopForMgr().getProfiloUtente(identita.getCodFiscale(), true);
		if (pu == null) {
			return Constants.EXECUTEINIT_OUTCOME_CODE__GESTORE_KO;
		} else {
			theModel.getAppDatacurrentUser().setProfiloUtenteTopFor(pu);
			return resultCode;
		}
	}

	/*PROTECTED REGION END*/
}
