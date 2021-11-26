/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.impl;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.mapper.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.impl.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R2017611839) ENABLED START*/
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
 *   - byFilterVisible (datagen::CustomFinder)
 *   - byNazioneItaVisible (datagen::CustomFinder)
 *   - byNazioneFraVisible (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
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

	protected TaifDNazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifDNazioneDaoRowMapper(null,
			TaifDNazioneDto.class, this);

	protected TaifDNazioneDaoRowMapper findAllRowMapper = new TaifDNazioneDaoRowMapper(null, TaifDNazioneDto.class,
			this);

	protected TaifDNazioneDaoRowMapper byFilterVisibleRowMapper = new TaifDNazioneDaoRowMapper(null,
			TaifDNazioneByFilterVisibleDto.class, this);

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
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
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

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDNazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
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
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::findByFilterVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT nazione.ID_NAZIONE as idNazione, nazione.NAZIONE_ITA as dsNazioneIta, nazione.NAZIONE_FRA as dsNazioneFra, nazione.MTD_ORDINAMENTO_ITA as ordinamentoIta, nazione.MTD_ORDINAMENTO_ITA as ordinamentoFra, nazione.MTD_FLG_VISIBILE as flgVisible");

		sql.append(" FROM TAIF_D_NAZIONE nazione");

		sql.append(" WHERE ");

		sql.append("nazione.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R-1936768911) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		if (input.getFlagItaFr().equalsIgnoreCase(Constants.itaLang)) {
			sql.append(" ORDER BY MTD_ORDINAMENTO_ITA ASC");
		} else {
			sql.append(" ORDER BY MTD_ORDINAMENTO_FRA ASC");
		}

		/*PROTECTED REGION END*/

		List<TaifDNazioneByFilterVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDNazioneDaoImpl::findByFilterVisible] ERROR esecuzione query", ex);
			throw new TaifDNazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDNazioneDaoImpl", "findByFilterVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifDNazioneDaoImpl::findByFilterVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byNazioneItaVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByNazioneItaVisibleDto> findByNazioneItaVisible(java.lang.Integer input)
			throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::findByNazioneItaVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT nazione.ID_NAZIONE as idNazione, nazione.NAZIONE_ITA as dsNazioneIta, nazione.MTD_ORDINAMENTO_ITA as ordinamentoIta, nazione.MTD_FLG_VISIBILE as flgVisible");

		sql.append(" FROM TAIF_D_NAZIONE nazione");

		sql.append(" WHERE ");

		sql.append("nazione.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R-149938325) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input);

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

	public List<TaifDNazioneByNazioneFraVisibleDto> findByNazioneFraVisible(java.lang.Integer input)
			throws TaifDNazioneDaoException {
		LOG.debug("[TaifDNazioneDaoImpl::findByNazioneFraVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT nazione.ID_NAZIONE as idNazione, nazione.NAZIONE_FRA as dsNazioneFra, nazione.MTD_ORDINAMENTO_FRA as ordinamentoFra, nazione.MTD_FLG_VISIBILE as flgVisible");

		sql.append(" FROM TAIF_D_NAZIONE nazione");

		sql.append(" WHERE ");

		sql.append("nazione.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R633490794) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input);

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
