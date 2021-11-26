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

/*PROTECTED REGION ID(R-2060485415) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifRAttivDetMateriale.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byIdMateriale (datagen::CustomFinder)
 *   - byIdAttivita (datagen::CustomFinder)
 *   - byIdAttivitaProgressivo (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - byAttivitaAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifRAttivDetMaterialeDaoImpl extends AbstractDAO implements TaifRAttivDetMaterialeDao {
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
	 * Metodo di inserimento del DAO taifRAttivDetMateriale. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAttivDetMaterialePk
	 * @generated
	 */

	public TaifRAttivDetMaterialePk insert(TaifRAttivDetMaterialeDto dto)

	{
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_MATERIALE,ID_ATTIVITA,PROGRESSIVO,DESCR_ALTRO_MATERIALE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_MATERIALE , :ID_ATTIVITA , :PROGRESSIVO , :DESCR_ALTRO_MATERIALE , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MATERIALE]
		params.addValue("ID_MATERIALE", dto.getIdMateriale(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO_MATERIALE]
		params.addValue("DESCR_ALTRO_MATERIALE", dto.getDescrAltroMateriale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_R_ATTIVDET_MATERIALE table.
	 * @generated
	 */
	public void update(TaifRAttivDetMaterialeDto dto) throws TaifRAttivDetMaterialeDaoException {
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DESCR_ALTRO_MATERIALE = :DESCR_ALTRO_MATERIALE ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_MATERIALE = :ID_MATERIALE  AND ID_ATTIVITA = :ID_ATTIVITA  AND PROGRESSIVO = :PROGRESSIVO ";

		if (dto.getIdMateriale() == null || dto.getIdAttivita() == null || dto.getProgressivo() == null) {
			LOG.error("[TaifRAttivDetMaterialeDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifRAttivDetMaterialeDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MATERIALE]
		params.addValue("ID_MATERIALE", dto.getIdMateriale(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO_MATERIALE]
		params.addValue("DESCR_ALTRO_MATERIALE", dto.getDescrAltroMateriale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_R_ATTIVDET_MATERIALE table.
	 * @generated
	 */
	public void updateColumnsByAttivitaAzienda(TaifRAttivDetMaterialeDto dto)
			throws TaifRAttivDetMaterialeDaoException {
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::updateColumnsByAttivitaAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DESCR_ALTRO_MATERIALE = :DESCR_ALTRO_MATERIALE ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_MATERIALE = :ID_MATERIALE  AND ID_ATTIVITA = :ID_ATTIVITA  AND PROGRESSIVO = :PROGRESSIVO ";

		if (dto.getIdMateriale() == null || dto.getIdAttivita() == null || dto.getProgressivo() == null) {
			LOG.error(
					"[TaifRAttivDetMaterialeDaoImpl::updateColumnsByAttivitaAzienda] ERROR chiave primaria non impostata");
			throw new TaifRAttivDetMaterialeDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO_MATERIALE]
		params.addValue("DESCR_ALTRO_MATERIALE", dto.getDescrAltroMateriale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_MATERIALE]
		params.addValue("ID_MATERIALE", dto.getIdMateriale(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::updateColumnsByAttivitaAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_R_ATTIVDET_MATERIALE table.
	 * @generated
	 */

	public void delete(TaifRAttivDetMaterialePk pk) throws TaifRAttivDetMaterialeDaoException {
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_MATERIALE = :ID_MATERIALE  AND ID_ATTIVITA = :ID_ATTIVITA  AND PROGRESSIVO = :PROGRESSIVO ";

		if (pk == null) {
			LOG.error("[TaifRAttivDetMaterialeDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifRAttivDetMaterialeDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MATERIALE]
		params.addValue("ID_MATERIALE", pk.getIdMateriale(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", pk.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::delete] END");
	}

	protected TaifRAttivDetMaterialeDaoRowMapper findByPrimaryKeyRowMapper = new TaifRAttivDetMaterialeDaoRowMapper(
			null, TaifRAttivDetMaterialeDto.class, this);

	protected TaifRAttivDetMaterialeDaoRowMapper findAllRowMapper = new TaifRAttivDetMaterialeDaoRowMapper(null,
			TaifRAttivDetMaterialeDto.class, this);

	protected TaifRAttivDetMaterialeDaoRowMapper byIdMaterialeRowMapper = new TaifRAttivDetMaterialeDaoRowMapper(null,
			TaifRAttivDetMaterialeByIdMaterialeDto.class, this);

	protected TaifRAttivDetMaterialeDaoRowMapper byIdAttivitaRowMapper = new TaifRAttivDetMaterialeDaoRowMapper(null,
			TaifRAttivDetMaterialeByIdAttivitaDto.class, this);

	protected TaifRAttivDetMaterialeDaoRowMapper byIdAttivitaProgressivoRowMapper = new TaifRAttivDetMaterialeDaoRowMapper(
			null, TaifRAttivDetMaterialeByIdAttivitaProgressivoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_ATTIVDET_MATERIALE";
	}

	/** 
	 * Returns all rows from the TAIF_R_ATTIVDET_MATERIALE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAttivDetMaterialeDto findByPrimaryKey(TaifRAttivDetMaterialePk pk)
			throws TaifRAttivDetMaterialeDaoException {
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_MATERIALE,ID_ATTIVITA,PROGRESSIVO,DESCR_ALTRO_MATERIALE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName()
						+ " WHERE ID_MATERIALE = :ID_MATERIALE  AND ID_ATTIVITA = :ID_ATTIVITA  AND PROGRESSIVO = :PROGRESSIVO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MATERIALE]
		params.addValue("ID_MATERIALE", pk.getIdMateriale(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", pk.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.INTEGER);

		List<TaifRAttivDetMaterialeDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAttivDetMaterialeDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifRAttivDetMaterialeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAttivDetMaterialeDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_ATTIVDET_MATERIALE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAttivDetMaterialeDto> findAll() throws TaifRAttivDetMaterialeDaoException {
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_MATERIALE,ID_ATTIVITA,PROGRESSIVO,DESCR_ALTRO_MATERIALE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY PROGRESSIVO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifRAttivDetMaterialeDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAttivDetMaterialeDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifRAttivDetMaterialeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAttivDetMaterialeDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdMateriale con Qdef
		 * @generated
		 */

	public List<TaifRAttivDetMaterialeByIdMaterialeDto> findByIdMateriale(java.lang.Integer input)
			throws TaifRAttivDetMaterialeDaoException {
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findByIdMateriale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT attDett.ID_MATERIALE as idMatt, attDett.DESCR_ALTRO_MATERIALE as materiale");

		sql.append(" FROM TAIF_R_ATTIVDET_MATERIALE attDett");

		sql.append(" WHERE ");

		sql.append("attivMat.id_materiale=:idMateriale");
		/*PROTECTED REGION ID(R-112511583) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idMateriale", input);

		/*PROTECTED REGION END*/

		List<TaifRAttivDetMaterialeByIdMaterialeDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdMaterialeRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAttivDetMaterialeDaoImpl::findByIdMateriale] ERROR esecuzione query", ex);
			throw new TaifRAttivDetMaterialeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAttivDetMaterialeDaoImpl", "findByIdMateriale", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findByIdMateriale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAttivita con Qdef
		 * @generated
		 */

	public List<TaifRAttivDetMaterialeByIdAttivitaDto> findByIdAttivita(java.lang.Integer input)
			throws TaifRAttivDetMaterialeDaoException {
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findByIdAttivita] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivMat.ID_ATTIVITA as idAtt, attivMat.DESCR_ALTRO_MATERIALE as materiale, attivMat.PROGRESSIVO as progressivo, attivMat.DATA_INSERIMENTO as data, attivMat.ID_MATERIALE as idMateriale");

		sql.append(" FROM TAIF_R_ATTIVDET_MATERIALE attivMat");

		sql.append(" WHERE ");

		sql.append("attivMat.id_attivita=:idAttivita");
		/*PROTECTED REGION ID(R-727464343) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAttivita", input);

		/*PROTECTED REGION END*/

		List<TaifRAttivDetMaterialeByIdAttivitaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAttivitaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAttivDetMaterialeDaoImpl::findByIdAttivita] ERROR esecuzione query", ex);
			throw new TaifRAttivDetMaterialeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAttivDetMaterialeDaoImpl", "findByIdAttivita", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findByIdAttivita] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAttivitaProgressivo con Qdef
		 * @generated
		 */

	public List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> findByIdAttivitaProgressivo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AttivitaProgressivoFilter input)
			throws TaifRAttivDetMaterialeDaoException {
		LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findByIdAttivitaProgressivo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivMat.ID_MATERIALE as idMateriale, attivMat.PROGRESSIVO as progressivo, attivMat.ID_ATTIVITA as idAttivita, attivMat.DESCR_ALTRO_MATERIALE as descrizioneAltroMateriale");

		sql.append(" FROM TAIF_R_ATTIVDET_MATERIALE attivMat");

		sql.append(" WHERE ");

		sql.append(" attivMat.id_attivita=:idAttivita and attivMat.progressivo=:progressivo");
		/*PROTECTED REGION ID(R-1739032014) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAttivita", input.getIdAttivita());
		paramMap.addValue("progressivo", input.getProgressivo());

		/*PROTECTED REGION END*/

		List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAttivitaProgressivoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAttivDetMaterialeDaoImpl::findByIdAttivitaProgressivo] ERROR esecuzione query", ex);
			throw new TaifRAttivDetMaterialeDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAttivDetMaterialeDaoImpl", "findByIdAttivitaProgressivo", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAttivDetMaterialeDaoImpl::findByIdAttivitaProgressivo] END");
		}
		return list;
	}

}
