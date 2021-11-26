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
 * RowMapper specifico del DAO TaifDTipoMezzoDao
 * @generated
 */
public class TaifDTipoMezzoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoMezzoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoMezzoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoMezzoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoMezzoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMezzoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoMezzoDto) {
			return mapRow_internal((TaifDTipoMezzoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoMezzoByVisibileCategoriaDto) {
			return mapRow_internal((TaifDTipoMezzoByVisibileCategoriaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoMezzoByVisibileOrdinDto) {
			return mapRow_internal((TaifDTipoMezzoByVisibileOrdinDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoMezzoByTipoMezzoDto) {
			return mapRow_internal((TaifDTipoMezzoByTipoMezzoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDTipoMezzoByCategoriaMezzoDto) {
			return mapRow_internal((TaifDTipoMezzoByCategoriaMezzoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoMezzoDto mapRow_internal(TaifDTipoMezzoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoMezzoDto dto = objectToFill;

		// colonna [ID_TIPO_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_MEZZO") != null)
			dto.setIdTipoMezzo((Integer) rs.getObject("ID_TIPO_MEZZO"));

		// colonna [FK_CATEGORIA_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("FK_CATEGORIA_MEZZO") != null)
			dto.setFkCategoriaMezzo((Integer) rs.getObject("FK_CATEGORIA_MEZZO"));

		// colonna [TIPO_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("TIPO_MEZZO") != null)
			dto.setTipoMezzo(rs.getString("TIPO_MEZZO"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoMezzoByVisibileCategoriaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMezzoByVisibileCategoriaDto
	 * @generated
	 */

	public TaifDTipoMezzoByVisibileCategoriaDto mapRow_internal(TaifDTipoMezzoByVisibileCategoriaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoMezzoByVisibileCategoriaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGORIA") != null)
			dto.setIdCategoria((Integer) rs.getObject("idCategoria"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoMezzoByVisibileOrdinDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMezzoByVisibileOrdinDto
	 * @generated
	 */

	public TaifDTipoMezzoByVisibileOrdinDto mapRow_internal(TaifDTipoMezzoByVisibileOrdinDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTipoMezzoByVisibileOrdinDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGORIA") != null)
			dto.setIdCategoria((Integer) rs.getObject("idCategoria"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoMezzoByTipoMezzoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMezzoByTipoMezzoDto
	 * @generated
	 */

	public TaifDTipoMezzoByTipoMezzoDto mapRow_internal(TaifDTipoMezzoByTipoMezzoDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTipoMezzoByTipoMezzoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGORIA") != null)
			dto.setIdCategoria((Integer) rs.getObject("idCategoria"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoMezzoByCategoriaMezzoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoMezzoByCategoriaMezzoDto
	 * @generated
	 */

	public TaifDTipoMezzoByCategoriaMezzoDto mapRow_internal(TaifDTipoMezzoByCategoriaMezzoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifDTipoMezzoByCategoriaMezzoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGORIA") != null)
			dto.setIdCategoria((Integer) rs.getObject("idCategoria"));

		if (mapAllColumns || columnsToReadMap.get("TIPO") != null)
			dto.setTipo(rs.getString("tipo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
