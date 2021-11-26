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

/*PROTECTED REGION ID(R163741723) ENABLED START*/
// aggiungere qui eventuali import custom. 
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTCorso.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - byFilterUnitaFormativa (datagen::CustomFinder)
 *   - byFilterVisible (datagen::CustomFinder)
 *   - corsiPerAgenziaUnita (datagen::CustomFinder)
  * - UPDATERS:
 *   - forIdCorso (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTCorsoDaoImpl extends AbstractDAO implements TaifTCorsoDao {
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
	 * Metodo di inserimento del DAO taifTCorso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTCorsoPk
	 * @generated
	 */

	public TaifTCorsoPk insert(TaifTCorsoDto dto)

	{
		LOG.debug("[TaifTCorsoDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_CORSO,FK_AGENZIA_FORMATIVA,FK_UNITA_FORMATIVA,CORSO,CODICE_PSR,DATA_INIZIO,DATA_FINE,NRO_ORE,ISTAT_SEDE,COMUNE_ESTERO_SEDE,INDIRIZZO,FLG_ALTRO_CORSO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA,FK_CONFIG_UTENTE ) VALUES (  :ID_CORSO , :FK_AGENZIA_FORMATIVA , :FK_UNITA_FORMATIVA , :CORSO , :CODICE_PSR , :DATA_INIZIO , :DATA_FINE , :NRO_ORE , :ISTAT_SEDE , :COMUNE_ESTERO_SEDE , :INDIRIZZO , :FLG_ALTRO_CORSO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :MTD_ORDINAMENTO , :MTD_FLG_VISIBILE , :MTD_FLG_ITA_FRA , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_AGENZIA_FORMATIVA]
		params.addValue("FK_AGENZIA_FORMATIVA", dto.getFkAgenziaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_FORMATIVA]
		params.addValue("FK_UNITA_FORMATIVA", dto.getFkUnitaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CORSO]
		params.addValue("CORSO", dto.getCorso(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_PSR]
		params.addValue("CODICE_PSR", dto.getCodicePsr(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NRO_ORE]
		params.addValue("NRO_ORE", dto.getNroOre(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ISTAT_SEDE]
		params.addValue("ISTAT_SEDE", dto.getIstatSede(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_SEDE]
		params.addValue("COMUNE_ESTERO_SEDE", dto.getComuneEsteroSede(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ALTRO_CORSO]
		params.addValue("FLG_ALTRO_CORSO", dto.getFlgAltroCorso(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [MTD_ORDINAMENTO]
		params.addValue("MTD_ORDINAMENTO", dto.getMtdOrdinamento(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_VISIBILE]
		params.addValue("MTD_FLG_VISIBILE", dto.getMtdFlgVisibile(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [MTD_FLG_ITA_FRA]
		params.addValue("MTD_FLG_ITA_FRA", dto.getMtdFlgItaFra(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdCorso(newKey);
		LOG.debug("[TaifTCorsoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_T_CORSO table.
	 * @generated
	 */
	public void updateColumnsForIdCorso(TaifTCorsoDto dto) throws TaifTCorsoDaoException {
		LOG.debug("[TaifTCorsoDaoImpl::updateColumnsForIdCorso] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_AGENZIA_FORMATIVA = :FK_AGENZIA_FORMATIVA ,FK_UNITA_FORMATIVA = :FK_UNITA_FORMATIVA ,CORSO = :CORSO ,CODICE_PSR = :CODICE_PSR ,DATA_INIZIO = :DATA_INIZIO ,DATA_FINE = :DATA_FINE ,NRO_ORE = :NRO_ORE ,ISTAT_SEDE = :ISTAT_SEDE ,COMUNE_ESTERO_SEDE = :COMUNE_ESTERO_SEDE ,INDIRIZZO = :INDIRIZZO ,FLG_ALTRO_CORSO = :FLG_ALTRO_CORSO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_CORSO = :ID_CORSO ";

		if (dto.getIdCorso() == null) {
			LOG.error("[TaifTCorsoDaoImpl::updateColumnsForIdCorso] ERROR chiave primaria non impostata");
			throw new TaifTCorsoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_AGENZIA_FORMATIVA]
		params.addValue("FK_AGENZIA_FORMATIVA", dto.getFkAgenziaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_UNITA_FORMATIVA]
		params.addValue("FK_UNITA_FORMATIVA", dto.getFkUnitaFormativa(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CORSO]
		params.addValue("CORSO", dto.getCorso(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CODICE_PSR]
		params.addValue("CODICE_PSR", dto.getCodicePsr(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INIZIO]
		params.addValue("DATA_INIZIO", dto.getDataInizio(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_FINE]
		params.addValue("DATA_FINE", dto.getDataFine(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [NRO_ORE]
		params.addValue("NRO_ORE", dto.getNroOre(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [ISTAT_SEDE]
		params.addValue("ISTAT_SEDE", dto.getIstatSede(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_SEDE]
		params.addValue("COMUNE_ESTERO_SEDE", dto.getComuneEsteroSede(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO]
		params.addValue("INDIRIZZO", dto.getIndirizzo(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_ALTRO_CORSO]
		params.addValue("FLG_ALTRO_CORSO", dto.getFlgAltroCorso(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", dto.getIdCorso(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTCorsoDaoImpl::updateColumnsForIdCorso] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_CORSO table.
	 * @generated
	 */

	public void delete(TaifTCorsoPk pk) throws TaifTCorsoDaoException {
		LOG.debug("[TaifTCorsoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_CORSO = :ID_CORSO ";

		if (pk == null) {
			LOG.error("[TaifTCorsoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTCorsoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", pk.getIdCorso(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTCorsoDaoImpl::delete] END");
	}

	protected TaifTCorsoDaoRowMapper findByPrimaryKeyRowMapper = new TaifTCorsoDaoRowMapper(null, TaifTCorsoDto.class,
			this);

	protected TaifTCorsoDaoRowMapper findAllRowMapper = new TaifTCorsoDaoRowMapper(null, TaifTCorsoDto.class, this);

	protected TaifTCorsoDaoRowMapper byFilterUnitaFormativaRowMapper = new TaifTCorsoDaoRowMapper(null,
			TaifTCorsoByFilterUnitaFormativaDto.class, this);

	protected TaifTCorsoDaoRowMapper byFilterVisibleRowMapper = new TaifTCorsoDaoRowMapper(null,
			TaifTCorsoByFilterVisibleDto.class, this);

	protected TaifTCorsoDaoRowMapper corsiPerAgenziaUnitaRowMapper = new TaifTCorsoDaoRowMapper(null,
			TaifTCorsoCorsiPerAgenziaUnitaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_CORSO";
	}

	/** 
	 * Returns all rows from the TAIF_T_CORSO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTCorsoDto findByPrimaryKey(TaifTCorsoPk pk) throws TaifTCorsoDaoException {
		LOG.debug("[TaifTCorsoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CORSO,FK_AGENZIA_FORMATIVA,FK_UNITA_FORMATIVA,CORSO,CODICE_PSR,DATA_INIZIO,DATA_FINE,NRO_ORE,ISTAT_SEDE,COMUNE_ESTERO_SEDE,INDIRIZZO,FLG_ALTRO_CORSO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_CORSO = :ID_CORSO ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_CORSO]
		params.addValue("ID_CORSO", pk.getIdCorso(), java.sql.Types.INTEGER);

		List<TaifTCorsoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCorsoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCorsoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCorsoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_CORSO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTCorsoDto> findAll() throws TaifTCorsoDaoException {
		LOG.debug("[TaifTCorsoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_CORSO,FK_AGENZIA_FORMATIVA,FK_UNITA_FORMATIVA,CORSO,CODICE_PSR,DATA_INIZIO,DATA_FINE,NRO_ORE,ISTAT_SEDE,COMUNE_ESTERO_SEDE,INDIRIZZO,FLG_ALTRO_CORSO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,MTD_ORDINAMENTO,MTD_FLG_VISIBILE,MTD_FLG_ITA_FRA,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTCorsoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCorsoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCorsoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCorsoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterUnitaFormativa con Qdef
		 * @generated
		 */

	public List<TaifTCorsoByFilterUnitaFormativaDto> findByFilterUnitaFormativa(
			it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaFilter input) throws TaifTCorsoDaoException {
		LOG.debug("[TaifTCorsoDaoImpl::findByFilterUnitaFormativa] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT corso.ID_CORSO as idCorso, corso.CORSO as dsCorso, corso.DATA_INIZIO as dataInizioCorso, corso.DATA_FINE as dataFineCorso, corso.ISTAT_SEDE as sedeCorso, corso.COMUNE_ESTERO_SEDE as comuneEsteroSede, corso.INDIRIZZO as indirizzoSede, corso.NRO_ORE as numeroOre");

		sql.append(" FROM TAIF_T_CORSO corso");

		sql.append(" WHERE ");

		sql.append("corso.fk_unita_formativa = :idUnitaFormativa");
		/*PROTECTED REGION ID(R-658606789) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idUnitaFormativa", new Integer(input.getIdUnitaFormativa()));

		/*PROTECTED REGION END*/

		List<TaifTCorsoByFilterUnitaFormativaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterUnitaFormativaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCorsoDaoImpl::findByFilterUnitaFormativa] ERROR esecuzione query", ex);
			throw new TaifTCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCorsoDaoImpl", "findByFilterUnitaFormativa", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTCorsoDaoImpl::findByFilterUnitaFormativa] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifTCorsoByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.VisibileOrdinFilter input) throws TaifTCorsoDaoException {
		LOG.debug("[TaifTCorsoDaoImpl::findByFilterVisible] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT corso.ID_CORSO as idCorso, corso.CORSO as dsCorso, corso.FLG_ALTRO_CORSO as flgAltroCorso");

		sql.append(" FROM TAIF_T_CORSO corso");

		sql.append(" WHERE ");

		sql.append("corso.flg_altro_corso is not null");
		/*PROTECTED REGION ID(R1345362915) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ORDER BY corso.ID_CORSO ASC");

		paramMap.addValue("flagVisible", input.getFlagVisibile());

		/*PROTECTED REGION END*/

		List<TaifTCorsoByFilterVisibleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterVisibleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCorsoDaoImpl::findByFilterVisible] ERROR esecuzione query", ex);
			throw new TaifTCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCorsoDaoImpl", "findByFilterVisible", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCorsoDaoImpl::findByFilterVisible] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder corsiPerAgenziaUnita con Qdef
		 * @generated
		 */

	public List<TaifTCorsoCorsiPerAgenziaUnitaDto> findCorsiPerAgenziaUnita(
			it.csi.taif.topforweb.business.dao.topfor.filter.CorsoFormazioneFilter input)
			throws TaifTCorsoDaoException {
		LOG.debug("[TaifTCorsoDaoImpl::findCorsiPerAgenziaUnita] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT corso.ID_CORSO as idCorso, corso.CORSO as descrizioneCorsoCorso, corso.DATA_INIZIO as dataInizioCorso, corso.DATA_FINE as dataFineCorso, corso.ISTAT_SEDE as sedeCorso, corso.COMUNE_ESTERO_SEDE as comuneEsteroSede, corso.INDIRIZZO as indirizzoSede, corso.NRO_ORE as numeroOre, corso.FK_AGENZIA_FORMATIVA as idAgenziaFormativa, corso.FK_UNITA_FORMATIVA as idUnitaFormativa, corso.MTD_FLG_VISIBILE as flagVisibile, corso.MTD_FLG_ITA_FRA as flagItaFr, corso.MTD_ORDINAMENTO as ordinamento");

		sql.append(" FROM TAIF_T_CORSO corso");

		sql.append(" WHERE ");

		sql.append(
				"corso.fk_agenzia_formativa = :idAgenziaFormativa and corso.fk_unita_formativa = :idUnitaFormativa  and corso.mtd_flg_visibile = :flagVisibile and corso.mtd_flg_ita_fra=:itaFra");
		/*PROTECTED REGION ID(R1987004655) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		sql.append(" ORDER BY DATAINIZIOCORSO DESC");

		paramMap.addValue("idAgenziaFormativa", input.getIdAgenziaFormativa());
		paramMap.addValue("idUnitaFormativa", input.getIdUnitaFormativa());
		paramMap.addValue("flagVisibile", input.getFlagVisibile());
		paramMap.addValue("itaFra", input.getFlagItaFr());

		/*PROTECTED REGION END*/

		List<TaifTCorsoCorsiPerAgenziaUnitaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, corsiPerAgenziaUnitaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTCorsoDaoImpl::findCorsiPerAgenziaUnita] ERROR esecuzione query", ex);
			throw new TaifTCorsoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTCorsoDaoImpl", "findCorsiPerAgenziaUnita", "esecuzione query", sql.toString());
			LOG.debug("[TaifTCorsoDaoImpl::findCorsiPerAgenziaUnita] END");
		}
		return list;
	}

}
