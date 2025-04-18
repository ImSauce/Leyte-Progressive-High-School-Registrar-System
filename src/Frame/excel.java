
package Frame;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel extends javax.swing.JFrame {
    
     Statement st;
        ResultSet rs;

    Connection con; //sql
    PreparedStatement pts; //sql
    private final main mainInstance;
    
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
    
    
File file = null;
String filepath = null;
   


    public excel(main mainInstance) {
        initComponents();
        ImageIcon icon = new ImageIcon ("lphslogo.png");
        setIconImage(icon.getImage());
        this.mainInstance = mainInstance;
        setTitle("import");
        
        Connect();
        
         setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Add a WindowListener to handle the closing event
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Hide the frame instead of closing
                setVisible(false);
            }
        });
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        pathTXT = new javax.swing.JTextField();
        importscroll = new javax.swing.JScrollPane();
        ImportTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        TableSelect = new javax.swing.JComboBox<>();
        Deleterow = new SystemOtherComps.PH_Button();
        ImportBT = new SystemOtherComps.PH_Button();
        selectfile = new SystemOtherComps.PH_Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));

        pathTXT.setEditable(false);
        pathTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathTXTActionPerformed(evt);
            }
        });

        ImportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Middle Name", "Last Name", "Sex", "Email", "Birthday", "", "", "", "Contact", "Lrn", "Status", "Grade", "", "", "", "Year", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ImportTable.getTableHeader().setReorderingAllowed(false);
        importscroll.setViewportView(ImportTable);
        if (ImportTable.getColumnModel().getColumnCount() > 0) {
            ImportTable.getColumnModel().getColumn(6).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(6).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(6).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(7).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(7).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(8).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(8).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(13).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(13).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(13).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(14).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(14).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(14).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(15).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(15).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(15).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(17).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(17).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(17).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(18).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(18).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(18).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(19).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(19).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(19).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(20).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(20).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(20).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(21).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(21).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(21).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(22).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(22).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(22).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(23).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(23).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(23).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(24).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(24).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(24).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(25).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(25).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(25).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(26).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(26).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(26).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(27).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(27).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(27).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(28).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(28).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(28).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(29).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(29).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(29).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(30).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(30).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(30).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(31).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(31).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(31).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(32).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(32).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(32).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(33).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(33).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(33).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(34).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(34).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(34).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(35).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(35).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(35).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(36).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(36).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(36).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(37).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(37).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(37).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(38).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(38).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(38).setMaxWidth(0);
            ImportTable.getColumnModel().getColumn(39).setMinWidth(0);
            ImportTable.getColumnModel().getColumn(39).setPreferredWidth(0);
            ImportTable.getColumnModel().getColumn(39).setMaxWidth(0);
        }

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Import into:");

        TableSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masterlist", "Archive", "Transferred in", "Transferred out" }));
        TableSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TableSelectActionPerformed(evt);
            }
        });

        Deleterow.setBackground(new java.awt.Color(255, 255, 255));
        Deleterow.setBorder(null);
        Deleterow.setForeground(new java.awt.Color(0, 0, 0));
        Deleterow.setText("Delete Row");
        Deleterow.setToolTipText("");
        Deleterow.setAAA_AutoFitToSize(true);
        Deleterow.setAAA_ImageBoundArcSize(20);
        Deleterow.setAAA_roundBottomLeft(20);
        Deleterow.setAAA_roundBottomRight(20);
        Deleterow.setAAA_roundTopLeft(20);
        Deleterow.setAAA_roundTopRight(20);
        Deleterow.setAA_ArcSize(20);
        Deleterow.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        Deleterow.setAA_DrawBorder(true);
        Deleterow.setAA_HoverColor(new java.awt.Color(211, 211, 211));
        Deleterow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleterowActionPerformed(evt);
            }
        });

        ImportBT.setBackground(new java.awt.Color(0, 204, 102));
        ImportBT.setBorder(null);
        ImportBT.setForeground(new java.awt.Color(255, 255, 255));
        ImportBT.setText("IMPORT");
        ImportBT.setToolTipText("");
        ImportBT.setAAA_AutoFitToSize(true);
        ImportBT.setAAA_ImageBoundArcSize(20);
        ImportBT.setAAA_roundBottomLeft(20);
        ImportBT.setAAA_roundBottomRight(20);
        ImportBT.setAAA_roundTopLeft(20);
        ImportBT.setAAA_roundTopRight(20);
        ImportBT.setAA_ArcSize(20);
        ImportBT.setAA_BorderColor(new java.awt.Color(59, 214, 137));
        ImportBT.setAA_ButtonColor(new java.awt.Color(0, 204, 102));
        ImportBT.setAA_DrawBorder(true);
        ImportBT.setAA_HoverColor(new java.awt.Color(8, 144, 76));
        ImportBT.setAA_PressColor(new java.awt.Color(85, 163, 124));
        ImportBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportBTActionPerformed(evt);
            }
        });

        selectfile.setBackground(new java.awt.Color(51, 153, 255));
        selectfile.setBorder(null);
        selectfile.setForeground(new java.awt.Color(255, 255, 255));
        selectfile.setText("Select File");
        selectfile.setToolTipText("");
        selectfile.setAAA_AutoFitToSize(true);
        selectfile.setAAA_ImageBoundArcSize(20);
        selectfile.setAAA_roundBottomLeft(20);
        selectfile.setAAA_roundBottomRight(20);
        selectfile.setAAA_roundTopLeft(20);
        selectfile.setAAA_roundTopRight(20);
        selectfile.setAA_ArcSize(20);
        selectfile.setAA_BorderColor(new java.awt.Color(117, 186, 255));
        selectfile.setAA_ButtonColor(new java.awt.Color(51, 153, 255));
        selectfile.setAA_DrawBorder(true);
        selectfile.setAA_HoverColor(new java.awt.Color(67, 129, 178));
        selectfile.setAA_PressColor(new java.awt.Color(113, 174, 235));
        selectfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TableSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImportBT, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addComponent(selectfile, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pathTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addComponent(Deleterow, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainpanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(importscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(pathTXT)
                    .addComponent(Deleterow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 415, Short.MAX_VALUE)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(TableSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ImportBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(mainpanelLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(importscroll, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pathTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathTXTActionPerformed
        
    }//GEN-LAST:event_pathTXTActionPerformed

    private void TableSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TableSelectActionPerformed
        sfx.playSound3(clip);
    }//GEN-LAST:event_TableSelectActionPerformed

    private void DeleterowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleterowActionPerformed
         sfx.playSound2(clip);
        DefaultTableModel model = (DefaultTableModel) ImportTable.getModel();
    int selectedRow = ImportTable.getSelectedRow();
    if (selectedRow != -1) {
        String studentID = ImportTable.getValueAt(selectedRow, 10).toString(); 
        try {
            String sql = "DELETE FROM `excel` WHERE lrn = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Selected Row: " + selectedRow); //debugging
                model.removeRow(selectedRow);
                System.out.println("Row deleted successfully!");
            } else {
                System.out.println("No rows deleted!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "SQL Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_DeleterowActionPerformed

    private void ImportBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportBTActionPerformed
         sfx.playSound2(clip);
        
    String selectedOption = TableSelect.getSelectedItem().toString();
    if (selectedOption.equals("Masterlist")) {
        moveDatabase();
        dispose();    
    } 
    if (selectedOption.equals("Archive")){
    moveDatabase2();
    dispose();    
    }
    if (selectedOption.equals("Transferred in")){
    moveDatabase3();
    dispose();    
    }
    if (selectedOption.equals("Transferred out")){
    moveDatabase4();
    dispose();    
    }
    
    }//GEN-LAST:event_ImportBTActionPerformed

    private void selectfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectfileActionPerformed
        importExcelToJtableJava();
        importToDatabase();
    }//GEN-LAST:event_selectfileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private SystemOtherComps.PH_Button Deleterow;
    private SystemOtherComps.PH_Button ImportBT;
    private javax.swing.JTable ImportTable;
    private javax.swing.JComboBox<String> TableSelect;
    private javax.swing.JScrollPane importscroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField pathTXT;
    private SystemOtherComps.PH_Button selectfile;
    // End of variables declaration//GEN-END:variables

public void importExcelToJtableJava() {

    DefaultTableModel model = (DefaultTableModel) ImportTable.getModel();

    File f = null;
    String paths = null;
    File excelFile;
    FileInputStream excelFIS = null;
    BufferedInputStream excelBIS = null;
    XSSFWorkbook excelImportToJTable = null;

    JFileChooser excelFileChooser = new JFileChooser();
    excelFileChooser.setDialogTitle("Select Excel File");
    FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
    excelFileChooser.setFileFilter(fnef);
    int excelChooser = excelFileChooser.showOpenDialog(null);
    if (excelChooser == JFileChooser.APPROVE_OPTION) {

        f = excelFileChooser.getSelectedFile();
        paths = f.getAbsolutePath();
        pathTXT.setText(paths);

        try {
            excelFile = excelFileChooser.getSelectedFile();
            excelFIS = new FileInputStream(excelFile);
            excelBIS = new BufferedInputStream(excelFIS);
            excelImportToJTable = new XSSFWorkbook(excelBIS);
            XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

          
             
            for (int row = 0; row <= excelSheet.getLastRowNum(); row++) {
                XSSFRow excelRow = excelSheet.getRow(row);
            XSSFCell[] cells = new XSSFCell[41];
             
                for (int i = 0; i < 41; i++) {
                    cells[i] = excelRow.getCell(i);
                    System.out.println(i);
                }
                

                model.addRow(new Object[]{
                     getStringCellValue(cells[0]), getStringCellValue(cells[1]), getStringCellValue(cells[2]), getStringCellValue(cells[3]), getStringCellValue(cells[4]), 
        getStringCellValue(cells[5]), getStringCellValue(cells[6]), getStringCellValue(cells[7]), getStringCellValue(cells[8]), getStringCellValue(cells[9]), 
        getStringCellValue(cells[10]), getStringCellValue(cells[11]), getStringCellValue(cells[12]), getStringCellValue(cells[13]), getStringCellValue(cells[14]), 
        getStringCellValue(cells[15]), getStringCellValue(cells[16]), getStringCellValue(cells[17]), getStringCellValue(cells[18]), getStringCellValue(cells[19]), 
        getStringCellValue(cells[20]), getStringCellValue(cells[21]), getStringCellValue(cells[22]), getStringCellValue(cells[23]), getStringCellValue(cells[24]), 
        getStringCellValue(cells[25]), getStringCellValue(cells[26]), getStringCellValue(cells[27]), getStringCellValue(cells[28]), getStringCellValue(cells[29]), 
        getStringCellValue(cells[30]), getStringCellValue(cells[31]), getStringCellValue(cells[32]), getStringCellValue(cells[33]), getStringCellValue(cells[34]), 
        getStringCellValue(cells[35]), getStringCellValue(cells[36]), getStringCellValue(cells[37]), getStringCellValue(cells[38]), getStringCellValue(cells[39]), 
        getStringCellValue(cells[40])
                });
            }

        } catch (IOException iOException) {
            JOptionPane.showMessageDialog(null, iOException.getMessage());
        } finally {
            try {
                if (excelFIS != null) {
                    excelFIS.close();
                }
                if (excelBIS != null) {
                    excelBIS.close();
                }
                if (excelImportToJTable != null) {
                    excelImportToJTable.close();
                }
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            }
        }
    }
}

// Helper method to get string cell value
private String getStringCellValue(XSSFCell cell) {
    if (cell == null) {
        return "";
    }
    switch (cell.getCellType()) {
        case STRING:
            return cell.getStringCellValue();
        case NUMERIC:
            return String.valueOf((int)cell.getNumericCellValue());
        default:
            return "";
    }
}

public void importToDatabase() {
    try {
        Statement stmt = con.createStatement();
        stmt.execute("TRUNCATE TABLE excel");
      
        String sql = "INSERT INTO `excel`(`fname`, `mname`, `lname`, `sex`, `email`, `birthday`, `bday`, `bmonth`, `byear`, `contact`, `lrn`, `status`, `grade`, `g6`, `g10`, `g12`, `schoolyear`, `syear1`, `syear2`, `tyear`, `transferin`, `transferout`, `archive`, `vmasterlist`, `g6year`, `g10year`, `g12year`, `Bcertificate`, `sf9`, `sf10`, `description`, `imageName1`, `imageName2`, `imageName3`, `imagePath1`, `imagePath2`, `imagePath3`, `imageFile1`, `imageFile2`, `imageFile3`, `Address`) \n" +
                     "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pstmt = con.prepareStatement(sql);

        for (int row = 0; row < ImportTable.getRowCount(); row++) {
            pstmt.setString(1, ImportTable.getValueAt(row, 0).toString());
            pstmt.setString(2, ImportTable.getValueAt(row, 1).toString());
            pstmt.setString(3, ImportTable.getValueAt(row, 2).toString());
            pstmt.setString(4, ImportTable.getValueAt(row, 3).toString());
            pstmt.setString(5, ImportTable.getValueAt(row, 4).toString());
            pstmt.setString(6, ImportTable.getValueAt(row, 5).toString());
            pstmt.setString(7, ImportTable.getValueAt(row, 6).toString());
            pstmt.setString(8, ImportTable.getValueAt(row, 7).toString());
            pstmt.setString(9, ImportTable.getValueAt(row, 8).toString());
            pstmt.setString(10, ImportTable.getValueAt(row, 9).toString());
            pstmt.setString(11, ImportTable.getValueAt(row, 10).toString());
            pstmt.setString(12, ImportTable.getValueAt(row, 11).toString());
            pstmt.setString(13, ImportTable.getValueAt(row, 12).toString());
            pstmt.setString(14, ImportTable.getValueAt(row, 13).toString());
            pstmt.setString(15, ImportTable.getValueAt(row, 14).toString());
            pstmt.setString(16, ImportTable.getValueAt(row, 15).toString());
            pstmt.setString(17, ImportTable.getValueAt(row, 16).toString());
            pstmt.setString(18, ImportTable.getValueAt(row, 17).toString());
            pstmt.setString(19, ImportTable.getValueAt(row, 18).toString());
            pstmt.setString(20, ImportTable.getValueAt(row, 19).toString());
            pstmt.setString(21, ImportTable.getValueAt(row, 20).toString());
            pstmt.setString(22, ImportTable.getValueAt(row, 21).toString());
            pstmt.setString(23, ImportTable.getValueAt(row, 22).toString());
            pstmt.setString(24, ImportTable.getValueAt(row, 23).toString());
            pstmt.setString(25, ImportTable.getValueAt(row, 24).toString());
            pstmt.setString(26, ImportTable.getValueAt(row, 25).toString());
            pstmt.setString(27, ImportTable.getValueAt(row, 26).toString());
            pstmt.setString(28, ImportTable.getValueAt(row, 27).toString());
            pstmt.setString(29, ImportTable.getValueAt(row, 28).toString());
            pstmt.setString(30, ImportTable.getValueAt(row, 29).toString());
            pstmt.setString(31, ImportTable.getValueAt(row, 30).toString());
            pstmt.setString(32, ImportTable.getValueAt(row, 31).toString());
            pstmt.setString(33, ImportTable.getValueAt(row, 32).toString());
            pstmt.setString(34, ImportTable.getValueAt(row, 33).toString());
            pstmt.setString(35, ImportTable.getValueAt(row, 34).toString());
            pstmt.setString(36, ImportTable.getValueAt(row, 35).toString());
            pstmt.setString(37, ImportTable.getValueAt(row, 36).toString());
            pstmt.setString(38, ImportTable.getValueAt(row, 37).toString());
            pstmt.setString(39, ImportTable.getValueAt(row, 38).toString());
            pstmt.setString(40, ImportTable.getValueAt(row, 39).toString());
            pstmt.setString(41, ImportTable.getValueAt(row, 40).toString());
          
            
            pstmt.addBatch();
        }
        
        // Execute batch insert
        pstmt.executeBatch();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}


    public void moveDatabase() {
        //String move =  "INSERT INTO test SELECT lrn, fname, mname, lname, placeofbirth, birthday, father, fathernumber, fatheroccupation, mother, mothernumber, motheroccupation, familyreligion, grade, section, track, strand, callname, address, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL FROM excel_student_table;";
        String move = "INSERT INTO test SELECT * FROM excel; DELETE FROM excel;";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(move);
            pstmt.executeUpdate();
            
        
            JOptionPane.showMessageDialog(null, " IMPORT SUCCESSFUL " );
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error moving data: " + e.getMessage());
        }
    }
    
    public void moveDatabase2() {
        //String move =  "INSERT INTO test SELECT lrn, fname, mname, lname, placeofbirth, birthday, father, fathernumber, fatheroccupation, mother, mothernumber, motheroccupation, familyreligion, grade, section, track, strand, callname, address, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL FROM excel_student_table;";
        String move = "INSERT INTO archive SELECT * FROM excel; DELETE FROM excel;";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(move);
            pstmt.executeUpdate();
            
        
            JOptionPane.showMessageDialog(null, " IMPORT SUCCESSFUL " );
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error moving data: " + e.getMessage());
        }
    }
    
    public void moveDatabase3() {
        //String move =  "INSERT INTO test SELECT lrn, fname, mname, lname, placeofbirth, birthday, father, fathernumber, fatheroccupation, mother, mothernumber, motheroccupation, familyreligion, grade, section, track, strand, callname, address, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL FROM excel_student_table;";
        String move = "INSERT INTO transferin SELECT * FROM excel; DELETE FROM excel;";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(move);
            pstmt.executeUpdate();
            
        
            JOptionPane.showMessageDialog(null, " IMPORT SUCCESSFUL " );
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error moving data: " + e.getMessage());
        }
    }
    
    public void moveDatabase4() {
        //String move =  "INSERT INTO test SELECT lrn, fname, mname, lname, placeofbirth, birthday, father, fathernumber, fatheroccupation, mother, mothernumber, motheroccupation, familyreligion, grade, section, track, strand, callname, address, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL , NULL FROM excel_student_table;";
        String move = "INSERT INTO transferout SELECT * FROM excel; DELETE FROM excel;";
        
        try {
            PreparedStatement pstmt = con.prepareStatement(move);
            pstmt.executeUpdate();
            
        
            JOptionPane.showMessageDialog(null, " IMPORT SUCCESSFUL " );
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error moving data: " + e.getMessage());
        }
    }



}
