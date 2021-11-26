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
 * Interfaccia pubblica del DAO taifDTrazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTrazioneDao {

	/**
	 * Metodo di inserimento del DAO taifDTrazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTrazionePk
	 * @generated
	 */

	public TaifDTrazionePk insert(TaifDTrazioneDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TRAZIONE table.
	 * @generated
	 */
	public void update(TaifDTrazioneDto dto) throws TaifDTrazioneDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TRAZIONE table.
	 * @generated
	 */

	public void delete(TaifDTrazionePk pk) throws TaifDTrazioneDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TRAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTrazioneDto findByPrimaryKey(TaifDTrazionePk pk) throws TaifDTrazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TRAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTrazioneDto> findAll() throws TaifDTrazioneDaoException;

	/** 
		 * Implementazione del finder byVisibileOrdin con Qdef
		 * @generated
		 */

	public List<TaifDTrazioneByVisibileOrdinDto> findByVisibileOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDTrazioneDaoException;

	/** 
		 * Implementazione del finder byTrazTrazione con Qdef
		 * @generated
		 */

	public List<TaifDTrazioneByTrazTrazioneDto> findByTrazTrazione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifDTrazioneDaoException;

}
