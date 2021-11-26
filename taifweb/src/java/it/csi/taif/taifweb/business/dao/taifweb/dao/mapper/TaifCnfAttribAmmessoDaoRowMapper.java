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
 * RowMapper specifico del DAO TaifCnfAttribAmmessoDao
 * @generated
 */
public class TaifCnfAttribAmmessoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfAttribAmmessoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfAttribAmmessoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfAttribAmmessoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfAttribAmmessoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfAttribAmmessoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfAttribAmmessoDto) {
			return mapRow_internal((TaifCnfAttribAmmessoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifCnfAttribAmmessoByFilterDto) {
			return mapRow_internal((TaifCnfAttribAmmessoByFilterDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfAttribAmmessoDto mapRow_internal(TaifCnfAttribAmmessoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfAttribAmmessoDto dto = objectToFill;

		// colonna [FK_TIPO_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_MEZZO") != null)
			dto.setFkTipoMezzo((Integer) rs.getObject("FK_TIPO_MEZZO"));

		// colonna [NOME_ATTRIB]
		if (mapAllColumns || columnsToReadMap.get("NOME_ATTRIB") != null)
			dto.setNomeAttrib(rs.getString("NOME_ATTRIB"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfAttribAmmessoByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfAttribAmmessoByFilterDto
	 * @generated
	 */

	public TaifCnfAttribAmmessoByFilterDto mapRow_internal(TaifCnfAttribAmmessoByFilterDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifCnfAttribAmmessoByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("ATTRIBUTO") != null)
			dto.setAttributo(rs.getString("attributo"));

		if (mapAllColumns || columnsToReadMap.get("ORDIN") != null)
			dto.setOrdin(rs.getBigDecimal("ordin"));

		return dto;
	}

}
