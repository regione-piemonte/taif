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

/*PROTECTED REGION ID(R-908412079) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifRAziendaFrTipoContr.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByIdAzienda (datagen::CustomFinder)
 *   - byIdTipoContratto (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findTipoByIdAzienda (datagen::CustomFinder)
  * - UPDATERS:
 *   - updateForIdAziendaContratto (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifRAziendaFrTipoContrDaoImpl extends AbstractDAO implements TaifRAziendaFrTipoContrDao {
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
	 * Metodo di inserimento del DAO taifRAziendaFrTipoContr. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAziendaFrTipoContrPk
	 * @generated
	 */

	public TaifRAziendaFrTipoContrPk insert(TaifRAziendaFrTipoContrDto dto)

	{
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_AZIENDA,ID_TIPO_CONTRATTO,NR_ADDETTI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_AZIENDA , :ID_TIPO_CONTRATTO , :NR_ADDETTI , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", dto.getIdTipoContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NR_ADDETTI]
		params.addValue("NR_ADDETTI", dto.getNrAddetti(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_R_AZIENDAFR_TIPOCONTR table.
	 * @generated
	 */
	public void updateColumnsUpdateForIdAziendaContratto(TaifRAziendaFrTipoContrDto dto)
			throws TaifRAziendaFrTipoContrDaoException {
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::updateColumnsUpdateForIdAziendaContratto] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NR_ADDETTI = :NR_ADDETTI ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_TIPO_CONTRATTO = :ID_TIPO_CONTRATTO ";

		if (dto.getIdAzienda() == null || dto.getIdTipoContratto() == null) {
			LOG.error(
					"[TaifRAziendaFrTipoContrDaoImpl::updateColumnsUpdateForIdAziendaContratto] ERROR chiave primaria non impostata");
			throw new TaifRAziendaFrTipoContrDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", dto.getIdTipoContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NR_ADDETTI]
		params.addValue("NR_ADDETTI", dto.getNrAddetti(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", dto.getIdTipoContratto(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::updateColumnsUpdateForIdAziendaContratto] END");
	}

	/** 
	 * Deletes a single row in the TAIF_R_AZIENDAFR_TIPOCONTR table.
	 * @generated
	 */

	public void delete(TaifRAziendaFrTipoContrPk pk) throws TaifRAziendaFrTipoContrDaoException {
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_TIPO_CONTRATTO = :ID_TIPO_CONTRATTO ";

		if (pk == null) {
			LOG.error("[TaifRAziendaFrTipoContrDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifRAziendaFrTipoContrDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", pk.getIdTipoContratto(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::delete] END");
	}

	protected TaifRAziendaFrTipoContrDaoRowMapper findAllRowMapper = new TaifRAziendaFrTipoContrDaoRowMapper(null,
			TaifRAziendaFrTipoContrDto.class, this);

	protected TaifRAziendaFrTipoContrDaoRowMapper findByIdAziendaRowMapper = new TaifRAziendaFrTipoContrDaoRowMapper(
			null, TaifRAziendaFrTipoContrFindByIdAziendaDto.class, this);

	protected TaifRAziendaFrTipoContrDaoRowMapper byIdTipoContrattoRowMapper = new TaifRAziendaFrTipoContrDaoRowMapper(
			null, TaifRAziendaFrTipoContrByIdTipoContrattoDto.class, this);

	protected TaifRAziendaFrTipoContrDaoRowMapper findByPrimaryKeyRowMapper = new TaifRAziendaFrTipoContrDaoRowMapper(
			null, TaifRAziendaFrTipoContrDto.class, this);

	protected TaifRAziendaFrTipoContrDaoRowMapper findTipoByIdAziendaRowMapper = new TaifRAziendaFrTipoContrDaoRowMapper(
			null, TaifRAziendaFrTipoContrFindTipoByIdAziendaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_AZIENDAFR_TIPOCONTR";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_AZIENDAFR_TIPOCONTR.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAziendaFrTipoContrDto> findAll() throws TaifRAziendaFrTipoContrDaoException {
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,ID_TIPO_CONTRATTO,NR_ADDETTI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_AZIENDA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifRAziendaFrTipoContrDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoContrDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoContrDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoContrDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoContrFindByIdAziendaDto> findFindByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaFrTipoContrDaoException {
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findFindByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT aziendaContrattoFra.ID_AZIENDA as idAzienda, aziendaContrattoFra.ID_TIPO_CONTRATTO as idTipoContr, aziendaContrattoFra.NR_ADDETTI as nrAdetti, aziendaContrattoFra.DATA_INSERIMENTO as dataInserimento, aziendaContrattoFra.DATA_AGGIORNAMENTO as dataAggiornamento, aziendaContrattoFra.FK_CONFIG_UTENTE as fkConfigUtente");

		sql.append(" FROM TAIF_R_AZIENDAFR_TIPOCONTR aziendaContrattoFra");

		sql.append(" WHERE ");

		sql.append("aziendaContrattoFra.id_Azienda=:idAzienda");
		/*PROTECTED REGION ID(R28996737) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaFrTipoContrFindByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoContrDaoImpl::findFindByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoContrDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoContrDaoImpl", "findFindByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findFindByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdTipoContratto con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoContrByIdTipoContrattoDto> findByIdTipoContratto(java.lang.Integer input)
			throws TaifRAziendaFrTipoContrDaoException {
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findByIdTipoContratto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azContr.ID_AZIENDA as idAzienda, azContr.ID_TIPO_CONTRATTO as idTipoContr, azContr.NR_ADDETTI as addetti");

		sql.append(" FROM TAIF_R_AZIENDAFR_TIPOCONTR azContr");

		sql.append(" WHERE ");

		sql.append("azContr.id_tipo_contratto=:idContratto");
		/*PROTECTED REGION ID(R1987433028) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idContratto", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaFrTipoContrByIdTipoContrattoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdTipoContrattoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoContrDaoImpl::findByIdTipoContratto] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoContrDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoContrDaoImpl", "findByIdTipoContratto", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findByIdTipoContratto] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the TAIF_R_AZIENDAFR_TIPOCONTR table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAziendaFrTipoContrDto findByPrimaryKey(TaifRAziendaFrTipoContrPk pk)
			throws TaifRAziendaFrTipoContrDaoException {
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_AZIENDA,ID_TIPO_CONTRATTO,NR_ADDETTI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName()
						+ " WHERE ID_AZIENDA = :ID_AZIENDA  AND ID_TIPO_CONTRATTO = :ID_TIPO_CONTRATTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", pk.getIdTipoContratto(), java.sql.Types.INTEGER);

		List<TaifRAziendaFrTipoContrDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoContrDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoContrDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoContrDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder findTipoByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaFrTipoContrFindTipoByIdAziendaDto> findFindTipoByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaFrTipoContrDaoException {
		LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findFindTipoByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT aziendaContrattoFra.ID_AZIENDA as idAzienda, aziendaContrattoFra.ID_TIPO_CONTRATTO as idTipoContr, aziendaContrattoFra.NR_ADDETTI as nrAdetti, aziendaContrattoFra.DATA_INSERIMENTO as dataInserimento, aziendaContrattoFra.DATA_AGGIORNAMENTO as dataAggiornamento, aziendaContrattoFra.FK_CONFIG_UTENTE as fkConfigUtente, tipoContratto.TIPO_CONTRATTO as tipoContratto");

		sql.append(" FROM TAIF_R_AZIENDAFR_TIPOCONTR aziendaContrattoFra, TAIF_D_TIPO_CONTRATTO tipoContratto");

		sql.append(" WHERE ");

		sql.append("aziendaContrattoFra.ID_TIPO_CONTRATTO = tipoContratto.ID_TIPO_CONTRATTO");

		sql.append(" AND ");

		sql.append("aziendaContrattoFra.id_Azienda=:idAzienda");
		/*PROTECTED REGION ID(R728644949) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaFrTipoContrFindTipoByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findTipoByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaFrTipoContrDaoImpl::findFindTipoByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifRAziendaFrTipoContrDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaFrTipoContrDaoImpl", "findFindTipoByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaFrTipoContrDaoImpl::findFindTipoByIdAzienda] END");
		}
		return list;
	}

}
