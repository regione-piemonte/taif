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

/*PROTECTED REGION ID(R-460009583) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifCnfTipoMail.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byStatoPratica (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifCnfTipoMailDaoImpl extends AbstractDAO implements TaifCnfTipoMailDao {
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

	protected TaifCnfTipoMailDaoRowMapper findByPrimaryKeyRowMapper = new TaifCnfTipoMailDaoRowMapper(null,
			TaifCnfTipoMailDto.class, this);

	protected TaifCnfTipoMailDaoRowMapper byStatoPraticaRowMapper = new TaifCnfTipoMailDaoRowMapper(null,
			TaifCnfTipoMailDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_TIPO_MAIL";
	}

	/** 
	 * Returns all rows from the TAIF_CNF_TIPO_MAIL table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfTipoMailDto findByPrimaryKey(TaifCnfTipoMailPk pk) throws TaifCnfTipoMailDaoException {
		LOG.debug("[TaifCnfTipoMailDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_MAIL,FK_STATO_PRATICA,FLG_TIPO_MAIL,OGGETTO,TESTO FROM " + getTableName()
						+ " WHERE ID_TIPO_MAIL = :ID_TIPO_MAIL ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_MAIL]
		params.addValue("ID_TIPO_MAIL", pk.getIdTipoMail(), java.sql.Types.INTEGER);

		List<TaifCnfTipoMailDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifCnfTipoMailDto res = (TaifCnfTipoMailDto) cache.get(pk);
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
			LOG.error("[TaifCnfTipoMailDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifCnfTipoMailDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfTipoMailDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfTipoMailDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byStatoPratica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfTipoMailDto> findByStatoPratica(java.lang.Integer input) throws TaifCnfTipoMailDaoException {
		LOG.debug("[TaifCnfTipoMailDaoImpl::findByStatoPratica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT ID_TIPO_MAIL,FK_STATO_PRATICA,FLG_TIPO_MAIL,OGGETTO,TESTO ");
		sql.append(" FROM TAIF_CNF_TIPO_MAIL");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R2108263096) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append("FK_STATO_PRATICA = :fkStatoPratica");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R1056532786) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("fkStatoPratica", input);

		/*PROTECTED REGION END*/
		List<TaifCnfTipoMailDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byStatoPraticaRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfTipoMailDaoImpl::findByStatoPratica] esecuzione query", ex);
			throw new TaifCnfTipoMailDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfTipoMailDaoImpl", "findByStatoPratica", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfTipoMailDaoImpl::findByStatoPratica] END");
		}
		return list;
	}

}
