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
 * Data transfer object relativo al DAO TaifTCertificazioneDao.
 * @generated
 */
public class TaifTCertificazioneDto extends TaifTCertificazionePk {

	private static final long serialVersionUID = 1L;

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
	 * store della proprieta' associata alla colonna FK_TIPO_CERTIFICAZIONE
	 * @generated
	 */
	protected Integer fkTipoCertificazione;

	/**
	 * Imposta il valore della proprieta' fkTipoCertificazione associata alla
	 * colonna FK_TIPO_CERTIFICAZIONE.
	 * @generated
	 */
	public void setFkTipoCertificazione(Integer val) {

		fkTipoCertificazione = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoCertificazione associata alla
	 * @generated
	 */
	public Integer getFkTipoCertificazione() {

		return fkTipoCertificazione;

	}

	/**
	 * store della proprieta' associata alla colonna DESCR_ALTRO
	 * @generated
	 */
	protected String descrAltro;

	/**
	 * Imposta il valore della proprieta' descrAltro associata alla
	 * colonna DESCR_ALTRO.
	 * @generated
	 */
	public void setDescrAltro(String val) {

		descrAltro = val;

	}

	/**
	 * Legge il valore della proprieta' descrAltro associata alla
	 * @generated
	 */
	public String getDescrAltro() {

		return descrAltro;

	}

	/**
	 * store della proprieta' associata alla colonna NUMERO
	 * @generated
	 */
	protected String numero;

	/**
	 * Imposta il valore della proprieta' numero associata alla
	 * colonna NUMERO.
	 * @generated
	 */
	public void setNumero(String val) {

		numero = val;

	}

	/**
	 * Legge il valore della proprieta' numero associata alla
	 * @generated
	 */
	public String getNumero() {

		return numero;

	}

	/**
	 * store della proprieta' associata alla colonna ENTE_CERTIFICATORE
	 * @generated
	 */
	protected String enteCertificatore;

	/**
	 * Imposta il valore della proprieta' enteCertificatore associata alla
	 * colonna ENTE_CERTIFICATORE.
	 * @generated
	 */
	public void setEnteCertificatore(String val) {

		enteCertificatore = val;

	}

	/**
	 * Legge il valore della proprieta' enteCertificatore associata alla
	 * @generated
	 */
	public String getEnteCertificatore() {

		return enteCertificatore;

	}

	/**
	 * store della proprieta' associata alla colonna ANNO
	 * @generated
	 */
	protected java.math.BigDecimal anno;

	/**
	 * Imposta il valore della proprieta' anno associata alla
	 * colonna ANNO.
	 * @generated
	 */
	public void setAnno(java.math.BigDecimal val) {

		anno = val;

	}

	/**
	 * Legge il valore della proprieta' anno associata alla
	 * @generated
	 */
	public java.math.BigDecimal getAnno() {

		return anno;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_SCADENZA
	 * @generated
	 */
	protected java.sql.Timestamp dataScadenza;

	/**
	 * Imposta il valore della proprieta' dataScadenza associata alla
	 * colonna DATA_SCADENZA.
	 * @generated
	 */
	public void setDataScadenza(java.sql.Timestamp val) {

		if (val != null) {
			dataScadenza = new java.sql.Timestamp(val.getTime());
		} else {
			dataScadenza = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataScadenza associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataScadenza() {

		if (dataScadenza != null) {
			return new java.sql.Timestamp(dataScadenza.getTime());
		} else {
			return null;
		}

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
	 * Crea una istanza di TaifTCertificazionePk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTCertificazionePk
	 * @generated
	 */
	public TaifTCertificazionePk createPk() {
		return new TaifTCertificazionePk(idCertificazione);
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
