/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager.message;


import java.text.MessageFormat;
import java.util.Date;

import it.csi.taif.taifweb.util.ConvertUtil;

/**
 *
 * @author  1346 (Enrico Fusaro)
 */
public final class Message implements Cloneable {

    /**
     * Prefisso dei messaggi d'errore
     */
    private static final String ERROR_PREFIX = "S";
    private static final String ERROR_GENERIC_PREFIX = "G";
    private static final String ERROR_USER = "U";

    /**
     * Prefisso dei messaggi d'informazione
     */
    private static final String INFORMATION_PREFIX = "I";

    /**
     * Prefisso dei messaggi di conferma
     */
    private static final String CONFIRM_PREFIX = "C";

    /**
     * Segnaposto delle parti variabili dei messaggi
     */
    private static final String VALUE_PLACEHOLDER = "##value##";
    
    private static final String VALUE_PLACEHOLDER_AZIENDA_DENOMINAZIONE = "##valueAziendaDenominazione##";    
    private static final String VALUE_PLACEHOLDER_AZIENDA_PIVA = "##valueAziendaPartitaIva##";
    private static final String VALUE_PLACEHOLDER_TITOLARE_COGNOME = "##valueTitolareCognome##";
    private static final String VALUE_PLACEHOLDER_TITOLARE_NOME = "##valueTitolareNome##";
    private static final String VALUE_PLACEHOLDER_SOGGETTOGESTORE_DENOMBREVE = "##valueSoggettogestoreDenombreve##";
    private static final String VALUE_PLACEHOLDER_SOGGETTOGESTORE_DENOMINAZIONE = "##valueSoggettogestoreDenominazione##";
    private static final String VALUE_PLACEHOLDER_SOGGETTOGESTORE_TELEFONO = "##valueSoggettogestoreTelefono##";
    private static final String VALUE_PLACEHOLDER_SOGGETTOGESTORE_MAIL = "##valueSoggettogestoreMail##";
    private static final String VALUE_PLACEHOLDER_SOGGETTOGESTORE_PEC = "##valueSoggettogestorePec##";
    
    
    /**
     * Codice del messaggio
     */
    private MsgCodeEnum code = null;

    /**
     * Tipo di messaggio
     */
    private MsgTypeEnum type = null;

    /**
     * Testo del messaggio
     */
    private String text = null;

    /**
     * Inizializza un'istanza della classe
     */
    public Message() {
        /*NOP */
    }

    /**
     * Inizializza un'istanza della classe
     *
     * @param code Codice del messaggio
     * @param type Tipo del messaggio
     * @param text Testo del messaggio
     */
    public Message(MsgCodeEnum code, MsgTypeEnum type, String text) {
        this.code = code;
        this.type = type;
        this.text = text;
    }

    /**
     * Sostituisce un valore al primo segnaposto del messaggio
     *
     * @param value Valore da sostituire
     * @return Messaggio
     */
    public Message replacePlaceholder(String value) {
    	this.text = this.text.replaceFirst(VALUE_PLACEHOLDER, value);
         return this;
    }

    public Message replaceFormat(Object... values) {
        this.text = MessageFormat.format(this.text, values);
        return this;
    }

   

   

    /**
     * Inizializza un'istanza della classe con 9 parametri di sostituzione
     *
     * @param text Testo del messaggio
     * @param value1 Valore da sostituire
     * @param value2 Valore da sostituire
     * @param value3 Valore da sostituire
     * @param value4 Valore da sostituire
     * @param value5 Valore da sostituire
     * @param value6 Valore da sostituire
     * @param value7 Valore da sostituire
     * @param value8 Valore da sostituire
     * @param value9 Valore da sostituire
     */
    public Message(String text, String value1, String value2,
                   String value3, String value4, String value5, String value6,
                   String value7, String value8, String value9) {
        this.text = text;

        this.replacePlaceholder(value1, value2, value3, value4, value5, value6, value7, value8, value9);
    }

    

    /**
     * Sostituisce un valore al primo segnaposto del messaggio
     *
     * @param value Valore da sostituire
     * @return Messaggio
     */
    public Message replacePlaceholder(long value) {
        this.text = this.text.replaceFirst(VALUE_PLACEHOLDER, Long.toString(value));

        return this;
    }

    /**
     * Sostituisce un valore al primo segnaposto del messaggio
     *
     * @param value Valore da sostituire
     * @return Messaggio
     */
    public Message replacePlaceholder(Date value) {
        this.text = this.text.replaceFirst(VALUE_PLACEHOLDER, ConvertUtil.convertToString(value));

        return this;
    }

    

    

    /**
     * Sostituisce due valori ai segnaposto del messaggio
     *
     * @param value Valore da sostituire
     * @return Messaggio
     */
    public Message replacePlaceholder(String value1, String value2, String value3,
                                      String value4, String value5, String value6,
                                      String value7, String value8, String value9) {
            this.text = this.text.replaceFirst(VALUE_PLACEHOLDER_TITOLARE_COGNOME, value1);
            this.text = this.text.replaceFirst(VALUE_PLACEHOLDER_TITOLARE_NOME, value2);
            this.text = this.text.replaceFirst(VALUE_PLACEHOLDER_AZIENDA_DENOMINAZIONE, value3);
            this.text = this.text.replaceFirst(VALUE_PLACEHOLDER_AZIENDA_PIVA, value4);
            this.text = this.text.replaceFirst(VALUE_PLACEHOLDER_SOGGETTOGESTORE_DENOMBREVE, value5);
            this.text = this.text.replaceFirst(VALUE_PLACEHOLDER_SOGGETTOGESTORE_DENOMINAZIONE, value6);
            this.text = this.text.replaceFirst(VALUE_PLACEHOLDER_SOGGETTOGESTORE_TELEFONO, value7);
            this.text = this.text.replaceAll(VALUE_PLACEHOLDER_SOGGETTOGESTORE_MAIL, value8);
            this.text = this.text.replaceAll(VALUE_PLACEHOLDER_SOGGETTOGESTORE_PEC, value9);
        return this;
    }

    

    /**
     * Sostituisce un valore al primo segnaposto del messaggio
     *
     * @param value Valore da sostituire
     * @return Messaggio
     */
    public Message replacePlaceholder(int value) {
        this.text = this.text.replaceFirst(VALUE_PLACEHOLDER, Integer.toString(value));

        return this;
    }

    /**
     * Restituisce il codice del messaggio
     *
     * @return Codice del messaggio
     */
    public MsgCodeEnum getCode() {
        return this.code;
    }

    /**
     * Imposta il codice del messaggio
     *
     * @param code Codice del messaggio
     */
    public void setCode(MsgCodeEnum code) {
        this.code = code;
    }

    /**
     * Restituisce il tipo del messaggio
     *
     * @return Tipo del messaggio
     */
    public MsgTypeEnum getType() {
        return this.type;
    }

    /**
     * Imposta il tipo del messaggio
     *
     * @param type Tipo del messaggio
     */
    public void setType(MsgTypeEnum type) {
        this.type = type;
    }

    /**
     * Restituisce il testo del messaggio
     *
     * @return Testo del messaggio
     */
    public String getText() {
        return this.text;
    }

    /**
     * Imposta il testo del messaggio
     *
     * @param text Testo del messaggio
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Verifica se il messaggio e' un messaggio d'errore
     *
     * @return True se e' un messaggio d'errore, false altrimenti
     */
    public boolean isErrorMessage() {
        return this.checkMessage(new String[]{ ERROR_PREFIX, ERROR_GENERIC_PREFIX, ERROR_USER});
    }

    /**
     * Verifica se il messaggio e' un messaggio d'informazione
     *
     * @return True se e' un messaggio d'informazione, false altrimenti
     */
    public boolean isInfoMessage() {
        return this.checkMessage(INFORMATION_PREFIX);
    }

    /**
     * Verifica se il messaggio e' un messaggio di conferma
     *
     * @return True se e' un messaggio di conferma, false altrimenti
     */
    public boolean isConfirmMessage() {
        return this.checkMessage(CONFIRM_PREFIX);
    }

    /**
     * Verifica se il tipo di messaggio e' quello richiesto
     *
     * @param prefix Prefisso da verificare
     * @return True se il tipo di messaggio corrisponde, false altrimenti
     */
    private boolean checkMessage(String prefix) {
        boolean match;
        if (this.code == null) {
            match = false;
        } else {
            match = this.code.toString().startsWith(prefix);
        }
        return match;
    }

    /**
     * Verifica se il tipo di messaggio e' quello richiesto
     *
     * @param prefixs Prefissi da verificare
     * @return True se il tipo di messaggio corrisponde, false altrimenti
     */
    private boolean checkMessage(String[] prefixs) {
        boolean match = false;
        if (this.code != null) {
            for (String prefix : prefixs) {
                if (this.code.toString().startsWith(prefix)) {
                    match = true;

                    break;
                }
            }
        }

        return match;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object clone() {
        return new Message(code, type, text);
    }

    /**
     * Restituisce la descrizione dell'istanza
     *
     * @return Descrizione dell'istanza
     */
    @Override
    public String toString() {
        return this.code + " (" + this.type + "): " + this.text;
    }

}
