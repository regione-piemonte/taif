/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.model.view.state;

import it.csi.taif.taifweb.presentation.model.view.ViewElement;

public final class ElementStateBuilder {

	private ViewElement viewElement;
	private Boolean visible;
	private Boolean enabled;

	private ElementStateBuilder(ViewElement viewElement) {
		this.viewElement = viewElement;
	}

	public static ElementStateBuilder of(ViewElement viewElement) {
		return new ElementStateBuilder(viewElement);
	}

	public ElementStateBuilder visible(Boolean visible) {
		this.visible = visible;
		return this;
	}

	public ElementStateBuilder enabled(Boolean enabled) {
		this.enabled = enabled;
		return this;
	}

	public ElementState build() {
		final ElementState elementState = new ElementState();

		elementState.setViewElement(this.viewElement);
		elementState.setVisible(this.visible);
		elementState.setEnabled(this.enabled);

		return elementState;
	}
}
