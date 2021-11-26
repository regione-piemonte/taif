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
	 * Updates a single row in the TAIF_T_QUALIFICA table.
	 * @generated
	 */
	public void update(TaifTQualificaDto dto) throws TaifTQualificaDaoException;

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
		 * Implementazione del finder byPersona con Qdef
		 * @generated
		 */

	public List<TaifTQualificaByPersonaDto> findByPersona(java.lang.Integer input) throws TaifTQualificaDaoException;

	/** 
		 * Implementazione del finder byAgenziaFormativa con Qdef
		 * @generated
		 */

	public List<TaifTQualificaByAgenziaFormativaDto> findByAgenziaFormativa(java.lang.Integer input)
			throws TaifTQualificaDaoException;

	/** 
		 * Implementazione del finder findQualificaElencoOperatori con Qdef
		 * @generated
		 */

	public List<TaifTQualificaFindQualificaElencoOperatoriDto> findFindQualificaElencoOperatori(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoQualificaFilter input)
			throws TaifTQualificaDaoException;

}
