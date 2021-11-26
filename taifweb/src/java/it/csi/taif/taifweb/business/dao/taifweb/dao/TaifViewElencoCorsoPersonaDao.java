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
 * Interfaccia pubblica del DAO taifViewElencoCorsoPersona.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifViewElencoCorsoPersonaDao {

	/** 
	 * Restituisce tutte le righe della tabella TAIF_V_ELENCO_CORSO_PERSONA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifViewElencoCorsoPersonaDto> findAll() throws TaifViewElencoCorsoPersonaDaoException;

	/** 
		 * Implementazione del finder corsiPerPersona con Qdef
		 * @generated
		 */

	public List<TaifViewElencoCorsoPersonaCorsiPerPersonaDto> findCorsiPerPersona(java.lang.Integer input)
			throws TaifViewElencoCorsoPersonaDaoException;

	/** 
	 * Implementazione del finder byCodiceFiscalePersona
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifViewElencoCorsoPersonaDto> findByCodiceFiscalePersona(String input)
			throws TaifViewElencoCorsoPersonaDaoException;

}
