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
 * Interfaccia pubblica del DAO taifDFunzione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDFunzioneDao {

	/**
	 * Metodo di inserimento del DAO taifDFunzione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDFunzionePk
	 * @generated
	 */

	public TaifDFunzionePk insert(TaifDFunzioneDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_FUNZIONE table.
	 * @generated
	 */

	public void delete(TaifDFunzionePk pk) throws TaifDFunzioneDaoException;

	/** 
	 * Returns all rows from the TAIF_D_FUNZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDFunzioneDto findByPrimaryKey(TaifDFunzionePk pk) throws TaifDFunzioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_FUNZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDFunzioneDto> findAll() throws TaifDFunzioneDaoException;

	/** 
		 * Implementazione del finder byVisibleFilter con Qdef
		 * @generated
		 */

	public List<TaifDFunzioneByVisibleFilterDto> findByVisibleFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDFunzioneDaoException;

	/** 
		 * Implementazione del finder piazzaStoccaggio con Qdef
		 * @generated
		 */

	public List<TaifDFunzionePiazzaStoccaggioDto> findPiazzaStoccaggio(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDFunzioneDaoException;

	/** 
		 * Implementazione del finder byFunzione con Qdef
		 * @generated
		 */

	public List<TaifDFunzioneByFunzioneDto> findByFunzione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.FunzioneVisibleFilter input)
			throws TaifDFunzioneDaoException;

}
