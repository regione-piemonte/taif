/**
 * LimammEnte_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.topforweb.util.service.integration.svista;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LimammEnte_PortType extends Remote {
    public Comune[] cercaTuttiIComuni() throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Comune cercaComunePerCodiceIstat(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Comune[] cercaComuniPerIdProvincia(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Comune[] cercaComuniPerCap(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Comune cercaComunePerCodiceBelfiore(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Comune cercaComunePerIdComune(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Comune[] cercaComuniPerNome(String in0, int in1) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Comune[] cercaComuniPerNomeECodIstatProvincia(String in0, int in1, String in2) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Comune[] cercaComuniPerNomeEIdProvincia(String in0, int in1, long in2) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Provincia[] cercaTutteLeProvince() throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Provincia[] cercaProvincePerIdRegione(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Provincia cercaProvinciaPerCodiceIstat(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Provincia cercaProvinciaPerIdProvincia(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Provincia[] cercaProvincePerNome(String in0, Integer in1) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Regione[] cercaTutteLeRegioni() throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Regione cercaRegionePerIdRegione(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Regione cercaRegionePerCodIstat(String in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Regione[] cercaRegioniPerNome(String in0, int in1) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Localita[] cercaLocalitaPerIdComune(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Localita cercaLocalitaPerIdLocalita(Long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public Localita[] cercaLocalitaPerNome(String in0, int in1) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public String cercaEstensioneComune(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public String cercaGeometriaComune(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public String cercaEstensioneRegione(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public String cercaGeometriaRegione(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public String cercaEstensioneProvincia(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
    public String cercaGeometriaProvincia(long in0) throws RemoteException, UnrecoverableException, CSIException, SystemException, ParInputValNonCorrettoException, OutputException, ParInputObblMancantiException;
}
