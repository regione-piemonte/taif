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
 * Interfaccia pubblica del DAO taifDStatoPratica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDStatoPraticaDao {

	/**
	 * Metodo di inserimento del DAO taifDStatoPratica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDStatoPraticaPk
	 * @generated
	 */

	public TaifDStatoPraticaPk insert(TaifDStatoPraticaDto dto)

	;

	/** 
	 * Returns all rows from the TAIF_D_STATO_PRATICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDStatoPraticaDto findByPrimaryKey(TaifDStatoPraticaPk pk) throws TaifDStatoPraticaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_STATO_PRATICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDStatoPraticaDto> findAll() throws TaifDStatoPraticaDaoException;

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDStatoPraticaDaoException;

}
