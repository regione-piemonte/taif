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

/*PROTECTED REGION ID(R1053463439) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifCnfEstensAmm.
 * Il DAO implementa le seguenti operazioni:
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byEstensioneFileAndTipoAllegato (datagen::CustomFinder)
  * - UPDATERS:
 
 *    --
 * - DELETERS:
 
 *    --
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifCnfEstensAmmDaoImpl extends AbstractDAO implements TaifCnfEstensAmmDao {
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

	protected TaifCnfEstensAmmDaoRowMapper findByPrimaryKeyRowMapper = new TaifCnfEstensAmmDaoRowMapper(null,
			TaifCnfEstensAmmDto.class, this);

	protected TaifCnfEstensAmmDaoRowMapper byEstensioneFileAndTipoAllegatoRowMapper = new TaifCnfEstensAmmDaoRowMapper(
			null, TaifCnfEstensAmmDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_CNF_ESTENS_AMM";
	}

	/** 
	 * Returns all rows from the TAIF_CNF_ESTENS_AMM table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfEstensAmmDto findByPrimaryKey(TaifCnfEstensAmmPk pk) throws TaifCnfEstensAmmDaoException {
		LOG.debug("[TaifCnfEstensAmmDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder("SELECT ID_ESTENSIONE_FILE,ID_TIPO_ALLEGATO FROM " + getTableName()
				+ " WHERE ID_ESTENSIONE_FILE = :ID_ESTENSIONE_FILE  AND ID_TIPO_ALLEGATO = :ID_TIPO_ALLEGATO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_ESTENSIONE_FILE]
		params.addValue("ID_ESTENSIONE_FILE", pk.getIdEstensioneFile(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_TIPO_ALLEGATO]
		params.addValue("ID_TIPO_ALLEGATO", pk.getIdTipoAllegato(), java.sql.Types.INTEGER);

		List<TaifCnfEstensAmmDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifCnfEstensAmmDto res = (TaifCnfEstensAmmDto) cache.get(pk);
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
			LOG.error("[TaifCnfEstensAmmDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifCnfEstensAmmDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfEstensAmmDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifCnfEstensAmmDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Implementazione del finder byEstensioneFileAndTipoAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfEstensAmmDto> findByEstensioneFileAndTipoAllegato(String estensione, Integer input)
			throws TaifCnfEstensAmmDaoException {
		LOG.debug("[TaifCnfEstensAmmDaoImpl::findByEstensioneFileAndTipoAllegato] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		/*PROTECTED REGION ID(R13152474) ENABLED START*/
		// la clausola select e'customizzabile poiche' il finder ha l'attributo customSelect == true
		sql.append("SELECT ea.id_estensione_file, ea.id_tipo_allegato ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R-264047864) ENABLED START*/
		// la clausola from e'customizzabile poiche' il finder ha l'attributo customFrom==true
		sql.append(" FROM taif_cnf_estens_amm ea, taif_d_estensione_file ef ");
		/*PROTECTED REGION END*/
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R414689578) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append(" ea.id_estensione_file = ef.id_estensione_file");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)
		sql.append(" AND upper(ef.estensione) = upper(:estensione)");
		sql.append(" AND ea.id_tipo_allegato = :idTipoAllegato ");
		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R95361280) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("estensione", estensione);
		paramMap.addValue("idTipoAllegato", input);

		/*PROTECTED REGION END*/
		List<TaifCnfEstensAmmDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byEstensioneFileAndTipoAllegatoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifCnfEstensAmmDaoImpl::findByEstensioneFileAndTipoAllegato] esecuzione query", ex);
			throw new TaifCnfEstensAmmDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifCnfEstensAmmDaoImpl", "findByEstensioneFileAndTipoAllegato", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifCnfEstensAmmDaoImpl::findByEstensioneFileAndTipoAllegato] END");
		}
		return list;
	}

}
