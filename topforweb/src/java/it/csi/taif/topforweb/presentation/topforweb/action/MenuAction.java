/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action;

import java.util.*;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.*;

import it.csi.taif.topforweb.dto.*;
import it.csi.taif.topforweb.business.*;
import it.csi.taif.topforweb.presentation.topforweb.command.*;
import it.csi.taif.topforweb.presentation.topforweb.interceptor.FatClientOnly;

/**
 * MenuAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
public class MenuAction extends BaseAction<GlobalMenuModel> implements ModelDriven<GlobalMenuModel> {

	private GlobalMenuModel model;

	public GlobalMenuModel getModel() {
		return model;
	}

	public void setModel(GlobalMenuModel modello) {
		this.model = modello;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		super.setSession(session);
		if (model == null) {
			model = new GlobalMenuModel();
		}
		model.setSession(session);
	}

	private Map<String, JumpExtCommand> jumpExtCommands = new HashMap<String, JumpExtCommand>();

	public Map<String, JumpExtCommand> getJumpExtCommands() {
		return jumpExtCommands;
	}

	public void setJumpExtCommands(Map<String, JumpExtCommand> jumpExtCommands) {
		this.jumpExtCommands = jumpExtCommands;
	}

	/**
	 * classe model associata
	 */
	public Class modelClass() {
		return it.csi.taif.topforweb.dto.GlobalMenuModel.class;
	}

	/**
	 *
	 * @return Il risultato delle azioni, SUCCESS altrimenti.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return SUCCESS;
	}

	public static final String ACTIVE_MENU_ATTRNAME = "active_menu";

	public void setActiveMenu(String menuName) {
		session.put(ACTIVE_MENU_ATTRNAME, "menu_items_" + menuName);
	}

	/**
	 * inizializza la struttura dei command da eseguire per ciascun event handler 
	 * di ciascun widget
	 */
	protected ICommand initCommand(String moduleName, String panelName, String sourceWidget, String eventType) {
		ICommand cmd = null;
		try {
			cmd = CommandFactory.getInstance().buildCmdStructure_internal(null, "global",
					"_" + sourceWidget.toLowerCase() + "_" + "CLICKED");
		} catch (CommandExecutionException cee) {
			LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage() + ", restituisco NOPCommand",
					cee);
			cmd = new NOPCommand();
		}
		return cmd;
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-963475072) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// non sapendo quale content panel si sta abbandonando vengono rimossi tutti
		// gli appdata a scope PAGE

	}

	protected void dumpModel(boolean pre) {
		// metodo intenzionalmente vuoto
	}

	protected void doBeforeEventCommand() {
		// il menu e' globale: non sono previsti before/after event commands
	}

	protected void doAfterEventCommand() {
		// il menu e' globale: non sono previsti before/after event commands
	}
}
