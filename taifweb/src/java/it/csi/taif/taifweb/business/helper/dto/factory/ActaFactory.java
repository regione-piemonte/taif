/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import static it.csi.taif.taifweb.util.ConvertUtil.convertToLong;

import java.util.Date;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoByIdPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDettaglioPraticaPerInvioDto;
import it.csi.taif.taifweb.util.ActaConstants;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.DateUtil;
import it.csi.taif.taifweb.util.GenericUtil;
import it.doqui.acta.actasrv.dto.acaris.type.archive.ClassificazionePropertiesType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.ContenutoFisicoPropertiesType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.DocumentoFisicoPropertiesType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.DocumentoSemplicePropertiesType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.EnumDocPrimarioType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.EnumTipoDocumentoType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.FascicoloRealeAnnualePropertiesType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.FascicoloRealePropertiesType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.GruppoAllegatiPropertiesType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdFascicoloStandardType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdFormaDocumentariaType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdStatoDiEfficaciaType;
import it.doqui.acta.actasrv.dto.acaris.type.backoffice.ClientApplicationInfo;
import it.doqui.acta.actasrv.dto.acaris.type.common.AcarisContentStreamType;
import it.doqui.acta.actasrv.dto.acaris.type.common.CodiceFiscaleType;
import it.doqui.acta.actasrv.dto.acaris.type.common.EnumStreamId;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdAOOType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdNodoType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdStrutturaType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdVitalRecordCodeType;
import it.doqui.acta.actasrv.dto.acaris.type.common.ObjectIdType;
import it.doqui.acta.actasrv.dto.acaris.type.common.PropertiesType;
import it.doqui.acta.actasrv.dto.acaris.type.document.ContenutoFisicoIRC;
import it.doqui.acta.actasrv.dto.acaris.type.document.DocumentoArchivisticoIRC;
import it.doqui.acta.actasrv.dto.acaris.type.document.DocumentoFisicoIRC;
import it.doqui.acta.actasrv.dto.acaris.type.document.EnumStepErrorAction;
import it.doqui.acta.actasrv.dto.acaris.type.document.EnumTipoDocumentoArchivistico;
import it.doqui.acta.actasrv.dto.acaris.type.document.StepErrorAction;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.DestinatarioInterno;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.EnumTipoAPI;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.EnumTipologiaSoggettoAssociato;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.IdentificazioneProtocollante;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.InfoCreazioneCorrispondente;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.InfoCreazioneRegistrazione;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.InfoSoggettoAssociato;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.MittenteEsterno;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.ProtocollazioneDocumentoEsistente;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.RegistrazioneAPI;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.RegistrazioneArrivo;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.RiferimentoSoggettoEsistente;

public final class ActaFactory {
	
	public static ObjectIdType createObjectIdType(String value) {
		ObjectIdType result = new ObjectIdType();
		result.setValue(value);
		return result;
	}

	public static CodiceFiscaleType createCodiceFiscaleType(String value) {
		CodiceFiscaleType result = new CodiceFiscaleType();
		result.setValue(value);
		return result;
	}

	public static ClientApplicationInfo createClientApplicationInfo(String value) {
		ClientApplicationInfo result = new ClientApplicationInfo();
		result.setAppKey(value);
		return result;
	}

	public static IdAOOType createIdAooType(String value) {
		IdAOOType result = new IdAOOType();
		result.setValue(convertToLong(value));
		return result;
	}

	public static IdStrutturaType createIdStrutturaTyoe(String value) {
		IdStrutturaType result = new IdStrutturaType();
		result.setValue(convertToLong(value));
		return result;
	}

	public static IdNodoType createIdNodoType(String value) {
		IdNodoType result = new IdNodoType();
		result.setValue(convertToLong(value));
		return result;
	}

	public static FascicoloRealePropertiesType createFascioloProperties(
			ObjectIdType repositoryId,
			IdVitalRecordCodeType idVitalRecordCode,
			IdAOOType idAOOType,
			IdStrutturaType idStrutturaType,
			IdNodoType idNodoType,
			IdFascicoloStandardType idFascicoloStandardType,
			TaifTPraticaDettaglioPraticaPerInvioDto pratica) {
		
		
		FascicoloRealeAnnualePropertiesType result = new FascicoloRealeAnnualePropertiesType() ;
		
		result.setIdAOORespMat(idAOOType);
		result.setIdNodoRespMat(idNodoType);
		result.setIdStrutturaRespMat(idStrutturaType);
		
		result.setOggetto(pratica.getAzRagioneSociale());
		result.setSoggetto(pratica.getAzCodiceFiscale());
		result.setParoleChiave(getRappresentanteLegale(pratica));
		
		result.setIdFascicoloStdRiferimento(idFascicoloStandardType);
		result.setParentId(repositoryId);
		
		result.setConservazioneCorrente(3);
		result.setConservazioneGenerale(10);
		result.setDatiPersonali(true);
		result.setDatiSensibili(false);
		result.setDatiRiservati(false);
		
		result.setArchivioCorrente(true);
		result.setDataCreazione(new Date());
		
		result.setIdVitalRecordCode(idVitalRecordCode);
		return result;
	}

	public static DocumentoArchivisticoIRC createDocumentoArchivisticoIRC(ObjectIdType parentFolder, 
			ObjectIdType classificazionePrincipaleID,
			IdFormaDocumentariaType idFormaDocumentariaType,
			IdVitalRecordCodeType idVitalRecordCodeType, 
			IdStatoDiEfficaciaType idStatoDiEfficaciaType,
			AcarisContentStreamType stream, 
			TaifTPraticaDettaglioPraticaPerInvioDto pratica, 
			TaifTAllegatoByIdPraticaDto allegato) {
		
		DocumentoArchivisticoIRC result = new DocumentoArchivisticoIRC();
		
		if(GenericUtil.getBooleanFromString(allegato.getTipoallegatoActaFlgAllegati())) {
			result.setAllegato(true);
			result.setClassificazionePrincipale(classificazionePrincipaleID);
		}
		else {
			result.setAllegato(false);
			result.setParentFolderId(parentFolder);
			result.setGruppoAllegati(createGruppoAllegati());
		}
		
		
		result.setTipoDocumento(EnumTipoDocumentoArchivistico.DOCUMENTO_SEMPLICE);
		
		// Dati di classificazione
		result.setPropertiesClassificazione(createClassificazioneProperties());
		// Dati principali
		result.setPropertiesDocumento(createDocumentoProperties(
				idFormaDocumentariaType, 
				idVitalRecordCodeType, 
				idStatoDiEfficaciaType, 
				pratica, 
				allegato));
		// Documenti
		result.setDocumentiFisici(createDocumentiFisici(allegato, stream));
		
		return result;
	}

	private static DocumentoFisicoIRC[] createDocumentiFisici(TaifTAllegatoByIdPraticaDto allegato, AcarisContentStreamType stream) {
		DocumentoFisicoIRC[] result = new DocumentoFisicoIRC[] {createDocumentoFisico(allegato, stream)};
		return result;
	}

	private static DocumentoFisicoIRC createDocumentoFisico(TaifTAllegatoByIdPraticaDto allegato, AcarisContentStreamType stream) {
		DocumentoFisicoIRC result = new DocumentoFisicoIRC();
		result.setPropertiesDocumentoFisico(createDocumentoFisicoProperties(allegato));
		result.setContenutiFisici(createContenutiFisici(stream));
		result.setAzioniVerificaFirma(createStetErrorAction());
		return result;
	}

	private static StepErrorAction[] createStetErrorAction() {
		StepErrorAction[] result = new StepErrorAction[7];
		for (int i = 0; i < 7; i++) {
			result[i] = new StepErrorAction();
			result[i].setAction(EnumStepErrorAction.INSERT);
			result[i].setStep(i + 1);
        }
		return result;
	}

	private static ContenutoFisicoIRC[] createContenutiFisici(AcarisContentStreamType stream) {
		ContenutoFisicoIRC[] result = new ContenutoFisicoIRC[] {creaContenutoFisico(stream)};
		return result;
	}

	private static ContenutoFisicoIRC creaContenutoFisico(AcarisContentStreamType stream) {
		ContenutoFisicoIRC result = new ContenutoFisicoIRC();
		result.setPropertiesContenutoFisico(createPropertiesContenutoFisico());
		result.setStream(stream);
		result.setTipo(EnumStreamId.PRIMARY);
		return result;
	}

	private static PropertiesType createPropertiesContenutoFisico() {
		ContenutoFisicoPropertiesType result = new ContenutoFisicoPropertiesType();
        result.setSbustamento(false);
		return result;
	}

	private static DocumentoFisicoPropertiesType createDocumentoFisicoProperties(TaifTAllegatoByIdPraticaDto allegato) {
		DocumentoFisicoPropertiesType result = new DocumentoFisicoPropertiesType();
        result.setDescrizione(allegato.getNomeAllegato());
        result.setDataMemorizzazione(new Date());
		return result;
	}

	private static GruppoAllegatiPropertiesType createGruppoAllegati() {
		GruppoAllegatiPropertiesType result = new GruppoAllegatiPropertiesType();
		result.setNumeroAllegati(ActaConstants.NUMERO_ALLEGATI);
		return result;
	}

	private static DocumentoSemplicePropertiesType createDocumentoProperties(
			IdFormaDocumentariaType idFormaDocumentariaType,
			IdVitalRecordCodeType idVitalRecordCodeType, 
			IdStatoDiEfficaciaType idStatoDiEfficaciaType,
			TaifTPraticaDettaglioPraticaPerInvioDto pratica, 
			TaifTAllegatoByIdPraticaDto allegato) {
		DocumentoSemplicePropertiesType result = new DocumentoSemplicePropertiesType();
				
		StringBuilder oggetto = new StringBuilder();
		oggetto.append(pratica.getAzCodiceFiscale());
		oggetto.append(" - ");
		oggetto.append(DateUtil.getAnnoCorrente());
		oggetto.append(".");
		oggetto.append(DateUtil.getMeseCorrente());
		oggetto.append(" - ");
		oggetto.append(allegato.getTipoallegatoActaOggetto().replaceFirst(ActaConstants.TOKEN_OGGETTO_NUMERO_ALBO, pratica.getPrNumeroAlbo()));
		
		result.setOggetto(oggetto.toString());
		result.setOrigineInterna(false);
		result.setAnalogico(false);
		result.setDaConservare(false);
		result.setProntoPerConservazione(false);
		result.setDaConservarePrimaDel(null);
		result.setDatiPersonali(false);
		result.setDatiSensibili(false);
		result.setDatiRiservati(false);
		result.setRappresentazioneDigitale(true);
		result.setRegistrato(true);
		result.setModificabile(false);
		result.setDefinitivo(true);
		result.setDataCreazione(new Date());
		result.setAutoreGiuridico(new String[] {pratica.getAzRagioneSociale()});
		result.setAutoreFisico(new String[] {getRappresentanteLegale(pratica)});
		result.setDestinatarioGiuridico(new String[] {ActaConstants.DESTINATARIO_GIURIDICO});
		result.setSoggettoProduttore(new String[] {getRappresentanteLegale(pratica)});
		result.setDataDocCronica(new Date());
		result.setDocConAllegati(!GenericUtil.getBooleanFromString(allegato.getTipoallegatoActaFlgAllegati()));
		result.setDocAutenticato(false);
		result.setDocAutenticatoFirmaAutenticata(false);
		result.setDocAutenticatoCopiaAutentica(false);
		result.setIdFormaDocumentaria(idFormaDocumentariaType);
		result.setApplicativoAlimentante(ActaConstants.APPLICATIVO);
		result.setIdVitalRecordCode(idVitalRecordCodeType);
		result.setIdStatoDiEfficacia(idStatoDiEfficaciaType);
		if(Constants.TIPO_FIRMA_DIGITALE.equalsIgnoreCase(allegato.getTipoallegatoFlgFirma())){
			result.setTipoDocFisico(EnumTipoDocumentoType.FIRMATO);
		}
		else {
			result.setTipoDocFisico(EnumTipoDocumentoType.SEMPLICE);
		}
		result.setComposizione(EnumDocPrimarioType.DOCUMENTO_SINGOLO);
		result.setMultiplo(false);
		return result;
	}

	
	private static PropertiesType createClassificazioneProperties() {
		ClassificazionePropertiesType result = new ClassificazionePropertiesType();
		result.setCartaceo(false);
		result.setCopiaCartacea(false);
		return result;
	}
	
	
	private static String getRappresentanteLegale(TaifTPraticaDettaglioPraticaPerInvioDto pratica) {
		StringBuilder result = new StringBuilder();
		result.append(pratica.getPeNome());
		result.append(" ");
		result.append(pratica.getPeCognome());
		return result.toString();
	}

	public static ProtocollazioneDocumentoEsistente createProtocollazioneDocumentoEsistente(
			ObjectIdType objectIdAooType,
			ObjectIdType objectIdNodoType, String denominazioneNodo, 
			ObjectIdType objectIdStrutturaType,
			ObjectIdType classificazioneId,
			TaifTPraticaDettaglioPraticaPerInvioDto pratica) {
		ProtocollazioneDocumentoEsistente result = new ProtocollazioneDocumentoEsistente();
		result.setAooProtocollanteId(objectIdAooType);
		result.setClassificazioneId(classificazioneId);
		result.setSenzaCreazioneSoggettiEsterni(true);
		result.setRegistrazioneAPI(createRegistrazioneArrivo(objectIdNodoType, denominazioneNodo, objectIdStrutturaType, pratica));
		return result;
	}

	private static RegistrazioneAPI createRegistrazioneArrivo(
			ObjectIdType objectIdNodoType, String denominazioneNodo,
			ObjectIdType objectIdStrutturaType,
			TaifTPraticaDettaglioPraticaPerInvioDto pratica) {
		RegistrazioneArrivo result = new RegistrazioneArrivo();
		result.setTipoRegistrazione(EnumTipoAPI.ARRIVO);
		result.setInfoCreazione(createInfoCreazioneRegistrazione(objectIdNodoType, objectIdStrutturaType, denominazioneNodo));
		result.setMittenteEsterno(createMittentiEsterni(pratica));
		
		return result;
	}

	private static MittenteEsterno[] createMittentiEsterni(TaifTPraticaDettaglioPraticaPerInvioDto pratica) {
		return new MittenteEsterno[] {createMittenteEsterno(pratica)};
	}
	
	private static MittenteEsterno createMittenteEsterno(TaifTPraticaDettaglioPraticaPerInvioDto pratica) {
		MittenteEsterno result = new MittenteEsterno();
		result.setCorrispondente(createInfoCreazioneCorrispondenteMittente(pratica));
		return result;
	}

	private static InfoCreazioneCorrispondente createInfoCreazioneCorrispondenteMittente(TaifTPraticaDettaglioPraticaPerInvioDto pratica) {
		InfoCreazioneCorrispondente result = new InfoCreazioneCorrispondente();
		result.setCognome(pratica.getPeCognome());
		result.setNome(pratica.getPeNome());
		return result;
	}

	

	private static InfoCreazioneRegistrazione createInfoCreazioneRegistrazione(ObjectIdType objectIdNodoType, ObjectIdType objectIdStrutturaType, String denominazioneNodo) {
		InfoCreazioneRegistrazione result = new InfoCreazioneRegistrazione();
		result.setForzareSePresenzaInviti(true);
		result.setForzareSePresenzaDaInoltrare(true);
		result.setForzareSeRegistrazioneSimile(true);
		result.setOggetto("[DOC] Test protocollo");
		result.setProtocollante(createIdentificazioneProtocollante(objectIdNodoType, objectIdStrutturaType));
		result.setDestinatarioInterno(createDestinatariInterni(objectIdNodoType, denominazioneNodo));
		return result;
	}

	private static DestinatarioInterno[] createDestinatariInterni(ObjectIdType objectIdNodoType, String denominazioneNodo) {
		return new DestinatarioInterno[] {createDestinatarioInterno(objectIdNodoType, denominazioneNodo)};
	}

	private static DestinatarioInterno createDestinatarioInterno(ObjectIdType objectIdNodoType, String denominazioneNodo) {
		DestinatarioInterno result = new DestinatarioInterno();
		result.setIdRuoloCorrispondente(1); // per competenza
		result.setCorrispondente(createInfoCreazioneCorrispondenteDestinatario(objectIdNodoType, denominazioneNodo));
		return result;
	}

	private static InfoCreazioneCorrispondente createInfoCreazioneCorrispondenteDestinatario(
			ObjectIdType objectIdNodoType, String denominazioneNodo) {
		InfoCreazioneCorrispondente result = new InfoCreazioneCorrispondente();
		result.setInfoSoggettoAssociato(createInfoSoggettoAssociato(objectIdNodoType));
		result.setDenominazione(denominazioneNodo);
		return result;
	}

	private static RiferimentoSoggettoEsistente createInfoSoggettoAssociato(ObjectIdType objectIdNodoType) {
		RiferimentoSoggettoEsistente result = new RiferimentoSoggettoEsistente();
        result.setTipologia(EnumTipologiaSoggettoAssociato.NODO);
        result.setSoggettoId(objectIdNodoType);
        return result;
	}

	private static IdentificazioneProtocollante createIdentificazioneProtocollante(ObjectIdType objectIdNodoType, ObjectIdType objectIdStrutturaType) {
		IdentificazioneProtocollante result = new IdentificazioneProtocollante();
		result.setNodoId(objectIdNodoType);
		result.setStrutturaId(objectIdStrutturaType);
		return result;
	}

	public static IdFascicoloStandardType createIdFascicoloStandardType(String value) {
		IdFascicoloStandardType result = new IdFascicoloStandardType();
		result.setValue(convertToLong(value));
		return result;
	}
	
}

