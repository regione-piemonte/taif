/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.allegatodownload;

public class AllegatoDownload implements java.io.Serializable {

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

	/// Field [iconaDownload]
	private java.lang.String iconaDownload = null;

	/**
	 * imposta il valore del campo [iconaDownload]
	 * @param val
	 * @generated
	 */

	public void setIconaDownload(java.lang.String val) {
		iconaDownload = val;
	}

	/**
	 * legge il valore del campo [iconaDownload]
	 * @generated
	 */
	public java.lang.String getIconaDownload() {
		return iconaDownload;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AllegatoDownload() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1754274652) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
