
package Frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTableSorter {
    public void sortAndPopulateTable(JTable table, String columnName) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data
        
        try {
            Connection con = DriverManager.getConnection("your_connection_string");
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM test ORDER BY " + columnName;
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Object[] row = new Object[model.getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }
            
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL exception
        }
    }
}
//
//
// MyTableSorter sorter = new MyTableSorter();
//        sorter.sortAndPopulateTable(MasterlistTable, "grade"); 