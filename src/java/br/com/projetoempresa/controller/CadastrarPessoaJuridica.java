package br.com.projetoempresa.controller;

import br.com.projetoempresa.dao.GenericDAO;
import br.com.projetoempresa.dao.PessoaJuridicaDAO;
import br.com.projetoempresa.model.PessoaJuridica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlunoRemoto
 */
@WebServlet(name = "CadastrarPessoaJuridica", urlPatterns = {"/CadastrarPessoaJuridica"})
public class CadastrarPessoaJuridica extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //Obter os valores digitados no formulário
            String nomePessoaJuridica = request.getParameter("nomePessoaJuridica");
            String telefonePessoaJuridica = request.getParameter("telefonePessoaJuridica");
            String cnpjPessoaJuridica = request.getParameter("cnpjPessoaJuridica");
            String iePessoaJuridica = request.getParameter("iePessoaJuridica");
            String tipoPessoaJuridica = request.getParameter("tipoPessoaJuridica");
            
            //Incicializar variavel de mensagem
            String msg = null;
            
            //Inicializar objeto e atribuir valores a ele
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setNomePessoa(nomePessoaJuridica);
            pessoaJuridica.setTelefonePessoa(telefonePessoaJuridica);
            pessoaJuridica.setCnpjPessoaJuridica(cnpjPessoaJuridica);
            pessoaJuridica.setIePessoaJuridica(iePessoaJuridica);
            pessoaJuridica.setTipoPessoaJuridica(tipoPessoaJuridica);
            
            //Cadastrar uma PessoaJuridica na DAO
            try {
                GenericDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
                if (pessoaJuridicaDAO.cadastrar(pessoaJuridica)) {
                    //Se o cadastro for um sucesso, ele retornar TRUE
                    msg = "Usuário cadastrado com sucesso!";
                } else {
                    //Senao retorna FALSE
                    msg = "Problemas ao cadastrar PessoaJuridica. "
                            + "Verifique os dados informados e tente novamente!";
                }
                request.setAttribute("mensagem", msg);
                request.getRequestDispatcher("cadastrar-pessoajuridica.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("Problemas ao cadastrar PessoaJurídica CTR! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
