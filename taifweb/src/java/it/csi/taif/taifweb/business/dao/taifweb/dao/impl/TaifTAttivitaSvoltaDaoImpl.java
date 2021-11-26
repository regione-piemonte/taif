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

/*PROTECTED REGION ID(R-1992416015) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTAttivitaSvolta.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byIdAzienda (datagen::CustomFinder)
 *   - attivitaSvoltaByIdAzienda (datagen::CustomFinder)
 *   - attivitaSvoltaAndDettByIdAzienda (datagen::CustomFinder)
 *   - dettaglioAttivitaSvoltaByIdAzienda (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - attivitaForIdAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTAttivitaSvoltaDaoImpl extends AbstractDAO implements TaifTAttivitaSvoltaDao {
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
	 * Metodo di inserimento del DAO taifTAttivitaSvolta. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAttivitaSvoltaPk
	 * @generated
	 */

	public TaifTAttivitaSvoltaPk insert(TaifTAttivitaSvoltaDto dto)

	{
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ATTIVITA,FK_AZIENDA,FK_TIPO_ATTIVITA,DESCR_ALTRE_ATTIVITA,PERC_FATTURATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_ATTIVITA , :FK_AZIENDA , :FK_TIPO_ATTIVITA , :DESCR_ALTRE_ATTIVITA , :PERC_FATTURATO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_ATTIVITA]
		params.addValue("FK_TIPO_ATTIVITA", dto.getFkTipoAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRE_ATTIVITA]
		params.addValue("DESCR_ALTRE_ATTIVITA", dto.getDescrAltreAttivita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PERC_FATTURATO]
		params.addValue("PERC_FATTURATO", dto.getPercFatturato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAttivita(newKey);
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_ATTIVITA_SVOLTA table.
	 * @generated
	 */
	public void update(TaifTAttivitaSvoltaDto dto) throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_TIPO_ATTIVITA = :FK_TIPO_ATTIVITA ,DESCR_ALTRE_ATTIVITA = :DESCR_ALTRE_ATTIVITA ,PERC_FATTURATO = :PERC_FATTURATO ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_ATTIVITA = :ID_ATTIVITA ";

		if (dto.getIdAttivita() == null) {
			LOG.error("[TaifTAttivitaSvoltaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTAttivitaSvoltaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_ATTIVITA]
		params.addValue("FK_TIPO_ATTIVITA", dto.getFkTipoAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRE_ATTIVITA]
		params.addValue("DESCR_ALTRE_ATTIVITA", dto.getDescrAltreAttivita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PERC_FATTURATO]
		params.addValue("PERC_FATTURATO", dto.getPercFatturato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_ATTIVITA_SVOLTA table.
	 * @generated
	 */
	public void updateColumnsAttivitaForIdAzienda(TaifTAttivitaSvoltaDto dto) throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::updateColumnsAttivitaForIdAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TIPO_ATTIVITA = :FK_TIPO_ATTIVITA ,DESCR_ALTRE_ATTIVITA = :DESCR_ALTRE_ATTIVITA ,PERC_FATTURATO = :PERC_FATTURATO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_ATTIVITA = :ID_ATTIVITA ";

		if (dto.getIdAttivita() == null) {
			LOG.error(
					"[TaifTAttivitaSvoltaDaoImpl::updateColumnsAttivitaForIdAzienda] ERROR chiave primaria non impostata");
			throw new TaifTAttivitaSvoltaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_ATTIVITA]
		params.addValue("FK_TIPO_ATTIVITA", dto.getFkTipoAttivita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRE_ATTIVITA]
		params.addValue("DESCR_ALTRE_ATTIVITA", dto.getDescrAltreAttivita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PERC_FATTURATO]
		params.addValue("PERC_FATTURATO", dto.getPercFatturato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", dto.getIdAttivita(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::updateColumnsAttivitaForIdAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_ATTIVITA_SVOLTA table.
	 * @generated
	 */

	public void delete(TaifTAttivitaSvoltaPk pk) throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ATTIVITA = :ID_ATTIVITA ";

		if (pk == null) {
			LOG.error("[TaifTAttivitaSvoltaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTAttivitaSvoltaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", pk.getIdAttivita(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::delete] END");
	}

	protected TaifTAttivitaSvoltaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTAttivitaSvoltaDaoRowMapper(null,
			TaifTAttivitaSvoltaDto.class, this);

	protected TaifTAttivitaSvoltaDaoRowMapper findAllRowMapper = new TaifTAttivitaSvoltaDaoRowMapper(null,
			TaifTAttivitaSvoltaDto.class, this);

	protected TaifTAttivitaSvoltaDaoRowMapper byIdAziendaRowMapper = new TaifTAttivitaSvoltaDaoRowMapper(null,
			TaifTAttivitaSvoltaByIdAziendaDto.class, this);

	protected TaifTAttivitaSvoltaDaoRowMapper attivitaSvoltaByIdAziendaRowMapper = new TaifTAttivitaSvoltaDaoRowMapper(
			null, TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto.class, this);

	protected TaifTAttivitaSvoltaDaoRowMapper attivitaSvoltaAndDettByIdAziendaRowMapper = new TaifTAttivitaSvoltaDaoRowMapper(
			null, TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto.class, this);

	protected TaifTAttivitaSvoltaDaoRowMapper dettaglioAttivitaSvoltaByIdAziendaRowMapper = new TaifTAttivitaSvoltaDaoRowMapper(
			null, TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_ATTIVITA_SVOLTA";
	}

	/** 
	 * Returns all rows from the TAIF_T_ATTIVITA_SVOLTA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAttivitaSvoltaDto findByPrimaryKey(TaifTAttivitaSvoltaPk pk) throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ATTIVITA,FK_AZIENDA,FK_TIPO_ATTIVITA,DESCR_ALTRE_ATTIVITA,PERC_FATTURATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_ATTIVITA = :ID_ATTIVITA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ATTIVITA]
		params.addValue("ID_ATTIVITA", pk.getIdAttivita(), java.sql.Types.INTEGER);

		List<TaifTAttivitaSvoltaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_ATTIVITA_SVOLTA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAttivitaSvoltaDto> findAll() throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ATTIVITA,FK_AZIENDA,FK_TIPO_ATTIVITA,DESCR_ALTRE_ATTIVITA,PERC_FATTURATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_ATTIVITA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTAttivitaSvoltaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivita.ID_ATTIVITA as id, tipoAtt.TIPO_ATTIVITA as tipoAttivita, attivita.PERC_FATTURATO as fatturato, attivita.DESCR_ALTRE_ATTIVITA as altre, attivita.DATA_INSERIMENTO as dataIns, attivita.FK_TIPO_ATTIVITA as idTipoAttivita");

		sql.append(" FROM TAIF_T_ATTIVITA_SVOLTA attivita, TAIF_D_TIPO_ATTIVITA tipoAtt");

		sql.append(" WHERE ");

		sql.append("attivita.FK_TIPO_ATTIVITA = tipoAtt.ID_TIPO_ATTIVITA");

		sql.append(" AND ");

		sql.append("attivita.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R1479568603) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTAttivitaSvoltaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDaoImpl::findByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDaoImpl", "findByIdAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder attivitaSvoltaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> findAttivitaSvoltaByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findAttivitaSvoltaByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivita.ID_ATTIVITA as id, tipoAttivita.TIPO_ATTIVITA as tipoAttivita, attivita.PERC_FATTURATO as fatturato, attivita.DESCR_ALTRE_ATTIVITA as altreAttivita, attivita.DATA_INSERIMENTO as dataInserimento, attivita.DATA_AGGIORNAMENTO as dataAggiornamento");

		sql.append(" FROM TAIF_T_ATTIVITA_SVOLTA attivita, TAIF_D_TIPO_ATTIVITA tipoAttivita");

		sql.append(" WHERE ");

		sql.append("attivita.FK_TIPO_ATTIVITA = tipoAttivita.ID_TIPO_ATTIVITA");

		sql.append(" AND ");

		sql.append(
				"attivita.fk_azienda=:idAzienda and tipoAttivita.mtd_flg_visibile=:flagVisibile and tipoAttivita.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R-383514352) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (input.getIdTipoAttivita() != 0) {
			sql.append(" AND ");
			sql.append("attivita.fk_tipo_attivita=:idTipoAttivita ");
		}
		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());
		if (input.getIdTipoAttivita() != 0) {
			paramMap.addValue("idTipoAttivita", input.getIdTipoAttivita());
		}

		/*PROTECTED REGION END*/

		List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attivitaSvoltaByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDaoImpl::findAttivitaSvoltaByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDaoImpl", "findAttivitaSvoltaByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findAttivitaSvoltaByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder attivitaSvoltaAndDettByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> findAttivitaSvoltaAndDettByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findAttivitaSvoltaAndDettByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attivitaSvolta.ID_ATTIVITA as id, tipoAttivita.TIPO_ATTIVITA as tipoAttivita, attivitaSvolta.PERC_FATTURATO as fatturato, attivitaSvolta.DESCR_ALTRE_ATTIVITA as altreAttivita, attivitaSvolta.DATA_INSERIMENTO as dataInserimento, attivitaSvolta.DATA_AGGIORNAMENTO as dataAggiornamento, attivitaDettaglio.PROGRESSIVO as progressivoDettaglio, attivitaDettaglio.VALORE1 as valore1Dettaglio, attivitaDettaglio.VALORE2 as valore2Dettaglio, attivitaDettaglio.VALORE3 as valore3Dettaglio, attivitaDettaglio.PERC_CONTO_TERZI as percentualeContoTerzi, attivitaDettaglio.FK_UNITA_DI_MISURA as unitaMisuraDettaglio, tipoAttivita.ID_TIPO_ATTIVITA as idTipoAttivita");

		sql.append(
				" FROM TAIF_T_ATTIVITA_SVOLTA attivitaSvolta, TAIF_D_TIPO_ATTIVITA tipoAttivita, TAIF_T_ATTIVITA_SVOLTA_DETT attivitaDettaglio");

		sql.append(" WHERE ");

		sql.append(
				"attivitaSvolta.FK_TIPO_ATTIVITA = tipoAttivita.ID_TIPO_ATTIVITA AND attivitaSvolta.ID_ATTIVITA = attivitaDettaglio.ID_ATTIVITA");

		sql.append(" AND ");

		sql.append(
				"attivitaSvolta.fk_azienda=:idAzienda and tipoAttivita.mtd_flg_visibile=:flagVisibile and tipoAttivita.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R1669146960) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (input.getIdTipoAttivita() != 0) {
			sql.append(" AND ");
			sql.append("attivitaSvolta.fk_tipo_attivita=:idTipoAttivita ");
		}
		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());
		if (input.getIdTipoAttivita() != 0) {
			paramMap.addValue("idTipoAttivita", input.getIdTipoAttivita());
		}

		/*PROTECTED REGION END*/

		List<TaifTAttivitaSvoltaAttivitaSvoltaAndDettByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, attivitaSvoltaAndDettByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDaoImpl::findAttivitaSvoltaAndDettByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTAttivitaSvoltaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDaoImpl", "findAttivitaSvoltaAndDettByIdAzienda",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findAttivitaSvoltaAndDettByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder dettaglioAttivitaSvoltaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto> findDettaglioAttivitaSvoltaByIdAzienda(
			java.lang.Integer input) throws TaifTAttivitaSvoltaDaoException {
		LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findDettaglioAttivitaSvoltaByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tipoAttivita.TIPO_ATTIVITA as tipoAttivita, attivita.PERC_FATTURATO as fatturato");

		sql.append(" FROM TAIF_T_ATTIVITA_SVOLTA attivita, TAIF_D_TIPO_ATTIVITA tipoAttivita");

		sql.append(" WHERE ");

		sql.append("attivita.FK_TIPO_ATTIVITA = tipoAttivita.ID_TIPO_ATTIVITA");

		sql.append(" AND ");

		sql.append("attivita.fk_azienda=:idAziendaSelezionata");
		/*PROTECTED REGION ID(R125710765) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAziendaSelezionata", input);

		/*PROTECTED REGION END*/

		List<TaifTAttivitaSvoltaDettaglioAttivitaSvoltaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, dettaglioAttivitaSvoltaByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAttivitaSvoltaDaoImpl::findDettaglioAttivitaSvoltaByIdAzienda] ERROR esecuzione query",
					ex);
			throw new TaifTAttivitaSvoltaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAttivitaSvoltaDaoImpl", "findDettaglioAttivitaSvoltaByIdAzienda",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTAttivitaSvoltaDaoImpl::findDettaglioAttivitaSvoltaByIdAzienda] END");
		}
		return list;
	}

}
