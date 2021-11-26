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

/*PROTECTED REGION ID(R-532347451) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifRAziendaFrTipoMans.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByIdAzienda (datagen::CustomFinder)
 *   - byIdTipoMansione (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findTipoByIdAzienda (datagen::CustomFinder)
  * - UPDATERS:
 *   - updateForIdAziendaMansione (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifRAziendaFrTipoMansDaoImpl extends AbstractDAO implements TaifRAziendaFrTipoMansDao {
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
	 * Metodo di inserimento del DAO taifRAziendaFrTipoMans. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAziendaFrTipoMansPk
	 * @generated
	 */

	public TaifRAziendaFrTipoMansPk insert(TaifRAziendaFrTipoMansDto dto)

	{
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AZIENDA,ID_TIPO_MANSIONE,NR_ADDETTI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_AZIENDA , :ID_TIPO_MANSIONE , :NR_ADDETTI , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", dto.getIdTipoMansione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NR_ADDETTI]
		params.addValue("NR_ADDETTI", dto.getNrAddetti(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_R_AZIENDAFR_TIPOMANS table.
	 * @generated
	 */
	public void updateColumnsUpdateForIdAziendaMansione(TaifRAziendaFrTipoMansDto dto)
			throws TaifRAziendaFrTipoMansDaoException {
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::updateColumnsUpdateForIdAziendaMansione] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NR_ADDETTI = :NR_ADDETTI ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_TIPO_MANSIONE = :ID_TIPO_MANSIONE ";

		if (dto.getIdAzienda() == null || dto.getIdTipoMansione() == null) {
			LOG.error(
					"[TaifRAziendaFrTipoMansDaoImpl::updateColumnsUpdateForIdAziendaMansione] ERROR chiave primaria non impostata");
			throw new TaifRAziendaFrTipoMansDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", dto.getIdTipoMansione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NR_ADDETTI]
		params.addValue("NR_ADDETTI", dto.getNrAddetti(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", dto.getIdTipoMansione(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::updateColumnsUpdateForIdAziendaMansione] END");
	}

	/** 
	 * Deletes a single row in the TAIF_R_AZIENDAFR_TIPOMANS table.
	 * @generated
	 */

	public void delete(TaifRAziendaFrTipoMansPk pk) throws TaifRAziendaFrTipoMansDaoException {
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_TIPO_MANSIONE = :ID_TIPO_MANSIONE ";

		if (pk == null) {
			LOG.error("[TaifRAziendaFrTipoMansDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifRAziendaFrTipoMansDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", pk.getIdTipoMansione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::delete] END");
	}

	protected TaifRAziendaFrTipoMansDaoRowMapper findAllRowMapper = new TaifRAziendaFrTipoMansDaoRowMapper(null,
			TaifRAziendaFrTipoMansDto.class, this);

	protected TaifRAziendaFrTipoMansDaoRowMapper findByIdAziendaRowMapper = new TaifRAziendaFrTipoMansDaoRowMapper(null,
			TaifRAziendaFrTipoMansFindByIdAziendaDto.class, this);

	protected TaifRAziendaFrTipoMansDaoRowMapper byIdTipoMansioneRowMapper = new TaifRAziendaFrTipoMansDaoRowMapper(
			null, TaifRAziendaFrTipoMansByIdTipoMansioneDto.class, this);

	protected TaifRAziendaFrTipoMansDaoRowMapper findByPrimaryKeyRowMapper = new TaifRAziendaFrTipoMansDaoRowMapper(
			null, TaifRAziendaFrTipoMansDto.class, this);

	protected TaifRAziendaFrTipoMansDaoRowMapper findTipoByIdAziendaRowMapper = new TaifRAziendaFrTipoMansDaoRowMapper(
			null, TaifRAziendaFrTipoMansFindTipoByIdAziendaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_AZIENDAFR_TIPOMANS";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_AZIENDAFR_TIPOMANS.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAziendaFrTipoMansDto> findAll() throws TaifRAziendaFrTipoMansDaoException {
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,ID_TIPO_MANSIONE,NR_ADDETTI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_AZIENDA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifRAziendaFrTipoMansDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoMansDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoMansDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoMansDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoMansFindByIdAziendaDto> findFindByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaFrTipoMansDaoException {
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findFindByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT aziendaMansioneFra.ID_AZIENDA as idAzienda, aziendaMansioneFra.ID_TIPO_MANSIONE as idTipoMansione, aziendaMansioneFra.NR_ADDETTI as nrAdetti, aziendaMansioneFra.DATA_INSERIMENTO as dataInserimento, aziendaMansioneFra.DATA_AGGIORNAMENTO as dataAggiornamento, aziendaMansioneFra.FK_CONFIG_UTENTE as fkConfigUtente");

		sql.append(" FROM TAIF_R_AZIENDAFR_TIPOMANS aziendaMansioneFra");

		sql.append(" WHERE ");

		sql.append("aziendaMansioneFra.id_Azienda=:idAzienda");
		/*PROTECTED REGION ID(R464065388) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaFrTipoMansFindByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoMansDaoImpl::findFindByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoMansDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoMansDaoImpl", "findFindByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findFindByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdTipoMansione con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoMansByIdTipoMansioneDto> findByIdTipoMansione(java.lang.Integer input)
			throws TaifRAziendaFrTipoMansDaoException {
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findByIdTipoMansione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azContr.ID_AZIENDA as idAzienda, azContr.ID_TIPO_CONTRATTO as idTipoContr, azContr.NR_ADDETTI as addetti");

		sql.append(" FROM TAIF_R_AZIENDAFR_TIPOCONTR azContr");

		sql.append(" WHERE ");

		sql.append("azContr.id_tipo_mansione=:idMansione");
		/*PROTECTED REGION ID(R-1107391907) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idMansione", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaFrTipoMansByIdTipoMansioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdTipoMansioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoMansDaoImpl::findByIdTipoMansione] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoMansDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoMansDaoImpl", "findByIdTipoMansione", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findByIdTipoMansione] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the TAIF_R_AZIENDAFR_TIPOMANS table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAziendaFrTipoMansDto findByPrimaryKey(TaifRAziendaFrTipoMansPk pk)
			throws TaifRAziendaFrTipoMansDaoException {
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,ID_TIPO_MANSIONE,NR_ADDETTI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName()
						+ " WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_TIPO_MANSIONE = :ID_TIPO_MANSIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", pk.getIdTipoMansione(), java.sql.Types.INTEGER);

		List<TaifRAziendaFrTipoMansDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoMansDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoMansDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoMansDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder findTipoByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoMansFindTipoByIdAziendaDto> findFindTipoByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaFrTipoMansDaoException {
		LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findFindTipoByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT aziendaMansioneFra.ID_AZIENDA as idAzienda, aziendaMansioneFra.ID_TIPO_MANSIONE as idTipoMansione, aziendaMansioneFra.NR_ADDETTI as nrAdetti, aziendaMansioneFra.DATA_INSERIMENTO as dataInserimento, aziendaMansioneFra.DATA_AGGIORNAMENTO as dataAggiornamento, aziendaMansioneFra.FK_CONFIG_UTENTE as fkConfigUtente, tipoMansione.TIPO_MANSIONE as tipoMansione");

		sql.append(" FROM TAIF_R_AZIENDAFR_TIPOMANS aziendaMansioneFra, TAIF_D_TIPO_MANSIONE tipoMansione");

		sql.append(" WHERE ");

		sql.append("aziendaMansioneFra.ID_TIPO_MANSIONE = tipoMansione.ID_TIPO_MANSIONE");

		sql.append(" AND ");

		sql.append("aziendaMansioneFra.id_Azienda=:idAzienda");
		/*PROTECTED REGION ID(R1573744320) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaFrTipoMansFindTipoByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findTipoByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoMansDaoImpl::findFindTipoByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoMansDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoMansDaoImpl", "findFindTipoByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaFrTipoMansDaoImpl::findFindTipoByIdAzienda] END");
		}
		return list;
	}

}
