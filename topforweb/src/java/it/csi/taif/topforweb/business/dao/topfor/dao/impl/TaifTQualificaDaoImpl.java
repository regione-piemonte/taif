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

/*PROTECTED REGION ID(R-24724339) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTQualifica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byIdPersona (datagen::CustomFinder)
  * - UPDATERS:
 *   - byIdQualifica (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTQualificaDaoImpl extends AbstractDAO implements TaifTQualificaDao {
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
	 * Metodo di inserimento del DAO taifTQualifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTQualificaPk
	 * @generated
	 */

	public TaifTQualificaPk insert(TaifTQualificaDto dto)

	{
		LOG.debug("[TaifTQualificaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_QUALIFICA,FK_TIPO_QUALIFICA,FK_AGENZIA_FORMATIVA,FK_PERSONA,DATA_RILASCIO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_QUALIFICA , :FK_TIPO_QUALIFICA , :FK_AGENZIA_FORMATIVA , :FK_PERSONA , :DATA_RILASCIO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_QUALIFICA]
		params.addValue("ID_QUALIFICA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_QUALIFICA]
		params.addValue("FK_TIPO_QUALIFICA", dto.getFkTipoQualifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AGENZIA_FORMATIVA]
		params.addValue("FK_AGENZIA_FORMATIVA", dto.getFkAgenziaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA]
		params.addValue("FK_PERSONA", dto.getFkPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_RILASCIO]
		params.addValue("DATA_RILASCIO", dto.getDataRilascio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdQualifica(newKey);
		LOG.debug("[TaifTQualificaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_T_QUALIFICA table.
	 * @generated
	 */
	public void updateColumnsByIdQualifica(TaifTQualificaDto dto) throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::updateColumnsByIdQualifica] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TIPO_QUALIFICA = :FK_TIPO_QUALIFICA ,FK_AGENZIA_FORMATIVA = :FK_AGENZIA_FORMATIVA ,FK_PERSONA = :FK_PERSONA ,DATA_RILASCIO = :DATA_RILASCIO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_QUALIFICA = :ID_QUALIFICA ";

		if (dto.getIdQualifica() == null) {
			LOG.error("[TaifTQualificaDaoImpl::updateColumnsByIdQualifica] ERROR chiave primaria non impostata");
			throw new TaifTQualificaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_QUALIFICA]
		params.addValue("FK_TIPO_QUALIFICA", dto.getFkTipoQualifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AGENZIA_FORMATIVA]
		params.addValue("FK_AGENZIA_FORMATIVA", dto.getFkAgenziaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA]
		params.addValue("FK_PERSONA", dto.getFkPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_RILASCIO]
		params.addValue("DATA_RILASCIO", dto.getDataRilascio(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_QUALIFICA]
		params.addValue("ID_QUALIFICA", dto.getIdQualifica(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTQualificaDaoImpl::updateColumnsByIdQualifica] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_QUALIFICA table.
	 * @generated
	 */

	public void delete(TaifTQualificaPk pk) throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_QUALIFICA = :ID_QUALIFICA ";

		if (pk == null) {
			LOG.error("[TaifTQualificaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTQualificaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_QUALIFICA]
		params.addValue("ID_QUALIFICA", pk.getIdQualifica(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTQualificaDaoImpl::delete] END");
	}

	protected TaifTQualificaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTQualificaDaoRowMapper(null,
			TaifTQualificaDto.class, this);

	protected TaifTQualificaDaoRowMapper findAllRowMapper = new TaifTQualificaDaoRowMapper(null,
			TaifTQualificaDto.class, this);

	protected TaifTQualificaDaoRowMapper byIdPersonaRowMapper = new TaifTQualificaDaoRowMapper(null,
			TaifTQualificaByIdPersonaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_QUALIFICA";
	}

	/** 
	 * Returns all rows from the TAIF_T_QUALIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTQualificaDto findByPrimaryKey(TaifTQualificaPk pk) throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_QUALIFICA,FK_TIPO_QUALIFICA,FK_AGENZIA_FORMATIVA,FK_PERSONA,DATA_RILASCIO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_QUALIFICA = :ID_QUALIFICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_QUALIFICA]
		params.addValue("ID_QUALIFICA", pk.getIdQualifica(), java.sql.Types.INTEGER);

		List<TaifTQualificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTQualificaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTQualificaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTQualificaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_QUALIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTQualificaDto> findAll() throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_QUALIFICA,FK_TIPO_QUALIFICA,FK_AGENZIA_FORMATIVA,FK_PERSONA,DATA_RILASCIO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTQualificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTQualificaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTQualificaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTQualificaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdPersona con Qdef
		 * @generated
		 */

	public List<TaifTQualificaByIdPersonaDto> findByIdPersona(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::findByIdPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT q.ID_QUALIFICA as idQualifica, tq.ID_TIPO_QUALIFICA as idTipoQualifica, af.RAGIONE_SOCIALE as ragioneSociale, q.DATA_RILASCIO as dataRilascio, tq.TIPO_QUALIFICA as tipoQualifica");

		sql.append(" FROM TAIF_T_QUALIFICA q, TAIF_D_TIPO_QUALIFICA tq, TAIF_T_AGENZIA_FORMATIVA af");

		sql.append(" WHERE ");

		sql.append("q.FK_TIPO_QUALIFICA = tq.ID_TIPO_QUALIFICA AND q.FK_AGENZIA_FORMATIVA = af.ID_AGENZIA_FORMATIVA");

		sql.append(" AND ");

		sql.append("q.fk_persona = :idPersona");
		/*PROTECTED REGION ID(R-199371277) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", new Integer(input.getIdPersona()));

		/*PROTECTED REGION END*/

		List<TaifTQualificaByIdPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTQualificaDaoImpl::findByIdPersona] ERROR esecuzione query", ex);
			throw new TaifTQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTQualificaDaoImpl", "findByIdPersona", "esecuzione query", sql.toString());
			LOG.debug("[TaifTQualificaDaoImpl::findByIdPersona] END");
		}
		return list;
	}

}
