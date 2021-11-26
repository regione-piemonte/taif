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

/*PROTECTED REGION ID(R-1868272879) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoCarrello.
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
public class TaifDTipoCarrelloDaoImpl extends AbstractDAO implements TaifDTipoCarrelloDao {
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
	 * Metodo di inserimento del DAO taifDTipoCarrello. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoCarrelloPk
	 * @generated
	 */

	public TaifDTipoCarrelloPk insert(TaifDTipoCarrelloDto dto)

	{
		LOG.debug("[TaifDTipoCarrelloDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_CARRELLO,TIPO_CARRELLO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE ) VALUES (  :ID_TIPO_CARRELLO , :TIPO_CARRELLO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CARRELLO]
		params.addValue("ID_TIPO_CARRELLO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_CARRELLO]
		params.addValue("TIPO_CARRELLO", dto.getTipoCarrello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoCarrello(newKey);
		LOG.debug("[TaifDTipoCarrelloDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_TIPO_CARRELLO table.
	 * @generated
	 */
	public void update(TaifDTipoCarrelloDto dto) throws TaifDTipoCarrelloDaoException {
		LOG.debug("[TaifDTipoCarrelloDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET TIPO_CARRELLO = :TIPO_CARRELLO ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE  WHERE ID_TIPO_CARRELLO = :ID_TIPO_CARRELLO ";

		if (dto.getIdTipoCarrello() == null) {
			LOG.error("[TaifDTipoCarrelloDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDTipoCarrelloDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CARRELLO]
		params.addValue("ID_TIPO_CARRELLO", dto.getIdTipoCarrello(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_CARRELLO]
		params.addValue("TIPO_CARRELLO", dto.getTipoCarrello(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoCarrelloDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_CARRELLO table.
	 * @generated
	 */

	public void delete(TaifDTipoCarrelloPk pk) throws TaifDTipoCarrelloDaoException {
		LOG.debug("[TaifDTipoCarrelloDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_CARRELLO = :ID_TIPO_CARRELLO ";

		if (pk == null) {
			LOG.error("[TaifDTipoCarrelloDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoCarrelloDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CARRELLO]
		params.addValue("ID_TIPO_CARRELLO", pk.getIdTipoCarrello(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoCarrelloDaoImpl::delete] END");
	}

	protected TaifDTipoCarrelloDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoCarrelloDaoRowMapper(null,
			TaifDTipoCarrelloDto.class, this);

	protected TaifDTipoCarrelloDaoRowMapper findAllRowMapper = new TaifDTipoCarrelloDaoRowMapper(null,
			TaifDTipoCarrelloDto.class, this);

	protected TaifDTipoCarrelloDaoRowMapper byVisibileRowMapper = new TaifDTipoCarrelloDaoRowMapper(null,
			TaifDTipoCarrelloByVisibileDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_CARRELLO";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_CARRELLO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoCarrelloDto findByPrimaryKey(TaifDTipoCarrelloPk pk) throws TaifDTipoCarrelloDaoException {
		LOG.debug("[TaifDTipoCarrelloDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_CARRELLO,TIPO_CARRELLO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName()
						+ " WHERE ID_TIPO_CARRELLO = :ID_TIPO_CARRELLO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_CARRELLO]
		params.addValue("ID_TIPO_CARRELLO", pk.getIdTipoCarrello(), java.sql.Types.INTEGER);

		List<TaifDTipoCarrelloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoCarrelloDto res = (TaifDTipoCarrelloDto) cache.get(pk);
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
			LOG.error("[TaifDTipoCarrelloDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoCarrelloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoCarrelloDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoCarrelloDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_CARRELLO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoCarrelloDto> findAll() throws TaifDTipoCarrelloDaoException {
		LOG.debug("[TaifDTipoCarrelloDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_CARRELLO,TIPO_CARRELLO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoCarrelloDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoCarrelloDto> res = (List<TaifDTipoCarrelloDto>) cache.get("findAll_taifDTipoCarrello_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoCarrello_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoCarrelloDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoCarrelloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoCarrelloDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoCarrelloDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibile con Qdef
		 * @generated
		 */

	public List<TaifDTipoCarrelloByVisibileDto> findByVisibile(java.lang.Integer input)
			throws TaifDTipoCarrelloDaoException {
		LOG.debug("[TaifDTipoCarrelloDaoImpl::findByVisibile] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT carre.ID_TIPO_CARRELLO as id, carre.TIPO_CARRELLO as cat, carre.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_CARRELLO carre");

		sql.append(" WHERE ");

		sql.append("carre.mtd_flg_visibile=:visibile");
		/*PROTECTED REGION ID(R-1285891512) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input);

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoCarrelloByVisibileDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoCarrelloDaoImpl::findByVisibile] ERROR esecuzione query", ex);
			throw new TaifDTipoCarrelloDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoCarrelloDaoImpl", "findByVisibile", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoCarrelloDaoImpl::findByVisibile] END");
		}
		return list;
	}

}
