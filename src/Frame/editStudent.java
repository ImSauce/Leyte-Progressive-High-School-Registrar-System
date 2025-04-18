
package Frame;

import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.LayoutManager;
import java.awt.RenderingHints;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

import javax.swing.JPanel;


import com.mysql.cj.protocol.Resultset;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.ResultSet;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class editStudent extends javax.swing.JFrame {
//variables for mysql
Connection con = null;
PreparedStatement pst = null;
Statement st;
int valid = 0;
int del1 = 0;
int del2= 0;
int del3=0;


Sounds sfx = new Sounds();
    private Clip clip;

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


String url="jdbc:mysql://localhost/lphs5";
String user = "root";
String pass="";






    public editStudent() {
         
        
        
        initComponents();
        
       
        //MYSQL CODE-----------------------------------------------
       
    
        try{
        con = DriverManager.getConnection(url, user, pass);
        }catch(Exception ex){
            System.out.println("Error: " +ex.getMessage());
        }
        //MYSQL CODE-----------------------------------------------
        
        
        
        //icons and title
        ImageIcon logo = new ImageIcon("lphslogo.png");   
        setIconImage(logo.getImage());
        setTitle("Edit Student");
        setResizable(false);
        
        Border border = BorderFactory.createEmptyBorder(5, 5, 0, 5);
        Description.setBorder(BorderFactory.createCompoundBorder(Description.getBorder(), border));
        
        
    
       
       
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               scrollCredentials.getViewport().setViewPosition(new java.awt.Point(0, 0));
            }
        });
        
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
    
        
        
        
        
        

    }
    

    ResultSet rs;

 
   public void Connect (){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/lphs5", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
  
   
   
   
   public void LoadImageID1(){
   
  try {
        String LRN = lrn.getText();
        
        pst = con.prepareStatement("SELECT imageFile1, imagePath1 FROM test WHERE lrn=?");
        pst.setString(1, LRN);
        
        // Execute the query and assign the result set to rs
        rs = pst.executeQuery();

        if (rs.next()){
            
        LoadImage1();
        
        
        
        } else {
            JOptionPane.showMessageDialog(this, "no image found");
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  
   }
   
   public void LoadImage1(){
   
    try {
        
        byte[] imagedata = rs.getBytes("imageFile1");
        format1 = new ImageIcon(imagedata);
        Image mm = format1.getImage();
        Image img2 = mm.getScaledInstance(98,91,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        imageView1.setIcon(image);
        
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
    
   
   public void LoadImageID2(){
   
  try {
        String LRN = lrn.getText();
        
        pst = con.prepareStatement("SELECT imageFile2 FROM test WHERE lrn=?");
        pst.setString(1, LRN);
        
        // Execute the query and assign the result set to rs
        rs = pst.executeQuery();

        if (rs.next()){
           
        LoadImage2();
        } else {
            JOptionPane.showMessageDialog(this, "no image found");
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
   public void LoadImage2(){
   
    try {
        
        byte[] imagedata = rs.getBytes("imageFile2");
        format2 = new ImageIcon(imagedata);
        Image mm = format2.getImage();
        Image img2 = mm.getScaledInstance(98,91,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        imageView2.setIcon(image);
        
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
    public void LoadImageID3(){
   
  try {
        String LRN = lrn.getText();
        
        pst = con.prepareStatement("SELECT imageFile3 FROM test WHERE lrn=?");
        pst.setString(1, LRN);
        
        // Execute the query and assign the result set to rs
        rs = pst.executeQuery();

        if (rs.next()){
            
        LoadImage3();
        } else {
            JOptionPane.showMessageDialog(this, "no image found");
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   
   public void LoadImage3(){
   
    try {
        
        byte[] imagedata = rs.getBytes("imageFile3");
        format3 = new ImageIcon(imagedata);
        Image mm = format3.getImage();
        Image img2 = mm.getScaledInstance(98,91,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        imageView3.setIcon(image);
        
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
   }
   

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        credentialFrame = new javax.swing.JPanel();
        titleRP = new RoundedPanel(30, new Color(222, 235, 247));
        credentialslabel = new javax.swing.JLabel();
        scrollCredentials = new javax.swing.JScrollPane();
        CredentialPanel = new javax.swing.JPanel();
        firstname = new javax.swing.JTextField();
        middlename = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        Year1 = new javax.swing.JTextField();
        Year2 = new javax.swing.JTextField();
        imagepanel = new javax.swing.JPanel();
        uploadIMG1 = new javax.swing.JButton();
        uploadIMG2 = new javax.swing.JButton();
        uploadIMG3 = new javax.swing.JButton();
        BirthCertificateCB = new javax.swing.JCheckBox();
        sf9CB = new javax.swing.JCheckBox();
        sf10CB = new javax.swing.JCheckBox();
        clearIcon = new javax.swing.JButton();
        clearIcon1 = new javax.swing.JButton();
        clearIcon2 = new javax.swing.JButton();
        imageView1 = new javax.swing.JLabel();
        imageView2 = new javax.swing.JLabel();
        imageView3 = new javax.swing.JLabel();
        imageName1 = new javax.swing.JTextField();
        imageName2 = new javax.swing.JTextField();
        imageName3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        day = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox<>();
        year = new assets.YearComboBox();
        address = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        wordcount1 = new javax.swing.JLabel();
        hiddenPanel = new javax.swing.JPanel();
        grade10year = new javax.swing.JTextField();
        grade12year = new javax.swing.JTextField();
        grade6 = new javax.swing.JTextField();
        grade6year = new javax.swing.JTextField();
        grade10 = new javax.swing.JTextField();
        grade12 = new javax.swing.JTextField();
        HiddenImagePathPanel = new javax.swing.JPanel();
        imagePath1 = new javax.swing.JTextField();
        imagePath2 = new javax.swing.JTextField();
        imagePath3 = new javax.swing.JTextField();
        lrn = new javax.swing.JTextField();
        wordcount = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lrn1 = new javax.swing.JTextField();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        credentialFrame.setBackground(new java.awt.Color(255, 255, 255));

        titleRP.setBackground(new java.awt.Color(222, 235, 247));
        titleRP.setOpaque(false);

        credentialslabel.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel.setText("Edit Credentials");

        javax.swing.GroupLayout titleRPLayout = new javax.swing.GroupLayout(titleRP);
        titleRP.setLayout(titleRPLayout);
        titleRPLayout.setHorizontalGroup(
            titleRPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleRPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(credentialslabel, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
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

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contact");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sex");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Email");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Date of Birth");

        sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null, "Male", "Female" }));

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

        grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null, "Kindergarten", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Schoo Year");

        Year1.setEditable(false);
        Year1.setForeground(new java.awt.Color(153, 153, 153));

        Year2.setEditable(false);
        Year2.setForeground(new java.awt.Color(153, 153, 153));

        imagepanel.setBackground(new java.awt.Color(255, 255, 255));
        imagepanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imagepanel.setPreferredSize(new java.awt.Dimension(356, 201));

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

        imageView1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imageView2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imageView3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imageName1.setEditable(false);
        imageName1.setBackground(new java.awt.Color(255, 255, 255));
        imageName1.setForeground(new java.awt.Color(0, 0, 0));
        imageName1.setToolTipText("It is recommended to shorten the file name as much as possible\n");
        imageName1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imageName1.setMaximumSize(new java.awt.Dimension(98, 18));
        imageName1.setMinimumSize(new java.awt.Dimension(98, 18));
        imageName1.setPreferredSize(new java.awt.Dimension(98, 18));

        imageName2.setEditable(false);
        imageName2.setBackground(new java.awt.Color(255, 255, 255));
        imageName2.setForeground(new java.awt.Color(0, 0, 0));
        imageName2.setToolTipText("It is recommended to shorten the file name as much as possible\n");
        imageName2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imageName2.setMaximumSize(new java.awt.Dimension(98, 18));
        imageName2.setMinimumSize(new java.awt.Dimension(98, 18));
        imageName2.setPreferredSize(new java.awt.Dimension(98, 18));

        imageName3.setEditable(false);
        imageName3.setBackground(new java.awt.Color(255, 255, 255));
        imageName3.setForeground(new java.awt.Color(0, 0, 0));
        imageName3.setToolTipText("It is recommended to shorten the file name as much as possible\n");
        imageName3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imageName3.setMaximumSize(new java.awt.Dimension(98, 18));
        imageName3.setMinimumSize(new java.awt.Dimension(98, 18));
        imageName3.setPreferredSize(new java.awt.Dimension(98, 18));

        javax.swing.GroupLayout imagepanelLayout = new javax.swing.GroupLayout(imagepanel);
        imagepanel.setLayout(imagepanelLayout);
        imagepanelLayout.setHorizontalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagepanelLayout.createSequentialGroup()
                        .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageView1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imageName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(imageView2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(imageName2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(imagepanelLayout.createSequentialGroup()
                        .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BirthCertificateCB)
                            .addGroup(imagepanelLayout.createSequentialGroup()
                                .addComponent(uploadIMG1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearIcon)))
                        .addGap(26, 26, 26)
                        .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sf9CB, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(imagepanelLayout.createSequentialGroup()
                                .addComponent(uploadIMG2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearIcon1)))))
                .addGap(18, 18, 18)
                .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagepanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(uploadIMG3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearIcon2)
                        .addGap(49, 49, 49))
                    .addGroup(imagepanelLayout.createSequentialGroup()
                        .addComponent(imageName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(imagepanelLayout.createSequentialGroup()
                        .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sf10CB)
                            .addComponent(imageView3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        imagepanelLayout.setVerticalGroup(
            imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagepanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BirthCertificateCB)
                    .addComponent(sf10CB)
                    .addComponent(sf9CB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageView2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageView3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageView1, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imageName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imageName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(uploadIMG2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(clearIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(uploadIMG1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(imagepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(uploadIMG3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clearIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Requirements");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("to");

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(174, 174, 174));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Month");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(174, 174, 174));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Day");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(174, 174, 174));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Year");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(174, 174, 174));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("1st Year");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(174, 174, 174));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("2nd Year");

        Description.setColumns(20);
        Description.setRows(5);
        jScrollPane2.setViewportView(Description);

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Description");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setText("(optional)");

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01-January", "02-February", "03-March", "04-April", "05-May", "06-June", "07-July", "08-August", "09-September", "10-October", "11-November", "12-December"  }));

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Address");

        wordcount1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        wordcount1.setForeground(new java.awt.Color(165, 165, 165));
        wordcount1.setText("Number of Characters: 0");

        hiddenPanel.setBackground(new java.awt.Color(201, 163, 224));

        javax.swing.GroupLayout hiddenPanelLayout = new javax.swing.GroupLayout(hiddenPanel);
        hiddenPanel.setLayout(hiddenPanelLayout);
        hiddenPanelLayout.setHorizontalGroup(
            hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hiddenPanelLayout.createSequentialGroup()
                .addGroup(hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hiddenPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(grade10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grade12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(grade12year, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grade6year, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(hiddenPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(grade6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, hiddenPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(grade10year, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        hiddenPanelLayout.setVerticalGroup(
            hiddenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hiddenPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(grade6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(grade10year, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(grade12year, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(grade6year, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(grade10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(grade12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HiddenImagePathPanel.setBackground(new java.awt.Color(170, 124, 198));

        imagePath1.setEditable(false);
        imagePath1.setBackground(new java.awt.Color(255, 255, 255));
        imagePath1.setForeground(new java.awt.Color(0, 0, 0));
        imagePath1.setToolTipText("It is highly recommended to shorten the file name as much as possible\n(if the file name is too long or not visible at all, use the remove image button \nand restart the app)");
        imagePath1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imagePath2.setEditable(false);
        imagePath2.setBackground(new java.awt.Color(255, 255, 255));
        imagePath2.setForeground(new java.awt.Color(0, 0, 0));
        imagePath2.setToolTipText("It is highly recommended to shorten the file name as much as possible\n(if the file name is too long or not visible at all, use the remove image button \nand restart the app)");
        imagePath2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        imagePath2.setMinimumSize(new java.awt.Dimension(100, 18));
        imagePath2.setPreferredSize(new java.awt.Dimension(100, 18));

        imagePath3.setEditable(false);
        imagePath3.setBackground(new java.awt.Color(255, 255, 255));
        imagePath3.setForeground(new java.awt.Color(0, 0, 0));
        imagePath3.setToolTipText("It is highly recommended to shorten the file name as much as possible\n(if the file name is too long or not visible at all, use the remove image button \nand restart the app)");
        imagePath3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout HiddenImagePathPanelLayout = new javax.swing.GroupLayout(HiddenImagePathPanel);
        HiddenImagePathPanel.setLayout(HiddenImagePathPanelLayout);
        HiddenImagePathPanelLayout.setHorizontalGroup(
            HiddenImagePathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HiddenImagePathPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HiddenImagePathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HiddenImagePathPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(imagePath3))
                    .addComponent(imagePath1)
                    .addComponent(imagePath2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        HiddenImagePathPanelLayout.setVerticalGroup(
            HiddenImagePathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HiddenImagePathPanelLayout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(imagePath1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePath2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(imagePath3))
        );

        lrn.setForeground(new java.awt.Color(0, 0, 0));
        lrn.setToolTipText("LRN must contain 12 numbers");
        lrn.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                lrnCaretUpdate(evt);
            }
        });

        wordcount.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        wordcount.setForeground(new java.awt.Color(165, 165, 165));
        wordcount.setText("Number of Characters: 0");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("LRN");

        javax.swing.GroupLayout CredentialPanelLayout = new javax.swing.GroupLayout(CredentialPanel);
        CredentialPanel.setLayout(CredentialPanelLayout);
        CredentialPanelLayout.setHorizontalGroup(
            CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CredentialPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wordcount1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(433, 433, 433))
            .addGroup(CredentialPanelLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(wordcount)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstname)
                            .addComponent(middlename)
                            .addComponent(email)
                            .addComponent(contact, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lastname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(address)
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(month, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(sex, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6)
                                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CredentialPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Year1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Year2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(111, 111, 111)
                                                .addComponent(lrn1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CredentialPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(saveBT, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lrn))
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CredentialPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(HiddenImagePathPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(hiddenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))))
        );
        CredentialPanelLayout.setVerticalGroup(
            CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CredentialPanelLayout.createSequentialGroup()
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(hiddenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))))
                .addGap(0, 0, 0)
                .addComponent(wordcount)
                .addGap(24, 24, 24)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addGap(24, 24, 24)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Year2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(lrn1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(0, 0, 0)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(24, 24, 24)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(1, 1, 1)
                .addComponent(wordcount1)
                .addGap(24, 24, 24)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(HiddenImagePathPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(imagepanel, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel18)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel19)))
                .addGap(30, 30, 30)
                .addComponent(saveBT)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        scrollCredentials.setViewportView(CredentialPanel);

        javax.swing.GroupLayout credentialFrameLayout = new javax.swing.GroupLayout(credentialFrame);
        credentialFrame.setLayout(credentialFrameLayout);
        credentialFrameLayout.setHorizontalGroup(
            credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentialFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(titleRP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        credentialFrameLayout.setVerticalGroup(
            credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentialFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCredentials, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(credentialFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        EDITStudent();
        
        
        if (valid == 1){
            
            EDITStudentTransferin();
            
            saveImageToDatabase1(f1, path1);
            saveImageToDatabase2(f2, path2);
            saveImageToDatabase3(f3, path3);
            
            
            saveImageToDatabaseTransferin1(f1,path1);
            saveImageToDatabaseTransferin2(f2,path2);
            saveImageToDatabaseTransferin3(f3,path3);
            
            

            imageView1.setIcon(null);
            imageView2.setIcon(null);
            imageView3.setIcon(null);

            imagePath1.setText("");
            imagePath2.setText("");
            imagePath3.setText("");
            
            if (del1 == 1){
                String LRN = lrn.getText();
                emptyBlobFile1(LRN);
                emptyBlobFileTransferin1(LRN);
                del1=0;
            }
            if (del2 == 1){
                String LRN = lrn.getText();
                emptyBlobFile2(LRN);
                emptyBlobFileTransferin2(LRN);
                del2=0;
            }
            if (del3 == 1){
                String LRN = lrn.getText();
                emptyBlobFile3(LRN);
                emptyBlobFileTransferin3(LRN);
                del3 =0;
            }

            valid = 0;
           
            
            
            
            
            setVisible(false);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            scrollCredentials.getViewport().setViewPosition(new java.awt.Point(0, 0));
    
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
        
        imagePath1.setText(""); // Clear the text
        imageName1.setText("");
        imageView1.setIcon(null); // Clear the icon
        BirthCertificateCB.setSelected(false);
        del1=1;
    }//GEN-LAST:event_clearIconActionPerformed

    private void clearIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearIcon1ActionPerformed
       
        imagePath2.setText(""); // Clear the text
        imageName2.setText("");
        imageView2.setIcon(null); // Clear the icon
        sf9CB.setSelected(false);
        del2 = 1;
    }//GEN-LAST:event_clearIcon1ActionPerformed

    private void clearIcon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearIcon2ActionPerformed
       
        imagePath3.setText(""); // Clear the text
        imageName3.setText("");
        imageView3.setIcon(null); // Clear the icon
        sf10CB.setSelected(false);
        del3= 1;
    }//GEN-LAST:event_clearIcon2ActionPerformed

    private void contactCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_contactCaretUpdate
        String text = contact.getText();
        int characterCount = text.length();

        wordcount1.setText("Number of Characters: " + characterCount);
        
        wordcount.setText("Number of Characters: " + characterCount);
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

 
    
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox BirthCertificateCB;
    private javax.swing.JPanel CredentialPanel;
    public javax.swing.JTextArea Description;
    private javax.swing.JPanel HiddenImagePathPanel;
    public javax.swing.JTextField Year1;
    public javax.swing.JTextField Year2;
    public javax.swing.JTextField address;
    private javax.swing.JButton clearIcon;
    private javax.swing.JButton clearIcon1;
    private javax.swing.JButton clearIcon2;
    public javax.swing.JTextField contact;
    private javax.swing.JPanel credentialFrame;
    private javax.swing.JLabel credentialslabel;
    public javax.swing.JComboBox<String> day;
    public javax.swing.JTextField email;
    public javax.swing.JTextField firstname;
    public javax.swing.JComboBox<String> grade;
    public javax.swing.JTextField grade10;
    public javax.swing.JTextField grade10year;
    public javax.swing.JTextField grade12;
    public javax.swing.JTextField grade12year;
    public javax.swing.JTextField grade6;
    public javax.swing.JTextField grade6year;
    private javax.swing.JPanel hiddenPanel;
    public javax.swing.JTextField imageName1;
    public javax.swing.JTextField imageName2;
    public javax.swing.JTextField imageName3;
    public javax.swing.JTextField imagePath1;
    public javax.swing.JTextField imagePath2;
    public javax.swing.JTextField imagePath3;
    public javax.swing.JLabel imageView1;
    public javax.swing.JLabel imageView2;
    public javax.swing.JLabel imageView3;
    private javax.swing.JPanel imagepanel;
    private javax.swing.JEditorPane jEditorPane1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField lastname;
    public javax.swing.JTextField lrn;
    public javax.swing.JTextField lrn1;
    public javax.swing.JTextField middlename;
    public javax.swing.JComboBox<String> month;
    private javax.swing.JButton saveBT;
    private javax.swing.JScrollPane scrollCredentials;
    public javax.swing.JComboBox<String> sex;
    public javax.swing.JCheckBox sf10CB;
    public javax.swing.JCheckBox sf9CB;
    private javax.swing.JPanel titleRP;
    private javax.swing.JButton uploadIMG1;
    private javax.swing.JButton uploadIMG2;
    private javax.swing.JButton uploadIMG3;
    public javax.swing.JLabel wordcount;
    public javax.swing.JLabel wordcount1;
    public assets.YearComboBox year;
    // End of variables declaration//GEN-END:variables
//////////////////////////////////////////////////////////////    
//////////////////////////////////////////////////////////////    
/////////                METHODS            //////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
    
    
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    
            //ADD STUDENT FUNCTION
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void EDITStudent(){
/*(1)*/boolean COMPLETED ; 
        if
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
        String BIRTHDAY = month_num+"-"+day.getSelectedItem().toString()+"-"+year.getSelectedItem().toString();//day-month-year merged in 1 variable
        String BDAY =day.getSelectedItem().toString();
        String BMONTH =month_num;
        String BYEAR =year.getSelectedItem().toString();
        String CONTACT =contact.getText();
        String LRN =lrn.getText();
 /*(1)*/String STATUS = Boolean.toString(COMPLETED); //complete checkbox into string
        //String GRADE = grade.getSelectedItem().toString(); //grade checkbox

        String SYEAR = Year1.getText()+"-"+Year2.getText();
        String SYEAR1 =Year1.getText();
        String SYEAR2 =Year2.getText();
        
        boolean BCERTIFICATE = BirthCertificateCB.isSelected();
        boolean SF9 =sf9CB.isSelected();
        boolean SF10 =sf10CB.isSelected();
        
        String G6=grade6.getText();
        String G10=grade10.getText();
        String G12=grade12.getText();
        
        String G6YEAR = grade6year.getText();
        String G10YEAR = grade10year.getText();
        String G12YEAR = grade12year.getText();
        String DESCRIPTION =Description.getText();
        String ADDRESS =address.getText();
        
       
        
        if (G6.equals("0") && GRADE.equals("6")) 
       {
            G6 = "1";
            G6YEAR = SYEAR;
        }
       
       if (G10.equals("0") && GRADE.equals("10")) 
       {
            G10 = "1";
            G10YEAR = SYEAR;
        }
       
       if (G12.equals("0") && GRADE.equals("12")) 
       {
            G12 = "1";
            G12YEAR = SYEAR;
        }
       
       
        
       if (GRADE.equals("5") || GRADE.equals("4") ||
           GRADE.equals("3") || GRADE.equals("2") ||
           GRADE.equals("1")) 
       {
           G6 = "0";
           G10 = "0";
           G12 = "0";
          
       }
       
       if (GRADE.equals("6") || GRADE.equals("7") || GRADE.equals("8") || GRADE.equals("9")) 
       {
           G10 = "0";
           G12 = "0";
       }
       
       if (GRADE.equals("10") || GRADE.equals("11") )
       {
           
           G12 = "0";
       }
  
       
       
 
 
 /*(1)*/if (COMPLETED == true ){STATUS = "Complete";}
        else if (COMPLETED == false) {STATUS = "Incomplete";}
        
        if (validateInput()) // private boolean validateInput()
        {
            try {
                // SQL Update Query
                String sql = "UPDATE test SET fname=?, mname=?, lname=?, sex=?, email=?, birthday=?, "
                           + "bday=?, bmonth=?, byear=?, contact=?, status=?, grade=?, g6=?, g10=?, g12=?, "
                           + "schoolyear=?, syear1=?, syear2=?, bcertificate=?, sf9=?, sf10=?, g6year=?, g10year=?, g12year=?, description=?, address=?, lrn=? WHERE lrn=?";

                // Prepare the statement
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                // Set parameters
                preparedStatement.setString(1, FIRSTNAME);
                preparedStatement.setString(2, MIDDLENAME);
                preparedStatement.setString(3, LASTNAME);
                preparedStatement.setString(4, SEX);
                preparedStatement.setString(5, EMAIL);
                preparedStatement.setString(6, BIRTHDAY);
                preparedStatement.setString(7, BDAY);
                preparedStatement.setString(8, BMONTH);
                preparedStatement.setString(9, BYEAR);
                preparedStatement.setString(10, CONTACT);
                preparedStatement.setString(11, STATUS);
                preparedStatement.setString(12, GRADE);
                preparedStatement.setString(13, G6);
                preparedStatement.setString(14, G10);
                preparedStatement.setString(15, G12);
                preparedStatement.setString(16, SYEAR);
                preparedStatement.setString(17, SYEAR1);
                preparedStatement.setString(18, SYEAR2);
                
                preparedStatement.setBoolean(19, BCERTIFICATE);
                preparedStatement.setBoolean(20, SF9);
                preparedStatement.setBoolean(21, SF10);
                
                preparedStatement.setString(22, G6YEAR);
                preparedStatement.setString(23, G10YEAR);
                preparedStatement.setString(24, G12YEAR);
                preparedStatement.setString(25, DESCRIPTION);
                preparedStatement.setString(26, ADDRESS);
                preparedStatement.setString(27, LRN);
                preparedStatement.setString(28, lrn1.getText());
                
                

                // Execute the update
                preparedStatement.executeUpdate();

                // Close resources
               

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            
            
            
            
               
            
            
        

            
        //turn off add student pop up if the input are saved
        

        }
            
       
      
    }
    
    
    
     public void EDITStudentTransferin(){
/*(1)*/boolean COMPLETED ; 
        if
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
        
        String FIRSTNAME =firstname.getText();
        String MIDDLENAME =middlename.getText();
        String LASTNAME =lastname.getText();
        String SEX=sex.getSelectedItem().toString();
        String EMAIL=email.getText();
        String BIRTHDAY = month_num+"-"+day.getSelectedItem().toString()+"-"+year.getSelectedItem().toString();//day-month-year merged in 1 variable
        String BDAY =day.getSelectedItem().toString();
        String BMONTH =month_num;
        String BYEAR =year.getSelectedItem().toString();
        String CONTACT =contact.getText();
        String LRN =lrn.getText();
 /*(1)*/String STATUS = Boolean.toString(COMPLETED); //complete checkbox into string
        String GRADE = (String)grade.getSelectedItem(); //grade checkbox

        String SYEAR = Year1.getText()+"-"+Year2.getText();
        String SYEAR1 =Year1.getText();
        String SYEAR2 =Year2.getText();
        
        boolean BCERTIFICATE = BirthCertificateCB.isSelected();
        boolean SF9 =sf9CB.isSelected();
        boolean SF10 =sf10CB.isSelected();
        
        String G6=grade6.getText();
        String G10=grade10.getText();
        String G12=grade12.getText();
        
        String G6YEAR = grade6year.getText();
        String G10YEAR = grade10year.getText();
        String G12YEAR = grade12year.getText();
        String DESCRIPTION =Description.getText();
        String ADDRESS =address.getText();
        
       
        
        if (G6.equals("0") && GRADE.equals("6")) 
       {
            G6 = "1";
            G6YEAR = SYEAR;
        }
       
       if (G10.equals("0") && GRADE.equals("10")) 
       {
            G10 = "1";
            G10YEAR = SYEAR;
        }
       
       if (G12.equals("0") && GRADE.equals("12")) 
       {
            G12 = "1";
            G12YEAR = SYEAR;
        }
       
       
        
       if (GRADE.equals("5") || GRADE.equals("4") ||
           GRADE.equals("3") || GRADE.equals("2") ||
           GRADE.equals("1")) 
       {
           G6 = "0";
           G10 = "0";
           G12 = "0";
          
       }
       
       if (GRADE.equals("6") || GRADE.equals("7") || GRADE.equals("8") || GRADE.equals("9")) 
       {
           G10 = "0";
           G12 = "0";
       }
       
       if (GRADE.equals("10") || GRADE.equals("11") )
       {
           
           G12 = "0";
       }
  
       
       
 
 
 /*(1)*/if (COMPLETED == true ){STATUS = "Complete";}
        else if (COMPLETED == false) {STATUS = "Incomplete";}
        
        
            try {
                // SQL Update Query
                String sql = "UPDATE transferin SET fname=?, mname=?, lname=?, sex=?, email=?, birthday=?, "
                           + "bday=?, bmonth=?, byear=?, contact=?, status=?, grade=?, g6=?, g10=?, g12=?, "
                           + "bcertificate=?, sf9=?, sf10=?, g6year=?, g10year=?, g12year=?, description=?, address=?, lrn=? WHERE lrn=?";

                // Prepare the statement
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                // Set parameters
                preparedStatement.setString(1, FIRSTNAME);
                preparedStatement.setString(2, MIDDLENAME);
                preparedStatement.setString(3, LASTNAME);
                preparedStatement.setString(4, SEX);
                preparedStatement.setString(5, EMAIL);
                preparedStatement.setString(6, BIRTHDAY);
                preparedStatement.setString(7, BDAY);
                preparedStatement.setString(8, BMONTH);
                preparedStatement.setString(9, BYEAR);
                preparedStatement.setString(10, CONTACT);
                preparedStatement.setString(11, STATUS);
                preparedStatement.setString(12, GRADE);
                preparedStatement.setString(13, G6);
                preparedStatement.setString(14, G10);
                preparedStatement.setString(15, G12);
                
                preparedStatement.setBoolean(16, BCERTIFICATE);
                preparedStatement.setBoolean(17, SF9);
                preparedStatement.setBoolean(18, SF10);
                
                preparedStatement.setString(19, G6YEAR);
                preparedStatement.setString(20, G10YEAR);
                preparedStatement.setString(21, G12YEAR);
                preparedStatement.setString(22, DESCRIPTION);
                preparedStatement.setString(23, ADDRESS);
                preparedStatement.setString(24, LRN);
                preparedStatement.setString(25, lrn1.getText());
                
                

                // Execute the update
                preparedStatement.executeUpdate();

                // Close resources
               

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            
            
            main mainFrame = new main();
            mainFrame.refreshtransin();
    
      
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
        }finally {
            resetPreparedStatement();
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
        }finally {
            resetPreparedStatement();
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
        }finally {
            resetPreparedStatement();
        }
    }
}





private void saveImageToDatabaseTransferin1(File file, String path) {
     String LRN =lrn.getText();
    if (file != null && path != null && !path.isEmpty()) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String query = "UPDATE transferin SET imageName1 = ?, imagePath1 = ?, imageFile1 = ? WHERE lrn=? ";
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
        }finally {
            resetPreparedStatement();
        }
    }
} 
private void saveImageToDatabaseTransferin2(File file, String path) {
    String LRN =lrn.getText();
    if (file != null && path != null && !path.isEmpty()) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String query = "UPDATE transferin SET imageName2 = ?, imagePath2 = ?, imageFile2 = ? WHERE lrn=? ";
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
        }finally {
            resetPreparedStatement();
        }
    }
}
  
private void saveImageToDatabaseTransferin3(File file, String path) {
     String LRN =lrn.getText();
    if (file != null && path != null && !path.isEmpty()) {
        try {
            FileInputStream fis = new FileInputStream(file);
            String query = "UPDATE transferin SET imageName3 = ?, imagePath3 = ?, imageFile3 = ? WHERE lrn=? ";
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
        }finally {
            resetPreparedStatement();
        }
    }
}












    
    
    
     private boolean validateInput() {
    // Checks if the credentials have been fully provided. if not then it will prevent the user from activating the save button
    String lrnText = lrn.getText().trim(); // Get text from LRN field and remove leading/trailing whitespace
    String contactText = contact.getText().trim(); // Get text from contact field and remove leading/trailing whitespace

    if (
            firstname.getText().isEmpty() ||
            middlename.getText().isEmpty() ||
            lastname.getText().isEmpty() ||
            address.getText().isEmpty() ||
            sex.getSelectedItem() == null ||
            (!lrnText.isEmpty() && (!lrnText.matches("\\d+") || lrnText.length() != 12)) || // Check if LRN contains only numeric characters and has exactly 12 digits
            (contactText.isEmpty() || !contactText.matches("\\d{11}")) || // Check if contact is empty or does not have exactly 11 digits
            email.getText().isEmpty() ||
            day.getSelectedItem().toString().isEmpty() ||
            month.getSelectedItem().toString().isEmpty() ||
            year.getSelectedItem().toString().isEmpty() ||
            grade.getSelectedItem() == null
    ) {
        // Construct error message
        StringBuilder errorMessage = new StringBuilder("Please fill in all the necessary information.");
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
            
        JOptionPane.showMessageDialog(
                null,
                errorMessage.toString(),
                "Validation Error",
                JOptionPane.ERROR_MESSAGE
        );
        valid = 0;
        return false; // Validation failed
    } else{
        valid = 1;
    }

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
    
    private void resetPreparedStatement() {
    try {
        if (pst != null) {
            pst.close();
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error resetting PreparedStatement: " + ex.getMessage());
    } finally {
        pst = null;
    }
}
    
    
    
    private void emptyBlobFile1(String LRN) {
    try {
        String query = "UPDATE test SET imageName1 = '', imagePath1 = '', imageFile1 = '' WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
       
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}

private void emptyBlobFile2(String LRN) {
    try {
        String query = "UPDATE test SET imageName2 = '', imagePath2 = '', imageFile2 = '' WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}

private void emptyBlobFile3(String LRN) {
    try {
        String query = "UPDATE test SET imageName3 = '', imagePath3 = '', imageFile3 = '' WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}




    private void emptyBlobFileTransferin1(String LRN) {
    try {
        String query = "UPDATE transferin SET imageName1 = '', imagePath1 = '', imageFile1 = '' WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
       
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}

private void emptyBlobFileTransferin2(String LRN) {
    try {
        String query = "UPDATE transferin SET imageName2 = '', imagePath2 = '', imageFile2 = '' WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
    }
}

private void emptyBlobFileTransferin3(String LRN) {
    try {
        String query = "UPDATE transferin SET imageName3 = '', imagePath3 = '', imageFile3 = '' WHERE lrn = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, LRN);
        pst.executeUpdate();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error emptying BLOB file: " + ex.getMessage());
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


    

}



