/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action.domanda;

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
import it.csi.taif.taifweb.dto.domanda.CpDomandaModel;

import it.csi.taif.taifweb.presentation.taifweb.command.*;

import it.csi.taif.taifweb.presentation.taifweb.security.*;

import it.csi.taif.taifweb.business.*;

import it.csi.taif.taifweb.presentation.taifweb.action.*;

import it.csi.taif.taifweb.presentation.taifweb.action.domanda.states.CpDomandaScreenStates;

import it.csi.taif.taifweb.presentation.taifweb.interceptor.MethodProtection;

import it.csi.taif.taifweb.presentation.taifweb.interceptor.FatClientOnly;
import it.csi.taif.taifweb.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDomandaAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDomandaAction extends AbstractCPAction<CpDomandaModel>
		implements
			Preparable,
			ModelDriven<CpDomandaModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDomandaModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDomandaModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDomandaModel modello) {
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
			model = new CpDomandaModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "CpDomanda";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "domanda";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/domanda";

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

	private static final String URL_BACK_COMMAND = "/base/domanda/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.taif.taifweb.dto.domanda.CpDomandaModel.class;
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
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomanda 
	 */
	public String handle_CpDomanda_WzpDomanda_FpWizard1DatiAnagrafici_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomanda_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomanda_fpWizard1DatiAnagrafici");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomanda 
	 */
	public String handle_CpDomanda_WzpDomanda_FpWizard2DatiSocioEconomici_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomanda_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomanda_fpWizard2DatiSocioEconomici");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomanda 
	 */
	public String handle_CpDomanda_WzpDomanda_FpWizard3Attivita_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomanda_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomanda_fpWizard3Attivita");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomanda 
	 */
	public String handle_CpDomanda_WzpDomanda_FpWizard4Strutture_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomanda_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomanda_fpWizard4Strutture");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomanda 
	 */
	public String handle_CpDomanda_WzpDomanda_FpWizard5Attrezzature_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomanda_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomanda_fpWizard5Attrezzature");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomanda 
	 */
	public String handle_CpDomanda_WzpDomanda_FpWizard6Personale_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomanda_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomanda_fpWizard6Personale");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaDatiAnagrafici 
	 */
	public String handle_CpDomanda_WzpDomandaDatiAnagrafici_FpWizardDatiAnagraficiSub1_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub1");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda1_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaDatiAnagrafici 
	 */
	public String handle_CpDomanda_WzpDomandaDatiAnagrafici_FpWizardDatiAnagraficiSub2_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaDatiAnagrafici_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaDatiAnagrafici_fpWizardDatiAnagraficiSub2");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda1_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaDatiSocioEconomici 
	 */
	public String handle_CpDomanda_WzpDomandaDatiSocioEconomici_FpWizardDatiSocioEconomiciSub1_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub1");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda2_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaDatiSocioEconomici 
	 */
	public String handle_CpDomanda_WzpDomandaDatiSocioEconomici_FpWizardDatiSocioEconomiciSub2_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaDatiSocioEconomici_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaDatiSocioEconomici_fpWizardDatiSocioEconomiciSub2");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda2_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaAttivita 
	 */
	public String handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub1_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaAttivita_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub1");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda3_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaAttivita 
	 */
	public String handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub2_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaAttivita_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub2");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda3_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaAttivita 
	 */
	public String handle_CpDomanda_WzpDomandaAttivita_FpWizardAttivitaSub3_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaAttivita_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaAttivita_fpWizardAttivitaSub3");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda3_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaAttrezzatture 
	 */
	public String handle_CpDomanda_WzpDomandaAttrezzatture_FpWizardAttrezzatureSub1_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaAttrezzatture_fpWizardAttrezzatureSub1");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda5_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set wzpDomandaAttrezzatture 
	 */
	public String handle_CpDomanda_WzpDomandaAttrezzatture_PWizardAttrezzatureSub2_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("CpDomanda_wzpDomandaAttrezzatture_selectedMultiPanel");
		getModel().setSelectedTabValue("CpDomanda_wzpDomandaAttrezzatture_pWizardAttrezzatureSub2");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTsWizardDomanda5_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_INIT.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
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
	 * Gestione dell'evento CLICKED sul widget [btnCercaAnagraficaAziendaAeep]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaAnagraficaAziendaAeep_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnCercaAnagraficaAziendaAeep", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbsDatiAnagraficiAltreSedi2]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbsDatiAnagraficiAltreSedi2_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "rbsDatiAnagraficiAltreSedi2", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblDatiAnagraficiSedi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblDatiAnagraficiSedi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblDatiAnagraficiSedi", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddSedeOperativa]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddSedeOperativa_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddSedeOperativa", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDeleteSedeOperativa]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDeleteSedeOperativa_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnDeleteSedeOperativa", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaTitolareAnagraficaFr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaTitolareAnagraficaFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnCercaTitolareAnagraficaFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaTitolareAnagrafica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaTitolareAnagrafica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnCercaTitolareAnagrafica", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita_VALUE_CHANGED()
			throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbsDatiAnagraficiAltroConducente]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbsDatiAnagraficiAltroConducente_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "rbsDatiAnagraficiAltroConducente", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCercaAltroTitolareAnagrafica]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCercaAltroTitolareAnagrafica_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnCercaAltroTitolareAnagrafica", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita_VALUE_CHANGED()
			throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda",
				"cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsWizardDomanda1]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsWizardDomanda1_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tsWizardDomanda1", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbsDatiSocioEconomiciAltriAlbi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbsDatiSocioEconomiciAltriAlbi_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "rbsDatiSocioEconomiciAltriAlbi", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbDatiSocioEconomiciAltriAlbi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbDatiSocioEconomiciAltriAlbi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tbDatiSocioEconomiciAltriAlbi", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAltroAlbo]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAltroAlbo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAltroAlbo", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbsDatiSocioEconomiciCertificazioniQualitaProcesso]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbsDatiSocioEconomiciCertificazioniQualitaProcesso_VALUE_CHANGED()
			throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "rbsDatiSocioEconomiciCertificazioniQualitaProcesso",
				"VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbDatiSocioEconomiciCertificazioni]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbDatiSocioEconomiciCertificazioni_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tbDatiSocioEconomiciCertificazioni", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddCertificazioneQualitaProcesso]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddCertificazioneQualitaProcesso_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddCertificazioneQualitaProcesso", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsWizardDomanda2]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsWizardDomanda2_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tsWizardDomanda2", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttivitaUltimoAnno]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttivitaUltimoAnno_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblAttivitaUltimoAnno", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttivitaUltimoAnno1]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttivitaUltimoAnno1_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttivitaUltimoAnno1", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnConsultaIstanzaTaglioPresenti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnConsultaIstanzaTaglioPresenti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnConsultaIstanzaTaglioPresenti", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttivitaUltimoAnno2]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttivitaUltimoAnno2_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttivitaUltimoAnno2", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttivitaUltimoAnno3]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttivitaUltimoAnno3_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttivitaUltimoAnno3", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttivitaUltimoAnno4]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttivitaUltimoAnno4_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttivitaUltimoAnno4", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttivitaUltimoAnno5]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttivitaUltimoAnno5_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttivitaUltimoAnno5", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttivitaUltimoAnno5]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttivitaUltimoAnno5_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblAttivitaUltimoAnno5", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddArboricolturaDaLegno]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddArboricolturaDaLegno_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddArboricolturaDaLegno", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbsAttivitaLavoriPA]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbsAttivitaLavoriPA_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "rbsAttivitaLavoriPA", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbAttivitaLavoriPA]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbAttivitaLavoriPA_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tbAttivitaLavoriPA", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddLavoroPA]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddLavoroPA_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddLavoroPA", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbsAttivitaLegname]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbsAttivitaLegname_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "rbsAttivitaLegname", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbAttivitaLegname]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbAttivitaLegname_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tbAttivitaLegname", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddLegname]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddLegname_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddLegname", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tbAttivitaLegnameFr]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTbAttivitaLegnameFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tbAttivitaLegnameFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddLegnameFr]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddLegnameFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddLegnameFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsWizardDomanda3]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsWizardDomanda3_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tsWizardDomanda3", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbStruttureCapannoni]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbStruttureCapannoni_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbStruttureCapannoni", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblStruttureCapannoni]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblStruttureCapannoni_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblStruttureCapannoni", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddCapannone]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddCapannone_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddCapannone", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbStrutturePiazzaliStoccaggio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbStrutturePiazzaliStoccaggio_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbStrutturePiazzaliStoccaggio", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblStrutturePiazzaliStoccaggio]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblStrutturePiazzaliStoccaggio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblStrutturePiazzaliStoccaggio", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddPiazzaleStoccaggio]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddPiazzaleStoccaggio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddPiazzaleStoccaggio", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureCascoForestale]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureCascoForestale_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureCascoForestale", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttrezzatureCascoForestale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttrezzatureCascoForestale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblAttrezzatureCascoForestale", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaCascoForestale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaCascoForestale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaCascoForestale", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureScarponiRinforzati]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureScarponiRinforzati_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureScarponiRinforzati", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttrezzatureScarponiRinforzati]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttrezzatureScarponiRinforzati_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblAttrezzatureScarponiRinforzati", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaScarponiRinforzati]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaScarponiRinforzati_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaScarponiRinforzati", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzaturePantaloniAntitaglio]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzaturePantaloniAntitaglio_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzaturePantaloniAntitaglio", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttrezzaturePantaloniAntitaglio]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttrezzaturePantaloniAntitaglio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblAttrezzaturePantaloniAntitaglio", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddPantaloneAntitaglio]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddPantaloneAntitaglio_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddPantaloneAntitaglio", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchinaTrattrici]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchinaTrattrici_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchinaTrattrici", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchinaTrattrici]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchinaTrattrici_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchinaTrattrici", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaTrattrice]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaTrattrice_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaTrattrice", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchineSpeciali]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchineSpeciali_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchineSpeciali", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchineSpeciali]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchineSpeciali_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchineSpeciali", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaSpeciale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaSpeciale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaSpeciale", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchineMovimentoATerra]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchineMovimentoATerra_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchineMovimentoATerra", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchineMovimentoATerra]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchineMovimentoATerra_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchineMovimentoATerra", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaMovimentoATerra]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaMovimentoATerra_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaMovimentoATerra", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchinaRimorchi]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchinaRimorchi_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchinaRimorchi", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchinaRimorchi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchinaRimorchi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchinaRimorchi", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaRimorchi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaRimorchi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaRimorchi", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchinaVerricelli]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchinaVerricelli_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchinaVerricelli", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchinaVerricelli]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchinaVerricelli_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchinaVerricelli", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaVerricelli]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaVerricelli_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaVerricelli", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchinaPle]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchinaPle_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchinaPle", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchinaPle]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchinaPle_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchinaPle", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaPle]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaPle_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaPle", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchinaTrinciaForestale]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchinaTrinciaForestale_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchinaTrinciaForestale", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchinaTrinciaForestale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchinaTrinciaForestale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchinaTrinciaForestale", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaTrinciaForestale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaTrinciaForestale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaTrinciaForestale", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchineSegherieMobili]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchineSegherieMobili_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchineSegherieMobili", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchineSegherieMobili]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchineSegherieMobili_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchineSegherieMobili", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaSegherieMobili]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaSegherieMobili_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaSegherieMobili", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchineGruACavo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchineGruACavo_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchineGruACavo", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchineGruACavo]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchineGruACavo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchineGruACavo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaGruACavo]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaGruACavo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaGruACavo", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchineCippatrici]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchineCippatrici_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchineCippatrici", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchineCippatrici]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchineCippatrici_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchineCippatrici", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaCippatrici]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaCippatrici_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaCippatrici", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMezziDiTrasporto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMezziDiTrasporto_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMezziDiTrasporto", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMezziDiTrasporto]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMezziDiTrasporto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMezziDiTrasporto", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMezziDiTrasporto]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMezziDiTrasporto_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMezziDiTrasporto", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureAltriMezzi]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureAltriMezzi_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureAltriMezzi", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAltriMezzi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAltriMezzi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblAltriMezzi", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaAltriMezzi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaAltriMezzi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaAltriMezzi", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchineSpecialiFr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchineSpecialiFr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchineSpecialiFr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchineSpecialiFr]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchineSpecialiFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchineSpecialiFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaSpecialeFr]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaSpecialeFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaSpecialeFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchineMovimentoATerraFr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchineMovimentoATerraFr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchineMovimentoATerraFr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchineMovimentoATerraFr]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchineMovimentoATerraFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchineMovimentoATerraFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaMovimentoATerraFr]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaMovimentoATerraFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaMovimentoATerraFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchinaGrumier]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchinaGrumier_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchinaGrumier", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchinaGrumier]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchinaGrumier_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchinaGrumier", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaGrumier]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaGrumier_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaGrumier", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchinaRimorchiFr]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchinaRimorchiFr_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchinaRimorchiFr", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchinaRimorchiFr]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchinaRimorchiFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchinaRimorchiFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaRimorchiFr]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaRimorchiFr_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaRimorchiFr", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [chbAttrezzatureMacchinaSemi]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleChbAttrezzatureMacchinaSemi_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "chbAttrezzatureMacchinaSemi", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblMacchinaSemi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblMacchinaSemi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblMacchinaSemi", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddAttrezzaturaMacchinaSemi]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddAttrezzaturaMacchinaSemi_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddAttrezzaturaMacchinaSemi", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsWizardDomanda5]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsWizardDomanda5_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tsWizardDomanda5", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [rbsPersonale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleRbsPersonale_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "rbsPersonale", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento KEY_PRESSED sul widget [cmbRicercaAltroPersonale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleCmbRicercaAltroPersonale_KEY_PRESSED() throws CommandExecutionException {
		handleEventInternal("domanda", "cpdomanda", "cmbRicercaAltroPersonale", "KEY_PRESSED");
		return provideCmbRicercaAltroPersonale_DATASET();
	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAggiungiCodiceFiscaleAltroPersonale]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAggiungiCodiceFiscaleAltroPersonale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAggiungiCodiceFiscaleAltroPersonale", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAltroPersonale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAltroPersonale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tblAltroPersonale", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAddPersonale]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAddPersonale_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnAddPersonale", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tsWizardDomanda]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTsWizardDomanda_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "tsWizardDomanda", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnWizardDomandaIndietro]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnWizardDomandaIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnWizardDomandaIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnWizardDomandaSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnWizardDomandaSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnWizardDomandaSalva", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnWizardDomandaProsegui]
	 */
	@SkipValidation
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnWizardDomandaProsegui_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnWizardDomandaProsegui", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDocumentiDemo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDocumentiDemo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnDocumentiDemo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnIndexDemo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnIndexDemo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("domanda", "cpdomanda", "btnIndexDemo", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiAnagrafeAziendaleAttivitaPrimaria.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiAnagrafeAziendaleAttivitaPrimaria_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAttivitaPrimariaDatiAnagraficiAnagrafeAnziendale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiAnagrafeAziendaleAttivitaSecondaria.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiAnagrafeAziendaleAttivitaSecondaria_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoAttivitaSecondariaDatiAnagraficiAnagrafeAnziendale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiAnagrafeAziendaleFormaGiuridica.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiAnagrafeAziendaleFormaGiuridica_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoFormeGiuridicheDatiAnagraficiAnagrafeAnziendale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiAnagrafeAziendaleCCIAAProvincia_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoProvinceCCIAADatiAnagraficiAnagrafeAnziendale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiComuneSedeLegale.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiComuneSedeLegale_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniDatiAnagraficiAnagrafeAziendale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiAnagraficiSedi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiAnagraficiSedi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSediDatiAnagraficiAnagrafeAziendale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiTitolareRappresentanteLegaleStatoNascita_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale", "", false,
				false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCmbDatiAnagraficiTitolareRappresentanteLegaleComuneNascita_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniNascitaTitolareRappresentante", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCmbDatiAnagraficiTitolareRappresentanteLegaleComuneResidenza_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniResidenzaTitolareRappresentante", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiTitolareRappresentanteLegaleTitoloStudio_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale", "", false,
				false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiAnagraficiTitolareRappresentanteLegaleCorsiSostenuti_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoCorsiSostenutiTitolareRappresentanteLegale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiAnagraficiTitolareRappresentanteLegaleQualifiche.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiAnagraficiTitolareRappresentanteLegaleQualifiche_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoQualificheTitolareRappresentanteLegale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiAnagraficiTitolareRappresentanteLegaleRiconoscimenti_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoRiconiscimentiTitolareRappresentanteLegale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiTitolareAltroRappresentanteLegaleStatoNascita_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoStatoNascitaDatiAnagraficiTitolareRappresentanteLegale", "", false,
				false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiAltroTitolareRappresentanteLegaleComuneNascita_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniNascitaAltroTitolareRappresentante", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiTitolareAltroRappresentanteLegaleComuneResidenza_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoComuniResidenzaAltroTitolareRappresentante", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbDatiAnagraficiAltroTitolareRappresentanteLegaleTitoloStudio_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoTitoloStudioDatiAnagraficiTitolareRappresentanteLegale", "", false,
				false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiAnagraficiAltroTitolareRappresentanteLegaleCorsiSostenuti_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoCorsiSostenutiAltroTitolareRappresentanteLegale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiAnagraficiAltroTitolareRappresentanteLegaleQualifiche_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoQualificheAltroTitolareRappresentanteLegale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiAnagraficiAltroTitolareRappresentanteLegaleRiconoscimenti_DATASET()
			throws CommandExecutionException {

		return provideDataInternal("appDataelencoRiconiscimentiAltroTitolareRappresentanteLegale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiSocioeconomiciCategorieImpresa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiSocioeconomiciCategorieImpresa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCategorieImpresa", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbDatiSocioEconomiciAltriAlbi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbDatiSocioEconomiciAltriAlbi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAltriAlbi", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblDatiSocioeconomiciFormaOrganizzativa.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblDatiSocioeconomiciFormaOrganizzativa_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoFormeOrganizzative", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbDatiSocioEconomiciCertificazioni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbDatiSocioEconomiciCertificazioni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCertificazioni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttivitaUltimoAnno.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttivitaUltimoAnno_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAttivitaUltimoAnno", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbUnitaMisuraTagliUtilizzazioneInRegione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbUnitaMisuraTagliUtilizzazioneInRegione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaMisura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbUnitaMisuraTaglioPioppetoInRegione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbUnitaMisuraTaglioPioppetoInRegione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaMisura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbUnitaMisuraTagliIntercalariInRegione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbUnitaMisuraTagliIntercalariInRegione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaMisura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbUnitaMisuraTagliUtilizzazioneFuoriRegione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbUnitaMisuraTagliUtilizzazioneFuoriRegione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaMisura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbUnitaMisuraTaglioPioppetoFuoriRegione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbUnitaMisuraTaglioPioppetoFuoriRegione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaMisura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbUnitaMisuraTagliIntercalariFuoriRegione.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbUnitaMisuraTagliIntercalariFuoriRegione_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoUnitaMisura", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttivitaUltimoAnno4.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttivitaUltimoAnno4_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMaterialePropagazione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttivitaUltimoAnno5.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttivitaUltimoAnno5_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoArboricolturaDaLegno", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttivitaFr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttivitaFr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAttivitaUltimoAnnoFr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbAttivitaLavoriPA.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAttivitaLavoriPA_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoLavoriPA", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbAttivitaLegname.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAttivitaLegname_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoLegnamiAssortimentiTrattati", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tbAttivitaLegnameFr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTbAttivitaLegnameFr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoLegnamiAssortimentiTrattati", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblStruttureCapannoni.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblStruttureCapannoni_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCapannoni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblStrutturePiazzaliStoccaggio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblStrutturePiazzaliStoccaggio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoPiazzaliStoccaggio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttrezzatureCascoForestale.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttrezzatureCascoForestale_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoCaschiForestaliAttrezzature", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttrezzatureScarponiRinforzati.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttrezzatureScarponiRinforzati_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoScarponiRinforzatiAttrezzature", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttrezzaturePantaloniAntitaglio.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttrezzaturePantaloniAntitaglio_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoPantaloniAntitaglioAttrezzature", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchinaTrattrici.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchinaTrattrici_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineTrattrici", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchineSpeciali.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchineSpeciali_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineSpeciali", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchineMovimentoATerra.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchineMovimentoATerra_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineMovimentoTerra", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchinaRimorchi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchinaRimorchi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineRimorchi", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchinaVerricelli.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchinaVerricelli_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineVerricelli", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchinaPle.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchinaPle_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchinePle", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchinaTrinciaForestale.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchinaTrinciaForestale_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineTrinciaForestali", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchineSegherieMobili.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchineSegherieMobili_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineSegheriaMobile", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchineGruACavo.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchineGruACavo_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineGruACavo", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchineCippatrici.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchineCippatrici_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineCippatrici", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMezziDiTrasporto.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMezziDiTrasporto_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMezziDiTrasporto", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAltriMezzi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAltriMezzi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAltriMezzi", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchineSpecialiFr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchineSpecialiFr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineSpecialiFr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchineMovimentoATerraFr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchineMovimentoATerraFr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineMovimentoTerraFr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchinaGrumier.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchinaGrumier_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineGrumier", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchinaRimorchiFr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchinaRimorchiFr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineRimorchiFr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblMacchinaSemi.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblMacchinaSemi_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMacchineSemi", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cmbRicercaAltroPersonale.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCmbRicercaAltroPersonale_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoPersonaleSuggerito", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAltroPersonale.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAltroPersonale_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoPersonale", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAltroPersonaleTipoContrattoFr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAltroPersonaleTipoContrattoFr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAltroPersonaleTipoContrattoFr", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAltroPersonaleTipoMansioneFr.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAltroPersonaleTipoMansioneFr_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoAltroPersonaleTipoMansioneFr", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R920050336) ENABLED START*/
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
