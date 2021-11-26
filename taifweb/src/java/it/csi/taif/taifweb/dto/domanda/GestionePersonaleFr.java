/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class GestionePersonaleFr implements java.io.Serializable {

	/// Field [numeroTotaleAddetti]
	private int numeroTotaleAddetti = 0;

	/**
	 * imposta il valore del campo [numeroTotaleAddetti]
	 * @param val
	 * @generated
	 */

	public void setNumeroTotaleAddetti(int val) {
		numeroTotaleAddetti = val;
	}

	/**
	 * legge il valore del campo [numeroTotaleAddetti]
	 * @generated
	 */
	public int getNumeroTotaleAddetti() {
		return numeroTotaleAddetti;
	}

	/// Field [numeroEquivalenti]
	private java.lang.String numeroEquivalenti = null;

	/**
	 * imposta il valore del campo [numeroEquivalenti]
	 * @param val
	 * @generated
	 */

	public void setNumeroEquivalenti(java.lang.String val) {
		numeroEquivalenti = val;
	}

	/**
	 * legge il valore del campo [numeroEquivalenti]
	 * @generated
	 */
	public java.lang.String getNumeroEquivalenti() {
		return numeroEquivalenti;
	}

	/// Field [elencoAltroPersonaleTipoContratto]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> elencoAltroPersonaleTipoContratto = new java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr>();

	/**
	 * imposta il valore del campo [elencoAltroPersonaleTipoContratto]
	 * @param val
	 * @generated
	 */

	public void setElencoAltroPersonaleTipoContratto(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> val) {
		elencoAltroPersonaleTipoContratto = val;
	}

	/**
	 * legge il valore del campo [elencoAltroPersonaleTipoContratto]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> getElencoAltroPersonaleTipoContratto() {
		return elencoAltroPersonaleTipoContratto;
	}

	/// Field [elencoAltroPersonaleTipoMansione]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> elencoAltroPersonaleTipoMansione = new java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr>();

	/**
	 * imposta il valore del campo [elencoAltroPersonaleTipoMansione]
	 * @param val
	 * @generated
	 */

	public void setElencoAltroPersonaleTipoMansione(
			java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> val) {
		elencoAltroPersonaleTipoMansione = val;
	}

	/**
	 * legge il valore del campo [elencoAltroPersonaleTipoMansione]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.PersonaleFr> getElencoAltroPersonaleTipoMansione() {
		return elencoAltroPersonaleTipoMansione;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public GestionePersonaleFr() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R514162531) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
