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
 * Interfaccia pubblica del DAO taifCnfTipoMail.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifCnfTipoMailDao {

	/** 
	 * Returns all rows from the TAIF_CNF_TIPO_MAIL table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifCnfTipoMailDto findByPrimaryKey(TaifCnfTipoMailPk pk) throws TaifCnfTipoMailDaoException;

	/** 
	 * Implementazione del finder byStatoPratica
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifCnfTipoMailDto> findByStatoPratica(java.lang.Integer input) throws TaifCnfTipoMailDaoException;

}
