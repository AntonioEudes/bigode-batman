/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.controle;

import br.com.biblioteca.emprestimos.Livro;
import br.com.biblioteca.facede.IFacade;
import br.com.biblioteca.util.DaoFactory;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LivroControle {

    private IFacade fachada = DaoFactory.createImplFacade();

    public void SalvarLivro(Livro livro) throws Exception {
        fachada.inserirLivro(livro);
    }

    public void RemoverLivro(int id) throws Exception {
        fachada.removerLivro(id);
    }

    public List<Livro> listarLivro() throws Exception {
        return fachada.listarLivro();

    }

    public List<Livro> BuscarLivroPorNome(String nome) throws Exception {
        return fachada.buscarLivroPorNome(nome);

    }

    public void EditarLivro(Livro livro) throws Exception {
        fachada.editarLivro(livro);
    }

    public Livro ProcurarLivro(int id) throws Exception {
        return fachada.buscarLivro(id);

    }

}
