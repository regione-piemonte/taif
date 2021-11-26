/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class CategoriaImpresa implements java.io.Serializable {

	/// Field [idCategoria]
	private int idCategoria = 0;

	/**
	 * imposta il valore del campo [idCategoria]
	 * @param val
	 * @generated
	 */

	public void setIdCategoria(int val) {
		idCategoria = val;
	}

	/**
	 * legge il valore del campo [idCategoria]
	 * @generated
	 */
	public int getIdCategoria() {
		return idCategoria;
	}

	/// Field [dsCategoria]
	private java.lang.String dsCategoria = null;

	/**
	 * imposta il valore del campo [dsCategoria]
	 * @param val
	 * @generated
	 */

	public void setDsCategoria(java.lang.String val) {
		dsCategoria = val;
	}

	/**
	 * legge il valore del campo [dsCategoria]
	 * @generated
	 */
	public java.lang.String getDsCategoria() {
		return dsCategoria;
	}

	/// Field [nomeCategoria]
	private java.lang.String nomeCategoria = null;

	/**
	 * imposta il valore del campo [nomeCategoria]
	 * @param val
	 * @generated
	 */

	public void setNomeCategoria(java.lang.String val) {
		nomeCategoria = val;
	}

	/**
	 * legge il valore del campo [nomeCategoria]
	 * @generated
	 */
	public java.lang.String getNomeCategoria() {
		return nomeCategoria;
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
	public CategoriaImpresa() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R2037169444) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
