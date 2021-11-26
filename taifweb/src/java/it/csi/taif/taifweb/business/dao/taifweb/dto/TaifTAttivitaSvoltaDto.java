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
 * Data transfer object relativo al DAO TaifTAttivitaSvoltaDao.
 * @generated
 */
public class TaifTAttivitaSvoltaDto extends TaifTAttivitaSvoltaPk {

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
	 * store della proprieta' associata alla colonna FK_TIPO_ATTIVITA
	 * @generated
	 */
	protected Integer fkTipoAttivita;

	/**
	 * Imposta il valore della proprieta' fkTipoAttivita associata alla
	 * colonna FK_TIPO_ATTIVITA.
	 * @generated
	 */
	public void setFkTipoAttivita(Integer val) {

		fkTipoAttivita = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoAttivita associata alla
	 * @generated
	 */
	public Integer getFkTipoAttivita() {

		return fkTipoAttivita;

	}

	/**
	 * store della proprieta' associata alla colonna DESCR_ALTRE_ATTIVITA
	 * @generated
	 */
	protected String descrAltreAttivita;

	/**
	 * Imposta il valore della proprieta' descrAltreAttivita associata alla
	 * colonna DESCR_ALTRE_ATTIVITA.
	 * @generated
	 */
	public void setDescrAltreAttivita(String val) {

		descrAltreAttivita = val;

	}

	/**
	 * Legge il valore della proprieta' descrAltreAttivita associata alla
	 * @generated
	 */
	public String getDescrAltreAttivita() {

		return descrAltreAttivita;

	}

	/**
	 * store della proprieta' associata alla colonna PERC_FATTURATO
	 * @generated
	 */
	protected java.math.BigDecimal percFatturato;

	/**
	 * Imposta il valore della proprieta' percFatturato associata alla
	 * colonna PERC_FATTURATO.
	 * @generated
	 */
	public void setPercFatturato(java.math.BigDecimal val) {

		percFatturato = val;

	}

	/**
	 * Legge il valore della proprieta' percFatturato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getPercFatturato() {

		return percFatturato;

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
	 * Crea una istanza di TaifTAttivitaSvoltaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTAttivitaSvoltaPk
	 * @generated
	 */
	public TaifTAttivitaSvoltaPk createPk() {
		return new TaifTAttivitaSvoltaPk(idAttivita);
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
