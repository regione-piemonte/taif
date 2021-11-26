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
 * Interfaccia pubblica del DAO taifTAttivitaSvoltaDett.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTAttivitaSvoltaDettDao {

	/**
	 * Metodo di inserimento del DAO taifTAttivitaSvoltaDett. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAttivitaSvoltaDettPk
	 * @generated
	 */

	public TaifTAttivitaSvoltaDettPk insert(TaifTAttivitaSvoltaDettDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_ATTIVITA_SVOLTA_DETT table.
	 * @generated
	 */
	public void update(TaifTAttivitaSvoltaDettDto dto) throws TaifTAttivitaSvoltaDettDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_ATTIVITA_SVOLTA_DETT table.
	 * @generated
	 */
	public void updateColumnsForIdAzienda(TaifTAttivitaSvoltaDettDto dto) throws TaifTAttivitaSvoltaDettDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_ATTIVITA_SVOLTA_DETT table.
	 * @generated
	 */

	public void delete(TaifTAttivitaSvoltaDettPk pk) throws TaifTAttivitaSvoltaDettDaoException;

	/** 
	 * Returns all rows from the TAIF_T_ATTIVITA_SVOLTA_DETT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAttivitaSvoltaDettDto findByPrimaryKey(TaifTAttivitaSvoltaDettPk pk)
			throws TaifTAttivitaSvoltaDettDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_ATTIVITA_SVOLTA_DETT.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAttivitaSvoltaDettDto> findAll() throws TaifTAttivitaSvoltaDettDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaDettByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AttivitaSvoltaDettFilter input)
			throws TaifTAttivitaSvoltaDettDaoException;

	/** 
		 * Implementazione del finder byFilterAttivita con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> findByFilterAttivita(java.lang.Integer input)
			throws TaifTAttivitaSvoltaDettDaoException;

	/** 
		 * Implementazione del finder byAttivitaProgressivo con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto> findByAttivitaProgressivo(java.lang.Integer input)
			throws TaifTAttivitaSvoltaDettDaoException;

}
