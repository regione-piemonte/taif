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
 * Primary Key del DTO TaifDTrazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTrazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TRAZIONE
	 * @generated
	 */
	protected Integer idTrazione;

	/**
	 * Imposta il valore della proprieta' idTrazione associata alla
	 * colonna ID_TRAZIONE.
	 * @generated
	 */
	public void setIdTrazione(Integer val) {

		idTrazione = val;

	}

	/**
	 * Legge il valore della proprieta' idTrazione associata alla
	 * @generated
	 */
	public Integer getIdTrazione() {

		return idTrazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTrazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTrazionePk(

			final Integer idTrazione

	) {

		this.setIdTrazione(idTrazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTrazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTrazionePk)) {
			return false;
		}

		final TaifDTrazionePk _cast = (TaifDTrazionePk) _other;

		if (idTrazione == null ? _cast.getIdTrazione() != null : !idTrazione.equals(_cast.getIdTrazione())) {
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

		if (idTrazione != null) {
			_hashCode = 29 * _hashCode + idTrazione.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTrazionePk: ");
		ret.append("idTrazione=" + idTrazione);

		return ret.toString();
	}
}
