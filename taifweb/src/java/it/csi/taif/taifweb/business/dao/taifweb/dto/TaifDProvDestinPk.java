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
 * Primary Key del DTO TaifDProvDestinDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDProvDestinPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_PROV_DESTIN
	 * @generated
	 */
	protected Integer idProvDestin;

	/**
	 * Imposta il valore della proprieta' idProvDestin associata alla
	 * colonna ID_PROV_DESTIN.
	 * @generated
	 */
	public void setIdProvDestin(Integer val) {

		idProvDestin = val;

	}

	/**
	 * Legge il valore della proprieta' idProvDestin associata alla
	 * @generated
	 */
	public Integer getIdProvDestin() {

		return idProvDestin;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDProvDestinPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDProvDestinPk(

			final Integer idProvDestin

	) {

		this.setIdProvDestin(idProvDestin);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDProvDestinPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDProvDestinPk)) {
			return false;
		}

		final TaifDProvDestinPk _cast = (TaifDProvDestinPk) _other;

		if (idProvDestin == null ? _cast.getIdProvDestin() != null : !idProvDestin.equals(_cast.getIdProvDestin())) {
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

		if (idProvDestin != null) {
			_hashCode = 29 * _hashCode + idProvDestin.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDProvDestinPk: ");
		ret.append("idProvDestin=" + idProvDestin);

		return ret.toString();
	}
}
