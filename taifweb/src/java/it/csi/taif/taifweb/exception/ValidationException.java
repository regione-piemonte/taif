/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.exception;

import it.csi.taif.taifweb.business.manager.message.Message;

/**
 * Classe di eccezioni di validazione.
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 */
public final class ValidationException extends ManagerException {

    private static final long serialVersionUID = 7463668943781144734L;

    /**
     * Inizializza un'istanza della classe.
     */
    public ValidationException() {
        super(null, null, null);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param msg Messaggio associato all'eccezione
     */
    public ValidationException(Message msg) {
        super(msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param message Messaggio d'errore
     * @param msg Messaggio associato all'eccezione
     */
    public ValidationException(String message, Message msg) {
        super(message, msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param cause Causa dell'eccezione
     * @param msg Messaggio associato all'eccezione
     */
    public ValidationException(Throwable cause, Message msg) {
        super(cause, msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param message Messaggio d'errore
     * @param cause Causa dell'eccezione
     * @param msg Messaggio associato all'eccezione
     */
    public ValidationException(String message, Throwable cause, Message msg) {
        super(message, cause, msg);
    }

}
