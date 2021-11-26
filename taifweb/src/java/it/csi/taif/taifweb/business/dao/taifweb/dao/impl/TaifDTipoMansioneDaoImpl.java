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

/*PROTECTED REGION ID(R-1767146415) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoMansione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibleOrdin (datagen::CustomFinder)
 *   - byTipoMansione (datagen::CustomFinder)
 *   - byIdTipoMansione (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoMansioneDaoImpl extends AbstractDAO implements TaifDTipoMansioneDao {
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
	 * Cache del DAO.
	 * @generated
	 */
	protected SimpleCache cache;

	/**
	 * Restutuisce la cache del DAO
	 * @generated
	 */
	public SimpleCache getCache() {
		return cache;
	}

	/**
	 * Imposta la cache del DAO
	 * @param cache
	 * @generated
	 */
	public void setCache(SimpleCache cache) {
		this.cache = cache;
	}

	/**
	 * Metodo di inserimento del DAO taifDTipoMansione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoMansionePk
	 * @generated
	 */

	public TaifDTipoMansionePk insert(TaifDTipoMansioneDto dto)

	{
		LOG.debug("[TaifDTipoMansioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_MANSIONE,TIPO_MANSIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TIPO_MANSIONE , :TIPO_MANSIONE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_MANSIONE]
		params.addValue("TIPO_MANSIONE", dto.getTipoMansione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoMansione(newKey);
		LOG.debug("[TaifDTipoMansioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TIPO_MANSIONE table.
	 * @generated
	 */
	public void update(TaifDTipoMansioneDto dto) throws TaifDTipoMansioneDaoException {
		LOG.debug("[TaifDTipoMansioneDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPO_MANSIONE = :TIPO_MANSIONE ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE ,MTD_FLG_ITA_FRA = :MTD_FLG_ITA_FRA  WHERE ID_TIPO_MANSIONE = :ID_TIPO_MANSIONE ";

		if (dto.getIdTipoMansione() == null) {
			LOG.error("[TaifDTipoMansioneDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTipoMansioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", dto.getIdTipoMansione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_MANSIONE]
		params.addValue("TIPO_MANSIONE", dto.getTipoMansione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoMansioneDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_MANSIONE table.
	 * @generated
	 */

	public void delete(TaifDTipoMansionePk pk) throws TaifDTipoMansioneDaoException {
		LOG.debug("[TaifDTipoMansioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_MANSIONE = :ID_TIPO_MANSIONE ";

		if (pk == null) {
			LOG.error("[TaifDTipoMansioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoMansioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", pk.getIdTipoMansione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoMansioneDaoImpl::delete] END");
	}

	protected TaifDTipoMansioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoMansioneDaoRowMapper(null,
			TaifDTipoMansioneDto.class, this);

	protected TaifDTipoMansioneDaoRowMapper findAllRowMapper = new TaifDTipoMansioneDaoRowMapper(null,
			TaifDTipoMansioneDto.class, this);

	protected TaifDTipoMansioneDaoRowMapper byVisibleOrdinRowMapper = new TaifDTipoMansioneDaoRowMapper(null,
			TaifDTipoMansioneByVisibleOrdinDto.class, this);

	protected TaifDTipoMansioneDaoRowMapper byTipoMansioneRowMapper = new TaifDTipoMansioneDaoRowMapper(null,
			TaifDTipoMansioneByTipoMansioneDto.class, this);

	protected TaifDTipoMansioneDaoRowMapper byIdTipoMansioneRowMapper = new TaifDTipoMansioneDaoRowMapper(null,
			TaifDTipoMansioneByIdTipoMansioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_MANSIONE";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_MANSIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoMansioneDto findByPrimaryKey(TaifDTipoMansionePk pk) throws TaifDTipoMansioneDaoException {
		LOG.debug("[TaifDTipoMansioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_MANSIONE,TIPO_MANSIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TIPO_MANSIONE = :ID_TIPO_MANSIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MANSIONE]
		params.addValue("ID_TIPO_MANSIONE", pk.getIdTipoMansione(), java.sql.Types.INTEGER);

		List<TaifDTipoMansioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoMansioneDto res = (TaifDTipoMansioneDto) cache.get(pk);
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put(pk, list.get(0));
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMansioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoMansioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMansioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMansioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_MANSIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoMansioneDto> findAll() throws TaifDTipoMansioneDaoException {
		LOG.debug("[TaifDTipoMansioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_MANSIONE,TIPO_MANSIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoMansioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoMansioneDto> res = (List<TaifDTipoMansioneDto>) cache.get("findAll_taifDTipoMansione_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoMansione_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMansioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoMansioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMansioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMansioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibleOrdin con Qdef
		 * @generated
		 */

	public List<TaifDTipoMansioneByVisibleOrdinDto> findByVisibleOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoMansioneDaoException {
		LOG.debug("[TaifDTipoMansioneDaoImpl::findByVisibleOrdin] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tipo.ID_TIPO_MANSIONE as id, tipo.TIPO_MANSIONE as tipo, tipo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_MANSIONE tipo");

		sql.append(" WHERE ");

		sql.append("tipo.mtd_flg_visibile=:visibile and tipo.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R203011115) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoMansioneByVisibleOrdinDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleOrdinRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMansioneDaoImpl::findByVisibleOrdin] ERROR esecuzione query", ex);
			throw new TaifDTipoMansioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMansioneDaoImpl", "findByVisibleOrdin", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMansioneDaoImpl::findByVisibleOrdin] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTipoMansione con Qdef
		 * @generated
		 */

	public List<TaifDTipoMansioneByTipoMansioneDto> findByTipoMansione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.MansioneFilter input) throws TaifDTipoMansioneDaoException {
		LOG.debug("[TaifDTipoMansioneDaoImpl::findByTipoMansione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipo.ID_TIPO_MANSIONE as id, tipo.TIPO_MANSIONE as tipoMansione, tipo.MTD_ORDINAMENTO as ordin, tipo.MTD_FLG_ITA_FRA as flagLang");

		sql.append(" FROM TAIF_D_TIPO_MANSIONE tipo");

		sql.append(" WHERE ");

		sql.append(
				"tipo.mtd_flg_visibile=:visibile and tipo.mtd_flg_ita_fra=:flagItaFr and tipo.tipo_mansione=:tipoMansione");
		/*PROTECTED REGION ID(R-1832152619) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("tipoMansione", input.getTipoMansione());

		/*PROTECTED REGION END*/

		List<TaifDTipoMansioneByTipoMansioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoMansioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMansioneDaoImpl::findByTipoMansione] ERROR esecuzione query", ex);
			throw new TaifDTipoMansioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMansioneDaoImpl", "findByTipoMansione", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMansioneDaoImpl::findByTipoMansione] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdTipoMansione con Qdef
		 * @generated
		 */

	public List<TaifDTipoMansioneByIdTipoMansioneDto> findByIdTipoMansione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.MansioneFilter input) throws TaifDTipoMansioneDaoException {
		LOG.debug("[TaifDTipoMansioneDaoImpl::findByIdTipoMansione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipo.ID_TIPO_MANSIONE as id, tipo.TIPO_MANSIONE as tipoMansione, tipo.MTD_ORDINAMENTO as ordin, tipo.MTD_FLG_ITA_FRA as flagLang");

		sql.append(" FROM TAIF_D_TIPO_MANSIONE tipo");

		sql.append(" WHERE ");

		sql.append(
				"tipo.mtd_flg_visibile=:visibile and tipo.mtd_flg_ita_fra=:flagItaFr and tipo.id_tipo_mansione=:idTipoMansione");
		/*PROTECTED REGION ID(R-931183558) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("idTipoMansione", input.getIdMansione());

		/*PROTECTED REGION END*/

		List<TaifDTipoMansioneByIdTipoMansioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdTipoMansioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMansioneDaoImpl::findByIdTipoMansione] ERROR esecuzione query", ex);
			throw new TaifDTipoMansioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMansioneDaoImpl", "findByIdTipoMansione", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoMansioneDaoImpl::findByIdTipoMansione] END");
		}
		return list;
	}

}
