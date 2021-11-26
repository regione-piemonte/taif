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

/*PROTECTED REGION ID(R475644689) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTAttivitaSvoltaDett.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byFilterAttivita (datagen::CustomFinder)
 *   - byAttivitaProgressivo (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - forIdAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTAttivitaSvoltaDettDaoImpl extends AbstractDAO implements TaifTAttivitaSvoltaDettDao {
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
	 * Metodo di inserimento del DAO taifTAttivitaSvoltaDett. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAttivitaSvoltaDettPk
	 * @generated
	 */

	public TaifTAttivitaSvoltaDettPk insert(TaifTAttivitaSvoltaDettDto dto)

	{
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ATTIVITA,PROGRESSIVO,FK_UNITA_DI_MISURA,VALORE1,VALORE2,VALORE3,PERC_CONTO_TERZI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_ATTIVITA , :PROGRESSIVO , :FK_UNITA_DI_MISURA , :VALORE1 , :VALORE2 , :VALORE3 , :PERC_CONTO_TERZI , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_DI_MISURA]
		params.addValue("FK_UNITA_DI_MISURA", dto.getFkUnitaDiMisura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [VALORE1]
		params.addValue("VALORE1", dto.getValore1(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [VALORE2]
		params.addValue("VALORE2", dto.getValore2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [VALORE3]
		params.addValue("VALORE3", dto.getValore3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PERC_CONTO_TERZI]
		params.addValue("PERC_CONTO_TERZI", dto.getPercContoTerzi(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_ATTIVITA_SVOLTA_DETT table.
	 * @generated
	 */
	public void update(TaifTAttivitaSvoltaDettDto dto) throws TaifTAttivitaSvoltaDettDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_UNITA_DI_MISURA = :FK_UNITA_DI_MISURA ,VALORE1 = :VALORE1 ,VALORE2 = :VALORE2 ,VALORE3 = :VALORE3 ,PERC_CONTO_TERZI = :PERC_CONTO_TERZI ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_ATTIVITA = :ID_ATTIVITA  AND PROGRESSIVO = :PROGRESSIVO ";

		if (dto.getIdAttivita() == null || dto.getProgressivo() == null) {
			LOG.error("[TaifTAttivitaSvoltaDettDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTAttivitaSvoltaDettDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_DI_MISURA]
		params.addValue("FK_UNITA_DI_MISURA", dto.getFkUnitaDiMisura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [VALORE1]
		params.addValue("VALORE1", dto.getValore1(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [VALORE2]
		params.addValue("VALORE2", dto.getValore2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [VALORE3]
		params.addValue("VALORE3", dto.getValore3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PERC_CONTO_TERZI]
		params.addValue("PERC_CONTO_TERZI", dto.getPercContoTerzi(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_ATTIVITA_SVOLTA_DETT table.
	 * @generated
	 */
	public void updateColumnsForIdAzienda(TaifTAttivitaSvoltaDettDto dto) throws TaifTAttivitaSvoltaDettDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::updateColumnsForIdAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_UNITA_DI_MISURA = :FK_UNITA_DI_MISURA ,VALORE1 = :VALORE1 ,VALORE2 = :VALORE2 ,VALORE3 = :VALORE3 ,PERC_CONTO_TERZI = :PERC_CONTO_TERZI ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_ATTIVITA = :ID_ATTIVITA  AND PROGRESSIVO = :PROGRESSIVO ";

		if (dto.getIdAttivita() == null || dto.getProgressivo() == null) {
			LOG.error(
					"[TaifTAttivitaSvoltaDettDaoImpl::updateColumnsForIdAzienda] ERROR chiave primaria non impostata");
			throw new TaifTAttivitaSvoltaDettDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_DI_MISURA]
		params.addValue("FK_UNITA_DI_MISURA", dto.getFkUnitaDiMisura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [VALORE1]
		params.addValue("VALORE1", dto.getValore1(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [VALORE2]
		params.addValue("VALORE2", dto.getValore2(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [VALORE3]
		params.addValue("VALORE3", dto.getValore3(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [PERC_CONTO_TERZI]
		params.addValue("PERC_CONTO_TERZI", dto.getPercContoTerzi(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", dto.getProgressivo(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::updateColumnsForIdAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_ATTIVITA_SVOLTA_DETT table.
	 * @generated
	 */

	public void delete(TaifTAttivitaSvoltaDettPk pk) throws TaifTAttivitaSvoltaDettDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_ATTIVITA = :ID_ATTIVITA  AND PROGRESSIVO = :PROGRESSIVO ";

		if (pk == null) {
			LOG.error("[TaifTAttivitaSvoltaDettDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTAttivitaSvoltaDettDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", pk.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::delete] END");
	}

	protected TaifTAttivitaSvoltaDettDaoRowMapper findByPrimaryKeyRowMapper = new TaifTAttivitaSvoltaDettDaoRowMapper(
			null, TaifTAttivitaSvoltaDettDto.class, this);

	protected TaifTAttivitaSvoltaDettDaoRowMapper findAllRowMapper = new TaifTAttivitaSvoltaDettDaoRowMapper(null,
			TaifTAttivitaSvoltaDettDto.class, this);

	protected TaifTAttivitaSvoltaDettDaoRowMapper byFilterRowMapper = new TaifTAttivitaSvoltaDettDaoRowMapper(null,
			TaifTAttivitaSvoltaDettByFilterDto.class, this);

	protected TaifTAttivitaSvoltaDettDaoRowMapper byFilterAttivitaRowMapper = new TaifTAttivitaSvoltaDettDaoRowMapper(
			null, TaifTAttivitaSvoltaDettByFilterAttivitaDto.class, this);

	protected TaifTAttivitaSvoltaDettDaoRowMapper byAttivitaProgressivoRowMapper = new TaifTAttivitaSvoltaDettDaoRowMapper(
			null, TaifTAttivitaSvoltaDettByAttivitaProgressivoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_ATTIVITA_SVOLTA_DETT";
	}

	/** 
	 * Returns all rows from the TAIF_T_ATTIVITA_SVOLTA_DETT table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAttivitaSvoltaDettDto findByPrimaryKey(TaifTAttivitaSvoltaDettPk pk)
			throws TaifTAttivitaSvoltaDettDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ATTIVITA,PROGRESSIVO,FK_UNITA_DI_MISURA,VALORE1,VALORE2,VALORE3,PERC_CONTO_TERZI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_ATTIVITA = :ID_ATTIVITA  AND PROGRESSIVO = :PROGRESSIVO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", pk.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PROGRESSIVO]
		params.addValue("PROGRESSIVO", pk.getProgressivo(), java.sql.Types.INTEGER);

		List<TaifTAttivitaSvoltaDettDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDettDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDettDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_ATTIVITA_SVOLTA_DETT.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAttivitaSvoltaDettDto> findAll() throws TaifTAttivitaSvoltaDettDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ATTIVITA,PROGRESSIVO,FK_UNITA_DI_MISURA,VALORE1,VALORE2,VALORE3,PERC_CONTO_TERZI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_ATTIVITA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTAttivitaSvoltaDettDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDettDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDettDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaDettByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AttivitaSvoltaDettFilter input)
			throws TaifTAttivitaSvoltaDettDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attiv.ID_ATTIVITA as id, attiv.VALORE1 as val1, attiv.VALORE2 as val2, attiv.VALORE3 as val3, attiv.PERC_CONTO_TERZI as percent");

		sql.append(" FROM TAIF_T_ATTIVITA_SVOLTA_DETT attiv");

		sql.append(" WHERE ");

		sql.append(
				"(attiv.id_attivita =:attivita and attiv.valore1=:val1) or (attiv.id_attivita =:attivita and attiv.valore2=:val2) or (attiv.id_attivita =:attivita and attiv.valore3=:val3)");
		/*PROTECTED REGION ID(R1018997667) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("attivita", input.getIdAttivita());
		paramMap.addValue("val1", input.getValore1());
		paramMap.addValue("val2", input.getValore2());
		paramMap.addValue("val3", input.getValore3());

		/*PROTECTED REGION END*/

		List<TaifTAttivitaSvoltaDettByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDettDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDettDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterAttivita con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> findByFilterAttivita(java.lang.Integer input)
			throws TaifTAttivitaSvoltaDettDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findByFilterAttivita] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attiv.ID_ATTIVITA as id, attiv.VALORE1 as val1, attiv.VALORE2 as val2, attiv.VALORE3 as val3, attiv.PERC_CONTO_TERZI as percent, attiv.PROGRESSIVO as progressivo, attiv.FK_UNITA_DI_MISURA as unitaMisura, attiv.FK_CONFIG_UTENTE as configUtente");

		sql.append(" FROM TAIF_T_ATTIVITA_SVOLTA_DETT attiv");

		sql.append(" WHERE ");

		sql.append("attiv.id_attivita =:attivita");
		/*PROTECTED REGION ID(R-1009181893) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("attivita", input);

		/*PROTECTED REGION END*/

		List<TaifTAttivitaSvoltaDettByFilterAttivitaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterAttivitaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDettDaoImpl::findByFilterAttivita] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDettDaoImpl", "findByFilterAttivita", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findByFilterAttivita] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAttivitaProgressivo con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto> findByAttivitaProgressivo(java.lang.Integer input)
			throws TaifTAttivitaSvoltaDettDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findByAttivitaProgressivo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivitaDettaglio.ID_ATTIVITA as idAttivita, attivitaDettaglio.VALORE1 as valore1, attivitaDettaglio.VALORE2 as valore2, attivitaDettaglio.VALORE3 as valore3, attivitaDettaglio.PERC_CONTO_TERZI as percentuale, attivitaDettaglio.PROGRESSIVO as progressivoDett, attivitaDettaglio.FK_UNITA_DI_MISURA as unitaMisuraDett, attivitaDettaglio.FK_CONFIG_UTENTE as configUtenteDett, attivitaMateriale.ID_MATERIALE as idMateriale, attivitaMateriale.DESCR_ALTRO_MATERIALE as altroMateriale");

		sql.append(" FROM TAIF_T_ATTIVITA_SVOLTA_DETT attivitaDettaglio, TAIF_R_ATTIVDET_MATERIALE attivitaMateriale");

		sql.append(" WHERE ");

		sql.append(
				"attivitaDettaglio.ID_ATTIVITA = attivitaMateriale.ID_ATTIVITA AND attivitaDettaglio.PROGRESSIVO = attivitaMateriale.PROGRESSIVO");

		sql.append(" AND ");

		sql.append("attivitaDettaglio.id_attivita =:attivita");
		/*PROTECTED REGION ID(R1191961672) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("attivita", input);

		/*PROTECTED REGION END*/

		List<TaifTAttivitaSvoltaDettByAttivitaProgressivoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAttivitaProgressivoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDettDaoImpl::findByAttivitaProgressivo] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDettDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDettDaoImpl", "findByAttivitaProgressivo", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDettDaoImpl::findByAttivitaProgressivo] END");
		}
		return list;
	}

}
