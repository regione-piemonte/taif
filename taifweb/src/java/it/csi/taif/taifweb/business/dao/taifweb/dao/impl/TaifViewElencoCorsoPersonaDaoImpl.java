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

/*PROTECTED REGION ID(R-1424429919) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifViewElencoCorsoPersona.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - corsiPerPersona (datagen::CustomFinder)
 *   - byCodiceFiscalePersona (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifViewElencoCorsoPersonaDaoImpl extends AbstractDAO implements TaifViewElencoCorsoPersonaDao {
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

	protected TaifViewElencoCorsoPersonaDaoRowMapper findAllRowMapper = new TaifViewElencoCorsoPersonaDaoRowMapper(null,
			TaifViewElencoCorsoPersonaDto.class, this);

	protected TaifViewElencoCorsoPersonaDaoRowMapper corsiPerPersonaRowMapper = new TaifViewElencoCorsoPersonaDaoRowMapper(
			null, TaifViewElencoCorsoPersonaCorsiPerPersonaDto.class, this);

	protected TaifViewElencoCorsoPersonaDaoRowMapper byCodiceFiscalePersonaRowMapper = new TaifViewElencoCorsoPersonaDaoRowMapper(
			null, TaifViewElencoCorsoPersonaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_V_ELENCO_CORSO_PERSONA";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_V_ELENCO_CORSO_PERSONA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifViewElencoCorsoPersonaDto> findAll() throws TaifViewElencoCorsoPersonaDaoException {
		LOG.debug("[TaifViewElencoCorsoPersonaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_PERSONA,ARRAY_TO_STRING FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifViewElencoCorsoPersonaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifViewElencoCorsoPersonaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifViewElencoCorsoPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifViewElencoCorsoPersonaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifViewElencoCorsoPersonaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder corsiPerPersona con Qdef
		 * @generated
		 */

	public List<TaifViewElencoCorsoPersonaCorsiPerPersonaDto> findCorsiPerPersona(java.lang.Integer input)
			throws TaifViewElencoCorsoPersonaDaoException {
		LOG.debug("[TaifViewElencoCorsoPersonaDaoImpl::findCorsiPerPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT viewElencoCorsoPersona.ID_PERSONA as idPersona, viewElencoCorsoPersona.ARRAY_TO_STRING as corsiPerPersona");

		sql.append(" FROM TAIF_V_ELENCO_CORSO_PERSONA viewElencoCorsoPersona");

		sql.append(" WHERE ");

		sql.append("ID_PERSONA=:idPersona");
		/*PROTECTED REGION ID(R-1151104386) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input);

		/*PROTECTED REGION END*/

		List<TaifViewElencoCorsoPersonaCorsiPerPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, corsiPerPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifViewElencoCorsoPersonaDaoImpl::findCorsiPerPersona] ERROR esecuzione query", ex);
			throw new TaifViewElencoCorsoPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifViewElencoCorsoPersonaDaoImpl", "findCorsiPerPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifViewElencoCorsoPersonaDaoImpl::findCorsiPerPersona] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceFiscalePersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifViewElencoCorsoPersonaDto> findByCodiceFiscalePersona(String input)
			throws TaifViewElencoCorsoPersonaDaoException {
		LOG.debug("[TaifViewElencoCorsoPersonaDaoImpl::findByCodiceFiscalePersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1277891654) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT cpv.id_persona, cpv.array_to_string ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1719713420) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM TAIF_V_ELENCO_CORSO_PERSONA cpv, taif_t_persona qpt");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1761269698) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("cpv.id_persona = qpt.id_persona ");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("AND UPPER(qpt.codice_fiscale) = upper(:codiceFiscale)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1360100460) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/
		List<TaifViewElencoCorsoPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscalePersonaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifViewElencoCorsoPersonaDaoImpl::findByCodiceFiscalePersona] esecuzione query", ex);
			throw new TaifViewElencoCorsoPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifViewElencoCorsoPersonaDaoImpl", "findByCodiceFiscalePersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifViewElencoCorsoPersonaDaoImpl::findByCodiceFiscalePersona] END");
		}
		return list;
	}

}
