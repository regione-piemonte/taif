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
 * Primary Key del DTO TaifDUnitaFormativaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDUnitaFormativaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_UNITA_FORMATIVA
	 * @generated
	 */
	protected Integer idUnitaFormativa;

	/**
	 * Imposta il valore della proprieta' idUnitaFormativa associata alla
	 * colonna ID_UNITA_FORMATIVA.
	 * @generated
	 */
	public void setIdUnitaFormativa(Integer val) {

		idUnitaFormativa = val;

	}

	/**
	 * Legge il valore della proprieta' idUnitaFormativa associata alla
	 * @generated
	 */
	public Integer getIdUnitaFormativa() {

		return idUnitaFormativa;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDUnitaFormativaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDUnitaFormativaPk(

			final Integer idUnitaFormativa

	) {

		this.setIdUnitaFormativa(idUnitaFormativa);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDUnitaFormativaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDUnitaFormativaPk)) {
			return false;
		}

		final TaifDUnitaFormativaPk _cast = (TaifDUnitaFormativaPk) _other;

		if (idUnitaFormativa == null
				? _cast.getIdUnitaFormativa() != null
				: !idUnitaFormativa.equals(_cast.getIdUnitaFormativa())) {
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

		if (idUnitaFormativa != null) {
			_hashCode = 29 * _hashCode + idUnitaFormativa.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifDUnitaFormativaPk: ");
		ret.append("idUnitaFormativa=" + idUnitaFormativa);

		return ret.toString();
	}
}
