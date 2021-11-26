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
 * Interfaccia pubblica del DAO taifDTipoContratto.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoContrattoDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoContratto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoContrattoPk
	 * @generated
	 */

	public TaifDTipoContrattoPk insert(TaifDTipoContrattoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TIPO_CONTRATTO table.
	 * @generated
	 */
	public void update(TaifDTipoContrattoDto dto) throws TaifDTipoContrattoDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_CONTRATTO table.
	 * @generated
	 */

	public void delete(TaifDTipoContrattoPk pk) throws TaifDTipoContrattoDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_CONTRATTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoContrattoDto findByPrimaryKey(TaifDTipoContrattoPk pk) throws TaifDTipoContrattoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_CONTRATTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoContrattoDto> findAll() throws TaifDTipoContrattoDaoException;

	/** 
		 * Implementazione del finder byVisibleOrdin con Qdef
		 * @generated
		 */

	public List<TaifDTipoContrattoByVisibleOrdinDto> findByVisibleOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoContrattoDaoException;

	/** 
		 * Implementazione del finder byTipoContratto con Qdef
		 * @generated
		 */

	public List<TaifDTipoContrattoByTipoContrattoDto> findByTipoContratto(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ContrattoFilter input)
			throws TaifDTipoContrattoDaoException;

	/** 
		 * Implementazione del finder byIdContratto con Qdef
		 * @generated
		 */

	public List<TaifDTipoContrattoByIdContrattoDto> findByIdContratto(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ContrattoFilter input)
			throws TaifDTipoContrattoDaoException;

}
