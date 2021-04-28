<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Pessoa Jurídica</title>
    </head>
    <body>
        <h1 align="center">Projeto Empresa</h1>
        <hr>
        <form name="cadastrarpessoajuridica" action="CadastrarPessoaJuridica" method="POST">
            <table align="center" border="0">
                <tr>
                    <th colspan="2" align="center">Cadastro de Pessoas Jurídicas</th>
                </tr>

                <tr>
                    <th colspan="2" align="center">${mensagem}</th>
                </tr>

                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nomePessoaJuridica" required="true"></td>
                </tr>

                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="telefonePessoaJuridica" required="true"></td>
                </tr>

                <tr>
                    <td>CNPJ:</td>
                    <td><input type="text" name="cnpjPessoaJuridica" required="true"></td>
                </tr>

                <tr>
                    <td>IE (Inscrição Estadual):</td>
                    <td><input type="text" name="iePessoaJuridica"></td>
                </tr>

                <tr>
                    <td>Tipo:</td>
                    <td><input type="text" name="tipoPessoaJuridica"></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="cadastrar" value="Cadastrar">
                    </td>
                </tr>

            </table>
        </form><br>

    <center>
        <tr>
            <td align="center" colspan="9"><a href="ListarPessoaJuridica">Listar</a></td>
        </tr>
    </center><br>

    <center>
        <tr>
            <td align="center" colspan="2"><a href="index.jsp">Home</a></td>
        </tr>
    </center>

</body>
</html>
