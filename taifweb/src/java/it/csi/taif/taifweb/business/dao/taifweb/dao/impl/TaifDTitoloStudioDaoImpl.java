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

/*PROTECTED REGION ID(R797911025) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTitoloStudio.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTitoloStudioDaoImpl extends AbstractDAO implements TaifDTitoloStudioDao {
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

	protected TaifDTitoloStudioDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTitoloStudioDaoRowMapper(null,
			TaifDTitoloStudioDto.class, this);

	protected TaifDTitoloStudioDaoRowMapper findAllRowMapper = new TaifDTitoloStudioDaoRowMapper(null,
			TaifDTitoloStudioDto.class, this);

	protected TaifDTitoloStudioDaoRowMapper byFilterRowMapper = new TaifDTitoloStudioDaoRowMapper(null,
			TaifDTitoloStudioByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TITOLO_STUDIO";
	}

	/** 
	 * Returns all rows from the TAIF_D_TITOLO_STUDIO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTitoloStudioDto findByPrimaryKey(TaifDTitoloStudioPk pk) throws TaifDTitoloStudioDaoException {
		LOG.debug("[TaifDTitoloStudioDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TITOLO_STUDIO,TITOLO_STUDIO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TITOLO_STUDIO = :ID_TITOLO_STUDIO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TITOLO_STUDIO]
		params.addValue("ID_TITOLO_STUDIO", pk.getIdTitoloStudio(), java.sql.Types.INTEGER);

		List<TaifDTitoloStudioDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTitoloStudioDto res = (TaifDTitoloStudioDto) cache.get(pk);
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
			LOG.error("[TaifDTitoloStudioDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTitoloStudioDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTitoloStudioDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTitoloStudioDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TITOLO_STUDIO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTitoloStudioDto> findAll() throws TaifDTitoloStudioDaoException {
		LOG.debug("[TaifDTitoloStudioDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TITOLO_STUDIO,TITOLO_STUDIO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTitoloStudioDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTitoloStudioDto> res = (List<TaifDTitoloStudioDto>) cache.get("findAll_taifDTitoloStudio_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTitoloStudio_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTitoloStudioDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTitoloStudioDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTitoloStudioDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTitoloStudioDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDTitoloStudioByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTitoloStudioDaoException {
		LOG.debug("[TaifDTitoloStudioDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT studio.ID_TITOLO_STUDIO as id, studio.TITOLO_STUDIO as titolo, studio.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TITOLO_STUDIO studio");

		sql.append(" WHERE ");

		sql.append("studio.MTD_FLG_VISIBILE=:visibile and studio.MTD_FLG_ITA_FRA=:flagItFr");
		/*PROTECTED REGION ID(R477471814) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTitoloStudioByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTitoloStudioDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDTitoloStudioDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTitoloStudioDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTitoloStudioDaoImpl::findByFilter] END");
		}
		return list;
	}

}
