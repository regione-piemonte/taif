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
 * Interfaccia pubblica del DAO taifVApplSchedaOkReale.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifVApplSchedaOkRealeDao {

	/** 
	 * Implementazione del finder byPratica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVApplSchedaOkRealeDto> findByPratica(java.lang.Integer input)
			throws TaifVApplSchedaOkRealeDaoException;

	/** 
	 * Implementazione del finder byAzienda
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVApplSchedaOkRealeDto> findByAzienda(Integer input) throws TaifVApplSchedaOkRealeDaoException;

}
