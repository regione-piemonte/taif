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
 * Primary Key del DTO TaifRAziendaAssociazioneDto.
 * E' utilizzato per tutte le operazioni di lettura dati per chiave primaria. 
 * @generated
 */
public class TaifRAziendaAssociazionePk implements Serializable {

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
	public TaifRAziendaAssociazionePk() {
		//empty constructor
	}

	/**
	 * Costruttore di una chiave primaria a partire dai valori delle varie colonne
	 * @generated
	 */
	public TaifRAziendaAssociazionePk(

			final Integer idAssociazione, final Integer idAzienda

	) {

		this.setIdAssociazione(idAssociazione);

		this.setIdAzienda(idAzienda);

	}

	/**
	 * Method 'equals'. 
	 * Due istanze di TaifRAziendaAssociazionePk sono equals se i valori di tutti i campi coincidono.
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

		if (!(_other instanceof TaifRAziendaAssociazionePk)) {
			return false;
		}

		final TaifRAziendaAssociazionePk _cast = (TaifRAziendaAssociazionePk) _other;

		if (idAssociazione == null
				? _cast.getIdAssociazione() != null
				: !idAssociazione.equals(_cast.getIdAssociazione())) {
			return false;
		}

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

		if (idAssociazione != null) {
			_hashCode = 29 * _hashCode + idAssociazione.hashCode();
		}

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

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaAssociazionePk: ");
		ret.append("idAssociazione=" + idAssociazione);

		ret.append("it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRAziendaAssociazionePk: ");
		ret.append("idAzienda=" + idAzienda);

		return ret.toString();
	}
}
