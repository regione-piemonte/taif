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

/*PROTECTED REGION ID(R-210970277) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoStruttura.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - tipoStrutturaVisible (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoStrutturaDaoImpl extends AbstractDAO implements TaifDTipoStrutturaDao {
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
	 * Metodo di inserimento del DAO taifDTipoStruttura. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoStrutturaPk
	 * @generated
	 */

	public TaifDTipoStrutturaPk insert(TaifDTipoStrutturaDto dto)

	{
		LOG.debug("[TaifDTipoStrutturaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_STRUTTURA,TIPO_STRUTTURA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TIPO_STRUTTURA , :TIPO_STRUTTURA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_STRUTTURA]
		params.addValue("ID_TIPO_STRUTTURA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_STRUTTURA]
		params.addValue("TIPO_STRUTTURA", dto.getTipoStruttura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoStruttura(newKey);
		LOG.debug("[TaifDTipoStrutturaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TIPO_STRUTTURA table.
	 * @generated
	 */
	public void update(TaifDTipoStrutturaDto dto) throws TaifDTipoStrutturaDaoException {
		LOG.debug("[TaifDTipoStrutturaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPO_STRUTTURA = :TIPO_STRUTTURA ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE ,MTD_FLG_ITA_FRA = :MTD_FLG_ITA_FRA  WHERE ID_TIPO_STRUTTURA = :ID_TIPO_STRUTTURA ";

		if (dto.getIdTipoStruttura() == null) {
			LOG.error("[TaifDTipoStrutturaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTipoStrutturaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_STRUTTURA]
		params.addValue("ID_TIPO_STRUTTURA", dto.getIdTipoStruttura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_STRUTTURA]
		params.addValue("TIPO_STRUTTURA", dto.getTipoStruttura(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoStrutturaDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_STRUTTURA table.
	 * @generated
	 */

	public void delete(TaifDTipoStrutturaPk pk) throws TaifDTipoStrutturaDaoException {
		LOG.debug("[TaifDTipoStrutturaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_STRUTTURA = :ID_TIPO_STRUTTURA ";

		if (pk == null) {
			LOG.error("[TaifDTipoStrutturaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoStrutturaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_STRUTTURA]
		params.addValue("ID_TIPO_STRUTTURA", pk.getIdTipoStruttura(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoStrutturaDaoImpl::delete] END");
	}

	protected TaifDTipoStrutturaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoStrutturaDaoRowMapper(null,
			TaifDTipoStrutturaDto.class, this);

	protected TaifDTipoStrutturaDaoRowMapper findAllRowMapper = new TaifDTipoStrutturaDaoRowMapper(null,
			TaifDTipoStrutturaDto.class, this);

	protected TaifDTipoStrutturaDaoRowMapper tipoStrutturaVisibleRowMapper = new TaifDTipoStrutturaDaoRowMapper(null,
			TaifDTipoStrutturaTipoStrutturaVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_STRUTTURA";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_STRUTTURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoStrutturaDto findByPrimaryKey(TaifDTipoStrutturaPk pk) throws TaifDTipoStrutturaDaoException {
		LOG.debug("[TaifDTipoStrutturaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_STRUTTURA,TIPO_STRUTTURA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TIPO_STRUTTURA = :ID_TIPO_STRUTTURA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_STRUTTURA]
		params.addValue("ID_TIPO_STRUTTURA", pk.getIdTipoStruttura(), java.sql.Types.INTEGER);

		List<TaifDTipoStrutturaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoStrutturaDto res = (TaifDTipoStrutturaDto) cache.get(pk);
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
			LOG.error("[TaifDTipoStrutturaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoStrutturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoStrutturaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoStrutturaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_STRUTTURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoStrutturaDto> findAll() throws TaifDTipoStrutturaDaoException {
		LOG.debug("[TaifDTipoStrutturaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_STRUTTURA,TIPO_STRUTTURA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoStrutturaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoStrutturaDto> res = (List<TaifDTipoStrutturaDto>) cache
					.get("findAll_taifDTipoStruttura_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoStruttura_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoStrutturaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoStrutturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoStrutturaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoStrutturaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder tipoStrutturaVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoStrutturaTipoStrutturaVisibleDto> findTipoStrutturaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoStrutturaDaoException {
		LOG.debug("[TaifDTipoStrutturaDaoImpl::findTipoStrutturaVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT stru.ID_TIPO_STRUTTURA as id, stru.TIPO_STRUTTURA as tipoStru, stru.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_STRUTTURA stru");

		sql.append(" WHERE ");

		sql.append("stru.mtd_flg_visibile=:visibile and stru.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R1410489726) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoStrutturaTipoStrutturaVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, tipoStrutturaVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoStrutturaDaoImpl::findTipoStrutturaVisible] ERROR esecuzione query", ex);
			throw new TaifDTipoStrutturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoStrutturaDaoImpl", "findTipoStrutturaVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoStrutturaDaoImpl::findTipoStrutturaVisible] END");
		}
		return list;
	}

}
