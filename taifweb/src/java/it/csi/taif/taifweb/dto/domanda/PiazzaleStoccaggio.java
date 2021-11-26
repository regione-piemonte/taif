/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class PiazzaleStoccaggio implements java.io.Serializable {

	/// Field [idPiazzaleStoccaggio]
	private int idPiazzaleStoccaggio = 0;

	/**
	 * imposta il valore del campo [idPiazzaleStoccaggio]
	 * @param val
	 * @generated
	 */

	public void setIdPiazzaleStoccaggio(int val) {
		idPiazzaleStoccaggio = val;
	}

	/**
	 * legge il valore del campo [idPiazzaleStoccaggio]
	 * @generated
	 */
	public int getIdPiazzaleStoccaggio() {
		return idPiazzaleStoccaggio;
	}

	/// Field [dimensionePiazzale]
	private java.lang.String dimensionePiazzale = null;

	/**
	 * imposta il valore del campo [dimensionePiazzale]
	 * @param val
	 * @generated
	 */

	public void setDimensionePiazzale(java.lang.String val) {
		dimensionePiazzale = val;
	}

	/**
	 * legge il valore del campo [dimensionePiazzale]
	 * @generated
	 */
	public java.lang.String getDimensionePiazzale() {
		return dimensionePiazzale;
	}

	/// Field [annoCostruzioneORiattamentoPiazzale]
	private java.lang.String annoCostruzioneORiattamentoPiazzale = null;

	/**
	 * imposta il valore del campo [annoCostruzioneORiattamentoPiazzale]
	 * @param val
	 * @generated
	 */

	public void setAnnoCostruzioneORiattamentoPiazzale(java.lang.String val) {
		annoCostruzioneORiattamentoPiazzale = val;
	}

	/**
	 * legge il valore del campo [annoCostruzioneORiattamentoPiazzale]
	 * @generated
	 */
	public java.lang.String getAnnoCostruzioneORiattamentoPiazzale() {
		return annoCostruzioneORiattamentoPiazzale;
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

	/// Field [iconaCancella]
	private java.lang.String iconaCancella = null;

	/**
	 * imposta il valore del campo [iconaCancella]
	 * @param val
	 * @generated
	 */

	public void setIconaCancella(java.lang.String val) {
		iconaCancella = val;
	}

	/**
	 * legge il valore del campo [iconaCancella]
	 * @generated
	 */
	public java.lang.String getIconaCancella() {
		return iconaCancella;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public PiazzaleStoccaggio() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-429017387) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
