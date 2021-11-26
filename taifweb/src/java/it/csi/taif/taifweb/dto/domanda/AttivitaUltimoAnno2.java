/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class AttivitaUltimoAnno2 extends it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno
		implements
			java.io.Serializable {

	/// Field [ettariRealizzati]
	private java.lang.String ettariRealizzati = null;

	/**
	 * imposta il valore del campo [ettariRealizzati]
	 * @param val
	 * @generated
	 */

	public void setEttariRealizzati(java.lang.String val) {
		ettariRealizzati = val;
	}

	/**
	 * legge il valore del campo [ettariRealizzati]
	 * @generated
	 */
	public java.lang.String getEttariRealizzati() {
		return ettariRealizzati;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AttivitaUltimoAnno2() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-891800996) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
