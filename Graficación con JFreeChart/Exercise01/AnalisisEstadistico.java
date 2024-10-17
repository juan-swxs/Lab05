
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import programAesthetic.BackgroundPanel;

public class AnalisisEstadistico extends JFrame {

    private JPanel panel;
    private BackgroundPanel subpanel;
    private BackgroundPanel panel3;

    public AnalisisEstadistico() {
        setSize(570,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panels();
        changeText();
        changeButtons();
    }

    private void panels() {
        panel = new JPanel();
        panel.setBackground(new Color(60,45,45));
        panel.setLayout(null);

        subpanel = new BackgroundPanel("Images/Dermatologia.jpg");
        subpanel.setLayout(null);
        subpanel.setBounds(64, 54, 160, 250);

        panel3 = new BackgroundPanel("Images/Fondo.png");
        panel3.setLayout(null);
        panel3.setFocusable(true);
        panel3.setBounds(222, 54, 269, 250);

        JSeparator separator = new JSeparator(SwingConstants.CENTER);
        separator.setForeground(new Color(158,136,124));
        separator.setBounds(0,8,160,110);

        JSeparator separator2 = new JSeparator(SwingConstants.CENTER);
        separator2.setForeground(new Color(158,136,124));
        separator2.setBounds(0,238,160,110);


        subpanel.add(separator);
        subpanel.add(separator2);
        panel.add(subpanel);
        panel.add(panel3);
        this.getContentPane().add(panel);
    }

    private void changeText() {
        JLabel title = new JLabel("DERMATOLOGY  DATA");
        title.setFont(new Font("Microsoft Uighur", Font.ROMAN_BASELINE, 21));
        title.setBounds(197,5,180,30);

        JLabel title2 = new JLabel("Beauty");
        title2.setBounds(257,18,100,30);

        JLabel textButton = new JLabel("Ingresar Datos");
        textButton.setBounds(73, 355, 100, 30);

        JLabel textSelectGraph = new JLabel("Elegir grafica");
        textSelectGraph.setBounds(238, 355, 100, 30); 

        JLabel textDischarge = new JLabel("Descargar csv");
        textDischarge.setBounds(392, 355, 100, 30);

        panel.add(title);
        panel.add(title2);
        panel.add(textButton);
        panel.add(textSelectGraph);
        panel.add(textDischarge);
    }

    private void changeButtons() {
        JButton button = new JButton("📝");
        button.setFont(new Font("serif", Font.ROMAN_BASELINE, 26));
        button.setBounds(85, 314,55, 55);

        JButton selectGraph = new JButton("📊");
        selectGraph.setFont(new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 25));
        selectGraph.setBounds(244, 314, 55, 55);

        JButton discharge = new JButton("📥");
        discharge.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        discharge.setBounds(400, 314, 55, 55);
        
        SwingUtilities.invokeLater(() -> panel3.requestFocusInWindow());
        panel.add(button);
        panel.add(selectGraph);
        panel.add(discharge);
    }


}
