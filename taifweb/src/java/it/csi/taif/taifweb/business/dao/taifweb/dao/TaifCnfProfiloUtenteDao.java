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
 * Interfaccia pubblica del DAO taifCnfProfiloUtente.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifCnfProfiloUtenteDao {

	/**
	 * Metodo di inserimento del DAO taifCnfProfiloUtente. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifCnfProfiloUtentePk
	 * @generated
	 */

	public TaifCnfProfiloUtentePk insert(TaifCnfProfiloUtenteDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_CNF_PROFILO_UTENTE table.
	 * @generated
	 */
	public void update(TaifCnfProfiloUtenteDto dto) throws TaifCnfProfiloUtenteDaoException;

	/** 
	 * Deletes a single row in the TAIF_CNF_PROFILO_UTENTE table.
	 * @generated
	 */

	public void delete(TaifCnfProfiloUtentePk pk) throws TaifCnfProfiloUtenteDaoException;

	/** 
	 * Returns all rows from the TAIF_CNF_PROFILO_UTENTE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfProfiloUtenteDto findByPrimaryKey(TaifCnfProfiloUtentePk pk) throws TaifCnfProfiloUtenteDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_PROFILO_UTENTE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfProfiloUtenteDto> findAll() throws TaifCnfProfiloUtenteDaoException;

	/** 
		 * Implementazione del finder byProfiloUtente con Qdef
		 * @generated
		 */

	public List<TaifCnfProfiloUtenteByProfiloUtenteDto> findByProfiloUtente(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloFilter input)
			throws TaifCnfProfiloUtenteDaoException;

}
