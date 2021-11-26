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
 * RowMapper specifico del DAO TaifDTipoCertificazioneDao
 * @generated
 */
public class TaifDTipoCertificazioneDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoCertificazioneDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoCertificazioneDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoCertificazioneDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoCertificazioneDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoCertificazioneDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoCertificazioneDto) {
			return mapRow_internal((TaifDTipoCertificazioneDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoCertificazioneTipoCertificazioneVisibleDto) {
			return mapRow_internal((TaifDTipoCertificazioneTipoCertificazioneVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoCertificazioneDto mapRow_internal(TaifDTipoCertificazioneDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoCertificazioneDto dto = objectToFill;

		// colonna [ID_TIPO_CERTIFICAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CERTIFICAZIONE") != null)
			dto.setIdTipoCertificazione((Integer) rs.getObject("ID_TIPO_CERTIFICAZIONE"));

		// colonna [TIPO_CERTIFICAZIONE]
		if (mapAllColumns || columnsToReadMap.get("TIPO_CERTIFICAZIONE") != null)
			dto.setTipoCertificazione(rs.getString("TIPO_CERTIFICAZIONE"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoCertificazioneTipoCertificazioneVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoCertificazioneTipoCertificazioneVisibleDto
	 * @generated
	 */

	public TaifDTipoCertificazioneTipoCertificazioneVisibleDto mapRow_internal(
			TaifDTipoCertificazioneTipoCertificazioneVisibleDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoCertificazioneTipoCertificazioneVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOCERT") != null)
			dto.setTipoCert(rs.getString("tipoCert"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
