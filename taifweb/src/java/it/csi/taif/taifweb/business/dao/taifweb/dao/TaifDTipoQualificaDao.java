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
 * Interfaccia pubblica del DAO taifDTipoQualifica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoQualificaDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoQualifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoQualificaPk
	 * @generated
	 */

	public TaifDTipoQualificaPk insert(TaifDTipoQualificaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TIPO_QUALIFICA table.
	 * @generated
	 */
	public void update(TaifDTipoQualificaDto dto) throws TaifDTipoQualificaDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_QUALIFICA table.
	 * @generated
	 */

	public void delete(TaifDTipoQualificaPk pk) throws TaifDTipoQualificaDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_QUALIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoQualificaDto findByPrimaryKey(TaifDTipoQualificaPk pk) throws TaifDTipoQualificaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_QUALIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoQualificaDto> findAll() throws TaifDTipoQualificaDaoException;

	/** 
		 * Implementazione del finder byVisibile con Qdef
		 * @generated
		 */

	public List<TaifDTipoQualificaByVisibileDto> findByVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoQualificaDaoException;

}
