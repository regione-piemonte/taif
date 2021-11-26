/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoByIdPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDettaglioPraticaPerInvioDto;
import it.csi.taif.taifweb.business.helper.AaepServiceHelper;
import it.csi.taif.taifweb.business.helper.ActaServiceHelper;
import it.csi.taif.taifweb.business.helper.IndexServiceHelper;
import it.csi.taif.taifweb.business.helper.LimitiAmministrativiServiceHelper;
import it.csi.taif.taifweb.business.helper.LimmAmmEnteServiceHelper;
import it.csi.taif.taifweb.business.helper.PrimpaforservHelper;
import it.csi.taif.taifweb.business.helper.dto.MetadatiIndex;
import it.csi.taif.taifweb.business.helper.dto.factory.ActaFactory;
import it.csi.taif.taifweb.business.helper.dto.factory.AddressFactory;
import it.csi.taif.taifweb.business.helper.dto.factory.MetadatiIndexFactory;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.business.manager.message.MsgMgr;
import it.csi.taif.taifweb.dto.allegato.Allegato;
import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.common.DettaglioEmail;
import it.csi.taif.taifweb.dto.domanda.IstanzaTaglioPresentata;
import it.csi.taif.taifweb.dto.domanda.AziendaAAEP;
import it.csi.taif.taifweb.dto.domanda.ImportAziendaAAEP;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.exception.ServiceException;
import it.csi.taif.taifweb.util.ActaConstants;
import it.csi.taif.taifweb.util.ActaUtils;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.service.integration.aaep.ListaAttEconProd;
import it.csi.taif.taifweb.util.service.integration.primpaforserv.Istanza;
import it.csi.taif.taifweb.util.service.integration.svista.Comune;
import it.csi.taif.taifweb.util.service.integration.svista.Provincia;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdFascicoloStandardType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdFormaDocumentariaType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdStatoDiEfficaciaType;
import it.doqui.acta.actasrv.dto.acaris.type.backoffice.ClientApplicationInfo;
import it.doqui.acta.actasrv.dto.acaris.type.common.CodiceFiscaleType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdAOOType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdNodoType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdStrutturaType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdVitalRecordCodeType;
import it.doqui.acta.actasrv.dto.acaris.type.common.ObjectIdType;
import it.doqui.acta.actasrv.dto.acaris.type.common.PrincipalIdType;
import it.doqui.acta.actasrv.dto.acaris.type.document.IdentificatoreDocumento;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.IdentificazioneRegistrazione;

public class ServiceMgr {

	private static final Logger LOGGER = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager");

	/**
	 * Manager dei messaggi
	 */
	private MsgMgr msgMgr;

	/**
	 * Helper <code>facade</code> al servizio <code>WFS</code> <code>LIMAMM</code>.
	 */
	private LimitiAmministrativiServiceHelper limitiAmministrativiServiceHelper;

	private LimmAmmEnteServiceHelper limmAmmEnteServiceHelper;
	
	private AaepServiceHelper aaepServiceHelper;
	
	private IndexServiceHelper indexServiceHelper;
	
	private DozerBeanMapper dozerBeanMapper;
	
	private ActaServiceHelper actaServiceHelper;
	
	private PrimpaforservHelper primpaforservHelper;
	
	/**
	 * Database Manager.
	 */
	private DbMgr dbMgr;

	/**
	 * @return the msgMgr
	 */
	public MsgMgr getMsgMgr() {
		return msgMgr;
	}

	/**
	 * @param msgMgr
	 *            the msgMgr to set
	 */
	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}
	
	/**
	 * @return the limitiAmministrativiServiceHelper
	 */
	public LimitiAmministrativiServiceHelper getLimitiAmministrativiServiceHelper() {
		return limitiAmministrativiServiceHelper;
	}

	/**
	 * @param limitiAmministrativiServiceHelper
	 *            the limitiAmministrativiServiceHelper to set
	 */
	public void setLimitiAmministrativiServiceHelper(
			LimitiAmministrativiServiceHelper limitiAmministrativiServiceHelper) {
		this.limitiAmministrativiServiceHelper = limitiAmministrativiServiceHelper;
	}

	/**
	 * @return the limmAmmEnteServiceHelper
	 */
	public LimmAmmEnteServiceHelper getLimmAmmEnteServiceHelper() {
		LOGGER.debug("_________________-- limmAmmEnteServiceHelper ------ "+limmAmmEnteServiceHelper);
		return limmAmmEnteServiceHelper;
	}

	/**
	 * @param limmAmmEnteServiceHelper
	 *            the limmAmmEnteServiceHelper to set
	 */
	public void setLimmAmmEnteServiceHelper(LimmAmmEnteServiceHelper limmAmmEnteServiceHelper) {
		this.limmAmmEnteServiceHelper = limmAmmEnteServiceHelper;
	}

	/**
	 * @return the dbMgr
	 */
	public DbMgr getDbMgr() {
		return dbMgr;
	}

	/**
	 * @param dbMgr
	 *            the dbMgr to set
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	
	
	
	
	/**
	 * @return the aaepServiceHelper
	 */
	public AaepServiceHelper getAaepServiceHelper() {
		return aaepServiceHelper;
	}

	/**
	 * @param aaepServiceHelper the aaepServiceHelper to set
	 */
	public void setAaepServiceHelper(AaepServiceHelper aaepServiceHelper) {
		this.aaepServiceHelper = aaepServiceHelper;
	}

	/**
	 * @return the dozerBeanMapper
	 */
	public DozerBeanMapper getDozerBeanMapper() {
		return dozerBeanMapper;
	}

	/**
	 * @param dozerBeanMapper the dozerBeanMapper to set
	 */
	
	public void setDozerBeanMapper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
		this.dozerBeanMapper.setMappingFiles(Arrays.asList("dozer-mapping.xml", "dozer-two-mapping.xml", "dozer-three-mapping.xml", "dozer-four-mapping.xml"));
	}
	
	
	
	
	/**
	 * @return the indexServiceHelper
	 */
	public IndexServiceHelper getIndexServiceHelper() {
		return indexServiceHelper;
	}

	/**
	 * @param indexServiceHelper the indexServiceHelper to set
	 */
	public void setIndexServiceHelper(IndexServiceHelper indexServiceHelper) {
		this.indexServiceHelper = indexServiceHelper;
	}
	
	
	public ActaServiceHelper getActaServiceHelper() {
		return actaServiceHelper;
	}

	public void setActaServiceHelper(ActaServiceHelper actaServiceHelper) {
		this.actaServiceHelper = actaServiceHelper;
	}
	
	public PrimpaforservHelper getPrimpaforservHelper() {
		return primpaforservHelper;
	}

	public void setPrimpaforservHelper(PrimpaforservHelper primpaforservHelper) {
		this.primpaforservHelper = primpaforservHelper;
	}

	// INIZIO RICHIAMO SERVIZI
	
	
	public ArrayList<CodeDescription> limitiAmministrativiGetComuniPerProvincia(String idProvincia) throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetComuniPerProvincia] BEGIN");
		try {
			
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
			
			final Comune[] comuni = getLimmAmmEnteServiceHelper().cercaComuniPerIdProvincia(ConvertUtil.convertToLong(idProvincia));
			for (Comune comune : comuni) {
				result.add(dozerBeanMapper.map(comune, CodeDescription.class));
			}
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetComuniPerProvincia] END");
        }
	}
	
	public ArrayList<CodeDescription> limitiAmministrativiGetTuttiIComuni() throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetTuttiIComuni] BEGIN");
		try {
			
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
			
			final Comune[] comuni = getLimmAmmEnteServiceHelper().cercaTuttiIComuni();
			for (Comune comune : comuni) {
				result.add(dozerBeanMapper.map(comune, CodeDescription.class));
			}
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetTuttiIComuni] END");
        }
	}

	public ArrayList<CodeDescription> limitiAmministrativiGetProvince() throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvince] BEGIN");
		try {
			
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
			LimmAmmEnteServiceHelper service = getLimmAmmEnteServiceHelper();
			
			final Provincia[] province = service.cercaProvince();
			
			for (Provincia provincia : province) {
				result.add(dozerBeanMapper.map(provincia, CodeDescription.class));
			}
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvince] END");
        }
	}
	
	public ArrayList<CodeDescription> limitiAmministrativiGetProvinceIstat() throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvince] BEGIN");
		try {
			
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
			LimmAmmEnteServiceHelper service = getLimmAmmEnteServiceHelper();
			
			final Provincia[] province = service.cercaProvince();
			
			for (Provincia provincia : province) {
				CodeDescription cd = new CodeDescription();
				cd.setCode(provincia.getCodIstat());
				cd.setDescription(provincia.getNome());
				result.add(cd);
			}
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvince] END");
        }
	}
	
	public ArrayList<CodeDescription> aaepGetAziendePerCodiceFiscale(String codiceFiscaleSoggetto) throws ServiceException{
		LOGGER.debug("[ServiceMgr::aaepGetAziendePerCodiceFiscale] BEGIN");
		try {
			
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
			AaepServiceHelper service = getAaepServiceHelper();
			
			ListaAttEconProd[] list = service.cercaAziendeAAEPByCodiceFiscale(codiceFiscaleSoggetto);
			if(list!=null) {
				for (ListaAttEconProd dto : list) {
					result.add(dozerBeanMapper.map(dto, CodeDescription.class));
				}
			}
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::aaepGetAziendePerCodiceFiscale] END");
        }
	
	}
	
	public ArrayList<AziendaAAEP> aaepGetAziendePerCodiceFiscaleSoggetto(String codiceFiscaleSoggetto) throws ServiceException{
		LOGGER.debug("[ServiceMgr::aaepGetAziendePerCodiceFiscaleSoggetto] BEGIN");
		try {
			
			ArrayList<AziendaAAEP> result = new ArrayList<AziendaAAEP>();
			AaepServiceHelper service = getAaepServiceHelper();
			
			ListaAttEconProd[] list = service.cercaAziendeAAEPByCodiceFiscale(codiceFiscaleSoggetto);
			if(list!=null) {
				for (ListaAttEconProd dto : list) {
				    if(dto.getAziendaCessata().equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.AZIENDA_NON_CESSATA)) {
					result.add(dozerBeanMapper.map(dto, AziendaAAEP.class));
				    }
				}
			}
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_AAEP);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::aaepGetAziendePerCodiceFiscaleSoggetto] END");
        }
	
	}
	
	public ImportAziendaAAEP aaepImportAzienda(String codiceFiscaleAzienda) throws ManagerException{
		LOGGER.debug("[ServiziMgr::aaepImportAzienda] BEGIN");
		return this.getAaepServiceHelper().dettaglioAziendaAAEPByCodiceFiscale(codiceFiscaleAzienda);
	}
	
	public String limitiAmministrativiGetDsComuneByIstat(String codIstatComune) throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetDsComuneByIstat] BEGIN");
		try {
			
			String result = "";
			LimmAmmEnteServiceHelper service = getLimmAmmEnteServiceHelper();
			
			Comune c = service.cercaComunePerCodiceIstat(codIstatComune);
			if(c!=null) {
				result = c.getNome();
			}
			
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetDsComuneByIstat] END");
        }
	}
	
	public Comune limitiAmministrativiGetComuneByIstat(String codIstatComune) throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetComuneByIstat] BEGIN");
		try {
			
			LimmAmmEnteServiceHelper service = getLimmAmmEnteServiceHelper();
			if(StringUtils.isNotEmpty(codIstatComune)&&!codIstatComune.equals("0")) {
				return service.cercaComunePerCodiceIstat(codIstatComune);
			}else {
				Comune result = new Comune();
				result.setId(0);
				result.setCodIstat("0");
				result.setNome("");
				return result;
			}
		}catch (Exception e) {
		   
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
		    LOGGER.debug("[ServiceMgr::limitiAmministrativiGetComuneByIstat] END");
		}
	}
	
	public Provincia limitiAmministrativiGetProvinciaByIstatComune(String codIstatComune) throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvinciaByIstatComune] BEGIN");
		try {
			
			LimmAmmEnteServiceHelper service = getLimmAmmEnteServiceHelper();
			Comune c = this.limitiAmministrativiGetComuneByIstat(codIstatComune);
			Provincia result = service.cercaProvinciaPerIdProvincia(c.getIdProvincia());
			
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvinciaByIstatComune] END");
        }
	}
	
	public void indexCreateRootFolder(Integer idPersona, Integer idAzienda, Integer idPratica)throws ServiceException{
		LOGGER.debug("[ServiceMgr::indexCreateRootFolder] BEGIN");
		try {
			this.getIndexServiceHelper().indexCreateRootFolder(MetadatiIndexFactory.createMetadatiForRootFolder(idPersona, idAzienda, idPratica));
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_INDEX);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::indexCreateRootFolder] END");
        }		
	}
	
	public byte[] indexDownloadFile(String idAllegato)throws ServiceException{
		LOGGER.debug("[ServiceMgr::indexDownloadFile] BEGIN");
		try {
			return this.getIndexServiceHelper().indexDownloadFile(idAllegato);
		}
		finally {
			LOGGER.debug("[ServiceMgr::indexDownloadFile] END");
	    }	
	}
	
	public void indexDeleteFile(String idAllegato)throws ServiceException{
		LOGGER.debug("[ServiceMgr::indexDeleteFile] BEGIN");
		try {
			this.getIndexServiceHelper().indexDeleteFileByIdAllegato(idAllegato);
		}
		finally {
			LOGGER.debug("[ServiceMgr::indexDeleteFile] END");
	    }	
	}
	
	public void indexDeletePratica(String idPratica)throws ServiceException{
		LOGGER.debug("[ServiceMgr::indexDeletePratica] BEGIN");
		try {
			this.getIndexServiceHelper().indexDeleteMainFolder(idPratica);
		}
		finally {
			LOGGER.debug("[ServiceMgr::indexDeleteFile] END");
	    }
	}
	
	public String indexUploadFile(int idPratica, Allegato allegato, File file) throws ServiceException{
		LOGGER.debug("[ServiceMgr::indexUploadFile] BEGIN");
		try {
			return this.indexUploadFile(idPratica, allegato, FileUtils.readFileToByteArray(file));
		}
		catch (IOException e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_INDEX);
			throw new ServiceException(e, m);
		}
	}
	
	public String indexUploadFile(int idPratica, Allegato allegato, byte[] file) throws ServiceException{
		LOGGER.debug("[ServiceMgr::indexUploadFile] BEGIN");
		String result = null;
		try {
	       LOGGER.info("Nome file(CODICE_FISCALE - Scheda Azienda ANNO.MESE.pdf): " + allegato.getNomeFile());

			MetadatiIndex metadati = MetadatiIndexFactory.createMetadati(idPratica, allegato);
			result = this.getIndexServiceHelper().indexUploadFile(allegato.getNomeFile(), file, metadati);
		} catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_INDEX);
			throw new ServiceException(e, m);
		}
		finally {
			LOGGER.debug("[ServiceMgr::indexUploadFile] END");
	    }
		return result;
	}
	
	public void invioMail(DettaglioEmail emailVO) throws ServiceException {
		LOGGER.debug("[ServiceMgr::invioMail] BEGIN");
		// Create a mail session
        final Properties props = new Properties();
        props.put("mail.smtp.host", emailVO.getHost());
        props.put("mail.smtp.port", emailVO.getPort());
        final Session session = Session.getDefaultInstance(props, null);

        // Construct the message
        final javax.mail.Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(emailVO.getMittente()));

            msg.setRecipients(javax.mail.Message.RecipientType.TO, AddressFactory.createAddresses(emailVO.getDestinatari()));
            if (CollectionUtils.isNotEmpty(emailVO.getDestinatariCC())) {
                msg.setRecipients(javax.mail.Message.RecipientType.CC, AddressFactory.createAddresses(emailVO.getDestinatariCC()));
            }

            msg.setSubject(emailVO.getOggetto());

            // il corpo del messaggio si attacca dopo
            final MimeMultipart mp  = new MimeMultipart();
            final MimeBodyPart html = new MimeBodyPart();
            html.setText(emailVO.getCorpo());

//            if (CollectionUtils.isNotEmpty(emailVO.getAllegati())) {
//                LOGGER.debug("[ServiziMgr::mailSend] si allegano istanze");
//                //devo allegare le istanze alla mail
//                final Documento[] documenti = this.mapToArrayDocumento(emailVO.getAllegati());
//                if (ArrayUtils.isNotEmpty(documenti)) {
//                    MimeBodyPart attachmentPart = null;
//                    for (int i = 0; i < documenti.length; i++) {
//                        attachmentPart = new MimeBodyPart();
//
//                        final Documento doc = documenti[i];
//
//                        final FileDataSource fileDataSource = new FileDataSource(this.createFileWithData(doc)) {
//                            @Override
//                            public String getContentType() {
//                                return "application/xml";
//                            }
//                        };
//                        attachmentPart.setDataHandler(new DataHandler(fileDataSource));
//                        attachmentPart.setFileName(doc.getFileName());
//
//                        mp.addBodyPart(attachmentPart);
//                    }
//                }
//            }

            mp.addBodyPart(html);
            // add the Multipart to the message
            msg.setContent(mp);
            // Send the message
            Transport.send(msg);
        } catch(Exception e) {
            LOGGER.error("[ServiziMgr::invioMail] Eccezione: " + e.getMessage());

            final Message message = this.msgMgr.getMessage(MsgCodeEnum.G001);
            throw new ServiceException(e, message);
        }
        LOGGER.debug("[ServiziMgr::invioMail] END");
	}
	
	public void actaTestServizio(TaifTPraticaDettaglioPraticaPerInvioDto dto)throws ServiceException{
		LOGGER.debug("[ServiziMgr::actaTestServizio] BEGIN");
		try {
			ObjectIdType repositoryId = this.actaGetRepositoryId();
			
			LOGGER.debug("****************** repositoryId = *"+repositoryId.getValue()+"*");
			
			PrincipalIdType principalId = this.actaGetPrincipalId();
			
			LOGGER.debug("****************** principalId = *"+principalId.getValue()+"*");
			
			ObjectIdType voceId = this.actaGetVoceIdType(repositoryId, principalId);
			
			LOGGER.debug("****************** voceId = *"+voceId.getValue()+"*");
			
			ObjectIdType serieFascicoloId = this.actaGetSerieFascicoloId(repositoryId, voceId, principalId);
			
			LOGGER.debug("****************** serieFascicoloId = *"+serieFascicoloId.getValue()+"*");
			
			ObjectIdType fascicoloId = this.actaGetFascicoloId(repositoryId, principalId, serieFascicoloId, dto);
			
			LOGGER.debug("****************** fascicoloId = *"+fascicoloId.getValue()+"*");
			
			ObjectIdType sottofascicoloId = this.actaGetSottofascicoloId(repositoryId, fascicoloId, principalId, dto);
			
			LOGGER.debug("****************** sottofascicoloId = *"+sottofascicoloId.getValue()+"*");
			
		} catch (ManagerException e) {
			LOGGER.debug("[ServiziMgr::actaTestServizio] ERRORE "+e.getMessage());
			e.printStackTrace();
		}
		LOGGER.debug("[ServiziMgr::actaTestServizio] END");
	}
	
	private ObjectIdType actaGetRepositoryId() throws ManagerException {
		LOGGER.debug("[ServiziMgr::actaGetRepositoryId] BEGIN");
		ObjectIdType result = null;
		String repositoryId = this.getDbMgr().getParameterActaValue(ActaConstants.REPOSITORY_ID);
		if(StringUtils.isEmpty(repositoryId)) {
			result = this.getActaServiceHelper().getRepositoryIdByName(this.getDbMgr().getParameterActaValue(ActaConstants.REPOSITORY_NAME));
			this.getDbMgr().setParameterActa(ActaConstants.REPOSITORY_ID, result.getValue());
		}
		else {
			result = ActaFactory.createObjectIdType(repositoryId);
		}
		LOGGER.debug("[ServiziMgr::actaGetRepositoryId] END");
		return result;
	}
	
	private PrincipalIdType actaGetPrincipalId() throws ManagerException{
		LOGGER.debug("[ServiziMgr::actaGetPrincipalId] BEGIN");
		CodiceFiscaleType codiceFiscaleType = ActaFactory.createCodiceFiscaleType(this.getDbMgr().getParameterActaValue(ActaConstants.CODICE_FISCALE));
		ClientApplicationInfo appKey = ActaFactory.createClientApplicationInfo(this.getDbMgr().getParameterActaValue(ActaConstants.APP_KEY));
		IdAOOType idAoo = ActaFactory.createIdAooType(this.getDbMgr().getParameterActaValue(ActaConstants.ID_AOO));
		IdStrutturaType idStrutturaType = ActaFactory.createIdStrutturaTyoe(this.getDbMgr().getParameterActaValue(ActaConstants.ID_STRUTTURA));
		IdNodoType idNodoType = ActaFactory.createIdNodoType(this.getDbMgr().getParameterActaValue(ActaConstants.ID_NODO_RESPONSABILE));
		ObjectIdType reposiIdType = this.actaGetRepositoryId();
		
		PrincipalIdType result = this.getActaServiceHelper().getPrincipalId(
				reposiIdType, 
				codiceFiscaleType, 
				idAoo, 
				idStrutturaType, 
				idNodoType, 
				appKey);
		
		
		
		LOGGER.debug("[ServiziMgr::actaGetPrincipalId] END");
		return result;
	}
	
	private ObjectIdType actaGetVoceIdType(ObjectIdType repositoryId, PrincipalIdType principalId)throws ManagerException {
		LOGGER.debug("[ServiziMgr::actaGetVoceIdType] BEGIN");
		ObjectIdType result = null;
		String idVoce = this.getDbMgr().getParameterActaValue(ActaConstants.ID_VOCE);
		if(StringUtils.isEmpty(idVoce)) {
			result = this.getActaServiceHelper().getIdVoce(repositoryId, principalId);
			this.getDbMgr().setParameterActa(ActaConstants.ID_VOCE, result.getValue());
		}
		else {
			result = ActaFactory.createObjectIdType(idVoce);
		}
		LOGGER.debug("[ServiziMgr::actaGetVoceIdType] END");
		return result;
	}
	
	private ObjectIdType actaGetSerieFascicoloId(ObjectIdType repositoryId, ObjectIdType idVoce, PrincipalIdType  principalId)throws ManagerException{
		LOGGER.debug("[ServiziMgr::actaGetSerieFascicoloId] BEGIN");
		try {
			
			
			return this.getActaServiceHelper().getSerieFascicoloId(repositoryId, idVoce, principalId);
		}
		finally {
			LOGGER.debug("[ServiziMgr::actaGetSerieFascicoloId] END");
		}
		
	}
			
	public ArrayList<IstanzaTaglioPresentata> cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno(String codiceFiscale, int tipoComunicazione, int stato, int annoCorrente) throws ServiceException{
		LOGGER.debug("[ServiceMgr::cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno] BEGIN");
		Istanza[] elencoIstanze = new Istanza[0];
		try {
			ArrayList<IstanzaTaglioPresentata> result = new ArrayList<IstanzaTaglioPresentata>();
			elencoIstanze = getPrimpaforservHelper().getPrimpaforserv().cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno(codiceFiscale, null, null, annoCorrente);
			if(elencoIstanze!=null && elencoIstanze.length!=0){
				for (Istanza istanza : elencoIstanze) {
					result.add(dozerBeanMapper.map(istanza, IstanzaTaglioPresentata.class));
				}	
			}
			for(IstanzaTaglioPresentata i : result) {
				if(ConvertUtil.checkIsNullOrEmpty(i.getCategoriaIntervento()) && i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_UTILIZZAZIONE)) {
					i.setDsCategoriaIntervento(Constants.DS_ISTANZA_TAGLI_UTILIZZAZIONE);
				} else if(ConvertUtil.checkIsNullOrEmpty(i.getCategoriaIntervento()) && i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_PIOPPETI)) {
					i.setDsCategoriaIntervento(Constants.DS_ISTANZA_TAGLI_PIOPPETI);
				} else if(ConvertUtil.checkIsNullOrEmpty(i.getCategoriaIntervento()) && i.getCategoriaIntervento().equalsIgnoreCase(Constants.ISTANZA_TAGLI_INTERCALARI)) {
					i.setDsCategoriaIntervento(Constants.DS_ISTANZA_TAGLI_INTERCALARI);
				}
			}
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_PRIMPAFORSERV);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::cercaIstanzeForestaPerCodFiscaleTipoComunicazioneStatoAnno] END");
        }
	}
	private ObjectIdType actaGetFascicoloId(ObjectIdType repositoryId,PrincipalIdType  principalId, ObjectIdType serieFascicoloId,  TaifTPraticaDettaglioPraticaPerInvioDto pratica) throws ManagerException {
		LOGGER.debug("[ServiziMgr::actaGetFascicoloId] BEGIN");
		ObjectIdType result = null;
		try {
			IdAOOType idAoo = ActaFactory.createIdAooType(this.getDbMgr().getParameterActaValue(ActaConstants.ID_AOO));
			IdStrutturaType idStrutturaType = ActaFactory.createIdStrutturaTyoe(this.getDbMgr().getParameterActaValue(ActaConstants.ID_STRUTTURA));
			IdNodoType idNodoType = ActaFactory.createIdNodoType(this.getDbMgr().getParameterActaValue(ActaConstants.ID_NODO_RESPONSABILE));
			IdFascicoloStandardType idFascicoloStandardType = ActaFactory.createIdFascicoloStandardType(this.getDbMgr().getParameterActaValue(ActaConstants.ID_FASCICOLO_STANDARD_RIFERIMENTO));
			 result = this.getActaServiceHelper().cercaFascicolo(repositoryId, principalId, serieFascicoloId, pratica);
			 
			 if(result==null) {
				 result = this.getActaServiceHelper().createFascicolo(
						 idAoo,
						 idNodoType,
						 idStrutturaType,
						 repositoryId, 
						 principalId, 
						 serieFascicoloId,
						 this.actaGetIdVitalRecordCodeType(repositoryId),
						 idFascicoloStandardType,
						 pratica);
			 }
		
		}
		finally {
			LOGGER.debug("[ServiziMgr::actaGetFascicoloId] END");
		}
		return result;
	}
	
	private ObjectIdType actaGetSottofascicoloId(ObjectIdType repositoryId, ObjectIdType fascicoloId, PrincipalIdType  principalId,  TaifTPraticaDettaglioPraticaPerInvioDto pratica)throws ManagerException{
		LOGGER.debug("[ServiziMgr::actaGetSottofascicoloId] BEGIN");
		try {
			
			
			return this.getActaServiceHelper().getSottofascicoloId(repositoryId, principalId, fascicoloId, pratica);
		}
		finally {
			LOGGER.debug("[ServiziMgr::actaGetSottofascicoloId] END");
		}
		
	}
	
	public IdentificazioneRegistrazione actaArchiviaProtocolla(TaifTPraticaDettaglioPraticaPerInvioDto pratica) throws ManagerException{
		LOGGER.debug("[ServiziMgr::actaArchiviaDocumenti] BEGIN");
		ObjectIdType repositoryId = this.actaGetRepositoryId();
		PrincipalIdType principalId = this.actaGetPrincipalId();
		ObjectIdType objectIdClassificazione = this.actaArchiviaDocumenti(repositoryId, principalId, pratica);
		IdentificazioneRegistrazione result = this.actaProtocollaDocumento(repositoryId, principalId, objectIdClassificazione, pratica);
		LOGGER.debug("[ServiziMgr::actaArchiviaDocumenti] END");
		return result;
	}
	
//	public void actaArchiviaDocumenti(TaifTPraticaDettaglioPraticaPerInvioDto pratica)throws ManagerException{
//		ObjectIdType repositoryId = this.actaGetRepositoryId();
//		PrincipalIdType principalId = this.actaGetPrincipalId();
//		this.actaArchiviaDocumenti(repositoryId, principalId, pratica);
//	}
	
	private ObjectIdType actaArchiviaDocumenti(
			ObjectIdType repositoryId,
			PrincipalIdType principalId,
			TaifTPraticaDettaglioPraticaPerInvioDto pratica)throws ManagerException {
		LOGGER.debug("[ServiziMgr::actaArchiviaDocumenti] BEGIN"); 
		
		ObjectIdType result = null;
		
		ObjectIdType voceId = this.actaGetVoceIdType(repositoryId, principalId);
		ObjectIdType serieFascicoloId = this.actaGetSerieFascicoloId(repositoryId, voceId, principalId);
		ObjectIdType fascicoloId = this.actaGetFascicoloId(repositoryId, principalId, serieFascicoloId, pratica);
		ObjectIdType sottofascicoloId = this.actaGetSottofascicoloId(repositoryId, fascicoloId, principalId, pratica); 
		
		IdFormaDocumentariaType idFormaDocumentariaType = this.actaGetIdFormaDocumentariaType(repositoryId, principalId);
		IdVitalRecordCodeType idVitalRecordCodeType = this.actaGetIdVitalRecordCodeType(repositoryId);				 
				
		
		List<TaifTAllegatoByIdPraticaDto> allegati = this.getDbMgr().getElencoAllegatiByPratica(pratica.getPrIdPratica());
		TaifTAllegatoByIdPraticaDto padre = ActaUtils.getDocumentoPadre(allegati);
		if(StringUtils.isEmpty(padre.getAllegatoIdClassificazioneDoqui())) {
		
			IdentificatoreDocumento idDocPadre = this.actaArchiviaDocumentoPadre(
				repositoryId, 
				principalId, 
				idFormaDocumentariaType, 
				idVitalRecordCodeType, 
				sottofascicoloId, 
				pratica,
				padre
				);
		
			result = idDocPadre.getObjectIdClassificazione();
		}
		else {
			result = ActaFactory.createObjectIdType(padre.getAllegatoIdClassificazioneDoqui());
		}
		
		this.actaArchiviaAllegati(
				repositoryId, 
				principalId, 
				idFormaDocumentariaType, 
				idVitalRecordCodeType,
				result,
				pratica,
				ActaUtils.getAllegati(allegati));
		
		LOGGER.debug("[ServiziMgr::actaArchiviaDocumenti] END"); 
		
		return result;
	}
	
	private IdentificazioneRegistrazione actaProtocollaDocumento(
			ObjectIdType repositoryId,
			PrincipalIdType principalId,
			ObjectIdType objectIdClassificazione, 
			TaifTPraticaDettaglioPraticaPerInvioDto pratica) throws ManagerException{
		LOGGER.debug("[ServiziMgr::actaProtocollaDocumento] BEGIN");
		String idAoo = this.getDbMgr().getParameterActaValue(ActaConstants.ID_AOO);
		String idStruttura = this.getDbMgr().getParameterActaValue(ActaConstants.ID_STRUTTURA);
		String idNodo = this.getDbMgr().getParameterActaValue(ActaConstants.ID_NODO_RESPONSABILE);
		
		IdentificazioneRegistrazione result = this.actaServiceHelper.protocollaDocumentoInArrivo(
				objectIdClassificazione, 
				repositoryId, 
				principalId, 
				ConvertUtil.convertToLong(idAoo), 
				ConvertUtil.convertToLong(idNodo), 
				ConvertUtil.convertToLong(idStruttura), 
				pratica);
		LOGGER.debug("[ServiziMgr::actaProtocollaDocumento] END");
		return result;
	}

	private IdVitalRecordCodeType actaGetIdVitalRecordCodeType(ObjectIdType repositoryId) throws ManagerException {
		LOGGER.debug("[ServiziMgr::actaGetIdVitalRecordCodeType] BEGIN");
		String vitalRecordCode = this.getDbMgr().getParameterActaValue(ActaConstants.VITAL_RECORD_CODE);
		return this.getActaServiceHelper().getIdVitalRecordCodeType(repositoryId, vitalRecordCode);
	}

	private IdFormaDocumentariaType actaGetIdFormaDocumentariaType(ObjectIdType repositoryId, PrincipalIdType  principalId) throws ManagerException {
		LOGGER.debug("[ServiziMgr::actaGetIdFormaDocumentariaType] BEGIN");
		String formaDocumentariaCode = this.getDbMgr().getParameterActaValue(ActaConstants.FORMA_DOCUMENTARIA);
		return this.getActaServiceHelper().getIdFormaDocumentariaType(repositoryId, principalId, formaDocumentariaCode);
	}
	
	private IdentificatoreDocumento actaArchiviaDocumentoPadre(ObjectIdType repositoryId, 
			PrincipalIdType principalId,
			IdFormaDocumentariaType idFormaDocumentariaType,
			IdVitalRecordCodeType idVitalRecordCodeType, 
			ObjectIdType parentFolder, 
			TaifTPraticaDettaglioPraticaPerInvioDto pratica, 
			TaifTAllegatoByIdPraticaDto allegato) throws ManagerException {
		LOGGER.debug("[ServiziMgr::archiviaDocumentoPadre] BEGIN");
		byte[] file = this.indexDownloadFile(""+allegato.getIdAllegato());
		IdStatoDiEfficaciaType idStatoDiEfficaciaType = this.getActaServiceHelper().getIdStatoEfficaciaType(
				repositoryId,
				principalId, 
				allegato.getTipoallegatoActaStatoDiEfficacia());
		
		IdentificatoreDocumento result = this.getActaServiceHelper().archiviaDocumento(
				repositoryId, 
				principalId, 
				null, 
				idFormaDocumentariaType, 
				idVitalRecordCodeType, 
				idStatoDiEfficaciaType, 
				parentFolder, 
				file, 
				pratica, 
				allegato
				);
		this.dbMgr.aggiornaIdDocumentoActaAllegato(allegato, result.getObjectIdClassificazione(), result.getObjectIdDocumento());
		LOGGER.debug("[ServiziMgr::archiviaDocumentoPadre] END");
		return result;
		
	}
	
	private void actaArchiviaAllegati(
			ObjectIdType repositoryId, 
			PrincipalIdType principalId,
			IdFormaDocumentariaType idFormaDocumentariaType, 
			IdVitalRecordCodeType idVitalRecordCodeType,
			ObjectIdType documentoPadreId, 
			TaifTPraticaDettaglioPraticaPerInvioDto pratica,
			List<TaifTAllegatoByIdPraticaDto> allegati) throws ManagerException{
		
			for (TaifTAllegatoByIdPraticaDto allegato : allegati) {
			
				// Recupero da index
				byte[] file = this.indexDownloadFile(""+allegato.getIdAllegato());
				IdStatoDiEfficaciaType idStatoDiEfficaciaType = this.getActaServiceHelper().getIdStatoEfficaciaType(
						repositoryId,
						principalId, 
						allegato.getTipoallegatoActaStatoDiEfficacia());
				// Archivio su acta
				IdentificatoreDocumento id = this.getActaServiceHelper().archiviaDocumento(
						repositoryId, 
						principalId, 
						documentoPadreId, 
						idFormaDocumentariaType, 
						idVitalRecordCodeType, 
						idStatoDiEfficaciaType, 
						null, 
						file, 
						pratica, 
						allegato);
				
				this.dbMgr.aggiornaIdDocumentoActaAllegato(allegato, null, id.getObjectIdDocumento());
				
			}
		
	}
	
	public ArrayList<CodeDescription> limitiAmministrativiGetComuniPerIstatProvincia(String codiceIstatProvincia) throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetComuniPerIstatProvincia] BEGIN");
		try {
			
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
			
			final Comune[] comuni = getLimmAmmEnteServiceHelper().cercaComuniPerCodiceIstatProvincia(codiceIstatProvincia);
			for (Comune comune : comuni) {
				result.add(dozerBeanMapper.map(comune, CodeDescription.class));
			}
			return result;
		}catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_LIMAMM);
			throw new ServiceException(e, m);
		}finally {
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetComuniPerIstatProvincia] END");
        }
	}
	
}
