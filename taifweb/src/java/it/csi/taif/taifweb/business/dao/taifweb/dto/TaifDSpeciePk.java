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
 * Primary Key del DTO TaifDSpecieDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDSpeciePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_SPECIE
	 * @generated
	 */
	protected Integer idSpecie;

	/**
	 * Imposta il valore della proprieta' idSpecie associata alla
	 * colonna ID_SPECIE.
	 * @generated
	 */
	public void setIdSpecie(Integer val) {

		idSpecie = val;

	}

	/**
	 * Legge il valore della proprieta' idSpecie associata alla
	 * @generated
	 */
	public Integer getIdSpecie() {

		return idSpecie;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDSpeciePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDSpeciePk(

			final Integer idSpecie

	) {

		this.setIdSpecie(idSpecie);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDSpeciePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDSpeciePk)) {
			return false;
		}

		final TaifDSpeciePk _cast = (TaifDSpeciePk) _other;

		if (idSpecie == null ? _cast.getIdSpecie() != null : !idSpecie.equals(_cast.getIdSpecie())) {
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

		if (idSpecie != null) {
			_hashCode = 29 * _hashCode + idSpecie.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDSpeciePk: ");
		ret.append("idSpecie=" + idSpecie);

		return ret.toString();
	}
}
