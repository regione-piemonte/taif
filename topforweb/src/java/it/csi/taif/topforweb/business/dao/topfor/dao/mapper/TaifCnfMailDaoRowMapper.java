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
 * RowMapper specifico del DAO TaifCnfMailDao
 * @generated
 */
public class TaifCnfMailDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfMailDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfMailDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfMailDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfMailDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfMailDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfMailDto) {
			return mapRow_internal((TaifCnfMailDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfMailDto mapRow_internal(TaifCnfMailDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifCnfMailDto dto = objectToFill;

		// colonna [ID_MAIL]
		if (mapAllColumns || columnsToReadMap.get("ID_MAIL") != null)
			dto.setIdMail((Integer) rs.getObject("ID_MAIL"));

		// colonna [HOST]
		if (mapAllColumns || columnsToReadMap.get("HOST") != null)
			dto.setHost(rs.getString("HOST"));

		// colonna [PORTA]
		if (mapAllColumns || columnsToReadMap.get("PORTA") != null)
			dto.setPorta(rs.getBigDecimal("PORTA"));

		// colonna [USER_ID]
		if (mapAllColumns || columnsToReadMap.get("USER_ID") != null)
			dto.setUserId(rs.getString("USER_ID"));

		// colonna [PASSWORD]
		if (mapAllColumns || columnsToReadMap.get("PASSWORD") != null)
			dto.setPassword(rs.getString("PASSWORD"));

		// colonna [PROTOCOLLO]
		if (mapAllColumns || columnsToReadMap.get("PROTOCOLLO") != null)
			dto.setProtocollo(rs.getString("PROTOCOLLO"));

		// colonna [MITTENTE]
		if (mapAllColumns || columnsToReadMap.get("MITTENTE") != null)
			dto.setMittente(rs.getString("MITTENTE"));

		// colonna [DES_TIPO_POSTA]
		if (mapAllColumns || columnsToReadMap.get("DES_TIPO_POSTA") != null)
			dto.setDesTipoPosta(rs.getString("DES_TIPO_POSTA"));

		return dto;
	}

}
