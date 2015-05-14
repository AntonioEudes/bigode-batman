package br.com.biblioteca.main;

import br.com.bilbioteca.view.principal.JFramePrincipal;
import br.com.biblioteca.dao.AlunoDao;
import br.com.biblioteca.dao.FuncionarioDao;
import br.com.biblioteca.util.DaoFactory;
import br.com.biblioteca.Modeloprincipal.Aluno;
import br.com.biblioteca.Modeloprincipal.Funcionario;
import br.com.biblioteca.util.DateUtil;
import br.com.biblioteca.util.MensagensUtil;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) throws Exception {
        JFramePrincipal frame = new JFramePrincipal();
        frame.setVisible(true);
        //JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR));
//         JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Funcionario"));
//        
//        JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR_GENERICA, "Aluno"));
//        JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_SUCESSO_SALVAR_GENERICA, "Aluno"));
        //JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR, "Aluno ", " Aluno "));
        
        
        
    }       
    
}
