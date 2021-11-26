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
 * Primary Key del DTO TaifDCategoriaImpresaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDCategoriaImpresaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_CATEGORIA
	 * @generated
	 */
	protected Integer idCategoria;

	/**
	 * Imposta il valore della proprieta' idCategoria associata alla
	 * colonna ID_CATEGORIA.
	 * @generated
	 */
	public void setIdCategoria(Integer val) {

		idCategoria = val;

	}

	/**
	 * Legge il valore della proprieta' idCategoria associata alla
	 * @generated
	 */
	public Integer getIdCategoria() {

		return idCategoria;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDCategoriaImpresaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDCategoriaImpresaPk(

			final Integer idCategoria

	) {

		this.setIdCategoria(idCategoria);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDCategoriaImpresaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDCategoriaImpresaPk)) {
			return false;
		}

		final TaifDCategoriaImpresaPk _cast = (TaifDCategoriaImpresaPk) _other;

		if (idCategoria == null ? _cast.getIdCategoria() != null : !idCategoria.equals(_cast.getIdCategoria())) {
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

		if (idCategoria != null) {
			_hashCode = 29 * _hashCode + idCategoria.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDCategoriaImpresaPk: ");
		ret.append("idCategoria=" + idCategoria);

		return ret.toString();
	}
}
