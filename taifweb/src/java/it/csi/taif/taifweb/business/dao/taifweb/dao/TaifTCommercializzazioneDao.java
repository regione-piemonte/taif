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
 * Interfaccia pubblica del DAO taifTCommercializzazione.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTCommercializzazioneDao {

	/**
	 * Metodo di inserimento del DAO taifTCommercializzazione. Al termine dell'esecuzione il metodo
	 * ritorna il valore della primary key.
	 * 
	 * @param dto
	 * @return TaifTCommercializzazionePk
	 * @generated
	 */

	public TaifTCommercializzazionePk insert(TaifTCommercializzazioneDto dto)

	;

	/** 
	 * Updates a single row in the TAIF_T_COMMERCIALIZZAZIONE table.
	 * @generated
	 */
	public void update(TaifTCommercializzazioneDto dto) throws TaifTCommercializzazioneDaoException;

	/** 
	 * Updates selected columns in the TAIF_T_COMMERCIALIZZAZIONE table.
	 * @generated
	 */
	public void updateColumnsPeridAzienda(TaifTCommercializzazioneDto dto) throws TaifTCommercializzazioneDaoException;

	/** 
	 * Deletes a single row in the TAIF_T_COMMERCIALIZZAZIONE table.
	 * @generated
	 */

	public void delete(TaifTCommercializzazionePk pk) throws TaifTCommercializzazioneDaoException;

	/** 
	 * Returns all rows from the TAIF_T_COMMERCIALIZZAZIONE table that match the primary key criteria
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TaifTCommercializzazioneDto findByPrimaryKey(TaifTCommercializzazionePk pk)
			throws TaifTCommercializzazioneDaoException;

	/** 
	 * Restituisce tutte le righe della tabella TAIF_T_COMMERCIALIZZAZIONE.
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public List<TaifTCommercializzazioneDto> findAll() throws TaifTCommercializzazioneDaoException;

	/** 
		 * Implementazione del finder byFilter con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneByFilterDto> findByFilter(
			it.csi.taif.taifweb.business.dao.taifweb.filter.CommercializzazioneFilter input)
			throws TaifTCommercializzazioneDaoException;

	/** 
		 * Implementazione del finder byAzienda con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneByAziendaDto> findByAzienda(java.lang.Integer input)
			throws TaifTCommercializzazioneDaoException;

	/** 
		 * Implementazione del finder specieByIdSpecieVisible con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneSpecieByIdSpecieVisibleDto> findSpecieByIdSpecieVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.SpecieFilter input)
			throws TaifTCommercializzazioneDaoException;

	/** 
		 * Implementazione del finder provenienzaByIdProvenienzaVisible con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneProvenienzaByIdProvenienzaVisibleDto> findProvenienzaByIdProvenienzaVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.ProvenienzaFilter input)
			throws TaifTCommercializzazioneDaoException;

	/** 
		 * Implementazione del finder assortimentoByIdAssortimentoVisible con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneAssortimentoByIdAssortimentoVisibleDto> findAssortimentoByIdAssortimentoVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.AssortimentoFilter input)
			throws TaifTCommercializzazioneDaoException;

	/** 
		 * Implementazione del finder commUmByIdUnitaMisuraVisible con Qdef
		 * @generated
		 */

	public List<TaifTCommercializzazioneCommUmByIdUnitaMisuraVisibleDto> findCommUmByIdUnitaMisuraVisible(
			it.csi.taif.taifweb.business.dao.taifweb.filter.UnitaMisuraFilter input)
			throws TaifTCommercializzazioneDaoException;

}
