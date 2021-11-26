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

/*PROTECTED REGION ID(R-1902210971) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTAllegato.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byCorsoPersona (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTAllegatoDaoImpl extends AbstractDAO implements TaifTAllegatoDao {
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
	 * Metodo di inserimento del DAO taifTAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAllegatoPk
	 * @generated
	 */

	public TaifTAllegatoPk insert(TaifTAllegatoDto dto)

	{
		LOG.debug("[TaifTAllegatoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ALLEGATO,FK_PRATICA,FK_CORSO,FK_PERSONA,FK_ESTENSIONE_FILE,FK_TIPO_ALLEGATO,NOME_FILE,DIMENSIONE_FILE_KB,FLG_TIPO_INVIO,FLG_SCADENZA,DATA_UPLOAD,NOTE,ESTENSIONE_FILE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_ALLEGATO , :FK_PRATICA , :FK_CORSO , :FK_PERSONA , :FK_ESTENSIONE_FILE , :FK_TIPO_ALLEGATO , :NOME_FILE , :DIMENSIONE_FILE_KB , :FLG_TIPO_INVIO , :FLG_SCADENZA , :DATA_UPLOAD , :NOTE , :ESTENSIONE_FILE , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PRATICA]
		params.addValue("FK_PRATICA", dto.getFkPratica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_CORSO]
		params.addValue("FK_CORSO", dto.getFkCorso(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_PERSONA]
		params.addValue("FK_PERSONA", dto.getFkPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_ESTENSIONE_FILE]
		params.addValue("FK_ESTENSIONE_FILE", dto.getFkEstensioneFile(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_ALLEGATO]
		params.addValue("FK_TIPO_ALLEGATO", dto.getFkTipoAllegato(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_FILE]
		params.addValue("NOME_FILE", dto.getNomeFile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DIMENSIONE_FILE_KB]
		params.addValue("DIMENSIONE_FILE_KB", dto.getDimensioneFileKb(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_TIPO_INVIO]
		params.addValue("FLG_TIPO_INVIO", dto.getFlgTipoInvio(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SCADENZA]
		params.addValue("FLG_SCADENZA", dto.getFlgScadenza(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_UPLOAD]
		params.addValue("DATA_UPLOAD", dto.getDataUpload(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NOTE]
		params.addValue("NOTE", dto.getNote(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ESTENSIONE_FILE]
		params.addValue("ESTENSIONE_FILE", dto.getEstensioneFile(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdAllegato(newKey);
		LOG.debug("[TaifTAllegatoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_T_ALLEGATO table.
	 * @generated
	 */

	public void delete(TaifTAllegatoPk pk) throws TaifTAllegatoDaoException {
		LOG.debug("[TaifTAllegatoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ";

		if (pk == null) {
			LOG.error("[TaifTAllegatoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTAllegatoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTAllegatoDaoImpl::delete] END");
	}

	protected TaifTAllegatoDaoRowMapper findByPrimaryKeyRowMapper = new TaifTAllegatoDaoRowMapper(null,
			TaifTAllegatoDto.class, this);

	protected TaifTAllegatoDaoRowMapper findAllRowMapper = new TaifTAllegatoDaoRowMapper(null, TaifTAllegatoDto.class,
			this);

	protected TaifTAllegatoDaoRowMapper byCorsoPersonaRowMapper = new TaifTAllegatoDaoRowMapper(null,
			TaifTAllegatoByCorsoPersonaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_ALLEGATO";
	}

	/** 
	 * Returns all rows from the TAIF_T_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAllegatoDto findByPrimaryKey(TaifTAllegatoPk pk) throws TaifTAllegatoDaoException {
		LOG.debug("[TaifTAllegatoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,FK_PRATICA,FK_CORSO,FK_PERSONA,FK_ESTENSIONE_FILE,FK_TIPO_ALLEGATO,NOME_FILE,DIMENSIONE_FILE_KB,FLG_TIPO_INVIO,FLG_SCADENZA,DATA_UPLOAD,NOTE,ESTENSIONE_FILE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_ALLEGATO = :ID_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ALLEGATO]
		params.addValue("ID_ALLEGATO", pk.getIdAllegato(), java.sql.Types.INTEGER);

		List<TaifTAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAllegatoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAllegatoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAllegatoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAllegatoDto> findAll() throws TaifTAllegatoDaoException {
		LOG.debug("[TaifTAllegatoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ALLEGATO,FK_PRATICA,FK_CORSO,FK_PERSONA,FK_ESTENSIONE_FILE,FK_TIPO_ALLEGATO,NOME_FILE,DIMENSIONE_FILE_KB,FLG_TIPO_INVIO,FLG_SCADENZA,DATA_UPLOAD,NOTE,ESTENSIONE_FILE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_ALLEGATO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTAllegatoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAllegatoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAllegatoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAllegatoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCorsoPersona con Qdef
		 * @generated
		 */

	public List<TaifTAllegatoByCorsoPersonaDto> findByCorsoPersona(
			it.csi.taif.topforweb.business.dao.topfor.filter.AllegatoFilter input) throws TaifTAllegatoDaoException {
		LOG.debug("[TaifTAllegatoDaoImpl::findByCorsoPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT allegato.ID_ALLEGATO as idAllegato, allegato.FK_CORSO as fkCorso, allegato.FK_PERSONA as fkPersona");

		sql.append(" FROM TAIF_T_ALLEGATO allegato");

		sql.append(" WHERE ");

		sql.append("allegato.fk_persona =:idPersona and allegato.fk_corso =:idCorso");
		/*PROTECTED REGION ID(R180595060) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input.getIdPersona());
		paramMap.addValue("idCorso", input.getIdCorso());

		/*PROTECTED REGION END*/

		List<TaifTAllegatoByCorsoPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCorsoPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAllegatoDaoImpl::findByCorsoPersona] ERROR esecuzione query", ex);
			throw new TaifTAllegatoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAllegatoDaoImpl", "findByCorsoPersona", "esecuzione query", sql.toString());
			LOG.debug("[TaifTAllegatoDaoImpl::findByCorsoPersona] END");
		}
		return list;
	}

}
