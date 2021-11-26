/**
 * SoggettoPropertiesType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.csi.taif.taifweb.util.service.integration.acta.subjectregistryservice;

public class SoggettoPropertiesType  extends SubjectRegistryPropertiesType  implements java.io.Serializable {
    private java.lang.String uuid;

    private java.util.Date dataInizioValidita;

    private java.util.Date dataFineValidita;

    private java.lang.String stato;

    private java.lang.String chiaveEsterna;

    private boolean internoEnte;

    private java.lang.String pfPgUl;

    private java.util.Date[] dataAccorpamento;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idEnteAppartenenza;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAOOAppartenenza;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idUtenteCreazione;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAooAssociata;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idStrutturaAssociata;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idNodoAssociato;

    private it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType[] categoriaAnagrafica;

    private it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType codiceFonte;

    private it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoSoggettoOrigine;

    private it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoSoggettoAppartenenza;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggettoPadre;

    private java.lang.String nome;

    private java.lang.String cognome;

    private java.lang.String denominazione;

    private java.lang.String codice;

    private java.lang.String codiceFiscale;

    private java.lang.String email;

    private java.lang.String emailPEC;

    private java.lang.String partitaIVA;

    private java.lang.String[] fax;

    private java.lang.String[] telefono;

    private boolean ente;

    private boolean aoo;

    private java.lang.String matricola;

    private java.util.Date dataNascita;

    private java.lang.String luogoNascita;

    private java.lang.String note;

    private java.lang.String denominazioneNormalizzata;

    private it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType[] idIndirizzo;

    public SoggettoPropertiesType() {
    }

    public SoggettoPropertiesType(
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType objectId,
           it.csi.taif.taifweb.util.service.integration.acta.common.ChangeTokenType changeToken,
           java.lang.String objectTypeId,
           java.lang.String uuid,
           java.util.Date dataInizioValidita,
           java.util.Date dataFineValidita,
           java.lang.String stato,
           java.lang.String chiaveEsterna,
           boolean internoEnte,
           java.lang.String pfPgUl,
           java.util.Date[] dataAccorpamento,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idEnteAppartenenza,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAOOAppartenenza,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idUtenteCreazione,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAooAssociata,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idStrutturaAssociata,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idNodoAssociato,
           it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType[] categoriaAnagrafica,
           it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType codiceFonte,
           it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoSoggettoOrigine,
           it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoSoggettoAppartenenza,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggettoPadre,
           java.lang.String nome,
           java.lang.String cognome,
           java.lang.String denominazione,
           java.lang.String codice,
           java.lang.String codiceFiscale,
           java.lang.String email,
           java.lang.String emailPEC,
           java.lang.String partitaIVA,
           java.lang.String[] fax,
           java.lang.String[] telefono,
           boolean ente,
           boolean aoo,
           java.lang.String matricola,
           java.util.Date dataNascita,
           java.lang.String luogoNascita,
           java.lang.String note,
           java.lang.String denominazioneNormalizzata,
           it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType[] idIndirizzo) {
        super(
            objectId,
            changeToken,
            objectTypeId);
        this.uuid = uuid;
        this.dataInizioValidita = dataInizioValidita;
        this.dataFineValidita = dataFineValidita;
        this.stato = stato;
        this.chiaveEsterna = chiaveEsterna;
        this.internoEnte = internoEnte;
        this.pfPgUl = pfPgUl;
        this.dataAccorpamento = dataAccorpamento;
        this.idEnteAppartenenza = idEnteAppartenenza;
        this.idAOOAppartenenza = idAOOAppartenenza;
        this.idUtenteCreazione = idUtenteCreazione;
        this.idAooAssociata = idAooAssociata;
        this.idStrutturaAssociata = idStrutturaAssociata;
        this.idNodoAssociato = idNodoAssociato;
        this.categoriaAnagrafica = categoriaAnagrafica;
        this.codiceFonte = codiceFonte;
        this.tipoSoggettoOrigine = tipoSoggettoOrigine;
        this.tipoSoggettoAppartenenza = tipoSoggettoAppartenenza;
        this.idSoggettoPadre = idSoggettoPadre;
        this.nome = nome;
        this.cognome = cognome;
        this.denominazione = denominazione;
        this.codice = codice;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
        this.emailPEC = emailPEC;
        this.partitaIVA = partitaIVA;
        this.fax = fax;
        this.telefono = telefono;
        this.ente = ente;
        this.aoo = aoo;
        this.matricola = matricola;
        this.dataNascita = dataNascita;
        this.luogoNascita = luogoNascita;
        this.note = note;
        this.denominazioneNormalizzata = denominazioneNormalizzata;
        this.idIndirizzo = idIndirizzo;
    }


    /**
     * Gets the uuid value for this SoggettoPropertiesType.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this SoggettoPropertiesType.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
    }


    /**
     * Gets the dataInizioValidita value for this SoggettoPropertiesType.
     * 
     * @return dataInizioValidita
     */
    public java.util.Date getDataInizioValidita() {
        return dataInizioValidita;
    }


    /**
     * Sets the dataInizioValidita value for this SoggettoPropertiesType.
     * 
     * @param dataInizioValidita
     */
    public void setDataInizioValidita(java.util.Date dataInizioValidita) {
        this.dataInizioValidita = dataInizioValidita;
    }


    /**
     * Gets the dataFineValidita value for this SoggettoPropertiesType.
     * 
     * @return dataFineValidita
     */
    public java.util.Date getDataFineValidita() {
        return dataFineValidita;
    }


    /**
     * Sets the dataFineValidita value for this SoggettoPropertiesType.
     * 
     * @param dataFineValidita
     */
    public void setDataFineValidita(java.util.Date dataFineValidita) {
        this.dataFineValidita = dataFineValidita;
    }


    /**
     * Gets the stato value for this SoggettoPropertiesType.
     * 
     * @return stato
     */
    public java.lang.String getStato() {
        return stato;
    }


    /**
     * Sets the stato value for this SoggettoPropertiesType.
     * 
     * @param stato
     */
    public void setStato(java.lang.String stato) {
        this.stato = stato;
    }


    /**
     * Gets the chiaveEsterna value for this SoggettoPropertiesType.
     * 
     * @return chiaveEsterna
     */
    public java.lang.String getChiaveEsterna() {
        return chiaveEsterna;
    }


    /**
     * Sets the chiaveEsterna value for this SoggettoPropertiesType.
     * 
     * @param chiaveEsterna
     */
    public void setChiaveEsterna(java.lang.String chiaveEsterna) {
        this.chiaveEsterna = chiaveEsterna;
    }


    /**
     * Gets the internoEnte value for this SoggettoPropertiesType.
     * 
     * @return internoEnte
     */
    public boolean isInternoEnte() {
        return internoEnte;
    }


    /**
     * Sets the internoEnte value for this SoggettoPropertiesType.
     * 
     * @param internoEnte
     */
    public void setInternoEnte(boolean internoEnte) {
        this.internoEnte = internoEnte;
    }


    /**
     * Gets the pfPgUl value for this SoggettoPropertiesType.
     * 
     * @return pfPgUl
     */
    public java.lang.String getPfPgUl() {
        return pfPgUl;
    }


    /**
     * Sets the pfPgUl value for this SoggettoPropertiesType.
     * 
     * @param pfPgUl
     */
    public void setPfPgUl(java.lang.String pfPgUl) {
        this.pfPgUl = pfPgUl;
    }


    /**
     * Gets the dataAccorpamento value for this SoggettoPropertiesType.
     * 
     * @return dataAccorpamento
     */
    public java.util.Date[] getDataAccorpamento() {
        return dataAccorpamento;
    }


    /**
     * Sets the dataAccorpamento value for this SoggettoPropertiesType.
     * 
     * @param dataAccorpamento
     */
    public void setDataAccorpamento(java.util.Date[] dataAccorpamento) {
        this.dataAccorpamento = dataAccorpamento;
    }

    public java.util.Date getDataAccorpamento(int i) {
        return this.dataAccorpamento[i];
    }

    public void setDataAccorpamento(int i, java.util.Date _value) {
        this.dataAccorpamento[i] = _value;
    }


    /**
     * Gets the idEnteAppartenenza value for this SoggettoPropertiesType.
     * 
     * @return idEnteAppartenenza
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdEnteAppartenenza() {
        return idEnteAppartenenza;
    }


    /**
     * Sets the idEnteAppartenenza value for this SoggettoPropertiesType.
     * 
     * @param idEnteAppartenenza
     */
    public void setIdEnteAppartenenza(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idEnteAppartenenza) {
        this.idEnteAppartenenza = idEnteAppartenenza;
    }


    /**
     * Gets the idAOOAppartenenza value for this SoggettoPropertiesType.
     * 
     * @return idAOOAppartenenza
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdAOOAppartenenza() {
        return idAOOAppartenenza;
    }


    /**
     * Sets the idAOOAppartenenza value for this SoggettoPropertiesType.
     * 
     * @param idAOOAppartenenza
     */
    public void setIdAOOAppartenenza(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAOOAppartenenza) {
        this.idAOOAppartenenza = idAOOAppartenenza;
    }


    /**
     * Gets the idUtenteCreazione value for this SoggettoPropertiesType.
     * 
     * @return idUtenteCreazione
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdUtenteCreazione() {
        return idUtenteCreazione;
    }


    /**
     * Sets the idUtenteCreazione value for this SoggettoPropertiesType.
     * 
     * @param idUtenteCreazione
     */
    public void setIdUtenteCreazione(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idUtenteCreazione) {
        this.idUtenteCreazione = idUtenteCreazione;
    }


    /**
     * Gets the idAooAssociata value for this SoggettoPropertiesType.
     * 
     * @return idAooAssociata
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdAooAssociata() {
        return idAooAssociata;
    }


    /**
     * Sets the idAooAssociata value for this SoggettoPropertiesType.
     * 
     * @param idAooAssociata
     */
    public void setIdAooAssociata(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idAooAssociata) {
        this.idAooAssociata = idAooAssociata;
    }


    /**
     * Gets the idStrutturaAssociata value for this SoggettoPropertiesType.
     * 
     * @return idStrutturaAssociata
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdStrutturaAssociata() {
        return idStrutturaAssociata;
    }


    /**
     * Sets the idStrutturaAssociata value for this SoggettoPropertiesType.
     * 
     * @param idStrutturaAssociata
     */
    public void setIdStrutturaAssociata(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idStrutturaAssociata) {
        this.idStrutturaAssociata = idStrutturaAssociata;
    }


    /**
     * Gets the idNodoAssociato value for this SoggettoPropertiesType.
     * 
     * @return idNodoAssociato
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdNodoAssociato() {
        return idNodoAssociato;
    }


    /**
     * Sets the idNodoAssociato value for this SoggettoPropertiesType.
     * 
     * @param idNodoAssociato
     */
    public void setIdNodoAssociato(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idNodoAssociato) {
        this.idNodoAssociato = idNodoAssociato;
    }


    /**
     * Gets the categoriaAnagrafica value for this SoggettoPropertiesType.
     * 
     * @return categoriaAnagrafica
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType[] getCategoriaAnagrafica() {
        return categoriaAnagrafica;
    }


    /**
     * Sets the categoriaAnagrafica value for this SoggettoPropertiesType.
     * 
     * @param categoriaAnagrafica
     */
    public void setCategoriaAnagrafica(it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType[] categoriaAnagrafica) {
        this.categoriaAnagrafica = categoriaAnagrafica;
    }

    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType getCategoriaAnagrafica(int i) {
        return this.categoriaAnagrafica[i];
    }

    public void setCategoriaAnagrafica(int i, it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType _value) {
        this.categoriaAnagrafica[i] = _value;
    }


    /**
     * Gets the codiceFonte value for this SoggettoPropertiesType.
     * 
     * @return codiceFonte
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType getCodiceFonte() {
        return codiceFonte;
    }


    /**
     * Sets the codiceFonte value for this SoggettoPropertiesType.
     * 
     * @param codiceFonte
     */
    public void setCodiceFonte(it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType codiceFonte) {
        this.codiceFonte = codiceFonte;
    }


    /**
     * Gets the tipoSoggettoOrigine value for this SoggettoPropertiesType.
     * 
     * @return tipoSoggettoOrigine
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType getTipoSoggettoOrigine() {
        return tipoSoggettoOrigine;
    }


    /**
     * Sets the tipoSoggettoOrigine value for this SoggettoPropertiesType.
     * 
     * @param tipoSoggettoOrigine
     */
    public void setTipoSoggettoOrigine(it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoSoggettoOrigine) {
        this.tipoSoggettoOrigine = tipoSoggettoOrigine;
    }


    /**
     * Gets the tipoSoggettoAppartenenza value for this SoggettoPropertiesType.
     * 
     * @return tipoSoggettoAppartenenza
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType getTipoSoggettoAppartenenza() {
        return tipoSoggettoAppartenenza;
    }


    /**
     * Sets the tipoSoggettoAppartenenza value for this SoggettoPropertiesType.
     * 
     * @param tipoSoggettoAppartenenza
     */
    public void setTipoSoggettoAppartenenza(it.csi.taif.taifweb.util.service.integration.acta.common.DecodificaType tipoSoggettoAppartenenza) {
        this.tipoSoggettoAppartenenza = tipoSoggettoAppartenenza;
    }


    /**
     * Gets the idSoggettoPadre value for this SoggettoPropertiesType.
     * 
     * @return idSoggettoPadre
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdSoggettoPadre() {
        return idSoggettoPadre;
    }


    /**
     * Sets the idSoggettoPadre value for this SoggettoPropertiesType.
     * 
     * @param idSoggettoPadre
     */
    public void setIdSoggettoPadre(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType idSoggettoPadre) {
        this.idSoggettoPadre = idSoggettoPadre;
    }


    /**
     * Gets the nome value for this SoggettoPropertiesType.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this SoggettoPropertiesType.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the cognome value for this SoggettoPropertiesType.
     * 
     * @return cognome
     */
    public java.lang.String getCognome() {
        return cognome;
    }


    /**
     * Sets the cognome value for this SoggettoPropertiesType.
     * 
     * @param cognome
     */
    public void setCognome(java.lang.String cognome) {
        this.cognome = cognome;
    }


    /**
     * Gets the denominazione value for this SoggettoPropertiesType.
     * 
     * @return denominazione
     */
    public java.lang.String getDenominazione() {
        return denominazione;
    }


    /**
     * Sets the denominazione value for this SoggettoPropertiesType.
     * 
     * @param denominazione
     */
    public void setDenominazione(java.lang.String denominazione) {
        this.denominazione = denominazione;
    }


    /**
     * Gets the codice value for this SoggettoPropertiesType.
     * 
     * @return codice
     */
    public java.lang.String getCodice() {
        return codice;
    }


    /**
     * Sets the codice value for this SoggettoPropertiesType.
     * 
     * @param codice
     */
    public void setCodice(java.lang.String codice) {
        this.codice = codice;
    }


    /**
     * Gets the codiceFiscale value for this SoggettoPropertiesType.
     * 
     * @return codiceFiscale
     */
    public java.lang.String getCodiceFiscale() {
        return codiceFiscale;
    }


    /**
     * Sets the codiceFiscale value for this SoggettoPropertiesType.
     * 
     * @param codiceFiscale
     */
    public void setCodiceFiscale(java.lang.String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }


    /**
     * Gets the email value for this SoggettoPropertiesType.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this SoggettoPropertiesType.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the emailPEC value for this SoggettoPropertiesType.
     * 
     * @return emailPEC
     */
    public java.lang.String getEmailPEC() {
        return emailPEC;
    }


    /**
     * Sets the emailPEC value for this SoggettoPropertiesType.
     * 
     * @param emailPEC
     */
    public void setEmailPEC(java.lang.String emailPEC) {
        this.emailPEC = emailPEC;
    }


    /**
     * Gets the partitaIVA value for this SoggettoPropertiesType.
     * 
     * @return partitaIVA
     */
    public java.lang.String getPartitaIVA() {
        return partitaIVA;
    }


    /**
     * Sets the partitaIVA value for this SoggettoPropertiesType.
     * 
     * @param partitaIVA
     */
    public void setPartitaIVA(java.lang.String partitaIVA) {
        this.partitaIVA = partitaIVA;
    }


    /**
     * Gets the fax value for this SoggettoPropertiesType.
     * 
     * @return fax
     */
    public java.lang.String[] getFax() {
        return fax;
    }


    /**
     * Sets the fax value for this SoggettoPropertiesType.
     * 
     * @param fax
     */
    public void setFax(java.lang.String[] fax) {
        this.fax = fax;
    }

    public java.lang.String getFax(int i) {
        return this.fax[i];
    }

    public void setFax(int i, java.lang.String _value) {
        this.fax[i] = _value;
    }


    /**
     * Gets the telefono value for this SoggettoPropertiesType.
     * 
     * @return telefono
     */
    public java.lang.String[] getTelefono() {
        return telefono;
    }


    /**
     * Sets the telefono value for this SoggettoPropertiesType.
     * 
     * @param telefono
     */
    public void setTelefono(java.lang.String[] telefono) {
        this.telefono = telefono;
    }

    public java.lang.String getTelefono(int i) {
        return this.telefono[i];
    }

    public void setTelefono(int i, java.lang.String _value) {
        this.telefono[i] = _value;
    }


    /**
     * Gets the ente value for this SoggettoPropertiesType.
     * 
     * @return ente
     */
    public boolean isEnte() {
        return ente;
    }


    /**
     * Sets the ente value for this SoggettoPropertiesType.
     * 
     * @param ente
     */
    public void setEnte(boolean ente) {
        this.ente = ente;
    }


    /**
     * Gets the aoo value for this SoggettoPropertiesType.
     * 
     * @return aoo
     */
    public boolean isAoo() {
        return aoo;
    }


    /**
     * Sets the aoo value for this SoggettoPropertiesType.
     * 
     * @param aoo
     */
    public void setAoo(boolean aoo) {
        this.aoo = aoo;
    }


    /**
     * Gets the matricola value for this SoggettoPropertiesType.
     * 
     * @return matricola
     */
    public java.lang.String getMatricola() {
        return matricola;
    }


    /**
     * Sets the matricola value for this SoggettoPropertiesType.
     * 
     * @param matricola
     */
    public void setMatricola(java.lang.String matricola) {
        this.matricola = matricola;
    }


    /**
     * Gets the dataNascita value for this SoggettoPropertiesType.
     * 
     * @return dataNascita
     */
    public java.util.Date getDataNascita() {
        return dataNascita;
    }


    /**
     * Sets the dataNascita value for this SoggettoPropertiesType.
     * 
     * @param dataNascita
     */
    public void setDataNascita(java.util.Date dataNascita) {
        this.dataNascita = dataNascita;
    }


    /**
     * Gets the luogoNascita value for this SoggettoPropertiesType.
     * 
     * @return luogoNascita
     */
    public java.lang.String getLuogoNascita() {
        return luogoNascita;
    }


    /**
     * Sets the luogoNascita value for this SoggettoPropertiesType.
     * 
     * @param luogoNascita
     */
    public void setLuogoNascita(java.lang.String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }


    /**
     * Gets the note value for this SoggettoPropertiesType.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this SoggettoPropertiesType.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the denominazioneNormalizzata value for this SoggettoPropertiesType.
     * 
     * @return denominazioneNormalizzata
     */
    public java.lang.String getDenominazioneNormalizzata() {
        return denominazioneNormalizzata;
    }


    /**
     * Sets the denominazioneNormalizzata value for this SoggettoPropertiesType.
     * 
     * @param denominazioneNormalizzata
     */
    public void setDenominazioneNormalizzata(java.lang.String denominazioneNormalizzata) {
        this.denominazioneNormalizzata = denominazioneNormalizzata;
    }


    /**
     * Gets the idIndirizzo value for this SoggettoPropertiesType.
     * 
     * @return idIndirizzo
     */
    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType[] getIdIndirizzo() {
        return idIndirizzo;
    }


    /**
     * Sets the idIndirizzo value for this SoggettoPropertiesType.
     * 
     * @param idIndirizzo
     */
    public void setIdIndirizzo(it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType[] idIndirizzo) {
        this.idIndirizzo = idIndirizzo;
    }

    public it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType getIdIndirizzo(int i) {
        return this.idIndirizzo[i];
    }

    public void setIdIndirizzo(int i, it.csi.taif.taifweb.util.service.integration.acta.common.ObjectIdType _value) {
        this.idIndirizzo[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SoggettoPropertiesType)) return false;
        SoggettoPropertiesType other = (SoggettoPropertiesType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.uuid==null && other.getUuid()==null) || 
             (this.uuid!=null &&
              this.uuid.equals(other.getUuid()))) &&
            ((this.dataInizioValidita==null && other.getDataInizioValidita()==null) || 
             (this.dataInizioValidita!=null &&
              this.dataInizioValidita.equals(other.getDataInizioValidita()))) &&
            ((this.dataFineValidita==null && other.getDataFineValidita()==null) || 
             (this.dataFineValidita!=null &&
              this.dataFineValidita.equals(other.getDataFineValidita()))) &&
            ((this.stato==null && other.getStato()==null) || 
             (this.stato!=null &&
              this.stato.equals(other.getStato()))) &&
            ((this.chiaveEsterna==null && other.getChiaveEsterna()==null) || 
             (this.chiaveEsterna!=null &&
              this.chiaveEsterna.equals(other.getChiaveEsterna()))) &&
            this.internoEnte == other.isInternoEnte() &&
            ((this.pfPgUl==null && other.getPfPgUl()==null) || 
             (this.pfPgUl!=null &&
              this.pfPgUl.equals(other.getPfPgUl()))) &&
            ((this.dataAccorpamento==null && other.getDataAccorpamento()==null) || 
             (this.dataAccorpamento!=null &&
              java.util.Arrays.equals(this.dataAccorpamento, other.getDataAccorpamento()))) &&
            ((this.idEnteAppartenenza==null && other.getIdEnteAppartenenza()==null) || 
             (this.idEnteAppartenenza!=null &&
              this.idEnteAppartenenza.equals(other.getIdEnteAppartenenza()))) &&
            ((this.idAOOAppartenenza==null && other.getIdAOOAppartenenza()==null) || 
             (this.idAOOAppartenenza!=null &&
              this.idAOOAppartenenza.equals(other.getIdAOOAppartenenza()))) &&
            ((this.idUtenteCreazione==null && other.getIdUtenteCreazione()==null) || 
             (this.idUtenteCreazione!=null &&
              this.idUtenteCreazione.equals(other.getIdUtenteCreazione()))) &&
            ((this.idAooAssociata==null && other.getIdAooAssociata()==null) || 
             (this.idAooAssociata!=null &&
              this.idAooAssociata.equals(other.getIdAooAssociata()))) &&
            ((this.idStrutturaAssociata==null && other.getIdStrutturaAssociata()==null) || 
             (this.idStrutturaAssociata!=null &&
              this.idStrutturaAssociata.equals(other.getIdStrutturaAssociata()))) &&
            ((this.idNodoAssociato==null && other.getIdNodoAssociato()==null) || 
             (this.idNodoAssociato!=null &&
              this.idNodoAssociato.equals(other.getIdNodoAssociato()))) &&
            ((this.categoriaAnagrafica==null && other.getCategoriaAnagrafica()==null) || 
             (this.categoriaAnagrafica!=null &&
              java.util.Arrays.equals(this.categoriaAnagrafica, other.getCategoriaAnagrafica()))) &&
            ((this.codiceFonte==null && other.getCodiceFonte()==null) || 
             (this.codiceFonte!=null &&
              this.codiceFonte.equals(other.getCodiceFonte()))) &&
            ((this.tipoSoggettoOrigine==null && other.getTipoSoggettoOrigine()==null) || 
             (this.tipoSoggettoOrigine!=null &&
              this.tipoSoggettoOrigine.equals(other.getTipoSoggettoOrigine()))) &&
            ((this.tipoSoggettoAppartenenza==null && other.getTipoSoggettoAppartenenza()==null) || 
             (this.tipoSoggettoAppartenenza!=null &&
              this.tipoSoggettoAppartenenza.equals(other.getTipoSoggettoAppartenenza()))) &&
            ((this.idSoggettoPadre==null && other.getIdSoggettoPadre()==null) || 
             (this.idSoggettoPadre!=null &&
              this.idSoggettoPadre.equals(other.getIdSoggettoPadre()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.cognome==null && other.getCognome()==null) || 
             (this.cognome!=null &&
              this.cognome.equals(other.getCognome()))) &&
            ((this.denominazione==null && other.getDenominazione()==null) || 
             (this.denominazione!=null &&
              this.denominazione.equals(other.getDenominazione()))) &&
            ((this.codice==null && other.getCodice()==null) || 
             (this.codice!=null &&
              this.codice.equals(other.getCodice()))) &&
            ((this.codiceFiscale==null && other.getCodiceFiscale()==null) || 
             (this.codiceFiscale!=null &&
              this.codiceFiscale.equals(other.getCodiceFiscale()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.emailPEC==null && other.getEmailPEC()==null) || 
             (this.emailPEC!=null &&
              this.emailPEC.equals(other.getEmailPEC()))) &&
            ((this.partitaIVA==null && other.getPartitaIVA()==null) || 
             (this.partitaIVA!=null &&
              this.partitaIVA.equals(other.getPartitaIVA()))) &&
            ((this.fax==null && other.getFax()==null) || 
             (this.fax!=null &&
              java.util.Arrays.equals(this.fax, other.getFax()))) &&
            ((this.telefono==null && other.getTelefono()==null) || 
             (this.telefono!=null &&
              java.util.Arrays.equals(this.telefono, other.getTelefono()))) &&
            this.ente == other.isEnte() &&
            this.aoo == other.isAoo() &&
            ((this.matricola==null && other.getMatricola()==null) || 
             (this.matricola!=null &&
              this.matricola.equals(other.getMatricola()))) &&
            ((this.dataNascita==null && other.getDataNascita()==null) || 
             (this.dataNascita!=null &&
              this.dataNascita.equals(other.getDataNascita()))) &&
            ((this.luogoNascita==null && other.getLuogoNascita()==null) || 
             (this.luogoNascita!=null &&
              this.luogoNascita.equals(other.getLuogoNascita()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.denominazioneNormalizzata==null && other.getDenominazioneNormalizzata()==null) || 
             (this.denominazioneNormalizzata!=null &&
              this.denominazioneNormalizzata.equals(other.getDenominazioneNormalizzata()))) &&
            ((this.idIndirizzo==null && other.getIdIndirizzo()==null) || 
             (this.idIndirizzo!=null &&
              java.util.Arrays.equals(this.idIndirizzo, other.getIdIndirizzo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getUuid() != null) {
            _hashCode += getUuid().hashCode();
        }
        if (getDataInizioValidita() != null) {
            _hashCode += getDataInizioValidita().hashCode();
        }
        if (getDataFineValidita() != null) {
            _hashCode += getDataFineValidita().hashCode();
        }
        if (getStato() != null) {
            _hashCode += getStato().hashCode();
        }
        if (getChiaveEsterna() != null) {
            _hashCode += getChiaveEsterna().hashCode();
        }
        _hashCode += (isInternoEnte() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPfPgUl() != null) {
            _hashCode += getPfPgUl().hashCode();
        }
        if (getDataAccorpamento() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDataAccorpamento());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDataAccorpamento(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdEnteAppartenenza() != null) {
            _hashCode += getIdEnteAppartenenza().hashCode();
        }
        if (getIdAOOAppartenenza() != null) {
            _hashCode += getIdAOOAppartenenza().hashCode();
        }
        if (getIdUtenteCreazione() != null) {
            _hashCode += getIdUtenteCreazione().hashCode();
        }
        if (getIdAooAssociata() != null) {
            _hashCode += getIdAooAssociata().hashCode();
        }
        if (getIdStrutturaAssociata() != null) {
            _hashCode += getIdStrutturaAssociata().hashCode();
        }
        if (getIdNodoAssociato() != null) {
            _hashCode += getIdNodoAssociato().hashCode();
        }
        if (getCategoriaAnagrafica() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategoriaAnagrafica());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategoriaAnagrafica(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCodiceFonte() != null) {
            _hashCode += getCodiceFonte().hashCode();
        }
        if (getTipoSoggettoOrigine() != null) {
            _hashCode += getTipoSoggettoOrigine().hashCode();
        }
        if (getTipoSoggettoAppartenenza() != null) {
            _hashCode += getTipoSoggettoAppartenenza().hashCode();
        }
        if (getIdSoggettoPadre() != null) {
            _hashCode += getIdSoggettoPadre().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getCognome() != null) {
            _hashCode += getCognome().hashCode();
        }
        if (getDenominazione() != null) {
            _hashCode += getDenominazione().hashCode();
        }
        if (getCodice() != null) {
            _hashCode += getCodice().hashCode();
        }
        if (getCodiceFiscale() != null) {
            _hashCode += getCodiceFiscale().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getEmailPEC() != null) {
            _hashCode += getEmailPEC().hashCode();
        }
        if (getPartitaIVA() != null) {
            _hashCode += getPartitaIVA().hashCode();
        }
        if (getFax() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFax());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFax(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTelefono() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTelefono());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTelefono(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += (isEnte() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isAoo() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMatricola() != null) {
            _hashCode += getMatricola().hashCode();
        }
        if (getDataNascita() != null) {
            _hashCode += getDataNascita().hashCode();
        }
        if (getLuogoNascita() != null) {
            _hashCode += getLuogoNascita().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getDenominazioneNormalizzata() != null) {
            _hashCode += getDenominazioneNormalizzata().hashCode();
        }
        if (getIdIndirizzo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdIndirizzo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdIndirizzo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SoggettoPropertiesType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("subjectregistryservice.acaris.acta.doqui.it", "SoggettoPropertiesType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uuid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uuid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataInizioValidita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataInizioValidita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataFineValidita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataFineValidita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stato"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chiaveEsterna");
        elemField.setXmlName(new javax.xml.namespace.QName("", "chiaveEsterna"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internoEnte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "internoEnte"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pfPgUl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pfPgUl"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataAccorpamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataAccorpamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idEnteAppartenenza");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idEnteAppartenenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAOOAppartenenza");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAOOAppartenenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUtenteCreazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idUtenteCreazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idAooAssociata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idAooAssociata"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idStrutturaAssociata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idStrutturaAssociata"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idNodoAssociato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idNodoAssociato"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoriaAnagrafica");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categoriaAnagrafica"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFonte");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFonte"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoSoggettoOrigine");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoSoggettoOrigine"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoSoggettoAppartenenza");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoSoggettoAppartenenza"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "DecodificaType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idSoggettoPadre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idSoggettoPadre"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cognome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cognome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazione");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominazione"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codiceFiscale");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codiceFiscale"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailPEC");
        elemField.setXmlName(new javax.xml.namespace.QName("", "emailPEC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("partitaIVA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "partitaIVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fax");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fax"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telefono");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telefono"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aoo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "aoo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matricola");
        elemField.setXmlName(new javax.xml.namespace.QName("", "matricola"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dataNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("luogoNascita");
        elemField.setXmlName(new javax.xml.namespace.QName("", "luogoNascita"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("", "note"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("denominazioneNormalizzata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "denominazioneNormalizzata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idIndirizzo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idIndirizzo"));
        elemField.setXmlType(new javax.xml.namespace.QName("common.acaris.acta.doqui.it", "ObjectIdType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
