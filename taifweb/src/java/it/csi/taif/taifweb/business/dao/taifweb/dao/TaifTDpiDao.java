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
 * Interfaccia pubblica del DAO taifTDpi.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTDpiDao {

	/**
	 * Metodo di inserimento del DAO taifTDpi. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTDpiPk
	 * @generated
	 */

	public TaifTDpiPk insert(TaifTDpiDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_DPI table.
	 * @generated
	 */
	public void update(TaifTDpiDto dto) throws TaifTDpiDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_DPI table.
	 * @generated
	 */
	public void updateColumnsPerIdAzienda(TaifTDpiDto dto) throws TaifTDpiDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_DPI table.
	 * @generated
	 */

	public void delete(TaifTDpiPk pk) throws TaifTDpiDaoException;

	/** 
	 * Returns all rows from the TAIF_T_DPI table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTDpiDto findByPrimaryKey(TaifTDpiPk pk) throws TaifTDpiDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_DPI.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTDpiDto> findAll() throws TaifTDpiDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTDpiByFilterDto> findByFilter(it.csi.taif.taifweb.business.dao.taifweb.filter.DpiFilter input)
			throws TaifTDpiDaoException;

	/** 
		 * Implementazione del finder byAzienda con Qdef
		 * @generated
		 */

	public List<TaifTDpiByAziendaDto> findByAzienda(java.lang.Integer input) throws TaifTDpiDaoException;

	/** 
		 * Implementazione del finder byIdTipoDispositivo con Qdef
		 * @generated
		 */

	public List<TaifTDpiByIdTipoDispositivoDto> findByIdTipoDispositivo(java.lang.Integer input)
			throws TaifTDpiDaoException;

	/** 
		 * Implementazione del finder dpiByAziendaVisibile con Qdef
		 * @generated
		 */

	public List<TaifTDpiDpiByAziendaVisibileDto> findDpiByAziendaVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input) throws TaifTDpiDaoException;

}
