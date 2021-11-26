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

/*PROTECTED REGION ID(R478615039) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifRTrazTipoMezzo.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byIdTipoMezzo (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifRTrazTipoMezzoDaoImpl extends AbstractDAO implements TaifRTrazTipoMezzoDao {
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

	protected TaifRTrazTipoMezzoDaoRowMapper findByPrimaryKeyRowMapper = new TaifRTrazTipoMezzoDaoRowMapper(null,
			TaifRTrazTipoMezzoDto.class, this);

	protected TaifRTrazTipoMezzoDaoRowMapper findAllRowMapper = new TaifRTrazTipoMezzoDaoRowMapper(null,
			TaifRTrazTipoMezzoDto.class, this);

	protected TaifRTrazTipoMezzoDaoRowMapper byIdTipoMezzoRowMapper = new TaifRTrazTipoMezzoDaoRowMapper(null,
			TaifRTrazTipoMezzoByIdTipoMezzoDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_R_TRAZ_TIPOMEZZO";
	}

	/** 
	 * Returns all rows from the TAIF_R_TRAZ_TIPOMEZZO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRTrazTipoMezzoDto findByPrimaryKey(TaifRTrazTipoMezzoPk pk) throws TaifRTrazTipoMezzoDaoException {
		LOG.debug("[TaifRTrazTipoMezzoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_MEZZO,ID_TRAZIONE FROM " + getTableName()
				+ " WHERE ID_TIPO_MEZZO = :ID_TIPO_MEZZO  AND ID_TRAZIONE = :ID_TRAZIONE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MEZZO]
		params.addValue("ID_TIPO_MEZZO", pk.getIdTipoMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TRAZIONE]
		params.addValue("ID_TRAZIONE", pk.getIdTrazione(), java.sql.Types.INTEGER);

		List<TaifRTrazTipoMezzoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRTrazTipoMezzoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifRTrazTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRTrazTipoMezzoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifRTrazTipoMezzoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_TRAZ_TIPOMEZZO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRTrazTipoMezzoDto> findAll() throws TaifRTrazTipoMezzoDaoException {
		LOG.debug("[TaifRTrazTipoMezzoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_TIPO_MEZZO,ID_TRAZIONE FROM " + getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifRTrazTipoMezzoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRTrazTipoMezzoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifRTrazTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRTrazTipoMezzoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifRTrazTipoMezzoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byIdTipoMezzo con Qdef
		 * @generated
		 */

	public List<TaifRTrazTipoMezzoByIdTipoMezzoDto> findByIdTipoMezzo(java.lang.Integer input)
			throws TaifRTrazTipoMezzoDaoException {
		LOG.debug("[TaifRTrazTipoMezzoDaoImpl::findByIdTipoMezzo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT trazTipoMezzo.ID_TIPO_MEZZO as idTipoMezzo, trazTipoMezzo.ID_TRAZIONE as idTrazione");

		sql.append(" FROM TAIF_R_TRAZ_TIPOMEZZO trazTipoMezzo");

		sql.append(" WHERE ");

		sql.append("trazTipoMezzo.id_tipo_mezzo=:idTipoMezzo");
		/*PROTECTED REGION ID(R1872872361) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTipoMezzo", input);

		/*PROTECTED REGION END*/

		List<TaifRTrazTipoMezzoByIdTipoMezzoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byIdTipoMezzoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifRTrazTipoMezzoDaoImpl::findByIdTipoMezzo] ERROR esecuzione query", ex);
			throw new TaifRTrazTipoMezzoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifRTrazTipoMezzoDaoImpl", "findByIdTipoMezzo", "esecuzione query", sql.toString());
			LOG.debug("[TaifRTrazTipoMezzoDaoImpl::findByIdTipoMezzo] END");
		}
		return list;
	}

}
