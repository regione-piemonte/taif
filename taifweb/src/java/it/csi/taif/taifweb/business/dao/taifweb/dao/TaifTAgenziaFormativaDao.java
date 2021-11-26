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
 * Interfaccia pubblica del DAO taifTAgenziaFormativa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTAgenziaFormativaDao {

	/**
	 * Metodo di inserimento del DAO taifTAgenziaFormativa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAgenziaFormativaPk
	 * @generated
	 */

	public TaifTAgenziaFormativaPk insert(TaifTAgenziaFormativaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_AGENZIA_FORMATIVA table.
	 * @generated
	 */
	public void update(TaifTAgenziaFormativaDto dto) throws TaifTAgenziaFormativaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_AGENZIA_FORMATIVA table.
	 * @generated
	 */

	public void delete(TaifTAgenziaFormativaPk pk) throws TaifTAgenziaFormativaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_AGENZIA_FORMATIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAgenziaFormativaDto findByPrimaryKey(TaifTAgenziaFormativaPk pk)
			throws TaifTAgenziaFormativaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_AGENZIA_FORMATIVA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAgenziaFormativaDto> findAll() throws TaifTAgenziaFormativaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTAgenziaFormativaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AgenziaFormativaFilter input)
			throws TaifTAgenziaFormativaDaoException;

}
