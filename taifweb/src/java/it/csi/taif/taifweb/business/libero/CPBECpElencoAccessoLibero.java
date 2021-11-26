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

/*PROTECTED REGION ID(R1961163852) ENABLED START*/
import it.csi.taif.taifweb.business.manager.TaifMgr;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaByIdCategImpresaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaConteggioPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDettaglioAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaRicercaAziendaAvanzataDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoDettaglioMezzoByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaAltriAlbiByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel;
/*PROTECTED REGION END*/

public class CPBECpElencoAccessoLibero {

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

	// ApplicationData: [codFisPivaAzienda, scope:USER_SESSION]
	public static final String APPDATA_CODFISPIVAAZIENDA_CODE = "appDatacodFisPivaAzienda";

	// ApplicationData: [dataIscrizioneAlboAziendaA, scope:USER_SESSION]
	public static final String APPDATA_DATAISCRIZIONEALBOAZIENDAA_CODE = "appDatadataIscrizioneAlboAziendaA";

	// ApplicationData: [dataIscrizioneAlboAziendaDa, scope:USER_SESSION]
	public static final String APPDATA_DATAISCRIZIONEALBOAZIENDADA_CODE = "appDatadataIscrizioneAlboAziendaDa";

	// ApplicationData: [denominazioneAzienda, scope:USER_SESSION]
	public static final String APPDATA_DENOMINAZIONEAZIENDA_CODE = "appDatadenominazioneAzienda";

	// ApplicationData: [elencoAlbiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBIRICERCAACCESSOLIBERO_CODE = "appDataelencoAlbiRicercaAccessoLibero";

	// ApplicationData: [elencoAlbiSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBISELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoAlbiSelezionatiRicercaAccessoLibero";

	// ApplicationData: [elencoAssociazioniCertificazioneRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONERICERCAACCESSOLIBERO_CODE = "appDataelencoAssociazioniCertificazioneRicercaAccessoLibero";

	// ApplicationData: [elencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONISELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero";

	// ApplicationData: [elencoAttivitaSvolteRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTERICERCAACCESSOLIBERO_CODE = "appDataelencoAttivitaSvolteRicercaAccessoLibero";

	// ApplicationData: [elencoAttivitaSvolteSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTESELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero";

	// ApplicationData: [elencoCategorieImpresaRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESARICERCAACCESSOLIBERO_CODE = "appDataelencoCategorieImpresaRicercaAccessoLibero";

	// ApplicationData: [elencoCategorieImpresaSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESASELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero";

	// ApplicationData: [elencoComuniRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRICERCAACCESSOLIBERO_CODE = "appDataelencoComuniRicercaAccessoLibero";

	// ApplicationData: [elencoRisultatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAACCESSOLIBERO_CODE = "appDataelencoRisultatiRicercaAccessoLibero";

	// ApplicationData: [elencoSezioniRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONIRICERCAACCESSOLIBERO_CODE = "appDataelencoSezioniRicercaAccessoLibero";

	// ApplicationData: [elencoSezioniSelezionatiRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONISELEZIONATIRICERCAACCESSOLIBERO_CODE = "appDataelencoSezioniSelezionatiRicercaAccessoLibero";

	// ApplicationData: [idProvinciaSelezionatoRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_IDPROVINCIASELEZIONATORICERCAACCESSOLIBERO_CODE = "appDataidProvinciaSelezionatoRicercaAccessoLibero";

	// ApplicationData: [numeroAlboAzienda, scope:USER_SESSION]
	public static final String APPDATA_NUMEROALBOAZIENDA_CODE = "appDatanumeroAlboAzienda";

	// ApplicationData: [titolareLegaleRappresentanteAzienda, scope:USER_SESSION]
	public static final String APPDATA_TITOLARELEGALERAPPRESENTANTEAZIENDA_CODE = "appDatatitolareLegaleRappresentanteAzienda";

	// ApplicationData: [dettaglioAziendaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOAZIENDASELEZIONATA_CODE = "appDatadettaglioAziendaSelezionata";

	// ApplicationData: [idComuneSelezionatoRicercaAccessoLibero, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESELEZIONATORICERCAACCESSOLIBERO_CODE = "appDataidComuneSelezionatoRicercaAccessoLibero";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoAccessoLibero";

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
	 * Implementazione del metodo onTableClicked definito in un ExecCommand del
	 * ContentPanel cpElencoAccessoLibero
	 */
	public ExecResults onTableClicked(

			it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTABLECLICKED_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONTABLECLICKED_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2024714057) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Azienda azienda = new Azienda();

			// impostazione del result code 
			result.setResultCode(ONTABLECLICKED_OUTCOME_CODE__DETAIL);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			azienda = this.ricercaAziendaById(theModel.getIdRiga(), theModel);

			theModel.setAppDatadettaglioAziendaSelezionata(azienda);
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
	 * Implementazione del metodo exportRicercaAzienda definito in un ExecCommand del
	 * ContentPanel cpElencoAccessoLibero
	 */
	public ExecResults exportRicercaAzienda(

			it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPORTRICERCAAZIENDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String EXPORTRICERCAAZIENDA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R445295900) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//			String captcha = theModel.getWidg_tfVerificaCaptchaRicercaLibera();
			//			if (captcha != null && theModel.validateAnswerForWidg_captchaExportRicercaLibera(captcha)) {
			//				result.setResultCode(EXPORTRICERCAAZIENDA_OUTCOME_CODE__OK);
			//
			//				ArrayList<Azienda> list = theModel.getAppDataelencoRisultatiRicercaAccessoLibero();
			//				List<Integer> idAziendeTrovate = new ArrayList<Integer>();
			//				for (Azienda dto : list) {
			//					idAziendeTrovate.add(dto.getIdAzienda());
			//				}
			//				ActionContext.getContext().getSession().put("idAziendeTrovate", idAziendeTrovate);
			//			} else {
			//				result.getGlobalErrors().add("Il testo immesso NON corrisponde all'immagine");
			//				result.setResultCode(EXPORTRICERCAAZIENDA_OUTCOME_CODE__KO);
			//			}
			result.setResultCode(EXPORTRICERCAAZIENDA_OUTCOME_CODE__OK);
			ArrayList<Azienda> list = theModel.getAppDataelencoRisultatiRicercaAccessoLibero();
			List<Integer> idAziendeTrovate = new ArrayList<Integer>();
			for (Azienda dto : list) {
				idAziendeTrovate.add(dto.getIdAzienda());
			}
			ActionContext.getContext().getSession().put("idAziendeTrovate", idAziendeTrovate);
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::exportRicercaAzienda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo nuovaRicerca definito in un ExecCommand del
	 * ContentPanel cpElencoAccessoLibero
	 */
	public ExecResults nuovaRicerca(

			it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1784465461) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataelencoAlbiSelezionatiRicercaAccessoLibero(new ArrayList<String>());
			theModel.setAppDatanumeroAlboAzienda("");
			theModel.setAppDatadenominazioneAzienda("");
			theModel.setAppDatatitolareLegaleRappresentanteAzienda("");
			theModel.setAppDatacodFisPivaAzienda("");
			theModel.setAppDataidProvinciaSelezionatoRicercaAccessoLibero("");
			theModel.setAppDataidComuneSelezionatoRicercaAccessoLibero("");
			theModel.setAppDatadataIscrizioneAlboAziendaDa("");
			theModel.setAppDatadataIscrizioneAlboAziendaA("");
			theModel.setAppDataelencoSezioniSelezionatiRicercaAccessoLibero(new ArrayList<String>());
			theModel.setAppDataelencoCategorieImpresaSelezionatiRicercaAccessoLibero(new ArrayList<String>());
			theModel.setAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAccessoLibero(new ArrayList<String>());
			theModel.setAppDataelencoAttivitaSvolteSelezionatiRicercaAccessoLibero(new ArrayList<String>());
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
	 * Implementazione del metodo eliminaAziendaAccessoLibero definito in un ExecCommand del
	 * ContentPanel cpElencoAccessoLibero
	 */
	public ExecResults eliminaAziendaAccessoLibero(

			it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAAZIENDAACCESSOLIBERO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ELIMINAAZIENDAACCESSOLIBERO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1773752442) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(ELIMINAAZIENDAACCESSOLIBERO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaAziendaAccessoLibero] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoAziendeAccessoLibero
	 */
	public static void resetClearStatus_widg_tblElencoAziendeAccessoLibero(java.util.Map session) {
		session.put("cpElencoAccessoLibero_tblElencoAziendeAccessoLibero_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1712961186) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	@Autowired
	private TaifMgr taifMgr;

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	private Azienda ricercaAziendaById(String idRiga, CpElencoAccessoLiberoModel theModel) throws ManagerException {

		Azienda azienda = new Azienda();
		AziendaVisibleFilter aziendaFilter = new AziendaVisibleFilter();
		aziendaFilter.setIdAzienda(new Integer(idRiga));

		List<TaifTAziendaDettaglioAziendaByIdAziendaDto> aziendaTrovata = this.taifMgr.ricercaAziendeById(idRiga);

		List<TaifRPersonaAziendaConteggioPersonaDto> conteggioDto = this.taifMgr
				.conteggioNumeroAddettiByIdAzienda(idRiga);

		List<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto> categoriaDto = this.taifMgr
				.findDettaglioCategoriaImpresaByIdAzienda(idRiga);

		List<TaifTPraticaAltriAlbiByIdAziendaDto> altriAlbiDto = this.taifMgr.findAltriAlbiByIdAzienda(idRiga);

		List<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto> certificazioniDto = this.taifMgr
				.findDettaglioCertificazioniByIdAzienda(idRiga);

		List<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto> attivitaDto = this.taifMgr
				.findDettaglioAttivitaByIdAzienda(idRiga);

		List<TaifTMezzoDettaglioMezzoByIdAziendaDto> mezziDto = this.taifMgr.findDettaglioMezziIdAzienda(idRiga);

		azienda = convertFromDtoToObject(aziendaTrovata.get(0), conteggioDto.get(0), categoriaDto, altriAlbiDto,
				certificazioniDto, attivitaDto, mezziDto, theModel);

		return azienda;
	}

	private Azienda convertFromDtoToObject(TaifTAziendaDettaglioAziendaByIdAziendaDto aziendaDto,
			TaifRPersonaAziendaConteggioPersonaDto conteggioDto,
			List<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto> categoriaDto,
			List<TaifTPraticaAltriAlbiByIdAziendaDto> altriAlbiDto,
			List<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto> certificazioniDto,
			List<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto> attivitaDto,
			List<TaifTMezzoDettaglioMezzoByIdAziendaDto> mezziDto, CpElencoAccessoLiberoModel theModel) {

		String linguaDati = "";

		Azienda azienda = new Azienda();
		azienda.setIdAlbo(aziendaDto.getIdAlboAppartenenza());
		azienda.setDsAlbo(aziendaDto.getDsAlboAppartenenza());
		azienda.setNumeroAlbo(aziendaDto.getNumeroAlbo());
		if (aziendaDto.getIscrizioneAlbo() != null) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String data = df.format(aziendaDto.getIscrizioneAlbo());
			azienda.setDataIscrizioneAlbo(data);
		}
		azienda.setSezione(aziendaDto.getSezione());
		azienda.setIdAzienda(aziendaDto.getId());
		azienda.setDenominazione(aziendaDto.getDenominazioneAzienda());
		//mm
		//if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getCodiceFiscaleAzienda())
		//		|| ConvertUtil.checkIsNullOrEmpty(aziendaDto.getPivaAzienda())) { 
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getPivaAzienda())) {
			linguaDati = it.csi.taif.taifweb.business.dao.util.Constants.itaLang;
			azienda.setCodiceFiscale(aziendaDto.getPivaAzienda());
			azienda.setPartitaIva(aziendaDto.getPivaAzienda());
			azienda.setFormaGiuridica(aziendaDto.getFormagiuridicaita());
			azienda.setDsStato(aziendaDto.getDsStatoPraticaIta());
			azienda.setNumeroAddetti(conteggioDto.getConteggio() + "");
		} else {
			linguaDati = it.csi.taif.taifweb.business.dao.util.Constants.fraLang;
			azienda.setNSiret(aziendaDto.getNSiret());
			azienda.setNTva(aziendaDto.getNTva());
			azienda.setFormaGiuridica(aziendaDto.getFormagiuridicafra());
			azienda.setDsStato(aziendaDto.getDsStatoPraticaFra());
			azienda.setNbreSalaries(aziendaDto.getNbreSalariesFra() + "");
			azienda.setTempsPlein(aziendaDto.getTempsPleinFra() + "");
		}
		azienda.setTitolare(aziendaDto.getCognomeTitolare() + " " + aziendaDto.getNomeTitolare());
		azienda.setEmail(aziendaDto.getEmail());
		azienda.setSitoWeb(aziendaDto.getSitoWeb());
		azienda.setTelefono(aziendaDto.getTelefono());
		azienda.setSedeLegale(componiSedeLegale(aziendaDto, theModel));
		String categoria = "";
		for (TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto cat : categoriaDto) {
			if (ConvertUtil.checkIsNullOrEmpty(cat.getCategoriaImpresa())) {
				categoria = categoria + cat.getCategoriaImpresa() + " <br/>";
			}
		}
		azienda.setCategorie(categoria);
		String altriAlbi = "";
		for (TaifTPraticaAltriAlbiByIdAziendaDto albo : altriAlbiDto) {
			if (ConvertUtil.checkIsNullOrEmpty(albo.getAltroAlbo())) {
				altriAlbi = altriAlbi + albo.getAltroAlbo() + " <br/>";
			}
		}
		azienda.setAltriAlbi(altriAlbi);
		String certificazioni = "";
		for (TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto certificazione : certificazioniDto) {
			if (ConvertUtil.checkIsNullOrEmpty(certificazione.getTipoCertificazione())) {
				certificazioni = certificazioni + certificazione.getTipoCertificazione() + " <br/>";
			}
		}
		azienda.setCertificazioni(certificazioni);
		String attivita = "";
		for (TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto att : attivitaDto) {
			if (ConvertUtil.checkIsNullOrEmpty(att.getTipoAttivita())) {
				String tempAttivita = att.getTipoAttivita() + " " + "(" + att.getFatturato() + "%)";
				attivita = attivita + tempAttivita + " <br/>";
			}
		}
		azienda.setAttivita(attivita);
		String mezzi = "";
		for (TaifTMezzoDettaglioMezzoByIdAziendaDto mezzo : mezziDto) {
			if (ConvertUtil.checkIsNullOrEmpty(mezzo.getTipoMezzo())) {
				String tempMezzo = mezzo.getTipoMezzo() + " " + "(" + mezzo.getConteggio() + ")";
				mezzi = mezzi + tempMezzo + " <br/>";
			}
		}
		azienda.setMezzi(mezzi);

		return azienda;
	}

	private String componiSedeLegale(TaifTAziendaDettaglioAziendaByIdAziendaDto aziendaDto,
			CpElencoAccessoLiberoModel theModel) {
		String indirizzo = "";
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getIndirizzo())) {
			indirizzo = aziendaDto.getIndirizzo();
		}
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getCivico())) {
			indirizzo = indirizzo + ", " + aziendaDto.getCivico();
		}
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getCap())) {
			indirizzo = indirizzo + ", " + aziendaDto.getCap();
		}
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getIstatComuneSede())) {
			indirizzo = indirizzo + ", "
					+ getDenominazioneComuneFromCodiceIstat(aziendaDto.getIstatComuneSede(), theModel);
		}
		if (ConvertUtil.checkIsNullOrEmpty(aziendaDto.getComuneSedeEstero())) {
			indirizzo = indirizzo + ", " + aziendaDto.getComuneSedeEstero();
		}
		return indirizzo;
	}

	private String getDenominazioneComuneFromCodiceIstat(String codiceIstatComune,
			CpElencoAccessoLiberoModel theModel) {
		String denominazioneComune = "";
		for (CodeDescription element : theModel.getAppDataelencoComuniRicercaAccessoLibero()) {
			if (element.getCode().equalsIgnoreCase(codiceIstatComune)) {
				denominazioneComune = element.getDescription();
				break;
			}
		}
		return denominazioneComune;
	}

	/*PROTECTED REGION END*/
}
