package org.example.services;
import java.sql.*;

public class AbstractDatabaseService {
    protected Connection conn;
    protected AbstractDatabaseService(String user,String password){
        Statement stmt = null;
        ResultSet rs = null;
        try {
            this.conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3000/pokedb?" +
                            "user="+user+"&password="+password);

            stmt = this.conn.createStatement();

            rs = stmt.executeQuery("SELECT * from pokemons");
            System.out.println(rs.getFetchSize());// Do something with the Connection

        }
        catch (SQLException ex) {
            // handle any errors
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
        catch (Exception e){
            System.err.println("JavaDriverException: " + e.getMessage());
        }
    }
}
