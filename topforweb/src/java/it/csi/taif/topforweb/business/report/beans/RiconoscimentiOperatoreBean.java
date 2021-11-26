/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.report.beans;

import java.util.Date;

public class RiconoscimentiOperatoreBean {

    
    private Integer idPersona;
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Date dataRiconoscimento;
    private String unitaFormativaEquivalente;
    private String agenziaFormazione;
    
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
    public Date getDataRiconoscimento() {
        return dataRiconoscimento;
    }
    public void setDataRiconoscimento(Date dataRiconoscimento) {
        this.dataRiconoscimento = dataRiconoscimento;
    }
  
    public String getUnitaFormativaEquivalente() {
        return unitaFormativaEquivalente;
    }
    public void setUnitaFormativaEquivalente(String unitaFormativaEquivalente) {
        this.unitaFormativaEquivalente = unitaFormativaEquivalente;
    }
    public String getAgenziaFormazione() {
        return agenziaFormazione;
    }
    public void setAgenziaFormazione(String agenziaFormazione) {
        this.agenziaFormazione = agenziaFormazione;
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
