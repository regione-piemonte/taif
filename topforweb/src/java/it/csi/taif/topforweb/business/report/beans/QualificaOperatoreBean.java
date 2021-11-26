/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.report.beans;

import java.util.Date;

public class QualificaOperatoreBean {

    
    private Integer idPersona;
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private String tipoQualifica;
    private Date dataQualifica;
    private String  agenziaFormativa;
    
    
    public Integer getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public String getTipoQualifica() {
        return tipoQualifica;
    }
    public void setTipoQualifica(String tipoQualifica) {
        this.tipoQualifica = tipoQualifica;
    }
    public Date getDataQualifica() {
        return dataQualifica;
    }
    public void setDataQualifica(Date dataQualifica) {
        this.dataQualifica = dataQualifica;
    }
    public String getAgenziaFormativa() {
        return agenziaFormativa;
    }
    public void setAgenziaFormativa(String agenziaFormativa) {
        this.agenziaFormativa = agenziaFormativa;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
   
    
    
    
}
