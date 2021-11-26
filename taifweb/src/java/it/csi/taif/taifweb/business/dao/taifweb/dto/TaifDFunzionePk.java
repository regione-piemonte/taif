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
 * Primary Key del DTO TaifDFunzioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDFunzionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_FUNZIONE
	 * @generated
	 */
	protected Integer idFunzione;

	/**
	 * Imposta il valore della proprieta' idFunzione associata alla
	 * colonna ID_FUNZIONE.
	 * @generated
	 */
	public void setIdFunzione(Integer val) {

		idFunzione = val;

	}

	/**
	 * Legge il valore della proprieta' idFunzione associata alla
	 * @generated
	 */
	public Integer getIdFunzione() {

		return idFunzione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDFunzionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDFunzionePk(

			final Integer idFunzione

	) {

		this.setIdFunzione(idFunzione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDFunzionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDFunzionePk)) {
			return false;
		}

		final TaifDFunzionePk _cast = (TaifDFunzionePk) _other;

		if (idFunzione == null ? _cast.getIdFunzione() != null : !idFunzione.equals(_cast.getIdFunzione())) {
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

		if (idFunzione != null) {
			_hashCode = 29 * _hashCode + idFunzione.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDFunzionePk: ");
		ret.append("idFunzione=" + idFunzione);

		return ret.toString();
	}
}
