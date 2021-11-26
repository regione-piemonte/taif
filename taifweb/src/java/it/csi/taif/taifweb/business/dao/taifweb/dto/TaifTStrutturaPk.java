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
 * Primary Key del DTO TaifTStrutturaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTStrutturaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STRUTTURA
	 * @generated
	 */
	protected Integer idStruttura;

	/**
	 * Imposta il valore della proprieta' idStruttura associata alla
	 * colonna ID_STRUTTURA.
	 * @generated
	 */
	public void setIdStruttura(Integer val) {

		idStruttura = val;

	}

	/**
	 * Legge il valore della proprieta' idStruttura associata alla
	 * @generated
	 */
	public Integer getIdStruttura() {

		return idStruttura;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTStrutturaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTStrutturaPk(

			final Integer idStruttura

	) {

		this.setIdStruttura(idStruttura);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTStrutturaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTStrutturaPk)) {
			return false;
		}

		final TaifTStrutturaPk _cast = (TaifTStrutturaPk) _other;

		if (idStruttura == null ? _cast.getIdStruttura() != null : !idStruttura.equals(_cast.getIdStruttura())) {
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

		if (idStruttura != null) {
			_hashCode = 29 * _hashCode + idStruttura.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTStrutturaPk: ");
		ret.append("idStruttura=" + idStruttura);

		return ret.toString();
	}
}
