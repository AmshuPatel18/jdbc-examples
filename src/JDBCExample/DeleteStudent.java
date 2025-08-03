package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent {
    public static void main(String[] args) {
        String jdbc_url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";
        try{
            Connection con= DriverManager.getConnection(jdbc_url,username,password);
            PreparedStatement smt=con.prepareStatement("DELETE FROM students WHERE id=?");
            smt.setInt(1,1);
            int rowsDeleted=smt.executeUpdate();
            if(rowsDeleted>0){
                System.out.println("deletd your row");
            }
            else{
                System.out.println("no matching id found to delete"
                );
            }
            smt.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
