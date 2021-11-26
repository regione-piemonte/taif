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
 * Primary Key del DTO TaifTLavoroPaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTLavoroPaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_LAVORO_PA
	 * @generated
	 */
	protected Integer idLavoroPa;

	/**
	 * Imposta il valore della proprieta' idLavoroPa associata alla
	 * colonna ID_LAVORO_PA.
	 * @generated
	 */
	public void setIdLavoroPa(Integer val) {

		idLavoroPa = val;

	}

	/**
	 * Legge il valore della proprieta' idLavoroPa associata alla
	 * @generated
	 */
	public Integer getIdLavoroPa() {

		return idLavoroPa;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTLavoroPaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTLavoroPaPk(

			final Integer idLavoroPa

	) {

		this.setIdLavoroPa(idLavoroPa);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTLavoroPaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTLavoroPaPk)) {
			return false;
		}

		final TaifTLavoroPaPk _cast = (TaifTLavoroPaPk) _other;

		if (idLavoroPa == null ? _cast.getIdLavoroPa() != null : !idLavoroPa.equals(_cast.getIdLavoroPa())) {
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

		if (idLavoroPa != null) {
			_hashCode = 29 * _hashCode + idLavoroPa.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTLavoroPaPk: ");
		ret.append("idLavoroPa=" + idLavoroPa);

		return ret.toString();
	}
}
