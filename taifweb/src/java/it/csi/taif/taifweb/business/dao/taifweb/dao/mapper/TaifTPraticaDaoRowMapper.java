/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dao.mapper;

import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.impl.BaseDaoRowMapper;
import it.csi.taif.taifweb.business.dao.taifweb.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO TaifTPraticaDao
 * @generated
 */
public class TaifTPraticaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTPraticaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTPraticaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTPraticaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTPraticaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPraticaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTPraticaDto) {
			return mapRow_internal((TaifTPraticaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTPraticaByIdAziendaDto) {
			return mapRow_internal((TaifTPraticaByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPraticaByIdGestoreDto) {
			return mapRow_internal((TaifTPraticaByIdGestoreDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPraticaByNumeroAlboDto) {
			return mapRow_internal((TaifTPraticaByNumeroAlboDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPraticaByIdAziendaAlboDto) {
			return mapRow_internal((TaifTPraticaByIdAziendaAlboDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPraticaAltriAlbiByIdAziendaDto) {
			return mapRow_internal((TaifTPraticaAltriAlbiByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPraticaDettaglioPraticaPerInvioDto) {
			return mapRow_internal((TaifTPraticaDettaglioPraticaPerInvioDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPraticaMaxAlboNumberValueDto) {
			return mapRow_internal((TaifTPraticaMaxAlboNumberValueDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTPraticaDto mapRow_internal(TaifTPraticaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPraticaDto dto = objectToFill;

		// colonna [ID_PRATICA]
		if (mapAllColumns || columnsToReadMap.get("ID_PRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("ID_PRATICA"));

		// colonna [FK_SOGGETTO_GESTORE]
		if (mapAllColumns || columnsToReadMap.get("FK_SOGGETTO_GESTORE") != null)
			dto.setFkSoggettoGestore((Integer) rs.getObject("FK_SOGGETTO_GESTORE"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [DATA_PRESENTAZIONE]
		if (mapAllColumns || columnsToReadMap.get("DATA_PRESENTAZIONE") != null)
			dto.setDataPresentazione(rs.getDate("DATA_PRESENTAZIONE"));

		// colonna [DATA_ISCRIZIONE_ALBO]
		if (mapAllColumns || columnsToReadMap.get("DATA_ISCRIZIONE_ALBO") != null)
			dto.setDataIscrizioneAlbo(rs.getDate("DATA_ISCRIZIONE_ALBO"));

		// colonna [NUMERO_ALBO]
		if (mapAllColumns || columnsToReadMap.get("NUMERO_ALBO") != null)
			dto.setNumeroAlbo(rs.getString("NUMERO_ALBO"));

		// colonna [FLG_SEZIONE]
		if (mapAllColumns || columnsToReadMap.get("FLG_SEZIONE") != null)
			dto.setFlgSezione(rs.getString("FLG_SEZIONE"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [DENOMINAZIONE_ALTRO_ALBO]
		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_ALTRO_ALBO") != null)
			dto.setDenominazioneAltroAlbo(rs.getString("DENOMINAZIONE_ALTRO_ALBO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPraticaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPraticaByIdAziendaDto
	 * @generated
	 */

	public TaifTPraticaByIdAziendaDto mapRow_internal(TaifTPraticaByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPraticaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("NRALBO") != null)
			dto.setNrAlbo(rs.getString("nrAlbo"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEALTROALBO") != null)
			dto.setDenominazioneAltroAlbo(rs.getString("denominazioneAltroAlbo"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("FLAGSEZIONE") != null)
			dto.setFlagSezione(rs.getString("flagSezione"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSCRIZIONEALBO") != null)
			dto.setDataInscrizioneAlbo(rs.getDate("dataInscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("DATAPRESENTAZIONE") != null)
			dto.setDataPresentazione(rs.getDate("dataPresentazione"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPraticaByIdGestoreDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPraticaByIdGestoreDto
	 * @generated
	 */

	public TaifTPraticaByIdGestoreDto mapRow_internal(TaifTPraticaByIdGestoreDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPraticaByIdGestoreDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("NRALBO") != null)
			dto.setNrAlbo(rs.getString("nrAlbo"));

		if (mapAllColumns || columnsToReadMap.get("DENOM") != null)
			dto.setDenom(rs.getString("denom"));

		if (mapAllColumns || columnsToReadMap.get("GESTORE") != null)
			dto.setGestore((Integer) rs.getObject("gestore"));

		if (mapAllColumns || columnsToReadMap.get("SEZIONE") != null)
			dto.setSezione(rs.getString("sezione"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPraticaByNumeroAlboDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPraticaByNumeroAlboDto
	 * @generated
	 */

	public TaifTPraticaByNumeroAlboDto mapRow_internal(TaifTPraticaByNumeroAlboDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPraticaByNumeroAlboDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("SOGGETTO") != null)
			dto.setSoggetto((Integer) rs.getObject("soggetto"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGG") != null)
			dto.setDataAgg(rs.getTimestamp("dataAgg"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPraticaByIdAziendaAlboDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPraticaByIdAziendaAlboDto
	 * @generated
	 */

	public TaifTPraticaByIdAziendaAlboDto mapRow_internal(TaifTPraticaByIdAziendaAlboDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTPraticaByIdAziendaAlboDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPRATICA") != null)
			dto.setIdPratica((Integer) rs.getObject("idPratica"));

		if (mapAllColumns || columnsToReadMap.get("NRALBO") != null)
			dto.setNrAlbo(rs.getString("nrAlbo"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEALTROALBO") != null)
			dto.setDenominazioneAltroAlbo(rs.getString("denominazioneAltroAlbo"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("FLAGSEZIONE") != null)
			dto.setFlagSezione(rs.getString("flagSezione"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSCRIZIONEALBO") != null)
			dto.setDataInscrizioneAlbo(rs.getDate("dataInscrizioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("DATAPRESENTAZIONE") != null)
			dto.setDataPresentazione(rs.getDate("dataPresentazione"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTIONE") != null)
			dto.setIdSoggettoGestione((Integer) rs.getObject("idSoggettoGestione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEGESTORE") != null)
			dto.setCodiceGestore(rs.getString("codiceGestore"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINZIONEALBO") != null)
			dto.setDenominzioneAlbo(rs.getString("denominzioneAlbo"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEESTESA") != null)
			dto.setDenominazioneEstesa(rs.getString("denominazioneEstesa"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPraticaAltriAlbiByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPraticaAltriAlbiByIdAziendaDto
	 * @generated
	 */

	public TaifTPraticaAltriAlbiByIdAziendaDto mapRow_internal(TaifTPraticaAltriAlbiByIdAziendaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPraticaAltriAlbiByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ALTROALBO") != null)
			dto.setAltroAlbo(rs.getString("altroAlbo"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPraticaDettaglioPraticaPerInvioDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPraticaDettaglioPraticaPerInvioDto
	 * @generated
	 */

	public TaifTPraticaDettaglioPraticaPerInvioDto mapRow_internal(TaifTPraticaDettaglioPraticaPerInvioDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPraticaDettaglioPraticaPerInvioDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_PRATICA") != null)
			dto.setPrIdPratica((Integer) rs.getObject("ID_PRATICA"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO_ALBO") != null)
			dto.setPrNumeroAlbo(rs.getString("NUMERO_ALBO"));

		if (mapAllColumns || columnsToReadMap.get("DATA_ISCRIZIONE_ALBO") != null)
			dto.setPrDataIscrizioneAlbo(rs.getDate("DATA_ISCRIZIONE_ALBO"));

		if (mapAllColumns || columnsToReadMap.get("FK_STATO_PRATICA") != null)
			dto.setSsFkStatoPratica((Integer) rs.getObject("FK_STATO_PRATICA"));

		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setAzIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		if (mapAllColumns || columnsToReadMap.get("PARTITA_IVA") != null)
			dto.setAzPartitaIva(rs.getString("PARTITA_IVA"));

		if (mapAllColumns || columnsToReadMap.get("N_TVA") != null)
			dto.setAzNTva(rs.getString("N_TVA"));

		if (mapAllColumns || columnsToReadMap.get("RAGIONE_SOCIALE") != null)
			dto.setAzRagioneSociale(rs.getString("RAGIONE_SOCIALE"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setAzCodiceFiscale(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("N_SIRET") != null)
			dto.setAzNSiret(rs.getString("N_SIRET"));

		if (mapAllColumns || columnsToReadMap.get("MAILAZIENDA") != null)
			dto.setMailAzienda(rs.getString("mailAzienda"));

		if (mapAllColumns || columnsToReadMap.get("PECAZIENDA") != null)
			dto.setPecAzienda(rs.getString("pecAzienda"));

		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setPeIdPersona((Integer) rs.getObject("ID_PERSONA"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setPeCognome(rs.getString("COGNOME"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setPeNome(rs.getString("NOME"));

		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setPeCodiceFiscale(rs.getString("CODICE_FISCALE"));

		if (mapAllColumns || columnsToReadMap.get("ID_SOGGETTO_GESTORE") != null)
			dto.setSgIdSoggettoGestore((Integer) rs.getObject("ID_SOGGETTO_GESTORE"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE_BREVE") != null)
			dto.setSgDenominazioneBreve(rs.getString("DENOMINAZIONE_BREVE"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONE") != null)
			dto.setSgDenominazione(rs.getString("DENOMINAZIONE"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setSgTelefono(rs.getString("TELEFONO"));

		if (mapAllColumns || columnsToReadMap.get("MAILSOGGETTOGESTORE") != null)
			dto.setMailSoggettoGestore(rs.getString("mailSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("PECSOGGETTOGESTORE") != null)
			dto.setPecSoggettoGestore(rs.getString("pecSoggettoGestore"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPraticaMaxAlboNumberValueDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPraticaMaxAlboNumberValueDto
	 * @generated
	 */

	public TaifTPraticaMaxAlboNumberValueDto mapRow_internal(TaifTPraticaMaxAlboNumberValueDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPraticaMaxAlboNumberValueDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("MAXNUMEROALBO") != null)
			dto.setMaxNumeroAlbo((Integer) rs.getObject("maxNumeroAlbo"));

		return dto;
	}

}
