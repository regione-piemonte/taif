/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO taifDStatoOpfo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDStatoOpfoDao {

	/**
	 * Metodo di inserimento del DAO taifDStatoOpfo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDStatoOpfoPk
	 * @generated
	 */

	public TaifDStatoOpfoPk insert(TaifDStatoOpfoDto dto)

	;

	/** 
	 * Returns all rows from the TAIF_D_STATO_OPFO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDStatoOpfoDto findByPrimaryKey(TaifDStatoOpfoPk pk) throws TaifDStatoOpfoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_STATO_OPFO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDStatoOpfoDto> findAll() throws TaifDStatoOpfoDaoException;

	/** 
		 * Implementazione del finder byVisibileFra con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoByVisibileFraDto> findByVisibileFra(java.lang.Integer input)
			throws TaifDStatoOpfoDaoException;

	/** 
		 * Implementazione del finder byVisibileIta con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoByVisibileItaDto> findByVisibileIta(java.lang.Integer input)
			throws TaifDStatoOpfoDaoException;

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDStatoOpfoDaoException;

}
