/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
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
	 * Updates selected columns in the TAIF_T_PERSONA table.
	 * @generated
	 */
	public void updateColumnsByIdPersona(TaifTPersonaDto dto) throws TaifTPersonaDaoException;

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
		 * Implementazione del finder datiIdentificativiOperatore con Qdef
		 * @generated
		 */

	public List<TaifTPersonaDatiIdentificativiOperatoreDto> findDatiIdentificativiOperatore(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder profiloUtenteByCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTPersonaProfiloUtenteByCodiceFiscaleDto> findProfiloUtenteByCodiceFiscale(
			it.csi.taif.topforweb.business.dao.topfor.filter.ConfigProfiloFilter input) throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byCodiceFiscalePersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByCodiceFiscalePersonaDto> findByCodiceFiscalePersona(java.lang.String input)
			throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTPersonaByFilterDto> findByFilter(
			it.csi.taif.topforweb.business.dao.topfor.filter.PersonaFilter input) throws TaifTPersonaDaoException;

	/** 
	 * Implementazione del finder loginInfo
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTPersonaDto> findLoginInfo(it.csi.taif.topforweb.dto.common.LoginInfo input)
			throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder anagraficaOperatoreByIdOperatore con Qdef
		 * @generated
		 */

	public List<TaifTPersonaAnagraficaOperatoreByIdOperatoreDto> findAnagraficaOperatoreByIdOperatore(
			java.lang.Integer input) throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder operatoriCorsiPerPersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaOperatoriCorsiPerPersonaDto> findOperatoriCorsiPerPersona(java.lang.Integer input)
			throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder qualifichePerPersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaQualifichePerPersonaDto> findQualifichePerPersona(java.lang.Integer input)
			throws TaifTPersonaDaoException;

	/** 
		 * Implementazione del finder riconoscimentiPerPersona con Qdef
		 * @generated
		 */

	public List<TaifTPersonaRiconoscimentiPerPersonaDto> findRiconoscimentiPerPersona(java.lang.Integer input)
			throws TaifTPersonaDaoException;

}
