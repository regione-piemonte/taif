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

/*PROTECTED REGION ID(R1249646929) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTRiconoscimento.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byCodiceFiscale (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTRiconoscimentoDaoImpl extends AbstractDAO implements TaifTRiconoscimentoDao {
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
	 * Metodo di inserimento del DAO taifTRiconoscimento. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTRiconoscimentoPk
	 * @generated
	 */

	public TaifTRiconoscimentoPk insert(TaifTRiconoscimentoDto dto)

	{
		LOG.debug("[TaifTRiconoscimentoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_RICONOSCIMENTO,FK_UNITA_FORMATIVA,FK_AGENZIA_FORMATIVA,FK_PERSONA,DATA_RICONOSCIMENTO,NOTE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_RICONOSCIMENTO , :FK_UNITA_FORMATIVA , :FK_AGENZIA_FORMATIVA , :FK_PERSONA , :DATA_RICONOSCIMENTO , :NOTE , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RICONOSCIMENTO]
		params.addValue("ID_RICONOSCIMENTO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_FORMATIVA]
		params.addValue("FK_UNITA_FORMATIVA", dto.getFkUnitaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AGENZIA_FORMATIVA]
		params.addValue("FK_AGENZIA_FORMATIVA", dto.getFkAgenziaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA]
		params.addValue("FK_PERSONA", dto.getFkPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_RICONOSCIMENTO]
		params.addValue("DATA_RICONOSCIMENTO", dto.getDataRiconoscimento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdRiconoscimento(newKey);
		LOG.debug("[TaifTRiconoscimentoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_RICONOSCIMENTO table.
	 * @generated
	 */
	public void update(TaifTRiconoscimentoDto dto) throws TaifTRiconoscimentoDaoException {
		LOG.debug("[TaifTRiconoscimentoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_UNITA_FORMATIVA = :FK_UNITA_FORMATIVA ,FK_AGENZIA_FORMATIVA = :FK_AGENZIA_FORMATIVA ,FK_PERSONA = :FK_PERSONA ,DATA_RICONOSCIMENTO = :DATA_RICONOSCIMENTO ,NOTE = :NOTE ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_RICONOSCIMENTO = :ID_RICONOSCIMENTO ";

		if (dto.getIdRiconoscimento() == null) {
			LOG.error("[TaifTRiconoscimentoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTRiconoscimentoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RICONOSCIMENTO]
		params.addValue("ID_RICONOSCIMENTO", dto.getIdRiconoscimento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_FORMATIVA]
		params.addValue("FK_UNITA_FORMATIVA", dto.getFkUnitaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AGENZIA_FORMATIVA]
		params.addValue("FK_AGENZIA_FORMATIVA", dto.getFkAgenziaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA]
		params.addValue("FK_PERSONA", dto.getFkPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_RICONOSCIMENTO]
		params.addValue("DATA_RICONOSCIMENTO", dto.getDataRiconoscimento(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTRiconoscimentoDaoImpl::update] END");
	}

	protected TaifTRiconoscimentoDaoRowMapper findByPrimaryKeyRowMapper = new TaifTRiconoscimentoDaoRowMapper(null,
			TaifTRiconoscimentoDto.class, this);

	protected TaifTRiconoscimentoDaoRowMapper findAllRowMapper = new TaifTRiconoscimentoDaoRowMapper(null,
			TaifTRiconoscimentoDto.class, this);

	protected TaifTRiconoscimentoDaoRowMapper byFilterRowMapper = new TaifTRiconoscimentoDaoRowMapper(null,
			TaifTRiconoscimentoByFilterDto.class, this);

	protected TaifTRiconoscimentoDaoRowMapper byCodiceFiscaleRowMapper = new TaifTRiconoscimentoDaoRowMapper(null,
			TaifTRiconoscimentoByCodiceFiscaleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_RICONOSCIMENTO";
	}

	/** 
	 * Returns all rows from the TAIF_T_RICONOSCIMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTRiconoscimentoDto findByPrimaryKey(TaifTRiconoscimentoPk pk) throws TaifTRiconoscimentoDaoException {
		LOG.debug("[TaifTRiconoscimentoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_RICONOSCIMENTO,FK_UNITA_FORMATIVA,FK_AGENZIA_FORMATIVA,FK_PERSONA,DATA_RICONOSCIMENTO,NOTE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_RICONOSCIMENTO = :ID_RICONOSCIMENTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_RICONOSCIMENTO]
		params.addValue("ID_RICONOSCIMENTO", pk.getIdRiconoscimento(), java.sql.Types.INTEGER);

		List<TaifTRiconoscimentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTRiconoscimentoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTRiconoscimentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTRiconoscimentoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTRiconoscimentoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_RICONOSCIMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTRiconoscimentoDto> findAll() throws TaifTRiconoscimentoDaoException {
		LOG.debug("[TaifTRiconoscimentoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_RICONOSCIMENTO,FK_UNITA_FORMATIVA,FK_AGENZIA_FORMATIVA,FK_PERSONA,DATA_RICONOSCIMENTO,NOTE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_RICONOSCIMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTRiconoscimentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTRiconoscimentoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTRiconoscimentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTRiconoscimentoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTRiconoscimentoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTRiconoscimentoByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.RiconoscimentoFilter input)
			throws TaifTRiconoscimentoDaoException {
		LOG.debug("[TaifTRiconoscimentoDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ricon.ID_RICONOSCIMENTO as id, ricon.FK_UNITA_FORMATIVA as idUnForm, ricon.FK_AGENZIA_FORMATIVA as idAgForm, ricon.FK_PERSONA as idPers, ricon.DATA_RICONOSCIMENTO as data, ricon.NOTE as note");

		sql.append(" FROM TAIF_T_RICONOSCIMENTO ricon");

		sql.append(" WHERE ");

		sql.append(
				"ricon.fk_unita_formativa=:idUnitaFormativa or ricon.fk_agenzia_formativa=:idAgenziaFormativa or ricon.fk_persona=:idPersona");
		/*PROTECTED REGION ID(R-294866903) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idUnitaFormativa", input.getIdUnitaFormativa());
		paramMap.addValue("idAgenziaFormativa", input.getIdAgenziaFormativa());
		paramMap.addValue("idPersona", input.getIdPersona());

		/*PROTECTED REGION END*/

		List<TaifTRiconoscimentoByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTRiconoscimentoDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTRiconoscimentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTRiconoscimentoDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifTRiconoscimentoDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTRiconoscimentoByCodiceFiscaleDto> findByCodiceFiscale(String input)
			throws TaifTRiconoscimentoDaoException {
		LOG.debug("[TaifTRiconoscimentoDaoImpl::findByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT r.ID_RICONOSCIMENTO, r.FK_UNITA_FORMATIVA, r.FK_PERSONA, u.UNITA_FORMATIVA, u.SIGLA");

		sql.append(" FROM TAIF_T_RICONOSCIMENTO r, TAIF_D_UNITA_FORMATIVA u, TAIF_T_PERSONA p");

		sql.append(" WHERE ");

		sql.append("r.FK_UNITA_FORMATIVA = u.ID_UNITA_FORMATIVA AND r.FK_PERSONA = p.ID_PERSONA");

		sql.append(" AND ");

		sql.append("p.CODICE_FISCALE = :codiceFiscale");
		/*PROTECTED REGION ID(R740525691) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/

		List<TaifTRiconoscimentoByCodiceFiscaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTRiconoscimentoDaoImpl::findByCodiceFiscale] ERROR esecuzione query", ex);
			throw new TaifTRiconoscimentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTRiconoscimentoDaoImpl", "findByCodiceFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTRiconoscimentoDaoImpl::findByCodiceFiscale] END");
		}
		return list;
	}

}
