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
 * Primary Key del DTO TaifTSedeAziendaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTSedeAziendaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_SEDE
	 * @generated
	 */
	protected Integer idSede;

	/**
	 * Imposta il valore della proprieta' idSede associata alla
	 * colonna ID_SEDE.
	 * @generated
	 */
	public void setIdSede(Integer val) {

		idSede = val;

	}

	/**
	 * Legge il valore della proprieta' idSede associata alla
	 * @generated
	 */
	public Integer getIdSede() {

		return idSede;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTSedeAziendaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTSedeAziendaPk(

			final Integer idSede

	) {

		this.setIdSede(idSede);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTSedeAziendaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTSedeAziendaPk)) {
			return false;
		}

		final TaifTSedeAziendaPk _cast = (TaifTSedeAziendaPk) _other;

		if (idSede == null ? _cast.getIdSede() != null : !idSede.equals(_cast.getIdSede())) {
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

		if (idSede != null) {
			_hashCode = 29 * _hashCode + idSede.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTSedeAziendaPk: ");
		ret.append("idSede=" + idSede);

		return ret.toString();
	}
}
