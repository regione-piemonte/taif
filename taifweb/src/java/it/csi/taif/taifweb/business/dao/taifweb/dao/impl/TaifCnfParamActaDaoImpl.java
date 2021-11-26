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

/*PROTECTED REGION ID(R-355202739) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifCnfParamActa.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byCodice (datagen::CustomFinder)
  * - UPDATERS:
 *   - valoreByCodice (datagen::UpdateColumns)
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifCnfParamActaDaoImpl extends AbstractDAO implements TaifCnfParamActaDao {
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
	 * Updates selected columns in the TAIF_CNF_PARAM_ACTA table.
	 * @generated
	 */
	public void updateColumnsValoreByCodice(TaifCnfParamActaDto dto) throws TaifCnfParamActaDaoException {
		LOG.debug("[TaifCnfParamActaDaoImpl::updateColumnsValoreByCodice] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET VALORE = :VALORE  WHERE ID_CONFIG_PARAM_ACTA = :ID_CONFIG_PARAM_ACTA ";

		if (dto.getIdConfigParamActa() == null) {
			LOG.error("[TaifCnfParamActaDaoImpl::updateColumnsValoreByCodice] ERROR chiave primaria non impostata");
			throw new TaifCnfParamActaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [VALORE]
		params.addValue("VALORE", dto.getValore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_CONFIG_PARAM_ACTA]
		params.addValue("ID_CONFIG_PARAM_ACTA", dto.getIdConfigParamActa(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifCnfParamActaDaoImpl::updateColumnsValoreByCodice] END");
	}

	protected TaifCnfParamActaDaoRowMapper findByPrimaryKeyRowMapper = new TaifCnfParamActaDaoRowMapper(null,
			TaifCnfParamActaDto.class, this);

	protected TaifCnfParamActaDaoRowMapper findAllRowMapper = new TaifCnfParamActaDaoRowMapper(null,
			TaifCnfParamActaDto.class, this);

	protected TaifCnfParamActaDaoRowMapper byCodiceRowMapper = new TaifCnfParamActaDaoRowMapper(null,
			TaifCnfParamActaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_PARAM_ACTA";
	}

	/** 
	 * Returns all rows from the TAIF_CNF_PARAM_ACTA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfParamActaDto findByPrimaryKey(TaifCnfParamActaPk pk) throws TaifCnfParamActaDaoException {
		LOG.debug("[TaifCnfParamActaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_CONFIG_PARAM_ACTA,CODICE,VALORE FROM " + getTableName()
				+ " WHERE ID_CONFIG_PARAM_ACTA = :ID_CONFIG_PARAM_ACTA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONFIG_PARAM_ACTA]
		params.addValue("ID_CONFIG_PARAM_ACTA", pk.getIdConfigParamActa(), java.sql.Types.INTEGER);

		List<TaifCnfParamActaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfParamActaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifCnfParamActaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfParamActaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfParamActaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_PARAM_ACTA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfParamActaDto> findAll() throws TaifCnfParamActaDaoException {
		LOG.debug("[TaifCnfParamActaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_CONFIG_PARAM_ACTA,CODICE,VALORE FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifCnfParamActaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfParamActaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifCnfParamActaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfParamActaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfParamActaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodice
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfParamActaDto> findByCodice(java.lang.String input) throws TaifCnfParamActaDaoException {
		LOG.debug("[TaifCnfParamActaDaoImpl::findByCodice] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_CONFIG_PARAM_ACTA,CODICE,VALORE ");
		sql.append(" FROM TAIF_CNF_PARAM_ACTA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1147231981) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("CODICE = :CODICE");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1329339293) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("CODICE", input);

		/*PROTECTED REGION END*/
		List<TaifCnfParamActaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfParamActaDaoImpl::findByCodice] esecuzione query", ex);
			throw new TaifCnfParamActaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfParamActaDaoImpl", "findByCodice", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfParamActaDaoImpl::findByCodice] END");
		}
		return list;
	}

}
