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

insert into TIPOPESSOAJURIDICA(nomeTipoPessoaJuridica) values('MEI');
insert into TIPOPESSOAJURIDICA(nomeTipoPessoaJuridica) values('S.A');