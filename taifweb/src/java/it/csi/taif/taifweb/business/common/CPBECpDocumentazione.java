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

/*PROTECTED REGION ID(R1072683635) ENABLED START*/
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

// TAIF-29: itextpdf DEPRECATA sostituita con openpdf (lowagie)
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Font.FontFamily;
import com.lowagie.text.*;

import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.business.BEException;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfTipoAllegatoByAllegatoFilterDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPersonaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaAziendaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter;
import it.csi.taif.taifweb.business.dao.util.Constants;
import it.csi.taif.taifweb.business.helper.dto.factory.SvistaFactory;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.manager.validation.ValidationMgr;
import it.csi.taif.taifweb.business.manager.validation.Validator;
import it.csi.taif.taifweb.business.report.AttestazioneConfermaAosta;
import it.csi.taif.taifweb.business.report.AttestazioneConfermaLiguria;
import it.csi.taif.taifweb.business.report.AttestazioneConfermaPiemonte;
import it.csi.taif.taifweb.business.report.DichiarazioneSostitutivaAosta;
import it.csi.taif.taifweb.business.report.DichiarazioneSostitutivaLiguria;
import it.csi.taif.taifweb.business.report.DichiarazioneSostitutivaPiemonte;
import it.csi.taif.taifweb.business.report.DomandaIscrizioneLiguria;
import it.csi.taif.taifweb.business.report.DomandaIscrizionePiemonte;
import it.csi.taif.taifweb.business.report.DomandaIscrizioneValeAosta;
import it.csi.taif.taifweb.business.report.InscriptionAnnuaireInformaProvence;
import it.csi.taif.taifweb.business.report.InscriptionAnnuaireInformaRhonesAlpes;
import it.csi.taif.taifweb.dto.ExecResults;
import it.csi.taif.taifweb.dto.allegato.Allegato;
import it.csi.taif.taifweb.dto.allegatodownload.AllegatoDownload;
import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.common.CpDocumentazioneModel;
import it.csi.taif.taifweb.dto.common.ProfiloUtenteTaif;
import it.csi.taif.taifweb.dto.domanda.Riepilogo;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;

/*PROTECTED REGION END*/

public class CPBECpDocumentazione {

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

	// ApplicationData: [elencoTipologieAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOLOGIEALLEGATI_CODE = "appDataelencoTipologieAllegati";

	// ApplicationData: [elencoAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATI_CODE = "appDataelencoAllegati";

	// ApplicationData: [allegato, scope:USER_SESSION]
	public static final String APPDATA_ALLEGATO_CODE = "appDataallegato";

	// ApplicationData: [elencoSottotipologieAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSOTTOTIPOLOGIEALLEGATI_CODE = "appDataelencoSottotipologieAllegati";

	// ApplicationData: [idAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDALLEGATOSELEZIONATO_CODE = "appDataidAllegatoSelezionato";

	// ApplicationData: [idSottotipologiaAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDSOTTOTIPOLOGIAALLEGATOSELEZIONATO_CODE = "appDataidSottotipologiaAllegatoSelezionato";

	// ApplicationData: [idTipologiaAllegatoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOLOGIAALLEGATOSELEZIONATO_CODE = "appDataidTipologiaAllegatoSelezionato";

	// ApplicationData: [elencoDenominazioneTipoAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCODENOMINAZIONETIPOALLEGATI_CODE = "appDataelencoDenominazioneTipoAllegati";

	// ApplicationData: [elencoAllegatiDownload, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALLEGATIDOWNLOAD_CODE = "appDataelencoAllegatiDownload";

	// ApplicationData: [elencoTipologieAllegatiDownload, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOLOGIEALLEGATIDOWNLOAD_CODE = "appDataelencoTipologieAllegatiDownload";

	// ApplicationData: [idTipologiaAllegatoDownloadSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDTIPOLOGIAALLEGATODOWNLOADSELEZIONATO_CODE = "appDataidTipologiaAllegatoDownloadSelezionato";

	// ApplicationData: [albo, scope:USER_SESSION]
	public static final String APPDATA_ALBO_CODE = "appDataalbo";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [idPratica, scope:USER_SESSION]
	public static final String APPDATA_IDPRATICA_CODE = "appDataidPratica";

	// ApplicationData: [domandaRiepilogo, scope:USER_SESSION]
	public static final String APPDATA_DOMANDARIEPILOGO_CODE = "appDatadomandaRiepilogo";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "CpDocumentazione";

	public static final String MULTIPANEL_MPELENCOALLEGATIFIRMATI = "mpElencoAllegatiFirmati";
	public static final String MPI_MPELENCOALLEGATIFIRMATI_FPELENCOALLEGATIFIRMATI = CPNAME + "_"
			+ MULTIPANEL_MPELENCOALLEGATIFIRMATI + "_" + "fpElencoAllegatiFirmati";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadAllegatiDownload definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults loadAllegatiDownload(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADALLEGATIDOWNLOAD_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String LOADALLEGATIDOWNLOAD_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R929510951) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			tipoAllegatoFilter = this.getTipoAllegatoFilter(theModel);
			tipoAllegatoFilter.setFlagDownload(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
			tipoAllegatoFilter.setFlagUplod(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.zero));

			//  impostato di default a contesto domanda = D. definire come segliere il contesto tra C e D

			//tipoAllegatoFilter.setFlagContesto(it.csi.taif.taifweb.business.dao.util.Constants.contestoDomanda);

			Riepilogo riepilogo = theModel.getAppDatadomandaRiepilogo();

			if (riepilogo.getIdStatoDomanda() == 1) {
				tipoAllegatoFilter.setFlagContesto(it.csi.taif.taifweb.business.dao.util.Constants.contestoDomanda);
			} else {
				tipoAllegatoFilter.setFlagContesto(it.csi.taif.taifweb.business.dao.util.Constants.contestoConferma);
			}

			tipoAllegatoFilter.setFlagFirma(theModel.getAppDataidTipologiaAllegatoDownloadSelezionato());

			ArrayList<AllegatoDownload> listAllegatoDownload = new ArrayList<AllegatoDownload>();
			ArrayList<TaifCnfTipoAllegatoByAllegatoFilterDto> listCnfSottoTipoAllegato = taifMgr
					.getTipoFirmaAllegati(tipoAllegatoFilter);
			for (TaifCnfTipoAllegatoByAllegatoFilterDto sottoTipoAllegatoDto : listCnfSottoTipoAllegato) {
				AllegatoDownload download = new AllegatoDownload();
				download.setIdTipoAllegato(sottoTipoAllegatoDto.getIdTipoAllegato());
				download.setNomeFile(sottoTipoAllegatoDto.getTipoAllegato());
				listAllegatoDownload.add(download);
			}

			theModel.setAppDataelencoAllegatiDownload(listAllegatoDownload);

			ActionContext.getContext().getSession().put("idAzienda", theModel.getAppDataidAzienda());
			ActionContext.getContext().getSession().put("idPratica", theModel.getAppDataidPratica());
			ActionContext.getContext().getSession().put("flagFirma", tipoAllegatoFilter.getFlagFirma());
			ActionContext.getContext().getSession().put("dataTracciato", theModel.getAppDatatracciato());

			// impostazione del result code 
			result.setResultCode(LOADALLEGATIDOWNLOAD_OUTCOME_CODE__SI);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadAllegatiDownload] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadSottoTipoAllegato definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults loadSottoTipoAllegato(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADSOTTOTIPOALLEGATO_OUTCOME_CODE__SI = //NOSONAR  Reason:EIAS
				"SI"; //NOSONAR  Reason:EIAS
		final String LOADSOTTOTIPOALLEGATO_OUTCOME_CODE__NO = //NOSONAR  Reason:EIAS
				"NO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R436100342) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.setAppDataelencoSottotipologieAllegati(this.getElencoSottoTipoAllegato(theModel));

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			// impostazione del result code 
			if (theModel.getAppDataidTipologiaAllegatoSelezionato() == null
					|| theModel.getAppDataidTipologiaAllegatoSelezionato().equalsIgnoreCase("")) {
				result.setResultCode(LOADSOTTOTIPOALLEGATO_OUTCOME_CODE__NO);
				return result;
			} else {
				result.setResultCode(LOADSOTTOTIPOALLEGATO_OUTCOME_CODE__SI);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadSottoTipoAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadAllegato definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults loadAllegato(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADALLEGATO_OUTCOME_CODE__OK_ALLEGATI_NON_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_NON_PRESENTI"; //NOSONAR  Reason:EIAS
		final String LOADALLEGATO_OUTCOME_CODE__OK_ALLEGATI_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_PRESENTI"; //NOSONAR  Reason:EIAS
		final String LOADALLEGATO_OUTCOME_CODE__OK_ALLEGATI_OBBLIGATORI_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_OBBLIGATORI_PRESENTI"; //NOSONAR  Reason:EIAS
		final String LOADALLEGATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String LOADALLEGATO_OUTCOME_CODE__FORMATO_KO = //NOSONAR  Reason:EIAS
				"FORMATO_KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1613267081) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				//				String extensionFile = theModel.getWidg_updFileContentType();
				//				if (extensionFile != null && !extensionFile.equalsIgnoreCase("")) {
				//					extensionFile = extensionFile.substring(extensionFile.length() - 3, extensionFile.length());
				//				}
				String extensionFile = org.apache.commons.lang3.StringUtils
						.substringAfterLast(theModel.getWidg_updFileFileName(), ".");
				tipoAllegatoFilter.setEstensioneFile(extensionFile);
				ProfiloUtenteTaif put = theModel.getAppDatacurrentUser().getProfiloUtenteTaif();

				this.validationMgr.validazioneDocumentazioneAllegati(theModel, tipoAllegatoFilter);
				Allegato allegato = new Allegato();
				allegato.setIdTipoAllegato(new Integer(theModel.getAppDataidSottotipologiaAllegatoSelezionato()));
				allegato.setNomeFile(theModel.getWidg_updFileFileName());
				allegato.setDimensioneFileKb(ConvertUtil.convertToString(theModel.getWidg_updFile().length()));
				this.taifMgr.uploadFile(theModel.getAppDataidPratica(), allegato, put.getIdConfigUtente(),
						theModel.getWidg_updFile());

				result.setResultCode(this.getElencoAllegati(theModel, LOADALLEGATO_OUTCOME_CODE__OK_ALLEGATI_PRESENTI,
						LOADALLEGATO_OUTCOME_CODE__OK_ALLEGATI_NON_PRESENTI,
						LOADALLEGATO_OUTCOME_CODE__OK_ALLEGATI_OBBLIGATORI_PRESENTI));

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, LOADALLEGATO_OUTCOME_CODE__FORMATO_KO);
				return result;
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadAllegato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onTableClick definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults onTableClick(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONTABLECLICK_OUTCOME_CODE__VIEW = //NOSONAR  Reason:EIAS
				"VIEW"; //NOSONAR  Reason:EIAS
		final String ONTABLECLICK_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R268085231) ENABLED START*/
			String resultCode = ONTABLECLICK_OUTCOME_CODE__VIEW;
			// inserire qui la logica applicativa da eseguire:
			String idColonna = theModel.getIdColonna();
			String idAllegatoSelezionato = theModel.getIdRiga();

			log.debug("+++++++++++++++ ID ALLEGATO SELEZIONATO +++++++++++ *" + idAllegatoSelezionato + "*");
			theModel.getSession().put(it.csi.taif.taifweb.util.Constants.INDEX_ID_ALLEGATO_SELEZIONATO,
					idAllegatoSelezionato);

			if (it.csi.taif.taifweb.util.Constants.ICONA_CANCELLA.equalsIgnoreCase(idColonna)) {
				resultCode = ONTABLECLICK_OUTCOME_CODE__DELETE;
			}
			// impostazione del result code 
			result.setResultCode(resultCode);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onTableClick] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo goBackDocumentazione definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults goBackDocumentazione(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GOBACKDOCUMENTAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1488591832) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(GOBACKDOCUMENTAZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::goBackDocumentazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inviaDomanda definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults inviaDomanda(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVIADOMANDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String INVIADOMANDA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1189909723) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			//			TaifTPersonaProfiloUtenteByCodiceFiscaleDto profiloUtente = (TaifTPersonaProfiloUtenteByCodiceFiscaleDto) ActionContext
			//					.getContext().getSession().get("profiloUtente");

			//			this.taifMgr.cambiaStato(theModel.getAppDataidPratica(),
			//					it.csi.taif.taifweb.util.Constants.STATO_PRESENTATA, theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdConfigUtente());

			this.taifMgr.inviaDomanda(theModel.getAppDataidPratica(), theModel.getAppDatatracciato(),
					theModel.getAppDatacurrentUser().getProfiloUtenteTaif().getIdConfigUtente());

			theModel.getSession().put(it.csi.taif.taifweb.util.Constants.SESSION_INVIO_DOMANDA, "true");

			// impostazione del result code 
			result.setResultCode(INVIADOMANDA_OUTCOME_CODE__OK);
			//this.taifMgr

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inviaDomanda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo confermaInvioDocumentazione definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults confermaInvioDocumentazione(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMAINVIODOCUMENTAZIONE_OUTCOME_CODE__OKAZIENDA = //NOSONAR  Reason:EIAS
				"OkAzienda"; //NOSONAR  Reason:EIAS
		final String CONFERMAINVIODOCUMENTAZIONE_OUTCOME_CODE__OKGESTORE = //NOSONAR  Reason:EIAS
				"OkGestore"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1986842573) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(CONFERMAINVIODOCUMENTAZIONE_OUTCOME_CODE__OKAZIENDA);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaInvioDocumentazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaDocumento definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults eliminaDocumento(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINADOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		final String ELIMINADOCUMENTO_OUTCOME_CODE__OK_ALLEGATI_NON_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_NON_PRESENTI"; //NOSONAR  Reason:EIAS
		final String ELIMINADOCUMENTO_OUTCOME_CODE__OK_ALLEGATI_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_PRESENTI"; //NOSONAR  Reason:EIAS
		final String ELIMINADOCUMENTO_OUTCOME_CODE__OK_ALLEGATI_OBBLIGATORI_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_OBBLIGATORI_PRESENTI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R95430661) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				String idAllegato = (String) theModel.getSession()
						.get(it.csi.taif.taifweb.util.Constants.INDEX_ID_ALLEGATO_SELEZIONATO);
				this.taifMgr.deleteFile(idAllegato);

				result.setResultCode(
						this.getElencoAllegati(theModel, ELIMINADOCUMENTO_OUTCOME_CODE__OK_ALLEGATI_PRESENTI,
								ELIMINADOCUMENTO_OUTCOME_CODE__OK_ALLEGATI_NON_PRESENTI,
								ELIMINADOCUMENTO_OUTCOME_CODE__OK_ALLEGATI_OBBLIGATORI_PRESENTI));

			} catch (ManagerException e) {
				Validator.gestisciEccezione(result, e, ELIMINADOCUMENTO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-732282581) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			//theModel.setAppDataidSottotipologiaAllegatoSelezionato("");
			tipoAllegatoFilter = this.getTipoAllegatoFilter(theModel);

			/*			
						ArrayList<TaifCnfTipoAllegatoByAllegatoFilterDto> listCnfTipoAllegato = taifMgr.getTipoFirmaAllegati(visibileOrdinFilter);
						ArrayList<CodeDescription> elencoDenominazioneTipoAllegati = new ArrayList<CodeDescription>();
						for (TaifCnfTipoAllegatoByAllegatoFilterDto tipoAllegatoDto : listCnfTipoAllegato) {
							boolean presente = false;
							for (CodeDescription elem : listTipoAllegato) {
								if (elem.getCode().equalsIgnoreCase(tipoAllegatoDto.getFlagFirma())) {
									presente = true;
									break;
								}
							}
							if (!presente) {
								CodeDescription tipoAllegato = new CodeDescription();
								tipoAllegato.setCode("D");
								tipoAllegato.setDescription("DIGITALE");
								listTipoAllegato.add(tipoAllegato);
							}
							CodeDescription denomtipoAllegato = new CodeDescription();
							denomtipoAllegato.setCode(tipoAllegatoDto.getIdTipoAllegato() + "");
							denomtipoAllegato.setDescription(getDescriptionFromCode(tipoAllegatoDto.getTipoAllegato()));
							elencoDenominazioneTipoAllegati.add(denomtipoAllegato);
			
						}
			
						theModel.setAppDataelencoDenominazioneTipoAllegati(elencoDenominazioneTipoAllegati); */
			theModel.setAppDataelencoTipologieAllegati(getListaTipoFirmaDocumento());//listTipoAllegato
			theModel.setAppDataelencoTipologieAllegatiDownload(getListaTipoFirmaDocumento());//listTipoAllegato
			theModel.setAppDataelencoSottotipologieAllegati(getListaSottoTipoAllegato());//listSottoTipoAllegato

			// impostazione del result code 
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
	 * ContentPanel CpDocumentazione
	 */
	public ExecResults executeEnter(

			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXECUTEENTER_OUTCOME_CODE__OK_ALLEGATI_NON_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_NON_PRESENTI"; //NOSONAR  Reason:EIAS
		final String EXECUTEENTER_OUTCOME_CODE__OK_ALLEGATI_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_PRESENTI"; //NOSONAR  Reason:EIAS
		final String EXECUTEENTER_OUTCOME_CODE__OK_ALLEGATI_OBBLIGATORI_PRESENTI = //NOSONAR  Reason:EIAS
				"OK_ALLEGATI_OBBLIGATORI_PRESENTI"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1663434597) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			result.setResultCode(this.getElencoAllegati(theModel, EXECUTEENTER_OUTCOME_CODE__OK_ALLEGATI_PRESENTI,
					EXECUTEENTER_OUTCOME_CODE__OK_ALLEGATI_NON_PRESENTI,
					EXECUTEENTER_OUTCOME_CODE__OK_ALLEGATI_OBBLIGATORI_PRESENTI));

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tElencoDownloadAllegati
	 */
	public static void resetClearStatus_widg_tElencoDownloadAllegati(java.util.Map session) {
		session.put("CpDocumentazione_tElencoDownloadAllegati_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tElencoAllegati
	 */
	public static void resetClearStatus_widg_tElencoAllegati(java.util.Map session) {
		session.put("CpDocumentazione_tElencoAllegati_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R583707873) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	@Autowired
	private TipoAllegatoFilter tipoAllegatoFilter;

	@Autowired
	private TaifMgr taifMgr;

	@Autowired
	private ValidationMgr validationMgr;

	@Autowired
	private DomandaIscrizioneLiguria domandaIscrizioneLiguria;

	@Autowired
	private DomandaIscrizionePiemonte domandaIscrizionePiemonte;

	@Autowired
	private DomandaIscrizioneValeAosta domandaIscrizioneValeAosta;

	@Autowired
	private DichiarazioneSostitutivaPiemonte dichiarazioneSostitutivaPiemonte;

	@Autowired
	private DichiarazioneSostitutivaLiguria dichiarazioneSostitutivaLiguria;

	@Autowired
	private DichiarazioneSostitutivaAosta dichiarazioneSostitutivaAosta;

	@Autowired
	private AttestazioneConfermaLiguria attestazioneConfermaLiguria;

	@Autowired
	private AttestazioneConfermaPiemonte attestazioneConfermaPiemonte;

	@Autowired
	private AttestazioneConfermaAosta attestazioneConfermaAosta;

	@Autowired
	private InscriptionAnnuaireInformaRhonesAlpes inscriptionAnnuaireInformaRhonesAlpes;

	@Autowired
	private InscriptionAnnuaireInformaProvence inscriptionAnnuaireInformaProvence;

	public void setTipoAllegatoFilter(TipoAllegatoFilter tipoAllegatoFilter) {
		this.tipoAllegatoFilter = tipoAllegatoFilter;
	}
	public void setValidationMgr(ValidationMgr validationMgr) {
		this.validationMgr = validationMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	public void setDichiarazioneSostitutivaPiemonte(DichiarazioneSostitutivaPiemonte dichiarazioneSostitutivaPiemonte) {
		this.dichiarazioneSostitutivaPiemonte = dichiarazioneSostitutivaPiemonte;
	}

	public void setDichiarazioneSostitutivaLiguria(DichiarazioneSostitutivaLiguria dichiarazioneSostitutivaLiguria) {
		this.dichiarazioneSostitutivaLiguria = dichiarazioneSostitutivaLiguria;
	}

	public void setDichiarazioneSostitutivaAosta(DichiarazioneSostitutivaAosta dichiarazioneSostitutivaAosta) {
		this.dichiarazioneSostitutivaAosta = dichiarazioneSostitutivaAosta;
	}

	public void setAttestazioneConfermaLiguria(AttestazioneConfermaLiguria attestazioneConfermaLiguria) {
		this.attestazioneConfermaLiguria = attestazioneConfermaLiguria;
	}

	public void setAttestazioneConfermaPiemonte(AttestazioneConfermaPiemonte attestazioneConfermaPiemonte) {
		this.attestazioneConfermaPiemonte = attestazioneConfermaPiemonte;
	}

	public void setAttestazioneConfermaAosta(AttestazioneConfermaAosta attestazioneConfermaAosta) {
		this.attestazioneConfermaAosta = attestazioneConfermaAosta;
	}

	public void setDomandaIscrizioneLiguria(DomandaIscrizioneLiguria domandaIscrizioneLiguria) {
		this.domandaIscrizioneLiguria = domandaIscrizioneLiguria;
	}

	public void setDomandaIscrizionePiemonte(DomandaIscrizionePiemonte domandaIscrizionePiemonte) {
		this.domandaIscrizionePiemonte = domandaIscrizionePiemonte;
	}

	public void setDomandaIscrizioneValeAosta(DomandaIscrizioneValeAosta domandaIscrizioneValeAosta) {
		this.domandaIscrizioneValeAosta = domandaIscrizioneValeAosta;
	}

	public void setInscriptionAnnuaireInformaRhonesAlpes(
			InscriptionAnnuaireInformaRhonesAlpes inscriptionAnnuaireInformaRhonesAlpes) {
		this.inscriptionAnnuaireInformaRhonesAlpes = inscriptionAnnuaireInformaRhonesAlpes;
	}

	public void setInscriptionAnnuaireInformaProvence(
			InscriptionAnnuaireInformaProvence inscriptionAnnuaireInformaProvence) {
		this.inscriptionAnnuaireInformaProvence = inscriptionAnnuaireInformaProvence;
	}

	private TipoAllegatoFilter getTipoAllegatoFilter(CpDocumentazioneModel theModel) {
		tipoAllegatoFilter.setFlagItaFr(theModel.getAppDatatracciato());
		tipoAllegatoFilter.setFlagVisibile(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		tipoAllegatoFilter.setIdprocedura(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		//  AllegatoFilter.setFlagContesto(it.csi.taif.taifweb.business.dao.util.Constants.contestoDomanda);
		Riepilogo riepilogo = theModel.getAppDatadomandaRiepilogo();
		if (riepilogo.getIdStatoDomanda() == 1) {
			tipoAllegatoFilter.setFlagContesto(it.csi.taif.taifweb.business.dao.util.Constants.contestoDomanda);
		} else {
			tipoAllegatoFilter.setFlagContesto(it.csi.taif.taifweb.business.dao.util.Constants.contestoConferma);
		}
		tipoAllegatoFilter.setIdPratica(theModel.getAppDataidPratica());

		String flagFirma = null;
		List<Allegato> allegati = theModel.getAppDataelencoAllegati();
		if (allegati != null && !allegati.isEmpty()) {
			flagFirma = allegati.get(0).getFlagFirma();
		} else {
			flagFirma = theModel.getAppDataidTipologiaAllegatoSelezionato();
		}
		tipoAllegatoFilter.setFlagFirma(flagFirma);

		return tipoAllegatoFilter;

	}

	public static final Font BOLD_UNDERLINED = new Font(Font.TIMES_ROMAN, 12, Font.BOLD | Font.UNDERLINE);
	public static final Font NORMAL_ONE = new Font(Font.TIMES_ROMAN, 12);

	public static Font BOLD = new Font();
	public static Font NORMAL = new Font();

	private String getDescriptionFromCode(String cod) {
		if (cod != null) {
			if (cod.equalsIgnoreCase(it.csi.taif.taifweb.util.Constants.TIPO_FIRMA_DIGITALE)) {
				return it.csi.taif.taifweb.util.Constants.DESCR_TIPO_FIRMA_DIGITALE;
			} else if (cod.equalsIgnoreCase(it.csi.taif.taifweb.util.Constants.TIPO_FIRMA_AUTOGRAFA)) {
				return it.csi.taif.taifweb.util.Constants.DESCR_TIPO_FIRMA_AUTOGRAFA;
			}
		}
		return cod;
	}

	private String getDenominazioneFromId(String id, ArrayList<CodeDescription> elencoDenominazioneAllegati) {
		for (CodeDescription temp : elencoDenominazioneAllegati) {
			if (temp.getCode().equalsIgnoreCase(id)) {
				return temp.getDescription();
			}
		}
		return "";
	}

	private ArrayList<CodeDescription> gestisciComboDopoInserimento(
			ArrayList<CodeDescription> elencoSottotipologieAllegati, Integer idTipoAllegato) {
		for (int i = 0; i < elencoSottotipologieAllegati.size(); i++) {
			if (elencoSottotipologieAllegati.get(i).getCode().equalsIgnoreCase(idTipoAllegato + "")) {
				elencoSottotipologieAllegati.remove(i);
				break;
			}
		}
		return elencoSottotipologieAllegati;

	}

	private ArrayList<CodeDescription> getListaTipoFirmaDocumento() {

		ArrayList<CodeDescription> listTipoAllegato = new ArrayList<CodeDescription>();
		CodeDescription tipoAllegato2 = new CodeDescription();
		tipoAllegato2.setCode(it.csi.taif.taifweb.business.dao.util.Constants.dChar);
		tipoAllegato2.setDescription(it.csi.taif.taifweb.business.dao.util.Constants.DIGITALE);
		listTipoAllegato.add(tipoAllegato2);
		CodeDescription tipoAllegato3 = new CodeDescription();
		tipoAllegato3.setCode(it.csi.taif.taifweb.business.dao.util.Constants.aChar);
		tipoAllegato3.setDescription(it.csi.taif.taifweb.business.dao.util.Constants.AUTOGRAFA);
		listTipoAllegato.add(tipoAllegato3);

		return listTipoAllegato;
	}

	private ArrayList<CodeDescription> getListaSottoTipoAllegato() {

		ArrayList<CodeDescription> listSottoTipoAllegato = new ArrayList<CodeDescription>();
		CodeDescription tipoAllegato = new CodeDescription();
		tipoAllegato.setCode(it.csi.taif.taifweb.business.dao.util.Constants.blank);
		tipoAllegato.setDescription(getDescriptionFromCode(it.csi.taif.taifweb.business.dao.util.Constants.blank));
		listSottoTipoAllegato.add(tipoAllegato);

		return listSottoTipoAllegato;

	}

	public ByteArrayOutputStream makePdf(int idAzienda, int idPratica, String tipoFirma) throws ManagerException {

		try {

			PersonaAziendaFilter personaFilter = new PersonaAziendaFilter();
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			personaFilter.setIdAzienda(idAzienda);
			personaFilter.setIdConfigUtente(taifTAziendaDto.getFkConfigUtente());

			TaifTPraticaDto praticaIscritta = taifMgr.getPraticByIdPratica(idPratica);
			TaifTPersonaDto personaTitolareRapp = taifMgr.getRappLegaleFromAzienda(idAzienda);
			TaifTSoggettoGestoreDto soggettoGestore = taifMgr
					.getSoggettoGestoreById(praticaIscritta.getFkSoggettoGestore().intValue());
			String comuneSoggetoGestore = null;
			if (soggettoGestore.getIstatComune() != null) {
				comuneSoggetoGestore = taifMgr.getComuneByIstat(soggettoGestore.getIstatComune()).getNome();
			} else {
				comuneSoggetoGestore = soggettoGestore.getComuneEstero();
			}

			List<String> flagList = taifMgr.getListFlagSezionePerIdAzienda(idAzienda);

			String filePath = extractFilePath();
			if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.PIE)) {
				log.info("CPBECpDocumentazione::makePdf soggetto PIEMONTE");
				return domandaIscrizionePiemonte.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						flagList, soggettoGestore, comuneSoggetoGestore, tipoFirma, filePath);
			} else if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.LIG)) {
				log.info("CPBECpDocumentazione::makePdf soggetto LIGURIA");
				return domandaIscrizioneLiguria.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						flagList, soggettoGestore, comuneSoggetoGestore, tipoFirma, filePath);
			} else if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.VDA)) {
				log.info("CPBECpDocumentazione::makePdf soggetto VDA");
				return domandaIscrizioneValeAosta.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						flagList, soggettoGestore, comuneSoggetoGestore, tipoFirma, filePath);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ManagerException(new Message());
		}
		return null;

	}

	public ByteArrayOutputStream makeDichiarazionePdf(int idAzienda, int idPratica, String tipoFirma)
			throws ManagerException {
		try {
			PersonaAziendaFilter personaFilter = new PersonaAziendaFilter();
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			personaFilter.setIdAzienda(idAzienda);
			personaFilter.setIdConfigUtente(taifTAziendaDto.getFkConfigUtente());

			TaifTPraticaDto praticaIscritta = taifMgr.getPraticByIdPratica(idPratica);

			TaifTPersonaDto personaTitolareRapp = taifMgr.getRappLegaleFromAzienda(idAzienda);
			TaifTSoggettoGestoreDto soggettoGestore = taifMgr
					.getSoggettoGestoreById(praticaIscritta.getFkSoggettoGestore().intValue());

			String comuneNascitaEstero = personaTitolareRapp.getComuneEsteroNascita();
			Comune comuneNascita = null;
			Provincia provinciaNascita = null;
			if (StringUtils.isNotEmpty(comuneNascitaEstero)) {
				comuneNascita = SvistaFactory.createComuneEstero(comuneNascitaEstero);
				provinciaNascita = SvistaFactory.createProvinciaEstero();
			} else {
				comuneNascita = taifMgr.getComuneByIstat(personaTitolareRapp.getIstatComuneNascita());
				provinciaNascita = taifMgr.getProvinciaByIstat(personaTitolareRapp.getIstatComuneNascita());
			}

			Comune comuneResidenza = taifMgr.getComuneByIstat(personaTitolareRapp.getIstatComuneRes());
			Provincia provinciaResidenza = taifMgr.getProvinciaByIstat(personaTitolareRapp.getIstatComuneRes());

			if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.LIG)) {
				return dichiarazioneSostitutivaLiguria.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						comuneNascita, provinciaNascita, comuneResidenza, provinciaResidenza, tipoFirma);
			} else if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.PIE)) {
				return dichiarazioneSostitutivaPiemonte.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						comuneNascita, provinciaNascita, comuneResidenza, provinciaResidenza, tipoFirma);
			} else if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.VDA)) {
				return dichiarazioneSostitutivaAosta.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						comuneNascita, provinciaNascita, comuneResidenza, provinciaResidenza, tipoFirma);
			}

		} catch (Exception e) {
			e.getStackTrace();
			throw new ManagerException(new Message());
		}
		return null;

	}

	public ByteArrayOutputStream makeAttestazionePdf(int idAzienda, int idPratica, String tipoFirma)
			throws ManagerException {
		try {
			PersonaAziendaFilter personaFilter = new PersonaAziendaFilter();
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			personaFilter.setIdAzienda(idAzienda);
			personaFilter.setIdConfigUtente(taifTAziendaDto.getFkConfigUtente());

			TaifTPraticaDto praticaIscritta = taifMgr.getPraticByIdPratica(idPratica);
			TaifTPersonaDto personaTitolareRapp = taifMgr.getRappLegaleFromAzienda(idAzienda);
			TaifTSoggettoGestoreDto soggettoGestore = taifMgr
					.getSoggettoGestoreById(praticaIscritta.getFkSoggettoGestore().intValue());
			String comuneSoggetoGestore = null;
			if (soggettoGestore.getIstatComune() != null) {
				comuneSoggetoGestore = taifMgr.getComuneByIstat(soggettoGestore.getIstatComune()).getNome();
			} else {
				comuneSoggetoGestore = soggettoGestore.getComuneEstero();
			}
			String filePath = extractFilePath();
			if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.LIG)) {
				return attestazioneConfermaLiguria.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						soggettoGestore, comuneSoggetoGestore, tipoFirma, filePath);
			} else if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.PIE)) {
				return attestazioneConfermaPiemonte.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						soggettoGestore, comuneSoggetoGestore, tipoFirma, filePath);
			} else if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.VDA)) {
				return attestazioneConfermaAosta.createPdf(taifTAziendaDto, praticaIscritta, personaTitolareRapp,
						soggettoGestore, comuneSoggetoGestore, tipoFirma, filePath);
			}

		} catch (Exception e) {
			e.getStackTrace();
			throw new ManagerException(new Message());
		}
		return null;

	}

	public String getFileName(Integer idAzienda, Integer idPratica, String idTipoAllegato) throws DbManagerException {

		String fileNaleIscrizione = "";
		DateFormat df = new SimpleDateFormat("yyyy");
		TaifTPraticaDto praticaFindet = taifMgr.getPraticByIdPratica(idPratica);

		TaifTAziendaDto aziendaFindet = taifMgr.getAziendaById(idAzienda);

		if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.three))
				|| (idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.four))) {
			fileNaleIscrizione = aziendaFindet.getCodiceFiscale().concat(" - ")
					.concat(df.format(new Date()).concat(" - Conferma  iscrizione AIFO numero "))
					.concat(praticaFindet.getNumeroAlbo());

		} else if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.fiveStr))
				|| (idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.six))) {
			fileNaleIscrizione = aziendaFindet.getCodiceFiscale().concat(" - Dichiarazione requisiti");

		} else if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.one))
				|| (idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.two))) {
			fileNaleIscrizione = aziendaFindet.getCodiceFiscale().concat(" - Domanda Iscrizione Azienda");
		} else if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.elevenStr))
				|| (idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.twelveStr))) {
			fileNaleIscrizione = aziendaFindet.getNSiret().concat(" - Inscription annuelle transfrontalier");

		} else if ((idTipoAllegato.equals(it.csi.taif.taifweb.business.dao.util.Constants.eight))) {

			StringBuffer nomeFile = new StringBuffer();
			if (StringUtils.isNotEmpty(aziendaFindet.getCodiceFiscale())) {
				nomeFile.append(aziendaFindet.getCodiceFiscale());
			} else {
				nomeFile.append(aziendaFindet.getNSiret());
			}
			nomeFile.append(" - Scheda Azienda.pdf");
			fileNaleIscrizione = nomeFile.toString();

		}

		return fileNaleIscrizione;
	}

	/*
	<codice_fiscale_azienda> + " - " +  <anno> + " - Conferma  iscrizione AIFO numero " + <numero_albo>
	Es: BGTSGL62A03B111N  - 2018 - Conferma  iscrizione AIFO numero 313
	
	<codice_fiscale_azienda> + " - Dichiarazione requisiti"
	Es: BGTSGL62A03B111N  - Dichiarazione requisiti*/

	private String getElencoAllegati(it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel,
			final String allegatiPresenti, final String allegatiNonPresenti, final String allegatiObbligatoriPresenti)
			throws ManagerException {

		ArrayList<Allegato> allegati = this.taifMgr.getElencoAllegati(theModel.getAppDataidPratica());
		theModel.setAppDataelencoAllegati(allegati);
		if (allegati != null && allegati.size() > 0) {
			theModel.setAppDataidTipologiaAllegatoSelezionato(allegati.get(0).getFlagFirma());
			theModel.setAppDataelencoSottotipologieAllegati(this.getElencoSottoTipoAllegato(theModel));
			List<Integer> obbligatori = this.taifMgr
					.getAllegatiObbligatoriPerPratica(this.getTipoAllegatoFilter(theModel));
			if (obbligatori != null && !obbligatori.isEmpty()) {
				return allegatiPresenti;
			} else {
				return allegatiObbligatoriPresenti;
			}
		} else {
			return allegatiNonPresenti;
		}

	}

	public ByteArrayOutputStream makeDichiarazioneFrancesePdf(Integer idAzienda, Integer idPratica, String tipoFirma)
			throws ManagerException {
		try {

			PersonaAziendaFilter personaFilter = new PersonaAziendaFilter();
			TaifTAziendaDto taifTAziendaDto = taifMgr.getAziendaById(idAzienda);
			personaFilter.setIdAzienda(idAzienda);
			personaFilter.setIdConfigUtente(taifTAziendaDto.getFkConfigUtente());

			TaifTPraticaDto praticaIscritta = taifMgr.getPraticByIdPratica(idPratica);
			TaifTPersonaDto personaTitolareRapp = taifMgr.getRappLegaleFromAzienda(idAzienda);
			TaifTSoggettoGestoreDto soggettoGestore = taifMgr
					.getSoggettoGestoreById(praticaIscritta.getFkSoggettoGestore().intValue());

			String image = extractPictute();
			if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.RHA)) {
				//Inscription annuaire Informa
				return inscriptionAnnuaireInformaRhonesAlpes.createPdf(taifTAziendaDto, praticaIscritta,
						personaTitolareRapp, soggettoGestore, tipoFirma, image);
			} else if (soggettoGestore.getCodice().equalsIgnoreCase(Constants.PACA)) {
				return inscriptionAnnuaireInformaProvence.createPdf(taifTAziendaDto, praticaIscritta,
						personaTitolareRapp, soggettoGestore, tipoFirma, image);
			}

		} catch (Exception e) {
			e.getStackTrace();
			throw new ManagerException(new Message());
		}

		return null;
	}

	private String extractFilePath() {
		log.debug(" extractFilePath() : "
				+ (ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT));
		String filePath = ((ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT))
				.getRealPath("/WEB-INF/wingding.ttf");
		return filePath;
	}

	private String extractPictute() {
		String filePath = ((ServletContext) ActionContext.getContext().get(StrutsStatics.SERVLET_CONTEXT))
				.getRealPath("/WEB-INF/inscriptionPicture.jpeg");
		return filePath;
	}

	private ArrayList<CodeDescription> getElencoSottoTipoAllegato(
			it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel) throws ManagerException {
		tipoAllegatoFilter = this.getTipoAllegatoFilter(theModel);
		tipoAllegatoFilter.setFlagUplod(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.one));
		tipoAllegatoFilter.setFlagDownload(Integer.parseInt(it.csi.taif.taifweb.business.dao.util.Constants.zero));
		tipoAllegatoFilter.setFlagFirma(theModel.getAppDataidTipologiaAllegatoSelezionato());
		ArrayList<CodeDescription> listSottoTipoAllegato = new ArrayList<CodeDescription>();
		ArrayList<TaifCnfTipoAllegatoByAllegatoFilterDto> listCnfSottoTipoAllegato = taifMgr
				.getTipoFirmaAllegati(tipoAllegatoFilter);
		for (TaifCnfTipoAllegatoByAllegatoFilterDto sottoTipoAllegatoDto : listCnfSottoTipoAllegato) {
			CodeDescription sottoTipoAllegato = new CodeDescription();
			sottoTipoAllegato.setCode(sottoTipoAllegatoDto.getIdTipoAllegato() + "");
			sottoTipoAllegato.setDescription(sottoTipoAllegatoDto.getTipoAllegato());
			if (sottoTipoAllegatoDto
					.getIdTipoAllegato() != it.csi.taif.taifweb.business.dao.util.Constants.idTipoAllegatoMarcaDaBollo
					|| (sottoTipoAllegatoDto
							.getIdTipoAllegato() == it.csi.taif.taifweb.business.dao.util.Constants.idTipoAllegatoMarcaDaBollo
							&& theModel.getAppDataalbo()
									.getIdAlbo() == it.csi.taif.taifweb.util.Constants.ID_ALBO_VALLE_D_AOSTA)) {
				listSottoTipoAllegato.add(sottoTipoAllegato);
			}
		}

		if (listSottoTipoAllegato.size() == 0) {
			CodeDescription sottoTipoAllegato = new CodeDescription();
			sottoTipoAllegato.setCode("");
			sottoTipoAllegato.setDescription("");
			listSottoTipoAllegato.add(sottoTipoAllegato);
		}
		return listSottoTipoAllegato;
	}
	/*PROTECTED REGION END*/
}
