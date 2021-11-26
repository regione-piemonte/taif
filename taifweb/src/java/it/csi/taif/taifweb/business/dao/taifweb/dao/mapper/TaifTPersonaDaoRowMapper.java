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
 * RowMapper specifico del DAO TaifTPersonaDao
 * @generated
 */
public class TaifTPersonaDaoRowMapper extends BaseDaoRowMapper implements org.springframework.jdbc.core.RowMapper {

	/**
	 * Dao associato al RowMapper. Serve per i supplier DAO
	 * @generated
	 */
	TaifTPersonaDaoImpl dao;

	/**
	 * costruttore
	 * @param columnsToRead elenco delle colonne da includere nel mapping (per query
	 *        incomplete, esempio distinct, custom select...) nella classe padre
	 */
	public TaifTPersonaDaoRowMapper(String[] columnsToRead, Class dtoClass, TaifTPersonaDao dao) {
		super(columnsToRead, dtoClass);
		this.dao = (TaifTPersonaDaoImpl) dao;
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaDto
	 * @generated
	 */
	public Object mapRow(ResultSet rs, int row) throws SQLException {
		Object dtoInstance = getNewDto();

		if (dtoInstance instanceof TaifTPersonaDto) {
			return mapRow_internal((TaifTPersonaDto) dtoInstance, rs, row);
		}

		if (dtoInstance instanceof TaifTPersonaByFilterDto) {
			return mapRow_internal((TaifTPersonaByFilterDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaByConfigUtenteDto) {
			return mapRow_internal((TaifTPersonaByConfigUtenteDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaByProfiloPersonaDto) {
			return mapRow_internal((TaifTPersonaByProfiloPersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto) {
			return mapRow_internal((TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto) {
			return mapRow_internal((TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaByCodiceFiscalePersonaDto) {
			return mapRow_internal((TaifTPersonaByCodiceFiscalePersonaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaByCodiceFiscalePersonaPerContrattoDto) {
			return mapRow_internal((TaifTPersonaByCodiceFiscalePersonaPerContrattoDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaProfiloUtenteByCodiceFiscaleDto) {
			return mapRow_internal((TaifTPersonaProfiloUtenteByCodiceFiscaleDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaByIdAziendaDto) {
			return mapRow_internal((TaifTPersonaByIdAziendaDto) dtoInstance, rs, row);
		}
		if (dtoInstance instanceof TaifTPersonaByNrSiMsaPersonaFranceseDto) {
			return mapRow_internal((TaifTPersonaByNrSiMsaPersonaFranceseDto) dtoInstance, rs, row);
		}

		return dtoInstance;
	}

	public TaifTPersonaDto mapRow_internal(TaifTPersonaDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPersonaDto dto = objectToFill;

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

		// colonna [PWD]
		if (mapAllColumns || columnsToReadMap.get("PWD") != null)
			dto.setPwd(rs.getString("PWD"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByFilterDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByFilterDto
	 * @generated
	 */

	public TaifTPersonaByFilterDto mapRow_internal(TaifTPersonaByFilterDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPersonaByFilterDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("NAZIONE") != null)
			dto.setNazione((Integer) rs.getObject("nazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("NASCITA") != null)
			dto.setNascita(rs.getDate("nascita"));

		if (mapAllColumns || columnsToReadMap.get("COM") != null)
			dto.setCom(rs.getString("com"));

		if (mapAllColumns || columnsToReadMap.get("COMESTERO") != null)
			dto.setComEstero(rs.getString("comEstero"));

		if (mapAllColumns || columnsToReadMap.get("COMRES") != null)
			dto.setComRes(rs.getString("comRes"));

		if (mapAllColumns || columnsToReadMap.get("IND") != null)
			dto.setInd(rs.getString("ind"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TEL") != null)
			dto.setTel(rs.getString("tel"));

		if (mapAllColumns || columnsToReadMap.get("CELL") != null)
			dto.setCell(rs.getString("cell"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ASTUDI") != null)
			dto.setAStudi(rs.getString("aStudi"));

		if (mapAllColumns || columnsToReadMap.get("FKCONFIGUTENTE") != null)
			dto.setFkConfigUtente((Integer) rs.getObject("fkConfigUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByConfigUtenteDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByConfigUtenteDto
	 * @generated
	 */

	public TaifTPersonaByConfigUtenteDto mapRow_internal(TaifTPersonaByConfigUtenteDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTPersonaByConfigUtenteDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("NAZIONE") != null)
			dto.setNazione((Integer) rs.getObject("nazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("NASCITA") != null)
			dto.setNascita(rs.getDate("nascita"));

		if (mapAllColumns || columnsToReadMap.get("COM") != null)
			dto.setCom(rs.getString("com"));

		if (mapAllColumns || columnsToReadMap.get("COMESTERO") != null)
			dto.setComEstero(rs.getString("comEstero"));

		if (mapAllColumns || columnsToReadMap.get("COMRES") != null)
			dto.setComRes(rs.getString("comRes"));

		if (mapAllColumns || columnsToReadMap.get("IND") != null)
			dto.setInd(rs.getString("ind"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TEL") != null)
			dto.setTel(rs.getString("tel"));

		if (mapAllColumns || columnsToReadMap.get("CELL") != null)
			dto.setCell(rs.getString("cell"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ASTUDI") != null)
			dto.setAStudi(rs.getString("aStudi"));

		if (mapAllColumns || columnsToReadMap.get("CONFIGUTENTE") != null)
			dto.setConfigUtente((Integer) rs.getObject("configUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByProfiloPersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByProfiloPersonaDto
	 * @generated
	 */

	public TaifTPersonaByProfiloPersonaDto mapRow_internal(TaifTPersonaByProfiloPersonaDto objectToFill, ResultSet rs,
			int row) throws SQLException {
		TaifTPersonaByProfiloPersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("NASCITA") != null)
			dto.setNascita(rs.getDate("nascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMESTERO") != null)
			dto.setComEstero(rs.getString("comEstero"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZO") != null)
			dto.setIndirizzo(rs.getString("indirizzo"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELL") != null)
			dto.setCell(rs.getString("cell"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ASTUDI") != null)
			dto.setAStudi(rs.getString("aStudi"));

		if (mapAllColumns || columnsToReadMap.get("IDCONFIGUTENTE") != null)
			dto.setIdConfigUtente((Integer) rs.getObject("idConfigUtente"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto
	 * @generated
	 */

	public TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto mapRow_internal(
			TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("NAZIONE") != null)
			dto.setNazione((Integer) rs.getObject("nazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("NASCITA") != null)
			dto.setNascita(rs.getDate("nascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMESTERO") != null)
			dto.setComEstero(rs.getString("comEstero"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("IND") != null)
			dto.setInd(rs.getString("ind"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TEL") != null)
			dto.setTel(rs.getString("tel"));

		if (mapAllColumns || columnsToReadMap.get("CELL") != null)
			dto.setCell(rs.getString("cell"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ALTRISTUDI") != null)
			dto.setAltriStudi(rs.getString("altriStudi"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto
	 * @generated
	 */

	public TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto mapRow_internal(
			TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("ID") != null)
			dto.setId((Integer) rs.getObject("id"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("NAZIONE") != null)
			dto.setNazione((Integer) rs.getObject("nazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("NASCITA") != null)
			dto.setNascita(rs.getDate("nascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMESTERO") != null)
			dto.setComEstero(rs.getString("comEstero"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("IND") != null)
			dto.setInd(rs.getString("ind"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TEL") != null)
			dto.setTel(rs.getString("tel"));

		if (mapAllColumns || columnsToReadMap.get("CELL") != null)
			dto.setCell(rs.getString("cell"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ALTRISTUDI") != null)
			dto.setAltriStudi(rs.getString("altriStudi"));

		if (mapAllColumns || columnsToReadMap.get("TITOLOSTUDIOFRANCESE") != null)
			dto.setTitoloStudioFrancese(rs.getString("titoloStudioFrancese"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByCodiceFiscalePersonaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByCodiceFiscalePersonaDto
	 * @generated
	 */

	public TaifTPersonaByCodiceFiscalePersonaDto mapRow_internal(TaifTPersonaByCodiceFiscalePersonaDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPersonaByCodiceFiscalePersonaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICORESIDENZA") != null)
			dto.setCivicoResidenza(rs.getString("civicoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ASTUDI") != null)
			dto.setAStudi(rs.getString("aStudi"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByCodiceFiscalePersonaPerContrattoDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByCodiceFiscalePersonaPerContrattoDto
	 * @generated
	 */

	public TaifTPersonaByCodiceFiscalePersonaPerContrattoDto mapRow_internal(
			TaifTPersonaByCodiceFiscalePersonaPerContrattoDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPersonaByCodiceFiscalePersonaPerContrattoDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("ASTUDI") != null)
			dto.setAStudi(rs.getString("aStudi"));

		if (mapAllColumns || columnsToReadMap.get("IDRUOLOPERSONA") != null)
			dto.setIdRuoloPersona((Integer) rs.getObject("idRuoloPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDMANSIONE") != null)
			dto.setIdMansione((Integer) rs.getObject("idMansione"));

		if (mapAllColumns || columnsToReadMap.get("IDCONTRATTOPERSONA") != null)
			dto.setIdContrattoPersona((Integer) rs.getObject("idContrattoPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDINQUADRAMENTO") != null)
			dto.setIdInquadramento((Integer) rs.getObject("idInquadramento"));

		if (mapAllColumns || columnsToReadMap.get("FLAGTEMPODETT") != null)
			dto.setFlagTempoDett(rs.getBigDecimal("flagTempoDett"));

		if (mapAllColumns || columnsToReadMap.get("GGTEMPODETT") != null)
			dto.setGgTempoDett((Integer) rs.getObject("ggTempoDett"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaProfiloUtenteByCodiceFiscaleDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaProfiloUtenteByCodiceFiscaleDto
	 * @generated
	 */

	public TaifTPersonaProfiloUtenteByCodiceFiscaleDto mapRow_internal(
			TaifTPersonaProfiloUtenteByCodiceFiscaleDto objectToFill, ResultSet rs, int row) throws SQLException {
		TaifTPersonaProfiloUtenteByCodiceFiscaleDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICORESIDENZA") != null)
			dto.setCivicoResidenza(rs.getString("civicoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ASTUDI") != null)
			dto.setAStudi(rs.getString("aStudi"));

		if (mapAllColumns || columnsToReadMap.get("IDPROFILOUTENTE") != null)
			dto.setIdProfiloUtente((Integer) rs.getObject("idProfiloUtente"));

		if (mapAllColumns || columnsToReadMap.get("PROFILOUTENTE") != null)
			dto.setProfiloUtente(rs.getString("profiloUtente"));

		if (mapAllColumns || columnsToReadMap.get("FLAGUTENTEATTIVO") != null)
			dto.setFlagUtenteAttivo(rs.getBigDecimal("flagUtenteAttivo"));

		if (mapAllColumns || columnsToReadMap.get("PROCEDURAUTENTE") != null)
			dto.setProceduraUtente((Integer) rs.getObject("proceduraUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDCONFIGUTENTE") != null)
			dto.setIdConfigUtente((Integer) rs.getObject("idConfigUtente"));

		if (mapAllColumns || columnsToReadMap.get("IDSOGGETTOGESTORE") != null)
			dto.setIdSoggettoGestore((Integer) rs.getObject("idSoggettoGestore"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByIdAziendaDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByIdAziendaDto
	 * @generated
	 */

	public TaifTPersonaByIdAziendaDto mapRow_internal(TaifTPersonaByIdAziendaDto objectToFill, ResultSet rs, int row)
			throws SQLException {
		TaifTPersonaByIdAziendaDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("IDSTATO") != null)
			dto.setIdStato((Integer) rs.getObject("idStato"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("MSA") != null)
			dto.setMsa(rs.getString("msa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERO") != null)
			dto.setComuneEstero(rs.getString("comuneEstero"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneresidenza(rs.getString("istatComuneresidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICO") != null)
			dto.setCivico(rs.getString("civico"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ASTUDI") != null)
			dto.setAStudi(rs.getString("aStudi"));

		if (mapAllColumns || columnsToReadMap.get("IDAZIENDA") != null)
			dto.setIdAzienda((Integer) rs.getObject("idAzienda"));

		if (mapAllColumns || columnsToReadMap.get("IDRUOLOPERSONA") != null)
			dto.setIdRuoloPersona((Integer) rs.getObject("idRuoloPersona"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERORESIDENZA") != null)
			dto.setComuneEsteroResidenza(rs.getString("comuneEsteroResidenza"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOMANSIONE") != null)
			dto.setIdTipoMansione((Integer) rs.getObject("idTipoMansione"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOCONTRATTO") != null)
			dto.setIdTipoContratto((Integer) rs.getObject("idTipoContratto"));

		if (mapAllColumns || columnsToReadMap.get("IDTIPOINQUADRAMENTO") != null)
			dto.setIdTipoInquadramento((Integer) rs.getObject("idTipoInquadramento"));

		if (mapAllColumns || columnsToReadMap.get("FLAGTENPODETERMINATO") != null)
			dto.setFlagTenpoDeterminato(rs.getBigDecimal("flagTenpoDeterminato"));

		if (mapAllColumns || columnsToReadMap.get("GIORNITEMPODETERMINATO") != null)
			dto.setGiorniTempoDeterminato((Integer) rs.getObject("giorniTempoDeterminato"));

		return dto;
	}

	/**
	 * Metodo specifico di mapping relativo al DTO custom TaifTPersonaByNrSiMsaPersonaFranceseDto.
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return TaifTPersonaByNrSiMsaPersonaFranceseDto
	 * @generated
	 */

	public TaifTPersonaByNrSiMsaPersonaFranceseDto mapRow_internal(TaifTPersonaByNrSiMsaPersonaFranceseDto objectToFill,
			ResultSet rs, int row) throws SQLException {
		TaifTPersonaByNrSiMsaPersonaFranceseDto dto = objectToFill;

		if (mapAllColumns || columnsToReadMap.get("IDPERSONA") != null)
			dto.setIdPersona((Integer) rs.getObject("idPersona"));

		if (mapAllColumns || columnsToReadMap.get("IDTITOLO") != null)
			dto.setIdTitolo((Integer) rs.getObject("idTitolo"));

		if (mapAllColumns || columnsToReadMap.get("IDSTUDIOFRA") != null)
			dto.setIdStudioFra((Integer) rs.getObject("idStudioFra"));

		if (mapAllColumns || columnsToReadMap.get("IDNAZIONE") != null)
			dto.setIdNazione((Integer) rs.getObject("idNazione"));

		if (mapAllColumns || columnsToReadMap.get("CODICEFISCALE") != null)
			dto.setCodiceFiscale(rs.getString("codiceFiscale"));

		if (mapAllColumns || columnsToReadMap.get("NUMERORSIMSASA") != null)
			dto.setNumeroRsiMsaSa(rs.getString("numeroRsiMsaSa"));

		if (mapAllColumns || columnsToReadMap.get("COGNOME") != null)
			dto.setCognome(rs.getString("cognome"));

		if (mapAllColumns || columnsToReadMap.get("NOME") != null)
			dto.setNome(rs.getString("nome"));

		if (mapAllColumns || columnsToReadMap.get("SESSO") != null)
			dto.setSesso(rs.getString("sesso"));

		if (mapAllColumns || columnsToReadMap.get("DATANASCITA") != null)
			dto.setDataNascita(rs.getDate("dataNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNENASCITA") != null)
			dto.setIstatComuneNascita(rs.getString("istatComuneNascita"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERONASCITA") != null)
			dto.setComuneEsteroNascita(rs.getString("comuneEsteroNascita"));

		if (mapAllColumns || columnsToReadMap.get("ISTATCOMUNERESIDENZA") != null)
			dto.setIstatComuneResidenza(rs.getString("istatComuneResidenza"));

		if (mapAllColumns || columnsToReadMap.get("INDIRIZZORESIDENZA") != null)
			dto.setIndirizzoResidenza(rs.getString("indirizzoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CIVICORESIDENZA") != null)
			dto.setCivicoResidenza(rs.getString("civicoResidenza"));

		if (mapAllColumns || columnsToReadMap.get("CAP") != null)
			dto.setCap(rs.getString("cap"));

		if (mapAllColumns || columnsToReadMap.get("TELEFONO") != null)
			dto.setTelefono(rs.getString("telefono"));

		if (mapAllColumns || columnsToReadMap.get("CELLULARE") != null)
			dto.setCellulare(rs.getString("cellulare"));

		if (mapAllColumns || columnsToReadMap.get("MAIL") != null)
			dto.setMail(rs.getString("mail"));

		if (mapAllColumns || columnsToReadMap.get("ASTUDI") != null)
			dto.setAStudi(rs.getString("aStudi"));

		if (mapAllColumns || columnsToReadMap.get("COMUNEESTERORESIDENZA") != null)
			dto.setComuneEsteroResidenza(rs.getString("comuneEsteroResidenza"));

		return dto;
	}

}
