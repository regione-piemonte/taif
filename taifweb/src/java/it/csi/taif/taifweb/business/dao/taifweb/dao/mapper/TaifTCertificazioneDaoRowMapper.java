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
 * RowMapper specifico del DAO TaifTCertificazioneDao
 * @generated
 */
public class TaifTCertificazioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTCertificazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTCertificazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTCertificazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTCertificazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCertificazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTCertificazioneDto) {
			return mapRow_internal((TaifTCertificazioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTCertificazioneByAziendaDto) {
			return mapRow_internal((TaifTCertificazioneByAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCertificazioneByTipoCertDto) {
			return mapRow_internal((TaifTCertificazioneByTipoCertDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCertificazioneElencoCertificazioniDto) {
			return mapRow_internal((TaifTCertificazioneElencoCertificazioniDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCertificazioneByAziendaTipoCertDto) {
			return mapRow_internal((TaifTCertificazioneByAziendaTipoCertDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCertificazioneFindCertificazioniByIdAziendaDto) {
			return mapRow_internal((TaifTCertificazioneFindCertificazioniByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto) {
			return mapRow_internal((TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTCertificazioneDto mapRow_internal(TaifTCertificazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTCertificazioneDto dto = objectToFill;

		// colonna [ID_CERTIFICAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_CERTIFICAZIONE") != null)
			dto.setIdCertificazione((Integer) rs.getObject("ID_CERTIFICAZIONE"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [FK_TIPO_CERTIFICAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_CERTIFICAZIONE") != null)
			dto.setFkTipoCertificazione((Integer) rs.getObject("FK_TIPO_CERTIFICAZIONE"));

		// colonna [DESCR_ALTRO]
		if (mapAllColumns || columnsToReadMap.get("DESCR_ALTRO") != null)
			dto.setDescrAltro(rs.getString("DESCR_ALTRO"));

		// colonna [NUMERO]
		if (mapAllColumns || columnsToReadMap.get("NUMERO") != null)
			dto.setNumero(rs.getString("NUMERO"));

		// colonna [ENTE_CERTIFICATORE]
		if (mapAllColumns || columnsToReadMap.get("ENTE_CERTIFICATORE") != null)
			dto.setEnteCertificatore(rs.getString("ENTE_CERTIFICATORE"));

		// colonna [ANNO]
		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("ANNO"));

		// colonna [DATA_SCADENZA]
		if (mapAllColumns || columnsToReadMap.get("DATA_SCADENZA") != null)
			dto.setDataScadenza(rs.getTimestamp("DATA_SCADENZA"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTCertificazioneByAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCertificazioneByAziendaDto
	 * @generated
	 */

	public TaifTCertificazioneByAziendaDto mapRow_internal(TaifTCertificazioneByAziendaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTCertificazioneByAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCERTIFICAZIONE") != null)
			dto.setTipoCertificazione((Integer) rs.getObject("tipoCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO") != null)
			dto.setNumero(rs.getString("numero"));

		if (mapAllColumns || columnsToReadMap.get("ENTECERTIFICATORE") != null)
			dto.setEnteCertificatore(rs.getString("enteCertificatore"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("DATA") != null)
			dto.setData(rs.getTimestamp("data"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCertificazioneByTipoCertDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCertificazioneByTipoCertDto
	 * @generated
	 */

	public TaifTCertificazioneByTipoCertDto mapRow_internal(TaifTCertificazioneByTipoCertDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTCertificazioneByTipoCertDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCERTIFICAZIONE") != null)
			dto.setTipoCertificazione((Integer) rs.getObject("tipoCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO") != null)
			dto.setNumero(rs.getString("numero"));

		if (mapAllColumns || columnsToReadMap.get("ENTECERTIFICATORE") != null)
			dto.setEnteCertificatore(rs.getString("enteCertificatore"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("DATA") != null)
			dto.setData(rs.getTimestamp("data"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCertificazioneElencoCertificazioniDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCertificazioneElencoCertificazioniDto
	 * @generated
	 */

	public TaifTCertificazioneElencoCertificazioniDto mapRow_internal(
			TaifTCertificazioneElencoCertificazioniDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTCertificazioneElencoCertificazioniDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCERTIFICAZIONE") != null)
			dto.setIdCertificazione((Integer) rs.getObject("idCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("FKTIPOCERTIFICAZIONE") != null)
			dto.setFkTipoCertificazione((Integer) rs.getObject("fkTipoCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO") != null)
			dto.setNumero(rs.getString("numero"));

		if (mapAllColumns || columnsToReadMap.get("ENTECERTIFICATORE") != null)
			dto.setEnteCertificatore(rs.getString("enteCertificatore"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("DATASCADENZA") != null)
			dto.setDataScadenza(rs.getTimestamp("dataScadenza"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONEALTRO") != null)
			dto.setDescrizioneAltro(rs.getString("descrizioneAltro"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCERTIFICAZIONE") != null)
			dto.setTipoCertificazione(rs.getString("tipoCertificazione"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCertificazioneByAziendaTipoCertDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCertificazioneByAziendaTipoCertDto
	 * @generated
	 */

	public TaifTCertificazioneByAziendaTipoCertDto mapRow_internal(TaifTCertificazioneByAziendaTipoCertDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTCertificazioneByAziendaTipoCertDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCERTIFICAZIONE") != null)
			dto.setTipoCertificazione((Integer) rs.getObject("tipoCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("NUMERO") != null)
			dto.setNumero(rs.getString("numero"));

		if (mapAllColumns || columnsToReadMap.get("ENTECERTIFICATORE") != null)
			dto.setEnteCertificatore(rs.getString("enteCertificatore"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("DATA") != null)
			dto.setData(rs.getTimestamp("data"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCertificazioneFindCertificazioniByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCertificazioneFindCertificazioniByIdAziendaDto
	 * @generated
	 */

	public TaifTCertificazioneFindCertificazioniByIdAziendaDto mapRow_internal(
			TaifTCertificazioneFindCertificazioniByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTCertificazioneFindCertificazioniByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCERTIFICAZIONE") != null)
			dto.setIdCertificazione((Integer) rs.getObject("idCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("NUMEROCERTIFICAZIONE") != null)
			dto.setNumeroCertificazione(rs.getString("numeroCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("ENTECERTIFICATORE") != null)
			dto.setEnteCertificatore(rs.getString("enteCertificatore"));

		if (mapAllColumns || columnsToReadMap.get("ANNOCERTIFICAZIONE") != null)
			dto.setAnnoCertificazione(rs.getBigDecimal("annoCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("DATASCADENZA") != null)
			dto.setDataScadenza(rs.getTimestamp("dataScadenza"));

		if (mapAllColumns || columnsToReadMap.get("ALTRACERTIFICAZIONE") != null)
			dto.setAltraCertificazione(rs.getString("altraCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCERTIFICAZIONE") != null)
			dto.setTipoCertificazione(rs.getString("tipoCertificazione"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCERTIFICAZIONE") != null)
			dto.setIdTipoCertificazione((Integer) rs.getObject("idTipoCertificazione"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto
	 * @generated
	 */

	public TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto mapRow_internal(
			TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("TIPOCERTIFICAZIONE") != null)
			dto.setTipoCertificazione(rs.getString("tipoCertificazione"));

		return dto;
	}

}
