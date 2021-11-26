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
 * Interfaccia pubblica del DAO taifDTipoCarrello.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoCarrelloDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoCarrello. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoCarrelloPk
	 * @generated
	 */

	public TaifDTipoCarrelloPk insert(TaifDTipoCarrelloDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TIPO_CARRELLO table.
	 * @generated
	 */
	public void update(TaifDTipoCarrelloDto dto) throws TaifDTipoCarrelloDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_CARRELLO table.
	 * @generated
	 */

	public void delete(TaifDTipoCarrelloPk pk) throws TaifDTipoCarrelloDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_CARRELLO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoCarrelloDto findByPrimaryKey(TaifDTipoCarrelloPk pk) throws TaifDTipoCarrelloDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_CARRELLO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoCarrelloDto> findAll() throws TaifDTipoCarrelloDaoException;

	/** 
		 * Implementazione del finder byVisibile con Qdef
		 * @generated
		 */

	public List<TaifDTipoCarrelloByVisibileDto> findByVisibile(java.lang.Integer input)
			throws TaifDTipoCarrelloDaoException;

}
