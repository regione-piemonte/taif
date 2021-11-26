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
 * Interfaccia pubblica del DAO taifVElencoQualificaPersona.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifVElencoQualificaPersonaDao {

	/** 
	 * Implementazione del finder byIdPersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVElencoQualificaPersonaDto> findByIdPersona(Integer input)
			throws TaifVElencoQualificaPersonaDaoException;

	/** 
	 * Implementazione del finder byCodiceFiscalePersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifVElencoQualificaPersonaDto> findByCodiceFiscalePersona(String input)
			throws TaifVElencoQualificaPersonaDaoException;

}
