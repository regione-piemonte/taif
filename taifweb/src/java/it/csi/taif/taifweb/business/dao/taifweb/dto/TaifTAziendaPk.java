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
 * Primary Key del DTO TaifTAziendaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifTAziendaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_AZIENDA
	 * @generated
	 */
	protected Integer idAzienda;

	/**
	 * Imposta il valore della proprieta' idAzienda associata alla
	 * colonna ID_AZIENDA.
	 * @generated
	 */
	public void setIdAzienda(Integer val) {

		idAzienda = val;

	}

	/**
	 * Legge il valore della proprieta' idAzienda associata alla
	 * @generated
	 */
	public Integer getIdAzienda() {

		return idAzienda;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifTAziendaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifTAziendaPk(

			final Integer idAzienda

	) {

		this.setIdAzienda(idAzienda);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifTAziendaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifTAziendaPk)) {
			return false;
		}

		final TaifTAziendaPk _cast = (TaifTAziendaPk) _other;

		if (idAzienda == null ? _cast.getIdAzienda() != null : !idAzienda.equals(_cast.getIdAzienda())) {
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

		if (idAzienda != null) {
			_hashCode = 29 * _hashCode + idAzienda.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAziendaPk: ");
		ret.append("idAzienda=" + idAzienda);

		return ret.toString();
	}
}
