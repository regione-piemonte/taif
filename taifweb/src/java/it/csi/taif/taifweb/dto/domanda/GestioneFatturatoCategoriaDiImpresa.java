/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class GestioneFatturatoCategoriaDiImpresa implements java.io.Serializable {

	/// Field [fatturato]
	private it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa fatturato = null;

	/**
	 * imposta il valore del campo [fatturato]
	 * @param val
	 * @generated
	 */

	public void setFatturato(it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa val) {
		fatturato = val;
	}

	/**
	 * legge il valore del campo [fatturato]
	 * @generated
	 */
	public it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa getFatturato() {
		return fatturato;
	}

	/// Field [elencoCategorieImpresa]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.CategoriaImpresa> elencoCategorieImpresa = new java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.CategoriaImpresa>();

	/**
	 * imposta il valore del campo [elencoCategorieImpresa]
	 * @param val
	 * @generated
	 */

	public void setElencoCategorieImpresa(java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.CategoriaImpresa> val) {
		elencoCategorieImpresa = val;
	}

	/**
	 * legge il valore del campo [elencoCategorieImpresa]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.domanda.CategoriaImpresa> getElencoCategorieImpresa() {
		return elencoCategorieImpresa;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public GestioneFatturatoCategoriaDiImpresa() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1574830411) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
