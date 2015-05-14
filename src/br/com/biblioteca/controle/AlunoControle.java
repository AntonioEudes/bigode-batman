/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.controle;

import br.com.biblioteca.Modeloprincipal.Aluno;
import br.com.biblioteca.Modeloprincipal.Funcionario;
import br.com.biblioteca.facede.IFacade;
import br.com.biblioteca.facede.ImplFacade;
import br.com.biblioteca.util.DaoFactory;
import java.util.List;

/**
 *
 * @author Antonio Eudes
 */
public class AlunoControle {

    private IFacade fachada = DaoFactory.createImplFacade();

    public void SalvarAluno(Aluno aluno) throws Exception {
        fachada.inserirAluno(aluno);
    }

    public void RemoverAluno(int id) throws Exception {
        fachada.removerAluno(id);
    }

    public List<Aluno> listarAlunos() throws Exception {
        return fachada.listarAluno();

    }

    public List<Aluno> BuscarAlunoPorNome(String nome) throws Exception {
        return fachada.buscarAlunoPorNome(nome);

    }

    public void EditarAluno(Aluno aluno) throws Exception {
        fachada.editarAluno(aluno);
    }

    public Aluno ProcurarAluno(int id) throws Exception {
        return fachada.buscarAluno(id);

    }

}
