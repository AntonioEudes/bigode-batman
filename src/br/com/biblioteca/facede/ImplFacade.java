package br.com.biblioteca.facede;

import br.com.biblioteca.dao.AlunoDao;
import br.com.biblioteca.dao.FuncionarioDao;
import br.com.biblioteca.util.DaoFactory;
import br.com.biblioteca.Modeloprincipal.Aluno;
import br.com.biblioteca.Modeloprincipal.Funcionario;
import br.com.biblioteca.dao.LivroDao;
import br.com.biblioteca.emprestimos.Livro;
import br.com.biblioteca.util.DaoException;
import java.util.List;

public class ImplFacade implements IFacade {

    private AlunoDao alunoDao;
    private FuncionarioDao funcionarioDao;
    private LivroDao livroDao;

    public ImplFacade() {

        alunoDao = DaoFactory.createAlunoDao();
        funcionarioDao = DaoFactory.createFuncionarioDao();
        livroDao = DaoFactory.createLivroDao();
    }

//------------------------------------------------------------------------------------------------------------------------
    public void inserirAluno(Aluno aluno) throws Exception {

        try {
            this.alunoDao.inserir(aluno);

        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }

    }

    public void editarAluno(Aluno aluno) throws Exception {

        try {

            this.alunoDao.editar(aluno);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }

    }

    public void removerAluno(int id) throws Exception {

        try {

            this.alunoDao.remover(id);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Aluno> listarAluno() throws Exception {

        try {

            return alunoDao.listarAlunos();
        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());

        }
    }

    public Aluno buscarAluno(int id) throws Exception {

        try {

            return this.alunoDao.getPorId(id);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Aluno> buscarAlunoPorNome(String nome) throws Exception {
        return this.alunoDao.listarAlunosPorNome(nome);

    }
//--------------------------------------------------------------------------------

    public void inserirFuncionario(Funcionario func) throws Exception {

        try {
            this.funcionarioDao.inserir(func);

        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }

    }

    public void editarFuncionario(Funcionario func) throws Exception {

        try {

            this.funcionarioDao.editar(func);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }

    }

    public void removerFuncionario(int id) throws Exception {

        try {

            this.funcionarioDao.remover(id);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Funcionario> listarFuncionario() throws Exception {

        try {

            return this.funcionarioDao.listarFuncionarios();
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public Funcionario buscarFuncionario(int id) throws Exception {

        try {

            return this.funcionarioDao.getPorId(id);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Funcionario> buscarFuncionarioPorNome(String nome) throws Exception {
        return this.funcionarioDao.listarFuncionarioPorNome(nome);

    }
//------------------------------------------------------------------------------

    public void inserirLivro(Livro livro) throws Exception {

        try {
            this.livroDao.inserir(livro);

        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }

    }

    public void editarLivro(Livro livro) throws Exception {

        try {

            this.livroDao.editar(livro);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }

    }

    public void removerLivro(int id) throws Exception {

        try {

            this.livroDao.remover(id);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Livro> listarLivro() throws Exception {

        try {

            return livroDao.listarLivro();
        } catch (DaoException ex) {
            ex.printStackTrace();
            throw new Exception(ex.getMessage());

        }
    }

    public Livro buscarLivro(int id) throws Exception {

        try {

            return this.livroDao.getPorId(id);
        } catch (DaoException ex) {
            throw new Exception(ex.getMessage());

        }
    }

    public List<Livro> buscarLivroPorNome(String nome) throws Exception {
        return this.livroDao.listarLivroPorNome(nome);

    }

}
