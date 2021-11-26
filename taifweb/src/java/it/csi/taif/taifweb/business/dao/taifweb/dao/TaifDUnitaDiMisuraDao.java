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
 * Interfaccia pubblica del DAO taifDUnitaDiMisura.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDUnitaDiMisuraDao {

	/**
	 * Metodo di inserimento del DAO taifDUnitaDiMisura. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDUnitaDiMisuraPk
	 * @generated
	 */

	public TaifDUnitaDiMisuraPk insert(TaifDUnitaDiMisuraDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_D_UNITA_DI_MISURA table.
	 * @generated
	 */

	public void delete(TaifDUnitaDiMisuraPk pk) throws TaifDUnitaDiMisuraDaoException;

	/** 
	 * Returns all rows from the TAIF_D_UNITA_DI_MISURA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDUnitaDiMisuraDto findByPrimaryKey(TaifDUnitaDiMisuraPk pk) throws TaifDUnitaDiMisuraDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_UNITA_DI_MISURA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDUnitaDiMisuraDto> findAll() throws TaifDUnitaDiMisuraDaoException;

	/** 
		 * Implementazione del finder byVisibleFilter con Qdef
		 * @generated
		 */

	public List<TaifDUnitaDiMisuraByVisibleFilterDto> findByVisibleFilter(java.lang.Integer input)
			throws TaifDUnitaDiMisuraDaoException;

	/** 
		 * Implementazione del finder byVisibleUnitaMisura con Qdef
		 * @generated
		 */

	public List<TaifDUnitaDiMisuraByVisibleUnitaMisuraDto> findByVisibleUnitaMisura(
			it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaMisuraFilter input)
			throws TaifDUnitaDiMisuraDaoException;

}
