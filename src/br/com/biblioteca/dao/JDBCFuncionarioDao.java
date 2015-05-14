package br.com.biblioteca.dao;

import br.com.biblioteca.util.ConnectionFactory;
import br.com.biblioteca.util.DaoException;
import br.com.biblioteca.Modeloprincipal.Funcionario;
import br.com.biblioteca.util.MensagensUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class JDBCFuncionarioDao implements FuncionarioDao {

    
    private Connection con;
    private int idEndereco;
    private int idContato;

//    private Connection con = ConnectionFactory.getConnection();

    
    public void inserir(Funcionario f) throws DaoException {
        
          con = ConnectionFactory.getConnection();
        try {

           // String insertUsuario = "INSERT INTO usuario (login,senha) VALUES(?,?)";
            String insertFuncionario = "INSERT INTO funcionarios (nome,cpf,rg,cargo,dataadmicao) VALUES (?,?,?,?,?)";
            String funcionarioEndereco = "INSERT INTO enderecos (rua,numero,bairro,complemento,cidade,cep) VALUES (?,?,?,?,?,?)";
            String funcionarioTelefones = "INSERT INTO telefones (celular01,celular02,telefonefixo) VALUES (?,?,?)";

            //PreparedStatement st = con.prepareStatement(sql);  
             PreparedStatement st = con.prepareStatement(funcionarioEndereco,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, f.getEnderecoFuncionario().getRua());
            st.setString(2, f.getEnderecoFuncionario().getNumero());
            st.setString(3, f.getEnderecoFuncionario().getBairro());
            st.setString(4, f.getEnderecoFuncionario().getComplemento());
            st.setString(5, f.getEnderecoFuncionario().getCidade());
            st.setString(6, f.getEnderecoFuncionario().getCep());
            
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            rs = st.getGeneratedKeys();

            while (rs.next()) {
                idEndereco = rs.getInt(1);
            }

            
            st = con.prepareStatement(funcionarioTelefones,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            st.setString(1, f.getTelefoneFuncionario().getCelular01());
            st.setString(2, f.getTelefoneFuncionario().getCelular02());
            st.setString(3, f.getTelefoneFuncionario().getTelefoneFixo());

            st.executeUpdate();

            rs = st.getGeneratedKeys();

            while (rs.next()) {
                idContato = rs.getInt(1);
            }

            st = con.prepareStatement(insertFuncionario);

       //     st.setString(1, f.get);
            st.setString(1, f.getNome());
            st.setString(2, f.getCpf());
            st.setString(3, f.getRg());
            st.setString(4, f.getCargo());

            java.sql.Date dataDB = new java.sql.Date(f.getDataAdmicao().getTime());
            st.setDate(5, dataDB);
            st.executeUpdate();

            st.close();
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Funcionario"));
            throw new DaoException("");
        }

    }

    public void editar(Funcionario f) throws DaoException {

        
        try {
            con = ConnectionFactory.getConnection();
            
            String upDateFuncionario = "UPDATE funcionarios SET nome = ?, cpf = ?, rg = ?, cargo = ?, dataadmicao = ? WHERE id = ? ";
            
            PreparedStatement st = con.prepareStatement(upDateFuncionario);

            st.setString(1, f.getNome());
            st.setString(2, f.getCpf());
            st.setString(3, f.getRg());
            st.setString(4, f.getCargo());

            java.sql.Date dataDB = new java.sql.Date(f.getDataAdmicao().getTime());
            st.setDate(5, dataDB);
            
            st.setInt(6, f.getId());
            
            st.executeUpdate();

            st.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void remover(int id) throws DaoException {
        
        con = ConnectionFactory.getConnection();
        try {
            String sql = "DELETE FROM funcionarios WHERE id = ? ";
            
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setInt(1, id);
            st.executeUpdate();

            st.close();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_DELETAR_GENERICA,"Aluno"));
            
            throw new DaoException("Erro ao tentar deletar");
            
        }
    }

    public List<Funcionario> listarFuncionarios() throws DaoException {
        
        this.con = ConnectionFactory.getConnection();
        try {

            List<Funcionario> func = new ArrayList<Funcionario>();

            String sql = "SELECT * FROM funcionarios";

            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Funcionario f = new Funcionario();
                
                
                java.util.Date dataadmicao = new java.util.Date(rs.getDate("dataadmicao").getTime());
                ///java.util.Date dataDemicao = new java.util.Date(rs.getDate("dataDemicao").getTime());

                Funcionario funcionario = new Funcionario();

                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setCargo(rs.getString("cargo"));
     
                funcionario.setDataAdmicao(rs.getDate("dataadmicao"));
                //funcionario.setdataadmicao(dataadmicao);
               // funcionario.setDataDemicao(dataDemicao);
                
                
                funcionario.setId(rs.getInt("id"));

                func.add(funcionario);

            }

            st.close();

            con.close();

            return func;

        } catch (SQLException e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Funcionario"));
            throw new DaoException("");
        }
    }
    public Funcionario getPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public List<Funcionario>listarFuncionarioPorNome(String nome) throws DaoException {
         try {

            this.con = ConnectionFactory.getConnection();
            
            List<Funcionario> func = new ArrayList<Funcionario>();

            String sql = "SELECT* FROM funcionarios where nome like ?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, nome + "%");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                
                java.util.Date dataadmicao = new java.util.Date(rs.getDate("dataadmicao").getTime());
                
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRg(rs.getString("rg"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDataAdmicao(rs.getDate("dataadmicao"));
                
                //aluno.setId(rs.getInt("id"));

                func.add(funcionario);

            }

            st.close();

            con.close();

            return func;

        } catch (Exception e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Funcionario"));
            throw new DaoException("");
        }
    }
}
