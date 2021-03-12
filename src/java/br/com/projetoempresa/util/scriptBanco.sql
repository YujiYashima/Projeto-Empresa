create table PESSOA(

	idPessoa serial not null,
	nomePessoa varchar(50),
	telefonePessoa varchar(11),
	constraint pk_pessoa primary key(idpessoa)

);


create table PESSOAJURIDICA(

	idPessoaJuridica serial not null,
	cnpjPessoaJuridica varchar(14),
	iePessoaJuridica varchar(10),
        tipoPessoaJuridica varchar(10),
	idPessoa integer,
	constraint pk_pessoaJuridica primary key(idPessoaJuridica),
	constraint fk_pj_pessoa foreign key(idPessoa) references pessoa(idPessoa)
);

