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
 * RowMapper specifico del DAO TaifDCategoriaMezzoDao
 * @generated
 */
public class TaifDCategoriaMezzoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDCategoriaMezzoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDCategoriaMezzoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDCategoriaMezzoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDCategoriaMezzoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDCategoriaMezzoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDCategoriaMezzoDto) {
			return mapRow_internal((TaifDCategoriaMezzoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDCategoriaMezzoByVisibileOrdinDto) {
			return mapRow_internal((TaifDCategoriaMezzoByVisibileOrdinDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDCategoriaMezzoByCategoriaMezzoDto) {
			return mapRow_internal((TaifDCategoriaMezzoByCategoriaMezzoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDCategoriaMezzoByIdCategoriaMezzoDto) {
			return mapRow_internal((TaifDCategoriaMezzoByIdCategoriaMezzoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDCategoriaMezzoByIdTipoMezzoDto) {
			return mapRow_internal((TaifDCategoriaMezzoByIdTipoMezzoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDCategoriaMezzoDto mapRow_internal(TaifDCategoriaMezzoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDCategoriaMezzoDto dto = objectToFill;

		// colonna [ID_CATEGORIA_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("ID_CATEGORIA_MEZZO") != null)
			dto.setIdCategoriaMezzo((Integer) rs.getObject("ID_CATEGORIA_MEZZO"));

		// colonna [CATEGORIA_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("CATEGORIA_MEZZO") != null)
			dto.setCategoriaMezzo(rs.getString("CATEGORIA_MEZZO"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDCategoriaMezzoByVisibileOrdinDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDCategoriaMezzoByVisibileOrdinDto
	 * @generated
	 */

	public TaifDCategoriaMezzoByVisibileOrdinDto mapRow_internal(TaifDCategoriaMezzoByVisibileOrdinDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDCategoriaMezzoByVisibileOrdinDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CAT") != null)
			dto.setCat(rs.getString("cat"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDCategoriaMezzoByCategoriaMezzoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDCategoriaMezzoByCategoriaMezzoDto
	 * @generated
	 */

	public TaifDCategoriaMezzoByCategoriaMezzoDto mapRow_internal(TaifDCategoriaMezzoByCategoriaMezzoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDCategoriaMezzoByCategoriaMezzoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CAT") != null)
			dto.setCat(rs.getString("cat"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDCategoriaMezzoByIdCategoriaMezzoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDCategoriaMezzoByIdCategoriaMezzoDto
	 * @generated
	 */

	public TaifDCategoriaMezzoByIdCategoriaMezzoDto mapRow_internal(
			TaifDCategoriaMezzoByIdCategoriaMezzoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifDCategoriaMezzoByIdCategoriaMezzoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CAT") != null)
			dto.setCat(rs.getString("cat"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDCategoriaMezzoByIdTipoMezzoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDCategoriaMezzoByIdTipoMezzoDto
	 * @generated
	 */

	public TaifDCategoriaMezzoByIdTipoMezzoDto mapRow_internal(TaifDCategoriaMezzoByIdTipoMezzoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDCategoriaMezzoByIdTipoMezzoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CAT") != null)
			dto.setCat(rs.getString("cat"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGORIAMEZZO") != null)
			dto.setIdCategoriaMezzo((Integer) rs.getObject("idCategoriaMezzo"));

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		return dto;
	}

}
