/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import BaseClass.BaseClass;
import View.Thong_bao.Message;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author tudv
 */
public class ConnectDb {

    private Connection con = BaseClass.getConnectDb();
    private Message mess = BaseClass.getMessage();

    public static Connection connectDB() {
        Connection conn = null;
        try {
//            String url1 = "jdbc:mysql://localhost/quan_ly_thu_vien";
//            String user = "root";
//            String password = "";
//            conn = DriverManager.getConnection(url1, user, password);
        	
        	Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/qltv", "root", "1234567890");
        } catch (Exception ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        if (ConnectDb.connectDB() != null) {
            System.out.println("aaaaaaaaaaaaaa");
        };
    }
}
