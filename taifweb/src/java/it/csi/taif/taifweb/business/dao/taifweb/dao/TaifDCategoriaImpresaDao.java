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
 * Interfaccia pubblica del DAO taifDCategoriaImpresa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDCategoriaImpresaDao {

	/**
	 * Metodo di inserimento del DAO taifDCategoriaImpresa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDCategoriaImpresaPk
	 * @generated
	 */

	public TaifDCategoriaImpresaPk insert(TaifDCategoriaImpresaDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_CATEGORIA_IMPRESA table.
	 * @generated
	 */

	public void delete(TaifDCategoriaImpresaPk pk) throws TaifDCategoriaImpresaDaoException;

	/** 
	 * Returns all rows from the TAIF_D_CATEGORIA_IMPRESA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDCategoriaImpresaDto findByPrimaryKey(TaifDCategoriaImpresaPk pk)
			throws TaifDCategoriaImpresaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_CATEGORIA_IMPRESA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDCategoriaImpresaDto> findAll() throws TaifDCategoriaImpresaDaoException;

	/** 
		 * Implementazione del finder categoriaImpresaVisible con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaImpresaCategoriaImpresaVisibleDto> findCategoriaImpresaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDCategoriaImpresaDaoException;

}
