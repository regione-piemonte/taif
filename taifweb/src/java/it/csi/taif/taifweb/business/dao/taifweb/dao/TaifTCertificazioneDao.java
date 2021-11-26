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
 * Interfaccia pubblica del DAO taifTCertificazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTCertificazioneDao {

	/**
	 * Metodo di inserimento del DAO taifTCertificazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTCertificazionePk
	 * @generated
	 */

	public TaifTCertificazionePk insert(TaifTCertificazioneDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_CERTIFICAZIONE table.
	 * @generated
	 */
	public void update(TaifTCertificazioneDto dto) throws TaifTCertificazioneDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_CERTIFICAZIONE table.
	 * @generated
	 */
	public void updateColumnsCertificazione(TaifTCertificazioneDto dto) throws TaifTCertificazioneDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_CERTIFICAZIONE table.
	 * @generated
	 */

	public void delete(TaifTCertificazionePk pk) throws TaifTCertificazioneDaoException;

	/** 
	 * Returns all rows from the TAIF_T_CERTIFICAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTCertificazioneDto findByPrimaryKey(TaifTCertificazionePk pk) throws TaifTCertificazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_CERTIFICAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTCertificazioneDto> findAll() throws TaifTCertificazioneDaoException;

	/** 
		 * Implementazione del finder byAzienda con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneByAziendaDto> findByAzienda(java.lang.Integer input)
			throws TaifTCertificazioneDaoException;

	/** 
		 * Implementazione del finder byTipoCert con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneByTipoCertDto> findByTipoCert(java.lang.Integer input)
			throws TaifTCertificazioneDaoException;

	/** 
		 * Implementazione del finder elencoCertificazioni con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneElencoCertificazioniDto> findElencoCertificazioni(java.lang.Integer input)
			throws TaifTCertificazioneDaoException;

	/** 
		 * Implementazione del finder byAziendaTipoCert con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneByAziendaTipoCertDto> findByAziendaTipoCert(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CertificazioneFilter input)
			throws TaifTCertificazioneDaoException;

	/** 
		 * Implementazione del finder findCertificazioniByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneFindCertificazioniByIdAziendaDto> findFindCertificazioniByIdAzienda(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter input)
			throws TaifTCertificazioneDaoException;

	/** 
		 * Implementazione del finder dettaglioCertificazioniByIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTCertificazioneDettaglioCertificazioniByIdAziendaDto> findDettaglioCertificazioniByIdAzienda(
			java.lang.Integer input) throws TaifTCertificazioneDaoException;

}
