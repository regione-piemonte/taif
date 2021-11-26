/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.dao.taifweb.dao;

import it.csi.taif.taifweb.business.dao.taifweb.dao.*;
import it.csi.taif.taifweb.business.dao.taifweb.dto.*;
import it.csi.taif.taifweb.business.dao.taifweb.qbe.*;
import it.csi.taif.taifweb.business.dao.taifweb.metadata.*;
import it.csi.taif.taifweb.business.dao.taifweb.exceptions.*;
import it.csi.taif.taifweb.business.dao.util.*;
import it.csi.taif.taifweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO taifTPersona.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTPersonaDao {

	/**
	 * Metodo di inserimento del DAO taifTPersona. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTPersonaPk
	 * @generated
	 */

	public TaifTPersonaPk insert(TaifTPersonaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_PERSONA table.
	 * @generated
	 */
	public void update(TaifTPersonaDto dto) throws TaifTPersonaDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_PERSONA table.
	 * @generated
	 */
	public void updateColumnsForTitolareRappresentante(TaifTPersonaDto dto) throws TaifTPersonaDaoException;

	/** 
	 * Custom deleter in the TAIF_T_PERSONA table.
	 * @generated
	 */
	public void customDeleterDeletePersonaByCodiceFiscale(java.lang.String filter) throws TaifTPersonaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_PERSONA table.
	 * @generated
	 */

	public void delete(TaifTPersonaPk pk) throws TaifTPersonaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_PERSONA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTPersonaDto findByPrimaryKey(TaifTPersonaPk pk) throws TaifTPersonaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_PERSONA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPersonaDto> findAll() throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter input) throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byConfigUtente con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByConfigUtenteDto> findByConfigUtente(java.lang.Integer input)
			throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byProfiloPersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByProfiloPersonaDto> findByProfiloPersona(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloPersona input) throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder titoloStudioByIdTitoleStudioVisibileIta con Qdef
		 * @generated
		 */

	public List<TaifTPersonaTitoloStudioByIdTitoleStudioVisibileItaDto> findTitoloStudioByIdTitoleStudioVisibileIta(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TitoloStudioFilter input) throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder titoloStudioByIdTitoleStudioVisibileFra con Qdef
		 * @generated
		 */

	public List<TaifTPersonaTitoloStudioByIdTitoleStudioVisibileFraDto> findTitoloStudioByIdTitoleStudioVisibileFra(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TitoloStudioFilter input) throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byCodiceFiscalePersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByCodiceFiscalePersonaDto> findByCodiceFiscalePersona(java.lang.String input)
			throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byCodiceFiscalePersonaPerContratto con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByCodiceFiscalePersonaPerContrattoDto> findByCodiceFiscalePersonaPerContratto(
			java.lang.String input) throws TaifTPersonaDaoException;

	/** 
	 * Implementazione del finder loginInfo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPersonaDto> findLoginInfo(it.csi.taif.taifweb.dto.common.LoginInfo input)
			throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder profiloUtenteByCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> findProfiloUtenteByCodiceFiscale(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ConfigProfiloFilter input) throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByIdAziendaDto> findByIdAzienda(java.lang.Integer input) throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byNrSiMsaPersonaFrancese con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByNrSiMsaPersonaFranceseDto> findByNrSiMsaPersonaFrancese(java.lang.String input)
			throws TaifTPersonaDaoException;
	
	/** 
	 * Implementazione del finder byCodiceIdentificativoFilter
	 */
	
	public List<TaifTPersonaByFilterDto> findByCodiceIdentificativoFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaFilter input) throws TaifTPersonaDaoException;

}
