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
 * Interfaccia pubblica del DAO taifApplSchedaOk.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifApplSchedaOkDao {

	/**
	 * Metodo di inserimento del DAO taifApplSchedaOk. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifApplSchedaOkPk
	 * @generated
	 */

	public TaifApplSchedaOkPk insert(TaifApplSchedaOkDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_APPL_SCHEDA_OK table.
	 * @generated
	 */
	public void update(TaifApplSchedaOkDto dto) throws TaifApplSchedaOkDaoException;

	/** 
	 * Deletes a single row in the TAIF_APPL_SCHEDA_OK table.
	 * @generated
	 */

	public void delete(TaifApplSchedaOkPk pk) throws TaifApplSchedaOkDaoException;

	/** 
	 * Returns all rows from the TAIF_APPL_SCHEDA_OK table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifApplSchedaOkDto findByPrimaryKey(TaifApplSchedaOkPk pk) throws TaifApplSchedaOkDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_APPL_SCHEDA_OK.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifApplSchedaOkDto> findAll() throws TaifApplSchedaOkDaoException;

	/** 
		 * Implementazione del finder byPratica con Qdef
		 * @generated
		 */

	public List<TaifApplSchedaOkByPraticaDto> findByPratica(java.lang.Integer input)
			throws TaifApplSchedaOkDaoException;

}
