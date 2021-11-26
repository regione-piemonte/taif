/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action.gestore;

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
import it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel;

import it.csi.taif.taifweb.presentation.taifweb.command.*;

import it.csi.taif.taifweb.presentation.taifweb.security.*;

import it.csi.taif.taifweb.business.*;

import it.csi.taif.taifweb.presentation.taifweb.action.*;

import it.csi.taif.taifweb.presentation.taifweb.action.gestore.states.CpElencoAziendeGestoreScreenStates;

import it.csi.taif.taifweb.presentation.taifweb.interceptor.MethodProtection;

import it.csi.taif.taifweb.presentation.taifweb.interceptor.FatClientOnly;
import it.csi.taif.taifweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpElencoAziendeGestoreAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpElencoAziendeGestoreAction extends AbstractCPAction<CpElencoAziendeGestoreModel>
		implements
			Preparable,
			ModelDriven<CpElencoAziendeGestoreModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpElencoAziendeGestoreModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpElencoAziendeGestoreModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpElencoAziendeGestoreModel modello) {
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
			model = new CpElencoAziendeGestoreModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpElencoAziendeGestore";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "gestore";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/gestore";

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

	private static final String URL_BACK_COMMAND = "/base/gestore/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.taif.taifweb.dto.gestore.CpElencoAziendeGestoreModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [tblElencoAziendeGestore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblElencoAziendeGestore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpelencoaziendegestore", "tblElencoAziendeGestore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnElencoAziendeGestoreExport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnElencoAziendeGestoreExport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpelencoaziendegestore", "btnElencoAziendeGestoreExport", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnElencoAziendeNuovaRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnElencoAziendeNuovaRicerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpelencoaziendegestore", "btnElencoAziendeNuovaRicerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnElencoAziendeGestoreIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnElencoAziendeGestoreIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpelencoaziendegestore", "btnElencoAziendeGestoreIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaEliminaAziendaGestore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaEliminaAziendaGestore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpelencoaziendegestore", "btnAnnullaEliminaAziendaGestore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaEliminaAziendaGestore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaEliminaAziendaGestore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpelencoaziendegestore", "btnConfermaEliminaAziendaGestore", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tblElencoAziendeGestore.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblElencoAziendeGestore_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoRisultatiRicercaAziendaGestore", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1457340461) ENABLED START*/
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
