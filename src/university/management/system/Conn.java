package university.management.system;

import java.sql.*;

public class Conn{
    
    Connection c;
    Statement s;

    Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///Student_Progression", "root", "#pranav@2211");
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Trace() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
