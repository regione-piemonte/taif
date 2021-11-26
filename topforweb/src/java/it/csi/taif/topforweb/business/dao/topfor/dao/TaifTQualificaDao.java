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
 * Interfaccia pubblica del DAO taifTQualifica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTQualificaDao {

	/**
	 * Metodo di inserimento del DAO taifTQualifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTQualificaPk
	 * @generated
	 */

	public TaifTQualificaPk insert(TaifTQualificaDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_T_QUALIFICA table.
	 * @generated
	 */
	public void updateColumnsByIdQualifica(TaifTQualificaDto dto) throws TaifTQualificaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_QUALIFICA table.
	 * @generated
	 */

	public void delete(TaifTQualificaPk pk) throws TaifTQualificaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_QUALIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTQualificaDto findByPrimaryKey(TaifTQualificaPk pk) throws TaifTQualificaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_QUALIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTQualificaDto> findAll() throws TaifTQualificaDaoException;

	/** 
		 * Implementazione del finder byIdPersona con Qdef
		 * @generated
		 */

	public List<TaifTQualificaByIdPersonaDto> findByIdPersona(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTQualificaDaoException;

}
