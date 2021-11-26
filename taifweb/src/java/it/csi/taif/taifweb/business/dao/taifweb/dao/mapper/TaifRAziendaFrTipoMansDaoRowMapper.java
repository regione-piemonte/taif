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
 * RowMapper specifico del DAO TaifRAziendaFrTipoMansDao
 * @generated
 */
public class TaifRAziendaFrTipoMansDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifRAziendaFrTipoMansDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifRAziendaFrTipoMansDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifRAziendaFrTipoMansDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifRAziendaFrTipoMansDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaFrTipoMansDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifRAziendaFrTipoMansDto) {
			return mapRow_internal((TaifRAziendaFrTipoMansDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifRAziendaFrTipoMansFindByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaFrTipoMansFindByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaFrTipoMansByIdTipoMansioneDto) {
			return mapRow_internal((TaifRAziendaFrTipoMansByIdTipoMansioneDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaFrTipoMansFindTipoByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaFrTipoMansFindTipoByIdAziendaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifRAziendaFrTipoMansDto mapRow_internal(TaifRAziendaFrTipoMansDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRAziendaFrTipoMansDto dto = objectToFill;

		// colonna [ID_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		// colonna [ID_TIPO_MANSIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_MANSIONE") != null)
			dto.setIdTipoMansione((Integer) rs.getObject("ID_TIPO_MANSIONE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaFrTipoMansFindByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaFrTipoMansFindByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaFrTipoMansFindByIdAziendaDto mapRow_internal(
			TaifRAziendaFrTipoMansFindByIdAziendaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaFrTipoMansFindByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMANSIONE") != null)
			dto.setIdTipoMansione((Integer) rs.getObject("idTipoMansione"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaFrTipoMansByIdTipoMansioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaFrTipoMansByIdTipoMansioneDto
	 * @generated
	 */

	public TaifRAziendaFrTipoMansByIdTipoMansioneDto mapRow_internal(
			TaifRAziendaFrTipoMansByIdTipoMansioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaFrTipoMansByIdTipoMansioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCONTR") != null)
			dto.setIdTipoContr((Integer) rs.getObject("idTipoContr"));

		if (mapAllColumns || columnsToReadMap.get("ADDETTI") != null)
			dto.setAddetti((Integer) rs.getObject("addetti"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaFrTipoMansFindTipoByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaFrTipoMansFindTipoByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaFrTipoMansFindTipoByIdAziendaDto mapRow_internal(
			TaifRAziendaFrTipoMansFindTipoByIdAziendaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaFrTipoMansFindTipoByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMANSIONE") != null)
			dto.setIdTipoMansione((Integer) rs.getObject("idTipoMansione"));

		if (mapAllColumns || columnsToReadMap.get("NRADETTI") != null)
			dto.setNrAdetti((Integer) rs.getObject("nrAdetti"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("TIPOMANSIONE") != null)
			dto.setTipoMansione(rs.getString("tipoMansione"));

		return dto;
	}

}
