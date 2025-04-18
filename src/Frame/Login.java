
package Frame;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;




public class Login extends javax.swing.JFrame {
    
    String url= "jdbc:mysql://localhost/lphs5";
        String user = "root";
        String pass= "";
        Statement st;
        ResultSet rs;
        Connection con = null; //sql
    PreparedStatement pst = null; //sql
    
    
    String USERNAME = "sam";
    String PASSWORD = "123samboy";

   
    public Login() {
        initComponents();
        
      
         //MYSQL CODE-----------------------------------------------

        try{
        con = DriverManager.getConnection(url, user, pass);
        }catch(Exception ex){
            System.out.println("Error: " +ex.getMessage());  
        }
        //MYSQL CODE-----------------------------------------------
        
        
         ImageIcon logo = new ImageIcon("lphslogo.png");   
        setIconImage(logo.getImage());
        setTitle("Login");
        setResizable(false);
        
        setupDarkModeButton();
        setupLightModeButton();
        
    }
 
    
    

    private void openMainApplicationFrame() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                main main = new main();
                main.setVisible(true);
                main.setVisible(false);
                //   new Frame.SplashScreen(null, true).setVisible(true);
                main.setVisible(true);
            }
        });
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        curvesPanel2 = new Frame.CurvesPanel();
        pH_Label1 = new SystemOtherComps.PH_Label();
        Title = new javax.swing.JLabel();
        username = new SystemOtherComps.PH_TextField();
        password = new SystemOtherComps.PH_PasswordField();
        pH_Button1 = new SystemOtherComps.PH_Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        pH_Label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lphslogo.png"))); // NOI18N

        Title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Title.setForeground(new java.awt.Color(0, 0, 0));
        Title.setText("<html>Welcome to<br>\n<b>LPHS REGISTRAR SYSTEM</b></html>\n");
        Title.setToolTipText("");

        username.setForeground(new java.awt.Color(0, 0, 0));
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setAA_TextHint("username");
        username.setAB_LineColor(new java.awt.Color(0, 0, 0));

        password.setForeground(new java.awt.Color(0, 0, 0));
        password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password.setAA_TextHint("password");
        password.setAB_LineColor(new java.awt.Color(0, 0, 0));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        pH_Button1.setBackground(new java.awt.Color(255, 255, 255));
        pH_Button1.setBorder(null);
        pH_Button1.setForeground(new java.awt.Color(0, 0, 0));
        pH_Button1.setText("ENTER");
        pH_Button1.setToolTipText("");
        pH_Button1.setAAA_AutoFitToSize(true);
        pH_Button1.setAAA_ImageBoundArcSize(20);
        pH_Button1.setAAA_roundBottomLeft(20);
        pH_Button1.setAAA_roundBottomRight(20);
        pH_Button1.setAAA_roundTopLeft(20);
        pH_Button1.setAAA_roundTopRight(20);
        pH_Button1.setAA_ArcSize(20);
        pH_Button1.setAA_BorderColor(new java.awt.Color(51, 72, 94));
        pH_Button1.setAA_ButtonColor(new java.awt.Color(174, 198, 230));
        pH_Button1.setAA_DrawBorder(true);
        pH_Button1.setAA_HoverColor(new java.awt.Color(129, 175, 211));
        pH_Button1.setAA_OpaqueBackground(true);
        pH_Button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pH_Button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout curvesPanel2Layout = new javax.swing.GroupLayout(curvesPanel2);
        curvesPanel2.setLayout(curvesPanel2Layout);
        curvesPanel2Layout.setHorizontalGroup(
            curvesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(curvesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(curvesPanel2Layout.createSequentialGroup()
                        .addGroup(curvesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(curvesPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(pH_Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33))
                    .addGroup(curvesPanel2Layout.createSequentialGroup()
                        .addComponent(pH_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(49, Short.MAX_VALUE))))
        );
        curvesPanel2Layout.setVerticalGroup(
            curvesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(curvesPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(curvesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pH_Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(pH_Button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curvesPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(curvesPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

     Sounds sfx = new Sounds();
    private Clip clip;
    private void pH_Button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pH_Button1ActionPerformed

        
        sfx.playSound2(clip);
        
        
        char[] enteredPasswordChars = password.getPassword();
        String enteredPassword = new String(enteredPasswordChars);

        String sqlQuery = "SELECT username, password FROM login WHERE id=1";
        try {
            PreparedStatement pst = con.prepareStatement(sqlQuery);
            ResultSet rs = pst.executeQuery();

            // Assuming you have only one record with id=1
            if (rs.next()) {
                String usernameDB = rs.getString("username");
                String passwordDB = rs.getString("password");

                // Check if the entered credentials are correct
                if (usernameDB.equals(username.getText()) && passwordDB.equals(enteredPassword)) {
                    openMainApplicationFrame();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }

            // Close the ResultSet and PreparedStatement
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_pH_Button1ActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private Frame.CurvesPanel curvesPanel2;
    private SystemOtherComps.PH_Button pH_Button1;
    private SystemOtherComps.PH_Label pH_Label1;
    private SystemOtherComps.PH_PasswordField password;
    private SystemOtherComps.PH_TextField username;
    // End of variables declaration//GEN-END:variables

  private void setupDarkModeButton() {
        JButton darkModeButton = new JButton("Dark Mode");
        darkModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStyle("darkStyle");
            }
        }); 
  }
  
  
   private void setupLightModeButton() {
        JButton lightModeButton = new JButton("Light Mode");
        lightModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeStyle("lightStyle");
            }
        });

        // Add lightModeButton to your JFrame's layout
    }

private void changeStyle(String style) {
        FlatIntelliJLaf.registerCustomDefaultsSource(style);
        FlatIntelliJLaf.setup();
        // Additional customization if needed
        SwingUtilities.updateComponentTreeUI(this);
    }






}



