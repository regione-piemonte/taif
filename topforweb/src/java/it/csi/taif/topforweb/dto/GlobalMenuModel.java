/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.taif.topforweb.dto.common.*;
import it.csi.taif.topforweb.dto.gestore.*;
import it.csi.taif.topforweb.dto.operatore.*;
import it.csi.taif.topforweb.dto.corsoprofessionale.*;
import it.csi.taif.topforweb.dto.qualifica.*;
import it.csi.taif.topforweb.dto.riconoscimento.*;
import it.csi.taif.topforweb.dto.allegato.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata al Menu
 */
public class GlobalMenuModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

}
