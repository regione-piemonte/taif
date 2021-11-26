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
 * Interfaccia pubblica del DAO taifRAziendaFrTipoContr.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifRAziendaFrTipoContrDao {

	/**
	 * Metodo di inserimento del DAO taifRAziendaFrTipoContr. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAziendaFrTipoContrPk
	 * @generated
	 */

	public TaifRAziendaFrTipoContrPk insert(TaifRAziendaFrTipoContrDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_R_AZIENDAFR_TIPOCONTR table.
	 * @generated
	 */
	public void updateColumnsUpdateForIdAziendaContratto(TaifRAziendaFrTipoContrDto dto)
			throws TaifRAziendaFrTipoContrDaoException;

	/** 
	 * Deletes a single row in the TAIF_R_AZIENDAFR_TIPOCONTR table.
	 * @generated
	 */

	public void delete(TaifRAziendaFrTipoContrPk pk) throws TaifRAziendaFrTipoContrDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_AZIENDAFR_TIPOCONTR.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAziendaFrTipoContrDto> findAll() throws TaifRAziendaFrTipoContrDaoException;

	/** 
		 * Implementazione del finder findByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoContrFindByIdAziendaDto> findFindByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaFrTipoContrDaoException;

	/** 
		 * Implementazione del finder byIdTipoContratto con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoContrByIdTipoContrattoDto> findByIdTipoContratto(java.lang.Integer input)
			throws TaifRAziendaFrTipoContrDaoException;

	/** 
	 * Returns all rows from the TAIF_R_AZIENDAFR_TIPOCONTR table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAziendaFrTipoContrDto findByPrimaryKey(TaifRAziendaFrTipoContrPk pk)
			throws TaifRAziendaFrTipoContrDaoException;

	/** 
		 * Implementazione del finder findTipoByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoContrFindTipoByIdAziendaDto> findFindTipoByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaFrTipoContrDaoException;

}
