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
 * Primary Key del DTO TaifDTipoAttivitaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoAttivitaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_ATTIVITA
	 * @generated
	 */
	protected Integer idTipoAttivita;

	/**
	 * Imposta il valore della proprieta' idTipoAttivita associata alla
	 * colonna ID_TIPO_ATTIVITA.
	 * @generated
	 */
	public void setIdTipoAttivita(Integer val) {

		idTipoAttivita = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoAttivita associata alla
	 * @generated
	 */
	public Integer getIdTipoAttivita() {

		return idTipoAttivita;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoAttivitaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoAttivitaPk(

			final Integer idTipoAttivita

	) {

		this.setIdTipoAttivita(idTipoAttivita);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoAttivitaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoAttivitaPk)) {
			return false;
		}

		final TaifDTipoAttivitaPk _cast = (TaifDTipoAttivitaPk) _other;

		if (idTipoAttivita == null
				? _cast.getIdTipoAttivita() != null
				: !idTipoAttivita.equals(_cast.getIdTipoAttivita())) {
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

		if (idTipoAttivita != null) {
			_hashCode = 29 * _hashCode + idTipoAttivita.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoAttivitaPk: ");
		ret.append("idTipoAttivita=" + idTipoAttivita);

		return ret.toString();
	}
}
