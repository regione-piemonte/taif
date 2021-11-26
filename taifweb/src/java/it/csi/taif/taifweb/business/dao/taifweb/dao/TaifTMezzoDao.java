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
 * Interfaccia pubblica del DAO taifTMezzo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTMezzoDao {

	/**
	 * Metodo di inserimento del DAO taifTMezzo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTMezzoPk
	 * @generated
	 */

	public TaifTMezzoPk insert(TaifTMezzoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_MEZZO table.
	 * @generated
	 */
	public void update(TaifTMezzoDto dto) throws TaifTMezzoDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_MEZZO table.
	 * @generated
	 */
	public void updateColumnsPerIdAzienda(TaifTMezzoDto dto) throws TaifTMezzoDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_MEZZO table.
	 * @generated
	 */

	public void delete(TaifTMezzoPk pk) throws TaifTMezzoDaoException;

	/** 
	 * Returns all rows from the TAIF_T_MEZZO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTMezzoDto findByPrimaryKey(TaifTMezzoPk pk) throws TaifTMezzoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_MEZZO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTMezzoDto> findAll() throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder byTipoMezzo con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByTipoMezzoDto> findByTipoMezzo(java.lang.String input) throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder byTipoMezzoAzienda con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByTipoMezzoAziendaDto> findByTipoMezzoAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder byTipoMezzoAziendaVisibile con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByTipoMezzoAziendaVisibileDto> findByTipoMezzoAziendaVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder tipoTrazioneByIdTrazione con Qdef
		 * @generated
		 */

	public List<TaifTMezzoTipoTrazioneByIdTrazioneDto> findTipoTrazioneByIdTrazione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TrazioneFilter input) throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder tipoAlimentazioneByIdAlimentazione con Qdef
		 * @generated
		 */

	public List<TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto> findTipoAlimentazioneByIdAlimentazione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AlimentazioneFilter input) throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder tipoCarrelloByIdCarrello con Qdef
		 * @generated
		 */

	public List<TaifTMezzoTipoCarrelloByIdCarrelloDto> findTipoCarrelloByIdCarrello(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoCarrelloFilter input) throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder dettaglioMezzoByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTMezzoDettaglioMezzoByIdAziendaDto> findDettaglioMezzoByIdAzienda(java.lang.Integer input)
			throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder byIdTipoMezzoAzienda con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByIdTipoMezzoAziendaDto> findByIdTipoMezzoAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifTMezzoDaoException;

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByIdAziendaDto> findByIdAzienda(java.lang.Integer input) throws TaifTMezzoDaoException;

}
