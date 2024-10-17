
import java.awt.Color;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;
   
public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatMaterialDarkerIJTheme.setup();
        UIManager.put("Component.focusWidth", 0);
        UIManager.put("Button.background", new Color(60,45,45));
        UIManager.put("Button.foreground", new Color(250,250,250,180));
        UIManager.put("Button.arc", 999);
        UIManager.put("Button.borderWidth", 0);
        UIManager.put("Label.foreground", Color.WHITE);
        AnalisisEstadistico hola = new AnalisisEstadistico();

        SwingUtilities.updateComponentTreeUI(hola);
        hola.setVisible(true);
    }
}