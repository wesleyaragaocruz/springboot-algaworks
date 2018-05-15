/**
 * Author:  wesley
 * Created: 09/05/2018
 */

DROP TABLE IF EXISTS public.tb_pes_pessoa;
CREATE TABLE public.tb_pes_pessoa (
	pes_id_pessoa bigserial NOT NULL,
	pes_ds_nome character varying(50) NOT NULL,
	pes_ds_logradouro character varying(30),
	pes_ds_numero character varying(30),
	pes_ds_complemento character varying(30),
	pes_ds_bairro character varying(30),
	pes_ds_cep character varying(30),
	pes_ds_cidade character varying(30),
	pes_ds_estado character varying(30),
	pes_st_ativo boolean NOT NULL,
        CONSTRAINT pk_pes PRIMARY KEY (pes_id_pessoa)
) WITH (OIDS = FALSE);

/*ALTER TABLE public.tb_pes_pessoa OWNER TO algaworks;*/

INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Pedro Barbosa', 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Henrique Medeiros', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Carlos Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Leonardo Oliveira', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
INSERT INTO public.tb_pes_pessoa (pes_ds_nome, pes_ds_logradouro, pes_ds_numero, pes_ds_complemento, pes_ds_bairro, pes_ds_cep, pes_ds_cidade, pes_ds_estado, pes_st_ativo) values ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);
