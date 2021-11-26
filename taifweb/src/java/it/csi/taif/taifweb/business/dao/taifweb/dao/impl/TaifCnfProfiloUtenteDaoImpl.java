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

/*PROTECTED REGION ID(R1000788461) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifCnfProfiloUtente.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byProfiloUtente (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifCnfProfiloUtenteDaoImpl extends AbstractDAO implements TaifCnfProfiloUtenteDao {
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
	 * Metodo di inserimento del DAO taifCnfProfiloUtente. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifCnfProfiloUtentePk
	 * @generated
	 */

	public TaifCnfProfiloUtentePk insert(TaifCnfProfiloUtenteDto dto)

	{
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PROFILO_UTENTE,PROFILO_UTENTE,MTD_FLG_ATTIVO,FK_PROCEDURA ) VALUES (  :ID_PROFILO_UTENTE , :PROFILO_UTENTE , :MTD_FLG_ATTIVO , :FK_PROCEDURA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PROFILO_UTENTE]
		params.addValue("ID_PROFILO_UTENTE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROFILO_UTENTE]
		params.addValue("PROFILO_UTENTE", dto.getProfiloUtente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ATTIVO]
		params.addValue("MTD_FLG_ATTIVO", dto.getMtdFlgAttivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PROCEDURA]
		params.addValue("FK_PROCEDURA", dto.getFkProcedura(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdProfiloUtente(newKey);
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_CNF_PROFILO_UTENTE table.
	 * @generated
	 */
	public void update(TaifCnfProfiloUtenteDto dto) throws TaifCnfProfiloUtenteDaoException {
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET PROFILO_UTENTE = :PROFILO_UTENTE ,MTD_FLG_ATTIVO = :MTD_FLG_ATTIVO ,FK_PROCEDURA = :FK_PROCEDURA  WHERE ID_PROFILO_UTENTE = :ID_PROFILO_UTENTE ";

		if (dto.getIdProfiloUtente() == null) {
			LOG.error("[TaifCnfProfiloUtenteDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifCnfProfiloUtenteDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PROFILO_UTENTE]
		params.addValue("ID_PROFILO_UTENTE", dto.getIdProfiloUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROFILO_UTENTE]
		params.addValue("PROFILO_UTENTE", dto.getProfiloUtente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ATTIVO]
		params.addValue("MTD_FLG_ATTIVO", dto.getMtdFlgAttivo(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FK_PROCEDURA]
		params.addValue("FK_PROCEDURA", dto.getFkProcedura(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_CNF_PROFILO_UTENTE table.
	 * @generated
	 */

	public void delete(TaifCnfProfiloUtentePk pk) throws TaifCnfProfiloUtenteDaoException {
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_PROFILO_UTENTE = :ID_PROFILO_UTENTE ";

		if (pk == null) {
			LOG.error("[TaifCnfProfiloUtenteDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifCnfProfiloUtenteDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PROFILO_UTENTE]
		params.addValue("ID_PROFILO_UTENTE", pk.getIdProfiloUtente(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::delete] END");
	}

	protected TaifCnfProfiloUtenteDaoRowMapper findByPrimaryKeyRowMapper = new TaifCnfProfiloUtenteDaoRowMapper(null,
			TaifCnfProfiloUtenteDto.class, this);

	protected TaifCnfProfiloUtenteDaoRowMapper findAllRowMapper = new TaifCnfProfiloUtenteDaoRowMapper(null,
			TaifCnfProfiloUtenteDto.class, this);

	protected TaifCnfProfiloUtenteDaoRowMapper byProfiloUtenteRowMapper = new TaifCnfProfiloUtenteDaoRowMapper(null,
			TaifCnfProfiloUtenteByProfiloUtenteDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_PROFILO_UTENTE";
	}

	/** 
	 * Returns all rows from the TAIF_CNF_PROFILO_UTENTE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfProfiloUtenteDto findByPrimaryKey(TaifCnfProfiloUtentePk pk) throws TaifCnfProfiloUtenteDaoException {
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PROFILO_UTENTE,PROFILO_UTENTE,MTD_FLG_ATTIVO,FK_PROCEDURA FROM " + getTableName()
						+ " WHERE ID_PROFILO_UTENTE = :ID_PROFILO_UTENTE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PROFILO_UTENTE]
		params.addValue("ID_PROFILO_UTENTE", pk.getIdProfiloUtente(), java.sql.Types.INTEGER);

		List<TaifCnfProfiloUtenteDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfProfiloUtenteDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifCnfProfiloUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfProfiloUtenteDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifCnfProfiloUtenteDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_PROFILO_UTENTE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfProfiloUtenteDto> findAll() throws TaifCnfProfiloUtenteDaoException {
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PROFILO_UTENTE,PROFILO_UTENTE,MTD_FLG_ATTIVO,FK_PROCEDURA FROM " + getTableName());

		sql.append(" ORDER BY ID_CONFIG_UTENTE ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifCnfProfiloUtenteDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfProfiloUtenteDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifCnfProfiloUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfProfiloUtenteDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfProfiloUtenteDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byProfiloUtente con Qdef
		 * @generated
		 */

	public List<TaifCnfProfiloUtenteByProfiloUtenteDto> findByProfiloUtente(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloFilter input)
			throws TaifCnfProfiloUtenteDaoException {
		LOG.debug("[TaifCnfProfiloUtenteDaoImpl::findByProfiloUtente] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT cnfProfiloUtente.ID_PROFILO_UTENTE as idProfilo, cnfProfiloUtente.PROFILO_UTENTE as profiloUtente, cnfProfiloUtente.FK_PROCEDURA as procedura");

		sql.append(" FROM TAIF_CNF_PROFILO_UTENTE cnfProfiloUtente");

		sql.append(" WHERE ");

		sql.append(
				"cnfProfiloUtente.profilo_utente=:profiloUtente and cnfProfiloUtente.fk_procedura=:idProcedura and cnfProfiloUtente.mtd_flg_attivo=:flagAttivo");
		/*PROTECTED REGION ID(R1628077550) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("profiloUtente", input.getProfiloUtente());
		paramMap.addValue("idProcedura", input.getIdProcedura());
		paramMap.addValue("flagAttivo", input.getFlagAttivo());

		/*PROTECTED REGION END*/

		List<TaifCnfProfiloUtenteByProfiloUtenteDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byProfiloUtenteRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfProfiloUtenteDaoImpl::findByProfiloUtente] ERROR esecuzione query", ex);
			throw new TaifCnfProfiloUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfProfiloUtenteDaoImpl", "findByProfiloUtente", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifCnfProfiloUtenteDaoImpl::findByProfiloUtente] END");
		}
		return list;
	}

}
