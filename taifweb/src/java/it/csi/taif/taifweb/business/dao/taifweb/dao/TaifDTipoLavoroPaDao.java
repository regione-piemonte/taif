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
 * Interfaccia pubblica del DAO taifDTipoLavoroPa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoLavoroPaDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoLavoroPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoLavoroPaPk
	 * @generated
	 */

	public TaifDTipoLavoroPaPk insert(TaifDTipoLavoroPaDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_LAVORO_PA table.
	 * @generated
	 */

	public void delete(TaifDTipoLavoroPaPk pk) throws TaifDTipoLavoroPaDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_LAVORO_PA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoLavoroPaDto findByPrimaryKey(TaifDTipoLavoroPaPk pk) throws TaifDTipoLavoroPaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_LAVORO_PA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoLavoroPaDto> findAll() throws TaifDTipoLavoroPaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDTipoLavoroPaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoLavoroPaDaoException;

}
