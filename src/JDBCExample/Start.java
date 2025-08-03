package JDBCExample;

import java.sql.*;

public class Start {
    public static void main(String[] args) {
        String jdbc_url="jdbc:mysql://localhost:3306/studentdb";
        String username="root";
        String pswd="root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con= DriverManager.getConnection(jdbc_url,username,pswd);
            Statement smt=con.createStatement();
            ResultSet rs=smt.executeQuery("SELECT * FROM students");


            while(rs.next()){
                System.out.println("ID | Name | Grade");
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String grade=rs.getString("grade");

                System.out.println(id + " | " + name + " | " + grade);

            }
            rs.close();
            smt.close();
            con.close();
            System.out.println("connection closed");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
