<%-- 
    Document   : cadastrar-tipo
    Created on : 02/06/2021, 17:48:49
    Author     : Yuji adm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar TipoPessoaJuridica</title>
    </head>
    <body>
        <h1 align="center">Projeto Empresa</h1>
        <hr>
        <form name="cadastrartipo" action="CadastrarTipo" method="POST">
            <table align="center" border="0">
                <tr>
                    <th colspan="2" align="center">Cadastro de Tipos de Pessoas Jurídicas</th>
                </tr>

                <tr>
                    <th colspan="2" align="center">${mensagem}</th>
                </tr>

                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nomeTipo" required="true"></td>
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
            <td align="center" colspan="2"><a href="index.jsp">Home</a></td>
        </tr>
    </center>
    
    </body>
</html>
