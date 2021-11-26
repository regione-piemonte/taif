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

/*PROTECTED REGION ID(R176119857) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDSpecie.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDSpecieDaoImpl extends AbstractDAO implements TaifDSpecieDao {
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
	 * Metodo di inserimento del DAO taifDSpecie. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDSpeciePk
	 * @generated
	 */

	public TaifDSpeciePk insert(TaifDSpecieDto dto)

	{
		LOG.debug("[TaifDSpecieDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_SPECIE,NOME_SPECIE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_SPECIE , :NOME_SPECIE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SPECIE]
		params.addValue("ID_SPECIE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_SPECIE]
		params.addValue("NOME_SPECIE", dto.getNomeSpecie(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdSpecie(newKey);
		LOG.debug("[TaifDSpecieDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_SPECIE table.
	 * @generated
	 */
	public void update(TaifDSpecieDto dto) throws TaifDSpecieDaoException {
		LOG.debug("[TaifDSpecieDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOME_SPECIE = :NOME_SPECIE ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE ,MTD_FLG_ITA_FRA = :MTD_FLG_ITA_FRA  WHERE ID_SPECIE = :ID_SPECIE ";

		if (dto.getIdSpecie() == null) {
			LOG.error("[TaifDSpecieDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDSpecieDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SPECIE]
		params.addValue("ID_SPECIE", dto.getIdSpecie(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_SPECIE]
		params.addValue("NOME_SPECIE", dto.getNomeSpecie(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDSpecieDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_SPECIE table.
	 * @generated
	 */

	public void delete(TaifDSpeciePk pk) throws TaifDSpecieDaoException {
		LOG.debug("[TaifDSpecieDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_SPECIE = :ID_SPECIE ";

		if (pk == null) {
			LOG.error("[TaifDSpecieDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDSpecieDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SPECIE]
		params.addValue("ID_SPECIE", pk.getIdSpecie(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDSpecieDaoImpl::delete] END");
	}

	protected TaifDSpecieDaoRowMapper findByPrimaryKeyRowMapper = new TaifDSpecieDaoRowMapper(null,
			TaifDSpecieDto.class, this);

	protected TaifDSpecieDaoRowMapper findAllRowMapper = new TaifDSpecieDaoRowMapper(null, TaifDSpecieDto.class, this);

	protected TaifDSpecieDaoRowMapper byFilterRowMapper = new TaifDSpecieDaoRowMapper(null,
			TaifDSpecieByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_SPECIE";
	}

	/** 
	 * Returns all rows from the TAIF_D_SPECIE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDSpecieDto findByPrimaryKey(TaifDSpeciePk pk) throws TaifDSpecieDaoException {
		LOG.debug("[TaifDSpecieDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_SPECIE,NOME_SPECIE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM " + getTableName()
						+ " WHERE ID_SPECIE = :ID_SPECIE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SPECIE]
		params.addValue("ID_SPECIE", pk.getIdSpecie(), java.sql.Types.INTEGER);

		List<TaifDSpecieDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDSpecieDto res = (TaifDSpecieDto) cache.get(pk);
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
			LOG.error("[TaifDSpecieDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDSpecieDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDSpecieDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDSpecieDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_SPECIE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDSpecieDto> findAll() throws TaifDSpecieDaoException {
		LOG.debug("[TaifDSpecieDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_SPECIE,NOME_SPECIE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDSpecieDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDSpecieDto> res = (List<TaifDSpecieDto>) cache.get("findAll_taifDSpecie_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDSpecie_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDSpecieDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDSpecieDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDSpecieDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDSpecieDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDSpecieByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDSpecieDaoException {
		LOG.debug("[TaifDSpecieDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT specie.ID_SPECIE as id, specie.NOME_SPECIE as nome, specie.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_SPECIE specie");

		sql.append(" WHERE ");

		sql.append("specie.MTD_FLG_VISIBILE=:visibile and specie.MTD_FLG_ITA_FRA=:flagItaFr");
		/*PROTECTED REGION ID(R-250712332) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDSpecieByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDSpecieDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDSpecieDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDSpecieDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDSpecieDaoImpl::findByFilter] END");
		}
		return list;
	}

}
