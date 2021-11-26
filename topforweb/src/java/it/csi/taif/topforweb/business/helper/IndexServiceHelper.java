/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.commons.lang3.StringUtils;

import it.csi.taif.topforweb.business.helper.AbstractServiceHelper;
import it.csi.taif.topforweb.business.helper.dto.MetadatiIndex;
import it.csi.taif.topforweb.business.helper.dto.factory.IndexDtoFactory;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.topforweb.exception.ServiceException;
import it.csi.taif.topforweb.util.ArrayUtils;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import it.csi.taif.topforweb.util.DateUtil;
import it.csi.taif.topforweb.util.GenericUtil;
import it.doqui.index.ecmengine.client.webservices.dto.Node;
import it.doqui.index.ecmengine.client.webservices.dto.OperationContext;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Content;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Mimetype;
import it.doqui.index.ecmengine.client.webservices.dto.engine.management.Property;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.ResultContent;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchParams;
import it.doqui.index.ecmengine.client.webservices.dto.engine.search.SearchResponse;
import it.doqui.index.ecmengine.client.webservices.engine.EcmEngineWebServiceDelegate;
import it.doqui.index.ecmengine.client.webservices.engine.EcmEngineWebServiceDelegateServiceLocator;
import it.doqui.index.ecmengine.client.webservices.exception.InvalidParameterException;
import it.doqui.index.ecmengine.client.webservices.exception.publishing.NoDataExtractedException;

public class IndexServiceHelper extends AbstractServiceHelper {

	EcmEngineWebServiceDelegate ecmEngineWebServiceDelegate;

	/**
	 * @return the ecmEngineWebServiceDelegate
	 */
	public EcmEngineWebServiceDelegate getEcmEngineWebServiceDelegate() {
		return ecmEngineWebServiceDelegate;
	}

	/**
	 * @param ecmEngineWebServiceDelegate
	 *            the ecmEngineWebServiceDelegate to set
	 */
	public void setEcmEngineWebServiceDelegate(EcmEngineWebServiceDelegate ecmEngineWebServiceDelegate) {
		this.ecmEngineWebServiceDelegate = ecmEngineWebServiceDelegate;
	}

	public IndexServiceHelper(String url) {
		EcmEngineWebServiceDelegateServiceLocator ecmengineLocator = new EcmEngineWebServiceDelegateServiceLocator();

		try {
			ecmEngineWebServiceDelegate = ecmengineLocator.getEcmEngineManagement(new URL(url));
		} catch (MalformedURLException e)  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (javax.xml.rpc.ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private OperationContext indexGetOperationContext(String user) {
		LOGGER.debug("[IndexServiceHelper::indexGetOperationContext] BEGIN");
		final OperationContext ctx = new OperationContext();
		ctx.setUsername(user);
		ctx.setPassword(Constants.INDEX_PSW);
		ctx.setNomeFisico(Constants.INDEX_UTENTE);
		ctx.setFruitore(Constants.INDEX_FRUITORE);
		ctx.setRepository(Constants.INDEX_REPOSITORY);
		LOGGER.debug("[IndexServiceHelper::indexGetOperationContext] END");
		return ctx;
	}

	private Content indexGetContent(String fileName) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexGetContent] BEGIN");
		final Content c = new Content();
		c.setContentPropertyPrefixedName(Constants.INDEX_PREFIX_NAME);
		c.setPrefixedName(Constants.INDEX_PREFIX + fileName);
		c.setParentAssocTypePrefixedName(Constants.INDEX_PREFIX_CONTAINS);
		c.setTypePrefixedName(Constants.INDEX_ALLEGATO_NAME);
		c.setMimeType(this.indexGetMimeType(fileName));
		c.setEncoding(Constants.INDEX_ENCODING);
		LOGGER.debug("[IndexServiceHelper::indexGetContent] END");
		return c;
	}

	private Content indexGetContentFolder(String folderName) {
		LOGGER.debug("[IndexServiceHelper::indexGetContentFolder] BEGIN");
		final Content myFolder = new Content();
		myFolder.setPrefixedName(Constants.INDEX_DEFAULT_PREFIX + folderName);
		myFolder.setParentAssocTypePrefixedName(Constants.INDEX_PREFIX_CONTAINS);
		myFolder.setModelPrefixedName(Constants.INDEX_PREFIX_MODEL);
		myFolder.setTypePrefixedName(Constants.INDEX_PREFIX_FOLDER);
		final Property p = new Property();
		p.setPrefixedName(Constants.INDEX_PREFIX_NAME_SHORT);
		p.setDataType("text");
		p.setValues(new String[] { folderName });
		myFolder.setProperties(new Property[] { p });
		LOGGER.debug("[IndexServiceHelper::indexGetContentFolder] END");
		return myFolder;
	}

	private String indexGetMimeType(String fileName) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexGetMimeType] BEGIN");
		final String estensione = StringUtils.substringAfterLast(fileName, ".");
		final Mimetype mt = new Mimetype();
		mt.setFileExtension(estensione);
		Mimetype[] mime = null;
		try {
			mime = this.getEcmEngineWebServiceDelegate().getMimetype(mt);
		} catch (InvalidParameterException e) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		} catch (RemoteException e) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		} catch (Exception e) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		}

		if (mime != null && mime.length > 0) {
			return mime[0].getMimetype();
		} else {
			return Constants.MIMETYPE_DEFAULT;
		}
	}

	private Content indexCreateContent(MetadatiIndex metadati, String fileName, byte[] file) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexGetContent] BEGIN");
		final Content c = this.indexGetContent(fileName);
		c.setModelPrefixedName(Constants.INDEX_TAIF_PREFIX_MODEL);
		c.setProperties(this.indexSetMetadati(metadati));
		c.setContent(file);
		LOGGER.debug("[IndexServiceHelper::indexGetContent] END");
		return c;
	}

	private Property[] indexSetMetadati(MetadatiIndex metadati) {
		LOGGER.debug("[IndexServiceHelper::indexSetMetadati] BEGIN");

		final Property[] result = new Property[6];

		result[0] = new Property();
		result[0].setDataType(Constants.INDEX_TYPE_TEXT);
		result[0].setPrefixedName(MetadatiIndex.META_ID_ALLEGATO);
		result[0].setValues(new String[] { metadati.getIdAllegato() });

		result[1] = new Property();
		result[1].setDataType(Constants.INDEX_TYPE_TEXT);
		result[1].setPrefixedName(MetadatiIndex.META_ID_TIPOLOGIA);
		result[1].setValues(new String[] { metadati.getIdTipologia() });

		result[2] = new Property();
		result[2].setDataType(Constants.INDEX_TYPE_TEXT);
		result[2].setPrefixedName(MetadatiIndex.META_ID_AZIENDA);
		result[2].setValues(new String[] { metadati.getIdAzienda() });

		result[3] = new Property();
		result[3].setDataType(Constants.INDEX_TYPE_TEXT);
		result[3].setPrefixedName(MetadatiIndex.META_ID_PRATICA);
		result[3].setValues(new String[] { metadati.getIdPratica() });

		result[4] = new Property();
		result[4].setDataType(Constants.INDEX_TYPE_TEXT);
		result[4].setPrefixedName(MetadatiIndex.META_ID_PERSONA);
		result[4].setValues(new String[] { metadati.getIdPersona() });

		result[5] = new Property();
		result[5].setDataType(Constants.INDEX_TYPE_TEXT);
		result[5].setPrefixedName(MetadatiIndex.META_ID_CORSO);
		result[5].setValues(new String[] { metadati.getIdCorso() });

		LOGGER.debug("[IndexServiceHelper::indexSetMetadati] END");
		return result;
	}

	private String indexGetRootFolder() throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexGetRootFolder] BEGIN");
		try {
			final SearchParams params = new SearchParams();

			params.setLimit(1);

			final StringBuilder query = new StringBuilder();
			query.append(Constants.INDEX_ROOT);

			params.setXPathQuery(query.toString());
			
			GenericUtil.stampaVO(params, true);


			return this.ecmEngineWebServiceDelegate.nodeExists(params,
					indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN));
		} catch (Exception e) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		}
	}

	private String indexSearchFolder(SearchParams params, String folderName, String uidParent) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexSearchFolder] BEGIN");

		LOGGER.debug("[IndexServiceHelper::indexSearchFolder] folderName " + folderName);
		LOGGER.debug("[IndexServiceHelper::indexSearchFolder] uidParent " + uidParent);

		GenericUtil.stampaVO(params, true);

		try {
			LOGGER.debug("[IndexServiceHelper::this.getEcmEngineWebServiceDelegate()] *" + this.getEcmEngineWebServiceDelegate()+"*");
			return this.getEcmEngineWebServiceDelegate().nodeExists(params,
					indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN));
		} catch (NoDataExtractedException e) {
			LOGGER.error("[IndexServiceHelper::indexSearchFolder] ERROR: " + e.getMessage(), e);

			if (uidParent == null) {
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
				message.replacePlaceholder(Constants.ERR_INDEX);

				throw new ServiceException(e, message);
			} else {
				return this.indexCreateFolder(folderName, uidParent);
			}
		} catch (RuntimeException e) {
			LOGGER.error("[IndexServiceHelper::indexSearchFolder] ERROR RUNTIME: " + e.getMessage(), e);

			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		} catch (Exception e) {
			LOGGER.error("[IndexServiceHelper::indexSearchFolder] ERROR GENERICO: " + e.getMessage(), e);

			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		} finally {
			LOGGER.debug("[IndexServiceHelper::indexSearchFolder] END");
		}
	}

	private String indexCreateFolder(String folderName, String uidParent) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexCreateFolder] BEGIN");

		String uidFolder = null;
		try {
			uidFolder = this.getEcmEngineWebServiceDelegate()
					.createContent(new Node(uidParent), this.indexGetContentFolder(folderName),
							this.indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN))
					.getUid();
		} catch (Exception e) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		}

		LOGGER.debug("[IndexServiceHelper::indexCreateFolder] END");

		return uidFolder;
	}

	public String indexCreateRootFolder(MetadatiIndex metadati) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexCreateRootFolder] BEGIN");

		String uidFolder = null;
		try {
			SearchParams params = new SearchParams();
			params.setLimit(1);

			final StringBuilder queryBuilder = new StringBuilder();
			queryBuilder.append(Constants.INDEX_ROOT);
			queryBuilder.append(Constants.INDEX_FOLDER_SUFFIX);
			queryBuilder.append(Constants.INDEX_TAIF_TIPO_PROCEDURA);
			params.setXPathQuery(queryBuilder.toString());
			
			final String uidTipoProcedura = this.indexSearchFolder(params, metadati.getTipoProcedura(),
					this.indexGetRootFolder());

			final Node nodeIdentificativo = this.getEcmEngineWebServiceDelegate().createContent(
					new Node(uidTipoProcedura), this.indexGetContentFolder(metadati.getIdPersona()),
					this.indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN));

			if (nodeIdentificativo != null) {
				uidFolder = nodeIdentificativo.getUid();
			}

		} catch (Exception e) {
			LOGGER.error("[IndexServiceHelper::indexCreateRootFolder] ERROR GENERICO: " + e.getMessage(), e);

			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		}

		LOGGER.debug("[IndexServiceHelper::indexCreateRootFolder] END");
		return uidFolder;
	}


	public String indexGetFolder(MetadatiIndex metadati) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexGetFolder] BEGIN");

		try {
			
			final StringBuilder luceneQuery = new StringBuilder();
			// Path /app:company_home/cm:taif/ cm:<tipo procedimento>/cm:<identificativo>/
			luceneQuery.append(Constants.INDEX_ROOT).append(Constants.INDEX_FOLDER_SUFFIX)
					.append(Constants.TIPOLOGIA_ELENCO_OPERATORI);
			
			String uidFolderElOp = this.indexSearchFolder(
					IndexDtoFactory.createSearchParamsForIndexFolder(luceneQuery.toString()), Constants.TIPOLOGIA_ELENCO_OPERATORI, null);
			
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getIdPersona());
			
			String uidFolderOperatore = this.indexSearchFolder(
					IndexDtoFactory.createSearchParamsForIndexFolder(luceneQuery.toString()), metadati.getIdPersona(), uidFolderElOp);

			// Pathapp:company_home/cm:taif/ cm:<tipo
			// procedimento>/cm:<identificativo>/cm:<anno>/
			String annoCorrente = ConvertUtil.convertToString(DateUtil.getAnnoCorrente());
			luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(annoCorrente);

			String uidFolderAnno = this.indexSearchFolder(
					IndexDtoFactory.createSearchParamsForIndexFolder(luceneQuery.toString()), annoCorrente, uidFolderOperatore);

			// Path app:company_home/cm:taif/ cm:<tipo
			// procedimento>/cm:<identificativo>/cm:<anno>/cm:<tipologia documento>
			/*luceneQuery.append(Constants.INDEX_FOLDER_SUFFIX);
			luceneQuery.append(metadati.getIdTipologia());

			String uidFolderTipologia = this.indexSearchFolder(
					IndexDtoFactory.createSearchParamsForIndexFolder(luceneQuery.toString()), metadati.getIdTipologia(),
					uidFolderAnno);*/

			return uidFolderAnno;
		} catch (Exception e) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);

			message.replacePlaceholder(Constants.ERR_INDEX);

			throw new ServiceException(e, message);
		} finally {
			LOGGER.debug("[IndexServiceHelper::indexGetFolder] END");
		}
	}

	public String indexUploadFile(String fileName, byte[] file, MetadatiIndex metadati) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexUploadFile] BEGIN");
		String uidFile = null;
		try {
			final Node n = new Node(this.indexGetFolder(metadati));
			final Content c = this.indexCreateContent(metadati, fileName, file);
			final OperationContext oc = this.indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			
			GenericUtil.stampaVO(n, true);
			
			final Node nodoFile = this.ecmEngineWebServiceDelegate.createContent(n, c, oc);

			uidFile = nodoFile.getUid();
		} catch (Exception e) {
			final Message errorMessage = this.msgMgr.getMessage(MsgCodeEnum.G002);
			errorMessage.replacePlaceholder(Constants.ERR_INDEX);

			final String errorLog = "[IndexServiceHelper::indexDeleteFile] ERROR (%s): " + errorMessage.getText();

			LOGGER.error(String.format(errorLog, e.getClass().getName()), e);

			throw new ServiceException(e, errorMessage);
		} finally {
			LOGGER.debug("[IndexServiceHelper::indexUploadFile] END");
		}
		return uidFile;
	}

	public String indexDeleteFile(String uid) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexDeleteFile] BEGIN");
		try {
			if (StringUtils.isNotEmpty(uid)) {
				this.getEcmEngineWebServiceDelegate().deleteContent(new Node(uid),
						this.indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN));
			}

			return uid;
		} catch (Exception e) {
			final Message errorMessage = this.msgMgr.getMessage(MsgCodeEnum.G002);
			errorMessage.replacePlaceholder(Constants.ERR_INDEX);

			final String errorLog = "[IndexServiceHelper::indexDeleteFile] ERROR (%s): " + errorMessage.getText();

			LOGGER.error(String.format(errorLog, e.getClass().getName()), e);

			throw new ServiceException(e, errorMessage);
		} finally {
			LOGGER.debug("[IndexServiceHelper::indexDeleteFile] END");
		}
	}

	public void indexDeleteFileByIdAllegato(String idAllegato) throws ServiceException {
		LOGGER.debug("[IndexServiceHelper::indexDeleteFileByIdAllegato] BEGIN");

		this.indexDeleteFile(this.indexGetUidAllegato(idAllegato));

		LOGGER.debug("[IndexServiceHelper::indexDeleteFileByIdAllegato] END");
	}
	
	private String indexGetUidAllegato(String idAllegato) throws ServiceException {
        return this.indexGetUidAllegato(
            IndexDtoFactory.createSearchParamsForIndexUid(idAllegato)
        );
    }
	
	private String indexGetUidAllegato(SearchParams params) throws ServiceException {
        LOGGER.debug("[IndexServiceHelper::indexGetUidAllegato] BEGIN");

        String uid = null;
        try {
            final OperationContext oc = this.indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);

            final SearchResponse response = this.getEcmEngineWebServiceDelegate().luceneSearch(params, oc);

            final ResultContent[] results = response.getResultContentArray();
            if (ArrayUtils.isNotEmpty(results)) {
                uid = results[0].getUid();
            }

            return uid;
        } catch (Exception e) {
            final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);

            message.replacePlaceholder(Constants.ERR_INDEX);

            throw new ServiceException(e, message);
        } finally {
            LOGGER.debug("[IndexServiceHelper::indexGetUidAllegato] END");
        }
    }
	
	public void indexDeleteMainFolder(String idPratica) throws ServiceException {
        LOGGER.debug("[IndexServiceHelper::indexDeleteMainFolder] BEGIN");

        try {
        	
        	  final StringBuilder luceneQuery = new StringBuilder();

                luceneQuery.append(Constants.INDEX_ROOT)
                           .append(Constants.INDEX_FOLDER_SUFFIX)
                           .append(Constants.TIPOLOGIA_ELENCO_OPERATORI)
                           .append(Constants.INDEX_FOLDER_SUFFIX)           
                           .append(idPratica);
             
            final String uid = this.getEcmEngineWebServiceDelegate().nodeExists(
                IndexDtoFactory.createSearchParamsForIndexFolder(luceneQuery.toString()),
                this.indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN)
            );

            this.indexDeleteFile(uid);
        } catch (Exception e) {
            final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);

            message.replacePlaceholder(Constants.ERR_INDEX);

            throw new ServiceException(e, message);
        } finally {
            LOGGER.debug("[IndexServiceHelper::indexDeleteMainFolder] END");
        }
    }

	
	public byte[] indexDownloadFile(String idAllegato)throws ServiceException{
		LOGGER.debug("[IndexServiceHelper::indexDownloadFile] END");
		byte[] result = null;
		try {
			final String uidAllegato = this.indexGetUidAllegato(idAllegato);
			final OperationContext oc = this.indexGetOperationContext(Constants.INDEX_USERNAME_ADMIN);
			result = this.ecmEngineWebServiceDelegate.retrieveContentData(IndexDtoFactory.createNode(uidAllegato), IndexDtoFactory.createContent(), oc);
		}catch (Exception e) {
            final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);

            message.replacePlaceholder(Constants.ERR_INDEX);

            throw new ServiceException(e, message);
        } finally {
            LOGGER.debug("[IndexServiceHelper::indexDownloadFile] END");
        }
		return result;
	}
}
