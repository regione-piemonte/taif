/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager.message;

/**
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 */
public interface MsgType {

    /**
     * Messaggio d'errore fatale.
     */
    public final static int FATAL = 5;

    /**
     * Messaggio d'errore.
     */
    public final static int ERROR = 4;

    /**
     * Messaggio d'allerta.
     */
    public final static int WARNING = 3;

    /**
     * Messaggio di informazione.
     */
    public final static int INFO = 2;

    /**
     * Messaggio di debug.
     */
    public final static int DEBUG = 1;

    /**
     * Messaggio di conferma.
     */
    public final static int CONFIRM = 0;

    /**
     * Restituisce il tipo di messaggio.
     *
     * @return il tipo di messaggio
     */
    public int getMessageType();

}

