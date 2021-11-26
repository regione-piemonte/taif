/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.business.helper.dto.factory;

import java.util.ArrayList;
import java.util.List;

import it.csi.taif.taifweb.dto.domanda.AnagraficaAziendale;
import it.csi.taif.taifweb.dto.domanda.ImportAziendaAAEP;
import it.csi.taif.taifweb.dto.domanda.TitolareRappresentanteLegale;
import it.csi.taif.taifweb.util.Constants;
import it.csi.taif.taifweb.util.service.integration.aaep.AziendaAAEP;
import it.csi.taif.taifweb.util.service.integration.aaep.RappresentanteLegaleAAEP;
import it.csi.taif.taifweb.util.service.integration.aaep.Sede;

public class AaepFactory {

	public static ImportAziendaAAEP createImportAziendaAAEP(AziendaAAEP azienda, List<Sede> sedi) {
		ImportAziendaAAEP result = new ImportAziendaAAEP();
		result.setAnagraficaAziendale(getAnagraficaAziendale(azienda));
		result.setSedeLegale(getSedeLegale(sedi));
		result.setSediOperative(getSediOperative(sedi));
		result.setTitolareRappresentanteLegale(getTitolareRappresentanteLegale(azienda));
		return result;
	}

	private static TitolareRappresentanteLegale getTitolareRappresentanteLegale(AziendaAAEP azienda) {
		TitolareRappresentanteLegale result = new TitolareRappresentanteLegale();
		if(azienda!=null) {
			RappresentanteLegaleAAEP rapp = azienda.getRappresentanteLegaleAAEP();
			if(rapp!=null) {
				result.setCodiceFiscale(rapp.getCodiceFiscale());
				result.setCognome(rapp.getCognome());
				result.setNome(rapp.getNome());
				result.setDataNascita(rapp.getDataNascita());
				result.setIdComuneNascita(rapp.getCodComuneNascita());
				result.setDsComuneNascitaNoIta(rapp.getDescrComuneNascita());
				result.setIdComuneResidenza(rapp.getCodComuneResidenza());
				result.setDsComuneResidenzaNoIta(rapp.getDescrComuneResidenza());
				result.setIndirizzo(rapp.getIndirizzo());
				result.setCap(rapp.getCap());
			}
		}
		return result;
	}

	private static ArrayList<it.csi.taif.taifweb.dto.domanda.Sede> getSediOperative(List<Sede> sedi) {
		ArrayList<it.csi.taif.taifweb.dto.domanda.Sede> result = new ArrayList<it.csi.taif.taifweb.dto.domanda.Sede>();
		int rownum = 1;
		for (Sede sede : sedi) {
			it.csi.taif.taifweb.dto.domanda.Sede dto = createSede(sede);
			dto.setRownum(rownum);
			rownum++;
			result.add(dto);
		}
		return result;
	}

	private static it.csi.taif.taifweb.dto.domanda.Sede getSedeLegale(List<Sede> sedi) {
		it.csi.taif.taifweb.dto.domanda.Sede result = new it.csi.taif.taifweb.dto.domanda.Sede();
		if(sedi!=null) {
			for (Sede sede : sedi) {
			    if(Constants.AAEP_ID_TIPO_SEDE_LEGALE.equalsIgnoreCase(sede.getIdTipoSede())) {
					result = createSede(sede);
					break;
				}
			}
		}
		return result;
	}
	

	private static it.csi.taif.taifweb.dto.domanda.Sede createSede(Sede sede) {
		it.csi.taif.taifweb.dto.domanda.Sede result = new it.csi.taif.taifweb.dto.domanda.Sede();
		if(sede!=null) {
			//result.setIdComune(sede.getCodComune());
			result.setIstatComuneSede(sede.getCodComune());
			result.setDsComune(sede.getNomeComune());
			result.setCap(sede.getCap());
			result.setIndirizzo(sede.getIndirizzo());
			result.setNumeroCivico(sede.getNumeroCivico());
			if(sede.getTelefono() != null) {
			    result.setTelefono(sede.getTelefono());
			}
			result.setTelefono(sede.getTelefono());
			result.setIdTipoSede(Integer.valueOf(sede.getIdTipoSede()));
		}
		return result;
	}

	private static AnagraficaAziendale getAnagraficaAziendale(AziendaAAEP azienda) {
		AnagraficaAziendale result = new AnagraficaAziendale();
		if(azienda!=null) {
			result.setCodiceFiscale(azienda.getCodiceFiscale());
			result.setPartitaIva(azienda.getPartitaIva());
			result.setDescrizione(azienda.getRagioneSociale());
			result.setIdFormaGiurdica(azienda.getIdNaturaGiuridica());
			result.setIdProvinciaCCIAA(azienda.getProvinciaCCIAA());
			result.setNumeroCCIAA(azienda.getNumeroCCIAA());
			if(azienda.getCodATECO91() == null) {
			    result.setIdAttivitaPrimaria(azienda.getCodATECO2007());  
			}else {
			    result.setIdAttivitaPrimaria(azienda.getCodATECO91());
			}
			result.setIdFormaGiurdica(azienda.getDescrizioneNaturaGiuridica());
			//result.setIdFormaGiurdica(azienda.getIdNaturaGiuridica());
			result.setIdProvinciaCCIAA(azienda.getProvinciaCCIAA());
			result.setNumeroCCIAA(azienda.getNumeroCCIAA());
			
		}
		return result;
	}
	
	

}
