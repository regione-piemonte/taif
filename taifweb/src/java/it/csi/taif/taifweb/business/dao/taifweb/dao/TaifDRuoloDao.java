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
 * Interfaccia pubblica del DAO taifDRuolo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDRuoloDao {

	/**
	 * Metodo di inserimento del DAO taifDRuolo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDRuoloPk
	 * @generated
	 */

	public TaifDRuoloPk insert(TaifDRuoloDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_RUOLO table.
	 * @generated
	 */
	public void update(TaifDRuoloDto dto) throws TaifDRuoloDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_RUOLO table.
	 * @generated
	 */

	public void delete(TaifDRuoloPk pk) throws TaifDRuoloDaoException;

	/** 
	 * Returns all rows from the TAIF_D_RUOLO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDRuoloDto findByPrimaryKey(TaifDRuoloPk pk) throws TaifDRuoloDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_RUOLO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDRuoloDto> findAll() throws TaifDRuoloDaoException;

	/** 
		 * Implementazione del finder byVisibile con Qdef
		 * @generated
		 */

	public List<TaifDRuoloByVisibileDto> findByVisibile(java.lang.Integer input) throws TaifDRuoloDaoException;

	/** 
		 * Implementazione del finder byRuolo con Qdef
		 * @generated
		 */

	public List<TaifDRuoloByRuoloDto> findByRuolo(it.csi.taif.taifweb.business.dao.taifweb.filter.RuoloFilter input)
			throws TaifDRuoloDaoException;

	/** 
		 * Implementazione del finder byidRuolo con Qdef
		 * @generated
		 */

	public List<TaifDRuoloByidRuoloDto> findByidRuolo(it.csi.taif.taifweb.business.dao.taifweb.filter.RuoloFilter input)
			throws TaifDRuoloDaoException;

}
