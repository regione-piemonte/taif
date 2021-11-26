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
 * Interfaccia pubblica del DAO taifTCorso.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTCorsoDao {

	/**
	 * Metodo di inserimento del DAO taifTCorso. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTCorsoPk
	 * @generated
	 */

	public TaifTCorsoPk insert(TaifTCorsoDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_T_CORSO table.
	 * @generated
	 */
	public void updateColumnsForIdCorso(TaifTCorsoDto dto) throws TaifTCorsoDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_CORSO table.
	 * @generated
	 */

	public void delete(TaifTCorsoPk pk) throws TaifTCorsoDaoException;

	/** 
	 * Returns all rows from the TAIF_T_CORSO table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTCorsoDto findByPrimaryKey(TaifTCorsoPk pk) throws TaifTCorsoDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_CORSO.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTCorsoDto> findAll() throws TaifTCorsoDaoException;

	/** 
		 * Implementazione del finder byFilterUnitaFormativa con Qdef
		 * @generated
		 */

	public List<TaifTCorsoByFilterUnitaFormativaDto> findByFilterUnitaFormativa(
			it.csi.taif.topforweb.business.dao.topfor.filter.UnitaFormativaFilter input) throws TaifTCorsoDaoException;

	/** 
		 * Implementazione del finder byFilterVisible con Qdef
		 * @generated
		 */

	public List<TaifTCorsoByFilterVisibleDto> findByFilterVisible(
			it.csi.taif.topforweb.business.dao.topfor.filter.VisibileOrdinFilter input) throws TaifTCorsoDaoException;

	/** 
		 * Implementazione del finder corsiPerAgenziaUnita con Qdef
		 * @generated
		 */

	public List<TaifTCorsoCorsiPerAgenziaUnitaDto> findCorsiPerAgenziaUnita(
			it.csi.taif.topforweb.business.dao.topfor.filter.CorsoFormazioneFilter input) throws TaifTCorsoDaoException;

}
