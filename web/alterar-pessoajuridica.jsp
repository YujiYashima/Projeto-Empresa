<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1 align="center">Etec de Fernandópolis</h1>
        <hr>
        <h2 align="center">Controle de PessoasJuridicas</h2>
        <form name="alterarpessoaJuridica" action="AlterarPessoaJuridica" method="POST">
            <table align="center" border="0">
                <tr>
                    <th colspan="2" align="center">Alteração de PessoaJuridica</th>
                </tr>
                
                <tr>
                    <th colspan="2" align="center">${mensagem}</th>
                </tr>
                
                <tr>
                    <td>ID PessoaJuridica</td>
                    <td><input type="text" name="idPessoaJuridica" value="${pessoaJuridica.idPessoaJuridica}" readonly="true"></td>
                </tr>
                
                <tr>
                    <td>ID Pessoa:</td>
                    <td><input type="text" name="idPessoa" id="idPessoa"
                               value="${pessoaJuridica.idPessoa}" readonly="true"></td>
                </tr>
                
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nomePessoaJuridica" value="${pessoaJuridica.nomePessoa}"></td>
                </tr>
                
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="telefonePessoaJuridica" value="${pessoaJuridica.telefonePessoa}"></td>
                </tr>
                
                <tr>
                    <td>CNPJ:</td>
                    <td><input type="text" name="cnpjPessoaJuridica" value="${pessoaJuridica.cnpjPessoaJuridica}"></td>
                </tr>
                
                <tr>
                    <td>IE:</td>
                    <td><input type="text" name="iePessoaJuridica" value="${pessoaJuridica.iePessoaJuridica}"></td>
                </tr>
                
                <tr>
                    <td>Tipo:</td>
                    <td><input type="text" name="tipoPessoaJuridica" value="${pessoaJuridica.tipoPessoaJuridica}"></td>
                </tr>
                
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" name="alterar" value="Alterar">
                    </td>
                </tr>
                
                <tr>
                    <td align="center" colspan="2"><a href="ListarPessoaJuridica">Voltar</a></td>
                </tr>
            </table>
        </form>
                
    </body>
</html>
