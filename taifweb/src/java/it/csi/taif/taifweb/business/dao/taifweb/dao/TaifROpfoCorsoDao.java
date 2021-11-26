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
 * Interfaccia pubblica del DAO taifROpfoCorso.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifROpfoCorsoDao {

	/**
	 * Metodo di inserimento del DAO taifROpfoCorso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifROpfoCorsoPk
	 * @generated
	 */

	public TaifROpfoCorsoPk insert(TaifROpfoCorsoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_R_OPFO_CORSO table.
	 * @generated
	 */
	public void update(TaifROpfoCorsoDto dto) throws TaifROpfoCorsoDaoException;

	/** 
	 * Updates selected columns in the TAIF_R_OPFO_CORSO table.
	 * @generated
	 */
	public void updateColumnsOperatoreCorsoById(TaifROpfoCorsoDto dto) throws TaifROpfoCorsoDaoException;

	/** 
	 * Deletes a single row in the TAIF_R_OPFO_CORSO table.
	 * @generated
	 */

	public void delete(TaifROpfoCorsoPk pk) throws TaifROpfoCorsoDaoException;

	/** 
	 * Returns all rows from the TAIF_R_OPFO_CORSO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifROpfoCorsoDto findByPrimaryKey(TaifROpfoCorsoPk pk) throws TaifROpfoCorsoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_OPFO_CORSO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifROpfoCorsoDto> findAll() throws TaifROpfoCorsoDaoException;

	/** 
		 * Implementazione del finder byIdPersona con Qdef
		 * @generated
		 */

	public List<TaifROpfoCorsoByIdPersonaDto> findByIdPersona(java.lang.Integer input)
			throws TaifROpfoCorsoDaoException;

	/** 
		 * Implementazione del finder byIdCorso con Qdef
		 * @generated
		 */

	public List<TaifROpfoCorsoByIdCorsoDto> findByIdCorso(java.lang.Integer input) throws TaifROpfoCorsoDaoException;

}
