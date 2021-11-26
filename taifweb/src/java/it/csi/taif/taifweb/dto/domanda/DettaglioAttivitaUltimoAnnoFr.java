/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class DettaglioAttivitaUltimoAnnoFr implements java.io.Serializable {

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

	/// Field [percentuale]
	private java.lang.String percentuale = null;

	/**
	 * imposta il valore del campo [percentuale]
	 * @param val
	 * @generated
	 */

	public void setPercentuale(java.lang.String val) {
		percentuale = val;
	}

	/**
	 * legge il valore del campo [percentuale]
	 * @generated
	 */
	public java.lang.String getPercentuale() {
		return percentuale;
	}

	/// Field [descrizione]
	private java.lang.String descrizione = null;

	/**
	 * imposta il valore del campo [descrizione]
	 * @param val
	 * @generated
	 */

	public void setDescrizione(java.lang.String val) {
		descrizione = val;
	}

	/**
	 * legge il valore del campo [descrizione]
	 * @generated
	 */
	public java.lang.String getDescrizione() {
		return descrizione;
	}

	/// Field [volume]
	private java.lang.String volume = null;

	/**
	 * imposta il valore del campo [volume]
	 * @param val
	 * @generated
	 */

	public void setVolume(java.lang.String val) {
		volume = val;
	}

	/**
	 * legge il valore del campo [volume]
	 * @generated
	 */
	public java.lang.String getVolume() {
		return volume;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DettaglioAttivitaUltimoAnnoFr() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-453361271) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
