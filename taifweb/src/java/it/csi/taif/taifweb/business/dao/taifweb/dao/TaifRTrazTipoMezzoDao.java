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
 * Interfaccia pubblica del DAO taifRTrazTipoMezzo.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifRTrazTipoMezzoDao {

	/** 
	 * Returns all rows from the TAIF_R_TRAZ_TIPOMEZZO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRTrazTipoMezzoDto findByPrimaryKey(TaifRTrazTipoMezzoPk pk) throws TaifRTrazTipoMezzoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_TRAZ_TIPOMEZZO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRTrazTipoMezzoDto> findAll() throws TaifRTrazTipoMezzoDaoException;

	/** 
		 * Implementazione del finder byIdTipoMezzo con Qdef
		 * @generated
		 */

	public List<TaifRTrazTipoMezzoByIdTipoMezzoDto> findByIdTipoMezzo(java.lang.Integer input)
			throws TaifRTrazTipoMezzoDaoException;

}
