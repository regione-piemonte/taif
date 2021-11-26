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

/*PROTECTED REGION ID(R1428107857) ENABLED START*/
// aggiungere qui eventuali import custom. 

/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTStoricoStato.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byStatoPratica (datagen::CustomFinder)
 *   - byidPraticaIT (datagen::CustomFinder)
 *   - byidPraticaFR (datagen::CustomFinder)
 *   - statoAttivo (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - cambioStato (datagen::UpdateColumns)
 *   - aggiornaStato (datagen::UpdateColumns)
 *   - inserisciProtocollo (datagen::UpdateColumns)
 *   - modificaStato (datagen::CustomUpdater)
 *   - fineStato (datagen::CustomUpdater)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTStoricoStatoDaoImpl extends AbstractDAO implements TaifTStoricoStatoDao {
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
	 * Metodo di inserimento del DAO taifTStoricoStato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTStoricoStatoPk
	 * @generated
	 */

	public TaifTStoricoStatoPk insert(TaifTStoricoStatoDto dto)

	{
		LOG.debug("[TaifTStoricoStatoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PRATICA,DATA_INSERIMENTO_STATO,FK_STATO_PRATICA,NUMERO_PROTOCOLLO,DATA_PROTOCOLLO,DATA_AGGIORNAMENTO,NOTE,FK_CONFIG_UTENTE,DATA_FINE_STATO ) VALUES (  :ID_PRATICA , :DATA_INSERIMENTO_STATO , :FK_STATO_PRATICA , :NUMERO_PROTOCOLLO , :DATA_PROTOCOLLO , :DATA_AGGIORNAMENTO , :NOTE , :FK_CONFIG_UTENTE , :DATA_FINE_STATO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", dto.getIdPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_STATO]
		params.addValue("DATA_INSERIMENTO_STATO", dto.getDataInserimentoStato(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_STATO_PRATICA]
		params.addValue("FK_STATO_PRATICA", dto.getFkStatoPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NUMERO_PROTOCOLLO]
		params.addValue("NUMERO_PROTOCOLLO", dto.getNumeroProtocollo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_PROTOCOLLO]
		params.addValue("DATA_PROTOCOLLO", dto.getDataProtocollo(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_FINE_STATO]
		params.addValue("DATA_FINE_STATO", dto.getDataFineStato(), java.sql.Types.DATE);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifTStoricoStatoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void update(TaifTStoricoStatoDto dto) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO_PRATICA = :FK_STATO_PRATICA ,NUMERO_PROTOCOLLO = :NUMERO_PROTOCOLLO ,DATA_PROTOCOLLO = :DATA_PROTOCOLLO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,NOTE = :NOTE ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,DATA_FINE_STATO = :DATA_FINE_STATO  WHERE ID_PRATICA = :ID_PRATICA  AND DATA_INSERIMENTO_STATO = :DATA_INSERIMENTO_STATO ";

		if (dto.getIdPratica() == null || dto.getDataInserimentoStato() == null) {
			LOG.error("[TaifTStoricoStatoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTStoricoStatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", dto.getIdPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_STATO]
		params.addValue("DATA_INSERIMENTO_STATO", dto.getDataInserimentoStato(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_STATO_PRATICA]
		params.addValue("FK_STATO_PRATICA", dto.getFkStatoPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NUMERO_PROTOCOLLO]
		params.addValue("NUMERO_PROTOCOLLO", dto.getNumeroProtocollo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_PROTOCOLLO]
		params.addValue("DATA_PROTOCOLLO", dto.getDataProtocollo(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_FINE_STATO]
		params.addValue("DATA_FINE_STATO", dto.getDataFineStato(), java.sql.Types.DATE);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStoricoStatoDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void updateColumnsCambioStato(TaifTStoricoStatoDto dto) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::updateColumnsCambioStato] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_FINE_STATO = :DATA_FINE_STATO  WHERE ID_PRATICA = :ID_PRATICA  AND DATA_INSERIMENTO_STATO = :DATA_INSERIMENTO_STATO ";

		if (dto.getIdPratica() == null || dto.getDataInserimentoStato() == null) {
			LOG.error("[TaifTStoricoStatoDaoImpl::updateColumnsCambioStato] ERROR chiave primaria non impostata");
			throw new TaifTStoricoStatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_FINE_STATO]
		params.addValue("DATA_FINE_STATO", dto.getDataFineStato(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", dto.getIdPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_STATO]
		params.addValue("DATA_INSERIMENTO_STATO", dto.getDataInserimentoStato(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStoricoStatoDaoImpl::updateColumnsCambioStato] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void updateColumnsAggiornaStato(TaifTStoricoStatoDto dto) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::updateColumnsAggiornaStato] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,DATA_PROTOCOLLO = :DATA_PROTOCOLLO ,NUMERO_PROTOCOLLO = :NUMERO_PROTOCOLLO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,NOTE = :NOTE  WHERE ID_PRATICA = :ID_PRATICA  AND DATA_INSERIMENTO_STATO = :DATA_INSERIMENTO_STATO ";

		if (dto.getIdPratica() == null || dto.getDataInserimentoStato() == null) {
			LOG.error("[TaifTStoricoStatoDaoImpl::updateColumnsAggiornaStato] ERROR chiave primaria non impostata");
			throw new TaifTStoricoStatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_PROTOCOLLO]
		params.addValue("DATA_PROTOCOLLO", dto.getDataProtocollo(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [NUMERO_PROTOCOLLO]
		params.addValue("NUMERO_PROTOCOLLO", dto.getNumeroProtocollo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", dto.getIdPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_STATO]
		params.addValue("DATA_INSERIMENTO_STATO", dto.getDataInserimentoStato(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStoricoStatoDaoImpl::updateColumnsAggiornaStato] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void updateColumnsInserisciProtocollo(TaifTStoricoStatoDto dto) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::updateColumnsInserisciProtocollo] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NUMERO_PROTOCOLLO = :NUMERO_PROTOCOLLO ,DATA_PROTOCOLLO = :DATA_PROTOCOLLO  WHERE ID_PRATICA = :ID_PRATICA  AND DATA_INSERIMENTO_STATO = :DATA_INSERIMENTO_STATO ";

		if (dto.getIdPratica() == null || dto.getDataInserimentoStato() == null) {
			LOG.error(
					"[TaifTStoricoStatoDaoImpl::updateColumnsInserisciProtocollo] ERROR chiave primaria non impostata");
			throw new TaifTStoricoStatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [NUMERO_PROTOCOLLO]
		params.addValue("NUMERO_PROTOCOLLO", dto.getNumeroProtocollo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_PROTOCOLLO]
		params.addValue("DATA_PROTOCOLLO", dto.getDataProtocollo(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", dto.getIdPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_STATO]
		params.addValue("DATA_INSERIMENTO_STATO", dto.getDataInserimentoStato(), java.sql.Types.TIMESTAMP);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStoricoStatoDaoImpl::updateColumnsInserisciProtocollo] END");
	}

	/** 
	 * Custom updater in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void customUpdaterModificaStato(Integer idPratica, Integer filter,
			it.csi.taif.taifweb.dto.domanda.DettaglioStato value) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::customUpdaterModificaStato] START");
		/*PROTECTED REGION ID(R-1432911315) ENABLED START*/
		//***scrivere la custom query
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ");
		sql.append(getTableName());
		sql.append(" SET ");
		sql.append("DATA_AGGIORNAMENTO = NOW(), ");
		sql.append("DATA_PROTOCOLLO = to_date(:dataProtocollo, 'DD/MM/YYYY') ,");
		sql.append("NUMERO_PROTOCOLLO = :numeroProtocollo ,");
		sql.append("FK_CONFIG_UTENTE = :idConfigUtente ,");
		sql.append("NOTE = :note ");
		sql.append("WHERE ID_PRATICA = :idPratica ");
		sql.append("AND TO_CHAR (DATA_INSERIMENTO_STATO,'DD/MM/YYYY HH24:MI:SS')  =  :dataInserimentoStato");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("dataProtocollo", value.getDataProtocollo(), java.sql.Types.VARCHAR);
		params.addValue("numeroProtocollo", value.getNumeroProtocollo(), java.sql.Types.VARCHAR);
		params.addValue("idConfigUtente", filter, java.sql.Types.INTEGER);
		params.addValue("note", value.getNote(), java.sql.Types.VARCHAR);
		params.addValue("idPratica", idPratica, java.sql.Types.INTEGER);
		params.addValue("dataInserimentoStato", value.getDataInserimento(), java.sql.Types.VARCHAR);
		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStoricoStatoDaoImpl::customUpdaterModificaStato] END");
	}

	/** 
	 * Custom updater in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */
	public void customUpdaterFineStato(TaifTStoricoStatoDto filter, String value) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::customUpdaterFineStato] START");
		/*PROTECTED REGION ID(R723282747) ENABLED START*/
		//***scrivere la custom query
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ");
		sql.append(getTableName());
		sql.append(" SET ");
		sql.append("DATA_FINE_STATO = NOW() ");
		sql.append("WHERE ID_PRATICA = :idPratica ");
		sql.append("AND TO_CHAR (DATA_INSERIMENTO_STATO,'DD/MM/YYYY HH24:MI:SS')  =  :dataInserimentoStato");

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("idPratica", filter.getIdPratica(), java.sql.Types.INTEGER);
		params.addValue("dataInserimentoStato", value, java.sql.Types.VARCHAR);

		/*PROTECTED REGION END*/

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStoricoStatoDaoImpl::customUpdaterFineStato] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_STORICO_STATO table.
	 * @generated
	 */

	public void delete(TaifTStoricoStatoPk pk) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_PRATICA = :ID_PRATICA  AND DATA_INSERIMENTO_STATO = :DATA_INSERIMENTO_STATO ";

		if (pk == null) {
			LOG.error("[TaifTStoricoStatoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTStoricoStatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", pk.getIdPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_STATO]
		params.addValue("DATA_INSERIMENTO_STATO", pk.getDataInserimentoStato(), java.sql.Types.TIMESTAMP);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStoricoStatoDaoImpl::delete] END");
	}

	protected TaifTStoricoStatoDaoRowMapper findByPrimaryKeyRowMapper = new TaifTStoricoStatoDaoRowMapper(null,
			TaifTStoricoStatoDto.class, this);

	protected TaifTStoricoStatoDaoRowMapper findAllRowMapper = new TaifTStoricoStatoDaoRowMapper(null,
			TaifTStoricoStatoDto.class, this);

	protected TaifTStoricoStatoDaoRowMapper byStatoPraticaRowMapper = new TaifTStoricoStatoDaoRowMapper(null,
			TaifTStoricoStatoByStatoPraticaDto.class, this);

	protected TaifTStoricoStatoDaoRowMapper byidPraticaITRowMapper = new TaifTStoricoStatoDaoRowMapper(null,
			TaifTStoricoStatoByidPraticaITDto.class, this);

	protected TaifTStoricoStatoDaoRowMapper byidPraticaFRRowMapper = new TaifTStoricoStatoDaoRowMapper(null,
			TaifTStoricoStatoByidPraticaFRDto.class, this);

	protected TaifTStoricoStatoDaoRowMapper statoAttivoRowMapper = new TaifTStoricoStatoDaoRowMapper(null,
			TaifTStoricoStatoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_STORICO_STATO";
	}

	/** 
	 * Returns all rows from the TAIF_T_STORICO_STATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTStoricoStatoDto findByPrimaryKey(TaifTStoricoStatoPk pk) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PRATICA,DATA_INSERIMENTO_STATO,FK_STATO_PRATICA,NUMERO_PROTOCOLLO,DATA_PROTOCOLLO,DATA_AGGIORNAMENTO,NOTE,FK_CONFIG_UTENTE,DATA_FINE_STATO FROM "
						+ getTableName()
						+ " WHERE ID_PRATICA = :ID_PRATICA  AND DATA_INSERIMENTO_STATO = :DATA_INSERIMENTO_STATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PRATICA]
		params.addValue("ID_PRATICA", pk.getIdPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO_STATO]
		params.addValue("DATA_INSERIMENTO_STATO", pk.getDataInserimentoStato(), java.sql.Types.TIMESTAMP);

		List<TaifTStoricoStatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStoricoStatoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTStoricoStatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStoricoStatoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStoricoStatoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_STORICO_STATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTStoricoStatoDto> findAll() throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PRATICA,DATA_INSERIMENTO_STATO,FK_STATO_PRATICA,NUMERO_PROTOCOLLO,DATA_PROTOCOLLO,DATA_AGGIORNAMENTO,NOTE,FK_CONFIG_UTENTE,DATA_FINE_STATO FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_PRATICA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTStoricoStatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStoricoStatoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTStoricoStatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStoricoStatoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStoricoStatoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byStatoPratica con Qdef
		 * @generated
		 */

	public List<TaifTStoricoStatoByStatoPraticaDto> findByStatoPratica(java.lang.Integer idPratica,
			java.lang.Integer input) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::findByStatoPratica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PRATICA as id, DATA_INSERIMENTO_STATO as dataInserimentoStato, FK_STATO_PRATICA as idStatoPratica, NUMERO_PROTOCOLLO as numProtocollo, DATA_PROTOCOLLO as dataProt, NOTE as note");

		sql.append(" FROM TAIF_T_STORICO_STATO");

		sql.append(" WHERE ");

		sql.append("fk_stato_pratica=:idStatoPratica");
		/*PROTECTED REGION ID(R-1902610056) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" AND id_pratica = :idPratica");
		sql.append(" AND data_fine_stato is null ");

		paramMap.addValue("idPratica", idPratica);
		paramMap.addValue("idStatoPratica", input);

		/*PROTECTED REGION END*/

		List<TaifTStoricoStatoByStatoPraticaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byStatoPraticaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStoricoStatoDaoImpl::findByStatoPratica] ERROR esecuzione query", ex);
			throw new TaifTStoricoStatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStoricoStatoDaoImpl", "findByStatoPratica", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStoricoStatoDaoImpl::findByStatoPratica] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byidPraticaIT con Qdef
		 * @generated
		 */

	public List<TaifTStoricoStatoByidPraticaITDto> findByidPraticaIT(java.lang.Integer input)
			throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::findByidPraticaIT] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT storicoStato.ID_PRATICA as idPratica, storicoStato.FK_STATO_PRATICA as idStatoPratica, storicoStato.DATA_INSERIMENTO_STATO as dataInserimentoStato, storicoStato.NUMERO_PROTOCOLLO as numeroProtocollo, storicoStato.DATA_PROTOCOLLO as dataProtocollo, storicoStato.DATA_AGGIORNAMENTO as dataUltimaModifica, storicoStato.NOTE as note, statoPratica.STATO_PRATICA_ITA as statoPratica, persona.COGNOME as operatoreCognome, persona.NOME as operatoreNome");

		sql.append(
				" FROM TAIF_T_STORICO_STATO storicoStato, TAIF_D_STATO_PRATICA statoPratica, TAIF_CNF_CONFIG_UTENTE configUtente, TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append(
				"statoPratica.ID_STATO_PRATICA = storicoStato.FK_STATO_PRATICA AND storicoStato.FK_CONFIG_UTENTE = configUtente.ID_CONFIG_UTENTE AND configUtente.FK_PERSONA = persona.ID_PERSONA");

		sql.append(" AND ");

		sql.append("storicoStato.ID_PRATICA=:idPratica");
		/*PROTECTED REGION ID(R1162445983) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ORDER BY storicoStato.DATA_INSERIMENTO_STATO ASC ");

		paramMap.addValue("idPratica", input);

		/*PROTECTED REGION END*/

		List<TaifTStoricoStatoByidPraticaITDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byidPraticaITRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStoricoStatoDaoImpl::findByidPraticaIT] ERROR esecuzione query", ex);
			throw new TaifTStoricoStatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStoricoStatoDaoImpl", "findByidPraticaIT", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStoricoStatoDaoImpl::findByidPraticaIT] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byidPraticaFR con Qdef
		 * @generated
		 */

	public List<TaifTStoricoStatoByidPraticaFRDto> findByidPraticaFR(java.lang.Integer input)
			throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::findByidPraticaFR] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT storicoStato.ID_PRATICA as idPratica, statoPratica.STATO_PRATICA_ITA as statoPratica, storicoStato.DATA_INSERIMENTO_STATO as dataInserimentoStato, storicoStato.FK_STATO_PRATICA as idStatoPratica");

		sql.append(" FROM TAIF_T_STORICO_STATO storicoStato, TAIF_D_STATO_PRATICA statoPratica");

		sql.append(" WHERE ");

		sql.append("statoPratica.ID_STATO_PRATICA = storicoStato.FK_STATO_PRATICA");

		sql.append(" AND ");

		sql.append("storicoStato.ID_PRATICA=:idPratica");
		/*PROTECTED REGION ID(R-1557323362) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPratica", input);

		/*PROTECTED REGION END*/

		List<TaifTStoricoStatoByidPraticaFRDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byidPraticaFRRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStoricoStatoDaoImpl::findByidPraticaFR] ERROR esecuzione query", ex);
			throw new TaifTStoricoStatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStoricoStatoDaoImpl", "findByidPraticaFR", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStoricoStatoDaoImpl::findByidPraticaFR] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder statoAttivo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTStoricoStatoDto> findStatoAttivo(java.lang.Integer input) throws TaifTStoricoStatoDaoException {
		LOG.debug("[TaifTStoricoStatoDaoImpl::findStatoAttivo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PRATICA,DATA_INSERIMENTO_STATO,FK_STATO_PRATICA,NUMERO_PROTOCOLLO,DATA_PROTOCOLLO,DATA_AGGIORNAMENTO,NOTE,FK_CONFIG_UTENTE,DATA_FINE_STATO ");
		sql.append(" FROM TAIF_T_STORICO_STATO");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R1736804806) ENABLED START*/
		// personalizzare la query SQL relativa al finder

		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("DATA_FINE_STATO is null AND ");
		sql.append("ID_PRATICA = :idPratica");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-1868739612) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("idPratica", input);

		/*PROTECTED REGION END*/
		List<TaifTStoricoStatoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, statoAttivoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifTStoricoStatoDaoImpl::findStatoAttivo] esecuzione query", ex);
			throw new TaifTStoricoStatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStoricoStatoDaoImpl", "findStatoAttivo", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStoricoStatoDaoImpl::findStatoAttivo] END");
		}
		return list;
	}

}
