/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class Capannone implements java.io.Serializable {

	/// Field [idCapannone]
	private int idCapannone = 0;

	/**
	 * imposta il valore del campo [idCapannone]
	 * @param val
	 * @generated
	 */

	public void setIdCapannone(int val) {
		idCapannone = val;
	}

	/**
	 * legge il valore del campo [idCapannone]
	 * @generated
	 */
	public int getIdCapannone() {
		return idCapannone;
	}

	/// Field [funzioneCapannone]
	private java.lang.String funzioneCapannone = null;

	/**
	 * imposta il valore del campo [funzioneCapannone]
	 * @param val
	 * @generated
	 */

	public void setFunzioneCapannone(java.lang.String val) {
		funzioneCapannone = val;
	}

	/**
	 * legge il valore del campo [funzioneCapannone]
	 * @generated
	 */
	public java.lang.String getFunzioneCapannone() {
		return funzioneCapannone;
	}

	/// Field [dimensioneCapannone]
	private java.lang.String dimensioneCapannone = null;

	/**
	 * imposta il valore del campo [dimensioneCapannone]
	 * @param val
	 * @generated
	 */

	public void setDimensioneCapannone(java.lang.String val) {
		dimensioneCapannone = val;
	}

	/**
	 * legge il valore del campo [dimensioneCapannone]
	 * @generated
	 */
	public java.lang.String getDimensioneCapannone() {
		return dimensioneCapannone;
	}

	/// Field [annoCostruzioneORiattamentoCapannone]
	private java.lang.String annoCostruzioneORiattamentoCapannone = null;

	/**
	 * imposta il valore del campo [annoCostruzioneORiattamentoCapannone]
	 * @param val
	 * @generated
	 */

	public void setAnnoCostruzioneORiattamentoCapannone(java.lang.String val) {
		annoCostruzioneORiattamentoCapannone = val;
	}

	/**
	 * legge il valore del campo [annoCostruzioneORiattamentoCapannone]
	 * @generated
	 */
	public java.lang.String getAnnoCostruzioneORiattamentoCapannone() {
		return annoCostruzioneORiattamentoCapannone;
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

	/// Field [idFunzione]
	private int idFunzione = 0;

	/**
	 * imposta il valore del campo [idFunzione]
	 * @param val
	 * @generated
	 */

	public void setIdFunzione(int val) {
		idFunzione = val;
	}

	/**
	 * legge il valore del campo [idFunzione]
	 * @generated
	 */
	public int getIdFunzione() {
		return idFunzione;
	}

	/// Field [dsFunzione]
	private java.lang.String dsFunzione = null;

	/**
	 * imposta il valore del campo [dsFunzione]
	 * @param val
	 * @generated
	 */

	public void setDsFunzione(java.lang.String val) {
		dsFunzione = val;
	}

	/**
	 * legge il valore del campo [dsFunzione]
	 * @generated
	 */
	public java.lang.String getDsFunzione() {
		return dsFunzione;
	}

	/// Field [elencoFunzioni]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoFunzioni = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoFunzioni]
	 * @param val
	 * @generated
	 */

	public void setElencoFunzioni(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoFunzioni = val;
	}

	/**
	 * legge il valore del campo [elencoFunzioni]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoFunzioni() {
		return elencoFunzioni;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Capannone() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1555976059) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
