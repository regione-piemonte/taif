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
 * Primary Key del DTO TaifTAllegatoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTAllegatoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ALLEGATO
	 * @generated
	 */
	protected Integer idAllegato;

	/**
	 * Imposta il valore della proprieta' idAllegato associata alla
	 * colonna ID_ALLEGATO.
	 * @generated
	 */
	public void setIdAllegato(Integer val) {

		idAllegato = val;

	}

	/**
	 * Legge il valore della proprieta' idAllegato associata alla
	 * @generated
	 */
	public Integer getIdAllegato() {

		return idAllegato;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTAllegatoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTAllegatoPk(

			final Integer idAllegato

	) {

		this.setIdAllegato(idAllegato);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTAllegatoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTAllegatoPk)) {
			return false;
		}

		final TaifTAllegatoPk _cast = (TaifTAllegatoPk) _other;

		if (idAllegato == null ? _cast.getIdAllegato() != null : !idAllegato.equals(_cast.getIdAllegato())) {
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

		if (idAllegato != null) {
			_hashCode = 29 * _hashCode + idAllegato.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifTAllegatoPk: ");
		ret.append("idAllegato=" + idAllegato);

		return ret.toString();
	}
}
