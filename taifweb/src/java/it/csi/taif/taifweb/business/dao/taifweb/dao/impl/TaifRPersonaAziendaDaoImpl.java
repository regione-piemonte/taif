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

/*PROTECTED REGION ID(R1906967761) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifRPersonaAzienda.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byIdAzienda (datagen::CustomFinder)
 *   - contrattoByIdPersona (datagen::CustomFinder)
 *   - byFkUtente (datagen::CustomFinder)
 *   - byAziendaUtente (datagen::CustomFinder)
 *   - tipoInquadramentoByIdInquadramentoVisibile (datagen::CustomFinder)
 *   - ruoloByIdRuoloVisibile (datagen::CustomFinder)
 *   - contrattoByIdContrattoVisibile (datagen::CustomFinder)
 *   - mansioneByIdMansioneVisibile (datagen::CustomFinder)
 *   - conteggioPersona (datagen::CustomFinder)
 *   - rappresentanteLegaleAzienda (datagen::CustomFinder)
  * - UPDATERS:
 *   - personaAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifRPersonaAziendaDaoImpl extends AbstractDAO implements TaifRPersonaAziendaDao {
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
	 * Metodo di inserimento del DAO taifRPersonaAzienda. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRPersonaAziendaPk
	 * @generated
	 */

	public TaifRPersonaAziendaPk insert(TaifRPersonaAziendaDto dto)

	{
		LOG.debug("[TaifRPersonaAziendaDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA,ID_AZIENDA,FK_RUOLO,FK_TIPO_MANSIONE,FK_TIPO_CONTRATTO,FK_TIPO_INQUADRAMENTO,FLG_TEMPO_DETERMINATO,GG_TEMPO_DETERMINATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_PERSONA , :ID_AZIENDA , :FK_RUOLO , :FK_TIPO_MANSIONE , :FK_TIPO_CONTRATTO , :FK_TIPO_INQUADRAMENTO , :FLG_TEMPO_DETERMINATO , :GG_TEMPO_DETERMINATO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_RUOLO]
		params.addValue("FK_RUOLO", dto.getFkRuolo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_MANSIONE]
		params.addValue("FK_TIPO_MANSIONE", dto.getFkTipoMansione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CONTRATTO]
		params.addValue("FK_TIPO_CONTRATTO", dto.getFkTipoContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_INQUADRAMENTO]
		params.addValue("FK_TIPO_INQUADRAMENTO", dto.getFkTipoInquadramento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_TEMPO_DETERMINATO]
		params.addValue("FLG_TEMPO_DETERMINATO", dto.getFlgTempoDeterminato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [GG_TEMPO_DETERMINATO]
		params.addValue("GG_TEMPO_DETERMINATO", dto.getGgTempoDeterminato(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifRPersonaAziendaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_R_PERSONA_AZIENDA table.
	 * @generated
	 */
	public void updateColumnsPersonaAzienda(TaifRPersonaAziendaDto dto) throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::updateColumnsPersonaAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_RUOLO = :FK_RUOLO ,FK_TIPO_MANSIONE = :FK_TIPO_MANSIONE ,FK_TIPO_CONTRATTO = :FK_TIPO_CONTRATTO ,FK_TIPO_INQUADRAMENTO = :FK_TIPO_INQUADRAMENTO ,FLG_TEMPO_DETERMINATO = :FLG_TEMPO_DETERMINATO ,GG_TEMPO_DETERMINATO = :GG_TEMPO_DETERMINATO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_PERSONA = :ID_PERSONA  AND ID_AZIENDA = :ID_AZIENDA ";

		if (dto.getIdPersona() == null || dto.getIdAzienda() == null) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::updateColumnsPersonaAzienda] ERROR chiave primaria non impostata");
			throw new TaifRPersonaAziendaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_RUOLO]
		params.addValue("FK_RUOLO", dto.getFkRuolo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_MANSIONE]
		params.addValue("FK_TIPO_MANSIONE", dto.getFkTipoMansione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_CONTRATTO]
		params.addValue("FK_TIPO_CONTRATTO", dto.getFkTipoContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_INQUADRAMENTO]
		params.addValue("FK_TIPO_INQUADRAMENTO", dto.getFkTipoInquadramento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_TEMPO_DETERMINATO]
		params.addValue("FLG_TEMPO_DETERMINATO", dto.getFlgTempoDeterminato(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [GG_TEMPO_DETERMINATO]
		params.addValue("GG_TEMPO_DETERMINATO", dto.getGgTempoDeterminato(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRPersonaAziendaDaoImpl::updateColumnsPersonaAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_R_PERSONA_AZIENDA table.
	 * @generated
	 */

	public void delete(TaifRPersonaAziendaPk pk) throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_PERSONA = :ID_PERSONA  AND ID_AZIENDA = :ID_AZIENDA ";

		if (pk == null) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifRPersonaAziendaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRPersonaAziendaDaoImpl::delete] END");
	}

	protected TaifRPersonaAziendaDaoRowMapper findByPrimaryKeyRowMapper = new TaifRPersonaAziendaDaoRowMapper(null,
			TaifRPersonaAziendaDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper findAllRowMapper = new TaifRPersonaAziendaDaoRowMapper(null,
			TaifRPersonaAziendaDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper byIdAziendaRowMapper = new TaifRPersonaAziendaDaoRowMapper(null,
			TaifRPersonaAziendaByIdAziendaDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper contrattoByIdPersonaRowMapper = new TaifRPersonaAziendaDaoRowMapper(null,
			TaifRPersonaAziendaContrattoByIdPersonaDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper byFkUtenteRowMapper = new TaifRPersonaAziendaDaoRowMapper(null,
			TaifRPersonaAziendaByFkUtenteDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper byAziendaUtenteRowMapper = new TaifRPersonaAziendaDaoRowMapper(null,
			TaifRPersonaAziendaByAziendaUtenteDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper tipoInquadramentoByIdInquadramentoVisibileRowMapper = new TaifRPersonaAziendaDaoRowMapper(
			null, TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper ruoloByIdRuoloVisibileRowMapper = new TaifRPersonaAziendaDaoRowMapper(
			null, TaifRPersonaAziendaRuoloByIdRuoloVisibileDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper contrattoByIdContrattoVisibileRowMapper = new TaifRPersonaAziendaDaoRowMapper(
			null, TaifRPersonaAziendaContrattoByIdContrattoVisibileDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper mansioneByIdMansioneVisibileRowMapper = new TaifRPersonaAziendaDaoRowMapper(
			null, TaifRPersonaAziendaMansioneByIdMansioneVisibileDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper conteggioPersonaRowMapper = new TaifRPersonaAziendaDaoRowMapper(null,
			TaifRPersonaAziendaConteggioPersonaDto.class, this);

	protected TaifRPersonaAziendaDaoRowMapper rappresentanteLegaleAziendaRowMapper = new TaifRPersonaAziendaDaoRowMapper(
			null, TaifRPersonaAziendaRappresentanteLegaleAziendaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_PERSONA_AZIENDA";
	}

	/** 
	 * Returns all rows from the TAIF_R_PERSONA_AZIENDA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRPersonaAziendaDto findByPrimaryKey(TaifRPersonaAziendaPk pk) throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,ID_AZIENDA,FK_RUOLO,FK_TIPO_MANSIONE,FK_TIPO_CONTRATTO,FK_TIPO_INQUADRAMENTO,FLG_TEMPO_DETERMINATO,GG_TEMPO_DETERMINATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_PERSONA = :ID_PERSONA  AND ID_AZIENDA = :ID_AZIENDA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		List<TaifRPersonaAziendaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_PERSONA_AZIENDA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRPersonaAziendaDto> findAll() throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,ID_AZIENDA,FK_RUOLO,FK_TIPO_MANSIONE,FK_TIPO_CONTRATTO,FK_TIPO_INQUADRAMENTO,FLG_TEMPO_DETERMINATO,GG_TEMPO_DETERMINATO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_PERSONA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifRPersonaAziendaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as id, persAz.ID_AZIENDA as idAz, persAz.FK_RUOLO as idRuolo, persAz.FK_TIPO_MANSIONE as idMansione, persAz.FK_TIPO_CONTRATTO as idContratto, persAz.FK_TIPO_INQUADRAMENTO as idInquad, persAz.FLG_TEMPO_DETERMINATO as flInd, persAz.GG_TEMPO_DETERMINATO as det");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz");

		sql.append(" WHERE ");

		sql.append("persAz.id_azienda=:idAzienda");
		/*PROTECTED REGION ID(R-108802328) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findByIdAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder contrattoByIdPersona con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaContrattoByIdPersonaDto> findContrattoByIdPersona(java.lang.Integer input)
			throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findContrattoByIdPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as id, persAz.ID_AZIENDA as idAz, persAz.FK_RUOLO as idRuolo, persAz.FK_TIPO_MANSIONE as idMansione, persAz.FK_TIPO_CONTRATTO as idContratto, persAz.FK_TIPO_INQUADRAMENTO as idInquad, persAz.FLG_TEMPO_DETERMINATO as flInd, persAz.GG_TEMPO_DETERMINATO as det, contratto.TIPO_INQUADRAMENTO as tipoContratto");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz, TAIF_D_TIPO_INQUADRAMENTO contratto");

		sql.append(" WHERE ");

		sql.append("persAz.FK_TIPO_CONTRATTO = contratto.ID_TIPO_INQUADRAMENTO");

		sql.append(" AND ");

		sql.append("persAz.id_Azienda=:idAzienda");
		/*PROTECTED REGION ID(R1275340280) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaContrattoByIdPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, contrattoByIdPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findContrattoByIdPersona] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findContrattoByIdPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findContrattoByIdPersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFkUtente con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaByFkUtenteDto> findByFkUtente(java.lang.Integer input)
			throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findByFkUtente] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as id, persAz.ID_AZIENDA as idAz, persAz.FK_RUOLO as idRuolo, persAz.FK_TIPO_MANSIONE as idMansione, persAz.FK_TIPO_CONTRATTO as idContratto, persAz.FK_TIPO_INQUADRAMENTO as idInquad, persAz.FLG_TEMPO_DETERMINATO as flInd, persAz.GG_TEMPO_DETERMINATO as det");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz");

		sql.append(" WHERE ");

		sql.append("persAz.fk_config_utente=:idUtente");
		/*PROTECTED REGION ID(R1122962735) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idUtente", input);

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaByFkUtenteDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFkUtenteRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findByFkUtente] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findByFkUtente", "esecuzione query", sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findByFkUtente] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAziendaUtente con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaByAziendaUtenteDto> findByAziendaUtente(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaAziendaFilter input)
			throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findByAziendaUtente] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as idPersona, persAz.ID_AZIENDA as idAzienda, persAz.FK_RUOLO as idRuolo, persAz.FK_TIPO_MANSIONE as idMansione, persAz.FK_TIPO_CONTRATTO as idContratto, persAz.FK_TIPO_INQUADRAMENTO as idInquad, persAz.FLG_TEMPO_DETERMINATO as flagIndeterminato, persAz.GG_TEMPO_DETERMINATO as ggDeterminato");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz");

		sql.append(" WHERE ");

		sql.append("persAz.fk_config_utente=:idUtente and persAz.id_azienda=:idAzienda");
		/*PROTECTED REGION ID(R1159170228) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idUtente", input.getIdConfigUtente());
		paramMap.addValue("idAzienda", input.getIdAzienda());
		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaByAziendaUtenteDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAziendaUtenteRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findByAziendaUtente] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findByAziendaUtente", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findByAziendaUtente] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder tipoInquadramentoByIdInquadramentoVisibile con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto> findTipoInquadramentoByIdInquadramentoVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.InquadramentoFilter input)
			throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findTipoInquadramentoByIdInquadramentoVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as id, persAz.FK_TIPO_INQUADRAMENTO as idInquad, tipoInquadramento.TIPO_INQUADRAMENTO as tipoInquadramento");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz, TAIF_D_TIPO_INQUADRAMENTO tipoInquadramento");

		sql.append(" WHERE ");

		sql.append("persAz.FK_TIPO_INQUADRAMENTO = tipoInquadramento.ID_TIPO_INQUADRAMENTO");

		sql.append(" AND ");

		sql.append(
				"persAz.fk_tipo_inquadramento=:idInquadramento and tipoInquadramento.mtd_flg_visibile=:flagVisibile ");
		/*PROTECTED REGION ID(R812853081) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idInquadramento", input.getIdInquadramento());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, tipoInquadramentoByIdInquadramentoVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error(
					"[TaifRPersonaAziendaDaoImpl::findTipoInquadramentoByIdInquadramentoVisibile] ERROR esecuzione query",
					ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findTipoInquadramentoByIdInquadramentoVisibile",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findTipoInquadramentoByIdInquadramentoVisibile] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder ruoloByIdRuoloVisibile con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaRuoloByIdRuoloVisibileDto> findRuoloByIdRuoloVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.RuoloFilter input) throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findRuoloByIdRuoloVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as id, persAz.FK_TIPO_INQUADRAMENTO as idInquad, ruolo.RUOLO as ruoloPersona");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz, TAIF_D_RUOLO ruolo");

		sql.append(" WHERE ");

		sql.append("persAz.FK_RUOLO = ruolo.ID_RUOLO");

		sql.append(" AND ");

		sql.append("persAz.fk_ruolo=:idRuolo and ruolo.mtd_flg_visibile=:flagVisibile ");
		/*PROTECTED REGION ID(R-1725647603) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idRuolo", input.getIdRuolo());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaRuoloByIdRuoloVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ruoloByIdRuoloVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findRuoloByIdRuoloVisibile] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findRuoloByIdRuoloVisibile", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findRuoloByIdRuoloVisibile] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder contrattoByIdContrattoVisibile con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaContrattoByIdContrattoVisibileDto> findContrattoByIdContrattoVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ContrattoFilter input)
			throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findContrattoByIdContrattoVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as id, persAz.FK_TIPO_INQUADRAMENTO as idInquad, tipoContratto.RUOLO as ruoloPersona");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz, TAIF_D_TIPO_CONTRATTO tipoContratto");

		sql.append(" WHERE ");

		sql.append("persAz.FK_TIPO_CONTRATTO = tipoContratto.ID_TIPO_CONTRATTO");

		sql.append(" AND ");

		sql.append(
				"persAz.fk_tipo_contratto=:idContratto and tipoContratto.mtd_flg_visibile=:flagVisibile and tipoContratto.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R-951055827) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idContratto", input.getIdContratto());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaContrattoByIdContrattoVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, contrattoByIdContrattoVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findContrattoByIdContrattoVisibile] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findContrattoByIdContrattoVisibile",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findContrattoByIdContrattoVisibile] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder mansioneByIdMansioneVisibile con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaMansioneByIdMansioneVisibileDto> findMansioneByIdMansioneVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.MansioneFilter input)
			throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findMansioneByIdMansioneVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as id, persAz.FK_TIPO_INQUADRAMENTO as idInquad, tipoMansione.RUOLO as ruoloPersona");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz, TAIF_D_TIPO_MANSIONE tipoMansione");

		sql.append(" WHERE ");

		sql.append("persAz.FK_TIPO_MANSIONE = tipoMansione.ID_TIPO_MANSIONE");

		sql.append(" AND ");

		sql.append(
				"persAz.fk_tipo_mansione=:idMansione and tipoMansione.mtd_flg_visibile=:flagVisibile and tipoMansione.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R1868981917) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idMansione", input.getIdMansione());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaMansioneByIdMansioneVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, mansioneByIdMansioneVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findMansioneByIdMansioneVisibile] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findMansioneByIdMansioneVisibile", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findMansioneByIdMansioneVisibile] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder conteggioPersona con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaConteggioPersonaDto> findConteggioPersona(java.lang.Integer input)
			throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findConteggioPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT count(persAz.fk_ruolo) AS conteggio");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz");

		sql.append(" WHERE ");

		sql.append("persAz.id_azienda=:idAziendaSelezionata");
		/*PROTECTED REGION ID(R-1878440943) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAziendaSelezionata", input);

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaConteggioPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, conteggioPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findConteggioPersona] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findConteggioPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findConteggioPersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder rappresentanteLegaleAzienda con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaRappresentanteLegaleAziendaDto> findRappresentanteLegaleAzienda(
			java.lang.Integer input) throws TaifRPersonaAziendaDaoException {
		LOG.debug("[TaifRPersonaAziendaDaoImpl::findRappresentanteLegaleAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persAz.ID_PERSONA as idPersona, persAz.ID_AZIENDA as idAzienda, persAz.FK_RUOLO as idRuolo, persAz.FK_TIPO_MANSIONE as idMansione, persAz.FK_TIPO_CONTRATTO as idContratto, persAz.FK_TIPO_INQUADRAMENTO as idInquad, persAz.FLG_TEMPO_DETERMINATO as flagIndeterminato, persAz.GG_TEMPO_DETERMINATO as ggDeterminato");

		sql.append(" FROM TAIF_R_PERSONA_AZIENDA persAz");

		sql.append(" WHERE ");

		sql.append("persAz.id_azienda=:idAzienda and persAz.fk_ruolo=1");
		/*PROTECTED REGION ID(R1256419034) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRPersonaAziendaRappresentanteLegaleAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, rappresentanteLegaleAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRPersonaAziendaDaoImpl::findRappresentanteLegaleAzienda] ERROR esecuzione query", ex);
			throw new TaifRPersonaAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRPersonaAziendaDaoImpl", "findRappresentanteLegaleAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRPersonaAziendaDaoImpl::findRappresentanteLegaleAzienda] END");
		}
		return list;
	}

}
