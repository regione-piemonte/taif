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
 * Interfaccia pubblica del DAO taifDUnitaFormativa.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifDUnitaFormativaDao {

	/** 
	 * Restituisce tutte le righe della tabella TAIF_D_UNITA_FORMATIVA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifDUnitaFormativaDto> findAll() throws TaifDUnitaFormativaDaoException;

	/** 
	 * Returns all rows from the TAIF_D_UNITA_FORMATIVA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifDUnitaFormativaDto findByPrimaryKey(TaifDUnitaFormativaPk pk) throws TaifDUnitaFormativaDaoException;

	/** 
		 * Implementazione del finder byFilterVisibleSoggettoGestore con Qdef
		 * @generated
		 */

	public List<TaifDUnitaFormativaByFilterVisibleSoggettoGestoreDto> findByFilterVisibleSoggettoGestore(
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDUnitaFormativaDaoException;

	/** 
		 * Implementazione del finder byFilterAgenziaFormativa con Qdef
		 * @generated
		 */

	public List<TaifDUnitaFormativaByFilterAgenziaFormativaDto> findByFilterAgenziaFormativa(
			it.csi.taif.topforweb.business.dao.topfor.filter.AgenziaFormativaFilter input)
			throws TaifDUnitaFormativaDaoException;

	/** 
		 * Implementazione del finder byAmbitoFormativo con Qdef
		 * @generated
		 */

	public List<TaifDUnitaFormativaByAmbitoFormativoDto> findByAmbitoFormativo(int idAmbitoFormativo,
			it.csi.taif.topforweb.business.dao.topfor.filter.SoggettoGestoreVisibleOrdinFilter input)
			throws TaifDUnitaFormativaDaoException;

}
