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
 * RowMapper specifico del DAO TaifTDpiDao
 * @generated
 */
public class TaifTDpiDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTDpiDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTDpiDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTDpiDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTDpiDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTDpiDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTDpiDto) {
			return mapRow_internal((TaifTDpiDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTDpiByFilterDto) {
			return mapRow_internal((TaifTDpiByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTDpiByAziendaDto) {
			return mapRow_internal((TaifTDpiByAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTDpiByIdTipoDispositivoDto) {
			return mapRow_internal((TaifTDpiByIdTipoDispositivoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTDpiDpiByAziendaVisibileDto) {
			return mapRow_internal((TaifTDpiDpiByAziendaVisibileDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTDpiDto mapRow_internal(TaifTDpiDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTDpiDto dto = objectToFill;

		// colonna [ID_DPI]
		if (mapAllColumns || columnsToReadMap.get("ID_DPI") != null)
			dto.setIdDpi((Integer) rs.getObject("ID_DPI"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [FK_TIPO_DPI]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_DPI") != null)
			dto.setFkTipoDpi((Integer) rs.getObject("FK_TIPO_DPI"));

		// colonna [TIPOLOGIA]
		if (mapAllColumns || columnsToReadMap.get("TIPOLOGIA") != null)
			dto.setTipologia(rs.getString("TIPOLOGIA"));

		// colonna [QUANTITA]
		if (mapAllColumns || columnsToReadMap.get("QUANTITA") != null)
			dto.setQuantita((Integer) rs.getObject("QUANTITA"));

		// colonna [ANNO_SCAD]
		if (mapAllColumns || columnsToReadMap.get("ANNO_SCAD") != null)
			dto.setAnnoScad(rs.getBigDecimal("ANNO_SCAD"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTDpiByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTDpiByFilterDto
	 * @generated
	 */

	public TaifTDpiByFilterDto mapRow_internal(TaifTDpiByFilterDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTDpiByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("QUANT") != null)
			dto.setQuant((Integer) rs.getObject("quant"));

		if (mapAllColumns || columnsToReadMap.get("SCAD") != null)
			dto.setScad(rs.getBigDecimal("scad"));

		if (mapAllColumns || columnsToReadMap.get("TIPDPI") != null)
			dto.setTipDpi((Integer) rs.getObject("tipDpi"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTDpiByAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTDpiByAziendaDto
	 * @generated
	 */

	public TaifTDpiByAziendaDto mapRow_internal(TaifTDpiByAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTDpiByAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDDPI") != null)
			dto.setIdDpi((Integer) rs.getObject("idDpi"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("TIPOLOGIA") != null)
			dto.setTipologia(rs.getString("tipologia"));

		if (mapAllColumns || columnsToReadMap.get("QUANTITA") != null)
			dto.setQuantita((Integer) rs.getObject("quantita"));

		if (mapAllColumns || columnsToReadMap.get("ANNOSCADENZA") != null)
			dto.setAnnoScadenza(rs.getBigDecimal("annoScadenza"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPODPI") != null)
			dto.setIdTipoDpi((Integer) rs.getObject("idTipoDpi"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTDpiByIdTipoDispositivoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTDpiByIdTipoDispositivoDto
	 * @generated
	 */

	public TaifTDpiByIdTipoDispositivoDto mapRow_internal(TaifTDpiByIdTipoDispositivoDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTDpiByIdTipoDispositivoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDDPI") != null)
			dto.setIdDpi((Integer) rs.getObject("idDpi"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("TIPOLOGIA") != null)
			dto.setTipologia(rs.getString("tipologia"));

		if (mapAllColumns || columnsToReadMap.get("QUANT") != null)
			dto.setQuant((Integer) rs.getObject("quant"));

		if (mapAllColumns || columnsToReadMap.get("SCAD") != null)
			dto.setScad(rs.getBigDecimal("scad"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPODPI") != null)
			dto.setIdTipoDpi((Integer) rs.getObject("idTipoDpi"));

		if (mapAllColumns || columnsToReadMap.get("TIPODPI") != null)
			dto.setTipoDpi(rs.getString("tipoDpi"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTDpiDpiByAziendaVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTDpiDpiByAziendaVisibileDto
	 * @generated
	 */

	public TaifTDpiDpiByAziendaVisibileDto mapRow_internal(TaifTDpiDpiByAziendaVisibileDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTDpiDpiByAziendaVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDDPI") != null)
			dto.setIdDpi((Integer) rs.getObject("idDpi"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("TIPOLOGIA") != null)
			dto.setTipologia(rs.getString("tipologia"));

		if (mapAllColumns || columnsToReadMap.get("QUANTITA") != null)
			dto.setQuantita((Integer) rs.getObject("quantita"));

		if (mapAllColumns || columnsToReadMap.get("ANNOSCADENZA") != null)
			dto.setAnnoScadenza(rs.getBigDecimal("annoScadenza"));

		if (mapAllColumns || columnsToReadMap.get("TIPODPI") != null)
			dto.setTipoDpi(rs.getString("tipoDpi"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPODPI") != null)
			dto.setIdTipoDpi((Integer) rs.getObject("idTipoDpi"));

		return dto;
	}

}
