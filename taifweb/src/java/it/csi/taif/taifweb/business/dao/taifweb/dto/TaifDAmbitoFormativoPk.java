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
 * Primary Key del DTO TaifDAmbitoFormativoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDAmbitoFormativoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_AMBITO_FORMATIVO
	 * @generated
	 */
	protected Integer idAmbitoFormativo;

	/**
	 * Imposta il valore della proprieta' idAmbitoFormativo associata alla
	 * colonna ID_AMBITO_FORMATIVO.
	 * @generated
	 */
	public void setIdAmbitoFormativo(Integer val) {

		idAmbitoFormativo = val;

	}

	/**
	 * Legge il valore della proprieta' idAmbitoFormativo associata alla
	 * @generated
	 */
	public Integer getIdAmbitoFormativo() {

		return idAmbitoFormativo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDAmbitoFormativoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDAmbitoFormativoPk(

			final Integer idAmbitoFormativo

	) {

		this.setIdAmbitoFormativo(idAmbitoFormativo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDAmbitoFormativoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDAmbitoFormativoPk)) {
			return false;
		}

		final TaifDAmbitoFormativoPk _cast = (TaifDAmbitoFormativoPk) _other;

		if (idAmbitoFormativo == null
				? _cast.getIdAmbitoFormativo() != null
				: !idAmbitoFormativo.equals(_cast.getIdAmbitoFormativo())) {
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

		if (idAmbitoFormativo != null) {
			_hashCode = 29 * _hashCode + idAmbitoFormativo.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAmbitoFormativoPk: ");
		ret.append("idAmbitoFormativo=" + idAmbitoFormativo);

		return ret.toString();
	}
}
