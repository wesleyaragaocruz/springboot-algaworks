/**
 * Author:  wesley
 * Created: 08/05/2018
 */

DROP TABLE IF EXISTS public.tb_cat_categoria;

CREATE TABLE public.tb_cat_categoria (
   cat_id_categoria serial NOT NULL, 
   cat_ds_categoria character varying(50), 
   CONSTRAINT pk_cat PRIMARY KEY (cat_id_categoria)
) WITH (OIDS = FALSE);

/*ALTER TABLE public.tb_cat_categoria OWNER TO algaworks;*/

INSERT INTO public.tb_cat_categoria (cat_ds_categoria) VALUES ('Farmácia');
INSERT INTO public.tb_cat_categoria (cat_ds_categoria) VALUES ('Lazer');
INSERT INTO public.tb_cat_categoria (cat_ds_categoria) VALUES ('Supermercado');
INSERT INTO public.tb_cat_categoria (cat_ds_categoria) VALUES ('Alimentação');
INSERT INTO public.tb_cat_categoria (cat_ds_categoria) VALUES ('Outros');


