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
 * Interfaccia pubblica del DAO taifDTipoMezzo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoMezzoDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoMezzo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoMezzoPk
	 * @generated
	 */

	public TaifDTipoMezzoPk insert(TaifDTipoMezzoDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_MEZZO table.
	 * @generated
	 */

	public void delete(TaifDTipoMezzoPk pk) throws TaifDTipoMezzoDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_MEZZO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoMezzoDto findByPrimaryKey(TaifDTipoMezzoPk pk) throws TaifDTipoMezzoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_MEZZO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoMezzoDto> findAll() throws TaifDTipoMezzoDaoException;

	/** 
		 * Implementazione del finder byVisibileCategoria con Qdef
		 * @generated
		 */

	public List<TaifDTipoMezzoByVisibileCategoriaDto> findByVisibileCategoria(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifDTipoMezzoDaoException;

	/** 
		 * Implementazione del finder byVisibileOrdin con Qdef
		 * @generated
		 */

	public List<TaifDTipoMezzoByVisibileOrdinDto> findByVisibileOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoMezzoDaoException;

	/** 
		 * Implementazione del finder byTipoMezzo con Qdef
		 * @generated
		 */

	public List<TaifDTipoMezzoByTipoMezzoDto> findByTipoMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifDTipoMezzoDaoException;

	/** 
		 * Implementazione del finder byCategoriaMezzo con Qdef
		 * @generated
		 */

	public List<TaifDTipoMezzoByCategoriaMezzoDto> findByCategoriaMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifDTipoMezzoDaoException;

}
