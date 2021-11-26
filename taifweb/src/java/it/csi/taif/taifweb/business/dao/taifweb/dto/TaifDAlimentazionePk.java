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
 * Primary Key del DTO TaifDAlimentazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDAlimentazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ALIMENTAZIONE
	 * @generated
	 */
	protected Integer idAlimentazione;

	/**
	 * Imposta il valore della proprieta' idAlimentazione associata alla
	 * colonna ID_ALIMENTAZIONE.
	 * @generated
	 */
	public void setIdAlimentazione(Integer val) {

		idAlimentazione = val;

	}

	/**
	 * Legge il valore della proprieta' idAlimentazione associata alla
	 * @generated
	 */
	public Integer getIdAlimentazione() {

		return idAlimentazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDAlimentazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDAlimentazionePk(

			final Integer idAlimentazione

	) {

		this.setIdAlimentazione(idAlimentazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDAlimentazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDAlimentazionePk)) {
			return false;
		}

		final TaifDAlimentazionePk _cast = (TaifDAlimentazionePk) _other;

		if (idAlimentazione == null
				? _cast.getIdAlimentazione() != null
				: !idAlimentazione.equals(_cast.getIdAlimentazione())) {
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

		if (idAlimentazione != null) {
			_hashCode = 29 * _hashCode + idAlimentazione.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAlimentazionePk: ");
		ret.append("idAlimentazione=" + idAlimentazione);

		return ret.toString();
	}
}
