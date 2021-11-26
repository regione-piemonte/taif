/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.util.guava.common.base;

/**
 *
 * @author 71740 (Simone Cornacchia)
 *
 * @param <T>
 */
public interface Predicate<T> {

	/**
	 *
	 * @param object
	 * @return
	 */
	boolean apply(T object);

}
