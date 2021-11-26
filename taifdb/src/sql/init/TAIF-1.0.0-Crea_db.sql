/*
Copyright CSI-Piemonte -2021
SPDX-License-Identifier: EUPL-1.2-or-later.
*/

--------------------
-- TABLE PK & FK  --
--------------------

CREATE TABLE taif_appl_scheda_ok
(
	id_azienda            integer  NOT NULL ,
	flg_sez_1_1_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez11_0_1 CHECK (flg_sez_1_1_ita_ok in (0,1)),
	flg_sez_1_2_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez12_0_1 CHECK (flg_sez_1_2_ita_ok in (0,1)),
	flg_sez_2_1_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez21_0_1 CHECK (flg_sez_2_1_ita_ok in (0,1)),
	flg_sez_2_2_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez22_0_1 CHECK (flg_sez_2_2_ita_ok in (0,1)),
	flg_sez_3_1_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez31_0_1 CHECK (flg_sez_3_1_ita_ok in (0,1)),
	flg_sez_3_2_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez32_0_1 CHECK (flg_sez_3_2_ita_ok in (0,1)),
	flg_sez_3_3_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez33_0_1 CHECK (flg_sez_3_3_ita_ok in (0,1)),
	flg_sez_4_ita_ok      NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez4_0_1 CHECK (flg_sez_4_ita_ok in (0,1)),
	flg_sez_5_1_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez51_0_1 CHECK (flg_sez_5_1_ita_ok in (0,1)),
	flg_sez_5_2_ita_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez52_0_1 CHECK (flg_sez_5_2_ita_ok in (0,1)),
	flg_sez_6_ita_ok      NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez6_0_1 CHECK (flg_sez_6_ita_ok in (0,1)),
	flg_sez_1_1_fra_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez11f_0_1 CHECK (flg_sez_1_1_fra_ok in (0,1)),
	flg_sez_1_2_fra_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez12f_0_1 CHECK (flg_sez_1_2_fra_ok in (0,1)),
	flg_sez_2_1_fra_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez21f_0_1 CHECK (flg_sez_2_1_fra_ok in (0,1)),
	flg_sez_2_2_fra_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez22f_0_1 CHECK (flg_sez_2_2_fra_ok in (0,1)),
	flg_sez_3_1_fra_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez31f_0_1 CHECK (flg_sez_3_1_fra_ok in (0,1)),
	flg_sez_3_3_fra_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez33f_0_1 CHECK (flg_sez_3_3_fra_ok in (0,1)),
	flg_sez_4_fra_ok      NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez4f_0_1 CHECK (flg_sez_4_fra_ok in (0,1)),
	flg_sez_5_2_fra_ok    NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez52f_0_1 CHECK (flg_sez_5_2_fra_ok in (0,1)),
	flg_sez_6_fra_ok      NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  sez6f_0_1 CHECK (flg_sez_6_fra_ok in (0,1))
);

ALTER TABLE taif_appl_scheda_ok
	ADD CONSTRAINT  PK_taif_appl_scheda_ok PRIMARY KEY (id_azienda);



CREATE TABLE taif_cnf_attrib_ammesso
(
	fk_tipo_mezzo         integer  NOT NULL ,
	nome_attrib           CHARACTER VARYING(50)  NOT NULL ,
	mtd_ordinamento       NUMERIC(3)  NULL 
);

ALTER TABLE taif_cnf_attrib_ammesso
	ADD CONSTRAINT  PK_taif_cnf_attrib_ammesso PRIMARY KEY (fk_tipo_mezzo,nome_attrib);



CREATE TABLE taif_cnf_config_utente
(
	id_config_utente      INTEGER  NOT NULL ,
	fk_profilo_utente     integer  NOT NULL ,
	fk_persona            integer  NOT NULL ,
	fk_soggetto_gestore   INTEGER   DEFAULT  99 NOT NULL ,
	nr_accessi            INTEGER  NOT NULL ,
	data_primo_accesso    TIMESTAMP  NOT NULL ,
	data_ultimo_accesso   TIMESTAMP  NOT NULL 
);

ALTER TABLE taif_cnf_config_utente
	ADD CONSTRAINT  PK_taif_cnf_config_utente PRIMARY KEY (id_config_utente);



CREATE TABLE taif_cnf_estens_amm
(
	id_estensione_file    INTEGER  NOT NULL ,
	id_tipo_allegato      integer  NOT NULL 
);

ALTER TABLE taif_cnf_estens_amm
	ADD CONSTRAINT  PK_taif_cnf_estens_amm PRIMARY KEY (id_estensione_file,id_tipo_allegato);



CREATE TABLE taif_cnf_mail
(
	id_mail               INTEGER  NOT NULL ,
	host                  CHARACTER VARYING(100)  NOT NULL ,
	porta                 NUMERIC(6,0)  NULL ,
	user_id               CHARACTER VARYING(100)  NULL ,
	password              CHARACTER VARYING(100)  NULL ,
	protocollo            CHARACTER VARYING(100)  NULL ,
	mittente              CHARACTER VARYING(100)  NULL ,
	des_tipo_posta        CHARACTER VARYING(100)  NULL 
);

ALTER TABLE taif_cnf_mail
	ADD CONSTRAINT  PK_taif_cnf_mail PRIMARY KEY (id_mail);



CREATE TABLE taif_cnf_procedura
(
	id_procedura          INTEGER  NOT NULL ,
	nome_procedura        character varying(50)  NOT NULL 
);

ALTER TABLE taif_cnf_procedura
	ADD CONSTRAINT  PK_taif_cnf_procedura PRIMARY KEY (id_procedura);



CREATE TABLE taif_cnf_profilo_utente
(
	id_profilo_utente     integer  NOT NULL ,
	profilo_utente        character varying(100)  NOT NULL ,
	mtd_flg_attivo        numeric(1)  NULL  CONSTRAINT  attiv_0_1 CHECK (mtd_flg_attivo in (0,1)),
	fk_procedura          INTEGER  NOT NULL 
);



ALTER TABLE taif_cnf_profilo_utente
	ADD CONSTRAINT  PK_taif_cnf_profilo_utente PRIMARY KEY (id_profilo_utente);



CREATE TABLE taif_cnf_tipo_allegato
(
	id_tipo_allegato      integer  NOT NULL ,
	fk_procedura          INTEGER  NOT NULL ,
	tipo_allegato         character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis7_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if7_i_f CHECK (mtd_flg_ita_fra in ('I', 'F')),
	flg_contesto          character varying(1)  NULL  CONSTRAINT  dom_d_c_x CHECK (flg_contesto in ('X', 'C', 'D')),
	flg_firma             character varying(1)  NULL  CONSTRAINT  dom_a_d CHECK (flg_firma in ('A', 'D')),
	flg_download          NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  down_0_1 CHECK (flg_download in (0,1)),
	flg_upload            NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  upl_0_1 CHECK (flg_upload in (0,1)),
	flg_invio             NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  invio_0_1 CHECK (flg_invio in (0,1)),
	acta_oggetto          CHARACTER VARYING(100)  NULL ,
	acta_flg_allegati     CHARACTER VARYING(1)  NULL ,
	acta_stato_di_efficacia  CHARACTER VARYING(100)  NULL 
);



ALTER TABLE taif_cnf_tipo_allegato
	ADD CONSTRAINT  PK_taif_cnf_tipo_allegato PRIMARY KEY (id_tipo_allegato);



CREATE TABLE taif_cnf_tipo_mail
(
	id_tipo_mail          integer  NOT NULL ,
	fk_stato_pratica      integer  NOT NULL ,
	flg_tipo_mail         numeric(1)  NULL  CONSTRAINT  tipo_mail_1_2 CHECK (flg_tipo_mail in (1,2)),
	oggetto               character varying(1000)  NOT NULL ,
	testo                 CHARACTER VARYING(5000)  NULL 
);



ALTER TABLE taif_cnf_tipo_mail
	ADD CONSTRAINT  PK_taif_cnf_tipo_mail PRIMARY KEY (id_tipo_mail);



CREATE TABLE taif_d_alimentazione
(
	id_alimentazione      integer  NOT NULL ,
	alimentazione         character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis5_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_alimentazione
	ADD CONSTRAINT  PK_taif_d_alimentazione PRIMARY KEY (id_alimentazione);



CREATE TABLE taif_d_ambito_formativo
(
	id_ambito_formativo   integer  NOT NULL ,
	ambito_formativo      character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis24_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if24_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_ambito_formativo
	ADD CONSTRAINT  PK_taif_d_ambito_formativo PRIMARY KEY (id_ambito_formativo);



CREATE TABLE taif_d_associazione
(
	id_associazione       integer  NOT NULL ,
	associazione          character varying(100)  NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis9_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if9_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_associazione
	ADD CONSTRAINT  PK_taif_d_associazione PRIMARY KEY (id_associazione);



CREATE TABLE taif_d_assortimento
(
	id_assortimento       integer  NOT NULL ,
	assortimento          character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis20_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if20_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_assortimento
	ADD CONSTRAINT  PK_taif_d_assortimento PRIMARY KEY (id_assortimento);



CREATE TABLE taif_d_attivita_ateco_ape
(
	id_attivita           integer  NOT NULL ,
	codice                character varying(10)  NOT NULL ,
	attivita              character varying(200)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis8_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if8_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_attivita_ateco_ape
	ADD CONSTRAINT  PK_taif_d_attivita_ateco_ape PRIMARY KEY (id_attivita);



CREATE TABLE taif_d_categoria_impresa
(
	id_categoria          integer  NOT NULL ,
	categoria_impresa     character varying(300)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis14_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if14_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_categoria_impresa
	ADD CONSTRAINT  PK_taif_d_categoria_impresa PRIMARY KEY (id_categoria);



CREATE TABLE taif_d_categoria_mezzo
(
	id_categoria_mezzo    integer  NOT NULL ,
	categoria_mezzo       character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis35_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if35_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_categoria_mezzo
	ADD CONSTRAINT  PK_taif_d_categoria_mezzo PRIMARY KEY (id_categoria_mezzo);



CREATE TABLE taif_d_comune_fra
(
	id_comune_fra         integer  NOT NULL ,
	comune_fra            character varying(200)  NOT NULL ,
	dipartimento          character varying(100)  NULL 
);



ALTER TABLE taif_d_comune_fra
	ADD CONSTRAINT  PK_taif_d_comune_fra PRIMARY KEY (id_comune_fra);



CREATE TABLE taif_d_estensione_file
(
	id_estensione_file    INTEGER  NOT NULL ,
	estensione            CHARACTER VARYING(5)  NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis99_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_estensione_file
	ADD CONSTRAINT  PK_taif_d_estensione_file PRIMARY KEY (id_estensione_file);



CREATE TABLE taif_d_forma_giuridica
(
	id_forma_giuridica    integer  NOT NULL ,
	forma_giuridica       character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis13_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if13_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_forma_giuridica
	ADD CONSTRAINT  PK_taif_d_forma_giuridica PRIMARY KEY (id_forma_giuridica);



CREATE TABLE taif_d_funzione
(
	id_funzione           integer  NOT NULL ,
	fk_tipo_struttura     integer  NOT NULL ,
	funzione              character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis22_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if22_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_funzione
	ADD CONSTRAINT  PK_taif_d_funzione PRIMARY KEY (id_funzione);



CREATE TABLE taif_d_materiale
(
	id_materiale          integer  NOT NULL ,
	materiale             character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis32_0_1 CHECK (mtd_flg_visibile in (0,1)),
	flg_vivai_arb         character varying(1)  NULL  CONSTRAINT  dom_v_a CHECK (flg_vivai_arb in ('V', 'A'))
);



ALTER TABLE taif_d_materiale
	ADD CONSTRAINT  PK_taif_d_materiale PRIMARY KEY (id_materiale);



CREATE TABLE taif_d_nazione
(
	id_nazione            integer  NOT NULL ,
	nazione_ita           character varying(100)  NOT NULL ,
	nazione_fra           character varying(100)  NULL ,
	mtd_ordinamento_ita   numeric(3)  NULL ,
	mtd_ordinamento_fra   numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis33_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_nazione
	ADD CONSTRAINT  PK_taif_d_nazione PRIMARY KEY (id_nazione);



CREATE TABLE taif_d_prov_destin
(
	id_prov_destin        integer  NOT NULL ,
	prov_destin           character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis27_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if27_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_prov_destin
	ADD CONSTRAINT  PK_taif_d_prov_destin PRIMARY KEY (id_prov_destin);



CREATE TABLE taif_d_ruolo
(
	id_ruolo              integer  NOT NULL ,
	ruolo                 character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  dom1_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_ruolo
	ADD CONSTRAINT  PK_taif_d_ruolo PRIMARY KEY (id_ruolo);



CREATE TABLE taif_d_specie
(
	id_specie             integer  NOT NULL ,
	nome_specie           character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis26_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  dom_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_specie
	ADD CONSTRAINT  PK_taif_d_specie PRIMARY KEY (id_specie);



CREATE TABLE taif_d_stato_opfo
(
	id_stato_opfo         integer  NOT NULL ,
	stato_opfo_ita        character varying(100)  NOT NULL ,
	stato_opfo_fra        character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis30_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_stato_opfo
	ADD CONSTRAINT  PK_taif_d_stato_opfo PRIMARY KEY (id_stato_opfo);



CREATE TABLE taif_d_stato_pratica
(
	id_stato_pratica      integer  NOT NULL ,
	fk_stato_padre        integer  NULL ,
	stato_pratica_ita     character varying(100)  NOT NULL ,
	stato_pratica_fra     character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis28_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_stato_pratica
	ADD CONSTRAINT  PK_taif_d_stato_pratica PRIMARY KEY (id_stato_pratica);



CREATE TABLE taif_d_tipo_attivita
(
	id_tipo_attivita      integer  NOT NULL ,
	tipo_attivita         character varying(300)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis15_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if15_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_tipo_attivita
	ADD CONSTRAINT  PK_taif_d_tipo_attivita PRIMARY KEY (id_tipo_attivita);



CREATE TABLE taif_d_tipo_carrello
(
	id_tipo_carrello      integer  NOT NULL ,
	tipo_carrello         character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis6_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_tipo_carrello
	ADD CONSTRAINT  PK_taif_d_tipo_carrello PRIMARY KEY (id_tipo_carrello);



CREATE TABLE taif_d_tipo_certificazione
(
	id_tipo_certificazione  integer  NOT NULL ,
	tipo_certificazione   character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis17_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if17_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_tipo_certificazione
	ADD CONSTRAINT  PK_taif_d_tipo_certificazione PRIMARY KEY (id_tipo_certificazione);



CREATE TABLE taif_d_tipo_contratto
(
	id_tipo_contratto     integer  NOT NULL ,
	tipo_contratto        character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis11_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if11_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_tipo_contratto
	ADD CONSTRAINT  PK_taif_d_tipo_contratto PRIMARY KEY (id_tipo_contratto);



CREATE TABLE taif_d_tipo_dpi
(
	id_tipo_dpi           integer  NOT NULL ,
	tipo_dpi              character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis16_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_tipo_dpi
	ADD CONSTRAINT  PK_taif_d_tipo_dpi PRIMARY KEY (id_tipo_dpi);



CREATE TABLE taif_d_tipo_inquadramento
(
	id_tipo_inquadramento  INTEGER  NOT NULL ,
	tipo_inquadramento    character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis1_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_tipo_inquadramento
	ADD CONSTRAINT  PK_taif_d_tipo_inquadramento PRIMARY KEY (id_tipo_inquadramento);



CREATE TABLE taif_d_tipo_lavoro_pa
(
	id_tipo_lavoro_pa     integer  NOT NULL ,
	tipo_lavoro_pa        character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis18_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_tipo_lavoro_pa
	ADD CONSTRAINT  PK_taif_d_tipo_lavoro_pa PRIMARY KEY (id_tipo_lavoro_pa);



CREATE TABLE taif_d_tipo_mansione
(
	id_tipo_mansione      integer  NOT NULL ,
	tipo_mansione         character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis10_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if10_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_tipo_mansione
	ADD CONSTRAINT  PK_taif_d_tipo_mansione PRIMARY KEY (id_tipo_mansione);



CREATE TABLE taif_d_tipo_mezzo
(
	id_tipo_mezzo         integer  NOT NULL ,
	fk_categoria_mezzo    integer  NOT NULL ,
	tipo_mezzo            character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis3_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if3_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_tipo_mezzo
	ADD CONSTRAINT  PK_taif_d_tipo_mezzo PRIMARY KEY (id_tipo_mezzo);



CREATE TABLE taif_d_tipo_qualifica
(
	id_tipo_qualifica     integer  NOT NULL ,
	tipo_qualifica        character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis25_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if25_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_tipo_qualifica
	ADD CONSTRAINT  PK_taif_d_tipo_qualifica PRIMARY KEY (id_tipo_qualifica);



CREATE TABLE taif_d_tipo_sede_azienda
(
	id_tipo_sede          integer  NOT NULL ,
	tipo_sede             character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis2_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_tipo_sede_azienda
	ADD CONSTRAINT  PK_taif_d_tipo_sede_azienda PRIMARY KEY (id_tipo_sede);



CREATE TABLE taif_d_tipo_struttura
(
	id_tipo_struttura     integer  NOT NULL ,
	tipo_struttura        character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis34_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if34_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_tipo_struttura
	ADD CONSTRAINT  PK_taif_d_tipo_struttura PRIMARY KEY (id_tipo_struttura);



CREATE TABLE taif_d_titolo_studio
(
	id_titolo_studio      integer  NOT NULL ,
	titolo_studio         character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis12_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if12_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_titolo_studio
	ADD CONSTRAINT  PK_taif_d_titolo_studio PRIMARY KEY (id_titolo_studio);



CREATE TABLE taif_d_trazione
(
	id_trazione           integer  NOT NULL ,
	trazione              character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis4_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if4_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_trazione
	ADD CONSTRAINT  PK_taif_d_trazione PRIMARY KEY (id_trazione);



CREATE TABLE taif_d_unita_di_misura
(
	id_unita_di_misura    integer  NOT NULL ,
	unita_di_misura       character varying(100)  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis19_0_1 CHECK (mtd_flg_visibile in (0,1))
);



ALTER TABLE taif_d_unita_di_misura
	ADD CONSTRAINT  PK_taif_d_unita_di_misura PRIMARY KEY (id_unita_di_misura);



CREATE TABLE taif_d_unita_formativa
(
	id_unita_formativa    integer  NOT NULL ,
	fk_ambito_formativo   integer  NOT NULL ,
	fk_soggetto_gestore   INTEGER  NOT NULL ,
	unita_formativa       character varying(200)  NOT NULL ,
	sigla                 character varying(10)  NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis21_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if21_i_f CHECK (mtd_flg_ita_fra in ('I', 'F'))
);



ALTER TABLE taif_d_unita_formativa
	ADD CONSTRAINT  PK_taif_d_unita_formativa PRIMARY KEY (id_unita_formativa);



CREATE TABLE taif_r_attivdet_materiale
(
	id_materiale          integer  NOT NULL ,
	id_attivita           INTEGER  NOT NULL ,
	progressivo           INTEGER  NOT NULL ,
	descr_altro_materiale  character varying(100)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    TIMESTAMP  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_r_attivdet_materiale
	ADD CONSTRAINT  PK_taif_r_attivdet_materiale PRIMARY KEY (id_materiale,id_attivita,progressivo);



CREATE TABLE taif_r_azienda_associazione
(
	id_associazione       integer  NOT NULL ,
	id_azienda            integer  NOT NULL ,
	nome                  character varying(100)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    TIMESTAMP  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_r_azienda_associazione
	ADD CONSTRAINT  PK_taif_r_azienda_associazione PRIMARY KEY (id_associazione,id_azienda);



CREATE TABLE taif_r_azienda_categimpresa
(
	id_azienda            integer  NOT NULL ,
	id_categoria          integer  NOT NULL ,
	azienda_categimpresa  character varying(100)  NULL ,
	data_inserimento      TIMESTAMP  NOT NULL ,
	data_aggiornamento    TIMESTAMP  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_r_azienda_categimpresa
	ADD CONSTRAINT  PK_taif_r_azienda_categimpresa PRIMARY KEY (id_azienda,id_categoria);



CREATE TABLE taif_r_aziendafr_tipocontr
(
	id_azienda            integer  NOT NULL ,
	id_tipo_contratto     integer  NOT NULL ,
	nr_addetti            INTEGER  NOT NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_r_aziendafr_tipocontr
	ADD CONSTRAINT  PK_taif_r_aziendafr_tipocontr PRIMARY KEY (id_azienda,id_tipo_contratto);



CREATE TABLE taif_r_aziendafr_tipomans
(
	id_azienda            integer  NOT NULL ,
	id_tipo_mansione      integer  NOT NULL ,
	nr_addetti            INTEGER  NOT NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_r_aziendafr_tipomans
	ADD CONSTRAINT  PK_taif_r_aziendafr_tipomans PRIMARY KEY (id_azienda,id_tipo_mansione);



CREATE TABLE taif_r_opfo_corso
(
	id_corso              integer  NOT NULL ,
	id_persona            integer  NOT NULL ,
	flg_esito             character varying(1)   DEFAULT  'F' NOT NULL  CONSTRAINT  dom_f_p CHECK (flg_esito in ('F', 'P')),
	descrizione_altro     character varying(100)  NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	data_inserimento      timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_r_opfo_corso
	ADD CONSTRAINT  PK_taif_r_opfo_corso PRIMARY KEY (id_corso,id_persona);



CREATE TABLE taif_r_persona_azienda
(
	id_persona            integer  NOT NULL ,
	id_azienda            integer  NOT NULL ,
	fk_ruolo              integer  NOT NULL ,
	fk_tipo_mansione      integer  NOT NULL ,
	fk_tipo_contratto     integer  NOT NULL ,
	fk_tipo_inquadramento  INTEGER  NOT NULL ,
	flg_tempo_determinato  numeric(1)  NULL  CONSTRAINT  tdet_0_1 CHECK (flg_tempo_determinato in (0,1)),
	gg_tempo_determinato  integer  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_r_persona_azienda
	ADD CONSTRAINT  PK_taif_r_persona_azienda PRIMARY KEY (id_persona,id_azienda);



CREATE TABLE taif_r_traz_tipomezzo
(
	id_tipo_mezzo         integer  NOT NULL ,
	id_trazione           integer  NOT NULL 
);



ALTER TABLE taif_r_traz_tipomezzo
	ADD CONSTRAINT  PK_taif_r_traz_tipomezzo PRIMARY KEY (id_tipo_mezzo,id_trazione);



CREATE TABLE taif_t_agenzia_formativa
(
	id_agenzia_formativa  integer  NOT NULL ,
	codice_fiscale        character varying(16)  NULL ,
	partita_iva           character varying(11)  NULL ,
	ragione_sociale       character varying(100)  NOT NULL ,
	codice_psr            character varying(6)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	istat_sede            character varying(6)  NULL ,
	comune_estero         character varying(50)  NULL ,
	indirizzo             character varying(100)  NULL ,
	cap                   character varying(10)  NULL ,
	fk_config_utente      INTEGER  NOT NULL ,
	flg_visibile          NUMERIC(1)  NULL  CONSTRAINT  fvis_0_1 CHECK (flg_visibile in (0,1)),
	mtd_ordinamento       NUMERIC(3)  NULL 
);



ALTER TABLE taif_t_agenzia_formativa
	ADD CONSTRAINT  PK_taif_t_agenzia_formativa PRIMARY KEY (id_agenzia_formativa);



CREATE TABLE taif_t_allegato
(
	id_allegato           integer  NOT NULL ,
	fk_pratica            INTEGER  NULL ,
	fk_corso              integer  NULL ,
	fk_persona            integer  NULL ,
	fk_estensione_file    INTEGER  NOT NULL ,
	fk_tipo_allegato      integer  NOT NULL ,
	nome_file             character varying(100)  NOT NULL ,
	dimensione_file_kb    integer  NOT NULL ,
	flg_tipo_invio        character varying(1)  NULL  CONSTRAINT  dom_d_p CHECK (flg_tipo_invio in ('D', 'P')),
	flg_scadenza          numeric(1)  NULL  CONSTRAINT  scad_0_1 CHECK (flg_scadenza in (0,1)),
	data_upload           timestamp  NULL ,
	note                  character varying(1000)  NULL ,
	estensione_file       character varying(5)  NOT NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL ,
	id_doc_doqui          CHARACTER VARYING(500)  NULL ,
	id_classificazione_doqui  CHARACTER VARYING(500)  NULL 
);



ALTER TABLE taif_t_allegato
	ADD CONSTRAINT  PK_taif_t_allegato PRIMARY KEY (id_allegato);



CREATE TABLE taif_t_attivita_svolta
(
	id_attivita           INTEGER  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	fk_tipo_attivita      integer  NOT NULL ,
	descr_altre_attivita  character varying(100)  NULL ,
	perc_fatturato        numeric(3)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    TIMESTAMP  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_attivita_svolta
	ADD CONSTRAINT  PK_taif_t_attivita_svolta PRIMARY KEY (id_attivita);



CREATE TABLE taif_t_attivita_svolta_dett
(
	id_attivita           INTEGER  NOT NULL ,
	progressivo           INTEGER  NOT NULL ,
	fk_unita_di_misura    integer  NOT NULL ,
	valore1               numeric  NULL ,
	valore2               numeric  NULL ,
	valore3               numeric  NULL ,
	perc_conto_terzi      numeric(3)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_attivita_svolta_dett
	ADD CONSTRAINT  PK_taif_t_attivita_svolta_dett PRIMARY KEY (id_attivita,progressivo);



CREATE TABLE taif_t_azienda
(
	id_azienda            integer  NOT NULL ,
	fk_attivita_primaria  integer  NOT NULL ,
	fk_attivita_secondaria  integer  NOT NULL ,
	fk_attivita_ape       integer  NOT NULL ,
	fk_forma_giuridica_ita  integer  NOT NULL ,
	fk_forma_giuridica_fra  integer  NOT NULL ,
	codice_fiscale        character varying(16)  NULL ,
	n_siret               character varying(14)  NULL ,
	partita_iva           character varying(11)  NULL ,
	n_tva                 character varying(13)  NULL ,
	cciaa_numero          character varying(8)  NULL ,
	cciaa_sigla_prov      character varying(2)  NULL ,
	ragione_sociale       character varying(1000)  NOT NULL ,
	n_marca_bollo         character varying(14)  NULL ,
	descr_altra_forma_giuridica  character varying(50)  NULL ,
	email                 character varying(100)  NULL ,
	pec                   character varying(100)  NULL ,
	sito_web              character varying(100)  NULL ,
	anno_inizio           numeric(4)  NULL ,
	fatturato             numeric(12,2)  NULL ,
	perc_commercio_fra    numeric(3)  NULL ,
	client1_fra           character varying(100)  NULL ,
	client2_fra           character varying(100)  NULL ,
	client3_fra           character varying(100)  NULL ,
	nbre_salaries_fra     integer  NULL ,
	temps_plein_fra       integer  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_azienda
	ADD CONSTRAINT  PK_taif_t_azienda PRIMARY KEY (id_azienda);



CREATE TABLE taif_t_certificazione
(
	id_certificazione     integer  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	fk_tipo_certificazione  integer  NOT NULL ,
	descr_altro           character varying(100)  NULL ,
	numero                character varying(30)  NOT NULL ,
	ente_certificatore    character varying(100)  NOT NULL ,
	anno                  numeric(4)  NOT NULL ,
	data_scadenza         timestamp  NOT NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    TIMESTAMP  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_certificazione
	ADD CONSTRAINT  PK_taif_t_certificazione PRIMARY KEY (id_certificazione);



CREATE TABLE taif_t_commercializzazione
(
	id_commercializzazione  integer  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	fk_specie             integer  NOT NULL ,
	fk_provenienza        integer  NOT NULL ,
	fk_destinazione       integer  NOT NULL ,
	fk_assortimento       integer  NOT NULL ,
	fk_unita_di_misura    integer  NOT NULL ,
	venduto_medio         numeric  NULL ,
	flg_tagliato_acquistato  character varying(1)  NULL  CONSTRAINT  dom_t_a CHECK (flg_tagliato_acquistato in ('T', 'A')),
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL ,
	note                  CHARACTER VARYING(200)  NULL 
);



ALTER TABLE taif_t_commercializzazione
	ADD CONSTRAINT  PK_taif_t_commercializzazione PRIMARY KEY (id_commercializzazione);



CREATE TABLE taif_t_corso
(
	id_corso              integer  NOT NULL ,
	fk_agenzia_formativa  integer  NOT NULL ,
	fk_unita_formativa    integer  NOT NULL ,
	corso                 character varying(300)  NOT NULL ,
	codice_psr            numeric(6)  NULL ,
	data_inizio           timestamp  NULL ,
	data_fine             timestamp  NULL ,
	nro_ore               numeric(3)  NULL ,
	istat_sede            character varying(6)  NULL ,
	comune_estero_sede    character varying(100)  NULL ,
	indirizzo             character varying(100)  NULL ,
	flg_altro_corso       numeric(1)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis23_0_1 CHECK (mtd_flg_visibile in (0,1)),
	mtd_flg_ita_fra       character varying(1)  NOT NULL  CONSTRAINT  if23_i_f CHECK (mtd_flg_ita_fra in ('I', 'F')),
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_corso
	ADD CONSTRAINT  PK_taif_t_corso PRIMARY KEY (id_corso);



CREATE TABLE taif_t_dpi
(
	id_dpi                integer  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	fk_tipo_dpi           integer  NOT NULL ,
	tipologia             character varying(50)  NULL ,
	quantita              INTEGER  NOT NULL ,
	anno_scad             numeric(4)  NULL ,
	data_inserimento      TIMESTAMP  NOT NULL ,
	data_aggiornamento    TIMESTAMP  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_dpi
	ADD CONSTRAINT  PK_taif_t_dpi PRIMARY KEY (id_dpi);



CREATE TABLE taif_t_lavoro_pa
(
	id_lavoro_pa          integer  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	fk_tipo_lavoro_pa     integer  NOT NULL ,
	committente           character varying(100)  NOT NULL ,
	importo               numeric(12,2)  NOT NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL ,
	descr_altro           CHARACTER VARYING(100)  NULL 
);



ALTER TABLE taif_t_lavoro_pa
	ADD CONSTRAINT  PK_taif_t_lavoro_pa PRIMARY KEY (id_lavoro_pa);



CREATE TABLE taif_t_mezzo
(
	id_mezzo              integer  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	fk_alimentazione      integer  NOT NULL ,
	fk_tipo_carrello      integer  NOT NULL ,
	fk_tipo_mezzo         integer  NOT NULL ,
	fk_trazione           integer  NOT NULL ,
	anno                  numeric(4)  NULL ,
	potenza_kw            integer  NULL ,
	portata_kg            integer  NULL ,
	flg_comandato_distanza  numeric(1)  NULL  CONSTRAINT  cdist_0_1 CHECK (flg_comandato_distanza in (0,1)),
	flg_noleggio          numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  nol_0_1 CHECK (flg_noleggio in (0,1)),
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_mezzo
	ADD CONSTRAINT  PK_taif_t_mezzo PRIMARY KEY (id_mezzo);



CREATE TABLE taif_t_opfo
(
	id_persona            integer  NOT NULL ,
	fk_stato_opfo         integer  NOT NULL ,
	fk_soggetto_gestore   INTEGER  NOT NULL ,
	flg_pubblico          NUMERIC(1)   DEFAULT  0 NOT NULL  CONSTRAINT  pub_0_1 CHECK (flg_pubblico in (0,1)),
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_opfo
	ADD CONSTRAINT  PK_taif_t_opfo PRIMARY KEY (id_persona);



CREATE TABLE taif_t_persona
(
	id_persona            integer  NOT NULL ,
	fk_titolo_studio      integer  NOT NULL ,
	fk_titolo_studio_fra  integer  NOT NULL ,
	fk_nazione            integer  NOT NULL ,
	codice_fiscale        character varying(16)  NULL ,
	n_rsi_msa             character varying(30)  NULL ,
	pwd                   CHARACTER VARYING(10)  NULL ,
	cognome               character varying(50)  NOT NULL ,
	nome                  character varying(50)  NOT NULL ,
	flg_sesso             character varying(1)  NULL  CONSTRAINT  pers_m_f CHECK (flg_sesso in ('M', 'F')),
	data_nascita          date  NULL ,
	istat_comune_nascita  character varying(6)  NULL ,
	comune_estero_nascita  character varying(100)  NULL ,
	istat_comune_res      character varying(16)  NULL ,
	comune_estero_res     character varying(100)  NULL ,
	indirizzo_res         character varying(100)  NULL ,
	civico_res            character varying(10)  NULL ,
	cap_res               character varying(10)  NULL ,
	telefono              character varying(20)  NULL ,
	cellulare             character varying(20)  NULL ,
	mail                  character varying(100)  NULL ,
	altri_studi           character varying(200)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NULL ,
	fk_comune_fra_nascita  integer  NOT NULL ,
	fk_comune_fra_res     integer  NOT NULL 
);



ALTER TABLE taif_t_persona
	ADD CONSTRAINT  PK_taif_t_persona PRIMARY KEY (id_persona);



CREATE TABLE taif_t_pratica
(
	id_pratica            INTEGER  NOT NULL ,
	fk_soggetto_gestore   INTEGER  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	data_presentazione    date  NULL ,
	data_iscrizione_albo  date  NULL ,
	numero_albo           character varying(10)  NULL ,
	flg_sezione           character varying(1)  NOT NULL  CONSTRAINT  dom_a_b CHECK (flg_sezione in ('A', 'B')),
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    TIMESTAMP  NOT NULL ,
	denominazione_altro_albo  character varying(100)  NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_pratica
	ADD CONSTRAINT  PK_taif_t_pratica PRIMARY KEY (id_pratica);



CREATE TABLE taif_t_qualifica
(
	id_qualifica          INTEGER  NOT NULL ,
	fk_tipo_qualifica     integer  NOT NULL ,
	fk_agenzia_formativa  integer  NOT NULL ,
	fk_persona            integer  NOT NULL ,
	data_rilascio         date  NOT NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_qualifica
	ADD CONSTRAINT  PK_taif_t_qualifica PRIMARY KEY (id_qualifica);



CREATE TABLE taif_t_riconoscimento
(
	id_riconoscimento     INTEGER  NOT NULL ,
	fk_unita_formativa    integer  NOT NULL ,
	fk_agenzia_formativa  integer  NOT NULL ,
	fk_persona            integer  NOT NULL ,
	data_riconoscimento   date  NOT NULL ,
	note                  character varying(1000)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NULL 
);



ALTER TABLE taif_t_riconoscimento
	ADD CONSTRAINT  PK_taif_t_riconoscimento PRIMARY KEY (id_riconoscimento);



CREATE TABLE taif_t_sede_azienda
(
	id_sede               integer  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	fk_tipo_sede          integer  NOT NULL ,
	istat_comune          character varying(6)  NULL ,
	comune_estero         character varying(100)  NULL ,
	indirizzo             character varying(100)  NULL ,
	civico                character varying(10)  NULL ,
	cap                   character varying(10)  NULL ,
	telefono              character varying(20)  NULL ,
	cellulare             character varying(20)  NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL ,
	fk_comune_fra         integer  NOT NULL 
);



ALTER TABLE taif_t_sede_azienda
	ADD CONSTRAINT  PK_taif_t_sede_azienda PRIMARY KEY (id_sede);



CREATE TABLE taif_t_soggetto_gestore
(
	id_soggetto_gestore   INTEGER  NOT NULL ,
	codice                character varying(5)  NOT NULL ,
	denominazione_breve   character varying(50)  NOT NULL ,
	denominazione         character varying(100)  NOT NULL ,
	istat_comune          character varying(6)  NULL ,
	comune_estero         character varying(100)  NULL ,
	indirizzo             character varying(100)  NULL ,
	civico                character varying(10)  NULL ,
	cap                   character varying(10)  NULL ,
	telefono              character varying(20)  NULL ,
	cellulare             character varying(20)  NULL ,
	mail                  character varying(100)  NULL ,
	pec                   character varying(100)  NULL ,
	referente             character varying(100)  NULL ,
	mtd_ordinamento       numeric(3)  NULL ,
	mtd_flg_visibile      numeric(1)   DEFAULT  0 NOT NULL  CONSTRAINT  vis31_0_1 CHECK (mtd_flg_visibile in (0,1)),
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	url_doc_privacy       CHARACTER VARYING(500)  NULL 
);



ALTER TABLE taif_t_soggetto_gestore
	ADD CONSTRAINT  PK_taif_t_soggetto_gestore PRIMARY KEY (id_soggetto_gestore);



CREATE TABLE taif_t_storico_stato
(
	id_pratica            INTEGER  NOT NULL ,
	data_inserimento_stato  timestamp  NOT NULL ,
	fk_stato_pratica      integer  NOT NULL ,
	numero_protocollo     character varying(20)  NULL ,
	data_protocollo       date  NULL ,
	data_aggiornamento    TIMESTAMP  NULL ,
	note                  character varying(1000)  NULL ,
	fk_config_utente      INTEGER  NOT NULL ,
	data_fine_stato       DATE  NULL 
);



ALTER TABLE taif_t_storico_stato
	ADD CONSTRAINT  PK_taif_t_storico_stato PRIMARY KEY (id_pratica,data_inserimento_stato);



CREATE TABLE taif_t_struttura
(
	id_struttura          integer  NOT NULL ,
	fk_funzione           integer  NOT NULL ,
	fk_azienda            integer  NOT NULL ,
	dimensione            integer  NOT NULL ,
	anno                  numeric(4)  NOT NULL ,
	data_inserimento      timestamp  NOT NULL ,
	data_aggiornamento    timestamp  NOT NULL ,
	fk_config_utente      INTEGER  NOT NULL 
);



ALTER TABLE taif_t_struttura
	ADD CONSTRAINT  PK_taif_t_struttura PRIMARY KEY (id_struttura);



ALTER TABLE taif_appl_scheda_ok
	ADD (CONSTRAINT  fk_taif_t_azienda_16 FOREIGN KEY (id_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_cnf_attrib_ammesso
	ADD (CONSTRAINT  fk_taif_d_tipo_mezzo_02 FOREIGN KEY (fk_tipo_mezzo) REFERENCES taif_d_tipo_mezzo(id_tipo_mezzo));



ALTER TABLE taif_cnf_config_utente
	ADD (CONSTRAINT  fk_taif_cnf_profilo_utente_01 FOREIGN KEY (fk_profilo_utente) REFERENCES taif_cnf_profilo_utente(id_profilo_utente));



ALTER TABLE taif_cnf_config_utente
	ADD (CONSTRAINT  fk_taif_t_persona_01 FOREIGN KEY (fk_persona) REFERENCES taif_t_persona(id_persona));



ALTER TABLE taif_cnf_config_utente
	ADD (CONSTRAINT  fk_taif_t_soggetto_gestore_01 FOREIGN KEY (fk_soggetto_gestore) REFERENCES taif_t_soggetto_gestore(id_soggetto_gestore));



ALTER TABLE taif_cnf_config_utente
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_01 FOREIGN KEY (id_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_cnf_estens_amm
	ADD (CONSTRAINT  fk_taif_d_estensione_file_01 FOREIGN KEY (id_estensione_file) REFERENCES taif_d_estensione_file(id_estensione_file));



ALTER TABLE taif_cnf_estens_amm
	ADD (CONSTRAINT  fk_taif_cnf_tipo_allegato_01 FOREIGN KEY (id_tipo_allegato) REFERENCES taif_cnf_tipo_allegato(id_tipo_allegato));



ALTER TABLE taif_cnf_profilo_utente
	ADD (CONSTRAINT  fk_taif_cnf_procedura_01 FOREIGN KEY (fk_procedura) REFERENCES taif_cnf_procedura(id_procedura));



ALTER TABLE taif_cnf_tipo_allegato
	ADD (CONSTRAINT  fk_taif_cnf_procedura_02 FOREIGN KEY (fk_procedura) REFERENCES taif_cnf_procedura(id_procedura));



ALTER TABLE taif_cnf_tipo_mail
	ADD (CONSTRAINT  fk_taif_d_stato_pratica_03 FOREIGN KEY (fk_stato_pratica) REFERENCES taif_d_stato_pratica(id_stato_pratica));



ALTER TABLE taif_d_funzione
	ADD (CONSTRAINT  fk_taif_d_tipo_struttura_01 FOREIGN KEY (fk_tipo_struttura) REFERENCES taif_d_tipo_struttura(id_tipo_struttura));



ALTER TABLE taif_d_stato_pratica
	ADD (CONSTRAINT  fk_taif_d_stato_pratica_02 FOREIGN KEY (fk_stato_padre) REFERENCES taif_d_stato_pratica(id_stato_pratica));



ALTER TABLE taif_d_tipo_mezzo
	ADD (CONSTRAINT  fk_taif_d_categoria_mezzo_01 FOREIGN KEY (fk_categoria_mezzo) REFERENCES taif_d_categoria_mezzo(id_categoria_mezzo));



ALTER TABLE taif_d_unita_formativa
	ADD (CONSTRAINT  fk_taif_d_ambito_formativo_01 FOREIGN KEY (fk_ambito_formativo) REFERENCES taif_d_ambito_formativo(id_ambito_formativo));



ALTER TABLE taif_d_unita_formativa
	ADD (CONSTRAINT  fk_taif_t_soggetto_gestore_02 FOREIGN KEY (fk_soggetto_gestore) REFERENCES taif_t_soggetto_gestore(id_soggetto_gestore));



ALTER TABLE taif_r_attivdet_materiale
	ADD (CONSTRAINT  fk_taif_d_materiale_01 FOREIGN KEY (id_materiale) REFERENCES taif_d_materiale(id_materiale));



ALTER TABLE taif_r_attivdet_materiale
	ADD (CONSTRAINT  fk_taif_t_attiv_svolta_dett_01 FOREIGN KEY (id_attivita,progressivo) REFERENCES taif_t_attivita_svolta_dett(id_attivita,progressivo));



ALTER TABLE taif_r_attivdet_materiale
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_25 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_r_azienda_associazione
	ADD (CONSTRAINT  fk_taif_d_associazione_01 FOREIGN KEY (id_associazione) REFERENCES taif_d_associazione(id_associazione));



ALTER TABLE taif_r_azienda_associazione
	ADD (CONSTRAINT  fk_taif_t_azienda_08 FOREIGN KEY (id_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_r_azienda_associazione
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_02 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_r_azienda_categimpresa
	ADD (CONSTRAINT  fk_taif_d_categoria_impresa_01 FOREIGN KEY (id_categoria) REFERENCES taif_d_categoria_impresa(id_categoria));



ALTER TABLE taif_r_azienda_categimpresa
	ADD (CONSTRAINT  fk_taif_t_azienda_03 FOREIGN KEY (id_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_r_aziendafr_tipocontr
	ADD (CONSTRAINT  fk_taif_t_azienda_02 FOREIGN KEY (id_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_r_aziendafr_tipocontr
	ADD (CONSTRAINT  fk_taif_d_tipo_contratto_01 FOREIGN KEY (id_tipo_contratto) REFERENCES taif_d_tipo_contratto(id_tipo_contratto));



ALTER TABLE taif_r_aziendafr_tipocontr
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_04 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_r_aziendafr_tipomans
	ADD (CONSTRAINT  fk_taif_t_azienda_01 FOREIGN KEY (id_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_r_aziendafr_tipomans
	ADD (CONSTRAINT  fk_taif_d_tipo_mansione_01 FOREIGN KEY (id_tipo_mansione) REFERENCES taif_d_tipo_mansione(id_tipo_mansione));



ALTER TABLE taif_r_aziendafr_tipomans
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_05 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_r_opfo_corso
	ADD (CONSTRAINT  fk_taif_t_corso_01 FOREIGN KEY (id_corso) REFERENCES taif_t_corso(id_corso));



ALTER TABLE taif_r_opfo_corso
	ADD (CONSTRAINT  fk_taif_t_opfo_01 FOREIGN KEY (id_persona) REFERENCES taif_t_opfo(id_persona));



ALTER TABLE taif_r_opfo_corso
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_06 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_r_persona_azienda
	ADD (CONSTRAINT  fk_taif_t_persona_02 FOREIGN KEY (id_persona) REFERENCES taif_t_persona(id_persona));



ALTER TABLE taif_r_persona_azienda
	ADD (CONSTRAINT  fk_taif_t_azienda_12 FOREIGN KEY (id_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_r_persona_azienda
	ADD (CONSTRAINT  fk_taif_d_ruolo_01 FOREIGN KEY (fk_ruolo) REFERENCES taif_d_ruolo(id_ruolo));



ALTER TABLE taif_r_persona_azienda
	ADD (CONSTRAINT  fk_taif_d_tipo_mansione_02 FOREIGN KEY (fk_tipo_mansione) REFERENCES taif_d_tipo_mansione(id_tipo_mansione));



ALTER TABLE taif_r_persona_azienda
	ADD (CONSTRAINT  fk_taif_d_tipo_contratto_02 FOREIGN KEY (fk_tipo_contratto) REFERENCES taif_d_tipo_contratto(id_tipo_contratto));



ALTER TABLE taif_r_persona_azienda
	ADD (CONSTRAINT  fk_taif_d_tipo_inquadramento_0 FOREIGN KEY (fk_tipo_inquadramento) REFERENCES taif_d_tipo_inquadramento(id_tipo_inquadramento));



ALTER TABLE taif_r_persona_azienda
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_07 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_r_traz_tipomezzo
	ADD (CONSTRAINT  fk_taif_d_tipo_mezzo_01 FOREIGN KEY (id_tipo_mezzo) REFERENCES taif_d_tipo_mezzo(id_tipo_mezzo));



ALTER TABLE taif_r_traz_tipomezzo
	ADD (CONSTRAINT  fk_taif_d_trazione_01 FOREIGN KEY (id_trazione) REFERENCES taif_d_trazione(id_trazione));



ALTER TABLE taif_t_agenzia_formativa
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_27 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_allegato
	ADD (CONSTRAINT  fk_taif_t_pratica_02 FOREIGN KEY (fk_pratica) REFERENCES taif_t_pratica(id_pratica));



ALTER TABLE taif_t_allegato
	ADD (CONSTRAINT  fk_taif_r_opfo_corso_01 FOREIGN KEY (fk_corso,fk_persona) REFERENCES taif_r_opfo_corso(id_corso,id_persona));



ALTER TABLE taif_t_allegato
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_08 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_allegato
	ADD (CONSTRAINT  fk_taif_cnf_estens_amm_01 FOREIGN KEY (fk_estensione_file,fk_tipo_allegato) REFERENCES taif_cnf_estens_amm(id_estensione_file,id_tipo_allegato));



ALTER TABLE taif_t_attivita_svolta
	ADD (CONSTRAINT  fk_taif_t_azienda_04 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_t_attivita_svolta
	ADD (CONSTRAINT  fk_taif_d_tipo_attivita_01 FOREIGN KEY (fk_tipo_attivita) REFERENCES taif_d_tipo_attivita(id_tipo_attivita));



ALTER TABLE taif_t_attivita_svolta
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_10 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_attivita_svolta_dett
	ADD (CONSTRAINT  fk_taif_t_attivita_svolta_01 FOREIGN KEY (id_attivita) REFERENCES taif_t_attivita_svolta(id_attivita));



ALTER TABLE taif_t_attivita_svolta_dett
	ADD (CONSTRAINT  fk_taif_d_unita_di_misura_02 FOREIGN KEY (fk_unita_di_misura) REFERENCES taif_d_unita_di_misura(id_unita_di_misura));



ALTER TABLE taif_t_attivita_svolta_dett
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_11 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_azienda
	ADD (CONSTRAINT  fk_taif_d_attiv_ateco_ape_02 FOREIGN KEY (fk_attivita_primaria) REFERENCES taif_d_attivita_ateco_ape(id_attivita));



ALTER TABLE taif_t_azienda
	ADD (CONSTRAINT  fk_taif_d_attiv_ateco_ape_01 FOREIGN KEY (fk_attivita_secondaria) REFERENCES taif_d_attivita_ateco_ape(id_attivita));



ALTER TABLE taif_t_azienda
	ADD (CONSTRAINT  fk_taif_d_forma_giuridica_01 FOREIGN KEY (fk_forma_giuridica_ita) REFERENCES taif_d_forma_giuridica(id_forma_giuridica));



ALTER TABLE taif_t_azienda
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_12 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_azienda
	ADD (CONSTRAINT  fk_taif_d_forma_giuridica_02 FOREIGN KEY (fk_forma_giuridica_fra) REFERENCES taif_d_forma_giuridica(id_forma_giuridica));



ALTER TABLE taif_t_azienda
	ADD (CONSTRAINT  fk_taif_d_attiv_ateco_ape_03 FOREIGN KEY (fk_attivita_ape) REFERENCES taif_d_attivita_ateco_ape(id_attivita));



ALTER TABLE taif_t_certificazione
	ADD (CONSTRAINT  fk_taif_d_tipo_certificazione_ FOREIGN KEY (fk_tipo_certificazione) REFERENCES taif_d_tipo_certificazione(id_tipo_certificazione));



ALTER TABLE taif_t_certificazione
	ADD (CONSTRAINT  fk_taif_t_azienda_15 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_t_certificazione
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_13 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_commercializzazione
	ADD (CONSTRAINT  fk_taif_t_azienda_13 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_t_commercializzazione
	ADD (CONSTRAINT  fk_taif_d_specie_01 FOREIGN KEY (fk_specie) REFERENCES taif_d_specie(id_specie));



ALTER TABLE taif_t_commercializzazione
	ADD (CONSTRAINT  fk_taif_d_prov_destin_01 FOREIGN KEY (fk_provenienza) REFERENCES taif_d_prov_destin(id_prov_destin));



ALTER TABLE taif_t_commercializzazione
	ADD (CONSTRAINT  fk_taif_d_prov_destin_02 FOREIGN KEY (fk_destinazione) REFERENCES taif_d_prov_destin(id_prov_destin));



ALTER TABLE taif_t_commercializzazione
	ADD (CONSTRAINT  fk_taif_d_assortimento_01 FOREIGN KEY (fk_assortimento) REFERENCES taif_d_assortimento(id_assortimento));



ALTER TABLE taif_t_commercializzazione
	ADD (CONSTRAINT  fk_taif_d_unita_di_misura_01 FOREIGN KEY (fk_unita_di_misura) REFERENCES taif_d_unita_di_misura(id_unita_di_misura));



ALTER TABLE taif_t_commercializzazione
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_14 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_corso
	ADD (CONSTRAINT  fk_taif_t_agenzia_formativa_01 FOREIGN KEY (fk_agenzia_formativa) REFERENCES taif_t_agenzia_formativa(id_agenzia_formativa));



ALTER TABLE taif_t_corso
	ADD (CONSTRAINT  fk_taif_d_unita_formativa_01 FOREIGN KEY (fk_unita_formativa) REFERENCES taif_d_unita_formativa(id_unita_formativa));



ALTER TABLE taif_t_corso
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_28 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_dpi
	ADD (CONSTRAINT  fk_taif_d_tipo_dpi_01 FOREIGN KEY (fk_tipo_dpi) REFERENCES taif_d_tipo_dpi(id_tipo_dpi));



ALTER TABLE taif_t_dpi
	ADD (CONSTRAINT  fk_taif_t_azienda_05 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_t_dpi
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_15 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_lavoro_pa
	ADD (CONSTRAINT  fk_taif_d_tipo_lavoro_pa_01 FOREIGN KEY (fk_tipo_lavoro_pa) REFERENCES taif_d_tipo_lavoro_pa(id_tipo_lavoro_pa));



ALTER TABLE taif_t_lavoro_pa
	ADD (CONSTRAINT  fk_taif_t_azienda_14 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_t_lavoro_pa
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_23 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_mezzo
	ADD (CONSTRAINT  fk_taif_t_azienda_09 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));



ALTER TABLE taif_t_mezzo
	ADD (CONSTRAINT  fk_taif_d_alimentazione_01 FOREIGN KEY (fk_alimentazione) REFERENCES taif_d_alimentazione(id_alimentazione));



ALTER TABLE taif_t_mezzo
	ADD (CONSTRAINT  fk_taif_d_tipo_carrello_01 FOREIGN KEY (fk_tipo_carrello) REFERENCES taif_d_tipo_carrello(id_tipo_carrello));



ALTER TABLE taif_t_mezzo
	ADD (CONSTRAINT  fk_taif_r_traz_tipomezzo_01 FOREIGN KEY (fk_tipo_mezzo,fk_trazione) REFERENCES taif_r_traz_tipomezzo(id_tipo_mezzo,id_trazione));



ALTER TABLE taif_t_mezzo
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_16 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_opfo
	ADD (CONSTRAINT  fk_taif_t_persona_03 FOREIGN KEY (id_persona) REFERENCES taif_t_persona(id_persona));



ALTER TABLE taif_t_opfo
	ADD (CONSTRAINT  fk_taif_d_stato_opfo_01 FOREIGN KEY (fk_stato_opfo) REFERENCES taif_d_stato_opfo(id_stato_opfo));



ALTER TABLE taif_t_opfo
	ADD (CONSTRAINT  fk_taif_t_soggetto_gestore_04 FOREIGN KEY (fk_soggetto_gestore) REFERENCES taif_t_soggetto_gestore(id_soggetto_gestore));



ALTER TABLE taif_t_opfo
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_26 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_persona
	ADD (CONSTRAINT  fk_taif_d_titolo_studio_01 FOREIGN KEY (fk_titolo_studio) REFERENCES taif_d_titolo_studio(id_titolo_studio));



ALTER TABLE taif_t_persona
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_17 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));



ALTER TABLE taif_t_persona
	ADD (CONSTRAINT  fk_taif_d_nazione_01 FOREIGN KEY (fk_nazione) REFERENCES taif_d_nazione(id_nazione));


ALTER TABLE taif_t_persona
	ADD (CONSTRAINT  fk_taif_d_titolo_studio_02 FOREIGN KEY (fk_titolo_studio_fra) REFERENCES taif_d_titolo_studio(id_titolo_studio));

ALTER TABLE taif_t_persona
	ADD (CONSTRAINT  fk_d_comune_fra_01 FOREIGN KEY (fk_comune_fra_nascita) REFERENCES taif_d_comune_fra(id_comune_fra));

ALTER TABLE taif_t_persona
	ADD (CONSTRAINT  fk_d_comune_fra_02 FOREIGN KEY (fk_comune_fra_res) REFERENCES taif_d_comune_fra(id_comune_fra));


ALTER TABLE taif_t_pratica
	ADD (CONSTRAINT  fk_taif_t_azienda_10 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));

ALTER TABLE taif_t_pratica
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_24 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));

ALTER TABLE taif_t_pratica
	ADD (CONSTRAINT  fk_taif_t_soggetto_gestore_03 FOREIGN KEY (fk_soggetto_gestore) REFERENCES taif_t_soggetto_gestore(id_soggetto_gestore));


ALTER TABLE taif_t_qualifica
	ADD (CONSTRAINT  fk_taif_d_tipo_qualifica_01 FOREIGN KEY (fk_tipo_qualifica) REFERENCES taif_d_tipo_qualifica(id_tipo_qualifica));

ALTER TABLE taif_t_qualifica
	ADD (CONSTRAINT  fk_taif_t_agenzia_formativa_02 FOREIGN KEY (fk_agenzia_formativa) REFERENCES taif_t_agenzia_formativa(id_agenzia_formativa));

ALTER TABLE taif_t_qualifica
	ADD (CONSTRAINT  fk_taif_t_opfo_02 FOREIGN KEY (fk_persona) REFERENCES taif_t_opfo(id_persona));

ALTER TABLE taif_t_qualifica
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_18 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));


ALTER TABLE taif_t_riconoscimento
	ADD (CONSTRAINT  fk_taif_d_unita_formativa_02 FOREIGN KEY (fk_unita_formativa) REFERENCES taif_d_unita_formativa(id_unita_formativa));

ALTER TABLE taif_t_riconoscimento
	ADD (CONSTRAINT  fk_taif_t_agenzia_formativa_03 FOREIGN KEY (fk_agenzia_formativa) REFERENCES taif_t_agenzia_formativa(id_agenzia_formativa));

ALTER TABLE taif_t_riconoscimento
	ADD (CONSTRAINT  fk_taif_t_opfo_03 FOREIGN KEY (fk_persona) REFERENCES taif_t_opfo(id_persona));

ALTER TABLE taif_t_riconoscimento
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_19 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));


ALTER TABLE taif_t_sede_azienda
	ADD (CONSTRAINT  fk_taif_t_azienda_11 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));

ALTER TABLE taif_t_sede_azienda
	ADD (CONSTRAINT  fk_taif_d_tipo_sede_azienda_01 FOREIGN KEY (fk_tipo_sede) REFERENCES taif_d_tipo_sede_azienda(id_tipo_sede));

ALTER TABLE taif_t_sede_azienda
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_20 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));

ALTER TABLE taif_t_sede_azienda
	ADD (CONSTRAINT  fk_d_comune_fra_03 FOREIGN KEY (fk_comune_fra) REFERENCES taif_d_comune_fra(id_comune_fra));


ALTER TABLE taif_t_storico_stato
	ADD (CONSTRAINT  fk_taif_t_pratica_01 FOREIGN KEY (id_pratica) REFERENCES taif_t_pratica(id_pratica));

ALTER TABLE taif_t_storico_stato
	ADD (CONSTRAINT  fk_taif_d_stato_pratica_01 FOREIGN KEY (fk_stato_pratica) REFERENCES taif_d_stato_pratica(id_stato_pratica));

ALTER TABLE taif_t_storico_stato
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_21 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));


ALTER TABLE taif_t_struttura
	ADD (CONSTRAINT  fk_taif_t_azienda_06 FOREIGN KEY (fk_azienda) REFERENCES taif_t_azienda(id_azienda));

ALTER TABLE taif_t_struttura
	ADD (CONSTRAINT  fk_taif_d_funzione_01 FOREIGN KEY (fk_funzione) REFERENCES taif_d_funzione(id_funzione));

ALTER TABLE taif_t_struttura
	ADD (CONSTRAINT  fk_taif_cnf_config_utente_22 FOREIGN KEY (fk_config_utente) REFERENCES taif_cnf_config_utente(id_config_utente));




--------------
-- SEQUENCE --
--------------
CREATE SEQUENCE seq_taif_config_utente
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_config_utente
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_config_utente TO taif;
GRANT ALL ON SEQUENCE seq_taif_config_utente TO taif_rw;


CREATE SEQUENCE seq_taif_t_allegato
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_allegato
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_allegato TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_allegato TO taif_rw;


CREATE SEQUENCE seq_taif_t_attivita_svolta
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_attivita_svolta
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_attivita_svolta TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_attivita_svolta TO taif_rw;


CREATE SEQUENCE seq_taif_t_azienda
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_azienda
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_azienda TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_azienda TO taif_rw;


CREATE SEQUENCE seq_taif_t_certificazione
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_certificazione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_certificazione TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_certificazione TO taif_rw;


CREATE SEQUENCE seq_taif_t_commercializzazione
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_commercializzazione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_commercializzazione TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_commercializzazione TO taif_rw;


CREATE SEQUENCE seq_taif_t_dpi
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_dpi
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_dpi TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_dpi TO taif_rw;


CREATE SEQUENCE seq_taif_t_lavoro_pa
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_lavoro_pa
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_lavoro_pa TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_lavoro_pa TO taif_rw;


CREATE SEQUENCE seq_taif_t_mezzo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_mezzo
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_mezzo TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_mezzo TO taif_rw;


CREATE SEQUENCE seq_taif_t_persona
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_persona
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_persona TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_persona TO taif_rw;


CREATE SEQUENCE seq_taif_t_pratica
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_pratica
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_pratica TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_pratica TO taif_rw;


CREATE SEQUENCE seq_taif_t_qualifica
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_qualifica
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_qualifica TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_qualifica TO taif_rw;


CREATE SEQUENCE seq_taif_t_riconoscimento
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_riconoscimento
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_riconoscimento TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_riconoscimento TO taif_rw;


CREATE SEQUENCE seq_taif_t_sede_azienda
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_sede_azienda
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_sede_azienda TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_sede_azienda TO taif_rw;


CREATE SEQUENCE seq_taif_t_struttura
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_struttura
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_struttura TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_struttura TO taif_rw;


CREATE SEQUENCE seq_taif_cnf_attrib_ammesso
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_cnf_attrib_ammesso
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_attrib_ammesso TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_attrib_ammesso TO taif_rw;	


CREATE SEQUENCE seq_taif_cnf_estens_amm
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_cnf_estens_amm
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_estens_amm TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_estens_amm TO taif_rw;
	
CREATE SEQUENCE seq_taif_cnf_procedura
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_cnf_procedura
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_procedura TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_procedura TO taif_rw;


CREATE SEQUENCE seq_taif_cnf_profilo_utente
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_cnf_profilo_utente
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_profilo_utente TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_profilo_utente TO taif_rw;


CREATE SEQUENCE seq_taif_cnf_tipo_allegato
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_cnf_tipo_allegato
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_tipo_allegato TO taif;
GRANT ALL ON SEQUENCE seq_taif_cnf_tipo_allegato TO taif_rw;


CREATE SEQUENCE seq_taif_d_alimentazione
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_alimentazione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_alimentazione TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_alimentazione TO taif_rw;


CREATE SEQUENCE seq_taif_d_ambito_formativo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_ambito_formativo
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_ambito_formativo TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_ambito_formativo TO taif_rw;


CREATE SEQUENCE seq_taif_d_associazione
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_associazione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_associazione TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_associazione TO taif_rw;		
		
	
CREATE SEQUENCE seq_taif_d_assortimento
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_assortimento
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_assortimento TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_assortimento TO taif_rw;	
	
	
CREATE SEQUENCE seq_taif_d_attivita_ateco_ape
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_attivita_ateco_ape
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_attivita_ateco_ape TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_attivita_ateco_ape TO taif_rw;


CREATE SEQUENCE seq_taif_d_categoria_impresa
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_categoria_impresa
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_categoria_impresa TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_categoria_impresa TO taif_rw;


CREATE SEQUENCE seq_taif_d_estensione_file
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_estensione_file
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_estensione_file TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_estensione_file TO taif_rw;


CREATE SEQUENCE seq_taif_d_forma_giuridica
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_forma_giuridica
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_forma_giuridica TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_forma_giuridica TO taif_rw;


CREATE SEQUENCE seq_taif_d_funzione
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_funzione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_funzione TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_funzione TO taif_rw;


CREATE SEQUENCE seq_taif_d_materiale
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_materiale
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_materiale TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_materiale TO taif_rw;	

		
CREATE SEQUENCE seq_taif_d_nazione
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_nazione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_nazione TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_nazione TO taif_rw;		
	
	
CREATE SEQUENCE seq_taif_d_prov_destin
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_prov_destin
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_prov_destin TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_prov_destin TO taif_rw;


CREATE SEQUENCE seq_taif_d_ruolo
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_ruolo
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_ruolo TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_ruolo TO taif_rw;


CREATE SEQUENCE seq_taif_d_specie
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_specie
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_specie TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_specie TO taif_rw;
	
	
CREATE SEQUENCE seq_taif_d_stato_opfo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_stato_opfo
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_stato_opfo TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_stato_opfo TO taif_rw;		
		
		
CREATE SEQUENCE seq_taif_d_stato_pratica
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_stato_pratica
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_stato_pratica TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_stato_pratica TO taif_rw;


CREATE SEQUENCE seq_taif_d_tipo_attivita
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_attivita
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_attivita TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_attivita TO taif_rw;


CREATE SEQUENCE seq_taif_d_tipo_carrello
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_carrello
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_carrello TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_carrello TO taif_rw;


CREATE SEQUENCE seq_taif_d_tipo_certificazione
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_certificazione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_certificazione TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_certificazione TO taif_rw;


CREATE SEQUENCE seq_taif_d_tipo_contratto
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_contratto
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_contratto TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_contratto TO taif_rw;		
		
		
CREATE SEQUENCE seq_taif_d_tipo_dpi
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_dpi
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_dpi TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_dpi TO taif_rw;		
	
		
CREATE SEQUENCE seq_taif_d_tipo_inquadramento
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_inquadramento
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_inquadramento TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_inquadramento TO taif_rw;


CREATE SEQUENCE seq_taif_d_tipo_lavoro_pa
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_lavoro_pa
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_lavoro_pa TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_lavoro_pa TO taif_rw;


CREATE SEQUENCE seq_taif_d_tipo_mansione
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_mansione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_mansione TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_mansione TO taif_rw;


CREATE SEQUENCE seq_taif_d_tipo_mezzo
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_mezzo
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_mezzo TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_mezzo TO taif_rw;


CREATE SEQUENCE seq_taif_d_tipo_qualifica
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_qualifica
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_qualifica TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_qualifica TO taif_rw;
	
		
CREATE SEQUENCE seq_taif_d_tipo_sede_azienda
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_sede_azienda
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_sede_azienda TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_sede_azienda TO taif_rw;	
	
	
CREATE SEQUENCE seq_taif_d_tipo_struttura
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_tipo_struttura
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_struttura TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_tipo_struttura TO taif_rw;		
	
	
CREATE SEQUENCE seq_taif_d_titolo_studio
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_titolo_studio
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_titolo_studio TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_titolo_studio TO taif_rw;	
	
	
CREATE SEQUENCE seq_taif_d_trazione
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_trazione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_trazione TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_trazione TO taif_rw;	
	
	
CREATE SEQUENCE seq_taif_d_unita_formativa
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_unita_formativa
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_unita_formativa TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_unita_formativa TO taif_rw;	


CREATE SEQUENCE seq_taif_d_unita_misura
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_d_unita_misura
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_unita_misura TO taif;
GRANT ALL ON SEQUENCE seq_taif_d_unita_misura TO taif_rw;		
	
	
CREATE SEQUENCE seq_taif_r_azienda_associazione
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_r_azienda_associazione
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_r_azienda_associazione TO taif;
GRANT ALL ON SEQUENCE seq_taif_r_azienda_associazione TO taif_rw;


CREATE SEQUENCE seq_taif_r_tranz_tipomezzo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_r_tranz_tipomezzo
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_r_tranz_tipomezzo TO taif;
GRANT ALL ON SEQUENCE seq_taif_r_tranz_tipomezzo TO taif_rw;


CREATE SEQUENCE seq_taif_t_agenzia_formativa
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_agenzia_formativa
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_agenzia_formativa TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_agenzia_formativa TO taif_rw;


CREATE SEQUENCE seq_taif_t_aziendafr_tipocontr
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_aziendafr_tipocontr
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_aziendafr_tipocontr TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_aziendafr_tipocontr TO taif_rw;


CREATE SEQUENCE seq_taif_t_corso
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_corso
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_corso TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_corso TO taif_rw;


CREATE SEQUENCE seq_taif_t_opfo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_opfo
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_opfo TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_opfo TO taif_rw;


CREATE SEQUENCE seq_taif_t_soggetto_gestore
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999999
  START 1
  CACHE 1;
ALTER TABLE seq_taif_t_soggetto_gestore
  OWNER TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_soggetto_gestore TO taif;
GRANT ALL ON SEQUENCE seq_taif_t_soggetto_gestore TO taif_rw;
