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
 * Interfaccia pubblica del DAO taifDAttivitaAtecoApe.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDAttivitaAtecoApeDao {

	/**
	 * Metodo di inserimento del DAO taifDAttivitaAtecoApe. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAttivitaAtecoApePk
	 * @generated
	 */

	public TaifDAttivitaAtecoApePk insert(TaifDAttivitaAtecoApeDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_ATTIVITA_ATECO_APE table.
	 * @generated
	 */

	public void delete(TaifDAttivitaAtecoApePk pk) throws TaifDAttivitaAtecoApeDaoException;

	/** 
	 * Returns all rows from the TAIF_D_ATTIVITA_ATECO_APE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAttivitaAtecoApeDto findByPrimaryKey(TaifDAttivitaAtecoApePk pk)
			throws TaifDAttivitaAtecoApeDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ATTIVITA_ATECO_APE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAttivitaAtecoApeDto> findAll() throws TaifDAttivitaAtecoApeDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDAttivitaAtecoApeByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAttivitaAtecoApeDaoException;

	/** 
		 * Implementazione del finder byCodiceAttivita con Qdef
		 * @generated
		 */

	public List<TaifDAttivitaAtecoApeByCodiceAttivitaDto> findByCodiceAttivita(java.lang.String input)
			throws TaifDAttivitaAtecoApeDaoException;

}
