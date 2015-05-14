/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.controle;

import br.com.biblioteca.Modeloprincipal.Funcionario;
import br.com.biblioteca.facede.IFacade;
import br.com.biblioteca.facede.ImplFacade;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class FuncionarioControle {

    private IFacade fachada = new ImplFacade();

    public void SalvarFuncionario(Funcionario func) throws Exception {
        fachada.inserirFuncionario(func);
    }

    public Funcionario ProcurarFuncionario(int id) throws Exception {
        return fachada.buscarFuncionario(id);

    }

    public void RemoverFuncionario(int id) throws Exception {
        fachada.removerFuncionario(id);
    }

    public List<Funcionario> listarFuncionario() throws Exception {
        return fachada.listarFuncionario();

    }

    public List<Funcionario> BuscarFuncionarioPorNome(String nome) throws Exception {
        return fachada.buscarFuncionarioPorNome(nome);

    }

    public void EditarFuncionario(Funcionario func) throws Exception {
        fachada.editarFuncionario(func);
    }

}
