package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertStudent {

    public static void main(String[] args) {
        String jdbc_url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";
        try{
            Connection conn = DriverManager.getConnection(jdbc_url, username, password);
            PreparedStatement psmt=conn.prepareStatement("INSERT INTO students(id,name,grade)VALUES(?,?,?)");
            psmt.setInt(1,4);
            psmt.setString(2,"Aliya");
            psmt.setString(3,"A+");
            psmt.executeUpdate();
            System.out.println("Done with insertion");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
