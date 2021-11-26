/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.dto.domanda;

public class Personale implements java.io.Serializable {

	/// Field [idPersonale]
	private int idPersonale = 0;

	/**
	 * imposta il valore del campo [idPersonale]
	 * @param val
	 * @generated
	 */

	public void setIdPersonale(int val) {
		idPersonale = val;
	}

	/**
	 * legge il valore del campo [idPersonale]
	 * @generated
	 */
	public int getIdPersonale() {
		return idPersonale;
	}

	/// Field [codiceFiscale]
	private java.lang.String codiceFiscale = null;

	/**
	 * imposta il valore del campo [codiceFiscale]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	/**
	 * legge il valore del campo [codiceFiscale]
	 * @generated
	 */
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
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

	/// Field [idTipologiaPersonale]
	private int idTipologiaPersonale = 0;

	/**
	 * imposta il valore del campo [idTipologiaPersonale]
	 * @param val
	 * @generated
	 */

	public void setIdTipologiaPersonale(int val) {
		idTipologiaPersonale = val;
	}

	/**
	 * legge il valore del campo [idTipologiaPersonale]
	 * @generated
	 */
	public int getIdTipologiaPersonale() {
		return idTipologiaPersonale;
	}

	/// Field [dsTipologiaPersonale]
	private java.lang.String dsTipologiaPersonale = null;

	/**
	 * imposta il valore del campo [dsTipologiaPersonale]
	 * @param val
	 * @generated
	 */

	public void setDsTipologiaPersonale(java.lang.String val) {
		dsTipologiaPersonale = val;
	}

	/**
	 * legge il valore del campo [dsTipologiaPersonale]
	 * @generated
	 */
	public java.lang.String getDsTipologiaPersonale() {
		return dsTipologiaPersonale;
	}

	/// Field [elencoTipologiaPersonale]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoTipologiaPersonale = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoTipologiaPersonale]
	 * @param val
	 * @generated
	 */

	public void setElencoTipologiaPersonale(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoTipologiaPersonale = val;
	}

	/**
	 * legge il valore del campo [elencoTipologiaPersonale]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoTipologiaPersonale() {
		return elencoTipologiaPersonale;
	}

	/// Field [idMansione]
	private int idMansione = 0;

	/**
	 * imposta il valore del campo [idMansione]
	 * @param val
	 * @generated
	 */

	public void setIdMansione(int val) {
		idMansione = val;
	}

	/**
	 * legge il valore del campo [idMansione]
	 * @generated
	 */
	public int getIdMansione() {
		return idMansione;
	}

	/// Field [dsMansione]
	private java.lang.String dsMansione = null;

	/**
	 * imposta il valore del campo [dsMansione]
	 * @param val
	 * @generated
	 */

	public void setDsMansione(java.lang.String val) {
		dsMansione = val;
	}

	/**
	 * legge il valore del campo [dsMansione]
	 * @generated
	 */
	public java.lang.String getDsMansione() {
		return dsMansione;
	}

	/// Field [elencoMansioni]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoMansioni = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoMansioni]
	 * @param val
	 * @generated
	 */

	public void setElencoMansioni(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoMansioni = val;
	}

	/**
	 * legge il valore del campo [elencoMansioni]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoMansioni() {
		return elencoMansioni;
	}

	/// Field [idContratto]
	private int idContratto = 0;

	/**
	 * imposta il valore del campo [idContratto]
	 * @param val
	 * @generated
	 */

	public void setIdContratto(int val) {
		idContratto = val;
	}

	/**
	 * legge il valore del campo [idContratto]
	 * @generated
	 */
	public int getIdContratto() {
		return idContratto;
	}

	/// Field [dsContratto]
	private java.lang.String dsContratto = null;

	/**
	 * imposta il valore del campo [dsContratto]
	 * @param val
	 * @generated
	 */

	public void setDsContratto(java.lang.String val) {
		dsContratto = val;
	}

	/**
	 * legge il valore del campo [dsContratto]
	 * @generated
	 */
	public java.lang.String getDsContratto() {
		return dsContratto;
	}

	/// Field [elencoContratti]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoContratti = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoContratti]
	 * @param val
	 * @generated
	 */

	public void setElencoContratti(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoContratti = val;
	}

	/**
	 * legge il valore del campo [elencoContratti]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoContratti() {
		return elencoContratti;
	}

	/// Field [idDurataContratto]
	private java.lang.String idDurataContratto = null;

	/**
	 * imposta il valore del campo [idDurataContratto]
	 * @param val
	 * @generated
	 */

	public void setIdDurataContratto(java.lang.String val) {
		idDurataContratto = val;
	}

	/**
	 * legge il valore del campo [idDurataContratto]
	 * @generated
	 */
	public java.lang.String getIdDurataContratto() {
		return idDurataContratto;
	}

	/// Field [dsDurataContratto]
	private java.lang.String dsDurataContratto = null;

	/**
	 * imposta il valore del campo [dsDurataContratto]
	 * @param val
	 * @generated
	 */

	public void setDsDurataContratto(java.lang.String val) {
		dsDurataContratto = val;
	}

	/**
	 * legge il valore del campo [dsDurataContratto]
	 * @generated
	 */
	public java.lang.String getDsDurataContratto() {
		return dsDurataContratto;
	}

	/// Field [elencoDurateContratto]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoDurateContratto = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoDurateContratto]
	 * @param val
	 * @generated
	 */

	public void setElencoDurateContratto(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoDurateContratto = val;
	}

	/**
	 * legge il valore del campo [elencoDurateContratto]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoDurateContratto() {
		return elencoDurateContratto;
	}

	/// Field [giorniNellAnno]
	private java.lang.String giorniNellAnno = null;

	/**
	 * imposta il valore del campo [giorniNellAnno]
	 * @param val
	 * @generated
	 */

	public void setGiorniNellAnno(java.lang.String val) {
		giorniNellAnno = val;
	}

	/**
	 * legge il valore del campo [giorniNellAnno]
	 * @generated
	 */
	public java.lang.String getGiorniNellAnno() {
		return giorniNellAnno;
	}

	/// Field [idInquadramento]
	private int idInquadramento = 0;

	/**
	 * imposta il valore del campo [idInquadramento]
	 * @param val
	 * @generated
	 */

	public void setIdInquadramento(int val) {
		idInquadramento = val;
	}

	/**
	 * legge il valore del campo [idInquadramento]
	 * @generated
	 */
	public int getIdInquadramento() {
		return idInquadramento;
	}

	/// Field [dsInquadramento]
	private java.lang.String dsInquadramento = null;

	/**
	 * imposta il valore del campo [dsInquadramento]
	 * @param val
	 * @generated
	 */

	public void setDsInquadramento(java.lang.String val) {
		dsInquadramento = val;
	}

	/**
	 * legge il valore del campo [dsInquadramento]
	 * @generated
	 */
	public java.lang.String getDsInquadramento() {
		return dsInquadramento;
	}

	/// Field [elencoInquadramenti]
	private java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> elencoInquadramenti = new java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription>();

	/**
	 * imposta il valore del campo [elencoInquadramenti]
	 * @param val
	 * @generated
	 */

	public void setElencoInquadramenti(java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> val) {
		elencoInquadramenti = val;
	}

	/**
	 * legge il valore del campo [elencoInquadramenti]
	 * @generated
	 */
	public java.util.ArrayList<it.csi.taif.taifweb.dto.common.CodeDescription> getElencoInquadramenti() {
		return elencoInquadramenti;
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

	/// Field [codiceFiscaleEditabile]
	private boolean codiceFiscaleEditabile = false;

	/**
	 * imposta il valore del campo [codiceFiscaleEditabile]
	 * @param val
	 * @generated
	 */

	public void setCodiceFiscaleEditabile(boolean val) {
		codiceFiscaleEditabile = val;
	}

	/**
	 * legge il valore del campo [codiceFiscaleEditabile]
	 * @generated
	 */
	public boolean getCodiceFiscaleEditabile() {
		return codiceFiscaleEditabile;
	}

	/// Field [cognomeEditabile]
	private boolean cognomeEditabile = false;

	/**
	 * imposta il valore del campo [cognomeEditabile]
	 * @param val
	 * @generated
	 */

	public void setCognomeEditabile(boolean val) {
		cognomeEditabile = val;
	}

	/**
	 * legge il valore del campo [cognomeEditabile]
	 * @generated
	 */
	public boolean getCognomeEditabile() {
		return cognomeEditabile;
	}

	/// Field [nomeEditabile]
	private boolean nomeEditabile = false;

	/**
	 * imposta il valore del campo [nomeEditabile]
	 * @param val
	 * @generated
	 */

	public void setNomeEditabile(boolean val) {
		nomeEditabile = val;
	}

	/**
	 * legge il valore del campo [nomeEditabile]
	 * @generated
	 */
	public boolean getNomeEditabile() {
		return nomeEditabile;
	}

	/// Field [iconaOperatore]
	private java.lang.String iconaOperatore = null;

	/**
	 * imposta il valore del campo [iconaOperatore]
	 * @param val
	 * @generated
	 */

	public void setIconaOperatore(java.lang.String val) {
		iconaOperatore = val;
	}

	/**
	 * legge il valore del campo [iconaOperatore]
	 * @generated
	 */
	public java.lang.String getIconaOperatore() {
		return iconaOperatore;
	}

	/// Field [corsi]
	private java.lang.String corsi = null;

	/**
	 * imposta il valore del campo [corsi]
	 * @param val
	 * @generated
	 */

	public void setCorsi(java.lang.String val) {
		corsi = val;
	}

	/**
	 * legge il valore del campo [corsi]
	 * @generated
	 */
	public java.lang.String getCorsi() {
		return corsi;
	}

	/// Field [qualifiche]
	private java.lang.String qualifiche = null;

	/**
	 * imposta il valore del campo [qualifiche]
	 * @param val
	 * @generated
	 */

	public void setQualifiche(java.lang.String val) {
		qualifiche = val;
	}

	/**
	 * legge il valore del campo [qualifiche]
	 * @generated
	 */
	public java.lang.String getQualifiche() {
		return qualifiche;
	}

	/// Field [riconoscimenti]
	private java.lang.String riconoscimenti = null;

	/**
	 * imposta il valore del campo [riconoscimenti]
	 * @param val
	 * @generated
	 */

	public void setRiconoscimenti(java.lang.String val) {
		riconoscimenti = val;
	}

	/**
	 * legge il valore del campo [riconoscimenti]
	 * @generated
	 */
	public java.lang.String getRiconoscimenti() {
		return riconoscimenti;
	}

	/// Field [corsiPresenti]
	private boolean corsiPresenti = false;

	/**
	 * imposta il valore del campo [corsiPresenti]
	 * @param val
	 * @generated
	 */

	public void setCorsiPresenti(boolean val) {
		corsiPresenti = val;
	}

	/**
	 * legge il valore del campo [corsiPresenti]
	 * @generated
	 */
	public boolean getCorsiPresenti() {
		return corsiPresenti;
	}

	/// Field [qualifichePresenti]
	private boolean qualifichePresenti = false;

	/**
	 * imposta il valore del campo [qualifichePresenti]
	 * @param val
	 * @generated
	 */

	public void setQualifichePresenti(boolean val) {
		qualifichePresenti = val;
	}

	/**
	 * legge il valore del campo [qualifichePresenti]
	 * @generated
	 */
	public boolean getQualifichePresenti() {
		return qualifichePresenti;
	}

	/// Field [riconoscimentiPresenti]
	private boolean riconoscimentiPresenti = false;

	/**
	 * imposta il valore del campo [riconoscimentiPresenti]
	 * @param val
	 * @generated
	 */

	public void setRiconoscimentiPresenti(boolean val) {
		riconoscimentiPresenti = val;
	}

	/**
	 * legge il valore del campo [riconoscimentiPresenti]
	 * @generated
	 */
	public boolean getRiconoscimentiPresenti() {
		return riconoscimentiPresenti;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Personale() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1192833677) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
