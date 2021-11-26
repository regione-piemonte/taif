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
 * Primary Key del DTO TaifDTipoDpiDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoDpiPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_DPI
	 * @generated
	 */
	protected Integer idTipoDpi;

	/**
	 * Imposta il valore della proprieta' idTipoDpi associata alla
	 * colonna ID_TIPO_DPI.
	 * @generated
	 */
	public void setIdTipoDpi(Integer val) {

		idTipoDpi = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoDpi associata alla
	 * @generated
	 */
	public Integer getIdTipoDpi() {

		return idTipoDpi;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoDpiPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoDpiPk(

			final Integer idTipoDpi

	) {

		this.setIdTipoDpi(idTipoDpi);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoDpiPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoDpiPk)) {
			return false;
		}

		final TaifDTipoDpiPk _cast = (TaifDTipoDpiPk) _other;

		if (idTipoDpi == null ? _cast.getIdTipoDpi() != null : !idTipoDpi.equals(_cast.getIdTipoDpi())) {
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

		if (idTipoDpi != null) {
			_hashCode = 29 * _hashCode + idTipoDpi.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoDpiPk: ");
		ret.append("idTipoDpi=" + idTipoDpi);

		return ret.toString();
	}
}
