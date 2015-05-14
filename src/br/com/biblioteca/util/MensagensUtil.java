/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.util;

import java.util.ResourceBundle;

/**
 *
 * @author Marcelo
 */
public class MensagensUtil {
    
    private static final String FILE_NAME = "mensagens";
    public static final String MSG_ERRO_SALVAR = "msg_erro_salvar";
    public static final String MSG_SUCESSO_SALVAR = "msg_sucesso_salvar";
    public static final String MSG_ERRO_SALVAR_GENERICA = "msg_erro_salvar_generica";
    public static final String MSG_SUCESSO_SALVAR_GENERICA = "msg_sucesso_salvar_generica";
    public static final String MSG_SUCESSO_EDITAR_GENERICA = "msg_sucesso_Editar";
    public static final String MSG_REMOVIDO_SUCESSO = "msg_Removido_Sucesso";
    public static final String MSG_ERRO_DELETAR_GENERICA = "msg_erro_deletar_generica"; 
    public static final String MSG_SELECIONE_ELEMENTO_TABELA = "msg_Selecione_elemento_tabela"; 
    public static final String MSG_PERGUNTA_REMOCAO_TABELA = "msg_Pergunta_Remocao_tabela";
    private static ResourceBundle bundle;
    
    static{
        bundle = ResourceBundle.getBundle(FILE_NAME);
    }
    
    public static String getValor(String chave){
        return bundle.getString(chave);
    }
    
    public static String getValor(String chave, String valor){
        return String.format(bundle.getString(chave), valor);
    }
    
    public static String getValor(String chave, String valor,String valor2){
        return String.format(bundle.getString(chave), valor,valor2);
    }
}
