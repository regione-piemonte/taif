/*
Copyright CSI-Piemonte -2021
SPDX-License-Identifier: EUPL-1.2-or-later.
*/

CREATE TABLE taif_cnf_param_acta
(
  id_config_param_acta integer NOT NULL,
  codice character varying(50) NOT NULL,
  valore character varying(500),
  CONSTRAINT pk_taif_cnf_param_acta PRIMARY KEY (id_config_param_acta),
  CONSTRAINT taif_cnf_param_acta_codice_key UNIQUE (codice)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE taif_cnf_param_acta
  OWNER TO taif;
GRANT ALL ON TABLE taif_cnf_param_acta TO taif;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE taif_cnf_param_acta TO taif_rw;



CREATE TABLE taif_cnf_param_apimgr
(
  id_config_param_apimgr integer NOT NULL,
  consumer_key character varying(200),
  consumer_secret character varying(200),
  data_inizio_validita date,
  data_fine_validita date,
  CONSTRAINT pk_taif_cnf_param_apimgr PRIMARY KEY (id_config_param_apimgr)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE taif_cnf_param_apimgr
  OWNER TO taif;
GRANT ALL ON TABLE taif_cnf_param_apimgr TO taif;
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLE taif_cnf_param_apimgr TO taif_rw;
