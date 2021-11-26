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

/*PROTECTED REGION ID(R-1275302831) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDAssociazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibleOrdin (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDAssociazioneDaoImpl extends AbstractDAO implements TaifDAssociazioneDao {
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
	 * Metodo di inserimento del DAO taifDAssociazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAssociazionePk
	 * @generated
	 */

	public TaifDAssociazionePk insert(TaifDAssociazioneDto dto)

	{
		LOG.debug("[TaifDAssociazioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ASSOCIAZIONE,ASSOCIAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_ASSOCIAZIONE , :ASSOCIAZIONE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSOCIAZIONE]
		params.addValue("ID_ASSOCIAZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ASSOCIAZIONE]
		params.addValue("ASSOCIAZIONE", dto.getAssociazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAssociazione(newKey);
		LOG.debug("[TaifDAssociazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_ASSOCIAZIONE table.
	 * @generated
	 */

	public void delete(TaifDAssociazionePk pk) throws TaifDAssociazioneDaoException {
		LOG.debug("[TaifDAssociazioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ASSOCIAZIONE = :ID_ASSOCIAZIONE ";

		if (pk == null) {
			LOG.error("[TaifDAssociazioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDAssociazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSOCIAZIONE]
		params.addValue("ID_ASSOCIAZIONE", pk.getIdAssociazione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDAssociazioneDaoImpl::delete] END");
	}

	protected TaifDAssociazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifDAssociazioneDaoRowMapper(null,
			TaifDAssociazioneDto.class, this);

	protected TaifDAssociazioneDaoRowMapper findAllRowMapper = new TaifDAssociazioneDaoRowMapper(null,
			TaifDAssociazioneDto.class, this);

	protected TaifDAssociazioneDaoRowMapper byVisibleOrdinRowMapper = new TaifDAssociazioneDaoRowMapper(null,
			TaifDAssociazioneByVisibleOrdinDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_ASSOCIAZIONE";
	}

	/** 
	 * Returns all rows from the TAIF_D_ASSOCIAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAssociazioneDto findByPrimaryKey(TaifDAssociazionePk pk) throws TaifDAssociazioneDaoException {
		LOG.debug("[TaifDAssociazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ASSOCIAZIONE,ASSOCIAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_ASSOCIAZIONE = :ID_ASSOCIAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSOCIAZIONE]
		params.addValue("ID_ASSOCIAZIONE", pk.getIdAssociazione(), java.sql.Types.INTEGER);

		List<TaifDAssociazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDAssociazioneDto res = (TaifDAssociazioneDto) cache.get(pk);
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
			LOG.error("[TaifDAssociazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDAssociazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAssociazioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAssociazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ASSOCIAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAssociazioneDto> findAll() throws TaifDAssociazioneDaoException {
		LOG.debug("[TaifDAssociazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ASSOCIAZIONE,ASSOCIAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDAssociazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDAssociazioneDto> res = (List<TaifDAssociazioneDto>) cache.get("findAll_taifDAssociazione_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDAssociazione_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAssociazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDAssociazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAssociazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAssociazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibleOrdin con Qdef
		 * @generated
		 */

	public List<TaifDAssociazioneByVisibleOrdinDto> findByVisibleOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAssociazioneDaoException {
		LOG.debug("[TaifDAssociazioneDaoImpl::findByVisibleOrdin] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT assoc.ID_ASSOCIAZIONE as id, assoc.ASSOCIAZIONE as associazione, assoc.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_ASSOCIAZIONE assoc");

		sql.append(" WHERE ");

		sql.append("assoc.mtd_flg_visibile=:visibile and assoc.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R-431901013) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		/*PROTECTED REGION END*/

		List<TaifDAssociazioneByVisibleOrdinDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleOrdinRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAssociazioneDaoImpl::findByVisibleOrdin] ERROR esecuzione query", ex);
			throw new TaifDAssociazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAssociazioneDaoImpl", "findByVisibleOrdin", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAssociazioneDaoImpl::findByVisibleOrdin] END");
		}
		return list;
	}

}
