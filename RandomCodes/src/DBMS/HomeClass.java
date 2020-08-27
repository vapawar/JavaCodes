package DBMS;

import java.sql.*;

public class HomeClass {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "vpawar00");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from customers");
            while (rs.next() != false) {
                System.out.println(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   "
                        + rs.getString(4) + rs.getString(5));
            }
            conn.close();
        } catch (Exception ex) {
        }
    }

}
