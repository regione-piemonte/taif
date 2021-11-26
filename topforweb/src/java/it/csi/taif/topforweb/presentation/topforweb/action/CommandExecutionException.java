/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.action;

/**
 * Eccezione rilanciatain caso di errori durante l'esecuzione della
 * catena di comandi.
 *
 */
public class CommandExecutionException extends Exception {
	public CommandExecutionException(String msg, Throwable nested) {
		super(msg, nested);
	}

	public CommandExecutionException(String msg) {
		super(msg);
	}
};
