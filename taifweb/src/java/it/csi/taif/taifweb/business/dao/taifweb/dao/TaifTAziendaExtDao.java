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

/**
 * Interfaccia pubblica del DAO taifTAzienda.
 * Espone le operazioni che possono essere eseguite per la gestione 
 * della tabella [Table[TRANSIENT]]
 * @generated
 */
public interface TaifTAziendaExtDao {

	
	public List<TaifTAziendaIntestazioneRiepilogoDto> findIntestazioneRiepilogo(java.lang.Integer idAzienda,
			java.lang.Integer input) throws TaifTAziendaDaoException;

	public List<TaifTAziendaIntestazioneRiepilogoByPraticaDto> findIntestazioneRiepilogoByPratica(Integer idPratica) throws TaifTAziendaDaoException;

}
