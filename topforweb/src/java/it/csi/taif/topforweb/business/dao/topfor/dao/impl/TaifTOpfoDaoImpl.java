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

/*PROTECTED REGION ID(R-1480880443) ENABLED START*/
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTOpfo.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - ricercaOperatoreAvanzata (datagen::CustomFinder)
  * - UPDATERS:
 *   - byIdOperatoriForestali (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTOpfoDaoImpl extends AbstractDAO implements TaifTOpfoDao {
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
	 * Metodo di inserimento del DAO taifTOpfo. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTOpfoPk
	 * @generated
	 */

	public TaifTOpfoPk insert(TaifTOpfoDto dto)

	{
		LOG.debug("[TaifTOpfoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA,FK_STATO_OPFO,FK_SOGGETTO_GESTORE,FLG_PUBBLICO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE ) VALUES (  :ID_PERSONA , :FK_STATO_OPFO , :FK_SOGGETTO_GESTORE , :FLG_PUBBLICO , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_STATO_OPFO]
		params.addValue("FK_STATO_OPFO", dto.getFkStatoOpfo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_PUBBLICO]
		params.addValue("FLG_PUBBLICO", dto.getFlgPubblico(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		insert(jdbcTemplate, sql.toString(), params);

		LOG.debug("[TaifTOpfoDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_T_OPFO table.
	 * @generated
	 */
	public void updateColumnsByIdOperatoriForestali(TaifTOpfoDto dto) throws TaifTOpfoDaoException {
		LOG.debug("[TaifTOpfoDaoImpl::updateColumnsByIdOperatoriForestali] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_STATO_OPFO = :FK_STATO_OPFO ,FK_SOGGETTO_GESTORE = :FK_SOGGETTO_GESTORE ,FLG_PUBBLICO = :FLG_PUBBLICO ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_PERSONA = :ID_PERSONA ";

		if (dto.getIdPersona() == null) {
			LOG.error("[TaifTOpfoDaoImpl::updateColumnsByIdOperatoriForestali] ERROR chiave primaria non impostata");
			throw new TaifTOpfoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_STATO_OPFO]
		params.addValue("FK_STATO_OPFO", dto.getFkStatoOpfo(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_SOGGETTO_GESTORE]
		params.addValue("FK_SOGGETTO_GESTORE", dto.getFkSoggettoGestore(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FLG_PUBBLICO]
		params.addValue("FLG_PUBBLICO", dto.getFlgPubblico(), java.sql.Types.NUMERIC);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTOpfoDaoImpl::updateColumnsByIdOperatoriForestali] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_OPFO table.
	 * @generated
	 */

	public void delete(TaifTOpfoPk pk) throws TaifTOpfoDaoException {
		LOG.debug("[TaifTOpfoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_PERSONA = :ID_PERSONA ";

		if (pk == null) {
			LOG.error("[TaifTOpfoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTOpfoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTOpfoDaoImpl::delete] END");
	}

	protected TaifTOpfoDaoRowMapper findByPrimaryKeyRowMapper = new TaifTOpfoDaoRowMapper(null, TaifTOpfoDto.class,
			this);

	protected TaifTOpfoDaoRowMapper findAllRowMapper = new TaifTOpfoDaoRowMapper(null, TaifTOpfoDto.class, this);

	protected TaifTOpfoDaoRowMapper ricercaOperatoreAvanzataRowMapper = new TaifTOpfoDaoRowMapper(null,
			TaifTOpfoRicercaOperatoreAvanzataDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_OPFO";
	}

	/** 
	 * Returns all rows from the TAIF_T_OPFO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTOpfoDto findByPrimaryKey(TaifTOpfoPk pk) throws TaifTOpfoDaoException {
		LOG.debug("[TaifTOpfoDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,FK_STATO_OPFO,FK_SOGGETTO_GESTORE,FLG_PUBBLICO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName() + " WHERE ID_PERSONA = :ID_PERSONA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		List<TaifTOpfoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTOpfoDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTOpfoDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTOpfoDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_OPFO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTOpfoDto> findAll() throws TaifTOpfoDaoException {
		LOG.debug("[TaifTOpfoDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,FK_STATO_OPFO,FK_SOGGETTO_GESTORE,FLG_PUBBLICO,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTOpfoDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTOpfoDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTOpfoDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTOpfoDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder ricercaOperatoreAvanzata con Qdef
		 * @generated
		 */

	public List<TaifTOpfoRicercaOperatoreAvanzataDto> findRicercaOperatoreAvanzata(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTOpfoDaoException {
		LOG.debug("[TaifTOpfoDaoImpl::findRicercaOperatoreAvanzata] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT soggGestore.ID_SOGGETTO_GESTORE as idSoggettoGestore, soggGestore.DENOMINAZIONE_BREVE as denominazioneBreve, persona.ID_PERSONA as idPersona, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as nRsiMsa, persona.COGNOME as cognomeOperatore, persona.NOME as nomeOperatore, elencoCorso.ARRAY_TO_STRING as elencoCorso, soggGestore.URL_DOC_PRIVACY as urlPrivacy");

		sql.append(
				" FROM TAIF_T_PERSONA persona, TAIF_T_OPFO opfo, TAIF_R_OPFO_CORSO opfoCorso, TAIF_T_CORSO corso, TAIF_T_AGENZIA_FORMATIVA agenzia, TAIF_D_UNITA_FORMATIVA unitaFormativa, TAIF_T_SOGGETTO_GESTORE soggGestore, TAIF_V_ELENCO_CORSO_PERSONA elencoCorso");

		sql.append(" WHERE ");

		sql.append("1 = 1");
		/*PROTECTED REGION ID(R-257245978) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		int index = sql.indexOf("FROM");

		String query = sql.substring(0, index);

		query = query.replaceAll("SELECT", "SELECT DISTINCT");

		String addToQuery = " FROM"
				+ " TAIF_T_PERSONA persona JOIN TAIF_T_OPFO opfo ON persona.ID_PERSONA = opfo.ID_PERSONA"
				+ " LEFT JOIN TAIF_R_OPFO_CORSO opfoCorso ON opfo.ID_PERSONA = opfoCorso.ID_PERSONA"
				+ " LEFT JOIN TAIF_T_CORSO corso ON opfoCorso.ID_CORSO = corso.ID_CORSO"
				+ " LEFT JOIN TAIF_T_AGENZIA_FORMATIVA agenzia ON corso.fk_agenzia_formativa = agenzia.id_agenzia_formativa "
				+ " LEFT JOIN TAIF_D_UNITA_FORMATIVA unitaFormativa ON corso.fk_unita_formativa = unitaFormativa.id_unita_formativa "
				+ " LEFT JOIN TAIF_T_SOGGETTO_GESTORE soggGestore ON opfo.FK_SOGGETTO_GESTORE = soggGestore.ID_SOGGETTO_GESTORE "
				+ " LEFT JOIN TAIF_V_ELENCO_CORSO_PERSONA elencoCorso ON opfo.ID_PERSONA = elencoCorso.ID_PERSONA "
				+ " WHERE 1 = 1";

		query = query + addToQuery;

		StringBuilder q = new StringBuilder(query);

		if (ConvertUtil.checkListIsNullOrEmpty(input.getAlboOperatore())) {
			q.append(" AND ");
			q.append("soggGestore.id_soggetto_gestore IN (:stringAlboOperatore)");
			List<Integer> listAlboAppartenenza = new ArrayList<Integer>();
			for(String albo: input.getAlboOperatore()) {
				listAlboAppartenenza.add(ConvertUtil.convertToInteger(albo));
			}
			paramMap.addValue("stringAlboOperatore", listAlboAppartenenza);

		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getUnitaFormativa())) {
			q.append(" AND ");
			q.append("unitaFormativa.id_unita_formativa = :idUnitaFormativa");
			paramMap.addValue("idUnitaFormativa", ConvertUtil.toInteger(input.getUnitaFormativa()));
		} else if (ConvertUtil.checkIsNullOrEmpty(input.getIdAmbitoFormativo())) {
			q.append(" AND ");
			q.append("unitaFormativa.fk_ambito_formativo = :fk_ambito_formativo");
			paramMap.addValue("fkAmbitoFormativo", ConvertUtil.toInteger(input.getIdAmbitoFormativo()));
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getAgenziaFormativa())) {
			q.append(" AND ");
			q.append("agenzia.id_agenzia_formativa = :idAgenziaFormativa");
			paramMap.addValue("idAgenziaFormativa", ConvertUtil.toInteger(input.getAgenziaFormativa()));
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getCognome())) {
			q.append(" AND ");
			q.append("UPPER (persona.cognome) like UPPER(:cognome)");
			String cognome = "%" + input.getCognome() + "%";
			paramMap.addValue("cognome", cognome);
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getIstatComune())) {
			q.append(" AND ");
			q.append("persona.istat_comune_res = :istatComuneRes");
			paramMap.addValue("istatComuneRes", input.getIstatComune());
		} else if (ConvertUtil.checkIsNullOrEmpty(input.getIstatProvincia())) {
			q.append(" AND ");
			q.append("LEFT(persona.istat_comune_res,3) = :istatComuneRes");
			paramMap.addValue("istatComuneRes", input.getIstatProvincia());
		}

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		if (input.getDataDa() != null && !input.getDataDa().equals(Constants.blank)) {
			q.append(" AND ");
			if (input.getDataA() != null && !input.getDataA().equals(Constants.blank)) {
				q.append("corso.data_inizio BETWEEN  to_date(:dataDa,'dd/mm/yyyy')  and   to_date(:dataA ,'dd/mm/yyyy')");
				paramMap.addValue("dataA", df.format(input.getDataA()));

			} else {
				q.append("corso.data_inizio  > to_date(:dataDa,'dd/mm/yyyy')");
			}
			
			paramMap.addValue("dataDa", df.format(input.getDataDa()));
		} else {
			if (input.getDataA() != null && !input.getDataA().equals(Constants.blank)) {
				q.append("corso.data_fine  < to_date(:dataA,'dd/mm/yyyy')");
				paramMap.addValue("dataA", df.format(input.getDataA()));

			}
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getStatoScheda())) {
			q.append(" AND ");
			q.append("opfo.fk_stato_opfo = :statoScheda");
			paramMap.addValue("statoScheda", ConvertUtil.toInteger(input.getStatoScheda()));
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getStatoOperatore())) {
			q.append(" AND ");
			q.append("opfo.flg_pubblico = :statoOpfo");
			paramMap.addValue("statoOpfo", ConvertUtil.toInteger(input.getStatoOperatore()));
		}

		if (input.isIstruttore()) {
			q.append(
					" AND opfo.id_persona in (SELECT Qualifica.fk_persona FROM TAIF_T_QUALIFICA Qualifica WHERE Qualifica.fk_tipo_qualifica in (4,5,6,7,8,9) ) ");
		}

		if (input.isOperatoreConQualifica()) {
			q.append(" AND opfo.id_persona in (SELECT Qualifica.fk_persona FROM TAIF_T_QUALIFICA Qualifica)");
		}

		q.append(" ORDER BY  persona.COGNOME");

		sql = q;

		/*PROTECTED REGION END*/

		List<TaifTOpfoRicercaOperatoreAvanzataDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, ricercaOperatoreAvanzataRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTOpfoDaoImpl::findRicercaOperatoreAvanzata] ERROR esecuzione query", ex);
			throw new TaifTOpfoDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTOpfoDaoImpl", "findRicercaOperatoreAvanzata", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTOpfoDaoImpl::findRicercaOperatoreAvanzata] END");
		}
		return list;
	}

}
