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

/*PROTECTED REGION ID(R172671333) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTPersonaExt.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - ricercaNumeroAlboForestale (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTPersonaExtDaoImpl extends AbstractDAO implements TaifTPersonaExtDao {
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

	protected TaifTPersonaExtDaoRowMapper ricercaNumeroAlboForestaleRowMapper = new TaifTPersonaExtDaoRowMapper(null,
			TaifTPersonaExtRicercaNumeroAlboForestaleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_PERSONA";
	}

	/** 
		 * Implementazione del finder ricercaNumeroAlboForestale con Qdef
		 * @generated
		 */

	public List<TaifTPersonaExtRicercaNumeroAlboForestaleDto> findRicercaNumeroAlboForestale(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTPersonaExtDaoException {
		LOG.debug("[TaifTPersonaExtDaoImpl::findRicercaNumeroAlboForestale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		/*PROTECTED REGION ID(R-2077696990) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		
		sql.append("SELECT zzz.id_persona as idPersona,"+
					" array_to_string(z_cat(zzz.albo), '; '::text) as numeroAlboForestale"
					+" FROM ("
					+" SELECT" 
					+" persona.id_persona, Soggetto.codice::text||'-'::text||pratica.numero_albo::text as albo"
					+" FROM" 
					+" TAIF_T_PERSONA Persona,"
					+" TAIF_R_PERSONA_AZIENDA PersonaAzienda,"
					+" TAIF_T_AZIENDA Azienda,"
					+" TAIF_T_PRATICA Pratica,"
					+" taif_t_soggetto_gestore Soggetto"
					+" WHERE persona.id_persona = personaazienda.id_persona"
					+" and personaazienda.id_azienda = azienda.id_azienda"
					+" and azienda.id_azienda = pratica.fk_azienda"
					+" and pratica.fk_soggetto_gestore=Soggetto.id_soggetto_gestore"
					+" and pratica.fk_soggetto_gestore <> 0"
					+" and pratica.numero_albo >= '1'"
					+" and persona.id_persona = :idPersona"
					+" ) zzz"
					+" GROUP BY zzz.id_persona");

		paramMap.addValue("idPersona", new Integer(input.getIdPersona()));

		/*PROTECTED REGION END*/

		List<TaifTPersonaExtRicercaNumeroAlboForestaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ricercaNumeroAlboForestaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaExtDaoImpl::findRicercaNumeroAlboForestale] ERROR esecuzione query", ex);
			throw new TaifTPersonaExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaExtDaoImpl", "findRicercaNumeroAlboForestale", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaExtDaoImpl::findRicercaNumeroAlboForestale] END");
		}
		return list;
	}

}
