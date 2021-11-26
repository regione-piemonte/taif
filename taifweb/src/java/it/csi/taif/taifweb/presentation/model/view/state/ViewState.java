/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.model.view.state;


import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import it.csi.taif.taifweb.presentation.model.view.ViewElement;
import it.csi.taif.taifweb.util.StringUtils;

public final class ViewState implements Serializable {
	private static final long serialVersionUID = 1L;

	private Map<String, ElementState> viewState;

	public ViewState() {
		this.viewState = new HashMap<String, ElementState>();
	}

	public void add(ElementState elementState) {
		final ViewElement ve = elementState.getViewElement();

		if (ve != null) {
			final String name = ve.getName();
			if (StringUtils.isNotBlank(name)) {
				this.viewState.put(name, elementState);
			}
		}
	}

	public void add(ElementStateBuilder builder) {
		this.add(builder.build());
	}

	public void remove(ViewElement viewElement) {
		this.viewState.remove(viewElement.getName());
	}

	public void clear() {
		this.viewState.clear();
	}

	public Collection<ElementState> getViewState() {
		return Collections.unmodifiableCollection(this.viewState.values());
	}
}
