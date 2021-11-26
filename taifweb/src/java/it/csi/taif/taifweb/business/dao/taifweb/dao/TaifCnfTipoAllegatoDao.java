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
 * Interfaccia pubblica del DAO taifCnfTipoAllegato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifCnfTipoAllegatoDao {

	/** 
	 * Returns all rows from the TAIF_CNF_TIPO_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfTipoAllegatoDto findByPrimaryKey(TaifCnfTipoAllegatoPk pk) throws TaifCnfTipoAllegatoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_TIPO_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfTipoAllegatoDto> findAll() throws TaifCnfTipoAllegatoDaoException;

	/** 
		 * Implementazione del finder byProcedura con Qdef
		 * @generated
		 */

	public List<TaifCnfTipoAllegatoByProceduraDto> findByProcedura(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifCnfTipoAllegatoDaoException;

	/** 
		 * Implementazione del finder byAllegatoFilter con Qdef
		 * @generated
		 */

	public List<TaifCnfTipoAllegatoByAllegatoFilterDto> findByAllegatoFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifCnfTipoAllegatoDaoException;

	/** 
		 * Implementazione del finder allegatiObbligatori con Qdef
		 * @generated
		 */

	public List<TaifCnfTipoAllegatoAllegatiObbligatoriDto> findAllegatiObbligatori(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifCnfTipoAllegatoDaoException;

}
