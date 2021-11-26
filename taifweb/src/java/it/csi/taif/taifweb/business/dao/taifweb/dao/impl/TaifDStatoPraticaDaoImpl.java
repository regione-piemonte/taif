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

/*PROTECTED REGION ID(R-747620047) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDStatoPratica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byFilterStatoPraticaIta (datagen::CustomFinder)
 *   - byFilterStatoPraticaFra (datagen::CustomFinder)
 *   - elencoStatiPraticaItalia (datagen::CustomFinder)
 *   - elencoStatiPraticaFrance (datagen::CustomFinder)
 *   - elencoSottoStatiPraticaItalia (datagen::CustomFinder)
 *   - elencoSottoStatiPraticaFrance (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDStatoPraticaDaoImpl extends AbstractDAO implements TaifDStatoPraticaDao {
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
	 * Metodo di inserimento del DAO taifDStatoPratica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDStatoPraticaPk
	 * @generated
	 */

	public TaifDStatoPraticaPk insert(TaifDStatoPraticaDto dto)

	{
		LOG.debug("[TaifDStatoPraticaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_STATO_PRATICA,FK_STATO_PADRE,STATO_PRATICA_ITA,STATO_PRATICA_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_STATO_PRATICA , :FK_STATO_PADRE , :STATO_PRATICA_ITA , :STATO_PRATICA_FRA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_PRATICA]
		params.addValue("ID_STATO_PRATICA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_PADRE]
		params.addValue("FK_STATO_PADRE", dto.getFkStatoPadre(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [STATO_PRATICA_ITA]
		params.addValue("STATO_PRATICA_ITA", dto.getStatoPraticaIta(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [STATO_PRATICA_FRA]
		params.addValue("STATO_PRATICA_FRA", dto.getStatoPraticaFra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdStatoPratica(newKey);
		LOG.debug("[TaifDStatoPraticaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_STATO_PRATICA table.
	 * @generated
	 */

	public void delete(TaifDStatoPraticaPk pk) throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_STATO_PRATICA = :ID_STATO_PRATICA ";

		if (pk == null) {
			LOG.error("[TaifDStatoPraticaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDStatoPraticaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_PRATICA]
		params.addValue("ID_STATO_PRATICA", pk.getIdStatoPratica(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDStatoPraticaDaoImpl::delete] END");
	}

	protected TaifDStatoPraticaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper findAllRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper byFilterRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaByFilterDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper byFilterStatoPraticaItaRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaByFilterStatoPraticaItaDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper byFilterStatoPraticaFraRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaByFilterStatoPraticaFraDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper elencoStatiPraticaItaliaRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaElencoStatiPraticaItaliaDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper elencoStatiPraticaFranceRowMapper = new TaifDStatoPraticaDaoRowMapper(null,
			TaifDStatoPraticaElencoStatiPraticaFranceDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper elencoSottoStatiPraticaItaliaRowMapper = new TaifDStatoPraticaDaoRowMapper(
			null, TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto.class, this);

	protected TaifDStatoPraticaDaoRowMapper elencoSottoStatiPraticaFranceRowMapper = new TaifDStatoPraticaDaoRowMapper(
			null, TaifDStatoPraticaElencoSottoStatiPraticaFranceDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_STATO_PRATICA";
	}

	/** 
	 * Returns all rows from the TAIF_D_STATO_PRATICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDStatoPraticaDto findByPrimaryKey(TaifDStatoPraticaPk pk) throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_PRATICA,FK_STATO_PADRE,STATO_PRATICA_ITA,STATO_PRATICA_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
						+ getTableName() + " WHERE ID_STATO_PRATICA = :ID_STATO_PRATICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STATO_PRATICA]
		params.addValue("ID_STATO_PRATICA", pk.getIdStatoPratica(), java.sql.Types.INTEGER);

		List<TaifDStatoPraticaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDStatoPraticaDto res = (TaifDStatoPraticaDto) cache.get(pk);
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
			LOG.error("[TaifDStatoPraticaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_STATO_PRATICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDStatoPraticaDto> findAll() throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STATO_PRATICA,FK_STATO_PADRE,STATO_PRATICA_ITA,STATO_PRATICA_FRA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDStatoPraticaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDStatoPraticaDto> res = (List<TaifDStatoPraticaDto>) cache.get("findAll_taifDStatoPratica_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDStatoPratica_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoPratica.ID_STATO_PRATICA as id, statoPratica.FK_STATO_PADRE as idPadre, statoPratica.STATO_PRATICA_ITA as ita, statoPratica.STATO_PRATICA_FRA as fra, statoPratica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R-70959884) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDStatoPraticaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterStatoPraticaIta con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaByFilterStatoPraticaItaDto> findByFilterStatoPraticaIta(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findByFilterStatoPraticaIta] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoPratica.ID_STATO_PRATICA as id, statoPratica.FK_STATO_PADRE as idPadre, statoPratica.STATO_PRATICA_ITA as ita, statoPratica.STATO_PRATICA_FRA as fra, statoPratica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.MTD_FLG_VISIBILE=:visibile and statoPratica.STATO_PRATICA_ITA=:codiceStatoPratica");
		/*PROTECTED REGION ID(R-562816739) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceStatoPratica", input.getStatoPraticaLang());
		paramMap.addValue("visibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifDStatoPraticaByFilterStatoPraticaItaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterStatoPraticaItaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findByFilterStatoPraticaIta] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findByFilterStatoPraticaIta", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findByFilterStatoPraticaIta] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterStatoPraticaFra con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaByFilterStatoPraticaFraDto> findByFilterStatoPraticaFra(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findByFilterStatoPraticaFra] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoPratica.ID_STATO_PRATICA as id, statoPratica.FK_STATO_PADRE as idPadre, statoPratica.STATO_PRATICA_ITA as ita, statoPratica.STATO_PRATICA_FRA as fra, statoPratica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.MTD_FLG_VISIBILE=:visibile and statoPratica.STATO_PRATICA_FRA=:codiceStatoPratica");
		/*PROTECTED REGION ID(R1023679486) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("codiceStatoPratica", input.getStatoPraticaLang());

		/*PROTECTED REGION END*/

		List<TaifDStatoPraticaByFilterStatoPraticaFraDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterStatoPraticaFraRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findByFilterStatoPraticaFra] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findByFilterStatoPraticaFra", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findByFilterStatoPraticaFra] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder elencoStatiPraticaItalia con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaElencoStatiPraticaItaliaDto> findElencoStatiPraticaItalia(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findElencoStatiPraticaItalia] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoPratica.ID_STATO_PRATICA as id, statoPratica.STATO_PRATICA_ITA as statoPratica, statoPratica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.MTD_FLG_VISIBILE=:visibile and fk_stato_padre is null");
		/*PROTECTED REGION ID(R-1194262372) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifDStatoPraticaElencoStatiPraticaItaliaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, elencoStatiPraticaItaliaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findElencoStatiPraticaItalia] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findElencoStatiPraticaItalia", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findElencoStatiPraticaItalia] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder elencoStatiPraticaFrance con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaElencoStatiPraticaFranceDto> findElencoStatiPraticaFrance(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findElencoStatiPraticaFrance] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoPratica.ID_STATO_PRATICA as id, statoPratica.STATO_PRATICA_FRA as statoPratica, statoPratica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.MTD_FLG_VISIBILE=:visibile and fk_stato_padre is null");
		/*PROTECTED REGION ID(R-1430233393) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		//paramMap.addValue("codiceStatoPratica", input.getStatoPraticaLang());

		/*PROTECTED REGION END*/

		List<TaifDStatoPraticaElencoStatiPraticaFranceDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, elencoStatiPraticaFranceRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findElencoStatiPraticaFrance] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findElencoStatiPraticaFrance", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findElencoStatiPraticaFrance] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder elencoSottoStatiPraticaItalia con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto> findElencoSottoStatiPraticaItalia(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findElencoSottoStatiPraticaItalia] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoPratica.ID_STATO_PRATICA as id, statoPratica.STATO_PRATICA_ITA as statoPratica, statoPratica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.fk_stato_padre=:statoPraticaPadre");
		/*PROTECTED REGION ID(R-2017660757) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("statoPraticaPadre", input.getfKStatoPraticaPadre());

		/*PROTECTED REGION END*/

		List<TaifDStatoPraticaElencoSottoStatiPraticaItaliaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, elencoSottoStatiPraticaItaliaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findElencoSottoStatiPraticaItalia] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findElencoSottoStatiPraticaItalia", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findElencoSottoStatiPraticaItalia] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder elencoSottoStatiPraticaFrance con Qdef
		 * @generated
		 */

	public List<TaifDStatoPraticaElencoSottoStatiPraticaFranceDto> findElencoSottoStatiPraticaFrance(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StatoPraticaFilter input)
			throws TaifDStatoPraticaDaoException {
		LOG.debug("[TaifDStatoPraticaDaoImpl::findElencoSottoStatiPraticaFrance] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT statoPratica.ID_STATO_PRATICA as id, statoPratica.STATO_PRATICA_FRA as statoPratica, statoPratica.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.fk_stato_padre=:statoPraticaPadre");
		/*PROTECTED REGION ID(R2041335518) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("statoPraticaPadre", input.getfKStatoPraticaPadre());

		/*PROTECTED REGION END*/

		List<TaifDStatoPraticaElencoSottoStatiPraticaFranceDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, elencoSottoStatiPraticaFranceRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDStatoPraticaDaoImpl::findElencoSottoStatiPraticaFrance] ERROR esecuzione query", ex);
			throw new TaifDStatoPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDStatoPraticaDaoImpl", "findElencoSottoStatiPraticaFrance", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDStatoPraticaDaoImpl::findElencoSottoStatiPraticaFrance] END");
		}
		return list;
	}

}
