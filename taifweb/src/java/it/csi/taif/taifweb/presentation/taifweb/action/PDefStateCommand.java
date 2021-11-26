/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.action;

import java.util.Map;
import java.util.HashMap;

/**
 * La logica &egrave; l astessa di ScreenStateCommand, poich&egrave; i nomi dei widget sono espansi
 * all'inizializzazione del comando.
 */
public class PDefStateCommand extends ScreenStateCommand {

	public PDefStateCommand(String stateName, String widgetsOn[], String widgetsOff[], String widgetsShown[],
			String widgetsHidden[]) {
		super(stateName, widgetsOn, widgetsOff, widgetsShown, widgetsHidden);
	}

	/**
	 * costruttore di default
	 */
	public PDefStateCommand() {
		/// costruttore intenzionalmente vuoto
	}
}
