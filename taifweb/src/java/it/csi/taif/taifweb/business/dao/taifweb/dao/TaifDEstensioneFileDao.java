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
 * Interfaccia pubblica del DAO taifDEstensioneFile.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDEstensioneFileDao {

	/**
	 * Metodo di inserimento del DAO taifDEstensioneFile. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDEstensioneFilePk
	 * @generated
	 */

	public TaifDEstensioneFilePk insert(TaifDEstensioneFileDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_ESTENSIONE_FILE table.
	 * @generated
	 */
	public void update(TaifDEstensioneFileDto dto) throws TaifDEstensioneFileDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_ESTENSIONE_FILE table.
	 * @generated
	 */

	public void delete(TaifDEstensioneFilePk pk) throws TaifDEstensioneFileDaoException;

	/** 
	 * Returns all rows from the TAIF_D_ESTENSIONE_FILE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDEstensioneFileDto findByPrimaryKey(TaifDEstensioneFilePk pk) throws TaifDEstensioneFileDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_ESTENSIONE_FILE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDEstensioneFileDto> findAll() throws TaifDEstensioneFileDaoException;

	/** 
		 * Implementazione del finder estensioneFileVisible con Qdef
		 * @generated
		 */

	public List<TaifDEstensioneFileEstensioneFileVisibleDto> findEstensioneFileVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.VisibileOrdinFilter input)
			throws TaifDEstensioneFileDaoException;

	/** 
		 * Implementazione del finder estensioneFileAmm con Qdef
		 * @generated
		 */

	public List<TaifDEstensioneFileEstensioneFileAmmDto> findEstensioneFileAmm(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifDEstensioneFileDaoException;

	/** 
		 * Implementazione del finder estensionePerTipoDocumentoSelezionato con Qdef
		 * @generated
		 */

	public List<TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto> findEstensionePerTipoDocumentoSelezionato(
			it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter input)
			throws TaifDEstensioneFileDaoException;

}
