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
 * Interfaccia pubblica del DAO taifTSedeAzienda.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTSedeAziendaDao {

	/**
	 * Metodo di inserimento del DAO taifTSedeAzienda. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTSedeAziendaPk
	 * @generated
	 */

	public TaifTSedeAziendaPk insert(TaifTSedeAziendaDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_SEDE_AZIENDA table.
	 * @generated
	 */
	public void update(TaifTSedeAziendaDto dto) throws TaifTSedeAziendaDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_SEDE_AZIENDA table.
	 * @generated
	 */
	public void updateColumnsUpdateColSediAzienda(TaifTSedeAziendaDto dto) throws TaifTSedeAziendaDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_SEDE_AZIENDA table.
	 * @generated
	 */

	public void delete(TaifTSedeAziendaPk pk) throws TaifTSedeAziendaDaoException;

	/** 
	 * Returns all rows from the TAIF_T_SEDE_AZIENDA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTSedeAziendaDto findByPrimaryKey(TaifTSedeAziendaPk pk) throws TaifTSedeAziendaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_SEDE_AZIENDA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTSedeAziendaDto> findAll() throws TaifTSedeAziendaDaoException;

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifTSedeAziendaByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifTSedeAziendaDaoException;

	/** 
		 * Implementazione del finder idMaxValue con Qdef
		 * @generated
		 */

	public List<TaifTSedeAziendaIdMaxValueDto> findIdMaxValue(java.lang.Integer input)
			throws TaifTSedeAziendaDaoException;

}
