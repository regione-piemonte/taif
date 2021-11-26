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
 * Interfaccia pubblica del DAO taifDTipoDpi.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoDpiDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoDpi. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoDpiPk
	 * @generated
	 */

	public TaifDTipoDpiPk insert(TaifDTipoDpiDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TIPO_DPI table.
	 * @generated
	 */
	public void update(TaifDTipoDpiDto dto) throws TaifDTipoDpiDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_DPI table.
	 * @generated
	 */

	public void delete(TaifDTipoDpiPk pk) throws TaifDTipoDpiDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_DPI table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoDpiDto findByPrimaryKey(TaifDTipoDpiPk pk) throws TaifDTipoDpiDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_DPI.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoDpiDto> findAll() throws TaifDTipoDpiDaoException;

	/** 
		 * Implementazione del finder byVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoDpiByVisibleDto> findByVisible(java.lang.Integer input) throws TaifDTipoDpiDaoException;

	/** 
		 * Implementazione del finder byDispVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoDpiByDispVisibleDto> findByDispVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.DispositiviFilter input) throws TaifDTipoDpiDaoException;

}
