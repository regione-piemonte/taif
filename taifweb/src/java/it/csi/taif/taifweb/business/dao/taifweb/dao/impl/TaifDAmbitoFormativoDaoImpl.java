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

/*PROTECTED REGION ID(R1811194365) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDAmbitoFormativo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisible (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDAmbitoFormativoDaoImpl extends AbstractDAO implements TaifDAmbitoFormativoDao {
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
	 * Metodo di inserimento del DAO taifDAmbitoFormativo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAmbitoFormativoPk
	 * @generated
	 */

	public TaifDAmbitoFormativoPk insert(TaifDAmbitoFormativoDto dto)

	{
		LOG.debug("[TaifDAmbitoFormativoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AMBITO_FORMATIVO,AMBITO_FORMATIVO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_AMBITO_FORMATIVO , :AMBITO_FORMATIVO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AMBITO_FORMATIVO]
		params.addValue("ID_AMBITO_FORMATIVO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [AMBITO_FORMATIVO]
		params.addValue("AMBITO_FORMATIVO", dto.getAmbitoFormativo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAmbitoFormativo(newKey);
		LOG.debug("[TaifDAmbitoFormativoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_AMBITO_FORMATIVO table.
	 * @generated
	 */

	public void delete(TaifDAmbitoFormativoPk pk) throws TaifDAmbitoFormativoDaoException {
		LOG.debug("[TaifDAmbitoFormativoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_AMBITO_FORMATIVO = :ID_AMBITO_FORMATIVO ";

		if (pk == null) {
			LOG.error("[TaifDAmbitoFormativoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDAmbitoFormativoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AMBITO_FORMATIVO]
		params.addValue("ID_AMBITO_FORMATIVO", pk.getIdAmbitoFormativo(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDAmbitoFormativoDaoImpl::delete] END");
	}

	protected TaifDAmbitoFormativoDaoRowMapper findByPrimaryKeyRowMapper = new TaifDAmbitoFormativoDaoRowMapper(null,
			TaifDAmbitoFormativoDto.class, this);

	protected TaifDAmbitoFormativoDaoRowMapper findAllRowMapper = new TaifDAmbitoFormativoDaoRowMapper(null,
			TaifDAmbitoFormativoDto.class, this);

	protected TaifDAmbitoFormativoDaoRowMapper byVisibleRowMapper = new TaifDAmbitoFormativoDaoRowMapper(null,
			TaifDAmbitoFormativoByVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_AMBITO_FORMATIVO";
	}

	/** 
	 * Returns all rows from the TAIF_D_AMBITO_FORMATIVO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAmbitoFormativoDto findByPrimaryKey(TaifDAmbitoFormativoPk pk) throws TaifDAmbitoFormativoDaoException {
		LOG.debug("[TaifDAmbitoFormativoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AMBITO_FORMATIVO,AMBITO_FORMATIVO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_AMBITO_FORMATIVO = :ID_AMBITO_FORMATIVO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AMBITO_FORMATIVO]
		params.addValue("ID_AMBITO_FORMATIVO", pk.getIdAmbitoFormativo(), java.sql.Types.INTEGER);

		List<TaifDAmbitoFormativoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDAmbitoFormativoDto res = (TaifDAmbitoFormativoDto) cache.get(pk);
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
			LOG.error("[TaifDAmbitoFormativoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDAmbitoFormativoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAmbitoFormativoDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDAmbitoFormativoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_AMBITO_FORMATIVO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAmbitoFormativoDto> findAll() throws TaifDAmbitoFormativoDaoException {
		LOG.debug("[TaifDAmbitoFormativoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AMBITO_FORMATIVO,AMBITO_FORMATIVO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDAmbitoFormativoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDAmbitoFormativoDto> res = (List<TaifDAmbitoFormativoDto>) cache
					.get("findAll_taifDAmbitoFormativo_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDAmbitoFormativo_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAmbitoFormativoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDAmbitoFormativoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAmbitoFormativoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAmbitoFormativoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisible con Qdef
		 * @generated
		 */

	public List<TaifDAmbitoFormativoByVisibleDto> findByVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAmbitoFormativoDaoException {
		LOG.debug("[TaifDAmbitoFormativoDaoImpl::findByVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT amb.ID_AMBITO_FORMATIVO as id, amb.AMBITO_FORMATIVO as ambito, amb.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_AMBITO_FORMATIVO amb");

		sql.append(" WHERE ");

		sql.append("amb.mtd_flg_visibile=:visibile and amb.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R55224384) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDAmbitoFormativoByVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAmbitoFormativoDaoImpl::findByVisible] ERROR esecuzione query", ex);
			throw new TaifDAmbitoFormativoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAmbitoFormativoDaoImpl", "findByVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAmbitoFormativoDaoImpl::findByVisible] END");
		}
		return list;
	}

}
