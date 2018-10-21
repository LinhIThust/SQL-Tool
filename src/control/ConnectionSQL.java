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

    private static String dbName = "";
    private static String userName = "xv";
    private static String pWorld = "";
    private static String sqlURL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=" + dbName + "; integratedSecurity=true";

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public  String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public  String getpWorld() {
        return pWorld;
    }

    public void setpWorld(String pWorld) {
        this.pWorld = pWorld;
    }

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
//            System.out.println("xx FAIL!");
//            System.out.println(userName);
//            System.out.println(pWorld);
            return conn;
        } catch (Exception ex) {
            System.out.println("LOGIN FAIL!");
            ex.printStackTrace();
        }
        return null;

    }

}
