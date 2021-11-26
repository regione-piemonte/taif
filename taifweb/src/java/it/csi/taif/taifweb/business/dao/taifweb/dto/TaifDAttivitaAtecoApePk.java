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
 * Primary Key del DTO TaifDAttivitaAtecoApeDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDAttivitaAtecoApePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ATTIVITA
	 * @generated
	 */
	protected Integer idAttivita;

	/**
	 * Imposta il valore della proprieta' idAttivita associata alla
	 * colonna ID_ATTIVITA.
	 * @generated
	 */
	public void setIdAttivita(Integer val) {

		idAttivita = val;

	}

	/**
	 * Legge il valore della proprieta' idAttivita associata alla
	 * @generated
	 */
	public Integer getIdAttivita() {

		return idAttivita;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDAttivitaAtecoApePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDAttivitaAtecoApePk(

			final Integer idAttivita

	) {

		this.setIdAttivita(idAttivita);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDAttivitaAtecoApePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDAttivitaAtecoApePk)) {
			return false;
		}

		final TaifDAttivitaAtecoApePk _cast = (TaifDAttivitaAtecoApePk) _other;

		if (idAttivita == null ? _cast.getIdAttivita() != null : !idAttivita.equals(_cast.getIdAttivita())) {
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

		if (idAttivita != null) {
			_hashCode = 29 * _hashCode + idAttivita.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAttivitaAtecoApePk: ");
		ret.append("idAttivita=" + idAttivita);

		return ret.toString();
	}
}
