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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickyhe
 */
public class MovieBean {

    String url = "jdbc:derby://localhost:1527/MovieDB;create=true";
    String dbusername = "Nick";
    String dbpassword = "123";

    public boolean addMovie(Movie movie) {
        boolean check = false;

        try {

            if (!checkTableExisting()) {
                createTable();
            }

            Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);

            PreparedStatement st
                    = conn.prepareStatement("INSERT INTO MOVIEINFO (NAME, RELEASEYEAR, TYPE, DIRECTOR) "
                            + "VALUES(?, ?, ?, ?)");
            st.setString(1, movie.getName());
            st.setString(2, movie.getYear());
            st.setString(3, movie.getType());
            st.setString(4, movie.getDirectors());

            int result = st.executeUpdate();

            if (result == 1) {
                check = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return check;
    }

    public List<Movie> getMovie() {
        List<Movie> movies = new ArrayList<>();
        try {
            
            if (!checkTableExisting()) {
                createTable();
            }
            
            Connection connection = DriverManager.getConnection(url, dbusername, dbpassword);

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM MOVIEINFO");

            Movie movie;
            
            if (!rs.next()) {
                return null;
            } else {
                do {
                    movie = new Movie();
                    movie.setName(rs.getString(1));
                    movie.setYear(rs.getString(2));
                    movie.setType(rs.getString(3));
                    movie.setDirectors(rs.getString(4));
                    movies.add(movie);
                } while (rs.next());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return movies;
    }

    private void createTable() throws SQLException {
        Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);
        System.out.println("Database has connected...");
        Statement statement = conn.createStatement();

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

    private boolean checkTableExisting() {
        boolean flag = false;
        try {
            System.out.println("Check existing tables.... ");
            Connection conn = DriverManager.getConnection(url, dbusername, dbpassword);
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);

            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.equalsIgnoreCase("MOVIEINFO")) {
                    flag = true;
                    System.out.println("Table has already existed.");
                }
            }

            if (flag == false) {
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
