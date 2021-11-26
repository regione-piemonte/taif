/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class AziendaAAEP implements java.io.Serializable {

	/// Field [codiceAteco]
	private java.lang.String codiceAteco = null;

	/**
	 * imposta il valore del campo [codiceAteco]
	 * @param val
	 * @generated
	 */

	public void setCodiceAteco(java.lang.String val) {
		codiceAteco = val;
	}

	/**
	 * legge il valore del campo [codiceAteco]
	 * @generated
	 */
	public java.lang.String getCodiceAteco() {
		return codiceAteco;
	}

	/// Field [descrizioneAteco]
	private java.lang.String descrizioneAteco = null;

	/**
	 * imposta il valore del campo [descrizioneAteco]
	 * @param val
	 * @generated
	 */

	public void setDescrizioneAteco(java.lang.String val) {
		descrizioneAteco = val;
	}

	/**
	 * legge il valore del campo [descrizioneAteco]
	 * @generated
	 */
	public java.lang.String getDescrizioneAteco() {
		return descrizioneAteco;
	}

	/// Field [codiceFiscale]
	private java.lang.String codiceFiscale = null;

	/**
	 * imposta il valore del campo [codiceFiscale]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	/**
	 * legge il valore del campo [codiceFiscale]
	 * @generated
	 */
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
	}

	/// Field [ragioneSociale]
	private java.lang.String ragioneSociale = null;

	/**
	 * imposta il valore del campo [ragioneSociale]
	 * @param val
	 * @generated
	 */

	public void setRagioneSociale(java.lang.String val) {
		ragioneSociale = val;
	}

	/**
	 * legge il valore del campo [ragioneSociale]
	 * @generated
	 */
	public java.lang.String getRagioneSociale() {
		return ragioneSociale;
	}

	/// Field [iconaDettaglio]
	private java.lang.String iconaDettaglio = null;

	/**
	 * imposta il valore del campo [iconaDettaglio]
	 * @param val
	 * @generated
	 */

	public void setIconaDettaglio(java.lang.String val) {
		iconaDettaglio = val;
	}

	/**
	 * legge il valore del campo [iconaDettaglio]
	 * @generated
	 */
	public java.lang.String getIconaDettaglio() {
		return iconaDettaglio;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AziendaAAEP() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-211418417) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
