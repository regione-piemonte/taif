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
 * Primary Key del DTO TaifDTipoLavoroPaDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDTipoLavoroPaPk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_TIPO_LAVORO_PA
	 * @generated
	 */
	protected Integer idTipoLavoroPa;

	/**
	 * Imposta il valore della proprieta' idTipoLavoroPa associata alla
	 * colonna ID_TIPO_LAVORO_PA.
	 * @generated
	 */
	public void setIdTipoLavoroPa(Integer val) {

		idTipoLavoroPa = val;

	}

	/**
	 * Legge il valore della proprieta' idTipoLavoroPa associata alla
	 * @generated
	 */
	public Integer getIdTipoLavoroPa() {

		return idTipoLavoroPa;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDTipoLavoroPaPk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDTipoLavoroPaPk(

			final Integer idTipoLavoroPa

	) {

		this.setIdTipoLavoroPa(idTipoLavoroPa);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDTipoLavoroPaPk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDTipoLavoroPaPk)) {
			return false;
		}

		final TaifDTipoLavoroPaPk _cast = (TaifDTipoLavoroPaPk) _other;

		if (idTipoLavoroPa == null
				? _cast.getIdTipoLavoroPa() != null
				: !idTipoLavoroPa.equals(_cast.getIdTipoLavoroPa())) {
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

		if (idTipoLavoroPa != null) {
			_hashCode = 29 * _hashCode + idTipoLavoroPa.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDTipoLavoroPaPk: ");
		ret.append("idTipoLavoroPa=" + idTipoLavoroPa);

		return ret.toString();
	}
}
