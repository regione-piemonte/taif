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
 * Primary Key del DTO TaifDFormaGiuridicaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDFormaGiuridicaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_FORMA_GIURIDICA
	 * @generated
	 */
	protected Integer idFormaGiuridica;

	/**
	 * Imposta il valore della proprieta' idFormaGiuridica associata alla
	 * colonna ID_FORMA_GIURIDICA.
	 * @generated
	 */
	public void setIdFormaGiuridica(Integer val) {

		idFormaGiuridica = val;

	}

	/**
	 * Legge il valore della proprieta' idFormaGiuridica associata alla
	 * @generated
	 */
	public Integer getIdFormaGiuridica() {

		return idFormaGiuridica;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDFormaGiuridicaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDFormaGiuridicaPk(

			final Integer idFormaGiuridica

	) {

		this.setIdFormaGiuridica(idFormaGiuridica);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDFormaGiuridicaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDFormaGiuridicaPk)) {
			return false;
		}

		final TaifDFormaGiuridicaPk _cast = (TaifDFormaGiuridicaPk) _other;

		if (idFormaGiuridica == null
				? _cast.getIdFormaGiuridica() != null
				: !idFormaGiuridica.equals(_cast.getIdFormaGiuridica())) {
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

		if (idFormaGiuridica != null) {
			_hashCode = 29 * _hashCode + idFormaGiuridica.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDFormaGiuridicaPk: ");
		ret.append("idFormaGiuridica=" + idFormaGiuridica);

		return ret.toString();
	}
}
