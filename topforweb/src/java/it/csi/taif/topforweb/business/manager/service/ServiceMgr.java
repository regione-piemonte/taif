/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dozer.DozerBeanMapper;

import it.csi.taif.topforweb.business.helper.dto.factory.AddressFactory;
import it.csi.taif.topforweb.dto.common.DettaglioEmail;
import it.csi.taif.topforweb.business.helper.AaepServiceHelper;
import it.csi.taif.topforweb.business.helper.IndexServiceHelper;
import it.csi.taif.topforweb.business.helper.LimitiAmministrativiServiceHelper;
import it.csi.taif.topforweb.business.helper.LimmAmmEnteServiceHelper;
import it.csi.taif.topforweb.business.helper.dto.MetadatiIndex;
import it.csi.taif.topforweb.business.helper.dto.factory.MetadatiIndexFactory;
import it.csi.taif.topforweb.business.manager.db.DbMgr;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.topforweb.business.manager.message.MsgMgr;
import it.csi.taif.topforweb.dto.allegato.Allegato;
import it.csi.taif.topforweb.dto.common.CodeDescription;
import it.csi.taif.topforweb.exception.ServiceException;
import it.csi.taif.topforweb.util.CodeDescriptionComparator;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import it.csi.taif.topforweb.util.service.integration.aaep.ListaAttEconProd;
import it.csi.taif.topforweb.util.service.integration.svista.Comune;
import it.csi.taif.topforweb.util.service.integration.svista.Provincia;

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
            this.dozerBeanMapper.setMappingFiles(Arrays.asList("dozer-mapping.xml"));
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

	// INIZIO RICHIAMO SERVIZI
	
	public ArrayList<CodeDescription> limitiAmministrativiGetComuniPerProvincia(String[] elencoProvince) throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetComuniPerProvincia] BEGIN");
		try {
			
			ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
			
			for(String codice : elencoProvince) {
				final Comune[] comuni = getLimmAmmEnteServiceHelper().cercaComuniPerIdProvincia(ConvertUtil.convertToLong(codice));
				for (Comune comune : comuni) {
					//result.add(dozerBeanMapper.map(comune, CodeDescription.class));
					CodeDescription t = new CodeDescription();
					t.setCode(comune.getCodIstat());
					t.setDescription(comune.getNome());
					result.add(t);
					}
			}
			Collections.sort(result, new CodeDescriptionComparator());
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
				CodeDescription t = new CodeDescription();
				t.setCode(comune.getCodIstat());
				t.setDescription(comune.getNome());
				result.add(t);
				//result.add(dozerBeanMapper.map(comune, CodeDescription.class));
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
	
	public ArrayList<CodeDescription> aaepGetAziendePerCodiceFiscale(String codiceFiscaleSoggetto) throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvince] BEGIN");
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
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvince] END");
        }
	
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
			
			Comune result = service.cercaComunePerCodiceIstat(codIstatComune);
			
			return result;
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
	
	public void indexCreateRootFolder(String tipoProcedura, Integer idPersona, Integer idAzienda)throws ServiceException{
		LOGGER.debug("[ServiceMgr::indexCreateRootFolder] BEGIN");
		try {
			this.getIndexServiceHelper().indexCreateRootFolder(MetadatiIndexFactory.createMetadatiForRootFolder(tipoProcedura, idPersona, idAzienda));
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
	
	public String indexUploadFile(int idCorso, int idPersona, Allegato allegato, File file) throws ServiceException{
		LOGGER.debug("[ServiceMgr::indexUploadFile] BEGIN");
		String result = null;
		try {
			MetadatiIndex metadati = MetadatiIndexFactory.createMetadati(idCorso, idPersona, allegato);
			result = this.getIndexServiceHelper().indexUploadFile(allegato.getNomeFile(), FileUtils.readFileToByteArray(file), metadati);
		} catch (ServiceException e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G0041);
			m.replacePlaceholder(Constants.ERR_INDEX);
			throw new ServiceException(e, m);
		} 
		catch (Exception e) {
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G002);
			m.replacePlaceholder(Constants.ERR_INDEX);
			throw new ServiceException(e, m);
		}
		finally {
			LOGGER.debug("[ServiceMgr::indexUploadFile] END");
	    }
		return result;
	}
	
	public void invioMail(it.csi.taif.topforweb.dto.common.DettaglioEmail emailVO) throws ServiceException {
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
        	e.printStackTrace();
            LOGGER.error("[ServiziMgr::invioMail] Eccezione: " + e.getMessage());

            final Message message = this.msgMgr.getMessage(MsgCodeEnum.G001);
            throw new ServiceException(e, message);
        }
        LOGGER.debug("[ServiziMgr::invioMail] END");
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
	
	public ArrayList<CodeDescription> limitiAmministrativiGetProvinceIstat() throws ServiceException{
		LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvinceIstat] BEGIN");
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
            LOGGER.debug("[ServiceMgr::limitiAmministrativiGetProvinceIstat] END");
        }
	}
	
}
