/**
 * LimammEnteSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.topforweb.util.service.integration.svista;

import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.Vector;

import javax.xml.namespace.QName;

import org.apache.axis.AxisEngine;
import org.apache.axis.AxisFault;
import org.apache.axis.NoEndPointException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;
import org.apache.axis.constants.Style;
import org.apache.axis.constants.Use;
import org.apache.axis.description.FaultDesc;
import org.apache.axis.description.OperationDesc;
import org.apache.axis.description.ParameterDesc;
import org.apache.axis.encoding.DeserializerFactory;
import org.apache.axis.encoding.SerializerFactory;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.encoding.ser.EnumDeserializerFactory;
import org.apache.axis.encoding.ser.EnumSerializerFactory;
import org.apache.axis.encoding.ser.SimpleDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListDeserializerFactory;
import org.apache.axis.encoding.ser.SimpleListSerializerFactory;
import org.apache.axis.encoding.ser.SimpleSerializerFactory;
import org.apache.axis.soap.SOAPConstants;
import org.apache.axis.utils.JavaUtils;


public class LimammEnteSoapBindingStub extends Stub implements LimammEnte_PortType {
    private Vector cachedSerClasses = new Vector();
    private Vector cachedSerQNames = new Vector();
    private Vector cachedSerFactories = new Vector();
    private Vector cachedDeserFactories = new Vector();

    static OperationDesc [] _operations;

    static {
        _operations = new OperationDesc[27];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
    }

    private static void _initOperationDesc1(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("cercaTuttiIComuni");
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune[].class);
        oper.setReturnQName(new QName("ente", "cercaTuttiIComuniReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new OperationDesc();
        oper.setName("cercaComunePerCodiceIstat");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune.class);
        oper.setReturnQName(new QName("ente", "cercaComunePerCodiceIstatReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new OperationDesc();
        oper.setName("cercaComuniPerIdProvincia");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune[].class);
        oper.setReturnQName(new QName("ente", "cercaComuniPerIdProvinciaReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new OperationDesc();
        oper.setName("cercaComuniPerCap");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune[].class);
        oper.setReturnQName(new QName("ente", "cercaComuniPerCapReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new OperationDesc();
        oper.setName("cercaComunePerCodiceBelfiore");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune.class);
        oper.setReturnQName(new QName("ente", "cercaComunePerCodiceBelfioreReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new OperationDesc();
        oper.setName("cercaComunePerIdComune");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune.class);
        oper.setReturnQName(new QName("ente", "cercaComunePerIdComuneReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new OperationDesc();
        oper.setName("cercaComuniPerNome");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("ente", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune[].class);
        oper.setReturnQName(new QName("ente", "cercaComuniPerNomeReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new OperationDesc();
        oper.setName("cercaComuniPerNomeECodIstatProvincia");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("ente", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("ente", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune[].class);
        oper.setReturnQName(new QName("ente", "cercaComuniPerNomeECodIstatProvinciaReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new OperationDesc();
        oper.setName("cercaComuniPerNomeEIdProvincia");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("ente", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("ente", "in2"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Comune"));
        oper.setReturnClass(Comune[].class);
        oper.setReturnQName(new QName("ente", "cercaComuniPerNomeEIdProvinciaReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new OperationDesc();
        oper.setName("cercaTutteLeProvince");
        oper.setReturnType(new QName("ente", "Provincia"));
        oper.setReturnClass(Provincia[].class);
        oper.setReturnQName(new QName("ente", "cercaTutteLeProvinceReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("cercaProvincePerIdRegione");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Provincia"));
        oper.setReturnClass(Provincia[].class);
        oper.setReturnQName(new QName("ente", "cercaProvincePerIdRegioneReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new OperationDesc();
        oper.setName("cercaProvinciaPerCodiceIstat");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Provincia"));
        oper.setReturnClass(Provincia.class);
        oper.setReturnQName(new QName("ente", "cercaProvinciaPerCodiceIstatReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new OperationDesc();
        oper.setName("cercaProvinciaPerIdProvincia");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Provincia"));
        oper.setReturnClass(Provincia.class);
        oper.setReturnQName(new QName("ente", "cercaProvinciaPerIdProvinciaReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new OperationDesc();
        oper.setName("cercaProvincePerNome");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("ente", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), Integer.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Provincia"));
        oper.setReturnClass(Provincia[].class);
        oper.setReturnQName(new QName("ente", "cercaProvincePerNomeReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new OperationDesc();
        oper.setName("cercaTutteLeRegioni");
        oper.setReturnType(new QName("ente", "Regione"));
        oper.setReturnClass(Regione[].class);
        oper.setReturnQName(new QName("ente", "cercaTutteLeRegioniReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new OperationDesc();
        oper.setName("cercaRegionePerIdRegione");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Regione"));
        oper.setReturnClass(Regione.class);
        oper.setReturnQName(new QName("ente", "cercaRegionePerIdRegioneReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new OperationDesc();
        oper.setName("cercaRegionePerCodIstat");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Regione"));
        oper.setReturnClass(Regione.class);
        oper.setReturnQName(new QName("ente", "cercaRegionePerCodIstatReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new OperationDesc();
        oper.setName("cercaRegioniPerNome");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("ente", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Regione"));
        oper.setReturnClass(Regione[].class);
        oper.setReturnQName(new QName("ente", "cercaRegioniPerNomeReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[17] = oper;

        oper = new OperationDesc();
        oper.setName("cercaLocalitaPerIdComune");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Localita"));
        oper.setReturnClass(Localita[].class);
        oper.setReturnQName(new QName("ente", "cercaLocalitaPerIdComuneReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[18] = oper;

        oper = new OperationDesc();
        oper.setName("cercaLocalitaPerIdLocalita");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), Long.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Localita"));
        oper.setReturnClass(Localita.class);
        oper.setReturnQName(new QName("ente", "cercaLocalitaPerIdLocalitaReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        OperationDesc oper;
        ParameterDesc param;
        oper = new OperationDesc();
        oper.setName("cercaLocalitaPerNome");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "string"), String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new ParameterDesc(new QName("ente", "in1"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("ente", "Localita"));
        oper.setReturnClass(Localita[].class);
        oper.setReturnQName(new QName("ente", "cercaLocalitaPerNomeReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[20] = oper;

        oper = new OperationDesc();
        oper.setName("cercaEstensioneComune");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("ente", "cercaEstensioneComuneReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[21] = oper;

        oper = new OperationDesc();
        oper.setName("cercaGeometriaComune");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("ente", "cercaGeometriaComuneReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[22] = oper;

        oper = new OperationDesc();
        oper.setName("cercaEstensioneRegione");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("ente", "cercaEstensioneRegioneReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[23] = oper;

        oper = new OperationDesc();
        oper.setName("cercaGeometriaRegione");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("ente", "cercaGeometriaRegioneReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[24] = oper;

        oper = new OperationDesc();
        oper.setName("cercaEstensioneProvincia");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("ente", "cercaEstensioneProvinciaReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[25] = oper;

        oper = new OperationDesc();
        oper.setName("cercaGeometriaProvincia");
        param = new ParameterDesc(new QName("ente", "in0"), ParameterDesc.IN, new QName("http://www.w3.org/2001/XMLSchema", "long"), long.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(String.class);
        oper.setReturnQName(new QName("ente", "cercaGeometriaProvinciaReturn"));
        oper.setStyle(Style.WRAPPED);
        oper.setUse(Use.LITERAL);
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault2"),
                      "UnrecoverableException",
                      new QName("ente", "UnrecoverableException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault"),
                      "CSIException",
                      new QName("ente", "CSIException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault1"),
                      "SystemException",
                      new QName("ente", "SystemException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault5"),
                      "ParInputValNonCorrettoException",
                      new QName("ente", "ParInputValNonCorrettoException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault3"),
                      "OutputException",
                      new QName("ente", "OutputException"), 
                      true
                     ));
        oper.addFault(new FaultDesc(
                      new QName("ente", "fault4"),
                      "ParInputObblMancantiException",
                      new QName("ente", "ParInputObblMancantiException"), 
                      true
                     ));
        _operations[26] = oper;

    }

    public LimammEnteSoapBindingStub() throws AxisFault {
         this(null);
    }

    public LimammEnteSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public LimammEnteSoapBindingStub(javax.xml.rpc.Service service) throws AxisFault {
        if (service == null) {
            super.service = new Service();
        } else {
            super.service = service;
        }
        ((Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            QName qName;
            QName qName2;
            Class beansf = BeanSerializerFactory.class;
            Class beandf = BeanDeserializerFactory.class;
            Class enumsf = EnumSerializerFactory.class;
            Class enumdf = EnumDeserializerFactory.class;
            Class arraysf = ArraySerializerFactory.class;
            Class arraydf = ArrayDeserializerFactory.class;
            Class simplesf = SimpleSerializerFactory.class;
            Class simpledf = SimpleDeserializerFactory.class;
            Class simplelistsf = SimpleListSerializerFactory.class;
            Class simplelistdf = SimpleListDeserializerFactory.class;
            qName = new QName("ente", "ArrayOfAsl");
            cachedSerQNames.add(qName);
            cls = Asl[].class;
            cachedSerClasses.add(cls);
            qName = new QName("ente", "Asl");
            qName2 = new QName("ente", "item");
            cachedSerFactories.add(new ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new ArrayDeserializerFactory());

            qName = new QName("ente", "Asl");
            cachedSerQNames.add(qName);
            cls = Asl.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "Comune");
            cachedSerQNames.add(qName);
            cls = Comune.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "CSIException");
            cachedSerQNames.add(qName);
            cls = CSIException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "Localita");
            cachedSerQNames.add(qName);
            cls = Localita.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "OutputException");
            cachedSerQNames.add(qName);
            cls = OutputException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "ParInputObblMancantiException");
            cachedSerQNames.add(qName);
            cls = ParInputObblMancantiException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "ParInputValNonCorrettoException");
            cachedSerQNames.add(qName);
            cls = ParInputValNonCorrettoException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "Provincia");
            cachedSerQNames.add(qName);
            cls = Provincia.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "Regione");
            cachedSerQNames.add(qName);
            cls = Regione.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "SystemException");
            cachedSerQNames.add(qName);
            cls = SystemException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "UnrecoverableException");
            cachedSerQNames.add(qName);
            cls = UnrecoverableException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new QName("ente", "UserException");
            cachedSerQNames.add(qName);
            cls = UserException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected Call createCall() throws RemoteException {
        try {
            Call _call = super._createCall();
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
            Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
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
                        Class cls = (Class) cachedSerClasses.get(i);
                        QName qName =
                                (QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof SerializerFactory) {
                            SerializerFactory sf = (SerializerFactory)
                                 cachedSerFactories.get(i);
                            DeserializerFactory df = (DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public Comune[] cercaTuttiIComuni() throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaTuttiIComuni"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune[]) _resp;
            } catch (Exception _exception) {
                return (Comune[]) JavaUtils.convert(_resp, Comune[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Comune cercaComunePerCodiceIstat(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaComunePerCodiceIstat"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune) _resp;
            } catch (Exception _exception) {
                return (Comune) JavaUtils.convert(_resp, Comune.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Comune[] cercaComuniPerIdProvincia(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaComuniPerIdProvincia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune[]) _resp;
            } catch (Exception _exception) {
                return (Comune[]) JavaUtils.convert(_resp, Comune[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Comune[] cercaComuniPerCap(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaComuniPerCap"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune[]) _resp;
            } catch (Exception _exception) {
                return (Comune[]) JavaUtils.convert(_resp, Comune[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Comune cercaComunePerCodiceBelfiore(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaComunePerCodiceBelfiore"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune) _resp;
            } catch (Exception _exception) {
                return (Comune) JavaUtils.convert(_resp, Comune.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Comune cercaComunePerIdComune(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaComunePerIdComune"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune) _resp;
            } catch (Exception _exception) {
                return (Comune) JavaUtils.convert(_resp, Comune.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Comune[] cercaComuniPerNome(String in0, int in1) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaComuniPerNome"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0, new Integer(in1)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune[]) _resp;
            } catch (Exception _exception) {
                return (Comune[]) JavaUtils.convert(_resp, Comune[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Comune[] cercaComuniPerNomeECodIstatProvincia(String in0, int in1, String in2) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaComuniPerNomeECodIstatProvincia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0, new Integer(in1), in2});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune[]) _resp;
            } catch (Exception _exception) {
                return (Comune[]) JavaUtils.convert(_resp, Comune[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Comune[] cercaComuniPerNomeEIdProvincia(String in0, int in1, long in2) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaComuniPerNomeEIdProvincia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0, new Integer(in1), new Long(in2)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Comune[]) _resp;
            } catch (Exception _exception) {
                return (Comune[]) JavaUtils.convert(_resp, Comune[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Provincia[] cercaTutteLeProvince() throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaTutteLeProvince"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Provincia[]) _resp;
            } catch (Exception _exception) {
                return (Provincia[]) JavaUtils.convert(_resp, Provincia[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Provincia[] cercaProvincePerIdRegione(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaProvincePerIdRegione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {new Long(in0)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Provincia[]) _resp;
            } catch (Exception _exception) {
                return (Provincia[]) JavaUtils.convert(_resp, Provincia[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Provincia cercaProvinciaPerCodiceIstat(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaProvinciaPerCodiceIstat"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Provincia) _resp;
            } catch (Exception _exception) {
                return (Provincia) JavaUtils.convert(_resp, Provincia.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Provincia cercaProvinciaPerIdProvincia(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaProvinciaPerIdProvincia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Provincia) _resp;
            } catch (Exception _exception) {
                return (Provincia) JavaUtils.convert(_resp, Provincia.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Provincia[] cercaProvincePerNome(String in0, Integer in1) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaProvincePerNome"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0, in1});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Provincia[]) _resp;
            } catch (Exception _exception) {
                return (Provincia[]) JavaUtils.convert(_resp, Provincia[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Regione[] cercaTutteLeRegioni() throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaTutteLeRegioni"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Regione[]) _resp;
            } catch (Exception _exception) {
                return (Regione[]) JavaUtils.convert(_resp, Regione[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Regione cercaRegionePerIdRegione(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaRegionePerIdRegione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Regione) _resp;
            } catch (Exception _exception) {
                return (Regione) JavaUtils.convert(_resp, Regione.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Regione cercaRegionePerCodIstat(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaRegionePerCodIstat"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Regione) _resp;
            } catch (Exception _exception) {
                return (Regione) JavaUtils.convert(_resp, Regione.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Regione[] cercaRegioniPerNome(String in0, int in1) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaRegioniPerNome"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0, new Integer(in1)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Regione[]) _resp;
            } catch (Exception _exception) {
                return (Regione[]) JavaUtils.convert(_resp, Regione[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Localita[] cercaLocalitaPerIdComune(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaLocalitaPerIdComune"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Localita[]) _resp;
            } catch (Exception _exception) {
                return (Localita[]) JavaUtils.convert(_resp, Localita[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Localita cercaLocalitaPerIdLocalita(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaLocalitaPerIdLocalita"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Localita) _resp;
            } catch (Exception _exception) {
                return (Localita) JavaUtils.convert(_resp, Localita.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public Localita[] cercaLocalitaPerNome(String in0, int in1) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaLocalitaPerNome"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {in0, new Integer(in1)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (Localita[]) _resp;
            } catch (Exception _exception) {
                return (Localita[]) JavaUtils.convert(_resp, Localita[].class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public String cercaEstensioneComune(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaEstensioneComune"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {new Long(in0)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public String cercaGeometriaComune(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaGeometriaComune"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {new Long(in0)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public String cercaEstensioneRegione(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaEstensioneRegione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {new Long(in0)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public String cercaGeometriaRegione(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaGeometriaRegione"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {new Long(in0)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public String cercaEstensioneProvincia(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaEstensioneProvincia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {new Long(in0)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public String cercaGeometriaProvincia(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException {
        if (super.cachedEndpoint == null) {
            throw new NoEndPointException();
        }
        Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new QName("ente", "cercaGeometriaProvincia"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {new Long(in0)});

        if (_resp instanceof RemoteException) {
            throw (RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (String) _resp;
            } catch (Exception _exception) {
                return (String) JavaUtils.convert(_resp, String.class);
            }
        }
  } catch (AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof RemoteException) {
              throw (RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof UnrecoverableException) {
              throw (UnrecoverableException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof CSIException) {
              throw (CSIException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof SystemException) {
              throw (SystemException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputValNonCorrettoException) {
              throw (ParInputValNonCorrettoException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof OutputException) {
              throw (OutputException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ParInputObblMancantiException) {
              throw (ParInputObblMancantiException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
