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
 * Interfaccia pubblica del DAO taifTStoricoStato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTStoricoStatoDao {

	/**
	 * Metodo di inserimento del DAO taifTStoricoStato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTStoricoStatoPk
	 * @generated
	 */

	public TaifTStoricoStatoPk insert(TaifTStoricoStatoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void update(TaifTStoricoStatoDto dto) throws TaifTStoricoStatoDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void updateColumnsCambioStato(TaifTStoricoStatoDto dto) throws TaifTStoricoStatoDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void updateColumnsAggiornaStato(TaifTStoricoStatoDto dto) throws TaifTStoricoStatoDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void updateColumnsInserisciProtocollo(TaifTStoricoStatoDto dto) throws TaifTStoricoStatoDaoException;

	/** 
	 * Custom updater in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void customUpdaterModificaStato(Integer idPratica, Integer filter,
			it.csi.taif.taifweb.dto.domanda.DettaglioStato value) throws TaifTStoricoStatoDaoException;

	/** 
	 * Custom updater in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void customUpdaterFineStato(TaifTStoricoStatoDto filter, String value) throws TaifTStoricoStatoDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */

	public void delete(TaifTStoricoStatoPk pk) throws TaifTStoricoStatoDaoException;

	/** 
	 * Returns all rows from the TAIF_T_STORICO_STATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTStoricoStatoDto findByPrimaryKey(TaifTStoricoStatoPk pk) throws TaifTStoricoStatoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_STORICO_STATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTStoricoStatoDto> findAll() throws TaifTStoricoStatoDaoException;

	/** 
		 * Implementazione del finder byStatoPratica con Qdef
		 * @generated
		 */

	public List<TaifTStoricoStatoByStatoPraticaDto> findByStatoPratica(java.lang.Integer idPratica,
			java.lang.Integer input) throws TaifTStoricoStatoDaoException;

	/** 
		 * Implementazione del finder byidPraticaIT con Qdef
		 * @generated
		 */

	public List<TaifTStoricoStatoByidPraticaITDto> findByidPraticaIT(java.lang.Integer input)
			throws TaifTStoricoStatoDaoException;

	/** 
		 * Implementazione del finder byidPraticaFR con Qdef
		 * @generated
		 */

	public List<TaifTStoricoStatoByidPraticaFRDto> findByidPraticaFR(java.lang.Integer input)
			throws TaifTStoricoStatoDaoException;

	/** 
	 * Implementazione del finder statoAttivo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTStoricoStatoDto> findStatoAttivo(java.lang.Integer input) throws TaifTStoricoStatoDaoException;

}
