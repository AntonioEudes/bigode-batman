/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bilbioteca.view.livro;

import br.com.biblioteca.controle.LivroControle;
import br.com.biblioteca.emprestimos.Livro;
import br.com.biblioteca.util.MensagensUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class CadastrarLivro extends javax.swing.JFrame {

    private Livro livro = new Livro();

    private LivroControle livroControle = new LivroControle();
    /**
     * Creates new form CadastrarLivro
     */
    public CadastrarLivro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextAno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextArea = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextAutor = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextGenero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextDescricao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTexIsbn = new javax.swing.JTextField();
        JButtonCancelar = new javax.swing.JButton();
        JButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Cadastro de Livro");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel1.setText("Titulo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));
        getContentPane().add(jTextTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 150, -1));

        jLabel3.setText("Ano:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));
        getContentPane().add(jTextAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 50, -1));

        jLabel4.setText("Area:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
        getContentPane().add(jTextArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 150, -1));

        jLabel5.setText("Autor:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));
        getContentPane().add(jTextAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, -1));

        jLabel6.setText("Genero:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));
        getContentPane().add(jTextGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 150, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Biblioteca\\src\\br\\com\\biblioteca\\incone\\Picture-26(bilbiotecaaaaaaaaa).png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 190, 180));

        jLabel8.setText("Descrição");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, -1, -1));
        getContentPane().add(jTextDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 150, -1));

        jLabel9.setText("ISBN");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, -1, -1));
        getContentPane().add(jTexIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 160, -1));

        JButtonCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Biblioteca\\src\\br\\com\\biblioteca\\incone\\delet.png")); // NOI18N
        JButtonCancelar.setText("Cancelar");
        JButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(JButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        JButtonSalvar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Biblioteca\\src\\br\\com\\biblioteca\\incone\\accept.png")); // NOI18N
        JButtonSalvar.setText("Salvar");
        JButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(JButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 110, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_JButtonCancelarActionPerformed

    private void JButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonSalvarActionPerformed

        String titulo = jTextTitulo.getText();
        String ano = jTextAno.getText();
        String area = jTextArea.getText();
        String autor = jTextAutor.getText();
        String genero = jTextGenero.getText();
        String descricao = jTextDescricao.getText();
        String isbn = jTexIsbn.getText();
        

        livro.setTitulo(titulo);
        livro.setAno(ano);
        livro.setArea(area);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setDescricao(descricao);
        livro.setIsbn(isbn);


        

        

        //Aluno aluno = new Aluno();

        //aluno.setNome(nome);
        //aluno.setCpf(cpf);
        //aluno.setRg(rg);
        //aluno.setPeriodo(periodo);
        //aluno.setMatricula(matricula);
        //aluno.setCurso(curso);

        try {
            livroControle.SalvarLivro(livro);
            //JOptionPane.showMessageDialog(null,"Cliente SALVO com sucesso!");
           int resp = JOptionPane.showConfirmDialog(null, "Salvar cadastro do Livro?", "Cadastramento", JOptionPane.YES_NO_OPTION);
            if (resp == 0) 
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_SUCESSO_SALVAR_GENERICA,"Livro"));
            {
                dispose();
            }
        } catch (Exception ex) {
            Logger.getLogger(CadastrarLivro.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "IMPOSSÍVEL inserir Aluno!", "ERRO ao inserir o Aluno!", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, MensagensUtil.getValor(MensagensUtil.MSG_ERRO_SALVAR, "Livro ", " Livro "));
        }

        jTextTitulo.setText("");
        jTextAno.setText("");
        jTextArea.setText("");
        jTextAutor.setText("");
        jTextGenero.setText("");
        jTextDescricao.setText("");
        jTexIsbn.setText("");

    }//GEN-LAST:event_JButtonSalvarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCancelar;
    private javax.swing.JButton JButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTexIsbn;
    private javax.swing.JTextField jTextAno;
    private javax.swing.JTextField jTextArea;
    private javax.swing.JTextField jTextAutor;
    private javax.swing.JTextField jTextDescricao;
    private javax.swing.JTextField jTextGenero;
    private javax.swing.JTextField jTextTitulo;
    // End of variables declaration//GEN-END:variables
}
