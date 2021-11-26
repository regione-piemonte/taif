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
 * RowMapper specifico del DAO TaifRTrazTipoMezzoDao
 * @generated
 */
public class TaifRTrazTipoMezzoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifRTrazTipoMezzoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifRTrazTipoMezzoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifRTrazTipoMezzoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifRTrazTipoMezzoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRTrazTipoMezzoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifRTrazTipoMezzoDto) {
			return mapRow_internal((TaifRTrazTipoMezzoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifRTrazTipoMezzoByIdTipoMezzoDto) {
			return mapRow_internal((TaifRTrazTipoMezzoByIdTipoMezzoDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifRTrazTipoMezzoDto mapRow_internal(TaifRTrazTipoMezzoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRTrazTipoMezzoDto dto = objectToFill;

		// colonna [ID_TIPO_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_MEZZO") != null)
			dto.setIdTipoMezzo((Integer) rs.getObject("ID_TIPO_MEZZO"));

		// colonna [ID_TRAZIONE]
		if (mapAllColumns || columnsToReadMap.get("ID_TRAZIONE") != null)
			dto.setIdTrazione((Integer) rs.getObject("ID_TRAZIONE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRTrazTipoMezzoByIdTipoMezzoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRTrazTipoMezzoByIdTipoMezzoDto
	 * @generated
	 */

	public TaifRTrazTipoMezzoByIdTipoMezzoDto mapRow_internal(TaifRTrazTipoMezzoByIdTipoMezzoDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifRTrazTipoMezzoByIdTipoMezzoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMEZZO") != null)
			dto.setIdTipoMezzo((Integer) rs.getObject("idTipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTRAZIONE") != null)
			dto.setIdTrazione((Integer) rs.getObject("idTrazione"));

		return dto;
	}

}
