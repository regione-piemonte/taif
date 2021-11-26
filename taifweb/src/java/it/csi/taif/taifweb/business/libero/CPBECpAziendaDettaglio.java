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

/*PROTECTED REGION ID(R597732751) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpAziendaDettaglio {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [backDomanda, scope:USER_SESSION]
	public static final String APPDATA_BACKDOMANDA_CODE = "appDatabackDomanda";

	// ApplicationData: [crumbs, scope:USER_SESSION]
	public static final String APPDATA_CRUMBS_CODE = "appDatacrumbs";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [elencoComuni, scope:USER_SESSION]
	public static final String APPDATA_ELENCOCOMUNI_CODE = "appDataelencoComuni";

	// ApplicationData: [elencoDownloadAllegati, scope:USER_SESSION]
	public static final String APPDATA_ELENCODOWNLOADALLEGATI_CODE = "appDataelencoDownloadAllegati";

	// ApplicationData: [elencoProvince, scope:USER_SESSION]
	public static final String APPDATA_ELENCOPROVINCE_CODE = "appDataelencoProvince";

	// ApplicationData: [idAzienda, scope:USER_SESSION]
	public static final String APPDATA_IDAZIENDA_CODE = "appDataidAzienda";

	// ApplicationData: [idPratica, scope:USER_SESSION]
	public static final String APPDATA_IDPRATICA_CODE = "appDataidPratica";

	// ApplicationData: [login, scope:USER_ACTION]
	public static final String APPDATA_LOGIN_CODE = "appDatalogin";

	// ApplicationData: [msgError, scope:USER_ACTION]
	public static final String APPDATA_MSGERROR_CODE = "appDatamsgError";

	// ApplicationData: [serviceUrl, scope:USER_SESSION]
	public static final String APPDATA_SERVICEURL_CODE = "appDataserviceUrl";

	// ApplicationData: [tipoAccesso, scope:USER_SESSION]
	public static final String APPDATA_TIPOACCESSO_CODE = "appDatatipoAccesso";

	// ApplicationData: [tipologia, scope:USER_SESSION]
	public static final String APPDATA_TIPOLOGIA_CODE = "appDatatipologia";

	// ApplicationData: [tracciato, scope:USER_SESSION]
	public static final String APPDATA_TRACCIATO_CODE = "appDatatracciato";

	// ApplicationData: [TreeStatus, scope:USER_SESSION]
	public static final String APPDATA_TREESTATUS_CODE = "appDataTreeStatus";

	// ApplicationData: [codFisPivaAzienda, scope:USER_SESSION]
	public static final String APPDATA_CODFISPIVAAZIENDA_CODE = "appDatacodFisPivaAzienda";

	// ApplicationData: [dataIscrizioneAlboAziendaA, scope:USER_SESSION]
	public static final String APPDATA_DATAISCRIZIONEALBOAZIENDAA_CODE = "appDatadataIscrizioneAlboAziendaA";

	// ApplicationData: [dataIscrizioneAlboAziendaDa, scope:USER_SESSION]
	public static final String APPDATA_DATAISCRIZIONEALBOAZIENDADA_CODE = "appDatadataIscrizioneAlboAziendaDa";

	// ApplicationData: [denominazioneAzienda, scope:USER_SESSION]
	public static final String APPDATA_DENOMINAZIONEAZIENDA_CODE = "appDatadenominazioneAzienda";

	// ApplicationData: [dettaglioAziendaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOAZIENDASELEZIONATA_CODE = "appDatadettaglioAziendaSelezionata";

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpAziendaDettaglio";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo indietroDettaglioAzienda definito in un ExecCommand del
	 * ContentPanel cpAziendaDettaglio
	 */
	public ExecResults indietroDettaglioAzienda(

			it.csi.taif.taifweb.dto.libero.CpAziendaDettaglioModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INDIETRODETTAGLIOAZIENDA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"Ok"; //NOSONAR  Reason:EIAS
		final String INDIETRODETTAGLIOAZIENDA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"Ko"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R993677835) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INDIETRODETTAGLIOAZIENDA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::indietroDettaglioAzienda] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo executeInit definito in un ExecCommand del
	 * ContentPanel cpAziendaDettaglio
	 */
	public ExecResults executeInit(

			it.csi.taif.taifweb.dto.libero.CpAziendaDettaglioModel theModel

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
			/*PROTECTED REGION ID(R-1537023673) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// se codice fiscale o partita iva allora 
			// azienda italiana altrimenti francese

			if (theModel.getAppDatadettaglioAziendaSelezionata() != null) {
				if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDatadettaglioAziendaSelezionata().getCodiceFiscale())
						|| ConvertUtil
								.checkIsNullOrEmpty(theModel.getAppDatadettaglioAziendaSelezionata().getPartitaIva())) {
					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_ITA);
				} else {
					result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_FRA);
				}
			} else {
				result.setResultCode(EXECUTEINIT_OUTCOME_CODE__KO);
			}
			// impostazione del result code 
			result.setResultCode(EXECUTEINIT_OUTCOME_CODE__OK_ITA);

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
	/*PROTECTED REGION ID(R-1270330491) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
