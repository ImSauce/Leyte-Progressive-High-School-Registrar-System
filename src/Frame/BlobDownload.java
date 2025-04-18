
package Frame;

import java.io.*;
import java.sql.*;

public class BlobDownload {
    public void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        FileOutputStream fos = null;

        try {
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

            // SQL query to retrieve the blob data
            String sql = "SELECT blob_column FROM your_table WHERE condition";

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if (rs.next()) {
                // Retrieve the blob data
                Blob blob = rs.getBlob("blob_column");

                // Convert blob data to file
                InputStream in = blob.getBinaryStream();
                File file = new File("output.png"); // Specify the file name and extension
                fos = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("File downloaded successfully.");
            } else {
                System.out.println("No data found.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (fos != null) {
                    fos.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}