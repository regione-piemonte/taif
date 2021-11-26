/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class Stato implements java.io.Serializable {

	/// Field [idStatoDomanda]
	private java.lang.String idStatoDomanda = null;

	/**
	 * imposta il valore del campo [idStatoDomanda]
	 * @param val
	 * @generated
	 */

	public void setIdStatoDomanda(java.lang.String val) {
		idStatoDomanda = val;
	}

	/**
	 * legge il valore del campo [idStatoDomanda]
	 * @generated
	 */
	public java.lang.String getIdStatoDomanda() {
		return idStatoDomanda;
	}

	/// Field [dsStatoDomanda]
	private java.lang.String dsStatoDomanda = null;

	/**
	 * imposta il valore del campo [dsStatoDomanda]
	 * @param val
	 * @generated
	 */

	public void setDsStatoDomanda(java.lang.String val) {
		dsStatoDomanda = val;
	}

	/**
	 * legge il valore del campo [dsStatoDomanda]
	 * @generated
	 */
	public java.lang.String getDsStatoDomanda() {
		return dsStatoDomanda;
	}

	/// Field [numeroProtocollo]
	private java.lang.String numeroProtocollo = null;

	/**
	 * imposta il valore del campo [numeroProtocollo]
	 * @param val
	 * @generated
	 */

	public void setNumeroProtocollo(java.lang.String val) {
		numeroProtocollo = val;
	}

	/**
	 * legge il valore del campo [numeroProtocollo]
	 * @generated
	 */
	public java.lang.String getNumeroProtocollo() {
		return numeroProtocollo;
	}

	/// Field [note]
	private java.lang.String note = null;

	/**
	 * imposta il valore del campo [note]
	 * @param val
	 * @generated
	 */

	public void setNote(java.lang.String val) {
		note = val;
	}

	/**
	 * legge il valore del campo [note]
	 * @generated
	 */
	public java.lang.String getNote() {
		return note;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Stato() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1775871255) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
