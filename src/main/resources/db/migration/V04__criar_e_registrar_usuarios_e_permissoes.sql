/**
 * Author:  wesley
 * Created: 12/05/2018
 */
/**
 * Author:  wesley
 * Created: 12/05/2018
 */
-- DROP TABLE IF EXISTS public.tb_usr_usuario;
CREATE TABLE public.tb_usr_usuario (
	usr_id_usuario bigserial NOT NULL,
	usr_no_usuario character varying(50) NOT NULL,
	usr_ds_email character varying(50) NOT NULL,
	usr_pw_senha character varying(150) NOT NULL,
        CONSTRAINT pk_usr PRIMARY KEY (usr_id_usuario)
);
/*ALTER TABLE public.tb_usr_usuario OWNER TO algaworks;*/

-- DROP TABLE IF EXISTS public.tb_prm_permissao;
CREATE TABLE public.tb_prm_permissao (
	prm_id_permissao bigserial NOT NULL,
	prm_ds_permissao character varying(50) NOT NULL,
        CONSTRAINT pk_prm PRIMARY KEY (prm_id_permissao)
);
/*ALTER TABLE public.tb_prm_permissao OWNER TO algaworks;*/

-- DROP TABLE IF EXISTS public.tb_usr_prm;
CREATE TABLE public.tb_usr_prm (
    usr_id_usuario bigint NOT NULL,
    prm_id_permissao bigint NOT NULL,
    CONSTRAINT pk_usr_prm PRIMARY KEY (usr_id_usuario, prm_id_permissao),
    CONSTRAINT fk_usr_prm FOREIGN KEY (usr_id_usuario)
      REFERENCES public.tb_usr_usuario (usr_id_usuario) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_prm_usr FOREIGN KEY (prm_id_permissao)
      REFERENCES public.tb_prm_permissao (prm_id_permissao) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);
/*ALTER TABLE public.tb_usr_prm OWNER TO algaworks;*/

INSERT INTO public.tb_usr_usuario (usr_id_usuario, usr_no_usuario, usr_ds_email, usr_pw_senha) values (1, 'Administrador', 'admin@algamoney.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO public.tb_usr_usuario (usr_id_usuario, usr_no_usuario, usr_ds_email, usr_pw_senha) values (2, 'Maria Silva', 'maria@algamoney.com', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO public.tb_prm_permissao (prm_id_permissao, prm_ds_permissao) values (1, 'ROLE_CADASTRAR_CATEGORIA');
INSERT INTO public.tb_prm_permissao (prm_id_permissao, prm_ds_permissao) values (2, 'ROLE_PESQUISAR_CATEGORIA');

INSERT INTO public.tb_prm_permissao (prm_id_permissao, prm_ds_permissao) values (3, 'ROLE_CADASTRAR_PESSOA');
INSERT INTO public.tb_prm_permissao (prm_id_permissao, prm_ds_permissao) values (4, 'ROLE_REMOVER_PESSOA');
INSERT INTO public.tb_prm_permissao (prm_id_permissao, prm_ds_permissao) values (5, 'ROLE_PESQUISAR_PESSOA');

INSERT INTO public.tb_prm_permissao (prm_id_permissao, prm_ds_permissao) values (6, 'ROLE_CADASTRAR_LANCAMENTO');
INSERT INTO public.tb_prm_permissao (prm_id_permissao, prm_ds_permissao) values (7, 'ROLE_REMOVER_LANCAMENTO');
INSERT INTO public.tb_prm_permissao (prm_id_permissao, prm_ds_permissao) values (8, 'ROLE_PESQUISAR_LANCAMENTO');

-- admin
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (1, 1);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (1, 2);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (1, 3);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (1, 4);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (1, 5);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (1, 6);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (1, 7);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (1, 8);

-- maria
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (2, 2);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (2, 5);
INSERT INTO public.tb_usr_prm (usr_id_usuario, prm_id_permissao) values (2, 8);