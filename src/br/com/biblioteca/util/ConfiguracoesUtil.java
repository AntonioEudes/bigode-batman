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
public class ConfiguracoesUtil {
    
    private static final String FILE_NAME = "configuracao";
    public static final String URL = "url";
    public static final String USUARIO = "usuario";
    public static final String SENHA = "senha";
    
    private static ResourceBundle bundle;
    
    static{
        bundle = ResourceBundle.getBundle(FILE_NAME);
    }
    
    public static String getValor(String chave){
        return bundle.getString(chave);
    }
    
}
