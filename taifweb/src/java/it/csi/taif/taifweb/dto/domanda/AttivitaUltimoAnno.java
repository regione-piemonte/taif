/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class AttivitaUltimoAnno implements java.io.Serializable {

	/// Field [idAttivita]
	private int idAttivita = 0;

	/**
	 * imposta il valore del campo [idAttivita]
	 * @param val
	 * @generated
	 */

	public void setIdAttivita(int val) {
		idAttivita = val;
	}

	/**
	 * legge il valore del campo [idAttivita]
	 * @generated
	 */
	public int getIdAttivita() {
		return idAttivita;
	}

	/// Field [percentuale]
	private java.lang.String percentuale = null;

	/**
	 * imposta il valore del campo [percentuale]
	 * @param val
	 * @generated
	 */

	public void setPercentuale(java.lang.String val) {
		percentuale = val;
	}

	/**
	 * legge il valore del campo [percentuale]
	 * @generated
	 */
	public java.lang.String getPercentuale() {
		return percentuale;
	}

	/// Field [altro]
	private java.lang.String altro = null;

	/**
	 * imposta il valore del campo [altro]
	 * @param val
	 * @generated
	 */

	public void setAltro(java.lang.String val) {
		altro = val;
	}

	/**
	 * legge il valore del campo [altro]
	 * @generated
	 */
	public java.lang.String getAltro() {
		return altro;
	}

	/// Field [altroVisibile]
	private java.lang.Boolean altroVisibile = null;

	/**
	 * imposta il valore del campo [altroVisibile]
	 * @param val
	 * @generated
	 */

	public void setAltroVisibile(java.lang.Boolean val) {
		altroVisibile = val;
	}

	/**
	 * legge il valore del campo [altroVisibile]
	 * @generated
	 */
	public java.lang.Boolean getAltroVisibile() {
		return altroVisibile;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AttivitaUltimoAnno() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1465519890) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
