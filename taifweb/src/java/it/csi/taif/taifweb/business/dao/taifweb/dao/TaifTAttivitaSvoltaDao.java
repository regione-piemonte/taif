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
 * Interfaccia pubblica del DAO taifTAttivitaSvolta.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTAttivitaSvoltaDao {

	/**
	 * Metodo di inserimento del DAO taifTAttivitaSvolta. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAttivitaSvoltaPk
	 * @generated
	 */

	public TaifTAttivitaSvoltaPk insert(TaifTAttivitaSvoltaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_ATTIVITA_SVOLTA table.
	 * @generated
	 */
	public void update(TaifTAttivitaSvoltaDto dto) throws TaifTAttivitaSvoltaDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_ATTIVITA_SVOLTA table.
	 * @generated
	 */
	public void updateColumnsAttivitaForIdAzienda(TaifTAttivitaSvoltaDto dto) throws TaifTAttivitaSvoltaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_ATTIVITA_SVOLTA table.
	 * @generated
	 */

	public void delete(TaifTAttivitaSvoltaPk pk) throws TaifTAttivitaSvoltaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_ATTIVITA_SVOLTA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAttivitaSvoltaDto findByPrimaryKey(TaifTAttivitaSvoltaPk pk) throws TaifTAttivitaSvoltaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_ATTIVITA_SVOLTA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAttivitaSvoltaDto> findAll() throws TaifTAttivitaSvoltaDaoException;

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifTAttivitaSvoltaDaoException;

	/** 
		 * Implementazione del finder attivitaSvoltaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> findAttivitaSvoltaByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTAttivitaSvoltaDaoException;

	/** 
		 * Implementazione del finder attivitaSvoltaAndDettByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> findAttivitaSvoltaAndDettByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTAttivitaSvoltaDaoException;

	/** 
		 * Implementazione del finder dettaglioAttivitaSvoltaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto> findDettaglioAttivitaSvoltaByIdAzienda(
			java.lang.Integer input) throws TaifTAttivitaSvoltaDaoException;

}
