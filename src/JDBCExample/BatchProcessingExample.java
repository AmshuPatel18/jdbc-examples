package JDBCExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessingExample {
    public static void main(String[] args) {
        String jdbc_url = "jdbc:mysql://localhost:3306/studentdb";
                String username = "root";
                String password = "root";

                try (Connection con = DriverManager.getConnection(jdbc_url, username, password)) {
                    con.setAutoCommit(false);  // 🔹 Optional but recommended for batching

                    String sql = "INSERT INTO students(id, name, grade) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(sql);

                    // 🔹 1st record
                    pstmt.setInt(1, 10);
                    pstmt.setString(2, "Aanya");
                    pstmt.setString(3, "A");
                    pstmt.addBatch();

                    // 🔹 2nd record
                    pstmt.setInt(1, 11);
                    pstmt.setString(2, "Ravi");
                    pstmt.setString(3, "B");
                    pstmt.addBatch();

                    // 🔹 3rd record
                    pstmt.setInt(1, 12);
                    pstmt.setString(2, "Sara");
                    pstmt.setString(3, "A+");
                    pstmt.addBatch();

                    // 🔹 Execute batch
                    int[] results = pstmt.executeBatch();

                    con.commit();  // 🔹 Commit once after all are successful
                    System.out.println("Batch inserted successfully. Rows affected: " + results.length);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

    }
}
