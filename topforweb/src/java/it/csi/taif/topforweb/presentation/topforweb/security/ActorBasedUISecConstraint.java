/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.presentation.topforweb.security;
import java.util.Map;
import it.csi.taif.topforweb.business.*;
import it.csi.taif.topforweb.dto.*;

/**
 * Security constraint basato sull'impersonificazione dell'utente corrente 
 * di uno specifico actor
 * @generated
 */
public class ActorBasedUISecConstraint extends AbstractUISecConstraint {

	/**
	 * il codice dell'actor di cui verificare l'impersonificazione
	 * @generated
	 */
	private String actorCode;

	/**
	 * @param val il codice dell'Actor
	 */
	public void setActorCode(String val) {
		this.actorCode = val;
	}

	/**
	 * costrutto vuoto
	 */
	public ActorBasedUISecConstraint() {
		// intenzionalment evuoto
	}

	/**
	 * costruttore
	 * @param nomeContainer nome del content panel che contiene il constraint
	 * @param nomeWidget nome del widget a cui e' associato il constraint
	 * @param constrainedBehavior il constraint riguarda la visibilita' o l'abilitazione
	 * @param stato di default del widget a cui e' asociato il constraint
	 * @param actorCode il codice dell'actor di cui verificare l'impersonificazione
	 * @generated
	 */
	public ActorBasedUISecConstraint(String nomeContainer, String nomeWidget, int constrainedBehavior,
			boolean defaultState, String actorCode) {
		super(nomeContainer, nomeWidget, constrainedBehavior, defaultState);
		this.actorCode = actorCode;
	}

	/**
	 * realizza la verifica specifica (delegandola al security helper
	 * @param session la sessione applicativa
	 * @param sh il security helper
	 * @generated
	 */
	@Override
	public boolean specificCheck(BaseSessionAwareDTO model, Map session, SecurityHelper sh) throws BEException {
		return sh.verifyCurrentUserForActor(session, actorCode);
	}

}
