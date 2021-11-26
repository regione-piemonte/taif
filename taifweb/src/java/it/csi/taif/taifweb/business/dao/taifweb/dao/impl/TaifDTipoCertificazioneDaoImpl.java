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

/*PROTECTED REGION ID(R-1389740559) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoCertificazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - tipoCertificazioneVisible (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoCertificazioneDaoImpl extends AbstractDAO implements TaifDTipoCertificazioneDao {
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
	 * Metodo di inserimento del DAO taifDTipoCertificazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoCertificazionePk
	 * @generated
	 */

	public TaifDTipoCertificazionePk insert(TaifDTipoCertificazioneDto dto)

	{
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_CERTIFICAZIONE,TIPO_CERTIFICAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TIPO_CERTIFICAZIONE , :TIPO_CERTIFICAZIONE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CERTIFICAZIONE]
		params.addValue("ID_TIPO_CERTIFICAZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_CERTIFICAZIONE]
		params.addValue("TIPO_CERTIFICAZIONE", dto.getTipoCertificazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoCertificazione(newKey);
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TIPO_CERTIFICAZIONE table.
	 * @generated
	 */
	public void update(TaifDTipoCertificazioneDto dto) throws TaifDTipoCertificazioneDaoException {
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPO_CERTIFICAZIONE = :TIPO_CERTIFICAZIONE ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE ,MTD_FLG_ITA_FRA = :MTD_FLG_ITA_FRA  WHERE ID_TIPO_CERTIFICAZIONE = :ID_TIPO_CERTIFICAZIONE ";

		if (dto.getIdTipoCertificazione() == null) {
			LOG.error("[TaifDTipoCertificazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTipoCertificazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CERTIFICAZIONE]
		params.addValue("ID_TIPO_CERTIFICAZIONE", dto.getIdTipoCertificazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_CERTIFICAZIONE]
		params.addValue("TIPO_CERTIFICAZIONE", dto.getTipoCertificazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_CERTIFICAZIONE table.
	 * @generated
	 */

	public void delete(TaifDTipoCertificazionePk pk) throws TaifDTipoCertificazioneDaoException {
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_CERTIFICAZIONE = :ID_TIPO_CERTIFICAZIONE ";

		if (pk == null) {
			LOG.error("[TaifDTipoCertificazioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoCertificazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CERTIFICAZIONE]
		params.addValue("ID_TIPO_CERTIFICAZIONE", pk.getIdTipoCertificazione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::delete] END");
	}

	protected TaifDTipoCertificazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoCertificazioneDaoRowMapper(
			null, TaifDTipoCertificazioneDto.class, this);

	protected TaifDTipoCertificazioneDaoRowMapper findAllRowMapper = new TaifDTipoCertificazioneDaoRowMapper(null,
			TaifDTipoCertificazioneDto.class, this);

	protected TaifDTipoCertificazioneDaoRowMapper tipoCertificazioneVisibleRowMapper = new TaifDTipoCertificazioneDaoRowMapper(
			null, TaifDTipoCertificazioneTipoCertificazioneVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_CERTIFICAZIONE";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_CERTIFICAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoCertificazioneDto findByPrimaryKey(TaifDTipoCertificazionePk pk)
			throws TaifDTipoCertificazioneDaoException {
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_CERTIFICAZIONE,TIPO_CERTIFICAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TIPO_CERTIFICAZIONE = :ID_TIPO_CERTIFICAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CERTIFICAZIONE]
		params.addValue("ID_TIPO_CERTIFICAZIONE", pk.getIdTipoCertificazione(), java.sql.Types.INTEGER);

		List<TaifDTipoCertificazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoCertificazioneDto res = (TaifDTipoCertificazioneDto) cache.get(pk);
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
			LOG.error("[TaifDTipoCertificazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoCertificazioneDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoCertificazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_CERTIFICAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoCertificazioneDto> findAll() throws TaifDTipoCertificazioneDaoException {
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_CERTIFICAZIONE,TIPO_CERTIFICAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoCertificazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoCertificazioneDto> res = (List<TaifDTipoCertificazioneDto>) cache
					.get("findAll_taifDTipoCertificazione_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoCertificazione_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoCertificazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoCertificazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoCertificazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder tipoCertificazioneVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoCertificazioneTipoCertificazioneVisibleDto> findTipoCertificazioneVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoCertificazioneDaoException {
		LOG.debug("[TaifDTipoCertificazioneDaoImpl::findTipoCertificazioneVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT cert.ID_TIPO_CERTIFICAZIONE as id, cert.TIPO_CERTIFICAZIONE as tipoCert, cert.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_CERTIFICAZIONE cert");

		sql.append(" WHERE ");

		sql.append("cert.mtd_flg_visibile=:visibile and cert.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R-97470734) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoCertificazioneTipoCertificazioneVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, tipoCertificazioneVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoCertificazioneDaoImpl::findTipoCertificazioneVisible] ERROR esecuzione query", ex);
			throw new TaifDTipoCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoCertificazioneDaoImpl", "findTipoCertificazioneVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoCertificazioneDaoImpl::findTipoCertificazioneVisible] END");
		}
		return list;
	}

}
