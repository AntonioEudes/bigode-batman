package br.com.biblioteca.dao;

import java.util.List;

import br.com.biblioteca.util.DaoException;
import br.com.biblioteca.Modeloprincipal.Funcionario;

public interface FuncionarioDao {

    public void inserir(Funcionario f) throws DaoException;

    public void editar(Funcionario f) throws DaoException;

    public void remover(int id) throws DaoException;

    public List<Funcionario> listarFuncionarios() throws DaoException;
    
    public List<Funcionario> listarFuncionarioPorNome(String nome) throws DaoException;

    public Funcionario getPorId(int id) throws DaoException;

}
