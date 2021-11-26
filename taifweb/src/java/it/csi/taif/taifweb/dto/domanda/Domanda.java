/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class Domanda implements java.io.Serializable {

	/// Field [idDomanda]
	private int idDomanda = 0;

	/**
	 * imposta il valore del campo [idDomanda]
	 * @param val
	 * @generated
	 */

	public void setIdDomanda(int val) {
		idDomanda = val;
	}

	/**
	 * legge il valore del campo [idDomanda]
	 * @generated
	 */
	public int getIdDomanda() {
		return idDomanda;
	}

	/// Field [dsDomanda]
	private java.lang.String dsDomanda = null;

	/**
	 * imposta il valore del campo [dsDomanda]
	 * @param val
	 * @generated
	 */

	public void setDsDomanda(java.lang.String val) {
		dsDomanda = val;
	}

	/**
	 * legge il valore del campo [dsDomanda]
	 * @generated
	 */
	public java.lang.String getDsDomanda() {
		return dsDomanda;
	}

	/// Field [idStato]
	private int idStato = 0;

	/**
	 * imposta il valore del campo [idStato]
	 * @param val
	 * @generated
	 */

	public void setIdStato(int val) {
		idStato = val;
	}

	/**
	 * legge il valore del campo [idStato]
	 * @generated
	 */
	public int getIdStato() {
		return idStato;
	}

	/// Field [dsStato]
	private java.lang.String dsStato = null;

	/**
	 * imposta il valore del campo [dsStato]
	 * @param val
	 * @generated
	 */

	public void setDsStato(java.lang.String val) {
		dsStato = val;
	}

	/**
	 * legge il valore del campo [dsStato]
	 * @generated
	 */
	public java.lang.String getDsStato() {
		return dsStato;
	}

	/// Field [dsStatoFr]
	private java.lang.String dsStatoFr = null;

	/**
	 * imposta il valore del campo [dsStatoFr]
	 * @param val
	 * @generated
	 */

	public void setDsStatoFr(java.lang.String val) {
		dsStatoFr = val;
	}

	/**
	 * legge il valore del campo [dsStatoFr]
	 * @generated
	 */
	public java.lang.String getDsStatoFr() {
		return dsStatoFr;
	}

	/// Field [data]
	private java.lang.String data = null;

	/**
	 * imposta il valore del campo [data]
	 * @param val
	 * @generated
	 */

	public void setData(java.lang.String val) {
		data = val;
	}

	/**
	 * legge il valore del campo [data]
	 * @generated
	 */
	public java.lang.String getData() {
		return data;
	}

	/// Field [idAlbo]
	private int idAlbo = 0;

	/**
	 * imposta il valore del campo [idAlbo]
	 * @param val
	 * @generated
	 */

	public void setIdAlbo(int val) {
		idAlbo = val;
	}

	/**
	 * legge il valore del campo [idAlbo]
	 * @generated
	 */
	public int getIdAlbo() {
		return idAlbo;
	}

	/// Field [dsAlbo]
	private java.lang.String dsAlbo = null;

	/**
	 * imposta il valore del campo [dsAlbo]
	 * @param val
	 * @generated
	 */

	public void setDsAlbo(java.lang.String val) {
		dsAlbo = val;
	}

	/**
	 * legge il valore del campo [dsAlbo]
	 * @generated
	 */
	public java.lang.String getDsAlbo() {
		return dsAlbo;
	}

	/// Field [numeroAlbo]
	private java.lang.String numeroAlbo = null;

	/**
	 * imposta il valore del campo [numeroAlbo]
	 * @param val
	 * @generated
	 */

	public void setNumeroAlbo(java.lang.String val) {
		numeroAlbo = val;
	}

	/**
	 * legge il valore del campo [numeroAlbo]
	 * @generated
	 */
	public java.lang.String getNumeroAlbo() {
		return numeroAlbo;
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

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Domanda() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-960193926) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
