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
 * RowMapper specifico del DAO TaifTPersonaCorsiExtDao
 * @generated
 */
public class TaifTPersonaCorsiExtDaoRowMapper extends BaseDaoRowMapper
		implements
			org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTPersonaCorsiExtDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTPersonaCorsiExtDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTPersonaCorsiExtDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTPersonaCorsiExtDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaCorsiExtDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTPersonaCorsiExtDto) {
			return mapRow_internal((TaifTPersonaCorsiExtDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto) {
			return mapRow_internal((TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaCorsiExtAltriCorsiDto) {
			return mapRow_internal((TaifTPersonaCorsiExtAltriCorsiDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTPersonaCorsiExtDto mapRow_internal(TaifTPersonaCorsiExtDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPersonaCorsiExtDto dto = objectToFill;

		// colonna [ID_PERSONA]
		if (mapAllColumns || columnsToReadMap.get("ID_PERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("ID_PERSONA"));

		// colonna [FK_TITOLO_STUDIO]
		if (mapAllColumns || columnsToReadMap.get("FK_TITOLO_STUDIO") != null)
			dto.setFkTitoloStudio((Integer) rs.getObject("FK_TITOLO_STUDIO"));

		// colonna [FK_TITOLO_STUDIO_FRA]
		if (mapAllColumns || columnsToReadMap.get("FK_TITOLO_STUDIO_FRA") != null)
			dto.setFkTitoloStudioFra((Integer) rs.getObject("FK_TITOLO_STUDIO_FRA"));

		// colonna [FK_NAZIONE]
		if (mapAllColumns || columnsToReadMap.get("FK_NAZIONE") != null)
			dto.setFkNazione((Integer) rs.getObject("FK_NAZIONE"));

		// colonna [CODICE_FISCALE]
		if (mapAllColumns || columnsToReadMap.get("CODICE_FISCALE") != null)
			dto.setCodiceFiscale(rs.getString("CODICE_FISCALE"));

		// colonna [N_RSI_MSA]
		if (mapAllColumns || columnsToReadMap.get("N_RSI_MSA") != null)
			dto.setNRsiMsa(rs.getString("N_RSI_MSA"));

		// colonna [COGNOME]
		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("COGNOME"));

		// colonna [NOME]
		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("NOME"));

		// colonna [FLG_SESSO]
		if (mapAllColumns || columnsToReadMap.get("FLG_SESSO") != null)
			dto.setFlgSesso(rs.getString("FLG_SESSO"));

		// colonna [DATA_NASCITA]
		if (mapAllColumns || columnsToReadMap.get("DATA_NASCITA") != null)
			dto.setDataNascita(rs.getDate("DATA_NASCITA"));

		// colonna [ISTAT_COMUNE_NASCITA]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE_NASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("ISTAT_COMUNE_NASCITA"));

		// colonna [COMUNE_ESTERO_NASCITA]
		if (mapAllColumns || columnsToReadMap.get("COMUNE_ESTERO_NASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("COMUNE_ESTERO_NASCITA"));

		// colonna [ISTAT_COMUNE_RES]
		if (mapAllColumns || columnsToReadMap.get("ISTAT_COMUNE_RES") != null)
			dto.setIstatComuneRes(rs.getString("ISTAT_COMUNE_RES"));

		// colonna [COMUNE_ESTERO_RES]
		if (mapAllColumns || columnsToReadMap.get("COMUNE_ESTERO_RES") != null)
			dto.setComuneEsteroRes(rs.getString("COMUNE_ESTERO_RES"));

		// colonna [INDIRIZZO_RES]
		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO_RES") != null)
			dto.setIndirizzoRes(rs.getString("INDIRIZZO_RES"));

		// colonna [CIVICO_RES]
		if (mapAllColumns || columnsToReadMap.get("CIVICO_RES") != null)
			dto.setCivicoRes(rs.getString("CIVICO_RES"));

		// colonna [CAP_RES]
		if (mapAllColumns || columnsToReadMap.get("CAP_RES") != null)
			dto.setCapRes(rs.getString("CAP_RES"));

		// colonna [TELEFONO]
		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("TELEFONO"));

		// colonna [CELLULARE]
		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("CELLULARE"));

		// colonna [MAIL]
		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("MAIL"));

		// colonna [ALTRI_STUDI]
		if (mapAllColumns || columnsToReadMap.get("ALTRI_STUDI") != null)
			dto.setAltriStudi(rs.getString("ALTRI_STUDI"));

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
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto
	 * @generated
	 */

	public TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto mapRow_internal(
			TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto dto = objectToFill;
		
		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdCorso(rs.getString("idCorso"));

		if (mapAllColumns || columnsToReadMap.get("DSUNITAFORMATIVA") != null)
			dto.setDsUnitaFormativa(rs.getString("dsUnitaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("TITOLOCORSO") != null)
			dto.setTitoloCorso(rs.getString("titoloCorso"));

		if (mapAllColumns || columnsToReadMap.get("SEDECORSO") != null)
			dto.setSedeCorso(rs.getString("sedeCorso"));

		if (mapAllColumns || columnsToReadMap.get("DSAGENZIAFORMATIVA") != null)
			dto.setDsAgenziaFormativa(rs.getString("dsAgenziaFormativa"));

		if (mapAllColumns || columnsToReadMap.get("PERIODOSVOLGIMENTO") != null)
			dto.setPeriodoSvolgimento(rs.getString("periodoSvolgimento"));

		if (mapAllColumns || columnsToReadMap.get("NORE") != null)
			dto.setNOre(rs.getString("nOre"));

		if (mapAllColumns || columnsToReadMap.get("DSESITOCORSO") != null)
			dto.setDsEsitoCorso(rs.getString("dsEsitoCorso"));

		if (mapAllColumns || columnsToReadMap.get("IDALLEGATO") != null)
			dto.setIdAllegato(rs.getString("idAllegato"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaCorsiExtAltriCorsiDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaCorsiExtAltriCorsiDto
	 * @generated
	 */

	public TaifTPersonaCorsiExtAltriCorsiDto mapRow_internal(TaifTPersonaCorsiExtAltriCorsiDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPersonaCorsiExtAltriCorsiDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDCORSO") != null)
			dto.setIdCorso(rs.getString("idCorso"));
		
		if (mapAllColumns || columnsToReadMap.get("TITOLOCORSO") != null)
			dto.setTitoloCorso(rs.getString("titoloCorso"));

		if (mapAllColumns || columnsToReadMap.get("DESCRIZIONEALTROCORSO") != null)
			dto.setDescrizioneAltroCorso(rs.getString("descrizioneAltroCorso"));

		if (mapAllColumns || columnsToReadMap.get("IDALLEGATO") != null)
			dto.setIdAllegato(rs.getString("idAllegato"));

		if (mapAllColumns || columnsToReadMap.get("DSESITOCORSO") != null)
			dto.setDsEsitoCorso(rs.getString("dsEsitoCorso"));
		
		if (mapAllColumns || columnsToReadMap.get("ATTESTATOCONSCADENZA") != null)
			dto.setAttestatoConScadenza(rs.getString("attestatoConScadenza"));
		
		return dto;
	}

}
