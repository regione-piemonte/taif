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
 * Primary Key del DTO TaifTStoricoStatoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTStoricoStatoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_PRATICA
	 * @generated
	 */
	protected Integer idPratica;

	/**
	 * Imposta il valore della proprieta' idPratica associata alla
	 * colonna ID_PRATICA.
	 * @generated
	 */
	public void setIdPratica(Integer val) {

		idPratica = val;

	}

	/**
	 * Legge il valore della proprieta' idPratica associata alla
	 * @generated
	 */
	public Integer getIdPratica() {

		return idPratica;

	}

	/**
	 * store della proprieta' associata alla colonna DATA_INSERIMENTO_STATO
	 * @generated
	 */
	protected java.sql.Timestamp dataInserimentoStato;

	/**
	 * Imposta il valore della proprieta' dataInserimentoStato associata alla
	 * colonna DATA_INSERIMENTO_STATO.
	 * @generated
	 */
	public void setDataInserimentoStato(java.sql.Timestamp val) {

		if (val != null) {
			dataInserimentoStato = new java.sql.Timestamp(val.getTime());
		} else {
			dataInserimentoStato = null;
		}

	}

	/**
	 * Legge il valore della proprieta' dataInserimentoStato associata alla
	 * @generated
	 */
	public java.sql.Timestamp getDataInserimentoStato() {

		if (dataInserimentoStato != null) {
			return new java.sql.Timestamp(dataInserimentoStato.getTime());
		} else {
			return null;
		}

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTStoricoStatoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTStoricoStatoPk(

			final Integer idPratica, final java.sql.Timestamp dataInserimentoStato

	) {

		this.setIdPratica(idPratica);

		this.setDataInserimentoStato(dataInserimentoStato);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTStoricoStatoPk sono equals se i valori di tutti i campi coincidono.
	 * 
	 * @param _other
	 * @return boolean se i due oggetti sono uguali
	 */
	public boolean equals(Object _other) {
		if (_other == null) {
			return false;
		}

		if (_other == this) {
			return true;
		}

		if (!(_other instanceof TaifTStoricoStatoPk)) {
			return false;
		}

		final TaifTStoricoStatoPk _cast = (TaifTStoricoStatoPk) _other;

		if (idPratica == null ? _cast.getIdPratica() != null : !idPratica.equals(_cast.getIdPratica())) {
			return false;
		}

		if (dataInserimentoStato == null
				? _cast.getDataInserimentoStato() != null
				: !dataInserimentoStato.equals(_cast.getDataInserimentoStato())) {
			return false;
		}

		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode() {
		int _hashCode = 0;

		if (idPratica != null) {
			_hashCode = 29 * _hashCode + idPratica.hashCode();
		}

		if (dataInserimentoStato != null) {
			_hashCode = 29 * _hashCode + dataInserimentoStato.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStoricoStatoPk: ");
		ret.append("idPratica=" + idPratica);

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStoricoStatoPk: ");
		ret.append("dataInserimentoStato=" + dataInserimentoStato);

		return ret.toString();
	}
}
