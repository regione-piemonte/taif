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
 * Data transfer object relativo al DAO TaifTStoricoStatoDao.
 * @generated
 */
public class TaifTStoricoStatoDto extends TaifTStoricoStatoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_STATO_PRATICA
	 * @generated
	 */
	protected Integer fkStatoPratica;

	/**
	 * Imposta il valore della proprieta' fkStatoPratica associata alla
	 * colonna FK_STATO_PRATICA.
	 * @generated
	 */
	public void setFkStatoPratica(Integer val) {

		fkStatoPratica = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoPratica associata alla
	 * @generated
	 */
	public Integer getFkStatoPratica() {

		return fkStatoPratica;

	}

	/**
	 * store della proprieta' associata alla colonna NUMERO_PROTOCOLLO
	 * @generated
	 */
	protected String numeroProtocollo;

	/**
	 * Imposta il valore della proprieta' numeroProtocollo associata alla
	 * colonna NUMERO_PROTOCOLLO.
	 * @generated
	 */
	public void setNumeroProtocollo(String val) {

		numeroProtocollo = val;

	}

	/**
	 * Legge il valore della proprieta' numeroProtocollo associata alla
	 * @generated
	 */
	public String getNumeroProtocollo() {

		return numeroProtocollo;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_PROTOCOLLO
	 * @generated
	 */
	protected java.sql.Date dataProtocollo;

	/**
	 * Imposta il valore della proprieta' dataProtocollo associata alla
	 * colonna DATA_PROTOCOLLO.
	 * @generated
	 */
	public void setDataProtocollo(java.sql.Date val) {

		if (val != null) {
			dataProtocollo = new java.sql.Date(val.getTime());
		} else {
			dataProtocollo = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataProtocollo associata alla
	 * @generated
	 */
	public java.sql.Date getDataProtocollo() {

		if (dataProtocollo != null) {
			return new java.sql.Date(dataProtocollo.getTime());
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
	 * store della proprieta' associata alla colonna NOTE
	 * @generated
	 */
	protected String note;

	/**
	 * Imposta il valore della proprieta' note associata alla
	 * colonna NOTE.
	 * @generated
	 */
	public void setNote(String val) {

		note = val;

	}

	/**
	 * Legge il valore della proprieta' note associata alla
	 * @generated
	 */
	public String getNote() {

		return note;

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
	 * store della proprieta' associata alla colonna DATA_FINE_STATO
	 * @generated
	 */
	protected java.sql.Date dataFineStato;

	/**
	 * Imposta il valore della proprieta' dataFineStato associata alla
	 * colonna DATA_FINE_STATO.
	 * @generated
	 */
	public void setDataFineStato(java.sql.Date val) {

		if (val != null) {
			dataFineStato = new java.sql.Date(val.getTime());
		} else {
			dataFineStato = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataFineStato associata alla
	 * @generated
	 */
	public java.sql.Date getDataFineStato() {

		if (dataFineStato != null) {
			return new java.sql.Date(dataFineStato.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Crea una istanza di TaifTStoricoStatoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTStoricoStatoPk
	 * @generated
	 */
	public TaifTStoricoStatoPk createPk() {
		return new TaifTStoricoStatoPk(idPratica, dataInserimentoStato);
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
