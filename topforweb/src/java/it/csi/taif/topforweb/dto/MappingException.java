/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto;

/**
 * Classe di eccezione sollevata in caso di problemi di mapping
 */
public class MappingException extends Exception {

	/**
	 * costruttore vuoto
	 */
	public MappingException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public MappingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public MappingException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public MappingException(Throwable cause) {
		super(cause);
	}

}
