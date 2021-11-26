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
 * Interfaccia pubblica del DAO taifDCategoriaMezzo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDCategoriaMezzoDao {

	/**
	 * Metodo di inserimento del DAO taifDCategoriaMezzo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDCategoriaMezzoPk
	 * @generated
	 */

	public TaifDCategoriaMezzoPk insert(TaifDCategoriaMezzoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_CATEGORIA_MEZZO table.
	 * @generated
	 */
	public void update(TaifDCategoriaMezzoDto dto) throws TaifDCategoriaMezzoDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_CATEGORIA_MEZZO table.
	 * @generated
	 */

	public void delete(TaifDCategoriaMezzoPk pk) throws TaifDCategoriaMezzoDaoException;

	/** 
	 * Returns all rows from the TAIF_D_CATEGORIA_MEZZO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDCategoriaMezzoDto findByPrimaryKey(TaifDCategoriaMezzoPk pk) throws TaifDCategoriaMezzoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_CATEGORIA_MEZZO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDCategoriaMezzoDto> findAll() throws TaifDCategoriaMezzoDaoException;

	/** 
		 * Implementazione del finder byVisibileOrdin con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaMezzoByVisibileOrdinDto> findByVisibileOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDCategoriaMezzoDaoException;

	/** 
		 * Implementazione del finder byCategoriaMezzo con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaMezzoByCategoriaMezzoDto> findByCategoriaMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CategoriaMezzoFilter input)
			throws TaifDCategoriaMezzoDaoException;

	/** 
		 * Implementazione del finder byIdCategoriaMezzo con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaMezzoByIdCategoriaMezzoDto> findByIdCategoriaMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CategoriaMezzoFilter input)
			throws TaifDCategoriaMezzoDaoException;

	/** 
		 * Implementazione del finder byIdTipoMezzo con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaMezzoByIdTipoMezzoDto> findByIdTipoMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input)
			throws TaifDCategoriaMezzoDaoException;

}
