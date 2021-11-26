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
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoQualificaByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDTipoQualificaDaoException;

}
