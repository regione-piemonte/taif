/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action.libero;

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
import it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel;

import it.csi.taif.taifweb.presentation.taifweb.command.*;

import it.csi.taif.taifweb.presentation.taifweb.security.*;

import it.csi.taif.taifweb.business.*;

import it.csi.taif.taifweb.presentation.taifweb.action.*;

import it.csi.taif.taifweb.presentation.taifweb.action.libero.states.CpElencoAccessoLiberoScreenStates;

import it.csi.taif.taifweb.presentation.taifweb.interceptor.MethodProtection;

import it.csi.taif.taifweb.presentation.taifweb.interceptor.FatClientOnly;
import it.csi.taif.taifweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpElencoAccessoLiberoAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpElencoAccessoLiberoAction extends AbstractCPAction<CpElencoAccessoLiberoModel>
		implements
			Preparable,
			ModelDriven<CpElencoAccessoLiberoModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpElencoAccessoLiberoModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpElencoAccessoLiberoModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpElencoAccessoLiberoModel modello) {
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
			model = new CpElencoAccessoLiberoModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpElencoAccessoLibero";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "libero";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/libero";

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

	private static final String URL_BACK_COMMAND = "/base/libero/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.taif.taifweb.dto.libero.CpElencoAccessoLiberoModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [tblElencoAziendeAccessoLibero]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblElencoAziendeAccessoLibero_CLICKED() throws CommandExecutionException {

		return handleEventInternal("libero", "cpelencoaccessolibero", "tblElencoAziendeAccessoLibero", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnElencoAziendeAccessoLiberoExport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnElencoAziendeAccessoLiberoExport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("libero", "cpelencoaccessolibero", "btnElencoAziendeAccessoLiberoExport", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnElencoAziendeAccessoLiberoNuovaRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnElencoAziendeAccessoLiberoNuovaRicerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("libero", "cpelencoaccessolibero", "btnElencoAziendeAccessoLiberoNuovaRicerca",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnVerificaCaptchaRicercaLiberaExport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnVerificaCaptchaRicercaLiberaExport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("libero", "cpelencoaccessolibero", "btnVerificaCaptchaRicercaLiberaExport",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaEliminaAziendaAccessoLibero]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaEliminaAziendaAccessoLibero_CLICKED() throws CommandExecutionException {

		return handleEventInternal("libero", "cpelencoaccessolibero", "btnAnnullaEliminaAziendaAccessoLibero",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaEliminaAziendaAccessoLibero]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaEliminaAziendaAccessoLibero_CLICKED() throws CommandExecutionException {

		return handleEventInternal("libero", "cpelencoaccessolibero", "btnConfermaEliminaAziendaAccessoLibero",
				"CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tblElencoAziendeAccessoLibero.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblElencoAziendeAccessoLibero_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoRisultatiRicercaAccessoLibero", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1199306560) ENABLED START*/
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
