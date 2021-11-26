/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action.common;

import java.io.File;
import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.util.*;
import it.csi.taif.taifweb.dto.*;
import it.csi.taif.taifweb.dto.common.CpDocumentazioneModel;

import it.csi.taif.taifweb.presentation.taifweb.command.*;

import it.csi.taif.taifweb.presentation.taifweb.security.*;

import it.csi.taif.taifweb.business.*;

import it.csi.taif.taifweb.presentation.taifweb.action.*;

import it.csi.taif.taifweb.presentation.taifweb.action.common.states.CpDocumentazioneScreenStates;

import it.csi.taif.taifweb.presentation.taifweb.interceptor.MethodProtection;

import it.csi.taif.taifweb.presentation.taifweb.interceptor.FatClientOnly;
import it.csi.taif.taifweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDocumentazioneAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDocumentazioneAction extends AbstractCPAction<CpDocumentazioneModel>
		implements
			Preparable,
			ModelDriven<CpDocumentazioneModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDocumentazioneModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDocumentazioneModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDocumentazioneModel modello) {
		this.model = modello;
	}

	/**
	 * Il metodo setSession() viene ridefinito in modo che venga asosciato all'oggetto
	 * model.
	 * N.B: il model deve essere creato in precedenza, altrimenti l'impostazione non 
	 * e' possibile. 
	 * Per questo motivo esso viene creato in questo (se non gia' esistente).
	 */
	@Override
	public void setSession(Map session) {
		// implementazione standard di SessionAware
		super.setSession(session);
		// creo una nuova istanza di modello, se gia' non esiste 
		if (model == null) {
			model = new CpDocumentazioneModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "CpDocumentazione";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "common";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/common";

	/**
	 * restituisce il nome del content panel
	 */
	public String getCPName() {
		return CP_NAME;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel
	 */
	public String getCPNamespace() {
		return CP_NAMESPACE;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel, comprensivo di prefisso "base"/"secure"
	 */
	public String getCPFullNamespace() {
		return CP_FULL_NAMESPACE;
	}

	private static final String URL_BACK_COMMAND = "/base/common/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.taif.taifweb.dto.common.CpDocumentazioneModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_INIT.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		// else
		return false;
	}

	protected boolean isOnRefreshLegacyMode() {
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del singolo tipo di evento sul singolo widget
	/// contenuto nel contentPanel
	/// metodo: handle<nomeWidget>_<NOME_EVENTO>
	/// es: handletreeVoci_CLICKED
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoFirmaAllegatiDownload]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoFirmaAllegatiDownload_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "cbTipoFirmaAllegatiDownload", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoFirma]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoFirma_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "cbTipoFirma", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [loadAllegatoButton]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleLoadAllegatoButton_CLICKED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "loadAllegatoButton", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tElencoAllegati]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTElencoAllegati_CLICKED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "tElencoAllegati", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDocumentazioneIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDocumentazioneIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "btnDocumentazioneIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDocumentazioneInvio]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDocumentazioneInvio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "btnDocumentazioneInvio", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaInvioDocumentazioneHome]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaInvioDocumentazioneHome_CLICKED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "btnConfermaInvioDocumentazioneHome", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaEliminaDocumentazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaEliminaDocumentazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "btnConfermaEliminaDocumentazione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaEliminaDocumentazione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaEliminaDocumentazione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("common", "cpdocumentazione", "btnAnnullaEliminaDocumentazione", "CLICKED");

	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodo di data providing sull'intero ContentPanel
	/// metodo: provide_CPDATA
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	/// metodi di data providing sui widget dotati di multi data binding
	/// contenuti nel contentPanel
	/// metodo: provide<nomeWidget>_<tipologia dati>
	/// es: provideCbComuni_DATASET
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoFirmaAllegatiDownload.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoFirmaAllegatiDownload_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipologieAllegatiDownload", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tElencoDownloadAllegati.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTElencoDownloadAllegati_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAllegatiDownload", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbTipoFirma.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoFirma_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTipologieAllegati", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSottotipoFirma.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSottotipoFirma_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSottotipologieAllegati", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tElencoAllegati.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTElencoAllegati_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAllegati", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1191916223) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 * Metodo di preparazione della schermata/action
	 */
	public void prepare() throws CommandExecutionException {
		super.prepare();

	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// nothing to clear...
	}

	@SkipValidation
	public String handleChangeTab() {
		if (this.hasActionErrors() || this.hasFieldErrors() || this.hasErrors())
			return INPUT;
		else {
			session.put(getModel().getSelectedTabKey(), getModel().getSelectedTabValue());
			return SUCCESS;
		}
	}

}
