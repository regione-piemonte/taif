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

/*PROTECTED REGION ID(R-175176815) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTrazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibileOrdin (datagen::CustomFinder)
 *   - byTrazTrazione (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTrazioneDaoImpl extends AbstractDAO implements TaifDTrazioneDao {
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
	 * Metodo di inserimento del DAO taifDTrazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTrazionePk
	 * @generated
	 */

	public TaifDTrazionePk insert(TaifDTrazioneDto dto)

	{
		LOG.debug("[TaifDTrazioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TRAZIONE,TRAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TRAZIONE , :TRAZIONE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TRAZIONE]
		params.addValue("ID_TRAZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TRAZIONE]
		params.addValue("TRAZIONE", dto.getTrazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTrazione(newKey);
		LOG.debug("[TaifDTrazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TRAZIONE table.
	 * @generated
	 */
	public void update(TaifDTrazioneDto dto) throws TaifDTrazioneDaoException {
		LOG.debug("[TaifDTrazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TRAZIONE = :TRAZIONE ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE ,MTD_FLG_ITA_FRA = :MTD_FLG_ITA_FRA  WHERE ID_TRAZIONE = :ID_TRAZIONE ";

		if (dto.getIdTrazione() == null) {
			LOG.error("[TaifDTrazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTrazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TRAZIONE]
		params.addValue("ID_TRAZIONE", dto.getIdTrazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TRAZIONE]
		params.addValue("TRAZIONE", dto.getTrazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTrazioneDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TRAZIONE table.
	 * @generated
	 */

	public void delete(TaifDTrazionePk pk) throws TaifDTrazioneDaoException {
		LOG.debug("[TaifDTrazioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TRAZIONE = :ID_TRAZIONE ";

		if (pk == null) {
			LOG.error("[TaifDTrazioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTrazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TRAZIONE]
		params.addValue("ID_TRAZIONE", pk.getIdTrazione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTrazioneDaoImpl::delete] END");
	}

	protected TaifDTrazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTrazioneDaoRowMapper(null,
			TaifDTrazioneDto.class, this);

	protected TaifDTrazioneDaoRowMapper findAllRowMapper = new TaifDTrazioneDaoRowMapper(null, TaifDTrazioneDto.class,
			this);

	protected TaifDTrazioneDaoRowMapper byVisibileOrdinRowMapper = new TaifDTrazioneDaoRowMapper(null,
			TaifDTrazioneByVisibileOrdinDto.class, this);

	protected TaifDTrazioneDaoRowMapper byTrazTrazioneRowMapper = new TaifDTrazioneDaoRowMapper(null,
			TaifDTrazioneByTrazTrazioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TRAZIONE";
	}

	/** 
	 * Returns all rows from the TAIF_D_TRAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTrazioneDto findByPrimaryKey(TaifDTrazionePk pk) throws TaifDTrazioneDaoException {
		LOG.debug("[TaifDTrazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TRAZIONE,TRAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM " + getTableName()
						+ " WHERE ID_TRAZIONE = :ID_TRAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TRAZIONE]
		params.addValue("ID_TRAZIONE", pk.getIdTrazione(), java.sql.Types.INTEGER);

		List<TaifDTrazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTrazioneDto res = (TaifDTrazioneDto) cache.get(pk);
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
			LOG.error("[TaifDTrazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTrazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTrazioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTrazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TRAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTrazioneDto> findAll() throws TaifDTrazioneDaoException {
		LOG.debug("[TaifDTrazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TRAZIONE,TRAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTrazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTrazioneDto> res = (List<TaifDTrazioneDto>) cache.get("findAll_taifDTrazione_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTrazione_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTrazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTrazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTrazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTrazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibileOrdin con Qdef
		 * @generated
		 */

	public List<TaifDTrazioneByVisibileOrdinDto> findByVisibileOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTrazioneDaoException {
		LOG.debug("[TaifDTrazioneDaoImpl::findByVisibileOrdin] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT traz.ID_TRAZIONE as id, traz.TRAZIONE as cat, traz.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TRAZIONE traz");

		sql.append(" WHERE ");

		sql.append("traz.mtd_flg_visibile=:visibile and traz.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R544876074) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTrazioneByVisibileOrdinDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileOrdinRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTrazioneDaoImpl::findByVisibileOrdin] ERROR esecuzione query", ex);
			throw new TaifDTrazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTrazioneDaoImpl", "findByVisibileOrdin", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTrazioneDaoImpl::findByVisibileOrdin] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTrazTrazione con Qdef
		 * @generated
		 */

	public List<TaifDTrazioneByTrazTrazioneDto> findByTrazTrazione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifDTrazioneDaoException {
		LOG.debug("[TaifDTrazioneDaoImpl::findByTrazTrazione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT trazione.ID_TRAZIONE as idTrazione, trazione.TRAZIONE as trazione, trazione.MTD_ORDINAMENTO as ordinamento");

		sql.append(" FROM TAIF_D_TRAZIONE trazione, TAIF_R_TRAZ_TIPOMEZZO trazTipoMezzo");

		sql.append(" WHERE ");

		sql.append("trazione.ID_TRAZIONE = trazTipoMezzo.ID_TRAZIONE");

		sql.append(" AND ");

		sql.append(
				"trazTipoMezzo.id_tipo_mezzo=:idTipoMezzo and trazione.mtd_flg_visibile=:flagVisibile and trazione.mtd_flg_ita_fra=:idNazione");
		/*PROTECTED REGION ID(R-1832290914) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTipoMezzo", input.getIdTipoMezzo());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("idNazione", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifDTrazioneByTrazTrazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTrazTrazioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTrazioneDaoImpl::findByTrazTrazione] ERROR esecuzione query", ex);
			throw new TaifDTrazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTrazioneDaoImpl", "findByTrazTrazione", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTrazioneDaoImpl::findByTrazTrazione] END");
		}
		return list;
	}

}
