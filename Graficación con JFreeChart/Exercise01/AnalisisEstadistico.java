
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import programAesthetic.BackgroundPanel;

public class AnalisisEstadistico extends JFrame {

    private JPanel panel;
    private JPanel panelSetting;
    private JPanel panelInto;
    private CardLayout cardLayout;
    private BackgroundPanel subpanel;
    private BackgroundPanel panel3;

    public AnalisisEstadistico() {
        setSize(570, 460);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panels();
        changeText();
        changeButtons();
    }

    private void panels() {
        cardLayout = new CardLayout();
        panelSetting = new JPanel();
        panelSetting.setLayout(cardLayout);

        panel = new JPanel();
        panel.setBackground(new Color(60, 45, 45));
        panel.setLayout(null);

        subpanel = new BackgroundPanel("Images/Dermatologia.jpg");
        subpanel.setLayout(null);
        subpanel.setBounds(64, 54, 160, 250);

        panel3 = new BackgroundPanel("Images/Fondo.png");
        panel3.setLayout(null);
        panel3.setFocusable(true);
        panel3.setBounds(222, 54, 269, 250);

        panelInto = new JPanel();
        panelInto.setLayout(null);

        JSeparator separator = new JSeparator(SwingConstants.CENTER);
        separator.setForeground(new Color(158, 136, 124));
        separator.setBounds(0, 8, 160, 110);

        JSeparator separator2 = new JSeparator(SwingConstants.CENTER);
        separator2.setForeground(new Color(158, 136, 124));
        separator2.setBounds(0, 238, 160, 110);

        subpanel.add(separator);
        subpanel.add(separator2);
        panel.add(subpanel);
        panel.add(panel3);
        panelSetting.add(panel);
        panelSetting.add(panelInto, "Ingreso datos");
        this.getContentPane().add(panelSetting);
    }

    private void changeText() {
        JLabel title = new JLabel("DERMATOLOGY  DATA");
        title.setFont(new Font("Microsoft Uighur", Font.ROMAN_BASELINE, 21));
        title.setBounds(197, 5, 180, 30);

        JLabel title2 = new JLabel("Beauty");
        title2.setBounds(257, 18, 100, 30);

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
        button.setBounds(85, 314, 50, 50);
        button.addActionListener(e -> {
            cardLayout.show(panelSetting, "Ingreso datos");
            createForm();
        });

        JButton selectGraph = new JButton("📊");
        selectGraph.setFont(new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 25));
        selectGraph.setBounds(244, 314, 50, 50);

        JButton discharge = new JButton("📥");
        discharge.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        discharge.setBounds(400, 314, 50, 50);

        SwingUtilities.invokeLater(() -> panel3.requestFocusInWindow());
        panel.add(button);
        panel.add(selectGraph);
        panel.add(discharge);
    }

    private void createForm() {
        labelsForm();

        JTextField fecha = new JTextField();
        fecha.setBounds(30, 81, 480, 25);

        JTextField edad = new JTextField();
        edad.setBounds(30, 145, 190, 25);

        JComboBox<String> sexo = new JComboBox<>(new String[] { "Masculino", "Femenino" });
        sexo.setSelectedIndex(-1);
        sexo.setBounds(300, 145, 190, 25);

        JComboBox<String> diagnostico = new JComboBox<>(new String[] { "Acne Quistico", "Dermatitis Seborreica",
                "Rosacea", "Lentigo Solar", "Fotoenvejecimiento" });
        diagnostico.setSelectedIndex(-1);
        diagnostico.setBounds(30, 254, 190, 25);

        JComboBox<String> principal = new JComboBox<>(new String[] { "Si", "No", "Formas y causas no especificada",
                "Debido a cosmeticos", "Debido a otros agentes", "Debido a droguas en contacto con la piel" });
        principal.setSelectedIndex(-1);
        principal.setBounds(300, 254, 190, 25);

        JComboBox<String> tipo = new JComboBox<>(new String[] { "Presuntivo", "Definitivo" });
        tipo.setSelectedIndex(-1);
        tipo.setBounds(30, 325, 130, 25);

        JComboBox<String> clase = new JComboBox<>(new String[] { "Confirmado nuevo", "Confirmado repetido", "Impresion diagnostica" });
        clase.setSelectedIndex(-1);
        clase.setBounds(190, 325, 130, 25);

        JComboBox<String> especialidad = new JComboBox<>(new String[] { "Dermatologia", "Cirugia Plastica",
                "Dermatopediatria", "Cirugia dermatologica", "Hansen", "Ulceras", "Cirugia vascular periferica",
                "Fisioterapia", "Actividad fototerapia", "Consulta prequirurgica", "Leishmaniasis" });
        especialidad.setSelectedIndex(-1);
        especialidad.setBounds(350, 325, 170, 25);

        JButton backButton = new JButton("Regresar");
        backButton.setBackground(new Color(20, 20, 20));
        backButton.setBounds(40, 374, 100, 30);
        backButton.addActionListener(e -> {
            cardLayout.previous(panelSetting);
        });

        JButton login = new JButton("Login");
        login.setBackground(new Color(20, 20, 20));
        login.setBounds(390, 374, 100, 30);
        

        panelInto.add(fecha);
        panelInto.add(edad);
        panelInto.add(sexo);
        panelInto.add(diagnostico);
        panelInto.add(principal);
        panelInto.add(tipo);
        panelInto.add(clase);
        panelInto.add(especialidad);
        panelInto.add(backButton);
        panelInto.add(login);
    }

    private void labelsForm() {
        JLabel title2 = new JLabel("Datos personales");
        title2.setForeground(null);
        title2.setFont(new Font("Times new roman", Font.ITALIC, 16));
        title2.setBounds(30, 10, 120, 30);

        JSeparator separator = new JSeparator(SwingConstants.CENTER);
        separator.setBounds(30, 42, 490, 190);

        JLabel textFecha = new JLabel("Fecha");
        textFecha.setForeground(null);
        textFecha.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textFecha.setBounds(30, 50, 80, 30);

        JLabel textEdad = new JLabel("Edad");
        textEdad.setForeground(null);
        textEdad.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textEdad.setBounds(30, 114, 70, 30);

        JLabel textSexo = new JLabel("Sexo");
        textSexo.setForeground(null);
        textSexo.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textSexo.setBounds(300, 114, 70, 30);

        JLabel title3 = new JLabel("Datos medicos");
        title3.setForeground(null);
        title3.setFont(new Font("Times new roman", Font.ITALIC, 16));
        title3.setBounds(30, 182, 120, 30);

        JSeparator separator2 = new JSeparator(SwingConstants.CENTER);
        separator2.setBounds(30, 213, 490, 190);

        JLabel textDiagnostico = new JLabel("Diagnostico");
        textDiagnostico.setForeground(null);
        textDiagnostico.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textDiagnostico.setBounds(30, 219, 80, 30);

        JLabel textPrincipal = new JLabel("Principal");
        textPrincipal.setForeground(null);
        textPrincipal.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textPrincipal.setBounds(300, 219, 80, 30);

        JLabel textTipo = new JLabel("Tipo");
        textTipo.setForeground(null);
        textTipo.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textTipo.setBounds(30, 293, 80, 30);

        JLabel textClase = new JLabel("Clase");
        textClase.setForeground(null);
        textClase.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textClase.setBounds(190, 293, 70, 30);

        JLabel textEspecialidad = new JLabel("Especialidad");
        textEspecialidad.setForeground(null);
        textEspecialidad.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textEspecialidad.setBounds(350, 293, 80, 30);

        panelInto.add(title2);
        panelInto.add(separator);
        panelInto.add(textFecha);
        panelInto.add(textEdad);
        panelInto.add(textSexo);
        panelInto.add(title3);
        panelInto.add(separator2);
        panelInto.add(textDiagnostico);
        panelInto.add(textPrincipal);
        panelInto.add(textTipo);
        panelInto.add(textClase);
        panelInto.add(textEspecialidad);

    }

}
