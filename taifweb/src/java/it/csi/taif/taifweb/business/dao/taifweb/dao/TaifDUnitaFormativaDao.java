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
 * Interfaccia pubblica del DAO taifDUnitaFormativa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDUnitaFormativaDao {

	/**
	 * Metodo di inserimento del DAO taifDUnitaFormativa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDUnitaFormativaPk
	 * @generated
	 */

	public TaifDUnitaFormativaPk insert(TaifDUnitaFormativaDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_UNITA_FORMATIVA table.
	 * @generated
	 */

	public void delete(TaifDUnitaFormativaPk pk) throws TaifDUnitaFormativaDaoException;

	/** 
	 * Returns all rows from the TAIF_D_UNITA_FORMATIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDUnitaFormativaDto findByPrimaryKey(TaifDUnitaFormativaPk pk) throws TaifDUnitaFormativaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_UNITA_FORMATIVA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDUnitaFormativaDto> findAll() throws TaifDUnitaFormativaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDUnitaFormativaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaFormativaFilter input)
			throws TaifDUnitaFormativaDaoException;

}
