/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto.common;

public class LoginInfo implements java.io.Serializable {

	/// Field [user]
	private java.lang.String user = null;

	/**
	 * imposta il valore del campo [user]
	 * @param val
	 * @generated
	 */

	public void setUser(java.lang.String val) {
		user = val;
	}

	/**
	 * legge il valore del campo [user]
	 * @generated
	 */
	public java.lang.String getUser() {
		return user;
	}

	/// Field [password]
	private java.lang.String password = null;

	/**
	 * imposta il valore del campo [password]
	 * @param val
	 * @generated
	 */

	public void setPassword(java.lang.String val) {
		password = val;
	}

	/**
	 * legge il valore del campo [password]
	 * @generated
	 */
	public java.lang.String getPassword() {
		return password;
	}

	/// Field [pin]
	private java.lang.String pin = null;

	/**
	 * imposta il valore del campo [pin]
	 * @param val
	 * @generated
	 */

	public void setPin(java.lang.String val) {
		pin = val;
	}

	/**
	 * legge il valore del campo [pin]
	 * @generated
	 */
	public java.lang.String getPin() {
		return pin;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public LoginInfo() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1463159946) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
