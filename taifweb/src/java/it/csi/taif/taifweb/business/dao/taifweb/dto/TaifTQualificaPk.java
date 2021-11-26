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
 * Primary Key del DTO TaifTQualificaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTQualificaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_QUALIFICA
	 * @generated
	 */
	protected Integer idQualifica;

	/**
	 * Imposta il valore della proprieta' idQualifica associata alla
	 * colonna ID_QUALIFICA.
	 * @generated
	 */
	public void setIdQualifica(Integer val) {

		idQualifica = val;

	}

	/**
	 * Legge il valore della proprieta' idQualifica associata alla
	 * @generated
	 */
	public Integer getIdQualifica() {

		return idQualifica;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTQualificaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTQualificaPk(

			final Integer idQualifica

	) {

		this.setIdQualifica(idQualifica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTQualificaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTQualificaPk)) {
			return false;
		}

		final TaifTQualificaPk _cast = (TaifTQualificaPk) _other;

		if (idQualifica == null ? _cast.getIdQualifica() != null : !idQualifica.equals(_cast.getIdQualifica())) {
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

		if (idQualifica != null) {
			_hashCode = 29 * _hashCode + idQualifica.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTQualificaPk: ");
		ret.append("idQualifica=" + idQualifica);

		return ret.toString();
	}
}
