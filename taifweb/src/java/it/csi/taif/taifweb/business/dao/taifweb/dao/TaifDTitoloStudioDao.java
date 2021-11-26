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
 * Interfaccia pubblica del DAO taifDTitoloStudio.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTitoloStudioDao {

	/** 
	 * Returns all rows from the TAIF_D_TITOLO_STUDIO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTitoloStudioDto findByPrimaryKey(TaifDTitoloStudioPk pk) throws TaifDTitoloStudioDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TITOLO_STUDIO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTitoloStudioDto> findAll() throws TaifDTitoloStudioDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDTitoloStudioByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTitoloStudioDaoException;

}
