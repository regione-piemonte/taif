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
 * Primary Key del DTO TaifTDpiDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTDpiPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_DPI
	 * @generated
	 */
	protected Integer idDpi;

	/**
	 * Imposta il valore della proprieta' idDpi associata alla
	 * colonna ID_DPI.
	 * @generated
	 */
	public void setIdDpi(Integer val) {

		idDpi = val;

	}

	/**
	 * Legge il valore della proprieta' idDpi associata alla
	 * @generated
	 */
	public Integer getIdDpi() {

		return idDpi;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTDpiPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTDpiPk(

			final Integer idDpi

	) {

		this.setIdDpi(idDpi);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTDpiPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTDpiPk)) {
			return false;
		}

		final TaifTDpiPk _cast = (TaifTDpiPk) _other;

		if (idDpi == null ? _cast.getIdDpi() != null : !idDpi.equals(_cast.getIdDpi())) {
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

		if (idDpi != null) {
			_hashCode = 29 * _hashCode + idDpi.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTDpiPk: ");
		ret.append("idDpi=" + idDpi);

		return ret.toString();
	}
}
