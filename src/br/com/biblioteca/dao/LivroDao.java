package br.com.biblioteca.dao;

import java.util.List;

import br.com.biblioteca.util.DaoException;
import br.com.biblioteca.emprestimos.Livro;

public interface LivroDao {
    
public void inserir(Livro l) throws DaoException;

    public void editar(Livro l) throws DaoException;

    public void remover(int id) throws DaoException;

    public List<Livro> listarLivro() throws DaoException;
   
    public List<Livro> listarLivroPorNome(String nome) throws DaoException;

    public Livro getPorId(int id) throws DaoException;
}
