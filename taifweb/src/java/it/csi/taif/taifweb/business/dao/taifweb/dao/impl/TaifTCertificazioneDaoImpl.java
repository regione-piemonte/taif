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

/*PROTECTED REGION ID(R1485911665) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTCertificazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byAzienda (datagen::CustomFinder)
 *   - byTipoCert (datagen::CustomFinder)
 *   - elencoCertificazioni (datagen::CustomFinder)
 *   - byAziendaTipoCert (datagen::CustomFinder)
 *   - findCertificazioniByIdAzienda (datagen::CustomFinder)
 *   - dettaglioCertificazioniByIdAzienda (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - certificazione (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTCertificazioneDaoImpl extends AbstractDAO implements TaifTCertificazioneDao {
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
	 * Metodo di inserimento del DAO taifTCertificazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTCertificazionePk
	 * @generated
	 */

	public TaifTCertificazionePk insert(TaifTCertificazioneDto dto)

	{
		LOG.debug("[TaifTCertificazioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CERTIFICAZIONE,FK_AZIENDA,FK_TIPO_CERTIFICAZIONE,DESCR_ALTRO,NUMERO,ENTE_CERTIFICATORE,ANNO,DATA_SCADENZA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_CERTIFICAZIONE , :FK_AZIENDA , :FK_TIPO_CERTIFICAZIONE , :DESCR_ALTRO , :NUMERO , :ENTE_CERTIFICATORE , :ANNO , :DATA_SCADENZA , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CERTIFICAZIONE]
		params.addValue("ID_CERTIFICAZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CERTIFICAZIONE]
		params.addValue("FK_TIPO_CERTIFICAZIONE", dto.getFkTipoCertificazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO]
		params.addValue("NUMERO", dto.getNumero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ENTE_CERTIFICATORE]
		params.addValue("ENTE_CERTIFICATORE", dto.getEnteCertificatore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_SCADENZA]
		params.addValue("DATA_SCADENZA", dto.getDataScadenza(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdCertificazione(newKey);
		LOG.debug("[TaifTCertificazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_CERTIFICAZIONE table.
	 * @generated
	 */
	public void update(TaifTCertificazioneDto dto) throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_TIPO_CERTIFICAZIONE = :FK_TIPO_CERTIFICAZIONE ,DESCR_ALTRO = :DESCR_ALTRO ,NUMERO = :NUMERO ,ENTE_CERTIFICATORE = :ENTE_CERTIFICATORE ,ANNO = :ANNO ,DATA_SCADENZA = :DATA_SCADENZA ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_CERTIFICAZIONE = :ID_CERTIFICAZIONE ";

		if (dto.getIdCertificazione() == null) {
			LOG.error("[TaifTCertificazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTCertificazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CERTIFICAZIONE]
		params.addValue("ID_CERTIFICAZIONE", dto.getIdCertificazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CERTIFICAZIONE]
		params.addValue("FK_TIPO_CERTIFICAZIONE", dto.getFkTipoCertificazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO]
		params.addValue("NUMERO", dto.getNumero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ENTE_CERTIFICATORE]
		params.addValue("ENTE_CERTIFICATORE", dto.getEnteCertificatore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_SCADENZA]
		params.addValue("DATA_SCADENZA", dto.getDataScadenza(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTCertificazioneDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_CERTIFICAZIONE table.
	 * @generated
	 */
	public void updateColumnsCertificazione(TaifTCertificazioneDto dto) throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::updateColumnsCertificazione] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_TIPO_CERTIFICAZIONE = :FK_TIPO_CERTIFICAZIONE ,DESCR_ALTRO = :DESCR_ALTRO ,NUMERO = :NUMERO ,ENTE_CERTIFICATORE = :ENTE_CERTIFICATORE ,ANNO = :ANNO ,DATA_SCADENZA = :DATA_SCADENZA ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_CERTIFICAZIONE = :ID_CERTIFICAZIONE ";

		if (dto.getIdCertificazione() == null) {
			LOG.error("[TaifTCertificazioneDaoImpl::updateColumnsCertificazione] ERROR chiave primaria non impostata");
			throw new TaifTCertificazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CERTIFICAZIONE]
		params.addValue("FK_TIPO_CERTIFICAZIONE", dto.getFkTipoCertificazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NUMERO]
		params.addValue("NUMERO", dto.getNumero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ENTE_CERTIFICATORE]
		params.addValue("ENTE_CERTIFICATORE", dto.getEnteCertificatore(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_SCADENZA]
		params.addValue("DATA_SCADENZA", dto.getDataScadenza(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_CERTIFICAZIONE]
		params.addValue("ID_CERTIFICAZIONE", dto.getIdCertificazione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTCertificazioneDaoImpl::updateColumnsCertificazione] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_CERTIFICAZIONE table.
	 * @generated
	 */

	public void delete(TaifTCertificazionePk pk) throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_CERTIFICAZIONE = :ID_CERTIFICAZIONE ";

		if (pk == null) {
			LOG.error("[TaifTCertificazioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTCertificazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CERTIFICAZIONE]
		params.addValue("ID_CERTIFICAZIONE", pk.getIdCertificazione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTCertificazioneDaoImpl::delete] END");
	}

	protected TaifTCertificazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifTCertificazioneDaoRowMapper(null,
			TaifTCertificazioneDto.class, this);

	protected TaifTCertificazioneDaoRowMapper findAllRowMapper = new TaifTCertificazioneDaoRowMapper(null,
			TaifTCertificazioneDto.class, this);

	protected TaifTCertificazioneDaoRowMapper byAziendaRowMapper = new TaifTCertificazioneDaoRowMapper(null,
			TaifTCertificazioneByAziendaDto.class, this);

	protected TaifTCertificazioneDaoRowMapper byTipoCertRowMapper = new TaifTCertificazioneDaoRowMapper(null,
			TaifTCertificazioneByTipoCertDto.class, this);

	protected TaifTCertificazioneDaoRowMapper elencoCertificazioniRowMapper = new TaifTCertificazioneDaoRowMapper(null,
			TaifTCertificazioneElencoCertificazioniDto.class, this);

	protected TaifTCertificazioneDaoRowMapper byAziendaTipoCertRowMapper = new TaifTCertificazioneDaoRowMapper(null,
			TaifTCertificazioneByAziendaTipoCertDto.class, this);

	protected TaifTCertificazioneDaoRowMapper findCertificazioniByIdAziendaRowMapper = new TaifTCertificazioneDaoRowMapper(
			null, TaifTCertificazioneFindCertificazioniByIdAziendaDto.class, this);

	protected TaifTCertificazioneDaoRowMapper dettaglioCertificazioniByIdAziendaRowMapper = new TaifTCertificazioneDaoRowMapper(
			null, TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_CERTIFICAZIONE";
	}

	/** 
	 * Returns all rows from the TAIF_T_CERTIFICAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTCertificazioneDto findByPrimaryKey(TaifTCertificazionePk pk) throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CERTIFICAZIONE,FK_AZIENDA,FK_TIPO_CERTIFICAZIONE,DESCR_ALTRO,NUMERO,ENTE_CERTIFICATORE,ANNO,DATA_SCADENZA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_CERTIFICAZIONE = :ID_CERTIFICAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CERTIFICAZIONE]
		params.addValue("ID_CERTIFICAZIONE", pk.getIdCertificazione(), java.sql.Types.INTEGER);

		List<TaifTCertificazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCertificazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCertificazioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCertificazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_CERTIFICAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTCertificazioneDto> findAll() throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CERTIFICAZIONE,FK_AZIENDA,FK_TIPO_CERTIFICAZIONE,DESCR_ALTRO,NUMERO,ENTE_CERTIFICATORE,ANNO,DATA_SCADENZA,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_CERTIFICAZIONE ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTCertificazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCertificazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCertificazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCertificazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAzienda con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneByAziendaDto> findByAzienda(java.lang.Integer input)
			throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::findByAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT cert.ID_CERTIFICAZIONE as id, cert.FK_TIPO_CERTIFICAZIONE as tipoCertificazione, cert.NUMERO as numero, cert.ENTE_CERTIFICATORE as enteCertificatore, cert.ANNO as anno, cert.DATA_INSERIMENTO as data");

		sql.append(" FROM TAIF_T_CERTIFICAZIONE cert");

		sql.append(" WHERE ");

		sql.append("cert.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R1341367684) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTCertificazioneByAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCertificazioneDaoImpl::findByAzienda] ERROR esecuzione query", ex);
			throw new TaifTCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCertificazioneDaoImpl", "findByAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCertificazioneDaoImpl::findByAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTipoCert con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneByTipoCertDto> findByTipoCert(java.lang.Integer input)
			throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::findByTipoCert] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT cert.ID_CERTIFICAZIONE as id, cert.FK_TIPO_CERTIFICAZIONE as tipoCertificazione, cert.NUMERO as numero, cert.ENTE_CERTIFICATORE as enteCertificatore, cert.ANNO as anno, cert.DATA_INSERIMENTO as data");

		sql.append(" FROM TAIF_T_CERTIFICAZIONE cert");

		sql.append(" WHERE ");

		sql.append("cert.fk_tipo_certificazione=:idTipoCert");
		/*PROTECTED REGION ID(R-2061004450) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTipoCert", input);

		/*PROTECTED REGION END*/

		List<TaifTCertificazioneByTipoCertDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoCertRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCertificazioneDaoImpl::findByTipoCert] ERROR esecuzione query", ex);
			throw new TaifTCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCertificazioneDaoImpl", "findByTipoCert", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCertificazioneDaoImpl::findByTipoCert] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder elencoCertificazioni con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneElencoCertificazioniDto> findElencoCertificazioni(java.lang.Integer input)
			throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::findElencoCertificazioni] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT cert.ID_CERTIFICAZIONE as idCertificazione, cert.FK_TIPO_CERTIFICAZIONE as fkTipoCertificazione, cert.NUMERO as numero, cert.ENTE_CERTIFICATORE as enteCertificatore, cert.ANNO as anno, cert.DATA_INSERIMENTO as dataInserimento, cert.FK_AZIENDA as idAzienda, cert.DATA_AGGIORNAMENTO as dataAggiornamento, cert.DATA_SCADENZA as dataScadenza, cert.FK_CONFIG_UTENTE as fkConfigUtente, cert.DESCR_ALTRO as descrizioneAltro, tipoCert.TIPO_CERTIFICAZIONE as tipoCertificazione");

		sql.append(" FROM TAIF_T_CERTIFICAZIONE cert, TAIF_D_TIPO_CERTIFICAZIONE tipoCert");

		sql.append(" WHERE ");

		sql.append("cert.FK_TIPO_CERTIFICAZIONE = tipoCert.ID_TIPO_CERTIFICAZIONE");

		List<TaifTCertificazioneElencoCertificazioniDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, elencoCertificazioniRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCertificazioneDaoImpl::findElencoCertificazioni] ERROR esecuzione query", ex);
			throw new TaifTCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCertificazioneDaoImpl", "findElencoCertificazioni", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTCertificazioneDaoImpl::findElencoCertificazioni] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAziendaTipoCert con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneByAziendaTipoCertDto> findByAziendaTipoCert(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CertificazioneFilter input)
			throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::findByAziendaTipoCert] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT cert.ID_CERTIFICAZIONE as id, cert.FK_TIPO_CERTIFICAZIONE as tipoCertificazione, cert.NUMERO as numero, cert.ENTE_CERTIFICATORE as enteCertificatore, cert.ANNO as anno, cert.DATA_INSERIMENTO as data");

		sql.append(" FROM TAIF_T_CERTIFICAZIONE cert");

		sql.append(" WHERE ");

		sql.append("cert.fk_azienda=:idAzienda and cert.fk_tipo_certificazione=:idTipoCert");
		/*PROTECTED REGION ID(R1944235244) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("idTipoCert", input.getTipoCertificazione());

		/*PROTECTED REGION END*/

		List<TaifTCertificazioneByAziendaTipoCertDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAziendaTipoCertRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCertificazioneDaoImpl::findByAziendaTipoCert] ERROR esecuzione query", ex);
			throw new TaifTCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCertificazioneDaoImpl", "findByAziendaTipoCert", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTCertificazioneDaoImpl::findByAziendaTipoCert] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findCertificazioniByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> findFindCertificazioniByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::findFindCertificazioniByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT certificazioneTab.ID_CERTIFICAZIONE as idCertificazione, certificazioneTab.NUMERO as numeroCertificazione, certificazioneTab.ENTE_CERTIFICATORE as enteCertificatore, certificazioneTab.ANNO as annoCertificazione, certificazioneTab.DATA_SCADENZA as dataScadenza, certificazioneTab.DESCR_ALTRO as altraCertificazione, tipoCertificazioniTab.TIPO_CERTIFICAZIONE as tipoCertificazione, tipoCertificazioniTab.ID_TIPO_CERTIFICAZIONE as idTipoCertificazione");

		sql.append(" FROM TAIF_T_CERTIFICAZIONE certificazioneTab, TAIF_D_TIPO_CERTIFICAZIONE tipoCertificazioniTab");

		sql.append(" WHERE ");

		sql.append("certificazioneTab.FK_TIPO_CERTIFICAZIONE = tipoCertificazioniTab.ID_TIPO_CERTIFICAZIONE");

		sql.append(" AND ");

		sql.append(
				"certificazioneTab.fk_azienda=:idAzienda and tipoCertificazioniTab.mtd_flg_visibile=:flgVisibile and tipoCertificazioniTab.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R49195821) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("flgVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findCertificazioniByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCertificazioneDaoImpl::findFindCertificazioniByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCertificazioneDaoImpl", "findFindCertificazioniByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTCertificazioneDaoImpl::findFindCertificazioniByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder dettaglioCertificazioniByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto> findDettaglioCertificazioniByIdAzienda(
			java.lang.Integer input) throws TaifTCertificazioneDaoException {
		LOG.debug("[TaifTCertificazioneDaoImpl::findDettaglioCertificazioniByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tipoCertificazioniTab.TIPO_CERTIFICAZIONE as tipoCertificazione");

		sql.append(" FROM TAIF_T_CERTIFICAZIONE certificazioneTab, TAIF_D_TIPO_CERTIFICAZIONE tipoCertificazioniTab");

		sql.append(" WHERE ");

		sql.append("certificazioneTab.FK_TIPO_CERTIFICAZIONE = tipoCertificazioniTab.ID_TIPO_CERTIFICAZIONE");

		sql.append(" AND ");

		sql.append("certificazioneTab.fk_azienda=:idAziendaSelezionata");
		/*PROTECTED REGION ID(R-880540183) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAziendaSelezionata", input);

		/*PROTECTED REGION END*/

		List<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, dettaglioCertificazioniByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCertificazioneDaoImpl::findDettaglioCertificazioniByIdAzienda] ERROR esecuzione query",
					ex);
			throw new TaifTCertificazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCertificazioneDaoImpl", "findDettaglioCertificazioniByIdAzienda",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTCertificazioneDaoImpl::findDettaglioCertificazioniByIdAzienda] END");
		}
		return list;
	}

}
