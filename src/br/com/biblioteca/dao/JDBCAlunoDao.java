package br.com.biblioteca.dao;

import br.com.biblioteca.util.ConnectionFactory;
import br.com.biblioteca.util.DaoException;
import br.com.biblioteca.Modeloprincipal.Aluno;
import br.com.biblioteca.Modeloprincipal.Endereco;
import br.com.biblioteca.Modeloprincipal.Telefone;
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

public class JDBCAlunoDao implements AlunoDao {

    private Connection con;
    private int idEndereco;
    private int idContato;
    
    Endereco endereco = new Endereco();
    Telefone telefone = new Telefone();

    //private Connection con = ConnectionFactory.getConnection();
    public void inserir(Aluno a) throws DaoException {

        con = ConnectionFactory.getConnection();

        try {
            String insertEndereco = "INSERT INTO enderecos (rua,numero,bairro,complemento,cidade,cep) VALUES (?,?,?,?,?,?)";
            String insertTelefones = "INSERT INTO telefones (celular01,celular02,telefonefixo) VALUES (?,?,?)";
            String sql = "INSERT INTO alunos (nome,cpf,rg,periodo,matricula,curso) VALUES (?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(insertEndereco,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, a.getEnderecoAluno().getRua());
            st.setString(2, a.getEnderecoAluno().getNumero());
            st.setString(3, a.getEnderecoAluno().getBairro());
            st.setString(4, a.getEnderecoAluno().getComplemento());
            st.setString(5, a.getEnderecoAluno().getCidade());
            st.setString(6, a.getEnderecoAluno().getCep());

            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            rs = st.getGeneratedKeys();

            while (rs.next()) {
                idEndereco = rs.getInt(1);
            }

            st = con.prepareStatement(insertTelefones,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, a.getTelefoneAluno().getCelular01());
            st.setString(2, a.getTelefoneAluno().getCelular02());
            st.setString(3, a.getTelefoneAluno().getTelefoneFixo());

            st.executeUpdate();

            rs = st.getGeneratedKeys();

            while (rs.next()) {
                idContato = rs.getInt(1);
            }

            st = con.prepareStatement(sql);

            st.setString(1, a.getNome());
            st.setString(2, a.getCpf());
            st.setString(3, a.getRg());
            st.setString(4, a.getPeriodo());
            st.setString(5, a.getMatricula());
            st.setString(6, a.getCurso());

            st.executeUpdate();

            st.close();
            con.close();
           

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Aluno"));
            throw new DaoException("");
        }

    }

    @Override
    public void editar(Aluno a) throws DaoException {

        con = ConnectionFactory.getConnection();

        try {

            String endereco = "UPDATE endereco SET rua = ?, numero = ?, bairro = ?, complemento = ?, cidade = ?, cep = ? WHERE id )";
            String sqlAluno = "UPDATE alunos SET nome = ?, cpf = ?, rg = ?, periodo = ?, matricula = ?, curso = ? WHERE id = ? ";
            
 
            PreparedStatement st = con.prepareStatement(endereco,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, endereco);

            ResultSet rs = st.getGeneratedKeys();

            while (rs.next()) {
                idEndereco = rs.getInt(1);
            }
            
           st = con.prepareStatement(sqlAluno);

            st.setString(1, a.getNome());
            st.setString(2, a.getCpf());
            st.setString(3, a.getRg());
            st.setString(4, a.getPeriodo());
            st.setString(5, a.getMatricula());
            st.setString(6, a.getCurso());

            st.setInt(7, a.getId());

            st.executeUpdate();

            st.close();
            con.close();

           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Aluno"));
            ex.printStackTrace();
        }

    }

    public void remover(int id) throws DaoException {
        con = ConnectionFactory.getConnection();
        try {
            String deleteEnd = "DELETE FROM enderecos WHERE id = ?";
            String deleteTel = "DELETE FROM telefones WHERE id = ?";
            String sql = "DELETE FROM alunos WHERE id = ? ";

            PreparedStatement st = con.prepareStatement(sql);
            PreparedStatement stEnd = con.prepareStatement(deleteEnd);
            PreparedStatement stTel = con.prepareStatement(deleteTel);

            st.setInt(1, id);
            st.executeUpdate();

            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Aluno"));
            throw new DaoException("");
        }
    }

    public List<Aluno> listarAlunos() throws DaoException {
        
        this.con = ConnectionFactory.getConnection();
        
        try {
            List<Aluno> al = new ArrayList<Aluno>();
            String selectAluno = "SELECT * FROM alunos ";
            //String selectAluno = "SELECT * FROM alunos a,enderecos e,telefones t WHERE a.endereco = e.id, AND a.telefones = t.id";
            
            PreparedStatement st = con.prepareStatement(selectAluno);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();
                Endereco endereco = new Endereco();
                Telefone telefone = new Telefone();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setRg(rs.getString("rg"));
                aluno.setPeriodo(rs.getString("periodo"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setCurso(rs.getString("curso"));
                
                
//                telefone.setId(rs.getInt("id"));
  //              telefone.setCelular01(rs.getString("celular01"));
    //            telefone.setCelular02(rs.getString("celular02"));
      //          telefone.setTelefoneFixo(rs.getString("telefonefixo"));
        //        aluno.setTelefoneAluno(telefone);

//                endereco.setId(rs.getInt("id"));
//                endereco.setRua(rs.getString("rua"));
//                endereco.setNumero(rs.getString("numero"));
//                endereco.setBairro(rs.getString("bairro"));
//                endereco.setComplemento(rs.getString("complemento"));
//                endereco.setCidade(rs.getString("cidade"));
//                endereco.setCep(rs.getString("cep"));
//                aluno.setEnderecoAluno(endereco);
//                
                
                      al.add(aluno);
            }
            st.close();

            con.close();

            return al;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Aluno"));
            throw new DaoException("");
        }
    }

    public Aluno getPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Aluno> listarAlunosPorNome(String nome) throws DaoException {
        try {

            this.con = ConnectionFactory.getConnection();

            List<Aluno> al = new ArrayList<Aluno>();

         //   List<Endereco> end = new ArrayList<Endereco>();
            
            String sql = "SELECT* FROM alunos where nome like  ?";

            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, nome + "%");

            ResultSet rs = st.executeQuery();
            //ResultSet rsend = st.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setRg(rs.getString("rg"));
                //aluno.setMatricula(rs.getString("matricula"));
                aluno.setPeriodo(rs.getString("periodo"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setCurso(rs.getString("curso"));

                aluno.setId(rs.getInt("id"));

                al.add(aluno);
            //}
                //while (rsend.next()){
                //  idEndereco = rs.getInt(1);

                //Endereco endereco = new Endereco();
                //endereco.setRua(rsend.getString("rua"));
                //endereco.setNumero(rsend.getString("numero"));
                //endereco.setBairro(rsend.getString("bairro"));
                //endereco.setComplemento(rsend.getString("complemento"));
                //endereco.setCidade(rsend.getString("cidade"));
                // endereco.setCep(rsend.getString("cep"));
                //endereco.setId(rsend.getInt("id"));
                //end.add(endereco);
            }

            st.close();

            con.close();

            return al;

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Aluno"));
            throw new DaoException("");
        }
    }

}
