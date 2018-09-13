/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nickyhe
 */
public class CreateTable {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby://localhost:1527/MovieDB;create=true";
        String dbusername = "Nick";
        String dbpassword = "123";

        Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);
        System.out.println("Database has connected...");
        Statement statement = conn.createStatement();
        
        statement.executeUpdate("CREATE TABLE USERINFO(EMAIL VARCHAR(30), PASSWORD VARCHAR(20))");
        System.out.println("Table USERINFO created");
        
        statement.executeUpdate("CREATE TABLE MOVIEINFO (NAME VARCHAR(50), RELEASEYEAR VARCHAR(20), TYPE VARCHAR(30), DIRECTOR VARCHAR(30))");
        System.out.println("Table MOVIEINFO created");

        statement.executeUpdate("INSERT INTO MOVIEINFO (NAME, RELEASEYEAR, TYPE, DIRECTOR) "
                + "VALUES('Wonder Woman', '2017', 'Action,Adventure,Fantasy', 'Patty Jenkins')");
        statement.executeUpdate("INSERT INTO MOVIEINFO (NAME, RELEASEYEAR, TYPE, DIRECTOR) "
                + "VALUES('Logan', '2017', 'Action,Sci-FI,Drama', 'James Mangold')");
        statement.executeUpdate("INSERT INTO MOVIEINFO (NAME, RELEASEYEAR, TYPE, DIRECTOR) "
                + "VALUES('Justice League', '2017', 'Action,Adventure,Fantasy', 'Zack Snyder')");
        statement.executeUpdate("INSERT INTO MOVIEINFO (NAME, RELEASEYEAR, TYPE, DIRECTOR) "
                + "VALUES('Guardians of the Galaxy Vol. 2', '2017', 'Action,Adventure,Comedy', 'James Gunn')");
        statement.executeUpdate("INSERT INTO MOVIEINFO (NAME, RELEASEYEAR, TYPE, DIRECTOR) "
                + "VALUES('Pirates of the Caribbean 5 Dead Men Tell No Tales', '2017', 'Action,Adventure,Fantasy', 'Joachim Ronning')");

        System.out.println("Value updated");
        statement.close();
        conn.close();
    }
}
