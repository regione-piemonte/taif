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

/*PROTECTED REGION ID(R-1842544559) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDCategoriaMezzo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byVisibileOrdin (datagen::CustomFinder)
 *   - byCategoriaMezzo (datagen::CustomFinder)
 *   - byIdCategoriaMezzo (datagen::CustomFinder)
 *   - byIdTipoMezzo (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDCategoriaMezzoDaoImpl extends AbstractDAO implements TaifDCategoriaMezzoDao {
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
	 * Metodo di inserimento del DAO taifDCategoriaMezzo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDCategoriaMezzoPk
	 * @generated
	 */

	public TaifDCategoriaMezzoPk insert(TaifDCategoriaMezzoDto dto)

	{
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CATEGORIA_MEZZO,CATEGORIA_MEZZO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA ) VALUES (  :ID_CATEGORIA_MEZZO , :CATEGORIA_MEZZO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA_MEZZO]
		params.addValue("ID_CATEGORIA_MEZZO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CATEGORIA_MEZZO]
		params.addValue("CATEGORIA_MEZZO", dto.getCategoriaMezzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdCategoriaMezzo(newKey);
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_D_CATEGORIA_MEZZO table.
	 * @generated
	 */
	public void update(TaifDCategoriaMezzoDto dto) throws TaifDCategoriaMezzoDaoException {
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET CATEGORIA_MEZZO = :CATEGORIA_MEZZO ,MTD_ORDINAMENTO = :MTD_ORDINAMENTO ,MTD_FLG_VISIBILE = :MTD_FLG_VISIBILE ,MTD_FLG_ITA_FRA = :MTD_FLG_ITA_FRA  WHERE ID_CATEGORIA_MEZZO = :ID_CATEGORIA_MEZZO ";

		if (dto.getIdCategoriaMezzo() == null) {
			LOG.error("[TaifDCategoriaMezzoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifDCategoriaMezzoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA_MEZZO]
		params.addValue("ID_CATEGORIA_MEZZO", dto.getIdCategoriaMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CATEGORIA_MEZZO]
		params.addValue("CATEGORIA_MEZZO", dto.getCategoriaMezzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_D_CATEGORIA_MEZZO table.
	 * @generated
	 */

	public void delete(TaifDCategoriaMezzoPk pk) throws TaifDCategoriaMezzoDaoException {
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_CATEGORIA_MEZZO = :ID_CATEGORIA_MEZZO ";

		if (pk == null) {
			LOG.error("[TaifDCategoriaMezzoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifDCategoriaMezzoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA_MEZZO]
		params.addValue("ID_CATEGORIA_MEZZO", pk.getIdCategoriaMezzo(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::delete] END");
	}

	protected TaifDCategoriaMezzoDaoRowMapper findByPrimaryKeyRowMapper = new TaifDCategoriaMezzoDaoRowMapper(null,
			TaifDCategoriaMezzoDto.class, this);

	protected TaifDCategoriaMezzoDaoRowMapper findAllRowMapper = new TaifDCategoriaMezzoDaoRowMapper(null,
			TaifDCategoriaMezzoDto.class, this);

	protected TaifDCategoriaMezzoDaoRowMapper byVisibileOrdinRowMapper = new TaifDCategoriaMezzoDaoRowMapper(null,
			TaifDCategoriaMezzoByVisibileOrdinDto.class, this);

	protected TaifDCategoriaMezzoDaoRowMapper byCategoriaMezzoRowMapper = new TaifDCategoriaMezzoDaoRowMapper(null,
			TaifDCategoriaMezzoByCategoriaMezzoDto.class, this);

	protected TaifDCategoriaMezzoDaoRowMapper byIdCategoriaMezzoRowMapper = new TaifDCategoriaMezzoDaoRowMapper(null,
			TaifDCategoriaMezzoByIdCategoriaMezzoDto.class, this);

	protected TaifDCategoriaMezzoDaoRowMapper byIdTipoMezzoRowMapper = new TaifDCategoriaMezzoDaoRowMapper(null,
			TaifDCategoriaMezzoByIdTipoMezzoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_CATEGORIA_MEZZO";
	}

	/** 
	 * Returns all rows from the TAIF_D_CATEGORIA_MEZZO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDCategoriaMezzoDto findByPrimaryKey(TaifDCategoriaMezzoPk pk) throws TaifDCategoriaMezzoDaoException {
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CATEGORIA_MEZZO,CATEGORIA_MEZZO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName() + " WHERE ID_CATEGORIA_MEZZO = :ID_CATEGORIA_MEZZO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CATEGORIA_MEZZO]
		params.addValue("ID_CATEGORIA_MEZZO", pk.getIdCategoriaMezzo(), java.sql.Types.INTEGER);

		List<TaifDCategoriaMezzoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaMezzoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDCategoriaMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaMezzoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_CATEGORIA_MEZZO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDCategoriaMezzoDto> findAll() throws TaifDCategoriaMezzoDaoException {
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CATEGORIA_MEZZO,CATEGORIA_MEZZO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA FROM "
						+ getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDCategoriaMezzoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaMezzoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDCategoriaMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaMezzoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDCategoriaMezzoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byVisibileOrdin con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaMezzoByVisibileOrdinDto> findByVisibileOrdin(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDCategoriaMezzoDaoException {
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByVisibileOrdin] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT categ.ID_CATEGORIA_MEZZO as id, categ.CATEGORIA_MEZZO as cat, categ.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_CATEGORIA_MEZZO categ");

		sql.append(" WHERE ");

		sql.append("categ.mtd_flg_visibile=:visibile and categ.mtd_flg_ita_fra=:flagItaFr");
		/*PROTECTED REGION ID(R1083010458) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDCategoriaMezzoByVisibileOrdinDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byVisibileOrdinRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaMezzoDaoImpl::findByVisibileOrdin] ERROR esecuzione query", ex);
			throw new TaifDCategoriaMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaMezzoDaoImpl", "findByVisibileOrdin", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByVisibileOrdin] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCategoriaMezzo con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaMezzoByCategoriaMezzoDto> findByCategoriaMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CategoriaMezzoFilter input)
			throws TaifDCategoriaMezzoDaoException {
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByCategoriaMezzo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT categ.ID_CATEGORIA_MEZZO as id, categ.CATEGORIA_MEZZO as cat, categ.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_CATEGORIA_MEZZO categ");

		sql.append(" WHERE ");

		sql.append(
				"categ.mtd_flg_visibile=:visibile and categ.mtd_flg_ita_fra=:flagItaFr and categ.categoria_mezzo=:categoriaMezzo");
		/*PROTECTED REGION ID(R276976085) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("categoriaMezzo", input.getCategoriaMezzo());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDCategoriaMezzoByCategoriaMezzoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCategoriaMezzoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaMezzoDaoImpl::findByCategoriaMezzo] ERROR esecuzione query", ex);
			throw new TaifDCategoriaMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaMezzoDaoImpl", "findByCategoriaMezzo", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByCategoriaMezzo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdCategoriaMezzo con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaMezzoByIdCategoriaMezzoDto> findByIdCategoriaMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CategoriaMezzoFilter input)
			throws TaifDCategoriaMezzoDaoException {
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByIdCategoriaMezzo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT categ.ID_CATEGORIA_MEZZO as id, categ.CATEGORIA_MEZZO as cat, categ.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_D_CATEGORIA_MEZZO categ");

		sql.append(" WHERE ");

		sql.append(
				"categ.mtd_flg_visibile=:visibile and categ.mtd_flg_ita_fra=:flagItaFr and categ.id_categoria_mezzo=:idCategoriaMezzo");
		/*PROTECTED REGION ID(R-860233606) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("idCategoriaMezzo", input.getIdCategoriaMezzo());

		/*PROTECTED REGION END*/

		List<TaifDCategoriaMezzoByIdCategoriaMezzoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdCategoriaMezzoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaMezzoDaoImpl::findByIdCategoriaMezzo] ERROR esecuzione query", ex);
			throw new TaifDCategoriaMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaMezzoDaoImpl", "findByIdCategoriaMezzo", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByIdCategoriaMezzo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdTipoMezzo con Qdef
		 * @generated
		 */

	public List<TaifDCategoriaMezzoByIdTipoMezzoDto> findByIdTipoMezzo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoMezzoFilter input)
			throws TaifDCategoriaMezzoDaoException {
		LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByIdTipoMezzo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT categoriaMezzoTab.ID_CATEGORIA_MEZZO as id, categoriaMezzoTab.CATEGORIA_MEZZO as cat, categoriaMezzoTab.MTD_ORDINAMENTO as ordin, categoriaMezzoTab.ID_CATEGORIA_MEZZO as idCategoriaMezzo, tipoMezzoTab.TIPO_MEZZO as tipoMezzo");

		sql.append(" FROM TAIF_D_CATEGORIA_MEZZO categoriaMezzoTab, TAIF_D_TIPO_MEZZO tipoMezzoTab");

		sql.append(" WHERE ");

		sql.append("tipoMezzoTab.FK_CATEGORIA_MEZZO = categoriaMezzoTab.ID_CATEGORIA_MEZZO");

		sql.append(" AND ");

		sql.append(
				"categoriaMezzoTab.mtd_flg_visibile=:visibile and categoriaMezzoTab.mtd_flg_ita_fra=:flagItaFr and tipoMezzoTab.id_tipo_mezzo=:idTipoMezzo");
		/*PROTECTED REGION ID(R-1563275569) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFr", input.getFlagItaFr());
		paramMap.addValue("idTipoMezzo", input.getIdTipoMezzo());

		/*PROTECTED REGION END*/

		List<TaifDCategoriaMezzoByIdTipoMezzoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdTipoMezzoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDCategoriaMezzoDaoImpl::findByIdTipoMezzo] ERROR esecuzione query", ex);
			throw new TaifDCategoriaMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDCategoriaMezzoDaoImpl", "findByIdTipoMezzo", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDCategoriaMezzoDaoImpl::findByIdTipoMezzo] END");
		}
		return list;
	}

}
