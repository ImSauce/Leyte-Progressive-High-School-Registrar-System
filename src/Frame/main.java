package Frame;

import Frame.CustomCellRenderer;
import static com.microsoft.schemas.office.excel.STObjectType.Enum.table;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class main extends javax.swing.JFrame {
    
    int masterlistslide = 0;
    int archiveslide = 0;
    int transferinslide = 0;
    int transferoutslide= 0;
    int settingslide = 0;
    
    Sounds sfx = new Sounds();
    private Clip clip;
    int start = 0;
    String url= "jdbc:mysql://localhost/lphs5?allowMultiQueries=true";
        String user = "root";
        String pass= "";
        Statement st;
        ResultSet rs;
        
        
    
    private addStudent studentFrame; //add student button = used to prevent pop up duplication
   //edit student button = used to prevent pop up duplication
    Connection con = null; //sql
    PreparedStatement pst = null; //sql
    
    
    public main() {
        initComponents();
       
     
        
        
         JTableHeader header1 = MasterlistTable.getTableHeader();
         JTableHeader header2 = ArchiveTable.getTableHeader();
         JTableHeader header3 = TransferinTable.getTableHeader();
         JTableHeader header4 = TransferoutTable.getTableHeader();

        // Set the background color of the header
        header1.setBackground(new Color(246, 246, 246)); 
        header2.setBackground(new Color(246, 246, 246)); 
        header3.setBackground(new Color(246, 246, 246)); 
        header4.setBackground(new Color(246, 246, 246)); 

        // Set the foreground (text) color of the header
        //header.setForeground(Color.WHITE); // Set text color
        
        
//         if (masterlistRP.isVisible()){
//        masterlistRP.setVisible(false);  
//        } else {
//       masterlistRP.setVisible(true);  
//        }
         
         
        

    ExportPanel.setVisible(false);
    passpanel.setVisible(false);
    rowpanel.setVisible(false);
    fontpanel.setVisible(false);
    
    Font tableFont = MasterlistTable.getFont();
    int fontSize = tableFont.getSize();
    fontsizeTXT.setText(Integer.toString(fontSize));
    
    rowheightnum.setText(Integer.toString(MasterlistTable.getRowHeight()));
    
    
    
     
    
        
        
         //int index = MasterlistTable.getSelectedRow();
         
         
         //View Button POP UP command masterlist
    MasterlistTable.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me){
            if(SwingUtilities.isRightMouseButton(me)) {
                sfx.playSound2(clip);
                  ViewButton();
            }
        }
    });
    
    ArchiveTable.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me){
            if(SwingUtilities.isRightMouseButton(me)) {
                sfx.playSound2(clip);
                  ViewButtonArchive();
            }
        }
    });
    
    TransferinTable.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me){
            if(SwingUtilities.isRightMouseButton(me)) {
                sfx.playSound2(clip);
                  ViewButtonTransferin();
            }
        }
    });
    
    TransferoutTable.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent me){
            if(SwingUtilities.isRightMouseButton(me)) {
                sfx.playSound2(clip);
                  ViewButtonTransferout();
            }
        }
    });
    
    
    
    
    
    //View Button POP UP command archive
//    ArchiveTable.addMouseListener(new MouseAdapter() {
//        public void mouseClicked(MouseEvent me){
//            if(SwingUtilities.isRightMouseButton(me)) {
//                  ViewButton2();
//            }
//        }
//    });

    
    
        
        slidePanel.setVisible(false);
        //slidePanel1.setVisible(false);
       
        //Automatically run the refresh button when the app is run for the first time method[15]
         addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        
         
         
        //Student tags
        MasterlistTable.getColumnModel().getColumn(11).setCellRenderer(new CustomCellRenderer());//RED AND GREEN MASTERLIST
        TransferinTable.getColumnModel().getColumn(11).setCellRenderer(new CustomCellRendererTRANSIN());//BLUE FOR TRANSFER IN
        TransferoutTable.getColumnModel().getColumn(11).setCellRenderer(new CustomCellRendererTRANSOUT());//ORANGE FOR TRANSFER OUT
        ArchiveTable.getColumnModel().getColumn(11).setCellRenderer(new CustomCellRendererARCHIVE());//GREEN ARCHIVE
        
        //MYSQL CODE-----------------------------------------------
        

        try{
        con = DriverManager.getConnection(url, user, pass);
        }catch(Exception ex){
            System.out.println("Error: " +ex.getMessage());  
        }
        //MYSQL CODE-----------------------------------------------
        
        
                 
        //Basic Setup
        ImageIcon icon = new ImageIcon ("lphslogo.png");
        setIconImage(icon.getImage());
        setTitle("LPHS REGISTRAR");
        setExtendedState(MAXIMIZED_BOTH);
        MasterlistTable.setShowGrid(true);
        ArchiveTable.setShowGrid(true);
        TransferinTable.setShowGrid(true);
        TransferoutTable.setShowGrid(true);
        
        //show row count in the upper right corner
        studentnum.setText(Integer.toString(MasterlistTable.getRowCount()));    
        
        
         
     
        
    }
    
    editStudent studentEdit= new editStudent();
    editStudentTransferout editStudentTransferout= new editStudentTransferout();
    viewStudent studentView= new viewStudent();
    viewStudentArchive viewStudentArchive= new viewStudentArchive();
    viewStudentTransferin viewStudentTransferin= new viewStudentTransferin();
    viewStudentTransferout viewStudentTransferout= new viewStudentTransferout();
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slidePanel = new javax.swing.JPanel();
        MenuSlide = new javax.swing.JPanel();
        credentialslabel = new javax.swing.JLabel();
        MasterlistSlide = new javax.swing.JPanel();
        credentialslabel1 = new javax.swing.JLabel();
        ArchiveSlide = new javax.swing.JPanel();
        credentialslabel2 = new javax.swing.JLabel();
        TransferinSlide = new javax.swing.JPanel();
        credentialslabel3 = new javax.swing.JLabel();
        TransferoutSlide = new javax.swing.JPanel();
        credentialslabel4 = new javax.swing.JLabel();
        SettingsSlide = new javax.swing.JPanel();
        credentialslabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        hideControl = new javax.swing.JPanel();
        hidecontrollabel = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        masterlistPLBT = new javax.swing.JPanel();
        masterlistLBBT = new javax.swing.JLabel();
        archivePLBT = new javax.swing.JPanel();
        archiveLBBT = new javax.swing.JLabel();
        transferinPLBT = new javax.swing.JPanel();
        transferinLBBT = new javax.swing.JLabel();
        settingsPLBT = new javax.swing.JPanel();
        settingsLBBT = new javax.swing.JLabel();
        transferoutPLBT = new javax.swing.JPanel();
        transferoutLBBT = new javax.swing.JLabel();
        toggleButton1 = new toggle.ToggleButton();
        Menuslideclick = new javax.swing.JLabel();
        registrar_name1 = new javax.swing.JLabel();
        curvesPanel21 = new Frame.CurvesPanel2();
        jPanel3 = new javax.swing.JPanel();
        layers = new javax.swing.JLayeredPane();
        Masterlist = new javax.swing.JPanel();
        MasterlistMenuPanel = new javax.swing.JPanel();
        studentnum = new javax.swing.JLabel();
        sortlabel = new javax.swing.JLabel();
        sortBox = new javax.swing.JComboBox<>();
        sortlabel1 = new javax.swing.JLabel();
        searchTXT = new SystemOtherComps.PH_TextField();
        pH_Label2 = new SystemOtherComps.PH_Label();
        refreshBT = new SystemOtherComps.PH_Button();
        AddStudentBT = new SystemOtherComps.PH_Button();
        editBT = new SystemOtherComps.PH_Button();
        TransferOutBT = new SystemOtherComps.PH_Button();
        RemoveBT = new SystemOtherComps.PH_Button();
        MasterlistTableScrollPanel = new javax.swing.JScrollPane();
        MasterlistTable = new javax.swing.JTable();
        masterlistRP = new SystemOtherComps.PH_Panel();
        transferinRPlabel3 = new javax.swing.JLabel();
        Archive = new javax.swing.JPanel();
        ArchiveMenuPanel = new javax.swing.JPanel();
        studentnum4 = new javax.swing.JLabel();
        sortlabel9 = new javax.swing.JLabel();
        sortBox4 = new javax.swing.JComboBox<>();
        sortlabel2 = new javax.swing.JLabel();
        sortlabel3 = new javax.swing.JLabel();
        yearsorter = new assets.YearComboBox2();
        searchTXT4 = new SystemOtherComps.PH_TextField();
        pH_Label3 = new SystemOtherComps.PH_Label();
        resheshBT1 = new SystemOtherComps.PH_Button();
        restoreBT = new SystemOtherComps.PH_Button();
        ArchiveTableScrollPanel = new javax.swing.JScrollPane();
        ArchiveTable = new javax.swing.JTable();
        archiveRP = new SystemOtherComps.PH_Panel();
        transferinRPlabel2 = new javax.swing.JLabel();
        Transferout = new javax.swing.JPanel();
        TransferoutMenuPanel = new javax.swing.JPanel();
        studentnum3 = new javax.swing.JLabel();
        sortlabel6 = new javax.swing.JLabel();
        sortBox3 = new javax.swing.JComboBox<>();
        sortlabel7 = new javax.swing.JLabel();
        yearsorterTransferout = new assets.YearComboBox2();
        sortlabel10 = new javax.swing.JLabel();
        searchTXT3 = new SystemOtherComps.PH_TextField();
        pH_Label4 = new SystemOtherComps.PH_Label();
        resheshBT3 = new SystemOtherComps.PH_Button();
        TransferoutRestoreBT = new SystemOtherComps.PH_Button();
        TransferoutTableScrollPanel = new javax.swing.JScrollPane();
        TransferoutTable = new javax.swing.JTable();
        transferoutRP = new SystemOtherComps.PH_Panel();
        transferinRPlabel1 = new javax.swing.JLabel();
        Transferin = new javax.swing.JPanel();
        TransferinMenuPanel = new javax.swing.JPanel();
        studentnum2 = new javax.swing.JLabel();
        sortlabel4 = new javax.swing.JLabel();
        sortBox2 = new javax.swing.JComboBox<>();
        sortlabel5 = new javax.swing.JLabel();
        yearsorterTransferin = new assets.YearComboBox2();
        sortlabel8 = new javax.swing.JLabel();
        searchTXT2 = new SystemOtherComps.PH_TextField();
        pH_Label5 = new SystemOtherComps.PH_Label();
        resheshBT2 = new SystemOtherComps.PH_Button();
        TransferinTableScrollPanel = new javax.swing.JScrollPane();
        TransferinTable = new javax.swing.JTable();
        transferinRP = new SystemOtherComps.PH_Panel();
        transferinRPlabel = new javax.swing.JLabel();
        AboutUs = new javax.swing.JPanel();
        helpscroll1 = new javax.swing.JScrollPane();
        helpPanel1 = new javax.swing.JPanel();
        HelpLabel1 = new RoundedPanel(30, new Color(222, 235, 247));
        helplable1 = new javax.swing.JLabel();
        tablecontentsscroll4 = new javax.swing.JScrollPane();
        jLabel7 = new javax.swing.JLabel();
        tablecontentsscroll5 = new javax.swing.JScrollPane();
        jLabel11 = new javax.swing.JLabel();
        Help = new javax.swing.JPanel();
        helpscroll = new javax.swing.JScrollPane();
        helpPanel = new javax.swing.JPanel();
        HelpLabel = new RoundedPanel(30, new Color(222, 235, 247));
        helplable = new javax.swing.JLabel();
        tablecontentsscroll1 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        tablecontentsscroll2 = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        tablecontentsscroll3 = new javax.swing.JScrollPane();
        jLabel6 = new javax.swing.JLabel();
        Overview = new javax.swing.JPanel();
        Settings = new javax.swing.JPanel();
        aboutusBT = new javax.swing.JButton();
        helpBT = new javax.swing.JButton();
        changepasswordBT = new javax.swing.JButton();
        archiveBT = new javax.swing.JButton();
        UpdateBT = new javax.swing.JButton();
        BackupBT = new javax.swing.JButton();
        passpanel = new javax.swing.JPanel();
        confirmpasswordTXT = new javax.swing.JTextField();
        newpasswordTXT = new javax.swing.JTextField();
        newusernameTXT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        savepassword = new SystemOtherComps.PH_Button();
        rowBT = new javax.swing.JButton();
        rowpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        rowheightnum = new javax.swing.JTextField();
        rowadd = new javax.swing.JButton();
        rowreduce = new javax.swing.JButton();
        rowdef = new SystemOtherComps.PH_Button();
        fontsizeBT = new javax.swing.JButton();
        fontpanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        fontsizeTXT = new javax.swing.JTextField();
        fontup = new javax.swing.JButton();
        fontdown = new javax.swing.JButton();
        fontdef = new SystemOtherComps.PH_Button();
        hidetitleBT = new javax.swing.JButton();
        ExportPanel = new javax.swing.JPanel();
        exportBT = new SystemOtherComps.PH_Button();
        importBT = new SystemOtherComps.PH_Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        slidePanel.setBackground(new java.awt.Color(255, 255, 255));

        MenuSlide.setBackground(new java.awt.Color(255, 255, 255));
        MenuSlide.setToolTipText("Menu Mode");
        MenuSlide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuSlideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuSlideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuSlideMouseExited(evt);
            }
        });

        credentialslabel.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list.png"))); // NOI18N

        javax.swing.GroupLayout MenuSlideLayout = new javax.swing.GroupLayout(MenuSlide);
        MenuSlide.setLayout(MenuSlideLayout);
        MenuSlideLayout.setHorizontalGroup(
            MenuSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuSlideLayout.setVerticalGroup(
            MenuSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MasterlistSlide.setBackground(new java.awt.Color(255, 255, 255));
        MasterlistSlide.setToolTipText("Masterlist");
        MasterlistSlide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MasterlistSlideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MasterlistSlideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MasterlistSlideMouseExited(evt);
            }
        });

        credentialslabel1.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel1.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ballot.png"))); // NOI18N

        javax.swing.GroupLayout MasterlistSlideLayout = new javax.swing.GroupLayout(MasterlistSlide);
        MasterlistSlide.setLayout(MasterlistSlideLayout);
        MasterlistSlideLayout.setHorizontalGroup(
            MasterlistSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterlistSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MasterlistSlideLayout.setVerticalGroup(
            MasterlistSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterlistSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ArchiveSlide.setBackground(new java.awt.Color(255, 255, 255));
        ArchiveSlide.setToolTipText("Archive");
        ArchiveSlide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArchiveSlideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ArchiveSlideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ArchiveSlideMouseExited(evt);
            }
        });

        credentialslabel2.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel2.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inbox.png"))); // NOI18N

        javax.swing.GroupLayout ArchiveSlideLayout = new javax.swing.GroupLayout(ArchiveSlide);
        ArchiveSlide.setLayout(ArchiveSlideLayout);
        ArchiveSlideLayout.setHorizontalGroup(
            ArchiveSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArchiveSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ArchiveSlideLayout.setVerticalGroup(
            ArchiveSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArchiveSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TransferinSlide.setBackground(new java.awt.Color(255, 255, 255));
        TransferinSlide.setToolTipText("Transfer-in");
        TransferinSlide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransferinSlideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TransferinSlideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TransferinSlideMouseExited(evt);
            }
        });

        credentialslabel3.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel3.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tin.png"))); // NOI18N

        javax.swing.GroupLayout TransferinSlideLayout = new javax.swing.GroupLayout(TransferinSlide);
        TransferinSlide.setLayout(TransferinSlideLayout);
        TransferinSlideLayout.setHorizontalGroup(
            TransferinSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferinSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TransferinSlideLayout.setVerticalGroup(
            TransferinSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferinSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TransferoutSlide.setBackground(new java.awt.Color(255, 255, 255));
        TransferoutSlide.setToolTipText("Transfer-out");
        TransferoutSlide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TransferoutSlideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TransferoutSlideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TransferoutSlideMouseExited(evt);
            }
        });

        credentialslabel4.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel4.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel4.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tout.png"))); // NOI18N

        javax.swing.GroupLayout TransferoutSlideLayout = new javax.swing.GroupLayout(TransferoutSlide);
        TransferoutSlide.setLayout(TransferoutSlideLayout);
        TransferoutSlideLayout.setHorizontalGroup(
            TransferoutSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferoutSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TransferoutSlideLayout.setVerticalGroup(
            TransferoutSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferoutSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SettingsSlide.setBackground(new java.awt.Color(255, 255, 255));
        SettingsSlide.setToolTipText("Settings");
        SettingsSlide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SettingsSlideMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SettingsSlideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SettingsSlideMouseExited(evt);
            }
        });

        credentialslabel5.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel5.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel5.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings2.png"))); // NOI18N

        javax.swing.GroupLayout SettingsSlideLayout = new javax.swing.GroupLayout(SettingsSlide);
        SettingsSlide.setLayout(SettingsSlideLayout);
        SettingsSlideLayout.setHorizontalGroup(
            SettingsSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SettingsSlideLayout.setVerticalGroup(
            SettingsSlideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsSlideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        hideControl.setBackground(new java.awt.Color(255, 255, 255));
        hideControl.setForeground(new java.awt.Color(255, 255, 255));
        hideControl.setToolTipText("hide");
        hideControl.setPreferredSize(new java.awt.Dimension(42, 37));
        hideControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideControlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hideControlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hideControlMouseExited(evt);
            }
        });

        hidecontrollabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hidecontrollabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); // NOI18N

        javax.swing.GroupLayout hideControlLayout = new javax.swing.GroupLayout(hideControl);
        hideControl.setLayout(hideControlLayout);
        hideControlLayout.setHorizontalGroup(
            hideControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hideControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hidecontrollabel, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );
        hideControlLayout.setVerticalGroup(
            hideControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hideControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hidecontrollabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout slidePanelLayout = new javax.swing.GroupLayout(slidePanel);
        slidePanel.setLayout(slidePanelLayout);
        slidePanelLayout.setHorizontalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, slidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addGroup(slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(MenuSlide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MasterlistSlide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TransferinSlide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ArchiveSlide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TransferoutSlide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SettingsSlide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(hideControl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        slidePanelLayout.setVerticalGroup(
            slidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MasterlistSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ArchiveSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TransferinSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TransferoutSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SettingsSlide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hideControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );

        getContentPane().add(slidePanel);

        menu.setBackground(new java.awt.Color(189, 215, 238));
        menu.setPreferredSize(new java.awt.Dimension(162, 570));

        masterlistPLBT.setBackground(new java.awt.Color(189, 215, 238));
        masterlistPLBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masterlistPLBTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                masterlistPLBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                masterlistPLBTMouseExited(evt);
            }
        });

        masterlistLBBT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        masterlistLBBT.setForeground(new java.awt.Color(0, 0, 0));
        masterlistLBBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ballot.png"))); // NOI18N
        masterlistLBBT.setText("Masterlist");

        javax.swing.GroupLayout masterlistPLBTLayout = new javax.swing.GroupLayout(masterlistPLBT);
        masterlistPLBT.setLayout(masterlistPLBTLayout);
        masterlistPLBTLayout.setHorizontalGroup(
            masterlistPLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(masterlistPLBTLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(masterlistLBBT)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        masterlistPLBTLayout.setVerticalGroup(
            masterlistPLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, masterlistPLBTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(masterlistLBBT)
                .addContainerGap())
        );

        archivePLBT.setBackground(new java.awt.Color(189, 215, 238));
        archivePLBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archivePLBTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                archivePLBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                archivePLBTMouseExited(evt);
            }
        });

        archiveLBBT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        archiveLBBT.setForeground(new java.awt.Color(0, 0, 0));
        archiveLBBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inbox.png"))); // NOI18N
        archiveLBBT.setText("Archive");

        javax.swing.GroupLayout archivePLBTLayout = new javax.swing.GroupLayout(archivePLBT);
        archivePLBT.setLayout(archivePLBTLayout);
        archivePLBTLayout.setHorizontalGroup(
            archivePLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(archivePLBTLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(archiveLBBT)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        archivePLBTLayout.setVerticalGroup(
            archivePLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, archivePLBTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(archiveLBBT)
                .addContainerGap())
        );

        transferinPLBT.setBackground(new java.awt.Color(189, 215, 238));
        transferinPLBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transferinPLBTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transferinPLBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transferinPLBTMouseExited(evt);
            }
        });

        transferinLBBT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        transferinLBBT.setForeground(new java.awt.Color(0, 0, 0));
        transferinLBBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tin.png"))); // NOI18N
        transferinLBBT.setText("Transfer-in");

        javax.swing.GroupLayout transferinPLBTLayout = new javax.swing.GroupLayout(transferinPLBT);
        transferinPLBT.setLayout(transferinPLBTLayout);
        transferinPLBTLayout.setHorizontalGroup(
            transferinPLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transferinPLBTLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(transferinLBBT)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        transferinPLBTLayout.setVerticalGroup(
            transferinPLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transferinPLBTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transferinLBBT)
                .addContainerGap())
        );

        settingsPLBT.setBackground(new java.awt.Color(189, 215, 238));
        settingsPLBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsPLBTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsPLBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsPLBTMouseExited(evt);
            }
        });

        settingsLBBT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        settingsLBBT.setForeground(new java.awt.Color(0, 0, 0));
        settingsLBBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings2.png"))); // NOI18N
        settingsLBBT.setText("Settings");

        javax.swing.GroupLayout settingsPLBTLayout = new javax.swing.GroupLayout(settingsPLBT);
        settingsPLBT.setLayout(settingsPLBTLayout);
        settingsPLBTLayout.setHorizontalGroup(
            settingsPLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPLBTLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(settingsLBBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        settingsPLBTLayout.setVerticalGroup(
            settingsPLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingsPLBTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(settingsLBBT)
                .addContainerGap())
        );

        transferoutPLBT.setBackground(new java.awt.Color(189, 215, 238));
        transferoutPLBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transferoutPLBTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transferoutPLBTMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transferoutPLBTMouseExited(evt);
            }
        });

        transferoutLBBT.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        transferoutLBBT.setForeground(new java.awt.Color(0, 0, 0));
        transferoutLBBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Tout.png"))); // NOI18N
        transferoutLBBT.setText("Transfer-out");

        javax.swing.GroupLayout transferoutPLBTLayout = new javax.swing.GroupLayout(transferoutPLBT);
        transferoutPLBT.setLayout(transferoutPLBTLayout);
        transferoutPLBTLayout.setHorizontalGroup(
            transferoutPLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transferoutPLBTLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(transferoutLBBT, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        transferoutPLBTLayout.setVerticalGroup(
            transferoutPLBTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transferoutPLBTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(transferoutLBBT)
                .addContainerGap())
        );

        Menuslideclick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minilogo.jpg"))); // NOI18N
        Menuslideclick.setToolTipText("Icon Mode");
        Menuslideclick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuslideclickMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuslideclickMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuslideclickMouseExited(evt);
            }
        });

        registrar_name1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        registrar_name1.setForeground(new java.awt.Color(0, 0, 0));
        registrar_name1.setText("REGISTRAR");

        javax.swing.GroupLayout curvesPanel21Layout = new javax.swing.GroupLayout(curvesPanel21);
        curvesPanel21.setLayout(curvesPanel21Layout);
        curvesPanel21Layout.setHorizontalGroup(
            curvesPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        curvesPanel21Layout.setVerticalGroup(
            curvesPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transferinPLBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(archivePLBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(masterlistPLBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(settingsPLBT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(transferoutPLBT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(menuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(toggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(menuLayout.createSequentialGroup()
                                        .addComponent(Menuslideclick, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(registrar_name1)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(curvesPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(registrar_name1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(Menuslideclick, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterlistPLBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(archivePLBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transferinPLBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(transferoutPLBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsPLBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 490, Short.MAX_VALUE)
                .addComponent(curvesPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(menu);

        layers.setBackground(new java.awt.Color(255, 255, 255));
        layers.setLayout(new java.awt.CardLayout());

        Masterlist.setBackground(new java.awt.Color(255, 255, 255));

        MasterlistMenuPanel.setBackground(new java.awt.Color(255, 255, 255));
        MasterlistMenuPanel.setPreferredSize(new java.awt.Dimension(171, 542));

        studentnum.setBackground(new java.awt.Color(255, 255, 255));
        studentnum.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        studentnum.setForeground(new java.awt.Color(0, 0, 0));
        studentnum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentnum.setText("5");
        studentnum.setToolTipText("number of students visible inside the table");
        studentnum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)));
        studentnum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        studentnum.setOpaque(true);

        sortlabel.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel.setText("Sort");

        sortBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Male", "Female", "Last Name", "First Name", "Middle Name", "Complete", "Incomplete", "Grade 12", "Grade 11", "Grade 10", "Grade 9", "Grade 8", "Grade 7", "Grade 6", "Grade 5", "Grade 4", "Grade 3", "Grade 2", "Grade 1", "Kindergarten" }));
        sortBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBoxActionPerformed(evt);
            }
        });

        sortlabel1.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel1.setText("Students");

        searchTXT.setBackground(new java.awt.Color(255, 255, 255));
        searchTXT.setForeground(new java.awt.Color(0, 0, 0));
        searchTXT.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchTXT.setAA_BorderColor(new java.awt.Color(225, 225, 225));
        searchTXT.setAA_TextHint("Search...");
        searchTXT.setAB_HintColor(new java.awt.Color(225, 225, 225));
        searchTXT.setAB_LineColor(new java.awt.Color(206, 206, 206));
        searchTXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchTXTCaretUpdate(evt);
            }
        });

        pH_Label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchnew.png"))); // NOI18N

        refreshBT.setBackground(new java.awt.Color(255, 255, 255));
        refreshBT.setBorder(null);
        refreshBT.setForeground(new java.awt.Color(0, 0, 0));
        refreshBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh2.png"))); // NOI18N
        refreshBT.setText("Refresh                     ");
        refreshBT.setToolTipText("");
        refreshBT.setAAA_AutoFitToSize(true);
        refreshBT.setAAA_ImageBoundArcSize(20);
        refreshBT.setAAA_roundBottomLeft(20);
        refreshBT.setAAA_roundBottomRight(20);
        refreshBT.setAAA_roundTopLeft(20);
        refreshBT.setAAA_roundTopRight(20);
        refreshBT.setAA_ArcSize(20);
        refreshBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        refreshBT.setAA_DrawBorder(true);
        refreshBT.setAA_DrawTopBorder(true);
        refreshBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        refreshBT.setAA_ImageIndent(10);
        refreshBT.setName(""); // NOI18N
        refreshBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBTActionPerformed(evt);
            }
        });

        AddStudentBT.setBackground(new java.awt.Color(255, 255, 255));
        AddStudentBT.setBorder(null);
        AddStudentBT.setForeground(new java.awt.Color(0, 0, 0));
        AddStudentBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/AddStudentBT.png"))); // NOI18N
        AddStudentBT.setText("Add Student             ");
        AddStudentBT.setToolTipText("");
        AddStudentBT.setAAA_AutoFitToSize(true);
        AddStudentBT.setAAA_ImageBoundArcSize(20);
        AddStudentBT.setAAA_roundBottomLeft(20);
        AddStudentBT.setAAA_roundBottomRight(20);
        AddStudentBT.setAAA_roundTopLeft(20);
        AddStudentBT.setAAA_roundTopRight(20);
        AddStudentBT.setAA_ArcSize(20);
        AddStudentBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        AddStudentBT.setAA_DrawBorder(true);
        AddStudentBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        AddStudentBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStudentBTActionPerformed(evt);
            }
        });

        editBT.setBackground(new java.awt.Color(255, 255, 255));
        editBT.setBorder(null);
        editBT.setForeground(new java.awt.Color(0, 0, 0));
        editBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); // NOI18N
        editBT.setText("Edit                            ");
        editBT.setToolTipText("");
        editBT.setAAA_AutoFitToSize(true);
        editBT.setAAA_ImageBoundArcSize(20);
        editBT.setAAA_roundBottomLeft(20);
        editBT.setAAA_roundBottomRight(20);
        editBT.setAAA_roundTopLeft(20);
        editBT.setAAA_roundTopRight(20);
        editBT.setAA_ArcSize(20);
        editBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        editBT.setAA_DrawBorder(true);
        editBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        editBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTActionPerformed(evt);
            }
        });

        TransferOutBT.setBackground(new java.awt.Color(255, 255, 255));
        TransferOutBT.setBorder(null);
        TransferOutBT.setForeground(new java.awt.Color(0, 0, 0));
        TransferOutBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sign-out-alt.png"))); // NOI18N
        TransferOutBT.setText("Transferred out         ");
        TransferOutBT.setToolTipText("");
        TransferOutBT.setAAA_AutoFitToSize(true);
        TransferOutBT.setAAA_ImageBoundArcSize(20);
        TransferOutBT.setAAA_roundBottomLeft(20);
        TransferOutBT.setAAA_roundBottomRight(20);
        TransferOutBT.setAAA_roundTopLeft(20);
        TransferOutBT.setAAA_roundTopRight(20);
        TransferOutBT.setAA_ArcSize(20);
        TransferOutBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        TransferOutBT.setAA_DrawBorder(true);
        TransferOutBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        TransferOutBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferOutBTActionPerformed(evt);
            }
        });

        RemoveBT.setBackground(new java.awt.Color(255, 255, 255));
        RemoveBT.setBorder(null);
        RemoveBT.setForeground(new java.awt.Color(0, 0, 0));
        RemoveBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/trash.png"))); // NOI18N
        RemoveBT.setText("Delete                         ");
        RemoveBT.setToolTipText("");
        RemoveBT.setAAA_AutoFitToSize(true);
        RemoveBT.setAAA_ImageBoundArcSize(20);
        RemoveBT.setAAA_roundBottomLeft(20);
        RemoveBT.setAAA_roundBottomRight(20);
        RemoveBT.setAAA_roundTopLeft(20);
        RemoveBT.setAAA_roundTopRight(20);
        RemoveBT.setAA_ArcSize(20);
        RemoveBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        RemoveBT.setAA_DrawBorder(true);
        RemoveBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        RemoveBT.setIconTextGap(7);
        RemoveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MasterlistMenuPanelLayout = new javax.swing.GroupLayout(MasterlistMenuPanel);
        MasterlistMenuPanel.setLayout(MasterlistMenuPanelLayout);
        MasterlistMenuPanelLayout.setHorizontalGroup(
            MasterlistMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterlistMenuPanelLayout.createSequentialGroup()
                .addGroup(MasterlistMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MasterlistMenuPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(pH_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MasterlistMenuPanelLayout.createSequentialGroup()
                        .addGap(29, 60, Short.MAX_VALUE)
                        .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddStudentBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TransferOutBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MasterlistMenuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MasterlistMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sortlabel1)
                            .addComponent(sortlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentnum, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(RemoveBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MasterlistMenuPanelLayout.setVerticalGroup(
            MasterlistMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterlistMenuPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(MasterlistMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortlabel1)
                    .addComponent(studentnum, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(MasterlistMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortlabel)
                    .addComponent(sortBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MasterlistMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pH_Label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(refreshBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(AddStudentBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(editBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TransferOutBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RemoveBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MasterlistTableScrollPanel.setToolTipText("Right click to view Student info");

        MasterlistTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LRN", "Last Name", "First Name", "Middle Name", "Birthday", "Sex", "Grade Level", "School Year", "Contact", "Email", "Status", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MasterlistTable.setRowHeight(25);
        MasterlistTable.getTableHeader().setReorderingAllowed(false);
        MasterlistTableScrollPanel.setViewportView(MasterlistTable);
        if (MasterlistTable.getColumnModel().getColumnCount() > 0) {
            MasterlistTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            MasterlistTable.getColumnModel().getColumn(9).setPreferredWidth(200);
            MasterlistTable.getColumnModel().getColumn(10).setMinWidth(70);
            MasterlistTable.getColumnModel().getColumn(10).setPreferredWidth(70);
            MasterlistTable.getColumnModel().getColumn(10).setMaxWidth(80);
            MasterlistTable.getColumnModel().getColumn(11).setMinWidth(4);
            MasterlistTable.getColumnModel().getColumn(11).setPreferredWidth(4);
            MasterlistTable.getColumnModel().getColumn(11).setMaxWidth(4);
        }

        masterlistRP.setBackground(new java.awt.Color(222, 235, 247));
        masterlistRP.setAAA_AutoFillSize(true);
        masterlistRP.setAAA_AutoFitToSize(true);
        masterlistRP.setAAA_AutoSize(true);
        masterlistRP.setAAA_FitToSize(true);
        masterlistRP.setAAA_ImageBoundArcSize(30);
        masterlistRP.setAAA_roundBottomLeft(30);
        masterlistRP.setAAA_roundBottomRight(30);
        masterlistRP.setAAA_roundTopLeft(30);
        masterlistRP.setAAA_roundTopRight(30);
        masterlistRP.setAA_ArcSize(30);
        masterlistRP.setAA_BorderColor(new java.awt.Color(222, 235, 247));

        transferinRPlabel3.setBackground(new java.awt.Color(255, 255, 255));
        transferinRPlabel3.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        transferinRPlabel3.setForeground(new java.awt.Color(0, 0, 0));
        transferinRPlabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferinRPlabel3.setText("Masterlist");

        javax.swing.GroupLayout masterlistRPLayout = new javax.swing.GroupLayout(masterlistRP);
        masterlistRP.setLayout(masterlistRPLayout);
        masterlistRPLayout.setHorizontalGroup(
            masterlistRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
            .addGroup(masterlistRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(transferinRPlabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
        );
        masterlistRPLayout.setVerticalGroup(
            masterlistRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(masterlistRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, masterlistRPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(transferinRPlabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout MasterlistLayout = new javax.swing.GroupLayout(Masterlist);
        Masterlist.setLayout(MasterlistLayout);
        MasterlistLayout.setHorizontalGroup(
            MasterlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterlistLayout.createSequentialGroup()
                .addGroup(MasterlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterlistRP, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(MasterlistTableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MasterlistMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        MasterlistLayout.setVerticalGroup(
            MasterlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MasterlistLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterlistRP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MasterlistTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(MasterlistMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );

        layers.add(Masterlist, "card2");

        Archive.setBackground(new java.awt.Color(255, 255, 255));

        ArchiveMenuPanel.setBackground(new java.awt.Color(255, 255, 255));
        ArchiveMenuPanel.setPreferredSize(new java.awt.Dimension(171, 542));

        studentnum4.setBackground(new java.awt.Color(255, 255, 255));
        studentnum4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        studentnum4.setForeground(new java.awt.Color(0, 0, 0));
        studentnum4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentnum4.setText("5");
        studentnum4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)));
        studentnum4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        studentnum4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        studentnum4.setOpaque(true);

        sortlabel9.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel9.setText("Students");

        sortBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Male", "Female", "Last Name", "First Name", "Middle Name" }));
        sortBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBox4ActionPerformed(evt);
            }
        });

        sortlabel2.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel2.setText("Sort");

        sortlabel3.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel3.setText("Year");

        yearsorter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearsorterActionPerformed(evt);
            }
        });

        searchTXT4.setBackground(new java.awt.Color(255, 255, 255));
        searchTXT4.setForeground(new java.awt.Color(0, 0, 0));
        searchTXT4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchTXT4.setAA_BorderColor(new java.awt.Color(225, 225, 225));
        searchTXT4.setAA_TextHint("Search...");
        searchTXT4.setAB_HintColor(new java.awt.Color(225, 225, 225));
        searchTXT4.setAB_LineColor(new java.awt.Color(206, 206, 206));
        searchTXT4.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchTXT4CaretUpdate(evt);
            }
        });

        pH_Label3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchnew.png"))); // NOI18N

        resheshBT1.setBackground(new java.awt.Color(255, 255, 255));
        resheshBT1.setBorder(null);
        resheshBT1.setForeground(new java.awt.Color(0, 0, 0));
        resheshBT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh2.png"))); // NOI18N
        resheshBT1.setText("Refresh                     ");
        resheshBT1.setToolTipText("");
        resheshBT1.setAAA_AutoFitToSize(true);
        resheshBT1.setAAA_ImageBoundArcSize(20);
        resheshBT1.setAAA_roundBottomLeft(20);
        resheshBT1.setAAA_roundBottomRight(20);
        resheshBT1.setAAA_roundTopLeft(20);
        resheshBT1.setAAA_roundTopRight(20);
        resheshBT1.setAA_ArcSize(20);
        resheshBT1.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        resheshBT1.setAA_DrawBorder(true);
        resheshBT1.setAA_DrawTopBorder(true);
        resheshBT1.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        resheshBT1.setAA_ImageIndent(10);
        resheshBT1.setName(""); // NOI18N
        resheshBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resheshBT1ActionPerformed(evt);
            }
        });

        restoreBT.setBackground(new java.awt.Color(255, 255, 255));
        restoreBT.setBorder(null);
        restoreBT.setForeground(new java.awt.Color(0, 0, 0));
        restoreBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back-up.png"))); // NOI18N
        restoreBT.setText("Restore                     ");
        restoreBT.setToolTipText("");
        restoreBT.setAAA_AutoFitToSize(true);
        restoreBT.setAAA_ImageBoundArcSize(20);
        restoreBT.setAAA_roundBottomLeft(20);
        restoreBT.setAAA_roundBottomRight(20);
        restoreBT.setAAA_roundTopLeft(20);
        restoreBT.setAAA_roundTopRight(20);
        restoreBT.setAA_ArcSize(20);
        restoreBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        restoreBT.setAA_DrawBorder(true);
        restoreBT.setAA_DrawTopBorder(true);
        restoreBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        restoreBT.setAA_ImageIndent(10);
        restoreBT.setName(""); // NOI18N
        restoreBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ArchiveMenuPanelLayout = new javax.swing.GroupLayout(ArchiveMenuPanel);
        ArchiveMenuPanel.setLayout(ArchiveMenuPanelLayout);
        ArchiveMenuPanelLayout.setHorizontalGroup(
            ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArchiveMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ArchiveMenuPanelLayout.createSequentialGroup()
                        .addComponent(sortlabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentnum4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArchiveMenuPanelLayout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sortlabel2)
                            .addComponent(sortlabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sortBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yearsorter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(ArchiveMenuPanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(pH_Label3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTXT4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(resheshBT1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restoreBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ArchiveMenuPanelLayout.setVerticalGroup(
            ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ArchiveMenuPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortlabel9)
                    .addComponent(studentnum4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortlabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearsorter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortlabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ArchiveMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchTXT4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pH_Label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(resheshBT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restoreBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ArchiveTableScrollPanel.setToolTipText("Right click to view Student info");

        ArchiveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LRN", "Last Name", "First Name", "Middle Name", "Birthday", "Sex", "Grade Level", "Year", "Contact", "Email", "Status", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ArchiveTable.setRowHeight(25);
        ArchiveTable.getTableHeader().setReorderingAllowed(false);
        ArchiveTableScrollPanel.setViewportView(ArchiveTable);
        if (ArchiveTable.getColumnModel().getColumnCount() > 0) {
            ArchiveTable.getColumnModel().getColumn(9).setPreferredWidth(200);
            ArchiveTable.getColumnModel().getColumn(10).setMinWidth(70);
            ArchiveTable.getColumnModel().getColumn(10).setPreferredWidth(70);
            ArchiveTable.getColumnModel().getColumn(10).setMaxWidth(80);
            ArchiveTable.getColumnModel().getColumn(11).setMinWidth(4);
            ArchiveTable.getColumnModel().getColumn(11).setPreferredWidth(4);
            ArchiveTable.getColumnModel().getColumn(11).setMaxWidth(4);
        }

        archiveRP.setBackground(new java.awt.Color(222, 235, 247));
        archiveRP.setAAA_AutoFillSize(true);
        archiveRP.setAAA_AutoFitToSize(true);
        archiveRP.setAAA_AutoSize(true);
        archiveRP.setAAA_FitToSize(true);
        archiveRP.setAAA_ImageBoundArcSize(30);
        archiveRP.setAAA_roundBottomLeft(30);
        archiveRP.setAAA_roundBottomRight(30);
        archiveRP.setAAA_roundTopLeft(30);
        archiveRP.setAAA_roundTopRight(30);
        archiveRP.setAA_ArcSize(30);
        archiveRP.setAA_BorderColor(new java.awt.Color(222, 235, 247));

        transferinRPlabel2.setBackground(new java.awt.Color(255, 255, 255));
        transferinRPlabel2.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        transferinRPlabel2.setForeground(new java.awt.Color(0, 0, 0));
        transferinRPlabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferinRPlabel2.setText("Archive");

        javax.swing.GroupLayout archiveRPLayout = new javax.swing.GroupLayout(archiveRP);
        archiveRP.setLayout(archiveRPLayout);
        archiveRPLayout.setHorizontalGroup(
            archiveRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
            .addGroup(archiveRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(transferinRPlabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
        );
        archiveRPLayout.setVerticalGroup(
            archiveRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(archiveRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, archiveRPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(transferinRPlabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout ArchiveLayout = new javax.swing.GroupLayout(Archive);
        Archive.setLayout(ArchiveLayout);
        ArchiveLayout.setHorizontalGroup(
            ArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ArchiveLayout.createSequentialGroup()
                .addGroup(ArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ArchiveTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(archiveRP, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArchiveMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ArchiveLayout.setVerticalGroup(
            ArchiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ArchiveMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
            .addGroup(ArchiveLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(archiveRP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ArchiveTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addContainerGap())
        );

        layers.add(Archive, "card2");

        Transferout.setBackground(new java.awt.Color(255, 255, 255));

        TransferoutMenuPanel.setBackground(new java.awt.Color(255, 255, 255));

        studentnum3.setBackground(new java.awt.Color(255, 255, 255));
        studentnum3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        studentnum3.setForeground(new java.awt.Color(0, 0, 0));
        studentnum3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentnum3.setText("5");
        studentnum3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)));
        studentnum3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        studentnum3.setOpaque(true);

        sortlabel6.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel6.setText("Sort");

        sortBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Complete", "Incomplete", "Grade 12", "Grade 11", "Grade 10", "Grade 9", "Grade 8", "Grade 7", "Grade 6", "Grade 5", "Grade 4", "Grade 3", "Grade 2", "Grade 1", "Grade 0" }));
        sortBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBox3ActionPerformed(evt);
            }
        });

        sortlabel7.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel7.setText("Students");

        yearsorterTransferout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearsorterTransferoutActionPerformed(evt);
            }
        });

        sortlabel10.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel10.setText("Year");

        searchTXT3.setBackground(new java.awt.Color(255, 255, 255));
        searchTXT3.setForeground(new java.awt.Color(0, 0, 0));
        searchTXT3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchTXT3.setAA_BorderColor(new java.awt.Color(225, 225, 225));
        searchTXT3.setAA_TextHint("Search...");
        searchTXT3.setAB_HintColor(new java.awt.Color(225, 225, 225));
        searchTXT3.setAB_LineColor(new java.awt.Color(206, 206, 206));
        searchTXT3.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchTXT3CaretUpdate(evt);
            }
        });

        pH_Label4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchnew.png"))); // NOI18N

        resheshBT3.setBackground(new java.awt.Color(255, 255, 255));
        resheshBT3.setBorder(null);
        resheshBT3.setForeground(new java.awt.Color(0, 0, 0));
        resheshBT3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh2.png"))); // NOI18N
        resheshBT3.setText("Refresh                     ");
        resheshBT3.setToolTipText("");
        resheshBT3.setAAA_AutoFitToSize(true);
        resheshBT3.setAAA_ImageBoundArcSize(20);
        resheshBT3.setAAA_roundBottomLeft(20);
        resheshBT3.setAAA_roundBottomRight(20);
        resheshBT3.setAAA_roundTopLeft(20);
        resheshBT3.setAAA_roundTopRight(20);
        resheshBT3.setAA_ArcSize(20);
        resheshBT3.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        resheshBT3.setAA_DrawBorder(true);
        resheshBT3.setAA_DrawTopBorder(true);
        resheshBT3.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        resheshBT3.setAA_ImageIndent(10);
        resheshBT3.setName(""); // NOI18N
        resheshBT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resheshBT3ActionPerformed(evt);
            }
        });

        TransferoutRestoreBT.setBackground(new java.awt.Color(255, 255, 255));
        TransferoutRestoreBT.setBorder(null);
        TransferoutRestoreBT.setForeground(new java.awt.Color(0, 0, 0));
        TransferoutRestoreBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back-up.png"))); // NOI18N
        TransferoutRestoreBT.setText("Restore                     ");
        TransferoutRestoreBT.setToolTipText("");
        TransferoutRestoreBT.setAAA_AutoFitToSize(true);
        TransferoutRestoreBT.setAAA_ImageBoundArcSize(20);
        TransferoutRestoreBT.setAAA_roundBottomLeft(20);
        TransferoutRestoreBT.setAAA_roundBottomRight(20);
        TransferoutRestoreBT.setAAA_roundTopLeft(20);
        TransferoutRestoreBT.setAAA_roundTopRight(20);
        TransferoutRestoreBT.setAA_ArcSize(20);
        TransferoutRestoreBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        TransferoutRestoreBT.setAA_DrawBorder(true);
        TransferoutRestoreBT.setAA_DrawTopBorder(true);
        TransferoutRestoreBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        TransferoutRestoreBT.setAA_ImageIndent(10);
        TransferoutRestoreBT.setName(""); // NOI18N
        TransferoutRestoreBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransferoutRestoreBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TransferoutMenuPanelLayout = new javax.swing.GroupLayout(TransferoutMenuPanel);
        TransferoutMenuPanel.setLayout(TransferoutMenuPanelLayout);
        TransferoutMenuPanelLayout.setHorizontalGroup(
            TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferoutMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransferoutMenuPanelLayout.createSequentialGroup()
                        .addGroup(TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sortlabel7)
                            .addComponent(sortlabel6)
                            .addComponent(sortlabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearsorterTransferout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentnum3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, 107, Short.MAX_VALUE)))
                    .addGroup(TransferoutMenuPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pH_Label4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTXT3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(resheshBT3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TransferoutRestoreBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TransferoutMenuPanelLayout.setVerticalGroup(
            TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferoutMenuPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortlabel7)
                    .addComponent(studentnum3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortlabel6)
                    .addComponent(sortBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearsorterTransferout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortlabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TransferoutMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchTXT3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pH_Label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(resheshBT3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TransferoutRestoreBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TransferoutTableScrollPanel.setToolTipText("Right click to view Student info");

        TransferoutTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LRN", "Last Name", "First Name", "Middle Name", "Birthday", "Sex", "Grade Level", "School Year", "Contact", "Email", "Status", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TransferoutTable.setRowHeight(25);
        TransferoutTable.getTableHeader().setReorderingAllowed(false);
        TransferoutTableScrollPanel.setViewportView(TransferoutTable);
        if (TransferoutTable.getColumnModel().getColumnCount() > 0) {
            TransferoutTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            TransferoutTable.getColumnModel().getColumn(9).setPreferredWidth(200);
            TransferoutTable.getColumnModel().getColumn(10).setMinWidth(70);
            TransferoutTable.getColumnModel().getColumn(10).setPreferredWidth(70);
            TransferoutTable.getColumnModel().getColumn(10).setMaxWidth(80);
            TransferoutTable.getColumnModel().getColumn(11).setMinWidth(4);
            TransferoutTable.getColumnModel().getColumn(11).setPreferredWidth(4);
            TransferoutTable.getColumnModel().getColumn(11).setMaxWidth(4);
        }

        transferoutRP.setBackground(new java.awt.Color(222, 235, 247));
        transferoutRP.setAAA_AutoFillSize(true);
        transferoutRP.setAAA_AutoFitToSize(true);
        transferoutRP.setAAA_AutoSize(true);
        transferoutRP.setAAA_FitToSize(true);
        transferoutRP.setAAA_ImageBoundArcSize(30);
        transferoutRP.setAAA_roundBottomLeft(30);
        transferoutRP.setAAA_roundBottomRight(30);
        transferoutRP.setAAA_roundTopLeft(30);
        transferoutRP.setAAA_roundTopRight(30);
        transferoutRP.setAA_ArcSize(30);
        transferoutRP.setAA_BorderColor(new java.awt.Color(222, 235, 247));

        transferinRPlabel1.setBackground(new java.awt.Color(255, 255, 255));
        transferinRPlabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        transferinRPlabel1.setForeground(new java.awt.Color(0, 0, 0));
        transferinRPlabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferinRPlabel1.setText("Transfer-out");

        javax.swing.GroupLayout transferoutRPLayout = new javax.swing.GroupLayout(transferoutRP);
        transferoutRP.setLayout(transferoutRPLayout);
        transferoutRPLayout.setHorizontalGroup(
            transferoutRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 221, Short.MAX_VALUE)
            .addGroup(transferoutRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(transferinRPlabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
        );
        transferoutRPLayout.setVerticalGroup(
            transferoutRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(transferoutRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transferoutRPLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(transferinRPlabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout TransferoutLayout = new javax.swing.GroupLayout(Transferout);
        Transferout.setLayout(TransferoutLayout);
        TransferoutLayout.setHorizontalGroup(
            TransferoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransferoutLayout.createSequentialGroup()
                .addGroup(TransferoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TransferoutTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(transferoutRP, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransferoutMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TransferoutLayout.setVerticalGroup(
            TransferoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TransferoutMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TransferoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transferoutRP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransferoutTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addContainerGap())
        );

        layers.add(Transferout, "card2");

        Transferin.setBackground(new java.awt.Color(255, 255, 255));

        TransferinMenuPanel.setBackground(new java.awt.Color(255, 255, 255));

        studentnum2.setBackground(new java.awt.Color(255, 255, 255));
        studentnum2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        studentnum2.setForeground(new java.awt.Color(0, 0, 0));
        studentnum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentnum2.setText("5");
        studentnum2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 225, 225)));
        studentnum2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        studentnum2.setOpaque(true);

        sortlabel4.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel4.setText("Sort");

        sortBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Complete", "Incomplete", "Grade 12", "Grade 11", "Grade 10", "Grade 9", "Grade 8", "Grade 7", "Grade 6", "Grade 5", "Grade 4", "Grade 3", "Grade 2", "Grade 1", "Grade 0" }));
        sortBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBox2ActionPerformed(evt);
            }
        });

        sortlabel5.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel5.setText("Students");

        yearsorterTransferin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearsorterTransferinActionPerformed(evt);
            }
        });

        sortlabel8.setForeground(new java.awt.Color(0, 0, 0));
        sortlabel8.setText("Year");

        searchTXT2.setBackground(new java.awt.Color(255, 255, 255));
        searchTXT2.setForeground(new java.awt.Color(0, 0, 0));
        searchTXT2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchTXT2.setAA_BorderColor(new java.awt.Color(225, 225, 225));
        searchTXT2.setAA_TextHint("Search...");
        searchTXT2.setAB_HintColor(new java.awt.Color(225, 225, 225));
        searchTXT2.setAB_LineColor(new java.awt.Color(206, 206, 206));
        searchTXT2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchTXT2CaretUpdate(evt);
            }
        });

        pH_Label5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/searchnew.png"))); // NOI18N

        resheshBT2.setBackground(new java.awt.Color(255, 255, 255));
        resheshBT2.setBorder(null);
        resheshBT2.setForeground(new java.awt.Color(0, 0, 0));
        resheshBT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh2.png"))); // NOI18N
        resheshBT2.setText("Refresh                     ");
        resheshBT2.setToolTipText("");
        resheshBT2.setAAA_AutoFitToSize(true);
        resheshBT2.setAAA_ImageBoundArcSize(20);
        resheshBT2.setAAA_roundBottomLeft(20);
        resheshBT2.setAAA_roundBottomRight(20);
        resheshBT2.setAAA_roundTopLeft(20);
        resheshBT2.setAAA_roundTopRight(20);
        resheshBT2.setAA_ArcSize(20);
        resheshBT2.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        resheshBT2.setAA_DrawBorder(true);
        resheshBT2.setAA_DrawTopBorder(true);
        resheshBT2.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        resheshBT2.setAA_ImageIndent(10);
        resheshBT2.setName(""); // NOI18N
        resheshBT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resheshBT2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TransferinMenuPanelLayout = new javax.swing.GroupLayout(TransferinMenuPanel);
        TransferinMenuPanel.setLayout(TransferinMenuPanelLayout);
        TransferinMenuPanelLayout.setHorizontalGroup(
            TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferinMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TransferinMenuPanelLayout.createSequentialGroup()
                        .addGroup(TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sortlabel5)
                            .addComponent(sortlabel4)
                            .addComponent(sortlabel8)
                            .addComponent(pH_Label5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchTXT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yearsorterTransferin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sortBox2, 0, 107, Short.MAX_VALUE)
                            .addComponent(studentnum2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(resheshBT2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        TransferinMenuPanelLayout.setVerticalGroup(
            TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransferinMenuPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortlabel5)
                    .addComponent(studentnum2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortlabel4)
                    .addComponent(sortBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearsorterTransferin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortlabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TransferinMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchTXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pH_Label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(resheshBT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TransferinTableScrollPanel.setToolTipText("Right click to view Student info");

        TransferinTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LRN", "Last Name", "First Name", "Middle Name", "Birthday", "Sex", "Grade Level", "Year Transferred", "Contact", "Email", "Status", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TransferinTable.setRowHeight(25);
        TransferinTable.getTableHeader().setReorderingAllowed(false);
        TransferinTableScrollPanel.setViewportView(TransferinTable);
        if (TransferinTable.getColumnModel().getColumnCount() > 0) {
            TransferinTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            TransferinTable.getColumnModel().getColumn(9).setPreferredWidth(200);
            TransferinTable.getColumnModel().getColumn(10).setMinWidth(70);
            TransferinTable.getColumnModel().getColumn(10).setPreferredWidth(70);
            TransferinTable.getColumnModel().getColumn(10).setMaxWidth(80);
            TransferinTable.getColumnModel().getColumn(11).setMinWidth(4);
            TransferinTable.getColumnModel().getColumn(11).setPreferredWidth(4);
            TransferinTable.getColumnModel().getColumn(11).setMaxWidth(4);
        }

        transferinRP.setBackground(new java.awt.Color(222, 235, 247));
        transferinRP.setAAA_AutoFillSize(true);
        transferinRP.setAAA_AutoFitToSize(true);
        transferinRP.setAAA_AutoSize(true);
        transferinRP.setAAA_FitToSize(true);
        transferinRP.setAAA_ImageBoundArcSize(30);
        transferinRP.setAAA_roundBottomLeft(30);
        transferinRP.setAAA_roundBottomRight(30);
        transferinRP.setAAA_roundTopLeft(30);
        transferinRP.setAAA_roundTopRight(30);
        transferinRP.setAA_ArcSize(30);
        transferinRP.setAA_BorderColor(new java.awt.Color(222, 235, 247));

        transferinRPlabel.setBackground(new java.awt.Color(255, 255, 255));
        transferinRPlabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        transferinRPlabel.setForeground(new java.awt.Color(0, 0, 0));
        transferinRPlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        transferinRPlabel.setText("Transfer-in");

        javax.swing.GroupLayout transferinRPLayout = new javax.swing.GroupLayout(transferinRP);
        transferinRP.setLayout(transferinRPLayout);
        transferinRPLayout.setHorizontalGroup(
            transferinRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(transferinRPlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        transferinRPLayout.setVerticalGroup(
            transferinRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transferinRPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transferinRPlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TransferinLayout = new javax.swing.GroupLayout(Transferin);
        Transferin.setLayout(TransferinLayout);
        TransferinLayout.setHorizontalGroup(
            TransferinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransferinLayout.createSequentialGroup()
                .addGroup(TransferinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TransferinTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(transferinRP, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransferinMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TransferinLayout.setVerticalGroup(
            TransferinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TransferinMenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TransferinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transferinRP, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransferinTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                .addContainerGap())
        );

        layers.add(Transferin, "card2");

        AboutUs.setBackground(new java.awt.Color(255, 255, 255));

        helpscroll1.setBackground(new java.awt.Color(204, 204, 204));
        helpscroll1.setBorder(null);
        helpscroll1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        helpPanel1.setBackground(new java.awt.Color(255, 255, 255));
        helpPanel1.setPreferredSize(new java.awt.Dimension(866, 1000));

        HelpLabel1.setBackground(new java.awt.Color(222, 235, 247));
        HelpLabel1.setOpaque(false);

        helplable1.setBackground(new java.awt.Color(255, 255, 255));
        helplable1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        helplable1.setForeground(new java.awt.Color(0, 0, 0));
        helplable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helplable1.setText("About us");

        javax.swing.GroupLayout HelpLabel1Layout = new javax.swing.GroupLayout(HelpLabel1);
        HelpLabel1.setLayout(HelpLabel1Layout);
        HelpLabel1Layout.setHorizontalGroup(
            HelpLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HelpLabel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helplable1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                .addContainerGap())
        );
        HelpLabel1Layout.setVerticalGroup(
            HelpLabel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HelpLabel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helplable1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );

        tablecontentsscroll4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/abouts.png"))); // NOI18N
        jLabel7.setOpaque(true);
        tablecontentsscroll4.setViewportView(jLabel7);

        tablecontentsscroll5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/aboutusstory.png"))); // NOI18N
        jLabel11.setOpaque(true);
        tablecontentsscroll5.setViewportView(jLabel11);

        javax.swing.GroupLayout helpPanel1Layout = new javax.swing.GroupLayout(helpPanel1);
        helpPanel1.setLayout(helpPanel1Layout);
        helpPanel1Layout.setHorizontalGroup(
            helpPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HelpLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablecontentsscroll4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tablecontentsscroll5, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        helpPanel1Layout.setVerticalGroup(
            helpPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HelpLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tablecontentsscroll4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tablecontentsscroll5, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))
        );

        helpscroll1.setViewportView(helpPanel1);

        javax.swing.GroupLayout AboutUsLayout = new javax.swing.GroupLayout(AboutUs);
        AboutUs.setLayout(AboutUsLayout);
        AboutUsLayout.setHorizontalGroup(
            AboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpscroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        AboutUsLayout.setVerticalGroup(
            AboutUsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpscroll1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );

        layers.add(AboutUs, "card8");

        Help.setBackground(new java.awt.Color(255, 255, 255));

        helpscroll.setBackground(new java.awt.Color(204, 204, 204));
        helpscroll.setBorder(null);
        helpscroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        helpPanel.setBackground(new java.awt.Color(255, 255, 255));
        helpPanel.setPreferredSize(new java.awt.Dimension(866, 1000));

        HelpLabel.setBackground(new java.awt.Color(222, 235, 247));
        HelpLabel.setOpaque(false);

        helplable.setBackground(new java.awt.Color(255, 255, 255));
        helplable.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        helplable.setForeground(new java.awt.Color(0, 0, 0));
        helplable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        helplable.setText("Help Menu");

        javax.swing.GroupLayout HelpLabelLayout = new javax.swing.GroupLayout(HelpLabel);
        HelpLabel.setLayout(HelpLabelLayout);
        HelpLabelLayout.setHorizontalGroup(
            HelpLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HelpLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helplable, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                .addContainerGap())
        );
        HelpLabelLayout.setVerticalGroup(
            HelpLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HelpLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(helplable, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );

        tablecontentsscroll1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/getting started.png"))); // NOI18N
        jLabel4.setOpaque(true);
        tablecontentsscroll1.setViewportView(jLabel4);

        tablecontentsscroll2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/system requirements.png"))); // NOI18N
        jLabel5.setOpaque(true);
        tablecontentsscroll2.setViewportView(jLabel5);

        tablecontentsscroll3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/faqss.png"))); // NOI18N
        jLabel6.setOpaque(true);
        tablecontentsscroll3.setViewportView(jLabel6);

        javax.swing.GroupLayout helpPanelLayout = new javax.swing.GroupLayout(helpPanel);
        helpPanel.setLayout(helpPanelLayout);
        helpPanelLayout.setHorizontalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HelpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablecontentsscroll1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tablecontentsscroll2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(tablecontentsscroll3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        helpPanelLayout.setVerticalGroup(
            helpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, helpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HelpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(tablecontentsscroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablecontentsscroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablecontentsscroll3, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addContainerGap())
        );

        helpscroll.setViewportView(helpPanel);

        javax.swing.GroupLayout HelpLayout = new javax.swing.GroupLayout(Help);
        Help.setLayout(HelpLayout);
        HelpLayout.setHorizontalGroup(
            HelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        HelpLayout.setVerticalGroup(
            HelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(helpscroll, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );

        layers.add(Help, "card8");

        javax.swing.GroupLayout OverviewLayout = new javax.swing.GroupLayout(Overview);
        Overview.setLayout(OverviewLayout);
        OverviewLayout.setHorizontalGroup(
            OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        OverviewLayout.setVerticalGroup(
            OverviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );

        layers.add(Overview, "card9");

        Settings.setBackground(new java.awt.Color(255, 255, 255));

        aboutusBT.setBackground(new java.awt.Color(255, 255, 255));
        aboutusBT.setForeground(new java.awt.Color(0, 0, 0));
        aboutusBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/info (1).png"))); // NOI18N
        aboutusBT.setText("<html><b>ABOUT US</b><br> Learn about the developers and the story behind the system's creation, along with its key features.</html>");
        aboutusBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aboutusBT.setIconTextGap(10);
        aboutusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutusBTActionPerformed(evt);
            }
        });

        helpBT.setBackground(new java.awt.Color(255, 255, 255));
        helpBT.setForeground(new java.awt.Color(0, 0, 0));
        helpBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/interrogation.png"))); // NOI18N
        helpBT.setText("<html><b>HELP</b><br> Access help and support resources, including a knowledge base, user guides, manual, FAQs, and contact information for technical support.</html>");
        helpBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        helpBT.setIconTextGap(10);
        helpBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpBTActionPerformed(evt);
            }
        });

        changepasswordBT.setBackground(new java.awt.Color(255, 255, 255));
        changepasswordBT.setForeground(new java.awt.Color(0, 0, 0));
        changepasswordBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lock.png"))); // NOI18N
        changepasswordBT.setText("<html><b>SECURITY</b><br> Modify your password and username.</html>");
        changepasswordBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        changepasswordBT.setIconTextGap(10);
        changepasswordBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changepasswordBTActionPerformed(evt);
            }
        });

        archiveBT.setBackground(new java.awt.Color(255, 255, 255));
        archiveBT.setForeground(new java.awt.Color(0, 0, 0));
        archiveBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/inbox-in.png"))); // NOI18N
        archiveBT.setText("<html><b>SAVE TO ARCHIVE</b><br>Move all Grade 12 completed students to the archive.</html>");
        archiveBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        archiveBT.setIconTextGap(10);
        archiveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archiveBTActionPerformed(evt);
            }
        });

        UpdateBT.setBackground(new java.awt.Color(255, 255, 255));
        UpdateBT.setForeground(new java.awt.Color(0, 0, 0));
        UpdateBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sort-amount-up-alt.png"))); // NOI18N
        UpdateBT.setText("<html><b>UPDATE GRADE AND YEAR</b><br>Update students' year to the current year and increment their grade level by +1.</html>");
        UpdateBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UpdateBT.setIconTextGap(10);
        UpdateBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBTActionPerformed(evt);
            }
        });

        BackupBT.setBackground(new java.awt.Color(255, 255, 255));
        BackupBT.setForeground(new java.awt.Color(0, 0, 0));
        BackupBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BACKUP.png"))); // NOI18N
        BackupBT.setText("<html><b>BACKUP</b><br>Import or Export database to an excel file</html>");
        BackupBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BackupBT.setIconTextGap(10);
        BackupBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackupBTActionPerformed(evt);
            }
        });

        passpanel.setBackground(new java.awt.Color(255, 255, 255));
        passpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 233, 233)));

        confirmpasswordTXT.setBackground(new java.awt.Color(255, 255, 255));
        confirmpasswordTXT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        confirmpasswordTXT.setForeground(new java.awt.Color(0, 0, 0));
        confirmpasswordTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        newpasswordTXT.setBackground(new java.awt.Color(255, 255, 255));
        newpasswordTXT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        newpasswordTXT.setForeground(new java.awt.Color(0, 0, 0));
        newpasswordTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        newusernameTXT.setBackground(new java.awt.Color(255, 255, 255));
        newusernameTXT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        newusernameTXT.setForeground(new java.awt.Color(0, 0, 0));
        newusernameTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("enter new username:");
        jLabel8.setToolTipText("");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("enter new password:");
        jLabel9.setToolTipText("");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("confirm password:");
        jLabel10.setToolTipText("");

        savepassword.setBackground(new java.awt.Color(255, 255, 255));
        savepassword.setBorder(null);
        savepassword.setForeground(new java.awt.Color(0, 0, 0));
        savepassword.setText("Save");
        savepassword.setToolTipText("");
        savepassword.setAAA_AutoFitToSize(true);
        savepassword.setAAA_ImageBoundArcSize(20);
        savepassword.setAAA_roundBottomLeft(20);
        savepassword.setAAA_roundBottomRight(20);
        savepassword.setAAA_roundTopLeft(20);
        savepassword.setAAA_roundTopRight(20);
        savepassword.setAA_ArcSize(20);
        savepassword.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        savepassword.setAA_DrawBorder(true);
        savepassword.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        savepassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savepasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout passpanelLayout = new javax.swing.GroupLayout(passpanel);
        passpanel.setLayout(passpanelLayout);
        passpanelLayout.setHorizontalGroup(
            passpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passpanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(passpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(newpasswordTXT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmpasswordTXT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newusernameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(savepassword, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        passpanelLayout.setVerticalGroup(
            passpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(passpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newusernameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(passpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newpasswordTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(passpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmpasswordTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savepassword, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        rowBT.setBackground(new java.awt.Color(255, 255, 255));
        rowBT.setForeground(new java.awt.Color(0, 0, 0));
        rowBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/rowicon.jpg"))); // NOI18N
        rowBT.setText("<html><b>ROW HEIGHT</b><br>edit the height of all the tables</html>");
        rowBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rowBT.setIconTextGap(10);
        rowBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowBTActionPerformed(evt);
            }
        });

        rowpanel.setBackground(new java.awt.Color(255, 255, 255));
        rowpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 233, 233)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("EDIT ROW HEIGHT");

        rowheightnum.setEditable(false);
        rowheightnum.setBackground(new java.awt.Color(255, 255, 255));
        rowheightnum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rowheightnum.setForeground(new java.awt.Color(0, 0, 0));
        rowheightnum.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rowheightnum.setText("0");
        rowheightnum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        rowadd.setBackground(new java.awt.Color(255, 255, 255));
        rowadd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rowadd.setForeground(new java.awt.Color(0, 0, 0));
        rowadd.setText("+");
        rowadd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        rowadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowaddActionPerformed(evt);
            }
        });

        rowreduce.setBackground(new java.awt.Color(255, 255, 255));
        rowreduce.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rowreduce.setForeground(new java.awt.Color(0, 0, 0));
        rowreduce.setText("-");
        rowreduce.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        rowreduce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowreduceActionPerformed(evt);
            }
        });

        rowdef.setBackground(new java.awt.Color(255, 255, 255));
        rowdef.setBorder(null);
        rowdef.setForeground(new java.awt.Color(0, 0, 0));
        rowdef.setText("Set to Default");
        rowdef.setToolTipText("");
        rowdef.setAAA_AutoFitToSize(true);
        rowdef.setAAA_ImageBoundArcSize(20);
        rowdef.setAAA_roundBottomLeft(20);
        rowdef.setAAA_roundBottomRight(20);
        rowdef.setAAA_roundTopLeft(20);
        rowdef.setAAA_roundTopRight(20);
        rowdef.setAA_ArcSize(20);
        rowdef.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        rowdef.setAA_DrawBorder(true);
        rowdef.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        rowdef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rowdefActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rowpanelLayout = new javax.swing.GroupLayout(rowpanel);
        rowpanel.setLayout(rowpanelLayout);
        rowpanelLayout.setHorizontalGroup(
            rowpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rowpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rowpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rowheightnum))
                .addGap(3, 3, 3)
                .addGroup(rowpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rowadd, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rowreduce, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rowdef, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rowpanelLayout.setVerticalGroup(
            rowpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rowpanelLayout.createSequentialGroup()
                .addGroup(rowpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rowpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rowheightnum, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(rowpanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(rowpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rowdef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rowpanelLayout.createSequentialGroup()
                                .addComponent(rowadd, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(rowreduce, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(2, 2, 2))
        );

        fontsizeBT.setBackground(new java.awt.Color(255, 255, 255));
        fontsizeBT.setForeground(new java.awt.Color(0, 0, 0));
        fontsizeBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/font size icon.jpg"))); // NOI18N
        fontsizeBT.setText("<html><b>FONT SIZE</b><br>edit all the font size inside the tables</html>");
        fontsizeBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fontsizeBT.setIconTextGap(10);
        fontsizeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontsizeBTActionPerformed(evt);
            }
        });

        fontpanel.setBackground(new java.awt.Color(255, 255, 255));
        fontpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 233, 233)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("EDIT FONT SIZE");

        fontsizeTXT.setEditable(false);
        fontsizeTXT.setBackground(new java.awt.Color(255, 255, 255));
        fontsizeTXT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fontsizeTXT.setForeground(new java.awt.Color(0, 0, 0));
        fontsizeTXT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fontsizeTXT.setText("0");
        fontsizeTXT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        fontup.setBackground(new java.awt.Color(255, 255, 255));
        fontup.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fontup.setForeground(new java.awt.Color(0, 0, 0));
        fontup.setText("+");
        fontup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        fontup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontupActionPerformed(evt);
            }
        });

        fontdown.setBackground(new java.awt.Color(255, 255, 255));
        fontdown.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fontdown.setForeground(new java.awt.Color(0, 0, 0));
        fontdown.setText("-");
        fontdown.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(140, 140, 140)));
        fontdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontdownActionPerformed(evt);
            }
        });

        fontdef.setBackground(new java.awt.Color(255, 255, 255));
        fontdef.setBorder(null);
        fontdef.setForeground(new java.awt.Color(0, 0, 0));
        fontdef.setText("Set to Default");
        fontdef.setToolTipText("");
        fontdef.setAAA_AutoFitToSize(true);
        fontdef.setAAA_ImageBoundArcSize(20);
        fontdef.setAAA_roundBottomLeft(20);
        fontdef.setAAA_roundBottomRight(20);
        fontdef.setAAA_roundTopLeft(20);
        fontdef.setAAA_roundTopRight(20);
        fontdef.setAA_ArcSize(20);
        fontdef.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        fontdef.setAA_DrawBorder(true);
        fontdef.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        fontdef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontdefActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fontpanelLayout = new javax.swing.GroupLayout(fontpanel);
        fontpanel.setLayout(fontpanelLayout);
        fontpanelLayout.setHorizontalGroup(
            fontpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fontpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fontpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(fontsizeTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(fontpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fontup, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontdown, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fontdef, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        fontpanelLayout.setVerticalGroup(
            fontpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fontpanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(fontup, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(fontdown, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fontpanelLayout.createSequentialGroup()
                .addGroup(fontpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fontpanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fontsizeTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fontpanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fontdef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        hidetitleBT.setBackground(new java.awt.Color(255, 255, 255));
        hidetitleBT.setForeground(new java.awt.Color(0, 0, 0));
        hidetitleBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/eye.png"))); // NOI18N
        hidetitleBT.setText("<html><b>HIDE TITLE</b><br>hide or unhide the title above the tables</html>");
        hidetitleBT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hidetitleBT.setIconTextGap(10);
        hidetitleBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hidetitleBTActionPerformed(evt);
            }
        });

        ExportPanel.setBackground(new java.awt.Color(255, 255, 255));
        ExportPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 233, 233)));

        exportBT.setBackground(new java.awt.Color(255, 255, 255));
        exportBT.setBorder(null);
        exportBT.setForeground(new java.awt.Color(0, 0, 0));
        exportBT.setText("EXPORT");
        exportBT.setToolTipText("");
        exportBT.setAAA_AutoFitToSize(true);
        exportBT.setAAA_ImageBoundArcSize(20);
        exportBT.setAAA_roundBottomLeft(20);
        exportBT.setAAA_roundBottomRight(20);
        exportBT.setAAA_roundTopLeft(20);
        exportBT.setAAA_roundTopRight(20);
        exportBT.setAA_ArcSize(20);
        exportBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        exportBT.setAA_DrawBorder(true);
        exportBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        exportBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBTActionPerformed(evt);
            }
        });

        importBT.setBackground(new java.awt.Color(255, 255, 255));
        importBT.setBorder(null);
        importBT.setForeground(new java.awt.Color(0, 0, 0));
        importBT.setText("IMPORT");
        importBT.setToolTipText("");
        importBT.setAAA_AutoFitToSize(true);
        importBT.setAAA_ImageBoundArcSize(20);
        importBT.setAAA_roundBottomLeft(20);
        importBT.setAAA_roundBottomRight(20);
        importBT.setAAA_roundTopLeft(20);
        importBT.setAAA_roundTopRight(20);
        importBT.setAA_ArcSize(20);
        importBT.setAA_ButtonColor(new java.awt.Color(255, 255, 255));
        importBT.setAA_DrawBorder(true);
        importBT.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        importBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExportPanelLayout = new javax.swing.GroupLayout(ExportPanel);
        ExportPanel.setLayout(ExportPanelLayout);
        ExportPanelLayout.setHorizontalGroup(
            ExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportBT, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importBT, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ExportPanelLayout.setVerticalGroup(
            ExportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExportPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout SettingsLayout = new javax.swing.GroupLayout(Settings);
        Settings.setLayout(SettingsLayout);
        SettingsLayout.setHorizontalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aboutusBT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(helpBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(changepasswordBT)
                    .addComponent(archiveBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(UpdateBT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(BackupBT, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rowBT)
                    .addComponent(rowpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fontsizeBT)
                    .addComponent(fontpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hidetitleBT, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ExportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SettingsLayout.setVerticalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(aboutusBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(helpBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(changepasswordBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(passpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(archiveBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(UpdateBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(BackupBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(ExportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rowBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(rowpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(fontsizeBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(fontpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(hidetitleBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layers.add(Settings, "card2");

        getContentPane().add(layers);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    
    //Sort Complete and Incomplete students
    private void sortBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortBoxActionPerformed
    sfx.playSound3(clip);
        MasterlistSorter();
    
    }//GEN-LAST:event_sortBoxActionPerformed

 
    
    
    
//======================================================================================================================================================================//
    
    
               //MENU PANEL BUTTONS
    
    
//======================================================================================================================================================================// 
    
    
    
    
//- [9] -----------------------------------------------------------------------------------------------------------------------//
    private void masterlistPLBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterlistPLBTMouseClicked
        if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        
        
        layers.removeAll();
        layers.add(Masterlist);
        layers.repaint();
        layers.revalidate();
        refreshTable();
        
        masterlistslide = 1;
        archiveslide = 0;
        transferinslide = 0;
        transferoutslide= 0;
        settingslide = 0;
        setColor(MasterlistSlide);
        
        resetColor2(MenuSlide);
        resetColor2(ArchiveSlide);
        resetColor2(TransferinSlide);
        resetColor2(TransferoutSlide);
        resetColor2(SettingsSlide);
        
        masterlistPLBTMouseEntered(evt);

        archivePLBTMouseExited(evt);
        transferinPLBTMouseExited(evt);
        transferoutPLBTMouseExited(evt);
        settingsPLBTMouseExited(evt);
    
        updateJTable(MasterlistTable);
        
        
    }//GEN-LAST:event_masterlistPLBTMouseClicked

    private void masterlistPLBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterlistPLBTMouseEntered
        setColor(masterlistPLBT);
        setColorlabel(masterlistLBBT);
    }//GEN-LAST:event_masterlistPLBTMouseEntered

    private void masterlistPLBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterlistPLBTMouseExited
       if (masterlistslide == 0){
        resetColor(masterlistPLBT);
        resetColorlabel(masterlistLBBT);
       }
  
    }//GEN-LAST:event_masterlistPLBTMouseExited

    
//- [10] -----------------------------------------------------------------------------------------------------------------------//
    private void archivePLBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archivePLBTMouseClicked
        if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        
        layers.removeAll();
        layers.add(Archive);
        layers.repaint();
        layers.revalidate();
        refreshArchive();
        
        
        masterlistslide = 0;
        archiveslide = 1;
        transferinslide = 0;
        transferoutslide= 0;
        settingslide = 0;
        setColor(ArchiveSlide);
        
        resetColor2(MenuSlide);
        resetColor2(MasterlistSlide);
        resetColor2(TransferinSlide);
        resetColor2(TransferoutSlide);
        resetColor2(SettingsSlide);
        
        archivePLBTMouseEntered(evt);

        masterlistPLBTMouseExited(evt);
        transferinPLBTMouseExited(evt);
        transferoutPLBTMouseExited(evt);
        settingsPLBTMouseExited(evt);
    
        updateJTable(ArchiveTable);
  
    }//GEN-LAST:event_archivePLBTMouseClicked

    private void archivePLBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archivePLBTMouseEntered
        setColor(archivePLBT);
        setColorlabel(archiveLBBT);
    }//GEN-LAST:event_archivePLBTMouseEntered

    private void archivePLBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archivePLBTMouseExited
        if(archiveslide ==0){
        resetColor(archivePLBT);
        resetColorlabel(archiveLBBT);
        }
        
    }//GEN-LAST:event_archivePLBTMouseExited


//- [11] -----------------------------------------------------------------------------------------------------------------------//  
    private void transferinPLBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferinPLBTMouseClicked
        if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        
        layers.removeAll();
        layers.add(Transferin);
        layers.repaint();
        layers.revalidate();
        refreshtransin();
        
        
        masterlistslide = 0;
        archiveslide = 0;
        transferinslide = 1;
        transferoutslide= 0;
        settingslide = 0;
        setColor(TransferinSlide);
        
        resetColor2(MenuSlide);
        resetColor2(MasterlistSlide);
        resetColor2(ArchiveSlide);
        resetColor2(TransferoutSlide);
        resetColor2(SettingsSlide);
        
        transferinPLBTMouseEntered(evt);

        masterlistPLBTMouseExited(evt);
        archivePLBTMouseExited(evt);
        transferoutPLBTMouseExited(evt);
        settingsPLBTMouseExited(evt);
 
        updateJTable(TransferinTable);
    }//GEN-LAST:event_transferinPLBTMouseClicked

    private void transferinPLBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferinPLBTMouseEntered
        setColor(transferinPLBT);
        setColorlabel(transferinLBBT);
    }//GEN-LAST:event_transferinPLBTMouseEntered

    private void transferinPLBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferinPLBTMouseExited
        if(transferinslide ==0){
        resetColor(transferinPLBT);
        resetColorlabel(transferinLBBT);
        }
    }//GEN-LAST:event_transferinPLBTMouseExited

    
    
//- [13] -----------------------------------------------------------------------------------------------------------------------//    
    private void settingsPLBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsPLBTMouseClicked
        
        if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        
        layers.removeAll();
        layers.add(Settings);
        layers.repaint();
        layers.revalidate();
        
        masterlistslide = 0;
        archiveslide = 0;
        transferinslide = 0;
        transferoutslide= 0;
        settingslide = 1;
        setColor(SettingsSlide);
        
        resetColor2(MenuSlide);
        resetColor2(MasterlistSlide);
        resetColor2(ArchiveSlide);
        resetColor2(TransferinSlide);
        resetColor2(TransferoutSlide);
        
        settingsPLBTMouseEntered(evt);

        masterlistPLBTMouseExited(evt);
        archivePLBTMouseExited(evt);
        transferinPLBTMouseExited(evt);
        transferoutPLBTMouseExited(evt);
        
        
     
        
    }//GEN-LAST:event_settingsPLBTMouseClicked

    private void settingsPLBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsPLBTMouseEntered
        setColor(settingsPLBT);
        setColorlabel(settingsLBBT);
    }//GEN-LAST:event_settingsPLBTMouseEntered

    private void settingsPLBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsPLBTMouseExited
        if (settingslide == 0){
        resetColor(settingsPLBT);
        resetColorlabel(settingsLBBT);
        }
    }//GEN-LAST:event_settingsPLBTMouseExited

    
    private void transferoutPLBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferoutPLBTMouseClicked
        if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        
        
        layers.removeAll();
        layers.add(Transferout);
        layers.repaint();
        layers.revalidate();
        refreshtransout();
        
        masterlistslide = 0;
        archiveslide = 0;
        transferinslide = 0;
        transferoutslide= 1;
        settingslide = 0;
        setColor(TransferoutSlide);
        
        resetColor2(MenuSlide);
        resetColor2(MasterlistSlide);
        resetColor2(ArchiveSlide);
        resetColor2(TransferinSlide);
        resetColor2(SettingsSlide);
        
        transferoutPLBTMouseEntered(evt);

        masterlistPLBTMouseExited(evt);
        archivePLBTMouseExited(evt);
        transferinPLBTMouseExited(evt);
        settingsPLBTMouseExited(evt);
        
        
        
        updateJTable(TransferinTable);
    }//GEN-LAST:event_transferoutPLBTMouseClicked

    private void transferoutPLBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferoutPLBTMouseEntered
        setColor(transferoutPLBT);
        setColorlabel(transferoutLBBT);
    }//GEN-LAST:event_transferoutPLBTMouseEntered

    private void transferoutPLBTMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferoutPLBTMouseExited
       if (transferoutslide == 0){
        resetColor(transferoutPLBT);
        resetColorlabel(transferoutLBBT); 
       }
    }//GEN-LAST:event_transferoutPLBTMouseExited


    
    
    
    private void sortBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortBox2ActionPerformed
    sfx.playSound3(clip);
        TransferinSorter();
    
    
    }//GEN-LAST:event_sortBox2ActionPerformed




    private void sortBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortBox3ActionPerformed
    sfx.playSound3(clip);
        TransferoutSorter();
    
    }//GEN-LAST:event_sortBox3ActionPerformed

    
           
 
    private void lphsLogo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lphsLogo1MouseClicked

    }//GEN-LAST:event_lphsLogo1MouseClicked

    private void changepasswordBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changepasswordBTActionPerformed
        sfx.playSound2(clip);
        
        if(passpanel.isVisible()){
            passpanel.setVisible(false);
            newusernameTXT.setText("");
            newpasswordTXT.setText("");
            confirmpasswordTXT.setText("");
        }else {
        
                String enteredUsername = JOptionPane.showInputDialog(
                   null,
                   "Enter username:",
                   "Username Confirmation",
                   JOptionPane.PLAIN_MESSAGE
           );

           String enteredPassword = JOptionPane.showInputDialog(
                   null,
                   "Enter password:",
                   "Password Confirmation",
                   JOptionPane.PLAIN_MESSAGE
           );

           // Check if the credentials are correct
           if (isCredentialsCorrect(enteredUsername, enteredPassword)) {
               // Credentials are correct, proceed with the operation
               passpanel.setVisible(true);
               refreshArchive();
           } else {
               // Credentials are incorrect, display an error message
               JOptionPane.showMessageDialog(
                       null,
                       "Incorrect username or password. Operation canceled.",
                       "Error",
                       JOptionPane.ERROR_MESSAGE
               );
           }
        
        
        }
   
    }//GEN-LAST:event_changepasswordBTActionPerformed

    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //MENU SLIDE BUTTONS 
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    private void MenuSlideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSlideMouseEntered
       setColor(MenuSlide);
    }//GEN-LAST:event_MenuSlideMouseEntered

    private void MenuSlideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSlideMouseExited
        resetColor2(MenuSlide);      
    }//GEN-LAST:event_MenuSlideMouseExited

    private void MasterlistSlideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasterlistSlideMouseEntered
       setColor(MasterlistSlide);
    }//GEN-LAST:event_MasterlistSlideMouseEntered

    private void MasterlistSlideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasterlistSlideMouseExited
        if (masterlistslide == 0){
        resetColor2(MasterlistSlide);
        }     
    }//GEN-LAST:event_MasterlistSlideMouseExited

    private void MenuSlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuSlideMouseClicked
       sfx.playSound(clip);
        
        menu.setVisible(true);
        slidePanel.setVisible(false);
        
        
        setColor(MenuSlide);
        
        
    }//GEN-LAST:event_MenuSlideMouseClicked

    private void MasterlistSlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasterlistSlideMouseClicked
        
       if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        masterlistslide = 1;
        archiveslide = 0;
        transferinslide = 0;
        transferoutslide= 0;
        settingslide = 0;
        setColor(MasterlistSlide);
        
        resetColor2(MenuSlide);
        resetColor2(ArchiveSlide);
        resetColor2(TransferinSlide);
        resetColor2(TransferoutSlide);
        resetColor2(SettingsSlide);
        
        masterlistPLBTMouseClicked(evt);
    }//GEN-LAST:event_MasterlistSlideMouseClicked

    private void ArchiveSlideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArchiveSlideMouseEntered
       setColor(ArchiveSlide);
    }//GEN-LAST:event_ArchiveSlideMouseEntered

    private void ArchiveSlideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArchiveSlideMouseExited
        if (archiveslide == 0){
        resetColor2(ArchiveSlide);
        }    
    }//GEN-LAST:event_ArchiveSlideMouseExited

    private void ArchiveSlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArchiveSlideMouseClicked
        if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        masterlistslide = 0;
        archiveslide = 1;
        transferinslide = 0;
        transferoutslide= 0;
        settingslide = 0;
        setColor(ArchiveSlide);
        
        resetColor2(MenuSlide);
        resetColor2(MasterlistSlide);
        resetColor2(TransferinSlide);
        resetColor2(TransferoutSlide);
        resetColor2(SettingsSlide);
        
        archivePLBTMouseClicked(evt);
    }//GEN-LAST:event_ArchiveSlideMouseClicked

    private void TransferinSlideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferinSlideMouseEntered
        setColor(TransferinSlide);
    }//GEN-LAST:event_TransferinSlideMouseEntered

    private void TransferinSlideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferinSlideMouseExited
        if (transferinslide == 0){
        resetColor2(TransferinSlide);
        }   
    }//GEN-LAST:event_TransferinSlideMouseExited

    private void TransferinSlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferinSlideMouseClicked
        if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        masterlistslide = 0;
        archiveslide = 0;
        transferinslide = 1;
        transferoutslide= 0;
        settingslide = 0;
        setColor(TransferinSlide);
        
        resetColor2(MenuSlide);
        resetColor2(MasterlistSlide);
        resetColor2(ArchiveSlide);
        resetColor2(TransferoutSlide);
        resetColor2(SettingsSlide);
        
        transferinPLBTMouseClicked(evt);
    }//GEN-LAST:event_TransferinSlideMouseClicked

    private void TransferoutSlideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferoutSlideMouseEntered
        setColor(TransferoutSlide);
    }//GEN-LAST:event_TransferoutSlideMouseEntered

    private void TransferoutSlideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferoutSlideMouseExited
         if (transferoutslide == 0){
        resetColor2(TransferoutSlide);
        }   
    }//GEN-LAST:event_TransferoutSlideMouseExited

    private void TransferoutSlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TransferoutSlideMouseClicked
        
       if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        masterlistslide = 0;
        archiveslide = 0;
        transferinslide = 0;
        transferoutslide= 1;
        settingslide = 0;
        setColor(TransferoutSlide);
        
        resetColor2(MenuSlide);
        resetColor2(MasterlistSlide);
        resetColor2(ArchiveSlide);
        resetColor2(TransferinSlide);
        resetColor2(SettingsSlide);
        
        transferoutPLBTMouseClicked(evt);
    }//GEN-LAST:event_TransferoutSlideMouseClicked

    private void SettingsSlideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingsSlideMouseEntered
        setColor(SettingsSlide);
    }//GEN-LAST:event_SettingsSlideMouseEntered

    private void SettingsSlideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingsSlideMouseExited
        if (settingslide == 0){
        resetColor2(SettingsSlide);
        }  
    }//GEN-LAST:event_SettingsSlideMouseExited

    private void SettingsSlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SettingsSlideMouseClicked
        if (start ==0){
        start++;
        } else {
        sfx.playSound2(clip);
        }
        masterlistslide = 0;
        archiveslide = 0;
        transferinslide = 0;
        transferoutslide= 0;
        settingslide = 1;
        setColor(SettingsSlide);
        
        resetColor2(MenuSlide);
        resetColor2(MasterlistSlide);
        resetColor2(ArchiveSlide);
        resetColor2(TransferinSlide);
        resetColor2(TransferoutSlide);
        
        settingsPLBTMouseClicked(evt);
    }//GEN-LAST:event_SettingsSlideMouseClicked

    private void MenuslideclickMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuslideclickMouseClicked
      sfx.playSound(clip);
        menu.setVisible(false);
       slidePanel.setVisible(true);
    }//GEN-LAST:event_MenuslideclickMouseClicked

    private void MenuslideclickMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuslideclickMouseEntered
        ImageIcon icon = new ImageIcon("angle-circle-left.png");
        Menuslideclick.setIcon(icon);
    }//GEN-LAST:event_MenuslideclickMouseEntered

    private void MenuslideclickMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuslideclickMouseExited
       ImageIcon icon = new ImageIcon("minilogo.jpg");
       Menuslideclick.setIcon(icon);
    }//GEN-LAST:event_MenuslideclickMouseExited

        
    private void archiveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archiveBTActionPerformed

        sfx.playSound2(clip);
// Prompt for username and password
    String enteredUsername = JOptionPane.showInputDialog(
            null,
            "Enter username:",
            "Username Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    String enteredPassword = JOptionPane.showInputDialog(
            null,
            "Enter password:",
            "Password Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );
    
    
    //-----------------------------------------------------------------
    archiveLoad archive = new archiveLoad();
    Timer timer = new Timer (1, e -> {
        JOptionPane.getRootFrame().dispose();
    });
    //-----------------------------------------------------------------

    // Check if the credentials are correct
    if (isCredentialsCorrect(enteredUsername, enteredPassword)) {
       
        // Credentials are correct, proceed with the archiveButton and refreshBTActionPerformed
    //loadingLBL.setVisible(true);    
    int option = JOptionPane.showConfirmDialog(null, "<html>Performing this task will result in a massive change in the database.<br> (Are you sure you want to proceed?)</html>", "Confirmation", JOptionPane.YES_NO_OPTION);
    timer.setRepeats(false);
    timer.start();
    if (option == JOptionPane.YES_OPTION) {
        
     //loadingLBL.setVisible(true);      
    
     //-----------------------------------------------------------------
     archive.setVisible(true);
     JOptionPane.showMessageDialog(null, "");
    //-----------------------------------------------------------------
      archiveButton();
        
      refreshTable();

    }
      
        //loadingLBL.setVisible(false);
        archive.setVisible(false);
        JOptionPane.showMessageDialog(null, msg); 
        
        
    } else {
        // Credentials are incorrect, display an error message
        JOptionPane.showMessageDialog(
                null,
                "Incorrect username or password. Archive canceled.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_archiveBTActionPerformed

    private void yearsorterTransferinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearsorterTransferinActionPerformed
        sfx.playSound3(clip);
        YearTransferinSorter();
    }//GEN-LAST:event_yearsorterTransferinActionPerformed

    private void yearsorterTransferoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearsorterTransferoutActionPerformed
        sfx.playSound3(clip);
        YearTransferoutSorter();
    }//GEN-LAST:event_yearsorterTransferoutActionPerformed

    private void UpdateBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBTActionPerformed
    
        sfx.playSound2(clip);
// Prompt for username and password
    String enteredUsername = JOptionPane.showInputDialog(
            null,
            "Enter username:",
            "Username Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    String enteredPassword = JOptionPane.showInputDialog(
            null,
            "Enter password:",
            "Password Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    // Check if the credentials are correct
    if (isCredentialsCorrect(enteredUsername, enteredPassword)) {
        // Credentials are correct, proceed with the main code
        int option = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to update the year and increment all grade levels?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );

        if (option == JOptionPane.YES_OPTION) {
            UpdateYear();
            incrementAllGradeLevelByOne();

            // Display a popup if rows have been updated
            JOptionPane.showMessageDialog(
                    null,
                    "Rows have been updated.",
                    "Update Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    } else {
        // Credentials are incorrect, display an error message
        JOptionPane.showMessageDialog(
                null,
                "Incorrect username or password. Update canceled.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_UpdateBTActionPerformed

    private void helpBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpBTActionPerformed
        
        sfx.playSound2(clip);
        layers.removeAll();
        layers.add(Help);
        layers.repaint();
        layers.revalidate();
    }//GEN-LAST:event_helpBTActionPerformed

    private void BackupBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackupBTActionPerformed
        sfx.playSound2(clip);
        if (ExportPanel.isVisible()){
        ExportPanel.setVisible(false);
        }else{
        ExportPanel.setVisible(true);
        }
    }//GEN-LAST:event_BackupBTActionPerformed

    private void rowBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowBTActionPerformed
        sfx.playSound2(clip);
        
        if (rowpanel.isVisible()){
        rowpanel.setVisible(false);
        }else{
        rowpanel.setVisible(true);
        }
    }//GEN-LAST:event_rowBTActionPerformed

    private void rowaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowaddActionPerformed
        sfx.playSound2(clip);
        
        int plus = Integer.parseInt(rowheightnum.getText());
        plus += 5;
        rowheightnum.setText(Integer.toString(plus)); 
        MasterlistTable.setRowHeight(plus);
        ArchiveTable.setRowHeight(plus);
        TransferinTable.setRowHeight(plus);
        TransferoutTable.setRowHeight(plus);
        
    }//GEN-LAST:event_rowaddActionPerformed

    private void rowreduceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowreduceActionPerformed
sfx.playSound2(clip);

        int plus = Integer.parseInt(rowheightnum.getText());
        if (plus != 10) {
        
        plus -= 5;
       rowheightnum.setText(Integer.toString(plus)); 
        MasterlistTable.setRowHeight(plus);
        ArchiveTable.setRowHeight(plus);
        TransferinTable.setRowHeight(plus);
        TransferoutTable.setRowHeight(plus);
        
        }
    }//GEN-LAST:event_rowreduceActionPerformed

    private void fontsizeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontsizeBTActionPerformed
       sfx.playSound2(clip);
        if (fontpanel.isVisible()){
        fontpanel.setVisible(false);
        }else{
        fontpanel.setVisible(true);
        }
    }//GEN-LAST:event_fontsizeBTActionPerformed

    private void fontupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontupActionPerformed
sfx.playSound2(clip);
        Font masterlistfont = MasterlistTable.getFont();
        
        int font = Integer.parseInt(fontsizeTXT.getText());
        font += 2;
        fontsizeTXT.setText(Integer.toString(font));
        
        Font newFont = new Font(masterlistfont.getName(), masterlistfont.getStyle(), font); 
        MasterlistTable.setFont(newFont);
        ArchiveTable.setFont(newFont);
        TransferinTable.setFont(newFont);
        TransferoutTable.setFont(newFont);
    }//GEN-LAST:event_fontupActionPerformed

    private void fontdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontdownActionPerformed
sfx.playSound2(clip);
        Font masterlistfont = MasterlistTable.getFont();
        
        int font = Integer.parseInt(fontsizeTXT.getText());
        
        if (font != 2) {
        font -= 2;
        fontsizeTXT.setText(Integer.toString(font));
        
        Font newFont = new Font(masterlistfont.getName(), masterlistfont.getStyle(), font); 
        MasterlistTable.setFont(newFont);
        ArchiveTable.setFont(newFont);
        TransferinTable.setFont(newFont);
        TransferoutTable.setFont(newFont);

        }
    }//GEN-LAST:event_fontdownActionPerformed

    private void sortBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortBox4ActionPerformed
        sfx.playSound3(clip);
        ArchiveSorter();
    }//GEN-LAST:event_sortBox4ActionPerformed

    private void yearsorterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearsorterActionPerformed
        sfx.playSound3(clip);
        YearArchiveSorter();
    }//GEN-LAST:event_yearsorterActionPerformed

    
    private ImageIcon icon1, icon2;
    private void hideControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideControlMouseEntered
        setColor(hideControl);
    }//GEN-LAST:event_hideControlMouseEntered

    private void hideControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideControlMouseExited
        resetColor2(hideControl);
    }//GEN-LAST:event_hideControlMouseExited
  
    private void hidetitleBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hidetitleBTActionPerformed
sfx.playSound(clip);

        icon2 = new ImageIcon("eye-crossed.png"); // Replace "icon1.png" with your icon file path
        icon1 = new ImageIcon("eye.png");
        
       
        
        SwingUtilities.updateComponentTreeUI(this);
        if (masterlistRP.isVisible()){
        masterlistRP.setVisible(false);  
        transferinRP.setVisible(false);  
        transferoutRP.setVisible(false);  
        archiveRP.setVisible(false);  
      
        hidetitleBT.setIcon(icon2);   
        hidetitleBT.setText("<html><b>UNHIDE TITLE</b><br>hide or unhide the title above the tables</html>");
        } else {
        masterlistRP.setVisible(true);  
        transferinRP.setVisible(true);  
        transferoutRP.setVisible(true);  
        archiveRP.setVisible(true); 
        hidetitleBT.setIcon(icon1);
        hidetitleBT.setText("<html><b>HIDE TITLE</b><br>hide or unhide the title above the tables</html>");
        }
         
         
    }//GEN-LAST:event_hidetitleBTActionPerformed

    private void hideControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideControlMouseClicked
        sfx.playSound(clip); 
        icon2 = new ImageIcon("eye-crossed.png"); // Replace "icon1.png" with your icon file path
        icon1 = new ImageIcon("eye.png");
        
        if (MasterlistMenuPanel.isVisible()){
        
        hidecontrollabel.setIcon(icon2);  
        MasterlistMenuPanel.setVisible(false);
        ArchiveMenuPanel.setVisible(false);
        TransferoutMenuPanel.setVisible(false);
        TransferinMenuPanel.setVisible(false);  
        } else {
        hidecontrollabel.setIcon(icon1);
        MasterlistMenuPanel.setVisible(true);
        ArchiveMenuPanel.setVisible(true);
        TransferoutMenuPanel.setVisible(true);
        TransferinMenuPanel.setVisible(true);  
        }
        
        
    }//GEN-LAST:event_hideControlMouseClicked

    private void exportBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBTActionPerformed
  sfx.playSound2(clip);
        export export = new export();
        export.setVisible(true);
        export.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_exportBTActionPerformed

    private void importBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importBTActionPerformed
        sfx.playSound2(clip); 
        excel excel = new excel(this);
        excel.setVisible(true);
    }//GEN-LAST:event_importBTActionPerformed

    private void searchTXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchTXTCaretUpdate
        searchMasterlist();
    }//GEN-LAST:event_searchTXTCaretUpdate

    private void searchTXT4CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchTXT4CaretUpdate
        searchArchive();
    }//GEN-LAST:event_searchTXT4CaretUpdate

    private void searchTXT3CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchTXT3CaretUpdate
        searchTransferout();
    }//GEN-LAST:event_searchTXT3CaretUpdate

    private void searchTXT2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchTXT2CaretUpdate
        searchTransferin();
    }//GEN-LAST:event_searchTXT2CaretUpdate

    private void rowdefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rowdefActionPerformed
       sfx.playSound2(clip);
        
        int plus = 25;
        
        rowheightnum.setText(Integer.toString(plus)); 
        MasterlistTable.setRowHeight(plus);
        ArchiveTable.setRowHeight(plus);
        TransferinTable.setRowHeight(plus);
        TransferoutTable.setRowHeight(plus);
    }//GEN-LAST:event_rowdefActionPerformed

    private void fontdefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontdefActionPerformed
        sfx.playSound2(clip);
        Font masterlistfont = MasterlistTable.getFont();
        
        int font = Integer.parseInt(fontsizeTXT.getText());
        font = 12;
        fontsizeTXT.setText(Integer.toString(font));
        
        Font newFont = new Font(masterlistfont.getName(), masterlistfont.getStyle(), font); 
        MasterlistTable.setFont(newFont);
        ArchiveTable.setFont(newFont);
        TransferinTable.setFont(newFont);
        TransferoutTable.setFont(newFont);
    }//GEN-LAST:event_fontdefActionPerformed

    private void savepasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savepasswordActionPerformed
        
        sfx.playSound2(clip);
        
        String newusername = newusernameTXT.getText();
        String newpassword = newpasswordTXT.getText();
        String confirmpassword = confirmpasswordTXT.getText();

        // Check if newusername, newpassword, and confirmpassword are not null
        if (newusername.isEmpty() || newpassword.isEmpty() || confirmpassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (newpassword.equals(confirmpassword)) {
                // Run the database update code
                String sqlUpdate = "UPDATE login SET username=?, password=? WHERE id=1";
                try {
                    PreparedStatement preparedStatement = con.prepareStatement(sqlUpdate);
                    preparedStatement.setString(1, newusername);
                    preparedStatement.setString(2, newpassword);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this,  "Update successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                        newusernameTXT.setText("");
                        newpasswordTXT.setText("");
                        confirmpasswordTXT.setText("");

                        passpanel.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "Update failed", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
       
    }//GEN-LAST:event_savepasswordActionPerformed

    private void refreshBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBTActionPerformed
        if (start ==2){
            start++;
        } else {
            sfx.playSound2(clip);
        }

        updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);

        refreshTable();
        refreshArchive();
        refreshtransin();
        refreshtransout();
    }//GEN-LAST:event_refreshBTActionPerformed

    private void AddStudentBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStudentBTActionPerformed
        
        if (studentFrame == null || !studentFrame.isVisible()) {
            studentFrame = new addStudent(this);
            studentFrame.setVisible(true);
        }
        /* if theres already a JFRAME (addStudent.java) running.
        it will prevent making a duplicate JFRAME
        until you close it and run it again */

        //Activate refreshButton
        refreshBTActionPerformed(evt);

    }//GEN-LAST:event_AddStudentBTActionPerformed

    private void editBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTActionPerformed
         sfx.playSound2(clip);
        EditButton();
        
    }//GEN-LAST:event_editBTActionPerformed

    private void TransferOutBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferOutBTActionPerformed
          sfx.playSound2(clip);
        transferOutButton();
        DeleteButton2();
        refreshBTActionPerformed(evt);
    }//GEN-LAST:event_TransferOutBTActionPerformed

    private void RemoveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveBTActionPerformed
      
        sfx.playSound2(clip);
// Prompt for username and password
    String enteredUsername = JOptionPane.showInputDialog(
            null,
            "Enter username:",
            "Username Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    String enteredPassword = JOptionPane.showInputDialog(
            null,
            "Enter password:",
            "Password Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    // Check if the credentials are correct
    if (isCredentialsCorrect(enteredUsername, enteredPassword)) {
        // Credentials are correct, proceed with the DeleteButton and refreshBTActionPerformed
        DeleteButton();
        
       
        refreshBTActionPerformed(evt);
    } else {
        // Credentials are incorrect, display an error message
        JOptionPane.showMessageDialog(
                null,
                "Incorrect username or password. Removal canceled.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_RemoveBTActionPerformed

    private void resheshBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resheshBT1ActionPerformed
 sfx.playSound2(clip);
        refreshBTActionPerformed(evt);
    }//GEN-LAST:event_resheshBT1ActionPerformed

    private void restoreBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBTActionPerformed
         sfx.playSound2(clip);
        // Prompt for username and password
    String enteredUsername = JOptionPane.showInputDialog(
            null,
            "Enter username:",
            "Username Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    String enteredPassword = JOptionPane.showInputDialog(
            null,
            "Enter password:",
            "Password Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    // Check if the credentials are correct
    if (isCredentialsCorrect(enteredUsername, enteredPassword)) {
        // Credentials are correct, proceed with the archiveRestore and refreshBTActionPerformed
        archiveRestore();
        refreshBTActionPerformed(evt);
    } else {
        // Credentials are incorrect, display an error message
        JOptionPane.showMessageDialog(
                null,
                "Incorrect username or password. Restoration canceled.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_restoreBTActionPerformed

    private void resheshBT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resheshBT3ActionPerformed
          refreshBTActionPerformed(evt);
    }//GEN-LAST:event_resheshBT3ActionPerformed

    private void TransferoutRestoreBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransferoutRestoreBTActionPerformed
         sfx.playSound2(clip);

        // Prompt for username and password
    String enteredUsername = JOptionPane.showInputDialog(
            null,
            "Enter username:",
            "Username Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    String enteredPassword = JOptionPane.showInputDialog(
            null,
            "Enter password:",
            "Password Confirmation",
            JOptionPane.PLAIN_MESSAGE
    );

    // Check if the credentials are correct
    if (isCredentialsCorrect(enteredUsername, enteredPassword)) {
        // Credentials are correct, proceed with the TransferoutRestore
        TransferoutRestore();
        
    } else {
        // Credentials are incorrect, display an error message
        JOptionPane.showMessageDialog(
                null,
                "Incorrect username or password. Transferout restoration canceled.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_TransferoutRestoreBTActionPerformed

    private void resheshBT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resheshBT2ActionPerformed
       
        refreshBTActionPerformed(evt);
    }//GEN-LAST:event_resheshBT2ActionPerformed

    private void aboutusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutusBTActionPerformed
        layers.removeAll();
        layers.add(AboutUs);
        layers.repaint();
        layers.revalidate();

        sfx.playSound2(clip);

        sfx.playSound2(clip);
    }//GEN-LAST:event_aboutusBTActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AboutUs;
    private SystemOtherComps.PH_Button AddStudentBT;
    private javax.swing.JPanel Archive;
    private javax.swing.JPanel ArchiveMenuPanel;
    private javax.swing.JPanel ArchiveSlide;
    private javax.swing.JTable ArchiveTable;
    private javax.swing.JScrollPane ArchiveTableScrollPanel;
    private javax.swing.JButton BackupBT;
    private javax.swing.JPanel ExportPanel;
    private javax.swing.JPanel Help;
    private javax.swing.JPanel HelpLabel;
    private javax.swing.JPanel HelpLabel1;
    private javax.swing.JPanel Masterlist;
    private javax.swing.JPanel MasterlistMenuPanel;
    private javax.swing.JPanel MasterlistSlide;
    private javax.swing.JTable MasterlistTable;
    public javax.swing.JScrollPane MasterlistTableScrollPanel;
    private javax.swing.JPanel MenuSlide;
    private javax.swing.JLabel Menuslideclick;
    private javax.swing.JPanel Overview;
    private SystemOtherComps.PH_Button RemoveBT;
    private javax.swing.JPanel Settings;
    private javax.swing.JPanel SettingsSlide;
    private SystemOtherComps.PH_Button TransferOutBT;
    private javax.swing.JPanel Transferin;
    private javax.swing.JPanel TransferinMenuPanel;
    private javax.swing.JPanel TransferinSlide;
    private javax.swing.JTable TransferinTable;
    private javax.swing.JScrollPane TransferinTableScrollPanel;
    private javax.swing.JPanel Transferout;
    private javax.swing.JPanel TransferoutMenuPanel;
    private SystemOtherComps.PH_Button TransferoutRestoreBT;
    private javax.swing.JPanel TransferoutSlide;
    private javax.swing.JTable TransferoutTable;
    public javax.swing.JScrollPane TransferoutTableScrollPanel;
    private javax.swing.JButton UpdateBT;
    private javax.swing.JButton aboutusBT;
    private javax.swing.JButton archiveBT;
    private javax.swing.JLabel archiveLBBT;
    private javax.swing.JPanel archivePLBT;
    private SystemOtherComps.PH_Panel archiveRP;
    private javax.swing.JButton changepasswordBT;
    private javax.swing.JTextField confirmpasswordTXT;
    private javax.swing.JLabel credentialslabel;
    private javax.swing.JLabel credentialslabel1;
    private javax.swing.JLabel credentialslabel2;
    private javax.swing.JLabel credentialslabel3;
    private javax.swing.JLabel credentialslabel4;
    private javax.swing.JLabel credentialslabel5;
    private Frame.CurvesPanel2 curvesPanel21;
    private SystemOtherComps.PH_Button editBT;
    private SystemOtherComps.PH_Button exportBT;
    private SystemOtherComps.PH_Button fontdef;
    private javax.swing.JButton fontdown;
    private javax.swing.JPanel fontpanel;
    private javax.swing.JButton fontsizeBT;
    private javax.swing.JTextField fontsizeTXT;
    private javax.swing.JButton fontup;
    private javax.swing.JButton helpBT;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JPanel helpPanel1;
    private javax.swing.JLabel helplable;
    private javax.swing.JLabel helplable1;
    private javax.swing.JScrollPane helpscroll;
    private javax.swing.JScrollPane helpscroll1;
    private javax.swing.JPanel hideControl;
    private javax.swing.JLabel hidecontrollabel;
    private javax.swing.JButton hidetitleBT;
    private SystemOtherComps.PH_Button importBT;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLayeredPane layers;
    private javax.swing.JLabel masterlistLBBT;
    private javax.swing.JPanel masterlistPLBT;
    private SystemOtherComps.PH_Panel masterlistRP;
    private javax.swing.JPanel menu;
    private javax.swing.JTextField newpasswordTXT;
    private javax.swing.JTextField newusernameTXT;
    private SystemOtherComps.PH_Label pH_Label2;
    private SystemOtherComps.PH_Label pH_Label3;
    private SystemOtherComps.PH_Label pH_Label4;
    private SystemOtherComps.PH_Label pH_Label5;
    private javax.swing.JPanel passpanel;
    private SystemOtherComps.PH_Button refreshBT;
    private javax.swing.JLabel registrar_name1;
    private SystemOtherComps.PH_Button resheshBT1;
    private SystemOtherComps.PH_Button resheshBT2;
    private SystemOtherComps.PH_Button resheshBT3;
    private SystemOtherComps.PH_Button restoreBT;
    private javax.swing.JButton rowBT;
    private javax.swing.JButton rowadd;
    private SystemOtherComps.PH_Button rowdef;
    private javax.swing.JTextField rowheightnum;
    private javax.swing.JPanel rowpanel;
    private javax.swing.JButton rowreduce;
    private SystemOtherComps.PH_Button savepassword;
    private SystemOtherComps.PH_TextField searchTXT;
    private SystemOtherComps.PH_TextField searchTXT2;
    private SystemOtherComps.PH_TextField searchTXT3;
    private SystemOtherComps.PH_TextField searchTXT4;
    private javax.swing.JLabel settingsLBBT;
    private javax.swing.JPanel settingsPLBT;
    private javax.swing.JPanel slidePanel;
    private javax.swing.JComboBox<String> sortBox;
    private javax.swing.JComboBox<String> sortBox2;
    private javax.swing.JComboBox<String> sortBox3;
    private javax.swing.JComboBox<String> sortBox4;
    private javax.swing.JLabel sortlabel;
    private javax.swing.JLabel sortlabel1;
    private javax.swing.JLabel sortlabel10;
    private javax.swing.JLabel sortlabel2;
    private javax.swing.JLabel sortlabel3;
    private javax.swing.JLabel sortlabel4;
    private javax.swing.JLabel sortlabel5;
    private javax.swing.JLabel sortlabel6;
    private javax.swing.JLabel sortlabel7;
    private javax.swing.JLabel sortlabel8;
    private javax.swing.JLabel sortlabel9;
    private javax.swing.JLabel studentnum;
    private javax.swing.JLabel studentnum2;
    private javax.swing.JLabel studentnum3;
    private javax.swing.JLabel studentnum4;
    private javax.swing.JScrollPane tablecontentsscroll1;
    private javax.swing.JScrollPane tablecontentsscroll2;
    private javax.swing.JScrollPane tablecontentsscroll3;
    private javax.swing.JScrollPane tablecontentsscroll4;
    private javax.swing.JScrollPane tablecontentsscroll5;
    private toggle.ToggleButton toggleButton1;
    private javax.swing.JLabel transferinLBBT;
    private javax.swing.JPanel transferinPLBT;
    private SystemOtherComps.PH_Panel transferinRP;
    private javax.swing.JLabel transferinRPlabel;
    private javax.swing.JLabel transferinRPlabel1;
    private javax.swing.JLabel transferinRPlabel2;
    private javax.swing.JLabel transferinRPlabel3;
    private javax.swing.JLabel transferoutLBBT;
    private javax.swing.JPanel transferoutPLBT;
    private SystemOtherComps.PH_Panel transferoutRP;
    private assets.YearComboBox2 yearsorter;
    private assets.YearComboBox2 yearsorterTransferin;
    private assets.YearComboBox2 yearsorterTransferout;
    // End of variables declaration//GEN-END:variables
//////////////////////////////////////////////////////////////    
//////////////////////////////////////////////////////////////    
/////////                METHODS            //////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
    
    



//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //BUTTON FUNCTIONS
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   
    
    public void EditButton(){
        int selectedRow = MasterlistTable.getSelectedRow();
        String syear1Value = ""; 
        String syear2Value = ""; 
        String bday = "";
        String bmonth = "";
        String byear = "";
        boolean Bcertificate = false;
        boolean sf9 = false;
        boolean sf10 = false;
        String g6 = "";
        String g10 = "";
        String g12 = "";
        String g6year = "";
        String g10year = "";
        String g12year = "";
        String desc = "";
        String path1="";
        String path2="";
        String path3="";
        String Address="";
        String imName1="";
        String imName2="";
        String imName3="";
        
        
    if (selectedRow != -1) {
        String studentID = MasterlistTable.getValueAt(selectedRow, 0).toString();
        
        
        
        String sql = "SELECT `syear1`, `syear2`,`bday` ,`bmonth` ,`byear`, `Bcertificate`, `sf9`, `sf10`, `g6`, `g10`, `g12`, `g6year`, `g10year`, `g12year`, `description`, `imagePath1`, `imagePath2`, `imagePath3`, `address`, `imageName1`, `imageName2`, `imageName3` FROM `test` WHERE lrn = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                syear1Value = rs.getString("syear1");
                syear2Value = rs.getString("syear2");
                bday = rs.getString("bday");
                bmonth =rs.getString("bmonth");  
                byear = rs.getString("byear");
                Bcertificate = rs.getBoolean("Bcertificate");
                sf9 = rs.getBoolean("sf9");
                sf10 = rs.getBoolean("sf10");
                g6 = rs.getString("g6");
                g10 = rs.getString("g10");
                g12 = rs.getString("g12");
                g6year = rs.getString("g6year");
                g10year = rs.getString("g10year");
                g12year = rs.getString("g12year");
                desc = rs.getString("description");
                path1  = rs.getString("imagePath1");
                path2  = rs.getString("imagePath2");
                path3  = rs.getString("imagePath3");
                Address =rs.getString("address");
                imName1 =rs.getString("imageName1");
                imName2 =rs.getString("imageName2");
                imName3 =rs.getString("imageName3");
                
                
            } else {
                // Handle the case where no rows were found
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        
        int index = MasterlistTable.getSelectedRow();
        TableModel model = MasterlistTable.getModel();
        String Ln = model.getValueAt(index, 1).toString();
        String Fn = model.getValueAt(index, 2).toString();
        String Mn = model.getValueAt(index, 3).toString();
        String Lrn = model.getValueAt(index, 0).toString();
        String Con = model.getValueAt(index, 8).toString();
        String Em = model.getValueAt(index, 9).toString();
        String Se = model.getValueAt(index, 5).toString();
        String Gr = model.getValueAt(index, 6).toString();


        
        studentEdit.setVisible(true);
        studentEdit.pack();
        studentEdit.setLocationRelativeTo(null);
        studentEdit.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
        
        
        
        if (bmonth.equals("01")){
            bmonth = "01-January";
        } else if (bmonth.equals("02")){
            bmonth = "02-February";
        } else if (bmonth.equals("03")){
            bmonth = "03-March";
        } else if (bmonth.equals("04")){
            bmonth = "04-April";
        } else if (bmonth.equals("05")){
            bmonth = "05-May";
        } else if (bmonth.equals("06")){
            bmonth = "06-June";
        } else if (bmonth.equals("07")){
            bmonth = "07-July";
        } else if (bmonth.equals("08")){
            bmonth = "08-August";
        } else if (bmonth.equals("09")){
            bmonth = "09-September";
        } else if (bmonth.equals("10")){
            bmonth = "10-October";
        } else if (bmonth.equals("11")){
           bmonth = "11-November";
        } else if (bmonth.equals("12")){
            bmonth = "12-December";
        } else {
         bmonth = "haha";
        } 
        System.out.println(bmonth);
        
        studentEdit.imagePath1.setText("");
        studentEdit.imagePath2.setText("");
        studentEdit.imagePath3.setText("");
        
        studentEdit.imageName1.setText("");
        studentEdit.imageName2.setText("");
        studentEdit.imageName3.setText("");
        
        
        studentEdit.lastname.setText(Ln);
        studentEdit.firstname.setText(Fn);
        studentEdit.middlename.setText(Mn);
        studentEdit.lrn.setText(Lrn);
        studentEdit.contact.setText(Con);
        studentEdit.email.setText(Em);
        studentEdit.sex.setSelectedItem(Se);
        
        
        
        if (Gr.equals("0")){
        studentEdit.grade.setSelectedItem("Kindergarten");
        } else {
        studentEdit.grade.setSelectedItem(Gr);
        }
        
        
        studentEdit.Year1.setText(syear1Value);
        studentEdit.Year2.setText(syear2Value);
        studentEdit.day.setSelectedItem(bday);
        studentEdit.month.setSelectedItem(bmonth);
        studentEdit.year.setSelectedItem(byear);
        studentEdit.BirthCertificateCB.setSelected(Bcertificate);
        studentEdit.sf9CB.setSelected(sf9);
        studentEdit.sf10CB.setSelected(sf10);
        studentEdit.grade6.setText(g6);
        studentEdit.grade10.setText(g10);
        studentEdit.grade12.setText(g12);
        studentEdit.grade6year.setText(g6year);
        studentEdit.grade10year.setText(g10year);
        studentEdit.grade12year.setText(g12year);
        studentEdit.Description.setText(desc);
        studentEdit.lrn1.setText(Lrn);
       
        
        studentEdit.address.setText(Address);
        
        
        int characterCount = Lrn.length();

        studentEdit.wordcount.setText("Number of Characters: " + characterCount);
        
       
        int characterCount2 = Con.length();

        studentEdit.wordcount1.setText("Number of Characters: " + characterCount2);
        
   
        studentEdit.imageView1.setIcon(null);
        studentEdit.imageView2.setIcon(null);
        studentEdit.imageView3.setIcon(null);
        
        
        if (Bcertificate == true){
        studentEdit.LoadImageID1();
        studentEdit.imagePath1.setText(path1);
        studentEdit.imagePath1.setColumns(1);
        
        studentEdit.imageName1.setText(imName1);
        studentEdit.imageName1.setColumns(1);
        
        }
        if (sf9 == true){
        studentEdit.LoadImageID2();
        studentEdit.imagePath2.setText(path2);
        studentEdit.imagePath2.setColumns(1);
        
        studentEdit.imageName2.setText(imName2);
        studentEdit.imageName2.setColumns(1);
        }
         if (sf10 == true){
        studentEdit.LoadImageID3();
        studentEdit.imagePath3.setText(path3);
        studentEdit.imagePath3.setColumns(1);
        
        studentEdit.imageName3.setText(imName3);
        studentEdit.imageName3.setColumns(1);
        }
         
   
        
        //bmonth="";
    }
    
    
    public void EditButtonTransferout(){
        int selectedRow = TransferoutTable.getSelectedRow();
        String syear1Value = ""; 
        String syear2Value = ""; 
        String bday = "";
        String bmonth = "";
        String byear = "";
        boolean Bcertificate = false;
        boolean sf9 = false;
        boolean sf10 = false;
        String g6 = "";
        String g10 = "";
        String g12 = "";
        String g6year = "";
        String g10year = "";
        String g12year = "";
        String desc = "";
        String path1="";
        String path2="";
        String path3="";
        String Address="";
        String imName1="";
        String imName2="";
        String imName3="";
        
        
    if (selectedRow != -1) {
        String studentID = TransferoutTable.getValueAt(selectedRow, 0).toString();
        
        
        
        String sql = "SELECT `syear1`, `syear2`,`bday` ,`bmonth` ,`byear`, `Bcertificate`, `sf9`, `sf10`, `g6`, `g10`, `g12`, `g6year`, `g10year`, `g12year`, `description`, `imagePath1`, `imagePath2`, `imagePath3`, `address`, `imageName1`, `imageName2`, `imageName3` FROM `transferout` WHERE lrn = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                syear1Value = rs.getString("syear1");
                syear2Value = rs.getString("syear2");
                bday = rs.getString("bday");
                bmonth =rs.getString("bmonth");  
                byear = rs.getString("byear");
                Bcertificate = rs.getBoolean("Bcertificate");
                sf9 = rs.getBoolean("sf9");
                sf10 = rs.getBoolean("sf10");
                g6 = rs.getString("g6");
                g10 = rs.getString("g10");
                g12 = rs.getString("g12");
                g6year = rs.getString("g6year");
                g10year = rs.getString("g10year");
                g12year = rs.getString("g12year");
                desc = rs.getString("description");
                path1  = rs.getString("imagePath1");
                path2  = rs.getString("imagePath2");
                path3  = rs.getString("imagePath3");
                Address =rs.getString("address");
                imName1 =rs.getString("imageName1");
                imName2 =rs.getString("imageName2");
                imName3 =rs.getString("imageName3");
                
                
            } else {
                // Handle the case where no rows were found
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        
        int index = TransferoutTable.getSelectedRow();
        TableModel model = TransferoutTable.getModel();
        String Ln = model.getValueAt(index, 1).toString();
        String Fn = model.getValueAt(index, 2).toString();
        String Mn = model.getValueAt(index, 3).toString();
        String Lrn = model.getValueAt(index, 0).toString();
        String Con = model.getValueAt(index, 8).toString();
        String Em = model.getValueAt(index, 9).toString();
        String Se = model.getValueAt(index, 5).toString();
        String Gr = model.getValueAt(index, 6).toString();


        
        editStudentTransferout.setVisible(true);
        editStudentTransferout.pack();
        editStudentTransferout.setLocationRelativeTo(null);
        editStudentTransferout.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
        
        
        
        if (bmonth.equals("01")){
            bmonth = "01-January";
        } else if (bmonth.equals("02")){
            bmonth = "02-February";
        } else if (bmonth.equals("03")){
            bmonth = "03-March";
        } else if (bmonth.equals("04")){
            bmonth = "04-April";
        } else if (bmonth.equals("05")){
            bmonth = "05-May";
        } else if (bmonth.equals("06")){
            bmonth = "06-June";
        } else if (bmonth.equals("07")){
            bmonth = "07-July";
        } else if (bmonth.equals("08")){
            bmonth = "08-August";
        } else if (bmonth.equals("09")){
            bmonth = "09-September";
        } else if (bmonth.equals("10")){
            bmonth = "10-October";
        } else if (bmonth.equals("11")){
           bmonth = "11-November";
        } else if (bmonth.equals("12")){
            bmonth = "12-December";
        } else {
         bmonth = "haha";
        } 
        System.out.println(bmonth);
        
        
        
        
        java.util.Date d = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String dd = sdf.format(d);
        int tonum =Integer.parseInt(dd);
        int merge = tonum + 1;
        String dd2 = Integer.toString(merge);

        editStudentTransferout.Year1.setText(dd);
        editStudentTransferout.Year2.setText(dd2);
    
        editStudentTransferout.imagePath1.setText("");
        editStudentTransferout.imagePath2.setText("");
        editStudentTransferout.imagePath3.setText("");
        
        editStudentTransferout.imageName1.setText("");
        editStudentTransferout.imageName2.setText("");
        editStudentTransferout.imageName3.setText("");
        
        
        editStudentTransferout.lastname.setText(Ln);
        editStudentTransferout.firstname.setText(Fn);
        editStudentTransferout.middlename.setText(Mn);
        editStudentTransferout.lrn.setText(Lrn);
        editStudentTransferout.contact.setText(Con);
        editStudentTransferout.email.setText(Em);
        editStudentTransferout.sex.setSelectedItem(Se);
        
        if (Gr.equals("0")){
        editStudentTransferout.grade.setSelectedItem("Kindergarten");
        } else {
        editStudentTransferout.grade.setSelectedItem(Gr);
        }
      
        editStudentTransferout.day.setSelectedItem(bday);
        editStudentTransferout.month.setSelectedItem(bmonth);
        editStudentTransferout.year.setSelectedItem(byear);
        editStudentTransferout.BirthCertificateCB.setSelected(Bcertificate);
        editStudentTransferout.sf9CB.setSelected(sf9);
        editStudentTransferout.sf10CB.setSelected(sf10);
        editStudentTransferout.grade6.setText(g6);
        editStudentTransferout.grade10.setText(g10);
        editStudentTransferout.grade12.setText(g12);
        editStudentTransferout.grade6year.setText(g6year);
        editStudentTransferout.grade10year.setText(g10year);
        editStudentTransferout.grade12year.setText(g12year);
        editStudentTransferout.Description.setText(desc);
        editStudentTransferout.lrn1.setText(Lrn);
       
        
        editStudentTransferout.address.setText(Address);
        
        
        int characterCount = Lrn.length();

        editStudentTransferout.wordcount.setText("Number of Characters: " + characterCount);
        
       
        int characterCount2 = Con.length();

        editStudentTransferout.wordcount1.setText("Number of Characters: " + characterCount2);
        
   
        editStudentTransferout.imageView1.setIcon(null);
        editStudentTransferout.imageView2.setIcon(null);
        editStudentTransferout.imageView3.setIcon(null);
        
        
        if (Bcertificate == true){
        editStudentTransferout.LoadImageID1();
        editStudentTransferout.imagePath1.setText(path1);
        editStudentTransferout.imagePath1.setColumns(1);
        
        editStudentTransferout.imageName1.setText(imName1);
        editStudentTransferout.imageName1.setColumns(1);
        
        }
        if (sf9 == true){
        editStudentTransferout.LoadImageID2();
        editStudentTransferout.imagePath2.setText(path2);
        editStudentTransferout.imagePath2.setColumns(1);
        
        editStudentTransferout.imageName2.setText(imName2);
        editStudentTransferout.imageName2.setColumns(1);
        }
         if (sf10 == true){
        editStudentTransferout.LoadImageID3();
        editStudentTransferout.imagePath3.setText(path3);
        editStudentTransferout.imagePath3.setColumns(1);
        
        editStudentTransferout.imageName3.setText(imName3);
        editStudentTransferout.imageName3.setColumns(1);
        }
         
         
        int selectedRow1 = TransferoutTable.getSelectedRow();
        editStudentTransferout.rowNum.setText(String.valueOf(selectedRow1));
         
         
   
        
        //bmonth="";
    }
    
    

    
    
    public void ViewButton(){
        int selectedRow = MasterlistTable.getSelectedRow();
        String syear1Value = ""; 
        String syear2Value = ""; 
        String bday = "";
        String bmonth = "";
        String byear = "";
        boolean Bcertificate = false;
        boolean sf9 = false;
        boolean sf10 = false;
        String g6 = "";
        String g10 = "";
        String g12 = "";
        String g6year = "";
        String g10year = "";
        String g12year = "";
        String Syear = "";
        String birthday = "";
        String desc = "";
        boolean transin = false;
        String Addr = "";
        String path1="";
        String path2="";
        String path3="";
        
        
    if (selectedRow != -1) {
        String studentID = MasterlistTable.getValueAt(selectedRow, 0).toString();
        
        
        
        String sql = "SELECT `syear1`, `syear2`,`bday` ,`bmonth` ,`byear`, `Bcertificate`, `sf9`, `sf10`, `g6`, `g10`, `g12`, `g6year`, `g10year`, `g12year`, `schoolyear`, `birthday`, `description`, `transferin`, `address`, `imageName1`, `imageName2` , `imageName3` FROM `test` WHERE lrn = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                syear1Value = rs.getString("syear1");
                syear2Value = rs.getString("syear2");
                bday = rs.getString("bday");
                bmonth =rs.getString("bmonth");  
                byear = rs.getString("byear");
                Bcertificate = rs.getBoolean("Bcertificate");
                sf9 = rs.getBoolean("sf9");
                sf10 = rs.getBoolean("sf10");
                g6 = rs.getString("g6");
                g10 = rs.getString("g10");
                g12 = rs.getString("g12");
                g6year = rs.getString("g6year");
                g10year = rs.getString("g10year");
                g12year = rs.getString("g12year");
                Syear = rs.getString("schoolyear");
                birthday = rs.getString("birthday");
                desc = rs.getString("description");
                transin = rs.getBoolean("transferin");
                Addr = rs.getString("address");
                path1 = rs.getString("imageName1");
                path2 = rs.getString("imageName2");
                path3 = rs.getString("imageName3");
                
                
                
            } else {
                // Handle the case where no rows were found
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        
        int index = MasterlistTable.getSelectedRow();
        TableModel model = MasterlistTable.getModel();
        String Ln = model.getValueAt(index, 1).toString();
        String Fn = model.getValueAt(index, 2).toString();
        String Mn = model.getValueAt(index, 3).toString();
        String Lrn = model.getValueAt(index, 0).toString();
        String Con = model.getValueAt(index, 8).toString();
        String Em = model.getValueAt(index, 9).toString();
        String Se = model.getValueAt(index, 5).toString();
        String Gr = model.getValueAt(index, 6).toString();


        
        studentView.setVisible(true);
        studentView.pack();
        studentView.setLocationRelativeTo(null);

        
        
        
        
       
        
        
        
        studentView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        studentView.lastname.setText(Ln);
        studentView.firstname.setText(Fn);
        studentView.middlename.setText(Mn);
        studentView.lrn.setText(Lrn);
        studentView.contact.setText(Con);
        studentView.email.setText(Em);
        studentView.sex.setText(Se);
        studentView.grade.setText(Gr);
        studentView.schoolyear.setText(syear1Value);
        studentView.birthday.setText(bmonth);
     
        studentView.BirthCertificateCB.setSelected(Bcertificate);
        studentView.sf9CB.setSelected(sf9);
        studentView.sf10CB.setSelected(sf10);
        
        studentView.birthday.setText(birthday);
        studentView.schoolyear.setText(Syear);
        studentView.Description.setText(desc);
        
         studentView.grade6view.setText(g6year);
        studentView.grade10view.setText(g10year);
        
        studentView.TransferInCB.setSelected(transin);
        studentView.address.setText(Addr);
     
       
        studentView.imageView1.setIcon(null);
        studentView.imageView2.setIcon(null);
        studentView.imageView3.setIcon(null);
        
        studentView.imagePath1.setText("");
        studentView.imagePath2.setText("");
        studentView.imagePath3.setText("");
        
         if (Bcertificate == true){
        studentView.LoadImageID1();
        studentView.imagePath1.setText(path1);
        studentView.imagePath1.setColumns(1);
        
        }
        if (sf9 == true){
        studentView.LoadImageID2();
        studentView.imagePath2.setText(path2);
        studentView.imagePath2.setColumns(1);
        }
         if (sf10 == true){
        studentView.LoadImageID3();
        studentView.imagePath3.setText(path3);
        studentView.imagePath3.setColumns(1);
        }

        

    }
    
    
    public void ViewButtonTransferin(){
        int selectedRow = TransferinTable.getSelectedRow();
        String syear1Value = ""; 
        String syear2Value = ""; 
        String bday = "";
        String bmonth = "";
        String byear = "";
        boolean Bcertificate = false;
        boolean sf9 = false;
        boolean sf10 = false;
        String g6 = "";
        String g10 = "";
        String g12 = "";
        String g6year = "";
        String g10year = "";
        String g12year = "";
        String Syear = "";
        String birthday = "";
        String desc = "";
        boolean transin = false;
        String Addr = "";
        String path1="";
        String path2="";
        String path3="";
        
        
    if (selectedRow != -1) {
        String studentID = TransferinTable.getValueAt(selectedRow, 0).toString();
        
        
        
        String sql = "SELECT `syear1`, `syear2`,`bday` ,`bmonth` ,`byear`, `Bcertificate`, `sf9`, `sf10`, `g6`, `g10`, `g12`, `g6year`, `g10year`, `g12year`, `tyear`, `birthday`, `description`, `transferin`, `address`, `imageName1`, `imageName2` , `imageName3` FROM `transferin` WHERE lrn = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                syear1Value = rs.getString("syear1");
                syear2Value = rs.getString("syear2");
                bday = rs.getString("bday");
                bmonth =rs.getString("bmonth");  
                byear = rs.getString("byear");
                Bcertificate = rs.getBoolean("Bcertificate");
                sf9 = rs.getBoolean("sf9");
                sf10 = rs.getBoolean("sf10");
                g6 = rs.getString("g6");
                g10 = rs.getString("g10");
                g12 = rs.getString("g12");
                g6year = rs.getString("g6year");
                g10year = rs.getString("g10year");
                g12year = rs.getString("g12year");
                Syear = rs.getString("tyear");
                birthday = rs.getString("birthday");
                desc = rs.getString("description");
                transin = rs.getBoolean("transferin");
                Addr = rs.getString("address");
                path1 = rs.getString("imageName1");
                path2 = rs.getString("imageName2");
                path3 = rs.getString("imageName3");
                
                
                
                
                
            } else {
                // Handle the case where no rows were found
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        
        int index = TransferinTable.getSelectedRow();
        TableModel model = TransferinTable.getModel();
        String Ln = model.getValueAt(index, 1).toString();
        String Fn = model.getValueAt(index, 2).toString();
        String Mn = model.getValueAt(index, 3).toString();
        String Lrn = model.getValueAt(index, 0).toString();
        String Con = model.getValueAt(index, 8).toString();
        String Em = model.getValueAt(index, 9).toString();
        String Se = model.getValueAt(index, 5).toString();
        String Gr = model.getValueAt(index, 6).toString();


        
        viewStudentTransferin.setVisible(true);
        viewStudentTransferin.pack();
        viewStudentTransferin.setLocationRelativeTo(null);

        
        
        System.out.println(Bcertificate);
        
        viewStudentTransferin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        viewStudentTransferin.lastname.setText(Ln);
        viewStudentTransferin.firstname.setText(Fn);
        viewStudentTransferin.middlename.setText(Mn);
        viewStudentTransferin.lrn.setText(Lrn);
        viewStudentTransferin.contact.setText(Con);
        viewStudentTransferin.email.setText(Em);
        viewStudentTransferin.sex.setText(Se);
        viewStudentTransferin.birthday.setText(bmonth);
        viewStudentTransferin.BirthCertificateCB.setSelected(Bcertificate);
        viewStudentTransferin.sf9CB.setSelected(sf9);
        viewStudentTransferin.sf10CB.setSelected(sf10);
        viewStudentTransferin.birthday.setText(birthday);  
        viewStudentTransferin.Description.setText(desc);
        
        viewStudentTransferin.address.setText(Addr);
        viewStudentTransferin.grade.setText(Gr);
        viewStudentTransferin.schoolyear.setText(Syear);
        
       
     
       
        viewStudentTransferin.imageView1.setIcon(null);
        viewStudentTransferin.imageView2.setIcon(null);
        viewStudentTransferin.imageView3.setIcon(null);
        
        viewStudentTransferin.imagePath1.setText("");
        viewStudentTransferin.imagePath2.setText("");
        viewStudentTransferin.imagePath3.setText("");
        
         if (Bcertificate == true){
        viewStudentTransferin.LoadImageID1();
        viewStudentTransferin.imagePath1.setText(path1);
        viewStudentTransferin.imagePath1.setColumns(1);
        
        }
        if (sf9 == true){
        viewStudentTransferin.LoadImageID2();
        viewStudentTransferin.imagePath2.setText(path2);
        viewStudentTransferin.imagePath2.setColumns(1);
        }
         if (sf10 == true){
        viewStudentTransferin.LoadImageID3();
        viewStudentTransferin.imagePath3.setText(path3);
        viewStudentTransferin.imagePath3.setColumns(1);
        }

        

    }
    
    
    
    public void ViewButtonTransferout(){
        int selectedRow = TransferoutTable.getSelectedRow();
        String syear1Value = ""; 
        String syear2Value = ""; 
        String bday = "";
        String bmonth = "";
        String byear = "";
        boolean Bcertificate = false;
        boolean sf9 = false;
        boolean sf10 = false;
        String g6 = "";
        String g10 = "";
        String g12 = "";
        String g6year = "";
        String g10year = "";
        String g12year = "";
        String Syear = "";
        String birthday = "";
        String desc = "";
        boolean transin = false;
        String Addr = "";
        String path1="";
        String path2="";
        String path3="";
        
        
    if (selectedRow != -1) {
        String studentID = TransferoutTable.getValueAt(selectedRow, 0).toString();
        
        
        
        String sql = "SELECT `syear1`, `syear2`,`bday` ,`bmonth` ,`byear`, `Bcertificate`, `sf9`, `sf10`, `g6`, `g10`, `g12`, `g6year`, `g10year`, `g12year`, `tyear`, `birthday`, `description`, `transferin`, `address`, `imageName1`, `imageName2` , `imageName3` FROM `transferout` WHERE lrn = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                syear1Value = rs.getString("syear1");
                syear2Value = rs.getString("syear2");
                bday = rs.getString("bday");
                bmonth =rs.getString("bmonth");  
                byear = rs.getString("byear");
                Bcertificate = rs.getBoolean("Bcertificate");
                sf9 = rs.getBoolean("sf9");
                sf10 = rs.getBoolean("sf10");
                g6 = rs.getString("g6");
                g10 = rs.getString("g10");
                g12 = rs.getString("g12");
                g6year = rs.getString("g6year");
                g10year = rs.getString("g10year");
                g12year = rs.getString("g12year");
                Syear = rs.getString("tyear");
                birthday = rs.getString("birthday");
                desc = rs.getString("description");
                transin = rs.getBoolean("transferin");
                Addr = rs.getString("address");
                path1 = rs.getString("imageName1");
                path2 = rs.getString("imageName2");
                path3 = rs.getString("imageName3");
                
                
                
                
                
            } else {
                // Handle the case where no rows were found
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        
        int index = TransferoutTable.getSelectedRow();
        TableModel model = TransferoutTable.getModel();
        String Ln = model.getValueAt(index, 1).toString();
        String Fn = model.getValueAt(index, 2).toString();
        String Mn = model.getValueAt(index, 3).toString();
        String Lrn = model.getValueAt(index, 0).toString();
        String Con = model.getValueAt(index, 8).toString();
        String Em = model.getValueAt(index, 9).toString();
        String Se = model.getValueAt(index, 5).toString();
        String Gr = model.getValueAt(index, 6).toString();


        
        viewStudentTransferout.setVisible(true);
        viewStudentTransferout.pack();
        viewStudentTransferout.setLocationRelativeTo(null);

        
        
        System.out.println(Bcertificate);
        
        viewStudentTransferout.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        viewStudentTransferout.lastname.setText(Ln);
        viewStudentTransferout.firstname.setText(Fn);
        viewStudentTransferout.middlename.setText(Mn);
        viewStudentTransferout.lrn.setText(Lrn);
        viewStudentTransferout.contact.setText(Con);
        viewStudentTransferout.email.setText(Em);
        viewStudentTransferout.sex.setText(Se);
        viewStudentTransferout.birthday.setText(bmonth);
        viewStudentTransferout.BirthCertificateCB.setSelected(Bcertificate);
        viewStudentTransferout.sf9CB.setSelected(sf9);
        viewStudentTransferout.sf10CB.setSelected(sf10);
        viewStudentTransferout.birthday.setText(birthday);  
        viewStudentTransferout.Description.setText(desc);
        
        viewStudentTransferout.address.setText(Addr);
        viewStudentTransferout.grade.setText(Gr);
        viewStudentTransferout.schoolyear.setText(Syear);
        
       
     
       
        viewStudentTransferout.imageView1.setIcon(null);
        viewStudentTransferout.imageView2.setIcon(null);
        viewStudentTransferout.imageView3.setIcon(null);
        
        viewStudentTransferout.imagePath1.setText("");
        viewStudentTransferout.imagePath2.setText("");
        viewStudentTransferout.imagePath3.setText("");
        
         if (Bcertificate == true){
        viewStudentTransferout.LoadImageID1();
        viewStudentTransferout.imagePath1.setText(path1);
        viewStudentTransferout.imagePath1.setColumns(1);
        
        }
        if (sf9 == true){
        viewStudentTransferout.LoadImageID2();
        viewStudentTransferout.imagePath2.setText(path2);
        viewStudentTransferout.imagePath2.setColumns(1);
        }
         if (sf10 == true){
        viewStudentTransferout.LoadImageID3();
        viewStudentTransferout.imagePath3.setText(path3);
        viewStudentTransferout.imagePath3.setColumns(1);
        }

        

    }
    
    
    
    
    
    public void ViewButtonArchive(){
        int selectedRow = ArchiveTable.getSelectedRow();
        String syear1Value = ""; 
        String syear2Value = ""; 
        String bday = "";
        String bmonth = "";
        String byear = "";
        boolean Bcertificate = false;
        boolean sf9 = false;
        boolean sf10 = false;
        String g6 = "";
        String g10 = "";
        String g12 = "";
        String g6year = "";
        String g10year = "";
        String g12year = "";
        String Syear = "";
        String birthday = "";
        String desc = "";
        boolean transin = false;
        String Addr = "";
        String path1="";
        String path2="";
        String path3="";
        
        
    if (selectedRow != -1) {
        String studentID = ArchiveTable.getValueAt(selectedRow, 0).toString();
        
        
        
        String sql = "SELECT `syear1`, `syear2`,`bday` ,`bmonth` ,`byear`, `Bcertificate`, `sf9`, `sf10`, `g6`, `g10`, `g12`, `g6year`, `g10year`, `g12year`, `schoolyear`, `birthday`, `description`, `transferin`, `address`, `imageName1`, `imageName2` , `imageName3` FROM `archive` WHERE lrn = ?";
        
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentID);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                syear1Value = rs.getString("syear1");
                syear2Value = rs.getString("syear2");
                bday = rs.getString("bday");
                bmonth =rs.getString("bmonth");  
                byear = rs.getString("byear");
                Bcertificate = rs.getBoolean("Bcertificate");
                sf9 = rs.getBoolean("sf9");
                sf10 = rs.getBoolean("sf10");
                g6 = rs.getString("g6");
                g10 = rs.getString("g10");
                g12 = rs.getString("g12");
                g6year = rs.getString("g6year");
                g10year = rs.getString("g10year");
                g12year = rs.getString("g12year");
                Syear = rs.getString("schoolyear");
                birthday = rs.getString("birthday");
                desc = rs.getString("description");
                transin = rs.getBoolean("transferin");
                Addr = rs.getString("address");
                path1 = rs.getString("imageName1");
                path2 = rs.getString("imageName2");
                path3 = rs.getString("imageName3");
                
                
                
                
                
            } else {
                // Handle the case where no rows were found
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        
        int index = ArchiveTable.getSelectedRow();
        TableModel model = ArchiveTable.getModel();
        String Ln = model.getValueAt(index, 1).toString();
        String Fn = model.getValueAt(index, 2).toString();
        String Mn = model.getValueAt(index, 3).toString();
        String Lrn = model.getValueAt(index, 0).toString();
        String Con = model.getValueAt(index, 8).toString();
        String Em = model.getValueAt(index, 9).toString();
        String Se = model.getValueAt(index, 5).toString();
        String Gr = model.getValueAt(index, 6).toString();


        
        viewStudentArchive.setVisible(true);
        viewStudentArchive.pack();
        viewStudentArchive.setLocationRelativeTo(null);

        
        
        
        
        viewStudentArchive.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        viewStudentArchive.lastname.setText(Ln);
        viewStudentArchive.firstname.setText(Fn);
        viewStudentArchive.middlename.setText(Mn);
        viewStudentArchive.lrn.setText(Lrn);
        viewStudentArchive.contact.setText(Con);
        viewStudentArchive.email.setText(Em);
        viewStudentArchive.sex.setText(Se);
        viewStudentArchive.birthday.setText(bmonth);
        viewStudentArchive.BirthCertificateCB.setSelected(Bcertificate);
        viewStudentArchive.sf9CB.setSelected(sf9);
        viewStudentArchive.sf10CB.setSelected(sf10);
        viewStudentArchive.birthday.setText(birthday);  
        viewStudentArchive.Description.setText(desc);
        viewStudentArchive.TransferInCB.setSelected(transin);
        viewStudentArchive.address.setText(Addr);
        
        
        viewStudentArchive.grade6view.setText(g6year);
        viewStudentArchive.grade10view.setText(g10year);
        viewStudentArchive.grade12view.setText(g12year);
        
     
       
        viewStudentArchive.imageView1.setIcon(null);
        viewStudentArchive.imageView2.setIcon(null);
        viewStudentArchive.imageView3.setIcon(null);
        
        viewStudentArchive.imagePath1.setText("");
        viewStudentArchive.imagePath2.setText("");
        viewStudentArchive.imagePath3.setText("");
        
         if (Bcertificate == true){
        viewStudentArchive.LoadImageID1();
        viewStudentArchive.imagePath1.setText(path1);
        viewStudentArchive.imagePath1.setColumns(1);
        
        }
        if (sf9 == true){
        viewStudentArchive.LoadImageID2();
        viewStudentArchive.imagePath2.setText(path2);
        viewStudentArchive.imagePath2.setColumns(1);
        }
         if (sf10 == true){
        viewStudentArchive.LoadImageID3();
        viewStudentArchive.imagePath3.setText(path3);
        viewStudentArchive.imagePath3.setColumns(1);
        }

        

    }
    
    
    
    

    
   private void DeleteButton() {
    int selectedRow = MasterlistTable.getSelectedRow();

    if (selectedRow != -1) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            String studentID = MasterlistTable.getValueAt(selectedRow, 0).toString(); //getrow

            String sql = "DELETE FROM `test` WHERE lrn = ?;"
                    + "     DELETE FROM `transferin` WHERE lrn = ?;";
            
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, studentID);
                pst.setString(2, studentID);
                
                int affectedRows = pst.executeUpdate();

                System.out.println("Selected Row: " + selectedRow); //debugging
                System.out.println("Student ID: " + studentID);//debugging
                
                if (affectedRows > 0) {
                    
                    JOptionPane.showMessageDialog(null, "Row deleted successfully");
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete row");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to delete");
    }
}
   
   
   private void DeleteButton2() {
    int selectedRow = TransferinTable.getSelectedRow();

    if (selectedRow != -1) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this row?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            String studentID = TransferinTable.getValueAt(selectedRow, 0).toString(); //getrow

            System.out.println(studentID);
            String sql = "DELETE FROM `transferin` WHERE lrn = ?";
            
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, studentID);
                
                int affectedRows = pst.executeUpdate();

                
                
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Row deleted successfully");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete row");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    } 
}
  
    
   private void transferOutButton() {
    int selectedRow = MasterlistTable.getSelectedRow();

    if (selectedRow != -1) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to the student to be transferred out?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            String studentID = MasterlistTable.getValueAt(selectedRow, 0).toString(); //getrow

            String sql = "INSERT INTO transferout SELECT * FROM test WHERE lrn=?";
            
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, studentID);
                
                int affectedRows = pst.executeUpdate();

                System.out.println("Selected Row: " + selectedRow); //debugging
                System.out.println("Student ID: " + studentID);//debugging
                
                if (affectedRows > 0) {
                    String sql2 = "DELETE FROM `transferin` WHERE lrn = ?";

                    try {
                        PreparedStatement pst2 = con.prepareStatement(sql2);
                        pst2.setString(1, studentID);

                        int rowsAffected = pst2.executeUpdate();

                        // Check if any rows were affected
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "The student data from Transfer-in menu has been removed and moved to transferout.",
                                    "Transfer Successful",
                                    JOptionPane.INFORMATION_MESSAGE
                            );
                        } 
                    } catch (SQLException ex) {
                        ex.printStackTrace();       
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to transfer the student");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            
            String sql1 = "DELETE FROM test WHERE lrn=?";
            
            try {
                PreparedStatement pst = con.prepareStatement(sql1);
                pst.setString(1, studentID);
                
                pst.executeUpdate();
                refreshArchive();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to transfer");
    }
}
    
    
    
    

    
    
String msg;
    
//UPDATE THIS AFTER U CREATE THE EDIT BUTTON
    private void archiveButton(){
       
  
 
        
        String sql = "INSERT INTO archive SELECT * FROM test WHERE grade ='12' AND status = 'complete';"
                     + "UPDATE archive SET g12year =schoolyear;"
                     + "UPDATE archive SET archive =lrn;"
                     + "DELETE FROM test WHERE grade ='12' AND status = 'complete';"; 
        
        try {
            pst = con.prepareStatement(sql);
            int affectedRows = pst.executeUpdate();
            
            
            
            if (affectedRows > 0) {
                //JOptionPane.showMessageDialog(null, "Rows archived successfully"); 
              //  loadingLBL.setVisible(true);
                msg = "Rows archived successfully";
                
                
                
            } else {
                //JOptionPane.showMessageDialog(null, "No rows were archived");
              //  loadingLBL.setVisible(true);
                msg = "No rows were archived";
            }
        } catch (SQLException ex) {
            
        }
        
  
    
}
    
    
      private void archiveRestore(){
        int selectedRow = ArchiveTable.getSelectedRow();

    if (selectedRow != -1) {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to bring back this student to the masterlist?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION) {
            String studentID = ArchiveTable.getValueAt(selectedRow, 0).toString(); //getrow

            String sql = "INSERT INTO test SELECT * FROM archive WHERE lrn=?;"
                        + "DELETE FROM archive WHERE lrn=?;"
                        + "UPDATE test SET g12year ='';";
            
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, studentID);
                pst.setString(2, studentID);
                
                int affectedRows = pst.executeUpdate();

                System.out.println("Selected Row: " + selectedRow); //debugging
                System.out.println("Student ID: " + studentID);//debugging
                
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Row Restored successfully");
                       
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Restore row");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
      
        }
    } else {
        JOptionPane.showMessageDialog(null, "Please select a row to Restore");
    }
 

    }
      
      
       public void TransferoutRestore(){
        
        int selectedRow = TransferoutTable.getSelectedRow();

    if (selectedRow != -1) {
    int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to bring back this student to the masterlist?", "Confirmation", JOptionPane.YES_NO_OPTION);
       if (option == JOptionPane.YES_OPTION) {
           EditButtonTransferout();

        }
 
    }
 
    }
      
      
    
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //REFRESH TABLES
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // Create a method to refresh the MySQL JTable contents
public void refreshTable() {
    String sql = "SELECT * FROM test ORDER BY grade DESC, lname ASC ";

    
    try {
        DefaultTableModel model = (DefaultTableModel) MasterlistTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
      
        
        // update each category of JTable

    while (rs.next()) {
    int grades = Integer.parseInt(rs.getString(13));
        
        model.addRow(new Object[] {
            
           
            rs.getString(11),
            rs.getString(3),
            rs.getString(1),
            rs.getString(2),
            rs.getString(6),
            rs.getString(4),
            grades, // Use the integer directly
            rs.getString(17),
            rs.getString(10),
            rs.getString(5),
            rs.getString(12),
            
            
        });
    }
        // update the student count shown in the upper right corner
        studentnum.setText(Integer.toString(MasterlistTable.getRowCount()));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        MasterlistTable.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        MasterlistTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    
    updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);
}

public void refreshtransin() {
    String sql = "SELECT * FROM transferin ORDER BY grade DESC, lname ASC ";

    
    try {
        DefaultTableModel model = (DefaultTableModel) TransferinTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
      
        
        // update each category of JTable

    while (rs.next()) {
    int grades = Integer.parseInt(rs.getString(13));
        
        model.addRow(new Object[] {
            
           
            rs.getString(11),
            rs.getString(3),
            rs.getString(1),
            rs.getString(2),
            rs.getString(6),
            rs.getString(4),
            grades, // Use the integer directly
            rs.getString(17),
            rs.getString(10),
            rs.getString(5),
            rs.getString(12),
            
            
        });
    }
        // update the student count shown in the upper right corner
        studentnum2.setText(Integer.toString(TransferinTable.getRowCount()));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TransferinTable.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        TransferinTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}


public void refreshtransout() {
    String sql = "SELECT * FROM transferout ORDER BY grade DESC, lname ASC";

    
    try {
        DefaultTableModel model = (DefaultTableModel) TransferoutTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
      
        
        // update each category of JTable

    while (rs.next()) {
    int grades = Integer.parseInt(rs.getString(13));
        
        model.addRow(new Object[] {
            
           
            rs.getString(11),
            rs.getString(3),
            rs.getString(1),
            rs.getString(2),
            rs.getString(6),
            rs.getString(4),
            grades, // Use the integer directly
            rs.getString(17),
            rs.getString(10),
            rs.getString(5),
            rs.getString(12),
            
            
        });
    }
        // update the student count shown in the upper right corner
        studentnum3.setText(Integer.toString(TransferoutTable.getRowCount()));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TransferoutTable.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        TransferoutTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        
        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    
}





private void refreshArchive(){
String sql = "SELECT * FROM archive ORDER BY schoolyear DESC, lname ASC ";

    
    try {
        DefaultTableModel model = (DefaultTableModel) ArchiveTable.getModel();
        model.setRowCount(0);

        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        
        
      
        
        // update each category of JTable

    while (rs.next()) {
    int grades = Integer.parseInt(rs.getString(13));
        
        model.addRow(new Object[] {
            
           
            rs.getString(11),
            rs.getString(3),
            rs.getString(1),
            rs.getString(2),
            rs.getString(6),
            rs.getString(4),
            grades, // Use the integer directly
            rs.getString(17),
            rs.getString(10),
            rs.getString(5),
            rs.getString(12),
            
            
        });
    }
        // update the student count shown in the upper right corner
        studentnum4.setText(Integer.toString(ArchiveTable.getRowCount()));
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        ArchiveTable.getColumnModel().getColumn(10).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(9).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(8).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(7).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        ArchiveTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
}
    

//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //SORTERS
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////


public void MasterlistSorter() {
    String selectedValue = (String) sortBox.getSelectedItem();

    // Construct appropriate SQL query based on selected value
    String sqlQuery;
    if (selectedValue.equals("All")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.equals("Last Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test ORDER BY lname ASC";
    } else if (selectedValue.equals("First Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test ORDER BY fname ASC";
    } else if (selectedValue.equals("Middle Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test ORDER BY mname ASC";
    }
    else if (selectedValue.equals("Male")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test WHERE sex = 'Male' ORDER BY grade DESC, lname ASC";
    }else if (selectedValue.equals("Female")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test WHERE sex = 'Female' ORDER BY grade DESC, lname ASC";
    }
    else if (selectedValue.equals("Complete")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test WHERE status = 'Complete' ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.equals("Incomplete")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test WHERE status = 'Incomplete' ORDER BY grade DESC, lname ASC";
    }else if (selectedValue.equals("Kindergarten")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test WHERE grade = '0' ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.startsWith("Grade ")) {
        int grade = Integer.parseInt(selectedValue.substring("Grade ".length()));
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test WHERE grade = ? ORDER BY grade DESC, lname ASC ";
    } else {
        // Handle other cases if needed
        sqlQuery = "SELECT * FROM test";
    }
    
    updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set parameters for grade filtering, if applicable
        if (selectedValue.startsWith("Grade ")) {
            int grade = Integer.parseInt(selectedValue.substring("Grade ".length()));
            preparedStatement.setInt(1, grade);
        }

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) MasterlistTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        studentnum.setText(Integer.toString(model.getRowCount()));

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
}




public void ArchiveSorter() {
    String selectedValue = (String) sortBox4.getSelectedItem();

    // Construct appropriate SQL query based on selected value
    String sqlQuery;
    if (selectedValue.equals("All")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.equals("Last Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive ORDER BY lname ASC";
    } else if (selectedValue.equals("First Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive ORDER BY fname ASC";
    } else if (selectedValue.equals("Middle Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive ORDER BY mname ASC";
    }
    else if (selectedValue.equals("Male")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive WHERE sex = 'Male' ORDER BY grade DESC, lname ASC";
    }else if (selectedValue.equals("Female")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive WHERE sex = 'Female' ORDER BY grade DESC, lname ASC";
    }
    else if (selectedValue.equals("Complete")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive WHERE status = 'Complete' ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.equals("Incomplete")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive WHERE status = 'Incomplete' ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.startsWith("Grade ")) {
        int grade = Integer.parseInt(selectedValue.substring("Grade ".length()));
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive WHERE grade = ? ORDER BY grade DESC, lname ASC ";
    } else {
        // Handle other cases if needed
        sqlQuery = "SELECT * FROM archive";
    }

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set parameters for grade filtering, if applicable
        if (selectedValue.startsWith("Grade ")) {
            int grade = Integer.parseInt(selectedValue.substring("Grade ".length()));
            preparedStatement.setInt(1, grade);
        }

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) ArchiveTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        studentnum4.setText(Integer.toString(model.getRowCount()));

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
}

public void YearArchiveSorter() {
    String selectedValue = (String) yearsorter.getSelectedItem();

    // Check if the selected value is a valid year range
    try {
        // Extract the start and end years from the selected value
        String[] yearRange = selectedValue.split("-");
        int startYear = Integer.parseInt(yearRange[0]);
        int endYear = Integer.parseInt(yearRange[1]);

        // Construct SQL query to filter by school year range
        String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive WHERE (schoolyear >= ? AND schoolyear <= ?) ORDER BY schoolyear ASC, grade DESC, lname ASC";

        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

            // Set the start and end years as parameters
            preparedStatement.setInt(1, startYear);
            preparedStatement.setInt(2, endYear);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the updated data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with new data
            DefaultTableModel model = (DefaultTableModel) ArchiveTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            studentnum4.setText(Integer.toString(model.getRowCount()));

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }

    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Handle case when the selected value is not in the expected format or cannot be parsed
        // You may add appropriate error handling or ignore this case if necessary
    }
}


public void YearTransferinSorter() {
    String selectedValue = (String) yearsorterTransferin.getSelectedItem();

    // Check if the selected value is a valid year range
    try {
        // Extract the start and end years from the selected value
        String[] yearRange = selectedValue.split("-");
        int startYear = Integer.parseInt(yearRange[0]);
        int endYear = Integer.parseInt(yearRange[1]);

        // Construct SQL query to filter by school year range
        String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE (schoolyear >= ? AND schoolyear <= ?) ORDER BY schoolyear ASC, grade DESC, lname ASC";

        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

            // Set the start and end years as parameters
            preparedStatement.setInt(1, startYear);
            preparedStatement.setInt(2, endYear);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the updated data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with new data
            DefaultTableModel model = (DefaultTableModel) TransferinTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            studentnum2.setText(Integer.toString(model.getRowCount()));
            
            updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }

    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Handle case when the selected value is not in the expected format or cannot be parsed
        // You may add appropriate error handling or ignore this case if necessary
    }
}





public void TransferinSorter(){
    String selectedValue = (String) sortBox2.getSelectedItem();

    // Construct appropriate SQL query based on selected value
    String sqlQuery;
    if (selectedValue.equals("All")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.equals("Last Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin ORDER BY lname ASC";
    } else if (selectedValue.equals("First Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin ORDER BY fname ASC";
    } else if (selectedValue.equals("Middle Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin ORDER BY mname ASC";
    }
    else if (selectedValue.equals("Male")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE sex = 'Male' ORDER BY grade DESC, lname ASC";
    }else if (selectedValue.equals("Female")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE sex = 'Female' ORDER BY grade DESC, lname ASC";
    }
    else if (selectedValue.equals("Complete")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE status = 'Complete' ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.equals("Incomplete")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE status = 'Incomplete' ORDER BY grade DESC, lname ASC";
    }else if (selectedValue.equals("Kindergarten")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE grade = '0' ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.startsWith("Grade ")) {
        int grade = Integer.parseInt(selectedValue.substring("Grade ".length()));
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE grade = ? ORDER BY grade DESC, lname ASC ";
    } else {
        // Handle other cases if needed
        sqlQuery = "SELECT * FROM transferin";
    }

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set parameters for grade filtering, if applicable
        if (selectedValue.startsWith("Grade ")) {
            int grade = Integer.parseInt(selectedValue.substring("Grade ".length()));
            preparedStatement.setInt(1, grade);
        }

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) TransferinTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        studentnum2.setText(Integer.toString(model.getRowCount()));
        
        updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }

}

public void TransferoutSorter(){
String selectedValue = (String) sortBox3.getSelectedItem();

    // Construct appropriate SQL query based on selected value
    String sqlQuery;
    if (selectedValue.equals("All")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.equals("Last Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout ORDER BY lname ASC";
    } else if (selectedValue.equals("First Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout ORDER BY fname ASC";
    } else if (selectedValue.equals("Middle Name")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout ORDER BY mname ASC";
    }
    else if (selectedValue.equals("Male")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout WHERE sex = 'Male' ORDER BY grade DESC, lname ASC";
    }else if (selectedValue.equals("Female")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout WHERE sex = 'Female' ORDER BY grade DESC, lname ASC";
    }
    else if (selectedValue.equals("Complete")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout WHERE status = 'Complete' ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.equals("Incomplete")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout WHERE status = 'Incomplete'  ORDER BY grade DESC, lname ASC";
    }else if (selectedValue.equals("Kindergarten")) {
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE grade = '0' ORDER BY grade DESC, lname ASC";
    } else if (selectedValue.startsWith("Grade ")) {
        int grade = Integer.parseInt(selectedValue.substring("Grade ".length()));
        sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout WHERE grade = ? ORDER BY grade DESC, lname ASC ";
    } else {
        // Handle other cases if needed
        sqlQuery = "SELECT * FROM transferout";
    }

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set parameters for grade filtering, if applicable
        if (selectedValue.startsWith("Grade ")) {
            int grade = Integer.parseInt(selectedValue.substring("Grade ".length()));
            preparedStatement.setInt(1, grade);
        }

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) TransferoutTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        studentnum3.setText(Integer.toString(model.getRowCount()));
        
        updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }

}
    
public void YearTransferoutSorter() {
    String selectedValue = (String) yearsorterTransferout.getSelectedItem();

    // Check if the selected value is a valid year range
    try {
        // Extract the start and end years from the selected value
        String[] yearRange = selectedValue.split("-");
        int startYear = Integer.parseInt(yearRange[0]);
        int endYear = Integer.parseInt(yearRange[1]);

        // Construct SQL query to filter by school year range
        String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout WHERE (schoolyear >= ? AND schoolyear <= ?) ORDER BY schoolyear ASC, grade DESC, lname ASC";

        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

            // Set the start and end years as parameters
            preparedStatement.setInt(1, startYear);
            preparedStatement.setInt(2, endYear);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the updated data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with new data
            DefaultTableModel model = (DefaultTableModel) TransferoutTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            studentnum3.setText(Integer.toString(model.getRowCount()));
            
            updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }

    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Handle case when the selected value is not in the expected format or cannot be parsed
        // You may add appropriate error handling or ignore this case if necessary
    }
}
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //MENU PANEL COLOR BUTTONS 
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //FOR PANELS
    void setColor (JPanel panel)//mouse entered
    {
         panel.setBackground(new Color (143, 170, 220));//[143, 170, 220] dark blue
    }
    
    
    void resetColor (JPanel panel)//mouse exited
    {
        panel.setBackground(new Color (189, 215, 238));//[189, 215, 238] light blue
    }
    void resetColor2 (JPanel panel)//mouse exited
    {
        panel.setBackground(new Color (255,255,255));//[222,235,247]
    }
    
   
   //FOR LABELS 
    void setColorlabel (JLabel label)//mouse entered
    {
        label.setForeground(new Color (255,255,255)); //white    
    }
    
    void resetColorlabel (JLabel label)//mouse exited
    {
        label.setForeground(new Color (0,0,0));  //black  
    }    

    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //REFRESH START UP
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
  private void formWindowOpened(java.awt.event.WindowEvent evt) {
    //Automatically run the refresh button when the app is run for the first time    
    //activated in the innitcomponents
    refreshBTActionPerformed(null);
    masterlistPLBTMouseClicked(null);
    }
  
  
  
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
                //SEARCH METHODS
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
  private void searchMasterlist() {
    // Get the search text from the searchTXT field
    String searchText = searchTXT.getText().trim();

    // Check if search text is empty
    if (searchText.equals("")) {
        // If search text is empty, load all data from the database table
        String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test ORDER BY grade DESC, lname ASC ";
        
        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with the data
            DefaultTableModel model = (DefaultTableModel) MasterlistTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            studentnum.setText(Integer.toString(model.getRowCount()));
            
            updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }
        
        return; // Exit the method
    }

    // Construct the SQL query to search across multiple columns
    String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM test WHERE "
            + "CONCAT(`lname`, ' ', `fname`, ' ', `mname`, ' ', `birthday`, ' ', `sex`, ' ', `grade`, ' ', `schoolyear`, ' ', `contact`, ' ', `email`, ' ', `status`) "
            + "LIKE ? ";

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set the parameter for the search text
        preparedStatement.setString(1, "%" + searchText + "%");

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) MasterlistTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        studentnum.setText(Integer.toString(model.getRowCount()));
        
        updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
}
  
  
  private void searchTransferin(){
   // Get the search text from the searchTXT field
    String searchText = searchTXT2.getText().trim();

    // Check if search text is empty
    if (searchText.equals("")) {
        // If search text is empty, load all data from the database table
        String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin ORDER BY grade DESC, lname ASC ";
        
        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with the data
            DefaultTableModel model = (DefaultTableModel) TransferinTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            studentnum2.setText(Integer.toString(model.getRowCount()));
            
            updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }
        
        return; // Exit the method
    }

    // Construct the SQL query to search across multiple columns
    String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferin WHERE "
            + "CONCAT(`lname`, ' ', `fname`, ' ', `mname`, ' ', `birthday`, ' ', `sex`, ' ', `grade`, ' ', `schoolyear`, ' ', `contact`, ' ', `email`, ' ', `status`) "
            + "LIKE ? ";

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set the parameter for the search text
        preparedStatement.setString(1, "%" + searchText + "%");

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) TransferinTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        studentnum2.setText(Integer.toString(model.getRowCount()));
        
        
        updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
  }
  
  private void searchTransferout(){
      // Get the search text from the searchTXT field
    String searchText = searchTXT3.getText().trim();

    // Check if search text is empty
    if (searchText.equals("")) {
        // If search text is empty, load all data from the database table
        String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout ORDER BY grade DESC, lname ASC ";
        
        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with the data
            DefaultTableModel model = (DefaultTableModel) TransferoutTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            studentnum3.setText(Integer.toString(model.getRowCount()));
            
            updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }
        
        return; // Exit the method
    }

    // Construct the SQL query to search across multiple columns
    String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM transferout WHERE "
            + "CONCAT(`lname`, ' ', `fname`, ' ', `mname`, ' ', `birthday`, ' ', `sex`, ' ', `grade`, ' ', `schoolyear`, ' ', `contact`, ' ', `email`, ' ', `status`) "
            + "LIKE ? ";

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set the parameter for the search text
        preparedStatement.setString(1, "%" + searchText + "%");

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) TransferoutTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        studentnum3.setText(Integer.toString(model.getRowCount()));
        
        updateJTable(MasterlistTable);
        updateJTable(ArchiveTable);
        updateJTable(TransferoutTable);
        updateJTable(TransferinTable);


    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
  
  }
  
  private void searchArchive(){
  // Get the search text from the searchTXT field
    String searchText = searchTXT4.getText().trim();

    // Check if search text is empty
    if (searchText.equals("")) {
        // If search text is empty, load all data from the database table
        String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive ORDER BY grade DESC, lname ASC ";
        
        try {
            // Prepare the statement
            PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
            
            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Create a list to hold the data
            List<Object[]> data = new ArrayList<>();

            // Populate the list with fetched data
            while (resultSet.next()) {
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
                for (int i = 0; i < row.length; i++) {
                    row[i] = resultSet.getObject(i + 1);
                }
                data.add(row);
            }

            // Update the existing table model with the data
            DefaultTableModel model = (DefaultTableModel) ArchiveTable.getModel();
            model.setRowCount(0); // Clear existing data
            for (Object[] row : data) {
                model.addRow(row);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

            // Update studentnum label with row count
            studentnum4.setText(Integer.toString(model.getRowCount()));

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
        }
        
        return; // Exit the method
    }

    // Construct the SQL query to search across multiple columns
    String sqlQuery = "SELECT `lrn`,`lname`,`fname`,`mname`,`birthday`,`sex`,`grade`,`schoolyear`,`contact`,`email`,`status` FROM archive WHERE "
            + "CONCAT(`lname`, ' ', `fname`, ' ', `mname`, ' ', `birthday`, ' ', `sex`, ' ', `grade`, ' ', `schoolyear`, ' ', `contact`, ' ', `email`, ' ', `status`) "
            + "LIKE ?";

    try {
        // Prepare the statement
        PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);

        // Set the parameter for the search text
        preparedStatement.setString(1, "%" + searchText + "%");

        // Execute the query
        ResultSet resultSet = preparedStatement.executeQuery();

        // Create a list to hold the updated data
        List<Object[]> data = new ArrayList<>();

        // Populate the list with fetched data
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            data.add(row);
        }

        // Update the existing table model with new data
        DefaultTableModel model = (DefaultTableModel) ArchiveTable.getModel();
        model.setRowCount(0); // Clear existing data
        for (Object[] row : data) {
            model.addRow(row);
        }

        // Close resources
        resultSet.close();
        preparedStatement.close();

        // Update studentnum label with row count
        studentnum4.setText(Integer.toString(model.getRowCount()));

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
    }
  }
  
  
  
 
  
  
  
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //ROUNDED PANEL METHOD
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
class RoundedPanel extends JPanel {
    private Color backgroundColor;
    private int cornerRadius = 15;
      private Color hoverColor; // New field for hover color

    public RoundedPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
    }

    public RoundedPanel(LayoutManager layout, int radius, Color bgColor, Color HoverColor) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
        hoverColor = HoverColor;
    }

    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
    }

    public RoundedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint background
        graphics.setColor(getForeground());
    }

    // Add mouse-entered and mouse-exited functionality
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
              if (hoverColor != null) {
                    setBackground(hoverColor);
                    repaint(); // Repaint the panel to reflect the background color change
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
              if (backgroundColor != null) {
                    setBackground(backgroundColor);
                    repaint(); // Repaint the panel to restore the original background color
                }
            }
        });
    }
}
    

public void RowCounter() {
    DefaultTableModel model = (DefaultTableModel) MasterlistTable.getModel();
    model.setColumnCount(0); // Clear existing columns
    model.addColumn("Row Number"); // Add a column for row numbers at the beginning

    // Update the row numbers in the first column
    for (int i = 0; i < model.getRowCount(); i++) {
        model.setValueAt(i + 1, i, 0); // Set the row number (starting from 1) in the first column
    }
}



 private boolean isCredentialsCorrect(String enteredUsername, String enteredPassword) {
    try {
        // Replace "yourDatabaseURL", "yourDatabaseUsername", and "yourDatabasePassword" with your actual database information
        String url = "jdbc:mysql://localhost/lphs5";
        String username = "root";
        String password = "";

        // Establish a connection to the database
        Connection con = DriverManager.getConnection(url, username, password);

        // Check the credentials against the "login" table
        String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPassword);

            ResultSet resultSet = preparedStatement.executeQuery();

            // If there is at least one matching record, return true
            return resultSet.next();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Handle the exception as needed, e.g., print the stack trace or display a message
        JOptionPane.showMessageDialog(
                null,
                "Error connecting to the database. Check the console for details.",
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
        return false;
    }
}
    
    
    public void incrementAllGradeLevelByOne() {
    try {
        // Update g6year with schoolyear for rows where grade is 6
        String sqlUpdate2 = "UPDATE test SET g6year = schoolyear WHERE grade = 6";
        PreparedStatement updateStatement2 = con.prepareStatement(sqlUpdate2);
        updateStatement2.executeUpdate();
        updateStatement2.close();

        // Update g10year with schoolyear for rows where grade is 10
        String sqlUpdate3 = "UPDATE test SET g10year = schoolyear WHERE grade = 10";
        PreparedStatement updateStatement3 = con.prepareStatement(sqlUpdate3);
        updateStatement3.executeUpdate();
        updateStatement3.close();


        // Set g6year to empty string for rows where grade < 6
        String sqlUpdate4 = "UPDATE test SET g6year = '' WHERE grade < 6";
        PreparedStatement updateStatement4 = con.prepareStatement(sqlUpdate4);
        updateStatement4.executeUpdate();
        updateStatement4.close();

        // Set g10year to empty string for rows where grade < 10
        String sqlUpdate5 = "UPDATE test SET g10year = '' WHERE grade < 10";
        PreparedStatement updateStatement5 = con.prepareStatement(sqlUpdate5);
        updateStatement5.executeUpdate(); 
        updateStatement5.close();

        // Set g12year to empty string for rows where grade < 12
        String sqlUpdate6 = "UPDATE test SET g12year = '' WHERE grade < 12";
        PreparedStatement updateStatement6 = con.prepareStatement(sqlUpdate6);
        updateStatement6.executeUpdate();
        updateStatement6.close();
        
        
        // Increment grade by 1 for all rows where grade < 12 or is null
        String sqlUpdate = "UPDATE test SET grade = grade + 1 WHERE grade < 12 OR grade IS NULL";
        PreparedStatement updateStatement = con.prepareStatement(sqlUpdate);
        updateStatement.executeUpdate();
        updateStatement.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        // Handle the exception as needed
    }
}

  
    public void UpdateYear(){
    
    Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String dd = sdf.format(d);
        int tonum =Integer.parseInt(dd);
        int merge = tonum + 1;
        String dd2 = Integer.toString(merge);
    
        String TotalYear = dd+"-"+dd2;
        
        try{
            String sql = "UPDATE test SET schoolyear=?, syear1=?, syear2=?";

           PreparedStatement preparedStatement = con.prepareStatement(sql);

           preparedStatement.setString(1,TotalYear );
           preparedStatement.setString(2,dd );
           preparedStatement.setString(3, dd2);



                   // Execute the update
                   preparedStatement.executeUpdate();
        
        
         } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    
    
    } 
    
    
    private static void updateJTable(final JTable masterlistTable) {
    SwingUtilities.invokeLater(() -> {
        DefaultTableModel model = (DefaultTableModel) masterlistTable.getModel();
        
        // Update the model
        for (int row = 0; row < model.getRowCount(); row++) {
            Object gradeValue = model.getValueAt(row, 6); // Assuming Grade column is at index 6
            
            if (gradeValue != null && gradeValue instanceof Integer && (int) gradeValue == 0) {
                model.setValueAt("Kindergarten", row, 6); // Assuming Grade column is at index 6
            }
        }
        
        // Notify JTable to refresh
        model.fireTableDataChanged();
    });
}
    
    
    
//    private void tranferinButton(){
//            int selectedRow = TransferoutTable.getSelectedRow();
//            String studentID = TransferoutTable.getValueAt(selectedRow, 0).toString();
//            String sql = "INSERT INTO transferin SELECT * FROM test WHERE lrn=?";
//            
//            try {
//                PreparedStatement pst = con.prepareStatement(sql);
//                pst.setString(1, studentID);
//                
//                pst.executeUpdate();
//    
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, ex);
//            }
//        
//    }
    
    
    
  



//
// public void addRowsToDatabase(JTable table) {
//        DefaultTableModel model = (DefaultTableModel) table.getModel();
//        
//        try {
//            // Establish database connection
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
//            
//            // Iterate through each row of the JTable
//            for (int i = 0; i < model.getRowCount(); i++) {
//                // Extract data from each cell in the row
//                String col1 = model.getValueAt(i, 0).toString(); // Assuming the first column's data type is String
//                String col2 = model.getValueAt(i, 1).toString(); // Assuming the second column's data type is String
//                // Add more columns as needed
//                
//                // Insert data into the database
//                String sql = "INSERT INTO your_table_name (column1, column2) VALUES (?, ?)"; // Adjust column names accordingly
//                PreparedStatement statement = connection.prepareStatement(sql);
//                statement.setString(1, col1);
//                statement.setString(2, col2);
//                // Set more parameters as needed
//                
//                // Execute the insert statement
//                statement.executeUpdate();
//                
//                // Close statement
//                statement.close();
//            }
//            
//            // Close connection
//            connection.close();
//            
//            JOptionPane.showMessageDialog(null, "Data inserted successfully.");
//            
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }

}



