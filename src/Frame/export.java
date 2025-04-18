
package Frame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class export extends javax.swing.JFrame {

    Connection con; //sql
    PreparedStatement pts; //sql

     Statement st;
        ResultSet rs;
        
        Sounds sfx = new Sounds();
    private Clip clip;
    
    
    public void Connect() {
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/lphs5?allowMultiQueries=true", "root", "");
            st = con.createStatement();
            System.out.println("Successfully connected to the database");
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to connect to the database");
        }
    }
    
    public export() {
        initComponents();
         ImageIcon icon = new ImageIcon ("lphslogo.png");
        setIconImage(icon.getImage());
        
        setTitle("export");
        Connect();
        
      
        refreshTable();
        
        refreshTableArchive();
        refreshTableTransferout();
        refreshTableTransferin();
                
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        students = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        importscroll4 = new javax.swing.JScrollPane();
        ArchiveTable = new javax.swing.JTable();
        importscroll = new javax.swing.JScrollPane();
        MasterlistTable = new javax.swing.JTable();
        importscroll5 = new javax.swing.JScrollPane();
        TransferinTable = new javax.swing.JTable();
        importscroll6 = new javax.swing.JScrollPane();
        TransferoutTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Please select the data to be exported");

        students.setBackground(new java.awt.Color(133, 196, 255));
        students.setForeground(new java.awt.Color(0, 0, 0));
        students.setText("Masterlist Table");
        students.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentsActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(133, 196, 255));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Archive Table");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(170, 170, 170));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("*Exporting Excel files does not include saving images.");

        jButton3.setBackground(new java.awt.Color(133, 196, 255));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Transferred in Table");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(133, 196, 255));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Transferred out Table");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        importscroll4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        importscroll4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        ArchiveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        ArchiveTable.getTableHeader().setReorderingAllowed(false);
        importscroll4.setViewportView(ArchiveTable);

        importscroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        importscroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        MasterlistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        MasterlistTable.getTableHeader().setReorderingAllowed(false);
        importscroll.setViewportView(MasterlistTable);

        importscroll5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        importscroll5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        TransferinTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        TransferinTable.getTableHeader().setReorderingAllowed(false);
        importscroll5.setViewportView(TransferinTable);

        importscroll6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        importscroll6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        TransferoutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""
            }
        ));
        TransferoutTable.getTableHeader().setReorderingAllowed(false);
        importscroll6.setViewportView(TransferoutTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(importscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importscroll4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importscroll5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importscroll6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importscroll4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importscroll5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(importscroll6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(students, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(students, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void studentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentsActionPerformed
        sfx.playSound2(clip);
        exportJTableToExcel();
      
        
    }//GEN-LAST:event_studentsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     sfx.playSound2(clip);
        exportJTableToExcel2();
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       sfx.playSound2(clip);
        exportJTableToExcel3();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      sfx.playSound2(clip);
        exportJTableToExcel4();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ArchiveTable;
    private javax.swing.JTable MasterlistTable;
    private javax.swing.JTable TransferinTable;
    private javax.swing.JTable TransferoutTable;
    private javax.swing.JScrollPane importscroll;
    private javax.swing.JScrollPane importscroll4;
    private javax.swing.JScrollPane importscroll5;
    private javax.swing.JScrollPane importscroll6;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton students;
    // End of variables declaration//GEN-END:variables

    
    
public void refreshTable() {
    String sql = "SELECT * FROM test";

    
    try {
        DefaultTableModel model = (DefaultTableModel) MasterlistTable.getModel();
        model.setRowCount(0);
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
 
    while (rs.next()) {
           String blank = "";
           String status="Incomplete";
 
        model.addRow(new Object[] {

            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            rs.getString(7),
            rs.getString(8),
            rs.getString(9),
            rs.getString(10),
            rs.getString(11),
            status,
            rs.getInt(13),
            rs.getString(14),
            rs.getString(15),
            rs.getString(16),
            rs.getString(17),
            rs.getString(18),
            rs.getString(19),
            rs.getString(20),
            rs.getString(21),
            rs.getString(22),
            rs.getString(23),
            rs.getString(24),
            rs.getString(25),
            rs.getString(26),
            rs.getString(27),
         
             blank,
            blank,
            blank,
            rs.getString(31),
            blank,
            blank,
            blank,
            blank,
            blank,
            blank,
          
            blank,
            blank,
            blank,
            
            rs.getString(41),
           
            

        });
    }
   
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}



public void refreshTableArchive() {
    String sql = "SELECT * FROM archive";

    
    try {
        DefaultTableModel model = (DefaultTableModel) ArchiveTable.getModel();
        model.setRowCount(0);
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
 
    while (rs.next()) {
            String blank = "";
            String status="Incomplete";
           
 
        model.addRow(new Object[] {

            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            rs.getString(7),
            rs.getString(8),
            rs.getString(9),
            rs.getString(10),
            rs.getString(11),
            status,
            rs.getInt(13),
            rs.getString(14),
            rs.getString(15),
            rs.getString(16),
            rs.getString(17),
            rs.getString(18),
            rs.getString(19),
            rs.getString(20),
            rs.getString(21),
            rs.getString(22),
            rs.getString(23),
            rs.getString(24),
            rs.getString(25),
            rs.getString(26),
            rs.getString(27),
            
            
            blank,
            blank,
            blank,
            rs.getString(31),
            blank,
            blank,
            blank,
            blank,
            blank,
            blank,
          
            blank,
            blank,
            blank,
           
            rs.getString(41),
           
            

        });
    }
   
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}



public void refreshTableTransferin() {
    String sql = "SELECT * FROM transferin";

    
    try {
        DefaultTableModel model = (DefaultTableModel) TransferinTable.getModel();
        model.setRowCount(0);
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
 
    while (rs.next()) {
            String blank ="";
            String status="Incomplete";
        
 
        model.addRow(new Object[] {

            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            rs.getString(7),
            rs.getString(8),
            rs.getString(9),
            rs.getString(10),
            rs.getString(11),
            status,
            rs.getInt(13),
            rs.getString(14),
            rs.getString(15),
            rs.getString(16),
            rs.getString(17),
            rs.getString(18),
            rs.getString(19),
            rs.getString(20),
            rs.getString(21),
            rs.getString(22),
            rs.getString(23),
            rs.getString(24),
            rs.getString(25),
            rs.getString(26),
            rs.getString(27),
            
             blank,
            blank,
            blank,
            rs.getString(31),
            blank,
            blank,
            blank,
            blank,
            blank,
            blank,
          
            blank,
            blank,
            blank,
            
            rs.getString(41),
           
            

        });
    }
   
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}


public void refreshTableTransferout() {
    String sql = "SELECT * FROM transferout";

    
    try {
        DefaultTableModel model = (DefaultTableModel) TransferoutTable.getModel();
        model.setRowCount(0);
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
 
    while (rs.next()) {
            String blank ="";
            String status="Incomplete";
        
 
        model.addRow(new Object[] {

            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getString(6),
            rs.getString(7),
            rs.getString(8),
            rs.getString(9),
            rs.getString(10),
            rs.getString(11),
            status,
            rs.getInt(13),
            rs.getString(14),
            rs.getString(15),
            rs.getString(16),
            rs.getString(17),
            rs.getString(18),
            rs.getString(19),
            rs.getString(20),
            rs.getString(21),
            rs.getString(22),
            rs.getString(23),
            rs.getString(24),
            rs.getString(25),
            rs.getString(26),
            rs.getString(27),
           
             blank,
            blank,
            blank,
            rs.getString(31),
            blank,
            blank,
            blank,
            blank,
            blank,
            blank,
          
            blank,
            blank,
            blank,
            
            rs.getString(41),
           
            

        });
    }
   
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}


    
public void exportJTableToExcel() {
    JFileChooser excelFileChooser = new JFileChooser();
    excelFileChooser.setDialogTitle("Save As Excel File");
    excelFileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm"));
    int excelChooser = excelFileChooser.showSaveDialog(null);
    if (excelChooser == JFileChooser.APPROVE_OPTION) {
        XSSFWorkbook excelExport = new XSSFWorkbook();
        XSSFSheet excelSheet = excelExport.createSheet("Sheet1");
        DefaultTableModel model = (DefaultTableModel) MasterlistTable.getModel();

        // Fill data rows
        for (int row = 0; row < model.getRowCount(); row++) {
            XSSFRow excelRow = excelSheet.createRow(row);
            for (int col = 0; col < model.getColumnCount(); col++) {
                XSSFCell cell = excelRow.createCell(col);
                cell.setCellValue(model.getValueAt(row, col).toString());
            }
        }

        try {
            FileOutputStream excelFOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
            excelExport.write(excelFOS);
            excelExport.close();
            excelFOS.close();
            JOptionPane.showMessageDialog(null, "Data exported successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error exporting data: " + e.getMessage());
        }
    }
}
    
public void exportJTableToExcel2() {
    JFileChooser excelFileChooser = new JFileChooser();
    excelFileChooser.setDialogTitle("Save As Excel File");
    excelFileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm"));
    int excelChooser = excelFileChooser.showSaveDialog(null);
    if (excelChooser == JFileChooser.APPROVE_OPTION) {
        XSSFWorkbook excelExport = new XSSFWorkbook();
        XSSFSheet excelSheet = excelExport.createSheet("Sheet1");
        DefaultTableModel model = (DefaultTableModel) ArchiveTable.getModel();

        // Fill data rows
        for (int row = 0; row < model.getRowCount(); row++) {
            XSSFRow excelRow = excelSheet.createRow(row);
            for (int col = 0; col < model.getColumnCount(); col++) {
                XSSFCell cell = excelRow.createCell(col);
                cell.setCellValue(model.getValueAt(row, col).toString());
            }
        }

        try {
            FileOutputStream excelFOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
            excelExport.write(excelFOS);
            excelExport.close();
            excelFOS.close();
            JOptionPane.showMessageDialog(null, "Data exported successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error exporting data: " + e.getMessage());
        }
    }
}

public void exportJTableToExcel3() {
    JFileChooser excelFileChooser = new JFileChooser();
    excelFileChooser.setDialogTitle("Save As Excel File");
    excelFileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm"));
    int excelChooser = excelFileChooser.showSaveDialog(null);
    if (excelChooser == JFileChooser.APPROVE_OPTION) {
        XSSFWorkbook excelExport = new XSSFWorkbook();
        XSSFSheet excelSheet = excelExport.createSheet("Sheet1");
        DefaultTableModel model = (DefaultTableModel) TransferinTable.getModel();

        // Fill data rows
        for (int row = 0; row < model.getRowCount(); row++) {
            XSSFRow excelRow = excelSheet.createRow(row);
            for (int col = 0; col < model.getColumnCount(); col++) {
                XSSFCell cell = excelRow.createCell(col);
                cell.setCellValue(model.getValueAt(row, col).toString());
            }
        }

        try {
            FileOutputStream excelFOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
            excelExport.write(excelFOS);
            excelExport.close();
            excelFOS.close();
            JOptionPane.showMessageDialog(null, "Data exported successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error exporting data: " + e.getMessage());
        }
    }
}


public void exportJTableToExcel4() {
    JFileChooser excelFileChooser = new JFileChooser();
    excelFileChooser.setDialogTitle("Save As Excel File");
    excelFileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm"));
    int excelChooser = excelFileChooser.showSaveDialog(null);
    if (excelChooser == JFileChooser.APPROVE_OPTION) {
        XSSFWorkbook excelExport = new XSSFWorkbook();
        XSSFSheet excelSheet = excelExport.createSheet("Sheet1");
        DefaultTableModel model = (DefaultTableModel) TransferoutTable.getModel();

        // Fill data rows
        for (int row = 0; row < model.getRowCount(); row++) {
            XSSFRow excelRow = excelSheet.createRow(row);
            for (int col = 0; col < model.getColumnCount(); col++) {
                XSSFCell cell = excelRow.createCell(col);
                cell.setCellValue(model.getValueAt(row, col).toString());
            }
        }

        try {
            FileOutputStream excelFOS = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
            excelExport.write(excelFOS);
            excelExport.close();
            excelFOS.close();
            JOptionPane.showMessageDialog(null, "Data exported successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error exporting data: " + e.getMessage());
        }
    }
}
}
