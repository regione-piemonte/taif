/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dao;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.taifweb.qbe.*;
import it.csi.taif.taifweb.business.dao.taifweb.metadata.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import it.csi.taif.taifweb.business.dao.util.*;
import it.csi.taif.taifweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO taifDTipoMansione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoMansioneDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoMansione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoMansionePk
	 * @generated
	 */

	public TaifDTipoMansionePk insert(TaifDTipoMansioneDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TIPO_MANSIONE table.
	 * @generated
	 */
	public void update(TaifDTipoMansioneDto dto) throws TaifDTipoMansioneDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_MANSIONE table.
	 * @generated
	 */

	public void delete(TaifDTipoMansionePk pk) throws TaifDTipoMansioneDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_MANSIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoMansioneDto findByPrimaryKey(TaifDTipoMansionePk pk) throws TaifDTipoMansioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_MANSIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoMansioneDto> findAll() throws TaifDTipoMansioneDaoException;

	/** 
		 * Implementazione del finder byVisibleOrdin con Qdef
		 * @generated
		 */

	public List<TaifDTipoMansioneByVisibleOrdinDto> findByVisibleOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoMansioneDaoException;

	/** 
		 * Implementazione del finder byTipoMansione con Qdef
		 * @generated
		 */

	public List<TaifDTipoMansioneByTipoMansioneDto> findByTipoMansione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.MansioneFilter input) throws TaifDTipoMansioneDaoException;

	/** 
		 * Implementazione del finder byIdTipoMansione con Qdef
		 * @generated
		 */

	public List<TaifDTipoMansioneByIdTipoMansioneDto> findByIdTipoMansione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.MansioneFilter input) throws TaifDTipoMansioneDaoException;

}
