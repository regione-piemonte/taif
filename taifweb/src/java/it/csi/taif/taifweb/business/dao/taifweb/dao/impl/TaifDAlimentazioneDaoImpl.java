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

/*PROTECTED REGION ID(R-746570201) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDAlimentazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibile (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDAlimentazioneDaoImpl extends AbstractDAO implements TaifDAlimentazioneDao {
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
	 * Metodo di inserimento del DAO taifDAlimentazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAlimentazionePk
	 * @generated
	 */

	public TaifDAlimentazionePk insert(TaifDAlimentazioneDto dto)

	{
		LOG.debug("[TaifDAlimentazioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALIMENTAZIONE,ALIMENTAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_ALIMENTAZIONE , :ALIMENTAZIONE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALIMENTAZIONE]
		params.addValue("ID_ALIMENTAZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ALIMENTAZIONE]
		params.addValue("ALIMENTAZIONE", dto.getAlimentazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAlimentazione(newKey);
		LOG.debug("[TaifDAlimentazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_ALIMENTAZIONE table.
	 * @generated
	 */
	public void update(TaifDAlimentazioneDto dto) throws TaifDAlimentazioneDaoException {
		LOG.debug("[TaifDAlimentazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET ALIMENTAZIONE = :ALIMENTAZIONE ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE  WHERE ID_ALIMENTAZIONE = :ID_ALIMENTAZIONE ";

		if (dto.getIdAlimentazione() == null) {
			LOG.error("[TaifDAlimentazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDAlimentazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALIMENTAZIONE]
		params.addValue("ID_ALIMENTAZIONE", dto.getIdAlimentazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ALIMENTAZIONE]
		params.addValue("ALIMENTAZIONE", dto.getAlimentazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDAlimentazioneDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_ALIMENTAZIONE table.
	 * @generated
	 */

	public void delete(TaifDAlimentazionePk pk) throws TaifDAlimentazioneDaoException {
		LOG.debug("[TaifDAlimentazioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALIMENTAZIONE = :ID_ALIMENTAZIONE ";

		if (pk == null) {
			LOG.error("[TaifDAlimentazioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDAlimentazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALIMENTAZIONE]
		params.addValue("ID_ALIMENTAZIONE", pk.getIdAlimentazione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDAlimentazioneDaoImpl::delete] END");
	}

	protected TaifDAlimentazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifDAlimentazioneDaoRowMapper(null,
			TaifDAlimentazioneDto.class, this);

	protected TaifDAlimentazioneDaoRowMapper findAllRowMapper = new TaifDAlimentazioneDaoRowMapper(null,
			TaifDAlimentazioneDto.class, this);

	protected TaifDAlimentazioneDaoRowMapper byVisibileRowMapper = new TaifDAlimentazioneDaoRowMapper(null,
			TaifDAlimentazioneByVisibileDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_ALIMENTAZIONE";
	}

	/** 
	 * Returns all rows from the TAIF_D_ALIMENTAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAlimentazioneDto findByPrimaryKey(TaifDAlimentazionePk pk) throws TaifDAlimentazioneDaoException {
		LOG.debug("[TaifDAlimentazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALIMENTAZIONE,ALIMENTAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName()
						+ " WHERE ID_ALIMENTAZIONE = :ID_ALIMENTAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALIMENTAZIONE]
		params.addValue("ID_ALIMENTAZIONE", pk.getIdAlimentazione(), java.sql.Types.INTEGER);

		List<TaifDAlimentazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDAlimentazioneDto res = (TaifDAlimentazioneDto) cache.get(pk);
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
			LOG.error("[TaifDAlimentazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDAlimentazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAlimentazioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAlimentazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ALIMENTAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAlimentazioneDto> findAll() throws TaifDAlimentazioneDaoException {
		LOG.debug("[TaifDAlimentazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALIMENTAZIONE,ALIMENTAZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDAlimentazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDAlimentazioneDto> res = (List<TaifDAlimentazioneDto>) cache
					.get("findAll_taifDAlimentazione_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDAlimentazione_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAlimentazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDAlimentazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAlimentazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAlimentazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibile con Qdef
		 * @generated
		 */

	public List<TaifDAlimentazioneByVisibileDto> findByVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAlimentazioneDaoException {
		LOG.debug("[TaifDAlimentazioneDaoImpl::findByVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT alim.ID_ALIMENTAZIONE as id, alim.ALIMENTAZIONE as cat, alim.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_ALIMENTAZIONE alim");

		sql.append(" WHERE ");

		sql.append("alim.mtd_flg_visibile=:visibile");
		/*PROTECTED REGION ID(R-1007035766) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		/*PROTECTED REGION END*/

		List<TaifDAlimentazioneByVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAlimentazioneDaoImpl::findByVisibile] ERROR esecuzione query", ex);
			throw new TaifDAlimentazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAlimentazioneDaoImpl", "findByVisibile", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAlimentazioneDaoImpl::findByVisibile] END");
		}
		return list;
	}

}
