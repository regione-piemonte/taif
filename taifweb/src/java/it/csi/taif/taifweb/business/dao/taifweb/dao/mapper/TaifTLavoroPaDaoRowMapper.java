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
 * RowMapper specifico del DAO TaifTLavoroPaDao
 * @generated
 */
public class TaifTLavoroPaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTLavoroPaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTLavoroPaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTLavoroPaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTLavoroPaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTLavoroPaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTLavoroPaDto) {
			return mapRow_internal((TaifTLavoroPaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTLavoroPaByFilterDto) {
			return mapRow_internal((TaifTLavoroPaByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTLavoroPaByAziendaDto) {
			return mapRow_internal((TaifTLavoroPaByAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTLavoroPaLavoroPaByAziendaVisibileDto) {
			return mapRow_internal((TaifTLavoroPaLavoroPaByAziendaVisibileDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTLavoroPaDto mapRow_internal(TaifTLavoroPaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTLavoroPaDto dto = objectToFill;

		// colonna [ID_LAVORO_PA]
		if (mapAllColumns || columnsToReadMap.get("ID_LAVORO_PA") != null)
			dto.setIdLavoroPa((Integer) rs.getObject("ID_LAVORO_PA"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [FK_TIPO_LAVORO_PA]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_LAVORO_PA") != null)
			dto.setFkTipoLavoroPa((Integer) rs.getObject("FK_TIPO_LAVORO_PA"));

		// colonna [COMMITTENTE]
		if (mapAllColumns || columnsToReadMap.get("COMMITTENTE") != null)
			dto.setCommittente(rs.getString("COMMITTENTE"));

		// colonna [IMPORTO]
		if (mapAllColumns || columnsToReadMap.get("IMPORTO") != null)
			dto.setImporto(rs.getBigDecimal("IMPORTO"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		// colonna [DESCR_ALTRO]
		if (mapAllColumns || columnsToReadMap.get("DESCR_ALTRO") != null)
			dto.setDescrAltro(rs.getString("DESCR_ALTRO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTLavoroPaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTLavoroPaByFilterDto
	 * @generated
	 */

	public TaifTLavoroPaByFilterDto mapRow_internal(TaifTLavoroPaByFilterDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTLavoroPaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("COMMIT") != null)
			dto.setCommit(rs.getString("commit"));

		if (mapAllColumns || columnsToReadMap.get("IMPORTO") != null)
			dto.setImporto(rs.getBigDecimal("importo"));

		if (mapAllColumns || columnsToReadMap.get("TIPOLAVORO") != null)
			dto.setTipoLavoro(rs.getString("tipoLavoro"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOLAVORO") != null)
			dto.setIdTipoLavoro((Integer) rs.getObject("idTipoLavoro"));

		if (mapAllColumns || columnsToReadMap.get("FKAZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("fkAzienda"));

		if (mapAllColumns || columnsToReadMap.get("DESCALTRO") != null)
			dto.setDescAltro(rs.getString("descAltro"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTLavoroPaByAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTLavoroPaByAziendaDto
	 * @generated
	 */

	public TaifTLavoroPaByAziendaDto mapRow_internal(TaifTLavoroPaByAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTLavoroPaByAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("COMMIT") != null)
			dto.setCommit(rs.getString("commit"));

		if (mapAllColumns || columnsToReadMap.get("IMPORTO") != null)
			dto.setImporto(rs.getBigDecimal("importo"));

		if (mapAllColumns || columnsToReadMap.get("TIPOLAVORO") != null)
			dto.setTipoLavoro(rs.getString("tipoLavoro"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOLAVORO") != null)
			dto.setIdTipoLavoro((Integer) rs.getObject("idTipoLavoro"));

		if (mapAllColumns || columnsToReadMap.get("FKAZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("fkAzienda"));

		if (mapAllColumns || columnsToReadMap.get("DESCALTRO") != null)
			dto.setDescAltro(rs.getString("descAltro"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTLavoroPaLavoroPaByAziendaVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTLavoroPaLavoroPaByAziendaVisibileDto
	 * @generated
	 */

	public TaifTLavoroPaLavoroPaByAziendaVisibileDto mapRow_internal(
			TaifTLavoroPaLavoroPaByAziendaVisibileDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTLavoroPaLavoroPaByAziendaVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDLAVORO") != null)
			dto.setIdLavoro((Integer) rs.getObject("idLavoro"));

		if (mapAllColumns || columnsToReadMap.get("COMMITENTE") != null)
			dto.setCommitente(rs.getString("commitente"));

		if (mapAllColumns || columnsToReadMap.get("IMPORTO") != null)
			dto.setImporto(rs.getBigDecimal("importo"));

		if (mapAllColumns || columnsToReadMap.get("TIPOLAVORO") != null)
			dto.setTipoLavoro(rs.getString("tipoLavoro"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOLAVORO") != null)
			dto.setIdTipoLavoro((Integer) rs.getObject("idTipoLavoro"));

		if (mapAllColumns || columnsToReadMap.get("FKAZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("fkAzienda"));

		if (mapAllColumns || columnsToReadMap.get("DESCALTROLAVORO") != null)
			dto.setDescAltroLavoro(rs.getString("descAltroLavoro"));

		return dto;
	}

}
