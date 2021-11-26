/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dao.impl;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.dao.mapper.*;
import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.taifweb.qbe.*;
import it.csi.taif.taifweb.business.dao.taifweb.metadata.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import it.csi.taif.taifweb.business.dao.impl.*;
import it.csi.taif.taifweb.business.dao.util.*;
import it.csi.taif.taifweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import it.csi.util.performance.StopWatch;
import org.apache.log4j.Logger;
import java.util.Map;
import java.util.TreeMap;

/*PROTECTED REGION ID(R-1080235567) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.taif.taifweb.util.ConvertUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDCategoriaImpresa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - categoriaImpresaVisible (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDCategoriaImpresaDaoImpl extends AbstractDAO implements TaifDCategoriaImpresaDao {
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE);
	/**
	 * Il DAO utilizza JDBC template per l'implementazione delle query.
	 * @generated
	 */
	protected NamedParameterJdbcTemplate jdbcTemplate;

	/**
	 * Imposta il JDBC template utilizato per l'implementazione delle query
	 * @generated
	 */
	public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Cache del DAO.
	 * @generated
	 */
	protected SimpleCache cache;

	/**
	 * Restutuisce la cache del DAO
	 * @generated
	 */
	public SimpleCache getCache() {
		return cache;
	}

	/**
	 * Imposta la cache del DAO
	 * @param cache
	 * @generated
	 */
	public void setCache(SimpleCache cache) {
		this.cache = cache;
	}

	/**
	 * Metodo di inserimento del DAO taifDCategoriaImpresa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDCategoriaImpresaPk
	 * @generated
	 */

	public TaifDCategoriaImpresaPk insert(TaifDCategoriaImpresaDto dto)

	{
		LOG.debug("[TaifDCategoriaImpresaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CATEGORIA,CATEGORIA_IMPRESA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_CATEGORIA , :CATEGORIA_IMPRESA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA]
		params.addValue("ID_CATEGORIA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CATEGORIA_IMPRESA]
		params.addValue("CATEGORIA_IMPRESA", dto.getCategoriaImpresa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdCategoria(newKey);
		LOG.debug("[TaifDCategoriaImpresaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_CATEGORIA_IMPRESA table.
	 * @generated
	 */

	public void delete(TaifDCategoriaImpresaPk pk) throws TaifDCategoriaImpresaDaoException {
		LOG.debug("[TaifDCategoriaImpresaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_CATEGORIA = :ID_CATEGORIA ";

		if (pk == null) {
			LOG.error("[TaifDCategoriaImpresaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDCategoriaImpresaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA]
		params.addValue("ID_CATEGORIA", pk.getIdCategoria(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDCategoriaImpresaDaoImpl::delete] END");
	}

	protected TaifDCategoriaImpresaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDCategoriaImpresaDaoRowMapper(null,
			TaifDCategoriaImpresaDto.class, this);

	protected TaifDCategoriaImpresaDaoRowMapper findAllRowMapper = new TaifDCategoriaImpresaDaoRowMapper(null,
			TaifDCategoriaImpresaDto.class, this);

	protected TaifDCategoriaImpresaDaoRowMapper categoriaImpresaVisibleRowMapper = new TaifDCategoriaImpresaDaoRowMapper(
			null, TaifDCategoriaImpresaCategoriaImpresaVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_CATEGORIA_IMPRESA";
	}

	/** 
	 * Returns all rows from the TAIF_D_CATEGORIA_IMPRESA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDCategoriaImpresaDto findByPrimaryKey(TaifDCategoriaImpresaPk pk)
			throws TaifDCategoriaImpresaDaoException {
		LOG.debug("[TaifDCategoriaImpresaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CATEGORIA,CATEGORIA_IMPRESA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_CATEGORIA = :ID_CATEGORIA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA]
		params.addValue("ID_CATEGORIA", pk.getIdCategoria(), java.sql.Types.INTEGER);

		List<TaifDCategoriaImpresaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDCategoriaImpresaDto res = (TaifDCategoriaImpresaDto) cache.get(pk);
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put(pk, list.get(0));
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaImpresaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDCategoriaImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaImpresaDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDCategoriaImpresaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_CATEGORIA_IMPRESA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDCategoriaImpresaDto> findAll() throws TaifDCategoriaImpresaDaoException {
		LOG.debug("[TaifDCategoriaImpresaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CATEGORIA,CATEGORIA_IMPRESA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDCategoriaImpresaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDCategoriaImpresaDto> res = (List<TaifDCategoriaImpresaDto>) cache
					.get("findAll_taifDCategoriaImpresa_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDCategoriaImpresa_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaImpresaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDCategoriaImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaImpresaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDCategoriaImpresaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder categoriaImpresaVisible con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaImpresaCategoriaImpresaVisibleDto> findCategoriaImpresaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDCategoriaImpresaDaoException {
		LOG.debug("[TaifDCategoriaImpresaDaoImpl::findCategoriaImpresaVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT impresa.ID_CATEGORIA as id, impresa.CATEGORIA_IMPRESA as categoria, impresa.MTD_ORDINAMENTO as ordin, impresa.MTD_FLG_VISIBILE as flagVis, impresa.MTD_FLG_ITA_FRA as flagIta");

		sql.append(" FROM TAIF_D_CATEGORIA_IMPRESA impresa");

		sql.append(" WHERE ");

		sql.append("impresa.mtd_flg_visibile=:visibile");
		/*PROTECTED REGION ID(R-1634032366) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		if (ConvertUtil.checkIsNullOrEmpty(input.getFlagItaFr())) {
			sql.append(" and impresa.mtd_flg_ita_fra=:flagItaFr");
			paramMap.addValue("flagItaFr", input.getFlagItaFr());
		}

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		/*PROTECTED REGION END*/

		List<TaifDCategoriaImpresaCategoriaImpresaVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, categoriaImpresaVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaImpresaDaoImpl::findCategoriaImpresaVisible] ERROR esecuzione query", ex);
			throw new TaifDCategoriaImpresaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaImpresaDaoImpl", "findCategoriaImpresaVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDCategoriaImpresaDaoImpl::findCategoriaImpresaVisible] END");
		}
		return list;
	}

}
