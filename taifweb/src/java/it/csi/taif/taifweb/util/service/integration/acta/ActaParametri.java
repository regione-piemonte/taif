/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.service.integration.acta;

import java.io.Serializable;
import java.util.List;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoByIdPraticaDto;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdFormaDocumentariaType;
import it.doqui.acta.actasrv.dto.acaris.type.archive.IdStatoDiEfficaciaType;
import it.doqui.acta.actasrv.dto.acaris.type.common.IdVitalRecordCodeType;
import it.doqui.acta.actasrv.dto.acaris.type.common.ObjectIdType;
import it.doqui.acta.actasrv.dto.acaris.type.common.PrincipalIdType;

public class ActaParametri implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6842835292509844130L;
	
	private ObjectIdType repositoryId; 
	private PrincipalIdType principalId;
	private	ObjectIdType classificazioneGeneraleId;
	private	IdFormaDocumentariaType idFormaDocumentariaType;
	private IdVitalRecordCodeType idVitalRecordCodeType; 
	private	IdStatoDiEfficaciaType idStatoDiEfficaciaType;
	private	ObjectIdType parentFolder; 
	private	byte[] file;
	private TaifTAllegatoByIdPraticaDto allegato;
	
	/**
	 * @return the repositoryId
	 */
	public ObjectIdType getRepositoryId() {
		return repositoryId;
	}
	/**
	 * @param repositoryId the repositoryId to set
	 */
	public void setRepositoryId(ObjectIdType repositoryId) {
		this.repositoryId = repositoryId;
	}
	/**
	 * @return the principalId
	 */
	public PrincipalIdType getPrincipalId() {
		return principalId;
	}
	/**
	 * @param principalId the principalId to set
	 */
	public void setPrincipalId(PrincipalIdType principalId) {
		this.principalId = principalId;
	}
	/**
	 * @return the classificazioneGeneraleId
	 */
	public ObjectIdType getClassificazioneGeneraleId() {
		return classificazioneGeneraleId;
	}
	/**
	 * @param classificazioneGeneraleId the classificazioneGeneraleId to set
	 */
	public void setClassificazioneGeneraleId(ObjectIdType classificazioneGeneraleId) {
		this.classificazioneGeneraleId = classificazioneGeneraleId;
	}
	/**
	 * @return the idFormaDocumentariaType
	 */
	public IdFormaDocumentariaType getIdFormaDocumentariaType() {
		return idFormaDocumentariaType;
	}
	/**
	 * @param idFormaDocumentariaType the idFormaDocumentariaType to set
	 */
	public void setIdFormaDocumentariaType(IdFormaDocumentariaType idFormaDocumentariaType) {
		this.idFormaDocumentariaType = idFormaDocumentariaType;
	}
	/**
	 * @return the idVitalRecordCodeType
	 */
	public IdVitalRecordCodeType getIdVitalRecordCodeType() {
		return idVitalRecordCodeType;
	}
	/**
	 * @param idVitalRecordCodeType the idVitalRecordCodeType to set
	 */
	public void setIdVitalRecordCodeType(IdVitalRecordCodeType idVitalRecordCodeType) {
		this.idVitalRecordCodeType = idVitalRecordCodeType;
	}
	/**
	 * @return the idStatoDiEfficaciaType
	 */
	public IdStatoDiEfficaciaType getIdStatoDiEfficaciaType() {
		return idStatoDiEfficaciaType;
	}
	/**
	 * @param idStatoDiEfficaciaType the idStatoDiEfficaciaType to set
	 */
	public void setIdStatoDiEfficaciaType(IdStatoDiEfficaciaType idStatoDiEfficaciaType) {
		this.idStatoDiEfficaciaType = idStatoDiEfficaciaType;
	}
	/**
	 * @return the parentFolder
	 */
	public ObjectIdType getParentFolder() {
		return parentFolder;
	}
	/**
	 * @param parentFolder the parentFolder to set
	 */
	public void setParentFolder(ObjectIdType parentFolder) {
		this.parentFolder = parentFolder;
	}
	/**
	 * @return the file
	 */
	public byte[] getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(byte[] file) {
		this.file = file;
	}
	/**
	 * @return the allegato
	 */
	public TaifTAllegatoByIdPraticaDto getAllegato() {
		return allegato;
	}
	/**
	 * @param allegato the allegato to set
	 */
	public void setAllegato(TaifTAllegatoByIdPraticaDto allegato) {
		this.allegato = allegato;
	}
	
	
	
	
	
}
