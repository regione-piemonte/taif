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

/*PROTECTED REGION ID(R1362952749) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifApplSchedaOk.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byPratica (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifApplSchedaOkDaoImpl extends AbstractDAO implements TaifApplSchedaOkDao {
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
	 * Metodo di inserimento del DAO taifApplSchedaOk. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifApplSchedaOkPk
	 * @generated
	 */

	public TaifApplSchedaOkPk insert(TaifApplSchedaOkDto dto)

	{
		LOG.debug("[TaifApplSchedaOkDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AZIENDA,FLG_SEZ_1_1_ITA_OK,FLG_SEZ_1_2_ITA_OK,FLG_SEZ_2_1_ITA_OK,FLG_SEZ_2_2_ITA_OK,FLG_SEZ_3_1_ITA_OK,FLG_SEZ_3_2_ITA_OK,FLG_SEZ_3_3_ITA_OK,FLG_SEZ_4_ITA_OK,FLG_SEZ_5_1_ITA_OK,FLG_SEZ_5_2_ITA_OK,FLG_SEZ_6_ITA_OK,FLG_SEZ_1_1_FRA_OK,FLG_SEZ_1_2_FRA_OK,FLG_SEZ_2_1_FRA_OK,FLG_SEZ_2_2_FRA_OK,FLG_SEZ_3_1_FRA_OK,FLG_SEZ_3_3_FRA_OK,FLG_SEZ_4_FRA_OK,FLG_SEZ_5_2_FRA_OK,FLG_SEZ_6_FRA_OK ) VALUES (  :ID_AZIENDA , :FLG_SEZ_1_1_ITA_OK , :FLG_SEZ_1_2_ITA_OK , :FLG_SEZ_2_1_ITA_OK , :FLG_SEZ_2_2_ITA_OK , :FLG_SEZ_3_1_ITA_OK , :FLG_SEZ_3_2_ITA_OK , :FLG_SEZ_3_3_ITA_OK , :FLG_SEZ_4_ITA_OK , :FLG_SEZ_5_1_ITA_OK , :FLG_SEZ_5_2_ITA_OK , :FLG_SEZ_6_ITA_OK , :FLG_SEZ_1_1_FRA_OK , :FLG_SEZ_1_2_FRA_OK , :FLG_SEZ_2_1_FRA_OK , :FLG_SEZ_2_2_FRA_OK , :FLG_SEZ_3_1_FRA_OK , :FLG_SEZ_3_3_FRA_OK , :FLG_SEZ_4_FRA_OK , :FLG_SEZ_5_2_FRA_OK , :FLG_SEZ_6_FRA_OK  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_1_1_ITA_OK]
		params.addValue("FLG_SEZ_1_1_ITA_OK", dto.getFlgSez11ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_1_2_ITA_OK]
		params.addValue("FLG_SEZ_1_2_ITA_OK", dto.getFlgSez12ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_2_1_ITA_OK]
		params.addValue("FLG_SEZ_2_1_ITA_OK", dto.getFlgSez21ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_2_2_ITA_OK]
		params.addValue("FLG_SEZ_2_2_ITA_OK", dto.getFlgSez22ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_1_ITA_OK]
		params.addValue("FLG_SEZ_3_1_ITA_OK", dto.getFlgSez31ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_2_ITA_OK]
		params.addValue("FLG_SEZ_3_2_ITA_OK", dto.getFlgSez32ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_3_ITA_OK]
		params.addValue("FLG_SEZ_3_3_ITA_OK", dto.getFlgSez33ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_4_ITA_OK]
		params.addValue("FLG_SEZ_4_ITA_OK", dto.getFlgSez4ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_5_1_ITA_OK]
		params.addValue("FLG_SEZ_5_1_ITA_OK", dto.getFlgSez51ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_5_2_ITA_OK]
		params.addValue("FLG_SEZ_5_2_ITA_OK", dto.getFlgSez52ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_6_ITA_OK]
		params.addValue("FLG_SEZ_6_ITA_OK", dto.getFlgSez6ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_1_1_FRA_OK]
		params.addValue("FLG_SEZ_1_1_FRA_OK", dto.getFlgSez11FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_1_2_FRA_OK]
		params.addValue("FLG_SEZ_1_2_FRA_OK", dto.getFlgSez12FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_2_1_FRA_OK]
		params.addValue("FLG_SEZ_2_1_FRA_OK", dto.getFlgSez21FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_2_2_FRA_OK]
		params.addValue("FLG_SEZ_2_2_FRA_OK", dto.getFlgSez22FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_1_FRA_OK]
		params.addValue("FLG_SEZ_3_1_FRA_OK", dto.getFlgSez31FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_3_FRA_OK]
		params.addValue("FLG_SEZ_3_3_FRA_OK", dto.getFlgSez33FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_4_FRA_OK]
		params.addValue("FLG_SEZ_4_FRA_OK", dto.getFlgSez4FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_5_2_FRA_OK]
		params.addValue("FLG_SEZ_5_2_FRA_OK", dto.getFlgSez52FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_6_FRA_OK]
		params.addValue("FLG_SEZ_6_FRA_OK", dto.getFlgSez6FraOk(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifApplSchedaOkDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_APPL_SCHEDA_OK table.
	 * @generated
	 */
	public void update(TaifApplSchedaOkDto dto) throws TaifApplSchedaOkDaoException {
		LOG.debug("[TaifApplSchedaOkDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_SEZ_1_1_ITA_OK = :FLG_SEZ_1_1_ITA_OK ,FLG_SEZ_1_2_ITA_OK = :FLG_SEZ_1_2_ITA_OK ,FLG_SEZ_2_1_ITA_OK = :FLG_SEZ_2_1_ITA_OK ,FLG_SEZ_2_2_ITA_OK = :FLG_SEZ_2_2_ITA_OK ,FLG_SEZ_3_1_ITA_OK = :FLG_SEZ_3_1_ITA_OK ,FLG_SEZ_3_2_ITA_OK = :FLG_SEZ_3_2_ITA_OK ,FLG_SEZ_3_3_ITA_OK = :FLG_SEZ_3_3_ITA_OK ,FLG_SEZ_4_ITA_OK = :FLG_SEZ_4_ITA_OK ,FLG_SEZ_5_1_ITA_OK = :FLG_SEZ_5_1_ITA_OK ,FLG_SEZ_5_2_ITA_OK = :FLG_SEZ_5_2_ITA_OK ,FLG_SEZ_6_ITA_OK = :FLG_SEZ_6_ITA_OK ,FLG_SEZ_1_1_FRA_OK = :FLG_SEZ_1_1_FRA_OK ,FLG_SEZ_1_2_FRA_OK = :FLG_SEZ_1_2_FRA_OK ,FLG_SEZ_2_1_FRA_OK = :FLG_SEZ_2_1_FRA_OK ,FLG_SEZ_2_2_FRA_OK = :FLG_SEZ_2_2_FRA_OK ,FLG_SEZ_3_1_FRA_OK = :FLG_SEZ_3_1_FRA_OK ,FLG_SEZ_3_3_FRA_OK = :FLG_SEZ_3_3_FRA_OK ,FLG_SEZ_4_FRA_OK = :FLG_SEZ_4_FRA_OK ,FLG_SEZ_5_2_FRA_OK = :FLG_SEZ_5_2_FRA_OK ,FLG_SEZ_6_FRA_OK = :FLG_SEZ_6_FRA_OK  WHERE ID_AZIENDA = :ID_AZIENDA ";

		if (dto.getIdAzienda() == null) {
			LOG.error("[TaifApplSchedaOkDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifApplSchedaOkDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_1_1_ITA_OK]
		params.addValue("FLG_SEZ_1_1_ITA_OK", dto.getFlgSez11ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_1_2_ITA_OK]
		params.addValue("FLG_SEZ_1_2_ITA_OK", dto.getFlgSez12ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_2_1_ITA_OK]
		params.addValue("FLG_SEZ_2_1_ITA_OK", dto.getFlgSez21ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_2_2_ITA_OK]
		params.addValue("FLG_SEZ_2_2_ITA_OK", dto.getFlgSez22ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_1_ITA_OK]
		params.addValue("FLG_SEZ_3_1_ITA_OK", dto.getFlgSez31ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_2_ITA_OK]
		params.addValue("FLG_SEZ_3_2_ITA_OK", dto.getFlgSez32ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_3_ITA_OK]
		params.addValue("FLG_SEZ_3_3_ITA_OK", dto.getFlgSez33ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_4_ITA_OK]
		params.addValue("FLG_SEZ_4_ITA_OK", dto.getFlgSez4ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_5_1_ITA_OK]
		params.addValue("FLG_SEZ_5_1_ITA_OK", dto.getFlgSez51ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_5_2_ITA_OK]
		params.addValue("FLG_SEZ_5_2_ITA_OK", dto.getFlgSez52ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_6_ITA_OK]
		params.addValue("FLG_SEZ_6_ITA_OK", dto.getFlgSez6ItaOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_1_1_FRA_OK]
		params.addValue("FLG_SEZ_1_1_FRA_OK", dto.getFlgSez11FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_1_2_FRA_OK]
		params.addValue("FLG_SEZ_1_2_FRA_OK", dto.getFlgSez12FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_2_1_FRA_OK]
		params.addValue("FLG_SEZ_2_1_FRA_OK", dto.getFlgSez21FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_2_2_FRA_OK]
		params.addValue("FLG_SEZ_2_2_FRA_OK", dto.getFlgSez22FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_1_FRA_OK]
		params.addValue("FLG_SEZ_3_1_FRA_OK", dto.getFlgSez31FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_3_3_FRA_OK]
		params.addValue("FLG_SEZ_3_3_FRA_OK", dto.getFlgSez33FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_4_FRA_OK]
		params.addValue("FLG_SEZ_4_FRA_OK", dto.getFlgSez4FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_5_2_FRA_OK]
		params.addValue("FLG_SEZ_5_2_FRA_OK", dto.getFlgSez52FraOk(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_SEZ_6_FRA_OK]
		params.addValue("FLG_SEZ_6_FRA_OK", dto.getFlgSez6FraOk(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifApplSchedaOkDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_APPL_SCHEDA_OK table.
	 * @generated
	 */

	public void delete(TaifApplSchedaOkPk pk) throws TaifApplSchedaOkDaoException {
		LOG.debug("[TaifApplSchedaOkDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_AZIENDA = :ID_AZIENDA ";

		if (pk == null) {
			LOG.error("[TaifApplSchedaOkDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifApplSchedaOkDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifApplSchedaOkDaoImpl::delete] END");
	}

	protected TaifApplSchedaOkDaoRowMapper findByPrimaryKeyRowMapper = new TaifApplSchedaOkDaoRowMapper(null,
			TaifApplSchedaOkDto.class, this);

	protected TaifApplSchedaOkDaoRowMapper findAllRowMapper = new TaifApplSchedaOkDaoRowMapper(null,
			TaifApplSchedaOkDto.class, this);

	protected TaifApplSchedaOkDaoRowMapper byPraticaRowMapper = new TaifApplSchedaOkDaoRowMapper(null,
			TaifApplSchedaOkByPraticaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_APPL_SCHEDA_OK";
	}

	/** 
	 * Returns all rows from the TAIF_APPL_SCHEDA_OK table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifApplSchedaOkDto findByPrimaryKey(TaifApplSchedaOkPk pk) throws TaifApplSchedaOkDaoException {
		LOG.debug("[TaifApplSchedaOkDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,FLG_SEZ_1_1_ITA_OK,FLG_SEZ_1_2_ITA_OK,FLG_SEZ_2_1_ITA_OK,FLG_SEZ_2_2_ITA_OK,FLG_SEZ_3_1_ITA_OK,FLG_SEZ_3_2_ITA_OK,FLG_SEZ_3_3_ITA_OK,FLG_SEZ_4_ITA_OK,FLG_SEZ_5_1_ITA_OK,FLG_SEZ_5_2_ITA_OK,FLG_SEZ_6_ITA_OK,FLG_SEZ_1_1_FRA_OK,FLG_SEZ_1_2_FRA_OK,FLG_SEZ_2_1_FRA_OK,FLG_SEZ_2_2_FRA_OK,FLG_SEZ_3_1_FRA_OK,FLG_SEZ_3_3_FRA_OK,FLG_SEZ_4_FRA_OK,FLG_SEZ_5_2_FRA_OK,FLG_SEZ_6_FRA_OK FROM "
						+ getTableName() + " WHERE ID_AZIENDA = :ID_AZIENDA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		List<TaifApplSchedaOkDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifApplSchedaOkDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifApplSchedaOkDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifApplSchedaOkDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifApplSchedaOkDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_APPL_SCHEDA_OK.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifApplSchedaOkDto> findAll() throws TaifApplSchedaOkDaoException {
		LOG.debug("[TaifApplSchedaOkDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,FLG_SEZ_1_1_ITA_OK,FLG_SEZ_1_2_ITA_OK,FLG_SEZ_2_1_ITA_OK,FLG_SEZ_2_2_ITA_OK,FLG_SEZ_3_1_ITA_OK,FLG_SEZ_3_2_ITA_OK,FLG_SEZ_3_3_ITA_OK,FLG_SEZ_4_ITA_OK,FLG_SEZ_5_1_ITA_OK,FLG_SEZ_5_2_ITA_OK,FLG_SEZ_6_ITA_OK,FLG_SEZ_1_1_FRA_OK,FLG_SEZ_1_2_FRA_OK,FLG_SEZ_2_1_FRA_OK,FLG_SEZ_2_2_FRA_OK,FLG_SEZ_3_1_FRA_OK,FLG_SEZ_3_3_FRA_OK,FLG_SEZ_4_FRA_OK,FLG_SEZ_5_2_FRA_OK,FLG_SEZ_6_FRA_OK FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifApplSchedaOkDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifApplSchedaOkDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifApplSchedaOkDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifApplSchedaOkDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifApplSchedaOkDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byPratica con Qdef
		 * @generated
		 */

	public List<TaifApplSchedaOkByPraticaDto> findByPratica(java.lang.Integer input)
			throws TaifApplSchedaOkDaoException {
		LOG.debug("[TaifApplSchedaOkDaoImpl::findByPratica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT sok.ID_AZIENDA, sok.FLG_SEZ_1_1_ITA_OK, sok.FLG_SEZ_1_2_ITA_OK, sok.FLG_SEZ_2_1_ITA_OK, sok.FLG_SEZ_2_2_ITA_OK, sok.FLG_SEZ_3_1_ITA_OK, sok.FLG_SEZ_3_2_ITA_OK, sok.FLG_SEZ_3_3_ITA_OK, sok.FLG_SEZ_4_ITA_OK, sok.FLG_SEZ_5_1_ITA_OK, sok.FLG_SEZ_5_2_ITA_OK, sok.FLG_SEZ_6_ITA_OK, sok.FLG_SEZ_1_1_FRA_OK, sok.FLG_SEZ_1_2_FRA_OK, sok.FLG_SEZ_2_1_FRA_OK, sok.FLG_SEZ_2_2_FRA_OK, sok.FLG_SEZ_3_1_FRA_OK, sok.FLG_SEZ_3_3_FRA_OK, sok.FLG_SEZ_4_FRA_OK, sok.FLG_SEZ_5_2_FRA_OK, sok.FLG_SEZ_6_FRA_OK");

		sql.append(" FROM TAIF_APPL_SCHEDA_OK sok, TAIF_T_PRATICA p");

		sql.append(" WHERE ");

		sql.append("sok.ID_AZIENDA = p.FK_AZIENDA");

		sql.append(" AND ");

		sql.append("p.ID_PRATICA = :idPratica");
		/*PROTECTED REGION ID(R-2022389912) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPratica", input);

		/*PROTECTED REGION END*/

		List<TaifApplSchedaOkByPraticaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byPraticaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifApplSchedaOkDaoImpl::findByPratica] ERROR esecuzione query", ex);
			throw new TaifApplSchedaOkDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifApplSchedaOkDaoImpl", "findByPratica", "esecuzione query", sql.toString());
			LOG.debug("[TaifApplSchedaOkDaoImpl::findByPratica] END");
		}
		return list;
	}

}
