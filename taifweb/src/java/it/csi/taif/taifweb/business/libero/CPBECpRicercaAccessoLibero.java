/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.libero;

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

/*PROTECTED REGION ID(R-1916643469) ENABLED START*/
import com.opensymphony.xwork2.ActionContext;

import it.csi.iride2.policy.entity.Identita;
import it.csi.iride2.policy.exceptions.MalformedIdTokenException;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaRicercaAziendaAvanzataDto;
import it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.SoggettoGestoreFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter;
import it.csi.taif.taifweb.business.manager.DummyMgr;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import it.csi.taif.taifweb.dto.libero.CpRicercaAccessoLiberoModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.dozer.DozerBeanMapper;
import it.csi.taif.taifweb.exception.ManagerException;
/*PROTECTED REGION END*/

public class CPBECpRicercaAccessoLibero {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [elencoAlbiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBIRICERCAACCESSOLIBERO_CODE = "appDataelencoAlbiRicercaAccessoLibero";

	// ApplicationData: [elencoAlbiSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBISELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoAlbiSelezionatiRicercaAccessoLibero";

	// ApplicationData: [elencoAssociazioniCertificazioneRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONERICERCAACCESSOLIBERO_CODE = "appDataelencoAssociazioniCertificazioneRicercaAccessoLibero";

	// ApplicationData: [elencoAttivitaSvolteRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTERICERCAACCESSOLIBERO_CODE = "appDataelencoAttivitaSvolteRicercaAccessoLibero";

	// ApplicationData: [elencoCategorieImpresaRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESARICERCAACCESSOLIBERO_CODE = "appDataelencoCategorieImpresaRicercaAccessoLibero";

	// ApplicationData: [elencoComuniRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRICERCAACCESSOLIBERO_CODE = "appDataelencoComuniRicercaAccessoLibero";

	// ApplicationData: [elencoRisultatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAACCESSOLIBERO_CODE = "appDataelencoRisultatiRicercaAccessoLibero";

	// ApplicationData: [elencoSezioniRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONIRICERCAACCESSOLIBERO_CODE = "appDataelencoSezioniRicercaAccessoLibero";

	// ApplicationData: [idProvinciaSelezionatoRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_IDPROVINCIASELEZIONATORICERCAACCESSOLIBERO_CODE = "appDataidProvinciaSelezionatoRicercaAccessoLibero";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

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

	// ApplicationData: [elencoAttivitaSvolteSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTESELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero";

	// ApplicationData: [elencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONISELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero";

	// ApplicationData: [elencoCategorieImpresaSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESASELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero";

	// ApplicationData: [elencoSezioniSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONISELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoSezioniSelezionatiRicercaAccessoLibero";

	// ApplicationData: [titolareLegaleRappresentanteAzienda, scope:USER_SESSION]
	public static final String APPDATA_TITOLARELEGALERAPPRESENTANTEAZIENDA_CODE = "appDatatitolareLegaleRappresentanteAzienda";

	// ApplicationData: [elencoProvinceRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCERICERCAACCESSOLIBERO_CODE = "appDataelencoProvinceRicercaAccessoLibero";

	// ApplicationData: [idComuneSelezionatoRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESELEZIONATORICERCAACCESSOLIBERO_CODE = "appDataidComuneSelezionatoRicercaAccessoLibero";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaAccessoLibero";

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
	 * ContentPanel cpRicercaAccessoLibero
	 */
	public ExecResults loadComuni(

			it.csi.taif.taifweb.dto.libero.CpRicercaAccessoLiberoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCOMUNI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String LOADCOMUNI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1823616179) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			final String DEFAULT = "000";
			String idProvincia = theModel.getAppDataidProvinciaSelezionatoRicercaAccessoLibero();
			if (StringUtils.isNotEmpty(idProvincia) && !DEFAULT.equalsIgnoreCase(idProvincia)) {
				theModel.setAppDataelencoComuniRicercaAccessoLibero(
						this.taifMgr.getElencoComuniPerIstatProvincia(idProvincia));
			} else {
				theModel.setAppDataelencoComuniRicercaAccessoLibero(this.taifMgr.getElencoComuni());
			}
			// imp

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
	 * Implementazione del metodo ricercaAziende definito in un ExecCommand del
	 * ContentPanel cpRicercaAccessoLibero
	 */
	public ExecResults ricercaAziende(

			it.csi.taif.taifweb.dto.libero.CpRicercaAccessoLiberoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAAZIENDE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String RICERCAAZIENDE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1000164763) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				ArrayList<Azienda> listAziendaTrovate = this.ricercaAziendaByCriteria(theModel, true);
				theModel.setAppDataelencoRisultatiRicercaAccessoLibero(listAziendaTrovate);
				result.setResultCode(RICERCAAZIENDE_OUTCOME_CODE__OK);
			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, RICERCAAZIENDE_OUTCOME_CODE__KO);
			}
			// impostazione del result code 
			result.setResultCode(RICERCAAZIENDE_OUTCOME_CODE__OK);

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
	 * ContentPanel cpRicercaAccessoLibero
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.libero.CpRicercaAccessoLiberoModel theModel

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
			/*PROTECTED REGION ID(R787775019) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			///////////////////////////////////////////////////
			///////////////////////////////////////////////////
			///////////////////////////////////////////////////
			//theModel.getAppDatacurrentUser().getProfiloUtenteTaif().setIdSoggettoGestore(4);
			///////////////////////////////////////////////////
			///////////////////////////////////////////////////
			///////////////////////////////////////////////////
			///////////////////////////////////////////////////

			this.createFakeIdentita();

			String linguaDati = ConvertUtil
					.getLinguaFromTipoAccesso(new Integer(theModel.getAppDatacurrentUser().getTipoAccesso()));

			int idConfigUtente;
			if (ActionContext.getContext().getSession().get("idConfigUtente") != null) {
				String interConfigUtente = (String) ActionContext.getContext().getSession().get("idConfigUtente");
				idConfigUtente = Integer.parseInt(interConfigUtente);
			}

			visibileOrdinFilter = getVisibileOrdinFilter(theModel, linguaDati);
			soggettoGestoreFilter = getSoggettoGestoreFilter(theModel);

			theModel.setAppDataelencoAlbiRicercaAccessoLibero(taifMgr.getElencoAlbi(soggettoGestoreFilter));

			theModel.setAppDataelencoSezioniRicercaAccessoLibero(this.taifMgr.getElencoSezioni());

			theModel.setAppDataelencoCategorieImpresaRicercaAccessoLibero(
					this.taifMgr.getElencoCategorieImpresaRicerca(visibileOrdinFilter));
			theModel.setAppDataelencoAttivitaSvolteRicercaAccessoLibero(
					this.taifMgr.getElencoTipoAttivita(visibileOrdinFilter));

			theModel.setAppDataelencoAssociazioniCertificazioneRicercaAccessoLibero(
					this.taifMgr.getElencoAssociazioniCertificazioni(linguaDati));

			theModel.setAppDataelencoComuniRicercaAccessoLibero(this.taifMgr.getElencoComuni());
			theModel.setAppDataelencoProvinceRicercaAccessoLibero(
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
	/*PROTECTED REGION ID(R323511713) ENABLED START*/
	@Autowired
	private VisibileOrdinFilter visibileOrdinFilter;

	@Autowired
	private SoggettoGestoreFilter soggettoGestoreFilter;

	@Autowired
	private StatoPraticaFilter statoPraticaFilter;

	@Autowired
	private TaifMgr taifMgr;

	@Autowired
	private DummyMgr dummyMgr = null;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	public DozerBeanMapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}

	public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
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

	public void setVisibileOrdinFilter(VisibileOrdinFilter visibileOrdinFilter) {
		this.visibileOrdinFilter = visibileOrdinFilter;
	}

	public void setSoggettoGestoreFilter(SoggettoGestoreFilter soggettoGestoreFilter) {
		this.soggettoGestoreFilter = soggettoGestoreFilter;
	}

	public void setStatoPraticaFilter(StatoPraticaFilter statoPraticaFilter) {
		this.statoPraticaFilter = statoPraticaFilter;
	}

	private VisibileOrdinFilter getVisibileOrdinFilter(CpRicercaAccessoLiberoModel theModel, String linguaDati) {
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

	private SoggettoGestoreFilter getSoggettoGestoreFilter(CpRicercaAccessoLiberoModel theModel) {
		//		if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif() != null) {
		//			soggettoGestoreFilter
		//					.setIdSoggetto(theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore());
		//		}
		soggettoGestoreFilter.setIdSoggetto(0);
		soggettoGestoreFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		return soggettoGestoreFilter;
	}

	private StatoPraticaFilter getStatoPraticaFilter(CpRicercaAccessoLiberoModel theModel, String linguaDati) {
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

	private ArrayList<Azienda> ricercaAziendaByCriteria(CpRicercaAccessoLiberoModel theModel, boolean isRicercaLibera)
			throws ManagerException, ParseException {
		RicercaAziendaFilter ricercaAziendaFilter = new RicercaAziendaFilter();
		ArrayList<Azienda> aziendeList = new ArrayList<Azienda>();
		ricercaAziendaFilter.setIdRuolo(new Integer("1"));
		ricercaAziendaFilter.setTipoSede(new Integer("1"));
		//albo di appartenenza
		List<String> listAlboAppartenenza = new ArrayList<String>();
		if (ConvertUtil.checkListIsNullOrEmpty(theModel.getAppDataelencoAlbiSelezionatiRicercaAccessoLibero())) {
			for (int i = 0; i < theModel.getAppDataelencoAlbiSelezionatiRicercaAccessoLibero().size(); i++) {
				String id = theModel.getAppDataelencoAlbiSelezionatiRicercaAccessoLibero().get(i);
				listAlboAppartenenza.add(id);
			}
			ricercaAziendaFilter.setAlboAppartenenza(listAlboAppartenenza);
		} else {
			for (int i = 0; i < theModel.getAppDataelencoAlbiRicercaAccessoLibero().size(); i++) {
				String id = theModel.getAppDataelencoAlbiRicercaAccessoLibero().get(i).getCode();
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
		ricercaAziendaFilter.setIstatComune(theModel.getAppDataidComuneSelezionatoRicercaAccessoLibero());
		String istatProvincia = theModel.getAppDataidProvinciaSelezionatoRicercaAccessoLibero();
		if (StringUtils.isNotEmpty(istatProvincia)
				&& !Constants.NULL_VALUE_ISTAT_PROVINCIA.equalsIgnoreCase(istatProvincia)) {
			ricercaAziendaFilter.setIstatProvincia(istatProvincia);
		} else {
			ricercaAziendaFilter.setIstatProvincia(null);
		}
		ricercaAziendaFilter.setTitolare(theModel.getAppDatatitolareLegaleRappresentanteAzienda());
		ricercaAziendaFilter.setDenominazioneAzienda(theModel.getAppDatadenominazioneAzienda());

		/*		// stato pratica
				if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore())) {
					ricercaAziendaFilter.setStatoPratica(
							new Integer(theModel.getAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore()));
				} else if (ConvertUtil
						.checkIsNullOrEmpty(theModel.getAppDataidStatoPraticaSelezionatoRicercaAziendaGestore())) {
					ricercaAziendaFilter
							.setStatoPratica(new Integer(theModel.getAppDataidStatoPraticaSelezionatoRicercaAziendaGestore()));
				}*/

		// sezione
		List<String> listSezione = new ArrayList<String>();

		if (ConvertUtil.checkListIsNullOrEmpty(theModel.getAppDataelencoSezioniSelezionatiRicercaAccessoLibero())) {
			for (int i = 0; i < theModel.getAppDataelencoSezioniSelezionatiRicercaAccessoLibero().size(); i++) {
				String id = theModel.getAppDataelencoSezioniSelezionatiRicercaAccessoLibero().get(i);
				log.info("sezione " + i + ") " + id);
				listSezione.add(id);
			}
			ricercaAziendaFilter.setSezione(listSezione);
		}

		// categorie d'impresa
		List<String> listCategorieImpresa = new ArrayList<String>();

		if (ConvertUtil
				.checkListIsNullOrEmpty(theModel.getAppDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero())) {
			for (int i = 0; i < theModel.getAppDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero()
					.size(); i++) {
				String id = theModel.getAppDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero().get(i);
				listCategorieImpresa.add(id);
			}
			ricercaAziendaFilter.setListaCategoriaImpresa(listCategorieImpresa);
		}

		// Associazione e certificazione
		List<String> listAssociazioneCertificazione = new ArrayList<String>();

		if (ConvertUtil.checkListIsNullOrEmpty(
				theModel.getAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero())) {
			for (int i = 0; i < theModel.getAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero()
					.size(); i++) {
				String code = theModel.getAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero()
						.get(i);
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

		if (ConvertUtil
				.checkListIsNullOrEmpty(theModel.getAppDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero())) {
			for (int i = 0; i < theModel.getAppDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero().size(); i++) {
				Attivita attivita = new Attivita();
				attivita.setIdAttivita(
						new Integer(theModel.getAppDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero().get(i)));
				listAttivitaSvolte.add(attivita);
			}
			ricercaAziendaFilter.setAttivitaSvolteList(listAttivitaSvolte);
		}

		ricercaAziendaFilter.setRicercaLibera(true);
		List<TaifTAziendaRicercaAziendaAvanzataDto> elencoAziendeTrovate = this.taifMgr
				.ricercaAziende(ricercaAziendaFilter);

		for (TaifTAziendaRicercaAziendaAvanzataDto aziendaDto : elencoAziendeTrovate) {
			//aziendeList.add(dozerBeanMapper.map(aziendaDto, Azienda.class));
			Azienda azienda = new Azienda();
			azienda = convertFromDtoToObject(aziendaDto, theModel);
			aziendeList.add(azienda);
		}

		return aziendeList;
	}

	private Azienda convertFromDtoToObject(TaifTAziendaRicercaAziendaAvanzataDto aziendaDto,
			CpRicercaAccessoLiberoModel theModel) {
		Azienda azienda = new Azienda();
		//		String linguaDati = it.csi.taif.taifweb.business.dao.util.Constants.itaLang;
		//		if (theModel.getAppDatacurrentUser().getProfiloUtenteTaif() == null) {
		//			linguaDati = ConvertUtil
		//					.getLinguaFromTipoAccesso(new Integer(theModel.getAppDatacurrentUser().getTipoAccesso()));
		//		} else {
		//			linguaDati = ConvertUtil.getLinguaFromSoggettoGestore(
		//					theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdSoggettoGestore());
		//		}
		String linguaDati = ConvertUtil
				.getLinguaFromTipoAccesso(new Integer(theModel.getAppDatacurrentUser().getTipoAccesso()));
		//mm
		//if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getCodiceFiscaleAzienda())) {
		//	azienda.setCodiceFiscale(aziendaDto.getCodiceFiscaleAzienda());
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getPivaAzienda())) {
			azienda.setCodiceFiscale(aziendaDto.getPivaAzienda());
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

		return azienda;
	}

	private String getDenominazioneComuneFromCodiceIstat(String codiceIstatComune,
			CpRicercaAccessoLiberoModel theModel) {
		String denominazioneComune = "";
		for (CodeDescription element : theModel.getAppDataelencoComuniRicercaAccessoLibero()) {
			if (element.getCode().equalsIgnoreCase(codiceIstatComune)) {
				denominazioneComune = element.getDescription();
				break;
			}
		}
		return denominazioneComune;
	}

	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	public void createFakeIdentita() {

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
			log.error("[CPBECpLogin::createFakeHeader] " + e.toString(), e);
		}

	}

	/*PROTECTED REGION END*/
}
