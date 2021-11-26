/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.impl;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.mapper.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.impl.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
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

/*PROTECTED REGION ID(R-412669231) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTSoggettoGestore.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findAll (datagen::FindAll)
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - byFilter (datagen::CustomFinder)
 *   - byFilterVisible (datagen::CustomFinder)
  * - UPDATERS:
 *   - byIdUtente (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTSoggettoGestoreDaoImpl extends AbstractDAO implements TaifTSoggettoGestoreDao {
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
	 * Metodo di inserimento del DAO taifTSoggettoGestore. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTSoggettoGestorePk
	 * @generated
	 */

	public TaifTSoggettoGestorePk insert(TaifTSoggettoGestoreDto dto)

	{
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_SOGGETTO_GESTORE,CODICE,DENOMINAZIONE_BREVE,DENOMINAZIONE,ISTAT_COMUNE,COMUNE_ESTERO,INDIRIZZO,CIVICO,CAP,TELEFONO,CELLULARE,MAIL,PEC,REFERENTE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,URL_DOC_PRIVACY ) VALUES (  :ID_SOGGETTO_GESTORE , :CODICE , :DENOMINAZIONE_BREVE , :DENOMINAZIONE , :ISTAT_COMUNE , :COMUNE_ESTERO , :INDIRIZZO , :CIVICO , :CAP , :TELEFONO , :CELLULARE , :MAIL , :PEC , :REFERENTE , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :URL_DOC_PRIVACY  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SOGGETTO_GESTORE]
		params.addValue("ID_SOGGETTO_GESTORE", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE]
		params.addValue("CODICE", dto.getCodice(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_BREVE]
		params.addValue("DENOMINAZIONE_BREVE", dto.getDenominazioneBreve(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE]
		params.addValue("DENOMINAZIONE", dto.getDenominazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL]
		params.addValue("MAIL", dto.getMail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PEC]
		params.addValue("PEC", dto.getPec(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [REFERENTE]
		params.addValue("REFERENTE", dto.getReferente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [URL_DOC_PRIVACY]
		params.addValue("URL_DOC_PRIVACY", dto.getUrlDocPrivacy(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdSoggettoGestore(newKey);
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_T_SOGGETTO_GESTORE table.
	 * @generated
	 */
	public void updateColumnsByIdUtente(TaifTSoggettoGestoreDto dto) throws TaifTSoggettoGestoreDaoException {
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::updateColumnsByIdUtente] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET DENOMINAZIONE_BREVE = :DENOMINAZIONE_BREVE ,DENOMINAZIONE = :DENOMINAZIONE ,ISTAT_COMUNE = :ISTAT_COMUNE ,COMUNE_ESTERO = :COMUNE_ESTERO ,INDIRIZZO = :INDIRIZZO ,CIVICO = :CIVICO ,CAP = :CAP ,TELEFONO = :TELEFONO ,CELLULARE = :CELLULARE ,MAIL = :MAIL ,PEC = :PEC ,REFERENTE = :REFERENTE ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,CODICE = :CODICE  WHERE ID_SOGGETTO_GESTORE = :ID_SOGGETTO_GESTORE ";

		if (dto.getIdSoggettoGestore() == null) {
			LOG.error("[TaifTSoggettoGestoreDaoImpl::updateColumnsByIdUtente] ERROR chiave primaria non impostata");
			throw new TaifTSoggettoGestoreDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE_BREVE]
		params.addValue("DENOMINAZIONE_BREVE", dto.getDenominazioneBreve(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DENOMINAZIONE]
		params.addValue("DENOMINAZIONE", dto.getDenominazione(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE]
		params.addValue("ISTAT_COMUNE", dto.getIstatComune(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO]
		params.addValue("COMUNE_ESTERO", dto.getComuneEstero(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO]
		params.addValue("CIVICO", dto.getCivico(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP]
		params.addValue("CAP", dto.getCap(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL]
		params.addValue("MAIL", dto.getMail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [PEC]
		params.addValue("PEC", dto.getPec(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [REFERENTE]
		params.addValue("REFERENTE", dto.getReferente(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [CODICE]
		params.addValue("CODICE", dto.getCodice(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ID_SOGGETTO_GESTORE]
		params.addValue("ID_SOGGETTO_GESTORE", dto.getIdSoggettoGestore(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::updateColumnsByIdUtente] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_SOGGETTO_GESTORE table.
	 * @generated
	 */

	public void delete(TaifTSoggettoGestorePk pk) throws TaifTSoggettoGestoreDaoException {
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_SOGGETTO_GESTORE = :ID_SOGGETTO_GESTORE ";

		if (pk == null) {
			LOG.error("[TaifTSoggettoGestoreDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTSoggettoGestoreDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SOGGETTO_GESTORE]
		params.addValue("ID_SOGGETTO_GESTORE", pk.getIdSoggettoGestore(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::delete] END");
	}

	protected TaifTSoggettoGestoreDaoRowMapper findAllRowMapper = new TaifTSoggettoGestoreDaoRowMapper(null,
			TaifTSoggettoGestoreDto.class, this);

	protected TaifTSoggettoGestoreDaoRowMapper findByPrimaryKeyRowMapper = new TaifTSoggettoGestoreDaoRowMapper(null,
			TaifTSoggettoGestoreDto.class, this);

	protected TaifTSoggettoGestoreDaoRowMapper byFilterRowMapper = new TaifTSoggettoGestoreDaoRowMapper(null,
			TaifTSoggettoGestoreByFilterDto.class, this);

	protected TaifTSoggettoGestoreDaoRowMapper byFilterVisibleRowMapper = new TaifTSoggettoGestoreDaoRowMapper(null,
			TaifTSoggettoGestoreByFilterVisibleDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_SOGGETTO_GESTORE";
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_SOGGETTO_GESTORE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTSoggettoGestoreDto> findAll() throws TaifTSoggettoGestoreDaoException {
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_SOGGETTO_GESTORE,CODICE,DENOMINAZIONE_BREVE,DENOMINAZIONE,ISTAT_COMUNE,COMUNE_ESTERO,INDIRIZZO,CIVICO,CAP,TELEFONO,CELLULARE,MAIL,PEC,REFERENTE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,URL_DOC_PRIVACY FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTSoggettoGestoreDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			List<TaifTSoggettoGestoreDto> res = (List<TaifTSoggettoGestoreDto>) cache
					.get("findAll_taifTSoggettoGestore_data");
			if (res != null) {
				LOG.debug("Dato trovato in cache");
				return res;
			} else {
				stopWatch.start();
				list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
				if (list != null && !list.isEmpty()) {
					cache.put("findAll_taifTSoggettoGestore_data", list);
				}
			}
		} catch (RuntimeException ex) {
			LOG.error("[TaifTSoggettoGestoreDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTSoggettoGestoreDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTSoggettoGestoreDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTSoggettoGestoreDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
	 * Returns all rows from the TAIF_T_SOGGETTO_GESTORE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTSoggettoGestoreDto findByPrimaryKey(TaifTSoggettoGestorePk pk) throws TaifTSoggettoGestoreDaoException {
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_SOGGETTO_GESTORE,CODICE,DENOMINAZIONE_BREVE,DENOMINAZIONE,ISTAT_COMUNE,COMUNE_ESTERO,INDIRIZZO,CIVICO,CAP,TELEFONO,CELLULARE,MAIL,PEC,REFERENTE,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,URL_DOC_PRIVACY FROM "
						+ getTableName() + " WHERE ID_SOGGETTO_GESTORE = :ID_SOGGETTO_GESTORE ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_SOGGETTO_GESTORE]
		params.addValue("ID_SOGGETTO_GESTORE", pk.getIdSoggettoGestore(), java.sql.Types.INTEGER);

		List<TaifTSoggettoGestoreDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			TaifTSoggettoGestoreDto res = (TaifTSoggettoGestoreDto) cache.get(pk);
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
			LOG.error("[TaifTSoggettoGestoreDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTSoggettoGestoreDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTSoggettoGestoreDaoImpl", "findByPrimaryKey", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTSoggettoGestoreDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTSoggettoGestoreByFilterDto> findByFilter(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreFilter input)
			throws TaifTSoggettoGestoreDaoException {
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT soggettoGestore.ID_SOGGETTO_GESTORE as idSoggettoGestore, soggettoGestore.CODICE as codiceGestore, soggettoGestore.DENOMINAZIONE_BREVE as denominazionebreve, soggettoGestore.DENOMINAZIONE as denominazione, soggettoGestore.REFERENTE as referente");

		sql.append(" FROM TAIF_T_SOGGETTO_GESTORE soggettoGestore");

		sql.append(" WHERE ");

		sql.append(
				"soggettogestore.mtd_flg_visibile=:visibile and soggettoGestore.id_soggetto_gestore=:idSoggettogestore");
		/*PROTECTED REGION ID(R743822486) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("visibile", input.getFlagVisibile());
		paramMap.addValue("idSoggettogestore", input.getIdSoggetto());

		/*PROTECTED REGION END*/

		List<TaifTSoggettoGestoreByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTSoggettoGestoreDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTSoggettoGestoreDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTSoggettoGestoreDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifTSoggettoGestoreDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifTSoggettoGestoreByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifTSoggettoGestoreDaoException {
		LOG.debug("[TaifTSoggettoGestoreDaoImpl::findByFilterVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT soggettoGestore.ID_SOGGETTO_GESTORE as idSoggettoGestore, soggettoGestore.CODICE as codiceGestore, soggettoGestore.DENOMINAZIONE_BREVE as denominazionebreve, soggettoGestore.DENOMINAZIONE as denominazione, soggettoGestore.REFERENTE as referente");

		sql.append(" FROM TAIF_T_SOGGETTO_GESTORE soggettoGestore");

		sql.append(" WHERE ");

		sql.append("soggettogestore.mtd_ordinamento is not null");
		/*PROTECTED REGION ID(R-1694895064) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (input.getIdSoggettoGestore() != 0) {
			sql.append(" AND  soggettoGestore.id_soggetto_gestore = :idSoggettoGestore");
			paramMap.addValue("idSoggettoGestore", input.getIdSoggettoGestore());
		}

		if (input.getFlagVisibile() != 0) {
			sql.append(" AND  soggettoGestore.mtd_flg_visibile = :mtd_flg_visibile");
			paramMap.addValue("mtd_flg_visibile", input.getFlagVisibile());
		}

		sql.append(" ORDER BY MTD_ORDINAMENTO ASC");

		/*PROTECTED REGION END*/

		List<TaifTSoggettoGestoreByFilterVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTSoggettoGestoreDaoImpl::findByFilterVisible] ERROR esecuzione query", ex);
			throw new TaifTSoggettoGestoreDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTSoggettoGestoreDaoImpl", "findByFilterVisible", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTSoggettoGestoreDaoImpl::findByFilterVisible] END");
		}
		return list;
	}

}
