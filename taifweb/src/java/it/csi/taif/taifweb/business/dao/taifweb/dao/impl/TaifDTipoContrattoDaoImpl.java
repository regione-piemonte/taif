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

/*PROTECTED REGION ID(R965796663) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoContratto.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibleOrdin (datagen::CustomFinder)
 *   - byTipoContratto (datagen::CustomFinder)
 *   - byIdContratto (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoContrattoDaoImpl extends AbstractDAO implements TaifDTipoContrattoDao {
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
	 * Metodo di inserimento del DAO taifDTipoContratto. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoContrattoPk
	 * @generated
	 */

	public TaifDTipoContrattoPk insert(TaifDTipoContrattoDto dto)

	{
		LOG.debug("[TaifDTipoContrattoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_CONTRATTO,TIPO_CONTRATTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TIPO_CONTRATTO , :TIPO_CONTRATTO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_CONTRATTO]
		params.addValue("TIPO_CONTRATTO", dto.getTipoContratto(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoContratto(newKey);
		LOG.debug("[TaifDTipoContrattoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TIPO_CONTRATTO table.
	 * @generated
	 */
	public void update(TaifDTipoContrattoDto dto) throws TaifDTipoContrattoDaoException {
		LOG.debug("[TaifDTipoContrattoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPO_CONTRATTO = :TIPO_CONTRATTO ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE ,MTD_FLG_ITA_FRA = :MTD_FLG_ITA_FRA  WHERE ID_TIPO_CONTRATTO = :ID_TIPO_CONTRATTO ";

		if (dto.getIdTipoContratto() == null) {
			LOG.error("[TaifDTipoContrattoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTipoContrattoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", dto.getIdTipoContratto(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_CONTRATTO]
		params.addValue("TIPO_CONTRATTO", dto.getTipoContratto(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoContrattoDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_CONTRATTO table.
	 * @generated
	 */

	public void delete(TaifDTipoContrattoPk pk) throws TaifDTipoContrattoDaoException {
		LOG.debug("[TaifDTipoContrattoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_CONTRATTO = :ID_TIPO_CONTRATTO ";

		if (pk == null) {
			LOG.error("[TaifDTipoContrattoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoContrattoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", pk.getIdTipoContratto(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoContrattoDaoImpl::delete] END");
	}

	protected TaifDTipoContrattoDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoContrattoDaoRowMapper(null,
			TaifDTipoContrattoDto.class, this);

	protected TaifDTipoContrattoDaoRowMapper findAllRowMapper = new TaifDTipoContrattoDaoRowMapper(null,
			TaifDTipoContrattoDto.class, this);

	protected TaifDTipoContrattoDaoRowMapper byVisibleOrdinRowMapper = new TaifDTipoContrattoDaoRowMapper(null,
			TaifDTipoContrattoByVisibleOrdinDto.class, this);

	protected TaifDTipoContrattoDaoRowMapper byTipoContrattoRowMapper = new TaifDTipoContrattoDaoRowMapper(null,
			TaifDTipoContrattoByTipoContrattoDto.class, this);

	protected TaifDTipoContrattoDaoRowMapper byIdContrattoRowMapper = new TaifDTipoContrattoDaoRowMapper(null,
			TaifDTipoContrattoByIdContrattoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_CONTRATTO";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_CONTRATTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoContrattoDto findByPrimaryKey(TaifDTipoContrattoPk pk) throws TaifDTipoContrattoDaoException {
		LOG.debug("[TaifDTipoContrattoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_CONTRATTO,TIPO_CONTRATTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TIPO_CONTRATTO = :ID_TIPO_CONTRATTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CONTRATTO]
		params.addValue("ID_TIPO_CONTRATTO", pk.getIdTipoContratto(), java.sql.Types.INTEGER);

		List<TaifDTipoContrattoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoContrattoDto res = (TaifDTipoContrattoDto) cache.get(pk);
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
			LOG.error("[TaifDTipoContrattoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoContrattoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoContrattoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_CONTRATTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoContrattoDto> findAll() throws TaifDTipoContrattoDaoException {
		LOG.debug("[TaifDTipoContrattoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_CONTRATTO,TIPO_CONTRATTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoContrattoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoContrattoDto> res = (List<TaifDTipoContrattoDto>) cache
					.get("findAll_taifDTipoContratto_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoContratto_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoContrattoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoContrattoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoContrattoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibleOrdin con Qdef
		 * @generated
		 */

	public List<TaifDTipoContrattoByVisibleOrdinDto> findByVisibleOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoContrattoDaoException {
		LOG.debug("[TaifDTipoContrattoDaoImpl::findByVisibleOrdin] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT tipo.ID_TIPO_CONTRATTO as id, tipo.TIPO_CONTRATTO as tipo, tipo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_CONTRATTO tipo");

		sql.append(" WHERE ");

		sql.append("tipo.mtd_flg_visibile=:visibile and tipo.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R1314806727) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoContrattoByVisibleOrdinDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleOrdinRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoContrattoDaoImpl::findByVisibleOrdin] ERROR esecuzione query", ex);
			throw new TaifDTipoContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoContrattoDaoImpl", "findByVisibleOrdin", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoContrattoDaoImpl::findByVisibleOrdin] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTipoContratto con Qdef
		 * @generated
		 */

	public List<TaifDTipoContrattoByTipoContrattoDto> findByTipoContratto(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ContrattoFilter input)
			throws TaifDTipoContrattoDaoException {
		LOG.debug("[TaifDTipoContrattoDaoImpl::findByTipoContratto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipo.ID_TIPO_CONTRATTO as id, tipo.TIPO_CONTRATTO as tipoContratto, tipo.MTD_ORDINAMENTO as ordin, tipo.MTD_FLG_ITA_FRA as flaglang");

		sql.append(" FROM TAIF_D_TIPO_CONTRATTO tipo");

		sql.append(" WHERE ");

		sql.append(
				"tipo.mtd_flg_visibile=:visibile and tipo.mtd_flg_ita_fra=:flagItaFr and tipo.tipo_contratto=:tipoContratto");
		/*PROTECTED REGION ID(R-1705208357) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("tipoContratto", input.getTipoContratto());

		/*PROTECTED REGION END*/

		List<TaifDTipoContrattoByTipoContrattoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoContrattoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoContrattoDaoImpl::findByTipoContratto] ERROR esecuzione query", ex);
			throw new TaifDTipoContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoContrattoDaoImpl", "findByTipoContratto", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoContrattoDaoImpl::findByTipoContratto] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdContratto con Qdef
		 * @generated
		 */

	public List<TaifDTipoContrattoByIdContrattoDto> findByIdContratto(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ContrattoFilter input)
			throws TaifDTipoContrattoDaoException {
		LOG.debug("[TaifDTipoContrattoDaoImpl::findByIdContratto] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipo.ID_TIPO_CONTRATTO as id, tipo.TIPO_CONTRATTO as tipoContratto, tipo.MTD_ORDINAMENTO as ordin, tipo.MTD_FLG_ITA_FRA as flaglang");

		sql.append(" FROM TAIF_D_TIPO_CONTRATTO tipo");

		sql.append(" WHERE ");

		sql.append(
				"tipo.mtd_flg_visibile=:visibile and tipo.mtd_flg_ita_fra=:flagItaFr and tipo.id_tipo_contratto=:idContratto");
		/*PROTECTED REGION ID(R1983899330) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("idContratto", input.getIdContratto());

		/*PROTECTED REGION END*/

		List<TaifDTipoContrattoByIdContrattoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdContrattoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoContrattoDaoImpl::findByIdContratto] ERROR esecuzione query", ex);
			throw new TaifDTipoContrattoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoContrattoDaoImpl", "findByIdContratto", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoContrattoDaoImpl::findByIdContratto] END");
		}
		return list;
	}

}
