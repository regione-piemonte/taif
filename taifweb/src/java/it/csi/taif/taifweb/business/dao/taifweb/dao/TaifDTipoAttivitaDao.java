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
 * Interfaccia pubblica del DAO taifDTipoAttivita.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoAttivitaDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoAttivita. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoAttivitaPk
	 * @generated
	 */

	public TaifDTipoAttivitaPk insert(TaifDTipoAttivitaDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_ATTIVITA table.
	 * @generated
	 */

	public void delete(TaifDTipoAttivitaPk pk) throws TaifDTipoAttivitaDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_ATTIVITA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoAttivitaDto findByPrimaryKey(TaifDTipoAttivitaPk pk) throws TaifDTipoAttivitaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_ATTIVITA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoAttivitaDto> findAll() throws TaifDTipoAttivitaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDTipoAttivitaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoAttivitaDaoException;

}
