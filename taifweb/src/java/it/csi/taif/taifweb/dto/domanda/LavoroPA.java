/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class LavoroPA implements java.io.Serializable {

	/// Field [idLavoroPA]
	private int idLavoroPA = 0;

	/**
	 * imposta il valore del campo [idLavoroPA]
	 * @param val
	 * @generated
	 */

	public void setIdLavoroPA(int val) {
		idLavoroPA = val;
	}

	/**
	 * legge il valore del campo [idLavoroPA]
	 * @generated
	 */
	public int getIdLavoroPA() {
		return idLavoroPA;
	}

	/// Field [committente]
	private java.lang.String committente = null;

	/**
	 * imposta il valore del campo [committente]
	 * @param val
	 * @generated
	 */

	public void setCommittente(java.lang.String val) {
		committente = val;
	}

	/**
	 * legge il valore del campo [committente]
	 * @generated
	 */
	public java.lang.String getCommittente() {
		return committente;
	}

	/// Field [idOggettoIntervento]
	private int idOggettoIntervento = 0;

	/**
	 * imposta il valore del campo [idOggettoIntervento]
	 * @param val
	 * @generated
	 */

	public void setIdOggettoIntervento(int val) {
		idOggettoIntervento = val;
	}

	/**
	 * legge il valore del campo [idOggettoIntervento]
	 * @generated
	 */
	public int getIdOggettoIntervento() {
		return idOggettoIntervento;
	}

	/// Field [dsOggettoIntervento]
	private java.lang.String dsOggettoIntervento = null;

	/**
	 * imposta il valore del campo [dsOggettoIntervento]
	 * @param val
	 * @generated
	 */

	public void setDsOggettoIntervento(java.lang.String val) {
		dsOggettoIntervento = val;
	}

	/**
	 * legge il valore del campo [dsOggettoIntervento]
	 * @generated
	 */
	public java.lang.String getDsOggettoIntervento() {
		return dsOggettoIntervento;
	}

	/// Field [elencoOggettiIntervento]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoOggettiIntervento = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoOggettiIntervento]
	 * @param val
	 * @generated
	 */

	public void setElencoOggettiIntervento(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoOggettiIntervento = val;
	}

	/**
	 * legge il valore del campo [elencoOggettiIntervento]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoOggettiIntervento() {
		return elencoOggettiIntervento;
	}

	/// Field [importoComplessivo]
	private int importoComplessivo = 0;

	/**
	 * imposta il valore del campo [importoComplessivo]
	 * @param val
	 * @generated
	 */

	public void setImportoComplessivo(int val) {
		importoComplessivo = val;
	}

	/**
	 * legge il valore del campo [importoComplessivo]
	 * @generated
	 */
	public int getImportoComplessivo() {
		return importoComplessivo;
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
	public LavoroPA() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1966043866) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
