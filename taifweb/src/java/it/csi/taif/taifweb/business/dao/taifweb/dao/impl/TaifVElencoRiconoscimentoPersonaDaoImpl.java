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

/*PROTECTED REGION ID(R1361434503) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifVElencoRiconoscimentoPersona.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - byIdPersona (datagen::CustomFinder)
 *   - byCodiceFiscalePersona (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifVElencoRiconoscimentoPersonaDaoImpl extends AbstractDAO
		implements
			TaifVElencoRiconoscimentoPersonaDao {
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

	protected TaifVElencoRiconoscimentoPersonaDaoRowMapper byIdPersonaRowMapper = new TaifVElencoRiconoscimentoPersonaDaoRowMapper(
			null, TaifVElencoRiconoscimentoPersonaDto.class, this);

	protected TaifVElencoRiconoscimentoPersonaDaoRowMapper byCodiceFiscalePersonaRowMapper = new TaifVElencoRiconoscimentoPersonaDaoRowMapper(
			null, TaifVElencoRiconoscimentoPersonaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_V_ELENCO_RICONOSCIMENTO_PERSONA";
	}

	/** 
	 * Implementazione del finder byIdPersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVElencoRiconoscimentoPersonaDto> findByIdPersona(Integer input)
			throws TaifVElencoRiconoscimentoPersonaDaoException {
		LOG.debug("[TaifVElencoRiconoscimentoPersonaDaoImpl::findByIdPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-1097687992) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT ID_PERSONA,ARRAY_TO_STRING ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1462967818) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM TAIF_V_ELENCO_RICONOSCIMENTO_PERSONA");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1902876668) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_PERSONA = :ID_PERSONA");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1015479186) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("ID_PERSONA", input);

		/*PROTECTED REGION END*/
		List<TaifVElencoRiconoscimentoPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdPersonaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifVElencoRiconoscimentoPersonaDaoImpl::findByIdPersona] esecuzione query", ex);
			throw new TaifVElencoRiconoscimentoPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifVElencoRiconoscimentoPersonaDaoImpl", "findByIdPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifVElencoRiconoscimentoPersonaDaoImpl::findByIdPersona] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceFiscalePersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVElencoRiconoscimentoPersonaDto> findByCodiceFiscalePersona(String input)
			throws TaifVElencoRiconoscimentoPersonaDaoException {
		LOG.debug("[TaifVElencoRiconoscimentoPersonaDaoImpl::findByCodiceFiscalePersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-267282855) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT rpv.id_persona, rpv.array_to_string ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-751489977) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM taif_v_elenco_riconoscimento_persona rpv, taif_t_persona qpt");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R-1811114037) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("rpv.id_persona = qpt.id_persona ");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("AND UPPER(qpt.codice_fiscale) = upper(:codice_fiscale)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-185074049) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codice_fiscale", input);

		/*PROTECTED REGION END*/
		List<TaifVElencoRiconoscimentoPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscalePersonaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifVElencoRiconoscimentoPersonaDaoImpl::findByCodiceFiscalePersona] esecuzione query", ex);
			throw new TaifVElencoRiconoscimentoPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifVElencoRiconoscimentoPersonaDaoImpl", "findByCodiceFiscalePersona",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifVElencoRiconoscimentoPersonaDaoImpl::findByCodiceFiscalePersona] END");
		}
		return list;
	}

}
