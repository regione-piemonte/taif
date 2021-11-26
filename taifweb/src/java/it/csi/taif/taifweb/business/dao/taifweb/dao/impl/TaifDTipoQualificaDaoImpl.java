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

/*PROTECTED REGION ID(R-1025905007) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoQualifica.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibile (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoQualificaDaoImpl extends AbstractDAO implements TaifDTipoQualificaDao {
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
	 * Metodo di inserimento del DAO taifDTipoQualifica. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoQualificaPk
	 * @generated
	 */

	public TaifDTipoQualificaPk insert(TaifDTipoQualificaDto dto)

	{
		LOG.debug("[TaifDTipoQualificaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_QUALIFICA,TIPO_QUALIFICA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TIPO_QUALIFICA , :TIPO_QUALIFICA , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_QUALIFICA]
		params.addValue("ID_TIPO_QUALIFICA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_QUALIFICA]
		params.addValue("TIPO_QUALIFICA", dto.getTipoQualifica(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoQualifica(newKey);
		LOG.debug("[TaifDTipoQualificaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TIPO_QUALIFICA table.
	 * @generated
	 */
	public void update(TaifDTipoQualificaDto dto) throws TaifDTipoQualificaDaoException {
		LOG.debug("[TaifDTipoQualificaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPO_QUALIFICA = :TIPO_QUALIFICA ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE ,MTD_FLG_ITA_FRA = :MTD_FLG_ITA_FRA  WHERE ID_TIPO_QUALIFICA = :ID_TIPO_QUALIFICA ";

		if (dto.getIdTipoQualifica() == null) {
			LOG.error("[TaifDTipoQualificaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTipoQualificaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_QUALIFICA]
		params.addValue("ID_TIPO_QUALIFICA", dto.getIdTipoQualifica(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_QUALIFICA]
		params.addValue("TIPO_QUALIFICA", dto.getTipoQualifica(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoQualificaDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_QUALIFICA table.
	 * @generated
	 */

	public void delete(TaifDTipoQualificaPk pk) throws TaifDTipoQualificaDaoException {
		LOG.debug("[TaifDTipoQualificaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_QUALIFICA = :ID_TIPO_QUALIFICA ";

		if (pk == null) {
			LOG.error("[TaifDTipoQualificaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoQualificaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_QUALIFICA]
		params.addValue("ID_TIPO_QUALIFICA", pk.getIdTipoQualifica(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoQualificaDaoImpl::delete] END");
	}

	protected TaifDTipoQualificaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoQualificaDaoRowMapper(null,
			TaifDTipoQualificaDto.class, this);

	protected TaifDTipoQualificaDaoRowMapper findAllRowMapper = new TaifDTipoQualificaDaoRowMapper(null,
			TaifDTipoQualificaDto.class, this);

	protected TaifDTipoQualificaDaoRowMapper byVisibileRowMapper = new TaifDTipoQualificaDaoRowMapper(null,
			TaifDTipoQualificaByVisibileDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_QUALIFICA";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_QUALIFICA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoQualificaDto findByPrimaryKey(TaifDTipoQualificaPk pk) throws TaifDTipoQualificaDaoException {
		LOG.debug("[TaifDTipoQualificaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_QUALIFICA,TIPO_QUALIFICA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TIPO_QUALIFICA = :ID_TIPO_QUALIFICA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_QUALIFICA]
		params.addValue("ID_TIPO_QUALIFICA", pk.getIdTipoQualifica(), java.sql.Types.INTEGER);

		List<TaifDTipoQualificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoQualificaDto res = (TaifDTipoQualificaDto) cache.get(pk);
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
			LOG.error("[TaifDTipoQualificaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoQualificaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoQualificaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_QUALIFICA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoQualificaDto> findAll() throws TaifDTipoQualificaDaoException {
		LOG.debug("[TaifDTipoQualificaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_QUALIFICA,TIPO_QUALIFICA,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoQualificaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoQualificaDto> res = (List<TaifDTipoQualificaDto>) cache
					.get("findAll_taifDTipoQualifica_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoQualifica_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoQualificaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoQualificaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoQualificaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibile con Qdef
		 * @generated
		 */

	public List<TaifDTipoQualificaByVisibileDto> findByVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoQualificaDaoException {
		LOG.debug("[TaifDTipoQualificaDaoImpl::findByVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT qualifica.ID_TIPO_QUALIFICA as id, qualifica.TIPO_QUALIFICA as tipo, qualifica.MTD_ORDINAMENTO as ordin, qualifica.MTD_FLG_ITA_FRA as itaFr");

		sql.append(" FROM TAIF_D_TIPO_QUALIFICA qualifica");

		sql.append(" WHERE ");

		sql.append("qualifica.mtd_flg_visibile=:visibile and qualifica.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R-2020702785) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoQualificaByVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoQualificaDaoImpl::findByVisibile] ERROR esecuzione query", ex);
			throw new TaifDTipoQualificaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoQualificaDaoImpl", "findByVisibile", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoQualificaDaoImpl::findByVisibile] END");
		}
		return list;
	}

}
