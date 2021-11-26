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
 * Interfaccia pubblica del DAO taifTPratica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTPraticaDao {

	/**
	 * Metodo di inserimento del DAO taifTPratica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTPraticaPk
	 * @generated
	 */

	public TaifTPraticaPk insert(TaifTPraticaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_PRATICA table.
	 * @generated
	 */
	public void update(TaifTPraticaDto dto) throws TaifTPraticaDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_PRATICA table.
	 * @generated
	 */
	public void updateColumnsPraticaByIdPratica(TaifTPraticaDto dto) throws TaifTPraticaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_PRATICA table.
	 * @generated
	 */

	public void delete(TaifTPraticaPk pk) throws TaifTPraticaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_PRATICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTPraticaDto findByPrimaryKey(TaifTPraticaPk pk) throws TaifTPraticaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_PRATICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPraticaDto> findAll() throws TaifTPraticaDaoException;

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTPraticaByIdAziendaDto> findByIdAzienda(java.lang.Integer input) throws TaifTPraticaDaoException;

	/** 
		 * Implementazione del finder byIdGestore con Qdef
		 * @generated
		 */

	public List<TaifTPraticaByIdGestoreDto> findByIdGestore(java.lang.Integer input) throws TaifTPraticaDaoException;

	/** 
		 * Implementazione del finder byNumeroAlbo con Qdef
		 * @generated
		 */

	public List<TaifTPraticaByNumeroAlboDto> findByNumeroAlbo(java.lang.String input) throws TaifTPraticaDaoException;

	/** 
		 * Implementazione del finder byIdAziendaAlbo con Qdef
		 * @generated
		 */

	public List<TaifTPraticaByIdAziendaAlboDto> findByIdAziendaAlbo(java.lang.Integer input)
			throws TaifTPraticaDaoException;

	/** 
	 * Implementazione del finder byIdAziendaIdSoggettoGestore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPraticaDto> findByIdAziendaIdSoggettoGestore(java.lang.Integer idAzienda, java.lang.Integer input)
			throws TaifTPraticaDaoException;

	/** 
		 * Implementazione del finder altriAlbiByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTPraticaAltriAlbiByIdAziendaDto> findAltriAlbiByIdAzienda(java.lang.Integer input)
			throws TaifTPraticaDaoException;

	/** 
		 * Implementazione del finder dettaglioPraticaPerInvio con Qdef
		 * @generated
		 */

	public List<TaifTPraticaDettaglioPraticaPerInvioDto> findDettaglioPraticaPerInvio(java.lang.Integer input)
			throws TaifTPraticaDaoException;

	/** 
		 * Implementazione del finder maxAlboNumberValue con Qdef
		 * @generated
		 */

	public List<TaifTPraticaMaxAlboNumberValueDto> findMaxAlboNumberValue(java.lang.Integer input)
			throws TaifTPraticaDaoException;

}
