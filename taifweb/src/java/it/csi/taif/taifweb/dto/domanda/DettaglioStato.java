/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class DettaglioStato extends it.csi.taif.taifweb.dto.domanda.Stato implements java.io.Serializable {

	/// Field [dataProtocollo]
	private java.lang.String dataProtocollo = null;

	/**
	 * imposta il valore del campo [dataProtocollo]
	 * @param val
	 * @generated
	 */

	public void setDataProtocollo(java.lang.String val) {
		dataProtocollo = val;
	}

	/**
	 * legge il valore del campo [dataProtocollo]
	 * @generated
	 */
	public java.lang.String getDataProtocollo() {
		return dataProtocollo;
	}

	/// Field [dataUltimaModifica]
	private java.lang.String dataUltimaModifica = null;

	/**
	 * imposta il valore del campo [dataUltimaModifica]
	 * @param val
	 * @generated
	 */

	public void setDataUltimaModifica(java.lang.String val) {
		dataUltimaModifica = val;
	}

	/**
	 * legge il valore del campo [dataUltimaModifica]
	 * @generated
	 */
	public java.lang.String getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	/// Field [operatoreUltimaModifica]
	private java.lang.String operatoreUltimaModifica = null;

	/**
	 * imposta il valore del campo [operatoreUltimaModifica]
	 * @param val
	 * @generated
	 */

	public void setOperatoreUltimaModifica(java.lang.String val) {
		operatoreUltimaModifica = val;
	}

	/**
	 * legge il valore del campo [operatoreUltimaModifica]
	 * @generated
	 */
	public java.lang.String getOperatoreUltimaModifica() {
		return operatoreUltimaModifica;
	}

	/// Field [elencoStatiDomanda]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoStatiDomanda = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoStatiDomanda]
	 * @param val
	 * @generated
	 */

	public void setElencoStatiDomanda(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoStatiDomanda = val;
	}

	/**
	 * legge il valore del campo [elencoStatiDomanda]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoStatiDomanda() {
		return elencoStatiDomanda;
	}

	/// Field [statoEditabile]
	private boolean statoEditabile = false;

	/**
	 * imposta il valore del campo [statoEditabile]
	 * @param val
	 * @generated
	 */

	public void setStatoEditabile(boolean val) {
		statoEditabile = val;
	}

	/**
	 * legge il valore del campo [statoEditabile]
	 * @generated
	 */
	public boolean getStatoEditabile() {
		return statoEditabile;
	}

	/// Field [numeroProtocolloEditabile]
	private boolean numeroProtocolloEditabile = false;

	/**
	 * imposta il valore del campo [numeroProtocolloEditabile]
	 * @param val
	 * @generated
	 */

	public void setNumeroProtocolloEditabile(boolean val) {
		numeroProtocolloEditabile = val;
	}

	/**
	 * legge il valore del campo [numeroProtocolloEditabile]
	 * @generated
	 */
	public boolean getNumeroProtocolloEditabile() {
		return numeroProtocolloEditabile;
	}

	/// Field [dataProtocolloEditabile]
	private boolean dataProtocolloEditabile = false;

	/**
	 * imposta il valore del campo [dataProtocolloEditabile]
	 * @param val
	 * @generated
	 */

	public void setDataProtocolloEditabile(boolean val) {
		dataProtocolloEditabile = val;
	}

	/**
	 * legge il valore del campo [dataProtocolloEditabile]
	 * @generated
	 */
	public boolean getDataProtocolloEditabile() {
		return dataProtocolloEditabile;
	}

	/// Field [noteEditabile]
	private boolean noteEditabile = false;

	/**
	 * imposta il valore del campo [noteEditabile]
	 * @param val
	 * @generated
	 */

	public void setNoteEditabile(boolean val) {
		noteEditabile = val;
	}

	/**
	 * legge il valore del campo [noteEditabile]
	 * @generated
	 */
	public boolean getNoteEditabile() {
		return noteEditabile;
	}

	/// Field [iconaModifica]
	private java.lang.String iconaModifica = null;

	/**
	 * imposta il valore del campo [iconaModifica]
	 * @param val
	 * @generated
	 */

	public void setIconaModifica(java.lang.String val) {
		iconaModifica = val;
	}

	/**
	 * legge il valore del campo [iconaModifica]
	 * @generated
	 */
	public java.lang.String getIconaModifica() {
		return iconaModifica;
	}

	/// Field [iconaSalva]
	private java.lang.String iconaSalva = null;

	/**
	 * imposta il valore del campo [iconaSalva]
	 * @param val
	 * @generated
	 */

	public void setIconaSalva(java.lang.String val) {
		iconaSalva = val;
	}

	/**
	 * legge il valore del campo [iconaSalva]
	 * @generated
	 */
	public java.lang.String getIconaSalva() {
		return iconaSalva;
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

	/// Field [esisteDB]
	private boolean esisteDB = false;

	/**
	 * imposta il valore del campo [esisteDB]
	 * @param val
	 * @generated
	 */

	public void setEsisteDB(boolean val) {
		esisteDB = val;
	}

	/**
	 * legge il valore del campo [esisteDB]
	 * @generated
	 */
	public boolean getEsisteDB() {
		return esisteDB;
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

	/// Field [dataInserimento]
	private java.lang.String dataInserimento = null;

	/**
	 * imposta il valore del campo [dataInserimento]
	 * @param val
	 * @generated
	 */

	public void setDataInserimento(java.lang.String val) {
		dataInserimento = val;
	}

	/**
	 * legge il valore del campo [dataInserimento]
	 * @generated
	 */
	public java.lang.String getDataInserimento() {
		return dataInserimento;
	}

	/// Field [editing]
	private boolean editing = false;

	/**
	 * imposta il valore del campo [editing]
	 * @param val
	 * @generated
	 */

	public void setEditing(boolean val) {
		editing = val;
	}

	/**
	 * legge il valore del campo [editing]
	 * @generated
	 */
	public boolean getEditing() {
		return editing;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public DettaglioStato() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1404578150) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
