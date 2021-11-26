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
 * Interfaccia pubblica del DAO taifCnfAttribAmmesso.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifCnfAttribAmmessoDao {

	/**
	 * Metodo di inserimento del DAO taifCnfAttribAmmesso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifCnfAttribAmmessoPk
	 * @generated
	 */

	public TaifCnfAttribAmmessoPk insert(TaifCnfAttribAmmessoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_CNF_ATTRIB_AMMESSO table.
	 * @generated
	 */
	public void update(TaifCnfAttribAmmessoDto dto) throws TaifCnfAttribAmmessoDaoException;

	/** 
	 * Deletes a single row in the TAIF_CNF_ATTRIB_AMMESSO table.
	 * @generated
	 */

	public void delete(TaifCnfAttribAmmessoPk pk) throws TaifCnfAttribAmmessoDaoException;

	/** 
	 * Returns all rows from the TAIF_CNF_ATTRIB_AMMESSO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfAttribAmmessoDto findByPrimaryKey(TaifCnfAttribAmmessoPk pk) throws TaifCnfAttribAmmessoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_ATTRIB_AMMESSO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfAttribAmmessoDto> findAll() throws TaifCnfAttribAmmessoDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifCnfAttribAmmessoByFilterDto> findByFilter(java.lang.Integer input)
			throws TaifCnfAttribAmmessoDaoException;

}
