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

/*PROTECTED REGION ID(R-2034392263) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTPersonaCorsiExt.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - corsiFinanziatiRegione (datagen::CustomFinder)
 *   - altriCorsi (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTPersonaCorsiExtDaoImpl extends AbstractDAO implements TaifTPersonaCorsiExtDao {
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

	protected TaifTPersonaCorsiExtDaoRowMapper corsiFinanziatiRegioneRowMapper = new TaifTPersonaCorsiExtDaoRowMapper(
			null, TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto.class, this);

	protected TaifTPersonaCorsiExtDaoRowMapper altriCorsiRowMapper = new TaifTPersonaCorsiExtDaoRowMapper(null,
			TaifTPersonaCorsiExtAltriCorsiDto.class, this);

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
		 * Implementazione del finder corsiFinanziatiRegione con Qdef
		 * @generated
		 */

	public List<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> findCorsiFinanziatiRegione(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTPersonaCorsiExtDaoException {
		LOG.debug("[TaifTPersonaCorsiExtDaoImpl::findCorsiFinanziatiRegione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		/*PROTECTED REGION ID(R1485741107) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		sql.append("select" + " DECODE (uf.sigla, NULL, '',uf.sigla)||'-'||uf.unita_formativa as dsUnitaFormativa,"
				+ "co.id_corso as idCorso,"
				+ " co.corso as titoloCorso," + " CASE WHEN  co.istat_sede is not null THEN co.istat_sede"
				+ " else af.istat_sede" + " END  as sedeCorso," + " af.ragione_sociale as dsAgenziaFormativa,"
				+ " TO_CHAR (co.data_inizio,'dd/mm/yyyy')||' - '||TO_CHAR (co.data_fine,'dd/mm/yyyy')  as periodoSvolgimento,"
				+ " co.nro_ore  as nOre,"
				+ " oc.flg_esito as flgEsito, "
				+ " DECODE (oc.flg_esito, 'F', 'FREQUENZA', 'P', 'FREQUENZA CON PROFITTO') as \"dsEsitoCorso\","
				+ " al.id_allegato as idAllegato" + " from" + " (((((taif_t_opfo o"
				+ " JOIN taif_r_opfo_corso oc ON o.id_persona=oc.id_persona)"
				+ " JOIN taif_t_corso co ON oc.id_corso= co.id_corso)"
				+ " JOIN taif_t_agenzia_formativa af ON co.fk_agenzia_formativa=af.id_agenzia_formativa)"
				+ " JOIN taif_d_unita_formativa uf ON co.fk_unita_formativa=uf.id_unita_formativa)"
				+ " LEFT JOIN taif_t_allegato al ON oc.id_corso=al.fk_corso and oc.id_persona=al.fk_persona)" + " where"
				+ " o.id_persona = :idPersona and" + " co.fk_unita_formativa <> 0 ORDER BY uf.id_unita_formativa");

		paramMap.addValue("idPersona", new Integer(input.getIdPersona()));

		/*PROTECTED REGION END*/

		List<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, corsiFinanziatiRegioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaCorsiExtDaoImpl::findCorsiFinanziatiRegione] ERROR esecuzione query", ex);
			throw new TaifTPersonaCorsiExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaCorsiExtDaoImpl", "findCorsiFinanziatiRegione", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaCorsiExtDaoImpl::findCorsiFinanziatiRegione] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder altriCorsi con Qdef
		 * @generated
		 */

	public List<TaifTPersonaCorsiExtAltriCorsiDto> findAltriCorsi(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTPersonaCorsiExtDaoException {
		LOG.debug("[TaifTPersonaCorsiExtDaoImpl::findAltriCorsi] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		/*PROTECTED REGION ID(R813134397) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append("SELECT co.id_corso as idCorso," 
			+" co.corso as titoloCorso,"
			+" oc.descrizione_altro as descrizioneAltroCorso,"
			+" al.id_allegato as idAllegato,"
			+" al.flg_scadenza as attestatoConScadenza,"
			+ "al.id_allegato as idAllegato,"
			+" DECODE (oc.flg_esito, 'F', 'FREQUENZA', 'P', 'FREQUENZA CON PROFITTO') as \"dsEsitoCorso\""
			+" from"
			+" (((taif_t_opfo o"
			+" JOIN taif_r_opfo_corso oc ON o.id_persona=oc.id_persona)"
			+" JOIN taif_t_corso co ON oc.id_corso= co.id_corso)"
			+" LEFT JOIN taif_t_allegato al ON oc.id_corso=al.fk_corso and oc.id_persona=al.fk_persona)"
			+" where"
			+" o.id_persona = :idPersona and"
			+" co.fk_unita_formativa = 0"
			+" ORDER BY co.id_corso;");
		
			paramMap.addValue("idPersona", new Integer(input.getIdPersona()));

		/*PROTECTED REGION END*/

		List<TaifTPersonaCorsiExtAltriCorsiDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, altriCorsiRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaCorsiExtDaoImpl::findAltriCorsi] ERROR esecuzione query", ex);
			throw new TaifTPersonaCorsiExtDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaCorsiExtDaoImpl", "findAltriCorsi", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaCorsiExtDaoImpl::findAltriCorsi] END");
		}
		return list;
	}

}
