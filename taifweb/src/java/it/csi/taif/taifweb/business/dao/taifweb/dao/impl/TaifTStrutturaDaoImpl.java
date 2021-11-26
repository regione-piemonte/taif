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

/*PROTECTED REGION ID(R-1672893597) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTStruttura.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - findByAzienda (datagen::CustomFinder)
 *   - byAziendaFunzione (datagen::CustomFinder)
 *   - findFunzioneTipoStrutturaByIdAzienda (datagen::CustomFinder)
  * - UPDATERS:
 *   - update (datagen::UpdateRow)
 *   - perIdAzienda (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTStrutturaDaoImpl extends AbstractDAO implements TaifTStrutturaDao {
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
	 * Metodo di inserimento del DAO taifTStruttura. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTStrutturaPk
	 * @generated
	 */

	public TaifTStrutturaPk insert(TaifTStrutturaDto dto)

	{
		LOG.debug("[TaifTStrutturaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_STRUTTURA,FK_FUNZIONE,FK_AZIENDA,DIMENSIONE,ANNO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_STRUTTURA , :FK_FUNZIONE , :FK_AZIENDA , :DIMENSIONE , :ANNO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STRUTTURA]
		params.addValue("ID_STRUTTURA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_FUNZIONE]
		params.addValue("FK_FUNZIONE", dto.getFkFunzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DIMENSIONE]
		params.addValue("DIMENSIONE", dto.getDimensione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdStruttura(newKey);
		LOG.debug("[TaifTStrutturaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates a single row in the TAIF_T_STRUTTURA table.
	 * @generated
	 */
	public void update(TaifTStrutturaDto dto) throws TaifTStrutturaDaoException {
		LOG.debug("[TaifTStrutturaDaoImpl::update] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_FUNZIONE = :FK_FUNZIONE ,FK_AZIENDA = :FK_AZIENDA ,DIMENSIONE = :DIMENSIONE ,ANNO = :ANNO ,DATA_INSERIMENTO = :DATA_INSERIMENTO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_STRUTTURA = :ID_STRUTTURA ";

		if (dto.getIdStruttura() == null) {
			LOG.error("[TaifTStrutturaDaoImpl::update] ERROR chiave primaria non impostata");
			throw new TaifTStrutturaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STRUTTURA]
		params.addValue("ID_STRUTTURA", dto.getIdStruttura(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_FUNZIONE]
		params.addValue("FK_FUNZIONE", dto.getFkFunzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DIMENSIONE]
		params.addValue("DIMENSIONE", dto.getDimensione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStrutturaDaoImpl::update] END");
	}

	/** 
	 * Updates selected columns in the TAIF_T_STRUTTURA table.
	 * @generated
	 */
	public void updateColumnsPerIdAzienda(TaifTStrutturaDto dto) throws TaifTStrutturaDaoException {
		LOG.debug("[TaifTStrutturaDaoImpl::updateColumnsPerIdAzienda] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_FUNZIONE = :FK_FUNZIONE ,DIMENSIONE = :DIMENSIONE ,ANNO = :ANNO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE ,FK_AZIENDA = :FK_AZIENDA  WHERE ID_STRUTTURA = :ID_STRUTTURA ";

		if (dto.getIdStruttura() == null) {
			LOG.error("[TaifTStrutturaDaoImpl::updateColumnsPerIdAzienda] ERROR chiave primaria non impostata");
			throw new TaifTStrutturaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_FUNZIONE]
		params.addValue("FK_FUNZIONE", dto.getFkFunzione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [DIMENSIONE]
		params.addValue("DIMENSIONE", dto.getDimensione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ANNO]
		params.addValue("ANNO", dto.getAnno(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AZIENDA]
		params.addValue("FK_AZIENDA", dto.getFkAzienda(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_STRUTTURA]
		params.addValue("ID_STRUTTURA", dto.getIdStruttura(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStrutturaDaoImpl::updateColumnsPerIdAzienda] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_STRUTTURA table.
	 * @generated
	 */

	public void delete(TaifTStrutturaPk pk) throws TaifTStrutturaDaoException {
		LOG.debug("[TaifTStrutturaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_STRUTTURA = :ID_STRUTTURA ";

		if (pk == null) {
			LOG.error("[TaifTStrutturaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTStrutturaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STRUTTURA]
		params.addValue("ID_STRUTTURA", pk.getIdStruttura(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTStrutturaDaoImpl::delete] END");
	}

	protected TaifTStrutturaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTStrutturaDaoRowMapper(null,
			TaifTStrutturaDto.class, this);

	protected TaifTStrutturaDaoRowMapper findAllRowMapper = new TaifTStrutturaDaoRowMapper(null,
			TaifTStrutturaDto.class, this);

	protected TaifTStrutturaDaoRowMapper findByAziendaRowMapper = new TaifTStrutturaDaoRowMapper(null,
			TaifTStrutturaFindByAziendaDto.class, this);

	protected TaifTStrutturaDaoRowMapper byAziendaFunzioneRowMapper = new TaifTStrutturaDaoRowMapper(null,
			TaifTStrutturaByAziendaFunzioneDto.class, this);

	protected TaifTStrutturaDaoRowMapper findFunzioneTipoStrutturaByIdAziendaRowMapper = new TaifTStrutturaDaoRowMapper(
			null, TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_STRUTTURA";
	}

	/** 
	 * Returns all rows from the TAIF_T_STRUTTURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTStrutturaDto findByPrimaryKey(TaifTStrutturaPk pk) throws TaifTStrutturaDaoException {
		LOG.debug("[TaifTStrutturaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STRUTTURA,FK_FUNZIONE,FK_AZIENDA,DIMENSIONE,ANNO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_STRUTTURA = :ID_STRUTTURA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_STRUTTURA]
		params.addValue("ID_STRUTTURA", pk.getIdStruttura(), java.sql.Types.INTEGER);

		List<TaifTStrutturaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStrutturaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTStrutturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStrutturaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStrutturaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_STRUTTURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTStrutturaDto> findAll() throws TaifTStrutturaDaoException {
		LOG.debug("[TaifTStrutturaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_STRUTTURA,FK_FUNZIONE,FK_AZIENDA,DIMENSIONE,ANNO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		sql.append(" ORDER BY ID_STRUTTURA ASC");
		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTStrutturaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStrutturaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTStrutturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStrutturaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStrutturaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findByAzienda con Qdef
		 * @generated
		 */

	public List<TaifTStrutturaFindByAziendaDto> findFindByAzienda(java.lang.Integer input)
			throws TaifTStrutturaDaoException {
		LOG.debug("[TaifTStrutturaDaoImpl::findFindByAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT stru.ID_STRUTTURA as id, stru.FK_FUNZIONE as funz, stru.DIMENSIONE as dim, stru.ANNO as anno, stru.DATA_INSERIMENTO as data");

		sql.append(" FROM TAIF_T_STRUTTURA stru");

		sql.append(" WHERE ");

		sql.append("stru.fk_azienda=:idAzienda ");
		/*PROTECTED REGION ID(R-1893667582) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input);

		/*PROTECTED REGION END*/

		List<TaifTStrutturaFindByAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findByAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStrutturaDaoImpl::findFindByAzienda] ERROR esecuzione query", ex);
			throw new TaifTStrutturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStrutturaDaoImpl", "findFindByAzienda", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStrutturaDaoImpl::findFindByAzienda] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byAziendaFunzione con Qdef
		 * @generated
		 */

	public List<TaifTStrutturaByAziendaFunzioneDto> findByAziendaFunzione(
			it.csi.taif.taifweb.business.dao.taifweb.filter.StrutturaFilter input) throws TaifTStrutturaDaoException {
		LOG.debug("[TaifTStrutturaDaoImpl::findByAziendaFunzione] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT stru.ID_STRUTTURA as id, stru.FK_FUNZIONE as funz, stru.DIMENSIONE as dim, stru.ANNO as anno, stru.DATA_INSERIMENTO as data, stru.FK_AZIENDA as azienda");

		sql.append(" FROM TAIF_T_STRUTTURA stru");

		sql.append(" WHERE ");

		sql.append("stru.fk_azienda=:idAzienda and stru.fk_funzione=:idFunzione");
		/*PROTECTED REGION ID(R-405488111) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("idFunzione", input.getIdFunzione());

		/*PROTECTED REGION END*/

		List<TaifTStrutturaByAziendaFunzioneDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byAziendaFunzioneRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStrutturaDaoImpl::findByAziendaFunzione] ERROR esecuzione query", ex);
			throw new TaifTStrutturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStrutturaDaoImpl", "findByAziendaFunzione", "esecuzione query", sql.toString());
			LOG.debug("[TaifTStrutturaDaoImpl::findByAziendaFunzione] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder findFunzioneTipoStrutturaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto> findFindFunzioneTipoStrutturaByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTStrutturaDaoException {
		LOG.debug("[TaifTStrutturaDaoImpl::findFindFunzioneTipoStrutturaByIdAzienda] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT strutturaTab.ID_STRUTTURA as idStruttura, strutturaTab.DIMENSIONE as dimensioneStruttura, strutturaTab.ANNO as annoStruttura, dTipoStrutturaTab.TIPO_STRUTTURA as tipoStruttura, dFunzioneTab.FUNZIONE as funzioneStruttura");

		sql.append(
				" FROM TAIF_D_TIPO_STRUTTURA dTipoStrutturaTab, TAIF_T_STRUTTURA strutturaTab, TAIF_D_FUNZIONE dFunzioneTab");

		sql.append(" WHERE ");

		sql.append(
				"strutturaTab.FK_FUNZIONE = dFunzioneTab.ID_FUNZIONE AND dFunzioneTab.ID_FUNZIONE = dTipoStrutturaTab.ID_TIPO_STRUTTURA");

		sql.append(" AND ");

		sql.append(
				"strutturaTab.fk_azienda=:idAzienda and dFunzioneTab.mtd_flg_visibile=:flagVisibile and dFunzioneTab.mtd_flg_ita_fra=:flagItaFra and dTipoStrutturaTab.mtd_flg_visibile=:flagVisibile and dTipoStrutturaTab.mtd_flg_ita_fra=:flagItaFra");
		/*PROTECTED REGION ID(R797485791) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idAzienda", input.getIdAzienda());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("flagItaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTStrutturaFindFunzioneTipoStrutturaByIdAziendaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, findFunzioneTipoStrutturaByIdAziendaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTStrutturaDaoImpl::findFindFunzioneTipoStrutturaByIdAzienda] ERROR esecuzione query", ex);
			throw new TaifTStrutturaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTStrutturaDaoImpl", "findFindFunzioneTipoStrutturaByIdAzienda",
					"esecuzione query", sql.toString());
			LOG.debug("[TaifTStrutturaDaoImpl::findFindFunzioneTipoStrutturaByIdAzienda] END");
		}
		return list;
	}

}
