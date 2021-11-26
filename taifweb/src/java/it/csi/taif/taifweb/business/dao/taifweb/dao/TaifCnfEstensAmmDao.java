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
 * Interfaccia pubblica del DAO taifCnfEstensAmm.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifCnfEstensAmmDao {

	/** 
	 * Returns all rows from the TAIF_CNF_ESTENS_AMM table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfEstensAmmDto findByPrimaryKey(TaifCnfEstensAmmPk pk) throws TaifCnfEstensAmmDaoException;

	/** 
	 * Implementazione del finder byEstensioneFileAndTipoAllegato
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfEstensAmmDto> findByEstensioneFileAndTipoAllegato(String estensione, Integer input)
			throws TaifCnfEstensAmmDaoException;

}
