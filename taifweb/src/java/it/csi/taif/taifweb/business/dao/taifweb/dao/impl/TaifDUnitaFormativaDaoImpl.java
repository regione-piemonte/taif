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

/*PROTECTED REGION ID(R-1976681007) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDUnitaFormativa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDUnitaFormativaDaoImpl extends AbstractDAO implements TaifDUnitaFormativaDao {
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
	 * Metodo di inserimento del DAO taifDUnitaFormativa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDUnitaFormativaPk
	 * @generated
	 */

	public TaifDUnitaFormativaPk insert(TaifDUnitaFormativaDto dto)

	{
		LOG.debug("[TaifDUnitaFormativaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_UNITA_FORMATIVA,FK_AMBITO_FORMATIVO,FK_SOGGETTO_GESTORE,UNITA_FORMATIVA,SIGLA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_UNITA_FORMATIVA , :FK_AMBITO_FORMATIVO , :FK_SOGGETTO_GESTORE , :UNITA_FORMATIVA , :SIGLA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_FORMATIVA]
		params.addValue("ID_UNITA_FORMATIVA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AMBITO_FORMATIVO]
		params.addValue("FK_AMBITO_FORMATIVO", dto.getFkAmbitoFormativo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [UNITA_FORMATIVA]
		params.addValue("UNITA_FORMATIVA", dto.getUnitaFormativa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [SIGLA]
		params.addValue("SIGLA", dto.getSigla(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdUnitaFormativa(newKey);
		LOG.debug("[TaifDUnitaFormativaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_UNITA_FORMATIVA table.
	 * @generated
	 */

	public void delete(TaifDUnitaFormativaPk pk) throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_UNITA_FORMATIVA = :ID_UNITA_FORMATIVA ";

		if (pk == null) {
			LOG.error("[TaifDUnitaFormativaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDUnitaFormativaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_FORMATIVA]
		params.addValue("ID_UNITA_FORMATIVA", pk.getIdUnitaFormativa(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDUnitaFormativaDaoImpl::delete] END");
	}

	protected TaifDUnitaFormativaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDUnitaFormativaDaoRowMapper(null,
			TaifDUnitaFormativaDto.class, this);

	protected TaifDUnitaFormativaDaoRowMapper findAllRowMapper = new TaifDUnitaFormativaDaoRowMapper(null,
			TaifDUnitaFormativaDto.class, this);

	protected TaifDUnitaFormativaDaoRowMapper byFilterRowMapper = new TaifDUnitaFormativaDaoRowMapper(null,
			TaifDUnitaFormativaByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_UNITA_FORMATIVA";
	}

	/** 
	 * Returns all rows from the TAIF_D_UNITA_FORMATIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDUnitaFormativaDto findByPrimaryKey(TaifDUnitaFormativaPk pk) throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_UNITA_FORMATIVA,FK_AMBITO_FORMATIVO,FK_SOGGETTO_GESTORE,UNITA_FORMATIVA,SIGLA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_UNITA_FORMATIVA = :ID_UNITA_FORMATIVA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_UNITA_FORMATIVA]
		params.addValue("ID_UNITA_FORMATIVA", pk.getIdUnitaFormativa(), java.sql.Types.INTEGER);

		List<TaifDUnitaFormativaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDUnitaFormativaDto res = (TaifDUnitaFormativaDto) cache.get(pk);
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
			LOG.error("[TaifDUnitaFormativaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDUnitaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaFormativaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDUnitaFormativaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_UNITA_FORMATIVA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDUnitaFormativaDto> findAll() throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_UNITA_FORMATIVA,FK_AMBITO_FORMATIVO,FK_SOGGETTO_GESTORE,UNITA_FORMATIVA,SIGLA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDUnitaFormativaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDUnitaFormativaDto> res = (List<TaifDUnitaFormativaDto>) cache
					.get("findAll_taifDUnitaFormativa_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDUnitaFormativa_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaFormativaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDUnitaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaFormativaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDUnitaFormativaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDUnitaFormativaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaFormativaFilter input)
			throws TaifDUnitaFormativaDaoException {
		LOG.debug("[TaifDUnitaFormativaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT formativa.ID_UNITA_FORMATIVA as id, formativa.FK_AMBITO_FORMATIVO as ambito, formativa.FK_AMBITO_FORMATIVO as gestore, formativa.UNITA_FORMATIVA as unita, formativa.SIGLA as sigla, formativa.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_UNITA_FORMATIVA formativa");

		sql.append(" WHERE ");

		sql.append(
				"(formativa.mtd_flg_visibile=:visibile and formativa.mtd_flg_ita_fra=:flagItaFr) and formativa.fk_ambito_formativo=:idAmbitoFormativo and formativa.fk_soggetto_gestore=:idSoggettoGestore");
		/*PROTECTED REGION ID(R1354265213) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("idAmbitoFormativo", input.getIdAmbitoFormativo());
		paramMap.addValue("idSoggettoGestore", input.getIdSoggettoGestore());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDUnitaFormativaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDUnitaFormativaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDUnitaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDUnitaFormativaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDUnitaFormativaDaoImpl::findByFilter] END");
		}
		return list;
	}

}
