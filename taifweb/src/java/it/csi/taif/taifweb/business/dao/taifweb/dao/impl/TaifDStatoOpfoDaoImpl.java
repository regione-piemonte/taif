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

/*PROTECTED REGION ID(R1951345869) ENABLED START*/
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
 *   - statoOpfoItaVisible (datagen::CustomFinder)
 *   - statoOpfoFraVisible (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
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

	/** 
	 * Updates a single row in the TAIF_D_STATO_OPFO table.
	 * @generated
	 */
	public void update(TaifDStatoOpfoDto dto) throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET STATO_OPFO_ITA = :STATO_OPFO_ITA ,STATO_OPFO_FRA = :STATO_OPFO_FRA ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE  WHERE ID_STATO_OPFO = :ID_STATO_OPFO ";

		if (dto.getIdStatoOpfo() == null) {
			LOG.error("[TaifDStatoOpfoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDStatoOpfoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_OPFO]
		params.addValue("ID_STATO_OPFO", dto.getIdStatoOpfo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [STATO_OPFO_ITA]
		params.addValue("STATO_OPFO_ITA", dto.getStatoOpfoIta(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [STATO_OPFO_FRA]
		params.addValue("STATO_OPFO_FRA", dto.getStatoOpfoFra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDStatoOpfoDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_STATO_OPFO table.
	 * @generated
	 */

	public void delete(TaifDStatoOpfoPk pk) throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_STATO_OPFO = :ID_STATO_OPFO ";

		if (pk == null) {
			LOG.error("[TaifDStatoOpfoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDStatoOpfoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_OPFO]
		params.addValue("ID_STATO_OPFO", pk.getIdStatoOpfo(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDStatoOpfoDaoImpl::delete] END");
	}

	protected TaifDStatoOpfoDaoRowMapper findByPrimaryKeyRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoDto.class, this);

	protected TaifDStatoOpfoDaoRowMapper findAllRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoDto.class, this);

	protected TaifDStatoOpfoDaoRowMapper statoOpfoItaVisibleRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoStatoOpfoItaVisibleDto.class, this);

	protected TaifDStatoOpfoDaoRowMapper statoOpfoFraVisibleRowMapper = new TaifDStatoOpfoDaoRowMapper(null,
			TaifDStatoOpfoStatoOpfoFraVisibleDto.class, this);

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
			TaifDStatoOpfoDto res = (TaifDStatoOpfoDto) cache.get(pk);
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

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDStatoOpfoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDStatoOpfoDto> res = (List<TaifDStatoOpfoDto>) cache.get("findAll_taifDStatoOpfo_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDStatoOpfo_data", list);
				}
			}
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
		 * Implementazione del finder statoOpfoItaVisible con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoStatoOpfoItaVisibleDto> findStatoOpfoItaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::findStatoOpfoItaVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT opfo.ID_STATO_OPFO as id, opfo.STATO_OPFO_ITA as it, opfo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_OPFO opfo");

		sql.append(" WHERE ");

		sql.append("opfo.mtd_flg_visibile=:visibile ");
		/*PROTECTED REGION ID(R-193913678) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDStatoOpfoStatoOpfoItaVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, statoOpfoItaVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoOpfoDaoImpl::findStatoOpfoItaVisible] ERROR esecuzione query", ex);
			throw new TaifDStatoOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoOpfoDaoImpl", "findStatoOpfoItaVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoOpfoDaoImpl::findStatoOpfoItaVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder statoOpfoFraVisible con Qdef
		 * @generated
		 */

	public List<TaifDStatoOpfoStatoOpfoFraVisibleDto> findStatoOpfoFraVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDStatoOpfoDaoException {
		LOG.debug("[TaifDStatoOpfoDaoImpl::findStatoOpfoFraVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT opfo.ID_STATO_OPFO as id, opfo.STATO_OPFO_FRA as it, opfo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_OPFO opfo");

		sql.append(" WHERE ");

		sql.append("opfo.mtd_flg_visibile=:visibile ");
		/*PROTECTED REGION ID(R589515441) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		/*PROTECTED REGION END*/

		List<TaifDStatoOpfoStatoOpfoFraVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, statoOpfoFraVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoOpfoDaoImpl::findStatoOpfoFraVisible] ERROR esecuzione query", ex);
			throw new TaifDStatoOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoOpfoDaoImpl", "findStatoOpfoFraVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoOpfoDaoImpl::findStatoOpfoFraVisible] END");
		}
		return list;
	}

}
