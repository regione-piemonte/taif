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
 * Primary Key del DTO TaifDTipoMansioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoMansionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_MANSIONE
	 * @generated
	 */
	protected Integer idTipoMansione;

	/**
	 * Imposta il valore della proprieta' idTipoMansione associata alla
	 * colonna ID_TIPO_MANSIONE.
	 * @generated
	 */
	public void setIdTipoMansione(Integer val) {

		idTipoMansione = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoMansione associata alla
	 * @generated
	 */
	public Integer getIdTipoMansione() {

		return idTipoMansione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoMansionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoMansionePk(

			final Integer idTipoMansione

	) {

		this.setIdTipoMansione(idTipoMansione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoMansionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoMansionePk)) {
			return false;
		}

		final TaifDTipoMansionePk _cast = (TaifDTipoMansionePk) _other;

		if (idTipoMansione == null
				? _cast.getIdTipoMansione() != null
				: !idTipoMansione.equals(_cast.getIdTipoMansione())) {
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

		if (idTipoMansione != null) {
			_hashCode = 29 * _hashCode + idTipoMansione.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoMansionePk: ");
		ret.append("idTipoMansione=" + idTipoMansione);

		return ret.toString();
	}
}
