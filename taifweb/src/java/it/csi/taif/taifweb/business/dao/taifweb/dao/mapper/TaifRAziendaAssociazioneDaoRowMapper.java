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
 * RowMapper specifico del DAO TaifRAziendaAssociazioneDao
 * @generated
 */
public class TaifRAziendaAssociazioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifRAziendaAssociazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifRAziendaAssociazioneDaoRowMapper(String[] columnsToRead, Class dtoClass,
			TaifRAziendaAssociazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifRAziendaAssociazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaAssociazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifRAziendaAssociazioneDto) {
			return mapRow_internal((TaifRAziendaAssociazioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifRAziendaAssociazioneByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaAssociazioneByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaAssociazioneByIdAssociazioneDto) {
			return mapRow_internal((TaifRAziendaAssociazioneByIdAssociazioneDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifRAziendaAssociazioneDto mapRow_internal(TaifRAziendaAssociazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRAziendaAssociazioneDto dto = objectToFill;

		// colonna [ID_ASSOCIAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_ASSOCIAZIONE") != null)
			dto.setIdAssociazione((Integer) rs.getObject("ID_ASSOCIAZIONE"));

		// colonna [ID_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaAssociazioneByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaAssociazioneByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaAssociazioneByIdAziendaDto mapRow_internal(TaifRAziendaAssociazioneByIdAziendaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifRAziendaAssociazioneByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDASSOCIAZIONE") != null)
			dto.setIdAssociazione((Integer) rs.getObject("idAssociazione"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaAssociazioneByIdAssociazioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaAssociazioneByIdAssociazioneDto
	 * @generated
	 */

	public TaifRAziendaAssociazioneByIdAssociazioneDto mapRow_internal(
			TaifRAziendaAssociazioneByIdAssociazioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaAssociazioneByIdAssociazioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDASSOCIAZIONE") != null)
			dto.setIdAssociazione((Integer) rs.getObject("idAssociazione"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto mapRow_internal(
			TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRAziendaAssociazioneFindAssociazioniByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDASSOCIAZIONE") != null)
			dto.setIdAssociazione((Integer) rs.getObject("idAssociazione"));

		if (mapAllColumns || columnsToReadMap.get("NOMEALTRAASSOCIAZIONE") != null)
			dto.setNomeAltraAssociazione(rs.getString("nomeAltraAssociazione"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("ASSOCIAZIONE") != null)
			dto.setAssociazione(rs.getString("associazione"));

		return dto;
	}

}
