/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class PersonaleFr implements java.io.Serializable {

	/// Field [idTipologia]
	private int idTipologia = 0;

	/**
	 * imposta il valore del campo [idTipologia]
	 * @param val
	 * @generated
	 */

	public void setIdTipologia(int val) {
		idTipologia = val;
	}

	/**
	 * legge il valore del campo [idTipologia]
	 * @generated
	 */
	public int getIdTipologia() {
		return idTipologia;
	}

	/// Field [dsTipologia]
	private java.lang.String dsTipologia = null;

	/**
	 * imposta il valore del campo [dsTipologia]
	 * @param val
	 * @generated
	 */

	public void setDsTipologia(java.lang.String val) {
		dsTipologia = val;
	}

	/**
	 * legge il valore del campo [dsTipologia]
	 * @generated
	 */
	public java.lang.String getDsTipologia() {
		return dsTipologia;
	}

	/// Field [numeroAddetti]
	private int numeroAddetti = 0;

	/**
	 * imposta il valore del campo [numeroAddetti]
	 * @param val
	 * @generated
	 */

	public void setNumeroAddetti(int val) {
		numeroAddetti = val;
	}

	/**
	 * legge il valore del campo [numeroAddetti]
	 * @generated
	 */
	public int getNumeroAddetti() {
		return numeroAddetti;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public PersonaleFr() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R423789727) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
