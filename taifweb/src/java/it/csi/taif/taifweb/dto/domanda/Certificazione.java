/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class Certificazione implements java.io.Serializable {

	/// Field [idCertificazione]
	private int idCertificazione = 0;

	/**
	 * imposta il valore del campo [idCertificazione]
	 * @param val
	 * @generated
	 */

	public void setIdCertificazione(int val) {
		idCertificazione = val;
	}

	/**
	 * legge il valore del campo [idCertificazione]
	 * @generated
	 */
	public int getIdCertificazione() {
		return idCertificazione;
	}

	/// Field [idTipoCertificazione]
	private int idTipoCertificazione = 0;

	/**
	 * imposta il valore del campo [idTipoCertificazione]
	 * @param val
	 * @generated
	 */

	public void setIdTipoCertificazione(int val) {
		idTipoCertificazione = val;
	}

	/**
	 * legge il valore del campo [idTipoCertificazione]
	 * @generated
	 */
	public int getIdTipoCertificazione() {
		return idTipoCertificazione;
	}

	/// Field [dsTipoCertificazione]
	private java.lang.String dsTipoCertificazione = null;

	/**
	 * imposta il valore del campo [dsTipoCertificazione]
	 * @param val
	 * @generated
	 */

	public void setDsTipoCertificazione(java.lang.String val) {
		dsTipoCertificazione = val;
	}

	/**
	 * legge il valore del campo [dsTipoCertificazione]
	 * @generated
	 */
	public java.lang.String getDsTipoCertificazione() {
		return dsTipoCertificazione;
	}

	/// Field [numero]
	private java.lang.String numero = null;

	/**
	 * imposta il valore del campo [numero]
	 * @param val
	 * @generated
	 */

	public void setNumero(java.lang.String val) {
		numero = val;
	}

	/**
	 * legge il valore del campo [numero]
	 * @generated
	 */
	public java.lang.String getNumero() {
		return numero;
	}

	/// Field [enteCertificatore]
	private java.lang.String enteCertificatore = null;

	/**
	 * imposta il valore del campo [enteCertificatore]
	 * @param val
	 * @generated
	 */

	public void setEnteCertificatore(java.lang.String val) {
		enteCertificatore = val;
	}

	/**
	 * legge il valore del campo [enteCertificatore]
	 * @generated
	 */
	public java.lang.String getEnteCertificatore() {
		return enteCertificatore;
	}

	/// Field [annoRilascio]
	private java.lang.String annoRilascio = null;

	/**
	 * imposta il valore del campo [annoRilascio]
	 * @param val
	 * @generated
	 */

	public void setAnnoRilascio(java.lang.String val) {
		annoRilascio = val;
	}

	/**
	 * legge il valore del campo [annoRilascio]
	 * @generated
	 */
	public java.lang.String getAnnoRilascio() {
		return annoRilascio;
	}

	/// Field [dataScadenza]
	private java.lang.String dataScadenza = null;

	/**
	 * imposta il valore del campo [dataScadenza]
	 * @param val
	 * @generated
	 */

	public void setDataScadenza(java.lang.String val) {
		dataScadenza = val;
	}

	/**
	 * legge il valore del campo [dataScadenza]
	 * @generated
	 */
	public java.lang.String getDataScadenza() {
		return dataScadenza;
	}

	/// Field [elencoTipoCertificazione]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoTipoCertificazione = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoTipoCertificazione]
	 * @param val
	 * @generated
	 */

	public void setElencoTipoCertificazione(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoTipoCertificazione = val;
	}

	/**
	 * legge il valore del campo [elencoTipoCertificazione]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoTipoCertificazione() {
		return elencoTipoCertificazione;
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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Certificazione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1311166277) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
