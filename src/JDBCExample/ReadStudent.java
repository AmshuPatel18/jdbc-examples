package JDBCExample;

import java.sql.*;

public class ReadStudent  {
    public static void main(String[] args) {


        String jdbc_url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";
        try {
            Connection conn = DriverManager.getConnection(jdbc_url, username, password);
            Statement smt = conn.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM students");
            System.out.println("ID | Name | Grade");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String grade = rs.getString("grade");

                System.out.println(id + " | " + name + " | " + grade);
            }
                rs.close();
                smt.close();
                conn.close();
            } catch(SQLException e){
                e.printStackTrace();

            }


        }
    }