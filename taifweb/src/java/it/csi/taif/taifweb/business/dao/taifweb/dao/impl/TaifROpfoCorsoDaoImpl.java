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

/*PROTECTED REGION ID(R-877934313) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifROpfoCorso.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byIdPersona (datagen::CustomFinder)
 *   - byIdCorso (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - operatoreCorsoById (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifROpfoCorsoDaoImpl extends AbstractDAO implements TaifROpfoCorsoDao {
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
	 * Metodo di inserimento del DAO taifROpfoCorso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifROpfoCorsoPk
	 * @generated
	 */

	public TaifROpfoCorsoPk insert(TaifROpfoCorsoDto dto)

	{
		LOG.debug("[TaifROpfoCorsoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CORSO,ID_PERSONA,FLG_ESITO,DESCRIZIONE_ALTRO,DATA_AGGIORNAMENTO,DATA_INSERIMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_CORSO , :ID_PERSONA , :FLG_ESITO , :DESCRIZIONE_ALTRO , :DATA_AGGIORNAMENTO , :DATA_INSERIMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", dto.getIdCorso(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_ESITO]
		params.addValue("FLG_ESITO", dto.getFlgEsito(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE_ALTRO]
		params.addValue("DESCRIZIONE_ALTRO", dto.getDescrizioneAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifROpfoCorsoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_R_OPFO_CORSO table.
	 * @generated
	 */
	public void update(TaifROpfoCorsoDto dto) throws TaifROpfoCorsoDaoException {
		LOG.debug("[TaifROpfoCorsoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FLG_ESITO = :FLG_ESITO ,DESCRIZIONE_ALTRO = :DESCRIZIONE_ALTRO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_CORSO = :ID_CORSO  AND ID_PERSONA = :ID_PERSONA ";

		if (dto.getIdCorso() == null || dto.getIdPersona() == null) {
			LOG.error("[TaifROpfoCorsoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifROpfoCorsoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", dto.getIdCorso(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_ESITO]
		params.addValue("FLG_ESITO", dto.getFlgEsito(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE_ALTRO]
		params.addValue("DESCRIZIONE_ALTRO", dto.getDescrizioneAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifROpfoCorsoDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_R_OPFO_CORSO table.
	 * @generated
	 */
	public void updateColumnsOperatoreCorsoById(TaifROpfoCorsoDto dto) throws TaifROpfoCorsoDaoException {
		LOG.debug("[TaifROpfoCorsoDaoImpl::updateColumnsOperatoreCorsoById] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DESCRIZIONE_ALTRO = :DESCRIZIONE_ALTRO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FLG_ESITO = :FLG_ESITO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_CORSO = :ID_CORSO  AND ID_PERSONA = :ID_PERSONA ";

		if (dto.getIdCorso() == null || dto.getIdPersona() == null) {
			LOG.error("[TaifROpfoCorsoDaoImpl::updateColumnsOperatoreCorsoById] ERROR chiave primaria non impostata");
			throw new TaifROpfoCorsoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", dto.getIdCorso(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCRIZIONE_ALTRO]
		params.addValue("DESCRIZIONE_ALTRO", dto.getDescrizioneAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FLG_ESITO]
		params.addValue("FLG_ESITO", dto.getFlgEsito(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", dto.getIdCorso(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifROpfoCorsoDaoImpl::updateColumnsOperatoreCorsoById] END");
	}

	/** 
	 * Deletes a single row in the TAIF_R_OPFO_CORSO table.
	 * @generated
	 */

	public void delete(TaifROpfoCorsoPk pk) throws TaifROpfoCorsoDaoException {
		LOG.debug("[TaifROpfoCorsoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_CORSO = :ID_CORSO  AND ID_PERSONA = :ID_PERSONA ";

		if (pk == null) {
			LOG.error("[TaifROpfoCorsoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifROpfoCorsoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", pk.getIdCorso(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifROpfoCorsoDaoImpl::delete] END");
	}

	protected TaifROpfoCorsoDaoRowMapper findByPrimaryKeyRowMapper = new TaifROpfoCorsoDaoRowMapper(null,
			TaifROpfoCorsoDto.class, this);

	protected TaifROpfoCorsoDaoRowMapper findAllRowMapper = new TaifROpfoCorsoDaoRowMapper(null,
			TaifROpfoCorsoDto.class, this);

	protected TaifROpfoCorsoDaoRowMapper byIdPersonaRowMapper = new TaifROpfoCorsoDaoRowMapper(null,
			TaifROpfoCorsoByIdPersonaDto.class, this);

	protected TaifROpfoCorsoDaoRowMapper byIdCorsoRowMapper = new TaifROpfoCorsoDaoRowMapper(null,
			TaifROpfoCorsoByIdCorsoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_OPFO_CORSO";
	}

	/** 
	 * Returns all rows from the TAIF_R_OPFO_CORSO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifROpfoCorsoDto findByPrimaryKey(TaifROpfoCorsoPk pk) throws TaifROpfoCorsoDaoException {
		LOG.debug("[TaifROpfoCorsoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CORSO,ID_PERSONA,FLG_ESITO,DESCRIZIONE_ALTRO,DATA_AGGIORNAMENTO,DATA_INSERIMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_CORSO = :ID_CORSO  AND ID_PERSONA = :ID_PERSONA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", pk.getIdCorso(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		List<TaifROpfoCorsoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifROpfoCorsoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifROpfoCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifROpfoCorsoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifROpfoCorsoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_OPFO_CORSO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifROpfoCorsoDto> findAll() throws TaifROpfoCorsoDaoException {
		LOG.debug("[TaifROpfoCorsoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CORSO,ID_PERSONA,FLG_ESITO,DESCRIZIONE_ALTRO,DATA_AGGIORNAMENTO,DATA_INSERIMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_CORSO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifROpfoCorsoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifROpfoCorsoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifROpfoCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifROpfoCorsoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifROpfoCorsoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdPersona con Qdef
		 * @generated
		 */

	public List<TaifROpfoCorsoByIdPersonaDto> findByIdPersona(java.lang.Integer input)
			throws TaifROpfoCorsoDaoException {
		LOG.debug("[TaifROpfoCorsoDaoImpl::findByIdPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT opco.ID_CORSO as idcorso, opco.ID_PERSONA as idpers, opco.DESCRIZIONE_ALTRO as desc, opco.FLG_ESITO as esito");

		sql.append(" FROM TAIF_R_OPFO_CORSO opco");

		sql.append(" WHERE ");

		sql.append("opco.id_persona=:idPersona");
		/*PROTECTED REGION ID(R-658616556) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input);

		/*PROTECTED REGION END*/

		List<TaifROpfoCorsoByIdPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifROpfoCorsoDaoImpl::findByIdPersona] ERROR esecuzione query", ex);
			throw new TaifROpfoCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifROpfoCorsoDaoImpl", "findByIdPersona", "esecuzione query", sql.toString());
			LOG.debug("[TaifROpfoCorsoDaoImpl::findByIdPersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdCorso con Qdef
		 * @generated
		 */

	public List<TaifROpfoCorsoByIdCorsoDto> findByIdCorso(java.lang.Integer input) throws TaifROpfoCorsoDaoException {
		LOG.debug("[TaifROpfoCorsoDaoImpl::findByIdCorso] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT opco.ID_CORSO as idcorso, opco.ID_PERSONA as idpers, opco.DESCRIZIONE_ALTRO as desc, opco.FLG_ESITO as esito");

		sql.append(" FROM TAIF_R_OPFO_CORSO opco");

		sql.append(" WHERE ");

		sql.append("opco.id_corso=:idCorso");
		/*PROTECTED REGION ID(R1948702750) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idCorso", input);

		/*PROTECTED REGION END*/

		List<TaifROpfoCorsoByIdCorsoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdCorsoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifROpfoCorsoDaoImpl::findByIdCorso] ERROR esecuzione query", ex);
			throw new TaifROpfoCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifROpfoCorsoDaoImpl", "findByIdCorso", "esecuzione query", sql.toString());
			LOG.debug("[TaifROpfoCorsoDaoImpl::findByIdCorso] END");
		}
		return list;
	}

}
