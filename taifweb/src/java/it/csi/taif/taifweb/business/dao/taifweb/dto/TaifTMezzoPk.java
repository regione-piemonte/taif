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
 * Primary Key del DTO TaifTMezzoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTMezzoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_MEZZO
	 * @generated
	 */
	protected Integer idMezzo;

	/**
	 * Imposta il valore della proprieta' idMezzo associata alla
	 * colonna ID_MEZZO.
	 * @generated
	 */
	public void setIdMezzo(Integer val) {

		idMezzo = val;

	}

	/**
	 * Legge il valore della proprieta' idMezzo associata alla
	 * @generated
	 */
	public Integer getIdMezzo() {

		return idMezzo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTMezzoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTMezzoPk(

			final Integer idMezzo

	) {

		this.setIdMezzo(idMezzo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTMezzoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTMezzoPk)) {
			return false;
		}

		final TaifTMezzoPk _cast = (TaifTMezzoPk) _other;

		if (idMezzo == null ? _cast.getIdMezzo() != null : !idMezzo.equals(_cast.getIdMezzo())) {
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

		if (idMezzo != null) {
			_hashCode = 29 * _hashCode + idMezzo.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTMezzoPk: ");
		ret.append("idMezzo=" + idMezzo);

		return ret.toString();
	}
}
