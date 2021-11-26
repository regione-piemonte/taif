/*
Copyright CSI-Piemonte -2021
SPDX-License-Identifier: EUPL-1.2-or-later.
*/
----------------------AZIENDE------------------------------------------------------

CREATE OR REPLACE VIEW taif_v_yucca_aziende as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale as cf_azienda,
azienda.partita_iva,
azienda.ragione_sociale,
pratica.numero_albo,
pratica.data_iscrizione_albo,
pratica.flg_sezione,
desc_stato.id_stato_pratica,
desc_stato.stato_pratica_ita stato_pratica,
stato.numero_protocollo,
azienda.data_aggiornamento,
azienda.cciaa_sigla_prov,
azienda.cciaa_numero,
tdaaa.attivita attivita_primaria,
tdaaa2.attivita attivita_secondaria,
tdfg.forma_giuridica,
azienda.descr_altra_forma_giuridica,
azienda.anno_inizio,
azienda.fatturato,
tdci.categoria_impresa,
trac.azienda_categimpresa altr_categoria_impresa,
ttsa.istat_comune istat_comune_sede_legale
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_d_stato_pratica desc_stato on stato.fk_stato_pratica=desc_stato.id_stato_pratica
join taif_d_attivita_ateco_ape tdaaa on azienda.fk_attivita_primaria = tdaaa.id_attivita
join taif_d_attivita_ateco_ape tdaaa2  on azienda.fk_attivita_secondaria = tdaaa2.id_attivita
join taif_d_forma_giuridica tdfg on azienda.fk_forma_giuridica_ita = tdfg.id_forma_giuridica 
join taif_r_azienda_categimpresa trac on azienda.id_azienda = trac.id_azienda 
join taif_d_categoria_impresa tdci on trac.id_categoria = tdci.id_categoria 
join taif_t_sede_azienda ttsa on azienda.id_azienda = ttsa.fk_azienda 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and ttsa.fk_tipo_sede = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale;



----------------------SEDI----------------------------------------------------

CREATE OR REPLACE VIEW taif_v_yucca_sedi as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tdtsa.tipo_sede,
ttsa.istat_comune,
ttsa.indirizzo,
ttsa.civico,
ttsa.cap
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_t_sede_azienda ttsa on azienda.id_azienda = ttsa.fk_azienda
join taif_d_tipo_sede_azienda tdtsa on ttsa.fk_tipo_sede = tdtsa.id_tipo_sede 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tdtsa.id_tipo_sede;


-----------------ALTRI ALBI------------------------------

CREATE OR REPLACE VIEW taif_v_yucca_altri_albi as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
ttp.data_iscrizione_albo,
ttp.numero_albo,
ttp.flg_sezione,
ttp.denominazione_altro_albo
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_t_pratica ttp on azienda.id_azienda=ttp.fk_azienda 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and ttp.fk_soggetto_gestore = 0
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale;


-------------CERTIFICAZIONI-------------------------------

CREATE OR REPLACE VIEW taif_v_yucca_certificazioni as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tdtc.tipo_certificazione,
ttc.descr_altro,
ttc.numero,
ttc.ente_certificatore,
ttc.anno,
ttc.data_scadenza 
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_t_certificazione ttc on azienda.id_azienda = ttc.fk_azienda 
join taif_d_tipo_certificazione tdtc on ttc.fk_tipo_certificazione = tdtc.id_tipo_certificazione 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tdtc.id_tipo_certificazione;


-----------ASSOCIAZIONI----------------------

CREATE OR REPLACE VIEW taif_v_yucca_associazioni as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tda.associazione,
traa.nome
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_r_azienda_associazione traa on azienda.id_azienda = traa.id_azienda 
join taif_d_associazione tda on traa.id_associazione = tda.id_associazione 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tda.id_associazione;


------------ATTIVITA SVOLTE---------------

CREATE OR REPLACE VIEW taif_v_yucca_attivita_svolte as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tdta.tipo_attivita,
ttas.perc_fatturato 
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_t_attivita_svolta ttas on azienda.id_azienda = ttas.fk_azienda 
join taif_d_tipo_attivita tdta on ttas.fk_tipo_attivita = tdta.id_tipo_attivita 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tdta.id_tipo_attivita;




-----------------LAVORI PA------------------------------

CREATE OR REPLACE VIEW taif_v_yucca_lavori_pa as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tdtlp.tipo_lavoro_pa,
ttlp.descr_altro,
ttlp.committente,
ttlp.importo
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_t_lavoro_pa ttlp on azienda.id_azienda = ttlp.fk_azienda 
join taif_d_tipo_lavoro_pa tdtlp on ttlp.fk_tipo_lavoro_pa = tdtlp.id_tipo_lavoro_pa 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tdtlp.id_tipo_lavoro_pa;


-----------COMMERCIALIZZAZIONI--------------------------

CREATE OR REPLACE VIEW taif_v_yucca_commercializzazioni as
select  
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tda.assortimento,
tdpd.prov_destin provenienza,
tdpd2.prov_destin destinazione,
tds.nome_specie,
ttc.flg_tagliato_acquistato,
ttc.venduto_medio,
tdudm.unita_di_misura,
ttc.note
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_t_commercializzazione ttc on azienda.id_azienda = ttc.fk_azienda 
join taif_d_assortimento tda on ttc.fk_assortimento = tda.id_assortimento
join taif_d_prov_destin tdpd on ttc.fk_provenienza = tdpd.id_prov_destin 
join taif_d_prov_destin tdpd2 on ttc.fk_destinazione = tdpd2.id_prov_destin 
join taif_d_specie tds on ttc.fk_specie = tds.id_specie
join taif_d_unita_di_misura tdudm on ttc.fk_unita_di_misura = tdudm.id_unita_di_misura 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tda.id_assortimento;



------------STRUTTURE-----------------------

CREATE OR REPLACE VIEW taif_v_yucca_strutture as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tdts.tipo_struttura,
tdf.funzione,
tts.dimensione,
tts.anno
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_t_struttura tts on azienda.id_azienda = tts.fk_azienda 
join taif_d_funzione tdf on tts.fk_funzione = tdf.id_funzione 
join taif_d_tipo_struttura tdts on tdf.fk_tipo_struttura = tdts.id_tipo_struttura 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tdts.id_tipo_struttura, tdf.id_funzione;


--------------DPI-----------------------

CREATE OR REPLACE VIEW taif_v_yucca_dpi as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tdtd.tipo_dpi,
ttd.tipologia,
ttd.quantita,
ttd.anno_scad
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda = pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica = stato.id_pratica
join taif_t_dpi ttd on azienda.id_azienda = ttd.fk_azienda 
join taif_d_tipo_dpi tdtd on ttd.fk_tipo_dpi = tdtd.id_tipo_dpi 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tdtd.id_tipo_dpi;


-------------MEZZI-----------------------------

CREATE OR REPLACE VIEW taif_v_yucca_mezzi as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tdcm.categoria_mezzo,
tdtm.tipo_mezzo,
ttm.descr_altro,
ttm.anno,
tdt.trazione,
tda.alimentazione,
tdtc.tipo_carrello,
ttm.potenza_kw,
ttm.portata_kg,
ttm.flg_comandato_distanza,
ttm.flg_noleggio di_proprieta
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda=pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica=stato.id_pratica
join taif_t_mezzo ttm on azienda.id_azienda = ttm.fk_azienda 
join taif_d_tipo_mezzo tdtm on ttm.fk_tipo_mezzo = tdtm.id_tipo_mezzo 
join taif_d_categoria_mezzo tdcm on tdtm.fk_categoria_mezzo = tdcm.id_categoria_mezzo 
join taif_d_trazione tdt on ttm.fk_trazione = tdt.id_trazione 
join taif_d_alimentazione tda on ttm.fk_alimentazione = tda.id_alimentazione 
join taif_d_tipo_carrello tdtc on ttm.fk_tipo_carrello = tdtc.id_tipo_carrello 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tdcm.id_categoria_mezzo, tdtm.id_tipo_mezzo;


--------------------------PERSONE-------------------
CREATE OR REPLACE VIEW taif_v_yucca_personale as
SELECT
azienda.id_azienda,
pratica.id_pratica,
azienda.codice_fiscale,
azienda.partita_iva,
azienda.ragione_sociale,
tdr.ruolo,
ttp.codice_fiscale,
ttp.cognome,
ttp.nome,
ttp.istat_comune_res,
tdts.titolo_studio ,
trpa.flg_tempo_determinato,
trpa.gg_tempo_determinato,
tdtm.tipo_mansione,
tdti.tipo_inquadramento,
tdtc.tipo_contratto,
tvecp.array_to_string corsi_frequentati,
tveqp.array_to_string qualifiche,
tverp.array_to_string riconoscimenti
FROM
taif_t_azienda azienda
join taif_t_pratica pratica on azienda.id_azienda = pratica.fk_azienda
join taif_t_storico_stato stato on pratica.id_pratica = stato.id_pratica
join taif_r_persona_azienda trpa on azienda.id_azienda = trpa.id_azienda
join taif_t_persona ttp on trpa.id_persona = ttp.id_persona 
join taif_d_ruolo tdr on trpa.fk_ruolo = tdr.id_ruolo 
join taif_d_titolo_studio tdts on ttp.fk_titolo_studio = tdts.id_titolo_studio 
join taif_d_tipo_mansione tdtm on trpa.fk_tipo_mansione = tdtm.id_tipo_mansione 
join taif_d_tipo_inquadramento tdti on trpa.fk_tipo_inquadramento = tdti.id_tipo_inquadramento 
join taif_d_tipo_contratto tdtc on trpa.fk_tipo_contratto = tdtc.id_tipo_contratto 
left join taif_v_elenco_corso_persona tvecp on trpa.id_persona = tvecp.id_persona 
left join taif_v_elenco_qualifica_persona tveqp on trpa.id_persona = tveqp.id_persona 
left join taif_v_elenco_riconoscimento_persona tverp on trpa.id_persona =  tverp.id_persona 
WHERE
stato.data_fine_stato is null
and pratica.fk_soggetto_gestore = 1
and stato.fk_stato_pratica in (4,8,9)
ORDER BY azienda.ragione_sociale, tdr.id_ruolo ;











-------------ELENCO OPERATORI------------------------------

CREATE OR REPLACE VIEW taif_v_yucca_el_op_anagrafica as
select 
ttp.codice_fiscale,
ttp.cognome,
ttp.nome,
ttp.data_nascita,
tdn.nazione_ita,
ttp.istat_comune_nascita,
ttp.comune_estero_nascita,
ttp.istat_comune_res,
ttp.comune_estero_res,
tto.flg_pubblico pubblicabilita,
tdso.stato_opfo_ita
from 
taif_t_persona ttp 
join taif_t_opfo tto on ttp.id_persona = tto.id_persona 
join taif_d_nazione tdn on ttp.fk_nazione = tdn.id_nazione 
join taif_d_stato_opfo tdso on tto.fk_stato_opfo = tdso.id_stato_opfo 
where 
tto.fk_soggetto_gestore = 1
order by ttp.cognome;




---------------CORSI-----------------------------

CREATE OR REPLACE VIEW taif_v_yucca_el_op_corsi as
select 
ttp.codice_fiscale,
ttp.cognome,
ttp.nome,
tdaf.ambito_formativo ,
tduf.sigla,
tduf.unita_formativa ,
ttc.corso ,
ttaf.ragione_sociale agenzia_formativa,
ttc.istat_sede ,
ttc.nro_ore ,
ttc.data_inizio ,
ttc.data_fine ,
troc.flg_esito ,
troc.descrizione_altro 
from 
taif_t_persona ttp 
join taif_t_opfo tto on ttp.id_persona = tto.id_persona 
join taif_r_opfo_corso troc on tto.id_persona = troc.id_persona 
join taif_t_corso ttc  on troc.id_corso = ttc.id_corso 
join taif_d_unita_formativa tduf on ttc.fk_unita_formativa = tduf.id_unita_formativa
join taif_t_agenzia_formativa ttaf on ttc.fk_agenzia_formativa = ttaf.id_agenzia_formativa 
join taif_d_ambito_formativo tdaf on tduf.fk_ambito_formativo = tdaf.id_ambito_formativo 
where 
tto.fk_soggetto_gestore = 1
order by ttp.cognome, ttp.nome, tduf.sigla;




-----QUALIFICHE------------------

CREATE OR REPLACE VIEW taif_v_yucca_el_op_qualifiche as
select 
ttp.codice_fiscale,
ttp.cognome,
ttp.nome,
tdtq.tipo_qualifica ,
ttaf.ragione_sociale agenzia_formativa,
ttq.data_rilascio 
from 
taif_t_persona ttp 
join taif_t_opfo tto on ttp.id_persona = tto.id_persona 
join taif_t_qualifica ttq on tto.id_persona = ttq.fk_persona 
join taif_d_tipo_qualifica tdtq on ttq.fk_tipo_qualifica = tdtq.id_tipo_qualifica 
join taif_t_agenzia_formativa ttaf on ttq.fk_agenzia_formativa = ttaf.id_agenzia_formativa 
where 
tto.fk_soggetto_gestore = 1
order by ttp.cognome, ttp.nome, tdtq.id_tipo_qualifica;



-------------RICONOSCIMENTI------------------

CREATE OR REPLACE VIEW taif_v_yucca_el_op_riconoscimenti as
select 
ttp.codice_fiscale,
ttp.cognome,
ttp.nome,
tduf.sigla ,
tduf.unita_formativa ,
ttaf.ragione_sociale agenzia_formativa
from 
taif_t_persona ttp 
join taif_t_opfo tto on ttp.id_persona = tto.id_persona 
join taif_t_riconoscimento ttr on tto.id_persona = ttr.fk_persona 
join taif_d_unita_formativa tduf on ttr.fk_unita_formativa = tduf.id_unita_formativa 
join taif_t_agenzia_formativa ttaf on ttr.fk_agenzia_formativa = ttaf.id_agenzia_formativa 
where
tto.fk_soggetto_gestore = 1
order by ttp.cognome, ttp.nome, tduf.sigla;