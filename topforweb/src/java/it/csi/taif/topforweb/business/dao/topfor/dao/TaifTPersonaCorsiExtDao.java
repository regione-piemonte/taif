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
 * Interfaccia pubblica del DAO taifTPersonaCorsiExt.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTPersonaCorsiExtDao {

	/** 
		 * Implementazione del finder corsiFinanziatiRegione con Qdef
		 * @generated
		 */

	public List<TaifTPersonaCorsiExtCorsiFinanziatiRegioneDto> findCorsiFinanziatiRegione(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTPersonaCorsiExtDaoException;

	/** 
		 * Implementazione del finder altriCorsi con Qdef
		 * @generated
		 */

	public List<TaifTPersonaCorsiExtAltriCorsiDto> findAltriCorsi(
			it.csi.taif.topforweb.business.dao.topfor.filter.RicercaOperatoreFilter input)
			throws TaifTPersonaCorsiExtDaoException;

}
