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

/*PROTECTED REGION ID(R2078721289) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoMezzo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibileCategoria (datagen::CustomFinder)
 *   - byVisibileOrdin (datagen::CustomFinder)
 *   - byTipoMezzo (datagen::CustomFinder)
 *   - byCategoriaMezzo (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoMezzoDaoImpl extends AbstractDAO implements TaifDTipoMezzoDao {
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
	 * Metodo di inserimento del DAO taifDTipoMezzo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoMezzoPk
	 * @generated
	 */

	public TaifDTipoMezzoPk insert(TaifDTipoMezzoDto dto)

	{
		LOG.debug("[TaifDTipoMezzoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_TIPO_MEZZO,FK_CATEGORIA_MEZZO,TIPO_MEZZO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_TIPO_MEZZO , :FK_CATEGORIA_MEZZO , :TIPO_MEZZO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MEZZO]
		params.addValue("ID_TIPO_MEZZO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_CATEGORIA_MEZZO]
		params.addValue("FK_CATEGORIA_MEZZO", dto.getFkCategoriaMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [TIPO_MEZZO]
		params.addValue("TIPO_MEZZO", dto.getTipoMezzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdTipoMezzo(newKey);
		LOG.debug("[TaifDTipoMezzoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_MEZZO table.
	 * @generated
	 */

	public void delete(TaifDTipoMezzoPk pk) throws TaifDTipoMezzoDaoException {
		LOG.debug("[TaifDTipoMezzoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_TIPO_MEZZO = :ID_TIPO_MEZZO ";

		if (pk == null) {
			LOG.error("[TaifDTipoMezzoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDTipoMezzoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MEZZO]
		params.addValue("ID_TIPO_MEZZO", pk.getIdTipoMezzo(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDTipoMezzoDaoImpl::delete] END");
	}

	protected TaifDTipoMezzoDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoMezzoDaoRowMapper(null,
			TaifDTipoMezzoDto.class, this);

	protected TaifDTipoMezzoDaoRowMapper findAllRowMapper = new TaifDTipoMezzoDaoRowMapper(null,
			TaifDTipoMezzoDto.class, this);

	protected TaifDTipoMezzoDaoRowMapper byVisibileCategoriaRowMapper = new TaifDTipoMezzoDaoRowMapper(null,
			TaifDTipoMezzoByVisibileCategoriaDto.class, this);

	protected TaifDTipoMezzoDaoRowMapper byVisibileOrdinRowMapper = new TaifDTipoMezzoDaoRowMapper(null,
			TaifDTipoMezzoByVisibileOrdinDto.class, this);

	protected TaifDTipoMezzoDaoRowMapper byTipoMezzoRowMapper = new TaifDTipoMezzoDaoRowMapper(null,
			TaifDTipoMezzoByTipoMezzoDto.class, this);

	protected TaifDTipoMezzoDaoRowMapper byCategoriaMezzoRowMapper = new TaifDTipoMezzoDaoRowMapper(null,
			TaifDTipoMezzoByCategoriaMezzoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_MEZZO";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_MEZZO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoMezzoDto findByPrimaryKey(TaifDTipoMezzoPk pk) throws TaifDTipoMezzoDaoException {
		LOG.debug("[TaifDTipoMezzoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_MEZZO,FK_CATEGORIA_MEZZO,TIPO_MEZZO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_TIPO_MEZZO = :ID_TIPO_MEZZO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MEZZO]
		params.addValue("ID_TIPO_MEZZO", pk.getIdTipoMezzo(), java.sql.Types.INTEGER);

		List<TaifDTipoMezzoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoMezzoDto res = (TaifDTipoMezzoDto) cache.get(pk);
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
			LOG.error("[TaifDTipoMezzoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMezzoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMezzoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_MEZZO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoMezzoDto> findAll() throws TaifDTipoMezzoDaoException {
		LOG.debug("[TaifDTipoMezzoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_MEZZO,FK_CATEGORIA_MEZZO,TIPO_MEZZO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoMezzoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoMezzoDto> res = (List<TaifDTipoMezzoDto>) cache.get("findAll_taifDTipoMezzo_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoMezzo_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMezzoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMezzoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMezzoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibileCategoria con Qdef
		 * @generated
		 */

	public List<TaifDTipoMezzoByVisibileCategoriaDto> findByVisibileCategoria(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifDTipoMezzoDaoException {
		LOG.debug("[TaifDTipoMezzoDaoImpl::findByVisibileCategoria] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT mezzo.ID_TIPO_MEZZO as id, mezzo.FK_CATEGORIA_MEZZO as idCategoria, mezzo.TIPO_MEZZO as tipo, mezzo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_MEZZO mezzo, TAIF_D_CATEGORIA_MEZZO categoria");

		sql.append(" WHERE ");

		sql.append("mezzo.FK_CATEGORIA_MEZZO = categoria.ID_CATEGORIA_MEZZO");

		sql.append(" AND ");

		sql.append(
				"mezzo.mtd_flg_visibile=:visibile and mezzo.mtd_flg_ita_fra=:flagItaFr and categoria.id_categoria_mezzo=:categoria");
		/*PROTECTED REGION ID(R368864706) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("categoria", input.getIdCategoriaMezzo());

		sql.append(" ORDER BY mezzo.MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoMezzoByVisibileCategoriaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileCategoriaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMezzoDaoImpl::findByVisibileCategoria] ERROR esecuzione query", ex);
			throw new TaifDTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMezzoDaoImpl", "findByVisibileCategoria", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoMezzoDaoImpl::findByVisibileCategoria] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibileOrdin con Qdef
		 * @generated
		 */

	public List<TaifDTipoMezzoByVisibileOrdinDto> findByVisibileOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoMezzoDaoException {
		LOG.debug("[TaifDTipoMezzoDaoImpl::findByVisibileOrdin] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT mezzo.ID_TIPO_MEZZO as id, mezzo.FK_CATEGORIA_MEZZO as idCategoria, mezzo.TIPO_MEZZO as tipo, mezzo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_MEZZO mezzo");

		sql.append(" WHERE ");

		sql.append("mezzo.mtd_flg_visibile=:visibile and mezzo.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R766843279) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoMezzoByVisibileOrdinDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileOrdinRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMezzoDaoImpl::findByVisibileOrdin] ERROR esecuzione query", ex);
			throw new TaifDTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMezzoDaoImpl", "findByVisibileOrdin", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMezzoDaoImpl::findByVisibileOrdin] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byTipoMezzo con Qdef
		 * @generated
		 */

	public List<TaifDTipoMezzoByTipoMezzoDto> findByTipoMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifDTipoMezzoDaoException {
		LOG.debug("[TaifDTipoMezzoDaoImpl::findByTipoMezzo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT mezzo.ID_TIPO_MEZZO as id, mezzo.FK_CATEGORIA_MEZZO as idCategoria, mezzo.TIPO_MEZZO as tipo, mezzo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_MEZZO mezzo");

		sql.append(" WHERE ");

		sql.append("mezzo.mtd_flg_visibile=:visibile and mezzo.mtd_flg_ita_fra=:flagItaFr and mezzo.tipo_mezzo=:tipo");
		/*PROTECTED REGION ID(R146218761) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("tipo", input.getTipoMezzo());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoMezzoByTipoMezzoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byTipoMezzoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMezzoDaoImpl::findByTipoMezzo] ERROR esecuzione query", ex);
			throw new TaifDTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMezzoDaoImpl", "findByTipoMezzo", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMezzoDaoImpl::findByTipoMezzo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCategoriaMezzo con Qdef
		 * @generated
		 */

	public List<TaifDTipoMezzoByCategoriaMezzoDto> findByCategoriaMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input) throws TaifDTipoMezzoDaoException {
		LOG.debug("[TaifDTipoMezzoDaoImpl::findByCategoriaMezzo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT tipoMezzo.ID_TIPO_MEZZO as id, tipoMezzo.FK_CATEGORIA_MEZZO as idCategoria, tipoMezzo.TIPO_MEZZO as tipo, tipoMezzo.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_TIPO_MEZZO tipoMezzo, TAIF_D_CATEGORIA_MEZZO categoriaMezzo");

		sql.append(" WHERE ");

		sql.append("tipoMezzo.FK_CATEGORIA_MEZZO = categoriaMezzo.ID_CATEGORIA_MEZZO");

		sql.append(" AND ");

		sql.append(
				"categoriaMezzo.mtd_flg_visibile=:visibile and categoriaMezzo.mtd_flg_ita_fra=:flagItaFr and categoriaMezzo.categoria_mezzo=:categoriaMezzo and tipoMezzo.mtd_flg_visibile=:idVisibile and tipoMezzo.mtd_flg_ita_fra=:flagItaFr ");
		/*PROTECTED REGION ID(R-934271872) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("categoriaMezzo", input.getCategoriaMezzo());
		paramMap.addValue("idVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifDTipoMezzoByCategoriaMezzoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCategoriaMezzoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoMezzoDaoImpl::findByCategoriaMezzo] ERROR esecuzione query", ex);
			throw new TaifDTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoMezzoDaoImpl", "findByCategoriaMezzo", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoMezzoDaoImpl::findByCategoriaMezzo] END");
		}
		return list;
	}

}
