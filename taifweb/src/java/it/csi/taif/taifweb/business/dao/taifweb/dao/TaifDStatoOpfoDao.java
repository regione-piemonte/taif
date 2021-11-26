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
 * Interfaccia pubblica del DAO taifDStatoOpfo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDStatoOpfoDao {

	/**
	 * Metodo di inserimento del DAO taifDStatoOpfo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDStatoOpfoPk
	 * @generated
	 */

	public TaifDStatoOpfoPk insert(TaifDStatoOpfoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_STATO_OPFO table.
	 * @generated
	 */
	public void update(TaifDStatoOpfoDto dto) throws TaifDStatoOpfoDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_STATO_OPFO table.
	 * @generated
	 */

	public void delete(TaifDStatoOpfoPk pk) throws TaifDStatoOpfoDaoException;

	/** 
	 * Returns all rows from the TAIF_D_STATO_OPFO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDStatoOpfoDto findByPrimaryKey(TaifDStatoOpfoPk pk) throws TaifDStatoOpfoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_STATO_OPFO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDStatoOpfoDto> findAll() throws TaifDStatoOpfoDaoException;

	/** 
		 * Implementazione del finder statoOpfoItaVisible con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoStatoOpfoItaVisibleDto> findStatoOpfoItaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDStatoOpfoDaoException;

	/** 
		 * Implementazione del finder statoOpfoFraVisible con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoStatoOpfoFraVisibleDto> findStatoOpfoFraVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDStatoOpfoDaoException;

}
