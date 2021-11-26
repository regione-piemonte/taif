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

/*PROTECTED REGION ID(R334779839) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDMateriale.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibleOrdin (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDMaterialeDaoImpl extends AbstractDAO implements TaifDMaterialeDao {
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
	 * Metodo di inserimento del DAO taifDMateriale. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDMaterialePk
	 * @generated
	 */

	public TaifDMaterialePk insert(TaifDMaterialeDto dto)

	{
		LOG.debug("[TaifDMaterialeDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_MATERIALE,MATERIALE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,FLG_VIVAI_ARB ) VALUES (  :ID_MATERIALE , :MATERIALE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :FLG_VIVAI_ARB  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MATERIALE]
		params.addValue("ID_MATERIALE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [MATERIALE]
		params.addValue("MATERIALE", dto.getMateriale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_VIVAI_ARB]
		params.addValue("FLG_VIVAI_ARB", dto.getFlgVivaiArb(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdMateriale(newKey);
		LOG.debug("[TaifDMaterialeDaoImpl::insert] END");
		return dto.createPk();

	}

	protected TaifDMaterialeDaoRowMapper findByPrimaryKeyRowMapper = new TaifDMaterialeDaoRowMapper(null,
			TaifDMaterialeDto.class, this);

	protected TaifDMaterialeDaoRowMapper findAllRowMapper = new TaifDMaterialeDaoRowMapper(null,
			TaifDMaterialeDto.class, this);

	protected TaifDMaterialeDaoRowMapper byVisibleOrdinRowMapper = new TaifDMaterialeDaoRowMapper(null,
			TaifDMaterialeByVisibleOrdinDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_MATERIALE";
	}

	/** 
	 * Returns all rows from the TAIF_D_MATERIALE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDMaterialeDto findByPrimaryKey(TaifDMaterialePk pk) throws TaifDMaterialeDaoException {
		LOG.debug("[TaifDMaterialeDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_MATERIALE,MATERIALE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,FLG_VIVAI_ARB FROM " + getTableName()
						+ " WHERE ID_MATERIALE = :ID_MATERIALE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MATERIALE]
		params.addValue("ID_MATERIALE", pk.getIdMateriale(), java.sql.Types.INTEGER);

		List<TaifDMaterialeDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDMaterialeDto res = (TaifDMaterialeDto) cache.get(pk);
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
			LOG.error("[TaifDMaterialeDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDMaterialeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDMaterialeDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDMaterialeDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_MATERIALE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDMaterialeDto> findAll() throws TaifDMaterialeDaoException {
		LOG.debug("[TaifDMaterialeDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_MATERIALE,MATERIALE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,FLG_VIVAI_ARB FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDMaterialeDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDMaterialeDto> res = (List<TaifDMaterialeDto>) cache.get("findAll_taifDMateriale_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDMateriale_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDMaterialeDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDMaterialeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDMaterialeDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDMaterialeDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibleOrdin con Qdef
		 * @generated
		 */

	public List<TaifDMaterialeByVisibleOrdinDto> findByVisibleOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.MaterialeFilter input) throws TaifDMaterialeDaoException {
		LOG.debug("[TaifDMaterialeDaoImpl::findByVisibleOrdin] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT m.ID_MATERIALE as id, m.MATERIALE as materiale, m.MTD_ORDINAMENTO as ordin, m.FLG_VIVAI_ARB as flagVivai");

		sql.append(" FROM TAIF_D_MATERIALE m");

		sql.append(" WHERE ");

		sql.append("m.mtd_flg_visibile=:visibile and m.flg_vivai_arb=:vivaiArb");
		/*PROTECTED REGION ID(R-1431550133) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("vivaiArb", input.getFlagVivaiArb());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDMaterialeByVisibleOrdinDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleOrdinRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDMaterialeDaoImpl::findByVisibleOrdin] ERROR esecuzione query", ex);
			throw new TaifDMaterialeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDMaterialeDaoImpl", "findByVisibleOrdin", "esecuzione query", sql.toString());
			LOG.debug("[TaifDMaterialeDaoImpl::findByVisibleOrdin] END");
		}
		return list;
	}

}
