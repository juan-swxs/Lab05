
import java.awt.Color;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
   
public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatMacDarkLaf.setup();
        UIManager.put("Component.focusWidth", 0);
        UIManager.put("Button.background", new Color(60,45,45));
        UIManager.put("Button.foreground", new Color(250, 250, 250, 180));
        UIManager.put("Button.arc", 999);
        UIManager.put("Button.borderWidth", 0);
        UIManager.put("Label.foreground", new Color(238, 218, 207));
        UIManager.put("TextField.foreground", new Color(236,236,236,120));
        AnalisisEstadistico graficas = new AnalisisEstadistico();

        SwingUtilities.updateComponentTreeUI(graficas);
        graficas.setVisible(true);
    }
}