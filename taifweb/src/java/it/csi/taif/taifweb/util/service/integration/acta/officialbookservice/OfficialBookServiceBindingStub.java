/**
 * OfficialBookServiceBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.officialbookservice;

public class OfficialBookServiceBindingStub extends org.apache.axis.client.Stub implements OfficialBookServicePort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[9];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("creaRegistrazione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipologiaCreazione"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipoRegistrazioneDaCreare"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "infoRichiestaCreazione"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazioneRequest"), RegistrazioneRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "IdentificazioneRegistrazione"));
        oper.setReturnClass(IdentificazioneRegistrazione.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "identificazioneCreazione"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("importaRegistrazione");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "classificazioneId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "registroId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "infoRegistrazione"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoRegistrazione"), InfoRegistrazione.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "senzaCreazioneSoggetti"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "boolean"), boolean.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "IdentificazioneRegistrazione"));
        oper.setReturnClass(IdentificazioneRegistrazione.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "identificazioneCreazione"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getRegistries");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "aooId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "anno"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "integer"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertyFilterType"), it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PagingResponseType"));
        oper.setReturnClass(it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "object"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "objectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertyFilterType"), it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectResponseType"));
        oper.setReturnClass(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "object"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("updateProperties");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "objectId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "changeToken"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ChangeTokenType"), it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "properties"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertyType"), it.csi.taif.taifweb.util.service.integration.acta.common.PropertyType[].class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "SimpleResponseType"));
        oper.setReturnClass(it.csi.taif.taifweb.util.service.integration.acta.common.SimpleResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "response"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("query");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "target"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "QueryableObjectType"), it.csi.taif.taifweb.util.service.integration.acta.common.QueryableObjectType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertyFilterType"), it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "criteria"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "QueryConditionType"), it.csi.taif.taifweb.util.service.integration.acta.common.QueryConditionType[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "navigationLimits"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "NavigationConditionInfoType"), it.csi.taif.taifweb.util.service.integration.acta.common.NavigationConditionInfoType.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "maxItems"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "integer"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "skipCount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "integer"), java.lang.Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PagingResponseType"));
        oper.setReturnClass(it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "object"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPropertiesMassive");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identifiers"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "filter"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertyFilterType"), it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectResponseType"));
        oper.setReturnClass(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "object"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("creaAnnotazioneOB");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "target"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "tipologiaTarget"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipologiaTargetAnnotazioneOB"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "properties"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertiesType"), it.csi.taif.taifweb.util.service.integration.acta.common.PropertiesType.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "IdentificazioneAnnotazioneOB"));
        oper.setReturnClass(IdentificazioneAnnotazioneOB.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "identificazioneCreazione"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("inviaSegnatura");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "repositoryId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "principalId"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "origine"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identificatoreRegistraizone"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"), it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "mittente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoMittenteIS"), InfoMittenteIS.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "destinatari"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoDestinatarioIS"), InfoDestinatarioIS[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "identitaDigitale"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFault"),
                      "it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType",
                      new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType"), 
                      true
                     ));
        _operations[8] = oper;

    }

    public OfficialBookServiceBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public OfficialBookServiceBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public OfficialBookServiceBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "acarisFaultType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "AnnotazioniPropertiesType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.AnnotazioniPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "boolean");
            cachedSerQNames.add(qName);
            cls = boolean.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ChangeTokenType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "CommonPropertiesType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.CommonPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ComplexPropertyType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.ComplexPropertyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "date");
            cachedSerQNames.add(qName);
            cls = java.util.Date.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaExtType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaExtType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "enumCommonObjectType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "enumErrorCodeType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "enumObjectType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "enumPropertyFilter");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "enumQueryOperator");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "enumServiceException");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IDDBType");
            cachedSerQNames.add(qName);
            cls = long.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IDType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "IdUtenteType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.IdUtenteType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "integer");
            cachedSerQNames.add(qName);
            cls = int.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "NavigationConditionInfoType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.NavigationConditionInfoType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectResponseType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PagingResponseType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PrincipalIdType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertiesType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.PropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertyFilterType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "PropertyType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.PropertyType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ProtocolloPropertiesType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.ProtocolloPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "QueryableObjectType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.QueryableObjectType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "QueryConditionType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.QueryConditionType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "QueryNameType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.QueryNameType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "SimpleResponseType");
            cachedSerQNames.add(qName);
            cls = it.csi.taif.taifweb.util.service.integration.acta.common.SimpleResponseType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ValueType");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string");
            qName2 = new javax.xml.namespace.QName("", "content");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "XMLType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "AnnotazioneOBPropertiesType");
            cachedSerQNames.add(qName);
            cls = AnnotazioneOBPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "CorrispondenteMessaggioPropertiesType");
            cachedSerQNames.add(qName);
            cls = CorrispondenteMessaggioPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "CorrispondentePropertiesType");
            cachedSerQNames.add(qName);
            cls = CorrispondentePropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "DestinatarioEsterno");
            cachedSerQNames.add(qName);
            cls = DestinatarioEsterno.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "DestinatarioInterno");
            cachedSerQNames.add(qName);
            cls = DestinatarioInterno.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumOfficialBookObjectType");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipoAPI");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipoContenitore");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipoCorrispondente");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipologiaSoggettoAssociato");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipologiaTargetAnnotazioneOB");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipoPFPG");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "enumTipoRegistrazioneDaCreare");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "IdentificazioneAnnotazioneOB");
            cachedSerQNames.add(qName);
            cls = IdentificazioneAnnotazioneOB.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "IdentificazioneProtocollante");
            cachedSerQNames.add(qName);
            cls = IdentificazioneProtocollante.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "IdentificazioneProtocollanteEstesa");
            cachedSerQNames.add(qName);
            cls = IdentificazioneProtocollanteEstesa.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "IdentificazioneRegistrazione");
            cachedSerQNames.add(qName);
            cls = IdentificazioneRegistrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoAnnullamentoRegistrazione");
            cachedSerQNames.add(qName);
            cls = InfoAnnullamentoRegistrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoCreazioneAnnotazioneOB");
            cachedSerQNames.add(qName);
            cls = InfoCreazioneAnnotazioneOB.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoCreazioneCorrispondente");
            cachedSerQNames.add(qName);
            cls = InfoCreazioneCorrispondente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoCreazioneRegistrazione");
            cachedSerQNames.add(qName);
            cls = InfoCreazioneRegistrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoDateArrivo");
            cachedSerQNames.add(qName);
            cls = InfoDateArrivo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoDestinatarioIS");
            cachedSerQNames.add(qName);
            cls = InfoDestinatarioIS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoMittenteIS");
            cachedSerQNames.add(qName);
            cls = InfoMittenteIS.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoProtocolloMittente");
            cachedSerQNames.add(qName);
            cls = InfoProtocolloMittente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoRegistrazione");
            cachedSerQNames.add(qName);
            cls = InfoRegistrazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "InfoSoggettoAssociato");
            cachedSerQNames.add(qName);
            cls = InfoSoggettoAssociato.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "LogProtocolloPropertiesType");
            cachedSerQNames.add(qName);
            cls = LogProtocolloPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "MessaggioPropertiesType");
            cachedSerQNames.add(qName);
            cls = MessaggioPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "MittenteEsterno");
            cachedSerQNames.add(qName);
            cls = MittenteEsterno.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "MittenteInterno");
            cachedSerQNames.add(qName);
            cls = MittenteInterno.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "OfficialBookPropertiesType");
            cachedSerQNames.add(qName);
            cls = OfficialBookPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "Protocollazione");
            cachedSerQNames.add(qName);
            cls = Protocollazione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "ProtocollazioneDaSmistamento");
            cachedSerQNames.add(qName);
            cls = ProtocollazioneDaSmistamento.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "ProtocollazioneDocumentoEsistente");
            cachedSerQNames.add(qName);
            cls = ProtocollazioneDocumentoEsistente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazioneAPI");
            cachedSerQNames.add(qName);
            cls = RegistrazioneAPI.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazioneArrivo");
            cachedSerQNames.add(qName);
            cls = RegistrazioneArrivo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazioneInterna");
            cachedSerQNames.add(qName);
            cls = RegistrazioneInterna.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazionePartenza");
            cachedSerQNames.add(qName);
            cls = RegistrazionePartenza.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazionePropertiesType");
            cachedSerQNames.add(qName);
            cls = RegistrazionePropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazioneRapida");
            cachedSerQNames.add(qName);
            cls = RegistrazioneRapida.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistrazioneRequest");
            cachedSerQNames.add(qName);
            cls = RegistrazioneRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RegistroProtocolloPropertiesType");
            cachedSerQNames.add(qName);
            cls = RegistroProtocolloPropertiesType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "RiferimentoSoggettoEsistente");
            cachedSerQNames.add(qName);
            cls = RiferimentoSoggettoEsistente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "SoggettoEsterno");
            cachedSerQNames.add(qName);
            cls = SoggettoEsterno.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("prt.common.acaris.acta.doqui.it", "enumPFPGUL");
            cachedSerQNames.add(qName);
            cls = java.lang.String.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(org.apache.axis.encoding.ser.BaseSerializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleSerializerFactory.class, cls, qName));
            cachedDeserFactories.add(org.apache.axis.encoding.ser.BaseDeserializerFactory.createFactory(org.apache.axis.encoding.ser.SimpleDeserializerFactory.class, cls, qName));

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public IdentificazioneRegistrazione creaRegistrazione(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, java.lang.String tipologiaCreazione, RegistrazioneRequest infoRichiestaCreazione) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "creaRegistrazione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, principalId, tipologiaCreazione, infoRichiestaCreazione});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (IdentificazioneRegistrazione) _resp;
            } catch (java.lang.Exception _exception) {
                return (IdentificazioneRegistrazione) org.apache.axis.utils.JavaUtils.convert(_resp, IdentificazioneRegistrazione.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public IdentificazioneRegistrazione importaRegistrazione(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType classificazioneId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType registroId, InfoRegistrazione infoRegistrazione, boolean senzaCreazioneSoggetti) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "importaRegistrazione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, principalId, classificazioneId, registroId, infoRegistrazione, new java.lang.Boolean(senzaCreazioneSoggetti)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (IdentificazioneRegistrazione) _resp;
            } catch (java.lang.Exception _exception) {
                return (IdentificazioneRegistrazione) org.apache.axis.utils.JavaUtils.convert(_resp, IdentificazioneRegistrazione.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType getRegistries(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType aooId, java.lang.Integer anno, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "getRegistries"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, principalId, aooId, anno, filter});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType getProperties(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "getProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, objectId, principalId, filter});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.taif.taifweb.util.service.integration.acta.common.SimpleResponseType updateProperties(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType changeToken, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyType[] properties) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "updateProperties"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, objectId, principalId, changeToken, properties});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.SimpleResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.SimpleResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.taif.taifweb.util.service.integration.acta.common.SimpleResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType query(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.QueryableObjectType target, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter, it.csi.taif.taifweb.util.service.integration.acta.common.QueryConditionType[] criteria, it.csi.taif.taifweb.util.service.integration.acta.common.NavigationConditionInfoType navigationLimits, java.lang.Integer maxItems, java.lang.Integer skipCount) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "query"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, principalId, target, filter, criteria, navigationLimits, maxItems, skipCount});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.taif.taifweb.util.service.integration.acta.common.PagingResponseType.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType[] getPropertiesMassive(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType[] identifiers, it.csi.taif.taifweb.util.service.integration.acta.common.PropertyFilterType filter) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "getPropertiesMassive"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, principalId, identifiers, filter});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType[]) org.apache.axis.utils.JavaUtils.convert(_resp, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectResponseType[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public IdentificazioneAnnotazioneOB creaAnnotazioneOB(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType target, java.lang.String tipologiaTarget, it.csi.taif.taifweb.util.service.integration.acta.common.PropertiesType properties) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "creaAnnotazioneOB"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, principalId, target, tipologiaTarget, properties});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (IdentificazioneAnnotazioneOB) _resp;
            } catch (java.lang.Exception _exception) {
                return (IdentificazioneAnnotazioneOB) org.apache.axis.utils.JavaUtils.convert(_resp, IdentificazioneAnnotazioneOB.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void inviaSegnatura(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType repositoryId, it.csi.taif.taifweb.util.service.integration.acta.common.PrincipalIdType principalId, java.lang.String origine, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType identificatoreRegistraizone, InfoMittenteIS mittente, InfoDestinatarioIS[] destinatari, java.lang.String identitaDigitale) throws java.rmi.RemoteException, it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("officialbookservice.acaris.acta.doqui.it", "inviaSegnatura"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {repositoryId, principalId, origine, identificatoreRegistraizone, mittente, destinatari, identitaDigitale});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) {
              throw (it.csi.taif.taifweb.util.service.integration.acta.common.AcarisFaultType) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
