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

/*PROTECTED REGION ID(R-1092470139) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifCnfConfigUtente.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFilter (datagen::CustomFinder)
 *   - profiloByCodiceFiscale (datagen::CustomFinder)
 *   - profiloByIdPersonaIdSoggettoGestore (datagen::CustomFinder)
 *   - profiloByCodiceFiscaleOperatore (datagen::CustomFinder)
  * - UPDATERS:
 *   - configUtente (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifCnfConfigUtenteDaoImpl extends AbstractDAO implements TaifCnfConfigUtenteDao {
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
	 * Metodo di inserimento del DAO taifCnfConfigUtente. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifCnfConfigUtentePk
	 * @generated
	 */

	public TaifCnfConfigUtentePk insert(TaifCnfConfigUtenteDto dto)

	{
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CONFIG_UTENTE,FK_PROFILO_UTENTE,FK_PERSONA,FK_SOGGETTO_GESTORE,NR_ACCESSI,DATA_PRIMO_ACCESSO,DATA_ULTIMO_ACCESSO ) VALUES (  :ID_CONFIG_UTENTE , :FK_PROFILO_UTENTE , :FK_PERSONA , :FK_SOGGETTO_GESTORE , :NR_ACCESSI , :DATA_PRIMO_ACCESSO , :DATA_ULTIMO_ACCESSO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONFIG_UTENTE]
		params.addValue("ID_CONFIG_UTENTE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PROFILO_UTENTE]
		params.addValue("FK_PROFILO_UTENTE", dto.getFkProfiloUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA]
		params.addValue("FK_PERSONA", dto.getFkPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NR_ACCESSI]
		params.addValue("NR_ACCESSI", dto.getNrAccessi(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_PRIMO_ACCESSO]
		params.addValue("DATA_PRIMO_ACCESSO", dto.getDataPrimoAccesso(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_ULTIMO_ACCESSO]
		params.addValue("DATA_ULTIMO_ACCESSO", dto.getDataUltimoAccesso(), java.sql.Types.TIMESTAMP);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdConfigUtente(newKey);
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_CNF_CONFIG_UTENTE table.
	 * @generated
	 */
	public void updateColumnsConfigUtente(TaifCnfConfigUtenteDto dto) throws TaifCnfConfigUtenteDaoException {
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::updateColumnsConfigUtente] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_PROFILO_UTENTE = :FK_PROFILO_UTENTE ,FK_PERSONA = :FK_PERSONA ,FK_SOGGETTO_GESTORE = :FK_SOGGETTO_GESTORE ,NR_ACCESSI = :NR_ACCESSI ,DATA_ULTIMO_ACCESSO = :DATA_ULTIMO_ACCESSO ,DATA_PRIMO_ACCESSO = :DATA_PRIMO_ACCESSO  WHERE ID_CONFIG_UTENTE = :ID_CONFIG_UTENTE ";

		if (dto.getIdConfigUtente() == null) {
			LOG.error("[TaifCnfConfigUtenteDaoImpl::updateColumnsConfigUtente] ERROR chiave primaria non impostata");
			throw new TaifCnfConfigUtenteDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_PROFILO_UTENTE]
		params.addValue("FK_PROFILO_UTENTE", dto.getFkProfiloUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA]
		params.addValue("FK_PERSONA", dto.getFkPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NR_ACCESSI]
		params.addValue("NR_ACCESSI", dto.getNrAccessi(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_ULTIMO_ACCESSO]
		params.addValue("DATA_ULTIMO_ACCESSO", dto.getDataUltimoAccesso(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_PRIMO_ACCESSO]
		params.addValue("DATA_PRIMO_ACCESSO", dto.getDataPrimoAccesso(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ID_CONFIG_UTENTE]
		params.addValue("ID_CONFIG_UTENTE", dto.getIdConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::updateColumnsConfigUtente] END");
	}

	/** 
	 * Deletes a single row in the TAIF_CNF_CONFIG_UTENTE table.
	 * @generated
	 */

	public void delete(TaifCnfConfigUtentePk pk) throws TaifCnfConfigUtenteDaoException {
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_CONFIG_UTENTE = :ID_CONFIG_UTENTE ";

		if (pk == null) {
			LOG.error("[TaifCnfConfigUtenteDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifCnfConfigUtenteDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONFIG_UTENTE]
		params.addValue("ID_CONFIG_UTENTE", pk.getIdConfigUtente(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::delete] END");
	}

	protected TaifCnfConfigUtenteDaoRowMapper findAllRowMapper = new TaifCnfConfigUtenteDaoRowMapper(null,
			TaifCnfConfigUtenteDto.class, this);

	protected TaifCnfConfigUtenteDaoRowMapper findByPrimaryKeyRowMapper = new TaifCnfConfigUtenteDaoRowMapper(null,
			TaifCnfConfigUtenteDto.class, this);

	protected TaifCnfConfigUtenteDaoRowMapper byFilterRowMapper = new TaifCnfConfigUtenteDaoRowMapper(null,
			TaifCnfConfigUtenteByFilterDto.class, this);

	protected TaifCnfConfigUtenteDaoRowMapper profiloByCodiceFiscaleRowMapper = new TaifCnfConfigUtenteDaoRowMapper(
			null, TaifCnfConfigUtenteProfiloByCodiceFiscaleDto.class, this);

	protected TaifCnfConfigUtenteDaoRowMapper profiloByIdPersonaIdSoggettoGestoreRowMapper = new TaifCnfConfigUtenteDaoRowMapper(
			null, TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto.class, this);

	protected TaifCnfConfigUtenteDaoRowMapper profiloByCodiceFiscaleOperatoreRowMapper = new TaifCnfConfigUtenteDaoRowMapper(
			null, TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_CONFIG_UTENTE";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_CONFIG_UTENTE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfConfigUtenteDto> findAll() throws TaifCnfConfigUtenteDaoException {
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CONFIG_UTENTE,FK_PROFILO_UTENTE,FK_PERSONA,FK_SOGGETTO_GESTORE,NR_ACCESSI,DATA_PRIMO_ACCESSO,DATA_ULTIMO_ACCESSO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifCnfConfigUtenteDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfConfigUtenteDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifCnfConfigUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfConfigUtenteDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfConfigUtenteDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the TAIF_CNF_CONFIG_UTENTE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfConfigUtenteDto findByPrimaryKey(TaifCnfConfigUtentePk pk) throws TaifCnfConfigUtenteDaoException {
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CONFIG_UTENTE,FK_PROFILO_UTENTE,FK_PERSONA,FK_SOGGETTO_GESTORE,NR_ACCESSI,DATA_PRIMO_ACCESSO,DATA_ULTIMO_ACCESSO FROM "
						+ getTableName() + " WHERE ID_CONFIG_UTENTE = :ID_CONFIG_UTENTE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CONFIG_UTENTE]
		params.addValue("ID_CONFIG_UTENTE", pk.getIdConfigUtente(), java.sql.Types.INTEGER);

		List<TaifCnfConfigUtenteDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfConfigUtenteDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifCnfConfigUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfConfigUtenteDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfConfigUtenteDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifCnfConfigUtenteByFilterDto> findByFilter(
			it.csi.taif.topforweb.business.dao.topfor.filter.ConfigUtenteFilter input)
			throws TaifCnfConfigUtenteDaoException {
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT utente.ID_CONFIG_UTENTE as id, utente.FK_PROFILO_UTENTE as idProf, utente.FK_PERSONA as idPers, utente.FK_SOGGETTO_GESTORE as idGestore, utente.NR_ACCESSI as accessi");

		sql.append(" FROM TAIF_CNF_CONFIG_UTENTE utente");

		sql.append(" WHERE ");

		sql.append("utente.fk_profilo_utente=:idProfiloUtente and utente.fk_persona=:idPersona ");
		/*PROTECTED REGION ID(R-159335633) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idProfiloUtente", input.getIdProfiloUtente());
		paramMap.addValue("idPersona", input.getIdPersona());

		/*PROTECTED REGION END*/

		List<TaifCnfConfigUtenteByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfConfigUtenteDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifCnfConfigUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfConfigUtenteDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfConfigUtenteDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder profiloByCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifCnfConfigUtenteProfiloByCodiceFiscaleDto> findProfiloByCodiceFiscale(java.lang.String input)
			throws TaifCnfConfigUtenteDaoException {
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::findProfiloByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT cu.ID_CONFIG_UTENTE as idConfigUtente, cu.FK_PROFILO_UTENTE as idProfiloUtente, cu.FK_PERSONA as idPersona, cu.FK_SOGGETTO_GESTORE as idSoggettoGestore, cu.NR_ACCESSI as accessi, pu.PROFILO_UTENTE as profiloUtente");

		sql.append(" FROM TAIF_CNF_CONFIG_UTENTE cu, TAIF_CNF_PROFILO_UTENTE pu, TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append("cu.FK_PERSONA = persona.ID_PERSONA AND cu.FK_PROFILO_UTENTE = pu.ID_PROFILO_UTENTE");

		sql.append(" AND ");

		sql.append(
				"(persona.codice_fiscale = :codiceFiscale OR persona.n_rsi_msa = :codiceFiscale ) AND pu.fk_procedura = 2");
		/*PROTECTED REGION ID(R-188204876) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND cu.fk_profilo_utente in (7,8,9)");

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/

		List<TaifCnfConfigUtenteProfiloByCodiceFiscaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, profiloByCodiceFiscaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfConfigUtenteDaoImpl::findProfiloByCodiceFiscale] ERROR esecuzione query", ex);
			throw new TaifCnfConfigUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfConfigUtenteDaoImpl", "findProfiloByCodiceFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifCnfConfigUtenteDaoImpl::findProfiloByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder profiloByIdPersonaIdSoggettoGestore con Qdef
		 * @generated
		 */

	public List<TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto> findProfiloByIdPersonaIdSoggettoGestore(
			it.csi.taif.topforweb.business.dao.topfor.filter.PersonaSoggettogestoreFilter input)
			throws TaifCnfConfigUtenteDaoException {
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::findProfiloByIdPersonaIdSoggettoGestore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT configUtente.FK_PERSONA as idPersona, configUtente.ID_CONFIG_UTENTE as idConfigUtente, configUtente.FK_SOGGETTO_GESTORE as idSoggettoGestore, configUtente.FK_PERSONA as idProfiloUtente");

		sql.append(" FROM TAIF_CNF_CONFIG_UTENTE configUtente, TAIF_CNF_PROFILO_UTENTE profiloUtente");

		sql.append(" WHERE ");

		sql.append("configUtente.FK_PROFILO_UTENTE = profiloUtente.ID_PROFILO_UTENTE");

		sql.append(" AND ");

		sql.append(
				"configUtente.fk_persona =:idPersona AND configUtente.fk_soggetto_gestore =:idSoggettoGestore AND  configUtente.fk_profilo_utente =:idProfiloUtente AND profiloUtente.fk_procedura = 2");
		/*PROTECTED REGION ID(R-815056489) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input.getIdPersona());
		paramMap.addValue("idSoggettoGestore", input.getIdSoggettoGestore());
		paramMap.addValue("idProfiloUtente", input.getIdProfilo());

		/*PROTECTED REGION END*/

		List<TaifCnfConfigUtenteProfiloByIdPersonaIdSoggettoGestoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, profiloByIdPersonaIdSoggettoGestoreRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfConfigUtenteDaoImpl::findProfiloByIdPersonaIdSoggettoGestore] ERROR esecuzione query",
					ex);
			throw new TaifCnfConfigUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfConfigUtenteDaoImpl", "findProfiloByIdPersonaIdSoggettoGestore",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifCnfConfigUtenteDaoImpl::findProfiloByIdPersonaIdSoggettoGestore] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder profiloByCodiceFiscaleOperatore con Qdef
		 * @generated
		 */

	public List<TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto> findProfiloByCodiceFiscaleOperatore(
			java.lang.String input) throws TaifCnfConfigUtenteDaoException {
		LOG.debug("[TaifCnfConfigUtenteDaoImpl::findProfiloByCodiceFiscaleOperatore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT cu.ID_CONFIG_UTENTE as idConfigUtente, cu.FK_PROFILO_UTENTE as idProfiloUtente, cu.FK_PERSONA as idPersona, cu.FK_SOGGETTO_GESTORE as idSoggettoGestore, cu.NR_ACCESSI as accessi, pu.PROFILO_UTENTE as profiloUtente");

		sql.append(" FROM TAIF_CNF_CONFIG_UTENTE cu, TAIF_CNF_PROFILO_UTENTE pu, TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append("cu.FK_PERSONA = persona.ID_PERSONA AND cu.FK_PROFILO_UTENTE = pu.ID_PROFILO_UTENTE");

		sql.append(" AND ");

		sql.append(
				"(persona.codice_fiscale = :codiceFiscale OR persona.n_rsi_msa = :codiceFiscale ) AND pu.fk_procedura = 2");
		/*PROTECTED REGION ID(R-1398308133) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/

		List<TaifCnfConfigUtenteProfiloByCodiceFiscaleOperatoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, profiloByCodiceFiscaleOperatoreRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfConfigUtenteDaoImpl::findProfiloByCodiceFiscaleOperatore] ERROR esecuzione query", ex);
			throw new TaifCnfConfigUtenteDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfConfigUtenteDaoImpl", "findProfiloByCodiceFiscaleOperatore",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifCnfConfigUtenteDaoImpl::findProfiloByCodiceFiscaleOperatore] END");
		}
		return list;
	}

}
