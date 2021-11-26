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
 * RowMapper specifico del DAO TaifCnfEstensAmmDao
 * @generated
 */
public class TaifCnfEstensAmmDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfEstensAmmDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfEstensAmmDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfEstensAmmDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfEstensAmmDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfEstensAmmDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfEstensAmmDto) {
			return mapRow_internal((TaifCnfEstensAmmDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfEstensAmmDto mapRow_internal(TaifCnfEstensAmmDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfEstensAmmDto dto = objectToFill;

		// colonna [ID_ESTENSIONE_FILE]
		if (mapAllColumns || columnsToReadMap.get("ID_ESTENSIONE_FILE") != null)
			dto.setIdEstensioneFile((Integer) rs.getObject("ID_ESTENSIONE_FILE"));

		// colonna [ID_TIPO_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_ALLEGATO") != null)
			dto.setIdTipoAllegato((Integer) rs.getObject("ID_TIPO_ALLEGATO"));

		return dto;
	}

}
