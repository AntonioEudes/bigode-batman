/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.util;

import br.com.biblioteca.dao.AlunoDao;
import br.com.biblioteca.dao.FuncionarioDao;
import br.com.biblioteca.dao.JDBCAlunoDao;
import br.com.biblioteca.dao.JDBCFuncionarioDao;
import br.com.biblioteca.dao.JDBCLivroDao;
import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.facede.ImplFacade;

public class DaoFactory {

    public static AlunoDao createAlunoDao() {
        return new JDBCAlunoDao();
    }

    public static FuncionarioDao createFuncionarioDao() {
        return new JDBCFuncionarioDao();
    }
    
    public static LivroDao createLivroDao() {
        return new JDBCLivroDao();
    }
    
    public static ImplFacade createImplFacade() {
        return new ImplFacade();
    }

}
