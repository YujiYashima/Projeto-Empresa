/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoempresa.controller;

import br.com.projetoempresa.dao.GenericDAO;
import br.com.projetoempresa.dao.PessoaJuridicaDAO;
import br.com.projetoempresa.dao.TipoPessoaJuridicaDAO;
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
@WebServlet(name = "CarregarPessoaJuridica", urlPatterns = {"/CarregarPessoaJuridica"})
public class CarregarPessoaJuridica extends HttpServlet {

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
           
            Integer idPessoaJuridica = Integer.parseInt(request.getParameter("idPessoa"));
            
            try{
                GenericDAO dao = new PessoaJuridicaDAO();
                request.setAttribute("pessoaJuridica", dao.carregar(idPessoaJuridica));
                
                dao = new TipoPessoaJuridicaDAO();
                request.setAttribute("tipospessoasjuridicas", dao.listar());
                
                //Verei se crio uma nova pagina ou se uso o própio cadastrar
                request.getRequestDispatcher("alterar-pessoajuridica.jsp").forward(request, response);
            }catch(Exception e){
                System.out.println("Problemas ao carregar PessoaJuridica CTR! Erro: " + e.getMessage());
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
