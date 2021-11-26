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
 * Interfaccia pubblica del DAO taifRAziendaAssociazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifRAziendaAssociazioneDao {

	/**
	 * Metodo di inserimento del DAO taifRAziendaAssociazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAziendaAssociazionePk
	 * @generated
	 */

	public TaifRAziendaAssociazionePk insert(TaifRAziendaAssociazioneDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_R_AZIENDA_ASSOCIAZIONE table.
	 * @generated
	 */
	public void update(TaifRAziendaAssociazioneDto dto) throws TaifRAziendaAssociazioneDaoException;

	/** 
	 * Updates selected columns in the TAIF_R_AZIENDA_ASSOCIAZIONE table.
	 * @generated
	 */
	public void updateColumnsAziendaAssociazioni(TaifRAziendaAssociazioneDto dto)
			throws TaifRAziendaAssociazioneDaoException;

	/** 
	 * Deletes a single row in the TAIF_R_AZIENDA_ASSOCIAZIONE table.
	 * @generated
	 */

	public void delete(TaifRAziendaAssociazionePk pk) throws TaifRAziendaAssociazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_AZIENDA_ASSOCIAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAziendaAssociazioneDto> findAll() throws TaifRAziendaAssociazioneDaoException;

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaAssociazioneByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaAssociazioneDaoException;

	/** 
		 * Implementazione del finder byIdAssociazione con Qdef
		 * @generated
		 */

	public List<TaifRAziendaAssociazioneByIdAssociazioneDto> findByIdAssociazione(java.lang.Integer input)
			throws TaifRAziendaAssociazioneDaoException;

	/** 
		 * Implementazione del finder findAssociazioniByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> findFindAssociazioniByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifRAziendaAssociazioneDaoException;

	/** 
	 * Returns all rows from the TAIF_R_AZIENDA_ASSOCIAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAziendaAssociazioneDto findByPrimaryKey(TaifRAziendaAssociazionePk pk)
			throws TaifRAziendaAssociazioneDaoException;

}
