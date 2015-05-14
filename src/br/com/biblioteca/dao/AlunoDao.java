package br.com.biblioteca.dao;

import java.util.List;
//
import br.com.biblioteca.util.DaoException;
import br.com.biblioteca.Modeloprincipal.Aluno;

public interface AlunoDao {

    public void inserir(Aluno a) throws DaoException;

    public void editar(Aluno a) throws DaoException;

    public void remover(int id) throws DaoException;

    public List<Aluno> listarAlunos() throws DaoException;
   
    public List<Aluno> listarAlunosPorNome(String nome) throws DaoException;

    public Aluno getPorId(int id) throws DaoException;

}
