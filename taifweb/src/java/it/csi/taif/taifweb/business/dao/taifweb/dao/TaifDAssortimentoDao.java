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
 * Interfaccia pubblica del DAO taifDAssortimento.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDAssortimentoDao {

	/**
	 * Metodo di inserimento del DAO taifDAssortimento. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAssortimentoPk
	 * @generated
	 */

	public TaifDAssortimentoPk insert(TaifDAssortimentoDto dto)

	;

	/** 
	 * Returns all rows from the TAIF_D_ASSORTIMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAssortimentoDto findByPrimaryKey(TaifDAssortimentoPk pk) throws TaifDAssortimentoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ASSORTIMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAssortimentoDto> findAll() throws TaifDAssortimentoDaoException;

	/** 
		 * Implementazione del finder byVisibleFilter con Qdef
		 * @generated
		 */

	public List<TaifDAssortimentoByVisibleFilterDto> findByVisibleFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAssortimentoDaoException;

}
