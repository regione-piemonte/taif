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

/*PROTECTED REGION ID(R352194977) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDUnitaDiMisura.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibleFilter (datagen::CustomFinder)
 *   - byVisibleUnitaMisura (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDUnitaDiMisuraDaoImpl extends AbstractDAO implements TaifDUnitaDiMisuraDao {
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
	 * Metodo di inserimento del DAO taifDUnitaDiMisura. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDUnitaDiMisuraPk
	 * @generated
	 */

	public TaifDUnitaDiMisuraPk insert(TaifDUnitaDiMisuraDto dto)

	{
		LOG.debug("[TaifDUnitaDiMisuraDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_UNITA_DI_MISURA,UNITA_DI_MISURA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_UNITA_DI_MISURA , :UNITA_DI_MISURA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_DI_MISURA]
		params.addValue("ID_UNITA_DI_MISURA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [UNITA_DI_MISURA]
		params.addValue("UNITA_DI_MISURA", dto.getUnitaDiMisura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdUnitaDiMisura(newKey);
		LOG.debug("[TaifDUnitaDiMisuraDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_UNITA_DI_MISURA table.
	 * @generated
	 */

	public void delete(TaifDUnitaDiMisuraPk pk) throws TaifDUnitaDiMisuraDaoException {
		LOG.debug("[TaifDUnitaDiMisuraDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_UNITA_DI_MISURA = :ID_UNITA_DI_MISURA ";

		if (pk == null) {
			LOG.error("[TaifDUnitaDiMisuraDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDUnitaDiMisuraDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_DI_MISURA]
		params.addValue("ID_UNITA_DI_MISURA", pk.getIdUnitaDiMisura(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDUnitaDiMisuraDaoImpl::delete] END");
	}

	protected TaifDUnitaDiMisuraDaoRowMapper findByPrimaryKeyRowMapper = new TaifDUnitaDiMisuraDaoRowMapper(null,
			TaifDUnitaDiMisuraDto.class, this);

	protected TaifDUnitaDiMisuraDaoRowMapper findAllRowMapper = new TaifDUnitaDiMisuraDaoRowMapper(null,
			TaifDUnitaDiMisuraDto.class, this);

	protected TaifDUnitaDiMisuraDaoRowMapper byVisibleFilterRowMapper = new TaifDUnitaDiMisuraDaoRowMapper(null,
			TaifDUnitaDiMisuraByVisibleFilterDto.class, this);

	protected TaifDUnitaDiMisuraDaoRowMapper byVisibleUnitaMisuraRowMapper = new TaifDUnitaDiMisuraDaoRowMapper(null,
			TaifDUnitaDiMisuraByVisibleUnitaMisuraDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_UNITA_DI_MISURA";
	}

	/** 
	 * Returns all rows from the TAIF_D_UNITA_DI_MISURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDUnitaDiMisuraDto findByPrimaryKey(TaifDUnitaDiMisuraPk pk) throws TaifDUnitaDiMisuraDaoException {
		LOG.debug("[TaifDUnitaDiMisuraDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_UNITA_DI_MISURA,UNITA_DI_MISURA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName()
						+ " WHERE ID_UNITA_DI_MISURA = :ID_UNITA_DI_MISURA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_DI_MISURA]
		params.addValue("ID_UNITA_DI_MISURA", pk.getIdUnitaDiMisura(), java.sql.Types.INTEGER);

		List<TaifDUnitaDiMisuraDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDUnitaDiMisuraDto res = (TaifDUnitaDiMisuraDto) cache.get(pk);
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
			LOG.error("[TaifDUnitaDiMisuraDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDUnitaDiMisuraDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaDiMisuraDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDUnitaDiMisuraDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_UNITA_DI_MISURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDUnitaDiMisuraDto> findAll() throws TaifDUnitaDiMisuraDaoException {
		LOG.debug("[TaifDUnitaDiMisuraDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_UNITA_DI_MISURA,UNITA_DI_MISURA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDUnitaDiMisuraDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDUnitaDiMisuraDto> res = (List<TaifDUnitaDiMisuraDto>) cache
					.get("findAll_taifDUnitaDiMisura_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDUnitaDiMisura_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaDiMisuraDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDUnitaDiMisuraDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaDiMisuraDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDUnitaDiMisuraDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibleFilter con Qdef
		 * @generated
		 */

	public List<TaifDUnitaDiMisuraByVisibleFilterDto> findByVisibleFilter(java.lang.Integer input)
			throws TaifDUnitaDiMisuraDaoException {
		LOG.debug("[TaifDUnitaDiMisuraDaoImpl::findByVisibleFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT unita.ID_UNITA_DI_MISURA as id, unita.UNITA_DI_MISURA as um, unita.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_UNITA_DI_MISURA unita");

		sql.append(" WHERE ");

		sql.append("unita.MTD_FLG_VISIBILE=:visibile ");
		/*PROTECTED REGION ID(R848652502) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input);

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDUnitaDiMisuraByVisibleFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaDiMisuraDaoImpl::findByVisibleFilter] ERROR esecuzione query", ex);
			throw new TaifDUnitaDiMisuraDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaDiMisuraDaoImpl", "findByVisibleFilter", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDUnitaDiMisuraDaoImpl::findByVisibleFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibleUnitaMisura con Qdef
		 * @generated
		 */

	public List<TaifDUnitaDiMisuraByVisibleUnitaMisuraDto> findByVisibleUnitaMisura(
			it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaMisuraFilter input)
			throws TaifDUnitaDiMisuraDaoException {
		LOG.debug("[TaifDUnitaDiMisuraDaoImpl::findByVisibleUnitaMisura] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT unita.ID_UNITA_DI_MISURA as id, unita.UNITA_DI_MISURA as um, unita.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_UNITA_DI_MISURA unita");

		sql.append(" WHERE ");

		sql.append("unita.mtd_flg_visibile=:visibile  and unita.unita_di_misura=:unitaMisura");
		/*PROTECTED REGION ID(R1205414104) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisible());
		paramMap.addValue("unitaMisura", input.getUnitaMisura());

		/*PROTECTED REGION END*/

		List<TaifDUnitaDiMisuraByVisibleUnitaMisuraDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleUnitaMisuraRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaDiMisuraDaoImpl::findByVisibleUnitaMisura] ERROR esecuzione query", ex);
			throw new TaifDUnitaDiMisuraDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaDiMisuraDaoImpl", "findByVisibleUnitaMisura", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDUnitaDiMisuraDaoImpl::findByVisibleUnitaMisura] END");
		}
		return list;
	}

}
