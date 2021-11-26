/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoByIdPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTPraticaDettaglioPraticaPerInvioDto;
import it.csi.taif.taifweb.business.helper.dto.ApiManagerDto;
import it.csi.taif.taifweb.business.helper.dto.factory.ActaFactory;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.exception.ServiceException;
import it.csi.taif.taifweb.util.ActaConstants;
import it.csi.taif.taifweb.util.ActaUtils;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.GenericUtil;
import it.csi.taif.taifweb.util.service.integration.acta.ActaStatoPraticaEnum;
import it.doqui.acta.acaris.backofficeservice.BackOfficeServicePort;
import it.doqui.acta.acaris.documentservice.DocumentServicePort;
import it.doqui.acta.acaris.managementservice.ManagementServicePort;
import it.doqui.acta.acaris.multifilingservice.MultifilingServicePort;
import it.doqui.acta.acaris.navigationservice.NavigationServicePort;
import it.doqui.acta.acaris.objectservice.ObjectServicePort;
import it.doqui.acta.acaris.officialbookservice.OfficialBookServicePort;
import it.doqui.acta.acaris.relationshipsservice.RelationshipsServicePort;
import it.doqui.acta.acaris.repositoryservice.AcarisException;
import it.doqui.acta.acaris.repositoryservice.RepositoryServicePort;
import it.doqui.acta.acaris.smsservice.SMSServicePort;
import it.doqui.acta.acaris.subjectregistryservice.SubjectRegistryServicePort;
import it.doqui.acta.actasrv.client.AcarisServiceAuthenticationClient;
import it.doqui.acta.actasrv.dto.acaris.type.archive.AcarisRepositoryEntryType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.EnumFascicoloRealeStatoType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.EnumFolderObjectType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdFascicoloStandardType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdFormaDocumentariaType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdStatoDiEfficaciaType;
import it.doqui.acta.actasrv.dto.acaris.type.backoffice.ClientApplicationInfo;
import it.doqui.acta.actasrv.dto.acaris.type.backoffice.PrincipalExtResponseType;
import it.doqui.acta.actasrv.dto.acaris.type.common.AcarisContentStreamType;
import it.doqui.acta.actasrv.dto.acaris.type.common.CodiceFiscaleType;
import it.doqui.acta.actasrv.dto.acaris.type.common.EnumMimeTypeType;
import it.doqui.acta.actasrv.dto.acaris.type.common.EnumObjectType;
import it.doqui.acta.actasrv.dto.acaris.type.common.EnumPropertyFilter;
import it.doqui.acta.actasrv.dto.acaris.type.common.EnumQueryOperator;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdAOOType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdNodoType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdStrutturaType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdVitalRecordCodeType;
import it.doqui.acta.actasrv.dto.acaris.type.common.NavigationConditionInfoType;
import it.doqui.acta.actasrv.dto.acaris.type.common.ObjectIdType;
import it.doqui.acta.actasrv.dto.acaris.type.common.PagingResponseType;
import it.doqui.acta.actasrv.dto.acaris.type.common.PrincipalIdType;
import it.doqui.acta.actasrv.dto.acaris.type.common.PropertyFilterType;
import it.doqui.acta.actasrv.dto.acaris.type.common.PropertyType;
import it.doqui.acta.actasrv.dto.acaris.type.common.QueryConditionType;
import it.doqui.acta.actasrv.dto.acaris.type.common.QueryNameType;
import it.doqui.acta.actasrv.dto.acaris.type.common.QueryableObjectType;
import it.doqui.acta.actasrv.dto.acaris.type.document.DocumentoArchivisticoIRC;
import it.doqui.acta.actasrv.dto.acaris.type.document.EnumTipoOperazione;
import it.doqui.acta.actasrv.dto.acaris.type.document.IdentificatoreDocumento;
import it.doqui.acta.actasrv.dto.acaris.type.management.VitalRecordCodeType;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.EnumTipoRegistrazioneDaCreare;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.IdentificazioneRegistrazione;
import it.doqui.acta.actasrv.dto.acaris.type.officialbook.ProtocollazioneDocumentoEsistente;

public class ActaServiceHelper extends AbstractServiceHelper {

	private BackOfficeServicePort backOfficeServicePort;
	private ManagementServicePort managementServicePort;
	private MultifilingServicePort multifilingServicePort;
	private NavigationServicePort navigationServicePort;
	private ObjectServicePort objectServicePort;
	private OfficialBookServicePort officialBookServicePort;
	private RelationshipsServicePort relationshipsServicePort;
	private DocumentServicePort documentServicePort;
	private RepositoryServicePort repositoryServicePort;
	private SMSServicePort sMSServicePort;
	private SubjectRegistryServicePort subjectRegistryServicePort;
	private ApiManagerServiceHelper apiManagerServiceHelper;

	protected String backoffice = null;
	protected String management = null;
	protected String multifiling = null;
	protected String navigation = null;
	protected String object = null;
	protected String officialbook = null;
	protected String relationships = null;
	protected String document = null;
	protected String repository = null;
	protected String sms = null;
	protected String subjectregistry = null;

	/**
	 * @return the apiManagerServiceHelper
	 */
	public ApiManagerServiceHelper getApiManagerServiceHelper() {
		return apiManagerServiceHelper;
	}

	/**
	 * @param apiManagerServiceHelper
	 *            the apiManagerServiceHelper to set
	 */
	public void setApiManagerServiceHelper(ApiManagerServiceHelper apiManagerServiceHelper) {
		this.apiManagerServiceHelper = apiManagerServiceHelper;
	}

	public BackOfficeServicePort getBackOfficeServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getBackOfficeServicePort] BEGIN");
		try {
			LOGGER.debug("............ 1");
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			LOGGER.debug("............ 2");
			
			GenericUtil.stampaVO(api, true);
			
			this.backOfficeServicePort = AcarisServiceAuthenticationClient.getBackofficeServiceTokenAPI(api.getUrl(),
					backoffice, api.getConsumerKey(), api.getConsumerSecret());
			
			LOGGER.debug("............ 3");
			
			
		} 
//			catch (it.doqui.acta.acaris.backofficeservice.AcarisException e) {
//			e.printStackTrace();
//			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
//			message.replacePlaceholder(Constants.ERR_ACTA + "b");
//			throw new ServiceException(message);
//		}
		catch (Exception e) {
			e.printStackTrace();
			
			LOGGER.debug("[ActaServiceHelper:: getBackOfficeServicePort] ERRRRR "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}

		LOGGER.debug("[ActaServiceHelper:: getBackOfficeServicePort] END");
		return backOfficeServicePort;
	}

	public void setBackOfficeServicePort(BackOfficeServicePort backOfficeServicePort) {
		this.backOfficeServicePort = backOfficeServicePort;
	}

	public ManagementServicePort getManagementServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getManagementServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.managementServicePort = AcarisServiceAuthenticationClient.getManagementServiceTokenAPI(api.getUrl(),
					management, api.getConsumerKey(), api.getConsumerSecret());
		} catch (it.doqui.acta.acaris.managementservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getManagementServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getManagementServicePort] END");
		return managementServicePort;
	}

	public void setManagementServicePort(ManagementServicePort managementServicePort) {
		this.managementServicePort = managementServicePort;
	}

	public MultifilingServicePort getMultifilingServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getMultifilingServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.multifilingServicePort = AcarisServiceAuthenticationClient.getMultifillingServiceTokenAPI(api.getUrl(),
					multifiling, api.getConsumerKey(), api.getConsumerSecret());
		} catch (it.doqui.acta.acaris.multifilingservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getMultifilingServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getMultifilingServicePort] END");
		return multifilingServicePort;
	}

	public void setMultifilingServicePort(MultifilingServicePort multifilingServicePort) {
		this.multifilingServicePort = multifilingServicePort;
	}

	public NavigationServicePort getNavigationServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getNavigationServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.navigationServicePort = AcarisServiceAuthenticationClient.getNavigationServiceTokenAPI(api.getUrl(),
					navigation, api.getConsumerKey(), api.getConsumerSecret());
		} catch (it.doqui.acta.acaris.navigationservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getNavigationServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getNavigationServicePort] END");
		return navigationServicePort;
	}

	public void setNavigationServicePort(NavigationServicePort navigationServicePort) {
		this.navigationServicePort = navigationServicePort;
	}

	public ObjectServicePort getObjectServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getObjectServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.objectServicePort = AcarisServiceAuthenticationClient.getObjectServiceTokenAPI(api.getUrl(), object,
					api.getConsumerKey(), api.getConsumerSecret(), false);
		} catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getObjectServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getObjectServicePort] END");
		return objectServicePort;
	}

	public void setObjectServicePort(ObjectServicePort objectServicePort) {
		this.objectServicePort = objectServicePort;
	}

	public OfficialBookServicePort getOfficialBookServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getOfficialBookServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.officialBookServicePort = AcarisServiceAuthenticationClient.getOfficialBookServiceTokenAPI(
					api.getUrl(), officialbook, api.getConsumerKey(), api.getConsumerSecret());
		} catch (it.doqui.acta.acaris.officialbookservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getOfficialBookServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getOfficialBookServicePort] END");
		return officialBookServicePort;
	}

	public void setOfficialBookServicePort(OfficialBookServicePort officialBookServicePort) {
		this.officialBookServicePort = officialBookServicePort;
	}

	public RelationshipsServicePort getRelationshipsServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getRelationshipsServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.relationshipsServicePort = AcarisServiceAuthenticationClient.getRelationshipsServiceTokenAPI(
					api.getUrl(), relationships, api.getConsumerKey(), api.getConsumerSecret(), false);
		} catch (it.doqui.acta.acaris.relationshipsservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getRelationshipsServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getRelationshipsServicePort] END");
		return relationshipsServicePort;
	}

	public void setRelationshipsServicePort(RelationshipsServicePort relationshipsServicePort) {
		this.relationshipsServicePort = relationshipsServicePort;
	}

	public DocumentServicePort getDocumentServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getDocumentServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.documentServicePort = AcarisServiceAuthenticationClient.getDocumentServiceTokenAPI(api.getUrl(),
					document, api.getConsumerKey(), api.getConsumerSecret(), false);
		} catch (it.doqui.acta.acaris.documentservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getDocumentServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getDocumentServicePort] END");
		return documentServicePort;
	}

	public void setDocumentServicePort(DocumentServicePort documentServicePort) {
		this.documentServicePort = documentServicePort;
	}

	public RepositoryServicePort getRepositoryServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getRepositoryServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.repositoryServicePort = AcarisServiceAuthenticationClient.getRepositoryServiceTokenAPI(api.getUrl(),
					repository, api.getConsumerKey(), api.getConsumerSecret());
		} catch (it.doqui.acta.acaris.repositoryservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getRepositoryServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}

		LOGGER.debug("[ActaServiceHelper:: getRepositoryServicePort] END");
		return repositoryServicePort;
	}

	public void setRepositoryServicePort(RepositoryServicePort repositoryServicePort) {
		this.repositoryServicePort = repositoryServicePort;
	}

	public SMSServicePort getsMSServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getsMSServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.sMSServicePort = AcarisServiceAuthenticationClient.getSmsServiceTokenAPI(api.getUrl(), sms,
					api.getConsumerKey(), api.getConsumerSecret());
		} catch (it.doqui.acta.acaris.smsservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getsMSServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getsMSServicePort] END");
		return sMSServicePort;
	}

	public void setsMSServicePort(SMSServicePort sMSServicePort) {
		this.sMSServicePort = sMSServicePort;
	}

	public SubjectRegistryServicePort getSubjectRegistryServicePort() throws ManagerException {
		LOGGER.debug("[ActaServiceHelper:: getSubjectRegistryServicePort] BEGIN");
		try {
			ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
			this.subjectRegistryServicePort = AcarisServiceAuthenticationClient.getSubjectRegistryServiceTokenAPI(
					api.getUrl(), subjectregistry, api.getConsumerKey(), api.getConsumerSecret());
		} catch (it.doqui.acta.acaris.subjectregistryservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getSubjectRegistryServicePort] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "b");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper:: getSubjectRegistryServicePort] END");
		return subjectRegistryServicePort;
	}

	public void setSubjectRegistryServicePort(SubjectRegistryServicePort subjectRegistryServicePort) {
		this.subjectRegistryServicePort = subjectRegistryServicePort;
	}

	public ActaServiceHelper(String backoffice, String management, String multifiling, String navigation, String object,
			String officialbook, String relationships, String document, String repository, String sms,
			String subjectregistry) {

		LOGGER.debug("[ActaServiceHelper::] BEGIN");

		LOGGER.debug("[ActaServiceHelper::] backoffice " + backoffice);
		LOGGER.debug("[ActaServiceHelper::] management " + management);
		LOGGER.debug("[ActaServiceHelper::] multifiling " + multifiling);
		LOGGER.debug("[ActaServiceHelper::] navigation " + navigation);
		LOGGER.debug("[ActaServiceHelper::] object " + object);
		LOGGER.debug("[ActaServiceHelper::] officialbook " + officialbook);
		LOGGER.debug("[ActaServiceHelper::] relationships " + relationships);
		LOGGER.debug("[ActaServiceHelper::] document " + document);
		LOGGER.debug("[ActaServiceHelper::] repository " + repository);
		LOGGER.debug("[ActaServiceHelper::] sms " + sms);
		LOGGER.debug("[ActaServiceHelper::] subjectregistry " + subjectregistry);

		this.backoffice = backoffice;
		this.management = management;
		this.multifiling = multifiling;
		this.navigation = navigation;
		this.object = object;
		this.officialbook = officialbook;
		this.relationships = relationships;
		this.document = document;
		this.repository = repository;
		this.sms = sms;
		this.subjectregistry = subjectregistry;

		// LOGGER.debug("[ActaServiceHelper::] getApiManagerServiceHelper()
		// "+getApiManagerServiceHelper());
		// ApiManagerDto api = this.getApiManagerServiceHelper().getApiManagerInfo();
		//
		// GenericUtil.stampaVO(api);
		//
		// String apiServiceUrl = api.getUrl();
		// String consumerKey = api.getConsumerKey();
		// String consumerSecret = api.getConsumerSecret();
		//
		// LOGGER.debug("[ActaServiceHelper::] 222222 ");
		//
		// try {
		// this.backOfficeServicePort =
		// AcarisServiceAuthenticationClient.getBackofficeServiceTokenAPI(api.getUrl(),
		// backoffice, api.getConsumerKey(), api.getConsumerSecret());
		// this.managementServicePort =
		// AcarisServiceAuthenticationClient.getManagementServiceTokenAPI(api.getUrl(),
		// management, api.getConsumerKey(), api.getConsumerSecret());
		// this.multifilingServicePort =
		// AcarisServiceAuthenticationClient.getMultifillingServiceTokenAPI(api.getUrl(),
		// multifiling, api.getConsumerKey(), api.getConsumerSecret());
		// this.navigationServicePort =
		// AcarisServiceAuthenticationClient.getNavigationServiceTokenAPI(apiServiceUrl,
		// navigation, consumerKey, consumerSecret);
		// this.objectServicePort =
		// AcarisServiceAuthenticationClient.getObjectServiceTokenAPI(apiServiceUrl,
		// object, consumerKey, consumerSecret, false);
		// this.officialBookServicePort =
		// AcarisServiceAuthenticationClient.getOfficialBookServiceTokenAPI(apiServiceUrl,
		// officialbook, consumerKey, consumerSecret);
		// this.relationshipsServicePort =
		// AcarisServiceAuthenticationClient.getRelationshipsServiceTokenAPI(apiServiceUrl,
		// relationships, consumerKey, consumerSecret, false);
		// this.documentServicePort =
		// AcarisServiceAuthenticationClient.getDocumentServiceTokenAPI(apiServiceUrl,
		// document, consumerKey, consumerSecret, false);
		// this.repositoryServicePort =
		// AcarisServiceAuthenticationClient.getRepositoryServiceTokenAPI(apiServiceUrl,
		// repository, consumerKey, consumerSecret);
		// this.sMSServicePort =
		// AcarisServiceAuthenticationClient.getSmsServiceTokenAPI(apiServiceUrl, sms,
		// consumerKey, consumerSecret);
		// this.subjectRegistryServicePort =
		// AcarisServiceAuthenticationClient.getSubjectRegistryServiceTokenAPI(apiServiceUrl,
		// subjectregistry, consumerKey, consumerSecret);
		// }catch (it.doqui.acta.acaris.backofficeservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"a");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.repositoryservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"b");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"c");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.documentservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"d");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.navigationservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"e");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.officialbookservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"f");
		// throw new ServiceException(message);
		// } catch (it.doqui.acta.acaris.managementservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"g");
		// throw new ServiceException(message);
		// } catch (it.doqui.acta.acaris.multifilingservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"h");
		// throw new ServiceException(message);
		// } catch (it.doqui.acta.acaris.relationshipsservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"i");
		// throw new ServiceException(message);
		// } catch (it.doqui.acta.acaris.smsservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"j");
		// throw new ServiceException(message);
		// } catch (it.doqui.acta.acaris.subjectregistryservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"k");
		// throw new ServiceException(message);
		// }
		LOGGER.debug("[ActaServiceHelper::] END");

	}

	private void inizializeService(String host, String context, int port) throws ServiceException {
		LOGGER.debug("[ActaServiceHelper::inizializeService] BEGIN");
		// try {
		// this.repositoryServicePort =
		// AcarisServiceClient.getRepositoryServiceAPI(host, context, port);
		// this.backOfficeServicePort =
		// AcarisServiceClient.getBackofficeServiceAPI(host, context, port);
		// this.objectServicePort = AcarisServiceClient.getObjectServiceAPI(host,
		// context, port, true);
		// this.documentServicePort = AcarisServiceClient.getDocumentServiceAPI(host,
		// context, port, true);
		// this.navigationServicePort =
		// AcarisServiceClient.getNavigationServiceAPI(host, context, port);
		// this.officialBookServicePort =
		// AcarisServiceClient.getOfficialBookServiceAPI(host, context, port);
		// }
		// catch (AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"a");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.backofficeservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"b");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"c");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.documentservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"d");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.navigationservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"e");
		// throw new ServiceException(message);
		// }
		// catch (it.doqui.acta.acaris.officialbookservice.AcarisException e) {
		// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
		// message.replacePlaceholder(Constants.ERR_ACTA+"f");
		// throw new ServiceException(message);
		// }
		//
		LOGGER.debug("[ActaServiceHelper::inizializeService] END");

	}

	public void testActa() {
		LOGGER.debug("[ActaServiceHelper::testActa] BEGIN");
		try {
			AcarisRepositoryEntryType[] list = this.getRepositoryServicePort().getRepositories();
			for (AcarisRepositoryEntryType acarisRepositoryEntryType : list) {
				LOGGER.debug("-------- NAME = " + acarisRepositoryEntryType.getRepositoryName());
				LOGGER.debug("-------- ID = " + acarisRepositoryEntryType.getRepositoryId());
				LOGGER.debug("------------------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.debug("[ActaServiceHelper::testActa] END");
	}

	public ObjectIdType getRepositoryIdByName(String repositoryName) throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::getRepositoryIdByName] BEGIN");
		ObjectIdType repositoryId = null;
		AcarisRepositoryEntryType[] elencoRepository = null;

		try {
			elencoRepository = this.getRepositoryServicePort().getRepositories();
			for (AcarisRepositoryEntryType repository : elencoRepository) {
				LOGGER.debug("[ActaServiceHelper::getRepository] repository:" + repository.getRepositoryName());

				if (repository.getRepositoryName().startsWith(repositoryName, 0)) {
					repositoryId = repository.getRepositoryId();
				}
			}
		} catch (AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::cercaFascicolo] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "e");
			throw new ServiceException(message);
		}

		LOGGER.debug("[ActaServiceHelper::getRepositoryIdByName] END");
		return repositoryId;
	}

	public PrincipalIdType getPrincipalId(ObjectIdType repositoryIdType, CodiceFiscaleType codiceFiscaleType,
			IdAOOType idAooType, IdStrutturaType idStrutturaType, IdNodoType idNodoType, ClientApplicationInfo appKey)
			throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::getPrincipalId] BEGIN");
		PrincipalIdType result = null;
		try {
			PrincipalExtResponseType[] response = this.getBackOfficeServicePort().getPrincipalExt(repositoryIdType,
					codiceFiscaleType, idAooType, idStrutturaType, idNodoType, appKey);

			if (response != null && response.length != 0) {
				result = response[0].getPrincipalId();
			}

		} catch (it.doqui.acta.acaris.backofficeservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getPrincipalId] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "f");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper::getPrincipalId] END");
		return result;
	}

	public ObjectIdType getSerieFascicoloId(ObjectIdType repositoryId, ObjectIdType idVoce, PrincipalIdType principalId)
			throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::getSerieFascicoloId] BEGIN");

		ObjectIdType result = null;

		try {

			QueryableObjectType target = new QueryableObjectType();
			target.setObject(EnumObjectType.SERIE_FASCICOLI_PROPERTIES_TYPE.value());

			QueryConditionType[] criteria = ActaUtils.getCriteria(new EnumQueryOperator[] { EnumQueryOperator.EQUALS },
					new String[] { "paroleChiave" }, new String[] { ActaConstants.SERIEFASCICOLO_PAROLACHIAVE });

			NavigationConditionInfoType navigationLimits = new NavigationConditionInfoType();
			ObjectIdType nodoRadice = new ObjectIdType();
			nodoRadice.setValue(idVoce.getValue());
			navigationLimits.setParentNodeId(nodoRadice);
			navigationLimits.setLimitToChildren(true);

			PropertyFilterType filter = ActaUtils.getPropertyFilterList(new String[] { "" },
					new String[] { "objectId" }, null);

			Integer maxItems = null;
			Integer skipCount = 0;

			PagingResponseType pagingResponse = this.getObjectServicePort().query(repositoryId, principalId, target,
					filter, criteria, navigationLimits, maxItems, skipCount);

			if (pagingResponse.getObjectsLength() > 0) {
				result = pagingResponse.getObjects(0).getObjectId();
			}

		} catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getSerieFascicoloId] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "f");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper::getSerieFascicoloId] END");

		return result;
	}

	public ObjectIdType getIdVoce(ObjectIdType repositoryId, PrincipalIdType principalId) throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::getIdVoce] BEGIN");

		ObjectIdType result = null;

		try {

			QueryableObjectType target = new QueryableObjectType();
			target.setObject(EnumObjectType.VOCE_PROPERTIES_TYPE.value());

			QueryConditionType[] criteria = ActaUtils.getCriteria(new EnumQueryOperator[] { EnumQueryOperator.EQUALS },
					new String[] { "descrizione" }, new String[] { "Imprenditoria forestale" }); // la descrizione della
																									// voce in cui si
																									// trova la serie
																									// AIFO

			PropertyFilterType filter = ActaUtils.getPropertyFilterList(new String[] { "" },
					new String[] { "objectId" }, null);

			Integer maxItems = null;
			Integer skipCount = 0;

			PagingResponseType pagingResponse = this.getObjectServicePort().query(repositoryId, principalId, target,
					filter, criteria, null, maxItems, skipCount);

			if (pagingResponse.getObjectsLength() > 0) {
				result = pagingResponse.getObjects(0).getObjectId();
			}

		} catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getIdVoce] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "g");
			throw new ServiceException(message);
		}

		LOGGER.debug("[ActaServiceHelper::getIdVoce] END");
		return result;
	}

	public ObjectIdType cercaFascicolo(ObjectIdType repositoryId, PrincipalIdType principalId,
			ObjectIdType serieFascicoloId, TaifTPraticaDettaglioPraticaPerInvioDto pratica) throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::cercaFascicolo] BEGIN");

		ObjectIdType result = null;
		QueryableObjectType target = new QueryableObjectType();
		target.setObject(EnumObjectType.FASCICOLO_REALE_ANNUALE_PROPERTIES_TYPE.value());

		QueryConditionType[] criteria = ActaUtils.getCriteria(
				new EnumQueryOperator[] { EnumQueryOperator.EQUALS, EnumQueryOperator.EQUALS },
				new String[] {"soggetto", "stato"}, 
				new String[] {pratica.getAzCodiceFiscale(), "1"});

		PropertyFilterType filter = ActaUtils.getPropertyFilterList(new String[] { "" }, new String[] { "objectId" },
				null);

		PagingResponseType pagingResponse = new PagingResponseType();

		try {

			// con queste impostazioni la paginazione e' gestita direttamente dal
			// sistema
			Integer maxItems = null;
			Integer skipCount = 0;

			NavigationConditionInfoType navigation = new NavigationConditionInfoType();
			navigation.setParentNodeId(serieFascicoloId);
			navigation.setLimitToChildren(true);

			pagingResponse = this.getObjectServicePort().query(repositoryId, principalId, target, filter, criteria,
					navigation, maxItems, skipCount);

			LOGGER.debug(" pagingResponse: " + pagingResponse);
			LOGGER.debug(" pagingResponse.getObjects(): " + pagingResponse.getObjects());
			LOGGER.debug(" pagingResponse.getObjectsLength(): " + pagingResponse.getObjectsLength());

			if (pagingResponse.getObjectsLength() > 0) {
				result = pagingResponse.getObjects(0).getObjectId();
			}

		} catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::cercaFascicolo] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "h");
			throw new ServiceException(message);
		}

		LOGGER.debug("[ActaServiceHelper::cercaFascicolo] BEGIN");

		return result;
	}

	public ObjectIdType createFascicolo(
			IdAOOType idAOOType,
			IdNodoType idNodoType,
			IdStrutturaType idStrutturaType,
			ObjectIdType repositoryId, 
			PrincipalIdType principalId, 
			ObjectIdType folderId,
			IdVitalRecordCodeType idVitalCodeType,
			IdFascicoloStandardType idFascicoloStandardType,
			TaifTPraticaDettaglioPraticaPerInvioDto pratica) throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::createFascicolo] BEGIN");
		
		
		LOGGER.debug("[PARAMETRI ::createFascicolo IDAOO ] *"+idAOOType.getValue());
		
		
		ObjectIdType result = null;

		try {
			result = this.getObjectServicePort().createFolder(repositoryId,
					EnumFolderObjectType.FASCICOLO_REALE_ANNUALE_PROPERTIES_TYPE, principalId,
					ActaFactory.createFascioloProperties(
							repositoryId, 
							idVitalCodeType,
							idAOOType,
							idStrutturaType,
							idNodoType,
							idFascicoloStandardType,
							pratica), folderId);
		} catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::createFascicolo] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "i");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper::createFascicolo] END");
		return result;

	}

	public ObjectIdType getSottofascicoloId(
			ObjectIdType repositoryId, 
			PrincipalIdType principalId,
			ObjectIdType fascicoloId, 
			TaifTPraticaDettaglioPraticaPerInvioDto pratica) throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::getSottofascicoloId] BEGIN");

		ObjectIdType result = null;
		QueryableObjectType target = new QueryableObjectType();
		target.setObject(EnumObjectType.SOTTOFASCICOLO_PROPERTIES_TYPE.value());

		int nrSottoFascicolo = ActaStatoPraticaEnum.getSottoFascicoloByIdStatoPratica(pratica.getSsFkStatoPratica())
				.getNrSottoFasciolo();

		QueryConditionType[] criteria = ActaUtils.getCriteria(new EnumQueryOperator[] { EnumQueryOperator.EQUALS },
				new String[] { "codice" }, new String[] { ConvertUtil.convertToString(nrSottoFascicolo) });

		PropertyFilterType filter = ActaUtils.getPropertyFilterList(new String[] { "" }, new String[] { "objectId" },
				null);

		PagingResponseType pagingResponse = new PagingResponseType();

		try {

			// con queste impostazioni la paginazione e' gestita direttamente dal
			// sistema
			Integer maxItems = null;
			Integer skipCount = 0;

			NavigationConditionInfoType navigation = new NavigationConditionInfoType();
			navigation.setParentNodeId(fascicoloId);
			navigation.setLimitToChildren(true);

			pagingResponse = this.getObjectServicePort().query(repositoryId, principalId, target, filter, criteria,
					navigation, maxItems, skipCount);

			LOGGER.debug(" pagingResponse: " + pagingResponse);
			LOGGER.debug(" pagingResponse.getObjects(): " + pagingResponse.getObjects());
			LOGGER.debug(" pagingResponse.getObjectsLength(): " + pagingResponse.getObjectsLength());

			if (pagingResponse.getObjectsLength() > 0) {
				result = pagingResponse.getObjects(0).getObjectId();
			}

		} catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getSottofascicoloId] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "h");
			throw new ServiceException(message);
		}

		LOGGER.debug("[ActaServiceHelper::getSottofascicoloId] BEGIN");

		return result;
	}

	public IdentificatoreDocumento archiviaDocumento(
			ObjectIdType repositoryId, 
			PrincipalIdType principalId,
			ObjectIdType classificazioneGeneraleId,
			IdFormaDocumentariaType idFormaDocumentariaType,
			IdVitalRecordCodeType idVitalRecordCodeType, 
			IdStatoDiEfficaciaType idStatoDiEfficaciaType,
			ObjectIdType parentFolder, 
			byte[] file, 
			TaifTPraticaDettaglioPraticaPerInvioDto pratica, 
			TaifTAllegatoByIdPraticaDto allegato)throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::archiviaDocumento] BEGIN");
		IdentificatoreDocumento result = null;
		try {
			AcarisContentStreamType stream = creaContentStream(file, allegato.getNomeAllegato());
			
			DocumentoArchivisticoIRC datiCreazione = ActaFactory.createDocumentoArchivisticoIRC(
					parentFolder,
					classificazioneGeneraleId,
					idFormaDocumentariaType,
					idVitalRecordCodeType,
					idStatoDiEfficaciaType,
					stream,
					pratica,
					allegato
					);
					
			EnumTipoOperazione tipoOperazione = EnumTipoOperazione.ELETTRONICO;
			result = this.getDocumentServicePort().creaDocumento(repositoryId, principalId, tipoOperazione,
					datiCreazione);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::archiviaDocumento] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "k");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper::archiviaDocumento] END");
		return result;
	}

	private static AcarisContentStreamType creaContentStream(byte[] fileByte, final String fileName) throws IOException {
		AcarisContentStreamType contentStream = new AcarisContentStreamType();
		// byte[] stream = getBytesFromFile(filePath + fileName);
		final InputStream iS = new ByteArrayInputStream(fileByte);
		final OutputStream oS = new ByteArrayOutputStream(fileByte.length);

		javax.activation.DataSource ds = new javax.activation.DataSource() {

			public OutputStream getOutputStream() throws IOException {
				return oS;
			}

			public String getName() {
				return fileName;
			}

			public InputStream getInputStream() throws IOException {
				return iS;
			}

			public String getContentType() {
				return GenericUtil.getFileExtension(fileName);
			}
		};
		contentStream.setStreamMTOM(new DataHandler(ds));
		//contentStream.setStream(fileByte);
		contentStream.setFilename(ds.getName());
		contentStream.setMimeType(EnumMimeTypeType.fromValue(GenericUtil.getMimeTypeFromFileName(fileName)));
		return contentStream;
	}

	public IdVitalRecordCodeType getIdVitalRecordCodeType(
			ObjectIdType repositoryId, 
			String vitalRecordCode) throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::getIdVitalRecordCodeType] BEGIN");
		IdVitalRecordCodeType result = null;
		try {
			VitalRecordCodeType[] vrcArray = this.getManagementServicePort().getVitalRecordCode(repositoryId);
			for (VitalRecordCodeType vrc : vrcArray) {
                if (vitalRecordCode.equalsIgnoreCase(vrc.getDescrizione())) {
                    result = vrc.getIdVitalRecordCode();
                    break;
                }
            }
		} 
		catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getIdVitalRecordCodeType] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "l");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper::getIdVitalRecordCodeType] END");
		return result;
	}

	public IdFormaDocumentariaType getIdFormaDocumentariaType(
			ObjectIdType repositoryId, 
			PrincipalIdType principalId,
			String formaDocumentariaCode) throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::getIdFormaDocumentariaType] BEGIN");
		IdFormaDocumentariaType result = null;
		QueryableObjectType target = new QueryableObjectType();
		target.setObject("FormaDocumentariaDecodifica");
		
		PropertyFilterType filter = new PropertyFilterType();
        filter.setFilterType(EnumPropertyFilter.LIST);

        List<QueryNameType> richieste = new ArrayList<QueryNameType>();
        QueryNameType richiesta = new QueryNameType();
        richiesta.setClassName(target.getObject());
        richiesta.setPropertyName("dbKey");
        richieste.add(richiesta);
        filter.setPropertyList(richieste.toArray(new QueryNameType[richieste.size()]));

        List<QueryConditionType> criteria = new ArrayList<QueryConditionType>();
        QueryConditionType qct = new QueryConditionType();
        qct.setPropertyName("descrizione");
        qct.setOperator(EnumQueryOperator.EQUALS);
        qct.setValue(formaDocumentariaCode);
        criteria.add(qct);
        PagingResponseType pagingResponse;
		try {
			pagingResponse = this.getObjectServicePort().query(
					repositoryId, 
					principalId, 
					target, 
					filter,
			        criteria.toArray(new QueryConditionType[criteria.size()]), null, null, new Integer(0));
		
        
	        if (pagingResponse != null && pagingResponse.getObjectsLength() == 1 && pagingResponse.getObjects(0) != null && pagingResponse.getObjects(0).getPropertiesLength() > 0) {
	            for (PropertyType current : pagingResponse.getObjects(0).getProperties()) {
	                if ("dbKey".equals(current.getQueryName().getPropertyName()) && current.getValue() != null && current.getValue().getContentLength() == 1) {
	                    result = new IdFormaDocumentariaType();
	                    result.setValue(Long.parseLong(current.getValue().getContent(0)));
	                    break;
	                }
	            }
	        }
		}
		catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getIdFormaDocumentariaType] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "m");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper::getIdFormaDocumentariaType] END");
		return result;
	}
	
	public IdStatoDiEfficaciaType getIdStatoEfficaciaType(ObjectIdType repositoryId, PrincipalIdType principalId,String descrizioneStatoEfficacia) throws ManagerException {
		LOGGER.debug("[ActaServiceHelper::getIdStatoEfficaciaType] END");
        QueryableObjectType target = new QueryableObjectType();
        target.setObject("StatoDiEfficaciaDecodifica");

        PropertyFilterType filter = new PropertyFilterType();
        filter.setFilterType(EnumPropertyFilter.LIST);

        List<QueryNameType> richieste = new ArrayList<QueryNameType>();
        QueryNameType richiesta = new QueryNameType();
        richiesta.setClassName(target.getObject());
        richiesta.setPropertyName("dbKey");
        richieste.add(richiesta);
        filter.setPropertyList(richieste.toArray(new QueryNameType[richieste.size()]));

        List<QueryConditionType> criteria = new ArrayList<QueryConditionType>();
        QueryConditionType qct = new QueryConditionType();
        qct.setPropertyName("descrizione");
        qct.setOperator(EnumQueryOperator.EQUALS);
        qct.setValue(descrizioneStatoEfficacia);
        criteria.add(qct);

        IdStatoDiEfficaciaType idStatoEfficacia = null;

        try {
            PagingResponseType result = this.getObjectServicePort().query(repositoryId, principalId, target, filter,
                criteria.toArray(new QueryConditionType[criteria.size()]), null, null, new Integer(0));

            if (result != null && result.getObjectsLength() == 1 && result.getObjects(0) != null && result.getObjects(0).getPropertiesLength() > 0) {
                for (PropertyType current : result.getObjects(0).getProperties()) {
                    if ("dbKey".equals(current.getQueryName().getPropertyName()) && current.getValue() != null && current.getValue().getContentLength() == 1) {
                        idStatoEfficacia = new IdStatoDiEfficaciaType();
                        idStatoEfficacia.setValue(Long.parseLong(current.getValue().getContent(0)));
                        break;
                    }
                }
            }

        } catch (it.doqui.acta.acaris.objectservice.AcarisException e) {
        	e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::getIdStatoEfficaciaType] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "n");
			throw new ServiceException(message);
		}
        LOGGER.debug("[ActaServiceHelper::getIdStatoEfficaciaType] END");
        return idStatoEfficacia;
    }
	
	public IdentificazioneRegistrazione protocollaDocumentoInArrivo(
			ObjectIdType classificazioneId,
			ObjectIdType repositoryId, 
			PrincipalIdType principalId,
			long idAoo,
			long idNodo,
			long idStruttura,
			TaifTPraticaDettaglioPraticaPerInvioDto pratica) throws ManagerException{
		LOGGER.debug("[ActaServiceHelper::protocollaDocumentoInArrivo] BEGIN");
		IdentificazioneRegistrazione result = null;
		try {
			ObjectIdType objectIdAooType = this.queryForAooStrutNodo(
					repositoryId, 
					principalId, 
					EnumObjectType.AOO_PROPERTIES_TYPE, 
					idAoo);
			ObjectIdType objectIdNodoType = this.queryForAooStrutNodo(
					repositoryId, 
					principalId, 
					EnumObjectType.NODO_PROPERTIES_TYPE, 
					idNodo);
			ObjectIdType objectIdStrutturaType = this.queryForAooStrutNodo(
					repositoryId, 
					principalId, 
					EnumObjectType.STRUTTURA_PROPERTIES_TYPE, 
					idStruttura);
			
			String descrizioneNodo = this.getDescrizioneNodo(repositoryId, principalId, idNodo);
			
			ProtocollazioneDocumentoEsistente protocollazione = ActaFactory.createProtocollazioneDocumentoEsistente(
					objectIdAooType, 
					objectIdNodoType, 
					descrizioneNodo,
					objectIdStrutturaType, 
					classificazioneId, 
					pratica);
			
			result = getOfficialBookServicePort().creaRegistrazione(
					repositoryId, 
					principalId, 
					EnumTipoRegistrazioneDaCreare.PROTOCOLLAZIONE_DOCUMENTO_ESISTENTE, 
					protocollazione);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			LOGGER.debug("[ActaServiceHelper::protocollaDocumentoInArrivo] ERROR --> "+e.getMessage());
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
			message.replacePlaceholder(Constants.ERR_ACTA + "o");
			throw new ServiceException(message);
		}
		LOGGER.debug("[ActaServiceHelper::protocollaDocumentoInArrivo] END");
		return result;
	}
	
	 public ObjectIdType queryForAooStrutNodo(
			 ObjectIdType repositoryId, 
			 PrincipalIdType principalId,
			 EnumObjectType targetType, 
			 long id) throws ManagerException{
		 LOGGER.debug("[ActaServiceHelper::queryForAooStrutNodo] BEGIN");
		 QueryableObjectType target = new QueryableObjectType();
	     target.setObject(targetType.value());
	     PropertyFilterType filter = new PropertyFilterType();
	     filter.setFilterType(EnumPropertyFilter.NONE);
	        
	     QueryConditionType[] criteria = new QueryConditionType[1];
	     QueryConditionType qct = new QueryConditionType();
	     qct.setPropertyName("dbKey");
	     qct.setOperator(EnumQueryOperator.EQUALS);
	     qct.setValue(String.valueOf(id));
	     criteria[0] = qct;
	        
	     ObjectIdType objectId = null;
	        
	     try {
	    	 PagingResponseType result = this.getBackOfficeServicePort().query(
	    			 repositoryId, 
	    			 principalId, 
	    			 target, 
	    			 filter, 
	    			 criteria, 
	    			 null,
	    			 new Integer(5), 
	    			 null);
	            
	          if (result != null && result.getObjectsLength() == 1 && result.getObjects(0) != null && result.getObjects(0).getPropertiesLength() > 0) {
	                for (PropertyType current : result.getObjects(0).getProperties()) {
	                    if ("objectId".equals(current.getQueryName().getPropertyName()) && current.getValue() != null && current.getValue().getContentLength() == 1) {
	                        objectId = new ObjectIdType();
	                        objectId.setValue(current.getValue().getContent(0));
	                        System.out.println("Trovato objectId per " + targetType.value());
	                        break;
	                    }
	                }
	            }
	            
	            if(objectId == null) {
	            	final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
	            	message.replacePlaceholder(Constants.ERR_ACTA + "p");
	            	throw new ServiceException(message);
	            }

	        } catch (Exception e) {
	        	e.printStackTrace();
				LOGGER.debug("[ActaServiceHelper::queryForAooStrutNodo] ERROR --> "+e.getMessage());
	        	final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
				message.replacePlaceholder(Constants.ERR_ACTA + "p");
				throw new ServiceException(message);
	        }
	     LOGGER.debug("[ActaServiceHelper::queryForAooStrutNodo] END");
	        return objectId;
	    }  
	 
	 public String getDescrizioneNodo(ObjectIdType repositoryId, 
			 PrincipalIdType principalId,
			 long idNodo) throws ManagerException{
		 LOGGER.debug("[ActaServiceHelper::getDescrizioneNodo] BEGIN");
	        QueryableObjectType target = new QueryableObjectType();
	        target.setObject(EnumObjectType.NODO_PROPERTIES_TYPE.value());
	        
	        PropertyFilterType filter = new PropertyFilterType();
	        filter.setFilterType(EnumPropertyFilter.LIST);
	        
	        QueryNameType[] richieste = new QueryNameType[4];
	        for(int i = 0; i < richieste.length; i++) {
	            richieste[i] = new QueryNameType();
	            richieste[i].setClassName(target.getObject());
	        }
	        
	        richieste[2].setPropertyName("descNodo");
	        filter.setPropertyList(richieste);
	        
	        QueryConditionType[] criteria = new QueryConditionType[1];
	        QueryConditionType qct = new QueryConditionType();
	        qct.setPropertyName("dbKey");
	        qct.setOperator(EnumQueryOperator.EQUALS);
	        qct.setValue(String.valueOf(idNodo));
	        criteria[0] = qct;
	        
	        String descrizione = null;
	        try {
	            PagingResponseType result = this.getBackOfficeServicePort().query(repositoryId, principalId, target, filter, criteria, null, new Integer(5), null);

	            if (result != null && result.getObjectsLength() == 1 && result.getObjects(0) != null && result.getObjects(0).getPropertiesLength() > 0) {
	                for (PropertyType current : result.getObjects(0).getProperties()) {
	                    if ("descNodo".equals(current.getQueryName().getPropertyName()) && current.getValue() != null && current.getValue().getContentLength() == 1) {
	                        descrizione = current.getValue().getContent(0);
	                        break;
	                    }
	                }
	            }
	            
	            if(descrizione == null) {
	            	final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
					message.replacePlaceholder(Constants.ERR_ACTA + "q1");
					throw new ServiceException(message);
	            }
	            
	        }  catch (Exception e) {
	        	e.printStackTrace();
				LOGGER.debug("[ActaServiceHelper::getDescrizioneNodo] ERROR --> "+e.getMessage());
	        	final Message message = this.msgMgr.getMessage(MsgCodeEnum.G002);
				message.replacePlaceholder(Constants.ERR_ACTA + "q2");
				throw new ServiceException(message);
	        }
	        LOGGER.debug("[ActaServiceHelper::getDescrizioneNodo] END");
	        return descrizione;
	    }
}
