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

/*PROTECTED REGION ID(R-2094740985) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoInquadramento.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisible (datagen::CustomFinder)
 *   - byTipoInquadramento (datagen::CustomFinder)
 *   - byIdInquadramento (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoInquadramentoDaoImpl extends AbstractDAO implements TaifDTipoInquadramentoDao {
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
	 * Metodo di inserimento del DAO taifDTipoInquadramento. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoInquadramentoPk
	 * @generated
	 */

	public TaifDTipoInquadramentoPk insert(TaifDTipoInquadramentoDto dto)

	{
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_INQUADRAMENTO,TIPO_INQUADRAMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_TIPO_INQUADRAMENTO , :TIPO_INQUADRAMENTO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_INQUADRAMENTO]
		params.addValue("ID_TIPO_INQUADRAMENTO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_INQUADRAMENTO]
		params.addValue("TIPO_INQUADRAMENTO", dto.getTipoInquadramento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoInquadramento(newKey);
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TIPO_INQUADRAMENTO table.
	 * @generated
	 */
	public void update(TaifDTipoInquadramentoDto dto) throws TaifDTipoInquadramentoDaoException {
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPO_INQUADRAMENTO = :TIPO_INQUADRAMENTO ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE  WHERE ID_TIPO_INQUADRAMENTO = :ID_TIPO_INQUADRAMENTO ";

		if (dto.getIdTipoInquadramento() == null) {
			LOG.error("[TaifDTipoInquadramentoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTipoInquadramentoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_INQUADRAMENTO]
		params.addValue("ID_TIPO_INQUADRAMENTO", dto.getIdTipoInquadramento(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_INQUADRAMENTO]
		params.addValue("TIPO_INQUADRAMENTO", dto.getTipoInquadramento(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_INQUADRAMENTO table.
	 * @generated
	 */

	public void delete(TaifDTipoInquadramentoPk pk) throws TaifDTipoInquadramentoDaoException {
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_INQUADRAMENTO = :ID_TIPO_INQUADRAMENTO ";

		if (pk == null) {
			LOG.error("[TaifDTipoInquadramentoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoInquadramentoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_INQUADRAMENTO]
		params.addValue("ID_TIPO_INQUADRAMENTO", pk.getIdTipoInquadramento(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::delete] END");
	}

	protected TaifDTipoInquadramentoDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoInquadramentoDaoRowMapper(
			null, TaifDTipoInquadramentoDto.class, this);

	protected TaifDTipoInquadramentoDaoRowMapper findAllRowMapper = new TaifDTipoInquadramentoDaoRowMapper(null,
			TaifDTipoInquadramentoDto.class, this);

	protected TaifDTipoInquadramentoDaoRowMapper byVisibleRowMapper = new TaifDTipoInquadramentoDaoRowMapper(null,
			TaifDTipoInquadramentoByVisibleDto.class, this);

	protected TaifDTipoInquadramentoDaoRowMapper byTipoInquadramentoRowMapper = new TaifDTipoInquadramentoDaoRowMapper(
			null, TaifDTipoInquadramentoByTipoInquadramentoDto.class, this);

	protected TaifDTipoInquadramentoDaoRowMapper byIdInquadramentoRowMapper = new TaifDTipoInquadramentoDaoRowMapper(
			null, TaifDTipoInquadramentoByIdInquadramentoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_INQUADRAMENTO";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_INQUADRAMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoInquadramentoDto findByPrimaryKey(TaifDTipoInquadramentoPk pk)
			throws TaifDTipoInquadramentoDaoException {
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_INQUADRAMENTO,TIPO_INQUADRAMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
						+ getTableName() + " WHERE ID_TIPO_INQUADRAMENTO = :ID_TIPO_INQUADRAMENTO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_INQUADRAMENTO]
		params.addValue("ID_TIPO_INQUADRAMENTO", pk.getIdTipoInquadramento(), java.sql.Types.INTEGER);

		List<TaifDTipoInquadramentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoInquadramentoDto res = (TaifDTipoInquadramentoDto) cache.get(pk);
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
			LOG.error("[TaifDTipoInquadramentoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoInquadramentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoInquadramentoDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoInquadramentoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_INQUADRAMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoInquadramentoDto> findAll() throws TaifDTipoInquadramentoDaoException {
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_INQUADRAMENTO,TIPO_INQUADRAMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoInquadramentoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoInquadramentoDto> res = (List<TaifDTipoInquadramentoDto>) cache
					.get("findAll_taifDTipoInquadramento_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoInquadramento_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoInquadramentoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoInquadramentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoInquadramentoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoInquadramentoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoInquadramentoByVisibleDto> findByVisible(java.lang.Integer input)
			throws TaifDTipoInquadramentoDaoException {
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::findByVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipo.ID_TIPO_INQUADRAMENTO as id, tipo.TIPO_INQUADRAMENTO as tipo, tipo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_INQUADRAMENTO tipo");

		sql.append(" WHERE ");

		sql.append("tipo.mtd_flg_visibile=:visibile ");
		/*PROTECTED REGION ID(R-984643173) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input);

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoInquadramentoByVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoInquadramentoDaoImpl::findByVisible] ERROR esecuzione query", ex);
			throw new TaifDTipoInquadramentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoInquadramentoDaoImpl", "findByVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoInquadramentoDaoImpl::findByVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTipoInquadramento con Qdef
		 * @generated
		 */

	public List<TaifDTipoInquadramentoByTipoInquadramentoDto> findByTipoInquadramento(
			it.csi.taif.taifweb.business.dao.taifweb.filter.InquadramentoFilter input)
			throws TaifDTipoInquadramentoDaoException {
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::findByTipoInquadramento] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipo.ID_TIPO_INQUADRAMENTO as id, tipo.TIPO_INQUADRAMENTO as tipoInquadramento, tipo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_INQUADRAMENTO tipo");

		sql.append(" WHERE ");

		sql.append("tipo.mtd_flg_visibile=:visibile and tipo.tipo_inquadramento=:tipoInquadramento");
		/*PROTECTED REGION ID(R134291467) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("tipoInquadramento", input.getTipoInquadramento());

		/*PROTECTED REGION END*/

		List<TaifDTipoInquadramentoByTipoInquadramentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoInquadramentoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoInquadramentoDaoImpl::findByTipoInquadramento] ERROR esecuzione query", ex);
			throw new TaifDTipoInquadramentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoInquadramentoDaoImpl", "findByTipoInquadramento", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoInquadramentoDaoImpl::findByTipoInquadramento] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdInquadramento con Qdef
		 * @generated
		 */

	public List<TaifDTipoInquadramentoByIdInquadramentoDto> findByIdInquadramento(
			it.csi.taif.taifweb.business.dao.taifweb.filter.InquadramentoFilter input)
			throws TaifDTipoInquadramentoDaoException {
		LOG.debug("[TaifDTipoInquadramentoDaoImpl::findByIdInquadramento] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipo.ID_TIPO_INQUADRAMENTO as id, tipo.TIPO_INQUADRAMENTO as tipoInquadramento, tipo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_INQUADRAMENTO tipo");

		sql.append(" WHERE ");

		sql.append("tipo.mtd_flg_visibile=:visibile and tipo.id_tipo_inquadramento=:idInquadramento");
		/*PROTECTED REGION ID(R1285421938) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("idInquadramento", input.getIdInquadramento());

		/*PROTECTED REGION END*/

		List<TaifDTipoInquadramentoByIdInquadramentoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdInquadramentoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoInquadramentoDaoImpl::findByIdInquadramento] ERROR esecuzione query", ex);
			throw new TaifDTipoInquadramentoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoInquadramentoDaoImpl", "findByIdInquadramento", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoInquadramentoDaoImpl::findByIdInquadramento] END");
		}
		return list;
	}

}
