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
 * Primary Key del DTO TaifDTipoInquadramentoDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoInquadramentoPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_INQUADRAMENTO
	 * @generated
	 */
	protected Integer idTipoInquadramento;

	/**
	 * Imposta il valore della proprieta' idTipoInquadramento associata alla
	 * colonna ID_TIPO_INQUADRAMENTO.
	 * @generated
	 */
	public void setIdTipoInquadramento(Integer val) {

		idTipoInquadramento = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoInquadramento associata alla
	 * @generated
	 */
	public Integer getIdTipoInquadramento() {

		return idTipoInquadramento;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoInquadramentoPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoInquadramentoPk(

			final Integer idTipoInquadramento

	) {

		this.setIdTipoInquadramento(idTipoInquadramento);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoInquadramentoPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoInquadramentoPk)) {
			return false;
		}

		final TaifDTipoInquadramentoPk _cast = (TaifDTipoInquadramentoPk) _other;

		if (idTipoInquadramento == null
				? _cast.getIdTipoInquadramento() != null
				: !idTipoInquadramento.equals(_cast.getIdTipoInquadramento())) {
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

		if (idTipoInquadramento != null) {
			_hashCode = 29 * _hashCode + idTipoInquadramento.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoInquadramentoPk: ");
		ret.append("idTipoInquadramento=" + idTipoInquadramento);

		return ret.toString();
	}
}
