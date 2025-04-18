
package Frame;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class ViewStudentImageArchive1 extends javax.swing.JFrame {

   
 Connection con = null;
PreparedStatement pst = null;

String url="jdbc:mysql://localhost/lphs5";
String user = "root";
String pass="";

ResultSet rs;

private ImageIcon format1 = null;

    
    
    
    
    
    public ViewStudentImageArchive1(String lrnValue) {
        initComponents();
        
        
        
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        
 
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
        setTitle("Birth Certificate");
        setResizable(true);
        
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

        jPanel1 = new javax.swing.JPanel();
        closeBT = new javax.swing.JButton();
        viewBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        view = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        closeBT.setText("Close");
        closeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBTActionPerformed(evt);
            }
        });

        viewBT.setText("jButton1");
        viewBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBTActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(247, 247, 247));

        view.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        view.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/zoomout.jpg"))); // NOI18N
        jButton2.setText("zoom out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/zoomin.jpg"))); // NOI18N
        jButton1.setText("zoom in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewBT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(closeBT, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(closeBT)
                        .addComponent(viewBT, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBTActionPerformed
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        dispose();
    }//GEN-LAST:event_closeBTActionPerformed

    private void viewBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBTActionPerformed
    
   
    }//GEN-LAST:event_viewBTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        zoomIcon(view, 1.1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        zoomIcon2(view, 0.9);
    }//GEN-LAST:event_jButton2ActionPerformed

  
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
    //Automatically run the refresh button when the app is run for the first time    
    //activated in the innitcomponents
    viewBTActionPerformed(null);
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel view;
    public javax.swing.JButton viewBT;
    // End of variables declaration//GEN-END:variables

    
    

   public void LoadImageID1(String LRN){
      
       
  try {
       
        System.out.println(LRN);
        
        pst = con.prepareStatement("SELECT imageFile1 FROM archive WHERE lrn=?");
        pst.setString(1, LRN);
        System.out.println(pst);
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
   
   public void LoadImage1() {
    try {
        byte[] imagedata = rs.getBytes("imageFile1");
        format1 = new ImageIcon(imagedata);
        Image img = format1.getImage();
        
        // Get the original width and height of the image
        int originalWidth = img.getWidth(null);
        int originalHeight = img.getHeight(null);
        
        // Set the ImageIcon to your label
        view.setIcon(format1);
        
        // Adjust the size of the label to fit the image
        view.setSize(originalWidth, originalHeight);
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
}
   


private void zoomIcon(JLabel label, double factor) {
        ImageIcon icon = (ImageIcon) label.getIcon();
        Image img = icon.getImage();
        
        int width = (int) (img.getWidth(null) * factor);
        int height = (int) (img.getHeight(null) * factor);
        
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(newImg));
    }

    private void zoomIcon2(JLabel label, double factor) {
    ImageIcon icon = (ImageIcon) label.getIcon();
    Image img = icon.getImage();
    
    int width = (int) (img.getWidth(null) * factor);
    int height = (int) (img.getHeight(null) * factor);
    
    Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    label.setIcon(new ImageIcon(newImg));
}


    
    
     
     public void LoadImageID1_(String LRN){
      
       
  try {
       
        System.out.println(LRN);
        
        pst = con.prepareStatement("SELECT imageFile1 FROM archive WHERE lrn=?");
        pst.setString(1, LRN);
        System.out.println(pst);
        // Execute the query and assign the result set to rs
        rs = pst.executeQuery();

        if (rs.next()){
        LoadImage1_();
        
        
        
        } else {
            JOptionPane.showMessageDialog(this, "no image found");
        }
        
        
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  
  
   }
    

    public void LoadImage1_(){
   
    try {
        
        byte[] imagedata = rs.getBytes("imageFile1");
        format1 = new ImageIcon(imagedata);
        Image mm = format1.getImage();
        Image img2 = mm.getScaledInstance(646,605,Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        view.setIcon(image);
       
       
    } catch (SQLException ex) {
        Logger.getLogger(editStudent.class.getName()).log(Level.SEVERE, null, ex);
    }
   }


}
