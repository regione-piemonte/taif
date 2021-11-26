/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action.gestore;

import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.topforweb.util.*;
import it.csi.taif.topforweb.dto.*;
import it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel;

import it.csi.taif.topforweb.presentation.topforweb.command.*;

import it.csi.taif.topforweb.presentation.topforweb.security.*;

import it.csi.taif.topforweb.business.*;

import it.csi.taif.topforweb.presentation.topforweb.action.*;

import it.csi.taif.topforweb.presentation.topforweb.action.gestore.states.CpRicercaOperatoreForestaleGestoreScreenStates;

import it.csi.taif.topforweb.presentation.topforweb.interceptor.MethodProtection;

import it.csi.taif.topforweb.presentation.topforweb.interceptor.FatClientOnly;
import it.csi.taif.topforweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpRicercaOperatoreForestaleGestoreAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpRicercaOperatoreForestaleGestoreAction extends AbstractCPAction<CpRicercaOperatoreForestaleGestoreModel>
		implements
			Preparable,
			ModelDriven<CpRicercaOperatoreForestaleGestoreModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpRicercaOperatoreForestaleGestoreModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpRicercaOperatoreForestaleGestoreModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpRicercaOperatoreForestaleGestoreModel modello) {
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
			model = new CpRicercaOperatoreForestaleGestoreModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpRicercaOperatoreForestaleGestore";

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
		return it.csi.taif.topforweb.dto.gestore.CpRicercaOperatoreForestaleGestoreModel.class;
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
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbAmbitoFormativo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbAmbitoFormativo_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpricercaoperatoreforestalegestore", "cbAmbitoFormativo",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProvinciaRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProvinciaRicerca_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpricercaoperatoreforestalegestore", "cbProvinciaRicerca",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnWizardIndietroHome]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnWizardIndietroHome_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpricercaoperatoreforestalegestore", "btnWizardIndietroHome", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnRicercaOperatoreForestaleGestore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnRicercaOperatoreForestaleGestore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpricercaoperatoreforestalegestore",
				"btnRicercaOperatoreForestaleGestore", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbAlboAppartenenzaOperatore.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAlboAppartenenzaOperatore_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAlbiRicercaOperatore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAmbitoFormativo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAmbitoFormativo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAmbitoFormativoRicercaOperatore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbUnitaFormativa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbUnitaFormativa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaFormativaRicercaOperatore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbAgenziaFormativa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbAgenziaFormativa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAgenziaFormativaRicercaOperatore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbStatoOperatoreRicerca.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbStatoOperatoreRicerca_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoOperatoreRicerca", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbStatoSchedaRicerca.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbStatoSchedaRicerca_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoSchedaRicerca", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbProvinciaRicerca.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProvinciaRicerca_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvinceRicercaOperatoreGestore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComuniRicerca.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComuniRicerca_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniRicercaOperatoreGestore", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1507339870) ENABLED START*/
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
