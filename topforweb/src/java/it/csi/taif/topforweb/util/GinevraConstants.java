/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util;

/**
 *
 * @author 71740 (Simone Cornacchia)
 */
public final class GinevraConstants {

    
    public static final long ID_REGIONE_PIEMONTE = 1L;

    /**
     * Modalit&agrave; di Ricerca per <em>corrispondenza esatta</em> al termine di ricerca.
     */
    public static final int MATCH_EXACTLY = 0;

    /**
     * Modalit&agrave; di Ricerca per <em>corrispondenza contenuta</em> nel termine di ricerca.
     */
    public static final int MATCH_CONTAINS = 1;

    /**
     * Modalit&agrave; di Ricerca per <em>corrispondenza trovata all'inizio</em> del termine di ricerca.
     */
    public static final int MATCH_STARTS_WITH = 2;

    /**
     * Modalit&agrave; di Ricerca per <em>corrispondenza trovata alla fine</em> del termine di ricerca.
     */
    public static final int MATCH_ENDS_WITH = 3;

    /**
     * Constructor.
     */
    private GinevraConstants() {
        /* NOP */
    }

}
