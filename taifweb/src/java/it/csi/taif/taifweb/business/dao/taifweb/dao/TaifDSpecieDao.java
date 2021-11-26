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
 * Interfaccia pubblica del DAO taifDSpecie.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDSpecieDao {

	/**
	 * Metodo di inserimento del DAO taifDSpecie. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDSpeciePk
	 * @generated
	 */

	public TaifDSpeciePk insert(TaifDSpecieDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_SPECIE table.
	 * @generated
	 */
	public void update(TaifDSpecieDto dto) throws TaifDSpecieDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_SPECIE table.
	 * @generated
	 */

	public void delete(TaifDSpeciePk pk) throws TaifDSpecieDaoException;

	/** 
	 * Returns all rows from the TAIF_D_SPECIE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDSpecieDto findByPrimaryKey(TaifDSpeciePk pk) throws TaifDSpecieDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_SPECIE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDSpecieDto> findAll() throws TaifDSpecieDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDSpecieByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDSpecieDaoException;

}
