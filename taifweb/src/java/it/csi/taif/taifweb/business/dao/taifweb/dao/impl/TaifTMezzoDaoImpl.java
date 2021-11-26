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

/*PROTECTED REGION ID(R-1950990191) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTMezzo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byTipoMezzo (datagen::CustomFinder)
 *   - byTipoMezzoAzienda (datagen::CustomFinder)
 *   - byTipoMezzoAziendaVisibile (datagen::CustomFinder)
 *   - tipoTrazioneByIdTrazione (datagen::CustomFinder)
 *   - tipoAlimentazioneByIdAlimentazione (datagen::CustomFinder)
 *   - tipoCarrelloByIdCarrello (datagen::CustomFinder)
 *   - dettaglioMezzoByIdAzienda (datagen::CustomFinder)
 *   - byIdTipoMezzoAzienda (datagen::CustomFinder)
 *   - byIdAzienda (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - perIdAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTMezzoDaoImpl extends AbstractDAO implements TaifTMezzoDao {
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
	 * Metodo di inserimento del DAO taifTMezzo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTMezzoPk
	 * @generated
	 */

	public TaifTMezzoPk insert(TaifTMezzoDto dto)

	{
		LOG.debug("[TaifTMezzoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_MEZZO,FK_AZIENDA,FK_ALIMENTAZIONE,FK_TIPO_CARRELLO,FK_TIPO_MEZZO,FK_TRAZIONE,ANNO,POTENZA_KW,PORTATA_KG,FLG_COMANDATO_DISTANZA,FLG_NOLEGGIO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,DESCR_ALTRO ) VALUES (  :ID_MEZZO , :FK_AZIENDA , :FK_ALIMENTAZIONE , :FK_TIPO_CARRELLO , :FK_TIPO_MEZZO , :FK_TRAZIONE , :ANNO , :POTENZA_KW , :PORTATA_KG , :FLG_COMANDATO_DISTANZA , :FLG_NOLEGGIO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE , :DESCR_ALTRO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MEZZO]
		params.addValue("ID_MEZZO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ALIMENTAZIONE]
		params.addValue("FK_ALIMENTAZIONE", dto.getFkAlimentazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CARRELLO]
		params.addValue("FK_TIPO_CARRELLO", dto.getFkTipoCarrello(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_MEZZO]
		params.addValue("FK_TIPO_MEZZO", dto.getFkTipoMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TRAZIONE]
		params.addValue("FK_TRAZIONE", dto.getFkTrazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_KW]
		params.addValue("POTENZA_KW", dto.getPotenzaKw(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PORTATA_KG]
		params.addValue("PORTATA_KG", dto.getPortataKg(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_COMANDATO_DISTANZA]
		params.addValue("FLG_COMANDATO_DISTANZA", dto.getFlgComandatoDistanza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NOLEGGIO]
		params.addValue("FLG_NOLEGGIO", dto.getFlgNoleggio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdMezzo(newKey);
		LOG.debug("[TaifTMezzoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_MEZZO table.
	 * @generated
	 */
	public void update(TaifTMezzoDto dto) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_ALIMENTAZIONE = :FK_ALIMENTAZIONE ,FK_TIPO_CARRELLO = :FK_TIPO_CARRELLO ,FK_TIPO_MEZZO = :FK_TIPO_MEZZO ,FK_TRAZIONE = :FK_TRAZIONE ,ANNO = :ANNO ,POTENZA_KW = :POTENZA_KW ,PORTATA_KG = :PORTATA_KG ,FLG_COMANDATO_DISTANZA = :FLG_COMANDATO_DISTANZA ,FLG_NOLEGGIO = :FLG_NOLEGGIO ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,DESCR_ALTRO = :DESCR_ALTRO  WHERE ID_MEZZO = :ID_MEZZO ";

		if (dto.getIdMezzo() == null) {
			LOG.error("[TaifTMezzoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTMezzoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MEZZO]
		params.addValue("ID_MEZZO", dto.getIdMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ALIMENTAZIONE]
		params.addValue("FK_ALIMENTAZIONE", dto.getFkAlimentazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CARRELLO]
		params.addValue("FK_TIPO_CARRELLO", dto.getFkTipoCarrello(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_MEZZO]
		params.addValue("FK_TIPO_MEZZO", dto.getFkTipoMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TRAZIONE]
		params.addValue("FK_TRAZIONE", dto.getFkTrazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_KW]
		params.addValue("POTENZA_KW", dto.getPotenzaKw(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PORTATA_KG]
		params.addValue("PORTATA_KG", dto.getPortataKg(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_COMANDATO_DISTANZA]
		params.addValue("FLG_COMANDATO_DISTANZA", dto.getFlgComandatoDistanza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NOLEGGIO]
		params.addValue("FLG_NOLEGGIO", dto.getFlgNoleggio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTMezzoDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_MEZZO table.
	 * @generated
	 */
	public void updateColumnsPerIdAzienda(TaifTMezzoDto dto) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::updateColumnsPerIdAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_ALIMENTAZIONE = :FK_ALIMENTAZIONE ,FK_TIPO_CARRELLO = :FK_TIPO_CARRELLO ,FK_TIPO_MEZZO = :FK_TIPO_MEZZO ,FK_TRAZIONE = :FK_TRAZIONE ,ANNO = :ANNO ,POTENZA_KW = :POTENZA_KW ,PORTATA_KG = :PORTATA_KG ,FLG_COMANDATO_DISTANZA = :FLG_COMANDATO_DISTANZA ,FLG_NOLEGGIO = :FLG_NOLEGGIO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,DESCR_ALTRO = :DESCR_ALTRO  WHERE ID_MEZZO = :ID_MEZZO ";

		if (dto.getIdMezzo() == null) {
			LOG.error("[TaifTMezzoDaoImpl::updateColumnsPerIdAzienda] ERROR chiave primaria non impostata");
			throw new TaifTMezzoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ALIMENTAZIONE]
		params.addValue("FK_ALIMENTAZIONE", dto.getFkAlimentazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CARRELLO]
		params.addValue("FK_TIPO_CARRELLO", dto.getFkTipoCarrello(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_MEZZO]
		params.addValue("FK_TIPO_MEZZO", dto.getFkTipoMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TRAZIONE]
		params.addValue("FK_TRAZIONE", dto.getFkTrazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [POTENZA_KW]
		params.addValue("POTENZA_KW", dto.getPotenzaKw(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PORTATA_KG]
		params.addValue("PORTATA_KG", dto.getPortataKg(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_COMANDATO_DISTANZA]
		params.addValue("FLG_COMANDATO_DISTANZA", dto.getFlgComandatoDistanza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [FLG_NOLEGGIO]
		params.addValue("FLG_NOLEGGIO", dto.getFlgNoleggio(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_MEZZO]
		params.addValue("ID_MEZZO", dto.getIdMezzo(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTMezzoDaoImpl::updateColumnsPerIdAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_MEZZO table.
	 * @generated
	 */

	public void delete(TaifTMezzoPk pk) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_MEZZO = :ID_MEZZO ";

		if (pk == null) {
			LOG.error("[TaifTMezzoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTMezzoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MEZZO]
		params.addValue("ID_MEZZO", pk.getIdMezzo(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTMezzoDaoImpl::delete] END");
	}

	protected TaifTMezzoDaoRowMapper findByPrimaryKeyRowMapper = new TaifTMezzoDaoRowMapper(null, TaifTMezzoDto.class,
			this);

	protected TaifTMezzoDaoRowMapper findAllRowMapper = new TaifTMezzoDaoRowMapper(null, TaifTMezzoDto.class, this);

	protected TaifTMezzoDaoRowMapper byTipoMezzoRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoByTipoMezzoDto.class, this);

	protected TaifTMezzoDaoRowMapper byTipoMezzoAziendaRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoByTipoMezzoAziendaDto.class, this);

	protected TaifTMezzoDaoRowMapper byTipoMezzoAziendaVisibileRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoByTipoMezzoAziendaVisibileDto.class, this);

	protected TaifTMezzoDaoRowMapper tipoTrazioneByIdTrazioneRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoTipoTrazioneByIdTrazioneDto.class, this);

	protected TaifTMezzoDaoRowMapper tipoAlimentazioneByIdAlimentazioneRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto.class, this);

	protected TaifTMezzoDaoRowMapper tipoCarrelloByIdCarrelloRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoTipoCarrelloByIdCarrelloDto.class, this);

	protected TaifTMezzoDaoRowMapper dettaglioMezzoByIdAziendaRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoDettaglioMezzoByIdAziendaDto.class, this);

	protected TaifTMezzoDaoRowMapper byIdTipoMezzoAziendaRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoByIdTipoMezzoAziendaDto.class, this);

	protected TaifTMezzoDaoRowMapper byIdAziendaRowMapper = new TaifTMezzoDaoRowMapper(null,
			TaifTMezzoByIdAziendaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_MEZZO";
	}

	/** 
	 * Returns all rows from the TAIF_T_MEZZO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTMezzoDto findByPrimaryKey(TaifTMezzoPk pk) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_MEZZO,FK_AZIENDA,FK_ALIMENTAZIONE,FK_TIPO_CARRELLO,FK_TIPO_MEZZO,FK_TRAZIONE,ANNO,POTENZA_KW,PORTATA_KG,FLG_COMANDATO_DISTANZA,FLG_NOLEGGIO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,DESCR_ALTRO FROM "
						+ getTableName() + " WHERE ID_MEZZO = :ID_MEZZO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_MEZZO]
		params.addValue("ID_MEZZO", pk.getIdMezzo(), java.sql.Types.INTEGER);

		List<TaifTMezzoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_MEZZO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTMezzoDto> findAll() throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_MEZZO,FK_AZIENDA,FK_ALIMENTAZIONE,FK_TIPO_CARRELLO,FK_TIPO_MEZZO,FK_TRAZIONE,ANNO,POTENZA_KW,PORTATA_KG,FLG_COMANDATO_DISTANZA,FLG_NOLEGGIO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,DESCR_ALTRO FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_MEZZO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTMezzoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTipoMezzo con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByTipoMezzoDto> findByTipoMezzo(java.lang.String input) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findByTipoMezzo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT mezzo.ID_MEZZO as id, tipo.TIPO_MEZZO as tipoMezzo, mezzo.ANNO as anno, mezzo.POTENZA_KW as potenza, mezzo.PORTATA_KG as portata, mezzo.FLG_COMANDATO_DISTANZA as comando, mezzo.FLG_NOLEGGIO as noleggio, mezzo.DATA_INSERIMENTO as dataInsert, mezzo.FK_AZIENDA as idAzienda, mezzo.FK_ALIMENTAZIONE as idAlimentazione, mezzo.FK_TIPO_CARRELLO as idTipoCarrel, mezzo.FK_TIPO_MEZZO as idTipoMezzo, mezzo.FK_TRAZIONE as idTipoTrazione");

		sql.append(" FROM TAIF_T_MEZZO mezzo, TAIF_D_TIPO_MEZZO tipo");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_TIPO_MEZZO = tipo.ID_TIPO_MEZZO");

		sql.append(" AND ");

		sql.append("tipo.tipo_mezzo=:tipoMezzo");
		/*PROTECTED REGION ID(R53122245) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("tipoMezzo", input);

		/*PROTECTED REGION END*/

		List<TaifTMezzoByTipoMezzoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoMezzoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findByTipoMezzo] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findByTipoMezzo", "esecuzione query", sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findByTipoMezzo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTipoMezzoAzienda con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByTipoMezzoAziendaDto> findByTipoMezzoAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findByTipoMezzoAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT mezzo.ID_MEZZO as id, tipo.TIPO_MEZZO as tipoMezzo, mezzo.ANNO as anno, mezzo.POTENZA_KW as potenza, mezzo.PORTATA_KG as portata, mezzo.FLG_COMANDATO_DISTANZA as comando, mezzo.FLG_NOLEGGIO as noleggio, mezzo.DATA_INSERIMENTO as dataInsert, mezzo.FK_AZIENDA as idAzienda, mezzo.FK_ALIMENTAZIONE as idAlimentazione, mezzo.FK_TIPO_CARRELLO as idTipoCarrel, mezzo.FK_TIPO_MEZZO as idTipoMezzo, mezzo.FK_TRAZIONE as idTipoTrazione");

		sql.append(" FROM TAIF_T_MEZZO mezzo, TAIF_D_TIPO_MEZZO tipo");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_TIPO_MEZZO = tipo.ID_TIPO_MEZZO");

		sql.append(" AND ");

		sql.append("tipo.tipo_mezzo=:tipoMezzo and mezzo.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R-1210419755) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("tipoMezzo", input.getTipoMezzo());
		paramMap.addValue("idAzienda", input.getIdAzienda());

		/*PROTECTED REGION END*/

		List<TaifTMezzoByTipoMezzoAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoMezzoAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findByTipoMezzoAzienda] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findByTipoMezzoAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findByTipoMezzoAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTipoMezzoAziendaVisibile con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByTipoMezzoAziendaVisibileDto> findByTipoMezzoAziendaVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findByTipoMezzoAziendaVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT mezzo.ID_MEZZO as id, tipo.TIPO_MEZZO as tipoMezzo, mezzo.ANNO as anno, mezzo.POTENZA_KW as potenza, mezzo.PORTATA_KG as portata, mezzo.FLG_COMANDATO_DISTANZA as comando, mezzo.FLG_NOLEGGIO as noleggio, mezzo.DATA_INSERIMENTO as dataInsert, mezzo.FK_AZIENDA as idAzienda, mezzo.FK_ALIMENTAZIONE as idAlimentazione, mezzo.FK_TIPO_CARRELLO as idTipoCarrel, mezzo.FK_TIPO_MEZZO as idTipoMezzo, mezzo.FK_TRAZIONE as idTipoTrazione, tipo.FK_CATEGORIA_MEZZO as idCategoriaMezzo, mezzo.DESCR_ALTRO as descrizioneAltro");

		sql.append(" FROM TAIF_T_MEZZO mezzo, TAIF_D_TIPO_MEZZO tipo");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_TIPO_MEZZO = tipo.ID_TIPO_MEZZO");

		sql.append(" AND ");

		sql.append(
				"mezzo.fk_azienda=:idAzienda  and mezzo.fk_tipo_mezzo=:idTipoMezzo and tipo.mtd_flg_visibile=:flagVisibile  and tipo.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R946612876) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("idTipoMezzo", input.getIdTipoMezzo());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTMezzoByTipoMezzoAziendaVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoMezzoAziendaVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findByTipoMezzoAziendaVisibile] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findByTipoMezzoAziendaVisibile", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findByTipoMezzoAziendaVisibile] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder tipoTrazioneByIdTrazione con Qdef
		 * @generated
		 */

	public List<TaifTMezzoTipoTrazioneByIdTrazioneDto> findTipoTrazioneByIdTrazione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TrazioneFilter input) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findTipoTrazioneByIdTrazione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipoTrazione.TIPO_MEZZO as tipoMezzo, mezzo.FK_TRAZIONE as idTipoTrazione, mezzo.ID_MEZZO as idMezzo");

		sql.append(" FROM TAIF_T_MEZZO mezzo, TAIF_D_TRAZIONE tipoTrazione");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_TRAZIONE = tipoTrazione.ID_TRAZIONE");

		sql.append(" AND ");

		sql.append(
				"mezzo.fk_trazione=:idTrazione and tipoTrazione.mtd_flg_visibile=:flagVisibile and tipoTrazione.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R422607089) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTrazione", input.getIdTrazione());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTMezzoTipoTrazioneByIdTrazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, tipoTrazioneByIdTrazioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findTipoTrazioneByIdTrazione] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findTipoTrazioneByIdTrazione", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findTipoTrazioneByIdTrazione] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder tipoAlimentazioneByIdAlimentazione con Qdef
		 * @generated
		 */

	public List<TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto> findTipoAlimentazioneByIdAlimentazione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AlimentazioneFilter input) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findTipoAlimentazioneByIdAlimentazione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipoAlimentazione.TIPO_MEZZO as tipoMezzo, mezzo.FK_ALIMENTAZIONE as idTipoTrazione, mezzo.ID_MEZZO as idMezzo");

		sql.append(" FROM TAIF_T_MEZZO mezzo, TAIF_D_ALIMENTAZIONE tipoAlimentazione");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_ALIMENTAZIONE = tipoAlimentazione.ID_ALIMENTAZIONE");

		sql.append(" AND ");

		sql.append(
				"mezzo.fk_alimentazione=:idAlimentazione and tipoAlimentazione.mtd_flg_visibile=:flagVisibile and tipoAlimentazione.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R957694077) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAlimentazione", input.getIdAlimentazione());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, tipoAlimentazioneByIdAlimentazioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findTipoAlimentazioneByIdAlimentazione] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findTipoAlimentazioneByIdAlimentazione", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findTipoAlimentazioneByIdAlimentazione] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder tipoCarrelloByIdCarrello con Qdef
		 * @generated
		 */

	public List<TaifTMezzoTipoCarrelloByIdCarrelloDto> findTipoCarrelloByIdCarrello(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoCarrelloFilter input) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findTipoCarrelloByIdCarrello] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipoCarrello.TIPO_MEZZO as tipoMezzo, mezzo.FK_ALIMENTAZIONE as idTipoTrazione, mezzo.ID_MEZZO as idMezzo");

		sql.append(" FROM TAIF_T_MEZZO mezzo, TAIF_D_TIPO_CARRELLO tipoCarrello");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_TRAZIONE = tipoCarrello.ID_TRAZIONE");

		sql.append(" AND ");

		sql.append(
				"mezzo.fk_tipo_carrello=:idCarrello and tipoCarrello.mtd_flg_visibile=:flagVisibile and tipoCarrello.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R2114361609) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idCarrello", input.getIdTipoCarrello());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTMezzoTipoCarrelloByIdCarrelloDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, tipoCarrelloByIdCarrelloRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findTipoCarrelloByIdCarrello] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findTipoCarrelloByIdCarrello", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findTipoCarrelloByIdCarrello] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder dettaglioMezzoByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTMezzoDettaglioMezzoByIdAziendaDto> findDettaglioMezzoByIdAzienda(java.lang.Integer input)
			throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findDettaglioMezzoByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tipoMezzo.TIPO_MEZZO as tipoMezzo, count (mezzo.fk_azienda) AS conteggio");

		sql.append(" FROM TAIF_T_MEZZO mezzo, TAIF_D_TIPO_MEZZO tipoMezzo");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_TIPO_MEZZO = tipoMezzo.ID_TIPO_MEZZO");

		sql.append(" AND ");

		sql.append("mezzo.fk_azienda = :idAziendaSelezionata GROUP BY tipoMezzo.tipo_mezzo;");
		/*PROTECTED REGION ID(R14042649) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAziendaSelezionata", input);

		/*PROTECTED REGION END*/

		List<TaifTMezzoDettaglioMezzoByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, dettaglioMezzoByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findDettaglioMezzoByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findDettaglioMezzoByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findDettaglioMezzoByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdTipoMezzoAzienda con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByIdTipoMezzoAziendaDto> findByIdTipoMezzoAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findByIdTipoMezzoAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT mezzo.ID_MEZZO as idMezzo, tipo.TIPO_MEZZO as tipoMezzo, mezzo.ANNO as anno, mezzo.POTENZA_KW as potenza, mezzo.PORTATA_KG as portata, mezzo.FLG_COMANDATO_DISTANZA as comando, mezzo.FLG_NOLEGGIO as noleggio, mezzo.DATA_INSERIMENTO as dataInsert, mezzo.FK_AZIENDA as idAzienda, mezzo.FK_ALIMENTAZIONE as idAlimentazione, mezzo.FK_TIPO_CARRELLO as idTipoCarrel, mezzo.FK_TIPO_MEZZO as idTipoMezzo, mezzo.FK_TRAZIONE as idTipoTrazione");

		sql.append(" FROM TAIF_T_MEZZO mezzo, TAIF_D_TIPO_MEZZO tipo");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_TIPO_MEZZO = tipo.ID_TIPO_MEZZO");

		sql.append(" AND ");

		sql.append("mezzo.fk_tipo_mezzo=:idTipoMezzo and mezzo.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R-683212934) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTipoMezzo", input.getIdTipoMezzo());
		paramMap.addValue("idAzienda", input.getIdAzienda());

		/*PROTECTED REGION END*/

		List<TaifTMezzoByIdTipoMezzoAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdTipoMezzoAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findByIdTipoMezzoAzienda] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findByIdTipoMezzoAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findByIdTipoMezzoAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTMezzoByIdAziendaDto> findByIdAzienda(java.lang.Integer input) throws TaifTMezzoDaoException {
		LOG.debug("[TaifTMezzoDaoImpl::findByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT mezzo.ID_MEZZO as id, mezzo.ANNO as anno, mezzo.POTENZA_KW as potenza, mezzo.PORTATA_KG as portata, mezzo.FLG_COMANDATO_DISTANZA as comando, mezzo.FLG_NOLEGGIO as noleggio, mezzo.DATA_INSERIMENTO as dataInsert, mezzo.FK_AZIENDA as idAzienda, mezzo.FK_ALIMENTAZIONE as idAlimentazione, mezzo.FK_TIPO_CARRELLO as idTipoCarrel, mezzo.FK_TIPO_MEZZO as idTipoMezzo, mezzo.FK_TRAZIONE as idTipoTrazione, mezzo.DESCR_ALTRO as descrizioneAltromezzo");

		sql.append(" FROM TAIF_T_MEZZO mezzo");

		sql.append(" WHERE ");

		sql.append("mezzo.fk_azienda=:idAzienda");
		/*PROTECTED REGION ID(R-669552403) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTMezzoByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTMezzoDaoImpl::findByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTMezzoDaoImpl", "findByIdAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTMezzoDaoImpl::findByIdAzienda] END");
		}
		return list;
	}

}
