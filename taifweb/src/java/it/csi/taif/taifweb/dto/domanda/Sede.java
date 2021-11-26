/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class Sede implements java.io.Serializable {

	/// Field [idSede]
	private int idSede = 0;

	/**
	 * imposta il valore del campo [idSede]
	 * @param val
	 * @generated
	 */

	public void setIdSede(int val) {
		idSede = val;
	}

	/**
	 * legge il valore del campo [idSede]
	 * @generated
	 */
	public int getIdSede() {
		return idSede;
	}

	/// Field [idTipoSede]
	private int idTipoSede = 0;

	/**
	 * imposta il valore del campo [idTipoSede]
	 * @param val
	 * @generated
	 */

	public void setIdTipoSede(int val) {
		idTipoSede = val;
	}

	/**
	 * legge il valore del campo [idTipoSede]
	 * @generated
	 */
	public int getIdTipoSede() {
		return idTipoSede;
	}

	/// Field [dsTipoSede]
	private java.lang.String dsTipoSede = null;

	/**
	 * imposta il valore del campo [dsTipoSede]
	 * @param val
	 * @generated
	 */

	public void setDsTipoSede(java.lang.String val) {
		dsTipoSede = val;
	}

	/**
	 * legge il valore del campo [dsTipoSede]
	 * @generated
	 */
	public java.lang.String getDsTipoSede() {
		return dsTipoSede;
	}

	/// Field [idComune]
	private java.lang.String idComune = null;

	/**
	 * imposta il valore del campo [idComune]
	 * @param val
	 * @generated
	 */

	public void setIdComune(java.lang.String val) {
		idComune = val;
	}

	/**
	 * legge il valore del campo [idComune]
	 * @generated
	 */
	public java.lang.String getIdComune() {
		return idComune;
	}

	/// Field [dsComune]
	private java.lang.String dsComune = null;

	/**
	 * imposta il valore del campo [dsComune]
	 * @param val
	 * @generated
	 */

	public void setDsComune(java.lang.String val) {
		dsComune = val;
	}

	/**
	 * legge il valore del campo [dsComune]
	 * @generated
	 */
	public java.lang.String getDsComune() {
		return dsComune;
	}

	/// Field [elencoComuni]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoComuni = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoComuni]
	 * @param val
	 * @generated
	 */

	public void setElencoComuni(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoComuni = val;
	}

	/**
	 * legge il valore del campo [elencoComuni]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoComuni() {
		return elencoComuni;
	}

	/// Field [cap]
	private java.lang.String cap = null;

	/**
	 * imposta il valore del campo [cap]
	 * @param val
	 * @generated
	 */

	public void setCap(java.lang.String val) {
		cap = val;
	}

	/**
	 * legge il valore del campo [cap]
	 * @generated
	 */
	public java.lang.String getCap() {
		return cap;
	}

	/// Field [indirizzo]
	private java.lang.String indirizzo = null;

	/**
	 * imposta il valore del campo [indirizzo]
	 * @param val
	 * @generated
	 */

	public void setIndirizzo(java.lang.String val) {
		indirizzo = val;
	}

	/**
	 * legge il valore del campo [indirizzo]
	 * @generated
	 */
	public java.lang.String getIndirizzo() {
		return indirizzo;
	}

	/// Field [numeroCivico]
	private java.lang.String numeroCivico = null;

	/**
	 * imposta il valore del campo [numeroCivico]
	 * @param val
	 * @generated
	 */

	public void setNumeroCivico(java.lang.String val) {
		numeroCivico = val;
	}

	/**
	 * legge il valore del campo [numeroCivico]
	 * @generated
	 */
	public java.lang.String getNumeroCivico() {
		return numeroCivico;
	}

	/// Field [telefono]
	private java.lang.String telefono = null;

	/**
	 * imposta il valore del campo [telefono]
	 * @param val
	 * @generated
	 */

	public void setTelefono(java.lang.String val) {
		telefono = val;
	}

	/**
	 * legge il valore del campo [telefono]
	 * @generated
	 */
	public java.lang.String getTelefono() {
		return telefono;
	}

	/// Field [elencoTipoSede]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoTipoSede = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoTipoSede]
	 * @param val
	 * @generated
	 */

	public void setElencoTipoSede(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoTipoSede = val;
	}

	/**
	 * legge il valore del campo [elencoTipoSede]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoTipoSede() {
		return elencoTipoSede;
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

	/// Field [iconaAggiungi]
	private java.lang.String iconaAggiungi = null;

	/**
	 * imposta il valore del campo [iconaAggiungi]
	 * @param val
	 * @generated
	 */

	public void setIconaAggiungi(java.lang.String val) {
		iconaAggiungi = val;
	}

	/**
	 * legge il valore del campo [iconaAggiungi]
	 * @generated
	 */
	public java.lang.String getIconaAggiungi() {
		return iconaAggiungi;
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

	/// Field [istatComuneSede]
	private java.lang.String istatComuneSede = null;

	/**
	 * imposta il valore del campo [istatComuneSede]
	 * @param val
	 * @generated
	 */

	public void setIstatComuneSede(java.lang.String val) {
		istatComuneSede = val;
	}

	/**
	 * legge il valore del campo [istatComuneSede]
	 * @generated
	 */
	public java.lang.String getIstatComuneSede() {
		return istatComuneSede;
	}

	/// Field [cellulare]
	private java.lang.String cellulare = null;

	/**
	 * imposta il valore del campo [cellulare]
	 * @param val
	 * @generated
	 */

	public void setCellulare(java.lang.String val) {
		cellulare = val;
	}

	/**
	 * legge il valore del campo [cellulare]
	 * @generated
	 */
	public java.lang.String getCellulare() {
		return cellulare;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Sede() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-156915043) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
