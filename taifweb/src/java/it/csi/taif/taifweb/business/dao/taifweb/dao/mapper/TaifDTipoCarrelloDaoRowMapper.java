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
 * RowMapper specifico del DAO TaifDTipoCarrelloDao
 * @generated
 */
public class TaifDTipoCarrelloDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifDTipoCarrelloDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifDTipoCarrelloDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifDTipoCarrelloDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifDTipoCarrelloDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoCarrelloDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifDTipoCarrelloDto) {
			return mapRow_internal((TaifDTipoCarrelloDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifDTipoCarrelloByVisibileDto) {
			return mapRow_internal((TaifDTipoCarrelloByVisibileDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifDTipoCarrelloDto mapRow_internal(TaifDTipoCarrelloDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifDTipoCarrelloDto dto = objectToFill;

		// colonna [ID_TIPO_CARRELLO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_CARRELLO") != null)
			dto.setIdTipoCarrello((Integer) rs.getObject("ID_TIPO_CARRELLO"));

		// colonna [TIPO_CARRELLO]
		if (mapAllColumns || columnsToReadMap.get("TIPO_CARRELLO") != null)
			dto.setTipoCarrello(rs.getString("TIPO_CARRELLO"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifDTipoCarrelloByVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifDTipoCarrelloByVisibileDto
	 * @generated
	 */

	public TaifDTipoCarrelloByVisibileDto mapRow_internal(TaifDTipoCarrelloByVisibileDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifDTipoCarrelloByVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("CAT") != null)
			dto.setCat(rs.getString("cat"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
