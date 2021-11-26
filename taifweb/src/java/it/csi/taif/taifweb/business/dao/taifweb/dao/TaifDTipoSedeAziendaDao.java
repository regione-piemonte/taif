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
 * Interfaccia pubblica del DAO taifDTipoSedeAzienda.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoSedeAziendaDao {

	/** 
	 * Returns all rows from the TAIF_D_TIPO_SEDE_AZIENDA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoSedeAziendaDto findByPrimaryKey(TaifDTipoSedeAziendaPk pk) throws TaifDTipoSedeAziendaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_SEDE_AZIENDA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoSedeAziendaDto> findAll() throws TaifDTipoSedeAziendaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDTipoSedeAziendaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoSedeAziendaDaoException;

}
