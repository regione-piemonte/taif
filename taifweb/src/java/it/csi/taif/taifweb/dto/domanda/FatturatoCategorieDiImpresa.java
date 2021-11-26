/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class FatturatoCategorieDiImpresa implements java.io.Serializable {

	/// Field [annoInizioAttivita]
	private java.lang.String annoInizioAttivita = null;

	/**
	 * imposta il valore del campo [annoInizioAttivita]
	 * @param val
	 * @generated
	 */

	public void setAnnoInizioAttivita(java.lang.String val) {
		annoInizioAttivita = val;
	}

	/**
	 * legge il valore del campo [annoInizioAttivita]
	 * @generated
	 */
	public java.lang.String getAnnoInizioAttivita() {
		return annoInizioAttivita;
	}

	/// Field [fatturatoUltimoAnno]
	private java.lang.String fatturatoUltimoAnno = null;

	/**
	 * imposta il valore del campo [fatturatoUltimoAnno]
	 * @param val
	 * @generated
	 */

	public void setFatturatoUltimoAnno(java.lang.String val) {
		fatturatoUltimoAnno = val;
	}

	/**
	 * legge il valore del campo [fatturatoUltimoAnno]
	 * @generated
	 */
	public java.lang.String getFatturatoUltimoAnno() {
		return fatturatoUltimoAnno;
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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public FatturatoCategorieDiImpresa() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-907503869) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
