/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action.gestore;

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

import it.csi.taif.topforweb.util.*;
import it.csi.taif.topforweb.dto.*;
import it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel;

import it.csi.taif.topforweb.presentation.topforweb.command.*;

import it.csi.taif.topforweb.presentation.topforweb.security.*;

import it.csi.taif.topforweb.business.*;

import it.csi.taif.topforweb.presentation.topforweb.action.*;

import it.csi.taif.topforweb.presentation.topforweb.action.gestore.states.CpInserimentoOperatoreScreenStates;

import it.csi.taif.topforweb.presentation.topforweb.interceptor.MethodProtection;

import it.csi.taif.topforweb.presentation.topforweb.interceptor.FatClientOnly;
import it.csi.taif.topforweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpInserimentoOperatoreAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpInserimentoOperatoreAction extends AbstractCPAction<CpInserimentoOperatoreModel>
		implements
			Preparable,
			ModelDriven<CpInserimentoOperatoreModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpInserimentoOperatoreModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpInserimentoOperatoreModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpInserimentoOperatoreModel modello) {
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
			model = new CpInserimentoOperatoreModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpInserimentoOperatore";

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
		return it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del click sui Tab
	/// contenuto nel contentPanel
	/// metodo: handle<id_completo_tab_item>_CLICKED
	/// 
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpOperatore 
	 */
	public String handle_CpInserimentoOperatore_WzpOperatore_FpWizardDatiAnagraficiOperatore_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpInserimentoOperatore_wzpOperatore_selectedMultiPanel");
		getModel().setSelectedTabValue("cpInserimentoOperatore_wzpOperatore_fpWizardDatiAnagraficiOperatore");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardOperatore_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpOperatore 
	 */
	public String handle_CpInserimentoOperatore_WzpOperatore_FpWizardCorsiFinanziatiRegioneOperatore_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpInserimentoOperatore_wzpOperatore_selectedMultiPanel");
		getModel().setSelectedTabValue("cpInserimentoOperatore_wzpOperatore_fpWizardCorsiFinanziatiRegioneOperatore");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardOperatore_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpOperatore 
	 */
	public String handle_CpInserimentoOperatore_WzpOperatore_FpWizardAltriCorsiOperatore_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpInserimentoOperatore_wzpOperatore_selectedMultiPanel");
		getModel().setSelectedTabValue("cpInserimentoOperatore_wzpOperatore_fpWizardAltriCorsiOperatore");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardOperatore_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpOperatore 
	 */
	public String handle_CpInserimentoOperatore_WzpOperatore_FpWizardQualificheOperatore_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpInserimentoOperatore_wzpOperatore_selectedMultiPanel");
		getModel().setSelectedTabValue("cpInserimentoOperatore_wzpOperatore_fpWizardQualificheOperatore");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardOperatore_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpOperatore 
	 */
	public String handle_CpInserimentoOperatore_WzpOperatore_FpWizardRiconoscimentiOperatore_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpInserimentoOperatore_wzpOperatore_selectedMultiPanel");
		getModel().setSelectedTabValue("cpInserimentoOperatore_wzpOperatore_fpWizardRiconoscimentiOperatore");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardOperatore_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

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
	 * Gestione dell'evento CLICKED sul widget [btnCercaOperatoreAnagraficaIt]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaOperatoreAnagraficaIt_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnCercaOperatoreAnagraficaIt", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaOperatoreFr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaOperatoreFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnCercaOperatoreFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbStatoNascitaOperatore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbStatoNascitaOperatore_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbStatoNascitaOperatore", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbComuneResidenzaOperatore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbComuneResidenzaOperatore_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbComuneResidenzaOperatore", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbStatoSchedaInserimento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbStatoSchedaInserimento_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbStatoSchedaInserimento", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbInserimentoAgenziaFormativa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbInserimentoAgenziaFormativa_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbInserimentoAgenziaFormativa",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbInserimentoUnitaFormativa]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbInserimentoUnitaFormativa_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbInserimentoUnitaFormativa", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbInserimentoTitoloCorso]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbInserimentoTitoloCorso_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbInserimentoTitoloCorso", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAggiungiCorsoFinanziatoRegione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAggiungiCorsoFinanziatoRegione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btAggiungiCorsoFinanziatoRegione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblInserimentoCorsiProfessionaliFinanziatiRegione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblInserimentoCorsiProfessionaliFinanziatiRegione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore",
				"tblInserimentoCorsiProfessionaliFinanziatiRegione", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaEliminaCorsoFinanziatoRegione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaEliminaCorsoFinanziatoRegione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnAnnullaEliminaCorsoFinanziatoRegione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaEliminaCorsoFinanziatoRegione]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaEliminaCorsoFinanziatoRegione_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnConfermaEliminaCorsoFinanziatoRegione",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbInserimentoAltroCorso]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbInserimentoAltroCorso_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbInserimentoAltroCorso", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAggiungiAltriCorsiButton]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAggiungiAltriCorsiButton_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btAggiungiAltriCorsiButton", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblInserimentoAltriCorsi]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblInserimentoAltriCorsi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "tblInserimentoAltriCorsi", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaEliminaAltroCorso]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaEliminaAltroCorso_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnAnnullaEliminaAltroCorso", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaEliminaAltroCorso]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaEliminaAltroCorso_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnConfermaEliminaAltroCorso", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAggiungiQualifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAggiungiQualifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btAggiungiQualifica", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblQualifiche]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblQualifiche_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "tblQualifiche", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaEliminaQualifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaEliminaQualifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnAnnullaEliminaQualifica", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaEliminaQualifica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaEliminaQualifica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnConfermaEliminaQualifica", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbInserimentoAgenziaFormativaRiconoscimento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbInserimentoAgenziaFormativaRiconoscimento_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbInserimentoAgenziaFormativaRiconoscimento",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbInserimentoUnitaFormativaRiconoscimento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbInserimentoUnitaFormativaRiconoscimento_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "cbInserimentoUnitaFormativaRiconoscimento",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btAggiungiRiconoscimento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtAggiungiRiconoscimento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btAggiungiRiconoscimento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblInserimentoRiconoscimenti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblInserimentoRiconoscimenti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "tblInserimentoRiconoscimenti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnullaEliminaRiconoscimento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnullaEliminaRiconoscimento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnAnnullaEliminaRiconoscimento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConfermaEliminaRiconoscimento]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConfermaEliminaRiconoscimento_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnConfermaEliminaRiconoscimento", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsWizardOperatore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsWizardOperatore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "tsWizardOperatore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnWizardBackElencoOperatore]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnWizardBackElencoOperatore_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnWizardBackElencoOperatore", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnWizardOperatoreIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnWizardOperatoreIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnWizardOperatoreIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnWizardOperatoreSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnWizardOperatoreSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnWizardOperatoreSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnWizardOperatoreProsegui]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnWizardOperatoreProsegui_CLICKED() throws CommandExecutionException {

		return handleEventInternal("gestore", "cpinserimentooperatore", "btnWizardOperatoreProsegui", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbStatoNascitaOperatore.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbStatoNascitaOperatore_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoNazioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComuneNascitaOperatore.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComuneNascitaOperatore_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniRicercaOperatoreGestore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbComuneResidenzaOperatore.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbComuneResidenzaOperatore_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniRicercaOperatoreGestore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbStatoSchedaInserimento.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbStatoSchedaInserimento_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoSchedaRicerca", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoAgenziaFormativa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoAgenziaFormativa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAgenziaFormativaRicercaOperatore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoUnitaFormativa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoUnitaFormativa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaFormativaCorsiFinanziati", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoTitoloCorso.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoTitoloCorso_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoTitoloCorso", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoEsitoCorso.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoEsitoCorso_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoEsitoCorso", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblInserimentoCorsiProfessionaliFinanziatiRegione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblInserimentoCorsiProfessionaliFinanziatiRegione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCorsiProfessionaliFinanziatiDaRegione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoAltroCorso.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoAltroCorso_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAltriCorsiDenominazioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoAttestatoConScadenza.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoAttestatoConScadenza_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAttestatoConScadenzaInserimento", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoEsitoAltroCorso.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoEsitoAltroCorso_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoEsitoCorso", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblInserimentoAltriCorsi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblInserimentoAltriCorsi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAltriCorsi", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoQualifica.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoQualifica_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoQualificheDenominazioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoQualificaAgenziaFormativa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoQualificaAgenziaFormativa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAgenziaFormativaRicercaOperatore", "", false, false);
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
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoAgenziaFormativaRiconoscimento.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoAgenziaFormativaRiconoscimento_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAgenziaFormativaRicercaOperatore", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbInserimentoUnitaFormativaRiconoscimento.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbInserimentoUnitaFormativaRiconoscimento_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaFormativaRiconoscimento", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblInserimentoRiconoscimenti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblInserimentoRiconoscimenti_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoRiconoscimento", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R1935200948) ENABLED START*/
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
