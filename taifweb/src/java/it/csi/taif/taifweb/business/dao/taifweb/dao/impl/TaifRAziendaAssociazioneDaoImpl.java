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

/*PROTECTED REGION ID(R-327377433) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifRAziendaAssociazione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - byIdAzienda (datagen::CustomFinder)
 *   - byIdAssociazione (datagen::CustomFinder)
 *   - findAssociazioniByIdAzienda (datagen::CustomFinder)
 *   - findByPrimaryKey (datagen::FindByPK)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - aziendaAssociazioni (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifRAziendaAssociazioneDaoImpl extends AbstractDAO implements TaifRAziendaAssociazioneDao {
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
	 * Metodo di inserimento del DAO taifRAziendaAssociazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAziendaAssociazionePk
	 * @generated
	 */

	public TaifRAziendaAssociazionePk insert(TaifRAziendaAssociazioneDto dto)

	{
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_ASSOCIAZIONE,ID_AZIENDA,NOME,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_ASSOCIAZIONE , :ID_AZIENDA , :NOME , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSOCIAZIONE]
		params.addValue("ID_ASSOCIAZIONE", dto.getIdAssociazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_R_AZIENDA_ASSOCIAZIONE table.
	 * @generated
	 */
	public void update(TaifRAziendaAssociazioneDto dto) throws TaifRAziendaAssociazioneDaoException {
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOME = :NOME ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_ASSOCIAZIONE = :ID_ASSOCIAZIONE  AND ID_AZIENDA = :ID_AZIENDA ";

		if (dto.getIdAssociazione() == null || dto.getIdAzienda() == null) {
			LOG.error("[TaifRAziendaAssociazioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifRAziendaAssociazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSOCIAZIONE]
		params.addValue("ID_ASSOCIAZIONE", dto.getIdAssociazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_R_AZIENDA_ASSOCIAZIONE table.
	 * @generated
	 */
	public void updateColumnsAziendaAssociazioni(TaifRAziendaAssociazioneDto dto)
			throws TaifRAziendaAssociazioneDaoException {
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::updateColumnsAziendaAssociazioni] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET NOME = :NOME ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_ASSOCIAZIONE = :ID_ASSOCIAZIONE  AND ID_AZIENDA = :ID_AZIENDA ";

		if (dto.getIdAssociazione() == null || dto.getIdAzienda() == null) {
			LOG.error(
					"[TaifRAziendaAssociazioneDaoImpl::updateColumnsAziendaAssociazioni] ERROR chiave primaria non impostata");
			throw new TaifRAziendaAssociazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_ASSOCIAZIONE]
		params.addValue("ID_ASSOCIAZIONE", dto.getIdAssociazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", dto.getIdAzienda(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::updateColumnsAziendaAssociazioni] END");
	}

	/** 
	 * Deletes a single row in the TAIF_R_AZIENDA_ASSOCIAZIONE table.
	 * @generated
	 */

	public void delete(TaifRAziendaAssociazionePk pk) throws TaifRAziendaAssociazioneDaoException {
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE ID_ASSOCIAZIONE = :ID_ASSOCIAZIONE  AND ID_AZIENDA = :ID_AZIENDA ";

		if (pk == null) {
			LOG.error("[TaifRAziendaAssociazioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifRAziendaAssociazioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSOCIAZIONE]
		params.addValue("ID_ASSOCIAZIONE", pk.getIdAssociazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::delete] END");
	}

	protected TaifRAziendaAssociazioneDaoRowMapper findAllRowMapper = new TaifRAziendaAssociazioneDaoRowMapper(null,
			TaifRAziendaAssociazioneDto.class, this);

	protected TaifRAziendaAssociazioneDaoRowMapper byIdAziendaRowMapper = new TaifRAziendaAssociazioneDaoRowMapper(null,
			TaifRAziendaAssociazioneByIdAziendaDto.class, this);

	protected TaifRAziendaAssociazioneDaoRowMapper byIdAssociazioneRowMapper = new TaifRAziendaAssociazioneDaoRowMapper(
			null, TaifRAziendaAssociazioneByIdAssociazioneDto.class, this);

	protected TaifRAziendaAssociazioneDaoRowMapper findAssociazioniByIdAziendaRowMapper = new TaifRAziendaAssociazioneDaoRowMapper(
			null, TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto.class, this);

	protected TaifRAziendaAssociazioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifRAziendaAssociazioneDaoRowMapper(
			null, TaifRAziendaAssociazioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_AZIENDA_ASSOCIAZIONE";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_AZIENDA_ASSOCIAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAziendaAssociazioneDto> findAll() throws TaifRAziendaAssociazioneDaoException {
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ASSOCIAZIONE,ID_AZIENDA,NOME,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_AZIENDA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifRAziendaAssociazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaAssociazioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifRAziendaAssociazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaAssociazioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaAssociazioneByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifRAziendaAssociazioneDaoException {
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azAssociazione.ID_AZIENDA as idAzienda, azAssociazione.ID_ASSOCIAZIONE as idAssociazione, azAssociazione.DATA_INSERIMENTO as dataInserimento, azAssociazione.NOME as nome");

		sql.append(" FROM TAIF_R_AZIENDA_ASSOCIAZIONE azAssociazione");

		sql.append(" WHERE ");

		sql.append("azAssociazione.id_azienda=:idAzienda");
		/*PROTECTED REGION ID(R1745680258) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaAssociazioneByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaAssociazioneDaoImpl::findByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifRAziendaAssociazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaAssociazioneDaoImpl", "findByIdAzienda", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findByIdAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdAssociazione con Qdef
		 * @generated
		 */

	public List<TaifRAziendaAssociazioneByIdAssociazioneDto> findByIdAssociazione(java.lang.Integer input)
			throws TaifRAziendaAssociazioneDaoException {
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findByIdAssociazione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azAssociazione.ID_ASSOCIAZIONE as idAzienda, azAssociazione.ID_ASSOCIAZIONE as idAssociazione, azAssociazione.NOME as nome, azAssociazione.DATA_INSERIMENTO as dataInserimento");

		sql.append(" FROM TAIF_R_AZIENDA_ASSOCIAZIONE azAssociazione");

		sql.append(" WHERE ");

		sql.append("azAssociazione.id_associazione=:idAssociazione");
		/*PROTECTED REGION ID(R-297658162) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAssociazione", input);

		/*PROTECTED REGION END*/

		List<TaifRAziendaAssociazioneByIdAssociazioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdAssociazioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaAssociazioneDaoImpl::findByIdAssociazione] ERROR esecuzione query", ex);
			throw new TaifRAziendaAssociazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaAssociazioneDaoImpl", "findByIdAssociazione", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findByIdAssociazione] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findAssociazioniByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> findFindAssociazioniByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifRAziendaAssociazioneDaoException {
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findFindAssociazioniByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT azAssociazione.ID_AZIENDA as idAzienda, azAssociazione.ID_ASSOCIAZIONE as idAssociazione, azAssociazione.NOME as nomeAltraAssociazione, azAssociazione.DATA_INSERIMENTO as dataInserimento, dAssociazione.ASSOCIAZIONE as associazione");

		sql.append(" FROM TAIF_R_AZIENDA_ASSOCIAZIONE azAssociazione, TAIF_D_ASSOCIAZIONE dAssociazione");

		sql.append(" WHERE ");

		sql.append("azAssociazione.ID_ASSOCIAZIONE = dAssociazione.ID_ASSOCIAZIONE");

		sql.append(" AND ");

		sql.append(
				"azAssociazione.id_azienda=:idAzienda  and dAssociazione.mtd_flg_visibile=:flagVisibile and  dAssociazione.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R685903625) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findAssociazioniByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaAssociazioneDaoImpl::findFindAssociazioniByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifRAziendaAssociazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaAssociazioneDaoImpl", "findFindAssociazioniByIdAzienda",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findFindAssociazioniByIdAzienda] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the TAIF_R_AZIENDA_ASSOCIAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAziendaAssociazioneDto findByPrimaryKey(TaifRAziendaAssociazionePk pk)
			throws TaifRAziendaAssociazioneDaoException {
		LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_ASSOCIAZIONE,ID_AZIENDA,NOME,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_ASSOCIAZIONE = :ID_ASSOCIAZIONE  AND ID_AZIENDA = :ID_AZIENDA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ASSOCIAZIONE]
		params.addValue("ID_ASSOCIAZIONE", pk.getIdAssociazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_AZIENDA]
		params.addValue("ID_AZIENDA", pk.getIdAzienda(), java.sql.Types.INTEGER);

		List<TaifRAziendaAssociazioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRAziendaAssociazioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifRAziendaAssociazioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRAziendaAssociazioneDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifRAziendaAssociazioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

}
