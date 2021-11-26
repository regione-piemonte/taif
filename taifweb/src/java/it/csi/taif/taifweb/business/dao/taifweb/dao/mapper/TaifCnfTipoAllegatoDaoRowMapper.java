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
 * RowMapper specifico del DAO TaifCnfTipoAllegatoDao
 * @generated
 */
public class TaifCnfTipoAllegatoDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifCnfTipoAllegatoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifCnfTipoAllegatoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifCnfTipoAllegatoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifCnfTipoAllegatoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfTipoAllegatoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifCnfTipoAllegatoDto) {
			return mapRow_internal((TaifCnfTipoAllegatoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifCnfTipoAllegatoByProceduraDto) {
			return mapRow_internal((TaifCnfTipoAllegatoByProceduraDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifCnfTipoAllegatoByAllegatoFilterDto) {
			return mapRow_internal((TaifCnfTipoAllegatoByAllegatoFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifCnfTipoAllegatoAllegatiObbligatoriDto) {
			return mapRow_internal((TaifCnfTipoAllegatoAllegatiObbligatoriDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifCnfTipoAllegatoDto mapRow_internal(TaifCnfTipoAllegatoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifCnfTipoAllegatoDto dto = objectToFill;

		// colonna [ID_TIPO_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_ALLEGATO") != null)
			dto.setIdTipoAllegato((Integer) rs.getObject("ID_TIPO_ALLEGATO"));

		// colonna [FK_PROCEDURA]
		if (mapAllColumns || columnsToReadMap.get("FK_PROCEDURA") != null)
			dto.setFkProcedura((Integer) rs.getObject("FK_PROCEDURA"));

		// colonna [TIPO_ALLEGATO]
		if (mapAllColumns || columnsToReadMap.get("TIPO_ALLEGATO") != null)
			dto.setTipoAllegato(rs.getString("TIPO_ALLEGATO"));

		// colonna [MTD_ORDINAMENTO]
		if (mapAllColumns || columnsToReadMap.get("MTD_ORDINAMENTO") != null)
			dto.setMtdOrdinamento(rs.getBigDecimal("MTD_ORDINAMENTO"));

		// colonna [MTD_FLG_VISIBILE]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_VISIBILE") != null)
			dto.setMtdFlgVisibile(rs.getBigDecimal("MTD_FLG_VISIBILE"));

		// colonna [MTD_FLG_ITA_FRA]
		if (mapAllColumns || columnsToReadMap.get("MTD_FLG_ITA_FRA") != null)
			dto.setMtdFlgItaFra(rs.getString("MTD_FLG_ITA_FRA"));

		// colonna [FLG_CONTESTO]
		if (mapAllColumns || columnsToReadMap.get("FLG_CONTESTO") != null)
			dto.setFlgContesto(rs.getString("FLG_CONTESTO"));

		// colonna [FLG_FIRMA]
		if (mapAllColumns || columnsToReadMap.get("FLG_FIRMA") != null)
			dto.setFlgFirma(rs.getString("FLG_FIRMA"));

		// colonna [FLG_DOWNLOAD]
		if (mapAllColumns || columnsToReadMap.get("FLG_DOWNLOAD") != null)
			dto.setFlgDownload(rs.getBigDecimal("FLG_DOWNLOAD"));

		// colonna [FLG_UPLOAD]
		if (mapAllColumns || columnsToReadMap.get("FLG_UPLOAD") != null)
			dto.setFlgUpload(rs.getBigDecimal("FLG_UPLOAD"));

		// colonna [FLG_INVIO]
		if (mapAllColumns || columnsToReadMap.get("FLG_INVIO") != null)
			dto.setFlgInvio(rs.getBigDecimal("FLG_INVIO"));

		// colonna [ACTA_OGGETTO]
		if (mapAllColumns || columnsToReadMap.get("ACTA_OGGETTO") != null)
			dto.setActaOggetto(rs.getString("ACTA_OGGETTO"));

		// colonna [ACTA_FLG_ALLEGATI]
		if (mapAllColumns || columnsToReadMap.get("ACTA_FLG_ALLEGATI") != null)
			dto.setActaFlgAllegati(rs.getString("ACTA_FLG_ALLEGATI"));

		// colonna [ACTA_STATO_DI_EFFICACIA]
		if (mapAllColumns || columnsToReadMap.get("ACTA_STATO_DI_EFFICACIA") != null)
			dto.setActaStatoDiEfficacia(rs.getString("ACTA_STATO_DI_EFFICACIA"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfTipoAllegatoByProceduraDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfTipoAllegatoByProceduraDto
	 * @generated
	 */

	public TaifCnfTipoAllegatoByProceduraDto mapRow_internal(TaifCnfTipoAllegatoByProceduraDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifCnfTipoAllegatoByProceduraDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDTIPOALLEGATO") != null)
			dto.setIdTipoAllegato((Integer) rs.getObject("idTipoAllegato"));

		if (mapAllColumns || columnsToReadMap.get("IDPROCEDURA") != null)
			dto.setIdProcedura((Integer) rs.getObject("idProcedura"));

		if (mapAllColumns || columnsToReadMap.get("TIPOALLEGATO") != null)
			dto.setTipoAllegato(rs.getString("tipoAllegato"));

		if (mapAllColumns || columnsToReadMap.get("FLAGFIRMA") != null)
			dto.setFlagFirma(rs.getString("flagFirma"));

		if (mapAllColumns || columnsToReadMap.get("FLAGDOWNLOAD") != null)
			dto.setFlagDownload(rs.getBigDecimal("flagDownload"));

		if (mapAllColumns || columnsToReadMap.get("FLAGUPLOAD") != null)
			dto.setFlagUpload(rs.getBigDecimal("flagUpload"));

		if (mapAllColumns || columnsToReadMap.get("FLAGINVIO") != null)
			dto.setFlagInvio(rs.getBigDecimal("flagInvio"));

		if (mapAllColumns || columnsToReadMap.get("NOMEPROCEDURA") != null)
			dto.setNomeProcedura(rs.getString("nomeProcedura"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfTipoAllegatoByAllegatoFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfTipoAllegatoByAllegatoFilterDto
	 * @generated
	 */

	public TaifCnfTipoAllegatoByAllegatoFilterDto mapRow_internal(TaifCnfTipoAllegatoByAllegatoFilterDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifCnfTipoAllegatoByAllegatoFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDTIPOALLEGATO") != null)
			dto.setIdTipoAllegato((Integer) rs.getObject("idTipoAllegato"));

		if (mapAllColumns || columnsToReadMap.get("IDPROCEDURA") != null)
			dto.setIdProcedura((Integer) rs.getObject("idProcedura"));

		if (mapAllColumns || columnsToReadMap.get("TIPOALLEGATO") != null)
			dto.setTipoAllegato(rs.getString("tipoAllegato"));

		if (mapAllColumns || columnsToReadMap.get("FLAGFIRMA") != null)
			dto.setFlagFirma(rs.getString("flagFirma"));

		if (mapAllColumns || columnsToReadMap.get("FLAGDOWNLOAD") != null)
			dto.setFlagDownload(rs.getBigDecimal("flagDownload"));

		if (mapAllColumns || columnsToReadMap.get("FLAGUPLOAD") != null)
			dto.setFlagUpload(rs.getBigDecimal("flagUpload"));

		if (mapAllColumns || columnsToReadMap.get("FLAGINVIO") != null)
			dto.setFlagInvio(rs.getBigDecimal("flagInvio"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifCnfTipoAllegatoAllegatiObbligatoriDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifCnfTipoAllegatoAllegatiObbligatoriDto
	 * @generated
	 */

	public TaifCnfTipoAllegatoAllegatiObbligatoriDto mapRow_internal(
			TaifCnfTipoAllegatoAllegatiObbligatoriDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifCnfTipoAllegatoAllegatiObbligatoriDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID_TIPO_ALLEGATO") != null)
			dto.setAIdTipoAllegato((Integer) rs.getObject("ID_TIPO_ALLEGATO"));

		return dto;
	}

}
