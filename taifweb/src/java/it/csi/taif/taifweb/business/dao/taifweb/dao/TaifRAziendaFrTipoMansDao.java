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
 * Interfaccia pubblica del DAO taifRAziendaFrTipoMans.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifRAziendaFrTipoMansDao {

	/**
	 * Metodo di inserimento del DAO taifRAziendaFrTipoMans. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAziendaFrTipoMansPk
	 * @generated
	 */

	public TaifRAziendaFrTipoMansPk insert(TaifRAziendaFrTipoMansDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_R_AZIENDAFR_TIPOMANS table.
	 * @generated
	 */
	public void updateColumnsUpdateForIdAziendaMansione(TaifRAziendaFrTipoMansDto dto)
			throws TaifRAziendaFrTipoMansDaoException;

	/** 
	 * Deletes a single row in the TAIF_R_AZIENDAFR_TIPOMANS table.
	 * @generated
	 */

	public void delete(TaifRAziendaFrTipoMansPk pk) throws TaifRAziendaFrTipoMansDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_AZIENDAFR_TIPOMANS.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAziendaFrTipoMansDto> findAll() throws TaifRAziendaFrTipoMansDaoException;

	/** 
		 * Implementazione del finder findByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoMansFindByIdAziendaDto> findFindByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaFrTipoMansDaoException;

	/** 
		 * Implementazione del finder byIdTipoMansione con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoMansByIdTipoMansioneDto> findByIdTipoMansione(java.lang.Integer input)
			throws TaifRAziendaFrTipoMansDaoException;

	/** 
	 * Returns all rows from the TAIF_R_AZIENDAFR_TIPOMANS table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAziendaFrTipoMansDto findByPrimaryKey(TaifRAziendaFrTipoMansPk pk)
			throws TaifRAziendaFrTipoMansDaoException;

	/** 
		 * Implementazione del finder findTipoByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoMansFindTipoByIdAziendaDto> findFindTipoByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaFrTipoMansDaoException;

}
