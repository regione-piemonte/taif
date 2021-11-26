/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.impl;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.mapper.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.impl.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R1279656769) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDStatoOpfo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibileFra (datagen::CustomFinder)
 *   - byVisibileIta (datagen::CustomFinder)
 *   - byFilterVisible (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDStatoOpfoDaoImpl extends AbstractDAO implements TaifDStatoOpfoDao {
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
	 * Metodo di inserimento del DAO taifDStatoOpfo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDStatoOpfoPk
	 * @generated
	 */

	public TaifDStatoOpfoPk insert(TaifDStatoOpfoDto dto)

	{
		LOG.debug("[TaifDStatoOpfoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_STATO_OPFO,STATO_OPFO_ITA,STATO_OPFO_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_STATO_OPFO , :STATO_OPFO_ITA , :STATO_OPFO_FRA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_OPFO]
		params.addValue("ID_STATO_OPFO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [STATO_OPFO_ITA]
		params.addValue("STATO_OPFO_ITA", dto.getStatoOpfoIta(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [STATO_OPFO_FRA]
		params.addValue("STATO_OPFO_FRA", dto.getStatoOpfoFra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdStatoOpfo(newKey);
		LOG.debug("[TaifDStatoOpfoDaoImpl::insert] END");
		return dto.createPk();

	}

	protected TaifDStatoOpfoDaoRowMapper findByPrimaryKeyRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoDto.class, this);

	protected TaifDStatoOpfoDaoRowMapper findAllRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoDto.class, this);

	protected TaifDStatoOpfoDaoRowMapper byVisibileFraRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoByVisibileFraDto.class, this);

	protected TaifDStatoOpfoDaoRowMapper byVisibileItaRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoByVisibileItaDto.class, this);

	protected TaifDStatoOpfoDaoRowMapper byFilterVisibleRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoByFilterVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_STATO_OPFO";
	}

	/** 
	 * Returns all rows from the TAIF_D_STATO_OPFO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDStatoOpfoDto findByPrimaryKey(TaifDStatoOpfoPk pk) throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_OPFO,STATO_OPFO_ITA,STATO_OPFO_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
						+ getTableName() + " WHERE ID_STATO_OPFO = :ID_STATO_OPFO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_OPFO]
		params.addValue("ID_STATO_OPFO", pk.getIdStatoOpfo(), java.sql.Types.INTEGER);

		List<TaifDStatoOpfoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoOpfoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDStatoOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoOpfoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoOpfoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_STATO_OPFO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDStatoOpfoDto> findAll() throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_OPFO,STATO_OPFO_ITA,STATO_OPFO_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDStatoOpfoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoOpfoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDStatoOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoOpfoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoOpfoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibileFra con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoByVisibileFraDto> findByVisibileFra(java.lang.Integer input)
			throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::findByVisibileFra] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoOperatore.ID_STATO_OPFO as idStatoOperatore, statoOperatore.STATO_OPFO_FRA as statoOperatoreFra, statoOperatore.MTD_ORDINAMENTO as idOrdin");

		sql.append(" FROM TAIF_D_STATO_OPFO statoOperatore");

		sql.append(" WHERE ");

		sql.append("statoOperatore.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R1811974206) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input);

		/*PROTECTED REGION END*/

		List<TaifDStatoOpfoByVisibileFraDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileFraRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoOpfoDaoImpl::findByVisibileFra] ERROR esecuzione query", ex);
			throw new TaifDStatoOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoOpfoDaoImpl", "findByVisibileFra", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoOpfoDaoImpl::findByVisibileFra] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibileIta con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoByVisibileItaDto> findByVisibileIta(java.lang.Integer input)
			throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::findByVisibileIta] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoOperatore.ID_STATO_OPFO as idStatoOperatore, statoOperatore.STATO_OPFO_ITA as statoOperatoreIta, statoOperatore.MTD_ORDINAMENTO as idOrdin");

		sql.append(" FROM TAIF_D_STATO_OPFO statoOperatore");

		sql.append(" WHERE ");

		sql.append("statoOperatore.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R225477981) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input);

		/*PROTECTED REGION END*/

		List<TaifDStatoOpfoByVisibileItaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileItaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoOpfoDaoImpl::findByVisibileIta] ERROR esecuzione query", ex);
			throw new TaifDStatoOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoOpfoDaoImpl", "findByVisibileIta", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoOpfoDaoImpl::findByVisibileIta] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::findByFilterVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoOperatore.ID_STATO_OPFO as idStatoOperatore, statoOperatore.STATO_OPFO_ITA as statoOperatoreIta, statoOperatore.MTD_ORDINAMENTO as idOrdin, statoOperatore.STATO_OPFO_FRA as statoOperatoreFra");

		sql.append(" FROM TAIF_D_STATO_OPFO statoOperatore");

		sql.append(" WHERE ");

		sql.append("statoOperatore.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R-2011911376) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifDStatoOpfoByFilterVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoOpfoDaoImpl::findByFilterVisible] ERROR esecuzione query", ex);
			throw new TaifDStatoOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoOpfoDaoImpl", "findByFilterVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoOpfoDaoImpl::findByFilterVisible] END");
		}
		return list;
	}

}
