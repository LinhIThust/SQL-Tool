/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DataBase;
import model.InfoBasicDB;
import net.proteanit.sql.DbUtils;
import view.Main;
/**
 *
 * @author LinhDzai
 */
public class Controller {

   // ConnectionSQL c = new ConnectionSQL();
    private Connection conn = ConnectionSQL.getConnection();

    public ArrayList<DataBase> getListNameDB() {
        String sql, sql2;
        ArrayList<DataBase> list = new ArrayList<>();
        sql = "SELECT * "
                + "FROM sys.databases d "
                + "WHERE d.database_id > 4";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DataBase db = new DataBase();
                db.setId(rs.getString(1));
                db.setName(rs.getString(2));

                list.add(db);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<InfoBasicDB> getInfoDB(String namedb) {
        ArrayList<InfoBasicDB> list = new ArrayList<>();
        String sql;
        sql = "USE " + namedb + "\n"
                + "SELECT TABLE_NAME,COLUMN_NAME,DATA_TYPE,"
                + "CHARACTER_MAXIMUM_LENGTH\n"
                + "FROM INFORMATION_SCHEMA.COLUMNS";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                InfoBasicDB info = new InfoBasicDB();
                info.setNameTable(rs.getString(1));
                info.setColName(rs.getString(2));
                info.setDataType(rs.getString(3));
                info.setMaxLength(rs.getInt(4));

                list.add(info);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public void getInfoDB1(String namedb) {
        String sql;
        sql = "USE " + namedb + "\n"
                + "SELECT TABLE_NAME,COLUMN_NAME,DATA_TYPE,"
                + "CHARACTER_MAXIMUM_LENGTH\n"
                + "FROM INFORMATION_SCHEMA.COLUMNS";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //jTable1.setModel(DbUtils.resultSetToNestedList(rs));
            
        } catch (SQLException e) {
        }
    }

//    public void Connect2DataBase(String nameDatabase) {
//        c.setDbName(nameDatabase);
//    }
//    public void setLoginDB(String user,String pass){
//        c.setUserName(user);
//        c.setpWorld(pass);
//    }

}
