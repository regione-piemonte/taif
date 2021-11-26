/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class AttivitaUltimoAnnoFr implements java.io.Serializable {

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

	/// Field [elencoAttivitaFr]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr> elencoAttivitaFr = new java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr>();

	/**
	 * imposta il valore del campo [elencoAttivitaFr]
	 * @param val
	 * @generated
	 */

	public void setElencoAttivitaFr(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr> val) {
		elencoAttivitaFr = val;
	}

	/**
	 * legge il valore del campo [elencoAttivitaFr]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr> getElencoAttivitaFr() {
		return elencoAttivitaFr;
	}

	/// Field [cliente1Fr]
	private java.lang.String cliente1Fr = null;

	/**
	 * imposta il valore del campo [cliente1Fr]
	 * @param val
	 * @generated
	 */

	public void setCliente1Fr(java.lang.String val) {
		cliente1Fr = val;
	}

	/**
	 * legge il valore del campo [cliente1Fr]
	 * @generated
	 */
	public java.lang.String getCliente1Fr() {
		return cliente1Fr;
	}

	/// Field [cliente2Fr]
	private java.lang.String cliente2Fr = null;

	/**
	 * imposta il valore del campo [cliente2Fr]
	 * @param val
	 * @generated
	 */

	public void setCliente2Fr(java.lang.String val) {
		cliente2Fr = val;
	}

	/**
	 * legge il valore del campo [cliente2Fr]
	 * @generated
	 */
	public java.lang.String getCliente2Fr() {
		return cliente2Fr;
	}

	/// Field [cliente3Fr]
	private java.lang.String cliente3Fr = null;

	/**
	 * imposta il valore del campo [cliente3Fr]
	 * @param val
	 * @generated
	 */

	public void setCliente3Fr(java.lang.String val) {
		cliente3Fr = val;
	}

	/**
	 * legge il valore del campo [cliente3Fr]
	 * @generated
	 */
	public java.lang.String getCliente3Fr() {
		return cliente3Fr;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public AttivitaUltimoAnnoFr() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R365344090) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
