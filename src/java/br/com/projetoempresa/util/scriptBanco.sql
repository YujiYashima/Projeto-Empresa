create table PESSOA(

	idPessoa serial not null,
	nomePessoa varchar(50),
	telefonePessoa varchar(11),
	constraint pk_pessoa primary key(idpessoa)
);

create table TIPOPESSOAJURIDICA(

        idTipoPessoaJuridica serial not null,
        nomeTipoPessoaJuridica varchar(50),
        constraint pk_tipoPessoaJuridica primary key(idTipoPessoaJuridica)
);

create table PESSOAJURIDICA(

	idPessoaJuridica serial not null,
	cnpjPessoaJuridica varchar(14),
	iePessoaJuridica varchar(10),
        idTipoPessoaJuridica integer,
	idPessoa integer,
	constraint pk_pessoaJuridica primary key(idPessoaJuridica),
        constraint fk_tipo_pessoaJuridica foreign key(idTipoPessoaJuridica) references tipopessoajuridica(idTipoPessoaJuridica),
	constraint fk_pj_pessoa foreign key(idPessoa) references pessoa(idPessoa)
);

create table SERVICO(

        idServico serial not null,
        nomeServico varchar(30),
        valorServico numeric (7, 2),
        descricaoServico varchar(100),
        constraint pk_servico primary key(idServico)
);

create table PESSOAJURIDICA_SERVICO(

        idServico integer not null,
        idPessoaJuridica integer not null,
        constraint pk_pessoajuridica_servico primary key(idServico, idPessoaJuridica),
        constraint fk_servico foreign key(idServico) references servico(idServico),
        constraint fk_pessoajuridica foreign key(idPessoaJuridica) references pessoajuridica(idPessoaJuridica)
);

insert into TIPOPESSOAJURIDICA(nomeTipoPessoaJuridica) values('MEI');
insert into TIPOPESSOAJURIDICA(nomeTipoPessoaJuridica) values('S.A');
insert into SERVICO(nomeServico, valorServico, descricaoServico) values('Limpeza', 1000.00, 'Limpeza geral de qualquer local');
insert into SERVICO(nomeServico, valorServico, descricaoServico) values('Treinamento', 500.00, 'Treinamento de funcionários e estagiários');
insert into SERVICO(nomeServico, valorServico, descricaoServico) values('Marketing', 3000.00, 'Marketing, redes sociais e serviços de divulgação');