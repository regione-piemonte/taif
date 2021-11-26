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
 * Primary Key del DTO TaifDMaterialeDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDMaterialePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_MATERIALE
	 * @generated
	 */
	protected Integer idMateriale;

	/**
	 * Imposta il valore della proprieta' idMateriale associata alla
	 * colonna ID_MATERIALE.
	 * @generated
	 */
	public void setIdMateriale(Integer val) {

		idMateriale = val;

	}

	/**
	 * Legge il valore della proprieta' idMateriale associata alla
	 * @generated
	 */
	public Integer getIdMateriale() {

		return idMateriale;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDMaterialePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDMaterialePk(

			final Integer idMateriale

	) {

		this.setIdMateriale(idMateriale);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDMaterialePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDMaterialePk)) {
			return false;
		}

		final TaifDMaterialePk _cast = (TaifDMaterialePk) _other;

		if (idMateriale == null ? _cast.getIdMateriale() != null : !idMateriale.equals(_cast.getIdMateriale())) {
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

		if (idMateriale != null) {
			_hashCode = 29 * _hashCode + idMateriale.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDMaterialePk: ");
		ret.append("idMateriale=" + idMateriale);

		return ret.toString();
	}
}
