/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class Attivita implements java.io.Serializable {

	/// Field [idAttivita]
	private int idAttivita = 0;

	/**
	 * imposta il valore del campo [idAttivita]
	 * @param val
	 * @generated
	 */

	public void setIdAttivita(int val) {
		idAttivita = val;
	}

	/**
	 * legge il valore del campo [idAttivita]
	 * @generated
	 */
	public int getIdAttivita() {
		return idAttivita;
	}

	/// Field [dsAttivita]
	private java.lang.String dsAttivita = null;

	/**
	 * imposta il valore del campo [dsAttivita]
	 * @param val
	 * @generated
	 */

	public void setDsAttivita(java.lang.String val) {
		dsAttivita = val;
	}

	/**
	 * legge il valore del campo [dsAttivita]
	 * @generated
	 */
	public java.lang.String getDsAttivita() {
		return dsAttivita;
	}

	/// Field [fatturato]
	private java.lang.String fatturato = null;

	/**
	 * imposta il valore del campo [fatturato]
	 * @param val
	 * @generated
	 */

	public void setFatturato(java.lang.String val) {
		fatturato = val;
	}

	/**
	 * legge il valore del campo [fatturato]
	 * @generated
	 */
	public java.lang.String getFatturato() {
		return fatturato;
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

	/// Field [iconaDettaglioVisibile]
	private boolean iconaDettaglioVisibile = false;

	/**
	 * imposta il valore del campo [iconaDettaglioVisibile]
	 * @param val
	 * @generated
	 */

	public void setIconaDettaglioVisibile(boolean val) {
		iconaDettaglioVisibile = val;
	}

	/**
	 * legge il valore del campo [iconaDettaglioVisibile]
	 * @generated
	 */
	public boolean getIconaDettaglioVisibile() {
		return iconaDettaglioVisibile;
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
	public Attivita() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1370269038) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
