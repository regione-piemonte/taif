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

/*PROTECTED REGION ID(R585560151) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifCnfAttribAmmesso.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilter (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifCnfAttribAmmessoDaoImpl extends AbstractDAO implements TaifCnfAttribAmmessoDao {
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
	 * Metodo di inserimento del DAO taifCnfAttribAmmesso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifCnfAttribAmmessoPk
	 * @generated
	 */

	public TaifCnfAttribAmmessoPk insert(TaifCnfAttribAmmessoDto dto)

	{
		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	FK_TIPO_MEZZO,NOME_ATTRIB,MTD_ORDINAMENTO ) VALUES (  :FK_TIPO_MEZZO , :NOME_ATTRIB , :MTD_ORDINAMENTO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_MEZZO]
		params.addValue("FK_TIPO_MEZZO", dto.getFkTipoMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_ATTRIB]
		params.addValue("NOME_ATTRIB", dto.getNomeAttrib(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_CNF_ATTRIB_AMMESSO table.
	 * @generated
	 */
	public void update(TaifCnfAttribAmmessoDto dto) throws TaifCnfAttribAmmessoDaoException {
		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET MTD_ORDINAMENTO = :MTD_ORDINAMENTO  WHERE FK_TIPO_MEZZO = :FK_TIPO_MEZZO  AND NOME_ATTRIB = :NOME_ATTRIB ";

		if (dto.getFkTipoMezzo() == null || dto.getNomeAttrib() == null) {
			LOG.error("[TaifCnfAttribAmmessoDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifCnfAttribAmmessoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_MEZZO]
		params.addValue("FK_TIPO_MEZZO", dto.getFkTipoMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_ATTRIB]
		params.addValue("NOME_ATTRIB", dto.getNomeAttrib(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::update] END");
	}

	/** 
	 * Deletes a single row in the TAIF_CNF_ATTRIB_AMMESSO table.
	 * @generated
	 */

	public void delete(TaifCnfAttribAmmessoPk pk) throws TaifCnfAttribAmmessoDaoException {
		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE FK_TIPO_MEZZO = :FK_TIPO_MEZZO  AND NOME_ATTRIB = :NOME_ATTRIB ";

		if (pk == null) {
			LOG.error("[TaifCnfAttribAmmessoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifCnfAttribAmmessoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_MEZZO]
		params.addValue("FK_TIPO_MEZZO", pk.getFkTipoMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_ATTRIB]
		params.addValue("NOME_ATTRIB", pk.getNomeAttrib(), java.sql.Types.VARCHAR);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::delete] END");
	}

	protected TaifCnfAttribAmmessoDaoRowMapper findByPrimaryKeyRowMapper = new TaifCnfAttribAmmessoDaoRowMapper(null,
			TaifCnfAttribAmmessoDto.class, this);

	protected TaifCnfAttribAmmessoDaoRowMapper findAllRowMapper = new TaifCnfAttribAmmessoDaoRowMapper(null,
			TaifCnfAttribAmmessoDto.class, this);

	protected TaifCnfAttribAmmessoDaoRowMapper byFilterRowMapper = new TaifCnfAttribAmmessoDaoRowMapper(null,
			TaifCnfAttribAmmessoByFilterDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_ATTRIB_AMMESSO";
	}

	/** 
	 * Returns all rows from the TAIF_CNF_ATTRIB_AMMESSO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfAttribAmmessoDto findByPrimaryKey(TaifCnfAttribAmmessoPk pk) throws TaifCnfAttribAmmessoDaoException {
		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT FK_TIPO_MEZZO,NOME_ATTRIB,MTD_ORDINAMENTO FROM "
				+ getTableName() + " WHERE FK_TIPO_MEZZO = :FK_TIPO_MEZZO  AND NOME_ATTRIB = :NOME_ATTRIB ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_TIPO_MEZZO]
		params.addValue("FK_TIPO_MEZZO", pk.getFkTipoMezzo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [NOME_ATTRIB]
		params.addValue("NOME_ATTRIB", pk.getNomeAttrib(), java.sql.Types.VARCHAR);

		List<TaifCnfAttribAmmessoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifCnfAttribAmmessoDto res = (TaifCnfAttribAmmessoDto) cache.get(pk);
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
			LOG.error("[TaifCnfAttribAmmessoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifCnfAttribAmmessoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfAttribAmmessoDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifCnfAttribAmmessoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_ATTRIB_AMMESSO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfAttribAmmessoDto> findAll() throws TaifCnfAttribAmmessoDaoException {
		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT FK_TIPO_MEZZO,NOME_ATTRIB,MTD_ORDINAMENTO FROM " + getTableName());

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifCnfAttribAmmessoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifCnfAttribAmmessoDto> res = (List<TaifCnfAttribAmmessoDto>) cache
					.get("findAll_taifCnfAttribAmmesso_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifCnfAttribAmmesso_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfAttribAmmessoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifCnfAttribAmmessoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfAttribAmmessoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfAttribAmmessoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifCnfAttribAmmessoByFilterDto> findByFilter(java.lang.Integer input)
			throws TaifCnfAttribAmmessoDaoException {
		LOG.debug("[TaifCnfAttribAmmessoDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT attrib.FK_TIPO_MEZZO as id, attrib.NOME_ATTRIB as attributo, attrib.MTD_ORDINAMENTO as ordin");

		sql.append(" FROM TAIF_CNF_ATTRIB_AMMESSO attrib");

		sql.append(" WHERE ");

		sql.append("attrib.fk_tipo_mezzo=:idTipoMezzo");
		/*PROTECTED REGION ID(R-446317709) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idTipoMezzo", input);

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifCnfAttribAmmessoByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfAttribAmmessoDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifCnfAttribAmmessoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfAttribAmmessoDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfAttribAmmessoDaoImpl::findByFilter] END");
		}
		return list;
	}

}
