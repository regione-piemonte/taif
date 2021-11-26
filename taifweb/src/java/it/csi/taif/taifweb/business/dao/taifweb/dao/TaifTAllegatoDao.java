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
 * Interfaccia pubblica del DAO taifTAllegato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTAllegatoDao {

	/**
	 * Metodo di inserimento del DAO taifTAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAllegatoPk
	 * @generated
	 */

	public TaifTAllegatoPk insert(TaifTAllegatoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_ALLEGATO table.
	 * @generated
	 */
	public void update(TaifTAllegatoDto dto) throws TaifTAllegatoDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_ALLEGATO table.
	 * @generated
	 */
	public void updateColumnsIdDocumentoActa(TaifTAllegatoDto dto) throws TaifTAllegatoDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_ALLEGATO table.
	 * @generated
	 */

	public void delete(TaifTAllegatoPk pk) throws TaifTAllegatoDaoException;

	/** 
	 * Returns all rows from the TAIF_T_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAllegatoDto findByPrimaryKey(TaifTAllegatoPk pk) throws TaifTAllegatoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAllegatoDto> findAll() throws TaifTAllegatoDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTAllegatoByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AllegatoFilter input) throws TaifTAllegatoDaoException;

	/** 
		 * Implementazione del finder byIdPratica con Qdef
		 * @generated
		 */

	public List<TaifTAllegatoByIdPraticaDto> findByIdPratica(java.lang.Integer input) throws TaifTAllegatoDaoException;

	/** 
		 * Implementazione del finder byIdPraticaAll con Qdef
		 * @generated
		 */

	public List<TaifTAllegatoByIdPraticaAllDto> findByIdPraticaAll(java.lang.Integer input)
			throws TaifTAllegatoDaoException;

}
