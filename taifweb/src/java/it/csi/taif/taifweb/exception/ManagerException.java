/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.exception;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.csi.taif.taifweb.business.manager.message.Message;

/**
 * Classe di eccezioni del <code>Manager</code>.
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 */
public class ManagerException extends Exception {

    private static final long serialVersionUID = -556492739708201774L;

    /**
     * Messaggio d'errore di default
     */
    private static final String DEFAULT_ERROR_MESSAGE = "Business error";

    /**
     * Messaggio associato all'eccezione
     */
    private final Message msg;

    /**
     * Lista dei campi che hanno sollevato l'eccezione
     */
    private final List<String> fieldList;

    /**
     * Lista dei messaggi.
     */
    private final List<Message> messageList;

    /**
     * Mappa dei campi.
     */
    private final Map<String, String> mapField;

    /**
     * Inizializza un'istanza della classe.
     *
     * @param msg Messaggio associato all'eccezione
     */
    public ManagerException(Message msg) {
        super(DEFAULT_ERROR_MESSAGE);

        this.msg = msg;

        this.fieldList = new ArrayList<String>();
        this.mapField = new HashMap<String, String>();
        this.messageList = new ArrayList<Message>();
        this.messageList.add(msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param message Messaggio d'errore
     * @param msg Messaggio associato all'eccezione
     */
    public ManagerException(String message, Message msg) {
        super(message);

        this.msg = msg;

        this.fieldList = new ArrayList<String>();
        this.mapField = new HashMap<String, String>();
        this.messageList = new ArrayList<Message>();
        this.messageList.add(msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param cause Causa dell'errore
     * @param msg Messaggio associato all'eccezione
     */
    public ManagerException(Throwable cause, Message msg) {
        super(DEFAULT_ERROR_MESSAGE, cause);

        this.msg = msg;

        this.fieldList = new ArrayList<String>();
        this.mapField = new HashMap<String, String>();
        this.messageList = new ArrayList<Message>();
        this.messageList.add(msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param message Messaggio d'errore
     * @param cause Causa dell'errore
     * @param msg Messaggio associato all'eccezione
     */
    public ManagerException(String message, Throwable cause, Message msg) {
        super(message, cause);

        this.msg = msg;

        this.fieldList = new ArrayList<String>();
        this.mapField = new HashMap<String, String>();
        this.messageList = new ArrayList<Message>();
        this.messageList.add(msg);
    }

    /**
     * Restituisce il messaggio associato all'eccezione
     *
     * @return Messaggio associato all'eccezione
     */
    public final Message getMsg() {
        return this.msg;
    }

    /**
     * Restituisce la lista dei campi che hanno sollevato l'eccezione
     *
     * @return Lista dei campi che hanno sollevato l'eccezione
     */
    public final List<String> getFieldList() {
        return this.fieldList;
    }

    /**
     *
     * @return
     */
    public final Map<String, String> getMapField() {
        return this.mapField;
    }

    /**
     * Aggiunge un campo alla lista dei campi che hanno sollevato l'eccezione
     *
     * @param field Campo da aggiungere
     */
    public final void addField(String field) {
        this.fieldList.add(field);
    }

    /**
     *
     * @param field
     * @param message
     */
    public final void addElement(String field, String message) {
        this.mapField.put(field, message);
    }

    /**
     *
     * @param message
     */
    public final void addMessage(Message message) {
        this.messageList.add(message);
    }

    /**
     *
     * @return
     */
    public final List<Message> getMessageList() {
        return this.messageList;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Throwable#getMessage()
     */
    @Override
    public final String getMessage() {
        String m;

        if (this.msg == null) {
            m = super.getMessage();
        } else {
            m = this.msg.getText();
        }

        return m;
    }

}
