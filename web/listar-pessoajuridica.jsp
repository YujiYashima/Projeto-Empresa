<%-- 
    Document   : listar-pessoajuridica
    Created on : 24/03/2021, 10:41:26
    Author     : Aluno
--%>

<%@page import="br.com.projetoempresa.model.PessoaJuridica"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciamento de Pessoa Juridica</title>
    </head>
    <body>
        <h1 align="center">Projeto Empresa</h1>
        <hr>
        <table align="center" border="1">
            <tr>
                <td colspan="9" align="center">Lista de Pessoa Jurídica</td>
            </tr>

            <tr>
                <th align="center">ID</th>
                <th align="center">Nome</th>
                <th align="center">Telefone</th>
                <th align="center">CNPJ</th>
                <th align="center">IE</th>
                <th align="center">Tipo</th>
                <th align="center">Alterar</th>
                <th align="center">Excluir</th>
            </tr>

            <%

                List<PessoaJuridica> pessoasJuridicas = (List<PessoaJuridica>) request.getAttribute("pessoasJuridicas");
                for (PessoaJuridica pessoaJuridica : pessoasJuridicas) {

            %>
            <tr>
                <td align="center"><%=pessoaJuridica.getIdPessoaJuridica()%></td>
                <td align="center"><%=pessoaJuridica.getNomePessoa()%></td>
                <td align="center"><%=pessoaJuridica.getTelefonePessoa()%></td>
                <td align="center"><%=pessoaJuridica.getCnpjPessoaJuridica()%></td>
                <td align="center"><%=pessoaJuridica.getIePessoaJuridica()%></td>
                <td align="center"><%=pessoaJuridica.getTipoPessoaJuridica()%></td>
                <td align="center"><a href="CarregarPessoaJuridica?idPessoa=<%=pessoaJuridica.getIdPessoaJuridica()%>">Alterar</a></td>
                <td align="center"><a href="ExcluirPessoaJuridica?idPessoa=<%=pessoaJuridica.getIdPessoaJuridica()%>">Excluir</a></td>
            </tr>

            <%
                }
            %>

        </table><br>

    <center>
        <tr>
            <td align="center" colspan="9"><a href="cadastrar-pessoajuridica.jsp">Cadastrar Outro</a></td>
        </tr>
    </center><br>

    <center>
        <tr>
            <td align="center" colspan="9"><a href="index.jsp">Home</a></td>
        </tr>
    </center>

</body>
</html>

