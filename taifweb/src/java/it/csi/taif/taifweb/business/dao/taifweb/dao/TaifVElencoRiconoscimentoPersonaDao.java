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
 * Interfaccia pubblica del DAO taifVElencoRiconoscimentoPersona.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifVElencoRiconoscimentoPersonaDao {

	/** 
	 * Implementazione del finder byIdPersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVElencoRiconoscimentoPersonaDto> findByIdPersona(Integer input)
			throws TaifVElencoRiconoscimentoPersonaDaoException;

	/** 
	 * Implementazione del finder byCodiceFiscalePersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVElencoRiconoscimentoPersonaDto> findByCodiceFiscalePersona(String input)
			throws TaifVElencoRiconoscimentoPersonaDaoException;

}
