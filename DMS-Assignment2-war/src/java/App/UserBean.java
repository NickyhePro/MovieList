/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author nickyhe
 */
@Stateless
@LocalBean
public class UserBean {

    String url = "jdbc:derby://localhost:1527/MovieDB;create=true";
    String dbusername = "Nick";
    String dbpassword = "123";

    public boolean register(User user) {

        boolean registered = false;

        try {
            
            if(!checkTableExisting())
            {
                createTable();
            }
           
            Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);
           
            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO USERINFO(EMAIL, PASSWORD)"
                            + " VALUES(?, ?)");
            st.setString(1, user.getEmail());
            st.setString(2, user.getPassword());
           
            int result = st.executeUpdate();
            
            if (result == 1) {
                registered = true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return registered;

    }

    public boolean login(User user) {

        try {

            Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);
            
            Statement st = conn.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT * FROM USERINFO");

            if (!rs.next()) {
                return false;
            } else {
                do {
                    
                    String email = rs.getString(1);
                    String password = rs.getString(2);
                    
                    if(user.getEmail().equals(email) && user.getPassword().equals(password))
                    {
                        return true;
                    }
                    
                } while (rs.next());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
    private void createTable() throws SQLException
    {
        Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);
        System.out.println("Database has connected...");
        Statement statement = conn.createStatement();
        
        statement.executeUpdate("CREATE TABLE USERINFO (EMAIL VARCHAR(30), PASSWORD VARCHAR(20))");
        System.out.println("Table USERINFO created");
        
        statement.close();
        conn.close();
    }
    
    private boolean checkTableExisting() {
        boolean flag = false;
        try {
            System.out.println("Check existing tables.... ");
            Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.equalsIgnoreCase("USERINFO")) {
                    flag = true;
                    System.out.println("Table has already existed.");
                }
            }
            
            if(flag == false)
            {
                System.out.println("No such table found.");
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
                conn.close();
            }
        } catch (SQLException ex) {
            
        }
        return flag;
     }

}
