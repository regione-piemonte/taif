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

/*PROTECTED REGION ID(R-951672405) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifCnfParamApimgr.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - parametriValidi (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifCnfParamApimgrDaoImpl extends AbstractDAO implements TaifCnfParamApimgrDao {
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

	protected TaifCnfParamApimgrDaoRowMapper findByPrimaryKeyRowMapper = new TaifCnfParamApimgrDaoRowMapper(null,
			TaifCnfParamApimgrDto.class, this);

	protected TaifCnfParamApimgrDaoRowMapper parametriValidiRowMapper = new TaifCnfParamApimgrDaoRowMapper(null,
			TaifCnfParamApimgrDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_PARAM_APIMGR";
	}

	/** 
	 * Returns all rows from the TAIF_CNF_PARAM_APIMGR table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfParamApimgrDto findByPrimaryKey(TaifCnfParamApimgrPk pk) throws TaifCnfParamApimgrDaoException {
		LOG.debug("[TaifCnfParamApimgrDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CONFIG_PARAM_APIMGR,CONSUMER_KEY,CONSUMER_SECRET,DATA_INIZIO_VALIDITA,DATA_FINE_VALIDITA FROM "
						+ getTableName() + " WHERE ID_CONFIG_PARAM_APIMGR = :ID_CONFIG_PARAM_APIMGR ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONFIG_PARAM_APIMGR]
		params.addValue("ID_CONFIG_PARAM_APIMGR", pk.getIdConfigParamApimgr(), java.sql.Types.INTEGER);

		List<TaifCnfParamApimgrDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifCnfParamApimgrDto res = (TaifCnfParamApimgrDto) cache.get(pk);
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
			LOG.error("[TaifCnfParamApimgrDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifCnfParamApimgrDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfParamApimgrDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfParamApimgrDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder parametriValidi
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfParamApimgrDto> findParametriValidi(java.lang.String input)
			throws TaifCnfParamApimgrDaoException {
		LOG.debug("[TaifCnfParamApimgrDaoImpl::findParametriValidi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_CONFIG_PARAM_APIMGR,CONSUMER_KEY,CONSUMER_SECRET,DATA_INIZIO_VALIDITA,DATA_FINE_VALIDITA ");
		sql.append(" FROM TAIF_CNF_PARAM_APIMGR");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1960003160) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("DATA_FINE_VALIDITA IS NULL ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-505669566) ENABLED START*/
		//***aggiungere tutte le condizioni

		/*PROTECTED REGION END*/
		List<TaifCnfParamApimgrDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, parametriValidiRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfParamApimgrDaoImpl::findParametriValidi] esecuzione query", ex);
			throw new TaifCnfParamApimgrDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfParamApimgrDaoImpl", "findParametriValidi", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifCnfParamApimgrDaoImpl::findParametriValidi] END");
		}
		return list;
	}

}
