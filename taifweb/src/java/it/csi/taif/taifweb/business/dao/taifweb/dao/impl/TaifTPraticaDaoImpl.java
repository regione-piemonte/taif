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

/*PROTECTED REGION ID(R1102511751) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTPratica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byIdAzienda (datagen::CustomFinder)
 *   - byIdGestore (datagen::CustomFinder)
 *   - byNumeroAlbo (datagen::CustomFinder)
 *   - byIdAziendaAlbo (datagen::CustomFinder)
 *   - byIdAziendaIdSoggettoGestore (datagen::CustomFinder)
 *   - altriAlbiByIdAzienda (datagen::CustomFinder)
 *   - dettaglioPraticaPerInvio (datagen::CustomFinder)
 *   - maxAlboNumberValue (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - praticaByIdPratica (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTPraticaDaoImpl extends AbstractDAO implements TaifTPraticaDao {
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
	 * Metodo di inserimento del DAO taifTPratica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTPraticaPk
	 * @generated
	 */

	public TaifTPraticaPk insert(TaifTPraticaDto dto)

	{
		LOG.debug("[TaifTPraticaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PRATICA,FK_SOGGETTO_GESTORE,FK_AZIENDA,DATA_PRESENTAZIONE,DATA_ISCRIZIONE_ALBO,NUMERO_ALBO,FLG_SEZIONE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,DENOMINAZIONE_ALTRO_ALBO,FK_CONFIG_UTENTE ) VALUES (  :ID_PRATICA , :FK_SOGGETTO_GESTORE , :FK_AZIENDA , :DATA_PRESENTAZIONE , :DATA_ISCRIZIONE_ALBO , :NUMERO_ALBO , :FLG_SEZIONE , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :DENOMINAZIONE_ALTRO_ALBO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_PRESENTAZIONE]
		params.addValue("DATA_PRESENTAZIONE", dto.getDataPresentazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ISCRIZIONE_ALBO]
		params.addValue("DATA_ISCRIZIONE_ALBO", dto.getDataIscrizioneAlbo(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NUMERO_ALBO]
		params.addValue("NUMERO_ALBO", dto.getNumeroAlbo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SEZIONE]
		params.addValue("FLG_SEZIONE", dto.getFlgSezione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_ALTRO_ALBO]
		params.addValue("DENOMINAZIONE_ALTRO_ALBO", dto.getDenominazioneAltroAlbo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdPratica(newKey);
		LOG.debug("[TaifTPraticaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_PRATICA table.
	 * @generated
	 */
	public void update(TaifTPraticaDto dto) throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_SOGGETTO_GESTORE = :FK_SOGGETTO_GESTORE ,FK_AZIENDA = :FK_AZIENDA ,DATA_PRESENTAZIONE = :DATA_PRESENTAZIONE ,DATA_ISCRIZIONE_ALBO = :DATA_ISCRIZIONE_ALBO ,NUMERO_ALBO = :NUMERO_ALBO ,FLG_SEZIONE = :FLG_SEZIONE ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,DENOMINAZIONE_ALTRO_ALBO = :DENOMINAZIONE_ALTRO_ALBO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_PRATICA = :ID_PRATICA ";

		if (dto.getIdPratica() == null) {
			LOG.error("[TaifTPraticaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTPraticaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", dto.getIdPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_PRESENTAZIONE]
		params.addValue("DATA_PRESENTAZIONE", dto.getDataPresentazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ISCRIZIONE_ALBO]
		params.addValue("DATA_ISCRIZIONE_ALBO", dto.getDataIscrizioneAlbo(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NUMERO_ALBO]
		params.addValue("NUMERO_ALBO", dto.getNumeroAlbo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SEZIONE]
		params.addValue("FLG_SEZIONE", dto.getFlgSezione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_ALTRO_ALBO]
		params.addValue("DENOMINAZIONE_ALTRO_ALBO", dto.getDenominazioneAltroAlbo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPraticaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_PRATICA table.
	 * @generated
	 */
	public void updateColumnsPraticaByIdPratica(TaifTPraticaDto dto) throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::updateColumnsPraticaByIdPratica] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_SOGGETTO_GESTORE = :FK_SOGGETTO_GESTORE ,FK_AZIENDA = :FK_AZIENDA ,DATA_PRESENTAZIONE = :DATA_PRESENTAZIONE ,DATA_ISCRIZIONE_ALBO = :DATA_ISCRIZIONE_ALBO ,NUMERO_ALBO = :NUMERO_ALBO ,FLG_SEZIONE = :FLG_SEZIONE ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,DENOMINAZIONE_ALTRO_ALBO = :DENOMINAZIONE_ALTRO_ALBO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_PRATICA = :ID_PRATICA ";

		if (dto.getIdPratica() == null) {
			LOG.error("[TaifTPraticaDaoImpl::updateColumnsPraticaByIdPratica] ERROR chiave primaria non impostata");
			throw new TaifTPraticaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_PRESENTAZIONE]
		params.addValue("DATA_PRESENTAZIONE", dto.getDataPresentazione(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_ISCRIZIONE_ALBO]
		params.addValue("DATA_ISCRIZIONE_ALBO", dto.getDataIscrizioneAlbo(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NUMERO_ALBO]
		params.addValue("NUMERO_ALBO", dto.getNumeroAlbo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SEZIONE]
		params.addValue("FLG_SEZIONE", dto.getFlgSezione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_ALTRO_ALBO]
		params.addValue("DENOMINAZIONE_ALTRO_ALBO", dto.getDenominazioneAltroAlbo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", dto.getIdPratica(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPraticaDaoImpl::updateColumnsPraticaByIdPratica] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_PRATICA table.
	 * @generated
	 */

	public void delete(TaifTPraticaPk pk) throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_PRATICA = :ID_PRATICA ";

		if (pk == null) {
			LOG.error("[TaifTPraticaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTPraticaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", pk.getIdPratica(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPraticaDaoImpl::delete] END");
	}

	protected TaifTPraticaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaDto.class, this);

	protected TaifTPraticaDaoRowMapper findAllRowMapper = new TaifTPraticaDaoRowMapper(null, TaifTPraticaDto.class,
			this);

	protected TaifTPraticaDaoRowMapper byIdAziendaRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaByIdAziendaDto.class, this);

	protected TaifTPraticaDaoRowMapper byIdGestoreRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaByIdGestoreDto.class, this);

	protected TaifTPraticaDaoRowMapper byNumeroAlboRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaByNumeroAlboDto.class, this);

	protected TaifTPraticaDaoRowMapper byIdAziendaAlboRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaByIdAziendaAlboDto.class, this);

	protected TaifTPraticaDaoRowMapper byIdAziendaIdSoggettoGestoreRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaDto.class, this);

	protected TaifTPraticaDaoRowMapper altriAlbiByIdAziendaRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaAltriAlbiByIdAziendaDto.class, this);

	protected TaifTPraticaDaoRowMapper dettaglioPraticaPerInvioRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaDettaglioPraticaPerInvioDto.class, this);

	protected TaifTPraticaDaoRowMapper maxAlboNumberValueRowMapper = new TaifTPraticaDaoRowMapper(null,
			TaifTPraticaMaxAlboNumberValueDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_PRATICA";
	}

	/** 
	 * Returns all rows from the TAIF_T_PRATICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTPraticaDto findByPrimaryKey(TaifTPraticaPk pk) throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PRATICA,FK_SOGGETTO_GESTORE,FK_AZIENDA,DATA_PRESENTAZIONE,DATA_ISCRIZIONE_ALBO,NUMERO_ALBO,FLG_SEZIONE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,DENOMINAZIONE_ALTRO_ALBO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_PRATICA = :ID_PRATICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", pk.getIdPratica(), java.sql.Types.INTEGER);

		List<TaifTPraticaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_PRATICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPraticaDto> findAll() throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PRATICA,FK_SOGGETTO_GESTORE,FK_AZIENDA,DATA_PRESENTAZIONE,DATA_ISCRIZIONE_ALBO,NUMERO_ALBO,FLG_SEZIONE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,DENOMINAZIONE_ALTRO_ALBO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_PRATICA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTPraticaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTPraticaByIdAziendaDto> findByIdAzienda(java.lang.Integer input) throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT pratica.ID_PRATICA as idPratica, pratica.NUMERO_ALBO as nrAlbo, pratica.DENOMINAZIONE_ALTRO_ALBO as denominazioneAltroAlbo, pratica.FK_SOGGETTO_GESTORE as idSoggettoGestore, pratica.FLG_SEZIONE as flagSezione, pratica.DATA_ISCRIZIONE_ALBO as dataInscrizioneAlbo, pratica.DATA_AGGIORNAMENTO as dataAggiornamento, pratica.FK_CONFIG_UTENTE as fkConfigUtente, pratica.DATA_PRESENTAZIONE as dataPresentazione, pratica.FK_AZIENDA as idAzienda");

		sql.append(" FROM TAIF_T_PRATICA pratica");

		sql.append(" WHERE ");

		sql.append("pratica.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R955624818) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTPraticaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findByIdAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdGestore con Qdef
		 * @generated
		 */

	public List<TaifTPraticaByIdGestoreDto> findByIdGestore(java.lang.Integer input) throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findByIdGestore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT pratica.ID_PRATICA as id, pratica.NUMERO_ALBO as nrAlbo, pratica.DENOMINAZIONE_ALTRO_ALBO as denom, pratica.FK_SOGGETTO_GESTORE as gestore, pratica.FLG_SEZIONE as sezione");

		sql.append(" FROM TAIF_T_PRATICA pratica");

		sql.append(" WHERE ");

		sql.append("pratica.fk_soggetto_gestore=:idSogettoGestor");
		/*PROTECTED REGION ID(R-1098277627) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idSogettoGestor", input);

		/*PROTECTED REGION END*/

		List<TaifTPraticaByIdGestoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdGestoreRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findByIdGestore] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findByIdGestore", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findByIdGestore] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byNumeroAlbo con Qdef
		 * @generated
		 */

	public List<TaifTPraticaByNumeroAlboDto> findByNumeroAlbo(java.lang.String input) throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findByNumeroAlbo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT pratica.ID_PRATICA as id, pratica.FK_AZIENDA as idAzienda, pratica.FK_SOGGETTO_GESTORE as soggetto, pratica.DATA_AGGIORNAMENTO as dataAgg");

		sql.append(" FROM TAIF_T_PRATICA pratica");

		sql.append(" WHERE ");

		sql.append("pratica.numero_albo=:numeroAlbo");
		/*PROTECTED REGION ID(R720100751) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("numeroAlbo", input);

		/*PROTECTED REGION END*/

		List<TaifTPraticaByNumeroAlboDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byNumeroAlboRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findByNumeroAlbo] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findByNumeroAlbo", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findByNumeroAlbo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAziendaAlbo con Qdef
		 * @generated
		 */

	public List<TaifTPraticaByIdAziendaAlboDto> findByIdAziendaAlbo(java.lang.Integer input)
			throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findByIdAziendaAlbo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT pratica.ID_PRATICA as idPratica, pratica.NUMERO_ALBO as nrAlbo, pratica.DENOMINAZIONE_ALTRO_ALBO as denominazioneAltroAlbo, pratica.FK_SOGGETTO_GESTORE as idSoggettoGestore, pratica.FLG_SEZIONE as flagSezione, pratica.DATA_ISCRIZIONE_ALBO as dataInscrizioneAlbo, pratica.DATA_AGGIORNAMENTO as dataAggiornamento, pratica.FK_CONFIG_UTENTE as fkConfigUtente, pratica.DATA_PRESENTAZIONE as dataPresentazione, pratica.FK_AZIENDA as idAzienda, soggettoGestore.ID_SOGGETTO_GESTORE as idSoggettoGestione, soggettoGestore.CODICE as codiceGestore, soggettoGestore.DENOMINAZIONE_BREVE as denominzioneAlbo, soggettoGestore.DENOMINAZIONE as denominazioneEstesa, soggettoGestore.DATA_INSERIMENTO as dataInserimento");

		sql.append(" FROM TAIF_T_PRATICA pratica, TAIF_T_SOGGETTO_GESTORE soggettoGestore");

		sql.append(" WHERE ");

		sql.append("pratica.FK_SOGGETTO_GESTORE = soggettoGestore.ID_SOGGETTO_GESTORE");

		sql.append(" AND ");

		sql.append("pratica.fk_azienda=:idAzienda ");
		/*PROTECTED REGION ID(R718471578) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTPraticaByIdAziendaAlboDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaAlboRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findByIdAziendaAlbo] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findByIdAziendaAlbo", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findByIdAziendaAlbo] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder byIdAziendaIdSoggettoGestore
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPraticaDto> findByIdAziendaIdSoggettoGestore(java.lang.Integer idAzienda, java.lang.Integer input)
			throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findByIdAziendaIdSoggettoGestore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PRATICA,FK_SOGGETTO_GESTORE,FK_AZIENDA,DATA_PRESENTAZIONE,DATA_ISCRIZIONE_ALBO,NUMERO_ALBO,FLG_SEZIONE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,DENOMINAZIONE_ALTRO_ALBO,FK_CONFIG_UTENTE ");
		sql.append(" FROM TAIF_T_PRATICA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2039119132) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FK_AZIENDA = :FK_AZIENDA");
		sql.append(" AND FK_SOGGETTO_GESTORE = :FK_SOGGETTO_GESTORE");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1086930098) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("FK_AZIENDA", idAzienda);
		paramMap.addValue("FK_SOGGETTO_GESTORE", input);

		/*PROTECTED REGION END*/
		List<TaifTPraticaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaIdSoggettoGestoreRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findByIdAziendaIdSoggettoGestore] esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findByIdAziendaIdSoggettoGestore", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findByIdAziendaIdSoggettoGestore] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder altriAlbiByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTPraticaAltriAlbiByIdAziendaDto> findAltriAlbiByIdAzienda(java.lang.Integer input)
			throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findAltriAlbiByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT pratica.DENOMINAZIONE_ALTRO_ALBO as altroAlbo");

		sql.append(" FROM TAIF_T_PRATICA pratica");

		sql.append(" WHERE ");

		sql.append("pratica.fk_azienda=:idAziendaSelezionata");
		/*PROTECTED REGION ID(R-31999896) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAziendaSelezionata", input);

		/*PROTECTED REGION END*/

		List<TaifTPraticaAltriAlbiByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, altriAlbiByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findAltriAlbiByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findAltriAlbiByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findAltriAlbiByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder dettaglioPraticaPerInvio con Qdef
		 * @generated
		 */

	public List<TaifTPraticaDettaglioPraticaPerInvioDto> findDettaglioPraticaPerInvio(java.lang.Integer input)
			throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findDettaglioPraticaPerInvio] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT pr.ID_PRATICA, pr.NUMERO_ALBO, pr.DATA_ISCRIZIONE_ALBO, ss.FK_STATO_PRATICA, az.ID_AZIENDA, az.PARTITA_IVA, az.N_TVA, az.RAGIONE_SOCIALE, az.CODICE_FISCALE, az.N_SIRET, az.EMAIL as mailAzienda, az.PEC as pecAzienda, pe.ID_PERSONA, pe.COGNOME, pe.NOME, pe.CODICE_FISCALE, sg.ID_SOGGETTO_GESTORE, sg.DENOMINAZIONE_BREVE, sg.DENOMINAZIONE, sg.TELEFONO, sg.MAIL as mailSoggettoGestore, sg.PEC as pecSoggettoGestore");

		sql.append(
				" FROM TAIF_T_PRATICA pr, TAIF_T_STORICO_STATO ss, TAIF_T_AZIENDA az, TAIF_R_PERSONA_AZIENDA pa, TAIF_T_PERSONA pe, TAIF_T_SOGGETTO_GESTORE sg");

		sql.append(" WHERE ");

		sql.append(
				"pr.FK_AZIENDA = az.ID_AZIENDA AND pr.ID_PRATICA = ss.ID_PRATICA AND az.ID_AZIENDA = pa.ID_AZIENDA AND pa.ID_PERSONA = pe.ID_PERSONA AND pr.FK_SOGGETTO_GESTORE = sg.ID_SOGGETTO_GESTORE");

		sql.append(" AND ");

		sql.append("pr.ID_PRATICA = :idPratica AND pa.FK_RUOLO = 1 and ss.DATA_FINE_STATO is null");
		/*PROTECTED REGION ID(R-324136583) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPratica", input);

		/*PROTECTED REGION END*/

		List<TaifTPraticaDettaglioPraticaPerInvioDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, dettaglioPraticaPerInvioRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findDettaglioPraticaPerInvio] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findDettaglioPraticaPerInvio", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findDettaglioPraticaPerInvio] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder maxAlboNumberValue con Qdef
		 * @generated
		 */

	public List<TaifTPraticaMaxAlboNumberValueDto> findMaxAlboNumberValue(java.lang.Integer input)
			throws TaifTPraticaDaoException {
		LOG.debug("[TaifTPraticaDaoImpl::findMaxAlboNumberValue] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT max(CAST(coalesce(numero_albo, '0')  AS INTEGER )) AS maxNumeroAlbo");

		sql.append(" FROM TAIF_T_PRATICA praticaTable");

		sql.append(" WHERE ");

		sql.append(
				"praticaTable.fk_soggetto_gestore=:idSoggettoGestore and numero_albo is not null and  numero_albo <> ' ' and  numero_albo <> ''");
		/*PROTECTED REGION ID(R-949448818) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idSoggettoGestore", input);

		/*PROTECTED REGION END*/

		List<TaifTPraticaMaxAlboNumberValueDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, maxAlboNumberValueRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPraticaDaoImpl::findMaxAlboNumberValue] ERROR esecuzione query", ex);
			throw new TaifTPraticaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPraticaDaoImpl", "findMaxAlboNumberValue", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPraticaDaoImpl::findMaxAlboNumberValue] END");
		}
		return list;
	}

}
