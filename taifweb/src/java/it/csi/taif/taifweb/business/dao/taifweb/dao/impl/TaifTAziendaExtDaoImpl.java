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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class TaifTAziendaExtDaoImpl extends AbstractDAO implements TaifTAziendaExtDao {
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
	 * Metodo di inserimento del DAO taifTAzienda. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAziendaPk
	 * @generated
	 */

	
	protected TaifTAziendaExtDaoRowMapper intestazioneRiepilogoRowMapper = new TaifTAziendaExtDaoRowMapper(null,
			TaifTAziendaIntestazioneRiepilogoDto.class, this);
	
	
	protected TaifTAziendaExtDaoRowMapper intestazioneRiepilogoByPraticaRowMapper = new TaifTAziendaExtDaoRowMapper(null,
			TaifTAziendaIntestazioneRiepilogoByPraticaDto.class, this);
	
	
	/**
	 * 
	 * Restituisce il nome della tabella su cui opera il DAO
	 * @return String
	 * @generated
	 */
	public String getTableName() {
		return "TAIF_T_AZIENDA";
	}

	
	public List<TaifTAziendaIntestazioneRiepilogoDto> findIntestazioneRiepilogo(java.lang.Integer idAzienda,
			java.lang.Integer input) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaExtDaoImpl::findIntestazioneRiepilogo] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT a.RAGIONE_SOCIALE, a.CODICE_FISCALE, a.PARTITA_IVA, p.DATA_AGGIORNAMENTO, sp.STATO_PRATICA_ITA, sp.STATO_PRATICA_FRA");
		sql.append(" FROM TAIF_T_AZIENDA a, TAIF_T_PRATICA p, TAIF_D_STATO_PRATICA sp, TAIF_T_STORICO_STATO ss");
		sql.append(" INNER JOIN ");
		sql.append("(SELECT fk_stato_pratica, max(data_aggiornamento) as data_agg ");
		sql.append("FROM taif_t_storico_stato ");
		sql.append("GROUP BY fk_stato_pratica) s ");
		sql.append("ON s.data_agg = ss.data_aggiornamento ");
		sql.append("AND s.fk_stato_pratica = ss.fk_stato_pratica ");
		sql.append("WHERE a.id_azienda = :idAzienda ");
		sql.append("AND p.fk_azienda = a.id_azienda ");
		sql.append("AND p.fk_soggetto_gestore = :idAlbo ");
		sql.append("AND p.id_pratica = ss.id_pratica "); 
		sql.append("AND ss.fk_stato_pratica = sp.id_stato_pratica ");
		
		paramMap.addValue("idAzienda", idAzienda);
		paramMap.addValue("idAlbo", input);

		List<TaifTAziendaIntestazioneRiepilogoDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, intestazioneRiepilogoRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaExtDaoImpl::findIntestazioneRiepilogo] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaExtDaoImpl", "findIntestazioneRiepilogo", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaExtDaoImpl::findIntestazioneRiepilogo] END");
		}
		return list;
	}
	
	public List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> findIntestazioneRiepilogoByPratica(
			java.lang.Integer input) throws TaifTAziendaDaoException {
		LOG.debug("[TaifTAziendaDaoImpl::findIntestazioneRiepilogoByPratica] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT aziendaTab.ID_AZIENDA as idAzienda, ");
		sql.append("aziendaTab.RAGIONE_SOCIALE as ragioneSocialeAzienda, ");
		sql.append("aziendaTab.CODICE_FISCALE as codiceFiscaleAzienda, ");
		sql.append("aziendaTab.PARTITA_IVA as pivaAzienda, ");
		sql.append("aziendaTab.N_SIRET as nSiret, ");
		sql.append("aziendaTab.DATA_AGGIORNAMENTO as dataAggiornamento, ");
		sql.append("statoPraticaTab.STATO_PRATICA_ITA as statoPraticaItalia, ");
		sql.append("statoPraticaTab.STATO_PRATICA_FRA as statoPraticaFrance, ");
		sql.append("praticaTab.ID_PRATICA as idPratica, ");
		sql.append("praticaTab.DATA_AGGIORNAMENTO as dataAggiornamentoPratica, ");
		sql.append("praticaTab.FK_SOGGETTO_GESTORE as idSoggettoGestore, ");
		sql.append("storicoStatoTab.FK_STATO_PRATICA as idStatoPratica, ");
		sql.append("personaTab.COGNOME as operatoreCognome, ");
		sql.append("personaTab.NOME as operatoreNome, ");
		sql.append("praticaTab.DATA_ISCRIZIONE_ALBO as dataIscrizioneAlbo, ");
		sql.append("praticaTab.NUMERO_ALBO as numeroIscrizioneAlbo, ");
		sql.append("storicoStatoAvvioTab.NUMERO_PROTOCOLLO as numeroProtocollo, ");
		sql.append("storicoStatoAvvioTab.DATA_PROTOCOLLO as dataProtocollo");
		sql.append(" FROM TAIF_T_AZIENDA aziendaTab,");  
		sql.append("TAIF_T_PRATICA praticaTab "); 
		sql.append("left outer join taif_t_storico_stato storicoStatoAvvioTab on(");
		sql.append("praticatab.id_pratica = storicoStatoAvvioTab.id_pratica and ");
		sql.append("storicoStatoAvvioTab.fk_stato_pratica = :idStatoPratica), ");
		sql.append("TAIF_D_STATO_PRATICA statoPraticaTab, ");
		sql.append("TAIF_T_STORICO_STATO storicoStatoTab, ");
		sql.append("TAIF_CNF_CONFIG_UTENTE configTab, ");
		sql.append("TAIF_T_PERSONA personaTab ");
		sql.append("WHERE aziendaTab.ID_AZIENDA = praticaTab.FK_AZIENDA ");
		sql.append("AND praticaTab.ID_PRATICA = storicoStatoTab.ID_PRATICA "); 
		sql.append("AND storicoStatoTab.FK_STATO_PRATICA = statoPraticaTab.ID_STATO_PRATICA "); 
		sql.append("AND aziendaTab.FK_CONFIG_UTENTE = configTab.ID_CONFIG_UTENTE "); 
		sql.append("AND configTab.FK_PERSONA = personaTab.ID_PERSONA ");
		sql.append("AND praticaTab.ID_PRATICA  = :idPratica "); 
		sql.append("AND storicoStatoTab.DATA_FINE_STATO is null ");
		sql.append("ORDER BY storicoStatoAvvioTab.data_inserimento_stato DESC ");
				
		paramMap.addValue("idPratica", input);
		paramMap.addValue("idStatoPratica", it.csi.taif.taifweb.util.Constants.STATO_PRESENTATA);

		
		List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> list = null;
		StopWatch stopWatch = new StopWatch(Constants.APPLICATION_CODE);

		try {
			stopWatch.start();
			list = jdbcTemplate.query(sql.toString(), paramMap, intestazioneRiepilogoByPraticaRowMapper);
		} catch (RuntimeException ex) {
			LOG.error("[TaifTAziendaDaoImpl::findIntestazioneRiepilogoByPratica] ERROR esecuzione query", ex);
			throw new TaifTAziendaDaoException("Query failed", ex);
		} finally {
			stopWatch.dumpElapsed("TaifTAziendaDaoImpl", "findIntestazioneRiepilogoByPratica", "esecuzione query",
					sql.toString());
			LOG.debug("[TaifTAziendaDaoImpl::findIntestazioneRiepilogoByPratica] END");
		}
		return list;
	}

}
