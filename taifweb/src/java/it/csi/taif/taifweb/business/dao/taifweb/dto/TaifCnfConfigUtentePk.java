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
 * Primary Key del DTO TaifCnfConfigUtenteDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifCnfConfigUtentePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CONFIG_UTENTE
	 * @generated
	 */
	protected Integer idConfigUtente;

	/**
	 * Imposta il valore della proprieta' idConfigUtente associata alla
	 * colonna ID_CONFIG_UTENTE.
	 * @generated
	 */
	public void setIdConfigUtente(Integer val) {

		idConfigUtente = val;

	}

	/**
	 * Legge il valore della proprieta' idConfigUtente associata alla
	 * @generated
	 */
	public Integer getIdConfigUtente() {

		return idConfigUtente;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifCnfConfigUtentePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifCnfConfigUtentePk(

			final Integer idConfigUtente

	) {

		this.setIdConfigUtente(idConfigUtente);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifCnfConfigUtentePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifCnfConfigUtentePk)) {
			return false;
		}

		final TaifCnfConfigUtentePk _cast = (TaifCnfConfigUtentePk) _other;

		if (idConfigUtente == null
				? _cast.getIdConfigUtente() != null
				: !idConfigUtente.equals(_cast.getIdConfigUtente())) {
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

		if (idConfigUtente != null) {
			_hashCode = 29 * _hashCode + idConfigUtente.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfConfigUtentePk: ");
		ret.append("idConfigUtente=" + idConfigUtente);

		return ret.toString();
	}
}
