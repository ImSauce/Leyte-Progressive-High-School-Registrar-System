
package Frame;

import com.mysql.cj.protocol.Resultset;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;


public class viewStudentTransferin extends javax.swing.JFrame {
Connection con = null;
PreparedStatement pst = null;
Statement st;






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

ResultSet rs;
 






    public viewStudentTransferin() {
        
        
        
        
        
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
        setTitle("View Student");
        setResizable(false);
        
        
        //TextArea Margin to the left
        
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
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        credentialFrame = new javax.swing.JPanel();
        titleRP = new RoundedPanel(30, new Color(222, 235, 247));
        credentialslabel = new javax.swing.JLabel();
        scrollCredentials = new javax.swing.JScrollPane();
        CredentialPanel = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Description = new javax.swing.JTextArea();
        firstname = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        BirthCertificateCB = new javax.swing.JCheckBox();
        sf9CB = new javax.swing.JCheckBox();
        sf10CB = new javax.swing.JCheckBox();
        imageView1 = new javax.swing.JLabel();
        imageView2 = new javax.swing.JLabel();
        imageView3 = new javax.swing.JLabel();
        imagePath1 = new javax.swing.JTextField();
        imagePath3 = new javax.swing.JTextField();
        imagePath2 = new javax.swing.JTextField();
        downloadImage1 = new javax.swing.JButton();
        downloadImage2 = new javax.swing.JButton();
        downloadImage3 = new javax.swing.JButton();
        viewBT1 = new javax.swing.JButton();
        viewBT2 = new javax.swing.JButton();
        viewBT3 = new javax.swing.JButton();
        middlename = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        lrn = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        ad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sex = new javax.swing.JTextField();
        birthday = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        grade = new javax.swing.JTextField();
        schoolyear = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        credentialFrame.setBackground(new java.awt.Color(255, 255, 255));

        titleRP.setBackground(new java.awt.Color(222, 235, 247));
        titleRP.setOpaque(false);

        credentialslabel.setBackground(new java.awt.Color(255, 255, 255));
        credentialslabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        credentialslabel.setForeground(new java.awt.Color(0, 0, 0));
        credentialslabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        credentialslabel.setText("View Credentials");

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

        scrollCredentials.setBorder(null);
        scrollCredentials.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollCredentials.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        CredentialPanel.setBackground(new java.awt.Color(255, 255, 255));

        email.setEditable(false);
        email.setBackground(new java.awt.Color(246, 246, 246));

        Description.setEditable(false);
        Description.setBackground(new java.awt.Color(246, 246, 246));
        Description.setColumns(20);
        Description.setRows(5);
        Description.setBorder(null);
        jScrollPane1.setViewportView(Description);

        firstname.setEditable(false);
        firstname.setBackground(new java.awt.Color(246, 246, 246));

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

        imageView3.setBackground(new java.awt.Color(246, 246, 246));
        imageView3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imagePath1.setEditable(false);
        imagePath1.setBackground(new java.awt.Color(255, 255, 255));
        imagePath1.setForeground(new java.awt.Color(0, 0, 0));
        imagePath1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imagePath3.setEditable(false);
        imagePath3.setBackground(new java.awt.Color(255, 255, 255));
        imagePath3.setForeground(new java.awt.Color(0, 0, 0));
        imagePath3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        imagePath2.setEditable(false);
        imagePath2.setBackground(new java.awt.Color(255, 255, 255));
        imagePath2.setForeground(new java.awt.Color(0, 0, 0));
        imagePath2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        downloadImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/downloadImage.jpg"))); // NOI18N
        downloadImage1.setToolTipText("Download Image");
        downloadImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadImage1ActionPerformed(evt);
            }
        });

        downloadImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/downloadImage.jpg"))); // NOI18N
        downloadImage2.setToolTipText("Download Image");
        downloadImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadImage2ActionPerformed(evt);
            }
        });

        downloadImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/downloadImage.jpg"))); // NOI18N
        downloadImage3.setToolTipText("Download Image");
        downloadImage3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadImage3ActionPerformed(evt);
            }
        });

        viewBT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.jpg"))); // NOI18N
        viewBT1.setToolTipText("View Image");
        viewBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBT1ActionPerformed(evt);
            }
        });

        viewBT2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.jpg"))); // NOI18N
        viewBT2.setToolTipText("View Image");
        viewBT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBT2ActionPerformed(evt);
            }
        });

        viewBT3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view.jpg"))); // NOI18N
        viewBT3.setToolTipText("View Image");
        viewBT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBT3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imagePath1, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                    .addComponent(BirthCertificateCB)
                    .addComponent(imageView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(downloadImage1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(imagePath2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addComponent(imageView2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(sf9CB)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(downloadImage2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(downloadImage3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewBT3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sf10CB)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(imageView3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagePath3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BirthCertificateCB)
                    .addComponent(sf10CB)
                    .addComponent(sf9CB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageView2, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(imageView3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagePath3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagePath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagePath1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(downloadImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downloadImage3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(downloadImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewBT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewBT2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewBT3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        middlename.setEditable(false);
        middlename.setBackground(new java.awt.Color(246, 246, 246));

        lastname.setEditable(false);
        lastname.setBackground(new java.awt.Color(246, 246, 246));

        lrn.setEditable(false);
        lrn.setBackground(new java.awt.Color(246, 246, 246));
        lrn.setToolTipText("LRN must contain 12 numbers");

        contact.setEditable(false);
        contact.setBackground(new java.awt.Color(246, 246, 246));
        contact.setToolTipText("Contact must contain 11 numbers");

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Last Name");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("First Name");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Description");

        address.setEditable(false);
        address.setBackground(new java.awt.Color(246, 246, 246));

        ad.setForeground(new java.awt.Color(0, 0, 0));
        ad.setText("Address");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Middle Name");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("LRN");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Requirements");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Contact");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Email");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(174, 174, 174));
        jLabel13.setText("MM/DD/YYYY");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Sex");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Date of Birth");

        sex.setEditable(false);
        sex.setBackground(new java.awt.Color(246, 246, 246));

        birthday.setEditable(false);
        birthday.setBackground(new java.awt.Color(246, 246, 246));
        birthday.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Grade Level");

        grade.setEditable(false);
        grade.setBackground(new java.awt.Color(246, 246, 246));

        schoolyear.setEditable(false);
        schoolyear.setBackground(new java.awt.Color(246, 246, 246));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Year Transferred");

        javax.swing.GroupLayout CredentialPanelLayout = new javax.swing.GroupLayout(CredentialPanel);
        CredentialPanel.setLayout(CredentialPanelLayout);
        CredentialPanelLayout.setHorizontalGroup(
            CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CredentialPanelLayout.createSequentialGroup()
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(ad))
                        .addGap(18, 18, 18)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(middlename)
                            .addComponent(firstname)
                            .addComponent(lastname)
                            .addComponent(contact)
                            .addComponent(address)
                            .addComponent(email)
                            .addComponent(lrn)))
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(schoolyear, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CredentialPanelLayout.setVerticalGroup(
            CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CredentialPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(middlename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CredentialPanelLayout.createSequentialGroup()
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lrn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(33, 33, 33)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CredentialPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ad)))
                        .addGap(31, 31, 31)
                        .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(CredentialPanelLayout.createSequentialGroup()
                                .addComponent(grade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(CredentialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(schoolyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 89, Short.MAX_VALUE))
        );

        scrollCredentials.setViewportView(CredentialPanel);

        javax.swing.GroupLayout credentialFrameLayout = new javax.swing.GroupLayout(credentialFrame);
        credentialFrame.setLayout(credentialFrameLayout);
        credentialFrameLayout.setHorizontalGroup(
            credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentialFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollCredentials)
                    .addComponent(titleRP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        credentialFrameLayout.setVerticalGroup(
            credentialFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(credentialFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleRP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCredentials, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(credentialFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(credentialFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void downloadImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadImage1ActionPerformed
       download1();
    }//GEN-LAST:event_downloadImage1ActionPerformed

    private void downloadImage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadImage2ActionPerformed
       download2();
    }//GEN-LAST:event_downloadImage2ActionPerformed

    private void downloadImage3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadImage3ActionPerformed
      download3();
    }//GEN-LAST:event_downloadImage3ActionPerformed

    private void viewBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBT1ActionPerformed
    String lrnValue = lrn.getText(); // Assuming lrn is the text field containing the LRN value
    ViewStudentImageTransferin1 view = new ViewStudentImageTransferin1(lrnValue);
    //view.LoadImageID1(lrnValue);
    view.LoadImageID1_(lrnValue);
    view.setVisible(true);
    }//GEN-LAST:event_viewBT1ActionPerformed

    private void viewBT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBT2ActionPerformed
    String lrnValue = lrn.getText(); // Assuming lrn is the text field containing the LRN value
    ViewStudentImageTransferin2 view = new ViewStudentImageTransferin2(lrnValue);
    //view.LoadImageID2(lrnValue);
    view.LoadImageID2_(lrnValue);
    view.setVisible(true); 
    }//GEN-LAST:event_viewBT2ActionPerformed

    private void viewBT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBT3ActionPerformed
    String lrnValue = lrn.getText(); // Assuming lrn is the text field containing the LRN value
    ViewStudentImageTransferin3 view = new ViewStudentImageTransferin3(lrnValue);
    //view.LoadImageID3(lrnValue);
    view.LoadImageID3_(lrnValue);
    view.setVisible(true);
    
    }//GEN-LAST:event_viewBT3ActionPerformed

    
    
    
    
    
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JCheckBox BirthCertificateCB;
    private javax.swing.JPanel CredentialPanel;
    public javax.swing.JTextArea Description;
    private javax.swing.JLabel ad;
    public javax.swing.JTextField address;
    public javax.swing.JTextField birthday;
    public javax.swing.JTextField contact;
    private javax.swing.JPanel credentialFrame;
    private javax.swing.JLabel credentialslabel;
    private javax.swing.JButton downloadImage1;
    private javax.swing.JButton downloadImage2;
    private javax.swing.JButton downloadImage3;
    public javax.swing.JTextField email;
    public javax.swing.JTextField firstname;
    public javax.swing.JTextField grade;
    public javax.swing.JTextField imagePath1;
    public javax.swing.JTextField imagePath2;
    public javax.swing.JTextField imagePath3;
    public javax.swing.JLabel imageView1;
    public javax.swing.JLabel imageView2;
    public javax.swing.JLabel imageView3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
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
    public javax.swing.JTextField lastname;
    public javax.swing.JTextField lrn;
    public javax.swing.JTextField middlename;
    public javax.swing.JTextField schoolyear;
    private javax.swing.JScrollPane scrollCredentials;
    public javax.swing.JTextField sex;
    public javax.swing.JCheckBox sf10CB;
    public javax.swing.JCheckBox sf9CB;
    private javax.swing.JPanel titleRP;
    private javax.swing.JButton viewBT1;
    private javax.swing.JButton viewBT2;
    private javax.swing.JButton viewBT3;
    // End of variables declaration//GEN-END:variables
//////////////////////////////////////////////////////////////    
//////////////////////////////////////////////////////////////    
/////////                METHODS            //////////////////
//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
    

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
        
        
        pst = con.prepareStatement("SELECT imageFile1, imagePath1 FROM transferin WHERE lrn=?");
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
        
        pst = con.prepareStatement("SELECT imageFile2 FROM transferin WHERE lrn=?");
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
        
        pst = con.prepareStatement("SELECT imageFile3 FROM transferin WHERE lrn=?");
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

    FileOutputStream fos = null;
    
  public void download1() {
    try {
        String LRN = lrn.getText();

        // SQL query to retrieve the blob data and image name
        String sql = "SELECT imageFile1, imageName1 FROM transferin WHERE lrn=?";
        
        pst = con.prepareStatement(sql);
        pst.setString(1, LRN); // Set the parameter value
        rs = pst.executeQuery();

        if (rs.next()) {
            // Retrieve the blob data
            Blob blob = rs.getBlob("imageFile1");
            
            // Check if the blob data is not null and has non-zero length
            if (blob != null && blob.length() > 0) {
                // Retrieve the image name from the database
                String imageName = rs.getString("imageName1");
                
                // Generate a random number between 1 and 100
                Random random = new Random();
                int randomNumber = random.nextInt(1000000) + 1;

                // Convert blob data to file
                InputStream in = blob.getBinaryStream();
                
                // Determine the default download folder path
                String defaultDownloadFolderPath = System.getProperty("user.home") + File.separator + "Downloads";

                // Create the default download folder if it does not exist
                File defaultDownloadFolder = new File(defaultDownloadFolderPath);
                if (!defaultDownloadFolder.exists()) {
                    defaultDownloadFolder.mkdirs();
                }
                
                // Create a file in the default download folder with the image name from the database
                // and a random number appended to it
                String fileName = imageName + "__" + randomNumber + ".png";
                File file = new File(defaultDownloadFolder, fileName);

                fos = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("File downloaded successfully.");
                System.out.println("File saved at: " + file.getAbsolutePath()); // Print the absolute path of the downloaded file
                
                // Show JOptionPane message with file directory
                JOptionPane.showMessageDialog(null, "File downloaded successfully.\nFile saved at: " + file.getAbsolutePath());
            } else {
                System.out.println("No image available for download.");
                JOptionPane.showMessageDialog(null, "No image available for download.");
            }
        } else {
            System.out.println("No data found.");
        }
    } catch (SQLException | IOException e) {
        e.printStackTrace();
    }
}  
   
   
  public void download2() {
    try {
        String LRN = lrn.getText();

        // SQL query to retrieve the blob data and image name
        String sql = "SELECT imageFile2, imageName2 FROM transferin WHERE lrn=?";
        
        pst = con.prepareStatement(sql);
        pst.setString(1, LRN); // Set the parameter value
        rs = pst.executeQuery();

        if (rs.next()) {
            // Retrieve the blob data
            Blob blob = rs.getBlob("imageFile2");
            
            // Check if the blob data is not null and has non-zero length
            if (blob != null && blob.length() > 0) {
                // Retrieve the image name from the database
                String imageName = rs.getString("imageName2");
                
                // Generate a random number between 1 and 100
                Random random = new Random();
                int randomNumber = random.nextInt(1000000) + 1;

                // Convert blob data to file
                InputStream in = blob.getBinaryStream();
                
                // Determine the default download folder path
                String defaultDownloadFolderPath = System.getProperty("user.home") + File.separator + "Downloads";

                // Create the default download folder if it does not exist
                File defaultDownloadFolder = new File(defaultDownloadFolderPath);
                if (!defaultDownloadFolder.exists()) {
                    defaultDownloadFolder.mkdirs();
                }
                
                // Create a file in the default download folder with the image name from the database
                // and a random number appended to it
                String fileName = imageName + "__" + randomNumber + ".png";
                File file = new File(defaultDownloadFolder, fileName);

                fos = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("File downloaded successfully.");
                System.out.println("File saved at: " + file.getAbsolutePath()); // Print the absolute path of the downloaded file
                
                // Show JOptionPane message with file directory
                JOptionPane.showMessageDialog(null, "File downloaded successfully.\nFile saved at: " + file.getAbsolutePath());
            } else {
                System.out.println("No image available for download.");
                JOptionPane.showMessageDialog(null, "No image available for download.");
            }
        } else {
            System.out.println("No data found.");
        }
    } catch (SQLException | IOException e) {
        e.printStackTrace();
    }
}  
  
  
public void download3() {
    try {
        String LRN = lrn.getText();

        // SQL query to retrieve the blob data and image name
        String sql = "SELECT imageFile3, imageName3 FROM transferin WHERE lrn=?";
        
        pst = con.prepareStatement(sql);
        pst.setString(1, LRN); // Set the parameter value
        rs = pst.executeQuery();

        if (rs.next()) {
            // Retrieve the blob data
            Blob blob = rs.getBlob("imageFile3");
            
            // Check if the blob data is not null and has non-zero length
            if (blob != null && blob.length() > 0) {
                // Retrieve the image name from the database
                String imageName = rs.getString("imageName3");
                
                // Generate a random number between 1 and 100
                Random random = new Random();
                int randomNumber = random.nextInt(1000000) + 1;

                // Convert blob data to file
                InputStream in = blob.getBinaryStream();
                
                // Determine the default download folder path
                String defaultDownloadFolderPath = System.getProperty("user.home") + File.separator + "Downloads";

                // Create the default download folder if it does not exist
                File defaultDownloadFolder = new File(defaultDownloadFolderPath);
                if (!defaultDownloadFolder.exists()) {
                    defaultDownloadFolder.mkdirs();
                }
                
                // Create a file in the default download folder with the image name from the database
                // and a random number appended to it
                String fileName = imageName + "__" + randomNumber + ".png";
                File file = new File(defaultDownloadFolder, fileName);

                fos = new FileOutputStream(file);
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("File downloaded successfully.");
                System.out.println("File saved at: " + file.getAbsolutePath()); // Print the absolute path of the downloaded file
                
                // Show JOptionPane message with file directory
                JOptionPane.showMessageDialog(null, "File downloaded successfully.\nFile saved at: " + file.getAbsolutePath());
            } else {
                System.out.println("No image available for download.");
                JOptionPane.showMessageDialog(null, "No image available for download.");
            }
        } else {
            System.out.println("No data found.");
        }
    } catch (SQLException | IOException e) {
        e.printStackTrace();
    }
}  
    
   
}



