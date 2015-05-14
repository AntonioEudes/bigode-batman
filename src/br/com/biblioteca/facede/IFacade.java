package br.com.biblioteca.facede;

import br.com.biblioteca.Modeloprincipal.Aluno;
import br.com.biblioteca.Modeloprincipal.Funcionario;
import br.com.biblioteca.Modeloprincipal.Pessoa;
import br.com.biblioteca.emprestimos.Livro;
import br.com.biblioteca.util.DaoFactory;
import java.util.List;

public interface IFacade {

    //Aluno
    public void inserirAluno(Aluno a) throws Exception;
    
    public void editarAluno(Aluno a) throws Exception;

    public void removerAluno(int id) throws Exception;

    public List<Aluno> listarAluno() throws Exception;
    
    public Aluno buscarAluno(int id) throws Exception;
    
    public List<Aluno> buscarAlunoPorNome(String nome) throws Exception;

    //Funcionario
    public void inserirFuncionario(Funcionario f) throws Exception;

    public void editarFuncionario(Funcionario f) throws Exception;

    public void removerFuncionario(int id) throws Exception;

    public List<Funcionario> listarFuncionario() throws Exception;

    public Funcionario buscarFuncionario(int id) throws Exception;
    
    public List<Funcionario> buscarFuncionarioPorNome(String nome) throws Exception;
    
    //LIvro
    
    public void inserirLivro(Livro l) throws Exception;

    public void editarLivro(Livro l) throws Exception;

    public void removerLivro(int id) throws Exception;

    public List<Livro> listarLivro() throws Exception;

    public Livro buscarLivro(int id) throws Exception;
    
    public List<Livro> buscarLivroPorNome(String nome) throws Exception;
    
}
