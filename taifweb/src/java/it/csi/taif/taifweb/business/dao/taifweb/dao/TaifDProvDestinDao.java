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
 * Interfaccia pubblica del DAO taifDProvDestin.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDProvDestinDao {

	/**
	 * Metodo di inserimento del DAO taifDProvDestin. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDProvDestinPk
	 * @generated
	 */

	public TaifDProvDestinPk insert(TaifDProvDestinDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_PROV_DESTIN table.
	 * @generated
	 */

	public void delete(TaifDProvDestinPk pk) throws TaifDProvDestinDaoException;

	/** 
	 * Returns all rows from the TAIF_D_PROV_DESTIN table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDProvDestinDto findByPrimaryKey(TaifDProvDestinPk pk) throws TaifDProvDestinDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_PROV_DESTIN.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDProvDestinDto> findAll() throws TaifDProvDestinDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDProvDestinByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDProvDestinDaoException;

}
