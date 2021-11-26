/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dto;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO TaifTSoggettoGestoreDao.
 * @generated
 */
public class TaifTSoggettoGestoreDto extends TaifTSoggettoGestorePk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna CODICE
	 * @generated
	 */
	protected String codice;

	/**
	 * Imposta il valore della proprieta' codice associata alla
	 * colonna CODICE.
	 * @generated
	 */
	public void setCodice(String val) {

		codice = val;

	}

	/**
	 * Legge il valore della proprieta' codice associata alla
	 * @generated
	 */
	public String getCodice() {

		return codice;

	}

	/**
	 * store della proprieta' associata alla colonna DENOMINAZIONE_BREVE
	 * @generated
	 */
	protected String denominazioneBreve;

	/**
	 * Imposta il valore della proprieta' denominazioneBreve associata alla
	 * colonna DENOMINAZIONE_BREVE.
	 * @generated
	 */
	public void setDenominazioneBreve(String val) {

		denominazioneBreve = val;

	}

	/**
	 * Legge il valore della proprieta' denominazioneBreve associata alla
	 * @generated
	 */
	public String getDenominazioneBreve() {

		return denominazioneBreve;

	}

	/**
	 * store della proprieta' associata alla colonna DENOMINAZIONE
	 * @generated
	 */
	protected String denominazione;

	/**
	 * Imposta il valore della proprieta' denominazione associata alla
	 * colonna DENOMINAZIONE.
	 * @generated
	 */
	public void setDenominazione(String val) {

		denominazione = val;

	}

	/**
	 * Legge il valore della proprieta' denominazione associata alla
	 * @generated
	 */
	public String getDenominazione() {

		return denominazione;

	}

	/**
	 * store della proprieta' associata alla colonna ISTAT_COMUNE
	 * @generated
	 */
	protected String istatComune;

	/**
	 * Imposta il valore della proprieta' istatComune associata alla
	 * colonna ISTAT_COMUNE.
	 * @generated
	 */
	public void setIstatComune(String val) {

		istatComune = val;

	}

	/**
	 * Legge il valore della proprieta' istatComune associata alla
	 * @generated
	 */
	public String getIstatComune() {

		return istatComune;

	}

	/**
	 * store della proprieta' associata alla colonna COMUNE_ESTERO
	 * @generated
	 */
	protected String comuneEstero;

	/**
	 * Imposta il valore della proprieta' comuneEstero associata alla
	 * colonna COMUNE_ESTERO.
	 * @generated
	 */
	public void setComuneEstero(String val) {

		comuneEstero = val;

	}

	/**
	 * Legge il valore della proprieta' comuneEstero associata alla
	 * @generated
	 */
	public String getComuneEstero() {

		return comuneEstero;

	}

	/**
	 * store della proprieta' associata alla colonna INDIRIZZO
	 * @generated
	 */
	protected String indirizzo;

	/**
	 * Imposta il valore della proprieta' indirizzo associata alla
	 * colonna INDIRIZZO.
	 * @generated
	 */
	public void setIndirizzo(String val) {

		indirizzo = val;

	}

	/**
	 * Legge il valore della proprieta' indirizzo associata alla
	 * @generated
	 */
	public String getIndirizzo() {

		return indirizzo;

	}

	/**
	 * store della proprieta' associata alla colonna CIVICO
	 * @generated
	 */
	protected String civico;

	/**
	 * Imposta il valore della proprieta' civico associata alla
	 * colonna CIVICO.
	 * @generated
	 */
	public void setCivico(String val) {

		civico = val;

	}

	/**
	 * Legge il valore della proprieta' civico associata alla
	 * @generated
	 */
	public String getCivico() {

		return civico;

	}

	/**
	 * store della proprieta' associata alla colonna CAP
	 * @generated
	 */
	protected String cap;

	/**
	 * Imposta il valore della proprieta' cap associata alla
	 * colonna CAP.
	 * @generated
	 */
	public void setCap(String val) {

		cap = val;

	}

	/**
	 * Legge il valore della proprieta' cap associata alla
	 * @generated
	 */
	public String getCap() {

		return cap;

	}

	/**
	 * store della proprieta' associata alla colonna TELEFONO
	 * @generated
	 */
	protected String telefono;

	/**
	 * Imposta il valore della proprieta' telefono associata alla
	 * colonna TELEFONO.
	 * @generated
	 */
	public void setTelefono(String val) {

		telefono = val;

	}

	/**
	 * Legge il valore della proprieta' telefono associata alla
	 * @generated
	 */
	public String getTelefono() {

		return telefono;

	}

	/**
	 * store della proprieta' associata alla colonna CELLULARE
	 * @generated
	 */
	protected String cellulare;

	/**
	 * Imposta il valore della proprieta' cellulare associata alla
	 * colonna CELLULARE.
	 * @generated
	 */
	public void setCellulare(String val) {

		cellulare = val;

	}

	/**
	 * Legge il valore della proprieta' cellulare associata alla
	 * @generated
	 */
	public String getCellulare() {

		return cellulare;

	}

	/**
	 * store della proprieta' associata alla colonna MAIL
	 * @generated
	 */
	protected String mail;

	/**
	 * Imposta il valore della proprieta' mail associata alla
	 * colonna MAIL.
	 * @generated
	 */
	public void setMail(String val) {

		mail = val;

	}

	/**
	 * Legge il valore della proprieta' mail associata alla
	 * @generated
	 */
	public String getMail() {

		return mail;

	}

	/**
	 * store della proprieta' associata alla colonna PEC
	 * @generated
	 */
	protected String pec;

	/**
	 * Imposta il valore della proprieta' pec associata alla
	 * colonna PEC.
	 * @generated
	 */
	public void setPec(String val) {

		pec = val;

	}

	/**
	 * Legge il valore della proprieta' pec associata alla
	 * @generated
	 */
	public String getPec() {

		return pec;

	}

	/**
	 * store della proprieta' associata alla colonna REFERENTE
	 * @generated
	 */
	protected String referente;

	/**
	 * Imposta il valore della proprieta' referente associata alla
	 * colonna REFERENTE.
	 * @generated
	 */
	public void setReferente(String val) {

		referente = val;

	}

	/**
	 * Legge il valore della proprieta' referente associata alla
	 * @generated
	 */
	public String getReferente() {

		return referente;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_ORDINAMENTO
	 * @generated
	 */
	protected java.math.BigDecimal mtdOrdinamento;

	/**
	 * Imposta il valore della proprieta' mtdOrdinamento associata alla
	 * colonna MTD_ORDINAMENTO.
	 * @generated
	 */
	public void setMtdOrdinamento(java.math.BigDecimal val) {

		mtdOrdinamento = val;

	}

	/**
	 * Legge il valore della proprieta' mtdOrdinamento associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdOrdinamento() {

		return mtdOrdinamento;

	}

	/**
	 * store della proprieta' associata alla colonna MTD_FLG_VISIBILE
	 * @generated
	 */
	protected java.math.BigDecimal mtdFlgVisibile;

	/**
	 * Imposta il valore della proprieta' mtdFlgVisibile associata alla
	 * colonna MTD_FLG_VISIBILE.
	 * @generated
	 */
	public void setMtdFlgVisibile(java.math.BigDecimal val) {

		mtdFlgVisibile = val;

	}

	/**
	 * Legge il valore della proprieta' mtdFlgVisibile associata alla
	 * @generated
	 */
	public java.math.BigDecimal getMtdFlgVisibile() {

		return mtdFlgVisibile;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INSERIMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataInserimento;

	/**
	 * Imposta il valore della proprieta' dataInserimento associata alla
	 * colonna DATA_INSERIMENTO.
	 * @generated
	 */
	public void setDataInserimento(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimento = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInserimento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimento() {

		if (dataInserimento != null) {
			return new java.sql.Timestamp(dataInserimento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_AGGIORNAMENTO
	 * @generated
	 */
	protected java.sql.Timestamp dataAggiornamento;

	/**
	 * Imposta il valore della proprieta' dataAggiornamento associata alla
	 * colonna DATA_AGGIORNAMENTO.
	 * @generated
	 */
	public void setDataAggiornamento(java.sql.Timestamp val) {

		if (val != null) {
			dataAggiornamento = new java.sql.Timestamp(val.getTime());
		} else {
			dataAggiornamento = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataAggiornamento associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataAggiornamento() {

		if (dataAggiornamento != null) {
			return new java.sql.Timestamp(dataAggiornamento.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna URL_DOC_PRIVACY
	 * @generated
	 */
	protected String urlDocPrivacy;

	/**
	 * Imposta il valore della proprieta' urlDocPrivacy associata alla
	 * colonna URL_DOC_PRIVACY.
	 * @generated
	 */
	public void setUrlDocPrivacy(String val) {

		urlDocPrivacy = val;

	}

	/**
	 * Legge il valore della proprieta' urlDocPrivacy associata alla
	 * @generated
	 */
	public String getUrlDocPrivacy() {

		return urlDocPrivacy;

	}

	/**
	 * Crea una istanza di TaifTSoggettoGestorePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTSoggettoGestorePk
	 * @generated
	 */
	public TaifTSoggettoGestorePk createPk() {
		return new TaifTSoggettoGestorePk(idSoggettoGestore);
	}

	/**
	 * la semantica dell'equals del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * @param other l'oggetto con cui effettuare il confronto
	 * @return true se i due oggetti sono semanticamente da considerarsi uguali
	 */
	public boolean equals(Object other) {
		return super.equals(other);
	}

	/**
	 * la semantica dell'hashCode del DTO e' la stessa della PK
	 * (ovvero della superclasse).
	 * 
	 * @return int
	 */
	public int hashCode() {
		return super.hashCode();
	}

}
