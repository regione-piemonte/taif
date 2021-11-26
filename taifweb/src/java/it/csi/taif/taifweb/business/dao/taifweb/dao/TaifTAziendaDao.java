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
 * Interfaccia pubblica del DAO taifTAzienda.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTAziendaDao {

	/**
	 * Metodo di inserimento del DAO taifTAzienda. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAziendaPk
	 * @generated
	 */

	public TaifTAziendaPk insert(TaifTAziendaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_AZIENDA table.
	 * @generated
	 */
	public void update(TaifTAziendaDto dto) throws TaifTAziendaDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_AZIENDA table.
	 * @generated
	 */
	public void updateColumnsAziendaByIdAzienda(TaifTAziendaDto dto) throws TaifTAziendaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_AZIENDA table.
	 * @generated
	 */

	public void delete(TaifTAziendaPk pk) throws TaifTAziendaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_AZIENDA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAziendaDto findByPrimaryKey(TaifTAziendaPk pk) throws TaifTAziendaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_AZIENDA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAziendaDto> findAll() throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder byCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTAziendaByCodiceFiscaleDto> findByCodiceFiscale(java.lang.String input)
			throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder byPiva con Qdef
		 * @generated
		 */

	public List<TaifTAziendaByPivaDto> findByPiva(java.lang.String input) throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder domandaByCodiceFiscale con Qdef
		 * @generated
		 */

	public List<TaifTAziendaDomandaByCodiceFiscaleDto> findDomandaByCodiceFiscale(java.lang.String input)
			throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder domandaAziendaPratica con Qdef
		 * @generated
		 */

	public List<TaifTAziendaDomandaAziendaPraticaDto> findDomandaAziendaPratica(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PraticaFilter input) throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder ricercaAziendaAvanzata con Qdef
		 * @generated
		 */

	public List<TaifTAziendaRicercaAziendaAvanzataDto> findRicercaAziendaAvanzata(
			it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter input) throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder ricercaAziendaExport con Qdef
		 * @generated
		 */

	public List<TaifTAziendaRicercaAziendaExportDto> findRicercaAziendaExport(
			it.csi.taif.taifweb.business.dao.taifweb.filter.RicercaAziendaFilter input) throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder elencoDomandaByLegaleRapp con Qdef
		 * @generated
		 */

	public List<TaifTAziendaElencoDomandaByLegaleRappDto> findElencoDomandaByLegaleRapp(java.lang.String input)
			throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder intestazioneRiepilogo con Qdef
		 * @generated
		 */

	public List<TaifTAziendaIntestazioneRiepilogoDto> findIntestazioneRiepilogo(java.lang.Integer idAzienda,
			java.lang.Integer input) throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder intestazioneRiepilogoByPratica con Qdef
		 * @generated
		 */

	public List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> findIntestazioneRiepilogoByPratica(
			java.lang.Integer input) throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder dettaglioAziendaByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTAziendaDettaglioAziendaByIdAziendaDto> findDettaglioAziendaByIdAzienda(java.lang.Integer input)
			throws TaifTAziendaDaoException;

	/** 
		 * Implementazione del finder elencoDomandaByLegaleRappAndProf con Qdef
		 * @generated
		 */

	public List<TaifTAziendaElencoDomandaByLegaleRappAndProfDto> findElencoDomandaByLegaleRappAndProf(
			java.lang.String input) throws TaifTAziendaDaoException;

}
