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
 * Interfaccia pubblica del DAO taifDAlimentazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDAlimentazioneDao {

	/**
	 * Metodo di inserimento del DAO taifDAlimentazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAlimentazionePk
	 * @generated
	 */

	public TaifDAlimentazionePk insert(TaifDAlimentazioneDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_ALIMENTAZIONE table.
	 * @generated
	 */
	public void update(TaifDAlimentazioneDto dto) throws TaifDAlimentazioneDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_ALIMENTAZIONE table.
	 * @generated
	 */

	public void delete(TaifDAlimentazionePk pk) throws TaifDAlimentazioneDaoException;

	/** 
	 * Returns all rows from the TAIF_D_ALIMENTAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAlimentazioneDto findByPrimaryKey(TaifDAlimentazionePk pk) throws TaifDAlimentazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ALIMENTAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAlimentazioneDto> findAll() throws TaifDAlimentazioneDaoException;

	/** 
		 * Implementazione del finder byVisibile con Qdef
		 * @generated
		 */

	public List<TaifDAlimentazioneByVisibileDto> findByVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAlimentazioneDaoException;

}
