/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.helper.dto.factory;

import java.util.ArrayList;
import java.util.List;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfMailDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifCnfTipoMailDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTOpfoDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTSoggettoGestoreDto;
import it.csi.taif.topforweb.business.dao.util.Constants;
import it.csi.taif.topforweb.dto.common.DettaglioEmail;
import it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.util.ConvertUtil;

public final class DettaglioEmailFactory {

	public static DettaglioEmail createDettaglioEmail(CpInserimentoOperatoreModel theModel, String tipoAccesso, 
			TaifCnfMailDto configMail, TaifCnfTipoMailDto mailDto,
			TaifTPersonaDto dto, TaifTSoggettoGestoreDto sogg, TaifTOpfoDto opfo) {

		DettaglioEmail result = new DettaglioEmail();
		
		result.setHost(configMail.getHost());
		result.setUserID(configMail.getUserId());
		result.setPassword(configMail.getPassword());
		result.setPort(ConvertUtil.convertToString(configMail.getPorta()));
		result.setProtocol(configMail.getProtocollo());
		result.setMittente(configMail.getMittente());
		
		result.setOggetto(mailDto.getOggetto());
		Message msgCorpo = null;
		 
		if(tipoAccesso.equalsIgnoreCase(Constants.TIPO_ACCESSO_OPERATORE_IT)) {
			 msgCorpo = new Message(
					mailDto.getTesto(),
					dto.getCognome(), 
					dto.getNome(), 
					sogg.getDenominazioneBreve(),
					dto.getNome(),
					dto.getCognome(),
					dto.getTelefono(),
					dto.getMail());
		} else if(tipoAccesso.equalsIgnoreCase(Constants.TIPO_ACCESSO_GESTORE_IT)){
			 msgCorpo = new Message(
						mailDto.getTesto(),
						sogg.getDenominazioneBreve(),
						ConvertUtil.getDescriptionById(theModel.getAppDataidStatoSchedaSelezionato(),theModel.getAppDataelencoStatoSchedaRicerca()),
						theModel.getAppDatamotivazioneRifiutoValidazione(),
						sogg.getDenominazione(),
						sogg.getTelefono(),
						sogg.getMail(),
						sogg.getPec(),"");
		}
		
		result.setCorpo(msgCorpo.getText());
		
		List<String> destinatari = new ArrayList<String>();
		List<String> destinatariCC = new ArrayList<String>();
		if(it.csi.taif.topforweb.business.dao.util.Constants.oneInt == ConvertUtil.convertToInteger(mailDto.getFlgTipoMail())) {
			destinatari.add(sogg.getMail());
			destinatariCC.add(dto.getMail());
		}
		else {
			destinatari.add(dto.getMail());
			destinatariCC.add(sogg.getMail());
		}
		
		result.setDestinatari(destinatari);
		result.setDestinatariCC(destinatariCC);
		
		return result;
	}
	
	
	
}
