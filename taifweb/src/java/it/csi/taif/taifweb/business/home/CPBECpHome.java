/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.home;

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

/*PROTECTED REGION ID(R-1185626779) ENABLED START*/

import com.opensymphony.xwork2.ActionContext;

import it.csi.custom.component.tree.base.TreeNode;
import it.csi.custom.component.tree.base.TreeNodeBase;
import it.csi.taif.taifweb.business.BEException;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaByProfiloPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaProfiloUtenteByCodiceFiscaleDto;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloPersona;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PraticaFilter;
import it.csi.taif.taifweb.business.manager.DummyMgr;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.validation.Validator;
import it.csi.taif.taifweb.dto.ExecResults;
import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.common.UserInfo;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.presentation.taifweb.action.ActivateMultiPanelItemCommand;
import it.csi.taif.taifweb.presentation.taifweb.action.home.CpHomeAction;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.GenericUtil;
import it.csi.taif.taifweb.util.StringUtils;

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

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [elencoDomande, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOMANDE_CODE = "appDataelencoDomande";

	// ApplicationData: [idAlboSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALBOSELEZIONATO_CODE = "appDataidAlboSelezionato";

	// ApplicationData: [idDomandaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDDOMANDASELEZIONATA_CODE = "appDataidDomandaSelezionata";

	// ApplicationData: [nodoAziendaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_NODOAZIENDASELEZIONATA_CODE = "appDatanodoAziendaSelezionata";

	// ApplicationData: [treeElencoAziende, scope:USER_SESSION]
	public static final String APPDATA_TREEELENCOAZIENDE_CODE = "appDatatreeElencoAziende";

	// ApplicationData: [idPratica, scope:USER_SESSION]
	public static final String APPDATA_IDPRATICA_CODE = "appDataidPratica";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [elencoAziendeAAEP, scope:USER_SESSION]
	public static final String APPDATA_ELENCOAZIENDEAAEP_CODE = "appDataelencoAziendeAAEP";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpHome";

	public static final String MULTIPANEL_MPAZIENDEAAEP = "mpAziendeAAEP";
	public static final String MPI_MPAZIENDEAAEP_FPAZIENDEAAEP = CPNAME + "_" + MULTIPANEL_MPAZIENDEAAEP + "_"
			+ "fpAziendeAAEP";

	public static final String MULTIPANEL_MPELENCODOMANDE = "mpElencoDomande";
	public static final String MPI_MPELENCODOMANDE_FPELENCODOMANDE = CPNAME + "_" + MULTIPANEL_MPELENCODOMANDE + "_"
			+ "fpElencoDomande";

	public static final String MULTIPANEL_MPELENCODOMANDEFR = "mpElencoDomandeFr";
	public static final String MPI_MPELENCODOMANDEFR_FPELENCODOMANDEFR = CPNAME + "_" + MULTIPANEL_MPELENCODOMANDEFR
			+ "_" + "fpElencoDomandeFr";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onTableAAEPClicked definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults onTableAAEPClicked(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTABLEAAEPCLICKED_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1116515319) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String resultCode = ONTABLEAAEPCLICKED_OUTCOME_CODE__OK;
			String codiceFiscaleAzienda = theModel.getIdRiga();
			String idColonna = theModel.getIdColonna();
			String dataTracciato = theModel.getAppDatatracciato();
			if (theModel.getAppDatatracciato() == null) {
				dataTracciato = it.csi.taif.taifweb.business.dao.util.Constants.iLang;
			}

			ActionContext.getContext().getSession().put("dataTracciato", dataTracciato);
			ActionContext.getContext().getSession().put("codiceFiscaleAzienda", codiceFiscaleAzienda);

			// impostazione del result code 
			result.setResultCode(ONTABLEAAEPCLICKED_OUTCOME_CODE__OK);

			// AGGANCIARE QUA IL RICHIAMO AD AAEP per precaricare i dati dell'Azienda
			log.debug("------------------- DETTAGLIO AAEP ----------------------");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onTableAAEPClicked] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onTableClicked definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults onTableClicked(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTABLECLICKED_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ONTABLECLICKED_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1631115326) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String resultCode = ONTABLECLICKED_OUTCOME_CODE__OK;
			String idColonna = theModel.getIdColonna();
			if (Constants.ICONA_CANCELLA.equalsIgnoreCase(idColonna)) {

				String idPratica = theModel.getIdRiga();
				String dataTracciato = theModel.getAppDatatracciato();
				if (theModel.getAppDatatracciato() == null) {
					dataTracciato = it.csi.taif.taifweb.business.dao.util.Constants.iLang;
				}
				ActionContext.getContext().getSession().put("dataTracciato", dataTracciato);
				ActionContext.getContext().getSession().put("idPratica", idPratica);

				resultCode = ONTABLECLICKED_OUTCOME_CODE__DELETE;
			} else {

				String idPratica = theModel.getIdRiga();
				String dataTracciato = theModel.getAppDatatracciato();
				if (theModel.getAppDatatracciato() == null) {
					dataTracciato = it.csi.taif.taifweb.business.dao.util.Constants.iLang;
				}
				PraticaFilter filter = new PraticaFilter();
				filter.setIdPratica(ConvertUtil.convertToInteger(idPratica));
				//theModel.setAppDataelencoDomande(this.taifMgr.getDomandaByPratica(filter, dataTracciato));
				log.debug("ID DOMANDA DA HOME? " + idPratica);
				theModel.setAppDataidPratica(ConvertUtil.convertToInteger(idPratica));
				// richiamo al dettaglio della azienda/domanda
			}
			// impostazione del result code 
			result.setResultCode(resultCode);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onTableClicked] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onTableFrClicked definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults onTableFrClicked(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTABLEFRCLICKED_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ONTABLEFRCLICKED_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1325399274) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String resultCode = ONTABLEFRCLICKED_OUTCOME_CODE__OK;
			String idColonna = theModel.getIdColonna();
			String idPratica = theModel.getIdRiga();
			String dataTracciato = theModel.getAppDatatracciato();

			if (Constants.ICONA_CANCELLA.equalsIgnoreCase(idColonna)) {

				ActionContext.getContext().getSession().put("dataTracciato", dataTracciato);
				ActionContext.getContext().getSession().put("idPratica", idPratica);

				resultCode = ONTABLEFRCLICKED_OUTCOME_CODE__DELETE;
			} else {

				if (theModel.getAppDatatracciato() == null) {
					dataTracciato = it.csi.taif.taifweb.business.dao.util.Constants.fLang;
				}
				PraticaFilter filter = new PraticaFilter();
				filter.setIdPratica(ConvertUtil.convertToInteger(idPratica));
				//theModel.setAppDataelencoDomande(this.taifMgr.getDomandaByPratica(filter, dataTracciato));
				log.debug("ID DOMANDA DA HOME? " + idPratica);
				theModel.setAppDataidPratica(ConvertUtil.convertToInteger(idPratica));
				// richiamo al dettaglio della azienda/domanda
			}

			// impostazione del result code 
			result.setResultCode(resultCode);
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onTableFrClicked] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo testActa definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults testActa(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String TESTACTA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1710694293) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			this.taifMgr.testActa();
			// impostazione del result code 
			result.setResultCode(TESTACTA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::testActa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaDomanda definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults eliminaDomanda(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINADOMANDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ELIMINADOMANDA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-344087141) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String idPratica = (String) ActionContext.getContext().getSession().get("idPratica");
			taifMgr.eliminaDomandaByIdzienda(Integer.valueOf(idPratica).intValue());
			//VT: jira taif-26
			ArrayList<AziendaAAEP> listAziendeAaep = new ArrayList<AziendaAAEP>();
			ArrayList<AziendaAAEP> aziendaDaAAEP = taifMgr
					.getElencoAziendeAAEP(theModel.getAppDatacurrentUser().getCodFisc());
			for (AziendaAAEP aziendaAAEP : aziendaDaAAEP) {
				if (!taifMgr.existeCodiceFiscaleAzienda(aziendaAAEP.getCodiceFiscale())) {
					listAziendeAaep.add(aziendaAAEP);
				}
			}
			theModel.setAppDataelencoAziendeAAEP(listAziendeAaep);
			theModel.setAppDataelencoDomande(
					this.taifMgr.getElencoDomandeSecondo(theModel.getAppDatacurrentUser().getCodFisc()));
			//fine jira taif-26
			//public void eliminaDomandaByIdzienda(Integer idAzienda, String tracciato)
			// impostazione del result code 
			result.setResultCode(ELIMINADOMANDA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaDomanda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String EXECUTEINIT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1403804259) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("---------- Home EXECUTE Init --------------");
			try {
				String tipoAccesso = theModel.getAppDatacurrentUser().getTipoAccesso();
				if (tipoAccesso == null) {
					tipoAccesso = "1"; // only for Test mm
				}
				int idProfilo = 0;
				if (tipoAccesso.equals(it.csi.taif.taifweb.business.dao.util.Constants.one)
						|| tipoAccesso.equals(it.csi.taif.taifweb.business.dao.util.Constants.two)) {
					idProfilo = it.csi.taif.taifweb.business.dao.util.Constants.oneInt;
				} else if (tipoAccesso.equals(it.csi.taif.taifweb.business.dao.util.Constants.three)
						|| tipoAccesso.equals(it.csi.taif.taifweb.business.dao.util.Constants.four)) {
					idProfilo = it.csi.taif.taifweb.business.dao.util.Constants.twoInt;
				}
				String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
				// testmm
				//codiceFiscale = "RNLPRX90A01L219X";
				PersonaFilter filterPersona = new PersonaFilter();
				filterPersona.setCodiceFiscale(codiceFiscale);
				filterPersona.setNome(theModel.getAppDatacurrentUser().getNome());
				filterPersona.setCognome(theModel.getAppDatacurrentUser().getCognome());
				String naz = theModel.getAppDatacurrentUser().getNazionalita();
				if (naz.equals("F")) {
					filterPersona.setIdNazione(2);
					theModel.setAppDatatracciato("F");
				} else {
					filterPersona.setIdNazione(1);
					theModel.setAppDatatracciato("I");
				}

				//filterPersona.setIdNazione(2);
				// ONLY PER TEST MM
				// idProfilo = 4;
				filterPersona.setIdProfiloUtente(idProfilo);
				if (codiceFiscale != null && StringUtils.isNotBlank(codiceFiscale)) {
					String tracciato = theModel.getAppDatatracciato();
					Integer idConfigUtente = taifMgr.findUserCollegatoPerCodiceFiscale(filterPersona, tracciato);
					taifMgr.updateNumeroAccessi(idConfigUtente);
					Integer idPersona = taifMgr.getPersonaFromCnfUtente(idConfigUtente);
					int idNazione = taifMgr.getPersonaByIdPersona(idPersona).getFkNazione();
					TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = taifMgr
							.getConfigProfiloUtenteByCodiceFiscale(getConfigProfiloUtente(theModel, idNazione),
									idProfilo);
					ActionContext.getContext().getSession().put("idProfilo", idProfilo);

					ActionContext.getContext().getSession().put("idNazione", profiloUtente.getIdNazione().toString());
					ActionContext.getContext().getSession().put("idConfigUtente", profiloUtente.getIdConfigUtente());
					ActionContext.getContext().getSession().put("idAlbo", theModel.getAppDataidAlboSelezionato());
					ActionContext.getContext().getSession().put("appDatatracciato", theModel.getAppDatatracciato());

					//theModel.setAppDatatreeElencoAziende(this.loadTreeElencoAziende(new ArrayList<CodeDescription>()));
					ArrayList<AziendaAAEP> listAziendeAaep = new ArrayList<AziendaAAEP>();
					ArrayList<AziendaAAEP> aziendaDaAAEP = taifMgr
							.getElencoAziendeAAEP(theModel.getAppDatacurrentUser().getCodFisc());
					for (AziendaAAEP aziendaAAEP : aziendaDaAAEP) {
						if (!taifMgr.existeCodiceFiscaleAzienda(aziendaAAEP.getCodiceFiscale())) {
							listAziendeAaep.add(aziendaAAEP);
						}
					}
					theModel.setAppDataelencoAziendeAAEP(listAziendeAaep);
					// mm - carica elencoAzienda dummy
					//theModel.setAppDataelencoAziendeAAEP(this.dummyMgr.getElencoAziendeAAEP());

					theModel.setAppDataelencoDomande(
							this.taifMgr.getElencoDomandeSecondo(theModel.getAppDatacurrentUser().getCodFisc()));

					this.setVisibility(theModel);

					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK);
				}
				// impostazione del result code
				// modifica degli attributi del model (che verranno propagati allo strato
				// di presentation). si puo' agire anche direttamente sull'attributo "session".
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, EXECUTEINIT_OUTCOME_CODE__KO);
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
	 * Implementazione del metodo executeEnter definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults executeEnter(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEENTER_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String EXECUTEENTER_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1973868237) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("---------- Home EXECUTE Enter --------------");
			// impostazione del result code 

			theModel.getAppDatacurrentUser()
					.setLingua(GenericUtil.getLinguaFromLocale(ActionContext.getContext().getLocale()));

			//VT: jira taif-26
			ArrayList<AziendaAAEP> listAziendeAaep = new ArrayList<AziendaAAEP>();
			ArrayList<AziendaAAEP> aziendaDaAAEP = taifMgr
					.getElencoAziendeAAEP(theModel.getAppDatacurrentUser().getCodFisc());
			for (AziendaAAEP aziendaAAEP : aziendaDaAAEP) {
				if (!taifMgr.existeCodiceFiscaleAzienda(aziendaAAEP.getCodiceFiscale())) {
					listAziendeAaep.add(aziendaAAEP);
				}
			}
			theModel.setAppDataelencoAziendeAAEP(listAziendeAaep);
			theModel.setAppDataelencoDomande(
					this.taifMgr.getElencoDomandeSecondo(theModel.getAppDatacurrentUser().getCodFisc()));
			//fine jira taif-26

			result.setResultCode(EXECUTEENTER_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeEnter] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeRefresh definito in un ExecCommand del
	 * ContentPanel cpHome
	 */
	public ExecResults executeRefresh(

			it.csi.taif.taifweb.dto.home.CpHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEREFRESH_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String EXECUTEREFRESH_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1890053296) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("---------- Home EXECUTE Refresh --------------");
			// impostazione del result code 
			result.setResultCode(EXECUTEREFRESH_OUTCOME_CODE__OK);

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
	 * permette di resettare lo stato di paginazione della tabella widg_tElencoAziendeAAEP
	 */
	public static void resetClearStatus_widg_tElencoAziendeAAEP(java.util.Map session) {
		session.put("cpHome_tElencoAziendeAAEP_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tElencoDomande
	 */
	public static void resetClearStatus_widg_tElencoDomande(java.util.Map session) {
		session.put("cpHome_tElencoDomande_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tElencoDomandeFr
	 */
	public static void resetClearStatus_widg_tElencoDomandeFr(java.util.Map session) {
		session.put("cpHome_tElencoDomandeFr_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1358798737) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private DummyMgr dummyMgr = null;
	private TaifMgr taifMgr = null;

	public DummyMgr getDummyMgr() {
		return dummyMgr;
	}

	public void setDummyMgr(DummyMgr dummyMgr) {
		this.dummyMgr = dummyMgr;
	}

	/**
	 * @return the taifMgr
	 */
	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	/**
	 * @param taifMgr the taifMgr to set
	 */
	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	private TreeNode loadTreeElencoAziende(ArrayList<CodeDescription> elencoAziende) throws ManagerException {

		//ArrayList<CodeDescription> elencoAziende = this.dummyMgr.getElencoAziende();

		final TreeNode node = new TreeNodeBase("root", "root", false);
		for (CodeDescription cd : elencoAziende) {
			final TreeNodeBase nodeAzienda = new TreeNodeBase(cd.getCode(), cd.getDescription(), true);
			node.getChildren().add(nodeAzienda);
		}

		return node;
	}

	@Deprecated
	private TaifTPersonaByProfiloPersonaDto getProfiloPersonaAzienda(UserInfo userInfo) throws DbManagerException {

		ConfigProfiloFilter profiloAzienda = getConfigProfiloUtenteAzienda();

		int idProfilo = this.taifMgr.getProfiloUtenteByProcedura(profiloAzienda).getIdProfilo();
		ConfigProfiloPersona configFilter = getConfigProfiloPersona(userInfo.getCodFisc(), idProfilo);
		TaifTPersonaByProfiloPersonaDto personaprofiloAzienda = this.taifMgr
				.getPersonaByCodiceFiscaleandProfilo(configFilter);
		return personaprofiloAzienda;
	}

	private ConfigProfiloFilter getConfigProfiloUtenteAzienda() {
		ConfigProfiloFilter profiloAzienda = new ConfigProfiloFilter();
		profiloAzienda.setFlagAttivo(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		profiloAzienda.setIdProcedura(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		profiloAzienda.setProfiloUtente(it.csi.taif.taifweb.business.dao.util.Constants.profiloAzienda);
		return profiloAzienda;
	}

	private ConfigProfiloPersona getConfigProfiloPersona(String codiceFiscalePersona, int idProfilo) {
		ConfigProfiloPersona configFilter = new ConfigProfiloPersona();
		configFilter.setCodiceFiscale(codiceFiscalePersona);
		configFilter.setIdProfiloUtente(idProfilo);
		return configFilter;
	}

	private ConfigProfiloFilter getConfigProfiloUtente(it.csi.taif.taifweb.dto.home.CpHomeModel theModel, int nazione) {
		ConfigProfiloFilter configProfiloFilter = new ConfigProfiloFilter();
		configProfiloFilter.setCodiceFiscale(theModel.getAppDatacurrentUser().getCodFisc());
		configProfiloFilter.setFlagAttivo(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		configProfiloFilter.setIdProcedura(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		if (nazione == 1) {
			configProfiloFilter.setDataTracciato("I");
		} else {
			configProfiloFilter.setDataTracciato("F");
		}
		return configProfiloFilter;
	}

	private void setVisibility(it.csi.taif.taifweb.dto.home.CpHomeModel theModel) {
		// TODO Auto-generated method stub
		try {

			final String FP_ELENCODOMANDE = "fpElencoDomande";
			final String FP_ELENCODOMANDE_FR = "fpElencoDomandeFr";

			CpHomeAction action = new CpHomeAction();
			action.setSession(theModel.getSession());

			String tipoAccesso = theModel.getAppDatacurrentUser().getTipoAccesso();
			if (tipoAccesso == null) {
				tipoAccesso = "1"; // only for Test mm
			}

			String mpActivate = null;
			String fpActivate = null;

			String mpDeactivate = null;

			if (tipoAccesso != null) {
				int idTipoAccesso = Integer.parseInt(tipoAccesso);
				switch (idTipoAccesso) {
					case 1 :
					case 3 :
						mpActivate = MULTIPANEL_MPELENCODOMANDE;
						fpActivate = FP_ELENCODOMANDE;

						mpDeactivate = MULTIPANEL_MPELENCODOMANDEFR;

						break;
					case 2 :
					case 4 :
						mpActivate = MULTIPANEL_MPELENCODOMANDEFR;
						fpActivate = FP_ELENCODOMANDE_FR;

						mpDeactivate = MULTIPANEL_MPELENCODOMANDE;

						break;

					default :
						break;
				}
			}

			ActivateMultiPanelItemCommand activate = new ActivateMultiPanelItemCommand(CPNAME, mpActivate, fpActivate);
			activate.doCommand(action);

			ActivateMultiPanelItemCommand deActivate = new ActivateMultiPanelItemCommand(CPNAME, mpDeactivate, null);
			deActivate.doCommand(action);

			ArrayList<AziendaAAEP> aaep = theModel.getAppDataelencoAziendeAAEP();
			if (aaep != null && !aaep.isEmpty()) {
				ActivateMultiPanelItemCommand activateAAEP = new ActivateMultiPanelItemCommand(CPNAME,
						MULTIPANEL_MPAZIENDEAAEP, "fpAziendeAAEP");
				activateAAEP.doCommand(action);
			} else {
				ActivateMultiPanelItemCommand deActivateAAEP = new ActivateMultiPanelItemCommand(CPNAME,
						MULTIPANEL_MPAZIENDEAAEP, null);
				deActivateAAEP.doCommand(action);
			}

		} catch (Exception e) {
			log.error("Generic Error --> setVisibility CP HOME");
		}
	}

	/*PROTECTED REGION END*/
}
