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
 * Interfaccia pubblica del DAO taifRAttivDetMateriale.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifRAttivDetMaterialeDao {

	/**
	 * Metodo di inserimento del DAO taifRAttivDetMateriale. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRAttivDetMaterialePk
	 * @generated
	 */

	public TaifRAttivDetMaterialePk insert(TaifRAttivDetMaterialeDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_R_ATTIVDET_MATERIALE table.
	 * @generated
	 */
	public void update(TaifRAttivDetMaterialeDto dto) throws TaifRAttivDetMaterialeDaoException;

	/** 
	 * Updates selected columns in the TAIF_R_ATTIVDET_MATERIALE table.
	 * @generated
	 */
	public void updateColumnsByAttivitaAzienda(TaifRAttivDetMaterialeDto dto) throws TaifRAttivDetMaterialeDaoException;

	/** 
	 * Deletes a single row in the TAIF_R_ATTIVDET_MATERIALE table.
	 * @generated
	 */

	public void delete(TaifRAttivDetMaterialePk pk) throws TaifRAttivDetMaterialeDaoException;

	/** 
	 * Returns all rows from the TAIF_R_ATTIVDET_MATERIALE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRAttivDetMaterialeDto findByPrimaryKey(TaifRAttivDetMaterialePk pk)
			throws TaifRAttivDetMaterialeDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_ATTIVDET_MATERIALE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRAttivDetMaterialeDto> findAll() throws TaifRAttivDetMaterialeDaoException;

	/** 
		 * Implementazione del finder byIdMateriale con Qdef
		 * @generated
		 */

	public List<TaifRAttivDetMaterialeByIdMaterialeDto> findByIdMateriale(java.lang.Integer input)
			throws TaifRAttivDetMaterialeDaoException;

	/** 
		 * Implementazione del finder byIdAttivita con Qdef
		 * @generated
		 */

	public List<TaifRAttivDetMaterialeByIdAttivitaDto> findByIdAttivita(java.lang.Integer input)
			throws TaifRAttivDetMaterialeDaoException;

	/** 
		 * Implementazione del finder byIdAttivitaProgressivo con Qdef
		 * @generated
		 */

	public List<TaifRAttivDetMaterialeByIdAttivitaProgressivoDto> findByIdAttivitaProgressivo(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AttivitaProgressivoFilter input)
			throws TaifRAttivDetMaterialeDaoException;

}
