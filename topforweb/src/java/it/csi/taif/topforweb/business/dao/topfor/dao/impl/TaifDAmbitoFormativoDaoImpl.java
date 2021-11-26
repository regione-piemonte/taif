/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.impl;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.mapper.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.impl.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-1648792975) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDAmbitoFormativo.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDAmbitoFormativoDaoImpl extends AbstractDAO implements TaifDAmbitoFormativoDao {
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

	protected TaifDAmbitoFormativoDaoRowMapper byFilterRowMapper = new TaifDAmbitoFormativoDaoRowMapper(null,
			TaifDAmbitoFormativoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_AMBITO_FORMATIVO";
	}

	/** 
	 * Implementazione del finder byFilter
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDAmbitoFormativoDto> findByFilter(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDAmbitoFormativoDaoException {
		LOG.debug("[TaifDAmbitoFormativoDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_AMBITO_FORMATIVO,AMBITO_FORMATIVO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ");
		sql.append(" FROM TAIF_D_AMBITO_FORMATIVO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-2083153200) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("MTD_FLG_VISIBILE = 1");
		sql.append(" AND mtd_flg_ita_fra = :mtd_flg_ita_fra");
		/*PROTECTED REGION END*/

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC"); /*PROTECTED REGION ID(R-28353510) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("mtd_flg_ita_fra", input.getFlagItaFr());

		/*PROTECTED REGION END*/
		List<TaifDAmbitoFormativoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifDAmbitoFormativoDaoImpl::findByFilter] esecuzione query", ex);
			throw new TaifDAmbitoFormativoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDAmbitoFormativoDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDAmbitoFormativoDaoImpl::findByFilter] END");
		}
		return list;
	}

}
