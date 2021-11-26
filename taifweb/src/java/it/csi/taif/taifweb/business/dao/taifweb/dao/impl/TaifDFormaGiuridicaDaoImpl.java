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

/*PROTECTED REGION ID(R49613777) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDFormaGiuridica.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byFormaGiuridica (datagen::CustomFinder)
 *   -  (datagen::QBEFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDFormaGiuridicaDaoImpl extends AbstractDAO implements TaifDFormaGiuridicaDao {
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

	protected TaifDFormaGiuridicaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDFormaGiuridicaDaoRowMapper(null,
			TaifDFormaGiuridicaDto.class, this);

	protected TaifDFormaGiuridicaDaoRowMapper findAllRowMapper = new TaifDFormaGiuridicaDaoRowMapper(null,
			TaifDFormaGiuridicaDto.class, this);

	protected TaifDFormaGiuridicaDaoRowMapper byFilterRowMapper = new TaifDFormaGiuridicaDaoRowMapper(null,
			TaifDFormaGiuridicaByFilterDto.class, this);

	protected TaifDFormaGiuridicaDaoRowMapper byFormaGiuridicaRowMapper = new TaifDFormaGiuridicaDaoRowMapper(null,
			TaifDFormaGiuridicaByFormaGiuridicaDto.class, this);

	protected TaifDFormaGiuridicaDaoRowMapper RowMapper = new TaifDFormaGiuridicaDaoRowMapper(null,
			TaifDFormaGiuridicaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_FORMA_GIURIDICA";
	}

	/** 
	 * Returns all rows from the TAIF_D_FORMA_GIURIDICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDFormaGiuridicaDto findByPrimaryKey(TaifDFormaGiuridicaPk pk) throws TaifDFormaGiuridicaDaoException {
		LOG.debug("[TaifDFormaGiuridicaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_FORMA_GIURIDICA,FORMA_GIURIDICA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_FORMA_GIURIDICA = :ID_FORMA_GIURIDICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_FORMA_GIURIDICA]
		params.addValue("ID_FORMA_GIURIDICA", pk.getIdFormaGiuridica(), java.sql.Types.INTEGER);

		List<TaifDFormaGiuridicaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDFormaGiuridicaDto res = (TaifDFormaGiuridicaDto) cache.get(pk);
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
			LOG.error("[TaifDFormaGiuridicaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDFormaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFormaGiuridicaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFormaGiuridicaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_FORMA_GIURIDICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDFormaGiuridicaDto> findAll() throws TaifDFormaGiuridicaDaoException {
		LOG.debug("[TaifDFormaGiuridicaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_FORMA_GIURIDICA,FORMA_GIURIDICA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDFormaGiuridicaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDFormaGiuridicaDto> res = (List<TaifDFormaGiuridicaDto>) cache
					.get("findAll_taifDFormaGiuridica_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDFormaGiuridica_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDFormaGiuridicaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDFormaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFormaGiuridicaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFormaGiuridicaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDFormaGiuridicaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.FormaGiuridicaFilter input)
			throws TaifDFormaGiuridicaDaoException {
		LOG.debug("[TaifDFormaGiuridicaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT giuridica.ID_FORMA_GIURIDICA as id, giuridica.FORMA_GIURIDICA as forma, giuridica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_FORMA_GIURIDICA giuridica");

		sql.append(" WHERE ");

		sql.append("giuridica.MTD_FLG_VISIBILE=:visibile and giuridica.MTD_FLG_ITA_FRA=:flagItFr");
		/*PROTECTED REGION ID(R-1611511763) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDFormaGiuridicaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDFormaGiuridicaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDFormaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFormaGiuridicaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFormaGiuridicaDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFormaGiuridica con Qdef
		 * @generated
		 */

	public List<TaifDFormaGiuridicaByFormaGiuridicaDto> findByFormaGiuridica(
			it.csi.taif.taifweb.business.dao.taifweb.filter.FormaGiuridicaFilter input)
			throws TaifDFormaGiuridicaDaoException {
		LOG.debug("[TaifDFormaGiuridicaDaoImpl::findByFormaGiuridica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT giuridica.ID_FORMA_GIURIDICA as id, giuridica.FORMA_GIURIDICA as forma, giuridica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_FORMA_GIURIDICA giuridica");

		sql.append(" WHERE ");

		sql.append("giuridica.MTD_FLG_VISIBILE=:visibile and giuridica.MTD_FLG_ITA_FRA=:flagItFr ");
		/*PROTECTED REGION ID(R-241631915) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND ");
		sql.append("upper(giuridica.forma_giuridica) like upper(:formaGiuridica) ");

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItFr", input.getFlagItaFr());
		String formaGiuridica = "%" + input.getFormaGiuridica() + "%";
		paramMap.addValue("formaGiuridica", formaGiuridica);
		
		/*PROTECTED REGION END*/

		List<TaifDFormaGiuridicaByFormaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFormaGiuridicaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDFormaGiuridicaDaoImpl::findByFormaGiuridica] ERROR esecuzione query", ex);
			throw new TaifDFormaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFormaGiuridicaDaoImpl", "findByFormaGiuridica", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDFormaGiuridicaDaoImpl::findByFormaGiuridica] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder  query-by-example
	 * @generated
	 */
	public List<TaifDFormaGiuridicaDto> findByExamples(
			ArrayList<it.csi.taif.taifweb.business.dao.taifweb.qbe.TaifDFormaGiuridicaExample> positive,
			ArrayList<it.csi.taif.taifweb.business.dao.taifweb.qbe.TaifDFormaGiuridicaExample> negative)
			throws TaifDFormaGiuridicaDaoException {
		LOG.debug("[TaifDFormaGiuridicaDaoImpl::findByExamples] START");
		//verifiche consistenza esempi
		if (positive == null) {
			throw new TaifDFormaGiuridicaDaoException(
					"Il set degli esempi positivi e' null. Impossibile costruire la query.");
		}
		if (negative == null) {
			throw new TaifDFormaGiuridicaDaoException(
					"Il set degli esempi negativi e' null. Impossibile costruire la query.");
		}

		if (positive.isEmpty() && negative.isEmpty()) {
			throw new TaifDFormaGiuridicaDaoException(
					"Il set degli esempi positivi e negativi e' vuoto. Impossibile costruire la query.");
		}

		// personalizzare la query SQL relativa al finder
		QBEQueryBuilder<TaifDFormaGiuridicaExample> builder = new QBEQueryBuilder<TaifDFormaGiuridicaExample>(
				new TaifDFormaGiuridicaMetadata());
		StringBuilder sql = null;
		try {
			sql = new StringBuilder(builder.createFromExamples(positive, negative, false));
		} catch (StringIndexOutOfBoundsException e) {
			throw new TaifDFormaGiuridicaDaoException(
					"E' stato valorizzato almeno un esempio senza nessun FieldCheck associato.Impossibile creare la query.",
					e);
		} catch (IllegalArgumentException e) {
			throw new TaifDFormaGiuridicaDaoException(
					"E' stato valorizzato un campo di un esempio complesso non corrispondente alla PK della tabella di lookup.",
					e);
		}

		List<TaifDFormaGiuridicaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), new HashMap(), RowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifDFormaGiuridicaDaoImpl::findByExamples] ERROR esecuzione query", ex);
			throw new TaifDFormaGiuridicaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFormaGiuridicaDaoImpl", "findByExamples", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFormaGiuridicaDaoImpl::findByExamples] END");
		}
		return list;
	}

}
