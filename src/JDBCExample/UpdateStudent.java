package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudent {
    public static void main(String[] args) {


    String jdbc_url = "jdbc:mysql://localhost:3306/studentdb";
    String username = "root";
    String password = "root";
        try

    {
        Connection conn = DriverManager.getConnection(jdbc_url, username, password);
        PreparedStatement psmt = conn.prepareStatement("UPDATE students SET grade=? WHERE id=?");
        psmt.setString(1, "A+");
        psmt.setInt(2, 1);
        int updatedRow = psmt.executeUpdate();
        if (updatedRow > 0) {
            System.out.println("Rows Updated! ");
        } else {
            System.out.println("no matching id found to update");
        }
        psmt.close();
        conn.close();

    } catch(
    SQLException e){
        e.printStackTrace();
    }



}}
