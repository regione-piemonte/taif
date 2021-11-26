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
 * Data transfer object relativo al DAO TaifTOpfoDao.
 * @generated
 */
public class TaifTOpfoDto extends TaifTOpfoPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_STATO_OPFO
	 * @generated
	 */
	protected Integer fkStatoOpfo;

	/**
	 * Imposta il valore della proprieta' fkStatoOpfo associata alla
	 * colonna FK_STATO_OPFO.
	 * @generated
	 */
	public void setFkStatoOpfo(Integer val) {

		fkStatoOpfo = val;

	}

	/**
	 * Legge il valore della proprieta' fkStatoOpfo associata alla
	 * @generated
	 */
	public Integer getFkStatoOpfo() {

		return fkStatoOpfo;

	}

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
	 * store della proprieta' associata alla colonna FLG_PUBBLICO
	 * @generated
	 */
	protected java.math.BigDecimal flgPubblico;

	/**
	 * Imposta il valore della proprieta' flgPubblico associata alla
	 * colonna FLG_PUBBLICO.
	 * @generated
	 */
	public void setFlgPubblico(java.math.BigDecimal val) {

		flgPubblico = val;

	}

	/**
	 * Legge il valore della proprieta' flgPubblico associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgPubblico() {

		return flgPubblico;

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
	 * Crea una istanza di TaifTOpfoPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTOpfoPk
	 * @generated
	 */
	public TaifTOpfoPk createPk() {
		return new TaifTOpfoPk(idPersona);
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
