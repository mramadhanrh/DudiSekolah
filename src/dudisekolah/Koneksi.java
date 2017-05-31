/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dudisekolah;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramadhan
 */
public class Koneksi {
    
    public Connection connection;
    public String username = "root";
    public String password = "";
    public String db = "java_report";
    public String driver = "com.mysql.jdbc.Driver";
    
    public Koneksi() {
        try {
            String url = "jdbc:mysql://localhost:3306/" + db;
            
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection() {
        return this.connection;
    }
    
    public ResultSet select(String sql) {
        try {
            PreparedStatement prepare = connection.prepareStatement(sql);
            ResultSet rs = prepare.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
