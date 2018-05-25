/**
 * Author:  wesley
 * Created: 10/05/2018
 */

-- DROP TABLE IF EXISTS public.tb_lcm_lancamento;
CREATE TABLE public.tb_lcm_lancamento (
	lcm_id_lancamento bigserial NOT NULL,
	lcm_ds_lancamento character varying(50) NOT NULL,
	lcm_dt_vencimento date NOT NULL,
	lcm_dt_pagamento date,
	lcm_vl_lancamento numeric(10,2) NOT NULL,
	lcm_ds_observacao character varying(100),
	lcm_tp_lancamento character varying(20) NOT NULL,
	cat_id_categoria integer NOT NULL,
	pes_id_pessoa bigint NOT NULL,
	CONSTRAINT pk_lcm PRIMARY KEY (lcm_id_lancamento),
  	CONSTRAINT fk_cat_lcm FOREIGN KEY (cat_id_categoria)
      REFERENCES public.tb_cat_categoria (cat_id_categoria) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT fk_pes_lcm FOREIGN KEY (pes_id_pessoa)
      REFERENCES public.tb_pes_pessoa (pes_id_pessoa) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
) WITH (OIDS=FALSE);

INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Salário mensal', '2017-06-10', null, 6500.00, 'Distribuição de lucros', 'RECEITA', 1, 1);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'DESPESA', 2, 2);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Top Club', '2017-06-10', null, 120, null, 'RECEITA', 3, 3);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Geração', 'RECEITA', 3, 4);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('DMAE', '2017-06-10', null, 200.30, null, 'DESPESA', 3, 5);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'RECEITA', 4, 6);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Bahamas', '2017-06-10', null, 500, null, 'RECEITA', 1, 7);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'DESPESA', 4, 8);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Despachante', '2017-06-10', null, 123.64, 'Multas', 'DESPESA', 3, 9);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Pneus', '2017-04-10', '2017-04-10', 665.33, null, 'RECEITA', 5, 10);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Café', '2017-06-10', null, 8.32, null, 'DESPESA', 1, 5);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Eletrônicos', '2017-04-10', '2017-04-10', 2100.32, null, 'DESPESA', 5, 4);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Instrumentos', '2017-06-10', null, 1040.32, null, 'DESPESA', 4, 3);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Café', '2017-04-10', '2017-04-10', 4.32, null, 'DESPESA', 4, 2);
INSERT INTO tb_lcm_lancamento (lcm_ds_lancamento, lcm_dt_vencimento, lcm_dt_pagamento, lcm_vl_lancamento, lcm_ds_observacao, lcm_tp_lancamento, cat_id_categoria, pes_id_pessoa) values ('Lanche', '2017-06-10', null, 10.20, null, 'DESPESA', 4, 1);

