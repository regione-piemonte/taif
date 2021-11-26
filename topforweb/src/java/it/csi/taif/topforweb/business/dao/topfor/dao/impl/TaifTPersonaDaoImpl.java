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

/*PROTECTED REGION ID(R1288938351) ENABLED START*/
// aggiungere qui eventuali import custom. 
import it.csi.taif.topforweb.util.ConvertUtil;
/*PROTECTED REGION END*/

/**
 * Implementazione del DAO taifTPersona.
 * Il DAO implementa le seguenti operazioni:
 * - INSERTER: 
 *   - (insert di default)
  * - FINDERS:
 *   - findByPrimaryKey (datagen::FindByPK)
 *   - findAll (datagen::FindAll)
 *   - datiIdentificativiOperatore (datagen::CustomFinder)
 *   - profiloUtenteByCodiceFiscale (datagen::CustomFinder)
 *   - byCodiceFiscalePersona (datagen::CustomFinder)
 *   - byFilter (datagen::CustomFinder)
 *   - loginInfo (datagen::CustomFinder)
 *   - anagraficaOperatoreByIdOperatore (datagen::CustomFinder)
 *   - operatoriCorsiPerPersona (datagen::CustomFinder)
 *   - qualifichePerPersona (datagen::CustomFinder)
 *   - riconoscimentiPerPersona (datagen::CustomFinder)
  * - UPDATERS:
 *   - byIdPersona (datagen::UpdateColumns)
 * - DELETERS:
 *   - delete (datagen::DeleteByPK)
 *
 * Le query sono realizzate utiulizzando spring-JDBCTemplate.
 * @generated
 */
public class TaifTPersonaDaoImpl extends AbstractDAO implements TaifTPersonaDao {
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
	 * Metodo di inserimento del DAO taifTPersona. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTPersonaPk
	 * @generated
	 */

	public TaifTPersonaPk insert(TaifTPersonaDto dto)

	{
		LOG.debug("[TaifTPersonaDaoImpl::insert] START");
		Integer newKey = Integer.valueOf(incrementer.nextIntValue());

		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	ID_PERSONA,FK_TITOLO_STUDIO,FK_TITOLO_STUDIO_FRA,FK_NAZIONE,CODICE_FISCALE,N_RSI_MSA,COGNOME,NOME,FLG_SESSO,DATA_NASCITA,ISTAT_COMUNE_NASCITA,COMUNE_ESTERO_NASCITA,ISTAT_COMUNE_RES,COMUNE_ESTERO_RES,INDIRIZZO_RES,CIVICO_RES,CAP_RES,TELEFONO,CELLULARE,MAIL,ALTRI_STUDI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,PWD ) VALUES (  :ID_PERSONA , :FK_TITOLO_STUDIO , :FK_TITOLO_STUDIO_FRA , :FK_NAZIONE , :CODICE_FISCALE , :N_RSI_MSA , :COGNOME , :NOME , :FLG_SESSO , :DATA_NASCITA , :ISTAT_COMUNE_NASCITA , :COMUNE_ESTERO_NASCITA , :ISTAT_COMUNE_RES , :COMUNE_ESTERO_RES , :INDIRIZZO_RES , :CIVICO_RES , :CAP_RES , :TELEFONO , :CELLULARE , :MAIL , :ALTRI_STUDI , :DATA_INSERIMENTO , :DATA_AGGIORNAMENTO , :FK_CONFIG_UTENTE , :PWD  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", newKey, java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TITOLO_STUDIO]
		params.addValue("FK_TITOLO_STUDIO", dto.getFkTitoloStudio(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_TITOLO_STUDIO_FRA]
		params.addValue("FK_TITOLO_STUDIO_FRA", dto.getFkTitoloStudioFra(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [FK_NAZIONE]
		params.addValue("FK_NAZIONE", dto.getFkNazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [N_RSI_MSA]
		params.addValue("N_RSI_MSA", dto.getNRsiMsa(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SESSO]
		params.addValue("FLG_SESSO", dto.getFlgSesso(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_NASCITA]
		params.addValue("DATA_NASCITA", dto.getDataNascita(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_NASCITA]
		params.addValue("ISTAT_COMUNE_NASCITA", dto.getIstatComuneNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_NASCITA]
		params.addValue("COMUNE_ESTERO_NASCITA", dto.getComuneEsteroNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_RES]
		params.addValue("ISTAT_COMUNE_RES", dto.getIstatComuneRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_RES]
		params.addValue("COMUNE_ESTERO_RES", dto.getComuneEsteroRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_RES]
		params.addValue("INDIRIZZO_RES", dto.getIndirizzoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO_RES]
		params.addValue("CIVICO_RES", dto.getCivicoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP_RES]
		params.addValue("CAP_RES", dto.getCapRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL]
		params.addValue("MAIL", dto.getMail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ALTRI_STUDI]
		params.addValue("ALTRI_STUDI", dto.getAltriStudi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_INSERIMENTO]
		params.addValue("DATA_INSERIMENTO", dto.getDataInserimento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [PWD]
		params.addValue("PWD", dto.getPwd(), java.sql.Types.VARCHAR);

		insert(jdbcTemplate, sql.toString(), params);

		dto.setIdPersona(newKey);
		LOG.debug("[TaifTPersonaDaoImpl::insert] END");
		return dto.createPk();

	}

	/** 
	 * Updates selected columns in the TAIF_T_PERSONA table.
	 * @generated
	 */
	public void updateColumnsByIdPersona(TaifTPersonaDto dto) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::updateColumnsByIdPersona] START");
		final String sql = "UPDATE " + getTableName()
				+ " SET FK_NAZIONE = :FK_NAZIONE ,COGNOME = :COGNOME ,FLG_SESSO = :FLG_SESSO ,DATA_NASCITA = :DATA_NASCITA ,ISTAT_COMUNE_NASCITA = :ISTAT_COMUNE_NASCITA ,COMUNE_ESTERO_NASCITA = :COMUNE_ESTERO_NASCITA ,ISTAT_COMUNE_RES = :ISTAT_COMUNE_RES ,COMUNE_ESTERO_RES = :COMUNE_ESTERO_RES ,INDIRIZZO_RES = :INDIRIZZO_RES ,CIVICO_RES = :CIVICO_RES ,CAP_RES = :CAP_RES ,TELEFONO = :TELEFONO ,CELLULARE = :CELLULARE ,MAIL = :MAIL ,ALTRI_STUDI = :ALTRI_STUDI ,DATA_AGGIORNAMENTO = :DATA_AGGIORNAMENTO ,FK_CONFIG_UTENTE = :FK_CONFIG_UTENTE  WHERE ID_PERSONA = :ID_PERSONA ";

		if (dto.getIdPersona() == null) {
			LOG.error("[TaifTPersonaDaoImpl::updateColumnsByIdPersona] ERROR chiave primaria non impostata");
			throw new TaifTPersonaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [FK_NAZIONE]
		params.addValue("FK_NAZIONE", dto.getFkNazione(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [FLG_SESSO]
		params.addValue("FLG_SESSO", dto.getFlgSesso(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_NASCITA]
		params.addValue("DATA_NASCITA", dto.getDataNascita(), java.sql.Types.DATE);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_NASCITA]
		params.addValue("ISTAT_COMUNE_NASCITA", dto.getIstatComuneNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_NASCITA]
		params.addValue("COMUNE_ESTERO_NASCITA", dto.getComuneEsteroNascita(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ISTAT_COMUNE_RES]
		params.addValue("ISTAT_COMUNE_RES", dto.getIstatComuneRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COMUNE_ESTERO_RES]
		params.addValue("COMUNE_ESTERO_RES", dto.getComuneEsteroRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [INDIRIZZO_RES]
		params.addValue("INDIRIZZO_RES", dto.getIndirizzoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CIVICO_RES]
		params.addValue("CIVICO_RES", dto.getCivicoRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CAP_RES]
		params.addValue("CAP_RES", dto.getCapRes(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [TELEFONO]
		params.addValue("TELEFONO", dto.getTelefono(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [CELLULARE]
		params.addValue("CELLULARE", dto.getCellulare(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [MAIL]
		params.addValue("MAIL", dto.getMail(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [ALTRI_STUDI]
		params.addValue("ALTRI_STUDI", dto.getAltriStudi(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [DATA_AGGIORNAMENTO]
		params.addValue("DATA_AGGIORNAMENTO", dto.getDataAggiornamento(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [FK_CONFIG_UTENTE]
		params.addValue("FK_CONFIG_UTENTE", dto.getFkConfigUtente(), java.sql.Types.INTEGER);

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", dto.getIdPersona(), java.sql.Types.INTEGER);

		update(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPersonaDaoImpl::updateColumnsByIdPersona] END");
	}

	/** 
	 * Deletes a single row in the TAIF_T_PERSONA table.
	 * @generated
	 */

	public void delete(TaifTPersonaPk pk) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName() + " WHERE ID_PERSONA = :ID_PERSONA ";

		if (pk == null) {
			LOG.error("[TaifTPersonaDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new TaifTPersonaDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		delete(jdbcTemplate, sql.toString(), params);
		LOG.debug("[TaifTPersonaDaoImpl::delete] END");
	}

	protected TaifTPersonaDaoRowMapper findByPrimaryKeyRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaDto.class, this);

	protected TaifTPersonaDaoRowMapper findAllRowMapper = new TaifTPersonaDaoRowMapper(null, TaifTPersonaDto.class,
			this);

	protected TaifTPersonaDaoRowMapper datiIdentificativiOperatoreRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaDatiIdentificativiOperatoreDto.class, this);

	protected TaifTPersonaDaoRowMapper profiloUtenteByCodiceFiscaleRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto.class, this);

	protected TaifTPersonaDaoRowMapper byCodiceFiscalePersonaRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByCodiceFiscalePersonaDto.class, this);

	protected TaifTPersonaDaoRowMapper byFilterRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaByFilterDto.class, this);

	protected TaifTPersonaDaoRowMapper loginInfoRowMapper = new TaifTPersonaDaoRowMapper(null, TaifTPersonaDto.class,
			this);

	protected TaifTPersonaDaoRowMapper anagraficaOperatoreByIdOperatoreRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaAnagraficaOperatoreByIdOperatoreDto.class, this);

	protected TaifTPersonaDaoRowMapper operatoriCorsiPerPersonaRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaOperatoriCorsiPerPersonaDto.class, this);

	protected TaifTPersonaDaoRowMapper qualifichePerPersonaRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaQualifichePerPersonaDto.class, this);

	protected TaifTPersonaDaoRowMapper riconoscimentiPerPersonaRowMapper = new TaifTPersonaDaoRowMapper(null,
			TaifTPersonaRiconoscimentiPerPersonaDto.class, this);

	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_PERSONA";
	}

	/** 
	 * Returns all rows from the TAIF_T_PERSONA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTPersonaDto findByPrimaryKey(TaifTPersonaPk pk) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByPrimaryKey] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,FK_TITOLO_STUDIO,FK_TITOLO_STUDIO_FRA,FK_NAZIONE,CODICE_FISCALE,N_RSI_MSA,COGNOME,NOME,FLG_SESSO,DATA_NASCITA,ISTAT_COMUNE_NASCITA,COMUNE_ESTERO_NASCITA,ISTAT_COMUNE_RES,COMUNE_ESTERO_RES,INDIRIZZO_RES,CIVICO_RES,CAP_RES,TELEFONO,CELLULARE,MAIL,ALTRI_STUDI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,PWD FROM "
						+ getTableName() + " WHERE ID_PERSONA = :ID_PERSONA ");

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [ID_PERSONA]
		params.addValue("ID_PERSONA", pk.getIdPersona(), java.sql.Types.INTEGER);

		List<TaifTPersonaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findByPrimaryKeyRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByPrimaryKey] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByPrimaryKey", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByPrimaryKey] END");
		}
		return list.isEmpty() ? null : list.get(0);
	}

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_PERSONA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPersonaDto> findAll() throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findAll] START");
		final StringBuilder sql = new StringBuilder(
				"SELECT ID_PERSONA,FK_TITOLO_STUDIO,FK_TITOLO_STUDIO_FRA,FK_NAZIONE,CODICE_FISCALE,N_RSI_MSA,COGNOME,NOME,FLG_SESSO,DATA_NASCITA,ISTAT_COMUNE_NASCITA,COMUNE_ESTERO_NASCITA,ISTAT_COMUNE_RES,COMUNE_ESTERO_RES,INDIRIZZO_RES,CIVICO_RES,CAP_RES,TELEFONO,CELLULARE,MAIL,ALTRI_STUDI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,PWD FROM "
						+ getTableName());

		MapSqlParameterSource params = new MapSqlParameterSource();

		List<TaifTPersonaDto> list = null;

		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), params, findAllRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findAll] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findAll", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findAll] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder datiIdentificativiOperatore con Qdef
		 * @generated
		 */

	public List<TaifTPersonaDatiIdentificativiOperatoreDto> findDatiIdentificativiOperatore(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findDatiIdentificativiOperatore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT o.FLG_PUBBLICO as pubblico, p.ID_PERSONA as idPersona, p.FK_TITOLO_STUDIO as idTitoloStudio, tita.TITOLO_STUDIO as titoloStudioIta, p.FK_TITOLO_STUDIO_FRA as idTitoloStudioFra, tfra.TITOLO_STUDIO as titoloStudioFra, p.FK_NAZIONE as idNazione, p.CODICE_FISCALE as codiceFiscale, p.N_RSI_MSA as nRsiMsa, p.COGNOME as cognome, p.NOME as nome, p.FLG_SESSO as sesso, p.DATA_NASCITA as dataNascita, p.ISTAT_COMUNE_NASCITA as istatComuneNascita, p.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, p.ISTAT_COMUNE_RES as istatComuneResidenza, p.COMUNE_ESTERO_RES as comuneEsteroResidenza, p.INDIRIZZO_RES as indirizzoResidenza, p.CIVICO_RES as civicoResidenza, p.CAP_RES as capResidenza, p.TELEFONO as telefono, p.CELLULARE as cellulare, p.MAIL as emailPersonale, p.ALTRI_STUDI as altriStudi, sogg.DENOMINAZIONE_BREVE as elencoAppartenenza, s.STATO_OPFO_ITA as statoSchedaIta, s.STATO_OPFO_FRA as statoSchedaFra, n.NAZIONE_ITA as nazioneNascitaIta, n.NAZIONE_FRA as nazioneNascitaFra, sogg.ID_SOGGETTO_GESTORE as idSoggettoGestore, sogg.URL_DOC_PRIVACY as urlPrivacy");

		sql.append(
				" FROM TAIF_T_PERSONA p, TAIF_T_OPFO o, TAIF_T_SOGGETTO_GESTORE sogg, TAIF_D_STATO_OPFO s, TAIF_D_NAZIONE n, TAIF_D_TITOLO_STUDIO tita, TAIF_D_TITOLO_STUDIO tfra");

		sql.append(" WHERE ");

		sql.append(
				"o.ID_PERSONA = p.ID_PERSONA AND n.ID_NAZIONE = p.FK_NAZIONE AND o.FK_STATO_OPFO = s.ID_STATO_OPFO AND o.FK_SOGGETTO_GESTORE = sogg.ID_SOGGETTO_GESTORE AND p.FK_TITOLO_STUDIO = tita.ID_TITOLO_STUDIO AND p.FK_TITOLO_STUDIO_FRA = tfra.ID_TITOLO_STUDIO");

		sql.append(" AND ");

		sql.append("1=1");
		/*PROTECTED REGION ID(R-531225905) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:
		if (ConvertUtil.checkIsNullOrEmpty(input.getIdPersona())) {
			sql.append(" AND p.id_persona = :idPersona");
			paramMap.addValue("idPersona", new Integer(input.getIdPersona()));
		} else if (ConvertUtil.checkIsNullOrEmpty(input.getCodiceFiscale())) {
			sql.append(" AND p.codice_fiscale = :codiceFiscale");
			paramMap.addValue("codiceFiscale", input.getCodiceFiscale());
		} else {
			sql.append(" AND p.n_rsi_msa = :nRsiMsa");
			paramMap.addValue("nRsiMsa", input.getnRsiMsa());
		}

		if (ConvertUtil.checkIsNullOrEmpty(input.getIdSoggettoGestore())) {
			sql.append(" AND sogg.ID_SOGGETTO_GESTORE = :idSoggettoGestore");
			paramMap.addValue("idSoggettoGestore", new Integer(input.getIdSoggettoGestore()));
		}

		/*PROTECTED REGION END*/

		List<TaifTPersonaDatiIdentificativiOperatoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, datiIdentificativiOperatoreRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findDatiIdentificativiOperatore] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findDatiIdentificativiOperatore", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findDatiIdentificativiOperatore] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder profiloUtenteByCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> findProfiloUtenteByCodiceFiscale(
			it.csi.taif.topforweb.business.dao.topfor.filter.ConfigProfiloFilter input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findProfiloUtenteByCodiceFiscale] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT personaTable.ID_PERSONA as idPersona, personaTable.FK_TITOLO_STUDIO as idTitolo, personaTable.FK_TITOLO_STUDIO_FRA as idTitoloFra, personaTable.FK_NAZIONE as idNazione, personaTable.CODICE_FISCALE as codiceFiscale, personaTable.N_RSI_MSA as rsiMsa, personaTable.COGNOME as cognome, personaTable.NOME as nome, personaTable.FLG_SESSO as sesso, personaTable.DATA_NASCITA as dataNascita, personaTable.ISTAT_COMUNE_NASCITA as istatComuneNascita, personaTable.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, personaTable.ISTAT_COMUNE_RES as istatComuneResidenza, personaTable.COMUNE_ESTERO_RES as comuneEsteroResidenza, personaTable.INDIRIZZO_RES as indirizzoResidenza, personaTable.CIVICO_RES as civicoResidenza, personaTable.CAP_RES as cap, personaTable.TELEFONO as telefon, personaTable.CELLULARE as cellulare, personaTable.MAIL as mail, personaTable.ALTRI_STUDI as altriStudi, configUtenteTable.FK_PROFILO_UTENTE as idProfiloUtente, profiloUtenteTable.PROFILO_UTENTE as profiloUtente, profiloUtenteTable.MTD_FLG_ATTIVO as flagUtenteAttivo, proceduraTable.ID_PROCEDURA as idProceduraUtente, configUtenteTable.ID_CONFIG_UTENTE as idConfigUtente, configUtenteTable.FK_SOGGETTO_GESTORE as idSoggettoGestore");

		sql.append(
				" FROM TAIF_T_PERSONA personaTable, TAIF_CNF_CONFIG_UTENTE configUtenteTable, TAIF_CNF_PROFILO_UTENTE profiloUtenteTable, TAIF_CNF_PROCEDURA proceduraTable");

		sql.append(" WHERE ");

		sql.append(
				"personaTable.ID_PERSONA = configUtenteTable.FK_PERSONA AND configUtenteTable.FK_PROFILO_UTENTE = profiloUtenteTable.ID_PROFILO_UTENTE AND profiloUtenteTable.FK_PROCEDURA = proceduraTable.ID_PROCEDURA");

		sql.append(" AND ");

		sql.append("proceduraTable.id_procedura=:idprocedura and profiloUtenteTable.mtd_flg_attivo=:flagAttivo");
		/*PROTECTED REGION ID(R1837132899) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		if (input.getDataTracciato().equals("I")) {
			sql.append(" AND ");
			sql.append("personaTable.codice_fiscale like :codiceFiscale");
		} else {
			sql.append(" AND ");
			sql.append("personaTable.n_rsi_msa like :codiceFiscale");
		}
		
		String codiceFiscale =  "%" + input.getCodiceFiscale() + "%";
		paramMap.addValue("codiceFiscale",codiceFiscale);
		paramMap.addValue("idprocedura", input.getIdProcedura());
		paramMap.addValue("flagAttivo", input.getFlagAttivo());

		/*PROTECTED REGION END*/

		List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, profiloUtenteByCodiceFiscaleRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findProfiloUtenteByCodiceFiscale] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findProfiloUtenteByCodiceFiscale", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findProfiloUtenteByCodiceFiscale] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byCodiceFiscalePersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByCodiceFiscalePersonaDto> findByCodiceFiscalePersona(java.lang.String input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByCodiceFiscalePersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT personaTabella.ID_PERSONA as idPersona, personaTabella.FK_TITOLO_STUDIO as idTitoloStudio, personaTabella.FK_TITOLO_STUDIO_FRA as idTitoloFra, personaTabella.FK_NAZIONE as idNazione, personaTabella.CODICE_FISCALE as codiceFiscale, personaTabella.N_RSI_MSA as nsiMsa, personaTabella.COGNOME as cognome, personaTabella.NOME as nome, personaTabella.FLG_SESSO as sesso, personaTabella.DATA_NASCITA as dataNascita, personaTabella.ISTAT_COMUNE_NASCITA as istatComuneNascita, personaTabella.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, personaTabella.COMUNE_ESTERO_RES as comuneEsteroResidenza, personaTabella.ISTAT_COMUNE_RES as istatComuneResidenza, personaTabella.INDIRIZZO_RES as indirizzoResidenza, personaTabella.CIVICO_RES as civicoResidenza, personaTabella.CAP_RES as cap, personaTabella.TELEFONO as telefono, personaTabella.CELLULARE as cellulare, personaTabella.MAIL as eMail, personaTabella.ALTRI_STUDI as altriStudi");

		sql.append(" FROM TAIF_T_PERSONA personaTabella");

		sql.append(" WHERE ");

		sql.append("personaTabella.codice_fiscale=:codiceFiscale");
		/*PROTECTED REGION ID(R-298253947) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceFiscale", input);

		/*PROTECTED REGION END*/

		List<TaifTPersonaByCodiceFiscalePersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byCodiceFiscalePersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByCodiceFiscalePersona] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByCodiceFiscalePersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByCodiceFiscalePersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByFilterDto> findByFilter(
			it.csi.taif.topforweb.business.dao.topfor.filter.PersonaFilter input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findByFilter] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT persona.ID_PERSONA as idPersona, persona.FK_TITOLO_STUDIO as idTitoloStudio, persona.FK_TITOLO_STUDIO_FRA as idTitoloFra, persona.FK_NAZIONE as idNazione, persona.CODICE_FISCALE as codiceFiscale, persona.N_RSI_MSA as nsiMsa, persona.COGNOME as cognome, persona.NOME as nome, persona.FLG_SESSO as sesso, persona.DATA_NASCITA as dataNascita, persona.ISTAT_COMUNE_NASCITA as istatComuneNascita, persona.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, persona.ISTAT_COMUNE_RES as istatComuneResidenza, persona.INDIRIZZO_RES as indirizzoResidenza, persona.CIVICO_RES as civicoResidenza, persona.CAP_RES as cap, persona.TELEFONO as telefono, persona.CELLULARE as cellulare, persona.MAIL as eMail, persona.ALTRI_STUDI as altriStudi");

		sql.append(" FROM TAIF_T_PERSONA persona");

		sql.append(" WHERE ");

		sql.append(
				"persona.fk_nazione = :nazioneUtente and ( persona.codice_fiscale = :codiceIdentificativo or persona.n_rsi_msa = :codiceIdentificativo )");
		/*PROTECTED REGION ID(R85329669) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("codiceIdentificativo", input.getCodiceFiscale());
		paramMap.addValue("nazioneUtente", input.getIdNazione());

		/*PROTECTED REGION END*/

		List<TaifTPersonaByFilterDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, byFilterRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findByFilter] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findByFilter", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findByFilter] END");
		}
		return list;
	}

	/** 
	 * Implementazione del finder loginInfo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPersonaDto> findLoginInfo(it.csi.taif.topforweb.dto.common.LoginInfo input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findLoginInfo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT ID_PERSONA,FK_TITOLO_STUDIO,FK_TITOLO_STUDIO_FRA,FK_NAZIONE,CODICE_FISCALE,N_RSI_MSA,COGNOME,NOME,FLG_SESSO,DATA_NASCITA,ISTAT_COMUNE_NASCITA,COMUNE_ESTERO_NASCITA,ISTAT_COMUNE_RES,COMUNE_ESTERO_RES,INDIRIZZO_RES,CIVICO_RES,CAP_RES,TELEFONO,CELLULARE,MAIL,ALTRI_STUDI,DATA_INSERIMENTO,DATA_AGGIORNAMENTO,FK_CONFIG_UTENTE,PWD ");
		sql.append(" FROM TAIF_T_PERSONA");
		sql.append(" WHERE ");
		/*PROTECTED REGION ID(R289209113) ENABLED START*/
		// personalizzare la query SQL relativa al finder
		sql.append("upper(N_RSI_MSA) = upper(:loginuser) AND PWD = (CRYPT(:password, PWD))");
		// personalizzare l'elenco dei parametri da passare al jdbctemplate (devono corrispondere in tipo e
		// numero ai parametri definiti nella queryString)

		/*PROTECTED REGION END*/
		/*PROTECTED REGION ID(R500434161) ENABLED START*/
		//***aggiungere tutte le condizioni

		paramMap.addValue("loginuser", input.getUser());
		paramMap.addValue("password", input.getPassword());

		/*PROTECTED REGION END*/
		List<TaifTPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);
		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, loginInfoRowMapper);

		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findLoginInfo] esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findLoginInfo", "esecuzione query", sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findLoginInfo] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder anagraficaOperatoreByIdOperatore con Qdef
		 * @generated
		 */

	public List<TaifTPersonaAnagraficaOperatoreByIdOperatoreDto> findAnagraficaOperatoreByIdOperatore(
			java.lang.Integer input) throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findAnagraficaOperatoreByIdOperatore] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT soggettoGestoreTab.ID_SOGGETTO_GESTORE as idSoggettoGestore, soggettoGestoreTab.DENOMINAZIONE_BREVE as denominazioneSoggettoGestore, personaTab.ID_PERSONA as idPersona, personaTab.CODICE_FISCALE as codiceFiscalePersona, personaTab.N_RSI_MSA as nRsiMsa, personaTab.COGNOME as cognomePersona, personaTab.NOME as nomePersona, personaTab.DATA_NASCITA as dataNascita, personaTab.FK_NAZIONE as idNazione, personaTab.ISTAT_COMUNE_NASCITA as istatComuneNascita, personaTab.COMUNE_ESTERO_NASCITA as comuneEsteroNascita, personaTab.ISTAT_COMUNE_RES as istatComuneResidenza, personaTab.COMUNE_ESTERO_RES as comuneEsteroResidenza, personaTab.INDIRIZZO_RES as indirizzoResidenza, personaTab.CIVICO_RES as civicoResidenza, personaTab.CAP_RES as capResidenza, personaTab.TELEFONO as telefono, personaTab.CELLULARE as cellulare, personaTab.MAIL as mailPersonale, opfoTab.FLG_PUBBLICO as flagPubblico, statoOpfoTab.STATO_OPFO_ITA as statoOpfoIta, soggettoGestoreTab.URL_DOC_PRIVACY as urlPrivacy");

		sql.append(
				" FROM TAIF_T_PERSONA personaTab, TAIF_T_OPFO opfoTab, TAIF_T_SOGGETTO_GESTORE soggettoGestoreTab, TAIF_D_STATO_OPFO statoOpfoTab");

		sql.append(" WHERE ");

		sql.append(
				"personaTab.ID_PERSONA = opfoTab.ID_PERSONA AND opfoTab.FK_SOGGETTO_GESTORE = soggettoGestoreTab.ID_SOGGETTO_GESTORE AND opfoTab.FK_STATO_OPFO = statoOpfoTab.ID_STATO_OPFO");

		sql.append(" AND ");

		sql.append("personaTab.id_persona =:idPersona");
		/*PROTECTED REGION ID(R418147171) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input);

		/*PROTECTED REGION END*/

		List<TaifTPersonaAnagraficaOperatoreByIdOperatoreDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, anagraficaOperatoreByIdOperatoreRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findAnagraficaOperatoreByIdOperatore] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findAnagraficaOperatoreByIdOperatore", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findAnagraficaOperatoreByIdOperatore] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder operatoriCorsiPerPersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaOperatoriCorsiPerPersonaDto> findOperatoriCorsiPerPersona(java.lang.Integer input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findOperatoriCorsiPerPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT personaTab.ID_PERSONA as idPersona, personaTab.CODICE_FISCALE as codiceFiscalePersona, personaTab.N_RSI_MSA as nRsiMsa, personaTab.COGNOME as cognomePersona, personaTab.NOME as nomePersona, corsoTab.CORSO as corso, corsoTab.DATA_INIZIO as dataInizioCorso, corsoTab.DATA_FINE as dataFineCorso, corsoTab.NRO_ORE as numeroOreCorso, agenziaFormativaTab.RAGIONE_SOCIALE as ragioneSocialeAgenzia, unitaFormativaTab.SIGLA as siglaUnitaFormativa, unitaFormativaTab.UNITA_FORMATIVA as unitaFormativa, opfoCorsoRel.DESCRIZIONE_ALTRO as altroDescrizione");

		sql.append(
				" FROM TAIF_T_PERSONA personaTab, TAIF_T_OPFO opfoTab, TAIF_R_OPFO_CORSO opfoCorsoRel, TAIF_T_CORSO corsoTab, TAIF_T_AGENZIA_FORMATIVA agenziaFormativaTab, TAIF_D_UNITA_FORMATIVA unitaFormativaTab");

		sql.append(" WHERE ");

		sql.append(
				"personaTab.ID_PERSONA = opfoTab.ID_PERSONA AND opfoTab.ID_PERSONA = opfoCorsoRel.ID_PERSONA AND opfoCorsoRel.ID_CORSO = corsoTab.ID_CORSO AND corsoTab.FK_UNITA_FORMATIVA = unitaFormativaTab.ID_UNITA_FORMATIVA AND corsoTab.FK_AGENZIA_FORMATIVA = agenziaFormativaTab.ID_AGENZIA_FORMATIVA");

		sql.append(" AND ");

		sql.append("personaTab.id_persona =:idPersona");
		/*PROTECTED REGION ID(R-1782736946) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input);

		/*PROTECTED REGION END*/

		List<TaifTPersonaOperatoriCorsiPerPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, operatoriCorsiPerPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findOperatoriCorsiPerPersona] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findOperatoriCorsiPerPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findOperatoriCorsiPerPersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder qualifichePerPersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaQualifichePerPersonaDto> findQualifichePerPersona(java.lang.Integer input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findQualifichePerPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT personaTab.ID_PERSONA as idPersona, personaTab.CODICE_FISCALE as codiceFiscalePersona, personaTab.N_RSI_MSA as nRsiMsa, personaTab.COGNOME as cognomePersona, personaTab.NOME as nomePersona, tipoQualificaTab.TIPO_QUALIFICA as tipoQualifica, qualificaTab.DATA_RILASCIO as dataRilascio, agenziaFormativaTab.RAGIONE_SOCIALE as ragioneSocialeAgenzia");

		sql.append(
				" FROM TAIF_T_PERSONA personaTab, TAIF_T_OPFO opfoTab, TAIF_T_QUALIFICA qualificaTab, TAIF_T_AGENZIA_FORMATIVA agenziaFormativaTab, TAIF_D_TIPO_QUALIFICA tipoQualificaTab");

		sql.append(" WHERE ");

		sql.append(
				"personaTab.ID_PERSONA = opfoTab.ID_PERSONA AND opfoTab.ID_PERSONA = qualificaTab.FK_PERSONA AND qualificaTab.FK_TIPO_QUALIFICA = tipoQualificaTab.ID_TIPO_QUALIFICA AND qualificaTab.FK_AGENZIA_FORMATIVA = agenziaFormativaTab.ID_AGENZIA_FORMATIVA");

		sql.append(" AND ");

		sql.append("personaTab.id_persona =:idPersona");
		/*PROTECTED REGION ID(R397193506) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input);

		/*PROTECTED REGION END*/

		List<TaifTPersonaQualifichePerPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, qualifichePerPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findQualifichePerPersona] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findQualifichePerPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findQualifichePerPersona] END");
		}
		return list;
	}

	/** 
		 * Implementazione del finder riconoscimentiPerPersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaRiconoscimentiPerPersonaDto> findRiconoscimentiPerPersona(java.lang.Integer input)
			throws TaifTPersonaDaoException {
		LOG.debug("[TaifTPersonaDaoImpl::findRiconoscimentiPerPersona] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append(
				"SELECT personaTab.ID_PERSONA as idPersona, personaTab.CODICE_FISCALE as codiceFiscalePersona, personaTab.N_RSI_MSA as nRsiMsa, personaTab.COGNOME as cognomePersona, personaTab.NOME as nomePersona, unitaFormativaTab.SIGLA as siglaUnitaFormativa, riconoscimentoTab.DATA_RICONOSCIMENTO as dataRiconoscimento, agenziaFormativaTab.RAGIONE_SOCIALE as ragioneSocialeAgenzia, unitaFormativaTab.UNITA_FORMATIVA as unitaFormativa");

		sql.append(
				" FROM TAIF_T_PERSONA personaTab, TAIF_T_OPFO opfoTab, TAIF_T_RICONOSCIMENTO riconoscimentoTab, TAIF_T_AGENZIA_FORMATIVA agenziaFormativaTab, TAIF_D_UNITA_FORMATIVA unitaFormativaTab");

		sql.append(" WHERE ");

		sql.append(
				"personaTab.ID_PERSONA = opfoTab.ID_PERSONA AND opfoTab.ID_PERSONA = riconoscimentoTab.FK_PERSONA AND unitaFormativaTab.ID_UNITA_FORMATIVA = riconoscimentoTab.FK_UNITA_FORMATIVA AND riconoscimentoTab.FK_AGENZIA_FORMATIVA = agenziaFormativaTab.ID_AGENZIA_FORMATIVA");

		sql.append(" AND ");

		sql.append("personaTab.id_persona =:idPersona");
		/*PROTECTED REGION ID(R1265384143) ENABLED START*/ //inserire qui i parametri indicati nella espressione di where, ad esempio:

		paramMap.addValue("idPersona", input);

		/*PROTECTED REGION END*/

		List<TaifTPersonaRiconoscimentiPerPersonaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, riconoscimentiPerPersonaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTPersonaDaoImpl::findRiconoscimentiPerPersona] ERROR esecuzione query", ex);
			throw new TaifTPersonaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTPersonaDaoImpl", "findRiconoscimentiPerPersona", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTPersonaDaoImpl::findRiconoscimentiPerPersona] END");
		}
		return list;
	}

}
