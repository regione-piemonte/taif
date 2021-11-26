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

/*PROTECTED REGION ID(R1374025361) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoLavoroPa.
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
public class TaifDTipoLavoroPaDaoImpl extends AbstractDAO implements TaifDTipoLavoroPaDao {
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
	 * Metodo di inserimento del DAO taifDTipoLavoroPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoLavoroPaPk
	 * @generated
	 */

	public TaifDTipoLavoroPaPk insert(TaifDTipoLavoroPaDto dto)

	{
		LOG.debug("[TaifDTipoLavoroPaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_LAVORO_PA,TIPO_LAVORO_PA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_TIPO_LAVORO_PA , :TIPO_LAVORO_PA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_LAVORO_PA]
		params.addValue("ID_TIPO_LAVORO_PA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_LAVORO_PA]
		params.addValue("TIPO_LAVORO_PA", dto.getTipoLavoroPa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoLavoroPa(newKey);
		LOG.debug("[TaifDTipoLavoroPaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_LAVORO_PA table.
	 * @generated
	 */

	public void delete(TaifDTipoLavoroPaPk pk) throws TaifDTipoLavoroPaDaoException {
		LOG.debug("[TaifDTipoLavoroPaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_LAVORO_PA = :ID_TIPO_LAVORO_PA ";

		if (pk == null) {
			LOG.error("[TaifDTipoLavoroPaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoLavoroPaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_LAVORO_PA]
		params.addValue("ID_TIPO_LAVORO_PA", pk.getIdTipoLavoroPa(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoLavoroPaDaoImpl::delete] END");
	}

	protected TaifDTipoLavoroPaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoLavoroPaDaoRowMapper(null,
			TaifDTipoLavoroPaDto.class, this);

	protected TaifDTipoLavoroPaDaoRowMapper findAllRowMapper = new TaifDTipoLavoroPaDaoRowMapper(null,
			TaifDTipoLavoroPaDto.class, this);

	protected TaifDTipoLavoroPaDaoRowMapper byFilterRowMapper = new TaifDTipoLavoroPaDaoRowMapper(null,
			TaifDTipoLavoroPaByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_LAVORO_PA";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_LAVORO_PA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoLavoroPaDto findByPrimaryKey(TaifDTipoLavoroPaPk pk) throws TaifDTipoLavoroPaDaoException {
		LOG.debug("[TaifDTipoLavoroPaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_LAVORO_PA,TIPO_LAVORO_PA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName()
						+ " WHERE ID_TIPO_LAVORO_PA = :ID_TIPO_LAVORO_PA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_LAVORO_PA]
		params.addValue("ID_TIPO_LAVORO_PA", pk.getIdTipoLavoroPa(), java.sql.Types.INTEGER);

		List<TaifDTipoLavoroPaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoLavoroPaDto res = (TaifDTipoLavoroPaDto) cache.get(pk);
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
			LOG.error("[TaifDTipoLavoroPaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoLavoroPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoLavoroPaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoLavoroPaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_LAVORO_PA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoLavoroPaDto> findAll() throws TaifDTipoLavoroPaDaoException {
		LOG.debug("[TaifDTipoLavoroPaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_LAVORO_PA,TIPO_LAVORO_PA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoLavoroPaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoLavoroPaDto> res = (List<TaifDTipoLavoroPaDto>) cache.get("findAll_taifDTipoLavoroPa_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoLavoroPa_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoLavoroPaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoLavoroPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoLavoroPaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoLavoroPaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDTipoLavoroPaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoLavoroPaDaoException {
		LOG.debug("[TaifDTipoLavoroPaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT lavoro.ID_TIPO_LAVORO_PA as id, lavoro.TIPO_LAVORO_PA as tipo, lavoro.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_LAVORO_PA lavoro");

		sql.append(" WHERE ");

		sql.append("lavoro.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R-2123697491) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoLavoroPaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoLavoroPaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDTipoLavoroPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoLavoroPaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoLavoroPaDaoImpl::findByFilter] END");
		}
		return list;
	}

}
