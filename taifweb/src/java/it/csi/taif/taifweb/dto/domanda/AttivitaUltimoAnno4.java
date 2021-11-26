/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class AttivitaUltimoAnno4 extends it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno
		implements
			java.io.Serializable {

	/// Field [elencoMaterialiPropagazione]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MaterialePropagazione> elencoMaterialiPropagazione = new java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MaterialePropagazione>();

	/**
	 * imposta il valore del campo [elencoMaterialiPropagazione]
	 * @param val
	 * @generated
	 */

	public void setElencoMaterialiPropagazione(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MaterialePropagazione> val) {
		elencoMaterialiPropagazione = val;
	}

	/**
	 * legge il valore del campo [elencoMaterialiPropagazione]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.MaterialePropagazione> getElencoMaterialiPropagazione() {
		return elencoMaterialiPropagazione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AttivitaUltimoAnno4() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-211742626) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
