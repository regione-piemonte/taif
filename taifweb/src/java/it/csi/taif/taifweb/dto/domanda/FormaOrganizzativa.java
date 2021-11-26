/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class FormaOrganizzativa implements java.io.Serializable {

	/// Field [idFormaOrganizzativa]
	private int idFormaOrganizzativa = 0;

	/**
	 * imposta il valore del campo [idFormaOrganizzativa]
	 * @param val
	 * @generated
	 */

	public void setIdFormaOrganizzativa(int val) {
		idFormaOrganizzativa = val;
	}

	/**
	 * legge il valore del campo [idFormaOrganizzativa]
	 * @generated
	 */
	public int getIdFormaOrganizzativa() {
		return idFormaOrganizzativa;
	}

	/// Field [dsFormaOrganizzativa]
	private java.lang.String dsFormaOrganizzativa = null;

	/**
	 * imposta il valore del campo [dsFormaOrganizzativa]
	 * @param val
	 * @generated
	 */

	public void setDsFormaOrganizzativa(java.lang.String val) {
		dsFormaOrganizzativa = val;
	}

	/**
	 * legge il valore del campo [dsFormaOrganizzativa]
	 * @generated
	 */
	public java.lang.String getDsFormaOrganizzativa() {
		return dsFormaOrganizzativa;
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

	/// Field [rownum]
	private int rownum = 0;

	/**
	 * imposta il valore del campo [rownum]
	 * @param val
	 * @generated
	 */

	public void setRownum(int val) {
		rownum = val;
	}

	/**
	 * legge il valore del campo [rownum]
	 * @generated
	 */
	public int getRownum() {
		return rownum;
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
	public FormaOrganizzativa() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1308991818) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
