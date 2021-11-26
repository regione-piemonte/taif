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
 * Primary Key del DTO TaifDStatoOpfoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDStatoOpfoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_STATO_OPFO
	 * @generated
	 */
	protected Integer idStatoOpfo;

	/**
	 * Imposta il valore della proprieta' idStatoOpfo associata alla
	 * colonna ID_STATO_OPFO.
	 * @generated
	 */
	public void setIdStatoOpfo(Integer val) {

		idStatoOpfo = val;

	}

	/**
	 * Legge il valore della proprieta' idStatoOpfo associata alla
	 * @generated
	 */
	public Integer getIdStatoOpfo() {

		return idStatoOpfo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDStatoOpfoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDStatoOpfoPk(

			final Integer idStatoOpfo

	) {

		this.setIdStatoOpfo(idStatoOpfo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDStatoOpfoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDStatoOpfoPk)) {
			return false;
		}

		final TaifDStatoOpfoPk _cast = (TaifDStatoOpfoPk) _other;

		if (idStatoOpfo == null ? _cast.getIdStatoOpfo() != null : !idStatoOpfo.equals(_cast.getIdStatoOpfo())) {
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

		if (idStatoOpfo != null) {
			_hashCode = 29 * _hashCode + idStatoOpfo.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDStatoOpfoPk: ");
		ret.append("idStatoOpfo=" + idStatoOpfo);

		return ret.toString();
	}
}
