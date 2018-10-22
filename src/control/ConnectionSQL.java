/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LinhDzai
 */
public class ConnectionSQL {

    private static String dbName = "QLKH";
    private static String userName = "sa";
    private static String pWorld = "2301";
    private static String sqlURL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + dbName + "; integratedSecurity=true";

    /**
     *
     * @param dbURL
     * @param userName
     * @param password
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(sqlURL, userName, pWorld);
            System.out.println("control.ConnectionSQL.getConnection()");
            return conn;
        } catch (Exception ex) {
            System.out.println("LOGIN FAIL!");
            ex.printStackTrace();
        }
        return null;

    }
  }


