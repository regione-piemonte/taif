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
 * Data transfer object relativo al DAO TaifTQualificaDao.
 * @generated
 */
public class TaifTQualificaDto extends TaifTQualificaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_QUALIFICA
	 * @generated
	 */
	protected Integer fkTipoQualifica;

	/**
	 * Imposta il valore della proprieta' fkTipoQualifica associata alla
	 * colonna FK_TIPO_QUALIFICA.
	 * @generated
	 */
	public void setFkTipoQualifica(Integer val) {

		fkTipoQualifica = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoQualifica associata alla
	 * @generated
	 */
	public Integer getFkTipoQualifica() {

		return fkTipoQualifica;

	}

	/**
	 * store della proprieta' associata alla colonna FK_AGENZIA_FORMATIVA
	 * @generated
	 */
	protected Integer fkAgenziaFormativa;

	/**
	 * Imposta il valore della proprieta' fkAgenziaFormativa associata alla
	 * colonna FK_AGENZIA_FORMATIVA.
	 * @generated
	 */
	public void setFkAgenziaFormativa(Integer val) {

		fkAgenziaFormativa = val;

	}

	/**
	 * Legge il valore della proprieta' fkAgenziaFormativa associata alla
	 * @generated
	 */
	public Integer getFkAgenziaFormativa() {

		return fkAgenziaFormativa;

	}

	/**
	 * store della proprieta' associata alla colonna FK_PERSONA
	 * @generated
	 */
	protected Integer fkPersona;

	/**
	 * Imposta il valore della proprieta' fkPersona associata alla
	 * colonna FK_PERSONA.
	 * @generated
	 */
	public void setFkPersona(Integer val) {

		fkPersona = val;

	}

	/**
	 * Legge il valore della proprieta' fkPersona associata alla
	 * @generated
	 */
	public Integer getFkPersona() {

		return fkPersona;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_RILASCIO
	 * @generated
	 */
	protected java.sql.Date dataRilascio;

	/**
	 * Imposta il valore della proprieta' dataRilascio associata alla
	 * colonna DATA_RILASCIO.
	 * @generated
	 */
	public void setDataRilascio(java.sql.Date val) {

		if (val != null) {
			dataRilascio = new java.sql.Date(val.getTime());
		} else {
			dataRilascio = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataRilascio associata alla
	 * @generated
	 */
	public java.sql.Date getDataRilascio() {

		if (dataRilascio != null) {
			return new java.sql.Date(dataRilascio.getTime());
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
	 * Crea una istanza di TaifTQualificaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTQualificaPk
	 * @generated
	 */
	public TaifTQualificaPk createPk() {
		return new TaifTQualificaPk(idQualifica);
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
