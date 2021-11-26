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
 * Interfaccia pubblica del DAO taifTSoggettoGestore.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTSoggettoGestoreDao {

	/**
	 * Metodo di inserimento del DAO taifTSoggettoGestore. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTSoggettoGestorePk
	 * @generated
	 */

	public TaifTSoggettoGestorePk insert(TaifTSoggettoGestoreDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_T_SOGGETTO_GESTORE table.
	 * @generated
	 */
	public void updateColumnsByIdUtente(TaifTSoggettoGestoreDto dto) throws TaifTSoggettoGestoreDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_SOGGETTO_GESTORE table.
	 * @generated
	 */

	public void delete(TaifTSoggettoGestorePk pk) throws TaifTSoggettoGestoreDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_SOGGETTO_GESTORE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTSoggettoGestoreDto> findAll() throws TaifTSoggettoGestoreDaoException;

	/** 
	 * Returns all rows from the TAIF_T_SOGGETTO_GESTORE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTSoggettoGestoreDto findByPrimaryKey(TaifTSoggettoGestorePk pk) throws TaifTSoggettoGestoreDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTSoggettoGestoreByFilterDto> findByFilter(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreFilter input)
			throws TaifTSoggettoGestoreDaoException;

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifTSoggettoGestoreByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifTSoggettoGestoreDaoException;

}
