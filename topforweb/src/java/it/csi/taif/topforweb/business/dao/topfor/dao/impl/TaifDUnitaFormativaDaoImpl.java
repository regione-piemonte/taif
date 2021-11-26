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

/*PROTECTED REGION ID(R196252485) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.taif.topforweb.util.ConvertUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDUnitaFormativa.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFilterVisibleSoggettoGestore (datagen::CustomFinder)
 *   - byFilterAgenziaFormativa (datagen::CustomFinder)
 *   - byAmbitoFormativo (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDUnitaFormativaDaoImpl extends AbstractDAO implements TaifDUnitaFormativaDao {
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

	protected TaifDUnitaFormativaDaoRowMapper findAllRowMapper = new TaifDUnitaFormativaDaoRowMapper(null,
			TaifDUnitaFormativaDto.class, this);

	protected TaifDUnitaFormativaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDUnitaFormativaDaoRowMapper(null,
			TaifDUnitaFormativaDto.class, this);

	protected TaifDUnitaFormativaDaoRowMapper byFilterVisibleSoggettoGestoreRowMapper = new TaifDUnitaFormativaDaoRowMapper(
			null, TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto.class, this);

	protected TaifDUnitaFormativaDaoRowMapper byFilterAgenziaFormativaRowMapper = new TaifDUnitaFormativaDaoRowMapper(
			null, TaifDUnitaFormativaByFilterAgenziaFormativaDto.class, this);

	protected TaifDUnitaFormativaDaoRowMapper byAmbitoFormativoRowMapper = new TaifDUnitaFormativaDaoRowMapper(null,
			TaifDUnitaFormativaByAmbitoFormativoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_UNITA_FORMATIVA";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_UNITA_FORMATIVA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDUnitaFormativaDto> findAll() throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_UNITA_FORMATIVA,FK_AMBITO_FORMATIVO,FK_SOGGETTO_GESTORE,UNITA_FORMATIVA,SIGLA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDUnitaFormativaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDUnitaFormativaDto> res = (List<TaifDUnitaFormativaDto>) cache
					.get("findAll_taifDUnitaFormativa_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDUnitaFormativa_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaFormativaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDUnitaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaFormativaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDUnitaFormativaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the TAIF_D_UNITA_FORMATIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDUnitaFormativaDto findByPrimaryKey(TaifDUnitaFormativaPk pk) throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_UNITA_FORMATIVA,FK_AMBITO_FORMATIVO,FK_SOGGETTO_GESTORE,UNITA_FORMATIVA,SIGLA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_UNITA_FORMATIVA = :ID_UNITA_FORMATIVA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_FORMATIVA]
		params.addValue("ID_UNITA_FORMATIVA", pk.getIdUnitaFormativa(), java.sql.Types.INTEGER);

		List<TaifDUnitaFormativaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDUnitaFormativaDto res = (TaifDUnitaFormativaDto) cache.get(pk);
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
			LOG.error("[TaifDUnitaFormativaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDUnitaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaFormativaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDUnitaFormativaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder byFilterVisibleSoggettoGestore con Qdef
		 * @generated
		 */

	public List<TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto> findByFilterVisibleSoggettoGestore(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::findByFilterVisibleSoggettoGestore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT unitaFormativa.ID_UNITA_FORMATIVA as idUnitaFormativa, unitaFormativa.UNITA_FORMATIVA as denominazioneUnitaFormativa, unitaFormativa.MTD_ORDINAMENTO as ordin, unitaFormativa.SIGLA as sigla");

		sql.append(" FROM TAIF_D_UNITA_FORMATIVA unitaFormativa");

		sql.append(" WHERE ");

		sql.append("1=1");
		/*PROTECTED REGION ID(R1970476050) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND  unitaFormativa.MTD_FLG_VISIBILE = 1");

		if (input.getIdSoggettoGestore() != 0) {
			sql.append(" AND  unitaFormativa.fk_soggetto_gestore = :idSoggettoGestore");
			paramMap.addValue("idSoggettoGestore", input.getIdSoggettoGestore());
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getFlagItaFr())) {
			sql.append(" AND  unitaFormativa.mtd_flg_ita_fra = :flagItaFr");
			paramMap.addValue("flagItaFr", input.getFlagItaFr());
		}

		sql.append(" order by unitaFormativa.MTD_ORDINAMENTO");

		/*PROTECTED REGION END*/

		List<TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterVisibleSoggettoGestoreRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaFormativaDaoImpl::findByFilterVisibleSoggettoGestore] ERROR esecuzione query", ex);
			throw new TaifDUnitaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaFormativaDaoImpl", "findByFilterVisibleSoggettoGestore",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifDUnitaFormativaDaoImpl::findByFilterVisibleSoggettoGestore] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterAgenziaFormativa con Qdef
		 * @generated
		 */

	public List<TaifDUnitaFormativaByFilterAgenziaFormativaDto> findByFilterAgenziaFormativa(
			it.csi.taif.topforweb.business.dao.topfor.filter.AgenziaFormativaFilter input)
			throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::findByFilterAgenziaFormativa] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT unitaFormativa.ID_UNITA_FORMATIVA as idUnitaFormativa, unitaFormativa.UNITA_FORMATIVA as dsUnitaFormativa, unitaFormativa.SIGLA as sigla");

		sql.append(
				" FROM TAIF_T_CORSO corso, TAIF_D_UNITA_FORMATIVA unitaFormativa, TAIF_T_AGENZIA_FORMATIVA agenziaFormativa");

		sql.append(" WHERE ");

		sql.append(
				"unitaFormativa.ID_UNITA_FORMATIVA = corso.FK_UNITA_FORMATIVA AND corso.FK_AGENZIA_FORMATIVA = agenziaFormativa.ID_AGENZIA_FORMATIVA");

		sql.append(" AND ");

		sql.append("agenziaFormativa.id_agenzia_formativa = :idAgenziaFormativa");
		/*PROTECTED REGION ID(R411988291) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" order by idUnitaFormativa");

		String queryComplete = sql.toString().replace("SELECT", "SELECT DISTINCT");
		sql = new StringBuilder(queryComplete);

		if (ConvertUtil.checkIsNullOrEmpty(input.getIdAgenziaFormativa())) {

			paramMap.addValue("idAgenziaFormativa", new Integer(input.getIdAgenziaFormativa()));
		}

		/*PROTECTED REGION END*/

		List<TaifDUnitaFormativaByFilterAgenziaFormativaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterAgenziaFormativaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaFormativaDaoImpl::findByFilterAgenziaFormativa] ERROR esecuzione query", ex);
			throw new TaifDUnitaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaFormativaDaoImpl", "findByFilterAgenziaFormativa", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDUnitaFormativaDaoImpl::findByFilterAgenziaFormativa] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAmbitoFormativo con Qdef
		 * @generated
		 */

	public List<TaifDUnitaFormativaByAmbitoFormativoDto> findByAmbitoFormativo(int idAmbitoFormativo,
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::findByAmbitoFormativo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT unitaFormativa.ID_UNITA_FORMATIVA as idUnitaFormativa, unitaFormativa.UNITA_FORMATIVA as denominazioneUnitaFormativa, unitaFormativa.MTD_ORDINAMENTO as ordin, unitaFormativa.SIGLA as sigla");

		sql.append(" FROM TAIF_D_UNITA_FORMATIVA unitaFormativa");

		sql.append(" WHERE ");

		sql.append("unitaFormativa.fk_ambito_formativo = :fk_ambito_formativo");
		/*PROTECTED REGION ID(R-1381165730) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		paramMap.addValue("fk_ambito_formativo", idAmbitoFormativo);

		sql.append(" AND  unitaFormativa.MTD_FLG_VISIBILE = 1");

		if (input.getIdSoggettoGestore() != 0) {
			sql.append(" AND  unitaFormativa.fk_soggetto_gestore = :idSoggettoGestore");
			paramMap.addValue("idSoggettoGestore", input.getIdSoggettoGestore());
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getFlagItaFr())) {
			sql.append(" AND  unitaFormativa.mtd_flg_ita_fra = :flagItaFr");
			paramMap.addValue("flagItaFr", input.getFlagItaFr());
		}

		sql.append(" order by unitaFormativa.MTD_ORDINAMENTO");

		/*PROTECTED REGION END*/

		List<TaifDUnitaFormativaByAmbitoFormativoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAmbitoFormativoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaFormativaDaoImpl::findByAmbitoFormativo] ERROR esecuzione query", ex);
			throw new TaifDUnitaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaFormativaDaoImpl", "findByAmbitoFormativo", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDUnitaFormativaDaoImpl::findByAmbitoFormativo] END");
		}
		return list;
	}

}
