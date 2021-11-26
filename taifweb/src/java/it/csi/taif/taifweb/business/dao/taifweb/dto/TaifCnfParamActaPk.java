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
 * Primary Key del DTO TaifCnfParamActaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifCnfParamActaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CONFIG_PARAM_ACTA
	 * @generated
	 */
	protected Integer idConfigParamActa;

	/**
	 * Imposta il valore della proprieta' idConfigParamActa associata alla
	 * colonna ID_CONFIG_PARAM_ACTA.
	 * @generated
	 */
	public void setIdConfigParamActa(Integer val) {

		idConfigParamActa = val;

	}

	/**
	 * Legge il valore della proprieta' idConfigParamActa associata alla
	 * @generated
	 */
	public Integer getIdConfigParamActa() {

		return idConfigParamActa;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifCnfParamActaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifCnfParamActaPk(

			final Integer idConfigParamActa

	) {

		this.setIdConfigParamActa(idConfigParamActa);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifCnfParamActaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifCnfParamActaPk)) {
			return false;
		}

		final TaifCnfParamActaPk _cast = (TaifCnfParamActaPk) _other;

		if (idConfigParamActa == null
				? _cast.getIdConfigParamActa() != null
				: !idConfigParamActa.equals(_cast.getIdConfigParamActa())) {
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

		if (idConfigParamActa != null) {
			_hashCode = 29 * _hashCode + idConfigParamActa.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfParamActaPk: ");
		ret.append("idConfigParamActa=" + idConfigParamActa);

		return ret.toString();
	}
}
