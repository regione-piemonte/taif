/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.builder;

/**
 *
 * @author 71740 (Simone Cornacchia)
 *
 * @param <T> built type
 */
public interface GenericBuilder<T> {

    /**
     *
     * @return
     */
    T build();

}
