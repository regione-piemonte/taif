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
 * Primary Key del DTO TaifTAgenziaFormativaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTAgenziaFormativaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_AGENZIA_FORMATIVA
	 * @generated
	 */
	protected Integer idAgenziaFormativa;

	/**
	 * Imposta il valore della proprieta' idAgenziaFormativa associata alla
	 * colonna ID_AGENZIA_FORMATIVA.
	 * @generated
	 */
	public void setIdAgenziaFormativa(Integer val) {

		idAgenziaFormativa = val;

	}

	/**
	 * Legge il valore della proprieta' idAgenziaFormativa associata alla
	 * @generated
	 */
	public Integer getIdAgenziaFormativa() {

		return idAgenziaFormativa;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTAgenziaFormativaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTAgenziaFormativaPk(

			final Integer idAgenziaFormativa

	) {

		this.setIdAgenziaFormativa(idAgenziaFormativa);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTAgenziaFormativaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTAgenziaFormativaPk)) {
			return false;
		}

		final TaifTAgenziaFormativaPk _cast = (TaifTAgenziaFormativaPk) _other;

		if (idAgenziaFormativa == null
				? _cast.getIdAgenziaFormativa() != null
				: !idAgenziaFormativa.equals(_cast.getIdAgenziaFormativa())) {
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

		if (idAgenziaFormativa != null) {
			_hashCode = 29 * _hashCode + idAgenziaFormativa.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAgenziaFormativaPk: ");
		ret.append("idAgenziaFormativa=" + idAgenziaFormativa);

		return ret.toString();
	}
}
