/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.common;

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

/*PROTECTED REGION ID(R-449117178) ENABLED START*/
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter;
import it.csi.taif.taifweb.presentation.taifweb.action.common.CpRiepilogoAction;
import it.csi.taif.taifweb.business.manager.DummyMgr;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.validation.ValidationMgr;
import it.csi.taif.taifweb.business.manager.validation.Validator;
import it.csi.taif.taifweb.presentation.model.view.helper.VisibilityHelper;
import it.csi.taif.taifweb.presentation.taifweb.action.ActivateMultiPanelItemCommand;
import it.csi.taif.taifweb.presentation.taifweb.action.CommandExecutionException;
import it.csi.taif.taifweb.presentation.taifweb.action.VisibilityCommand;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.exception.ValidationException;

import com.google.api.client.repackaged.com.google.common.annotations.VisibleForTesting;
import com.opensymphony.xwork2.ActionContext;
/*PROTECTED REGION END*/

public class CPBECpRiepilogo {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [serviceUrl, scope:USER_SESSION]
	public static final String APPDATA_SERVICEURL_CODE = "appDataserviceUrl";

	// ApplicationData: [domandaRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_DOMANDARIEPILOGO_CODE = "appDatadomandaRiepilogo";

	// ApplicationData: [elencoStatiDomandaRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIDOMANDARIEPILOGO_CODE = "appDataelencoStatiDomandaRiepilogo";

	// ApplicationData: [idStatoDomandaRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_IDSTATODOMANDARIEPILOGO_CODE = "appDataidStatoDomandaRiepilogo";

	// ApplicationData: [statoDomanda, scope:USER_SESSION]
	public static final String APPDATA_STATODOMANDA_CODE = "appDatastatoDomanda";

	// ApplicationData: [albo, scope:USER_SESSION]
	public static final String APPDATA_ALBO_CODE = "appDataalbo";

	// ApplicationData: [idPratica, scope:USER_SESSION]
	public static final String APPDATA_IDPRATICA_CODE = "appDataidPratica";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [backDomanda, scope:USER_SESSION]
	public static final String APPDATA_BACKDOMANDA_CODE = "appDatabackDomanda";

	// ApplicationData: [elencoGestioneStatiRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_ELENCOGESTIONESTATIRIEPILOGO_CODE = "appDataelencoGestioneStatiRiepilogo";

	// ApplicationData: [elencoRisultatiRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAAZIENDAGESTORE_CODE = "appDataelencoRisultatiRicercaAziendaGestore";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "CpRiepilogo";

	public static final String MULTIPANEL_MPRIEPILOGOTABELLASTATI = "mpRiepilogoTabellaStati";
	public static final String MPI_MPRIEPILOGOTABELLASTATI_FPRIEPILOGOTABELLASTATI = CPNAME + "_"
			+ MULTIPANEL_MPRIEPILOGOTABELLASTATI + "_" + "fpRiepilogoTabellaStati";

	public static final String MULTIPANEL_MPRIEPILOGOGESTIONESTATODOMANDA = "mpRiepilogoGestioneStatoDomanda";
	public static final String MPI_MPRIEPILOGOGESTIONESTATODOMANDA_FPRIEPILOGOGESTIONESTATODOMANDA = CPNAME + "_"
			+ MULTIPANEL_MPRIEPILOGOGESTIONESTATODOMANDA + "_" + "fpRiepilogoGestioneStatoDomanda";

	public static final String MULTIPANEL_MPRIEPILOGOSTATODOMANDA = "mpRiepilogoStatoDomanda";
	public static final String MPI_MPRIEPILOGOSTATODOMANDA_FPRIEPILOGOSTATODOMANDA = CPNAME + "_"
			+ MULTIPANEL_MPRIEPILOGOSTATODOMANDA + "_" + "fpRiepilogoStatoDomanda";

	public static final String MULTIPANEL_MPRIEPILOGOMESSAGGIO = "mpRiepilogoMessaggio";
	public static final String MPI_MPRIEPILOGOMESSAGGIO_FPRIEPILOGOMESSAGGIO = CPNAME + "_"
			+ MULTIPANEL_MPRIEPILOGOMESSAGGIO + "_" + "fpRiepilogoMessaggio";

	public static final String MULTIPANEL_MPSCHEDAAZIENDA = "mpSchedaAzienda";
	public static final String MPI_MPSCHEDAAZIENDA_FPSCHEDAAZIENDA = CPNAME + "_" + MULTIPANEL_MPSCHEDAAZIENDA + "_"
			+ "fpSchedaAzienda";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo openModificaStato definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults openModificaStato(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String OPENMODIFICASTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String OPENMODIFICASTATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-705485414) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//theModel.setAppDataelencoStatiDomandaRiepilogo(this.dummyMgr.getElencoStatiDomanda());

			this.getElencoDettaglioStato(theModel);

			//			// FIXME da cancellare!!
			//			if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif() != null) {
			//				if (linguaDati.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.fraLang)) {
			//					theModel.setAppDataelencoStatiDomandaRiepilogo(
			//							taifMgr.getElencoStatiPraticaFra(statoPraticaFilter));
			//				} else {
			//					theModel.setAppDataelencoStatiDomandaRiepilogo(
			//							taifMgr.getElencoStatiPraticaIta(statoPraticaFilter));
			//				}
			//			} else {
			//				theModel.setAppDataelencoStatiDomandaRiepilogo(taifMgr.getElencoStatiPraticaIta(statoPraticaFilter));
			//			}

			// impostazione del result code 
			result.setResultCode(OPENMODIFICASTATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::openModificaStato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaStati definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults onClickTabellaStati(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLASTATI_OUTCOME_CODE__EDIT = //NOSONAR  Reason:EIAS
				"edit"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLASTATI_OUTCOME_CODE__SAVE = //NOSONAR  Reason:EIAS
				"save"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLASTATI_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"delete"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1039804406) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			int rownum = ConvertUtil.convertToInteger(theModel.getIdRiga());
			ArrayList<DettaglioStato> list = theModel.getAppDataelencoGestioneStatiRiepilogo();

			if (theModel.getIdColonna().equals(Constants.ICONA_MODIFICA)) {
				for (DettaglioStato dto : list) {
					if (dto.getRownum() == rownum) {
						dto.setEditing(true);
						dto.setStatoEditabile(false);
						dto.setNumeroProtocolloEditabile(true);
						dto.setDataProtocolloEditabile(true);
						dto.setNoteEditabile(true);
						break;
					}
				}

				result.setResultCode(ONCLICKTABELLASTATI_OUTCOME_CODE__EDIT);
			} else {
				if (theModel.getIdColonna().equals(Constants.ICONA_SALVA)) {
					result.setResultCode(ONCLICKTABELLASTATI_OUTCOME_CODE__SAVE);
					for (DettaglioStato dto : list) {
						if (dto.getRownum() == rownum) {

							// TODO Salvataggio sul db

							this.taifMgr.salvaStato(theModel.getAppDataidPratica(), dto,
									theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdConfigUtente());

							break;
						}
					}
				} else {
					result.setResultCode(ONCLICKTABELLASTATI_OUTCOME_CODE__DELETE);
					list.remove(rownum - 1);
				}

				this.getElencoDettaglioStato(theModel);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaStati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo chiudiTabellaStati definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults chiudiTabellaStati(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDITABELLASTATI_OUTCOME_CODE__OK_SCHEDA = //NOSONAR  Reason:EIAS
				"Ok_Scheda"; //NOSONAR  Reason:EIAS
		final String CHIUDITABELLASTATI_OUTCOME_CODE__OK_WIZARD = //NOSONAR  Reason:EIAS
				"Ok_Wizard"; //NOSONAR  Reason:EIAS
		final String CHIUDITABELLASTATI_OUTCOME_CODE__OK_SCHEDAWIZARD = //NOSONAR  Reason:EIAS
				"Ok_SchedaWizard"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1569357467) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Integer idPratica = theModel.getAppDataidPratica();
			Riepilogo r = this.taifMgr.getRiepilogoByPratica(idPratica);
			theModel.setAppDatadomandaRiepilogo(r);
			this.setVisibility(theModel, r);
			// impostazione del result code 
			result.setResultCode(this.getStatoRiepilogo(theModel));

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::chiudiTabellaStati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo addStato definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults addStato(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ADDSTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-398014789) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<DettaglioStato> list = theModel.getAppDataelencoGestioneStatiRiepilogo();

			theModel.getAppDataelencoGestioneStatiRiepilogo()
					.add(ListUtils.addNuovoStato(list.size() + 1, list.get(0).getElencoStatiDomanda()));

			// impostazione del result code 
			result.setResultCode(ADDSTATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::addStato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo modificaStatoTest definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults modificaStatoTest(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String MODIFICASTATOTEST_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String MODIFICASTATOTEST_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1970132546) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(MODIFICASTATOTEST_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::modificaStatoTest] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goBack definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults goBack(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOBACK_OUTCOME_CODE__AZIENDA = //NOSONAR  Reason:EIAS
				"Azienda"; //NOSONAR  Reason:EIAS
		final String GOBACK_OUTCOME_CODE__GESTORE = //NOSONAR  Reason:EIAS
				"Gestore"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1348787034) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code

			theModel.getSession().remove("currentContentPanel");
			result.setResultCode(this.executeGoBack(theModel));

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
	 * Implementazione del metodo chiudiRiepilogo definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults chiudiRiepilogo(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHIUDIRIEPILOGO_OUTCOME_CODE__AZIENDA = //NOSONAR  Reason:EIAS
				"Azienda"; //NOSONAR  Reason:EIAS
		final String CHIUDIRIEPILOGO_OUTCOME_CODE__GESTORE = //NOSONAR  Reason:EIAS
				"Gestore"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-634809785) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(this.executeGoBack(theModel));

			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::chiudiRiepilogo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goToDocumenti definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults goToDocumenti(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOTODOCUMENTI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String GOTODOCUMENTI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1663692472) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GOTODOCUMENTI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::goToDocumenti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1210528002) ENABLED START*/
			// impostazione del result code 

			ProfiloUtenteTaif put = this.taifMgr.getProfiloUtente(theModel.getAppDatacurrentUser().getCodFisc());
			theModel.getAppDatacurrentUser().setProfiloUtenteTaif(put);

			result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK);

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
	 * Implementazione del metodo executeEnter definito in un ExecCommand del
	 * ContentPanel CpRiepilogo
	 */
	public ExecResults executeEnter(

			it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEENTER_OUTCOME_CODE__OK_SCHEDA = //NOSONAR  Reason:EIAS
				"Ok_Scheda"; //NOSONAR  Reason:EIAS
		final String EXECUTEENTER_OUTCOME_CODE__OK_WIZARD = //NOSONAR  Reason:EIAS
				"Ok_Wizard"; //NOSONAR  Reason:EIAS
		final String EXECUTEENTER_OUTCOME_CODE__OK_SCHEDAWIZARD = //NOSONAR  Reason:EIAS
				"Ok_SchedaWizard"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-277271566) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("    ******** currentContentPanel *" + theModel.getSession().get("currentContentPanel") + "*");

			Integer idPratica = theModel.getAppDataidPratica();
			Riepilogo r = this.taifMgr.getRiepilogoByPratica(idPratica);

			theModel.setAppDatatracciato(GenericUtil.getTracciatoFromSoggettoGestore(r.getIdSoggettoGestore()));

			theModel.setAppDatadomandaRiepilogo(r);

			Albo albo = this.taifMgr.getAlboSogettoGestore(Integer.parseInt(r.getIdSoggettoGestore()));
			theModel.setAppDataalbo(albo);

			theModel.setAppDataidAzienda(r.getIdAzienda());

			this.setVisibility(theModel, r);
			this.cleanSession(theModel);

			ActionContext.getContext().getSession().put("riepilogo", r);
			theModel.setAppDatabackDomanda(Constants.BACK_DOMANDA_RIEPILOGO);
			// impostazione del result code 
			result.setResultCode(getStatoRiepilogo(theModel));

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			if (theModel.getSession().get(Constants.SESSION_INVIO_DOMANDA) != null) {
				theModel.getSession().remove(Constants.SESSION_INVIO_DOMANDA);
				result.getGlobalMessages().add(Constants.MSG_INVIO_DOMANDA);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::executeEnter] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoStatiDomanda
	 */
	public static void resetClearStatus_widg_tblElencoStatiDomanda(java.util.Map session) {
		session.put("CpRiepilogo_tblElencoStatiDomanda_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1777031400) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private DummyMgr dummyMgr;
	private TaifMgr taifMgr;
	private ValidationMgr validationMgr;

	public ValidationMgr getValidationMgr() {
		return validationMgr;
	}

	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public DummyMgr getDummyMgr() {
		return dummyMgr;
	}

	public void setDummyMgr(DummyMgr dummyMgr) {
		this.dummyMgr = dummyMgr;
	}

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	@Autowired
	private StatoPraticaFilter statoPraticaFilter;

	public void setStatoPraticaFilter(StatoPraticaFilter statoPraticaFilter) {
		this.statoPraticaFilter = statoPraticaFilter;
	}

	private StatoPraticaFilter getStatoPraticaFilter(CpRiepilogoModel theModel, String linguaDati) {
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

	private void setVisibility(it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel, Riepilogo r)
			throws CommandExecutionException {
		CpRiepilogoAction action = new CpRiepilogoAction();
		action.setSession(theModel.getSession());

		List<String> show = new ArrayList<String>();
		List<String> hide = new ArrayList<String>();

		boolean modificaStatoVisible = false;
		Integer tipoAccesso = ConvertUtil.convertToInteger(theModel.getAppDatacurrentUser().getTipoAccesso());
		if (tipoAccesso == null) {
			tipoAccesso = 4; // onlyFor Test MM
		}
		log.debug("**************** tipoAccesso ************ *" + tipoAccesso + "*");
		if (tipoAccesso == 5 || tipoAccesso == 6) {
			String idProfiloUtente = theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo();
			log.debug("**************** idProfiloUtente ************ *" + idProfiloUtente + "*");

			if (idProfiloUtente.equalsIgnoreCase("4") || idProfiloUtente.equalsIgnoreCase("5")) {
				modificaStatoVisible = true;
			}
		}

		if (modificaStatoVisible) {
			show.add("btnRiepilogoModificaStato");
		} else {
			hide.add("btnRiepilogoModificaStato");
		}

		if (r.getSchedeComplete() && r.getPulsanteDocumentiVisibile()) {
			show.add("btnRiepilogoDocumenti");
		} else {
			hide.add("btnRiepilogoDocumenti");
		}

		if (theModel.getSession().get(Constants.SESSION_INVIO_DOMANDA) != null) {
			show.add("btnRiepilogoChiudi");
			hide.add("btnRiepilogoIndietro");
		} else {
			hide.add("btnRiepilogoChiudi");
			show.add("btnRiepilogoIndietro");
		}
		if (r.getSchedeComplete()) {
			ActivateMultiPanelItemCommand activate = new ActivateMultiPanelItemCommand(CPNAME, "mpSchedaAzienda",
					"fpSchedaAzienda");
			activate.doCommand(action);
		} else {
			ActivateMultiPanelItemCommand activate = new ActivateMultiPanelItemCommand(CPNAME, "mpSchedaAzienda", null);
			activate.doCommand(action);
		}

		VisibilityCommand vcShow = new VisibilityCommand(show.toArray(new String[0]), true);
		vcShow.doCommand(action);

		VisibilityCommand vcHide = new VisibilityCommand(hide.toArray(new String[0]), false);
		vcHide.doCommand(action);

	}

	private String executeGoBack(it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel) throws ManagerException {

		String result = null;

		final String BACK_AZIENDA = "Azienda";
		final String BACK_GESTORE = "Gestore";

		String tipoAccesso = (String) theModel.getSession().get("tipoAccesso");

		Integer i = Integer.valueOf(tipoAccesso);

		switch (i) {
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_AZIENDA_FRA :
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_AZIENDA_ITA :
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_PROFESSIONISTA_FRA :
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_PROFESSIONISTA_ITA :
				result = BACK_AZIENDA;
				break;
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_FRA :
			case it.csi.taif.taifweb.business.dao.util.Constants.TIPO_ACCESSO_GESTORE_ITA :
				result = BACK_GESTORE;

				RicercaAziendaFilter aziendaFilter = (RicercaAziendaFilter) theModel.getSession()
						.get(Constants.SESSION_FILTRO_RICERCA_AZIENDE);
				theModel.setAppDataelencoRisultatiRicercaAziendaGestore(
						this.taifMgr.ricercaAziendeRiepilogo(aziendaFilter));

				break;
			default :
				result = BACK_AZIENDA;
				break;
		}

		return result;
	}

	private void getElencoDettaglioStato(it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel)
			throws ManagerException {

		String linguaDati = ConvertUtil.getFlagLinguaFromSoggettoGestore(
				theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore());

		theModel.setAppDataelencoGestioneStatiRiepilogo(
				this.taifMgr.getElencoDettaglioStato(theModel.getAppDataidPratica(), linguaDati));
	}

	private String getStatoRiepilogo(it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel) {
		final String WIZARD = "Ok_Wizard";
		final String SCHEDA = "Ok_Scheda";
		final String SCHEDAWIZARD = "Ok_SchedaWizard";

		String result = null;

		Integer tipoAccesso = ConvertUtil.convertToInteger(theModel.getAppDatacurrentUser().getTipoAccesso());
		if (tipoAccesso == null) {
			tipoAccesso = 4; // onlyFor Test MM
		}
		log.debug("**************** tipoAccesso ************ *" + tipoAccesso + "*");
		/*if (tipoAccesso == 5 || tipoAccesso == 6) {
			String idProfiloUtente = theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo();
			log.debug("**************** idProfiloUtente ************ *" + idProfiloUtente + "*");
		
			if (idProfiloUtente.equalsIgnoreCase("4") || idProfiloUtente.equalsIgnoreCase("5")) {
				result = SCHEDAWIZARD;
			}
		} else {*/
		Riepilogo r = theModel.getAppDatadomandaRiepilogo();

		int idStato = r.getIdStatoDomanda();

		switch (idStato) {
			case Constants.STATO_BOZZA :
			case Constants.STATO_DA_CONFERMARE :
			case Constants.STATO_PER_MANCATA_CONFERMA :
				result = WIZARD;
				break;
			case Constants.STATO_CANCELLATA :
			case Constants.STATO_CONFERMATA :
			case Constants.STATO_ISCRITTA :
			case Constants.STATO_NON_ACCOLTA :
			case Constants.STATO_PRESA_IN_CARICO :
			case Constants.STATO_PRESENTATA :
			case Constants.STATO_SOSPESA :
				result = SCHEDA;
				if (tipoAccesso == 5 || tipoAccesso == 6) {
					String idProfiloUtente = theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdProfilo();
					log.debug("**************** idProfiloUtente ************ *" + idProfiloUtente + "*");

					if (idProfiloUtente.equalsIgnoreCase("4") || idProfiloUtente.equalsIgnoreCase("5")) {
						result = SCHEDAWIZARD;
					}

				}
				break;
			default :
				result = WIZARD;
		}
		//}

		return result;
	}

	private void cleanSession(it.csi.taif.taifweb.dto.common.CpRiepilogoModel theModel) {
		// Sottotab di domanda
		theModel.getSession().remove("CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel");
		theModel.getSession().remove("CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel");
		theModel.getSession().remove("CpDomanda_wzpDomandaAttivita_selectedMultiPanel");
		theModel.getSession().remove("CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel");

		// Sezione 3.1
		theModel.getSession().remove("appDataelencoAttivitaUltimoAnno");
		theModel.getSession().remove("appDataattivitaUltimoAnnoSelezionate");
		theModel.getSession().remove("appDataattivitaUltimoAnno1");
		theModel.getSession().remove("appDataattivitaUltimoAnno2");
		theModel.getSession().remove("appDataattivitaUltimoAnno3");
		theModel.getSession().remove("appDataattivitaUltimoAnno4");
		theModel.getSession().remove("appDataattivitaUltimoAnno5");
		theModel.getSession().remove("appDataattivitaUltimoAnno6");
		theModel.getSession().remove("appDataattivitaUltimoAnno7");
		theModel.getSession().remove("appDataattivitaUltimoAnno8");
		theModel.getSession().remove("appDataattivitaUltimoAnno9");
		theModel.getSession().remove("appDataidAttivitaUltimoAnno");
		theModel.getSession().remove("appDataidAttivitaUltimoAnnoFr");
		theModel.getSession().remove("appDataelencoAttivitaUltimoAnnoFr");
		theModel.getSession().remove("appDatagestioneAttivitaUltimoAnno");
	}

	/*PROTECTED REGION END*/
}
