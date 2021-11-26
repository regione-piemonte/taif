/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.allegato;

public class Allegato implements java.io.Serializable {

	/// Field [idAllegato]
	private int idAllegato = 0;

	/**
	 * imposta il valore del campo [idAllegato]
	 * @param val
	 * @generated
	 */

	public void setIdAllegato(int val) {
		idAllegato = val;
	}

	/**
	 * legge il valore del campo [idAllegato]
	 * @generated
	 */
	public int getIdAllegato() {
		return idAllegato;
	}

	/// Field [idTipoAllegato]
	private int idTipoAllegato = 0;

	/**
	 * imposta il valore del campo [idTipoAllegato]
	 * @param val
	 * @generated
	 */

	public void setIdTipoAllegato(int val) {
		idTipoAllegato = val;
	}

	/**
	 * legge il valore del campo [idTipoAllegato]
	 * @generated
	 */
	public int getIdTipoAllegato() {
		return idTipoAllegato;
	}

	/// Field [nomeFile]
	private java.lang.String nomeFile = null;

	/**
	 * imposta il valore del campo [nomeFile]
	 * @param val
	 * @generated
	 */

	public void setNomeFile(java.lang.String val) {
		nomeFile = val;
	}

	/**
	 * legge il valore del campo [nomeFile]
	 * @generated
	 */
	public java.lang.String getNomeFile() {
		return nomeFile;
	}

	/// Field [dimensioneFileKb]
	private java.lang.String dimensioneFileKb = null;

	/**
	 * imposta il valore del campo [dimensioneFileKb]
	 * @param val
	 * @generated
	 */

	public void setDimensioneFileKb(java.lang.String val) {
		dimensioneFileKb = val;
	}

	/**
	 * legge il valore del campo [dimensioneFileKb]
	 * @generated
	 */
	public java.lang.String getDimensioneFileKb() {
		return dimensioneFileKb;
	}

	/// Field [dataUpload]
	private java.lang.String dataUpload = null;

	/**
	 * imposta il valore del campo [dataUpload]
	 * @param val
	 * @generated
	 */

	public void setDataUpload(java.lang.String val) {
		dataUpload = val;
	}

	/**
	 * legge il valore del campo [dataUpload]
	 * @generated
	 */
	public java.lang.String getDataUpload() {
		return dataUpload;
	}

	/// Field [tipoAllegato]
	private java.lang.String tipoAllegato = null;

	/**
	 * imposta il valore del campo [tipoAllegato]
	 * @param val
	 * @generated
	 */

	public void setTipoAllegato(java.lang.String val) {
		tipoAllegato = val;
	}

	/**
	 * legge il valore del campo [tipoAllegato]
	 * @generated
	 */
	public java.lang.String getTipoAllegato() {
		return tipoAllegato;
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

	/// Field [flagFirma]
	private java.lang.String flagFirma = null;

	/**
	 * imposta il valore del campo [flagFirma]
	 * @param val
	 * @generated
	 */

	public void setFlagFirma(java.lang.String val) {
		flagFirma = val;
	}

	/**
	 * legge il valore del campo [flagFirma]
	 * @generated
	 */
	public java.lang.String getFlagFirma() {
		return flagFirma;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Allegato() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R342555948) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
