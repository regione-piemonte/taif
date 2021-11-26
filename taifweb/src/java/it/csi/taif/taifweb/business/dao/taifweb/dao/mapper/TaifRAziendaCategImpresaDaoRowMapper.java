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
 * RowMapper specifico del DAO TaifRAziendaCategImpresaDao
 * @generated
 */
public class TaifRAziendaCategImpresaDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifRAziendaCategImpresaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifRAziendaCategImpresaDaoRowMapper(String[] columnsToRead, Class dtoClass,
			TaifRAziendaCategImpresaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifRAziendaCategImpresaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaCategImpresaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifRAziendaCategImpresaDto) {
			return mapRow_internal((TaifRAziendaCategImpresaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifRAziendaCategImpresaByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaCategImpresaByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaCategImpresaByIdCategImpresaDto) {
			return mapRow_internal((TaifRAziendaCategImpresaByIdCategImpresaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto) {
			return mapRow_internal((TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto) {
			return mapRow_internal((TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto) dtoInstance,
					rs, row);
		}

		return dtoInstance;
	}

	public TaifRAziendaCategImpresaDto mapRow_internal(TaifRAziendaCategImpresaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRAziendaCategImpresaDto dto = objectToFill;

		// colonna [ID_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("ID_AZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("ID_AZIENDA"));

		// colonna [ID_CATEGORIA]
		if (mapAllColumns || columnsToReadMap.get("ID_CATEGORIA") != null)
			dto.setIdCategoria((Integer) rs.getObject("ID_CATEGORIA"));

		// colonna [AZIENDA_CATEGIMPRESA]
		if (mapAllColumns || columnsToReadMap.get("AZIENDA_CATEGIMPRESA") != null)
			dto.setAziendaCategimpresa(rs.getString("AZIENDA_CATEGIMPRESA"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaCategImpresaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaCategImpresaByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaCategImpresaByIdAziendaDto mapRow_internal(TaifRAziendaCategImpresaByIdAziendaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifRAziendaCategImpresaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGIMPRESA") != null)
			dto.setIdcategImpresa((Integer) rs.getObject("idcategImpresa"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("AZIENDACATEGIMPRESA") != null)
			dto.setAziendaCategImpresa(rs.getString("aziendaCategImpresa"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaCategImpresaByIdCategImpresaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaCategImpresaByIdCategImpresaDto
	 * @generated
	 */

	public TaifRAziendaCategImpresaByIdCategImpresaDto mapRow_internal(
			TaifRAziendaCategImpresaByIdCategImpresaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaCategImpresaByIdCategImpresaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGIMPRESA") != null)
			dto.setIdCategImpresa((Integer) rs.getObject("idCategImpresa"));

		if (mapAllColumns || columnsToReadMap.get("AZIENDACATEGIMPRESA") != null)
			dto.setAziendaCategImpresa(rs.getString("aziendaCategImpresa"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto
	 * @generated
	 */

	public TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto mapRow_internal(
			TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifRAziendaCategImpresaByIdAziendaIdCategoriaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGIMPRESA") != null)
			dto.setIdCategImpresa((Integer) rs.getObject("idCategImpresa"));

		if (mapAllColumns || columnsToReadMap.get("AZIENDACATEGIMPRESA") != null)
			dto.setAziendaCategImpresa(rs.getString("aziendaCategImpresa"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto mapRow_internal(
			TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRAziendaCategImpresaFindCategoriaImpresaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGIMPRESA") != null)
			dto.setIdcategImpresa((Integer) rs.getObject("idcategImpresa"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("dataInserimento"));

		if (mapAllColumns || columnsToReadMap.get("AZIENDACATEGIMPRESA") != null)
			dto.setAziendaCategImpresa(rs.getString("aziendaCategImpresa"));

		if (mapAllColumns || columnsToReadMap.get("DATAAGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("dataAggiornamento"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("CATEGORIAIMPRESA") != null)
			dto.setCategoriaImpresa(rs.getString("categoriaImpresa"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto
	 * @generated
	 */

	public TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto mapRow_internal(
			TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifRAziendaCategImpresaFindDettaglioCategoriaImpresaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("CATEGORIAIMPRESA") != null)
			dto.setCategoriaImpresa(rs.getString("categoriaImpresa"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGORIA") != null)
			dto.setIdCategoria((Integer) rs.getObject("idCategoria"));

		return dto;
	}

}
