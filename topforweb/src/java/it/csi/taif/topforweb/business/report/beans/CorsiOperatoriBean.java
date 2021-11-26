/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.report.beans;

import java.util.Date;

public class CorsiOperatoriBean {

    
    private Integer idPersona;
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Date dataInizio;
    private Date dataFine;
    private int numeroOre;
    private String agenziaFormazione;
    private String descrizioneCorso;
    private String unitaFormativa;
    private String siglaUnitaFormativa;
    
    
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
    public Date getDataInizio() {
        return dataInizio;
    }
    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }
    public Date getDataFine() {
        return dataFine;
    }
    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }
    public int getNumeroOre() {
        return numeroOre;
    }
    public void setNumeroOre(int numeroOre) {
        this.numeroOre = numeroOre;
    }
    public String getAgenziaFormazione() {
        return agenziaFormazione;
    }
    public void setAgenziaFormazione(String agenziaFormazione) {
        this.agenziaFormazione = agenziaFormazione;
    }
    public String getDescrizioneCorso() {
        return descrizioneCorso;
    }
    public void setDescrizioneCorso(String descrizioneCorso) {
        this.descrizioneCorso = descrizioneCorso;
    }
    public String getUnitaFormativa() {
        return unitaFormativa;
    }
    public void setUnitaFormativa(String unitaFormativa) {
        this.unitaFormativa = unitaFormativa;
    }
    public String getSiglaUnitaFormativa() {
        return siglaUnitaFormativa;
    }
    public void setSiglaUnitaFormativa(String siglaUnitaFormativa) {
        this.siglaUnitaFormativa = siglaUnitaFormativa;
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
