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

/*PROTECTED REGION ID(R-447416495) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTOpfo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - bySoggettoGestore (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTOpfoDaoImpl extends AbstractDAO implements TaifTOpfoDao {
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
	 * Metodo di inserimento del DAO taifTOpfo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTOpfoPk
	 * @generated
	 */

	public TaifTOpfoPk insert(TaifTOpfoDto dto)

	{
		LOG.debug("[TaifTOpfoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA,FK_STATO_OPFO,FK_SOGGETTO_GESTORE,FLG_PUBBLICO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_PERSONA , :FK_STATO_OPFO , :FK_SOGGETTO_GESTORE , :FLG_PUBBLICO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_OPFO]
		params.addValue("FK_STATO_OPFO", dto.getFkStatoOpfo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_PUBBLICO]
		params.addValue("FLG_PUBBLICO", dto.getFlgPubblico(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdPersona(newKey);
		LOG.debug("[TaifTOpfoDaoImpl::insert] END");
		return dto.createPk();

	}

	protected TaifTOpfoDaoRowMapper findByPrimaryKeyRowMapper = new TaifTOpfoDaoRowMapper(null, TaifTOpfoDto.class,
			this);

	protected TaifTOpfoDaoRowMapper findAllRowMapper = new TaifTOpfoDaoRowMapper(null, TaifTOpfoDto.class, this);

	protected TaifTOpfoDaoRowMapper bySoggettoGestoreRowMapper = new TaifTOpfoDaoRowMapper(null,
			TaifTOpfoBySoggettoGestoreDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_OPFO";
	}

	/** 
	 * Returns all rows from the TAIF_T_OPFO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTOpfoDto findByPrimaryKey(TaifTOpfoPk pk) throws TaifTOpfoDaoException {
		LOG.debug("[TaifTOpfoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,FK_STATO_OPFO,FK_SOGGETTO_GESTORE,FLG_PUBBLICO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_PERSONA = :ID_PERSONA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		List<TaifTOpfoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTOpfoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTOpfoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTOpfoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_OPFO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTOpfoDto> findAll() throws TaifTOpfoDaoException {
		LOG.debug("[TaifTOpfoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,FK_STATO_OPFO,FK_SOGGETTO_GESTORE,FLG_PUBBLICO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTOpfoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTOpfoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTOpfoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTOpfoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder bySoggettoGestore con Qdef
		 * @generated
		 */

	public List<TaifTOpfoBySoggettoGestoreDto> findBySoggettoGestore(java.lang.Integer input)
			throws TaifTOpfoDaoException {
		LOG.debug("[TaifTOpfoDaoImpl::findBySoggettoGestore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT opfo.ID_PERSONA as idPersona, opfo.FK_STATO_OPFO as statoOpfo");

		sql.append(" FROM TAIF_T_OPFO opfo");

		sql.append(" WHERE ");

		sql.append("opfo.fk_soggetto_gestore=:idSoggettoGestore");
		/*PROTECTED REGION ID(R440147972) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idSoggettoGestore", input);

		/*PROTECTED REGION END*/

		List<TaifTOpfoBySoggettoGestoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, bySoggettoGestoreRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTOpfoDaoImpl::findBySoggettoGestore] ERROR esecuzione query", ex);
			throw new TaifTOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTOpfoDaoImpl", "findBySoggettoGestore", "esecuzione query", sql.toString());
			LOG.debug("[TaifTOpfoDaoImpl::findBySoggettoGestore] END");
		}
		return list;
	}

}
