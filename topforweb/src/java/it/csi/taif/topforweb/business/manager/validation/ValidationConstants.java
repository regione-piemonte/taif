/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.validation;

/**
 * Costanti di validazione.
 *
 * @author  1346 (Enrico Fusaro)
 * @author 71740 (Simone Cornacchia)
 */
public final class ValidationConstants {

    /**
     * Lunghezza di un codice fiscale
     */
    public static final int CODICE_FISCALE_LEN = 16;

    /**
     * Lunghezza massima di un numero bollino
     */
    public static final int MAX_NUMERO_BOLLINO_LEN = 11;

    /**
     * Lunghezza massima di un numero REA
     */
    public static final int MAX_NUMERO_REA_LEN = 11;

    /**
     * Lunghezza massima di un codice impianto
     */
    public static final int MAX_CODICE_IMPIANTO_LEN = 11;

    /**
     * Formato da utilizzare con le date
     */
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    /**
     * Giorno e mese di default della data di installazione di una
     * apparecchiatura
     */
    public static final String DEFAULT_GG_MM_INSTALLAZIONE = "31/12/";

    /**
     * Anno di default della data di installazione di una apparecchiatura
     */
    public static final String DEFAULT_AA_INSTALLAZIONE = "1900";

    /**
     * Valore della voce vuota di una combo
     */
    public static final String EMPTY_ITEM = "0";

    /**
     * Constructor.
     */
    private ValidationConstants() {
        /* NOP */
    }

}
