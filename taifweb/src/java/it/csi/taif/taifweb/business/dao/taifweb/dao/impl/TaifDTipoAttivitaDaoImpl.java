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

/*PROTECTED REGION ID(R-218098927) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.taif.taifweb.util.ConvertUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoAttivita.
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
public class TaifDTipoAttivitaDaoImpl extends AbstractDAO implements TaifDTipoAttivitaDao {
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
	 * Metodo di inserimento del DAO taifDTipoAttivita. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoAttivitaPk
	 * @generated
	 */

	public TaifDTipoAttivitaPk insert(TaifDTipoAttivitaDto dto)

	{
		LOG.debug("[TaifDTipoAttivitaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_ATTIVITA,TIPO_ATTIVITA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TIPO_ATTIVITA , :TIPO_ATTIVITA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_ATTIVITA]
		params.addValue("ID_TIPO_ATTIVITA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_ATTIVITA]
		params.addValue("TIPO_ATTIVITA", dto.getTipoAttivita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoAttivita(newKey);
		LOG.debug("[TaifDTipoAttivitaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_ATTIVITA table.
	 * @generated
	 */

	public void delete(TaifDTipoAttivitaPk pk) throws TaifDTipoAttivitaDaoException {
		LOG.debug("[TaifDTipoAttivitaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_ATTIVITA = :ID_TIPO_ATTIVITA ";

		if (pk == null) {
			LOG.error("[TaifDTipoAttivitaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoAttivitaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_ATTIVITA]
		params.addValue("ID_TIPO_ATTIVITA", pk.getIdTipoAttivita(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoAttivitaDaoImpl::delete] END");
	}

	protected TaifDTipoAttivitaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoAttivitaDaoRowMapper(null,
			TaifDTipoAttivitaDto.class, this);

	protected TaifDTipoAttivitaDaoRowMapper findAllRowMapper = new TaifDTipoAttivitaDaoRowMapper(null,
			TaifDTipoAttivitaDto.class, this);

	protected TaifDTipoAttivitaDaoRowMapper byFilterRowMapper = new TaifDTipoAttivitaDaoRowMapper(null,
			TaifDTipoAttivitaByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_ATTIVITA";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_ATTIVITA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoAttivitaDto findByPrimaryKey(TaifDTipoAttivitaPk pk) throws TaifDTipoAttivitaDaoException {
		LOG.debug("[TaifDTipoAttivitaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_ATTIVITA,TIPO_ATTIVITA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TIPO_ATTIVITA = :ID_TIPO_ATTIVITA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_ATTIVITA]
		params.addValue("ID_TIPO_ATTIVITA", pk.getIdTipoAttivita(), java.sql.Types.INTEGER);

		List<TaifDTipoAttivitaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoAttivitaDto res = (TaifDTipoAttivitaDto) cache.get(pk);
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
			LOG.error("[TaifDTipoAttivitaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoAttivitaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoAttivitaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoAttivitaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_ATTIVITA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoAttivitaDto> findAll() throws TaifDTipoAttivitaDaoException {
		LOG.debug("[TaifDTipoAttivitaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_ATTIVITA,TIPO_ATTIVITA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoAttivitaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoAttivitaDto> res = (List<TaifDTipoAttivitaDto>) cache.get("findAll_taifDTipoAttivita_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoAttivita_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoAttivitaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoAttivitaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoAttivitaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoAttivitaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDTipoAttivitaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoAttivitaDaoException {
		LOG.debug("[TaifDTipoAttivitaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivita.ID_TIPO_ATTIVITA as id, attivita.TIPO_ATTIVITA as tipo, attivita.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_ATTIVITA attivita");

		sql.append(" WHERE ");

		sql.append("attivita.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R-380385287) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		if (ConvertUtil.checkIsNullOrEmpty(input.getFlagItaFr())) {
			sql.append(" and attivita.MTD_FLG_ITA_FRA=:flagItaFr");
			paramMap.addValue("flagItaFr", input.getFlagItaFr());
		}

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoAttivitaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoAttivitaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDTipoAttivitaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoAttivitaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoAttivitaDaoImpl::findByFilter] END");
		}
		return list;
	}

}
