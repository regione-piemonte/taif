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
 * RowMapper specifico del DAO TaifCnfTipoMailDao
 * @generated
 */
public class TaifCnfTipoMailDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfTipoMailDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfTipoMailDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfTipoMailDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfTipoMailDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfTipoMailDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfTipoMailDto) {
			return mapRow_internal((TaifCnfTipoMailDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfTipoMailDto mapRow_internal(TaifCnfTipoMailDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfTipoMailDto dto = objectToFill;

		// colonna [ID_TIPO_MAIL]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_MAIL") != null)
			dto.setIdTipoMail((Integer) rs.getObject("ID_TIPO_MAIL"));

		// colonna [FK_STATO_PRATICA]
		if (mapAllColumns || columnsToReadMap.get("FK_STATO_PRATICA") != null)
			dto.setFkStatoPratica((Integer) rs.getObject("FK_STATO_PRATICA"));

		// colonna [FLG_TIPO_MAIL]
		if (mapAllColumns || columnsToReadMap.get("FLG_TIPO_MAIL") != null)
			dto.setFlgTipoMail(rs.getBigDecimal("FLG_TIPO_MAIL"));

		// colonna [OGGETTO]
		if (mapAllColumns || columnsToReadMap.get("OGGETTO") != null)
			dto.setOggetto(rs.getString("OGGETTO"));

		// colonna [TESTO]
		if (mapAllColumns || columnsToReadMap.get("TESTO") != null)
			dto.setTesto(rs.getString("TESTO"));

		return dto;
	}

}
