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
 * Data transfer object relativo al DAO TaifTLavoroPaDao.
 * @generated
 */
public class TaifTLavoroPaDto extends TaifTLavoroPaPk {

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
	 * store della proprieta' associata alla colonna FK_TIPO_LAVORO_PA
	 * @generated
	 */
	protected Integer fkTipoLavoroPa;

	/**
	 * Imposta il valore della proprieta' fkTipoLavoroPa associata alla
	 * colonna FK_TIPO_LAVORO_PA.
	 * @generated
	 */
	public void setFkTipoLavoroPa(Integer val) {

		fkTipoLavoroPa = val;

	}

	/**
	 * Legge il valore della proprieta' fkTipoLavoroPa associata alla
	 * @generated
	 */
	public Integer getFkTipoLavoroPa() {

		return fkTipoLavoroPa;

	}

	/**
	 * store della proprieta' associata alla colonna COMMITTENTE
	 * @generated
	 */
	protected String committente;

	/**
	 * Imposta il valore della proprieta' committente associata alla
	 * colonna COMMITTENTE.
	 * @generated
	 */
	public void setCommittente(String val) {

		committente = val;

	}

	/**
	 * Legge il valore della proprieta' committente associata alla
	 * @generated
	 */
	public String getCommittente() {

		return committente;

	}

	/**
	 * store della proprieta' associata alla colonna IMPORTO
	 * @generated
	 */
	protected java.math.BigDecimal importo;

	/**
	 * Imposta il valore della proprieta' importo associata alla
	 * colonna IMPORTO.
	 * @generated
	 */
	public void setImporto(java.math.BigDecimal val) {

		importo = val;

	}

	/**
	 * Legge il valore della proprieta' importo associata alla
	 * @generated
	 */
	public java.math.BigDecimal getImporto() {

		return importo;

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
	 * Crea una istanza di TaifTLavoroPaPk a partire dal valore dei campi chiave del DTO
	 * 
	 * @return TaifTLavoroPaPk
	 * @generated
	 */
	public TaifTLavoroPaPk createPk() {
		return new TaifTLavoroPaPk(idLavoroPa);
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
