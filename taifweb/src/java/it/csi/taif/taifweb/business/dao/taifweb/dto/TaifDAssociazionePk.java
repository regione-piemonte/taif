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
 * Primary Key del DTO TaifDAssociazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifDAssociazionePk implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * store della proprieta' associata alla colonna ID_ASSOCIAZIONE
	 * @generated
	 */
	protected Integer idAssociazione;

	/**
	 * Imposta il valore della proprieta' idAssociazione associata alla
	 * colonna ID_ASSOCIAZIONE.
	 * @generated
	 */
	public void setIdAssociazione(Integer val) {

		idAssociazione = val;

	}

	/**
	 * Legge il valore della proprieta' idAssociazione associata alla
	 * @generated
	 */
	public Integer getIdAssociazione() {

		return idAssociazione;

	}

	/**
	 * Costruttore di una chiave primaria vuota
	 * @generated 
	 */
	public TaifDAssociazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifDAssociazionePk(

			final Integer idAssociazione

	) {

		this.setIdAssociazione(idAssociazione);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifDAssociazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifDAssociazionePk)) {
			return false;
		}

		final TaifDAssociazionePk _cast = (TaifDAssociazionePk) _other;

		if (idAssociazione == null
				? _cast.getIdAssociazione() != null
				: !idAssociazione.equals(_cast.getIdAssociazione())) {
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

		if (idAssociazione != null) {
			_hashCode = 29 * _hashCode + idAssociazione.hashCode();
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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDAssociazionePk: ");
		ret.append("idAssociazione=" + idAssociazione);

		return ret.toString();
	}
}
