/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO taifTOpfo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTOpfoDao {

	/**
	 * Metodo di inserimento del DAO taifTOpfo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTOpfoPk
	 * @generated
	 */

	public TaifTOpfoPk insert(TaifTOpfoDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_T_OPFO table.
	 * @generated
	 */
	public void updateColumnsByIdOperatoriForestali(TaifTOpfoDto dto) throws TaifTOpfoDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_OPFO table.
	 * @generated
	 */

	public void delete(TaifTOpfoPk pk) throws TaifTOpfoDaoException;

	/** 
	 * Returns all rows from the TAIF_T_OPFO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTOpfoDto findByPrimaryKey(TaifTOpfoPk pk) throws TaifTOpfoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_OPFO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTOpfoDto> findAll() throws TaifTOpfoDaoException;

	/** 
		 * Implementazione del finder ricercaOperatoreAvanzata con Qdef
		 * @generated
		 */

	public List<TaifTOpfoRicercaOperatoreAvanzataDto> findRicercaOperatoreAvanzata(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input) throws TaifTOpfoDaoException;

}
