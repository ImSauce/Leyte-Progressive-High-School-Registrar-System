
package run;

import Frame.Login;
import Frame.main;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class run {
    public static void main(String[] args) {
  
       FlatIntelliJLaf.registerCustomDefaultsSource("style");
       FlatIntelliJLaf.setup();
       UIManager.put("TitlePane.unifiedBackground", false);
       UIManager.getColor("Label.disabledForeground");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
