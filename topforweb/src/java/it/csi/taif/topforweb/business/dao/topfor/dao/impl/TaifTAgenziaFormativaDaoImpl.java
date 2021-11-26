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

/*PROTECTED REGION ID(R1250140997) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTAgenziaFormativa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFilterVisible (datagen::CustomFinder)
 *   - byFilterSoggettoGestore (datagen::CustomFinder)
 *   - byUnitaFormativaPersona (datagen::CustomFinder)
  * - UPDATERS:
 *   - byIdAgenziaFormativa (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTAgenziaFormativaDaoImpl extends AbstractDAO implements TaifTAgenziaFormativaDao {
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
	 * Metodo di inserimento del DAO taifTAgenziaFormativa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAgenziaFormativaPk
	 * @generated
	 */

	public TaifTAgenziaFormativaPk insert(TaifTAgenziaFormativaDto dto)

	{
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AGENZIA_FORMATIVA,CODICE_FISCALE,PARTITA_IVA,RAGIONE_SOCIALE,CODICE_PSR,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,ISTAT_SEDE,COMUNE_ESTERO,INDIRIZZO,CAP,FK_CONFIG_UTENTE,FLG_VISIBILE,MTD_ORDINAMENTO ) VALUES (  :ID_AGENZIA_FORMATIVA , :CODICE_FISCALE , :PARTITA_IVA , :RAGIONE_SOCIALE , :CODICE_PSR , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :ISTAT_SEDE , :COMUNE_ESTERO , :INDIRIZZO , :CAP , :FK_CONFIG_UTENTE , :FLG_VISIBILE , :MTD_ORDINAMENTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AGENZIA_FORMATIVA]
		params.addValue("ID_AGENZIA_FORMATIVA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PARTITA_IVA]
		params.addValue("PARTITA_IVA", dto.getPartitaIva(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RAGIONE_SOCIALE]
		params.addValue("RAGIONE_SOCIALE", dto.getRagioneSociale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_PSR]
		params.addValue("CODICE_PSR", dto.getCodicePsr(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ISTAT_SEDE]
		params.addValue("ISTAT_SEDE", dto.getIstatSede(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_VISIBILE]
		params.addValue("FLG_VISIBILE", dto.getFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAgenziaFormativa(newKey);
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_T_AGENZIA_FORMATIVA table.
	 * @generated
	 */
	public void updateColumnsByIdAgenziaFormativa(TaifTAgenziaFormativaDto dto)
			throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::updateColumnsByIdAgenziaFormativa] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET CODICE_PSR = :CODICE_PSR ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,ISTAT_SEDE = :ISTAT_SEDE ,COMUNE_ESTERO = :COMUNE_ESTERO ,INDIRIZZO = :INDIRIZZO ,CAP = :CAP ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_AGENZIA_FORMATIVA = :ID_AGENZIA_FORMATIVA ";

		if (dto.getIdAgenziaFormativa() == null) {
			LOG.error(
					"[TaifTAgenziaFormativaDaoImpl::updateColumnsByIdAgenziaFormativa] ERROR chiave primaria non impostata");
			throw new TaifTAgenziaFormativaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [CODICE_PSR]
		params.addValue("CODICE_PSR", dto.getCodicePsr(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [ISTAT_SEDE]
		params.addValue("ISTAT_SEDE", dto.getIstatSede(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AGENZIA_FORMATIVA]
		params.addValue("ID_AGENZIA_FORMATIVA", dto.getIdAgenziaFormativa(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::updateColumnsByIdAgenziaFormativa] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_AGENZIA_FORMATIVA table.
	 * @generated
	 */

	public void delete(TaifTAgenziaFormativaPk pk) throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_AGENZIA_FORMATIVA = :ID_AGENZIA_FORMATIVA ";

		if (pk == null) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTAgenziaFormativaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AGENZIA_FORMATIVA]
		params.addValue("ID_AGENZIA_FORMATIVA", pk.getIdAgenziaFormativa(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::delete] END");
	}

	protected TaifTAgenziaFormativaDaoRowMapper findAllRowMapper = new TaifTAgenziaFormativaDaoRowMapper(null,
			TaifTAgenziaFormativaDto.class, this);

	protected TaifTAgenziaFormativaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTAgenziaFormativaDaoRowMapper(null,
			TaifTAgenziaFormativaDto.class, this);

	protected TaifTAgenziaFormativaDaoRowMapper byFilterVisibleRowMapper = new TaifTAgenziaFormativaDaoRowMapper(null,
			TaifTAgenziaFormativaByFilterVisibleDto.class, this);

	protected TaifTAgenziaFormativaDaoRowMapper byFilterSoggettoGestoreRowMapper = new TaifTAgenziaFormativaDaoRowMapper(
			null, TaifTAgenziaFormativaByFilterSoggettoGestoreDto.class, this);

	protected TaifTAgenziaFormativaDaoRowMapper byUnitaFormativaPersonaRowMapper = new TaifTAgenziaFormativaDaoRowMapper(
			null, TaifTAgenziaFormativaByUnitaFormativaPersonaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_AGENZIA_FORMATIVA";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_AGENZIA_FORMATIVA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAgenziaFormativaDto> findAll() throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AGENZIA_FORMATIVA,CODICE_FISCALE,PARTITA_IVA,RAGIONE_SOCIALE,CODICE_PSR,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,ISTAT_SEDE,COMUNE_ESTERO,INDIRIZZO,CAP,FK_CONFIG_UTENTE,FLG_VISIBILE,MTD_ORDINAMENTO FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTAgenziaFormativaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTAgenziaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAgenziaFormativaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAgenziaFormativaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the TAIF_T_AGENZIA_FORMATIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAgenziaFormativaDto findByPrimaryKey(TaifTAgenziaFormativaPk pk)
			throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AGENZIA_FORMATIVA,CODICE_FISCALE,PARTITA_IVA,RAGIONE_SOCIALE,CODICE_PSR,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,ISTAT_SEDE,COMUNE_ESTERO,INDIRIZZO,CAP,FK_CONFIG_UTENTE,FLG_VISIBILE,MTD_ORDINAMENTO FROM "
						+ getTableName() + " WHERE ID_AGENZIA_FORMATIVA = :ID_AGENZIA_FORMATIVA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AGENZIA_FORMATIVA]
		params.addValue("ID_AGENZIA_FORMATIVA", pk.getIdAgenziaFormativa(), java.sql.Types.INTEGER);

		List<TaifTAgenziaFormativaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTAgenziaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAgenziaFormativaDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifTAgenziaFormativaByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByFilterVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT agenziaFormativa.ID_AGENZIA_FORMATIVA as idAgenziaFormativa, agenziaFormativa.RAGIONE_SOCIALE as denominazioneAgenziaFormativa");

		sql.append(" FROM TAIF_T_AGENZIA_FORMATIVA agenziaFormativa");

		sql.append(" WHERE ");

		sql.append("agenziaFormativa.FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R661329111) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifTAgenziaFormativaByFilterVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::findByFilterVisible] ERROR esecuzione query", ex);
			throw new TaifTAgenziaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAgenziaFormativaDaoImpl", "findByFilterVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByFilterVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterSoggettoGestore con Qdef
		 * @generated
		 */

	public List<TaifTAgenziaFormativaByFilterSoggettoGestoreDto> findByFilterSoggettoGestore(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByFilterSoggettoGestore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT agenziaFormativa.ID_AGENZIA_FORMATIVA as idAgenzia, agenziaFormativa.RAGIONE_SOCIALE as dsAgenziaFormativa");

		sql.append(
				" FROM TAIF_T_CORSO corso, TAIF_D_UNITA_FORMATIVA unitaFormativa, TAIF_T_AGENZIA_FORMATIVA agenziaFormativa");

		sql.append(" WHERE ");

		sql.append(
				"unitaFormativa.ID_UNITA_FORMATIVA = corso.FK_UNITA_FORMATIVA AND corso.FK_AGENZIA_FORMATIVA = agenziaFormativa.ID_AGENZIA_FORMATIVA");

		sql.append(" AND ");

		sql.append("unitaFormativa.fk_soggetto_gestore = :idSoggettoGestore");
		/*PROTECTED REGION ID(R2030134508) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" order by idAgenzia");

		String queryComplete = sql.toString().replace("SELECT", "SELECT DISTINCT");

		paramMap.addValue("idSoggettoGestore", input.getIdSoggettoGestore());

		/*PROTECTED REGION END*/

		List<TaifTAgenziaFormativaByFilterSoggettoGestoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterSoggettoGestoreRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::findByFilterSoggettoGestore] ERROR esecuzione query", ex);
			throw new TaifTAgenziaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAgenziaFormativaDaoImpl", "findByFilterSoggettoGestore", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByFilterSoggettoGestore] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byUnitaFormativaPersona con Qdef
		 * @generated
		 */

	public List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> findByUnitaFormativaPersona(
			it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaPersona input)
			throws TaifTAgenziaFormativaDaoException {
		LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByUnitaFormativaPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT agenziaFormativaTab.RAGIONE_SOCIALE as ragioneSociale, agenziaFormativaTab.INDIRIZZO as indirizzo, agenziaFormativaTab.CAP as cap, agenziaFormativaTab.ISTAT_SEDE as istatSede, soggettoGestoreTab.DENOMINAZIONE_BREVE as denominazioneBreve, personaTab.COGNOME as cognomePersona, personaTab.DATA_NASCITA as dataNascita, personaTab.ISTAT_COMUNE_NASCITA as istatComuneNascita, personaTab.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, personaTab.NOME as nomePersona, corsoTab.CORSO as corso, unitaFormativaTab.SIGLA as sigla, corsoTab.DATA_INIZIO as dataInizioCorso, corsoTab.DATA_FINE as dataFineCorso, corsoTab.NRO_ORE as numeroOre, soggettoGestoreTab.DENOMINAZIONE as denominazione, operatorCorsoTab.FLG_ESITO as flagEsito, soggettoGestoreTab.REFERENTE as referente, unitaFormativaTab.UNITA_FORMATIVA as unitaFormativa");

		sql.append(
				" FROM TAIF_T_AGENZIA_FORMATIVA agenziaFormativaTab, TAIF_D_UNITA_FORMATIVA unitaFormativaTab, TAIF_T_CORSO corsoTab, TAIF_R_OPFO_CORSO operatorCorsoTab, TAIF_T_PERSONA personaTab, TAIF_T_SOGGETTO_GESTORE soggettoGestoreTab, TAIF_T_OPFO opfoTab");

		sql.append(" WHERE ");

		sql.append(
				"opfoTab.ID_PERSONA = personaTab.ID_PERSONA AND opfoTab.FK_SOGGETTO_GESTORE = soggettoGestoreTab.ID_SOGGETTO_GESTORE AND personaTab.ID_PERSONA = operatorCorsoTab.ID_PERSONA AND operatorCorsoTab.ID_CORSO = corsoTab.ID_CORSO AND corsoTab.FK_AGENZIA_FORMATIVA = agenziaFormativaTab.ID_AGENZIA_FORMATIVA AND corsoTab.FK_UNITA_FORMATIVA = unitaFormativaTab.ID_UNITA_FORMATIVA");

		sql.append(" AND ");

		sql.append("personaTab.id_persona =:idPersona AND unitaFormativaTab.id_unita_formativa =:idUnitaFormativa");
		/*PROTECTED REGION ID(R1566569477) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input.getIdPersona());
		paramMap.addValue("idUnitaFormativa", input.getIdUnitaFormativa());

		/*PROTECTED REGION END*/

		List<TaifTAgenziaFormativaByUnitaFormativaPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byUnitaFormativaPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAgenziaFormativaDaoImpl::findByUnitaFormativaPersona] ERROR esecuzione query", ex);
			throw new TaifTAgenziaFormativaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAgenziaFormativaDaoImpl", "findByUnitaFormativaPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAgenziaFormativaDaoImpl::findByUnitaFormativaPersona] END");
		}
		return list;
	}

}
