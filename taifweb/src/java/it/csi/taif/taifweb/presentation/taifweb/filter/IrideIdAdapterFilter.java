/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.presentation.taifweb.filter;

import it.csi.iride2.policy.entity.Identita;
import it.csi.iride2.policy.exceptions.MalformedIdTokenException;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import it.csi.taif.taifweb.business.*;
import org.apache.log4j.*;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import it.csi.taif.taifweb.util.*;

/**
 * Inserisce in sessione:
 * <ul> 
 *  <li>l'identit&agrave; digitale relativa all'utente autenticato.
 *  <li>l'oggetto <code>currentUser</code>
 * </ul>
 * Funge da adapter tra il filter del metodo di autenticaizone previsto e la
 * logica applicativa.
 *
 * @author CSIPiemonte
 */
public class IrideIdAdapterFilter implements Filter {

	public static final String IRIDE_ID_SESSIONATTR = "iride2_id";

	public static final String AUTH_ID_MARKER = "Shib-Iride-IdentitaDigitale";

	public static final String USERINFO_SESSIONATTR = "appDatacurrentUser";

	/**  */
	protected static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".security");

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fchn)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) req;
		//taif-18: accesso utente dopo accesso libero
		boolean isLibero = hreq.getRequestURI().toString().contains("cpRicercaAccessoLibero") || hreq.getRequestURI().toString().contains("cpAziendaDettaglio") || hreq.getRequestURI().toString().contains("cpElencoAccessoLibero");
		LOG.info("[IrideIdAdapterFilter::doFilter] hreq.getRequestURI() toString : " + hreq.getRequestURI().toString());
		
		//LOG.info("[IrideIdAdapterFilter::doFilter] ServletActionContext.getRequest().getQueryString(): " + ServletActionContext.getRequest().getQueryString());

		StringBuilder token = new StringBuilder();
		token.append("RCRLBR77HL219V");
		token.append("/");
		token.append("RICERCA");
		token.append("/");
		token.append("LIBERA");
		token.append("/INFOCERT/");
		if(hreq.getSession().getAttribute(IRIDE_ID_SESSIONATTR) != null) {
			LOG.info("[IrideIdAdapterFilter::doFilter] IRIDE_ID_SESSIONATTR: " + hreq.getSession().getAttribute(IRIDE_ID_SESSIONATTR).toString());
			LOG.info("[IrideIdAdapterFilter::doFilter] TOKEN ACCESSO LIBERO: " + token.toString());
			if(!isLibero && hreq.getSession().getAttribute(IRIDE_ID_SESSIONATTR).toString().contains(token.toString())) {
				LOG.info("[IrideIdAdapterFilter::doFilter] IRIDE_ID_SESSIONATTR equals token");	
				LOG.debug("[IrideIdAdapterFilter::doFilter] IRIDE_ID_SESSIONATTR equals token");	

				hreq.getSession().removeAttribute(IRIDE_ID_SESSIONATTR);
				LOG.info("[IrideIdAdapterFilter::doFilter] IRIDE_ID_SESSIONATTR: " + hreq.getSession().getAttribute(IRIDE_ID_SESSIONATTR));
				LOG.debug("[IrideIdAdapterFilter::doFilter] IRIDE_ID_SESSIONATTR: " + hreq.getSession().getAttribute(IRIDE_ID_SESSIONATTR));
				}
			}
		
		if (hreq.getSession().getAttribute(IRIDE_ID_SESSIONATTR) == null) { 
			LOG.info("[IrideIdAdapterFilter::doFilter] IRIDE_ID_SESSIONATTR NULL || equals token");

			String marker = getToken(hreq);
			if (marker != null) {
				LOG.debug("[IrideIdAdapterFilter::doFilter] MARKER NOT NULL ");
				LOG.info("[IrideIdAdapterFilter::doFilter] MARKER NOT NULL ");

				try {
					Identita identita = new Identita(normalizeToken(marker));
					LOG.info("[IrideIdAdapterFilter::doFilter] Inserito in sessione marcatore IRIDE:" + identita);

					hreq.getSession().setAttribute(IRIDE_ID_SESSIONATTR, identita);
					it.csi.taif.taifweb.dto.common.UserInfo userInfo = new it.csi.taif.taifweb.dto.common.UserInfo();
					userInfo.setNome(identita.getNome());
					userInfo.setCognome(identita.getCognome());
					userInfo.setEnte("--");
					userInfo.setRuolo("--");
					userInfo.setCodFisc(identita.getCodFiscale());
					userInfo.setIdIride(identita.toString());
					userInfo.setNazionalita(Constants.NAZIONALITA_ITALIA);
					hreq.getSession().setAttribute(USERINFO_SESSIONATTR, userInfo);
				} catch (MalformedIdTokenException e) {
					LOG.error("[IrideIdAdapterFilter::doFilter] " + e.toString(), e);
				}
			} else {
				// STDMDD-325: il marcatore deve sempre essere presente altrimenti e' una 
				// condizione di errore (escluse le pagine home e di servizio)
				if (mustCheckPage(hreq.getRequestURI())) {
					LOG.error(
							"[IrideIdAdapterFilter::doFilter] Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
					throw new ServletException(
							"Tentativo di accesso a pagina non home e non di servizio senza token di sicurezza");
				}
			}
		}

		fchn.doFilter(req, resp);

	}

	private boolean mustCheckPage(String requestURI) {
		if (requestURI.indexOf("Login.do") > -1 ||requestURI.indexOf("HomePage.do") > -1 || requestURI.indexOf("sessionExpired.do") > -1
				|| requestURI.indexOf("fatalError") > -1 || requestURI.indexOf("notFoundError") > -1
				|| requestURI.indexOf("sessionExpired.jsp") > -1 || requestURI.indexOf("Logout") > -1)
			return false;
		else
			return true;
	}

	public void destroy() {
		// NOP
	}

	public void init(FilterConfig arg0) throws ServletException {
		// NOP
	}

	public String getToken(HttpServletRequest httpreq) {
		String marker = (String) httpreq.getHeader(AUTH_ID_MARKER);
		try {
			// gestione dell'encoding
			if(marker==null) {
				return marker;
			}
			String decodedMarker = new String(marker.getBytes("ISO-8859-1"), "UTF-8");
			return decodedMarker;
		} catch (java.io.UnsupportedEncodingException e) {
			// se la decodifica non funziona comunque sempre meglio restituire 
			// il marker originale non decodificato
			return marker;
		}
	}

	private String normalizeToken(String token) {
		return token;
	}

}
