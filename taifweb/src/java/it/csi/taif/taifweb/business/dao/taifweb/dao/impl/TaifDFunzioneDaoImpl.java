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

/*PROTECTED REGION ID(R563105553) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDFunzione.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibleFilter (datagen::CustomFinder)
 *   - piazzaStoccaggio (datagen::CustomFinder)
 *   - byFunzione (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDFunzioneDaoImpl extends AbstractDAO implements TaifDFunzioneDao {
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
	 * Metodo di inserimento del DAO taifDFunzione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDFunzionePk
	 * @generated
	 */

	public TaifDFunzionePk insert(TaifDFunzioneDto dto)

	{
		LOG.debug("[TaifDFunzioneDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_FUNZIONE,FK_TIPO_STRUTTURA,FUNZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_FUNZIONE , :FK_TIPO_STRUTTURA , :FUNZIONE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_FUNZIONE]
		params.addValue("ID_FUNZIONE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TIPO_STRUTTURA]
		params.addValue("FK_TIPO_STRUTTURA", dto.getFkTipoStruttura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FUNZIONE]
		params.addValue("FUNZIONE", dto.getFunzione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdFunzione(newKey);
		LOG.debug("[TaifDFunzioneDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_FUNZIONE table.
	 * @generated
	 */

	public void delete(TaifDFunzionePk pk) throws TaifDFunzioneDaoException {
		LOG.debug("[TaifDFunzioneDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_FUNZIONE = :ID_FUNZIONE ";

		if (pk == null) {
			LOG.error("[TaifDFunzioneDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDFunzioneDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_FUNZIONE]
		params.addValue("ID_FUNZIONE", pk.getIdFunzione(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDFunzioneDaoImpl::delete] END");
	}

	protected TaifDFunzioneDaoRowMapper findByPrimaryKeyRowMapper = new TaifDFunzioneDaoRowMapper(null,
			TaifDFunzioneDto.class, this);

	protected TaifDFunzioneDaoRowMapper findAllRowMapper = new TaifDFunzioneDaoRowMapper(null, TaifDFunzioneDto.class,
			this);

	protected TaifDFunzioneDaoRowMapper byVisibleFilterRowMapper = new TaifDFunzioneDaoRowMapper(null,
			TaifDFunzioneByVisibleFilterDto.class, this);

	protected TaifDFunzioneDaoRowMapper piazzaStoccaggioRowMapper = new TaifDFunzioneDaoRowMapper(null,
			TaifDFunzionePiazzaStoccaggioDto.class, this);

	protected TaifDFunzioneDaoRowMapper byFunzioneRowMapper = new TaifDFunzioneDaoRowMapper(null,
			TaifDFunzioneByFunzioneDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_FUNZIONE";
	}

	/** 
	 * Returns all rows from the TAIF_D_FUNZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDFunzioneDto findByPrimaryKey(TaifDFunzionePk pk) throws TaifDFunzioneDaoException {
		LOG.debug("[TaifDFunzioneDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_FUNZIONE,FK_TIPO_STRUTTURA,FUNZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_FUNZIONE = :ID_FUNZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_FUNZIONE]
		params.addValue("ID_FUNZIONE", pk.getIdFunzione(), java.sql.Types.INTEGER);

		List<TaifDFunzioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDFunzioneDto res = (TaifDFunzioneDto) cache.get(pk);
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
			LOG.error("[TaifDFunzioneDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDFunzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFunzioneDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFunzioneDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_FUNZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDFunzioneDto> findAll() throws TaifDFunzioneDaoException {
		LOG.debug("[TaifDFunzioneDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_FUNZIONE,FK_TIPO_STRUTTURA,FUNZIONE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDFunzioneDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDFunzioneDto> res = (List<TaifDFunzioneDto>) cache.get("findAll_taifDFunzione_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDFunzione_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDFunzioneDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDFunzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFunzioneDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFunzioneDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibleFilter con Qdef
		 * @generated
		 */

	public List<TaifDFunzioneByVisibleFilterDto> findByVisibleFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDFunzioneDaoException {
		LOG.debug("[TaifDFunzioneDaoImpl::findByVisibleFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT funzione.ID_FUNZIONE as id, funzione.FK_TIPO_STRUTTURA as idStru, funzione.FUNZIONE as funz, funzione.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_FUNZIONE funzione");

		sql.append(" WHERE ");

		sql.append(
				"funzione.mtd_flg_visibile=:visibile and funzione.mtd_flg_ita_fra=:flagItaFr and funzione.mtd_ordinamento is not null");
		/*PROTECTED REGION ID(R-619822311) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDFunzioneByVisibleFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibleFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDFunzioneDaoImpl::findByVisibleFilter] ERROR esecuzione query", ex);
			throw new TaifDFunzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFunzioneDaoImpl", "findByVisibleFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFunzioneDaoImpl::findByVisibleFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder piazzaStoccaggio con Qdef
		 * @generated
		 */

	public List<TaifDFunzionePiazzaStoccaggioDto> findPiazzaStoccaggio(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDFunzioneDaoException {
		LOG.debug("[TaifDFunzioneDaoImpl::findPiazzaStoccaggio] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT funzione.ID_FUNZIONE as id, funzione.FK_TIPO_STRUTTURA as idStru, funzione.FUNZIONE as funz, funzione.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_FUNZIONE funzione");

		sql.append(" WHERE ");

		sql.append(
				"funzione.mtd_flg_visibile=:visibile and funzione.mtd_flg_ita_fra=:flagItaFr and funzione.mtd_ordinamento is null");
		/*PROTECTED REGION ID(R812985234) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		//sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDFunzionePiazzaStoccaggioDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, piazzaStoccaggioRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDFunzioneDaoImpl::findPiazzaStoccaggio] ERROR esecuzione query", ex);
			throw new TaifDFunzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFunzioneDaoImpl", "findPiazzaStoccaggio", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFunzioneDaoImpl::findPiazzaStoccaggio] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFunzione con Qdef
		 * @generated
		 */

	public List<TaifDFunzioneByFunzioneDto> findByFunzione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.FunzioneVisibleFilter input)
			throws TaifDFunzioneDaoException {
		LOG.debug("[TaifDFunzioneDaoImpl::findByFunzione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT funzione.ID_FUNZIONE as idFunzione, funzione.FK_TIPO_STRUTTURA as idTipoStruttura, funzione.FUNZIONE as funz, funzione.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_FUNZIONE funzione");

		sql.append(" WHERE ");

		sql.append(
				"funzione.mtd_flg_visibile=:visibile and funzione.mtd_flg_ita_fra=:flagItaFr and funzione.funzione=:funzioneName");
		/*PROTECTED REGION ID(R1385415061) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("funzioneName", input.getFunzioneName());

		/*PROTECTED REGION END*/

		List<TaifDFunzioneByFunzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFunzioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDFunzioneDaoImpl::findByFunzione] ERROR esecuzione query", ex);
			throw new TaifDFunzioneDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDFunzioneDaoImpl", "findByFunzione", "esecuzione query", sql.toString());
			LOG.debug("[TaifDFunzioneDaoImpl::findByFunzione] END");
		}
		return list;
	}

}
