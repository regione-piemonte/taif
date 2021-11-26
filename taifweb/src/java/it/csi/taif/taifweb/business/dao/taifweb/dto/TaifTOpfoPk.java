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
 * Primary Key del DTO TaifTOpfoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTOpfoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_PERSONA
	 * @generated
	 */
	protected Integer idPersona;

	/**
	 * Imposta il valore della proprieta' idPersona associata alla
	 * colonna ID_PERSONA.
	 * @generated
	 */
	public void setIdPersona(Integer val) {

		idPersona = val;

	}

	/**
	 * Legge il valore della proprieta' idPersona associata alla
	 * @generated
	 */
	public Integer getIdPersona() {

		return idPersona;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTOpfoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTOpfoPk(

			final Integer idPersona

	) {

		this.setIdPersona(idPersona);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTOpfoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTOpfoPk)) {
			return false;
		}

		final TaifTOpfoPk _cast = (TaifTOpfoPk) _other;

		if (idPersona == null ? _cast.getIdPersona() != null : !idPersona.equals(_cast.getIdPersona())) {
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

		if (idPersona != null) {
			_hashCode = 29 * _hashCode + idPersona.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTOpfoPk: ");
		ret.append("idPersona=" + idPersona);

		return ret.toString();
	}
}
