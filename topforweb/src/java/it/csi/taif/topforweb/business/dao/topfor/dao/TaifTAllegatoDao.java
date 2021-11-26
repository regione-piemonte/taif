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
 * Interfaccia pubblica del DAO taifTAllegato.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTAllegatoDao {

	/**
	 * Metodo di inserimento del DAO taifTAllegato. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTAllegatoPk
	 * @generated
	 */

	public TaifTAllegatoPk insert(TaifTAllegatoDto dto)

	;

	/** 
	 * Deletes a single row in the TAIF_T_ALLEGATO table.
	 * @generated
	 */

	public void delete(TaifTAllegatoPk pk) throws TaifTAllegatoDaoException;

	/** 
	 * Returns all rows from the TAIF_T_ALLEGATO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTAllegatoDto findByPrimaryKey(TaifTAllegatoPk pk) throws TaifTAllegatoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_ALLEGATO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTAllegatoDto> findAll() throws TaifTAllegatoDaoException;

	/** 
		 * Implementazione del finder byCorsoPersona con Qdef
		 * @generated
		 */

	public List<TaifTAllegatoByCorsoPersonaDto> findByCorsoPersona(
			it.csi.taif.topforweb.business.dao.topfor.filter.AllegatoFilter input) throws TaifTAllegatoDaoException;

}
