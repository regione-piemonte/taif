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
 * Interfaccia pubblica del DAO taifCnfParamActa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifCnfParamActaDao {

	/** 
	 * Updates selected columns in the TAIF_CNF_PARAM_ACTA table.
	 * @generated
	 */
	public void updateColumnsValoreByCodice(TaifCnfParamActaDto dto) throws TaifCnfParamActaDaoException;

	/** 
	 * Returns all rows from the TAIF_CNF_PARAM_ACTA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfParamActaDto findByPrimaryKey(TaifCnfParamActaPk pk) throws TaifCnfParamActaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_CNF_PARAM_ACTA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfParamActaDto> findAll() throws TaifCnfParamActaDaoException;

	/** 
	 * Implementazione del finder byCodice
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfParamActaDto> findByCodice(java.lang.String input) throws TaifCnfParamActaDaoException;

}
