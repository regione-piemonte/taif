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
 * Interfaccia pubblica del DAO taifDMateriale.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDMaterialeDao {

	/**
	 * Metodo di inserimento del DAO taifDMateriale. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDMaterialePk
	 * @generated
	 */

	public TaifDMaterialePk insert(TaifDMaterialeDto dto)

	;

	/** 
	 * Returns all rows from the TAIF_D_MATERIALE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDMaterialeDto findByPrimaryKey(TaifDMaterialePk pk) throws TaifDMaterialeDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_MATERIALE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDMaterialeDto> findAll() throws TaifDMaterialeDaoException;

	/** 
		 * Implementazione del finder byVisibleOrdin con Qdef
		 * @generated
		 */

	public List<TaifDMaterialeByVisibleOrdinDto> findByVisibleOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.MaterialeFilter input) throws TaifDMaterialeDaoException;

}
