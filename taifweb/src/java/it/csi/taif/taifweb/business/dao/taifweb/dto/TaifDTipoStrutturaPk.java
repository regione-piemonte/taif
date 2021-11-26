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
 * Primary Key del DTO TaifDTipoStrutturaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoStrutturaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_STRUTTURA
	 * @generated
	 */
	protected Integer idTipoStruttura;

	/**
	 * Imposta il valore della proprieta' idTipoStruttura associata alla
	 * colonna ID_TIPO_STRUTTURA.
	 * @generated
	 */
	public void setIdTipoStruttura(Integer val) {

		idTipoStruttura = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoStruttura associata alla
	 * @generated
	 */
	public Integer getIdTipoStruttura() {

		return idTipoStruttura;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoStrutturaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoStrutturaPk(

			final Integer idTipoStruttura

	) {

		this.setIdTipoStruttura(idTipoStruttura);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoStrutturaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoStrutturaPk)) {
			return false;
		}

		final TaifDTipoStrutturaPk _cast = (TaifDTipoStrutturaPk) _other;

		if (idTipoStruttura == null
				? _cast.getIdTipoStruttura() != null
				: !idTipoStruttura.equals(_cast.getIdTipoStruttura())) {
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

		if (idTipoStruttura != null) {
			_hashCode = 29 * _hashCode + idTipoStruttura.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoStrutturaPk: ");
		ret.append("idTipoStruttura=" + idTipoStruttura);

		return ret.toString();
	}
}
