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
 * Primary Key del DTO TaifDTipoQualificaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoQualificaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_QUALIFICA
	 * @generated
	 */
	protected Integer idTipoQualifica;

	/**
	 * Imposta il valore della proprieta' idTipoQualifica associata alla
	 * colonna ID_TIPO_QUALIFICA.
	 * @generated
	 */
	public void setIdTipoQualifica(Integer val) {

		idTipoQualifica = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoQualifica associata alla
	 * @generated
	 */
	public Integer getIdTipoQualifica() {

		return idTipoQualifica;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoQualificaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoQualificaPk(

			final Integer idTipoQualifica

	) {

		this.setIdTipoQualifica(idTipoQualifica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoQualificaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoQualificaPk)) {
			return false;
		}

		final TaifDTipoQualificaPk _cast = (TaifDTipoQualificaPk) _other;

		if (idTipoQualifica == null
				? _cast.getIdTipoQualifica() != null
				: !idTipoQualifica.equals(_cast.getIdTipoQualifica())) {
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

		if (idTipoQualifica != null) {
			_hashCode = 29 * _hashCode + idTipoQualifica.hashCode();
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

		ret.append("it.csi.taif.topforweb.business.dao.topfor.dto.TaifDTipoQualificaPk: ");
		ret.append("idTipoQualifica=" + idTipoQualifica);

		return ret.toString();
	}
}
