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
 * Interfaccia pubblica del DAO taifTCorso.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTCorsoDao {

	/**
	 * Metodo di inserimento del DAO taifTCorso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTCorsoPk
	 * @generated
	 */

	public TaifTCorsoPk insert(TaifTCorsoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_CORSO table.
	 * @generated
	 */
	public void update(TaifTCorsoDto dto) throws TaifTCorsoDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_CORSO table.
	 * @generated
	 */

	public void delete(TaifTCorsoPk pk) throws TaifTCorsoDaoException;

	/** 
	 * Returns all rows from the TAIF_T_CORSO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTCorsoDto findByPrimaryKey(TaifTCorsoPk pk) throws TaifTCorsoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_CORSO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTCorsoDto> findAll() throws TaifTCorsoDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTCorsoByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoQualificaFilter input) throws TaifTCorsoDaoException;

	/** 
		 * Implementazione del finder findCorsiElencoOperatori con Qdef
		 * @generated
		 */

	public List<TaifTCorsoFindCorsiElencoOperatoriDto> findFindCorsiElencoOperatori(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoQualificaFilter input) throws TaifTCorsoDaoException;

}
