package br.com.biblioteca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    ConfiguracoesUtil.getValor(ConfiguracoesUtil.URL), 
                    ConfiguracoesUtil.getValor(ConfiguracoesUtil.USUARIO), 
                    ConfiguracoesUtil.getValor(ConfiguracoesUtil.SENHA));

            return conn;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

            return null;

        } catch (Exception e) {

        }
        return null;
    }

}
