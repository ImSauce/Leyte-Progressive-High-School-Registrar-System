
package Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class addStudent extends javax.swing.JFrame {
//variables for mysql
Connection con = null;
PreparedStatement pst = null;
private main mainFrame;
private String defaultText = "YYYY";


File f1 = null;
String  path1 = null;
private ImageIcon format1 = null;
String fname1=null;
int s1 =0;
byte [] pimage1=null;

File f2 = null;
String  path2 = null;
private ImageIcon format2 = null;
String fname2=null;
int s2 =0;
byte [] pimage2=null;

File f3 = null;
String  path3= null;
private ImageIcon format3 = null;
String fname3=null;
int s3 =0;
byte [] pimage3=null;

Sounds sfx = new Sounds();
    private Clip clip;


int valid1 =0;

    public addStudent(main mainFrame) {
        this.mainFrame = mainFrame;
        
        
        
        initComponents();  
        YEAR1();
        
        
        //MYSQL CODE-----------------------------------------------
        String url="jdbc:mysql://localhost/lphs5";
        String user = "root";
        String pass="";
    
        try{
        con = DriverManager.getConnection(url, user, pass);
        }catch(Exception ex){
            System.out.println("Error: " +ex.getMessage());
        }
        //MYSQL CODE-----------------------------------------------
        
        
        
        //icons and title
        ImageIcon logo = new ImageIcon("lphslogo.png");   
        setIconImage(logo.getImage());
        setTitle("Add Student");
        setResizable(false);
        
        Border border = BorderFactory.createEmptyBorder(5, 5, 0, 5);
        Description.setBorder(BorderFactory.createCompoundBorder(Description.getBorder(), border));
        
        
        
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Add a WindowListener to handle the closing event
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Hide the frame instead of closing
                setVisible(false);
            }
        });
        
        
        
    MyKeyListener myKeyListener = new MyKeyListener();
    
    // Add the custom KeyListener to all the components
    lastname.addKeyListener(myKeyListener);
    firstname.addKeyListener(myKeyListener);
    middlename.addKeyListener(myKeyListener);
    lrn.addKeyListener(myKeyListener);
    month.addKeyListener(myKeyListener);
    day.addKeyListener(myKeyListener);
    year.addKeyListener(myKeyListener);
    sex.addKeyListener(myKeyListener);
    grade.addKeyListener(myKeyListener);
    Year1.addKeyListener(myKeyListener);
    Year2.addKeyListener(myKeyListener);
    contact.addKeyListener(myKeyListener);
    email.addKeyListener(myKeyListener);
    address.addKeyListener(myKeyListener);
    Description.addKeyListener(myKeyListener);
    uploadIMG1.addKeyListener(myKeyListener);
    uploadIMG2.addKeyListener(myKeyListener);
    uploadIMG3.addKeyListener(myKeyListener);
    clearIcon.addKeyListener(myKeyListener);
    clearIcon1.addKeyListener(myKeyListener);
    clearIcon2.addKeyListener(myKeyListener);
    TransferInCB.addKeyListener(myKeyListener);
        
        
        
        
        
          
    }
    
    
    
    
   
   ResultSet rs;
   public void Connect (){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/upload_image_db", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(addStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        credentialFrame = new javax.swing.JPanel();
        titleRP = new RoundedPanel(30, new Color(222, 235, 247));
        credentialslabel = new javax.swing.JLabel();
        scrollCredentials = new javax.swing.JScrollPane();
        CredentialPanel = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        middlename = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        lrn = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sex = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        saveBT = new javax.swing.JButton();
        grade = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BirthCertificateCB = new javax.swing.JCheckBox();
        sf9CB = new javax.swing.JCheckBox();
        sf10CB = new javax.swing.JCheckBox();
        imageView1 = new javax.swing.JLabel();
        imageView2 = new javax.swing.JLabel();
        imageView3 = new javax.swing.JLabel();
        uploadIMG1 = new javax.swing.JButton();
        uploadIMG2 = new javax.swing.JButton();
        uploadIMG3 = new javax.swing.JButton();
        clearIcon = new javax.swing.JButton();
        clearIcon1 = new javax.swing.JButton();
        clearIcon2 = new javax.swing.JButton();
        imageName3 = new javax.swing.JTextField();
        imageName2 = new javax.swing.JTextField();
        imageName1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TransferInCB = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        day = new javax.swing.JComboBox<>();
        month = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        year = new assets.YearComboBox();
        wordcount = new javax.swing.JLabel();
        wordcount1 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        ad = new javax.swing.JLabel();
        HiddenImagePathPanel = new javax.swing.JPanel();
        imagePath3 = new javax.swing.JTextField();
        imagePath2 = new javax.swing.JTextField();
        imagePath1 = new javax.swing.JTextField();
        Year1 = new assets.YearComboBox();
        Year2 = new javax.swing.JTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        credentialFrame.setBackground(new java.awt.Color(255, 255, 255));

        titleRP.setBackground(new java.awt.Color(222, 235, 247));
        titleRP.setOpaque(false);

        credentialslabel.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel.setText("Enter Credentials");

        javax.swing.GroupLayout titleRPLayout = new javax.swing.GroupLayout(titleRP);
        titleRP.setLayout(titleRPLayout);
        titleRPLayout.setHorizontalGroup(
            titleRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleRPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titleRPLayout.setVerticalGroup(
            titleRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleRPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
        );

        scrollCredentials.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        CredentialPanel.setBackground(new java.awt.Color(255, 255, 255));

        lrn.setToolTipText("LRN must contain 12 numbers");
        lrn.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                lrnCaretUpdate(evt);
            }
        });

        contact.setToolTipText("Contact must contain 11 numbers");
        contact.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                contactCaretUpdate(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Last Name");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("First Name");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Middle Name");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("LRN");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contact");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sex");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Email");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Date of Birth");

        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  "Male", "Female" }));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Grade Level");

        saveBT.setText("Save");
        saveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTActionPerformed(evt);
            }
        });
        saveBT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                saveBTKeyTyped(evt);
            }
        });

        grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Kindergarten", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Schoo Year");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        BirthCertificateCB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BirthCertificateCB.setForeground(new java.awt.Color(0, 0, 0));
        BirthCertificateCB.setText("Birth Certificate");
        BirthCertificateCB.setEnabled(false);

        sf9CB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        sf9CB.setForeground(new java.awt.Color(0, 0, 0));
        sf9CB.setText("SF9");
        sf9CB.setEnabled(false);

        sf10CB.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        sf10CB.setForeground(new java.awt.Color(0, 0, 0));
        sf10CB.setText("SF10");
        sf10CB.setEnabled(false);

        imageView1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imageView2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imageView3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        uploadIMG1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        uploadIMG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addimage.jpg"))); // NOI18N
        uploadIMG1.setToolTipText("add image");
        uploadIMG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadIMG1ActionPerformed(evt);
            }
        });

        uploadIMG2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addimage.jpg"))); // NOI18N
        uploadIMG2.setToolTipText("add image");
        uploadIMG2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadIMG2ActionPerformed(evt);
            }
        });

        uploadIMG3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/addimage.jpg"))); // NOI18N
        uploadIMG3.setToolTipText("add image");
        uploadIMG3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadIMG3ActionPerformed(evt);
            }
        });

        clearIcon.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        clearIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.jpg"))); // NOI18N
        clearIcon.setToolTipText("remove image");
        clearIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearIconActionPerformed(evt);
            }
        });

        clearIcon1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        clearIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.jpg"))); // NOI18N
        clearIcon1.setToolTipText("remove image");
        clearIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearIcon1ActionPerformed(evt);
            }
        });

        clearIcon2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        clearIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.jpg"))); // NOI18N
        clearIcon2.setToolTipText("remove image");
        clearIcon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearIcon2ActionPerformed(evt);
            }
        });

        imageName3.setEditable(false);
        imageName3.setBackground(new java.awt.Color(255, 255, 255));
        imageName3.setForeground(new java.awt.Color(0, 0, 0));
        imageName3.setToolTipText("It is recommended to shorten the file name as much as possible");
        imageName3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imageName3.setMaximumSize(new java.awt.Dimension(98, 18));
        imageName3.setMinimumSize(new java.awt.Dimension(98, 18));
        imageName3.setPreferredSize(new java.awt.Dimension(98, 18));

        imageName2.setEditable(false);
        imageName2.setBackground(new java.awt.Color(255, 255, 255));
        imageName2.setForeground(new java.awt.Color(0, 0, 0));
        imageName2.setToolTipText("It is recommended to shorten the file name as much as possible");
        imageName2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imageName2.setMaximumSize(new java.awt.Dimension(98, 18));
        imageName2.setMinimumSize(new java.awt.Dimension(98, 18));
        imageName2.setPreferredSize(new java.awt.Dimension(98, 18));

        imageName1.setEditable(false);
        imageName1.setBackground(new java.awt.Color(255, 255, 255));
        imageName1.setForeground(new java.awt.Color(0, 0, 0));
        imageName1.setToolTipText("It is recommended to shorten the file name as much as possible");
        imageName1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imageName1.setMaximumSize(new java.awt.Dimension(98, 18));
        imageName1.setMinimumSize(new java.awt.Dimension(98, 18));
        imageName1.setPreferredSize(new java.awt.Dimension(98, 18));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageView1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(uploadIMG1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BirthCertificateCB)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imageName1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageView2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(uploadIMG2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(clearIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(sf9CB))
                    .addComponent(imageName2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sf10CB)
                    .addComponent(imageView3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uploadIMG3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clearIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BirthCertificateCB)
                            .addComponent(sf10CB)
                            .addComponent(sf9CB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageView3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imageView1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imageName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uploadIMG1)
                            .addComponent(uploadIMG2)
                            .addComponent(clearIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uploadIMG3))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Requirements");

        TransferInCB.setForeground(new java.awt.Color(0, 0, 0));
        TransferInCB.setText("Transferred-in");
        TransferInCB.setToolTipText("click this if the individual is a transferred student");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("to");

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"01-January", "02-February", "03-March", "04-April", "05-May", "06-June", "07-July", "08-August", "09-September", "10-October", "11-November", "12-December" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(174, 174, 174));
        jLabel13.setText("Month");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(174, 174, 174));
        jLabel14.setText("Day");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(174, 174, 174));
        jLabel15.setText("Year");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(174, 174, 174));
        jLabel16.setText("1st Year");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(174, 174, 174));
        jLabel17.setText("2nd Year");

        Description.setColumns(20);
        Description.setRows(5);
        jScrollPane1.setViewportView(Description);

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Description");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("(optional)");

        wordcount.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        wordcount.setForeground(new java.awt.Color(165, 165, 165));
        wordcount.setText("Number of Characters: 0");

        wordcount1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        wordcount1.setForeground(new java.awt.Color(165, 165, 165));
        wordcount1.setText("Number of Characters: 0");

        ad.setForeground(new java.awt.Color(0, 0, 0));
        ad.setText("Address");

        HiddenImagePathPanel.setBackground(new java.awt.Color(151, 102, 161));

        imagePath3.setEditable(false);
        imagePath3.setBackground(new java.awt.Color(255, 255, 255));
        imagePath3.setForeground(new java.awt.Color(0, 0, 0));
        imagePath3.setToolTipText("It is highly recommended to shorten the file name as much as possible\n(if the file name is too long or not visible at all, use the remove image button \nand restart the app)");
        imagePath3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imagePath2.setEditable(false);
        imagePath2.setBackground(new java.awt.Color(255, 255, 255));
        imagePath2.setForeground(new java.awt.Color(0, 0, 0));
        imagePath2.setToolTipText("It is highly recommended to shorten the file name as much as possible\n(if the file name is too long or not visible at all, use the remove image button \nand restart the app)");
        imagePath2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imagePath1.setEditable(false);
        imagePath1.setBackground(new java.awt.Color(255, 255, 255));
        imagePath1.setForeground(new java.awt.Color(0, 0, 0));
        imagePath1.setToolTipText("It is highly recommended to shorten the file name as much as possible\n(if the file name is too long or not visible at all, use the remove image button \nand restart the app)");
        imagePath1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout HiddenImagePathPanelLayout = new javax.swing.GroupLayout(HiddenImagePathPanel);
        HiddenImagePathPanel.setLayout(HiddenImagePathPanelLayout);
        HiddenImagePathPanelLayout.setHorizontalGroup(
            HiddenImagePathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HiddenImagePathPanelLayout.createSequentialGroup()
                .addGroup(HiddenImagePathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HiddenImagePathPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imagePath2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imagePath3))
                    .addGroup(HiddenImagePathPanelLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(imagePath1)))
                .addContainerGap())
        );
        HiddenImagePathPanelLayout.setVerticalGroup(
            HiddenImagePathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HiddenImagePathPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(HiddenImagePathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagePath3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagePath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(imagePath1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Year1ActionPerformed(evt);
            }
        });

        Year2.setEditable(false);
        Year2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout CredentialPanelLayout = new javax.swing.GroupLayout(CredentialPanel);
        CredentialPanel.setLayout(CredentialPanelLayout);
        CredentialPanelLayout.setHorizontalGroup(
            CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CredentialPanelLayout.createSequentialGroup()
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CredentialPanelLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(wordcount, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lrn, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)
                                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel8)))
                                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(wordcount1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(12, 12, 12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CredentialPanelLayout.createSequentialGroup()
                                        .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
                                .addGap(104, 104, 104)))))
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(CredentialPanelLayout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addComponent(TransferInCB)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                            .addComponent(saveBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CredentialPanelLayout.createSequentialGroup()
                            .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(CredentialPanelLayout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel13)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CredentialPanelLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel14)
                                    .addGap(52, 52, 52)
                                    .addComponent(jLabel15))
                                .addGroup(CredentialPanelLayout.createSequentialGroup()
                                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(CredentialPanelLayout.createSequentialGroup()
                            .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CredentialPanelLayout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jLabel16))
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(grade, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(sex, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(CredentialPanelLayout.createSequentialGroup()
                                    .addComponent(Year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(CredentialPanelLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel17))
                                .addGroup(CredentialPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Year2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(HiddenImagePathPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        CredentialPanelLayout.setVerticalGroup(
            CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CredentialPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(5, 5, 5)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(Year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Year2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(1, 1, 1)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wordcount)))
                .addGap(20, 20, 20)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGap(1, 1, 1)
                        .addComponent(wordcount1)
                        .addGap(18, 18, 18)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ad))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CredentialPanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(HiddenImagePathPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveBT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TransferInCB))
                        .addContainerGap())))
        );

        scrollCredentials.setViewportView(CredentialPanel);

        javax.swing.GroupLayout credentialFrameLayout = new javax.swing.GroupLayout(credentialFrame);
        credentialFrame.setLayout(credentialFrameLayout);
        credentialFrameLayout.setHorizontalGroup(
            credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentialFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleRP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollCredentials))
                .addGap(8, 8, 8))
        );
        credentialFrameLayout.setVerticalGroup(
            credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentialFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCredentials)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(credentialFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(credentialFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //SAVE BUTTON
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    private void saveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTActionPerformed
    sfx.playSound2(clip);
        
        addNewStudent();
    
    if (valid1 == 1){
        saveImageToDatabase1(f1, path1);
        saveImageToDatabase2(f2, path2);
        saveImageToDatabase3(f3, path3);
        
        
        main main = new main();
      
        tranferinButton();

        setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
    }
    
    }//GEN-LAST:event_saveBTActionPerformed

    private void uploadIMG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadIMG1ActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg");
    fileChooser.setFileFilter(imageFilter);
    int load = fileChooser.showOpenDialog(null);
    
    if (load == JFileChooser.APPROVE_OPTION) {
        f1 = fileChooser.getSelectedFile();
        path1 = f1.getAbsolutePath();
        String imageName = f1.getName();
        imageName1.setText(imageName);
        imageName1.setColumns(6);
        
        imagePath1.setText(path1);
        ImageIcon ii = new ImageIcon(path1);
        imagePath1.setColumns(1);
        
        Image img = ii.getImage().getScaledInstance(98, 91, Image.SCALE_SMOOTH);
        imageView1.setIcon(new ImageIcon(img));
        BirthCertificateCB.setSelected(true);
    }
    }//GEN-LAST:event_uploadIMG1ActionPerformed

    private void uploadIMG2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadIMG2ActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg");
    fileChooser.setFileFilter(imageFilter);
    int load = fileChooser.showOpenDialog(null);
    
    if (load == JFileChooser.APPROVE_OPTION) {
        f2 = fileChooser.getSelectedFile();
        path2 = f2.getAbsolutePath();
        String imageName = f2.getName();
        imageName2.setText(imageName);
        imageName2.setColumns(6);
        
        imagePath2.setText(path2);
        ImageIcon ii = new ImageIcon(path2);
        imagePath2.setColumns(1);
        
        Image img = ii.getImage().getScaledInstance(98, 91, Image.SCALE_SMOOTH);
        imageView2.setIcon(new ImageIcon(img));
        sf9CB.setSelected(true);
    }
    }//GEN-LAST:event_uploadIMG2ActionPerformed

    private void uploadIMG3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadIMG3ActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Files", "png", "jpg", "jpeg");
    fileChooser.setFileFilter(imageFilter);
    int load = fileChooser.showOpenDialog(null);
    
    if (load == JFileChooser.APPROVE_OPTION) {
        f3 = fileChooser.getSelectedFile();
        path3 = f3.getAbsolutePath();
        String imageName = f3.getName();
        imageName3.setText(imageName);
        imageName3.setColumns(6);
        imagePath3.setText(path3);
        
        ImageIcon ii = new ImageIcon(path3);
        imagePath3.setColumns(1);
        Image img = ii.getImage().getScaledInstance(98, 91, Image.SCALE_SMOOTH);
        imageView3.setIcon(new ImageIcon(img));
        sf10CB.setSelected(true);
    }
    }//GEN-LAST:event_uploadIMG3ActionPerformed

    private void clearIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearIconActionPerformed
    String LRN = lrn.getText();
    emptyBlobFile1(LRN);
    imagePath1.setText(""); // Clear the text
    imageName1.setText("");
    imageView1.setIcon(null); // Clear the icon
    BirthCertificateCB.setSelected(false);
    }//GEN-LAST:event_clearIconActionPerformed

    private void clearIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearIcon1ActionPerformed
    String LRN = lrn.getText();
    emptyBlobFile2(LRN);
    imagePath2.setText(""); // Clear the text
    imageName2.setText("");
    imageView2.setIcon(null); // Clear the icon
    sf9CB.setSelected(false);
    }//GEN-LAST:event_clearIcon1ActionPerformed

    private void clearIcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearIcon2ActionPerformed
    String LRN = lrn.getText();
    emptyBlobFile3(LRN);
    imagePath3.setText(""); // Clear the text
    imageName3.setText("");
    imageView3.setIcon(null); // Clear the icon
    sf10CB.setSelected(false);
    }//GEN-LAST:event_clearIcon2ActionPerformed

    private void lrnCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_lrnCaretUpdate
        String text = lrn.getText();
        int characterCount = text.length();

        wordcount.setText("Number of Characters: " + characterCount);
        if (characterCount > 12){
        
        wordcount.setForeground(Color.red);
        
        
        }else{
            wordcount.setForeground(new java.awt.Color(165,165,165));
        }
        
        String lrnText = lrn.getText().trim();
        if (!lrnText.matches("\\d+")&& !lrnText.equals("")) {
            lrn.setForeground(Color.red);
            
        }else{
        lrn.setForeground(Color.black);
        }
            
        
    }//GEN-LAST:event_lrnCaretUpdate

    private void contactCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_contactCaretUpdate
        String text = contact.getText();
        int characterCount = text.length();

        wordcount1.setText("Number of Characters: " + characterCount);
        
        if (characterCount > 11){
        
        wordcount1.setForeground(Color.red);
        
        }else{
            wordcount1.setForeground(new java.awt.Color(165,165,165));
        }
        
        String contactText = contact.getText().trim();
        if (!contactText.matches("\\d+")&& !contactText.equals("")) {
            contact.setForeground(Color.red);
            
        }else{
        contact.setForeground(Color.black);
        }
        
    }//GEN-LAST:event_contactCaretUpdate

    private void saveBTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_saveBTKeyTyped
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // Call the actionPerformed method of Enter button
        saveBTActionPerformed(new ActionEvent(saveBT, ActionEvent.ACTION_PERFORMED, ""));
    }
    }//GEN-LAST:event_saveBTKeyTyped

    private void Year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Year1ActionPerformed
       int YEAR2 =Integer.parseInt(Year1.getSelectedItem().toString());
    int YEAR22 = YEAR2 + 1;
    String YEAR222 = Integer.toString(YEAR22);
    
    Year2.setText(YEAR222);
    }//GEN-LAST:event_Year1ActionPerformed
 
    
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox BirthCertificateCB;
    private javax.swing.JPanel CredentialPanel;
    private javax.swing.JTextArea Description;
    private javax.swing.JPanel HiddenImagePathPanel;
    private javax.swing.JCheckBox TransferInCB;
    private assets.YearComboBox Year1;
    private javax.swing.JTextField Year2;
    private javax.swing.JLabel ad;
    private javax.swing.JTextField address;
    private javax.swing.JButton clearIcon;
    private javax.swing.JButton clearIcon1;
    private javax.swing.JButton clearIcon2;
    private javax.swing.JTextField contact;
    private javax.swing.JPanel credentialFrame;
    private javax.swing.JLabel credentialslabel;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JComboBox<String> grade;
    private javax.swing.JTextField imageName1;
    private javax.swing.JTextField imageName2;
    private javax.swing.JTextField imageName3;
    private javax.swing.JTextField imagePath1;
    private javax.swing.JTextField imagePath2;
    private javax.swing.JTextField imagePath3;
    private javax.swing.JLabel imageView1;
    private javax.swing.JLabel imageView2;
    private javax.swing.JLabel imageView3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastname;
    public javax.swing.JTextField lrn;
    private javax.swing.JTextField middlename;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JButton saveBT;
    private javax.swing.JScrollPane scrollCredentials;
    private javax.swing.JComboBox<String> sex;
    public javax.swing.JCheckBox sf10CB;
    public javax.swing.JCheckBox sf9CB;
    private javax.swing.JPanel titleRP;
    private javax.swing.JButton uploadIMG1;
    private javax.swing.JButton uploadIMG2;
    private javax.swing.JButton uploadIMG3;
    private javax.swing.JLabel wordcount;
    private javax.swing.JLabel wordcount1;
    private assets.YearComboBox year;
    // End of variables declaration//GEN-END:variables
//////////////////////////////////////////////////////////////    
//////////////////////////////////////////////////////////////    
/////////                METHODS            //////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
    
    
    public void YEAR1(){
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    String dd = sdf.format(d);
    int tonum =Integer.parseInt(dd);
    int merge = tonum + 1;
    String dd2 = Integer.toString(merge);
    
    
    year.setSelectedItem(dd);
    
    Year1.setSelectedItem(dd);
    
    int YEAR2 =Integer.parseInt(Year1.getSelectedItem().toString());
    int YEAR22 = YEAR2 + 1;
    String YEAR222 = Integer.toString(YEAR22);
    
    Year2.setText(YEAR222);
    }
    
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //ADD STUDENT FUNCTION
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void addNewStudent(){
    /*(1)*/boolean COMPLETED ; //complete checkbox into boolean
        if//if all requirements boxes are checked it will turn the student into a completed status. otherwise its false
        (   BirthCertificateCB.isSelected() && sf9CB.isSelected() && sf10CB.isSelected() )
        {
            COMPLETED = true;
        }else{
            COMPLETED = false;
        }
        
      
       
        String month_num = "";
        
        if (month.getSelectedItem().toString().equals("01-January")){
            month_num = "01";
        } else if (month.getSelectedItem().toString().equals("02-February")){
            month_num = "02";
        } else if (month.getSelectedItem().toString().equals("03-March")){
            month_num = "03";
        } else if (month.getSelectedItem().toString().equals("04-April")){
            month_num = "04";
        } else if (month.getSelectedItem().toString().equals("05-May")){
            month_num = "05";
        } else if (month.getSelectedItem().toString().equals("06-June")){
            month_num = "06";
        } else if (month.getSelectedItem().toString().equals("07-July")){
            month_num = "07";
        } else if (month.getSelectedItem().toString().equals("08-August")){
            month_num = "08";
        } else if (month.getSelectedItem().toString().equals("09-September")){
            month_num = "09";
        } else if (month.getSelectedItem().toString().equals("10-October")){
            month_num = "10";
        } else if (month.getSelectedItem().toString().equals("11-November")){
           month_num = "11";
        } else if (month.getSelectedItem().toString().equals("12-December")){
            month_num = "12";
        } else {
         month.setSelectedItem(null);
        }
        
        String GRADE = "";
        
        if (grade.getSelectedItem().toString().equals("Kindergarten")){
        GRADE = "0";
        } else {
        GRADE =grade.getSelectedItem().toString();
        }
     
        
        String FIRSTNAME =firstname.getText();
        String MIDDLENAME =middlename.getText();
        String LASTNAME =lastname.getText();
        String SEX=sex.getSelectedItem().toString();
        String EMAIL=email.getText();
        String BIRTHDAY = month_num+"-"+day.getSelectedItem().toString()+"-"+year.getSelectedItem().toString(); //day-month-year merged in 1 variable
        String BDAY =day.getSelectedItem().toString();
        String BMONTH =month_num;
        String BYEAR =year.getSelectedItem().toString();
        String CONTACT =contact.getText();
        String LRN =lrn.getText();
 /*(1)*/String STATUS = Boolean.toString(COMPLETED); //complete checkbox into string
        //String GRADE = grade.getSelectedItem().toString(); //grade checkbox
        String SYEAR = Year1.getSelectedItem()+"-"+Year2.getText();
        String SYEAR1 =Year1.getSelectedItem().toString();
        String SYEAR2 =Year2.getText();
        String TYEAR = Year1.getSelectedItem()+"-"+Year2.getText(); // for transfer students
        boolean TRANSFERIN = TransferInCB.isSelected(); //if Transfer in checkbox is checked
        boolean TRANSFEROUT = false;
        boolean ARCHIVE = false;
        boolean VMASTERLIST = false;
        boolean BCERTIFICATE = BirthCertificateCB.isSelected();
        boolean SF9 =sf9CB.isSelected();
        boolean SF10 =sf10CB.isSelected();
        String DESCRIPTION =Description.getText();
        String ADDRESS = address.getText();
        
        String G6 = "0";
        String G10 = "0";
        String G12 = "0";
        String G6YEAR = "";
        String G10YEAR = "";
        String G12YEAR = "";
        
        
        if (GRADE.equals("6"))
        {
            G6 = "1";
            G6YEAR =SYEAR;
        }
        if (GRADE.equals("10"))
        {
            G10 = "1";
            G10YEAR =SYEAR;
        }
        if (GRADE.equals("12"))
        {
            G12 = "1";;
            G12YEAR =SYEAR;
        }
        
        
 
 /*(1)*/if (COMPLETED == true ){STATUS = "Complete";}
        else if (COMPLETED == false) {STATUS = "Incomplete";}
        
        if (validateInput()) // private boolean validateInput()
        {
            
            try{
               

               //user input on credentials goes here
               String query = "INSERT INTO `test`(`fname`, `mname`, `lname`, `sex`, `email`, `birthday`, `bday`, `bmonth`, `byear`, `contact`, `lrn`, `status`, `grade`, `g6`, `g10`, `g12`, `schoolyear`, `syear1`, `syear2`, `tyear`, `transferin`, `transferout`, `archive`, `vmasterlist`, `g6year`, `g10year`, `g12year`, `Bcertificate`, `sf9`, `sf10`, `description`, `imageName1`, `imageName2`, `imageName3`, `imagePath1`, `imagePath2`, `imagePath3`, `imageFile1`, `imageFile2`, `imageFile3`, `address`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
               con = DriverManager.getConnection("jdbc:mysql://localhost/lphs5", "root", "");
               pst=con.prepareStatement(query);
               pst.setString(1, FIRSTNAME);
               pst.setString(2, MIDDLENAME);
               pst.setString(3, LASTNAME);
               pst.setString(4, SEX);
               pst.setString(5, EMAIL);
               pst.setString(6, BIRTHDAY);
               pst.setString(7, BDAY);
               pst.setString(8, BMONTH);
               pst.setString(9, BYEAR);
               pst.setString(10, CONTACT);
               pst.setString(11, LRN);
               pst.setString(12, STATUS);
               pst.setString(13, GRADE);
               pst.setString(14, G6);
               pst.setString(15, G10);
               pst.setString(16, G12);
               pst.setString(17, SYEAR);
               pst.setString(18, SYEAR1);
               pst.setString(19, SYEAR2);
               pst.setString(20, TYEAR);
               pst.setBoolean(21, TRANSFERIN);
               pst.setBoolean(22, TRANSFEROUT);
               pst.setBoolean(23, ARCHIVE);
               pst.setBoolean(24, VMASTERLIST);
               pst.setString(25, G6YEAR);
               pst.setString(26, G10YEAR);
               pst.setString(27, G12YEAR);
               pst.setBoolean(28, BCERTIFICATE);
               pst.setBoolean(29, SF9);
               pst.setBoolean(30, SF10);
               pst.setString(31, DESCRIPTION);
               
               pst.setString(32, "");
               pst.setString(33, "");
               pst.setString(34, "");
               
               pst.setString(35, "");
               pst.setString(36, "");
               pst.setString(37, "");
               
               pst.setString(38, "");
               pst.setString(39, "");
               pst.setString(40, "");
               
               pst.setString(41, ADDRESS);
               
              
               
               pst.executeUpdate();
               
               
               

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex+" save bt");


                }

        }
       
        mainFrame.refreshTable();
    }
    
    
    
    
    
    
    
    
 private void saveImageToDatabase1(File file, String path) {
     String LRN =lrn.getText();
    if (file != null && path != null && !path.isEmpty()) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String query = "UPDATE test SET imageName1 = ?, imagePath1 = ?, imageFile1 = ? WHERE lrn=? ";
            pst = con.prepareStatement(query);
            pst.setString(1, file.getName());
            pst.setString(2, path);
            pst.setBinaryStream(3, fis, (int) file.length());
            pst.setString(4, LRN);
            pst.executeUpdate();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Image file not found: " + ex.getMessage());
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error saving image to database: " + ex.getMessage());
        }
    }
} 
private void saveImageToDatabase2(File file, String path) {
    String LRN =lrn.getText();
    if (file != null && path != null && !path.isEmpty()) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String query = "UPDATE test SET imageName2 = ?, imagePath2 = ?, imageFile2 = ? WHERE lrn=? ";
            pst = con.prepareStatement(query);
            pst.setString(1, file.getName());
            pst.setString(2, path);
            pst.setBinaryStream(3, fis, (int) file.length());
            pst.setString(4, LRN);
            pst.executeUpdate();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Image file not found: " + ex.getMessage());
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error saving image to database: " + ex.getMessage());
        }
    }
}
  
private void saveImageToDatabase3(File file, String path) {
     String LRN =lrn.getText();
    if (file != null && path != null && !path.isEmpty()) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String query = "UPDATE test SET imageName3 = ?, imagePath3 = ?, imageFile3 = ? WHERE lrn=? ";
            pst = con.prepareStatement(query);
            pst.setString(1, file.getName());
            pst.setString(2, path);
            pst.setBinaryStream(3, fis, (int) file.length());
            pst.setString(4, LRN);
            pst.executeUpdate();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Image file not found: " + ex.getMessage());
        }  catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error saving image to database: " + ex.getMessage());
        }
    }
}
  








private void emptyBlobFile1(String LRN) {
    try {
        String query = "UPDATE test SET imageName1 = NULL, imagePath1 = NULL, imageFile1 = NULL WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
       
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}

private void emptyBlobFile2(String LRN) {
    try {
        String query = "UPDATE test SET imageName2 = NULL, imagePath2 = NULL, imageFile2 = NULL WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}

private void emptyBlobFile3(String LRN) {
    try {
        String query = "UPDATE test SET imageName3 = NULL, imagePath3 = NULL, imageFile3 = NULL WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}












  
  
 private boolean validateInput() {
    // Checks if the credentials have been fully provided. If not, it will prevent the user from activating the save button
    String lrnText = lrn.getText().trim(); // Get text from LRN field and remove leading/trailing whitespace
    String contactText = contact.getText().trim(); // Get text from contact field and remove leading/trailing whitespace
    String year1Text = Year1.getSelectedItem().toString().trim(); // Get text from Year1 field and remove leading/trailing whitespace
    String year2Text = Year2.getText().trim(); // Get text from Year2 field and remove leading/trailing whitespace
    StringBuilder errorMessage = new StringBuilder("Please fill in all the necessary information.");
    if (
            firstname.getText().isEmpty()||
            middlename.getText().isEmpty() ||
            year1Text.isEmpty() || year1Text.length() != 4 || !year1Text.matches("\\d+") || // Check if Year1 is empty, not 4 characters long, or contains non-numeric characters
            year2Text.isEmpty() || year2Text.length() != 4 || !year2Text.matches("\\d+") || // Check if Year2 is empty, not 4 characters long, or contains non-numeric characters
            lastname.getText().isEmpty() ||
            sex.getSelectedItem() == null ||
            (!lrnText.isEmpty() && (!lrnText.matches("\\d+") || lrnText.length() != 12)) || // Check if LRN contains only numeric characters and has exactly 12 digits
            (contactText.isEmpty() || !contactText.matches("\\d{11}")) || // Check if contact is empty or does not have exactly 11 digits
            email.getText().isEmpty() ||
            address.getText().isEmpty() ||
            day.getSelectedItem().toString().isEmpty() ||
            month.getSelectedItem().toString().isEmpty() ||
            year.getSelectedItem().toString().isEmpty() ||
            grade.getSelectedItem() == null
    ) {
        // Construct error message
       
        if (lrnText.isEmpty()) {
            errorMessage.append("\nLRN is required.");
        } else if (!lrnText.matches("\\d+")) {
            errorMessage.append("\nLRN should contain only numeric characters.");
        } else if (lrnText.length() != 12) {
            errorMessage.append("\nLRN should contain exactly 12 digits.");
        }
        if (contactText.isEmpty()) {
            errorMessage.append("\nContact number is required.");
        } else if (!contactText.matches("\\d+")) {
            errorMessage.append("\nContact number should contain only numeric characters.");
        } else if (contactText.length() != 11) {
            errorMessage.append("\nContact number should contain exactly 11 digits.");
        }
        if (year1Text.isEmpty() || year1Text.length() != 4 || !year1Text.matches("\\d+")) {
            errorMessage.append("\nYear 1 should contain exactly 4 digits and only numeric characters.");
        }
        if (year2Text.isEmpty() || year2Text.length() != 4 || !year2Text.matches("\\d+")) {
            errorMessage.append("\nYear 2 should contain exactly 4 digits and only numeric characters.");
        }
        
        

        JOptionPane.showMessageDialog(
                null,
                errorMessage.toString(),
                "Validation Error",
                JOptionPane.ERROR_MESSAGE
        );
        
        errorMessage.append("Please fill in all the necessary information.");
        
        valid1 = 0;
        return false; // Validation failed
        
    }
    
    valid1=1;
    return true; // Validation passed
   
    
}

    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
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

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            //graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }
    
    
 class MyKeyListener implements KeyListener {

    @Override
    public void keyPressed(KeyEvent evt) {
        saveBTKeyTyped(evt);
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        saveBTKeyTyped(evt);
    }

    @Override
    public void keyTyped(KeyEvent evt) {
         saveBTKeyTyped(evt);
    }
  }

    
    
    private void tranferinButton(){
   if (TransferInCB.isSelected()) {
            String sql = "INSERT INTO transferin SELECT * FROM test WHERE lrn=?";
            
            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, lrn.getText());
                
                pst.executeUpdate();
    
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
            

}



