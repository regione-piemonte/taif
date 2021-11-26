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
 * Primary Key del DTO TaifDAssortimentoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDAssortimentoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ASSORTIMENTO
	 * @generated
	 */
	protected Integer idAssortimento;

	/**
	 * Imposta il valore della proprieta' idAssortimento associata alla
	 * colonna ID_ASSORTIMENTO.
	 * @generated
	 */
	public void setIdAssortimento(Integer val) {

		idAssortimento = val;

	}

	/**
	 * Legge il valore della proprieta' idAssortimento associata alla
	 * @generated
	 */
	public Integer getIdAssortimento() {

		return idAssortimento;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDAssortimentoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDAssortimentoPk(

			final Integer idAssortimento

	) {

		this.setIdAssortimento(idAssortimento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDAssortimentoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDAssortimentoPk)) {
			return false;
		}

		final TaifDAssortimentoPk _cast = (TaifDAssortimentoPk) _other;

		if (idAssortimento == null
				? _cast.getIdAssortimento() != null
				: !idAssortimento.equals(_cast.getIdAssortimento())) {
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

		if (idAssortimento != null) {
			_hashCode = 29 * _hashCode + idAssortimento.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAssortimentoPk: ");
		ret.append("idAssortimento=" + idAssortimento);

		return ret.toString();
	}
}
