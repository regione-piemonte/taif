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
 * Interfaccia pubblica del DAO taifCnfConfigUtente.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifCnfConfigUtenteDao {

	/**
	 * Metodo di inserimento del DAO taifCnfConfigUtente. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifCnfConfigUtentePk
	 * @generated
	 */

	public TaifCnfConfigUtentePk insert(TaifCnfConfigUtenteDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_CNF_CONFIG_UTENTE table.
	 * @generated
	 */
	public void update(TaifCnfConfigUtenteDto dto) throws TaifCnfConfigUtenteDaoException;

	/** 
	 * Updates selected columns in the TAIF_CNF_CONFIG_UTENTE table.
	 * @generated
	 */
	public void updateColumnsConfigUtente(TaifCnfConfigUtenteDto dto) throws TaifCnfConfigUtenteDaoException;

	/** 
	 * Deletes a single row in the TAIF_CNF_CONFIG_UTENTE table.
	 * @generated
	 */

	public void delete(TaifCnfConfigUtentePk pk) throws TaifCnfConfigUtenteDaoException;

	/** 
	 * Returns all rows from the TAIF_CNF_CONFIG_UTENTE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfConfigUtenteDto findByPrimaryKey(TaifCnfConfigUtentePk pk) throws TaifCnfConfigUtenteDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_CONFIG_UTENTE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfConfigUtenteDto> findAll() throws TaifCnfConfigUtenteDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifCnfConfigUtenteByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigUtenteFilter input)
			throws TaifCnfConfigUtenteDaoException;

	/** 
		 * Implementazione del finder profiloByCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifCnfConfigUtenteProfiloByCodiceFiscaleDto> findProfiloByCodiceFiscale(java.lang.String input)
			throws TaifCnfConfigUtenteDaoException;

	/** 
		 * Implementazione del finder profiloByIdPersonaIdSoggettoGestore con Qdef
		 * @generated
		 */

	public List<TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto> findProfiloByIdPersonaIdSoggettoGestore(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaSoggettogestoreFilter input)
			throws TaifCnfConfigUtenteDaoException;

}
