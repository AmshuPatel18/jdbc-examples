package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {


            public static void main(String[] args) throws SQLException {
                String jdbc_url = "jdbc:mysql://localhost:3306/studentdb";
                String username = "root";
                String pswd = "root";
                Connection con=null;
                PreparedStatement psmt=null;
                try {
                    con = DriverManager.getConnection(jdbc_url, username, pswd);
                    con.setAutoCommit(false);
                    psmt = con.prepareStatement("INSERT INTO students(id,name,grade) VALUES(?,?,?)");

                    psmt.setInt(1,8);
                    psmt.setString(2,"Vinnie");
                    psmt.setString(3,"B");
                    psmt.executeUpdate();

                    psmt.setInt(1,9);
                    psmt.setString(2,"Kiya");
                    psmt.setString(3,"A");
                    psmt.executeUpdate();
                    con.commit();
                    System.out.println("transaction done succesfully");



                }catch(SQLException e){
                    System.out.println("Exception occured rolled back!");
                    if(con!=null){
                        con.rollback();
                    }

                }
                con.close();
            }
        }
