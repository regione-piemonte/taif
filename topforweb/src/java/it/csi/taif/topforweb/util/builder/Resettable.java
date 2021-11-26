/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.builder;

/**
 * Interfaccia che rappresenta un generico comportamento di <code>reset</code> di un'istanza.
 *
 * @author 71740 (Simone Cornacchia)
 */
public interface Resettable<T> {

    /**
     * Resetta l'istanza corrente, eseguendo le operazioni di <code>reset</code> eventualmente richieste.
     *
     * @return un riferimento all'istanza corrennte, eventualmente modificata a seguito delle operazione di <code>reset</code>
     */
    T reset();

}
