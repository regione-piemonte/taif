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
	 * Deletes a single row in the TAIF_D_STATO_PRATICA table.
	 * @generated
	 */

	public void delete(TaifDStatoPraticaPk pk) throws TaifDStatoPraticaDaoException;

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
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDStatoPraticaDaoException;

	/** 
		 * Implementazione del finder byFilterStatoPraticaIta con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaByFilterStatoPraticaItaDto> findByFilterStatoPraticaIta(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException;

	/** 
		 * Implementazione del finder byFilterStatoPraticaFra con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaByFilterStatoPraticaFraDto> findByFilterStatoPraticaFra(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException;

	/** 
		 * Implementazione del finder elencoStatiPraticaItalia con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaElencoStatiPraticaItaliaDto> findElencoStatiPraticaItalia(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException;

	/** 
		 * Implementazione del finder elencoStatiPraticaFrance con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaElencoStatiPraticaFranceDto> findElencoStatiPraticaFrance(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException;

	/** 
		 * Implementazione del finder elencoSottoStatiPraticaItalia con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto> findElencoSottoStatiPraticaItalia(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException;

	/** 
		 * Implementazione del finder elencoSottoStatiPraticaFrance con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaElencoSottoStatiPraticaFranceDto> findElencoSottoStatiPraticaFrance(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException;

}
