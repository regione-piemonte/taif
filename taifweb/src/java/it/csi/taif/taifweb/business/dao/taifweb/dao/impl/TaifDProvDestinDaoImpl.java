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

/*PROTECTED REGION ID(R1355991377) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDProvDestin.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDProvDestinDaoImpl extends AbstractDAO implements TaifDProvDestinDao {
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
	 * Metodo di inserimento del DAO taifDProvDestin. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDProvDestinPk
	 * @generated
	 */

	public TaifDProvDestinPk insert(TaifDProvDestinDto dto)

	{
		LOG.debug("[TaifDProvDestinDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PROV_DESTIN,PROV_DESTIN,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_PROV_DESTIN , :PROV_DESTIN , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PROV_DESTIN]
		params.addValue("ID_PROV_DESTIN", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROV_DESTIN]
		params.addValue("PROV_DESTIN", dto.getProvDestin(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdProvDestin(newKey);
		LOG.debug("[TaifDProvDestinDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_PROV_DESTIN table.
	 * @generated
	 */

	public void delete(TaifDProvDestinPk pk) throws TaifDProvDestinDaoException {
		LOG.debug("[TaifDProvDestinDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_PROV_DESTIN = :ID_PROV_DESTIN ";

		if (pk == null) {
			LOG.error("[TaifDProvDestinDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDProvDestinDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PROV_DESTIN]
		params.addValue("ID_PROV_DESTIN", pk.getIdProvDestin(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDProvDestinDaoImpl::delete] END");
	}

	protected TaifDProvDestinDaoRowMapper findByPrimaryKeyRowMapper = new TaifDProvDestinDaoRowMapper(null,
			TaifDProvDestinDto.class, this);

	protected TaifDProvDestinDaoRowMapper findAllRowMapper = new TaifDProvDestinDaoRowMapper(null,
			TaifDProvDestinDto.class, this);

	protected TaifDProvDestinDaoRowMapper byFilterRowMapper = new TaifDProvDestinDaoRowMapper(null,
			TaifDProvDestinByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_PROV_DESTIN";
	}

	/** 
	 * Returns all rows from the TAIF_D_PROV_DESTIN table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDProvDestinDto findByPrimaryKey(TaifDProvDestinPk pk) throws TaifDProvDestinDaoException {
		LOG.debug("[TaifDProvDestinDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PROV_DESTIN,PROV_DESTIN,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_PROV_DESTIN = :ID_PROV_DESTIN ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PROV_DESTIN]
		params.addValue("ID_PROV_DESTIN", pk.getIdProvDestin(), java.sql.Types.INTEGER);

		List<TaifDProvDestinDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDProvDestinDto res = (TaifDProvDestinDto) cache.get(pk);
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
			LOG.error("[TaifDProvDestinDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDProvDestinDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDProvDestinDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDProvDestinDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_PROV_DESTIN.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDProvDestinDto> findAll() throws TaifDProvDestinDaoException {
		LOG.debug("[TaifDProvDestinDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PROV_DESTIN,PROV_DESTIN,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDProvDestinDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDProvDestinDto> res = (List<TaifDProvDestinDto>) cache.get("findAll_taifDProvDestin_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDProvDestin_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDProvDestinDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDProvDestinDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDProvDestinDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDProvDestinDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDProvDestinByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDProvDestinDaoException {
		LOG.debug("[TaifDProvDestinDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT prov.ID_PROV_DESTIN as id, prov.PROV_DESTIN as provenienza, prov.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_PROV_DESTIN prov");

		sql.append(" WHERE ");

		sql.append("prov.MTD_FLG_VISIBILE=:visibile and prov.MTD_FLG_ITA_FRA=:flagItaFr");
		/*PROTECTED REGION ID(R164060397) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDProvDestinByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDProvDestinDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDProvDestinDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDProvDestinDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDProvDestinDaoImpl::findByFilter] END");
		}
		return list;
	}

}
