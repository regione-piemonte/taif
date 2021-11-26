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
 * Interfaccia pubblica del DAO taifTLavoroPa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTLavoroPaDao {

	/**
	 * Metodo di inserimento del DAO taifTLavoroPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTLavoroPaPk
	 * @generated
	 */

	public TaifTLavoroPaPk insert(TaifTLavoroPaDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_T_LAVORO_PA table.
	 * @generated
	 */
	public void updateColumnsUpdateById(TaifTLavoroPaDto dto) throws TaifTLavoroPaDaoException;

	/** 
	 * Updates a single row in the TAIF_T_LAVORO_PA table.
	 * @generated
	 */
	public void update(TaifTLavoroPaDto dto) throws TaifTLavoroPaDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_LAVORO_PA table.
	 * @generated
	 */
	public void updateColumnsPerIdAzienda(TaifTLavoroPaDto dto) throws TaifTLavoroPaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_LAVORO_PA table.
	 * @generated
	 */

	public void delete(TaifTLavoroPaPk pk) throws TaifTLavoroPaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_LAVORO_PA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTLavoroPaDto findByPrimaryKey(TaifTLavoroPaPk pk) throws TaifTLavoroPaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_LAVORO_PA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTLavoroPaDto> findAll() throws TaifTLavoroPaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTLavoroPaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifTLavoroPaDaoException;

	/** 
		 * Implementazione del finder byAzienda con Qdef
		 * @generated
		 */

	public List<TaifTLavoroPaByAziendaDto> findByAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.LavoroPaFilter input) throws TaifTLavoroPaDaoException;

	/** 
		 * Implementazione del finder lavoroPaByAziendaVisibile con Qdef
		 * @generated
		 */

	public List<TaifTLavoroPaLavoroPaByAziendaVisibileDto> findLavoroPaByAziendaVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTLavoroPaDaoException;

}
