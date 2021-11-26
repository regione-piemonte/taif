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
 * RowMapper specifico del DAO TaifRAziendaFrTipoContrDao
 * @generated
 */
public class TaifRAziendaFrTipoContrDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifRAziendaFrTipoContrDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifRAziendaFrTipoContrDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifRAziendaFrTipoContrDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifRAziendaFrTipoContrDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaFrTipoContrDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifRAziendaFrTipoContrDto) {
			return mapRow_internal((TaifRAziendaFrTipoContrDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifRAziendaFrTipoContrFindByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaFrTipoContrFindByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaFrTipoContrByIdTipoContrattoDto) {
			return mapRow_internal((TaifRAziendaFrTipoContrByIdTipoContrattoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaFrTipoContrFindTipoByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaFrTipoContrFindTipoByIdAziendaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifRAziendaFrTipoContrDto mapRow_internal(TaifRAziendaFrTipoContrDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRAziendaFrTipoContrDto dto = objectToFill;

		// colonna [ID_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		// colonna [ID_TIPO_CONTRATTO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CONTRATTO") != null)
			dto.setIdTipoContratto((Integer) rs.getObject("ID_TIPO_CONTRATTO"));

		// colonna [NR_ADDETTI]
		if (mapAllColumns || columnsToReadMap.get("NR_ADDETTI") != null)
			dto.setNrAddetti((Integer) rs.getObject("NR_ADDETTI"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaFrTipoContrFindByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaFrTipoContrFindByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaFrTipoContrFindByIdAziendaDto mapRow_internal(
			TaifRAziendaFrTipoContrFindByIdAziendaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaFrTipoContrFindByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCONTR") != null)
			dto.setIdTipoContr((Integer) rs.getObject("idTipoContr"));

		if (mapAllColumns || columnsToReadMap.get("NRADETTI") != null)
			dto.setNrAdetti((Integer) rs.getObject("nrAdetti"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaFrTipoContrByIdTipoContrattoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaFrTipoContrByIdTipoContrattoDto
	 * @generated
	 */

	public TaifRAziendaFrTipoContrByIdTipoContrattoDto mapRow_internal(
			TaifRAziendaFrTipoContrByIdTipoContrattoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaFrTipoContrByIdTipoContrattoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCONTR") != null)
			dto.setIdTipoContr((Integer) rs.getObject("idTipoContr"));

		if (mapAllColumns || columnsToReadMap.get("ADDETTI") != null)
			dto.setAddetti((Integer) rs.getObject("addetti"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaFrTipoContrFindTipoByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaFrTipoContrFindTipoByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaFrTipoContrFindTipoByIdAziendaDto mapRow_internal(
			TaifRAziendaFrTipoContrFindTipoByIdAziendaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaFrTipoContrFindTipoByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCONTR") != null)
			dto.setIdTipoContr((Integer) rs.getObject("idTipoContr"));

		if (mapAllColumns || columnsToReadMap.get("NRADETTI") != null)
			dto.setNrAdetti((Integer) rs.getObject("nrAdetti"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCONTRATTO") != null)
			dto.setTipoContratto(rs.getString("tipoContratto"));

		return dto;
	}

}
