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
 * Interfaccia pubblica del DAO taifDAssociazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDAssociazioneDao {

	/**
	 * Metodo di inserimento del DAO taifDAssociazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAssociazionePk
	 * @generated
	 */

	public TaifDAssociazionePk insert(TaifDAssociazioneDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_ASSOCIAZIONE table.
	 * @generated
	 */

	public void delete(TaifDAssociazionePk pk) throws TaifDAssociazioneDaoException;

	/** 
	 * Returns all rows from the TAIF_D_ASSOCIAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAssociazioneDto findByPrimaryKey(TaifDAssociazionePk pk) throws TaifDAssociazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ASSOCIAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAssociazioneDto> findAll() throws TaifDAssociazioneDaoException;

	/** 
		 * Implementazione del finder byVisibleOrdin con Qdef
		 * @generated
		 */

	public List<TaifDAssociazioneByVisibleOrdinDto> findByVisibleOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAssociazioneDaoException;

}
