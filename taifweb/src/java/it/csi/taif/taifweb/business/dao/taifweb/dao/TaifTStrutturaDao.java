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
 * Interfaccia pubblica del DAO taifTStruttura.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTStrutturaDao {

	/**
	 * Metodo di inserimento del DAO taifTStruttura. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTStrutturaPk
	 * @generated
	 */

	public TaifTStrutturaPk insert(TaifTStrutturaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_STRUTTURA table.
	 * @generated
	 */
	public void update(TaifTStrutturaDto dto) throws TaifTStrutturaDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_STRUTTURA table.
	 * @generated
	 */
	public void updateColumnsPerIdAzienda(TaifTStrutturaDto dto) throws TaifTStrutturaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_STRUTTURA table.
	 * @generated
	 */

	public void delete(TaifTStrutturaPk pk) throws TaifTStrutturaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_STRUTTURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTStrutturaDto findByPrimaryKey(TaifTStrutturaPk pk) throws TaifTStrutturaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_STRUTTURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTStrutturaDto> findAll() throws TaifTStrutturaDaoException;

	/** 
		 * Implementazione del finder findByAzienda con Qdef
		 * @generated
		 */

	public List<TaifTStrutturaFindByAziendaDto> findFindByAzienda(java.lang.Integer input)
			throws TaifTStrutturaDaoException;

	/** 
		 * Implementazione del finder byAziendaFunzione con Qdef
		 * @generated
		 */

	public List<TaifTStrutturaByAziendaFunzioneDto> findByAziendaFunzione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StrutturaFilter input) throws TaifTStrutturaDaoException;

	/** 
		 * Implementazione del finder findFunzioneTipoStrutturaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto> findFindFunzioneTipoStrutturaByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTStrutturaDaoException;

}
