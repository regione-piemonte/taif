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
 * Primary Key del DTO TaifCnfProfiloUtenteDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifCnfProfiloUtentePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_PROFILO_UTENTE
	 * @generated
	 */
	protected Integer idProfiloUtente;

	/**
	 * Imposta il valore della proprieta' idProfiloUtente associata alla
	 * colonna ID_PROFILO_UTENTE.
	 * @generated
	 */
	public void setIdProfiloUtente(Integer val) {

		idProfiloUtente = val;

	}

	/**
	 * Legge il valore della proprieta' idProfiloUtente associata alla
	 * @generated
	 */
	public Integer getIdProfiloUtente() {

		return idProfiloUtente;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifCnfProfiloUtentePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifCnfProfiloUtentePk(

			final Integer idProfiloUtente

	) {

		this.setIdProfiloUtente(idProfiloUtente);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifCnfProfiloUtentePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifCnfProfiloUtentePk)) {
			return false;
		}

		final TaifCnfProfiloUtentePk _cast = (TaifCnfProfiloUtentePk) _other;

		if (idProfiloUtente == null
				? _cast.getIdProfiloUtente() != null
				: !idProfiloUtente.equals(_cast.getIdProfiloUtente())) {
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

		if (idProfiloUtente != null) {
			_hashCode = 29 * _hashCode + idProfiloUtente.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfProfiloUtentePk: ");
		ret.append("idProfiloUtente=" + idProfiloUtente);

		return ret.toString();
	}
}
