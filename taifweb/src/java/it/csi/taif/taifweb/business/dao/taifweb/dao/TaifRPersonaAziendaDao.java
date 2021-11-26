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
 * Interfaccia pubblica del DAO taifRPersonaAzienda.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifRPersonaAziendaDao {

	/**
	 * Metodo di inserimento del DAO taifRPersonaAzienda. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifRPersonaAziendaPk
	 * @generated
	 */

	public TaifRPersonaAziendaPk insert(TaifRPersonaAziendaDto dto)

	;

	/** 
	 * Updates selected columns in the TAIF_R_PERSONA_AZIENDA table.
	 * @generated
	 */
	public void updateColumnsPersonaAzienda(TaifRPersonaAziendaDto dto) throws TaifRPersonaAziendaDaoException;

	/** 
	 * Deletes a single row in the TAIF_R_PERSONA_AZIENDA table.
	 * @generated
	 */

	public void delete(TaifRPersonaAziendaPk pk) throws TaifRPersonaAziendaDaoException;

	/** 
	 * Returns all rows from the TAIF_R_PERSONA_AZIENDA table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifRPersonaAziendaDto findByPrimaryKey(TaifRPersonaAziendaPk pk) throws TaifRPersonaAziendaDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_R_PERSONA_AZIENDA.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifRPersonaAziendaDto> findAll() throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder byIdAzienda con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaByIdAziendaDto> findByIdAzienda(java.lang.Integer input)
			throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder contrattoByIdPersona con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaContrattoByIdPersonaDto> findContrattoByIdPersona(java.lang.Integer input)
			throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder byFkUtente con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaByFkUtenteDto> findByFkUtente(java.lang.Integer input)
			throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder byAziendaUtente con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaByAziendaUtenteDto> findByAziendaUtente(
			it.csi.taif.taifweb.business.dao.taifweb.filter.PersonaAziendaFilter input)
			throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder tipoInquadramentoByIdInquadramentoVisibile con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaTipoInquadramentoByIdInquadramentoVisibileDto> findTipoInquadramentoByIdInquadramentoVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.InquadramentoFilter input)
			throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder ruoloByIdRuoloVisibile con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaRuoloByIdRuoloVisibileDto> findRuoloByIdRuoloVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.RuoloFilter input) throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder contrattoByIdContrattoVisibile con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaContrattoByIdContrattoVisibileDto> findContrattoByIdContrattoVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ContrattoFilter input)
			throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder mansioneByIdMansioneVisibile con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaMansioneByIdMansioneVisibileDto> findMansioneByIdMansioneVisibile(
			it.csi.taif.taifweb.business.dao.taifweb.filter.MansioneFilter input)
			throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder conteggioPersona con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaConteggioPersonaDto> findConteggioPersona(java.lang.Integer input)
			throws TaifRPersonaAziendaDaoException;

	/** 
		 * Implementazione del finder rappresentanteLegaleAzienda con Qdef
		 * @generated
		 */

	public List<TaifRPersonaAziendaRappresentanteLegaleAziendaDto> findRappresentanteLegaleAzienda(
			java.lang.Integer input) throws TaifRPersonaAziendaDaoException;

}
