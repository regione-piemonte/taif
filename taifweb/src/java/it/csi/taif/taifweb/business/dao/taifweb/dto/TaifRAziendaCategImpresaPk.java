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
 * Primary Key del DTO TaifRAziendaCategImpresaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifRAziendaCategImpresaPk implements Serializable {

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
	public TaifRAziendaCategImpresaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifRAziendaCategImpresaPk(

			final Integer idAzienda, final Integer idCategoria

	) {

		this.setIdAzienda(idAzienda);

		this.setIdCategoria(idCategoria);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifRAziendaCategImpresaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifRAziendaCategImpresaPk)) {
			return false;
		}

		final TaifRAziendaCategImpresaPk _cast = (TaifRAziendaCategImpresaPk) _other;

		if (idAzienda == null ? _cast.getIdAzienda() != null : !idAzienda.equals(_cast.getIdAzienda())) {
			return false;
		}

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

		if (idAzienda != null) {
			_hashCode = 29 * _hashCode + idAzienda.hashCode();
		}

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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaPk: ");
		ret.append("idAzienda=" + idAzienda);

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaCategImpresaPk: ");
		ret.append("idCategoria=" + idCategoria);

		return ret.toString();
	}
}
