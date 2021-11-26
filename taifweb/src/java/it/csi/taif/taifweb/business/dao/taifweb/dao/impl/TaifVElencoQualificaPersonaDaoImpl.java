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

/*PROTECTED REGION ID(R-1605803727) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifVElencoQualificaPersona.
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
public class TaifVElencoQualificaPersonaDaoImpl extends AbstractDAO implements TaifVElencoQualificaPersonaDao {
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

	protected TaifVElencoQualificaPersonaDaoRowMapper byIdPersonaRowMapper = new TaifVElencoQualificaPersonaDaoRowMapper(
			null, TaifVElencoQualificaPersonaDto.class, this);

	protected TaifVElencoQualificaPersonaDaoRowMapper byCodiceFiscalePersonaRowMapper = new TaifVElencoQualificaPersonaDaoRowMapper(
			null, TaifVElencoQualificaPersonaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_V_ELENCO_QUALIFICA_PERSONA";
	}

	/** 
	 * Implementazione del finder byIdPersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVElencoQualificaPersonaDto> findByIdPersona(Integer input)
			throws TaifVElencoQualificaPersonaDaoException {
		LOG.debug("[TaifVElencoQualificaPersonaDaoImpl::findByIdPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R-1049156073) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT ID_PERSONA,ARRAY_TO_STRING ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R865571717) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM TAIF_V_ELENCO_QUALIFICA_PERSONA");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1073158221) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("ID_PERSONA = :idPersona");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-966947267) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPersona", input);

		/*PROTECTED REGION END*/
		List<TaifVElencoQualificaPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdPersonaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifVElencoQualificaPersonaDaoImpl::findByIdPersona] esecuzione query", ex);
			throw new TaifVElencoQualificaPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifVElencoQualificaPersonaDaoImpl", "findByIdPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifVElencoQualificaPersonaDaoImpl::findByIdPersona] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byCodiceFiscalePersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVElencoQualificaPersonaDto> findByCodiceFiscalePersona(String input)
			throws TaifVElencoQualificaPersonaDaoException {
		LOG.debug("[TaifVElencoQualificaPersonaDaoImpl::findByCodiceFiscalePersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R1087513898) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT qpv.id_persona,ARRAY_TO_STRING ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1514325160) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM TAIF_V_ELENCO_QUALIFICA_PERSONA qpv, taif_t_persona qpt");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R310799066) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("qpv.id_persona = qpt.id_persona ");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("AND UPPER(qpt.codice_fiscale) = upper(:codiceFiscale)");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1169722704) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/
		List<TaifVElencoQualificaPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscalePersonaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifVElencoQualificaPersonaDaoImpl::findByCodiceFiscalePersona] esecuzione query", ex);
			throw new TaifVElencoQualificaPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifVElencoQualificaPersonaDaoImpl", "findByCodiceFiscalePersona",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifVElencoQualificaPersonaDaoImpl::findByCodiceFiscalePersona] END");
		}
		return list;
	}

}
