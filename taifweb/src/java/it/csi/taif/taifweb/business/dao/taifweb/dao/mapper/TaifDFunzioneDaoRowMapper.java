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
 * RowMapper specifico del DAO TaifDFunzioneDao
 * @generated
 */
public class TaifDFunzioneDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDFunzioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDFunzioneDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDFunzioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDFunzioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDFunzioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDFunzioneDto) {
			return mapRow_internal((TaifDFunzioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDFunzioneByVisibleFilterDto) {
			return mapRow_internal((TaifDFunzioneByVisibleFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDFunzionePiazzaStoccaggioDto) {
			return mapRow_internal((TaifDFunzionePiazzaStoccaggioDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDFunzioneByFunzioneDto) {
			return mapRow_internal((TaifDFunzioneByFunzioneDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDFunzioneDto mapRow_internal(TaifDFunzioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDFunzioneDto dto = objectToFill;

		// colonna [ID_FUNZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_FUNZIONE") != null)
			dto.setIdFunzione((Integer) rs.getObject("ID_FUNZIONE"));

		// colonna [FK_TIPO_STRUTTURA]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_STRUTTURA") != null)
			dto.setFkTipoStruttura((Integer) rs.getObject("FK_TIPO_STRUTTURA"));

		// colonna [FUNZIONE]
		if (mapAllColumns || columnsToReadMap.get("FUNZIONE") != null)
			dto.setFunzione(rs.getString("FUNZIONE"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		// colonna [MTD_FLG_ITA_FRA]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_ITA_FRA") != null)
			dto.setMtdFlgItaFra(rs.getString("MTD_FLG_ITA_FRA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDFunzioneByVisibleFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDFunzioneByVisibleFilterDto
	 * @generated
	 */

	public TaifDFunzioneByVisibleFilterDto mapRow_internal(TaifDFunzioneByVisibleFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDFunzioneByVisibleFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDSTRU") != null)
			dto.setIdStru((Integer) rs.getObject("idStru"));

		if (mapAllColumns || columnsToReadMap.get("FUNZ") != null)
			dto.setFunz(rs.getString("funz"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDFunzionePiazzaStoccaggioDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDFunzionePiazzaStoccaggioDto
	 * @generated
	 */

	public TaifDFunzionePiazzaStoccaggioDto mapRow_internal(TaifDFunzionePiazzaStoccaggioDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDFunzionePiazzaStoccaggioDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDSTRU") != null)
			dto.setIdStru((Integer) rs.getObject("idStru"));

		if (mapAllColumns || columnsToReadMap.get("FUNZ") != null)
			dto.setFunz(rs.getString("funz"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDFunzioneByFunzioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDFunzioneByFunzioneDto
	 * @generated
	 */

	public TaifDFunzioneByFunzioneDto mapRow_internal(TaifDFunzioneByFunzioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDFunzioneByFunzioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDFUNZIONE") != null)
			dto.setIdFunzione((Integer) rs.getObject("idFunzione"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOSTRUTTURA") != null)
			dto.setIdTipoStruttura((Integer) rs.getObject("idTipoStruttura"));

		if (mapAllColumns || columnsToReadMap.get("FUNZ") != null)
			dto.setFunz(rs.getString("funz"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
