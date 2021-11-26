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
 * Interfaccia pubblica del DAO taifDTipoStruttura.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoStrutturaDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoStruttura. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoStrutturaPk
	 * @generated
	 */

	public TaifDTipoStrutturaPk insert(TaifDTipoStrutturaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TIPO_STRUTTURA table.
	 * @generated
	 */
	public void update(TaifDTipoStrutturaDto dto) throws TaifDTipoStrutturaDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_STRUTTURA table.
	 * @generated
	 */

	public void delete(TaifDTipoStrutturaPk pk) throws TaifDTipoStrutturaDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_STRUTTURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoStrutturaDto findByPrimaryKey(TaifDTipoStrutturaPk pk) throws TaifDTipoStrutturaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_STRUTTURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoStrutturaDto> findAll() throws TaifDTipoStrutturaDaoException;

	/** 
		 * Implementazione del finder tipoStrutturaVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoStrutturaTipoStrutturaVisibleDto> findTipoStrutturaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoStrutturaDaoException;

}
