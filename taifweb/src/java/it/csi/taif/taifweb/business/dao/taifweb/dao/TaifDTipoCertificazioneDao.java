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
 * Interfaccia pubblica del DAO taifDTipoCertificazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoCertificazioneDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoCertificazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoCertificazionePk
	 * @generated
	 */

	public TaifDTipoCertificazionePk insert(TaifDTipoCertificazioneDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TIPO_CERTIFICAZIONE table.
	 * @generated
	 */
	public void update(TaifDTipoCertificazioneDto dto) throws TaifDTipoCertificazioneDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_CERTIFICAZIONE table.
	 * @generated
	 */

	public void delete(TaifDTipoCertificazionePk pk) throws TaifDTipoCertificazioneDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_CERTIFICAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoCertificazioneDto findByPrimaryKey(TaifDTipoCertificazionePk pk)
			throws TaifDTipoCertificazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_CERTIFICAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoCertificazioneDto> findAll() throws TaifDTipoCertificazioneDaoException;

	/** 
		 * Implementazione del finder tipoCertificazioneVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoCertificazioneTipoCertificazioneVisibleDto> findTipoCertificazioneVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDTipoCertificazioneDaoException;

}
