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

/*PROTECTED REGION ID(R1885335969) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifDTipoSedeAzienda.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifDTipoSedeAziendaDaoImpl extends AbstractDAO implements TaifDTipoSedeAziendaDao {
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

	protected TaifDTipoSedeAziendaDaoRowMapper findByPrimaryKeyRowMapper = new TaifDTipoSedeAziendaDaoRowMapper(null,
			TaifDTipoSedeAziendaDto.class, this);

	protected TaifDTipoSedeAziendaDaoRowMapper findAllRowMapper = new TaifDTipoSedeAziendaDaoRowMapper(null,
			TaifDTipoSedeAziendaDto.class, this);

	protected TaifDTipoSedeAziendaDaoRowMapper byFilterRowMapper = new TaifDTipoSedeAziendaDaoRowMapper(null,
			TaifDTipoSedeAziendaByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_D_TIPO_SEDE_AZIENDA";
	}

	/** 
	 * Returns all rows from the TAIF_D_TIPO_SEDE_AZIENDA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoSedeAziendaDto findByPrimaryKey(TaifDTipoSedeAziendaPk pk) throws TaifDTipoSedeAziendaDaoException {
		LOG.debug("[TaifDTipoSedeAziendaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_SEDE,TIPO_SEDE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName()
						+ " WHERE ID_TIPO_SEDE = :ID_TIPO_SEDE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_TIPO_SEDE]
		params.addValue("ID_TIPO_SEDE", pk.getIdTipoSede(), java.sql.Types.INTEGER);

		List<TaifDTipoSedeAziendaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifDTipoSedeAziendaDto res = (TaifDTipoSedeAziendaDto) cache.get(pk);
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
			LOG.error("[TaifDTipoSedeAziendaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifDTipoSedeAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoSedeAziendaDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifDTipoSedeAziendaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_SEDE_AZIENDA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoSedeAziendaDto> findAll() throws TaifDTipoSedeAziendaDaoException {
		LOG.debug("[TaifDTipoSedeAziendaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_TIPO_SEDE,TIPO_SEDE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifDTipoSedeAziendaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifDTipoSedeAziendaDto> res = (List<TaifDTipoSedeAziendaDto>) cache
					.get("findAll_taifDTipoSedeAzienda_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifDTipoSedeAzienda_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoSedeAziendaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifDTipoSedeAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoSedeAziendaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoSedeAziendaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifDTipoSedeAziendaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoSedeAziendaDaoException {
		LOG.debug("[TaifDTipoSedeAziendaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT sede.ID_TIPO_SEDE as id, sede.MTD_ORDINAMENTO as ordin, sede.TIPO_SEDE as tipo");

		sql.append(" FROM TAIF_D_TIPO_SEDE_AZIENDA sede");

		sql.append(" WHERE ");

		sql.append(" sede.MTD_FLG_VISIBILE=:visibile ");
		/*PROTECTED REGION ID(R38945528) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifDTipoSedeAziendaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifDTipoSedeAziendaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifDTipoSedeAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifDTipoSedeAziendaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifDTipoSedeAziendaDaoImpl::findByFilter] END");
		}
		return list;
	}

}
