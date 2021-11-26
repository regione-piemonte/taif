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
 * Data transfer object relativo al DAO TaifRPersonaAziendaDao.
 * @generated
 */
public class TaifRPersonaAziendaDto extends TaifRPersonaAziendaPk {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna FK_RUOLO
	 * @generated
	 */
	protected Integer fkRuolo;

	/**
	 * Imposta il valore della proprieta' fkRuolo associata alla
	 * colonna FK_RUOLO.
	 * @generated
	 */
	public void setFkRuolo(Integer val) {

		fkRuolo = val;

	}

	/**
	 * Legge il valore della proprieta' fkRuolo associata alla
	 * @generated
	 */
	public Integer getFkRuolo() {

		return fkRuolo;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_MANSIONE
	 * @generated
	 */
	protected Integer fkTipoMansione;

	/**
	 * Imposta il valore della proprieta' fkTipoMansione associata alla
	 * colonna FK_TIPO_MANSIONE.
	 * @generated
	 */
	public void setFkTipoMansione(Integer val) {

		fkTipoMansione = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoMansione associata alla
	 * @generated
	 */
	public Integer getFkTipoMansione() {

		return fkTipoMansione;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_CONTRATTO
	 * @generated
	 */
	protected Integer fkTipoContratto;

	/**
	 * Imposta il valore della proprieta' fkTipoContratto associata alla
	 * colonna FK_TIPO_CONTRATTO.
	 * @generated
	 */
	public void setFkTipoContratto(Integer val) {

		fkTipoContratto = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoContratto associata alla
	 * @generated
	 */
	public Integer getFkTipoContratto() {

		return fkTipoContratto;

	}

	/**
	 * store della proprieta' associata alla colonna FK_TIPO_INQUADRAMENTO
	 * @generated
	 */
	protected Integer fkTipoInquadramento;

	/**
	 * Imposta il valore della proprieta' fkTipoInquadramento associata alla
	 * colonna FK_TIPO_INQUADRAMENTO.
	 * @generated
	 */
	public void setFkTipoInquadramento(Integer val) {

		fkTipoInquadramento = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoInquadramento associata alla
	 * @generated
	 */
	public Integer getFkTipoInquadramento() {

		return fkTipoInquadramento;

	}

	/**
	 * store della proprieta' associata alla colonna FLG_TEMPO_DETERMINATO
	 * @generated
	 */
	protected java.math.BigDecimal flgTempoDeterminato;

	/**
	 * Imposta il valore della proprieta' flgTempoDeterminato associata alla
	 * colonna FLG_TEMPO_DETERMINATO.
	 * @generated
	 */
	public void setFlgTempoDeterminato(java.math.BigDecimal val) {

		flgTempoDeterminato = val;

	}

	/**
	 * Legge il valore della proprieta' flgTempoDeterminato associata alla
	 * @generated
	 */
	public java.math.BigDecimal getFlgTempoDeterminato() {

		return flgTempoDeterminato;

	}

	/**
	 * store della proprieta' associata alla colonna GG_TEMPO_DETERMINATO
	 * @generated
	 */
	protected Integer ggTempoDeterminato;

	/**
	 * Imposta il valore della proprieta' ggTempoDeterminato associata alla
	 * colonna GG_TEMPO_DETERMINATO.
	 * @generated
	 */
	public void setGgTempoDeterminato(Integer val) {

		ggTempoDeterminato = val;

	}

	/**
	 * Legge il valore della proprieta' ggTempoDeterminato associata alla
	 * @generated
	 */
	public Integer getGgTempoDeterminato() {

		return ggTempoDeterminato;

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
	 * Crea una istanza di TaifRPersonaAziendaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifRPersonaAziendaPk
	 * @generated
	 */
	public TaifRPersonaAziendaPk createPk() {
		return new TaifRPersonaAziendaPk(idPersona, idAzienda);
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
