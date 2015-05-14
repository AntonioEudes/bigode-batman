package br.com.biblioteca.dao;

import br.com.biblioteca.util.ConnectionFactory;
import br.com.biblioteca.util.DaoException;
import br.com.biblioteca.emprestimos.Livro;
import br.com.biblioteca.util.MensagensUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JDBCLivroDao implements LivroDao {

    private Connection con = ConnectionFactory.getConnection();

    public void inserir(Livro l) throws DaoException {

        con = ConnectionFactory.getConnection();

        try {

            String sql = "INSERT INTO livro (titulo,ano,area,autor,genero,descricao,isbn) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);

            st = con.prepareStatement(sql);

            st.setString(1, l.getTitulo());
            st.setString(2, l.getAno());
            st.setString(3, l.getArea());
            st.setString(4, l.getAutor());
            st.setString(5, l.getGenero());
            st.setString(6, l.getDescricao());
            st.setString(7, l.getIsbn());

            st.executeUpdate();

            st.close();
            con.close();

            

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Livro"));
            throw new DaoException("Erro ao inserir registro");
        }

    }

    public void editar(Livro l) throws DaoException {

        con = ConnectionFactory.getConnection();

        try {

            String sql1 = "UPDATE livro SET titulo = ?, ano = ?, area = ?, autor = ?, genero = ?, descricao = ?, isbn = ? WHERE id = ? ";

            PreparedStatement st = con.prepareStatement(sql1);

            st.setString(1, l.getTitulo());
            st.setString(2, l.getAno());
            st.setString(3, l.getArea());
            st.setString(4, l.getAutor());
            st.setString(5, l.getGenero());
            st.setString(6, l.getDescricao());
            st.setString(7, l.getIsbn());

            st.setInt(8, l.getId());

            st.executeUpdate();

            st.close();
            con.close();

            System.out.println("Ok");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Livro"));
            ex.printStackTrace();
        }

    }

    public void remover(int id) throws DaoException {
        con = ConnectionFactory.getConnection();
        try {
            String sql = "DELETE FROM livro WHERE id = ? ";

            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.executeUpdate();

            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Livro"));
            throw new DaoException("");
        }
    }

    public List<Livro> listarLivro() throws DaoException {
        this.con = ConnectionFactory.getConnection();
        try {
            List<Livro> l = new ArrayList<Livro>();

            String sql = "SELECT * FROM livro";

            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Livro livro = new Livro();

                livro.setTitulo(rs.getString("titulo"));
                livro.setAno(rs.getString("ano"));
                livro.setArea(rs.getString("area"));
                livro.setAutor(rs.getString("autor"));
                livro.setGenero(rs.getString("genero"));
                livro.setDescricao(rs.getString("descricao"));
                livro.setIsbn(rs.getString("isbn"));

                livro.setId(rs.getInt("id"));

                l.add(livro);

            }
            st.close();

            con.close();

            return l;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Livro"));
            throw new DaoException("");
        }
    }

    public Livro getPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Livro> listarLivroPorNome(String titulo) throws DaoException {
        
            this.con = ConnectionFactory.getConnection();
        try {

            List<Livro> l = new ArrayList<Livro>();

            String sql = "SELECT* FROM livro where titulo like ?";

            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, titulo+ "%");

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Livro livro = new Livro();

                livro.setTitulo(rs.getString("titulo"));
                livro.setAno(rs.getString("ano"));
                livro.setArea(rs.getString("area"));
                livro.setAutor(rs.getString("autor"));
                livro.setGenero(rs.getString("genero"));
                livro.setDescricao(rs.getString("descricao"));
                livro.setIsbn(rs.getString("isbn"));

                l.add(livro);
            }

            st.close();

            con.close();

            return l;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Livro"));
            throw new DaoException("");
        }
    }

}
