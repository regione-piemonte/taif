/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action;

/**
 * Interfaccia comune di tutte le azioni di presentation
 *
 */
public interface ICommand extends java.io.Serializable {
	/**
	 * Esegue l'azione corrispondente
	 * @return il codice del RESULT struts conseguente all'azione (se l'azione comporta)
	 * una decisione sul result, null altrimenti
	 */
	public String doCommand(BaseAction strutsAction) throws CommandExecutionException;
};
