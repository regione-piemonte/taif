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
 * Interfaccia pubblica del DAO taifDAmbitoFormativo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDAmbitoFormativoDao {

	/**
	 * Metodo di inserimento del DAO taifDAmbitoFormativo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAmbitoFormativoPk
	 * @generated
	 */

	public TaifDAmbitoFormativoPk insert(TaifDAmbitoFormativoDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_AMBITO_FORMATIVO table.
	 * @generated
	 */

	public void delete(TaifDAmbitoFormativoPk pk) throws TaifDAmbitoFormativoDaoException;

	/** 
	 * Returns all rows from the TAIF_D_AMBITO_FORMATIVO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAmbitoFormativoDto findByPrimaryKey(TaifDAmbitoFormativoPk pk) throws TaifDAmbitoFormativoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_AMBITO_FORMATIVO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAmbitoFormativoDto> findAll() throws TaifDAmbitoFormativoDaoException;

	/** 
		 * Implementazione del finder byVisible con Qdef
		 * @generated
		 */

	public List<TaifDAmbitoFormativoByVisibleDto> findByVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAmbitoFormativoDaoException;

}
