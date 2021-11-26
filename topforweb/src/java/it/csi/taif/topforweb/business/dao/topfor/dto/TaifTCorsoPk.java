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
 * Primary Key del DTO TaifTCorsoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTCorsoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CORSO
	 * @generated
	 */
	protected Integer idCorso;

	/**
	 * Imposta il valore della proprieta' idCorso associata alla
	 * colonna ID_CORSO.
	 * @generated
	 */
	public void setIdCorso(Integer val) {

		idCorso = val;

	}

	/**
	 * Legge il valore della proprieta' idCorso associata alla
	 * @generated
	 */
	public Integer getIdCorso() {

		return idCorso;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTCorsoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTCorsoPk(

			final Integer idCorso

	) {

		this.setIdCorso(idCorso);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTCorsoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTCorsoPk)) {
			return false;
		}

		final TaifTCorsoPk _cast = (TaifTCorsoPk) _other;

		if (idCorso == null ? _cast.getIdCorso() != null : !idCorso.equals(_cast.getIdCorso())) {
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

		if (idCorso != null) {
			_hashCode = 29 * _hashCode + idCorso.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifTCorsoPk: ");
		ret.append("idCorso=" + idCorso);

		return ret.toString();
	}
}
