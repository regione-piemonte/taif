/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dto;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import java.io.Serializable;
import java.util.*;

/**
 * Primary Key del DTO TaifDStatoPraticaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDStatoPraticaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO_PRATICA
	 * @generated
	 */
	protected Integer idStatoPratica;

	/**
	 * Imposta il valore della proprieta' idStatoPratica associata alla
	 * colonna ID_STATO_PRATICA.
	 * @generated
	 */
	public void setIdStatoPratica(Integer val) {

		idStatoPratica = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoPratica associata alla
	 * @generated
	 */
	public Integer getIdStatoPratica() {

		return idStatoPratica;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDStatoPraticaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDStatoPraticaPk(

			final Integer idStatoPratica

	) {

		this.setIdStatoPratica(idStatoPratica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDStatoPraticaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDStatoPraticaPk)) {
			return false;
		}

		final TaifDStatoPraticaPk _cast = (TaifDStatoPraticaPk) _other;

		if (idStatoPratica == null
				? _cast.getIdStatoPratica() != null
				: !idStatoPratica.equals(_cast.getIdStatoPratica())) {
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

		if (idStatoPratica != null) {
			_hashCode = 29 * _hashCode + idStatoPratica.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifDStatoPraticaPk: ");
		ret.append("idStatoPratica=" + idStatoPratica);

		return ret.toString();
	}
}
