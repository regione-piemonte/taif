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
 * Interfaccia pubblica del DAO taifDNazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDNazioneDao {

	/**
	 * Metodo di inserimento del DAO taifDNazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDNazionePk
	 * @generated
	 */

	public TaifDNazionePk insert(TaifDNazioneDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_NAZIONE table.
	 * @generated
	 */
	public void update(TaifDNazioneDto dto) throws TaifDNazioneDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_NAZIONE table.
	 * @generated
	 */

	public void delete(TaifDNazionePk pk) throws TaifDNazioneDaoException;

	/** 
	 * Returns all rows from the TAIF_D_NAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDNazioneDto findByPrimaryKey(TaifDNazionePk pk) throws TaifDNazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_NAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDNazioneDto> findAll() throws TaifDNazioneDaoException;

	/** 
		 * Implementazione del finder byNazioneItaVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByNazioneItaVisibleDto> findByNazioneItaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDNazioneDaoException;

	/** 
		 * Implementazione del finder byNazioneFraVisible con Qdef
		 * @generated
		 */

	public List<TaifDNazioneByNazioneFraVisibleDto> findByNazioneFraVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input) throws TaifDNazioneDaoException;

}
