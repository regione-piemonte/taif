/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class MaterialePropagazione implements java.io.Serializable {

	/// Field [idMaterialePropagazione]
	private int idMaterialePropagazione = 0;

	/**
	 * imposta il valore del campo [idMaterialePropagazione]
	 * @param val
	 * @generated
	 */

	public void setIdMaterialePropagazione(int val) {
		idMaterialePropagazione = val;
	}

	/**
	 * legge il valore del campo [idMaterialePropagazione]
	 * @generated
	 */
	public int getIdMaterialePropagazione() {
		return idMaterialePropagazione;
	}

	/// Field [dsMaterialePropagazione]
	private java.lang.String dsMaterialePropagazione = null;

	/**
	 * imposta il valore del campo [dsMaterialePropagazione]
	 * @param val
	 * @generated
	 */

	public void setDsMaterialePropagazione(java.lang.String val) {
		dsMaterialePropagazione = val;
	}

	/**
	 * legge il valore del campo [dsMaterialePropagazione]
	 * @generated
	 */
	public java.lang.String getDsMaterialePropagazione() {
		return dsMaterialePropagazione;
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
	private boolean altroVisibile = false;

	/**
	 * imposta il valore del campo [altroVisibile]
	 * @param val
	 * @generated
	 */

	public void setAltroVisibile(boolean val) {
		altroVisibile = val;
	}

	/**
	 * legge il valore del campo [altroVisibile]
	 * @generated
	 */
	public boolean getAltroVisibile() {
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
	public MaterialePropagazione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1085202261) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
