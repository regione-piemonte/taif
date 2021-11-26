/*******************************************************************************
 * Copyright CSI-Piemonte -2021
 * SPDX-License-Identifier: EUPL-1.2-or-later.
 ******************************************************************************/
package it.csi.taif.taifweb.util;

import java.util.ArrayList;

import it.csi.taif.taifweb.dto.common.CodeDescription;
import it.csi.taif.taifweb.dto.domanda.Albo;
import it.csi.taif.taifweb.dto.domanda.ArboricolturaDaLegno;
import it.csi.taif.taifweb.dto.domanda.Capannone;
import it.csi.taif.taifweb.dto.domanda.Certificazione;
import it.csi.taif.taifweb.dto.domanda.DettaglioStato;
import it.csi.taif.taifweb.dto.domanda.LavoroPA;
import it.csi.taif.taifweb.dto.domanda.LegnameAssortimentoTrattato;
import it.csi.taif.taifweb.dto.domanda.MacchinaMezzo;
import it.csi.taif.taifweb.dto.domanda.MezzoDiProtezioneIndividuale;
import it.csi.taif.taifweb.dto.domanda.Personale;
import it.csi.taif.taifweb.dto.domanda.PiazzaleStoccaggio;
import it.csi.taif.taifweb.dto.domanda.Sede;



public class ListUtils {
	
	public static int getMaxRowNumListaSedi(ArrayList<Sede> list) {
		
		int max = 0;
		if(list!=null) {
			for (Sede sede : list) {
				if(sede.getRownum()>max) {
					max = sede.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaAlbi(ArrayList<Albo> list) {
		int max = 0;
		if(list!=null) {
			for (Albo albo : list) {
				if(albo.getRownum()>max) {
					max = albo.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaCertificazioni(ArrayList<Certificazione> list) {
		int max = 0;
		if(list!=null) {
			for (Certificazione certificazione : list) {
				if(certificazione.getRownum()>max) {
					max = certificazione.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaLavoriPA(ArrayList<LavoroPA> list) {
		int max = 0;
		if(list!=null) {
			for (LavoroPA lavoroPA : list) {
				if(lavoroPA.getRownum()>max) {
					max = lavoroPA.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaLegnami(ArrayList<LegnameAssortimentoTrattato> list) {
		int max = 0;
		if(list!=null) {
			for (LegnameAssortimentoTrattato legnameAssortimentoTrattato : list) {
				if(legnameAssortimentoTrattato.getRownum()>max) {
					max = legnameAssortimentoTrattato.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaArboricolturaDaLegno(ArrayList<ArboricolturaDaLegno> list) {
		int max = 0;
		if(list!=null) {
			for (ArboricolturaDaLegno dto : list) {
				if(dto.getRownum()>max) {
					max = dto.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaCapannoni(ArrayList<Capannone> list) {
		int max = 0;
		if(list!=null) {
			for (Capannone dto : list) {
				if(dto.getRownum()>max) {
					max = dto.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaPiazzaliStoccaggio(ArrayList<PiazzaleStoccaggio> list) {
		int max = 0;
		if(list!=null) {
			for (PiazzaleStoccaggio dto : list) {
				if(dto.getRownum()>max) {
					max = dto.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaMezziDiProtezioneIndividuale(ArrayList<MezzoDiProtezioneIndividuale> list) {
		int max = 0;
		if(list!=null) {
			for (MezzoDiProtezioneIndividuale dto : list) {
				if(dto.getRownum()>max) {
					max = dto.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaMacchinaMezzo(ArrayList<MacchinaMezzo> list) {
		int max = 0;
		if(list!=null) {
			for (MacchinaMezzo dto : list) {
				if(dto.getRownum()>max) {
					max = dto.getRownum();
				}
			}
		}
		return max;
	}

	public static int getMaxRowNumListaPersonale(ArrayList<Personale> list) {
		int max = 0;
		if(list!=null) {
			for (Personale dto : list) {
				if(dto.getRownum()>max) {
					max = dto.getRownum();
				}
			}
		}
		return max;
	}
	
	public static ArboricolturaDaLegno addNuovaArboricolturaDaLegno(int rownum, ArrayList<CodeDescription> elencoTipoMateriale) {
		ArboricolturaDaLegno result = new ArboricolturaDaLegno();
		result.setAltro("");
		result.setAltroVisibile(true);
		result.setIconaCancellaVisibile(true);
		result.setRownum(rownum);
		result.setElencoTipoMateriale(elencoTipoMateriale);
		return result;
	} 

	

	public static LegnameAssortimentoTrattato addNuovoLegnameAssortimentoTrattato(int rownum,
			ArrayList<CodeDescription> elencoSpecie, ArrayList<CodeDescription> elencoProvenienza,
			ArrayList<CodeDescription> elencoAssortimento, ArrayList<CodeDescription> elencoTagliatoAquistato,
			ArrayList<CodeDescription> elencoUnitMisura, ArrayList<CodeDescription> elencoDestinazione) {
		LegnameAssortimentoTrattato result = new LegnameAssortimentoTrattato();
		result.setRownum(rownum);
		result.setElencoSpecie(elencoSpecie);
		result.setElencoProvenienze(elencoProvenienza);
		result.setElencoAssortimenti(elencoAssortimento);
		result.setElencoTA(elencoTagliatoAquistato);
		result.setElencoUnitaMisura(elencoUnitMisura);
		result.setElencoDestinazioni(elencoDestinazione);

		return result;
	}
	
	public static Albo addNuovoAlbo(int rownum) {
		Albo result = new Albo();
		result.setRownum(rownum);
		return result;
		}
	
	
	public static LavoroPA addNuovoLavoroPA(int rownum, ArrayList<CodeDescription> list) {
		LavoroPA result = new LavoroPA();
		result.setRownum(rownum);
		result.setElencoOggettiIntervento(list);
		return result;
	}
	
	
	public static Certificazione addNuovaCertificazione(int rownum, ArrayList<CodeDescription> list) {
		Certificazione result = new Certificazione();
		result.setRownum(rownum);
		result.setElencoTipoCertificazione(list);
		return result;
	}
	// da cambiare in elenco
	public static Capannone addNuovoCapannone(int rownum, ArrayList<CodeDescription> list) {
		Capannone result = new Capannone();
		result.setRownum(rownum);
		result.setElencoFunzioni(list);
		return result;
	}
	
	public static PiazzaleStoccaggio addNuovoPiazzaleStoccaggio(int rownum) {
		PiazzaleStoccaggio result = new PiazzaleStoccaggio();
		result.setRownum(rownum);
		return result;
	}
	
	

	public static MezzoDiProtezioneIndividuale addNuovoMezzoDiProtezioneIndividuale(int rownum,
			ArrayList<CodeDescription> list) {
		MezzoDiProtezioneIndividuale result = new MezzoDiProtezioneIndividuale();
		result.setRownum(rownum);
		result.setElencoTipoMezzoDiProtezioneIndividuale(list);
		return result;
	}
	
	public static MacchinaMezzo addNuovaMacchinaTratttice(int rownum, 
			ArrayList<CodeDescription> tipoTrazioni,
			ArrayList<CodeDescription> tipoNoleggi) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoTrazione(tipoTrazioni);
		result.setElencoTipoNoleggio(tipoNoleggi);
		return result;
	}
	
	public static MacchinaMezzo addNuovaMacchinaSpeciale(int rownum, 
			ArrayList<CodeDescription> tipoMezzo,
			ArrayList<CodeDescription> tipoNoleggi) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoMacchinaMezzo(tipoMezzo);
		result.setElencoTipoNoleggio(tipoNoleggi);
		return result;
	}
	
	public static MacchinaMezzo addNuovaMacchinaMovimentoTerra(int rownum,
			ArrayList<CodeDescription> tipoMacchinaMezzo,
			ArrayList<CodeDescription> tipoNoleggi,
			ArrayList<CodeDescription> tipoTrazione
			) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoMacchinaMezzo(tipoMacchinaMezzo);
		result.setElencoTipoNoleggio(tipoNoleggi);
		result.setElencoTipoTrazione(tipoTrazione);
		return result;
	}
	
	
	public static MacchinaMezzo addNuovaMacchinaRimorchi(int rownum,
			ArrayList<CodeDescription> tipoNoleggi,
			ArrayList<CodeDescription> tipoTrazione
			) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoNoleggio(tipoNoleggi);
		result.setElencoTipoTrazione(tipoTrazione);
		return result;
	}
	
	public static MacchinaMezzo addNuovaMacchinaVerricello(int rownum,
			ArrayList<CodeDescription> tipoNoleggi
			) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoNoleggio(tipoNoleggi);
		return result;
	}
	
	
	public static MacchinaMezzo addNuovaMacchinaPle(int rownum,
			ArrayList<CodeDescription> tipoNoleggi
	) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoNoleggio(tipoNoleggi);
		return result;	
	}
	
	
	public static MacchinaMezzo addNuovaMacchinaTrinciaForestale(int rownum,
			ArrayList<CodeDescription> tipoNoleggi
			) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoNoleggio(tipoNoleggi);
		return result;
	}

	
	public static MacchinaMezzo addNuovaMacchinaSegheriaMobile(int rownum,
			ArrayList<CodeDescription> tipoMezzo,
			ArrayList<CodeDescription> tipoAlimentazione,
			ArrayList<CodeDescription> tipoNoleggi) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoMacchinaMezzo(tipoMezzo);
		result.setElencoTipoAlimentazione(tipoAlimentazione);
		result.setElencoTipoNoleggio(tipoNoleggi);
		return result;
	}
	
	
	public static MacchinaMezzo addNuovaMacchinaGruACavo(int rownum,
			ArrayList<CodeDescription> tipoMezzo,
			ArrayList<CodeDescription> tipoNoleggi,
			ArrayList<CodeDescription> tipoCarrello
			) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoMacchinaMezzo(tipoMezzo);
		result.setElencoTipoCarrello(tipoCarrello);
		result.setElencoTipoNoleggio(tipoNoleggi);
		
		return result;
	}
	
	
	public static MacchinaMezzo addNuovaMacchinaCippatrice(int rownum,
			ArrayList<CodeDescription> tipoAlimentazione,
			ArrayList<CodeDescription> tipoNoleggi) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoAlimentazione(tipoAlimentazione);
		result.setElencoTipoNoleggio(tipoNoleggi);
		return result;
	}
	
	
	public static MacchinaMezzo addNuovoMezzoDiTrasporto(int rownum,
			ArrayList<CodeDescription> tipoMacchinaMezzo,
			ArrayList<CodeDescription> tipoNoleggi) {
		MacchinaMezzo result = new MacchinaMezzo();
		result.setRownum(rownum);
		result.setElencoTipoMacchinaMezzo(tipoMacchinaMezzo);
		result.setElencoTipoNoleggio(tipoNoleggi);
		return result;
	}
	 
	public static ArrayList<CodeDescription> createGenericListOfCodeDescription(String ...elements ){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if(elements!=null) {
			for (int i = 0; i < elements.length; i++) {
				CodeDescription obj = new CodeDescription();
				obj.setCode(ConvertUtil.convertToString(i));
				obj.setDescription(elements[i]);
				result.add(obj);
			}
		}
		return result;
	}
	
	public static ArrayList<CodeDescription> createGenericListOfCodeDescriptionSameCode(String ...elements ){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if(elements!=null) {
			for (int i = 0; i < elements.length; i++) {
				CodeDescription obj = new CodeDescription();
				obj.setCode(elements[i]);
				obj.setDescription(elements[i]);
				result.add(obj);
			}
		}
		return result;
	}
	
	public static ArrayList<CodeDescription> createListOfCodeDescription(String ...elements ){
		ArrayList<CodeDescription> result = new ArrayList<CodeDescription>();
		if(elements!=null) {
			for (int i = 0; i < elements.length; i++) {
				CodeDescription obj = new CodeDescription();
				obj.setCode(elements[i]);
				obj.setDescription(elements[i]);
				result.add(obj);
			}
		}
		return result;
	}
	
	
	public static Personale addNuovoPersonale(int rownum, 
			ArrayList<CodeDescription> elencoContratti,
			ArrayList<CodeDescription> elencoDurateContratto,
			ArrayList<CodeDescription> elencoInquadramenti,
			ArrayList<CodeDescription> elencoMansioni,
			ArrayList<CodeDescription> elencoTipologiaPersonale) {
		Personale result = new Personale();
		result.setRownum(rownum);
		result.setCodiceFiscaleEditabile(true);
		result.setCognomeEditabile(true);
		result.setNomeEditabile(true);
		result.setElencoContratti(elencoContratti);
		result.setElencoDurateContratto(elencoDurateContratto);
		result.setElencoInquadramenti(elencoInquadramenti);
		result.setElencoMansioni(elencoMansioni);
		result.setElencoTipologiaPersonale(elencoTipologiaPersonale);
		return result;
	}
	
	public static Sede addNuovaSede(int rownum, ArrayList<CodeDescription> list, ArrayList<CodeDescription> comuni) {
		Sede result = new Sede();
		result.setElencoTipoSede(list);
		result.setElencoComuni(comuni);
		result.setRownum(rownum);
		return result;
	}
	
	public static Sede addSedeLegale(int rownum, ArrayList<CodeDescription> elencoSedi ) {
		Sede result = new Sede();
		result.setRownum(rownum);
		result.setElencoTipoSede(elencoSedi);
		return result;
	}
	
	public static MacchinaMezzo addNuovaMacchinaGrumier(int rownum, ArrayList<CodeDescription> tipoNoleggi) {
        	MacchinaMezzo result = new MacchinaMezzo();
        	result.setRownum(rownum);
        	result.setElencoTipoNoleggio(tipoNoleggi);
        	return result;
	}
	
	public static MacchinaMezzo addNuovaMacchinaSemi(int rownum, ArrayList<CodeDescription> tipoNoleggi) {
        	MacchinaMezzo result = new MacchinaMezzo();
        	result.setRownum(rownum);
        	result.setElencoTipoNoleggio(tipoNoleggi);
        	return result;
	}
	
	public static DettaglioStato addNuovoStato(int rownum, ArrayList<CodeDescription> stati) {
		DettaglioStato result = new DettaglioStato();
		result.setRownum(rownum);
		result.setElencoStatiDomanda(stati);
		result.setEsisteDB(false);
		result.setStatoEditabile(true);
		result.setNumeroProtocolloEditabile(true);
		result.setDataProtocolloEditabile(true);
		result.setNoteEditabile(true);
		result.setEditing(true);
		return result;
	}
	
	public static MacchinaMezzo addNuovaMacchinaAltriMezzi(int rownum,
			ArrayList<CodeDescription> tipoMezzo,
			ArrayList<CodeDescription> tipoNoleggi,
			ArrayList<CodeDescription> tipoCarrello, 
			ArrayList<CodeDescription> tipoAlimentazione,
			ArrayList<CodeDescription> tipoTrazioni) {
		    
	        	MacchinaMezzo result = new MacchinaMezzo();
	        	result.setRownum(rownum);
	        	result.setElencoTipoMacchinaMezzo(tipoMezzo);
	        	result.setElencoTipoCarrello(tipoCarrello);
	        	result.setElencoTipoAlimentazione(tipoAlimentazione);
	        	result.setElencoTipoTrazione(tipoTrazioni);
	        	result.setElencoTipoNoleggio(tipoNoleggi);
		
		return result;
	}
	
	public static ArrayList<CodeDescription> addFirstEmptyElement(ArrayList<CodeDescription> list){
		if(list!=null) {
			CodeDescription empty = new CodeDescription();
			empty.setCode(Constants.NULL_VALUE_ISTAT_PROVINCIA);
			empty.setDescription(Constants.NULL_VALUE_PROVINCIA);
			
			list.add(0, empty);
		}
		return list; 
	}
	
}
