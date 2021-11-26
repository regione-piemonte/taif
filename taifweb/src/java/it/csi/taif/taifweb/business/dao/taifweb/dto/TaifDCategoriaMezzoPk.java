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
 * Primary Key del DTO TaifDCategoriaMezzoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDCategoriaMezzoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CATEGORIA_MEZZO
	 * @generated
	 */
	protected Integer idCategoriaMezzo;

	/**
	 * Imposta il valore della proprieta' idCategoriaMezzo associata alla
	 * colonna ID_CATEGORIA_MEZZO.
	 * @generated
	 */
	public void setIdCategoriaMezzo(Integer val) {

		idCategoriaMezzo = val;

	}

	/**
	 * Legge il valore della proprieta' idCategoriaMezzo associata alla
	 * @generated
	 */
	public Integer getIdCategoriaMezzo() {

		return idCategoriaMezzo;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDCategoriaMezzoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDCategoriaMezzoPk(

			final Integer idCategoriaMezzo

	) {

		this.setIdCategoriaMezzo(idCategoriaMezzo);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDCategoriaMezzoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDCategoriaMezzoPk)) {
			return false;
		}

		final TaifDCategoriaMezzoPk _cast = (TaifDCategoriaMezzoPk) _other;

		if (idCategoriaMezzo == null
				? _cast.getIdCategoriaMezzo() != null
				: !idCategoriaMezzo.equals(_cast.getIdCategoriaMezzo())) {
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

		if (idCategoriaMezzo != null) {
			_hashCode = 29 * _hashCode + idCategoriaMezzo.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDCategoriaMezzoPk: ");
		ret.append("idCategoriaMezzo=" + idCategoriaMezzo);

		return ret.toString();
	}
}
