/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Aluno
 */
@WebServlet(name = "AlterarPessoaJuridica", urlPatterns = {"/AlterarPessoaJuridica"})
public class AlterarPessoaJuridica extends HttpServlet {

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
            
            Integer idPessoaJuridica = Integer.parseInt(request.getParameter("idPessoaJuridica"));
            Integer idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
            String nomePessoaJuridica = request.getParameter("nomePessoaJuridica");
            String telefonePessoaJuridica = request.getParameter("telefonePessoaJuridica");
            String cnpjPessoaJuridica = request.getParameter("cnpjPessoaJuridica");
            String iePessoaJuridica = request.getParameter("iePessoaJuridica");
            String tipoPessoaJuridica = request.getParameter("tipoPessoaJuridica");
           
            String mensagem = null;

            PessoaJuridica pessoaJuridica = new PessoaJuridica();
            pessoaJuridica.setIdPessoaJuridica(idPessoaJuridica);
            pessoaJuridica.setNomePessoa(nomePessoaJuridica);
            pessoaJuridica.setTelefonePessoa(telefonePessoaJuridica);
            pessoaJuridica.setCnpjPessoaJuridica(cnpjPessoaJuridica);
            pessoaJuridica.setIePessoaJuridica(iePessoaJuridica);
            pessoaJuridica.setTipoPessoaJuridica(tipoPessoaJuridica);
            pessoaJuridica.setIdPessoa(idPessoa);

            try {
                GenericDAO dao = new PessoaJuridicaDAO();
                if (dao.alterar(pessoaJuridica)) {
                    mensagem = "PessoaJuridica alterado com sucesso.";
                } else {
                    mensagem = "Problemas ao alterar PessoaJuridica.";
                }
                request.setAttribute("mensagem", mensagem);
                request.getRequestDispatcher("ListarPessoaJuridica").forward(request, response);

            } catch (Exception e) {
                System.out.println("Problemas no Servlet ao alterar PessoaJuridica CTR! Erro: "
                        + e.getMessage());
                e.printStackTrace();
        
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