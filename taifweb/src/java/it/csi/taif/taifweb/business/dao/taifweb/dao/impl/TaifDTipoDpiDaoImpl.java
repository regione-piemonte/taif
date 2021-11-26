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

/*PROTECTED REGION ID(R-493988331) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoDpi.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisible (datagen::CustomFinder)
 *   - byDispVisible (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoDpiDaoImpl extends AbstractDAO implements TaifDTipoDpiDao {
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
	 * Metodo di inserimento del DAO taifDTipoDpi. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoDpiPk
	 * @generated
	 */

	public TaifDTipoDpiPk insert(TaifDTipoDpiDto dto)

	{
		LOG.debug("[TaifDTipoDpiDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_DPI,TIPO_DPI,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_TIPO_DPI , :TIPO_DPI , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_DPI]
		params.addValue("ID_TIPO_DPI", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_DPI]
		params.addValue("TIPO_DPI", dto.getTipoDpi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoDpi(newKey);
		LOG.debug("[TaifDTipoDpiDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TIPO_DPI table.
	 * @generated
	 */
	public void update(TaifDTipoDpiDto dto) throws TaifDTipoDpiDaoException {
		LOG.debug("[TaifDTipoDpiDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPO_DPI = :TIPO_DPI ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE  WHERE ID_TIPO_DPI = :ID_TIPO_DPI ";

		if (dto.getIdTipoDpi() == null) {
			LOG.error("[TaifDTipoDpiDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTipoDpiDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_DPI]
		params.addValue("ID_TIPO_DPI", dto.getIdTipoDpi(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_DPI]
		params.addValue("TIPO_DPI", dto.getTipoDpi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoDpiDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_DPI table.
	 * @generated
	 */

	public void delete(TaifDTipoDpiPk pk) throws TaifDTipoDpiDaoException {
		LOG.debug("[TaifDTipoDpiDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_DPI = :ID_TIPO_DPI ";

		if (pk == null) {
			LOG.error("[TaifDTipoDpiDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoDpiDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_DPI]
		params.addValue("ID_TIPO_DPI", pk.getIdTipoDpi(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoDpiDaoImpl::delete] END");
	}

	protected TaifDTipoDpiDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoDpiDaoRowMapper(null,
			TaifDTipoDpiDto.class, this);

	protected TaifDTipoDpiDaoRowMapper findAllRowMapper = new TaifDTipoDpiDaoRowMapper(null, TaifDTipoDpiDto.class,
			this);

	protected TaifDTipoDpiDaoRowMapper byVisibleRowMapper = new TaifDTipoDpiDaoRowMapper(null,
			TaifDTipoDpiByVisibleDto.class, this);

	protected TaifDTipoDpiDaoRowMapper byDispVisibleRowMapper = new TaifDTipoDpiDaoRowMapper(null,
			TaifDTipoDpiByDispVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_DPI";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_DPI table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoDpiDto findByPrimaryKey(TaifDTipoDpiPk pk) throws TaifDTipoDpiDaoException {
		LOG.debug("[TaifDTipoDpiDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_DPI,TIPO_DPI,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
				+ getTableName() + " WHERE ID_TIPO_DPI = :ID_TIPO_DPI ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_DPI]
		params.addValue("ID_TIPO_DPI", pk.getIdTipoDpi(), java.sql.Types.INTEGER);

		List<TaifDTipoDpiDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoDpiDto res = (TaifDTipoDpiDto) cache.get(pk);
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
			LOG.error("[TaifDTipoDpiDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoDpiDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoDpiDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_DPI.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoDpiDto> findAll() throws TaifDTipoDpiDaoException {
		LOG.debug("[TaifDTipoDpiDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_DPI,TIPO_DPI,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoDpiDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoDpiDto> res = (List<TaifDTipoDpiDto>) cache.get("findAll_taifDTipoDpi_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoDpi_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoDpiDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoDpiDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoDpiDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoDpiByVisibleDto> findByVisible(java.lang.Integer input) throws TaifDTipoDpiDaoException {
		LOG.debug("[TaifDTipoDpiDaoImpl::findByVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tipo.ID_TIPO_DPI as id, tipo.TIPO_DPI as tipo, tipo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_DPI tipo");

		sql.append(" WHERE ");

		sql.append("tipo.mtd_flg_visibile=:visibile ");
		/*PROTECTED REGION ID(R-591258572) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input);

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		/*PROTECTED REGION END*/

		List<TaifDTipoDpiByVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoDpiDaoImpl::findByVisible] ERROR esecuzione query", ex);
			throw new TaifDTipoDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoDpiDaoImpl", "findByVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoDpiDaoImpl::findByVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byDispVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoDpiByDispVisibleDto> findByDispVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.DispositiviFilter input) throws TaifDTipoDpiDaoException {
		LOG.debug("[TaifDTipoDpiDaoImpl::findByDispVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tipo.ID_TIPO_DPI as id, tipo.TIPO_DPI as tipo, tipo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_DPI tipo");

		sql.append(" WHERE ");

		sql.append("tipo.mtd_flg_visibile=:visibile and tipo.tipo_dpi=:tipoDpi");
		/*PROTECTED REGION ID(R663722998) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("tipoDpi", input.getTipoDpi());

		/*PROTECTED REGION END*/

		List<TaifDTipoDpiByDispVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byDispVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoDpiDaoImpl::findByDispVisible] ERROR esecuzione query", ex);
			throw new TaifDTipoDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoDpiDaoImpl", "findByDispVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoDpiDaoImpl::findByDispVisible] END");
		}
		return list;
	}

}
