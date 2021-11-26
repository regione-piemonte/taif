/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class ArboricolturaDaLegno implements java.io.Serializable {

	/// Field [idArboricolturaDaLegno]
	private int idArboricolturaDaLegno = 0;

	/**
	 * imposta il valore del campo [idArboricolturaDaLegno]
	 * @param val
	 * @generated
	 */

	public void setIdArboricolturaDaLegno(int val) {
		idArboricolturaDaLegno = val;
	}

	/**
	 * legge il valore del campo [idArboricolturaDaLegno]
	 * @generated
	 */
	public int getIdArboricolturaDaLegno() {
		return idArboricolturaDaLegno;
	}

	/// Field [realizzazione]
	private java.lang.String realizzazione = null;

	/**
	 * imposta il valore del campo [realizzazione]
	 * @param val
	 * @generated
	 */

	public void setRealizzazione(java.lang.String val) {
		realizzazione = val;
	}

	/**
	 * legge il valore del campo [realizzazione]
	 * @generated
	 */
	public java.lang.String getRealizzazione() {
		return realizzazione;
	}

	/// Field [manutenzione]
	private java.lang.String manutenzione = null;

	/**
	 * imposta il valore del campo [manutenzione]
	 * @param val
	 * @generated
	 */

	public void setManutenzione(java.lang.String val) {
		manutenzione = val;
	}

	/**
	 * legge il valore del campo [manutenzione]
	 * @generated
	 */
	public java.lang.String getManutenzione() {
		return manutenzione;
	}

	/// Field [conduzione]
	private java.lang.String conduzione = null;

	/**
	 * imposta il valore del campo [conduzione]
	 * @param val
	 * @generated
	 */

	public void setConduzione(java.lang.String val) {
		conduzione = val;
	}

	/**
	 * legge il valore del campo [conduzione]
	 * @generated
	 */
	public java.lang.String getConduzione() {
		return conduzione;
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

	/// Field [iconaCancellaVisibile]
	private boolean iconaCancellaVisibile = false;

	/**
	 * imposta il valore del campo [iconaCancellaVisibile]
	 * @param val
	 * @generated
	 */

	public void setIconaCancellaVisibile(boolean val) {
		iconaCancellaVisibile = val;
	}

	/**
	 * legge il valore del campo [iconaCancellaVisibile]
	 * @generated
	 */
	public boolean getIconaCancellaVisibile() {
		return iconaCancellaVisibile;
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

	/// Field [idTipoMateriale]
	private int idTipoMateriale = 0;

	/**
	 * imposta il valore del campo [idTipoMateriale]
	 * @param val
	 * @generated
	 */

	public void setIdTipoMateriale(int val) {
		idTipoMateriale = val;
	}

	/**
	 * legge il valore del campo [idTipoMateriale]
	 * @generated
	 */
	public int getIdTipoMateriale() {
		return idTipoMateriale;
	}

	/// Field [dsTipoMateriale]
	private java.lang.String dsTipoMateriale = null;

	/**
	 * imposta il valore del campo [dsTipoMateriale]
	 * @param val
	 * @generated
	 */

	public void setDsTipoMateriale(java.lang.String val) {
		dsTipoMateriale = val;
	}

	/**
	 * legge il valore del campo [dsTipoMateriale]
	 * @generated
	 */
	public java.lang.String getDsTipoMateriale() {
		return dsTipoMateriale;
	}

	/// Field [elencoTipoMateriale]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoTipoMateriale = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoTipoMateriale]
	 * @param val
	 * @generated
	 */

	public void setElencoTipoMateriale(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoTipoMateriale = val;
	}

	/**
	 * legge il valore del campo [elencoTipoMateriale]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoTipoMateriale() {
		return elencoTipoMateriale;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public ArboricolturaDaLegno() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1446680511) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
