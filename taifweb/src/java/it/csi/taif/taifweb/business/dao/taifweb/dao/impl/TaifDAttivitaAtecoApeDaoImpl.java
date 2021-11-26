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

/*PROTECTED REGION ID(R8374033) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDAttivitaAtecoApe.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byCodiceAttivita (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - deleteById (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDAttivitaAtecoApeDaoImpl extends AbstractDAO implements TaifDAttivitaAtecoApeDao {
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
	 * Metodo di inserimento del DAO taifDAttivitaAtecoApe. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDAttivitaAtecoApePk
	 * @generated
	 */

	public TaifDAttivitaAtecoApePk insert(TaifDAttivitaAtecoApeDto dto)

	{
		LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ATTIVITA,CODICE,ATTIVITA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_ATTIVITA , :CODICE , :ATTIVITA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE]
		params.addValue("CODICE", dto.getCodice(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ATTIVITA]
		params.addValue("ATTIVITA", dto.getAttivita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAttivita(newKey);
		LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_ATTIVITA_ATECO_APE table.
	 * @generated
	 */

	public void delete(TaifDAttivitaAtecoApePk pk) throws TaifDAttivitaAtecoApeDaoException {
		LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ATTIVITA = :ID_ATTIVITA ";

		if (pk == null) {
			LOG.error("[TaifDAttivitaAtecoApeDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDAttivitaAtecoApeDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", pk.getIdAttivita(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::delete] END");
	}

	protected TaifDAttivitaAtecoApeDaoRowMapper findByPrimaryKeyRowMapper = new TaifDAttivitaAtecoApeDaoRowMapper(null,
			TaifDAttivitaAtecoApeDto.class, this);

	protected TaifDAttivitaAtecoApeDaoRowMapper findAllRowMapper = new TaifDAttivitaAtecoApeDaoRowMapper(null,
			TaifDAttivitaAtecoApeDto.class, this);

	protected TaifDAttivitaAtecoApeDaoRowMapper byFilterRowMapper = new TaifDAttivitaAtecoApeDaoRowMapper(null,
			TaifDAttivitaAtecoApeByFilterDto.class, this);

	protected TaifDAttivitaAtecoApeDaoRowMapper byCodiceAttivitaRowMapper = new TaifDAttivitaAtecoApeDaoRowMapper(null,
			TaifDAttivitaAtecoApeByCodiceAttivitaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_ATTIVITA_ATECO_APE";
	}

	/** 
	 * Returns all rows from the TAIF_D_ATTIVITA_ATECO_APE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDAttivitaAtecoApeDto findByPrimaryKey(TaifDAttivitaAtecoApePk pk)
			throws TaifDAttivitaAtecoApeDaoException {
		LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ATTIVITA,CODICE,ATTIVITA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_ATTIVITA = :ID_ATTIVITA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", pk.getIdAttivita(), java.sql.Types.INTEGER);

		List<TaifDAttivitaAtecoApeDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAttivitaAtecoApeDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDAttivitaAtecoApeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAttivitaAtecoApeDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ATTIVITA_ATECO_APE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAttivitaAtecoApeDto> findAll() throws TaifDAttivitaAtecoApeDaoException {
		LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ATTIVITA,CODICE,ATTIVITA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDAttivitaAtecoApeDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAttivitaAtecoApeDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDAttivitaAtecoApeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAttivitaAtecoApeDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDAttivitaAtecoApeByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDAttivitaAtecoApeDaoException {
		LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivita.ID_ATTIVITA as id, attivita.CODICE||' - '||attivita.ATTIVITA AS att, attivita.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_ATTIVITA_ATECO_APE attivita");

		sql.append(" WHERE ");

		sql.append("attivita.MTD_FLG_VISIBILE =:flagVisib and attivita.MTD_FLG_ITA_FRA=:flagIta");
		/*PROTECTED REGION ID(R1527314045) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("flagVisib", input.getFlagVisibile());
		paramMap.addValue("flagIta", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDAttivitaAtecoApeByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAttivitaAtecoApeDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDAttivitaAtecoApeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAttivitaAtecoApeDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceAttivita con Qdef
		 * @generated
		 */

	public List<TaifDAttivitaAtecoApeByCodiceAttivitaDto> findByCodiceAttivita(java.lang.String input)
			throws TaifDAttivitaAtecoApeDaoException {
		LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::findByCodiceAttivita] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivita.ID_ATTIVITA as id, attivita.MTD_ORDINAMENTO as ordin, attivita.CODICE as codice, attivita.ATTIVITA as attivita");

		sql.append(" FROM TAIF_D_ATTIVITA_ATECO_APE attivita");

		sql.append(" WHERE ");

		sql.append("attivita.CODICE =:idCodice");
		/*PROTECTED REGION ID(R-1335850662) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idCodice", input);

		/*PROTECTED REGION END*/

		List<TaifDAttivitaAtecoApeByCodiceAttivitaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceAttivitaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDAttivitaAtecoApeDaoImpl::findByCodiceAttivita] ERROR esecuzione query", ex);
			throw new TaifDAttivitaAtecoApeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAttivitaAtecoApeDaoImpl", "findByCodiceAttivita", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDAttivitaAtecoApeDaoImpl::findByCodiceAttivita] END");
		}
		return list;
	}

}
