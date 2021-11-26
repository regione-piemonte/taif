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
 * Primary Key del DTO TaifDTipoMezzoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoMezzoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_MEZZO
	 * @generated
	 */
	protected Integer idTipoMezzo;

	/**
	 * Imposta il valore della proprieta' idTipoMezzo associata alla
	 * colonna ID_TIPO_MEZZO.
	 * @generated
	 */
	public void setIdTipoMezzo(Integer val) {

		idTipoMezzo = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoMezzo associata alla
	 * @generated
	 */
	public Integer getIdTipoMezzo() {

		return idTipoMezzo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoMezzoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoMezzoPk(

			final Integer idTipoMezzo

	) {

		this.setIdTipoMezzo(idTipoMezzo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoMezzoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoMezzoPk)) {
			return false;
		}

		final TaifDTipoMezzoPk _cast = (TaifDTipoMezzoPk) _other;

		if (idTipoMezzo == null ? _cast.getIdTipoMezzo() != null : !idTipoMezzo.equals(_cast.getIdTipoMezzo())) {
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

		if (idTipoMezzo != null) {
			_hashCode = 29 * _hashCode + idTipoMezzo.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoMezzoPk: ");
		ret.append("idTipoMezzo=" + idTipoMezzo);

		return ret.toString();
	}
}
