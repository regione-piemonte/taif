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

/*PROTECTED REGION ID(R646964761) ENABLED START*/
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
 *   - byPersona (datagen::CustomFinder)
 *   - byAgenziaFormativa (datagen::CustomFinder)
 *   - findQualificaElencoOperatori (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
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
	 * Updates a single row in the TAIF_T_QUALIFICA table.
	 * @generated
	 */
	public void update(TaifTQualificaDto dto) throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TIPO_QUALIFICA = :FK_TIPO_QUALIFICA ,FK_AGENZIA_FORMATIVA = :FK_AGENZIA_FORMATIVA ,FK_PERSONA = :FK_PERSONA ,DATA_RILASCIO = :DATA_RILASCIO ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_QUALIFICA = :ID_QUALIFICA ";

		if (dto.getIdQualifica() == null) {
			LOG.error("[TaifTQualificaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTQualificaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_QUALIFICA]
		params.addValue("ID_QUALIFICA", dto.getIdQualifica(), java.sql.Types.INTEGER);

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

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTQualificaDaoImpl::update] END");
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

	protected TaifTQualificaDaoRowMapper byPersonaRowMapper = new TaifTQualificaDaoRowMapper(null,
			TaifTQualificaByPersonaDto.class, this);

	protected TaifTQualificaDaoRowMapper byAgenziaFormativaRowMapper = new TaifTQualificaDaoRowMapper(null,
			TaifTQualificaByAgenziaFormativaDto.class, this);

	protected TaifTQualificaDaoRowMapper findQualificaElencoOperatoriRowMapper = new TaifTQualificaDaoRowMapper(null,
			TaifTQualificaFindQualificaElencoOperatoriDto.class, this);

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

		sql.append(" ORDER BY ID_QUALIFICA ASC");
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
		 * Implementazione del finder byPersona con Qdef
		 * @generated
		 */

	public List<TaifTQualificaByPersonaDto> findByPersona(java.lang.Integer input) throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::findByPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT qualifica.ID_QUALIFICA as id, qualifica.FK_TIPO_QUALIFICA as idTipoQual, qualifica.FK_AGENZIA_FORMATIVA as agForm, qualifica.FK_PERSONA as pers, qualifica.DATA_RILASCIO as ril, qualifica.DATA_INSERIMENTO as inser, tipo.TIPO_QUALIFICA as qualifica");

		sql.append(" FROM TAIF_T_QUALIFICA qualifica, TAIF_D_TIPO_QUALIFICA tipo");

		sql.append(" WHERE ");

		sql.append("qualifica.FK_TIPO_QUALIFICA = tipo.ID_TIPO_QUALIFICA");

		sql.append(" AND ");

		sql.append("qualifica.fk_persona=:idPersona");
		/*PROTECTED REGION ID(R1718598712) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input);

		/*PROTECTED REGION END*/

		List<TaifTQualificaByPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTQualificaDaoImpl::findByPersona] ERROR esecuzione query", ex);
			throw new TaifTQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTQualificaDaoImpl", "findByPersona", "esecuzione query", sql.toString());
			LOG.debug("[TaifTQualificaDaoImpl::findByPersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAgenziaFormativa con Qdef
		 * @generated
		 */

	public List<TaifTQualificaByAgenziaFormativaDto> findByAgenziaFormativa(java.lang.Integer input)
			throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::findByAgenziaFormativa] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT qualifica.ID_QUALIFICA as id, qualifica.FK_TIPO_QUALIFICA as idTipoQual, qualifica.FK_AGENZIA_FORMATIVA as agForm, qualifica.FK_PERSONA as pers, qualifica.DATA_RILASCIO as ril, qualifica.DATA_INSERIMENTO as inser");

		sql.append(" FROM TAIF_T_QUALIFICA qualifica");

		sql.append(" WHERE ");

		sql.append("qualifica.fk_agenzia_formativa=:idAgenziaFormativa");
		/*PROTECTED REGION ID(R-2069948014) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAgenziaFormativa", input);

		/*PROTECTED REGION END*/

		List<TaifTQualificaByAgenziaFormativaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAgenziaFormativaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTQualificaDaoImpl::findByAgenziaFormativa] ERROR esecuzione query", ex);
			throw new TaifTQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTQualificaDaoImpl", "findByAgenziaFormativa", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTQualificaDaoImpl::findByAgenziaFormativa] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findQualificaElencoOperatori con Qdef
		 * @generated
		 */

	public List<TaifTQualificaFindQualificaElencoOperatoriDto> findFindQualificaElencoOperatori(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CorsoQualificaFilter input)
			throws TaifTQualificaDaoException {
		LOG.debug("[TaifTQualificaDaoImpl::findFindQualificaElencoOperatori] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT qualificaTable.ID_QUALIFICA as idQualifica, tipoQualificaTable.TIPO_QUALIFICA as tipoQualifica, tipoQualificaTable.MTD_ORDINAMENTO as ordinamento");

		sql.append(
				" FROM TAIF_T_PERSONA personaTable, TAIF_T_QUALIFICA qualificaTable, TAIF_D_TIPO_QUALIFICA tipoQualificaTable, TAIF_T_OPFO opfoTable");

		sql.append(" WHERE ");

		sql.append(
				"personaTable.ID_PERSONA = opfoTable.ID_PERSONA AND opfoTable.ID_PERSONA = qualificaTable.FK_PERSONA AND qualificaTable.FK_TIPO_QUALIFICA = tipoQualificaTable.ID_TIPO_QUALIFICA");

		sql.append(" AND ");

		sql.append(
				"personaTable.codice_fiscale=:codiceFiscale and tipoQualificaTable.MTD_FLG_VISIBILE=:visibile and tipoQualificaTable.MTD_FLG_ITA_FRA=:flagItFr  ");
		/*PROTECTED REGION ID(R629131964) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceFiscale", input.getCodiceFiscale());
		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItFr", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTQualificaFindQualificaElencoOperatoriDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findQualificaElencoOperatoriRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTQualificaDaoImpl::findFindQualificaElencoOperatori] ERROR esecuzione query", ex);
			throw new TaifTQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTQualificaDaoImpl", "findFindQualificaElencoOperatori", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTQualificaDaoImpl::findFindQualificaElencoOperatori] END");
		}
		return list;
	}

}
