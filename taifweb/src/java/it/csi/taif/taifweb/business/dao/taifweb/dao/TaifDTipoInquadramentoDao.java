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
 * Interfaccia pubblica del DAO taifDTipoInquadramento.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDTipoInquadramentoDao {

	/**
	 * Metodo di inserimento del DAO taifDTipoInquadramento. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifDTipoInquadramentoPk
	 * @generated
	 */

	public TaifDTipoInquadramentoPk insert(TaifDTipoInquadramentoDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_D_TIPO_INQUADRAMENTO table.
	 * @generated
	 */
	public void update(TaifDTipoInquadramentoDto dto) throws TaifDTipoInquadramentoDaoException;

	/** 
	 * Deletes a single row in the TAIF_D_TIPO_INQUADRAMENTO table.
	 * @generated
	 */

	public void delete(TaifDTipoInquadramentoPk pk) throws TaifDTipoInquadramentoDaoException;

	/** 
	 * Returns all rows from the TAIF_D_TIPO_INQUADRAMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDTipoInquadramentoDto findByPrimaryKey(TaifDTipoInquadramentoPk pk)
			throws TaifDTipoInquadramentoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_TIPO_INQUADRAMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDTipoInquadramentoDto> findAll() throws TaifDTipoInquadramentoDaoException;

	/** 
		 * Implementazione del finder byVisible con Qdef
		 * @generated
		 */

	public List<TaifDTipoInquadramentoByVisibleDto> findByVisible(java.lang.Integer input)
			throws TaifDTipoInquadramentoDaoException;

	/** 
		 * Implementazione del finder byTipoInquadramento con Qdef
		 * @generated
		 */

	public List<TaifDTipoInquadramentoByTipoInquadramentoDto> findByTipoInquadramento(
			it.csi.taif.taifweb.business.dao.taifweb.filter.InquadramentoFilter input)
			throws TaifDTipoInquadramentoDaoException;

	/** 
		 * Implementazione del finder byIdInquadramento con Qdef
		 * @generated
		 */

	public List<TaifDTipoInquadramentoByIdInquadramentoDto> findByIdInquadramento(
			it.csi.taif.taifweb.business.dao.taifweb.filter.InquadramentoFilter input)
			throws TaifDTipoInquadramentoDaoException;

}
