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

/*PROTECTED REGION ID(R1898349515) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifVApplSchedaOkReale.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byPratica (datagen::CustomFinder)
 *   - byAzienda (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifVApplSchedaOkRealeDaoImpl extends AbstractDAO implements TaifVApplSchedaOkRealeDao {
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

	protected TaifVApplSchedaOkRealeDaoRowMapper byPraticaRowMapper = new TaifVApplSchedaOkRealeDaoRowMapper(null,
			TaifVApplSchedaOkRealeDto.class, this);

	protected TaifVApplSchedaOkRealeDaoRowMapper byAziendaRowMapper = new TaifVApplSchedaOkRealeDaoRowMapper(null,
			TaifVApplSchedaOkRealeDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_V_APPL_SCHEDA_OK_REALE";
	}

	/** 
	 * Implementazione del finder byPratica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVApplSchedaOkRealeDto> findByPratica(java.lang.Integer input)
			throws TaifVApplSchedaOkRealeDaoException {
		LOG.debug("[TaifVApplSchedaOkRealeDaoImpl::findByPratica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-2124804889) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT sok.ID_AZIENDA,");
		sql.append("sok.FLG_SEZ_1_1_ITA_OK,");
		sql.append("sok.FLG_SEZ_1_2_ITA_OK,");
		sql.append("sok.FLG_SEZ_2_1_ITA_OK,");
		sql.append("sok.FLG_SEZ_2_2_ITA_OK,");
		sql.append("sok.FLG_SEZ_3_1_ITA_OK,");
		sql.append("sok.FLG_SEZ_3_2_ITA_OK,");
		sql.append("sok.FLG_SEZ_3_3_ITA_OK,");
		sql.append("sok.FLG_SEZ_4_ITA_OK,");
		sql.append("sok.FLG_SEZ_5_1_ITA_OK,");
		sql.append("sok.FLG_SEZ_5_2_ITA_OK,");
		sql.append("sok.FLG_SEZ_6_ITA_OK,");
		sql.append("sok.FLG_SEZ_1_1_FRA_OK,");
		sql.append("sok.FLG_SEZ_1_2_FRA_OK,");
		sql.append("sok.FLG_SEZ_2_1_FRA_OK,");
		sql.append("sok.FLG_SEZ_2_2_FRA_OK,");
		sql.append("sok.FLG_SEZ_3_1_FRA_OK,");
		sql.append("sok.FLG_SEZ_3_3_FRA_OK,");
		sql.append("sok.FLG_SEZ_4_FRA_OK,");
		sql.append("sok.FLG_SEZ_5_2_FRA_OK,");
		sql.append("sok.FLG_SEZ_6_FRA_OK");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1034284629) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM TAIF_V_APPL_SCHEDA_OK_REALE sok, TAIF_T_PRATICA p");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2008291197) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("sok.ID_AZIENDA = p.FK_AZIENDA ");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("AND p.ID_PRATICA = :idPratica ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-2042596083) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPratica", input);

		/*PROTECTED REGION END*/
		List<TaifVApplSchedaOkRealeDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byPraticaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifVApplSchedaOkRealeDaoImpl::findByPratica] esecuzione query", ex);
			throw new TaifVApplSchedaOkRealeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifVApplSchedaOkRealeDaoImpl", "findByPratica", "esecuzione query", sql.toString());
			LOG.debug("[TaifVApplSchedaOkRealeDaoImpl::findByPratica] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byAzienda
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVApplSchedaOkRealeDto> findByAzienda(Integer input) throws TaifVApplSchedaOkRealeDaoException {
		LOG.debug("[TaifVApplSchedaOkRealeDaoImpl::findByAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_AZIENDA,FLG_SEZ_1_1_ITA_OK,FLG_SEZ_1_2_ITA_OK,FLG_SEZ_2_1_ITA_OK,FLG_SEZ_2_2_ITA_OK,FLG_SEZ_3_1_ITA_OK,FLG_SEZ_3_2_ITA_OK,FLG_SEZ_3_3_ITA_OK,FLG_SEZ_4_ITA_OK,FLG_SEZ_5_1_ITA_OK,FLG_SEZ_5_2_ITA_OK,FLG_SEZ_6_ITA_OK,FLG_SEZ_1_1_FRA_OK,FLG_SEZ_1_2_FRA_OK,FLG_SEZ_2_1_FRA_OK,FLG_SEZ_2_2_FRA_OK,FLG_SEZ_3_1_FRA_OK,FLG_SEZ_3_3_FRA_OK,FLG_SEZ_4_FRA_OK,FLG_SEZ_5_2_FRA_OK,FLG_SEZ_6_FRA_OK ");
		sql.append(" FROM TAIF_V_APPL_SCHEDA_OK_REALE");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-637132679) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_AZIENDA = :idAzienda");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1848609681) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/
		List<TaifVApplSchedaOkRealeDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAziendaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifVApplSchedaOkRealeDaoImpl::findByAzienda] esecuzione query", ex);
			throw new TaifVApplSchedaOkRealeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifVApplSchedaOkRealeDaoImpl", "findByAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifVApplSchedaOkRealeDaoImpl::findByAzienda] END");
		}
		return list;
	}

}
