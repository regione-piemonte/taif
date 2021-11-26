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
 * Interfaccia pubblica del DAO taifDFormaGiuridica.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDFormaGiuridicaDao {

	/** 
	 * Returns all rows from the TAIF_D_FORMA_GIURIDICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDFormaGiuridicaDto findByPrimaryKey(TaifDFormaGiuridicaPk pk) throws TaifDFormaGiuridicaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_FORMA_GIURIDICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDFormaGiuridicaDto> findAll() throws TaifDFormaGiuridicaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDFormaGiuridicaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.FormaGiuridicaFilter input)
			throws TaifDFormaGiuridicaDaoException;

	/** 
		 * Implementazione del finder byFormaGiuridica con Qdef
		 * @generated
		 */

	public List<TaifDFormaGiuridicaByFormaGiuridicaDto> findByFormaGiuridica(
			it.csi.taif.taifweb.business.dao.taifweb.filter.FormaGiuridicaFilter input)
			throws TaifDFormaGiuridicaDaoException;

	/** 
	 * Implementazione del finder  query-by-example
	 * @generated
	 */
	public List<TaifDFormaGiuridicaDto> findByExamples(
			ArrayList<it.csi.taif.taifweb.business.dao.taifweb.qbe.TaifDFormaGiuridicaExample> positive,
			ArrayList<it.csi.taif.taifweb.business.dao.taifweb.qbe.TaifDFormaGiuridicaExample> negative)
			throws TaifDFormaGiuridicaDaoException;
}
