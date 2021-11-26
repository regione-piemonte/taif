/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.manager.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDEstensioneFileEstensioneFileAmmDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifRPersonaAziendaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoByIdPraticaAllDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAllegatoByIdPraticaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.dto.TaifTCommercializzazioneByAziendaDto;
import it.csi.taif.taifweb.business.dao.taifweb.filter.AziendaVisibleFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.FormaGiuridicaFilter;
import it.csi.taif.taifweb.business.dao.taifweb.filter.TipoAllegatoFilter;
import it.csi.taif.taifweb.business.manager.db.DbMgr;
import it.csi.taif.taifweb.business.manager.message.Message;
import it.csi.taif.taifweb.business.manager.message.MsgCodeEnum;
import it.csi.taif.taifweb.business.manager.message.MsgMgr;
import it.csi.taif.taifweb.dto.allegato.Allegato;
import it.csi.taif.taifweb.dto.common.LoginInfo;
import it.csi.taif.taifweb.dto.domanda.Albo;
import it.csi.taif.taifweb.dto.domanda.AnagraficaAziendale;
import it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno;
import it.csi.taif.taifweb.dto.domanda.AssociazioniECertificazioni;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno1;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno2;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno3;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno4;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno5;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno6;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno7;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno8;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnno9;
import it.csi.taif.taifweb.dto.domanda.AttivitaUltimoAnnoFr;
import it.csi.taif.taifweb.dto.domanda.Capannone;
import it.csi.taif.taifweb.dto.domanda.Certificazione;
import it.csi.taif.taifweb.dto.domanda.DettaglioAttivitaUltimoAnnoFr;
import it.csi.taif.taifweb.dto.domanda.DettaglioStato;
import it.csi.taif.taifweb.dto.domanda.FatturatoCategorieDiImpresa;
import it.csi.taif.taifweb.dto.domanda.FormaOrganizzativa;
import it.csi.taif.taifweb.dto.domanda.GestioneAttivitaUltimoAnno;
import it.csi.taif.taifweb.dto.domanda.GestioneFatturatoCategoriaDiImpresa;
import it.csi.taif.taifweb.dto.domanda.GestioneMacchineMezzi;
import it.csi.taif.taifweb.dto.domanda.GestionePersonaleFr;
import it.csi.taif.taifweb.dto.domanda.Intervento;
import it.csi.taif.taifweb.dto.domanda.LavoroPA;
import it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato;
import it.csi.taif.taifweb.dto.domanda.MacchinaMezzo;
import it.csi.taif.taifweb.dto.domanda.MaterialePropagazione;
import it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale;
import it.csi.taif.taifweb.dto.domanda.Personale;
import it.csi.taif.taifweb.dto.domanda.PersonaleFr;
import it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio;
import it.csi.taif.taifweb.dto.domanda.Sede;
import it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale;
import it.csi.taif.taifweb.exception.DbManagerException;
import it.csi.taif.taifweb.exception.ManagerException;
import it.csi.taif.taifweb.exception.ValidationException;
import it.csi.taif.taifweb.util.CollectionUtils;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.ConvertUtil;
import it.csi.taif.taifweb.util.RegexConstants;
import it.csi.taif.taifweb.util.StringUtils;

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

	@Autowired
	private FormaGiuridicaFilter formaGiuridicaFilter;

	public void setFormaGiuridicaFilter(FormaGiuridicaFilter formaGiuridicaFilter) {
		this.formaGiuridicaFilter = formaGiuridicaFilter;
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
	private void checkCodiceFiscalePersone(String codiceFiscale, String codiceFiscaleField) throws ValidationException {
		LOG.debug("[ValidationMgr::checkCodiceFiscale] BEGIN");

		if (StringUtils.isEmpty(codiceFiscale)
				|| StringUtils.isNotStringValid(codiceFiscale, RegexConstants.CODICE_FISCALE_PERSONA)) {
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
	/*
	 * @SuppressWarnings("unused") private void _ok_checkCodiceFiscaleAzienda(String
	 * codiceFiscale, String codiceFiscaleField) throws ValidationException {
	 * LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] BEGIN");
	 * 
	 * if (StringUtils.isEmpty(codiceFiscale) ||
	 * StringUtils.isNotStringValid(codiceFiscale, RegexConstants.PARTITA_IVA) ||
	 * StringUtils.isNotStringValid(codiceFiscale, RegexConstants.PARTITA_IVA_SE)){
	 * if (this.valex == null) { this.valex = new
	 * ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G005)); } else {
	 * this.valex.addElement(codiceFiscaleField,
	 * this.msgMgr.getMessage(MsgCodeEnum.G005).getText()); }
	 * 
	 * this.valex.addField(codiceFiscaleField); }
	 * 
	 * LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] END"); }
	 */

	@SuppressWarnings("unused")
	private void checkCodiceFiscaleAzienda(String codiceFiscale, String codiceFiscaleField) throws ValidationException {
		LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] BEGIN");

		if (StringUtils.isEmpty(codiceFiscale)) {
			if (this.valex == null) {
				this.valex = new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G005));
			} else {
				this.valex.addElement(codiceFiscaleField, this.msgMgr.getMessage(MsgCodeEnum.G005).getText());
			}
			this.valex.addField(codiceFiscaleField);
		} else {
			if (StringUtils.isNotStringValid(codiceFiscale, RegexConstants.PARTITA_IVA)) {
				if (StringUtils.isNotStringValid(codiceFiscale, RegexConstants.CODICE_FISCALE_PERSONA)) {
					if (this.valex == null) {
						this.valex = new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G005));
					} else {
						this.valex.addElement(codiceFiscaleField, this.msgMgr.getMessage(MsgCodeEnum.G005).getText());
					}
					this.valex.addField(codiceFiscaleField);
				}
			}

		}

		LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] END");
	}

	@SuppressWarnings("unused")
	private void checkCodiceFiscaleAziendaFrancese(String codiceFiscale, String codiceFiscaleField)
			throws ValidationException {
		LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] BEGIN");

		// if (StringUtils.isEmpty(codiceFiscale)){
		// if (this.valex == null) {
		// this.valex = new
		// ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G0022));
		// } else {
		// this.valex.addElement(codiceFiscaleField,
		// this.msgMgr.getMessage(MsgCodeEnum.G0022).getText());
		// }
		// this.valex.addField(codiceFiscaleField);
		// }else {
		// if (StringUtils.isNotStringValid(codiceFiscale, RegexConstants.TVA_FRANCESE))
		// {
		// if (StringUtils.isNotStringValid(codiceFiscale,
		// RegexConstants.N_SIRET_FRANCESE)) {
		// if (this.valex == null) {
		// this.valex = new
		// ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G0023));
		// } else {
		// this.valex.addElement(codiceFiscaleField,
		// this.msgMgr.getMessage(MsgCodeEnum.G0023).getText());
		// }
		// this.valex.addField(codiceFiscaleField);
		// }
		// }
		//
		// }

		if (StringUtils.isEmpty(codiceFiscale)
				|| StringUtils.isNotStringValid(codiceFiscale, RegexConstants.N_SIRET_FRANCESE)) {
			if (this.valex == null) {
				this.valex = new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G0023));
			} else {
				this.valex.addElement(codiceFiscaleField, this.msgMgr.getMessage(MsgCodeEnum.G0023).getText());
			}

			this.valex.addField(codiceFiscaleField);
		}

		LOG.debug("[ValidationMgr::checkCodiceFiscaleAzienda] END");
	}

	// && StringUtils.isNotStringValid(codiceFiscale,
	// RegexConstants.CODICE_FISCALE))

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

	private void checkTvaFrancese(String tvaFrancese, String codiceFiscaleField) throws ValidationException {
		LOG.debug("[ValidationMgr::checkTvaFrancese] BEGIN");

		if (StringUtils.isEmpty(tvaFrancese)
				|| StringUtils.isNotStringValid(tvaFrancese, RegexConstants.TVA_FRANCESE)) {
			if (this.valex == null) {
				this.valex = new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G0022));
			} else {
				this.valex.addElement(codiceFiscaleField, this.msgMgr.getMessage(MsgCodeEnum.G0022).getText());
			}

			this.valex.addField(codiceFiscaleField);
		}

		LOG.debug("[ValidationMgr::checkTvaFrancese] END");
	}

	public static boolean isValidFormat(String value) {

		Pattern pattern = Pattern.compile(RegexConstants.DATA_FORMAT);
		Matcher matcher = pattern.matcher((CharSequence) value);
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

	public void validazioneDatiAziendali(Integer idAzienda, AnagraficaAziendale anagraficaAziendale, Sede sedeLegale,
			ArrayList<Sede> sedi, String dataTracciato, int idAlbo) throws ManagerException {
		LOG.debug("[ValidationMgr::validazioneDatiAziendali] BEGIN");

		this.valex = null;

		formaGiuridicaFilter.setFlagItaFr(dataTracciato);
		formaGiuridicaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);

		try {

			final boolean emptyCodiceFiscale = StringUtils.isEmpty(anagraficaAziendale.getCodiceFiscale());
			if (emptyCodiceFiscale) {
				this.valex = new ValidationException();
				this.valex.addField(FieldList.DATI_AZIENDALI_CODICE_FISCALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				if (dataTracciato.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
					message.replacePlaceholder("Codice Fiscale");
				}
				this.valex.addElement(FieldList.DATI_AZIENDALI_CODICE_FISCALE, message.getText());
			} else {
				checkCodiceFiscaleAzienda(anagraficaAziendale.getCodiceFiscale(),
						FieldList.DATI_AZIENDALI_CODICE_FISCALE);
			}

			final boolean emptyPartitaIva = StringUtils.isEmpty(anagraficaAziendale.getPartitaIva());
			if (emptyPartitaIva) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_PARTITA_IVA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Partita Iva");
				this.valex.addElement(FieldList.DATI_AZIENDALI_PARTITA_IVA, message.getText());
			} else {
				checkPivaAzienda(anagraficaAziendale.getPartitaIva(), FieldList.DATI_AZIENDALI_PARTITA_IVA);
			}

			final boolean emptyDescrizione = StringUtils.isEmpty(anagraficaAziendale.getDescrizione());
			if (emptyDescrizione) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_DESCRIZIONE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Descrizione");
				this.valex.addElement(FieldList.DATI_AZIENDALI_DESCRIZIONE, message.getText());
			}

			final boolean emptyAttivitaPrimaria = StringUtils.isEmpty(anagraficaAziendale.getIdAttivitaPrimaria());
			if (emptyAttivitaPrimaria) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Attivita primaria");
				this.valex.addElement(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE, message.getText());
			}

			final boolean emptyFormaGiuridica = StringUtils.isEmpty(anagraficaAziendale.getIdFormaGiurdica());
			final boolean notEmptyFormaGiuridica = StringUtils.isNotEmpty(anagraficaAziendale.getIdFormaGiurdica());
			if (emptyFormaGiuridica) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_FORMA_GIURIDICA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Forma giuridica");
				this.valex.addElement(FieldList.DATI_AZIENDALI_FORMA_GIURIDICA, message.getText());
			}

			final boolean emptyNote = StringUtils.isEmpty(anagraficaAziendale.getNote());
			if (emptyNote && notEmptyFormaGiuridica) {
				if (notEmptyFormaGiuridica) {
					formaGiuridicaFilter.setFormaGiuridica("Altro");
					if ((Integer.parseInt(anagraficaAziendale.getIdFormaGiurdica()) == dbMgr
							.getIdFormaGiuridica(formaGiuridicaFilter))
							|| Integer.parseInt(anagraficaAziendale.getIdFormaGiurdica()) == dbMgr
									.getIdFormaGiuridica(formaGiuridicaFilter)) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.DATI_AZIENDALI_NOTE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Note");
						this.valex.addElement(FieldList.DATI_AZIENDALI_NOTE, message.getText());
					}
				}
			}
			// solo per test mm
			if (dataTracciato.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				final boolean cciaa = StringUtils.isEmpty(anagraficaAziendale.getIdProvinciaCCIAA());
				if (cciaa) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.DATI_AZIENDALI_PROVINCIA_CCIAA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Provincia");
					this.valex.addElement(FieldList.DATI_AZIENDALI_PROVINCIA_CCIAA, message.getText());
				}

				final boolean cciaaNumero = StringUtils.isEmpty(anagraficaAziendale.getNumeroCCIAA());
				String numeroCCIA = anagraficaAziendale.getNumeroCCIAA();
				if (cciaaNumero) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.DATI_AZIENDALI_NUMERO_CCIAA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Numero");
					this.valex.addElement(FieldList.DATI_AZIENDALI_NUMERO_CCIAA, message.getText());
				} else if(numeroCCIA.length()>8) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.DATI_AZIENDALI_NUMERO_CCIAA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0032);
					this.valex.addElement(FieldList.DATI_AZIENDALI_NUMERO_CCIAA, message.getText());
					
				}
			}
			final boolean emptyPec = StringUtils.isEmpty(anagraficaAziendale.getPec());
			validateMailAdress(anagraficaAziendale.getPec(), emptyPec, MsgCodeEnum.G007, FieldList.DATI_AZIENDALI_PEC,
					"Pec");

			final boolean emptyMail = StringUtils.isEmpty(anagraficaAziendale.getEmail());
			validateMailAdress(anagraficaAziendale.getEmail(), emptyMail, MsgCodeEnum.G0010,
					FieldList.DATI_AZIENDALI_EMAIL, "E-mail di contatto");

			final boolean emptyTelefono = StringUtils.isEmpty(anagraficaAziendale.getTelefono());
			validateTelefonNumber(anagraficaAziendale.getTelefono(), emptyTelefono, FieldList.DATI_AZIENDALI_TELEFONO,
					"Telefono");

			if (dataTracciato.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.iLang)
					&& (idAlbo != it.csi.taif.taifweb.business.dao.util.Constants.threInt)) {
				final boolean emptyMarcaBollo = StringUtils.isEmpty(anagraficaAziendale.getMarcaDaBollo());
				if (emptyMarcaBollo) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.DATI_AZIENDALI_MARCA_DA_BOLLO);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Marca da Bollo");
					this.valex.addElement(FieldList.DATI_AZIENDALI_MARCA_DA_BOLLO, message.getText());
				} else {
					if (!validateMarcaDaBollo(anagraficaAziendale.getMarcaDaBollo())) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.DATI_AZIENDALI_MARCA_DA_BOLLO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0011);
						message.replacePlaceholder("Marca da bollo");
						this.valex.addElement(FieldList.DATI_AZIENDALI_MARCA_DA_BOLLO, message.getText());
					}

				}
			}

			// TODO
			// Controllo privacy (solo inserimento)
			LOG.debug("-------------- PRIVACY ? *" + anagraficaAziendale.getPrivacy() + "* --------------");

			if (!anagraficaAziendale.getPrivacy()) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_PRIVACY);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Privacy");
				this.valex.addElement(FieldList.DATI_AZIENDALI_PRIVACY, message.getText());
			}

			final boolean sedeLegaleComune = StringUtils.isEmpty(sedeLegale.getIstatComuneSede());
			if (sedeLegaleComune) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.SEDE_LEGALE_COMUNE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Comune sede legale ");
				this.valex.addElement(FieldList.SEDE_LEGALE_COMUNE, message.getText());
			}

			final boolean sedeLegaleCap = StringUtils.isEmpty(sedeLegale.getCap());
			if (sedeLegaleCap) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.SEDE_LEGALE_CAP);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("CAP sede legale ");
				this.valex.addElement(FieldList.SEDE_LEGALE_CAP, message.getText());
			}

			final boolean sedeLegaleIndirizzo = StringUtils.isEmpty(sedeLegale.getIndirizzo());
			if (sedeLegaleIndirizzo) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.SEDE_LEGALE_INDIRIZZO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Indirizzo sede legale ");
				this.valex.addElement(FieldList.SEDE_LEGALE_INDIRIZZO, message.getText());
			}

			final boolean sedeLegaleCivico = StringUtils.isEmpty(sedeLegale.getNumeroCivico());
			if (sedeLegaleCivico) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.SEDE_LEGALE_CIVICO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Civico sede legale ");
				this.valex.addElement(FieldList.SEDE_LEGALE_CIVICO, message.getText());
			}
			if (sedi != null && !sedi.isEmpty()) {
				for (Sede sede : sedi) {
					if (sede.getIdTipoSede() == 0) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.SEDE_TIPO_SEDE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Tipo Sede Operativa");
						this.valex.addElement(FieldList.SEDE_TIPO_SEDE, message.getText());
					}
					final boolean emptyComune = StringUtils.isEmpty(sede.getIdComune());
					// if (sede.getIdComune()==0) {
					if (emptyComune) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.SEDE_COMUNE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Comune Sede Operativa");
						this.valex.addElement(FieldList.SEDE_COMUNE, message.getText());
					}

					final boolean emptyCap = StringUtils.isEmpty(sede.getCap());
					validateCap(sede.getCap(), emptyCap, FieldList.SEDE_CAP, "Cap");

					final boolean emptyIndirizzo = StringUtils.isEmpty(sede.getIndirizzo());
					if (emptyIndirizzo) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.SEDE_INDIRIZZO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Indirizzo Sede Operativa");
						this.valex.addElement(FieldList.SEDE_INDIRIZZO, message.getText());
					}
					final boolean emptyCivico = StringUtils.isEmpty(sede.getNumeroCivico());
					if (emptyCivico) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.SEDE_CIVICO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Numero civico Sede Operativa");
						this.valex.addElement(FieldList.SEDE_CIVICO, message.getText());
					}

				}
			}
			// validazione attivita 1,2
			if (!emptyAttivitaPrimaria&&anagraficaAziendale.getIdAttivitaSecondaria() != null
					&& StringUtils.isNotEmpty(anagraficaAziendale.getIdAttivitaSecondaria())
					&& StringUtils.isNotBlank(anagraficaAziendale.getIdAttivitaSecondaria())) {
				if ((Integer.valueOf(anagraficaAziendale
						.getIdAttivitaPrimaria()) != it.csi.taif.taifweb.business.dao.util.Constants.oneInt)
						&& (Integer.valueOf(anagraficaAziendale
								.getIdAttivitaPrimaria()) != it.csi.taif.taifweb.business.dao.util.Constants.twoInt)
						&& (Integer.valueOf(anagraficaAziendale
								.getIdAttivitaSecondaria()) != it.csi.taif.taifweb.business.dao.util.Constants.oneInt)
						&& (Integer.valueOf(anagraficaAziendale
								.getIdAttivitaSecondaria()) != it.csi.taif.taifweb.business.dao.util.Constants.twoInt)) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0019);
					message.replacePlaceholder(
							" Attenzione! Scegliere almeno una attivita con  codice 02-10-00 o 02-20-00 ");
					this.valex.addElement(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE, message.getText());

				}
			} else {
				if (anagraficaAziendale.getIdAttivitaPrimaria() != null
						&& StringUtils.isNotEmpty(anagraficaAziendale.getIdAttivitaPrimaria())
						&& StringUtils.isNotBlank(anagraficaAziendale.getIdAttivitaPrimaria())) {
					if ((Integer.valueOf(anagraficaAziendale
							.getIdAttivitaPrimaria()) != it.csi.taif.taifweb.business.dao.util.Constants.oneInt)
							&& (Integer.valueOf(anagraficaAziendale
									.getIdAttivitaPrimaria()) != it.csi.taif.taifweb.business.dao.util.Constants.twoInt)) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0019);
						message.replacePlaceholder(
								" Attenzione! Scegliere almeno una attivita con  codice 02-10-00 o 02-20-00 ");
						this.valex.addElement(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE, message.getText());

					}
				}
			}
			// validazioni idAttivita diverse

			if (!emptyAttivitaPrimaria&&anagraficaAziendale.getIdAttivitaPrimaria().equals(anagraficaAziendale.getIdAttivitaSecondaria())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0019);
				message.replacePlaceholder(" Attenzione! Scegliere  attivita diverse ");
				this.valex.addElement(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE, message.getText());
			}

			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::validazioneDatiAziendali] END");
		}

	}

	public void validazioneDatiAziendaliFrancese(Integer idAzienda, AnagraficaAziendale anagraficaAziendale,
			Sede sedeLegale, ArrayList<Sede> sedi, String dataTracciato, int idAlbo) throws ManagerException {
		LOG.debug("[ValidationMgr::validazioneDatiAziendali] BEGIN");

		this.valex = null;
		// appDatatitolareRappresentanteLegale.nrsiMsa

		formaGiuridicaFilter.setFlagItaFr(dataTracciato);
		formaGiuridicaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);

		try {

			final boolean emptyCodiceFiscale = StringUtils.isEmpty(anagraficaAziendale.getCodiceFiscale());
			if (emptyCodiceFiscale) {
				this.valex = new ValidationException();
				this.valex.addField(FieldList.DATI_AZIENDALI_CODICE_FISCALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				if (dataTracciato.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
					message.replacePlaceholder("N Siret");
				}
				this.valex.addElement(FieldList.DATI_AZIENDALI_CODICE_FISCALE, message.getText());
			} else {
				checkCodiceFiscaleAziendaFrancese(anagraficaAziendale.getCodiceFiscale(),
						FieldList.DATI_AZIENDALI_CODICE_FISCALE);

			}

			final boolean emptyPartitaIva = StringUtils.isEmpty(anagraficaAziendale.getPartitaIva());
			if (emptyPartitaIva) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_PARTITA_IVA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("N TVA");
				this.valex.addElement(FieldList.DATI_AZIENDALI_PARTITA_IVA, message.getText());
			} else {
				checkTvaFrancese(anagraficaAziendale.getPartitaIva(), FieldList.DATI_AZIENDALI_PARTITA_IVA);
			}

			final boolean emptyDescrizione = StringUtils.isEmpty(anagraficaAziendale.getDescrizione());
			if (emptyDescrizione) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_DESCRIZIONE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Dénomination sociale");
				this.valex.addElement(FieldList.DATI_AZIENDALI_DESCRIZIONE, message.getText());
			}

			final boolean emptyAttivitaPrimaria = StringUtils.isEmpty(anagraficaAziendale.getIdAttivitaPrimaria());
			if (emptyAttivitaPrimaria) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Activité principale");
				this.valex.addElement(FieldList.DATI_AZIENDALI_ATTIVITA_PRINCIPALE, message.getText());
			}

			final boolean emptyFormaGiuridica = StringUtils.isEmpty(anagraficaAziendale.getIdFormaGiurdica());
			final boolean notEmptyFormaGiuridica = StringUtils.isNotEmpty(anagraficaAziendale.getIdFormaGiurdica());
			if (emptyFormaGiuridica) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_FORMA_GIURIDICA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Statut juridique");
				this.valex.addElement(FieldList.DATI_AZIENDALI_FORMA_GIURIDICA, message.getText());
			}

			final boolean emptyNote = StringUtils.isEmpty(anagraficaAziendale.getNote());
			if (emptyNote && notEmptyFormaGiuridica) {
				if (notEmptyFormaGiuridica) {
					formaGiuridicaFilter.setFormaGiuridica("Autre");
					if ((Integer.parseInt(anagraficaAziendale.getIdFormaGiurdica()) == dbMgr
							.getIdFormaGiuridica(formaGiuridicaFilter))
							|| Integer.parseInt(anagraficaAziendale.getIdFormaGiurdica()) == dbMgr
									.getIdFormaGiuridica(formaGiuridicaFilter)) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.DATI_AZIENDALI_NOTE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Notes");
						this.valex.addElement(FieldList.DATI_AZIENDALI_NOTE, message.getText());
					}
				}
			}

			final boolean emptyMail = StringUtils.isEmpty(anagraficaAziendale.getEmail());
			validateMailAdress(anagraficaAziendale.getEmail(), emptyMail, MsgCodeEnum.G0010,
					FieldList.DATI_AZIENDALI_EMAIL, "E-mail");

			final boolean emptyTelefono = StringUtils.isEmpty(anagraficaAziendale.getTelefono());
			validateTelefonNumber(anagraficaAziendale.getTelefono(), emptyTelefono, FieldList.DATI_AZIENDALI_TELEFONO,
					"Telephone ");

			final boolean sedeLegaleComune = StringUtils.isEmpty(sedeLegale.getDsComune());
			if (sedeLegaleComune) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.SEDE_LEGALE_COMUNE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Commune ");
				this.valex.addElement(FieldList.SEDE_LEGALE_COMUNE, message.getText());
			}

			final boolean sedeLegaleCap = StringUtils.isEmpty(sedeLegale.getCap());
			if (sedeLegaleCap) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.SEDE_LEGALE_CAP);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Code Postale ");
				this.valex.addElement(FieldList.SEDE_LEGALE_CAP, message.getText());
			}

			final boolean sedeLegaleIndirizzo = StringUtils.isEmpty(sedeLegale.getIndirizzo());
			if (sedeLegaleIndirizzo) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.SEDE_LEGALE_INDIRIZZO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Adresse ");
				this.valex.addElement(FieldList.SEDE_LEGALE_INDIRIZZO, message.getText());
			}

			final boolean sedeLegaleCivico = StringUtils.isEmpty(sedeLegale.getNumeroCivico());
			if (sedeLegaleCivico) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.SEDE_LEGALE_CIVICO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Numéro ");
				this.valex.addElement(FieldList.SEDE_LEGALE_CIVICO, message.getText());
			}

			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::validazioneDatiAziendali] END");
		}
	}

	public void validazioneTitolariRappresentante(Integer idAzienda, TitolareRappresentanteLegale titolare,
			TitolareRappresentanteLegale altroTitolare, String esisteConduttore) throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneTitolariRappresentante] BEGIN");

		this.valex = null;

		try {
			/*
			 * if (esisteConduttore == null) { if (this.valex == null) { this.valex = new
			 * ValidationException(); } this.valex.addField(FieldList.RADIO_SEL); final
			 * Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			 * message.replacePlaceholder("Radio Sel");
			 * this.valex.addElement(FieldList.RADIO_SEL, message.getText()); }
			 */

			final boolean emptyTitolareCF = StringUtils.isEmpty(titolare.getCodiceFiscale());
			if (emptyTitolareCF) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_CODICE_FISCALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Codice Fiscale");
				this.valex.addElement(FieldList.TITOLARE_RAPP_CODICE_FISCALE, message.getText());
			} else {
				// checkCodiceFiscale(titolare.getCodiceFiscale(),
				// FieldList.TITOLARE_RAPP_CODICE_FISCALE);
			}

			final boolean emptyTitolareNome = StringUtils.isEmpty(titolare.getNome());
			if (emptyTitolareNome) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_NOME);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Nome");
				this.valex.addElement(FieldList.TITOLARE_RAPP_NOME, message.getText());
			}

			final boolean emptyTitolareCognome = StringUtils.isEmpty(titolare.getCognome());
			if (emptyTitolareCognome) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_COGNOME);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Cognome");
				this.valex.addElement(FieldList.TITOLARE_RAPP_COGNOME, message.getText());
			}

			final boolean emptyTitolareDataNascita = StringUtils.isEmpty(titolare.getDataNascita());
			if (emptyTitolareDataNascita) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_DATA_NASCITA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Data di Nascita");
				this.valex.addElement(FieldList.TITOLARE_RAPP_DATA_NASCITA, message.getText());
			} else {
				if (!isValidFormat(titolare.getDataNascita())) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.TITOLARE_RAPP_DATA_NASCITA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0029);
					message.replacePlaceholder("Data di Nascita");
					this.valex.addElement(FieldList.TITOLARE_RAPP_DATA_NASCITA, message.getText());

				}
			}

			final boolean emptyTitolareCap = StringUtils.isEmpty(titolare.getCap());
			validateCap(titolare.getCap(), emptyTitolareCap, FieldList.TITOLARE_RAPP_CAP, "Cap");

			final boolean emptyTitolareCivico = StringUtils.isEmpty(titolare.getCivico());
			if (emptyTitolareCivico) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_CIVICO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Civico");
				this.valex.addElement(FieldList.TITOLARE_RAPP_CIVICO, message.getText());
			}

			final boolean emptyTitolareTelefono = StringUtils.isEmpty(titolare.getTelefono());
			validateTelefonNumber(titolare.getTelefono(), emptyTitolareTelefono, FieldList.TITOLARE_RAPP_TELEFONO,
					"Telefono");

			final boolean emptyTitolareMail = StringUtils.isEmpty(titolare.getEmail());
			validateMailAdress(titolare.getEmail(), emptyTitolareMail, MsgCodeEnum.G007, FieldList.TITOLARE_RAPP_EMAIL,
					"E-mail personale");

			final boolean emptyTitolareIndirizzo = StringUtils.isEmpty(titolare.getIndirizzo());
			if (emptyTitolareIndirizzo) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_INDIRIZZO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Indirizzo (via, piazza...)");
				this.valex.addElement(FieldList.TITOLARE_RAPP_INDIRIZZO, message.getText());
			}

			final boolean emptyStatoNascitaTitolare = StringUtils.isEmpty(titolare.getIdStatoNascita());
			if (emptyStatoNascitaTitolare) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_ID_STATO_NASCITA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Stato di nascita");
				this.valex.addElement(FieldList.TITOLARE_ID_STATO_NASCITA, message.getText());
			}

			final boolean emptyTitoloTitolare = StringUtils.isEmpty(titolare.getIdTitoloDiStudio());
			if (emptyTitoloTitolare) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_ID_TITOLO_STUDI);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Titolo di studio");
				this.valex.addElement(FieldList.TITOLARE_ID_TITOLO_STUDI, message.getText());
			}

			final boolean emptyTitolareResidenza = StringUtils.isEmpty(titolare.getIdComuneResidenza());
			if (emptyTitolareResidenza) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_COM_REZIDENZA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Comune di residenza");
				this.valex.addElement(FieldList.TITOLARE_COM_REZIDENZA, message.getText());
			}

			final boolean emptyTitolareNascita = StringUtils.isEmpty(titolare.getIdComuneNascita())&&StringUtils.isEmpty(titolare.getDsComuneNascitaNoIta());
			if (emptyTitolareNascita) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_COM_NASCITA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Comune");
				this.valex.addElement(FieldList.TITOLARE_COM_NASCITA, message.getText());
			}

			// per conduttore

			if (esisteConduttore != null && esisteConduttore.equals(Constants.NO)) {

				final boolean emptyConduttoreCF = StringUtils.isEmpty(altroTitolare.getCodiceFiscale());
				if (emptyConduttoreCF) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_CODICE_FISCALE);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Codice Fiscale");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_CODICE_FISCALE, message.getText());
				} else {
					// checkCodiceFiscale(altroTitolare.getCodiceFiscale(),
					// FieldList.CONDUTTORE_AZ_CODICE_FISCALE);
				}

				final boolean emptyConduttoreNome = StringUtils.isEmpty(altroTitolare.getNome());
				if (emptyConduttoreNome) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_NOME);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Nome");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_NOME, message.getText());
				}

				final boolean emptyConduttoreCognome = StringUtils.isEmpty(altroTitolare.getCognome());
				if (emptyConduttoreCognome) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_COGNOME);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Cognome");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_COGNOME, message.getText());
				}

				final boolean emptyConduttoreDataNascita = StringUtils.isEmpty(altroTitolare.getDataNascita());
				if (emptyConduttoreDataNascita) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_DATA_NASCITA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Data di Nascita");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_DATA_NASCITA, message.getText());
				} else {
					if (!isValidFormat(altroTitolare.getDataNascita())) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.CONDUTTORE_AZ_DATA_NASCITA);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0029);
						message.replacePlaceholder("Data di Nascita");
						this.valex.addElement(FieldList.CONDUTTORE_AZ_DATA_NASCITA, message.getText());

					}
				}

				final boolean emptyConduttoreCap = StringUtils.isEmpty(altroTitolare.getCap());
				validateCap(altroTitolare.getCap(), emptyConduttoreCap, FieldList.CONDUTTORE_AZ_CAP, "Cap");

				final boolean emptyConduttoreCivico = StringUtils.isEmpty(altroTitolare.getCivico());
				if (emptyConduttoreCivico) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_CIVICO);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Civico");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_CIVICO, message.getText());
				}

				final boolean emptyConduttoreTelefono = StringUtils.isEmpty(altroTitolare.getTelefono());
				// validateTelefonNumber(altroTitolare.getTelefono(), emptyConduttoreTelefono,
				// FieldList.CONDUTTORE_AZ_CELLULARE, "Telefono");

				final boolean emptyConduttoreMail = StringUtils.isEmpty(altroTitolare.getEmail());
				validateMailAdress(altroTitolare.getEmail(), emptyConduttoreMail, MsgCodeEnum.G007,
						FieldList.CONDUTTORE_AZ_EMAIL, "E-mail personale");

				final boolean emptyConduttoreIndirizzo = StringUtils.isEmpty(altroTitolare.getIndirizzo());
				if (emptyConduttoreIndirizzo) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_INDIRIZZO);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Indirizzo (via, piazza...)");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_INDIRIZZO, message.getText());
				}

				final boolean emptyStatoNascitaConduttore = StringUtils.isEmpty(altroTitolare.getIdStatoNascita());
				if (emptyStatoNascitaConduttore) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_ID_STATO_NASCITA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Stato di nascita");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_ID_STATO_NASCITA, message.getText());
				}

				final boolean emptyTitoloConduttore = StringUtils.isEmpty(altroTitolare.getIdTitoloDiStudio());
				if (emptyTitoloConduttore) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_ID_TITOLO_STUDI);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Titolo di studio");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_ID_TITOLO_STUDI, message.getText());
				}

				final boolean emptyConduttoreResidenza = StringUtils.isEmpty(altroTitolare.getIdComuneResidenza());
				if (emptyConduttoreResidenza) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_COM_REZIDENZA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Comune di residenza");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_COM_REZIDENZA, message.getText());
				}

				final boolean emptyConduttoreNascita = StringUtils.isEmpty(altroTitolare.getIdComuneNascita()) && StringUtils.isEmpty(altroTitolare.getDsComuneNascitaNoIta());
				if (emptyConduttoreNascita) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.CONDUTTORE_AZ_COM_NASCITA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Comune");
					this.valex.addElement(FieldList.CONDUTTORE_AZ_COM_NASCITA, message.getText());
				}

			}
			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneTitolariRappresentante] END");
		}
	}

	public void validazioneTitolariRappresentanteFrancese(Integer idAzienda, TitolareRappresentanteLegale titolare)
			throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneTitolariRappresentante] BEGIN");

		this.valex = null;

		try {

			final boolean emptyTitolareMSa = StringUtils.isEmpty(titolare.getNrsiMsa());
			if (emptyTitolareMSa) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_CODICE_FISCALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("N RSI/MSA ");
				this.valex.addElement(FieldList.TITOLARE_RAPP_CODICE_FISCALE, message.getText());
			} else {
				// checkCodiceFiscale(titolare.getCodiceFiscale(),
				// FieldList.TITOLARE_RAPP_CODICE_FISCALE);
			}

			final boolean emptyTitolareNome = StringUtils.isEmpty(titolare.getNome());
			if (emptyTitolareNome) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_NOME);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Nome");
				this.valex.addElement(FieldList.TITOLARE_RAPP_NOME, message.getText());
			}

			final boolean emptyTitolareCognome = StringUtils.isEmpty(titolare.getCognome());
			if (emptyTitolareCognome) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_COGNOME);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Cognome");
				this.valex.addElement(FieldList.TITOLARE_RAPP_COGNOME, message.getText());
			}

			final boolean emptyTitolareDataNascita = StringUtils.isEmpty(titolare.getDataNascita());
			if (emptyTitolareDataNascita) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_DATA_NASCITA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Data di Nascita");
				this.valex.addElement(FieldList.TITOLARE_RAPP_DATA_NASCITA, message.getText());
			} else {
				if (!isValidFormat(titolare.getDataNascita())) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.TITOLARE_RAPP_DATA_NASCITA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0029);
					message.replacePlaceholder("Data di Nascita");
					this.valex.addElement(FieldList.TITOLARE_RAPP_DATA_NASCITA, message.getText());

				}
			}

			final boolean emptyTitolareCap = StringUtils.isEmpty(titolare.getCap());
			validateCap(titolare.getCap(), emptyTitolareCap, FieldList.TITOLARE_RAPP_CAP, "Cap");

			final boolean emptyTitolareCivico = StringUtils.isEmpty(titolare.getCivico());
			if (emptyTitolareCivico) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_CIVICO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Civico");
				this.valex.addElement(FieldList.TITOLARE_RAPP_CIVICO, message.getText());
			}

			final boolean emptyTitolareTelefono = StringUtils.isEmpty(titolare.getTelefono());
			validateTelefonNumber(titolare.getTelefono(), emptyTitolareTelefono, FieldList.TITOLARE_RAPP_TELEFONO,
					"Telefono");

			final boolean emptyTitolareMail = StringUtils.isEmpty(titolare.getEmail());
			validateMailAdress(titolare.getEmail(), emptyTitolareMail, MsgCodeEnum.G007, FieldList.TITOLARE_RAPP_EMAIL,
					"E-mail personale");

			final boolean emptyTitolareIndirizzo = StringUtils.isEmpty(titolare.getIndirizzo());
			if (emptyTitolareIndirizzo) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_RAPP_INDIRIZZO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Indirizzo (via, piazza...)");
				this.valex.addElement(FieldList.TITOLARE_RAPP_INDIRIZZO, message.getText());
			}

			final boolean emptyStatoNascitaTitolare = StringUtils.isEmpty(titolare.getIdStatoNascita());
			if (emptyStatoNascitaTitolare) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_ID_STATO_NASCITA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Stato di nascita");
				this.valex.addElement(FieldList.TITOLARE_ID_STATO_NASCITA, message.getText());
			}

			final boolean emptyTitoloTitolare = StringUtils.isEmpty(titolare.getIdTitoloDiStudio());
			if (emptyTitoloTitolare) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_ID_TITOLO_STUDI);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Titolo di studio");
				this.valex.addElement(FieldList.TITOLARE_ID_TITOLO_STUDI, message.getText());
			}

			if (titolare.getIdStatoNascita() == String.valueOf(1)) {

				final boolean emptyTitolareNascitaIta = StringUtils.isEmpty(titolare.getIdComuneNascita());
				if (emptyTitolareNascitaIta) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.TITOLARE_COM_NASCITA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Comune");
					this.valex.addElement(FieldList.TITOLARE_COM_NASCITA, message.getText());
				}
			} else {
				final boolean emptyDescComuneResidenza = StringUtils.isEmpty(titolare.getDsComuneNascitaNoIta());
				if (emptyDescComuneResidenza) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.TITOLARE_COM_NASCITA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
					message.replacePlaceholder("Comune di residenza");
					this.valex.addElement(FieldList.TITOLARE_COM_NASCITA, message.getText());
				}
			}
			final boolean emptyDescComuneResidenza = StringUtils.isEmpty(titolare.getDsComuneResidenzaNoIta());
			if (emptyDescComuneResidenza) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.TITOLARE_COM_REZIDENZA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Comune");
				this.valex.addElement(FieldList.TITOLARE_COM_REZIDENZA, message.getText());
			}

			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneTitolariRappresentante] END");
		}
	}

	public void validazioneFatturatoECategorieImpresa(Integer idAzienda, GestioneFatturatoCategoriaDiImpresa dto,
			String impresaSelezionalta, FatturatoCategorieDiImpresa fatturatoCategorieDiImpresa)
			throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneFatturatoECategorieImpresa] BEGIN");
		this.valex = null;
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		try {

			final boolean emptyAnnoInizioAttivita = StringUtils.isEmpty(dto.getFatturato().getAnnoInizioAttivita());
			if (emptyAnnoInizioAttivita || (!(checkAnno(dto.getFatturato().getAnnoInizioAttivita())))
					|| (Integer.parseInt(dto.getFatturato().getAnnoInizioAttivita()) > currentYear)) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.FATTURATO_ANNO_INIZIO_ATTIVITA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Anno Inizio attivita");
				this.valex.addElement(FieldList.FATTURATO_ANNO_INIZIO_ATTIVITA, message.getText());
			}

			final boolean emptyFatturatoUltimoAnno = StringUtils.isEmpty(dto.getFatturato().getFatturatoUltimoAnno());
			if (emptyFatturatoUltimoAnno || (!(checkDoubleAndInteger(dto.getFatturato().getFatturatoUltimoAnno()))
					&& !(checkDoubleAndInteger2(dto.getFatturato().getFatturatoUltimoAnno())))) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.FATTURATO_TOTALE_ULTIMO_ANNO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Fatturato titale ultimo anno");
				this.valex.addElement(FieldList.FATTURATO_TOTALE_ULTIMO_ANNO, message.getText());

			}

			// final List<CategoriaImpresa> listCheckCategoria =
			// dto.getElencoCategorieImpresa();
			final boolean emptyImpresaSelezionalta = StringUtils.isEmpty(impresaSelezionalta);
			if (emptyImpresaSelezionalta || impresaSelezionalta.equals("")) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.ELENCO_CATEGORIE_IMPRESE_SELEZIONATE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0014);
				message.replacePlaceholder("Categorie di impresa");
				this.valex.addElement(FieldList.ELENCO_CATEGORIE_IMPRESE_SELEZIONATE, message.getText());
			} else {
				if (impresaSelezionalta.equals(it.csi.taif.taifweb.business.dao.util.Constants.fiveStr)
						|| impresaSelezionalta.equals(it.csi.taif.taifweb.business.dao.util.Constants.ten)) {
					if (StringUtils.isEmpty(dto.getElencoCategorieImpresa().get(0).getAltro())
							&& StringUtils.isEmpty(fatturatoCategorieDiImpresa.getAltro())) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.CATEGORIE_ALTRE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0024);
						message.replacePlaceholder("Altro");
						this.valex.addElement(FieldList.CATEGORIE_ALTRE, message.getText());

					}

				}

			}

			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneTitolariRappresentante] END");
		}
	}

	public void validazioneAssociazioniECertificazioni(Integer idAzienda, ArrayList<Albo> albi,
			ArrayList<FormaOrganizzativa> formeOrganizzative,
			ArrayList<Certificazione> certificazioni, ArrayList<String> listFormeOrganizzative, String esisteAlbo,
			String esisteCertificazione) throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneAssociazioniECertificazioni] BEGIN");
		this.valex = null;

		try {

			if (esisteAlbo == null) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.RADIO_INSCRIZIONE_ALBI);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("L'azienda");
				this.valex.addElement(FieldList.RADIO_INSCRIZIONE_ALBI, message.getText());
			}

			if (esisteCertificazione == null) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.RADIO_CERTIFICAZIONI);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Certificazioni di qualità");
				this.valex.addElement(FieldList.RADIO_CERTIFICAZIONI, message.getText());
			}

			if (esisteAlbo != null && esisteAlbo.equals(Constants.SI)) {
				for (Albo albo : albi) {
					if ((albo.getDenominazione() == null) || (albo.getDataIscrizione() == null)
							|| (albo.getNumeroAlbo()) == null) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.ELENCO_ALTRI_ALBI);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Iscrizione ad altri albi");
						this.valex.addElement(FieldList.ELENCO_ALTRI_ALBI, message.getText());
					}

				}
			}

			if (esisteCertificazione != null && esisteCertificazione.equals(Constants.SI)) {
				for (Certificazione certificato : certificazioni) {
					if ((certificato.getNumero() == null) || (certificato.getEnteCertificatore() == null)
							|| (certificato.getDataScadenza() == null) || (certificato.getAnnoRilascio() == null)) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.ELENCO_CERTIFICAZIONI);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Certificazione di qualita");
						this.valex.addElement(FieldList.ELENCO_CERTIFICAZIONI, message.getText());
					}
					// altro
					if ((certificato
							.getIdTipoCertificazione() == it.csi.taif.taifweb.business.dao.util.Constants.fiveInt)
							&& (certificato.getAltro() == null || StringUtils.isEmpty(certificato.getAltro()))) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.ELENCO_CERTIFICAZIONI);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Certificazione di qualita");
						this.valex.addElement(FieldList.ELENCO_CERTIFICAZIONI, message.getText());
					}

				}
			}
			// theModel.getAppDataassociazioniECertificazioni().getAltro4()
			if (formeOrganizzative != null) {
				for (FormaOrganizzativa formaOrg : formeOrganizzative) {
					if ((formaOrg.getIdFormaOrganizzativa() == it.csi.taif.taifweb.business.dao.util.Constants.five)
							&& ((formaOrg.getAltro() == null) || (StringUtils.isEmpty(formaOrg.getAltro())))) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.ELENCO_FORME_ORGANIZ);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Partecipazioni a forme organizzative");
						this.valex.addElement(FieldList.ELENCO_FORME_ORGANIZ, message.getText());
					}
					if ((formaOrg.getIdFormaOrganizzativa() == it.csi.taif.taifweb.business.dao.util.Constants.sixInt)
							&& ((formaOrg.getAltro() == null) || (StringUtils.isEmpty(formaOrg.getAltro())))) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.ELENCO_FORME_ORGANIZ);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Partecipazioni a forme organizzative");
						this.valex.addElement(FieldList.ELENCO_FORME_ORGANIZ, message.getText());
					}
					if ((formaOrg.getIdFormaOrganizzativa() == it.csi.taif.taifweb.business.dao.util.Constants.sevenInt)
							&& ((formaOrg.getAltro() == null) || (StringUtils.isEmpty(formaOrg.getAltro())))) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.ELENCO_FORME_ORGANIZ);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Partecipazioni a forme organizzative");
						this.valex.addElement(FieldList.ELENCO_FORME_ORGANIZ, message.getText());
					}
				}
			}

			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneAssociazioniECertificazioni] END");
		}

	}

	public void validazioneSalvaAttivitaUltimoAnno(Integer idAzienda,
			GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			List<MaterialePropagazione> elencoMaterialePropagazione, List<String> idMaterialiPropagazione,
			Map<String, Boolean> attivitaMap, String dataTracciato) throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneSalvaAttivitaUltimoAnno] BEGIN");
		this.valex = null;

		try {
			if (gestioneAttivitaUltimoAnno != null) {
				if (attivitaMap.get(Constants.att1)) {
					if (gestioneAttivitaUltimoAnno.getAttivita1() != null) {
						AttivitaUltimoAnno1 attivita1 = gestioneAttivitaUltimoAnno.getAttivita1();
						final boolean emptyPercent = StringUtils.isEmpty(attivita1.getPercentuale());
						if (emptyPercent) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT1_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale attivita ");
							this.valex.addElement(FieldList.ATT1_PERCENTUALE, message.getText());
						}

						if (attivita1.getInterventoInRegione() != null) {
							Intervento att1Regione = attivita1.getInterventoInRegione();

							final boolean emptyRegUttiliz = StringUtils
									.isEmpty(att1Regione.getTotaleVolumiTagliDiUtilizzazione());
							if (emptyRegUttiliz
									|| !(checkDoubleAndInteger(att1Regione.getTotaleVolumiTagliDiUtilizzazione()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_REG_TAGLI_UTILIZ);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Totale volumi");
								this.valex.addElement(FieldList.ATT1_REG_TAGLI_UTILIZ, message.getText());
							}

							final boolean emptyRegUttilizTerzi = StringUtils
									.isEmpty(att1Regione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi());
							if (emptyRegUttilizTerzi || !(checkPercent(
									att1Regione.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_REG_TAGLI_UTILIZ_TERZI);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Percentuale");
								this.valex.addElement(FieldList.ATT1_REG_TAGLI_UTILIZ_TERZI, message.getText());
							}
							final boolean emptyRegPioppeti = StringUtils
									.isEmpty(att1Regione.getTotaleVolumiTaglioPioppeti());
							if (emptyRegPioppeti
									|| !(checkDoubleAndInteger(att1Regione.getTotaleVolumiTaglioPioppeti()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_REG_TAGLI_PIOPPETI);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Totale volumi");
								this.valex.addElement(FieldList.ATT1_REG_TAGLI_PIOPPETI, message.getText());
							}
							final boolean emptyRegPioppetiTerzi = StringUtils
									.isEmpty(att1Regione.getPercentualeVolumiTaglioPioppetiContoTerzi());
							if (emptyRegPioppetiTerzi
									|| !(checkPercent(att1Regione.getPercentualeVolumiTaglioPioppetiContoTerzi()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_REG_TAGLI_PIOPPETI_TERZI);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Percentuale");
								this.valex.addElement(FieldList.ATT1_REG_TAGLI_PIOPPETI_TERZI, message.getText());
							}
							final boolean emptyRegIntercalari = StringUtils
									.isEmpty(att1Regione.getTotaleVolumiTagliIntercalari());
							if (emptyRegIntercalari
									|| !(checkDoubleAndInteger(att1Regione.getTotaleVolumiTagliIntercalari()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_REG_TAGLI_INTERC);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Totale volumi");
								this.valex.addElement(FieldList.ATT1_REG_TAGLI_INTERC, message.getText());
							}
							final boolean emptyRegIntercalariTerzi = StringUtils
									.isEmpty(att1Regione.getPercentualeVolumiTagliIntercalariContoTerzi());
							if (emptyRegIntercalariTerzi
									|| !(checkPercent(att1Regione.getPercentualeVolumiTagliIntercalariContoTerzi()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_REG_TAGLI_INTERC_TERZI);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Percentuale");
								this.valex.addElement(FieldList.ATT1_REG_TAGLI_INTERC_TERZI, message.getText());
							}
						}
						if (attivita1.getInterventoFuoriRegione() != null) {
							Intervento att1FuoriReg = attivita1.getInterventoFuoriRegione();
							final boolean emptyRegUttiliz = StringUtils
									.isEmpty(att1FuoriReg.getTotaleVolumiTagliDiUtilizzazione());
							if (emptyRegUttiliz
									|| !(checkDoubleAndInteger(att1FuoriReg.getTotaleVolumiTagliDiUtilizzazione()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_FUORI_TAGLI_UTILIZ);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Totale volumi");
								this.valex.addElement(FieldList.ATT1_FUORI_TAGLI_UTILIZ, message.getText());
							}

							final boolean emptyFuoroUttilizTerzi = StringUtils
									.isEmpty(att1FuoriReg.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi());
							if (emptyFuoroUttilizTerzi || !(checkPercent(
									att1FuoriReg.getPercentualeVolumiTagliDiUtilizzazioneContoTerzi()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_FUORI_TAGLI_UTILIZ_TERZI);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Percentuale");
								this.valex.addElement(FieldList.ATT1_FUORI_TAGLI_UTILIZ_TERZI, message.getText());
							}
							final boolean emptyFuoriPioppeti = StringUtils
									.isEmpty(att1FuoriReg.getTotaleVolumiTaglioPioppeti());
							if (emptyFuoriPioppeti
									|| !(checkDoubleAndInteger(att1FuoriReg.getTotaleVolumiTaglioPioppeti()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_FUORI_TAGLI_PIOPPETI);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Totale volumi");
								this.valex.addElement(FieldList.ATT1_FUORI_TAGLI_PIOPPETI, message.getText());
							}
							final boolean emptyFuoriPioppetiTerzi = StringUtils
									.isEmpty(att1FuoriReg.getPercentualeVolumiTaglioPioppetiContoTerzi());
							if (emptyFuoriPioppetiTerzi
									|| !(checkPercent(att1FuoriReg.getPercentualeVolumiTaglioPioppetiContoTerzi()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_FUORI_TAGLI_PIOPPETI_TERZI);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Percentuale");
								this.valex.addElement(FieldList.ATT1_FUORI_TAGLI_PIOPPETI_TERZI, message.getText());
							}
							final boolean emptyFuoriIntercalari = StringUtils
									.isEmpty(att1FuoriReg.getTotaleVolumiTagliIntercalari());
							if (emptyFuoriIntercalari
									|| !(checkDoubleAndInteger(att1FuoriReg.getTotaleVolumiTagliIntercalari()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_FUORI_TAGLI_INTERC);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Totale volumi");
								this.valex.addElement(FieldList.ATT1_FUORI_TAGLI_INTERC, message.getText());
							}
							final boolean emptyFuoriIntercalariTerzi = StringUtils
									.isEmpty(att1FuoriReg.getPercentualeVolumiTagliIntercalariContoTerzi());
							if (emptyFuoriIntercalariTerzi
									|| !(checkPercent(att1FuoriReg.getPercentualeVolumiTagliIntercalariContoTerzi()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT1_FUORI_TAGLI_INTERC_TERZI);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Percentuale");
								this.valex.addElement(FieldList.ATT1_FUORI_TAGLI_INTERC_TERZI, message.getText());
							}
						}
					}
				}
				if (attivitaMap.get(Constants.att2)) {
					if (gestioneAttivitaUltimoAnno.getAttivita2() != null) {
						AttivitaUltimoAnno2 attivita2 = gestioneAttivitaUltimoAnno.getAttivita2();
						final boolean emptyEttariRealizzati = StringUtils.isEmpty(attivita2.getEttariRealizzati());
						if (emptyEttariRealizzati || !(checkDoubleAndInteger(attivita2.getEttariRealizzati()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT2_ETTARI_REAL);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Ettari realizzati");
							this.valex.addElement(FieldList.ATT2_ETTARI_REAL, message.getText());
						}
						final boolean emptyPercentualeRealizzati = StringUtils.isEmpty(attivita2.getPercentuale());
						if (emptyPercentualeRealizzati || !(checkPercent(attivita2.getPercentuale()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT2_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale");
							this.valex.addElement(FieldList.ATT2_PERCENTUALE, message.getText());
						}
					}
				}
				if (attivitaMap.get(Constants.att3)) {
					if (gestioneAttivitaUltimoAnno.getAttivita3() != null) {
						AttivitaUltimoAnno3 attivita3 = gestioneAttivitaUltimoAnno.getAttivita3();
						final boolean realizzazione = StringUtils.isEmpty(attivita3.getRealizzazione());
						if (realizzazione || !(checkDoubleAndInteger(attivita3.getRealizzazione()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT3_REALIZZAZIONE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Realizzazzione");
							this.valex.addElement(FieldList.ATT3_REALIZZAZIONE, message.getText());
						}
						final boolean manutenzione = StringUtils.isEmpty(attivita3.getManutenzione());
						if (manutenzione || !(checkDoubleAndInteger(attivita3.getManutenzione()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT3_MANUTENZIONE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Manutenzione");
							this.valex.addElement(FieldList.ATT3_MANUTENZIONE, message.getText());
						}
						final boolean att3Percentuale = StringUtils.isEmpty(attivita3.getPercentuale());
						if (att3Percentuale || !(checkPercent(attivita3.getPercentuale()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT3_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale");
							this.valex.addElement(FieldList.ATT3_PERCENTUALE, message.getText());
						}
					}
				}

				if (attivitaMap.get(Constants.att4)) {
					if (gestioneAttivitaUltimoAnno.getAttivita4() != null) {
						AttivitaUltimoAnno4 attivita4 = gestioneAttivitaUltimoAnno.getAttivita4();
						if (attivita4 != null) {
							List<MaterialePropagazione> materialiPropagazioneList = attivita4
									.getElencoMaterialiPropagazione();
							for (MaterialePropagazione materialePropagazione : materialiPropagazioneList) {
								if (idMaterialiPropagazione!=null && !idMaterialiPropagazione.isEmpty() && idMaterialiPropagazione.contains("6")) {
									if (materialePropagazione.getIdMaterialePropagazione() == 6) {
										boolean propagazioneFiveEmpty = false;
										if(elencoMaterialePropagazione.get(6).getAltro()!= null) {
											 propagazioneFiveEmpty = StringUtils
												.isEmpty(elencoMaterialePropagazione.get(6).getAltro());
										} else {
											propagazioneFiveEmpty = true;
										}
										if (propagazioneFiveEmpty) {
											if (this.valex == null) {
												this.valex = new ValidationException();
											}
											this.valex.addField(FieldList.ATT4_PROPAGAZIONE);
											final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
											message.replacePlaceholder("Altro");
											this.valex.addElement(FieldList.ATT4_PROPAGAZIONE, message.getText());
										}
									}
								}
							}
						} else {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT4_PROPAGAZIONE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0014);
							message.replacePlaceholder("Attivita 4");
							this.valex.addElement(FieldList.ATT4_PROPAGAZIONE, message.getText());
						}

						final boolean att4Percentuale = StringUtils.isEmpty(attivita4.getPercentuale());
						if (att4Percentuale || !(checkPercent(attivita4.getPercentuale()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT4_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale");
							this.valex.addElement(FieldList.ATT4_PERCENTUALE, message.getText());
						}

					}
				}

				if (attivitaMap.get(Constants.att5)) {
					if (gestioneAttivitaUltimoAnno.getAttivita5() != null) {
						AttivitaUltimoAnno5 attivita5 = gestioneAttivitaUltimoAnno.getAttivita5();
						if (attivita5 != null) {
							List<ArboricolturaDaLegno> arboricolturaList = attivita5.getElencoArbolicoltureDaLegno();
							/*
							 * for (ArboricolturaDaLegno arboricoltura : arboricolturaList) { if
							 * ((StringUtils.isEmpty(arboricoltura.getAltro())) ||
							 * (StringUtils.isEmpty(arboricoltura.getConduzione())) ||
							 * (StringUtils.isEmpty(arboricoltura.getManutenzione())) ||
							 * (StringUtils.isEmpty(arboricoltura.getRealizzazione())) ||
							 * !(checkDoubleAndInteger(arboricoltura.getConduzione())) ||
							 * !(checkDoubleAndInteger(arboricoltura.getRealizzazione())) ||
							 * !(checkDoubleAndInteger(arboricoltura.getManutenzione()))) { if (this.valex
							 * == null) { this.valex = new ValidationException(); }
							 * this.valex.addField(FieldList.ATT5_ARB_LEGNO); final Message message =
							 * this.msgMgr.getMessage(MsgCodeEnum.G007);
							 * message.replacePlaceholder("Realizzazzione");
							 * this.valex.addElement(FieldList.ATT5_ARB_LEGNO, message.getText()); }
							 * 
							 * }
							 */
							final boolean att5Percentuale = StringUtils.isEmpty(attivita5.getPercentuale());
							if (att5Percentuale || !(checkPercent(attivita5.getPercentuale()))) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ATT5_PERCENTUALE);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Percentuale");
								this.valex.addElement(FieldList.ATT5_PERCENTUALE, message.getText());
							}
						}
					}

				}
				if (attivitaMap.get(Constants.att6)) {
					if (gestioneAttivitaUltimoAnno.getAttivita6() != null) {
						AttivitaUltimoAnno6 attivita6 = gestioneAttivitaUltimoAnno.getAttivita6();
						final boolean emptyPercentuale6 = StringUtils.isEmpty(attivita6.getPercentuale());
						if (emptyPercentuale6 || !(checkPercent(attivita6.getPercentuale()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT6_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale");
							this.valex.addElement(FieldList.ATT6_PERCENTUALE, message.getText());
						}
					}
				}
				if (attivitaMap.get(Constants.att7)) {
					if (gestioneAttivitaUltimoAnno.getAttivita7() != null) {
						AttivitaUltimoAnno7 attivita7 = gestioneAttivitaUltimoAnno.getAttivita7();
						final boolean emptyPercentuale7 = StringUtils.isEmpty(attivita7.getPercentuale());
						if (emptyPercentuale7 || !(checkPercent(attivita7.getPercentuale()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT7_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale");
							this.valex.addElement(FieldList.ATT7_PERCENTUALE, message.getText());
						}
					}
				}
				if (attivitaMap.get(Constants.att8)) {
					if (gestioneAttivitaUltimoAnno.getAttivita8() != null) {
						AttivitaUltimoAnno8 attivita8 = gestioneAttivitaUltimoAnno.getAttivita8();
						final boolean emptyPercentuale8 = StringUtils.isEmpty(attivita8.getPercentuale());
						if (emptyPercentuale8 || !(checkPercent(attivita8.getPercentuale()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT8_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale");
							this.valex.addElement(FieldList.ATT8_PERCENTUALE, message.getText());
						}
					}
				}
				if (attivitaMap.get(Constants.att9)) {
					if (gestioneAttivitaUltimoAnno.getAttivita9() != null) {
						AttivitaUltimoAnno9 attivita9 = gestioneAttivitaUltimoAnno.getAttivita9();
						final boolean emptyPercentuale9 = StringUtils.isEmpty(attivita9.getPercentuale());
						if (emptyPercentuale9 || !(checkPercent(attivita9.getPercentuale()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATT9_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale");
							this.valex.addElement(FieldList.ATT9_PERCENTUALE, message.getText());
						}
					}
				}

			}
			// verifica attivita comercializzazione
			List<TaifTCommercializzazioneByAziendaDto> listCommercializzazione = new ArrayList<TaifTCommercializzazioneByAziendaDto>();
			listCommercializzazione = dbMgr.findCommerciallizazioneByIdAzienda(idAzienda);
			if (!(attivitaMap.get(Constants.att8) || attivitaMap.get(Constants.att1))
					&& listCommercializzazione.size() > 0) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.ATT8_PERCENTUALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0031);
				message.replacePlaceholder("Attivita 8");
				this.valex.addElement(FieldList.ATT8_PERCENTUALE, message.getText());

			}
			if (valex != null) {
				throw valex;
			}
			//
		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaAttivitaUltimoAnno] END");
		}

	}

	public void validazioneSalvaLavoriPerPAUltimoAnno(Integer idAzienda, ArrayList<LavoroPA> listLavoroPA,
			String esistenzaLavoriPA, String dataTracciato) throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneSalvaLavoriPerPAUltimoAnno] BEGIN");
		this.valex = null;

		try {

			if (esistenzaLavoriPA == null) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.RADIO_SEL);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Radio Sel");
				this.valex.addElement(FieldList.RADIO_SEL, message.getText());
			} else {
				if (esistenzaLavoriPA.equals(Constants.SI)) {
					for (LavoroPA lavoroPA : listLavoroPA) {
						final boolean emptyCommitente = StringUtils.isEmpty(lavoroPA.getCommittente());
						if (emptyCommitente) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.LAVORI_PA_COMMITENTE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Commitente");
							this.valex.addElement(FieldList.LAVORI_PA_COMMITENTE, message.getText());
						} else {
							// checkCommitente(lavoroPA.getCommittente();
						}
						final int intervento = lavoroPA.getIdOggettoIntervento();
						if (intervento == 0) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.LAVORI_PA_INTERVENTO);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Intervento");
							this.valex.addElement(FieldList.LAVORI_PA_INTERVENTO, message.getText());
						}
						final int importo = lavoroPA.getImportoComplessivo();
						if (importo == 0) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.LAVORI_PA_IMPORTO);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Commitente");
							this.valex.addElement(FieldList.LAVORI_PA_IMPORTO, message.getText());
						}
						// if lavoroo=altro
						if (intervento == 6 && (StringUtils.isEmpty(lavoroPA.getAltro())
								|| StringUtils.isBlank(lavoroPA.getAltro()))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.LAVORI_PA_ALTRO);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Altro");
							this.valex.addElement(FieldList.LAVORI_PA_ALTRO, message.getText());
						}

					}
				}
			}
			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaLavoriPerPAUltimoAnno] END");
		}

	}

	// mmm
	public void validazioneSalvaCommercializzazioneLegnameEAssortimentiUltimoAnno(Integer idAzienda,
			ArrayList<LegnameAssortimentoTrattato> listLegname, String esistenzaAttivitaLegname,
			Integer percentualeCommercioFr, boolean existesezione33, String dataTracciato) throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneSalvaCommercializzazioneLegnameEAssortimentiUltimoAnno] BEGIN");
//		AziendaVisibleFilter aziendaVisibleFilterOtto = dbMgr.getAziendaVisibleFilter(idAzienda, dataTracciato,
//				it.csi.taif.taifweb.business.dao.util.Constants.eightInt);
//		AziendaVisibleFilter aziendaVisibleFilterUno = dbMgr.getAziendaVisibleFilter(idAzienda, dataTracciato,
//				it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
		this.valex = null;

		try {
			
			if (esistenzaAttivitaLegname == null) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.RADIO_SEL);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Radio Sel");
				this.valex.addElement(FieldList.RADIO_SEL, message.getText());
			
			}
			// Verifichiamo la presenza di commercializzazioni e di attivita 1 e 8
			this.validazioneAttivita1Attivita8(idAzienda, dataTracciato, listLegname, esistenzaAttivitaLegname );	
			

			if (esistenzaAttivitaLegname.equals(Constants.SI)) {
				for (LegnameAssortimentoTrattato legnameTrattato : listLegname) {
					final Integer idSpecie = legnameTrattato.getIdSpecie();
					if (idSpecie.intValue() == 0) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.LEGNAME_COMM_SPECIE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Specie");
						this.valex.addElement(FieldList.LEGNAME_COMM_SPECIE, message.getText());
					}
					final Integer provenienza = legnameTrattato.getIdProvenienza();
					if (provenienza == 0) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.LEGNAME_COMM_PROVENIENZA);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Provenienza");
						this.valex.addElement(FieldList.LEGNAME_COMM_PROVENIENZA, message.getText());
					}
					final int assortimento = legnameTrattato.getIdAssortimento();
					if (assortimento == 0) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.LEGNAME_COMM_ASSORTIMENTO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Assortimento");
						this.valex.addElement(FieldList.LEGNAME_COMM_ASSORTIMENTO, message.getText());
					}
					if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
						final String idTa = legnameTrattato.getIdTA();
						if (!it.csi.taif.taifweb.business.dao.util.Constants.TAGLIATO.equalsIgnoreCase(idTa)
								&& !it.csi.taif.taifweb.business.dao.util.Constants.ACQUISTATO.equalsIgnoreCase(idTa)) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.LEGNAME_COMM_TA);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("TA");
							this.valex.addElement(FieldList.LEGNAME_COMM_TA, message.getText());
						}

						// se non ho attivita8 o attivita1 e inserico commercializzazione legname
						// List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaUno =
						// dbMgr.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilterUno);
						// List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaOtto =
						// dbMgr.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilterOtto);
						// if((attivitaOtto != null && attivitaOtto.size() == 0 )||(attivitaUno != null
						// && attivitaUno.size() == 0)) {
						// if (this.valex == null) {
						// this.valex = new ValidationException();
						// }
						// this.valex.addField(FieldList.LEGNAME_COMM_SPECIE);
						// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0031);
						// message.replacePlaceholder("Commercializzazione");
						// this.valex.addElement(FieldList.LEGNAME_COMM_SPECIE, message.getText());
						// }
					}

					final boolean idVolVenduto = StringUtils.isEmpty(legnameTrattato.getVolumeVendutoMedioAnnuo());
					if (idVolVenduto) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.LEGNAME_COMM_VEOL_VENDUTO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Volume venduto");
						this.valex.addElement(FieldList.LEGNAME_COMM_VEOL_VENDUTO, message.getText());
					}
					final int idUm = legnameTrattato.getIdUnitaMisura();
					if (idUm == 0) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.LEGNAME_COMM_UM);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Unita misura");
						this.valex.addElement(FieldList.LEGNAME_COMM_UM, message.getText());
					}
					final Integer destinazione = legnameTrattato.getIdDestinazione();
					if (destinazione == 0) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.LEGNAME_COMM_VEOL_VENDUTO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Destinazione");
						this.valex.addElement(FieldList.LEGNAME_COMM_VEOL_VENDUTO, message.getText());
					}
					if (assortimento == 10 && (StringUtils.isEmpty(legnameTrattato.getAltro())
							|| StringUtils.isBlank(legnameTrattato.getAltro()))) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.LEGNAME_COMM_ALTRO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Altro");
						this.valex.addElement(FieldList.LEGNAME_COMM_ALTRO, message.getText());
					}
					if (idSpecie == 33 && (StringUtils.isEmpty(legnameTrattato.getAltro())
							|| StringUtils.isBlank(legnameTrattato.getAltro()))) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.LEGNAME_COMM_ALTRO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Altro");
						this.valex.addElement(FieldList.LEGNAME_COMM_ALTRO, message.getText());
					}

				}

				// // se non ho attivita8 e inserico commercializzazione legname
				// List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaOtto =
				// dbMgr.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilter);
				// if((attivitaOtto != null && attivitaOtto.size() == 0 )) {
				// if (this.valex == null) {
				// this.valex = new ValidationException();
				// }
				// this.valex.addField(FieldList.LEGNAME_COMM_SPECIE);
				// final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0031);
				// message.replacePlaceholder("Commercializzazione");
				// this.valex.addElement(FieldList.LEGNAME_COMM_SPECIE, message.getText());
				// }
				//
				if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.fLang)) {
					final Integer percentualeCommercio = percentualeCommercioFr;
					if (listLegname.size() > 0) {
						if (percentualeCommercio == null || (percentualeCommercio == 0)) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.LEGNAME_COMM_FR_PERCENTUALE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Percentuale Commercio Francese");
							this.valex.addElement(FieldList.LEGNAME_COMM_FR_PERCENTUALE, message.getText());
						}
					}
					if (percentualeCommercio != null && percentualeCommercio > 0) {
						if (listLegname.size() == 0) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.LEGNAME_COMM_SPECIE);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Commercializzazione ");
							this.valex.addElement(FieldList.LEGNAME_COMM_SPECIE, message.getText());
						}
					}
				}
//			} else {
//				if (!existesezione33) {
//					List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaUno = dbMgr
//							.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilterUno);
//					List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaOtto = dbMgr
//							.findAttivitaSvoltaByIdAzienda(aziendaVisibleFilterOtto);
//					if ((attivitaOtto != null && attivitaOtto.size() > 0 && attivitaOtto.get(0).getId() != null)) {
//						if (this.valex == null) {
//							this.valex = new ValidationException();
//						}
//						this.valex.addField(FieldList.LEGNAME_COMM_SPECIE);
//						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0030);
//						message.replacePlaceholder("Commercializzazione");
//						this.valex.addElement(FieldList.LEGNAME_COMM_SPECIE, message.getText());
//					}
//				}
			}
			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaCommercializzazioneLegnameEAssortimentiUltimoAnno] END");
		}

	}

	private void validazioneAttivita1Attivita8(Integer idAzienda, String tracciato,
			ArrayList<LegnameAssortimentoTrattato> listLegname, String esistenzaAttivitaLegname) throws ManagerException {
		LOG.debug("[ValidationMgr::validazioneAttivita1Attivita8] BEGIN");
		try {
			AziendaVisibleFilter uno = this.dbMgr.getAziendaVisibleFilter(idAzienda, tracciato, it.csi.taif.taifweb.business.dao.util.Constants.oneInt);
			List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaUno = dbMgr
					.findAttivitaSvoltaByIdAzienda(uno);
			
			AziendaVisibleFilter otto = this.dbMgr.getAziendaVisibleFilter(idAzienda, tracciato, it.csi.taif.taifweb.business.dao.util.Constants.eightInt);
			
			List<TaifTAttivitaSvoltaAttivitaSvoltaByIdAziendaDto> attivitaOtto = dbMgr
					.findAttivitaSvoltaByIdAzienda(otto);
			
			boolean listLegnameEmpty = listLegname==null||listLegname.isEmpty()||Constants.NO.equalsIgnoreCase(esistenzaAttivitaLegname);
			
			// 1. Se esiste l'attivita 1 o l'attivita 8 sulla scheda 3.1
			// e NON ci sono commercializzazioni, ERRORE G0030
			
			if((attivitaUno!=null && !attivitaUno.isEmpty())||(attivitaOtto!=null && !attivitaOtto.isEmpty())) {
				if(listLegnameEmpty) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.LEGNAME_COMM_SPECIE);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0030);
					message.replacePlaceholder("Commercializzazione");
					this.valex.addElement(FieldList.LEGNAME_COMM_SPECIE, message.getText());
				}
			}
			else if(!listLegnameEmpty) {
				// 2. Se esistono commercializzazioni e NON sono state selezionate
				// almeno una tra attività 1 o attivita 8, ERRORE G0031
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.LEGNAME_COMM_SPECIE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0031);
				message.replacePlaceholder("Commercializzazione");
				this.valex.addElement(FieldList.LEGNAME_COMM_SPECIE, message.getText());
			}
			
			
		}
		finally {
			LOG.debug("[ValidationMgr::validazioneAttivita1Attivita8] END");
		}
	}

	public void validazioneSalvaStrutture(Integer idAzienda, ArrayList<Capannone> capannoni,
			ArrayList<PiazzaleStoccaggio> piazzali, boolean esisteCapannone, boolean esistePiazzaSto,
			String dataTracciato) throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneSalvaCommercializzazioneLegnameEAssortimentiUltimoAnno] BEGIN");
		this.valex = null;

		try {
			if (esisteCapannone) {
				for (Capannone capannone : capannoni) {
					final boolean emptyFunzione = StringUtils.isEmpty(String.valueOf(capannone.getIdFunzione())); // capannone.getFunzioneCapannone()
					if (emptyFunzione) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.CAPANNONE_FUNZIONE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Funzione");
						this.valex.addElement(FieldList.CAPANNONE_FUNZIONE, message.getText());
					}
					final boolean emptyDimensione = StringUtils.isEmpty(capannone.getDimensioneCapannone());
					if (emptyDimensione) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.CAPANNONE_DIMENSIONE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("DIMENSIONE");
						this.valex.addElement(FieldList.CAPANNONE_DIMENSIONE, message.getText());
					}

					final boolean emptyAnnoConstr = StringUtils
							.isEmpty(capannone.getAnnoCostruzioneORiattamentoCapannone());
					if (emptyAnnoConstr) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.CAPANNONE_ANNO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Funzione");
						this.valex.addElement(FieldList.CAPANNONE_ANNO, message.getText());
					}

				}
			}
			if (esistePiazzaSto) {
				for (PiazzaleStoccaggio piazzaleStoccaggio : piazzali) {

					final boolean emptyDimenCApp = StringUtils.isEmpty(piazzaleStoccaggio.getDimensionePiazzale());
					if (emptyDimenCApp) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.CAPANNONE_DIMENSIONE);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("DIMENSIONE");
						this.valex.addElement(FieldList.CAPANNONE_DIMENSIONE, message.getText());
					}

					final boolean emptyAnnoConstrCapp = StringUtils
							.isEmpty(piazzaleStoccaggio.getAnnoCostruzioneORiattamentoPiazzale());
					if (emptyAnnoConstrCapp) {
						if (this.valex == null) {
							this.valex = new ValidationException();
						}
						this.valex.addField(FieldList.CAPANNONE_ANNO);
						final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
						message.replacePlaceholder("Funzione");
						this.valex.addElement(FieldList.CAPANNONE_ANNO, message.getText());
					}

				}
			}
			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaCommercializzazioneLegnameEAssortimentiUltimoAnno] END");
		}

	}

	public void validazioneSalvaAttrezzaturaAntiInfortunisticaMezziDPI(Integer idAzienda,
			ArrayList<MezzoDiProtezioneIndividuale> caschiForestali,
			ArrayList<MezzoDiProtezioneIndividuale> scarponiRinforzati,
			ArrayList<MezzoDiProtezioneIndividuale> pantaloniAntitaglio, Map<String, Boolean> attrezzatureMap,
			String dataTracciato) throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneSalvaAttrezzaturaAntiInfortunisticaMezziDPI] BEGIN");
		this.valex = null;

		try {
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkCaschi)) {
				if (!caschiForestali.isEmpty()) {
					for (MezzoDiProtezioneIndividuale casco : caschiForestali) {
						final boolean emptyQuantita = StringUtils.isEmpty(casco.getQuantita());
						if (emptyQuantita) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATTREZZATURA_CASCO_QUANTITA);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Quantita");
							this.valex.addElement(FieldList.ATTREZZATURA_CASCO_QUANTITA, message.getText());
						}
					}
				}
			}
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkScarponi)) {
				if (!scarponiRinforzati.isEmpty()) {
					for (MezzoDiProtezioneIndividuale scarponi : scarponiRinforzati) {
						final boolean emptyQuantita = StringUtils.isEmpty(scarponi.getQuantita());
						if (emptyQuantita) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATTREZZATURA_SCARPONI_QUANTITA);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Quantita");
							this.valex.addElement(FieldList.ATTREZZATURA_SCARPONI_QUANTITA, message.getText());
						}

					}
				}
			}
			if (attrezzatureMap.get(it.csi.taif.taifweb.util.Constants.checkPantaloni)) {
				if (!pantaloniAntitaglio.isEmpty()) {
					for (MezzoDiProtezioneIndividuale pantaloni : pantaloniAntitaglio) {
						final boolean emptyQuantita = StringUtils.isEmpty(pantaloni.getQuantita());
						if (emptyQuantita) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.ATTREZZATURA_PANTALONI_QUANTITA);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
							message.replacePlaceholder("Quantita");
							this.valex.addElement(FieldList.ATTREZZATURA_PANTALONI_QUANTITA, message.getText());
						}

					}
				}
			}

			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaAttrezzaturaAntiInfortunisticaMezziDPI] END");
		}

	}

	public void validazioneSalvaMacchineEMezzi(Integer idAzienda, GestioneMacchineMezzi gestioneMacchineMezzi,
			Map<String, Boolean> macchineMezziMap, String dataTracciato) throws ManagerException {
		LOG.debug("[ValidationMgr::validazioneSalvaMacchineEMezzi] BEGIN");
		this.valex = null;

		try {
			if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
				if (macchineMezziMap.get(Constants.checkTrattici)) {
					if (gestioneMacchineMezzi.getElencoTrattrici() != null) {
						for (MacchinaMezzo trattici : gestioneMacchineMezzi.getElencoTrattrici()) {

							final boolean emptyAnno = StringUtils.isEmpty(trattici.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnno, FieldList.MEZZI_TRATTICE_ANNO);

							final boolean emptyPOtenza = StringUtils.isEmpty(trattici.getPotenza());
							testPotenzaMezzi(emptyPOtenza, FieldList.MEZZI_TRATTICE_POTENZA);

							final int idTipoTrazione = trattici.getIdTipoTrazione();
							testTrazzioneMezzi(idTipoTrazione, FieldList.MEZZI_TRATTICE_TRAZIONE);

							final int idNoleggioTrattici = trattici.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioTrattici, FieldList.MEZZI_TRATTICE_NOLEGGIO);
						}
					}
				}
				if (macchineMezziMap.get(Constants.checkSpeciali)) {
					if (gestioneMacchineMezzi.getElencoMacchineSpeciali() != null) {
						for (MacchinaMezzo speciali : gestioneMacchineMezzi.getElencoMacchineSpeciali()) {

							final boolean emptyAnno = StringUtils.isEmpty(speciali.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnno, FieldList.MEZZI_SECIALE_ANNO);

							final boolean emptyPOtenza = StringUtils.isEmpty(speciali.getPotenza());
							testPotenzaMezzi(emptyPOtenza, FieldList.MEZZI_SECIALE_POTENZA);

							final int idTipoMacchina = speciali.getIdTipoMacchinaMezzo();
							testTipoMezzi(idTipoMacchina, FieldList.MEZZI_SECIALE_TIPO);

							final int idNoleggioSpeciali = speciali.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioSpeciali, FieldList.MEZZI_SECIALE_NOLEGGIO);
						}
					}
				}

				if (macchineMezziMap.get(Constants.checkTerra)) {
					if (gestioneMacchineMezzi.getElencoMacchineMovimentoTerra() != null) {
						for (MacchinaMezzo terra : gestioneMacchineMezzi.getElencoMacchineMovimentoTerra()) {

							final boolean emptyAnnoTerra = StringUtils.isEmpty(terra.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoTerra, FieldList.MEZZI_TERRA_ANNO);

							final boolean emptyPotenzaTerra = StringUtils.isEmpty(terra.getPotenza());
							testPotenzaMezzi(emptyPotenzaTerra, FieldList.MEZZI_TERRA_POTENZA);

							final int idTipoMacchinaTerra = terra.getIdTipoMacchinaMezzo();
							testTipoMezzi(idTipoMacchinaTerra, FieldList.MEZZI_TERRA_TIPO);

							final int idTipoTrazioneTerra = terra.getIdTipoTrazione();
							if (terra.getIdTipoMacchinaMezzo() != 9) {
								testTrazzioneMezzi(idTipoTrazioneTerra, FieldList.MEZZI_TERRA_TRAZIONE);
							}
							final int idTipoNoleggioTerra = terra.getIdTipoNoleggio();
							testNoleggioMezzi(idTipoNoleggioTerra, FieldList.MEZZI_TERRA_NOLEGGIO);

						}
					}
				}
				if (macchineMezziMap.get(Constants.checkRimorchi)) {
					if (gestioneMacchineMezzi.getElencoRimorchi() != null) {
						for (MacchinaMezzo rimorchio : gestioneMacchineMezzi.getElencoTrattrici()) {

							final boolean emptyAnnoR = StringUtils.isEmpty(rimorchio.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoR, FieldList.MEZZI_RIMORCHI_ANNO);

							final boolean emptyPOtenzaR = StringUtils.isEmpty(rimorchio.getPotenza());
							testPotenzaMezzi(emptyPOtenzaR, FieldList.MEZZI_RIMORCHI_POTENZA);

							final int idTipoTrazioneR = rimorchio.getIdTipoTrazione();
							testTrazzioneMezzi(idTipoTrazioneR, FieldList.MEZZI_RIMORCHI_TRAZIONE);

							final int idNoleggioRimorchi = rimorchio.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioRimorchi, FieldList.MEZZI_RIMORCHI_NOLEGGIO);

						}
					}
				}
				if (macchineMezziMap.get(Constants.checkVerricelli)) {
					if (gestioneMacchineMezzi.getElencoVerricelli() != null) {
						for (MacchinaMezzo vericelli : gestioneMacchineMezzi.getElencoVerricelli()) {

							final boolean emptyAnnoV = StringUtils.isEmpty(vericelli.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoV, FieldList.MEZZI_VERRICELLI_ANNO);

							final boolean emptyPOtenzaV = StringUtils.isEmpty(vericelli.getPotenza());
							testPotenzaMezzi(emptyPOtenzaV, FieldList.MEZZI_VERRICELLI_POTENZA);

							final int idNoleggioVerricelli = vericelli.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioVerricelli, FieldList.MEZZI_VERRICELLI_NOLEGGIO);

							// aggiungere comando a distanza
						}
					}
				}
				if (macchineMezziMap.get(Constants.checkPle)) {
					if (gestioneMacchineMezzi.getElencoPiattaformaElevabile() != null) {
						for (MacchinaMezzo ple : gestioneMacchineMezzi.getElencoPiattaformaElevabile()) {

							final boolean emptyAnnoPle = StringUtils.isEmpty(ple.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoPle, FieldList.MEZZI_PLE_ANNO);

							final boolean emptyPOtenzaPle = StringUtils.isEmpty(ple.getPotenza());
							testPotenzaMezzi(emptyPOtenzaPle, FieldList.MEZZI_PLE_POTENZA);

							final int idNoleggioPle = ple.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioPle, FieldList.MEZZI_PLE_NOLEGGIO);
						}
					}
				}
				if (macchineMezziMap.get(Constants.checkTrincia)) {
					if (gestioneMacchineMezzi.getElencoTrinciaForestale() != null) {
						for (MacchinaMezzo trincia : gestioneMacchineMezzi.getElencoTrinciaForestale()) {

							final boolean emptyAnnoTri = StringUtils.isEmpty(trincia.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoTri, FieldList.MEZZI_TRINCIA_ANNO);

							final boolean emptyPOtenzaTri = StringUtils.isEmpty(trincia.getPotenza());
							testPotenzaMezzi(emptyPOtenzaTri, FieldList.MEZZI_TRINCIA_POTENZA);

							final int idNoleggioTri = trincia.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioTri, FieldList.MEZZI_TRINCIA_NOLEGGIO);
						}
					}
				}
				if (macchineMezziMap.get(Constants.checkSegherie)) {
					if (gestioneMacchineMezzi.getElencoSegherieMobili() != null) {
						for (MacchinaMezzo segherie : gestioneMacchineMezzi.getElencoSegherieMobili()) {

							final boolean emptyAnnoSeg = StringUtils.isEmpty(segherie.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoSeg, FieldList.MEZZI_SEGHERIE_ANNO);

							if (segherie
									.getIdTipoAlimentazione() != it.csi.taif.taifweb.business.dao.util.Constants.twoInt) {
								final boolean emptyPOtenzaSeg = StringUtils.isEmpty(segherie.getPotenza());
								testPotenzaMezzi(emptyPOtenzaSeg, FieldList.MEZZI_SEGHERIE_POTENZA);
							}
							final int idNoleggioSeg = segherie.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioSeg, FieldList.MEZZI_SEGHERIE_NOLEGGIO);

							final int idTipoMacchinaSeg = segherie.getIdTipoMacchinaMezzo();
							testTipoMezzi(idTipoMacchinaSeg, FieldList.MEZZI_SEGHERIE_TIPO);

							final int idTipoAlimSeg = segherie.getIdTipoAlimentazione();
							testTipoAlimentazione(idTipoAlimSeg, FieldList.MEZZI_SEGHERIE_ALIM);

							checkAlimentazionePotenza(segherie.getIdTipoAlimentazione(), segherie.getPotenza());

						}
					}
				}
				if (macchineMezziMap.get(Constants.checkGru)) {
					if (gestioneMacchineMezzi.getElencoGruACavo() != null) {
						for (MacchinaMezzo griCavo : gestioneMacchineMezzi.getElencoGruACavo()) {

							final boolean emptyAnnoSeg = StringUtils.isEmpty(griCavo.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoSeg, FieldList.MEZZI_GRU_ANNO);

							final boolean emptyPOtenzaSeg = StringUtils.isEmpty(griCavo.getPotenza());
							testPotenzaMezzi(emptyPOtenzaSeg, FieldList.MEZZI_GRU_POTENZA);

							final int idNoleggioGRu = griCavo.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioGRu, FieldList.MEZZI_GRU_NOLEGGIO);

							final int idTipoMacchinaSeg = griCavo.getIdTipoMacchinaMezzo();
							testTipoMezzi(idTipoMacchinaSeg, FieldList.MEZZI_GRU_TIPO);

							final boolean emptyPortataGru = StringUtils.isEmpty(griCavo.getPortata());
							testPortataMezzi(emptyPortataGru, FieldList.MEZZI_GRU_PORTATA);

							final int idTipoCarello = griCavo.getIdTipoCarrello();
							testTipoCarello(idTipoCarello, FieldList.MEZZI_GRU_CARELLO);

						}
					}
				}

				if (macchineMezziMap.get(Constants.checkCippatrici)) {
					if (gestioneMacchineMezzi.getElencoCippatrici() != null) {
						for (MacchinaMezzo cipatricci : gestioneMacchineMezzi.getElencoCippatrici()) {
							final boolean emptyAnnoC = StringUtils.isEmpty(cipatricci.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoC, FieldList.MEZZI_CIPPATRICI_ANNO);

							if (cipatricci
									.getIdTipoAlimentazione() != it.csi.taif.taifweb.business.dao.util.Constants.twoInt) {
								final boolean emptyPOtenzaC = StringUtils.isEmpty(cipatricci.getPotenza());
								testPotenzaMezzi(emptyPOtenzaC, FieldList.MEZZI_CIPPATRICI_POTENZA);
							}
							final int idTipoAlimCipp = cipatricci.getIdTipoAlimentazione();
							testTipoAlimentazione(idTipoAlimCipp, FieldList.MEZZI_CIPPATRICI_ALIM);

							final int idNoleggioCipatricci = cipatricci.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioCipatricci, FieldList.MEZZI_CIPPATRICI_NOLEGGIO);

							checkAlimentazionePotenza(cipatricci.getIdTipoAlimentazione(), cipatricci.getPotenza());
						}
					}
				}

				if (macchineMezziMap.get(Constants.checkMezziTra)) {
					if (gestioneMacchineMezzi.getElencoMezziDiTrasporto() != null) {
						for (MacchinaMezzo trasporto : gestioneMacchineMezzi.getElencoMezziDiTrasporto()) {
							final boolean emptyAnnoT = StringUtils.isEmpty(trasporto.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoT, FieldList.MEZZI_TRANSP_ANNO);

							final int idTipoMacchinaMezzo = trasporto.getIdTipoMacchinaMezzo();
							testTipoMezzi(idTipoMacchinaMezzo, FieldList.MEZZI_TRANSP_TIPO);

							final boolean emptyPOtenzaTrs = StringUtils.isEmpty(trasporto.getPotenza());
							testPotenzaMezzi(emptyPOtenzaTrs, FieldList.MEZZI_TRANSP_POTENZA);

							final boolean emptyPortataMezzi = StringUtils.isEmpty(trasporto.getPortata());
							testPortataMezzi(emptyPortataMezzi, FieldList.MEZZI_TRANSP_PORTATA);

							final int idNoleggioTrasporto = trasporto.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioTrasporto, FieldList.MEZZI_TRANSP_NOLEGGIO);
						}
					}
				}
				if (macchineMezziMap.get(Constants.checkMezziAltri)) {
					if (gestioneMacchineMezzi.getElencoMezziDiTrasporto() != null) {
						for (MacchinaMezzo altriMezzi : gestioneMacchineMezzi.getElencoAltriMezzi()) {
							final boolean emptyDescrizione = StringUtils.isEmpty(altriMezzi.getDescrizione());
							if (emptyDescrizione) {
								if (this.valex == null) {
									this.valex = new ValidationException();
								}
								this.valex.addField(FieldList.ALTRI_MEZZI_DESCRIZIONE);
								final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
								message.replacePlaceholder("Descrizione");
								this.valex.addElement(FieldList.ALTRI_MEZZI_DESCRIZIONE, message.getText());
							}

							final boolean emptyAnnoAltrimezzi = StringUtils
									.isEmpty(altriMezzi.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoAltrimezzi, FieldList.ALTRI_MEZZI_ANNO);

							final int idNoleggioSeg = altriMezzi.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioSeg, FieldList.ALTRI_MEZZI_NOLEGGIO);

							checkAlimentazionePotenza(altriMezzi.getIdTipoAlimentazione(), altriMezzi.getPotenza());
						}
					}
				}
			} else {

				// tracciato fr.

				if (macchineMezziMap.get(Constants.checkSpecialiFr)) {
					if (gestioneMacchineMezzi.getElencoMacchineSpecialiFr() != null) {
						for (MacchinaMezzo speciali : gestioneMacchineMezzi.getElencoMacchineSpecialiFr()) {

							final boolean emptyAnno = StringUtils.isEmpty(speciali.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnno, FieldList.MEZZI_SECIALE_FR_ANNO);

							final boolean emptyPOtenza = StringUtils.isEmpty(speciali.getPotenza());
							testPotenzaMezzi(emptyPOtenza, FieldList.MEZZI_SECIALE_FR_POTENZA);

							final int idTipoMacchina = speciali.getIdTipoMacchinaMezzo();
							testTipoMezzi(idTipoMacchina, FieldList.MEZZI_SECIALE_FR_TIPO);

							final int idNoleggioSpeciali = speciali.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioSpeciali, FieldList.MEZZI_SECIALE_FR_NOLEGGIO);
						}
					}
				}

				if (macchineMezziMap.get(Constants.checkTerraFr)) {
					if (gestioneMacchineMezzi.getElencoMacchineMovimentoTerraFr() != null) {
						for (MacchinaMezzo terraFr : gestioneMacchineMezzi.getElencoMacchineMovimentoTerraFr()) {

							final boolean emptyAnnoTerra = StringUtils.isEmpty(terraFr.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoTerra, FieldList.MEZZI_TERRA_FR_ANNO);

							final boolean emptyPotenzaTerra = StringUtils.isEmpty(terraFr.getPotenza());
							testPotenzaMezzi(emptyPotenzaTerra, FieldList.MEZZI_TERRA_FR_POTENZA);

							final int idTipoMacchinaTerra = terraFr.getIdTipoMacchinaMezzo();
							testTipoMezzi(idTipoMacchinaTerra, FieldList.MEZZI_TERRA_FR_TIPO);

							final int idTipoTrazioneTerra = terraFr.getIdTipoTrazione();
							if (terraFr.getIdTipoMacchinaMezzo() == 30) {
								testTrazzioneMezzi(idTipoTrazioneTerra, FieldList.MEZZI_TERRA_FR_TRAZIONE);
							}

							final int idTipoNoleggioTerra = terraFr.getIdTipoNoleggio();
							testNoleggioMezzi(idTipoNoleggioTerra, FieldList.MEZZI_TERRA_FR_NOLEGGIO);

						}
					}
				}
				if (macchineMezziMap.get(Constants.checkRimorchiFr)) {
					if (gestioneMacchineMezzi.getElencoRimorchiFr() != null) {
						for (MacchinaMezzo rimorchio : gestioneMacchineMezzi.getElencoRimorchiFr()) {

							final boolean emptyAnnoR = StringUtils.isEmpty(rimorchio.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoR, FieldList.MEZZI_RIMORCHI_FR_ANNO);

							final boolean emptyPOtenzaR = StringUtils.isEmpty(rimorchio.getPotenza());
							testPotenzaMezzi(emptyPOtenzaR, FieldList.MEZZI_RIMORCHI_FR_POTENZA);

							final int idTipoTrazioneR = rimorchio.getIdTipoTrazione();
							testTrazzioneMezzi(idTipoTrazioneR, FieldList.MEZZI_RIMORCHI_FR_TRAZIONE);

							final int idNoleggioRimorchi = rimorchio.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioRimorchi, FieldList.MEZZI_RIMORCHI_FR_NOLEGGIO);

						}
					}
				}
				if (macchineMezziMap.get(Constants.checkGrumier)) {
					if (gestioneMacchineMezzi.getElencoGrumier() != null) {
						for (MacchinaMezzo grumier : gestioneMacchineMezzi.getElencoGrumier()) {

							final boolean emptyAnnoV = StringUtils.isEmpty(grumier.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoV, FieldList.MEZZI_GRUMIER_FR_ANNO);

							final boolean emptyPOtenzaV = StringUtils.isEmpty(grumier.getPotenza());
							testPotenzaMezzi(emptyPOtenzaV, FieldList.MEZZI_GRUMIER_FR_POTENZA);

							final int idNoleggioGrumier = grumier.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioGrumier, FieldList.MEZZI_GRUMIER_FR_NOLEGGIO);

						}
					}
				}
				if (macchineMezziMap.get(Constants.checkSemi)) {
					if (gestioneMacchineMezzi.getElencoSemi() != null) {
						for (MacchinaMezzo ple : gestioneMacchineMezzi.getElencoSemi()) {
							final boolean emptyAnnoSemi = StringUtils.isEmpty(ple.getAnnoImmatricolazione());
							testAnnoImmatriculazioneMezzi(emptyAnnoSemi, FieldList.MEZZI_SEMI_FR_ANNO);

							final boolean emptyPOtenzaSemi = StringUtils.isEmpty(ple.getPotenza());
							testPotenzaMezzi(emptyPOtenzaSemi, FieldList.MEZZI_SEMI_FR_POTENZA);

							final int idNoleggioSemi = ple.getIdTipoNoleggio();
							testNoleggioMezzi(idNoleggioSemi, FieldList.MEZZI_SEMI_FR_NOLEGGIO);
						}
					}
				}
			}

			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaMacchineEMezzi] END");
		}
	}

	// check alimentazione + potenza
	private void checkAlimentazionePotenza(int idAlimentazione, String valPOtenza) throws ValidationException {
		LOG.debug("[ValidationMgr::checkAlimentazionePotenza] BEGIN");

		if (idAlimentazione == it.csi.taif.taifweb.business.dao.util.Constants.twoInt
				&& (valPOtenza.length() > 0 && Integer.parseInt(valPOtenza) != 0)) {
			if (this.valex == null) {
				this.valex = new ValidationException(this.msgMgr.getMessage(MsgCodeEnum.G0028));
			}
			this.valex.addField(FieldList.ALTRI_MEZZI_POTENZA);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0028);
			message.replacePlaceholder("Potenza");
			this.valex.addElement(FieldList.ALTRI_MEZZI_POTENZA, message.getText());
		}

		LOG.debug("[ValidationMgr::checkAlimentazionePotenza] END");
	}

	private void testTipoAlimentazione(final int idTipoAlimentazione, String fieldElement) {
		if (idTipoAlimentazione == 0) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Alimentazione");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testTipoCarello(final int idTipoCarello, String fieldElement) {
		if (idTipoCarello == 0) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Tipo carello");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testTipoMezzi(final int idTipoMacchinaTerra, String fieldElement) {
		if (idTipoMacchinaTerra == 0) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Tipo macchina");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testAnnoImmatriculazioneMezzi(final boolean emptyAnnoR, String fieldElement) {
		if (emptyAnnoR) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Anno");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testPortataMezzi(final boolean emptyPortataMezzi, String fieldElement) {
		if (emptyPortataMezzi) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Portata");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testTrazzioneMezzi(final int idTipoTrazioneR, String fieldElement) {
		if (idTipoTrazioneR == 0) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Trazione");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testPotenzaMezzi(final boolean emptyPOtenzaV, String fieldElement) {
		if (emptyPOtenzaV) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Potenza");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testNoleggioMezzi(final int idNoleggio, String fieldElement) {
		if (idNoleggio != 0 && idNoleggio != 1) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Noleggio");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private boolean checkDoubleAndInteger(String fatturato) {
		LOG.debug("[ValidationMgr::checkFatturato] BEGIN");
		Pattern pattern = Pattern.compile(RegexConstants.DOUBLE_INTEGER);
		if (fatturato == null)
			return false;
		return pattern.matcher(fatturato).matches();
	}

	private boolean checkDoubleAndInteger2(String fatturato) {
		LOG.debug("[ValidationMgr::checkFatturato] BEGIN");
		Pattern pattern = Pattern.compile(RegexConstants.DOUBLE_INTEGER2);
		if (fatturato == null)
			return false;
		return pattern.matcher(fatturato).matches();
	}

	private boolean checkPercent(String percentVal) {
		LOG.debug("[ValidationMgr::checkFatturato] BEGIN");
		Pattern pattern = Pattern.compile(RegexConstants.PERCENT_PATTERN);
		if (percentVal == null)
			return false;
		return pattern.matcher(percentVal).matches();
	}

	private boolean checkAnno(String annoInizioAttivita) {
		LOG.debug("[ValidationMgr::validateCap] BEGIN");
		Pattern pattern = Pattern.compile(RegexConstants.ANNO_PATTERN);
		if (annoInizioAttivita == null)
			return false;
		return pattern.matcher(annoInizioAttivita).matches();
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
		} /*else {
			if (!validateTelefono(telefono)) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(fieldName);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G009);
				message.replacePlaceholder(placeHolder);
				this.valex.addElement(fieldName, message.getText());
			}

		}*/
	}

	public void validazioneDocumentazioneAllegati(it.csi.taif.taifweb.dto.common.CpDocumentazioneModel theModel,
			TipoAllegatoFilter visibileFilter) throws ManagerException {
		LOG.debug("[ValidationMgr::validazioneDocumentazioneAllegati] BEGIN");

		this.valex = null;

		try {
			if (theModel.getAppDataidTipologiaAllegatoSelezionato().equalsIgnoreCase("")) {
				checkExistValex();
				final Message message1 = this.msgMgr.getMessage(MsgCodeEnum.G0016);
				this.valex.addMessage(message1);
			}

			if (theModel.getAppDataidSottotipologiaAllegatoSelezionato().equalsIgnoreCase("")) {
				checkExistValex();
				final Message message2 = this.msgMgr.getMessage(MsgCodeEnum.G0017);
				this.valex.addMessage(message2);
			}

			if (visibileFilter.getEstensioneFile() == null || visibileFilter.getEstensioneFile().equalsIgnoreCase("")) {
				checkExistValex();
				final Message message3 = this.msgMgr.getMessage(MsgCodeEnum.G0018);
				this.valex.addMessage(message3);
			}

			List<TaifDEstensioneFileEstensioneFileAmmDto> extAmmesse = getDbMgr()
					.getEstensioneFileAmmessa(visibileFilter);
			boolean ammessa = false;
			for (TaifDEstensioneFileEstensioneFileAmmDto tipoEstensione : extAmmesse) {
				if (theModel.getAppDataidSottotipologiaAllegatoSelezionato()
						.equalsIgnoreCase(tipoEstensione.getId_tipo_allegato().toString())) {
					ammessa = true;
					break;
				}
			}
			if (!ammessa) {
				checkExistValex();
				visibileFilter.setIdTipoAllegatoSelezionato(theModel.getAppDataidSottotipologiaAllegatoSelezionato());
				List<TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto> list = getDbMgr()
						.getEstensionePerTipoDocumentoSelezionato(visibileFilter);
				Message message4 = this.msgMgr.getMessage(MsgCodeEnum.G0015);
				String estensioni = "";
				for (TaifDEstensioneFileEstensionePerTipoDocumentoSelezionatoDto t : list) {
					estensioni = estensioni + " " + t.getEstensione();
				}
				String testoMessaggio = message4.getText();
				message4.setText(testoMessaggio + " " + estensioni);
				this.valex.addMessage(message4);
			}

			String flagFirmaCombo = theModel.getAppDataidTipologiaAllegatoSelezionato();
			List<Allegato> listAllegati = theModel.getAppDataelencoAllegati();
			if (listAllegati != null && !listAllegati.isEmpty()
					&& !listAllegati.get(0).getFlagFirma().equalsIgnoreCase(flagFirmaCombo)) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DOCUMENTAZIONE_TIPO_FIRMA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0027);
				this.valex.addElement(FieldList.DOCUMENTAZIONE_TIPO_FIRMA, message.getText());
			}
			
			//taif-24: se per la stessa tipologia di allegato è già stato inserito un file con lo stesso nome
			List<TaifTAllegatoByIdPraticaAllDto> listAllegatiDto = this.dbMgr.getElencoAllAllegatiByPratica(theModel.getAppDataidPratica());
			for(TaifTAllegatoByIdPraticaAllDto allegato: listAllegatiDto) {
				LOG.debug("[ValidationMgr::validazioneDocumentazioneAllegati]allegato.getNomeAllegato()" + allegato.getNomeAllegato() 
						+ " allegato.getIdTipoAll()" + allegato.getIdTipoAll() + 
						   "theModel.getAppDataidSottotipologiaAllegatoSelezionato(): " + theModel.getAppDataidSottotipologiaAllegatoSelezionato());
				LOG.info("[ValidationMgr::validazioneDocumentazioneAllegati]allegato.getNomeAllegato()" + allegato.getNomeAllegato() 
				+ " allegato.getIdTipoAll()" + allegato.getIdTipoAll() + 
				   "theModel.getAppDataidSottotipologiaAllegatoSelezionato(): " + theModel.getAppDataidSottotipologiaAllegatoSelezionato());
				String tipoAllegato = String.valueOf(allegato.getIdTipoAll());

				if(allegato.getNomeAllegato().equals(theModel.getWidg_updFileFileName())
						&& tipoAllegato.equalsIgnoreCase(theModel.getAppDataidSottotipologiaAllegatoSelezionato())) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					final Message message5 = this.msgMgr.getMessage(MsgCodeEnum.G0033);

					this.valex.addMessage(message5);

				}
			}
			
			if(theModel.getWidg_updFile().length() > Constants.INDEX_MAX_SIZE) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				final Message message6 = this.msgMgr.getMessage(MsgCodeEnum.G0034);

				this.valex.addMessage(message6);
			}

			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::validazioneDocumentazioneAllegati] END");
		}
	}

	private void checkExistValex() {
		if (this.valex == null) {
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

	public void checkAziendaSalvata(Integer idAzienda) throws ValidationException {
		LOG.debug("[ValidationMgr::checkAziendaSalvata] BEGIN");
		try {
			if (idAzienda == null) {
				throw new ValidationException(this.getMsgMgr().getMessage(MsgCodeEnum.G0013));
			}
		} finally {
			LOG.debug("[ValidationMgr::checkAziendaSalvata] END");
		}
	}

	public void checkScheda3_2(String tracciato) throws ValidationException {
		LOG.debug("[ValidationMgr::checkScheda3_2] BEGIN");
		try {
			if (tracciato.equalsIgnoreCase(Constants.TRACCIATO_FR)) {
				throw new ValidationException(this.getMsgMgr().getMessage(MsgCodeEnum.G0021));
			}
		} finally {
			LOG.debug("[ValidationMgr::checkScheda3_2] END");
		}
	}

	public void validazioneCodiceFiscaleEPiva(AnagraficaAziendale anagraficaAziendale, String dataTracciato)
			throws DbManagerException, ValidationException {

		boolean esisteCf = dbMgr.existeCodiceFiscaleAzienda(anagraficaAziendale.getCodiceFiscale());
		boolean esistePiva = dbMgr.existePivaAzienda(anagraficaAziendale.getPartitaIva());

		LOG.debug("[ValidationMgr::validazioneDatiAziendali] BEGIN");

		this.valex = null;

		formaGiuridicaFilter.setFlagItaFr("I");
		formaGiuridicaFilter.setFlagVisibile(it.csi.taif.taifweb.business.dao.util.Constants.oneInt);

		try {

			final boolean emptyCodiceFiscale = StringUtils.isEmpty(anagraficaAziendale.getCodiceFiscale());
			if (emptyCodiceFiscale) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex = new ValidationException();
				this.valex.addField(FieldList.DATI_AZIENDALI_CODICE_FISCALE);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Codice Fiscale");
				this.valex.addElement(FieldList.DATI_AZIENDALI_CODICE_FISCALE, message.getText());
			} else {
				// find cf in anagrafica
				if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
					checkCodiceFiscaleAzienda(anagraficaAziendale.getCodiceFiscale(),
							FieldList.DATI_AZIENDALI_CODICE_FISCALE);
				} else {
					checkCodiceFiscaleAziendaFrancese(anagraficaAziendale.getCodiceFiscale(),
							FieldList.DATI_AZIENDALI_CODICE_FISCALE);
				}
				if (esisteCf) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.DATI_AZIENDALI_CODICE_FISCALE);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0019);
					message.replacePlaceholder("Attenzione! Impresa già presente in banca dati");
					this.valex.addElement(FieldList.DATI_AZIENDALI_CODICE_FISCALE, message.getText());
				}

			}

			final boolean emptyPartitaIva = StringUtils.isEmpty(anagraficaAziendale.getPartitaIva());
			if (emptyPartitaIva) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.DATI_AZIENDALI_PARTITA_IVA);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
				message.replacePlaceholder("Partita Iva");
				this.valex.addElement(FieldList.DATI_AZIENDALI_PARTITA_IVA, message.getText());
			} else {
				if (dataTracciato.equals(it.csi.taif.taifweb.business.dao.util.Constants.iLang)) {
					checkPivaAzienda(anagraficaAziendale.getPartitaIva(), FieldList.DATI_AZIENDALI_PARTITA_IVA);
				} else {
					checkTvaFrancese(anagraficaAziendale.getPartitaIva(), FieldList.DATI_AZIENDALI_PARTITA_IVA);
				}
				if (esistePiva) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.DATI_AZIENDALI_PARTITA_IVA);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0019);
					message.replacePlaceholder("Attenzione! Impresa già presente in banca dati");
					this.valex.addElement(FieldList.DATI_AZIENDALI_PARTITA_IVA, message.getText());
				}
			}

			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::validazioneDatiAziendali] END");
		}

	}

	public void validationSalvaPersonale(Integer idAzienda, ArrayList<Personale> elencoPersonale)
			throws ValidationException, DbManagerException {
		LOG.debug("[ValidationMgr::validazioneDatiAziendaliMarcaBollo] BEGIN");
		this.valex = null;
		try {
			List<TaifRPersonaAziendaByIdAziendaDto> personePerAzienda = dbMgr.getPersonePerIdAzienda(idAzienda);
			List<Integer> listPersonePerAzinda = new ArrayList<Integer>();
			if (!personePerAzienda.isEmpty()) {
				for (TaifRPersonaAziendaByIdAziendaDto taifRPersonaAziendaByIdAziendaDto : personePerAzienda) {
					listPersonePerAzinda.add(taifRPersonaAziendaByIdAziendaDto.getId());
				}
			}
			/*
			 * if(elencoPersonale!=null && !elencoPersonale.isEmpty()) { boolean esisteCorso
			 * = false; String corsiPersona =
			 * it.csi.taif.taifweb.business.dao.util.Constants.blank; for (Personale
			 * personale : elencoPersonale) {
			 * if(!(listPersonePerAzinda.contains(personale.getIdPersonale()))) {
			 * listPersonePerAzinda.add(personale.getIdPersonale()); } } for (Integer
			 * idPersona : listPersonePerAzinda) { corsiPersona=
			 * dbMgr.findCorsiPerPersona(idPersona);
			 * if(!(corsiPersona.equals(it.csi.taif.taifweb.business.dao.util.Constants.
			 * blank))) { esisteCorso = true; } } // if (!(esisteCorso)) { // if (this.valex
			 * == null) { // this.valex = new ValidationException(); // } //
			 * this.valex.addField(FieldList.DATI_AZIENDALI_MARCA_DA_BOLLO); // final
			 * Message message = this.msgMgr.getMessage(MsgCodeEnum.G0025); //
			 * message.replacePlaceholder("Marca da Bollo"); //
			 * this.valex.addElement(FieldList.DATI_AZIENDALI_MARCA_DA_BOLLO,
			 * message.getText()); // }
			 * 
			 * 
			 * }
			 */

			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneDatiAziendaliMarcaBollo] END");
		}
	}

	public void validationSalvaPersonaleFrancese(Integer idAzienda, GestionePersonaleFr gestionePersonaleFrancese)
			throws ValidationException {
		// TODO Auto-generated method stub
		LOG.debug("[ValidationMgr::validationSalvaPersonaleFrancese] BEGIN");
		this.valex = null;
		try {
			double totaleContratti = 0.0;
			double targetPerson = 0.0;
			double totaleMansioni = 0.0;
			double numeroContrattiPieno = 0.0;
			if (gestionePersonaleFrancese != null) {
				int numeroTotale = gestionePersonaleFrancese.getNumeroTotaleAddetti();
				targetPerson = numeroTotale;
				// double numeroEqv = new
				// Double(gestionePersonaleFrancese.getNumeroEquivalenti());
				double numeroEqv = StringUtils.stringToDouble(gestionePersonaleFrancese.getNumeroEquivalenti());
				numeroContrattiPieno = numeroEqv;
				ArrayList<PersonaleFr> altroPersonaleContratto = gestionePersonaleFrancese
						.getElencoAltroPersonaleTipoContratto();
				for (PersonaleFr personaleFr : altroPersonaleContratto) {
					totaleContratti = totaleContratti + personaleFr.getNumeroAddetti();
				}
				ArrayList<PersonaleFr> altroPersonaleMansione = gestionePersonaleFrancese
						.getElencoAltroPersonaleTipoMansione();
				for (PersonaleFr personaleFrM : altroPersonaleMansione) {
					totaleMansioni = totaleMansioni + personaleFrM.getNumeroAddetti();
				}
				if (targetPerson < numeroContrattiPieno) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.PERSONALE_TOTALE_ADDETTI);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0020);
					message.replacePlaceholder("Attenzione! Numero  totale addetti < numero addetti al tempo pieno ");
					this.valex.addElement(FieldList.PERSONALE_TOTALE_ADDETTI, message.getText());
				}
				if (targetPerson != totaleContratti) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.PERSONALE_TOTALE_ADDETTI);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0020);
					message.replacePlaceholder("Attenzione! Numero  addetti diverso di totale contratti ");
					this.valex.addElement(FieldList.PERSONALE_TOTALE_ADDETTI, message.getText());
				}
				if (targetPerson != totaleMansioni) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.PERSONALE_TOTALE_ADDETTI);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0020);
					message.replacePlaceholder("Attenzione! Numero  addetti diverso di totale mansioni ");
					this.valex.addElement(FieldList.PERSONALE_TOTALE_ADDETTI, message.getText());
				}
			}
			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validationSalvaPersonaleFrancese] END");
		}

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

	// this.validationMgr.validazionePercentualeAttivita(idAzienda,
	// gestioneAttivitaUltimoAnno);

	public void validazionePercentualeAttivita(Integer idAzienda, GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			Map<String, Boolean> attivitaMap, String dataTracciato) throws ValidationException {
		LOG.debug("[ValidationMgr::validateLoginInfo] BEGIN");
		this.valex = null;
		try {

			double totalePecentuale = 0.0;
			double targetPercentuale = 100.0;
			if (gestioneAttivitaUltimoAnno != null) {
				if (attivitaMap.get(Constants.att1)) {
					if (gestioneAttivitaUltimoAnno.getAttivita1() != null) {
						AttivitaUltimoAnno1 attivita1 = gestioneAttivitaUltimoAnno.getAttivita1();
						totalePecentuale = totalePecentuale + Double.parseDouble(attivita1.getPercentuale());
					}
				}

				if (attivitaMap.get(Constants.att2)) {
					if (gestioneAttivitaUltimoAnno.getAttivita2() != null) {
						AttivitaUltimoAnno2 attivita2 = gestioneAttivitaUltimoAnno.getAttivita2();
						totalePecentuale = totalePecentuale + Double.parseDouble(attivita2.getPercentuale());
					}
				}
				if (attivitaMap.get(Constants.att3)) {
					if (gestioneAttivitaUltimoAnno.getAttivita3() != null) {
						AttivitaUltimoAnno3 attivita3 = gestioneAttivitaUltimoAnno.getAttivita3();
						totalePecentuale = totalePecentuale + Double.parseDouble(attivita3.getPercentuale());
					}
				}
				if (attivitaMap.get(Constants.att4)) {
					if (gestioneAttivitaUltimoAnno.getAttivita4() != null) {
						AttivitaUltimoAnno4 attivita4 = gestioneAttivitaUltimoAnno.getAttivita4();
						totalePecentuale = totalePecentuale + Double.parseDouble(attivita4.getPercentuale());
					}
				}
				if (attivitaMap.get(Constants.att5)) {
					if (gestioneAttivitaUltimoAnno.getAttivita5() != null) {
						AttivitaUltimoAnno5 attivita5 = gestioneAttivitaUltimoAnno.getAttivita5();
						if (attivita5 != null) {
							totalePecentuale = totalePecentuale + Double.parseDouble(attivita5.getPercentuale());
						}
					}
				}
				if (attivitaMap.get(Constants.att6)) {
					if (gestioneAttivitaUltimoAnno.getAttivita6() != null) {
						AttivitaUltimoAnno6 attivita6 = gestioneAttivitaUltimoAnno.getAttivita6();
						totalePecentuale = totalePecentuale + Double.parseDouble(attivita6.getPercentuale());
					}
				}
				if (attivitaMap.get(Constants.att7)) {
					if (gestioneAttivitaUltimoAnno.getAttivita7() != null) {
						AttivitaUltimoAnno7 attivita7 = gestioneAttivitaUltimoAnno.getAttivita7();
						totalePecentuale = totalePecentuale + Double.parseDouble(attivita7.getPercentuale());
					}
				}
				if (attivitaMap.get(Constants.att8)) {
					if (gestioneAttivitaUltimoAnno.getAttivita8() != null) {
						AttivitaUltimoAnno8 attivita8 = gestioneAttivitaUltimoAnno.getAttivita8();
						totalePecentuale = totalePecentuale + Double.parseDouble(attivita8.getPercentuale());
					}
				}
				if (attivitaMap.get(Constants.att9)) {
					if (gestioneAttivitaUltimoAnno.getAttivita9() != null) {
						AttivitaUltimoAnno9 attivita9 = gestioneAttivitaUltimoAnno.getAttivita9();
						totalePecentuale = totalePecentuale + Double.parseDouble(attivita9.getPercentuale());
					}
				}
				if (totalePecentuale != targetPercentuale) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.ATT1_PERCENTUALE);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0020);
					message.replacePlaceholder("Attenzione! Somma  percentuali attivita deve essere 100 ");
					this.valex.addElement(FieldList.ATT1_PERCENTUALE, message.getText());
				}

			}
			if (valex != null) {
				throw valex;
			}

		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaAttivitaUltimoAnno] END");
		}

	}

	public void validateProfiloUtente(int idPersonaR) throws ValidationException {
		LOG.debug("[ValidationMgr::validateProfiloUtente] BEGIN");
		this.valex = null;
		if (idPersonaR == 0) {
			valex = new ValidationException();
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0020);
			message.replacePlaceholder(
					"Attenzione! Non sei abilitato all'accesso. Contattare l'Amministratore di sistema per farsi abilitare");
			this.valex.addField(FieldList.PROFILO);
			this.valex.addElement(FieldList.PROFILO, message.getText());
		}

		if (this.valex != null) {
			throw this.valex;
		}
		LOG.debug("[ValidationMgr::validateProfiloUtente] END");
	}

	public void validazioneSalvaAttivitaUltimoAnnoFrancese(Integer idAzienda,
			GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno, List<String> listIdAttivitaFrancese,
			String dataTracciato) throws ManagerException {

		LOG.debug("[ValidationMgr::validazioneSalvaAttivitaUltimoAnno] BEGIN");
		this.valex = null;

		try {
			if (gestioneAttivitaUltimoAnno != null) {
				AttivitaUltimoAnnoFr attivitaFrancese = gestioneAttivitaUltimoAnno.getAttivitaFr();
				if (attivitaFrancese != null && attivitaFrancese.getElencoAttivitaFr().size() > 0) {
					List<DettaglioAttivitaUltimoAnnoFr> dettaglioFranceseList = new ArrayList<DettaglioAttivitaUltimoAnnoFr>();
					dettaglioFranceseList = attivitaFrancese.getElencoAttivitaFr();
					for (String idTipoAttivita : listIdAttivitaFrancese) {
						for (DettaglioAttivitaUltimoAnnoFr dettaglioAttivitaUltimoAnnoFr : dettaglioFranceseList) {
							if (dettaglioAttivitaUltimoAnnoFr.getIdAttivita() == Integer.parseInt(idTipoAttivita)) {
								final boolean emptyPercentuale = StringUtils
										.isEmpty(dettaglioAttivitaUltimoAnnoFr.getPercentuale().trim());
								if (emptyPercentuale || !StringUtils
										.isNotBlank(dettaglioAttivitaUltimoAnnoFr.getPercentuale().trim())) {
									if (this.valex == null) {
										this.valex = new ValidationException();
									}
									this.valex.addField(FieldList.ATT_FR_PERCENTUALE);
									final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
									message.replacePlaceholder("Percentuale attivita ");
									this.valex.addElement(FieldList.ATT_FR_PERCENTUALE, message.getText());
								}
								final boolean emptyVolume = StringUtils
										.isEmpty(dettaglioAttivitaUltimoAnnoFr.getVolume().trim());
								if (emptyVolume
										|| !StringUtils.isNotBlank(dettaglioAttivitaUltimoAnnoFr.getVolume().trim())) {
									if (!((checkDoubleAndInteger(dettaglioAttivitaUltimoAnnoFr.getVolume().trim()))
											|| (checkDoubleAndInteger2(
													dettaglioAttivitaUltimoAnnoFr.getVolume().trim())))) {
										if (this.valex == null) {
											this.valex = new ValidationException();
										}
										this.valex.addField(FieldList.ATT_FR_VOLUME);
										final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
										message.replacePlaceholder("Volume attivita");
										this.valex.addElement(FieldList.ATT_FR_VOLUME, message.getText());
									}
								}
							}
						}
					}
				}
			}
			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaAttivitaUltimoAnno] END");
		}

	}

	public void validazionePercentualeAttivitaFrancese(GestioneAttivitaUltimoAnno gestioneAttivitaUltimoAnno,
			List<String> listIdAttivitaFrancese, String dataTracciato) throws ValidationException {
		LOG.debug("[ValidationMgr::validateLoginInfo] BEGIN");
		this.valex = null;
		try {
			double totalePecentuale = 0.0;
			double targetPercentuale = 100.0;
			if (gestioneAttivitaUltimoAnno != null) {
				List<DettaglioAttivitaUltimoAnnoFr> dettaglioList = gestioneAttivitaUltimoAnno.getAttivitaFr()
						.getElencoAttivitaFr();
				for (DettaglioAttivitaUltimoAnnoFr dettaglioAttivitaUltimoAnnoFr : dettaglioList) {
					for (String tipoAttivita : listIdAttivitaFrancese) {
						if (dettaglioAttivitaUltimoAnnoFr.getIdAttivita() == Integer.parseInt(tipoAttivita)) {
							totalePecentuale = totalePecentuale
									+ Double.parseDouble(dettaglioAttivitaUltimoAnnoFr.getPercentuale().trim());
						}
					}
				}
				if (totalePecentuale != targetPercentuale) {
					if (this.valex == null) {
						this.valex = new ValidationException();
					}
					this.valex.addField(FieldList.ATT_FR_PERCENTUALE);
					final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0020);
					message.replacePlaceholder("Attenzione! Somma  percentuali attivita deve essere 100 ");
					this.valex.addElement(FieldList.ATT_FR_PERCENTUALE, message.getText());
				}
			}
			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneSalvaAttivitaUltimoAnno] END");
		}

	}

	private void testAnnoImmatriculazioneMezziFrancese(final boolean emptyAnnoR, String fieldElement) {
		if (emptyAnnoR) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Année");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testTrazzioneMezziFrancese(final int idTipoTrazioneR, String fieldElement) {
		if (idTipoTrazioneR == 0) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Traction");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testPotenzaMezziFrancese(final boolean emptyPOtenzaV, String fieldElement) {
		if (emptyPOtenzaV) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Puissance");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testNoleggioMezziFrancese(final int idNoleggio, String fieldElement) {
		if (idNoleggio != 0 && idNoleggio != 1) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Louer");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	private void testTipoMezziFrancese(final int idTipoMacchinaTerra, String fieldElement) {
		if (idTipoMacchinaTerra == 0) {
			if (this.valex == null) {
				this.valex = new ValidationException();
			}
			this.valex.addField(fieldElement);
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G007);
			message.replacePlaceholder("Type de machine");
			this.valex.addElement(fieldElement, message.getText());
		}
	}

	public void checkDate(String date, String field) {
		if (!StringUtils.isStringValid(date, RegexConstants.DATA)) {
			final Message message = this.msgMgr.getMessage(MsgCodeEnum.G004);

			if (this.valex == null) {
				this.valex = new ValidationException(message);
			} else {
				this.valex.addElement(field, message.getText());
			}

			this.valex.addField(field);
		}
	}

	public void validateStato(DettaglioStato dto) throws ValidationException {
		LOG.debug("[ValidationMgr::validateStato] BEGIN");
		this.valex = null;
		if (StringUtils.isNotEmpty(dto.getDataProtocollo())) {
			// this.checkDate(dto.getDataProtocollo(), FieldList.MEZZI_GRU_ANNO);
			if (!isValidFormat(dto.getDataProtocollo())) {
				if (this.valex == null) {
					this.valex = new ValidationException();
				}
				this.valex.addField(FieldList.STATI_PROTOCOLO);
				final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0029);
				message.replacePlaceholder("Data di Protocolo");
				this.valex.addElement(FieldList.STATI_PROTOCOLO, message.getText());
			}
		}
		if (valex != null) {
			throw valex;
		}
		LOG.debug("[ValidationMgr::validateStato] END");
	}

	public void validazioneDatiAziendaliMarcaBollo(Integer idAzienda, AnagraficaAziendale anagraficaAziendale,
			String dataTracciato, int idAlbo) throws ValidationException, DbManagerException {
		LOG.debug("[ValidationMgr::validazioneDatiAziendaliMarcaBollo] BEGIN");
		this.valex = null;
		try {
			if (anagraficaAziendale != null) {
				if (dataTracciato.equalsIgnoreCase(it.csi.taif.taifweb.business.dao.util.Constants.iLang)
						&& (idAlbo != it.csi.taif.taifweb.business.dao.util.Constants.threInt)) {
					String marcaBolloFrontEnd = anagraficaAziendale.getMarcaDaBollo();
					String marcaBolloFind = this.dbMgr.getAziendaById(idAzienda).getNMarcaBollo();
					Integer statoPratica = this.dbMgr.findPraticaPerIdAzienda(idAzienda);
					if (!(statoPratica.intValue() == it.csi.taif.taifweb.business.dao.util.Constants.oneInt)) {
						if (!(marcaBolloFrontEnd.equalsIgnoreCase(marcaBolloFind))) {
							if (this.valex == null) {
								this.valex = new ValidationException();
							}
							this.valex.addField(FieldList.DATI_AZIENDALI_MARCA_DA_BOLLO);
							final Message message = this.msgMgr.getMessage(MsgCodeEnum.G0025);
							message.replacePlaceholder("Marca da Bollo");
							this.valex.addElement(FieldList.DATI_AZIENDALI_MARCA_DA_BOLLO, message.getText());
						}
					}
				}
			}
			if (valex != null) {
				throw valex;
			}
		} finally {
			LOG.debug("[ValidationMgr::validazioneDatiAziendaliMarcaBollo] END");
		}
	}

}
