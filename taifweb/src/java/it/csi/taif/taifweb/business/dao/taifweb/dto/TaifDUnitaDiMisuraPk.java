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
 * Primary Key del DTO TaifDUnitaDiMisuraDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDUnitaDiMisuraPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_UNITA_DI_MISURA
	 * @generated
	 */
	protected Integer idUnitaDiMisura;

	/**
	 * Imposta il valore della proprieta' idUnitaDiMisura associata alla
	 * colonna ID_UNITA_DI_MISURA.
	 * @generated
	 */
	public void setIdUnitaDiMisura(Integer val) {

		idUnitaDiMisura = val;

	}

	/**
	 * Legge il valore della proprieta' idUnitaDiMisura associata alla
	 * @generated
	 */
	public Integer getIdUnitaDiMisura() {

		return idUnitaDiMisura;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDUnitaDiMisuraPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDUnitaDiMisuraPk(

			final Integer idUnitaDiMisura

	) {

		this.setIdUnitaDiMisura(idUnitaDiMisura);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDUnitaDiMisuraPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDUnitaDiMisuraPk)) {
			return false;
		}

		final TaifDUnitaDiMisuraPk _cast = (TaifDUnitaDiMisuraPk) _other;

		if (idUnitaDiMisura == null
				? _cast.getIdUnitaDiMisura() != null
				: !idUnitaDiMisura.equals(_cast.getIdUnitaDiMisura())) {
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

		if (idUnitaDiMisura != null) {
			_hashCode = 29 * _hashCode + idUnitaDiMisura.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDUnitaDiMisuraPk: ");
		ret.append("idUnitaDiMisura=" + idUnitaDiMisura);

		return ret.toString();
	}
}
