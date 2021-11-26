/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dto;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Data transfer object relativo al DAO TaifTPraticaDao.
 * @generated
 */
public class TaifTPraticaDto extends TaifTPraticaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_SOGGETTO_GESTORE
	 * @generated
	 */
	protected Integer fkSoggettoGestore;

	/**
	 * Imposta il valore della proprieta' fkSoggettoGestore associata alla
	 * colonna FK_SOGGETTO_GESTORE.
	 * @generated
	 */
	public void setFkSoggettoGestore(Integer val) {

		fkSoggettoGestore = val;

	}

	/**
	 * Legge il valore della proprieta' fkSoggettoGestore associata alla
	 * @generated
	 */
	public Integer getFkSoggettoGestore() {

		return fkSoggettoGestore;

	}

	/**
	 * store della proprieta' associata alla colonna FK_AZIENDA
	 * @generated
	 */
	protected Integer fkAzienda;

	/**
	 * Imposta il valore della proprieta' fkAzienda associata alla
	 * colonna FK_AZIENDA.
	 * @generated
	 */
	public void setFkAzienda(Integer val) {

		fkAzienda = val;

	}

	/**
	 * Legge il valore della proprieta' fkAzienda associata alla
	 * @generated
	 */
	public Integer getFkAzienda() {

		return fkAzienda;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_PRESENTAZIONE
	 * @generated
	 */
	protected java.sql.Date dataPresentazione;

	/**
	 * Imposta il valore della proprieta' dataPresentazione associata alla
	 * colonna DATA_PRESENTAZIONE.
	 * @generated
	 */
	public void setDataPresentazione(java.sql.Date val) {

		if (val != null) {
			dataPresentazione = new java.sql.Date(val.getTime());
		} else {
			dataPresentazione = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataPresentazione associata alla
	 * @generated
	 */
	public java.sql.Date getDataPresentazione() {

		if (dataPresentazione != null) {
			return new java.sql.Date(dataPresentazione.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna DATA_ISCRIZIONE_ALBO
	 * @generated
	 */
	protected java.sql.Date dataIscrizioneAlbo;

	/**
	 * Imposta il valore della proprieta' dataIscrizioneAlbo associata alla
	 * colonna DATA_ISCRIZIONE_ALBO.
	 * @generated
	 */
	public void setDataIscrizioneAlbo(java.sql.Date val) {

		if (val != null) {
			dataIscrizioneAlbo = new java.sql.Date(val.getTime());
		} else {
			dataIscrizioneAlbo = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataIscrizioneAlbo associata alla
	 * @generated
	 */
	public java.sql.Date getDataIscrizioneAlbo() {

		if (dataIscrizioneAlbo != null) {
			return new java.sql.Date(dataIscrizioneAlbo.getTime());
		} else {
			return null;
		}

	}

	/**
	 * store della proprieta' associata alla colonna NUMERO_ALBO
	 * @generated
	 */
	protected String numeroAlbo;

	/**
	 * Imposta il valore della proprieta' numeroAlbo associata alla
	 * colonna NUMERO_ALBO.
	 * @generated
	 */
	public void setNumeroAlbo(String val) {

		numeroAlbo = val;

	}

	/**
	 * Legge il valore della proprieta' numeroAlbo associata alla
	 * @generated
	 */
	public String getNumeroAlbo() {

		return numeroAlbo;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_SEZIONE
	 * @generated
	 */
	protected String flgSezione;

	/**
	 * Imposta il valore della proprieta' flgSezione associata alla
	 * colonna FLG_SEZIONE.
	 * @generated
	 */
	public void setFlgSezione(String val) {

		flgSezione = val;

	}

	/**
	 * Legge il valore della proprieta' flgSezione associata alla
	 * @generated
	 */
	public String getFlgSezione() {

		return flgSezione;

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
	 * store della proprieta' associata alla colonna DENOMINAZIONE_ALTRO_ALBO
	 * @generated
	 */
	protected String denominazioneAltroAlbo;

	/**
	 * Imposta il valore della proprieta' denominazioneAltroAlbo associata alla
	 * colonna DENOMINAZIONE_ALTRO_ALBO.
	 * @generated
	 */
	public void setDenominazioneAltroAlbo(String val) {

		denominazioneAltroAlbo = val;

	}

	/**
	 * Legge il valore della proprieta' denominazioneAltroAlbo associata alla
	 * @generated
	 */
	public String getDenominazioneAltroAlbo() {

		return denominazioneAltroAlbo;

	}

	/**
	 * store della proprieta' associata alla colonna FK_CONFIG_UTENTE
	 * @generated
	 */
	protected Integer fkConfigUtente;

	/**
	 * Imposta il valore della proprieta' fkConfigUtente associata alla
	 * colonna FK_CONFIG_UTENTE.
	 * @generated
	 */
	public void setFkConfigUtente(Integer val) {

		fkConfigUtente = val;

	}

	/**
	 * Legge il valore della proprieta' fkConfigUtente associata alla
	 * @generated
	 */
	public Integer getFkConfigUtente() {

		return fkConfigUtente;

	}

	/**
	 * Crea una istanza di TaifTPraticaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTPraticaPk
	 * @generated
	 */
	public TaifTPraticaPk createPk() {
		return new TaifTPraticaPk(idPratica);
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
