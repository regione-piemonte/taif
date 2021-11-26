/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.exception;

import it.csi.taif.taifweb.business.manager.message.Message;

/**
 * Classe di eccezioni del <code>DbManager</code>.
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 */
public final class DbManagerException extends ManagerException {

    private static final long serialVersionUID = 3460974305395927581L;

    /**
     * Inizializza un'istanza della classe.
     */
    public DbManagerException() {
        super(null, null, null);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param msg Messaggio associato all'eccezione
     */
    public DbManagerException(Message msg) {
        super(msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param message Messaggio d'errore
     * @param msg Messaggio associato all'eccezione
     */
    public DbManagerException(String message, Message msg) {
        super(message, msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param cause Causa dell'eccezione
     * @param msg Messaggio associato all'eccezione
     */
    public DbManagerException(Throwable cause, Message msg) {
        super(cause, msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param message Messaggio d'errore
     * @param cause Causa dell'eccezione
     * @param msg Messaggio associato all'eccezione
     */
    public DbManagerException(String message, Throwable cause, Message msg) {
        super(message, cause, msg);
    }

}
