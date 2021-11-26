/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO taifDNazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDNazioneDao {

	/**
	 * Metodo di inserimento del DAO taifDNazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDNazionePk
	 * @generated
	 */

	public TaifDNazionePk insert(TaifDNazioneDto dto)

	;

	/** 
	 * Returns all rows from the TAIF_D_NAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDNazioneDto findByPrimaryKey(TaifDNazionePk pk) throws TaifDNazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_NAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDNazioneDto> findAll() throws TaifDNazioneDaoException;

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDNazioneDaoException;

	/** 
		 * Implementazione del finder byNazioneItaVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByNazioneItaVisibleDto> findByNazioneItaVisible(java.lang.Integer input)
			throws TaifDNazioneDaoException;

	/** 
		 * Implementazione del finder byNazioneFraVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByNazioneFraVisibleDto> findByNazioneFraVisible(java.lang.Integer input)
			throws TaifDNazioneDaoException;

}
