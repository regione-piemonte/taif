/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.dao.topfor.dao;

import it.csi.taif.topforweb.business.dao.topfor.dao.*;
import it.csi.taif.topforweb.business.dao.topfor.dto.*;
import it.csi.taif.topforweb.business.dao.topfor.qbe.*;
import it.csi.taif.topforweb.business.dao.topfor.metadata.*;
import it.csi.taif.topforweb.business.dao.topfor.exceptions.*;
import it.csi.taif.topforweb.business.dao.util.*;
import it.csi.taif.topforweb.business.dao.qbe.*;
import java.util.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interfaccia pubblica del DAO taifTRiconoscimento.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTRiconoscimentoDao {

	/**
	 * Metodo di inserimento del DAO taifTRiconoscimento. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTRiconoscimentoPk
	 * @generated
	 */

	public TaifTRiconoscimentoPk insert(TaifTRiconoscimentoDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_T_RICONOSCIMENTO table.
	 * @generated
	 */
	public void updateColumnsByIdRiconoscimento(TaifTRiconoscimentoDto dto) throws TaifTRiconoscimentoDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_RICONOSCIMENTO table.
	 * @generated
	 */

	public void delete(TaifTRiconoscimentoPk pk) throws TaifTRiconoscimentoDaoException;

	/** 
	 * Returns all rows from the TAIF_T_RICONOSCIMENTO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTRiconoscimentoDto findByPrimaryKey(TaifTRiconoscimentoPk pk) throws TaifTRiconoscimentoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_RICONOSCIMENTO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTRiconoscimentoDto> findAll() throws TaifTRiconoscimentoDaoException;

	/** 
		 * Implementazione del finder byIdPersona con Qdef
		 * @generated
		 */

	public List<TaifTRiconoscimentoByIdPersonaDto> findByIdPersona(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTRiconoscimentoDaoException;

}
