/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util.guava.common.base;

/**
 *
 * @author 71740 (Simone Cornacchia)
 *
 * @param <IN>
 * @param <OUT>
 */
public interface Function<IN, OUT> {

	/**
	 *
	 * @param input
	 * @return
	 */
	OUT apply(IN input);

}
