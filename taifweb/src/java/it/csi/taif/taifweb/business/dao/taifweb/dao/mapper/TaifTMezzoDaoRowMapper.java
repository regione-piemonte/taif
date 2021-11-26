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
 * RowMapper specifico del DAO TaifTMezzoDao
 * @generated
 */
public class TaifTMezzoDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTMezzoDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTMezzoDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTMezzoDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTMezzoDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTMezzoDto) {
			return mapRow_internal((TaifTMezzoDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTMezzoByTipoMezzoDto) {
			return mapRow_internal((TaifTMezzoByTipoMezzoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTMezzoByTipoMezzoAziendaDto) {
			return mapRow_internal((TaifTMezzoByTipoMezzoAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTMezzoByTipoMezzoAziendaVisibileDto) {
			return mapRow_internal((TaifTMezzoByTipoMezzoAziendaVisibileDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTMezzoTipoTrazioneByIdTrazioneDto) {
			return mapRow_internal((TaifTMezzoTipoTrazioneByIdTrazioneDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto) {
			return mapRow_internal((TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTMezzoTipoCarrelloByIdCarrelloDto) {
			return mapRow_internal((TaifTMezzoTipoCarrelloByIdCarrelloDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTMezzoDettaglioMezzoByIdAziendaDto) {
			return mapRow_internal((TaifTMezzoDettaglioMezzoByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTMezzoByIdTipoMezzoAziendaDto) {
			return mapRow_internal((TaifTMezzoByIdTipoMezzoAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTMezzoByIdAziendaDto) {
			return mapRow_internal((TaifTMezzoByIdAziendaDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTMezzoDto mapRow_internal(TaifTMezzoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTMezzoDto dto = objectToFill;

		// colonna [ID_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("ID_MEZZO") != null)
			dto.setIdMezzo((Integer) rs.getObject("ID_MEZZO"));

		// colonna [FK_AZIENDA]
		if (mapAllColumns || columnsToReadMap.get("FK_AZIENDA") != null)
			dto.setFkAzienda((Integer) rs.getObject("FK_AZIENDA"));

		// colonna [FK_ALIMENTAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_ALIMENTAZIONE") != null)
			dto.setFkAlimentazione((Integer) rs.getObject("FK_ALIMENTAZIONE"));

		// colonna [FK_TIPO_CARRELLO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_CARRELLO") != null)
			dto.setFkTipoCarrello((Integer) rs.getObject("FK_TIPO_CARRELLO"));

		// colonna [FK_TIPO_MEZZO]
		if (mapAllColumns || columnsToReadMap.get("FK_TIPO_MEZZO") != null)
			dto.setFkTipoMezzo((Integer) rs.getObject("FK_TIPO_MEZZO"));

		// colonna [FK_TRAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_TRAZIONE") != null)
			dto.setFkTrazione((Integer) rs.getObject("FK_TRAZIONE"));

		// colonna [ANNO]
		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("ANNO"));

		// colonna [POTENZA_KW]
		if (mapAllColumns || columnsToReadMap.get("POTENZA_KW") != null)
			dto.setPotenzaKw((Integer) rs.getObject("POTENZA_KW"));

		// colonna [PORTATA_KG]
		if (mapAllColumns || columnsToReadMap.get("PORTATA_KG") != null)
			dto.setPortataKg((Integer) rs.getObject("PORTATA_KG"));

		// colonna [FLG_COMANDATO_DISTANZA]
		if (mapAllColumns || columnsToReadMap.get("FLG_COMANDATO_DISTANZA") != null)
			dto.setFlgComandatoDistanza(rs.getBigDecimal("FLG_COMANDATO_DISTANZA"));

		// colonna [FLG_NOLEGGIO]
		if (mapAllColumns || columnsToReadMap.get("FLG_NOLEGGIO") != null)
			dto.setFlgNoleggio(rs.getBigDecimal("FLG_NOLEGGIO"));

		// colonna [DATA_INSERIMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_INSERIMENTO") != null)
			dto.setDataInserimento(rs.getTimestamp("DATA_INSERIMENTO"));

		// colonna [DATA_AGGIORNAMENTO]
		if (mapAllColumns || columnsToReadMap.get("DATA_AGGIORNAMENTO") != null)
			dto.setDataAggiornamento(rs.getTimestamp("DATA_AGGIORNAMENTO"));

		// colonna [FK_CONFIG_UTENTE]
		if (mapAllColumns || columnsToReadMap.get("FK_CONFIG_UTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("FK_CONFIG_UTENTE"));

		// colonna [DESCR_ALTRO]
		if (mapAllColumns || columnsToReadMap.get("DESCR_ALTRO") != null)
			dto.setDescrAltro(rs.getString("DESCR_ALTRO"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoByTipoMezzoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoByTipoMezzoDto
	 * @generated
	 */

	public TaifTMezzoByTipoMezzoDto mapRow_internal(TaifTMezzoByTipoMezzoDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTMezzoByTipoMezzoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("POTENZA") != null)
			dto.setPotenza((Integer) rs.getObject("potenza"));

		if (mapAllColumns || columnsToReadMap.get("PORTATA") != null)
			dto.setPortata((Integer) rs.getObject("portata"));

		if (mapAllColumns || columnsToReadMap.get("COMANDO") != null)
			dto.setComando(rs.getBigDecimal("comando"));

		if (mapAllColumns || columnsToReadMap.get("NOLEGGIO") != null)
			dto.setNoleggio(rs.getBigDecimal("noleggio"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERT") != null)
			dto.setDataInsert(rs.getTimestamp("dataInsert"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDALIMENTAZIONE") != null)
			dto.setIdAlimentazione((Integer) rs.getObject("idAlimentazione"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCARREL") != null)
			dto.setIdTipoCarrel((Integer) rs.getObject("idTipoCarrel"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMEZZO") != null)
			dto.setIdTipoMezzo((Integer) rs.getObject("idTipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOTRAZIONE") != null)
			dto.setIdTipoTrazione((Integer) rs.getObject("idTipoTrazione"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoByTipoMezzoAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoByTipoMezzoAziendaDto
	 * @generated
	 */

	public TaifTMezzoByTipoMezzoAziendaDto mapRow_internal(TaifTMezzoByTipoMezzoAziendaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTMezzoByTipoMezzoAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("POTENZA") != null)
			dto.setPotenza((Integer) rs.getObject("potenza"));

		if (mapAllColumns || columnsToReadMap.get("PORTATA") != null)
			dto.setPortata((Integer) rs.getObject("portata"));

		if (mapAllColumns || columnsToReadMap.get("COMANDO") != null)
			dto.setComando(rs.getBigDecimal("comando"));

		if (mapAllColumns || columnsToReadMap.get("NOLEGGIO") != null)
			dto.setNoleggio(rs.getBigDecimal("noleggio"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERT") != null)
			dto.setDataInsert(rs.getTimestamp("dataInsert"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDALIMENTAZIONE") != null)
			dto.setIdAlimentazione((Integer) rs.getObject("idAlimentazione"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCARREL") != null)
			dto.setIdTipoCarrel((Integer) rs.getObject("idTipoCarrel"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMEZZO") != null)
			dto.setIdTipoMezzo((Integer) rs.getObject("idTipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOTRAZIONE") != null)
			dto.setIdTipoTrazione((Integer) rs.getObject("idTipoTrazione"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoByTipoMezzoAziendaVisibileDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoByTipoMezzoAziendaVisibileDto
	 * @generated
	 */

	public TaifTMezzoByTipoMezzoAziendaVisibileDto mapRow_internal(TaifTMezzoByTipoMezzoAziendaVisibileDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTMezzoByTipoMezzoAziendaVisibileDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("POTENZA") != null)
			dto.setPotenza((Integer) rs.getObject("potenza"));

		if (mapAllColumns || columnsToReadMap.get("PORTATA") != null)
			dto.setPortata((Integer) rs.getObject("portata"));

		if (mapAllColumns || columnsToReadMap.get("COMANDO") != null)
			dto.setComando(rs.getBigDecimal("comando"));

		if (mapAllColumns || columnsToReadMap.get("NOLEGGIO") != null)
			dto.setNoleggio(rs.getBigDecimal("noleggio"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERT") != null)
			dto.setDataInsert(rs.getTimestamp("dataInsert"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDALIMENTAZIONE") != null)
			dto.setIdAlimentazione((Integer) rs.getObject("idAlimentazione"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCARREL") != null)
			dto.setIdTipoCarrel((Integer) rs.getObject("idTipoCarrel"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMEZZO") != null)
			dto.setIdTipoMezzo((Integer) rs.getObject("idTipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOTRAZIONE") != null)
			dto.setIdTipoTrazione((Integer) rs.getObject("idTipoTrazione"));

		if (mapAllColumns || columnsToReadMap.get("IDCATEGORIAMEZZO") != null)
			dto.setIdCategoriaMezzo((Integer) rs.getObject("idCategoriaMezzo"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONEALTRO") != null)
			dto.setDescrizioneAltro(rs.getString("descrizioneAltro"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoTipoTrazioneByIdTrazioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoTipoTrazioneByIdTrazioneDto
	 * @generated
	 */

	public TaifTMezzoTipoTrazioneByIdTrazioneDto mapRow_internal(TaifTMezzoTipoTrazioneByIdTrazioneDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTMezzoTipoTrazioneByIdTrazioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOTRAZIONE") != null)
			dto.setIdTipoTrazione((Integer) rs.getObject("idTipoTrazione"));

		if (mapAllColumns || columnsToReadMap.get("IDMEZZO") != null)
			dto.setIdMezzo((Integer) rs.getObject("idMezzo"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto
	 * @generated
	 */

	public TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto mapRow_internal(
			TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTMezzoTipoAlimentazioneByIdAlimentazioneDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOTRAZIONE") != null)
			dto.setIdTipoTrazione((Integer) rs.getObject("idTipoTrazione"));

		if (mapAllColumns || columnsToReadMap.get("IDMEZZO") != null)
			dto.setIdMezzo((Integer) rs.getObject("idMezzo"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoTipoCarrelloByIdCarrelloDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoTipoCarrelloByIdCarrelloDto
	 * @generated
	 */

	public TaifTMezzoTipoCarrelloByIdCarrelloDto mapRow_internal(TaifTMezzoTipoCarrelloByIdCarrelloDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTMezzoTipoCarrelloByIdCarrelloDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOTRAZIONE") != null)
			dto.setIdTipoTrazione((Integer) rs.getObject("idTipoTrazione"));

		if (mapAllColumns || columnsToReadMap.get("IDMEZZO") != null)
			dto.setIdMezzo((Integer) rs.getObject("idMezzo"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoDettaglioMezzoByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoDettaglioMezzoByIdAziendaDto
	 * @generated
	 */

	public TaifTMezzoDettaglioMezzoByIdAziendaDto mapRow_internal(TaifTMezzoDettaglioMezzoByIdAziendaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTMezzoDettaglioMezzoByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("CONTEGGIO") != null)
			dto.setConteggio((Long) rs.getObject("conteggio"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoByIdTipoMezzoAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoByIdTipoMezzoAziendaDto
	 * @generated
	 */

	public TaifTMezzoByIdTipoMezzoAziendaDto mapRow_internal(TaifTMezzoByIdTipoMezzoAziendaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTMezzoByIdTipoMezzoAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDMEZZO") != null)
			dto.setIdMezzo((Integer) rs.getObject("idMezzo"));

		if (mapAllColumns || columnsToReadMap.get("TIPOMEZZO") != null)
			dto.setTipoMezzo(rs.getString("tipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("POTENZA") != null)
			dto.setPotenza((Integer) rs.getObject("potenza"));

		if (mapAllColumns || columnsToReadMap.get("PORTATA") != null)
			dto.setPortata((Integer) rs.getObject("portata"));

		if (mapAllColumns || columnsToReadMap.get("COMANDO") != null)
			dto.setComando(rs.getBigDecimal("comando"));

		if (mapAllColumns || columnsToReadMap.get("NOLEGGIO") != null)
			dto.setNoleggio(rs.getBigDecimal("noleggio"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERT") != null)
			dto.setDataInsert(rs.getTimestamp("dataInsert"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDALIMENTAZIONE") != null)
			dto.setIdAlimentazione((Integer) rs.getObject("idAlimentazione"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCARREL") != null)
			dto.setIdTipoCarrel((Integer) rs.getObject("idTipoCarrel"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMEZZO") != null)
			dto.setIdTipoMezzo((Integer) rs.getObject("idTipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOTRAZIONE") != null)
			dto.setIdTipoTrazione((Integer) rs.getObject("idTipoTrazione"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTMezzoByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTMezzoByIdAziendaDto
	 * @generated
	 */

	public TaifTMezzoByIdAziendaDto mapRow_internal(TaifTMezzoByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTMezzoByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("ANNO") != null)
			dto.setAnno(rs.getBigDecimal("anno"));

		if (mapAllColumns || columnsToReadMap.get("POTENZA") != null)
			dto.setPotenza((Integer) rs.getObject("potenza"));

		if (mapAllColumns || columnsToReadMap.get("PORTATA") != null)
			dto.setPortata((Integer) rs.getObject("portata"));

		if (mapAllColumns || columnsToReadMap.get("COMANDO") != null)
			dto.setComando(rs.getBigDecimal("comando"));

		if (mapAllColumns || columnsToReadMap.get("NOLEGGIO") != null)
			dto.setNoleggio(rs.getBigDecimal("noleggio"));

		if (mapAllColumns || columnsToReadMap.get("DATAINSERT") != null)
			dto.setDataInsert(rs.getTimestamp("dataInsert"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDALIMENTAZIONE") != null)
			dto.setIdAlimentazione((Integer) rs.getObject("idAlimentazione"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCARREL") != null)
			dto.setIdTipoCarrel((Integer) rs.getObject("idTipoCarrel"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMEZZO") != null)
			dto.setIdTipoMezzo((Integer) rs.getObject("idTipoMezzo"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOTRAZIONE") != null)
			dto.setIdTipoTrazione((Integer) rs.getObject("idTipoTrazione"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONEALTROMEZZO") != null)
			dto.setDescrizioneAltromezzo(rs.getString("descrizioneAltromezzo"));

		return dto;
	}

}
