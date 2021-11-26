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
 * Primary Key del DTO TaifDRuoloDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDRuoloPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_RUOLO
	 * @generated
	 */
	protected Integer idRuolo;

	/**
	 * Imposta il valore della proprieta' idRuolo associata alla
	 * colonna ID_RUOLO.
	 * @generated
	 */
	public void setIdRuolo(Integer val) {

		idRuolo = val;

	}

	/**
	 * Legge il valore della proprieta' idRuolo associata alla
	 * @generated
	 */
	public Integer getIdRuolo() {

		return idRuolo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDRuoloPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDRuoloPk(

			final Integer idRuolo

	) {

		this.setIdRuolo(idRuolo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDRuoloPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDRuoloPk)) {
			return false;
		}

		final TaifDRuoloPk _cast = (TaifDRuoloPk) _other;

		if (idRuolo == null ? _cast.getIdRuolo() != null : !idRuolo.equals(_cast.getIdRuolo())) {
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

		if (idRuolo != null) {
			_hashCode = 29 * _hashCode + idRuolo.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDRuoloPk: ");
		ret.append("idRuolo=" + idRuolo);

		return ret.toString();
	}
}
