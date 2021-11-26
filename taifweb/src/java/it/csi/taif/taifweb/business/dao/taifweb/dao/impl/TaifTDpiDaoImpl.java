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

/*PROTECTED REGION ID(R-434092131) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTDpi.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byAzienda (datagen::CustomFinder)
 *   - byIdTipoDispositivo (datagen::CustomFinder)
 *   - dpiByAziendaVisibile (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - perIdAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTDpiDaoImpl extends AbstractDAO implements TaifTDpiDao {
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
	 * Metodo di inserimento del DAO taifTDpi. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTDpiPk
	 * @generated
	 */

	public TaifTDpiPk insert(TaifTDpiDto dto)

	{
		LOG.debug("[TaifTDpiDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_DPI,FK_AZIENDA,FK_TIPO_DPI,TIPOLOGIA,QUANTITA,ANNO_SCAD,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_DPI , :FK_AZIENDA , :FK_TIPO_DPI , :TIPOLOGIA , :QUANTITA , :ANNO_SCAD , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DPI]
		params.addValue("ID_DPI", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DPI]
		params.addValue("FK_TIPO_DPI", dto.getFkTipoDpi(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [QUANTITA]
		params.addValue("QUANTITA", dto.getQuantita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO_SCAD]
		params.addValue("ANNO_SCAD", dto.getAnnoScad(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdDpi(newKey);
		LOG.debug("[TaifTDpiDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_DPI table.
	 * @generated
	 */
	public void update(TaifTDpiDto dto) throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_TIPO_DPI = :FK_TIPO_DPI ,TIPOLOGIA = :TIPOLOGIA ,QUANTITA = :QUANTITA ,ANNO_SCAD = :ANNO_SCAD ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_DPI = :ID_DPI ";

		if (dto.getIdDpi() == null) {
			LOG.error("[TaifTDpiDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTDpiDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DPI]
		params.addValue("ID_DPI", dto.getIdDpi(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DPI]
		params.addValue("FK_TIPO_DPI", dto.getFkTipoDpi(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [QUANTITA]
		params.addValue("QUANTITA", dto.getQuantita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO_SCAD]
		params.addValue("ANNO_SCAD", dto.getAnnoScad(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTDpiDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_DPI table.
	 * @generated
	 */
	public void updateColumnsPerIdAzienda(TaifTDpiDto dto) throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::updateColumnsPerIdAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_TIPO_DPI = :FK_TIPO_DPI ,QUANTITA = :QUANTITA ,ANNO_SCAD = :ANNO_SCAD ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,TIPOLOGIA = :TIPOLOGIA  WHERE ID_DPI = :ID_DPI ";

		if (dto.getIdDpi() == null) {
			LOG.error("[TaifTDpiDaoImpl::updateColumnsPerIdAzienda] ERROR chiave primaria non impostata");
			throw new TaifTDpiDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_DPI]
		params.addValue("FK_TIPO_DPI", dto.getFkTipoDpi(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [QUANTITA]
		params.addValue("QUANTITA", dto.getQuantita(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO_SCAD]
		params.addValue("ANNO_SCAD", dto.getAnnoScad(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPOLOGIA]
		params.addValue("TIPOLOGIA", dto.getTipologia(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_DPI]
		params.addValue("ID_DPI", dto.getIdDpi(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTDpiDaoImpl::updateColumnsPerIdAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_DPI table.
	 * @generated
	 */

	public void delete(TaifTDpiPk pk) throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_DPI = :ID_DPI ";

		if (pk == null) {
			LOG.error("[TaifTDpiDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTDpiDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DPI]
		params.addValue("ID_DPI", pk.getIdDpi(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTDpiDaoImpl::delete] END");
	}

	protected TaifTDpiDaoRowMapper findByPrimaryKeyRowMapper = new TaifTDpiDaoRowMapper(null, TaifTDpiDto.class, this);

	protected TaifTDpiDaoRowMapper findAllRowMapper = new TaifTDpiDaoRowMapper(null, TaifTDpiDto.class, this);

	protected TaifTDpiDaoRowMapper byFilterRowMapper = new TaifTDpiDaoRowMapper(null, TaifTDpiByFilterDto.class, this);

	protected TaifTDpiDaoRowMapper byAziendaRowMapper = new TaifTDpiDaoRowMapper(null, TaifTDpiByAziendaDto.class,
			this);

	protected TaifTDpiDaoRowMapper byIdTipoDispositivoRowMapper = new TaifTDpiDaoRowMapper(null,
			TaifTDpiByIdTipoDispositivoDto.class, this);

	protected TaifTDpiDaoRowMapper dpiByAziendaVisibileRowMapper = new TaifTDpiDaoRowMapper(null,
			TaifTDpiDpiByAziendaVisibileDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_DPI";
	}

	/** 
	 * Returns all rows from the TAIF_T_DPI table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTDpiDto findByPrimaryKey(TaifTDpiPk pk) throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DPI,FK_AZIENDA,FK_TIPO_DPI,TIPOLOGIA,QUANTITA,ANNO_SCAD,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_DPI = :ID_DPI ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_DPI]
		params.addValue("ID_DPI", pk.getIdDpi(), java.sql.Types.INTEGER);

		List<TaifTDpiDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTDpiDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTDpiDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTDpiDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_DPI.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTDpiDto> findAll() throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_DPI,FK_AZIENDA,FK_TIPO_DPI,TIPOLOGIA,QUANTITA,ANNO_SCAD,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_DPI ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTDpiDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTDpiDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTDpiDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTDpiDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTDpiByFilterDto> findByFilter(it.csi.taif.taifweb.business.dao.taifweb.filter.DpiFilter input)
			throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT dpi.ID_DPI as id, dpi.FK_AZIENDA as idAzienda, dpi.TIPOLOGIA as tipo, dpi.QUANTITA as quant, dpi.ANNO_SCAD as scad, dpi.FK_TIPO_DPI as tipDpi");

		sql.append(" FROM TAIF_T_DPI dpi");

		sql.append(" WHERE ");

		sql.append("dpi.tipologia=:tipologia and dpi.quantita=:quantita and dpi.anno_scad=:scadenza");
		/*PROTECTED REGION ID(R34346166) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("tipologia", input.getTipologia());
		paramMap.addValue("quantita", input.getQuantita());
		paramMap.addValue("scadenza", input.getAnnoScadenza());

		/*PROTECTED REGION END*/

		List<TaifTDpiByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTDpiDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTDpiDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifTDpiDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAzienda con Qdef
		 * @generated
		 */

	public List<TaifTDpiByAziendaDto> findByAzienda(java.lang.Integer input) throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::findByAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT dpi.ID_DPI as idDpi, dpi.FK_AZIENDA as idAzienda, dpi.TIPOLOGIA as tipologia, dpi.QUANTITA as quantita, dpi.ANNO_SCAD as annoScadenza, dpi.FK_TIPO_DPI as idTipoDpi, dpi.DATA_AGGIORNAMENTO as dataAggiornamento");

		sql.append(" FROM TAIF_T_DPI dpi");

		sql.append(" WHERE ");

		sql.append("dpi.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R371446956) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTDpiByAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTDpiDaoImpl::findByAzienda] ERROR esecuzione query", ex);
			throw new TaifTDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTDpiDaoImpl", "findByAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTDpiDaoImpl::findByAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdTipoDispositivo con Qdef
		 * @generated
		 */

	public List<TaifTDpiByIdTipoDispositivoDto> findByIdTipoDispositivo(java.lang.Integer input)
			throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::findByIdTipoDispositivo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT dpi.ID_DPI as idDpi, dpi.FK_AZIENDA as idAzienda, dpi.TIPOLOGIA as tipologia, dpi.QUANTITA as quant, dpi.ANNO_SCAD as scad, dpi.FK_TIPO_DPI as idTipoDpi, tipoDpi.TIPO_DPI as tipoDpi");

		sql.append(" FROM TAIF_T_DPI dpi, TAIF_D_TIPO_DPI tipoDpi");

		sql.append(" WHERE ");

		sql.append("dpi.ID_DPI = tipoDpi.ID_TIPO_DPI");

		sql.append(" AND ");

		sql.append("dpi.fk_tipo_dpi=:idDpi");
		/*PROTECTED REGION ID(R2004318144) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idDpi", input);

		/*PROTECTED REGION END*/

		List<TaifTDpiByIdTipoDispositivoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdTipoDispositivoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTDpiDaoImpl::findByIdTipoDispositivo] ERROR esecuzione query", ex);
			throw new TaifTDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTDpiDaoImpl", "findByIdTipoDispositivo", "esecuzione query", sql.toString());
			LOG.debug("[TaifTDpiDaoImpl::findByIdTipoDispositivo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder dpiByAziendaVisibile con Qdef
		 * @generated
		 */

	public List<TaifTDpiDpiByAziendaVisibileDto> findDpiByAziendaVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input) throws TaifTDpiDaoException {
		LOG.debug("[TaifTDpiDaoImpl::findDpiByAziendaVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT dpi.ID_DPI as idDpi, dpi.FK_AZIENDA as idAzienda, dpi.TIPOLOGIA as tipologia, dpi.QUANTITA as quantita, dpi.ANNO_SCAD as annoScadenza, tipoDpi.TIPO_DPI as tipoDpi, tipoDpi.ID_TIPO_DPI as idTipoDpi");

		sql.append(" FROM TAIF_T_DPI dpi, TAIF_D_TIPO_DPI tipoDpi");

		sql.append(" WHERE ");

		sql.append("dpi.FK_TIPO_DPI = tipoDpi.ID_TIPO_DPI");

		sql.append(" AND ");

		sql.append("dpi.fk_azienda=:idAzienda and tipoDpi.mtd_flg_visibile=:flagVisibile");
		/*PROTECTED REGION ID(R445411962) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifTDpiDpiByAziendaVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, dpiByAziendaVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTDpiDaoImpl::findDpiByAziendaVisibile] ERROR esecuzione query", ex);
			throw new TaifTDpiDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTDpiDaoImpl", "findDpiByAziendaVisibile", "esecuzione query", sql.toString());
			LOG.debug("[TaifTDpiDaoImpl::findDpiByAziendaVisibile] END");
		}
		return list;
	}

}
