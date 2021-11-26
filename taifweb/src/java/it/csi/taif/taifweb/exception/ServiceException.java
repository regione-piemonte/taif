/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.exception;

import it.csi.taif.taifweb.business.manager.message.Message;

/**
 * Classe di eccezioni del <code>Servizio</code>.
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 */
public final class ServiceException extends ManagerException {

    private static final long serialVersionUID = 7583376730326946211L;

    /**
     * Inizializza un'istanza della classe.
     *
     * @param cause Causa dell'eccezione
     * @param msg Messaggio associato all'eccezione
     */
    public ServiceException(Throwable cause, Message msg) {
        super(cause, msg);
    }

    /**
     * Inizializza un'istanza della classe.
     *
     * @param msg Messaggio associato all'eccezione
     */
    public ServiceException(Message msg) {
        super(msg);
    }

}
