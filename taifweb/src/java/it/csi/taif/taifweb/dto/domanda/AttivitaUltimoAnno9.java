/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class AttivitaUltimoAnno9 extends it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno
		implements
			java.io.Serializable {

	/// Field [realizzazione]
	private java.lang.String realizzazione = null;

	/**
	 * imposta il valore del campo [realizzazione]
	 * @param val
	 * @generated
	 */

	public void setRealizzazione(java.lang.String val) {
		realizzazione = val;
	}

	/**
	 * legge il valore del campo [realizzazione]
	 * @generated
	 */
	public java.lang.String getRealizzazione() {
		return realizzazione;
	}

	/// Field [manutenzione]
	private java.lang.String manutenzione = null;

	/**
	 * imposta il valore del campo [manutenzione]
	 * @param val
	 * @generated
	 */

	public void setManutenzione(java.lang.String val) {
		manutenzione = val;
	}

	/**
	 * legge il valore del campo [manutenzione]
	 * @generated
	 */
	public java.lang.String getManutenzione() {
		return manutenzione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AttivitaUltimoAnno9() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-659080349) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
