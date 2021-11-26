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

/*PROTECTED REGION ID(R-1447099247) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTLavoroPa.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
 *   - byAzienda (datagen::CustomFinder)
 *   - lavoroPaByAziendaVisibile (datagen::CustomFinder)
  * - UPDATERS:
 *   - updateById (datagen::UpdateColumns)
 *   - update (datagen::UpdateRow)
 *   - perIdAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTLavoroPaDaoImpl extends AbstractDAO implements TaifTLavoroPaDao {
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
	 * Metodo di inserimento del DAO taifTLavoroPa. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTLavoroPaPk
	 * @generated
	 */

	public TaifTLavoroPaPk insert(TaifTLavoroPaDto dto)

	{
		LOG.debug("[TaifTLavoroPaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_LAVORO_PA,FK_AZIENDA,FK_TIPO_LAVORO_PA,COMMITTENTE,IMPORTO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,DESCR_ALTRO ) VALUES (  :ID_LAVORO_PA , :FK_AZIENDA , :FK_TIPO_LAVORO_PA , :COMMITTENTE , :IMPORTO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE , :DESCR_ALTRO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LAVORO_PA]
		params.addValue("ID_LAVORO_PA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_LAVORO_PA]
		params.addValue("FK_TIPO_LAVORO_PA", dto.getFkTipoLavoroPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [COMMITTENTE]
		params.addValue("COMMITTENTE", dto.getCommittente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [IMPORTO]
		params.addValue("IMPORTO", dto.getImporto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdLavoroPa(newKey);
		LOG.debug("[TaifTLavoroPaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_T_LAVORO_PA table.
	 * @generated
	 */
	public void updateColumnsUpdateById(TaifTLavoroPaDto dto) throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::updateColumnsUpdateById] START");
		final String sql = "UPDATE " + getTableName() + " SET  WHERE ID_LAVORO_PA = :ID_LAVORO_PA ";

		if (dto.getIdLavoroPa() == null) {
			LOG.error("[TaifTLavoroPaDaoImpl::updateColumnsUpdateById] ERROR chiave primaria non impostata");
			throw new TaifTLavoroPaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LAVORO_PA]
		params.addValue("ID_LAVORO_PA", dto.getIdLavoroPa(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTLavoroPaDaoImpl::updateColumnsUpdateById] END");
	}

	/** 
	 * Updates a single row in the TAIF_T_LAVORO_PA table.
	 * @generated
	 */
	public void update(TaifTLavoroPaDto dto) throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AZIENDA = :FK_AZIENDA ,FK_TIPO_LAVORO_PA = :FK_TIPO_LAVORO_PA ,COMMITTENTE = :COMMITTENTE ,IMPORTO = :IMPORTO ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,DESCR_ALTRO = :DESCR_ALTRO  WHERE ID_LAVORO_PA = :ID_LAVORO_PA ";

		if (dto.getIdLavoroPa() == null) {
			LOG.error("[TaifTLavoroPaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTLavoroPaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LAVORO_PA]
		params.addValue("ID_LAVORO_PA", dto.getIdLavoroPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_LAVORO_PA]
		params.addValue("FK_TIPO_LAVORO_PA", dto.getFkTipoLavoroPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [COMMITTENTE]
		params.addValue("COMMITTENTE", dto.getCommittente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [IMPORTO]
		params.addValue("IMPORTO", dto.getImporto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTLavoroPaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_LAVORO_PA table.
	 * @generated
	 */
	public void updateColumnsPerIdAzienda(TaifTLavoroPaDto dto) throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::updateColumnsPerIdAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_TIPO_LAVORO_PA = :FK_TIPO_LAVORO_PA ,COMMITTENTE = :COMMITTENTE ,IMPORTO = :IMPORTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,DESCR_ALTRO = :DESCR_ALTRO  WHERE ID_LAVORO_PA = :ID_LAVORO_PA ";

		if (dto.getIdLavoroPa() == null) {
			LOG.error("[TaifTLavoroPaDaoImpl::updateColumnsPerIdAzienda] ERROR chiave primaria non impostata");
			throw new TaifTLavoroPaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_LAVORO_PA]
		params.addValue("FK_TIPO_LAVORO_PA", dto.getFkTipoLavoroPa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [COMMITTENTE]
		params.addValue("COMMITTENTE", dto.getCommittente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [IMPORTO]
		params.addValue("IMPORTO", dto.getImporto(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DESCR_ALTRO]
		params.addValue("DESCR_ALTRO", dto.getDescrAltro(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_LAVORO_PA]
		params.addValue("ID_LAVORO_PA", dto.getIdLavoroPa(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTLavoroPaDaoImpl::updateColumnsPerIdAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_LAVORO_PA table.
	 * @generated
	 */

	public void delete(TaifTLavoroPaPk pk) throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_LAVORO_PA = :ID_LAVORO_PA ";

		if (pk == null) {
			LOG.error("[TaifTLavoroPaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTLavoroPaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LAVORO_PA]
		params.addValue("ID_LAVORO_PA", pk.getIdLavoroPa(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTLavoroPaDaoImpl::delete] END");
	}

	protected TaifTLavoroPaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTLavoroPaDaoRowMapper(null,
			TaifTLavoroPaDto.class, this);

	protected TaifTLavoroPaDaoRowMapper findAllRowMapper = new TaifTLavoroPaDaoRowMapper(null, TaifTLavoroPaDto.class,
			this);

	protected TaifTLavoroPaDaoRowMapper byFilterRowMapper = new TaifTLavoroPaDaoRowMapper(null,
			TaifTLavoroPaByFilterDto.class, this);

	protected TaifTLavoroPaDaoRowMapper byAziendaRowMapper = new TaifTLavoroPaDaoRowMapper(null,
			TaifTLavoroPaByAziendaDto.class, this);

	protected TaifTLavoroPaDaoRowMapper lavoroPaByAziendaVisibileRowMapper = new TaifTLavoroPaDaoRowMapper(null,
			TaifTLavoroPaLavoroPaByAziendaVisibileDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_LAVORO_PA";
	}

	/** 
	 * Returns all rows from the TAIF_T_LAVORO_PA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTLavoroPaDto findByPrimaryKey(TaifTLavoroPaPk pk) throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_LAVORO_PA,FK_AZIENDA,FK_TIPO_LAVORO_PA,COMMITTENTE,IMPORTO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,DESCR_ALTRO FROM "
						+ getTableName() + " WHERE ID_LAVORO_PA = :ID_LAVORO_PA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_LAVORO_PA]
		params.addValue("ID_LAVORO_PA", pk.getIdLavoroPa(), java.sql.Types.INTEGER);

		List<TaifTLavoroPaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTLavoroPaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTLavoroPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTLavoroPaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTLavoroPaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_LAVORO_PA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTLavoroPaDto> findAll() throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_LAVORO_PA,FK_AZIENDA,FK_TIPO_LAVORO_PA,COMMITTENTE,IMPORTO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,DESCR_ALTRO FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_LAVORO_PA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTLavoroPaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTLavoroPaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTLavoroPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTLavoroPaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTLavoroPaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTLavoroPaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT lavpa.ID_LAVORO_PA as id, lavpa.COMMITTENTE as commit, lavpa.IMPORTO as importo, tipo.TIPO_LAVORO_PA as tipoLavoro, tipo.ID_TIPO_LAVORO_PA as idTipoLavoro, lavpa.FK_AZIENDA as fkAzienda, lavpa.DESCR_ALTRO as descAltro");

		sql.append(" FROM TAIF_T_LAVORO_PA lavpa, TAIF_D_TIPO_LAVORO_PA tipo");

		sql.append(" WHERE ");

		sql.append("lavpa.FK_TIPO_LAVORO_PA = tipo.ID_TIPO_LAVORO_PA");

		sql.append(" AND ");

		sql.append("tipo.MTD_FLG_VISIBILE=:visibile");
		/*PROTECTED REGION ID(R2078173289) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifTLavoroPaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTLavoroPaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTLavoroPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTLavoroPaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifTLavoroPaDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAzienda con Qdef
		 * @generated
		 */

	public List<TaifTLavoroPaByAziendaDto> findByAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.LavoroPaFilter input) throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::findByAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT lavpa.ID_LAVORO_PA as id, lavpa.COMMITTENTE as commit, lavpa.IMPORTO as importo, tipo.TIPO_LAVORO_PA as tipoLavoro, tipo.ID_TIPO_LAVORO_PA as idTipoLavoro, lavpa.FK_AZIENDA as fkAzienda, lavpa.DESCR_ALTRO as descAltro");

		sql.append(" FROM TAIF_T_LAVORO_PA lavpa, TAIF_D_TIPO_LAVORO_PA tipo");

		sql.append(" WHERE ");

		sql.append("lavpa.FK_TIPO_LAVORO_PA = tipo.ID_TIPO_LAVORO_PA");

		sql.append(" AND ");

		sql.append("tipo.MTD_FLG_VISIBILE=:visibile and lavpa.FK_AZIENDA=:idAzienda");
		/*PROTECTED REGION ID(R-694421671) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("idAzienda", input.getIdAzienda());

		/*PROTECTED REGION END*/

		List<TaifTLavoroPaByAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTLavoroPaDaoImpl::findByAzienda] ERROR esecuzione query", ex);
			throw new TaifTLavoroPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTLavoroPaDaoImpl", "findByAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTLavoroPaDaoImpl::findByAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder lavoroPaByAziendaVisibile con Qdef
		 * @generated
		 */

	public List<TaifTLavoroPaLavoroPaByAziendaVisibileDto> findLavoroPaByAziendaVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTLavoroPaDaoException {
		LOG.debug("[TaifTLavoroPaDaoImpl::findLavoroPaByAziendaVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT lavoroPa.ID_LAVORO_PA as idLavoro, lavoroPa.COMMITTENTE as commitente, lavoroPa.IMPORTO as importo, tipoLavoro.TIPO_LAVORO_PA as tipoLavoro, tipoLavoro.ID_TIPO_LAVORO_PA as idTipoLavoro, lavoroPa.FK_AZIENDA as fkAzienda, lavoroPa.DESCR_ALTRO as descAltroLavoro");

		sql.append(" FROM TAIF_T_LAVORO_PA lavoroPa, TAIF_D_TIPO_LAVORO_PA tipoLavoro");

		sql.append(" WHERE ");

		sql.append("lavoroPa.FK_TIPO_LAVORO_PA = tipoLavoro.ID_TIPO_LAVORO_PA");

		sql.append(" AND ");

		sql.append("lavoroPa.fk_azienda=:idAzienda and   tipoLavoro.MTD_FLG_VISIBILE=:flagVisibile ");
		/*PROTECTED REGION ID(R-1600763860) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifTLavoroPaLavoroPaByAziendaVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, lavoroPaByAziendaVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTLavoroPaDaoImpl::findLavoroPaByAziendaVisibile] ERROR esecuzione query", ex);
			throw new TaifTLavoroPaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTLavoroPaDaoImpl", "findLavoroPaByAziendaVisibile", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTLavoroPaDaoImpl::findLavoroPaByAziendaVisibile] END");
		}
		return list;
	}

}
