package br.com.projetoempresa.controller;

import br.com.projetoempresa.dao.GenericDAO;
import br.com.projetoempresa.dao.PessoaJuridicaDAO;
import br.com.projetoempresa.dao.PessoaJuridicaServicoDAO;
import br.com.projetoempresa.model.PessoaJuridica;
import br.com.projetoempresa.model.PessoaJuridicaServico;
import br.com.projetoempresa.model.Servico;
import br.com.projetoempresa.model.TipoPessoaJuridica;
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
            String[] idServico = request.getParameterValues("idServico");
            int qntServicos = idServico.length;
            Integer idTipoPessoaJuridica = Integer.parseInt(request.getParameter("idTipoPessoaJuridica"));

            //Incicializar variavel de mensagem
            String msg = null;

            //Inicializar objeto e atribuir valores a ele
            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setNomePessoa(nomePessoaJuridica);
            pessoaJuridica.setTelefonePessoa(telefonePessoaJuridica);
            pessoaJuridica.setCnpjPessoaJuridica(cnpjPessoaJuridica);
            pessoaJuridica.setIePessoaJuridica(iePessoaJuridica);
            pessoaJuridica.setTipoPessoaJuridica(new TipoPessoaJuridica(idTipoPessoaJuridica));

            Integer idPJ = null;

            //Cadastrar uma PessoaJuridica na DAO
            try {
                PessoaJuridicaDAO dao = new PessoaJuridicaDAO();
                idPJ = dao.cadastrarPessoaJuridica(pessoaJuridica);

                if (idPJ > 0) {
                    pessoaJuridica.setIdPessoaJuridica(idPJ);

                    for (int i = 0; i < qntServicos; i++) {

                        PessoaJuridicaServico pessoaJuridicaServico = new PessoaJuridicaServico();
                        pessoaJuridicaServico.setServico(new Servico(Integer.parseInt(idServico[i])));
                        pessoaJuridicaServico.setPessoajuridica(pessoaJuridica);

                        GenericDAO pessoaJuridicaServicoDAO = new PessoaJuridicaServicoDAO();
                        if (pessoaJuridicaServicoDAO.cadastrar(pessoaJuridicaServico)) {
                            msg = "PessoaJuridica cadastrado com sucesso!";
                        } else {
                            msg = "Problemas ao cadastrar PessoaJuridica. "
                                    + "Verifique os dados informados e tente novamente!";
                        }

                    }
                } else {
                    msg = "Problemas ao cadastrar PessoaJuridica. "
                                    + "Verifique os dados informados e tente novamente!";
                }

                request.setAttribute("mensagem", msg);
                request.getRequestDispatcher("TipoPessoaJuridica").forward(request, response);
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
