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
 * RowMapper specifico del DAO TaifDMaterialeDao
 * @generated
 */
public class TaifDMaterialeDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDMaterialeDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDMaterialeDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDMaterialeDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDMaterialeDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDMaterialeDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDMaterialeDto) {
			return mapRow_internal((TaifDMaterialeDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDMaterialeByVisibleOrdinDto) {
			return mapRow_internal((TaifDMaterialeByVisibleOrdinDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDMaterialeDto mapRow_internal(TaifDMaterialeDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDMaterialeDto dto = objectToFill;

		// colonna [ID_MATERIALE]
		if (mapAllColumns || columnsToReadMap.get("ID_MATERIALE") != null)
			dto.setIdMateriale((Integer) rs.getObject("ID_MATERIALE"));

		// colonna [MATERIALE]
		if (mapAllColumns || columnsToReadMap.get("MATERIALE") != null)
			dto.setMateriale(rs.getString("MATERIALE"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		// colonna [FLG_VIVAI_ARB]
		if (mapAllColumns || columnsToReadMap.get("FLG_VIVAI_ARB") != null)
			dto.setFlgVivaiArb(rs.getString("FLG_VIVAI_ARB"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDMaterialeByVisibleOrdinDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDMaterialeByVisibleOrdinDto
	 * @generated
	 */

	public TaifDMaterialeByVisibleOrdinDto mapRow_internal(TaifDMaterialeByVisibleOrdinDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDMaterialeByVisibleOrdinDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("MATERIALE") != null)
			dto.setMateriale(rs.getString("materiale"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("FLAGVIVAI") != null)
			dto.setFlagVivai(rs.getString("flagVivai"));

		return dto;
	}

}
