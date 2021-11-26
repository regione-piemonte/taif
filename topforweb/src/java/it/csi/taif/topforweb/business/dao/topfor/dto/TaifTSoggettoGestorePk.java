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
 * Primary Key del DTO TaifTSoggettoGestoreDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTSoggettoGestorePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_SOGGETTO_GESTORE
	 * @generated
	 */
	protected Integer idSoggettoGestore;

	/**
	 * Imposta il valore della proprieta' idSoggettoGestore associata alla
	 * colonna ID_SOGGETTO_GESTORE.
	 * @generated
	 */
	public void setIdSoggettoGestore(Integer val) {

		idSoggettoGestore = val;

	}

	/**
	 * Legge il valore della proprieta' idSoggettoGestore associata alla
	 * @generated
	 */
	public Integer getIdSoggettoGestore() {

		return idSoggettoGestore;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTSoggettoGestorePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTSoggettoGestorePk(

			final Integer idSoggettoGestore

	) {

		this.setIdSoggettoGestore(idSoggettoGestore);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTSoggettoGestorePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTSoggettoGestorePk)) {
			return false;
		}

		final TaifTSoggettoGestorePk _cast = (TaifTSoggettoGestorePk) _other;

		if (idSoggettoGestore == null
				? _cast.getIdSoggettoGestore() != null
				: !idSoggettoGestore.equals(_cast.getIdSoggettoGestore())) {
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

		if (idSoggettoGestore != null) {
			_hashCode = 29 * _hashCode + idSoggettoGestore.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifTSoggettoGestorePk: ");
		ret.append("idSoggettoGestore=" + idSoggettoGestore);

		return ret.toString();
	}
}
