/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import java.util.ArrayList;
import java.util.List;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfMailDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifCnfTipoMailDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDettaglioPraticaPerInvioDto;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.dto.common.DettaglioEmail;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;

public final class DettaglioEmailFactory {

	public static DettaglioEmail createDettaglioEmail(TaifCnfMailDto configMail, TaifCnfTipoMailDto mailDto,
			TaifTPraticaDettaglioPraticaPerInvioDto dto) {

		final DettaglioEmail result = new DettaglioEmail();
		
		result.setHost(configMail.getHost());
		result.setUserID(configMail.getUserId());
		result.setPassword(configMail.getPassword());
		result.setPort(ConvertUtil.convertToString(configMail.getPorta()));
		result.setProtocol(configMail.getProtocollo());
		result.setMittente(configMail.getMittente());
		
		result.setOggetto(mailDto.getOggetto());
		
		final Message msgCorpo = new Message(mailDto.getTesto(), 
				dto.getPeCognome(), 
				dto.getPeNome(), 
				dto.getAzRagioneSociale(),
				dto.getAzPartitaIva(), 
				dto.getSgDenominazioneBreve(), 
				dto.getSgDenominazione(), 
				dto.getSgTelefono(), 
				dto.getMailSoggettoGestore(), 
				dto.getPecSoggettoGestore());
		
		result.setCorpo(msgCorpo.getText());
		
		List<String> destinatari = new ArrayList<String>();
		List<String> destinatariCC = new ArrayList<String>();
		if(it.csi.taif.taifweb.business.dao.util.Constants.oneInt == ConvertUtil.convertToInteger(mailDto.getFlgTipoMail())) {
			destinatari.add(dto.getMailSoggettoGestore());
			destinatariCC.add(dto.getMailAzienda());
		}
		else {
			destinatari.add(dto.getMailAzienda());
		}
		
		result.setDestinatari(destinatari);
		result.setDestinatariCC(destinatariCC);
		
		return result;
	}
	
	
	
}
