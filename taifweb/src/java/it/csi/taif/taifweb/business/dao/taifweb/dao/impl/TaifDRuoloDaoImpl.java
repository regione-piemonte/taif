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

/*PROTECTED REGION ID(R-1484607071) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDRuolo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - byPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibile (datagen::CustomFinder)
 *   - byRuolo (datagen::CustomFinder)
 *   - byidRuolo (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDRuoloDaoImpl extends AbstractDAO implements TaifDRuoloDao {
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
	 * Metodo di inserimento del DAO taifDRuolo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDRuoloPk
	 * @generated
	 */

	public TaifDRuoloPk insert(TaifDRuoloDto dto)

	{
		LOG.debug("[TaifDRuoloDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_RUOLO,RUOLO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_RUOLO , :RUOLO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO]
		params.addValue("ID_RUOLO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [RUOLO]
		params.addValue("RUOLO", dto.getRuolo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdRuolo(newKey);
		LOG.debug("[TaifDRuoloDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_RUOLO table.
	 * @generated
	 */
	public void update(TaifDRuoloDto dto) throws TaifDRuoloDaoException {
		LOG.debug("[TaifDRuoloDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET RUOLO = :RUOLO ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE  WHERE ID_RUOLO = :ID_RUOLO ";

		if (dto.getIdRuolo() == null) {
			LOG.error("[TaifDRuoloDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDRuoloDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO]
		params.addValue("ID_RUOLO", dto.getIdRuolo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [RUOLO]
		params.addValue("RUOLO", dto.getRuolo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDRuoloDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_RUOLO table.
	 * @generated
	 */

	public void delete(TaifDRuoloPk pk) throws TaifDRuoloDaoException {
		LOG.debug("[TaifDRuoloDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_RUOLO = :ID_RUOLO ";

		if (pk == null) {
			LOG.error("[TaifDRuoloDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDRuoloDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO]
		params.addValue("ID_RUOLO", pk.getIdRuolo(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDRuoloDaoImpl::delete] END");
	}

	protected TaifDRuoloDaoRowMapper byPrimaryKeyRowMapper = new TaifDRuoloDaoRowMapper(null, TaifDRuoloDto.class,
			this);

	protected TaifDRuoloDaoRowMapper findAllRowMapper = new TaifDRuoloDaoRowMapper(null, TaifDRuoloDto.class, this);

	protected TaifDRuoloDaoRowMapper byVisibileRowMapper = new TaifDRuoloDaoRowMapper(null,
			TaifDRuoloByVisibileDto.class, this);

	protected TaifDRuoloDaoRowMapper byRuoloRowMapper = new TaifDRuoloDaoRowMapper(null, TaifDRuoloByRuoloDto.class,
			this);

	protected TaifDRuoloDaoRowMapper byidRuoloRowMapper = new TaifDRuoloDaoRowMapper(null, TaifDRuoloByidRuoloDto.class,
			this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_RUOLO";
	}

	/** 
	 * Returns all rows from the TAIF_D_RUOLO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDRuoloDto findByPrimaryKey(TaifDRuoloPk pk) throws TaifDRuoloDaoException {
		LOG.debug("[TaifDRuoloDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_RUOLO,RUOLO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
				+ getTableName() + " WHERE ID_RUOLO = :ID_RUOLO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RUOLO]
		params.addValue("ID_RUOLO", pk.getIdRuolo(), java.sql.Types.INTEGER);

		List<TaifDRuoloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDRuoloDto res = (TaifDRuoloDto) cache.get(pk);
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, byPrimaryKeyRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put(pk, list.get(0));
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDRuoloDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDRuoloDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDRuoloDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_RUOLO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDRuoloDto> findAll() throws TaifDRuoloDaoException {
		LOG.debug("[TaifDRuoloDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_RUOLO,RUOLO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDRuoloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDRuoloDto> res = (List<TaifDRuoloDto>) cache.get("findAll_taifDRuolo_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDRuolo_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDRuoloDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDRuoloDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDRuoloDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibile con Qdef
		 * @generated
		 */

	public List<TaifDRuoloByVisibileDto> findByVisibile(java.lang.Integer input) throws TaifDRuoloDaoException {
		LOG.debug("[TaifDRuoloDaoImpl::findByVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ruolo.ID_RUOLO as id, ruolo.RUOLO as ruol, ruolo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_RUOLO ruolo");

		sql.append(" WHERE ");

		sql.append("ruolo.mtd_flg_visibile=:visibile");
		/*PROTECTED REGION ID(R1737436999) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.intValue());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDRuoloByVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDRuoloDaoImpl::findByVisibile] ERROR esecuzione query", ex);
			throw new TaifDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDRuoloDaoImpl", "findByVisibile", "esecuzione query", sql.toString());
			LOG.debug("[TaifDRuoloDaoImpl::findByVisibile] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byRuolo con Qdef
		 * @generated
		 */

	public List<TaifDRuoloByRuoloDto> findByRuolo(it.csi.taif.taifweb.business.dao.taifweb.filter.RuoloFilter input)
			throws TaifDRuoloDaoException {
		LOG.debug("[TaifDRuoloDaoImpl::findByRuolo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ruolo.ID_RUOLO as idRuolo");

		sql.append(" FROM TAIF_D_RUOLO ruolo");

		sql.append(" WHERE ");

		sql.append("ruolo.RUOLO=:ruoloName and ruolo.MTD_FLAG_VISIBLE=:flagVisible");
		/*PROTECTED REGION ID(R185721201) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("ruoloName", input.getRuoloName());
		paramMap.addValue("flagVisible", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifDRuoloByRuoloDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byRuoloRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDRuoloDaoImpl::findByRuolo] ERROR esecuzione query", ex);
			throw new TaifDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDRuoloDaoImpl", "findByRuolo", "esecuzione query", sql.toString());
			LOG.debug("[TaifDRuoloDaoImpl::findByRuolo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byidRuolo con Qdef
		 * @generated
		 */

	public List<TaifDRuoloByidRuoloDto> findByidRuolo(it.csi.taif.taifweb.business.dao.taifweb.filter.RuoloFilter input)
			throws TaifDRuoloDaoException {
		LOG.debug("[TaifDRuoloDaoImpl::findByidRuolo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ruolo.ID_RUOLO as idRuolo, ruolo.RUOLO as ruoloPersona");

		sql.append(" FROM TAIF_D_RUOLO ruolo");

		sql.append(" WHERE ");

		sql.append("ruolo.ID_RUOLO=:idRuolo and ruolo.MTD_FLAG_VISIBLE=:flagVisible");
		/*PROTECTED REGION ID(R-739681588) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idRuolo", input.getIdRuolo());
		paramMap.addValue("flagVisible", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifDRuoloByidRuoloDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byidRuoloRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDRuoloDaoImpl::findByidRuolo] ERROR esecuzione query", ex);
			throw new TaifDRuoloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDRuoloDaoImpl", "findByidRuolo", "esecuzione query", sql.toString());
			LOG.debug("[TaifDRuoloDaoImpl::findByidRuolo] END");
		}
		return list;
	}

}
