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
 * Interfaccia pubblica del DAO taifRAziendaCategImpresa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifRAziendaCategImpresaDao {

	/**
	 * Metodo di inserimento del DAO taifRAziendaCategImpresa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAziendaCategImpresaPk
	 * @generated
	 */

	public TaifRAziendaCategImpresaPk insert(TaifRAziendaCategImpresaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_R_AZIENDA_CATEGIMPRESA table.
	 * @generated
	 */
	public void update(TaifRAziendaCategImpresaDto dto) throws TaifRAziendaCategImpresaDaoException;

	/** 
	 * Updates selected columns in the TAIF_R_AZIENDA_CATEGIMPRESA table.
	 * @generated
	 */
	public void updateColumnsAziendaCategoriaImpresa(TaifRAziendaCategImpresaDto dto)
			throws TaifRAziendaCategImpresaDaoException;

	/** 
	 * Deletes a single row in the TAIF_R_AZIENDA_CATEGIMPRESA table.
	 * @generated
	 */

	public void delete(TaifRAziendaCategImpresaPk pk) throws TaifRAziendaCategImpresaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_AZIENDA_CATEGIMPRESA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAziendaCategImpresaDto> findAll() throws TaifRAziendaCategImpresaDaoException;

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaCategImpresaDaoException;

	/** 
		 * Implementazione del finder byIdCategImpresa con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaByIdCategImpresaDto> findByIdCategImpresa(java.lang.Integer input)
			throws TaifRAziendaCategImpresaDaoException;

	/** 
		 * Implementazione del finder byIdAziendaIdCategoria con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto> findByIdAziendaIdCategoria(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaImpresaFilter input)
			throws TaifRAziendaCategImpresaDaoException;

	/** 
		 * Implementazione del finder findCategoriaImpresaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto> findFindCategoriaImpresaByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifRAziendaCategImpresaDaoException;

	/** 
		 * Implementazione del finder findDettaglioCategoriaImpresaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto> findFindDettaglioCategoriaImpresaByIdAzienda(
			java.lang.Integer input) throws TaifRAziendaCategImpresaDaoException;

	/** 
	 * Returns all rows from the TAIF_R_AZIENDA_CATEGIMPRESA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAziendaCategImpresaDto findByPrimaryKey(TaifRAziendaCategImpresaPk pk)
			throws TaifRAziendaCategImpresaDaoException;

}
