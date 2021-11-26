/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.common;

public class UserInfo implements java.io.Serializable {

	/// Field [nome]
	private java.lang.String nome = null;

	/**
	 * imposta il valore del campo [nome]
	 * @param val
	 * @generated
	 */

	public void setNome(java.lang.String val) {
		nome = val;
	}

	/**
	 * legge il valore del campo [nome]
	 * @generated
	 */
	public java.lang.String getNome() {
		return nome;
	}

	/// Field [cognome]
	private java.lang.String cognome = null;

	/**
	 * imposta il valore del campo [cognome]
	 * @param val
	 * @generated
	 */

	public void setCognome(java.lang.String val) {
		cognome = val;
	}

	/**
	 * legge il valore del campo [cognome]
	 * @generated
	 */
	public java.lang.String getCognome() {
		return cognome;
	}

	/// Field [codFisc]
	private java.lang.String codFisc = null;

	/**
	 * imposta il valore del campo [codFisc]
	 * @param val
	 * @generated
	 */

	public void setCodFisc(java.lang.String val) {
		codFisc = val;
	}

	/**
	 * legge il valore del campo [codFisc]
	 * @generated
	 */
	public java.lang.String getCodFisc() {
		return codFisc;
	}

	/// Field [ente]
	private java.lang.String ente = null;

	/**
	 * imposta il valore del campo [ente]
	 * @param val
	 * @generated
	 */

	public void setEnte(java.lang.String val) {
		ente = val;
	}

	/**
	 * legge il valore del campo [ente]
	 * @generated
	 */
	public java.lang.String getEnte() {
		return ente;
	}

	/// Field [ruolo]
	private java.lang.String ruolo = null;

	/**
	 * imposta il valore del campo [ruolo]
	 * @param val
	 * @generated
	 */

	public void setRuolo(java.lang.String val) {
		ruolo = val;
	}

	/**
	 * legge il valore del campo [ruolo]
	 * @generated
	 */
	public java.lang.String getRuolo() {
		return ruolo;
	}

	/// Field [idIride]
	private java.lang.String idIride = null;

	/**
	 * imposta il valore del campo [idIride]
	 * @param val
	 * @generated
	 */

	public void setIdIride(java.lang.String val) {
		idIride = val;
	}

	/**
	 * legge il valore del campo [idIride]
	 * @generated
	 */
	public java.lang.String getIdIride() {
		return idIride;
	}

	/// Field [codRuolo]
	private java.lang.String codRuolo = null;

	/**
	 * imposta il valore del campo [codRuolo]
	 * @param val
	 * @generated
	 */

	public void setCodRuolo(java.lang.String val) {
		codRuolo = val;
	}

	/**
	 * legge il valore del campo [codRuolo]
	 * @generated
	 */
	public java.lang.String getCodRuolo() {
		return codRuolo;
	}

	/// Field [lingua]
	private java.lang.String lingua = null;

	/**
	 * imposta il valore del campo [lingua]
	 * @param val
	 * @generated
	 */

	public void setLingua(java.lang.String val) {
		lingua = val;
	}

	/**
	 * legge il valore del campo [lingua]
	 * @generated
	 */
	public java.lang.String getLingua() {
		return lingua;
	}

	/// Field [profiloUtenteTaif]
	private it.csi.taif.taifweb.dto.common.ProfiloUtenteTaif profiloUtenteTaif = null;

	/**
	 * imposta il valore del campo [profiloUtenteTaif]
	 * @param val
	 * @generated
	 */

	public void setProfiloUtenteTaif(it.csi.taif.taifweb.dto.common.ProfiloUtenteTaif val) {
		profiloUtenteTaif = val;
	}

	/**
	 * legge il valore del campo [profiloUtenteTaif]
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.common.ProfiloUtenteTaif getProfiloUtenteTaif() {
		return profiloUtenteTaif;
	}

	/// Field [nazionalita]
	private java.lang.String nazionalita = null;

	/**
	 * imposta il valore del campo [nazionalita]
	 * @param val
	 * @generated
	 */

	public void setNazionalita(java.lang.String val) {
		nazionalita = val;
	}

	/**
	 * legge il valore del campo [nazionalita]
	 * @generated
	 */
	public java.lang.String getNazionalita() {
		return nazionalita;
	}

	/// Field [tipoAccesso]
	private java.lang.String tipoAccesso = null;

	/**
	 * imposta il valore del campo [tipoAccesso]
	 * @param val
	 * @generated
	 */

	public void setTipoAccesso(java.lang.String val) {
		tipoAccesso = val;
	}

	/**
	 * legge il valore del campo [tipoAccesso]
	 * @generated
	 */
	public java.lang.String getTipoAccesso() {
		return tipoAccesso;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public UserInfo() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-579808706) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
