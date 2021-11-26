/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto.common;

public class ProfiloUtenteTopFor implements java.io.Serializable {

	/// Field [idProfilo]
	private java.lang.String idProfilo = null;

	/**
	 * imposta il valore del campo [idProfilo]
	 * @param val
	 * @generated
	 */

	public void setIdProfilo(java.lang.String val) {
		idProfilo = val;
	}

	/**
	 * legge il valore del campo [idProfilo]
	 * @generated
	 */
	public java.lang.String getIdProfilo() {
		return idProfilo;
	}

	/// Field [dsProfilo]
	private java.lang.String dsProfilo = null;

	/**
	 * imposta il valore del campo [dsProfilo]
	 * @param val
	 * @generated
	 */

	public void setDsProfilo(java.lang.String val) {
		dsProfilo = val;
	}

	/**
	 * legge il valore del campo [dsProfilo]
	 * @generated
	 */
	public java.lang.String getDsProfilo() {
		return dsProfilo;
	}

	/// Field [idSoggettoGestore]
	private java.lang.Integer idSoggettoGestore = null;

	/**
	 * imposta il valore del campo [idSoggettoGestore]
	 * @param val
	 * @generated
	 */

	public void setIdSoggettoGestore(java.lang.Integer val) {
		idSoggettoGestore = val;
	}

	/**
	 * legge il valore del campo [idSoggettoGestore]
	 * @generated
	 */
	public java.lang.Integer getIdSoggettoGestore() {
		return idSoggettoGestore;
	}

	/// Field [idConfigUtente]
	private java.lang.Integer idConfigUtente = null;

	/**
	 * imposta il valore del campo [idConfigUtente]
	 * @param val
	 * @generated
	 */

	public void setIdConfigUtente(java.lang.Integer val) {
		idConfigUtente = val;
	}

	/**
	 * legge il valore del campo [idConfigUtente]
	 * @generated
	 */
	public java.lang.Integer getIdConfigUtente() {
		return idConfigUtente;
	}

	/// Field [accessi]
	private java.lang.Integer accessi = null;

	/**
	 * imposta il valore del campo [accessi]
	 * @param val
	 * @generated
	 */

	public void setAccessi(java.lang.Integer val) {
		accessi = val;
	}

	/**
	 * legge il valore del campo [accessi]
	 * @generated
	 */
	public java.lang.Integer getAccessi() {
		return accessi;
	}

	/// Field [idPersona]
	private java.lang.Integer idPersona = null;

	/**
	 * imposta il valore del campo [idPersona]
	 * @param val
	 * @generated
	 */

	public void setIdPersona(java.lang.Integer val) {
		idPersona = val;
	}

	/**
	 * legge il valore del campo [idPersona]
	 * @generated
	 */
	public java.lang.Integer getIdPersona() {
		return idPersona;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public ProfiloUtenteTopFor() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-2142479117) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
