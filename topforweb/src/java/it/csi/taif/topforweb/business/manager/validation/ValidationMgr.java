/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.topforweb.business.manager.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import it.csi.taif.topforweb.business.dao.topfor.dto.TaifTPersonaByCodiceFiscalePersonaDto;
import it.csi.taif.topforweb.business.dao.topfor.filter.TipoAllegatoFilter;
import it.csi.taif.topforweb.business.helper.dto.MetadatiIndex;
import it.csi.taif.topforweb.business.helper.dto.factory.MetadatiIndexFactory;
import it.csi.taif.topforweb.business.manager.db.DbMgr;
import it.csi.taif.topforweb.business.manager.message.Message;
import it.csi.taif.topforweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.topforweb.business.manager.message.MsgMgr;
import it.csi.taif.topforweb.dto.allegato.Allegato;
import it.csi.taif.topforweb.dto.common.LoginInfo;
import it.csi.taif.topforweb.dto.corsoprofessionale.CorsoProfessionale;
import it.csi.taif.topforweb.dto.operatore.Operatore;
import it.csi.taif.topforweb.dto.qualifica.Qualifica;
import it.csi.taif.topforweb.dto.riconoscimento.Riconoscimento;
import it.csi.taif.topforweb.exception.ManagerException;
import it.csi.taif.topforweb.exception.ServiceException;
import it.csi.taif.topforweb.exception.ValidationException;
import it.csi.taif.topforweb.util.CollectionUtils;
import it.csi.taif.topforweb.util.Constants;
import it.csi.taif.topforweb.util.ConvertUtil;
import it.csi.taif.topforweb.util.RegexConstants;
import it.csi.taif.topforweb.util.StringUtils;

/**
 * Gestore delle validazioni.
 *
 * @author 1346 (Enrico Fusaro)
 */
public final class ValidationMgr {

	/**
	 * Logger.
	 */
	private static final Logger LOG = Logger.getLogger(Constants.APPLICATION_CODE + ".business.manager.validation");

	/**
	 * Formattatore di date.
	 */
	private final SimpleDateFormat formatter;

	/**
	 * {@link ValidationException}.
	 */
	private ValidationException valex;

	/**
	 * Manager dei messaggi
	 */
	private MsgMgr msgMgr;

	/**
	 * Manager del DB
	 */
	private DbMgr dbMgr;

	/**
	 * Restituisce il manager dei messaggi
	 *
	 * @return Manager dei messaggi
	 */
	
	public MsgMgr getMsgMgr() {
		return this.msgMgr;
	}

	/**
	 * Imposta il manager dei messaggi
	 *
	 * @param msgMgr
	 *            Manager dei messaggi
	 */
	public void setMsgMgr(MsgMgr msgMgr) {
		this.msgMgr = msgMgr;
	}

	/**
	 * Restituisce il manager del DB
	 *
	 * @return Manager del DB
	 */
	public DbMgr getDbMgr() {
		return this.dbMgr;
	}

	/**
	 * Imposta il manager del DB
	 *
	 * @param dbMgr
	 *            Manager del DB
	 */
	public void setDbMgr(DbMgr dbMgr) {
		this.dbMgr = dbMgr;
	}
	

	/**
	 * Constructor.
	 */
	public ValidationMgr() {
		this.formatter = new SimpleDateFormat(ValidationConstants.DATE_FORMAT);
		this.formatter.setLenient(false);
	}

	/**
	 *
	 * @param idSelezionato
	 * @throws ValidationException
	 */
	public void validazioneFormaleSelezioneElenco(String idSelezionato) throws ValidationException {
		this.validazioneFormaleSelezioneElenco(idSelezionato, this.msgMgr.getMessage(MsgCodeEnum.S001));
	}

	/**
	 *
	 * @param idSelezionato
	 * @throws ValidationException
	 */
	public void validazioneFormaleSelezioneElenco(Integer idSelezionato) throws ValidationException {
		this.validazioneFormaleSelezioneElenco(ConvertUtil.convertToString(idSelezionato),
				this.msgMgr.getMessage(MsgCodeEnum.S001));
	}

	public void validazioneFormaleSelezioneElenco(Integer idSelezionato, Message m) throws ValidationException {
		this.validazioneFormaleSelezioneElenco(ConvertUtil.convertToString(idSelezionato), m);
	}

	/**
	 *
	 * @param idSelezionato
	 * @param m
	 * @throws ValidationException
	 */
	public void validazioneFormaleSelezioneElenco(String idSelezionato, Message m) throws ValidationException {
		LOG.debug("[ValidationMgr::validazioneFormaleSelezioneElenco] BEGIN");

		if (StringUtils.isEmpty(idSelezionato)) {
			throw new ValidationException(m);
		}

		LOG.debug("[ValidationMgr::validazioneFormaleSelezioneElenco] END");
	}

	/**
	 *
	 * @param idSelezionati
	 * @param m
	 * @throws ValidationException
	 */
	public void validazioneFormaleSelezioneElenco(List<?> idSelezionati, Message m) throws ValidationException {
		LOG.debug("[ValidationMgr::validazioneFormaleSelezioneElenco] BEGIN");

		if (CollectionUtils.isEmpty(idSelezionati)) {
			throw new ValidationException(m);
		}

		LOG.debug("[ValidationMgr::validazioneFormaleSelezioneElenco] END");
	}

	/**
	 *
	 * @param idSelezionati
	 * @throws ValidationException
	 */
	public void validazioneFormaleSelezioneElenco(List<String> idSelezionati) throws ValidationException {
		this.validazioneFormaleSelezioneElenco(idSelezionati, this.msgMgr.getMessage(MsgCodeEnum.S001));
	}

	/**
	 *
	 * @param s
	 * @param minLenght
	 * @param field
	 * @throws ValidationException
	 */
	private void checkStringMinLenght(String s, int minLenght, String field) throws ValidationException {
		if (!StringUtils.checkStringMinLenght(s, minLenght)) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G004);
			message.replacePlaceholder(minLenght);

			if (this.valex == null) {
				this.valex = new ValidationException(message);
			}

			this.valex.addElement(field, message.getText());
			this.valex.addField(field);
		}
	}

	/**
	 *
	 * @param s
	 * @param maxLenght
	 * @param field
	 * @throws ValidationException
	 */
	private void checkAlphanumericStringMaxLenght(String s, int maxLenght, String field) throws ValidationException {
		if (!StringUtils.checkAlphanumericStringMaxLenght(s, maxLenght)) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G003);
			message.replacePlaceholder(maxLenght);

			if (this.valex == null) {
				this.valex = new ValidationException();
			}

			this.valex.addElement(field, message.getText());
			this.valex.addField(field);
		}
	}

	/**
	 *
	 * @param s
	 * @param minLenght
	 * @param field
	 * @throws ValidationException
	 */
	@SuppressWarnings("unused")
	private void checkAlphanumericStringMinLenght(String s, int minLenght, String field) throws ValidationException {
		if (!StringUtils.checkAlphanumericStringMinLenght(s, minLenght)) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G004);
			message.replacePlaceholder(minLenght);

			if (this.valex == null) {
				this.valex = new ValidationException(message);
			} else {
				this.valex.addElement(field, message.getText());
			}

			this.valex.addField(field);
		}
	}

	/**
	 * Verifica se un codice fiscale e' formalmente valido
	 *
	 * @param codiceFiscale
	 *            Il codice fiscale da verificare
	 * @param codiceFiscaleField
	 *            Campo associato al codice fiscale
	 * @throws ValidationManagerException
	 *             Il codice fiscale non e' formalmente valido
	 */
	@SuppressWarnings("unused")
	private void checkCodiceFiscale(String codiceFiscale, String codiceFiscaleField) throws ValidationException {
		LOG.debug("[ValidationMgr::checkCodiceFiscale] BEGIN");

		if (StringUtils.isEmpty(codiceFiscale)
				|| StringUtils.isNotStringValid(codiceFiscale, RegexConstants.CODICE_FISCALE)) {
			if (this.valex == null) {
				this.valex = new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G005));
			} else {
				this.valex.addElement(codiceFiscaleField, this.msgMgr.getMessage(MsgCodeEnum.G005).getText());
			}

			this.valex.addField(codiceFiscaleField);
		}

		LOG.debug("[ValidationMgr::checkCodiceFiscale] END");
	}

	/**
	 * Verifica se un codice fiscale di un'azienda e' formalmente valido
	 *
	 * @param codiceFiscale
	 *            Il codice fiscale da verificare
	 * @param codiceFiscaleField
	 *            Campo associato al codice fiscale
	 * @throws ValidationManagerException
	 *             Il codice fiscale non e' formalmente valido
	 */
	@SuppressWarnings("unused")
	private void checkCodiceFiscaleAzienda(String codiceFiscale, String codiceFiscaleField) throws ValidationException {
		LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] BEGIN");

		if (StringUtils.isEmpty(codiceFiscale)
				|| StringUtils.isNotStringValid(codiceFiscale, RegexConstants.PARTITA_IVA)
						&& StringUtils.isNotStringValid(codiceFiscale, RegexConstants.CODICE_FISCALE)) {
			if (this.valex == null) {
				this.valex = new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G005));
			} else {
				this.valex.addElement(codiceFiscaleField, this.msgMgr.getMessage(MsgCodeEnum.G005).getText());
			}

			this.valex.addField(codiceFiscaleField);
		}

		LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] END");
	}

	@SuppressWarnings("unused")
	private void checkPivaAzienda(String codiceFiscale, String codiceFiscaleField) throws ValidationException {
		LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] BEGIN");

		if (StringUtils.isEmpty(codiceFiscale)
				|| StringUtils.isNotStringValid(codiceFiscale, RegexConstants.PARTITA_IVA)) {
			if (this.valex == null) {
				this.valex = new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G0012));
			} else {
				this.valex.addElement(codiceFiscaleField, this.msgMgr.getMessage(MsgCodeEnum.G0012).getText());
			}

			this.valex.addField(codiceFiscaleField);
		}

		LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] END");
	}

	public static boolean isValidFormat(String value) {
	
		Pattern pattern = Pattern.compile(RegexConstants.DATA_FORMAT); 
		Matcher matcher = pattern.matcher((CharSequence)value); 
		return matcher.matches(); 
			        
		
	}

	public static boolean validateEmailAddress(String email) {
		LOG.debug("[ValidationMgr::validateEmailAddress] BEGIN");
		String emailRegex = RegexConstants.PECMAIL;
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean validateTelefono(String telefono) {
		LOG.debug("[ValidationMgr::validateTelefono] BEGIN");
		String telRegex = RegexConstants.TELEFONO;
		Pattern pattern = Pattern.compile(telRegex);
		if (telefono == null)
			return false;
		return pattern.matcher(telefono).matches();
	}

	public static boolean validateSitoInternet(String sito) {
		LOG.debug("[ValidationMgr::validateTelefono] BEGIN");
		String sitoRegex = RegexConstants.INTERNETSITE;
		Pattern pattern = Pattern.compile(sitoRegex);
		if (sito == null)
			return false;
		return pattern.matcher(sito).matches();
	}

	private boolean validateMarcaDaBollo(String marcaDaBollo) {
		LOG.debug("[ValidationMgr::validateMarcaDaBollo] BEGIN");
		String marcaBolloRegex = RegexConstants.MARCA_DA_BOLLO;
		Pattern pattern = Pattern.compile(marcaBolloRegex);
		if (marcaDaBollo == null)
			return false;
		return pattern.matcher(marcaDaBollo).matches();
	}

	private boolean validateCap(String codiceCap) {
		LOG.debug("[ValidationMgr::validateCap] BEGIN");
		String regex = RegexConstants.CAP;
		Pattern pattern = Pattern.compile(regex);
		if (codiceCap == null)
			return false;
		return pattern.matcher(codiceCap).matches();
	}

	private boolean validateCivico(String codiceCap) {
		LOG.debug("[ValidationMgr::validateCap] BEGIN");
		String regex = RegexConstants.CIVICO;
		Pattern pattern = Pattern.compile(regex);
		if (codiceCap == null)
			return false;
		return pattern.matcher(codiceCap).matches();
	}

	private void checkExistValex() {
		if(this.valex==null) {
		this.valex = new ValidationException();
		}
	}

	private void validateMailAdress(String mail, final boolean emptyMail, MsgCodeEnum messageCode, String fieldName,
			String placeHolder) {
		if (emptyMail) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldName);
			final Message message = this.msgMgr.getMessage(messageCode);
			message.replacePlaceholder(placeHolder);
			this.valex.addElement(fieldName, message.getText());
		} else {
			if (!(validateEmailAddress(mail))) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(fieldName);
				final Message message = this.msgMgr.getMessage(messageCode);
				message.replacePlaceholder(placeHolder);
				this.valex.addElement(fieldName, message.getText());
			}
		}
	}

	private void validateCap(String cap, final boolean emptyCap, String fieldName, String placeHolder) {
		if (emptyCap) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldName);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder(placeHolder);
			this.valex.addElement(fieldName, message.getText());
		} else {
			if (!(validateCap(cap))) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(fieldName);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder(placeHolder);
				this.valex.addElement(fieldName, message.getText());
			}
		}
	}

	
	public void validateProfiloUtente(int idPersonaR) throws ValidationException {
		LOG.debug("[ValidationMgr::validateProfiloUtente] BEGIN");
		this.valex = null;
		if(idPersonaR==0) {
			valex = new ValidationException();
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0020);
			message.replacePlaceholder("Attenzione! Non sei abilitato all'accesso. Contattare l'Amministratore di sistema per farsi abilitare");
			this.valex.addField(FieldList.PROFILO);
			this.valex.addElement(FieldList.PROFILO,message.getText());
			}
		
		if (this.valex != null) {
			throw this.valex;
		}
		LOG.debug("[ValidationMgr::validateProfiloUtente] END");
	}
	
	public void validazionePersonaOperatore( Operatore  operatoreInserito, String idStatoScheda, String idStatoOperatore, String idComuneResidenza, String idComuneNascita, String tracciato, Boolean privacy, Boolean consensoPubblicazione) throws ManagerException {

	LOG.debug("[ValidationMgr::validazionePersonaOperatore] BEGIN");
	this.valex = null;
	try {
		
		final boolean emptyTitolareCF = StringUtils.isEmpty(operatoreInserito.getCodiceFiscaleOperatore());
		if (emptyTitolareCF) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_CODICE_FISCALE);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Codice Fiscale");
			this.valex.addElement(FieldList.OPERATORE_FOREST_CODICE_FISCALE, message.getText());
		} else {
			// checkCodiceFiscale(titolare.getCodiceFiscale(),
			// FieldList.TITOLARE_RAPP_CODICE_FISCALE);
		}

		final boolean emptyTitolareNome = StringUtils.isEmpty(operatoreInserito.getNomeOperatore());
		if (emptyTitolareNome) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_NOME);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Nome");
			this.valex.addElement(FieldList.OPERATORE_FOREST_NOME, message.getText());
		}

		final boolean emptyTitolareCognome = StringUtils.isEmpty(operatoreInserito.getCognomeOperatore());
		if (emptyTitolareCognome) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_COGNOME);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Cognome");
			this.valex.addElement(FieldList.OPERATORE_FOREST_COGNOME, message.getText());
		}

		final boolean emptyTitolareDataNascita = StringUtils.isEmpty(operatoreInserito.getDataNascitaOperatore());
		if (emptyTitolareDataNascita) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_DATA_NASCITA);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Data di Nascita");
			this.valex.addElement(FieldList.OPERATORE_FOREST_DATA_NASCITA, message.getText());
		} else {
			if (!isValidFormat(operatoreInserito.getDataNascitaOperatore())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.OPERATORE_FOREST_DATA_NASCITA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0011);
				message.replacePlaceholder("Data di Nascita");
				this.valex.addElement(FieldList.OPERATORE_FOREST_DATA_NASCITA, message.getText());

			}
		}

		final boolean emptyTitolareCap = StringUtils.isEmpty(operatoreInserito.getCapResidenzaOperatore());
		validateCap(operatoreInserito.getCapResidenzaOperatore(), emptyTitolareCap, FieldList.OPERATORE_FOREST_CAP, "Cap");

		final boolean emptyTitolareCivico = StringUtils.isEmpty(operatoreInserito.getCapResidenzaOperatore());
		if (emptyTitolareCivico) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_CIVICO);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Civico");
			this.valex.addElement(FieldList.OPERATORE_FOREST_CIVICO, message.getText());
		}

		final boolean emptyTitolareTelefono = StringUtils.isEmpty(operatoreInserito.getTelefonoOperatore());
		validateTelefonNumber(operatoreInserito.getTelefonoOperatore(), emptyTitolareTelefono, FieldList.OPERATORE_FOREST_TELEFONO,
				"Telefono");

		//final boolean emptyTitolareMail = StringUtils.isEmpty(operatoreInserito.getEmailOperatore());
		//validateMailAdress(operatoreInserito.getEmailOperatore(), emptyTitolareMail, MsgCodeEnum.G007, FieldList.OPERATORE_FOREST_EMAIL,
		//		"E-mail personale");

		final boolean emptyTitolareIndirizzo = StringUtils.isEmpty(operatoreInserito.getEmailOperatore());
		if (emptyTitolareIndirizzo) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_INDIRIZZO);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Indirizzo (via, piazza...)");
			this.valex.addElement(FieldList.OPERATORE_FOREST_INDIRIZZO, message.getText());
		}

		final boolean emptyStatoNascitaTitolare = StringUtils.isEmpty(idStatoOperatore);
		if (emptyStatoNascitaTitolare) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_ID_STATO_NASCITA);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Stato di nascita");
			this.valex.addElement(FieldList.OPERATORE_FOREST_ID_STATO_NASCITA, message.getText());
		}

		

		final boolean emptyTitolareResidenza = StringUtils.isEmpty(idComuneResidenza);
		if (emptyTitolareResidenza) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_COM_REZIDENZA);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Comune di residenza");
			this.valex.addElement(FieldList.OPERATORE_FOREST_COM_REZIDENZA, message.getText());
		}
				
		/*if(!anagraficaAziendale.getPrivacy()) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.DATI_AZIENDALI_PRIVACY);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Privacy");
			this.valex.addElement(FieldList.DATI_AZIENDALI_PRIVACY, message.getText());
		}*/

		final boolean emptyTitolareNascita = StringUtils.isEmpty(idComuneNascita);
		if (emptyTitolareNascita) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_COM_NASCITA);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Comune");
			this.valex.addElement(FieldList.OPERATORE_FOREST_COM_NASCITA, message.getText());
		}
		
		if(!privacy) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_PRIVACY);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Privacy");
			this.valex.addElement(FieldList.OPERATORE_PRIVACY, message.getText());
		}
		
		if(!consensoPubblicazione) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_CONSENSO_PUBBLICAZIONE);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Consenso Pubblicazione");
			this.valex.addElement(FieldList.OPERATORE_CONSENSO_PUBBLICAZIONE, message.getText());
		}

		if (valex != null) {
			throw valex;
		}
	} finally {
		LOG.debug("[ValidationMgr::validazioneTitolariRappresentante] END");
	}
}
	
	
	
	public void validazioneEsistenzaSuDb( Operatore  operatoreInserito, List<TaifTPersonaByCodiceFiscalePersonaDto> titolarePerCodiceFiscale, Boolean fromModifica) throws ManagerException {

	LOG.debug("[ValidationMgr::validazioneEsistenzaSuDb] BEGIN");
	this.valex = null;
	try {
		
		boolean esisteSuDb = false;
		
		if(titolarePerCodiceFiscale.size()==0) {
			esisteSuDb = false;
		}
		else{
			esisteSuDb = (!StringUtils.isEmpty(titolarePerCodiceFiscale.get(0).getCodiceFiscale()) && 
					ConvertUtil.checkIntIsNullOrZero(titolarePerCodiceFiscale.get(0).getIdPersona()));
		}
		
		if (esisteSuDb) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(FieldList.OPERATORE_FOREST_CODICE_FISCALE);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0038);
			message.replacePlaceholder("Codice Fiscale");
			this.valex.addElement(FieldList.OPERATORE_FOREST_CODICE_FISCALE, message.getText());
		}

		if (valex != null) {
			throw valex;
		}
	} finally {
		LOG.debug("[ValidationMgr::validazioneEsistenzaSuDb] END");
	}
}
	
	
	
	
	
	
	
	
	
	
	private void validateTelefonNumber(String telefono, final boolean emptyTitolareTelefono, String fieldName,
		String placeHolder) {
	if (emptyTitolareTelefono) {
		if (this.valex == null) {
			this.valex = new ValidationException();
		}
		this.valex.addField(fieldName);
		final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
		message.replacePlaceholder(placeHolder);
		this.valex.addElement(fieldName, message.getText());
	} else {
		if (!validateTelefono(telefono)) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldName);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G009);
			message.replacePlaceholder(placeHolder);
			this.valex.addElement(fieldName, message.getText());
		}

	}
}
	
	public void validazioneDocumentazioneAllegati(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel, TipoAllegatoFilter visibileFilter) throws ManagerException {
		LOG.debug("[ValidationMgr::validazioneDocumentazioneAllegati] BEGIN");

		this.valex = null;

		try {
			/*if(theModel.getAppDataidTipologiaAllegatoSelezionato().equalsIgnoreCase("")){
				checkExistValex();
				final Message message1 = this.msgMgr.getMessage(MsgCodeEnum.G0016);
				this.valex.addMessage(message1);
			}*/
			
			if(visibileFilter.getEstensioneFile() == null || visibileFilter.getEstensioneFile().equalsIgnoreCase("")){
				checkExistValex();
				final Message message3 = this.msgMgr.getMessage(MsgCodeEnum.G0018);
				this.valex.addMessage(message3);
			}
			
			//List<TaifDEstensioneFileEstensioneFileAmmDto> extAmmesse = getDbMgr().getEstensioneFileAmmessa(visibileFilter);
			boolean ammessa = false;
			//for(TaifDEstensioneFileEstensioneFileAmmDto tipoEstensione : extAmmesse){
				if(visibileFilter.getEstensioneFile().equalsIgnoreCase(Constants.ESTENSIONE_ALLEGATO_PDF)) {
					ammessa= true;
				}
			//}
			if (!ammessa) {
				/*checkExistValex();
				visibileFilter.setIdTipoAllegatoSelezionato(theModel.getAppDataidSottotipologiaAllegatoSelezionato());
				List<TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto> list = getDbMgr().getEstensionePerTipoDocumentoSelezionato(visibileFilter);
				Message message4 = this.msgMgr.getMessage(MsgCodeEnum.G0015);
				String estensioni = "";
				for(TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto t : list){
					estensioni = estensioni + t.getEstensione();
				}
				String testoMessaggio = message4.getText();
				message4.setText(testoMessaggio + " " + estensioni);
				this.valex.addMessage(message4);*/
			} 
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::validazioneDocumentazioneAllegati] END");
		}
	}
	
	public void checkOperatoreSalvato(String idOperatore) throws ValidationException {
		LOG.debug("[ValidationMgr::checkOperatoreSalvato] BEGIN");
		try {
			if (!ConvertUtil.checkIsNullOrEmpty(idOperatore)) {
				throw new ValidationException(this.getMsgMgr().getMessage(MsgCodeEnum.G0013));
			}
		} finally {
			LOG.debug("[ValidationMgr::checkOperatoreSalvato] END");
		}
	}
	
	public void checkElencoCorsiFinanziatiRegione(ArrayList<CorsoProfessionale> elenco) throws ValidationException {
		LOG.debug("[ValidationMgr::checkElencoCorsiFinanziatiRegione] BEGIN");
		try {
			if (elenco== null || elenco.size()==0) {
				throw new ValidationException(this.getMsgMgr().getMessage(MsgCodeEnum.G0026));
			}
		} finally {
			LOG.debug("[ValidationMgr::checkElencoCorsiFinanziatiRegione] END");
		}
	}
	
	
	
	public void checkValiditaSchedaCorsiFinanziatiRegione(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) throws ValidationException {
		LOG.debug("[ValidationMgr::checkValiditaSchedaCorsiFinanziatiRegione] BEGIN");

		this.valex = null;
		try {
			
			if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidEsitoCorsoSelezionato())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.ESITO_CORSO_FINANZIATO_REGIONE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Esito Corso");
				this.valex.addElement(FieldList.ESITO_CORSO_FINANZIATO_REGIONE, message.getText());
			} 
			if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidAgenziaFormativaSelezionata())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.AGENZIA_FORMATIVA_CORSO_FINANZIATO_REGIONE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Agenzia Formativa");
				this.valex.addElement(FieldList.AGENZIA_FORMATIVA_CORSO_FINANZIATO_REGIONE, message.getText());
			} 
			if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidUnitaFormativaSelezionata())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.UNITA_FORMATIVA_CORSO_FINANZIATO_REGIONE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Unità Formativa");
				this.valex.addElement(FieldList.UNITA_FORMATIVA_CORSO_FINANZIATO_REGIONE, message.getText());
			} 
			if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidTitoloCorsoSelezionato())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Titolo Corso");
				this.valex.addElement(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE, message.getText());
			} 
			
			
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::checkValiditaSchedaCorsiFinanziatiRegione] END");
		}
	}
	
	
	
	public void checkCorsoFinanziatoRegioneGiaInserito(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) throws ValidationException {
		LOG.debug("[ValidationMgr::checkCorsoFinanziatoRegioneGiaInserito] BEGIN");

		this.valex = null;
		try {
			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidTitoloCorsoSelezionato()) && 
					(theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione()!=null && theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione().size()!=0)) {
				for(CorsoProfessionale c : theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione()) {
					if(c.getIdCorsoProfessionale().equalsIgnoreCase(theModel.getAppDataidTitoloCorsoSelezionato())) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0028);
						message.replacePlaceholder("Titolo Corso");
						this.valex.addElement(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE, message.getText());
					    break;
					}
				}
			} 
			
			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataidTitoloCorsoSelezionato()) && 
					(theModel.getAppDataelencoAltriCorsi()!=null && theModel.getAppDataelencoAltriCorsi().size()!=0)) {
				for(CorsoProfessionale c : theModel.getAppDataelencoAltriCorsi()) {
					if(c.getIdCorsoProfessionale().equalsIgnoreCase(theModel.getAppDataidTitoloCorsoSelezionato())) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0028);
						message.replacePlaceholder("Titolo Corso");
						this.valex.addElement(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE, message.getText());
					    break;
					}
				}
			} 
			
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::checkCorsoFinanziatoRegioneGiaInserito] END");
		}
	}
	
	
	
	public void checkAltroCorsoGiaInserito(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) throws ValidationException {
		LOG.debug("[ValidationMgr::checkAltroCorsoGiaInserito] BEGIN");

		this.valex = null;
		try {
			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale()) && 
					(theModel.getAppDataelencoAltriCorsi()!=null && theModel.getAppDataelencoAltriCorsi().size()!=0)) {
				for(CorsoProfessionale c : theModel.getAppDataelencoAltriCorsi()) {
					if(c.getIdCorsoProfessionale().equalsIgnoreCase(theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale())) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0028);
						message.replacePlaceholder("Titolo corso");
						this.valex.addElement(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE, message.getText());
						break;
					}
				}
			} 
			
			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale()) && 
					(theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione()!=null && theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione().size()!=0)) {
				for(CorsoProfessionale c : theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione()) {
					if(c.getIdCorsoProfessionale().equalsIgnoreCase(theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale())) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0028);
						message.replacePlaceholder("Titolo corso");
						this.valex.addElement(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE, message.getText());
						break;
					}
				}
			} 
			
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::checkAltroCorsoGiaInserito] END");
		}
	}
	
	
	public void checkCorsoGiaInseritoElencoAltriCorsi(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) throws ValidationException {
		LOG.debug("[ValidationMgr::checkCorsoGiaInseritoElencoAltriCorsi] BEGIN");

		this.valex = null;
		try {
			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale()) && 
					(theModel.getAppDataelencoAltriCorsi()!=null && theModel.getAppDataelencoAltriCorsi().size()!=0)) {
				for(CorsoProfessionale c : theModel.getAppDataelencoAltriCorsi()) {
					if(c.getIdCorsoProfessionale().equalsIgnoreCase(theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale())) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.TITOLO_CORSO_ALTRI_CORSI);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0028);
						message.replacePlaceholder("Corso");
						this.valex.addElement(FieldList.TITOLO_CORSO_ALTRI_CORSI, message.getText());
						break;
					}
				}
			} 
			
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::checkCorsoGiaInseritoElencoAltriCorsi] END");
		}
	}
	
	public void checkValiditaSchedaAltriCorsi(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) throws ValidationException {
		LOG.debug("[ValidationMgr::checkValiditaSchedaAltriCorsi] BEGIN");

		this.valex = null;
		try {
			
			if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLO_CORSO_ALTRI_CORSI);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Corso Professionale");
				this.valex.addElement(FieldList.TITOLO_CORSO_ALTRI_CORSI, message.getText());
			} 
			if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataaltroCorsoSelezionatoInserimento().getAttestatoConScadenza())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.ATTESTATO_SCADENZA_ALTRO_CORSO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Scadenza Attestato");
				this.valex.addElement(FieldList.ATTESTATO_SCADENZA_ALTRO_CORSO, message.getText());
			} 
			if (!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataaltroCorsoSelezionatoInserimento().getEsitoCorso())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.ESITO_ALTRO_CORSO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Esito Corso");
				this.valex.addElement(FieldList.ESITO_ALTRO_CORSO, message.getText());
			} 
			if (!ConvertUtil.checkIsNullOrEmpty(theModel.getWidg_updFileAttestatoAltriCorsiContentType())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.UPLOAD_ATTESTATO_ALTRO_CORSO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Attestato corso");
				this.valex.addElement(FieldList.UPLOAD_ATTESTATO_ALTRO_CORSO, message.getText());
			} 
			
			// se il corso selezionato è altro corso, allora la descrizione è obbligatoria
			
			if (ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale()) &&
					isAltroCorso(theModel) && 
					!ConvertUtil.checkIsNullOrEmpty(theModel.getAppDataaltroCorsoSelezionatoInserimento().getDescrizioneAltroCorso())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DESCRIZIONE_CORSO_ALTRI_CORSI);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Descrizione Corso");
				this.valex.addElement(FieldList.DESCRIZIONE_CORSO_ALTRI_CORSI, message.getText());
			} 
			
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::checkValiditaSchedaAltriCorsi] END");
		}
	}
	
	
	
		private Boolean isAltroCorso(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) {
			Boolean isAltroCorso = false;
			String id = theModel.getAppDataaltroCorsoSelezionatoInserimento().getIdCorsoProfessionale();
			for(CorsoProfessionale corso : theModel.getAppDataelencoAltriCorsiDenominazioni()) {
				if(corso.getIdCorsoProfessionale().equalsIgnoreCase(id)) {
					if(corso.getFlgAltroCorso().equalsIgnoreCase(it.csi.taif.topforweb.business.dao.util.Constants.ID_CORSO_DENOMINAZIONE_ALTRO)) {
						isAltroCorso = true;
					}
				}
			}
			return isAltroCorso;
		}
	
		
	
      public void validateLoginInfo(LoginInfo info) throws ValidationException {
        	LOG.debug("[ValidationMgr::validateLoginInfo] BEGIN");
        	this.valex = null;
        	if (StringUtils.isEmpty(info.getUser()) || StringUtils.isEmpty(info.getPassword())) {
        	    valex = new ValidationException();
        	    if (StringUtils.isEmpty(info.getUser())) {
        		final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
        		message.replacePlaceholder("Login");
        		this.valex.addField(FieldList.LOGIN_USER);
        		this.valex.addElement(FieldList.LOGIN_USER, message.getText());
        	    }
        	    if (StringUtils.isEmpty(info.getPassword())) {
        		final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
        		message.replacePlaceholder("Password");
        
        		this.valex.addField(FieldList.LOGIN_PASS);
        		this.valex.addElement(FieldList.LOGIN_PASS, message.getText());
        	    }
        	}
        
        	if (this.valex != null) {
        	    throw this.valex;
        	}
        	LOG.debug("[ValidationMgr::validateLoginInfo] END");
            }
	
      
  	public void checkQualificaGiaInserita(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) throws ValidationException {
		LOG.debug("[ValidationMgr::checkQualificaGiaInserita] BEGIN");

		this.valex = null;
		try {
			if (theModel.getAppDataqualificaSelezionataInserimento()!=null && 
					(theModel.getAppDataelencoQualifiche()!=null && theModel.getAppDataelencoQualifiche().size()!=0)) {
				for(Qualifica c : theModel.getAppDataelencoQualifiche()) {
					if(c.getIdQualifica().equalsIgnoreCase(theModel.getAppDataqualificaSelezionataInserimento().getIdQualifica()) &&
							c.getAgenziaFormativa().equalsIgnoreCase((theModel.getAppDataqualificaSelezionataInserimento().getAgenziaFormativa()))) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.QUALIFICHE_AGENZIA_FORMATIVA);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0038);
						message.replacePlaceholder("Qualifica");
						this.valex.addElement(FieldList.QUALIFICHE_AGENZIA_FORMATIVA, message.getText());
					    break;
					}
				}
			} 
			
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::checkQualificaGiaInserita] END");
		}
	}
            
            
     public void validitaSchedaQualifiche(Qualifica qualificaOperatore) throws ValidationException {
		LOG.debug("[ValidationMgr::validitaSchedaQualifiche] BEGIN");

		this.valex = null;
		try {
		   // final boolean qualifica = StringUtils.isEmpty(qualificaOperatore.getTipoQualifica());
		    final boolean qualifica = StringUtils.isEmpty(qualificaOperatore.getIdQualifica());
			if (qualifica) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.QUALIFICHE_QUALIFICA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Qualifica");
				this.valex.addElement(FieldList.QUALIFICHE_QUALIFICA, message.getText());
			}
        		
			final boolean agenziaFormativa = StringUtils.isEmpty(qualificaOperatore.getAgenziaFormativa());
			if (agenziaFormativa) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.QUALIFICHE_AGENZIA_FORMATIVA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Agenzia Formativa");
				this.valex.addElement(FieldList.QUALIFICHE_AGENZIA_FORMATIVA, message.getText());
			}
			final boolean emptyDataQualifica = StringUtils.isEmpty(qualificaOperatore.getDataQualifica());
			if (emptyDataQualifica) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.QUALIFICHE_DATA_QUALIFICA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Data qualifica");
				this.valex.addElement(FieldList.QUALIFICHE_DATA_QUALIFICA, message.getText());
			} else {
				if (!isValidFormat(qualificaOperatore.getDataQualifica())) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.QUALIFICHE_DATA_QUALIFICA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0011);
					message.replacePlaceholder("Data qualifica");
					this.valex.addElement(FieldList.QUALIFICHE_DATA_QUALIFICA, message.getText());
				}
			}
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::validitaSchedaQualifiche] END");
		}
	} 
     
     
   	public void checkRiconoscimentoGiaInserito(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel) throws ValidationException {
 		LOG.debug("[ValidationMgr::checkRiconoscimentoGiaInserito] BEGIN");

 		this.valex = null;
 		try {
 			if (theModel.getAppDatariconoscimentoSelezionatoInserimento()!=null && 
 					(theModel.getAppDataelencoRiconoscimento()!=null && theModel.getAppDataelencoRiconoscimento().size()!=0)) {
 				for(Riconoscimento c : theModel.getAppDataelencoRiconoscimento()) {
 					if(c.getAgenziaFormativa().equalsIgnoreCase(theModel.getAppDatariconoscimentoSelezionatoInserimento().getAgenziaFormativa()) &&
 							c.getUnitaFormativa().equalsIgnoreCase((theModel.getAppDatariconoscimentoSelezionatoInserimento().getUnitaFormativa()))) {
 						if (this.valex == null) {
 							this.valex = new ValidationException();
 						}
 						this.valex.addField(FieldList.RICONOSCIMENTI_UNITA_FORMATIVA);
 						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0040);
 						message.replacePlaceholder("Riconoscimento");
 						this.valex.addElement(FieldList.RICONOSCIMENTI_UNITA_FORMATIVA, message.getText());
 					    break;
 					}
 				}
 			} 
 			
 			if (valex != null) {
 				throw valex;
 			}

 		} finally {
 			LOG.debug("[ValidationMgr::checkRiconoscimentoGiaInserito] END");
 		}
 	} 
     
     
     
     
        
    public void validaSchedaRiconoscimento(Riconoscimento riconoscimentoCorso) throws ValidationException {
        	// TODO Auto-generated method stub
        	LOG.debug("[ValidationMgr::validaSchedaRiconoscimento] BEGIN");
        
        	this.valex = null;
        	try {
        
        	    final boolean agenziaFormativa = StringUtils.isEmpty(riconoscimentoCorso.getAgenziaFormativa());
        	    if (agenziaFormativa) {
        		if (this.valex == null) {
        		    this.valex = new ValidationException();
        		}
        		this.valex.addField(FieldList.RICONOSCIMENTI_AGENZIA_FORMATIVA);
        		final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
        		message.replacePlaceholder("Agenzia Formativa");
        		this.valex.addElement(FieldList.RICONOSCIMENTI_AGENZIA_FORMATIVA, message.getText());
        	    }
        	    
        	    final boolean unitaFormativa = StringUtils.isEmpty(riconoscimentoCorso.getUnitaFormativa());
        	    if (unitaFormativa) {
        		if (this.valex == null) {
        		    this.valex = new ValidationException();
        		}
        		this.valex.addField(FieldList.RICONOSCIMENTI_UNITA_FORMATIVA);
        		final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
        		message.replacePlaceholder("Unita Formativa");
        		this.valex.addElement(FieldList.RICONOSCIMENTI_UNITA_FORMATIVA, message.getText());
        	    }
        	    
        	    final boolean emptyDataRiconoscimento = StringUtils.isEmpty(riconoscimentoCorso.getDataRiconoscimento());
			if (emptyDataRiconoscimento) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.RICONOSCIMENTI_DATA_RICONOSCIMENTO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Data riconoscimento");
				this.valex.addElement(FieldList.RICONOSCIMENTI_DATA_RICONOSCIMENTO, message.getText());
			} else {
				if (!isValidFormat(riconoscimentoCorso.getDataRiconoscimento())) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.RICONOSCIMENTI_DATA_RICONOSCIMENTO);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0011);
					message.replacePlaceholder("Data riconoscimento");
					this.valex.addElement(FieldList.RICONOSCIMENTI_DATA_RICONOSCIMENTO, message.getText());
				}
			}
        	    if (valex != null) {
        		throw valex;
        	    }
        
        	} finally {
        	    LOG.debug("[ValidationMgr::validaSchedaRiconoscimento] END");
        	}
        
    }
    
    
    
	public void checkEsisteOperatore(String idOperatore) throws Exception {
		LOG.debug("[ValidationMgr::checkEsisteOperatore] BEGIN");
		
		try {
			if (!idOperatore.equalsIgnoreCase("")) {
				LOG.debug("id Operatore diverso da null");
			}
		} catch (Exception e) {
			// se entra in questa eccezione significa che id Operatore è null e quindi il codice fiscale non è presente
			// e mostro il messaggio a video
			final Message m = this.msgMgr.getMessage(MsgCodeEnum.G0042);
			m.replacePlaceholder(Constants.ERR_INDEX);
			throw new ServiceException(e, m);
		} 
	}
    	
            
            
	public void checkNomeAllegatoFile(it.csi.taif.topforweb.dto.gestore.CpInserimentoOperatoreModel theModel, Allegato allegato) throws ValidationException {
/*		LOG.debug("[ValidationMgr::checkNomeAllegatoFile] BEGIN");

		this.valex = null;
		try {
				for(CorsoProfessionale c : theModel.getAppDataelencoCorsiProfessionaliFinanziatiDaRegione()) {
					if(c.geta)) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0028);
						message.replacePlaceholder("Titolo corso");
						this.valex.addElement(FieldList.TITOLO_CORSO_FINANZIATO_REGIONE, message.getText());
						break;
					}
				}
			
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::checkNomeAllegatoFile] END");
		}*/
	}







}
