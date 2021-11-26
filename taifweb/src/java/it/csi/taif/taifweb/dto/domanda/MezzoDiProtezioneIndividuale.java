/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class MezzoDiProtezioneIndividuale implements java.io.Serializable {

	/// Field [idMezzoDiProtezioneIndividuale]
	private int idMezzoDiProtezioneIndividuale = 0;

	/**
	 * imposta il valore del campo [idMezzoDiProtezioneIndividuale]
	 * @param val
	 * @generated
	 */

	public void setIdMezzoDiProtezioneIndividuale(int val) {
		idMezzoDiProtezioneIndividuale = val;
	}

	/**
	 * legge il valore del campo [idMezzoDiProtezioneIndividuale]
	 * @generated
	 */
	public int getIdMezzoDiProtezioneIndividuale() {
		return idMezzoDiProtezioneIndividuale;
	}

	/// Field [dsMezzoDiProtezioneIndividuale]
	private java.lang.String dsMezzoDiProtezioneIndividuale = null;

	/**
	 * imposta il valore del campo [dsMezzoDiProtezioneIndividuale]
	 * @param val
	 * @generated
	 */

	public void setDsMezzoDiProtezioneIndividuale(java.lang.String val) {
		dsMezzoDiProtezioneIndividuale = val;
	}

	/**
	 * legge il valore del campo [dsMezzoDiProtezioneIndividuale]
	 * @generated
	 */
	public java.lang.String getDsMezzoDiProtezioneIndividuale() {
		return dsMezzoDiProtezioneIndividuale;
	}

	/// Field [idTipoMezzoDiProtezioneIndividuale]
	private int idTipoMezzoDiProtezioneIndividuale = 0;

	/**
	 * imposta il valore del campo [idTipoMezzoDiProtezioneIndividuale]
	 * @param val
	 * @generated
	 */

	public void setIdTipoMezzoDiProtezioneIndividuale(int val) {
		idTipoMezzoDiProtezioneIndividuale = val;
	}

	/**
	 * legge il valore del campo [idTipoMezzoDiProtezioneIndividuale]
	 * @generated
	 */
	public int getIdTipoMezzoDiProtezioneIndividuale() {
		return idTipoMezzoDiProtezioneIndividuale;
	}

	/// Field [dsTipoMezzoDiProtezioneIndividuale]
	private java.lang.String dsTipoMezzoDiProtezioneIndividuale = null;

	/**
	 * imposta il valore del campo [dsTipoMezzoDiProtezioneIndividuale]
	 * @param val
	 * @generated
	 */

	public void setDsTipoMezzoDiProtezioneIndividuale(java.lang.String val) {
		dsTipoMezzoDiProtezioneIndividuale = val;
	}

	/**
	 * legge il valore del campo [dsTipoMezzoDiProtezioneIndividuale]
	 * @generated
	 */
	public java.lang.String getDsTipoMezzoDiProtezioneIndividuale() {
		return dsTipoMezzoDiProtezioneIndividuale;
	}

	/// Field [elencoTipoMezzoDiProtezioneIndividuale]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoTipoMezzoDiProtezioneIndividuale = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoTipoMezzoDiProtezioneIndividuale]
	 * @param val
	 * @generated
	 */

	public void setElencoTipoMezzoDiProtezioneIndividuale(
			java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoTipoMezzoDiProtezioneIndividuale = val;
	}

	/**
	 * legge il valore del campo [elencoTipoMezzoDiProtezioneIndividuale]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoTipoMezzoDiProtezioneIndividuale() {
		return elencoTipoMezzoDiProtezioneIndividuale;
	}

	/// Field [quantita]
	private java.lang.String quantita = null;

	/**
	 * imposta il valore del campo [quantita]
	 * @param val
	 * @generated
	 */

	public void setQuantita(java.lang.String val) {
		quantita = val;
	}

	/**
	 * legge il valore del campo [quantita]
	 * @generated
	 */
	public java.lang.String getQuantita() {
		return quantita;
	}

	/// Field [annoScadenza]
	private java.lang.String annoScadenza = null;

	/**
	 * imposta il valore del campo [annoScadenza]
	 * @param val
	 * @generated
	 */

	public void setAnnoScadenza(java.lang.String val) {
		annoScadenza = val;
	}

	/**
	 * legge il valore del campo [annoScadenza]
	 * @generated
	 */
	public java.lang.String getAnnoScadenza() {
		return annoScadenza;
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

	/// Field [tipologia]
	private java.lang.String tipologia = null;

	/**
	 * imposta il valore del campo [tipologia]
	 * @param val
	 * @generated
	 */

	public void setTipologia(java.lang.String val) {
		tipologia = val;
	}

	/**
	 * legge il valore del campo [tipologia]
	 * @generated
	 */
	public java.lang.String getTipologia() {
		return tipologia;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public MezzoDiProtezioneIndividuale() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R483548577) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
