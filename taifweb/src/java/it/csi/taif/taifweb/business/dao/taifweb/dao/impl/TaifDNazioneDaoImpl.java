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

/*PROTECTED REGION ID(R-719970357) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDNazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byNazioneItaVisible (datagen::CustomFinder)
 *   - byNazioneFraVisible (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDNazioneDaoImpl extends AbstractDAO implements TaifDNazioneDao {
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
	 * Metodo di inserimento del DAO taifDNazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDNazionePk
	 * @generated
	 */

	public TaifDNazionePk insert(TaifDNazioneDto dto)

	{
		LOG.debug("[TaifDNazioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_NAZIONE,NAZIONE_ITA,NAZIONE_FRA,MTD_ORDINAMENTO_ITA,MTD_ORDINAMENTO_FRA,MTD_FLG_VISIBILE ) VALUES (  :ID_NAZIONE , :NAZIONE_ITA , :NAZIONE_FRA , :MTD_ORDINAMENTO_ITA , :MTD_ORDINAMENTO_FRA , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_NAZIONE]
		params.addValue("ID_NAZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NAZIONE_ITA]
		params.addValue("NAZIONE_ITA", dto.getNazioneIta(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NAZIONE_FRA]
		params.addValue("NAZIONE_FRA", dto.getNazioneFra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO_ITA]
		params.addValue("MTD_ORDINAMENTO_ITA", dto.getMtdOrdinamentoIta(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO_FRA]
		params.addValue("MTD_ORDINAMENTO_FRA", dto.getMtdOrdinamentoFra(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdNazione(newKey);
		LOG.debug("[TaifDNazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_NAZIONE table.
	 * @generated
	 */
	public void update(TaifDNazioneDto dto) throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NAZIONE_ITA = :NAZIONE_ITA ,NAZIONE_FRA = :NAZIONE_FRA ,MTD_ORDINAMENTO_ITA = :MTD_ORDINAMENTO_ITA ,MTD_ORDINAMENTO_FRA = :MTD_ORDINAMENTO_FRA ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE  WHERE ID_NAZIONE = :ID_NAZIONE ";

		if (dto.getIdNazione() == null) {
			LOG.error("[TaifDNazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDNazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_NAZIONE]
		params.addValue("ID_NAZIONE", dto.getIdNazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NAZIONE_ITA]
		params.addValue("NAZIONE_ITA", dto.getNazioneIta(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NAZIONE_FRA]
		params.addValue("NAZIONE_FRA", dto.getNazioneFra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO_ITA]
		params.addValue("MTD_ORDINAMENTO_ITA", dto.getMtdOrdinamentoIta(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO_FRA]
		params.addValue("MTD_ORDINAMENTO_FRA", dto.getMtdOrdinamentoFra(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDNazioneDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_NAZIONE table.
	 * @generated
	 */

	public void delete(TaifDNazionePk pk) throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_NAZIONE = :ID_NAZIONE ";

		if (pk == null) {
			LOG.error("[TaifDNazioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDNazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_NAZIONE]
		params.addValue("ID_NAZIONE", pk.getIdNazione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDNazioneDaoImpl::delete] END");
	}

	protected TaifDNazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifDNazioneDaoRowMapper(null,
			TaifDNazioneDto.class, this);

	protected TaifDNazioneDaoRowMapper findAllRowMapper = new TaifDNazioneDaoRowMapper(null, TaifDNazioneDto.class,
			this);

	protected TaifDNazioneDaoRowMapper byNazioneItaVisibleRowMapper = new TaifDNazioneDaoRowMapper(null,
			TaifDNazioneByNazioneItaVisibleDto.class, this);

	protected TaifDNazioneDaoRowMapper byNazioneFraVisibleRowMapper = new TaifDNazioneDaoRowMapper(null,
			TaifDNazioneByNazioneFraVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_NAZIONE";
	}

	/** 
	 * Returns all rows from the TAIF_D_NAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDNazioneDto findByPrimaryKey(TaifDNazionePk pk) throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_NAZIONE,NAZIONE_ITA,NAZIONE_FRA,MTD_ORDINAMENTO_ITA,MTD_ORDINAMENTO_FRA,MTD_FLG_VISIBILE FROM "
						+ getTableName() + " WHERE ID_NAZIONE = :ID_NAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_NAZIONE]
		params.addValue("ID_NAZIONE", pk.getIdNazione(), java.sql.Types.INTEGER);

		List<TaifDNazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDNazioneDto res = (TaifDNazioneDto) cache.get(pk);
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
			LOG.error("[TaifDNazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDNazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDNazioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDNazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_NAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDNazioneDto> findAll() throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_NAZIONE,NAZIONE_ITA,NAZIONE_FRA,MTD_ORDINAMENTO_ITA,MTD_ORDINAMENTO_FRA,MTD_FLG_VISIBILE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_NAZIONE ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDNazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDNazioneDto> res = (List<TaifDNazioneDto>) cache.get("findAll_taifDNazione_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDNazione_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDNazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDNazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDNazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDNazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byNazioneItaVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByNazioneItaVisibleDto> findByNazioneItaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::findByNazioneItaVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT naz.ID_NAZIONE as id, naz.NAZIONE_ITA as it, naz.MTD_ORDINAMENTO_ITA as ordin");

		sql.append(" FROM TAIF_D_NAZIONE naz");

		sql.append(" WHERE ");

		sql.append("naz.mtd_flg_visibile=:visibile ");
		/*PROTECTED REGION ID(R-149938325) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		sql.append(" ORDER BY MTD_ORDINAMENTO_ITA ASC");

		/*PROTECTED REGION END*/

		List<TaifDNazioneByNazioneItaVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byNazioneItaVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDNazioneDaoImpl::findByNazioneItaVisible] ERROR esecuzione query", ex);
			throw new TaifDNazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDNazioneDaoImpl", "findByNazioneItaVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifDNazioneDaoImpl::findByNazioneItaVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byNazioneFraVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByNazioneFraVisibleDto> findByNazioneFraVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::findByNazioneFraVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT naz.ID_NAZIONE as id, naz.NAZIONE_FRA as it, naz.MTD_ORDINAMENTO_FRA as ordin");

		sql.append(" FROM TAIF_D_NAZIONE naz");

		sql.append(" WHERE ");

		sql.append("naz.mtd_flg_visibile=:visibile ");
		/*PROTECTED REGION ID(R633490794) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		sql.append(" ORDER BY MTD_ORDINAMENTO_FRA ASC");

		/*PROTECTED REGION END*/

		List<TaifDNazioneByNazioneFraVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byNazioneFraVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDNazioneDaoImpl::findByNazioneFraVisible] ERROR esecuzione query", ex);
			throw new TaifDNazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDNazioneDaoImpl", "findByNazioneFraVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifDNazioneDaoImpl::findByNazioneFraVisible] END");
		}
		return list;
	}

}
