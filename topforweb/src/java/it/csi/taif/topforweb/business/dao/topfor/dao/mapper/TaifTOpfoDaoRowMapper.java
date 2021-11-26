/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.mapper;

import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.impl.BaseDaoRowMapper;
import it.csi.taif.topforweb.business.dao.topfor.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO TaifTOpfoDao
 * @generated
 */
public class TaifTOpfoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTOpfoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTOpfoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTOpfoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTOpfoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTOpfoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTOpfoDto) {
			return mapRow_internal((TaifTOpfoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTOpfoRicercaOperatoreAvanzataDto) {
			return mapRow_internal((TaifTOpfoRicercaOperatoreAvanzataDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTOpfoDto mapRow_internal(TaifTOpfoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTOpfoDto dto = objectToFill;

		// colonna [ID_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("ID_PERSONA"));

		// colonna [FK_STATO_OPFO]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_OPFO") != null)
			dto.setFkStatoOpfo((Integer) rs.getObject("FK_STATO_OPFO"));

		// colonna [FK_SOGGETTO_GESTORE]
		if (mapAllColumns || columnsToReadMap.get("FK_SOGGETTO_GESTORE") != null)
			dto.setFkSoggettoGestore((Integer) rs.getObject("FK_SOGGETTO_GESTORE"));

		// colonna [FLG_PUBBLICO]
		if (mapAllColumns || columnsToReadMap.get("FLG_PUBBLICO") != null)
			dto.setFlgPubblico(rs.getBigDecimal("FLG_PUBBLICO"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTOpfoRicercaOperatoreAvanzataDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTOpfoRicercaOperatoreAvanzataDto
	 * @generated
	 */

	public TaifTOpfoRicercaOperatoreAvanzataDto mapRow_internal(TaifTOpfoRicercaOperatoreAvanzataDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTOpfoRicercaOperatoreAvanzataDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		if (mapAllColumns || columnsToReadMap.get("DENOMINAZIONEBREVE") != null)
			dto.setDenominazioneBreve(rs.getString("denominazioneBreve"));

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("NRSIMSA") != null)
			dto.setNRsiMsa(rs.getString("nRsiMsa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOMEOPERATORE") != null)
			dto.setCognomeOperatore(rs.getString("cognomeOperatore"));

		if (mapAllColumns || columnsToReadMap.get("NOMEOPERATORE") != null)
			dto.setNomeOperatore(rs.getString("nomeOperatore"));

		if (mapAllColumns || columnsToReadMap.get("ELENCOCORSO") != null)
			dto.setElencoCorso(rs.getString("elencoCorso"));

		if (mapAllColumns || columnsToReadMap.get("URLPRIVACY") != null)
			dto.setUrlPrivacy(rs.getString("urlPrivacy"));

		return dto;
	}

}
