/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao.mapper;

import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.impl.BaseDaoRowMapper;
import it.csi.taif.topforweb.business.dao.topfor.dao.impl.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper specifico del DAO TaifDStatoOpfoDao
 * @generated
 */
public class TaifDStatoOpfoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDStatoOpfoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDStatoOpfoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDStatoOpfoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDStatoOpfoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoOpfoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDStatoOpfoDto) {
			return mapRow_internal((TaifDStatoOpfoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDStatoOpfoByVisibileFraDto) {
			return mapRow_internal((TaifDStatoOpfoByVisibileFraDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoOpfoByVisibileItaDto) {
			return mapRow_internal((TaifDStatoOpfoByVisibileItaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifDStatoOpfoByFilterVisibleDto) {
			return mapRow_internal((TaifDStatoOpfoByFilterVisibleDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDStatoOpfoDto mapRow_internal(TaifDStatoOpfoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDStatoOpfoDto dto = objectToFill;

		// colonna [ID_STATO_OPFO]
		if (mapAllColumns || columnsToReadMap.get("ID_STATO_OPFO") != null)
			dto.setIdStatoOpfo((Integer) rs.getObject("ID_STATO_OPFO"));

		// colonna [STATO_OPFO_ITA]
		if (mapAllColumns || columnsToReadMap.get("STATO_OPFO_ITA") != null)
			dto.setStatoOpfoIta(rs.getString("STATO_OPFO_ITA"));

		// colonna [STATO_OPFO_FRA]
		if (mapAllColumns || columnsToReadMap.get("STATO_OPFO_FRA") != null)
			dto.setStatoOpfoFra(rs.getString("STATO_OPFO_FRA"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoOpfoByVisibileFraDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoOpfoByVisibileFraDto
	 * @generated
	 */

	public TaifDStatoOpfoByVisibileFraDto mapRow_internal(TaifDStatoOpfoByVisibileFraDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDStatoOpfoByVisibileFraDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSTATOOPERATORE") != null)
			dto.setIdStatoOperatore((Integer) rs.getObject("idStatoOperatore"));

		if (mapAllColumns || columnsToReadMap.get("STATOOPERATOREFRA") != null)
			dto.setStatoOperatoreFra(rs.getString("statoOperatoreFra"));

		if (mapAllColumns || columnsToReadMap.get("IDORDIN") != null)
			dto.setIdOrdin(rs.getBigDecimal("idOrdin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoOpfoByVisibileItaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoOpfoByVisibileItaDto
	 * @generated
	 */

	public TaifDStatoOpfoByVisibileItaDto mapRow_internal(TaifDStatoOpfoByVisibileItaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDStatoOpfoByVisibileItaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSTATOOPERATORE") != null)
			dto.setIdStatoOperatore((Integer) rs.getObject("idStatoOperatore"));

		if (mapAllColumns || columnsToReadMap.get("STATOOPERATOREITA") != null)
			dto.setStatoOperatoreIta(rs.getString("statoOperatoreIta"));

		if (mapAllColumns || columnsToReadMap.get("IDORDIN") != null)
			dto.setIdOrdin(rs.getBigDecimal("idOrdin"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDStatoOpfoByFilterVisibleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDStatoOpfoByFilterVisibleDto
	 * @generated
	 */

	public TaifDStatoOpfoByFilterVisibleDto mapRow_internal(TaifDStatoOpfoByFilterVisibleDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDStatoOpfoByFilterVisibleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDSTATOOPERATORE") != null)
			dto.setIdStatoOperatore((Integer) rs.getObject("idStatoOperatore"));

		if (mapAllColumns || columnsToReadMap.get("STATOOPERATOREITA") != null)
			dto.setStatoOperatoreIta(rs.getString("statoOperatoreIta"));

		if (mapAllColumns || columnsToReadMap.get("IDORDIN") != null)
			dto.setIdOrdin(rs.getBigDecimal("idOrdin"));

		if (mapAllColumns || columnsToReadMap.get("STATOOPERATOREFRA") != null)
			dto.setStatoOperatoreFra(rs.getString("statoOperatoreFra"));

		return dto;
	}

}
