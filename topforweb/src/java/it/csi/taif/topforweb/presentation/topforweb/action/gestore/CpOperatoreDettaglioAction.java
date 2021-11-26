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
import it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel;

import it.csi.taif.topforweb.presentation.topforweb.command.*;

import it.csi.taif.topforweb.presentation.topforweb.security.*;

import it.csi.taif.topforweb.business.*;

import it.csi.taif.topforweb.presentation.topforweb.action.*;

import it.csi.taif.topforweb.presentation.topforweb.action.gestore.states.CpOperatoreDettaglioScreenStates;

import it.csi.taif.topforweb.presentation.topforweb.interceptor.MethodProtection;

import it.csi.taif.topforweb.presentation.topforweb.interceptor.FatClientOnly;
import it.csi.taif.topforweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpOperatoreDettaglioAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpOperatoreDettaglioAction extends AbstractCPAction<CpOperatoreDettaglioModel>
		implements
			Preparable,
			ModelDriven<CpOperatoreDettaglioModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpOperatoreDettaglioModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpOperatoreDettaglioModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpOperatoreDettaglioModel modello) {
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
			model = new CpOperatoreDettaglioModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpOperatoreDettaglio";

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
		return it.csi.taif.topforweb.dto.gestore.CpOperatoreDettaglioModel.class;
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

		if (AbstractCPAction.IMPLICIT_EVENT_ON_REFRESH.equals(implicitEventName)) //NOSONAR
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
	 * Gestione dell'evento CLICKED sul widget [tblCorsiProfessionaliFinanziatiRegione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblCorsiProfessionaliFinanziatiRegione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpoperatoredettaglio", "tblCorsiProfessionaliFinanziatiRegione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAltriCorsi]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAltriCorsi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpoperatoredettaglio", "tblAltriCorsi", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnModificaSchedaOperatore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnModificaSchedaOperatore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpoperatoredettaglio", "btnModificaSchedaOperatore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnEliminaSchedaOperatore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnEliminaSchedaOperatore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpoperatoredettaglio", "btnEliminaSchedaOperatore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndietroSchedaOperatore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndietroSchedaOperatore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpoperatoredettaglio", "btnIndietroSchedaOperatore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglioOperatoreNuovaRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglioOperatoreNuovaRicerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpoperatoredettaglio", "btnDettaglioOperatoreNuovaRicerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaEliminaAttestato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaEliminaAttestato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpoperatoredettaglio", "btnConfermaEliminaAttestato", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaEliminaAttestato]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaEliminaAttestato_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpoperatoredettaglio", "btnAnnullaEliminaAttestato", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tblCorsiProfessionaliFinanziatiRegione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblCorsiProfessionaliFinanziatiRegione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCorsiProfessionaliFinanziatiDaRegione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAltriCorsi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAltriCorsi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAltriCorsi", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblQualifiche.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblQualifiche_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoQualifiche", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblRiconoscimenti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblRiconoscimenti_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoRiconoscimento", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R190416200) ENABLED START*/
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
