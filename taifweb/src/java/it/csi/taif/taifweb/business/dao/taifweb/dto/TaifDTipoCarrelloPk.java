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
 * Primary Key del DTO TaifDTipoCarrelloDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoCarrelloPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_CARRELLO
	 * @generated
	 */
	protected Integer idTipoCarrello;

	/**
	 * Imposta il valore della proprieta' idTipoCarrello associata alla
	 * colonna ID_TIPO_CARRELLO.
	 * @generated
	 */
	public void setIdTipoCarrello(Integer val) {

		idTipoCarrello = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoCarrello associata alla
	 * @generated
	 */
	public Integer getIdTipoCarrello() {

		return idTipoCarrello;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoCarrelloPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoCarrelloPk(

			final Integer idTipoCarrello

	) {

		this.setIdTipoCarrello(idTipoCarrello);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoCarrelloPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoCarrelloPk)) {
			return false;
		}

		final TaifDTipoCarrelloPk _cast = (TaifDTipoCarrelloPk) _other;

		if (idTipoCarrello == null
				? _cast.getIdTipoCarrello() != null
				: !idTipoCarrello.equals(_cast.getIdTipoCarrello())) {
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

		if (idTipoCarrello != null) {
			_hashCode = 29 * _hashCode + idTipoCarrello.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoCarrelloPk: ");
		ret.append("idTipoCarrello=" + idTipoCarrello);

		return ret.toString();
	}
}
