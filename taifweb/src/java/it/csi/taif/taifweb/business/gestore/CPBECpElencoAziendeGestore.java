/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.gestore;

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

/*PROTECTED REGION ID(R-648398017) ENABLED START*/

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import it.csi.taif.taifweb.business.common.ExportToExcel;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.business.manager.TaifMgr;
import it.csi.taif.taifweb.business.manager.message.Message;

/*PROTECTED REGION END*/

public class CPBECpElencoAziendeGestore {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [elencoRisultatiRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCORISULTATIRICERCAAZIENDAGESTORE_CODE = "appDataelencoRisultatiRicercaAziendaGestore";

	// ApplicationData: [elencoDomande, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOMANDE_CODE = "appDataelencoDomande";

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

	// ApplicationData: [elencoAlbiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBIRICERCAAZIENDA_CODE = "appDataelencoAlbiRicercaAzienda";

	// ApplicationData: [elencoAlbiSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOALBISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAlbiSelezionatiRicercaAzienda";

	// ApplicationData: [elencoAssociazioniCertificazioneRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONERICERCAAZIENDA_CODE = "appDataelencoAssociazioniCertificazioneRicercaAzienda";

	// ApplicationData: [elencoAssociazioniCertificazioniSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOASSOCIAZIONICERTIFICAZIONISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda";

	// ApplicationData: [elencoAttivitaSvolteRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTERICERCAAZIENDA_CODE = "appDataelencoAttivitaSvolteRicercaAzienda";

	// ApplicationData: [elencoAttivitaSvolteSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOATTIVITASVOLTESELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoAttivitaSvolteSelezionatiRicercaAzienda";

	// ApplicationData: [elencoCategorieImpresaRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESARICERCAAZIENDA_CODE = "appDataelencoCategorieImpresaRicercaAzienda";

	// ApplicationData: [elencoCategorieImpresaSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCATEGORIEIMPRESASELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoCategorieImpresaSelezionatiRicercaAzienda";

	// ApplicationData: [elencoComuniRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNIRICERCAAZIENDAGESTORE_CODE = "appDataelencoComuniRicercaAziendaGestore";

	// ApplicationData: [elencoSezioniRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONIRICERCAAZIENDA_CODE = "appDataelencoSezioniRicercaAzienda";

	// ApplicationData: [elencoSezioniSelezionatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEZIONISELEZIONATIRICERCAAZIENDA_CODE = "appDataelencoSezioniSelezionatiRicercaAzienda";

	// ApplicationData: [elencoSottostatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSOTTOSTATIRICERCAAZIENDA_CODE = "appDataelencoSottostatiRicercaAzienda";

	// ApplicationData: [elencoStatiRicercaAzienda, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSTATIRICERCAAZIENDA_CODE = "appDataelencoStatiRicercaAzienda";

	// ApplicationData: [idComuneSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDCOMUNESELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidComuneSelezionatoRicercaAziendaGestore";

	// ApplicationData: [idSottoStatoPraticaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSOTTOSTATOPRATICASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore";

	// ApplicationData: [idStatoPraticaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSTATOPRATICASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidStatoPraticaSelezionatoRicercaAziendaGestore";

	// ApplicationData: [numeroAlboAzienda, scope:USER_SESSION]
	public static final String APPDATA_NUMEROALBOAZIENDA_CODE = "appDatanumeroAlboAzienda";

	// ApplicationData: [numeroRisultatiRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_NUMERORISULTATIRICERCAAZIENDAGESTORE_CODE = "appDatanumeroRisultatiRicercaAziendaGestore";

	// ApplicationData: [titolareLegaleRappresentanteAzienda, scope:USER_SESSION]
	public static final String APPDATA_TITOLARELEGALERAPPRESENTANTEAZIENDA_CODE = "appDatatitolareLegaleRappresentanteAzienda";

	// ApplicationData: [idPratica, scope:USER_SESSION]
	public static final String APPDATA_IDPRATICA_CODE = "appDataidPratica";

	// ApplicationData: [idSoggettoGestore, scope:USER_SESSION]
	public static final String APPDATA_IDSOGGETTOGESTORE_CODE = "appDataidSoggettoGestore";

	// ApplicationData: [idProvinciaSelezionatoRicercaAziendaGestore, scope:USER_SESSION]
	public static final String APPDATA_IDPROVINCIASELEZIONATORICERCAAZIENDAGESTORE_CODE = "appDataidProvinciaSelezionatoRicercaAziendaGestore";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpElencoAziendeGestore";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo onClickTabellaElencoAziendeGestore definito in un ExecCommand del
	 * ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults onClickTabellaElencoAziendeGestore(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ONCLICKTABELLAELENCOAZIENDEGESTORE_OUTCOME_CODE__DETAIL = //NOSONAR  Reason:EIAS
				"DETAIL"; //NOSONAR  Reason:EIAS
		final String ONCLICKTABELLAELENCOAZIENDEGESTORE_OUTCOME_CODE__DELETE = //NOSONAR  Reason:EIAS
				"DELETE"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1462485263) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("ID COLONNA ????? " + theModel.getIdColonna());
			log.debug("ID RIGA ????? " + theModel.getIdRiga());

			String resultCode = ONCLICKTABELLAELENCOAZIENDEGESTORE_OUTCOME_CODE__DETAIL;
			theModel.setAppDataidPratica(Integer.valueOf(theModel.getIdRiga()));
			theModel.setAppDataidSoggettoGestore(getSoggettoGestoreFromId(theModel));
			String colonna = theModel.getIdColonna();

			if (Constants.ICONA_CANCELLA.equalsIgnoreCase(colonna)) {
				resultCode = ONCLICKTABELLAELENCOAZIENDEGESTORE_OUTCOME_CODE__DELETE;
				theModel.getSession().put(Constants.ID_AZIENDA_GESTORE_TO_DELETE, theModel.getIdRiga());
			}
			// impostazione del result code 
			result.setResultCode(resultCode);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::onClickTabellaElencoAziendeGestore] Errore occorso nell'esecuzione del metodo:"
					+ e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo exportRicercaAzienda definito in un ExecCommand del
	 * ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults exportRicercaAzienda(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String EXPORTRICERCAAZIENDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1082075977) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			//ActionContext.getContext().getSession().put("elencoAziendeTrovate",elencoAziendeTrovate);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".
			result.setResultCode(EXPORTRICERCAAZIENDA_OUTCOME_CODE__OK);
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
	 * ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults nuovaRicerca(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String NUOVARICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1715784968) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDataelencoAlbiSelezionatiRicercaAzienda(new ArrayList<String>());
			theModel.setAppDatanumeroAlboAzienda("");
			theModel.setAppDatadenominazioneAzienda("");
			theModel.setAppDatatitolareLegaleRappresentanteAzienda("");
			theModel.setAppDatacodFisPivaAzienda("");
			theModel.setAppDataidProvinciaSelezionatoRicercaAziendaGestore("");
			theModel.setAppDataidComuneSelezionatoRicercaAziendaGestore("");
			theModel.setAppDatadataIscrizioneAlboAziendaDa("");
			theModel.setAppDatadataIscrizioneAlboAziendaA("");
			theModel.setAppDataidStatoPraticaSelezionatoRicercaAziendaGestore("");
			theModel.setAppDataidSottoStatoPraticaSelezionatoRicercaAziendaGestore("");
			theModel.setAppDataelencoSezioniSelezionatiRicercaAzienda(new ArrayList<String>());
			theModel.setAppDataelencoCategorieImpresaSelezionatiRicercaAzienda(new ArrayList<String>());
			theModel.setAppDataelencoAssociazioniCertificazioniSelezionatiRicercaAzienda(new ArrayList<String>());
			theModel.setAppDataelencoAttivitaSvolteSelezionatiRicercaAzienda(new ArrayList<String>());
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
	 * Implementazione del metodo indietroRicerca definito in un ExecCommand del
	 * ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults indietroRicerca(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRORICERCA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-476421829) ENABLED START*/
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
	 * Implementazione del metodo eliminaAziendaGestore definito in un ExecCommand del
	 * ContentPanel cpElencoAziendeGestore
	 */
	public ExecResults eliminaAziendaGestore(

			it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAAZIENDAGESTORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String ELIMINAAZIENDAGESTORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1437079230) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("ID RIGA ????? " + theModel.getSession().get(Constants.ID_AZIENDA_GESTORE_TO_DELETE));

			int rowNum = Integer.parseInt((String) theModel.getSession().get(Constants.ID_AZIENDA_GESTORE_TO_DELETE));

			for (Azienda dto : theModel.getAppDataelencoRisultatiRicercaAziendaGestore()) {
				if (dto.getIdAzienda() == rowNum) {
					taifMgr.eliminaDomandaByIdzienda(Integer.valueOf(dto.getIdPratica()).intValue());
					theModel.getAppDataelencoRisultatiRicercaAziendaGestore().remove(dto);
					break;
				}
			}

			theModel.getSession().remove(Constants.ID_AZIENDA_GESTORE_TO_DELETE);

			// impostazione del result code 
			result.setResultCode(ELIMINAAZIENDAGESTORE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaAziendaGestore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoAziendeGestore
	 */
	public static void resetClearStatus_widg_tblElencoAziendeGestore(java.util.Map session) {
		session.put("cpElencoAziendeGestore_tblElencoAziendeGestore_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-203530667) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	@Autowired
	private ExportToExcel exportToExcel;

	@Autowired
	private TaifMgr taifMgr;

	public ExportToExcel getExportToExcel() {
		return exportToExcel;
	}

	public void setExportToExcel(ExportToExcel exportToExcel) {
		this.exportToExcel = exportToExcel;
	}

	public TaifMgr getTaifMgr() {
		return taifMgr;
	}

	public void setTaifMgr(TaifMgr taifMgr) {
		this.taifMgr = taifMgr;
	}

	public ByteArrayOutputStream makeExportToExcel(List<Integer> listAziendaTrovate) throws ManagerException {
		try {
			return exportToExcel.exportToExcel(listAziendaTrovate);
		} catch (Exception e) {
			throw new ManagerException(new Message());

		}

	}

	public ByteArrayOutputStream makeExportToExcelRidotto(List<Integer> listAziendaTrovate) throws ManagerException {
		try {
			return exportToExcel.exportToExcelRidotto(listAziendaTrovate);
		} catch (Exception e) {
			throw new ManagerException(new Message());

		}

	}

	private String getSoggettoGestoreFromId(CpElencoAziendeGestoreModel theModel) {
		if (theModel.getAppDataelencoRisultatiRicercaAziendaGestore().size() != 0) {
			for (Azienda ris : theModel.getAppDataelencoRisultatiRicercaAziendaGestore()) {
				String idAziendaArray = ris.getIdAzienda() + "";
				if (idAziendaArray.equalsIgnoreCase(theModel.getIdRiga())) {
					return ris.getIdSoggettoGestore() + "";
				} ;
			}
		}
		return "";
	}

	/*PROTECTED REGION END*/
}
