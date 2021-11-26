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
 * Primary Key del DTO TaifTPraticaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTPraticaPk implements Serializable {

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
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTPraticaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTPraticaPk(

			final Integer idPratica

	) {

		this.setIdPratica(idPratica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTPraticaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTPraticaPk)) {
			return false;
		}

		final TaifTPraticaPk _cast = (TaifTPraticaPk) _other;

		if (idPratica == null ? _cast.getIdPratica() != null : !idPratica.equals(_cast.getIdPratica())) {
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

		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaPk: ");
		ret.append("idPratica=" + idPratica);

		return ret.toString();
	}
}
