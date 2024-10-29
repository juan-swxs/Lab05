
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
    private JTextField fecha;
    private JTextField edad;
    private JComboBox<String> sexo;
    private JComboBox<String> diagnostico;
    private JComboBox<String> principal;
    private JComboBox<String> tipo;
    private JComboBox<String> clase;
    private JComboBox<String> especialidad;
    private BarGraph grafico;
    private LineGraph graficoLine;
    private PieChart graficoCircular;
    private ArrayList<Paciente> pacientes;
    private ArrayList<ArrayList<String>> save;

    public AnalisisEstadistico() {
        setSize(570, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pacientes = new ArrayList<>();
        save = new ArrayList<>();
        panels();
        changeText();
        changeButtons();
    }

    private void panels() {
        cardLayout = new CardLayout();
        panelSetting = new JPanel(cardLayout);

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
        createForm();

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
        panelSetting.add(panel, "home");
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

        JLabel icon = new JLabel("🍁");
        icon.setForeground(new Color(74, 56, 54));
        icon.setFont(new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 40));
        icon.setBounds(19, 32, 100, 40);

        JLabel textIcon = new JLabel("Dermatology");
        textIcon.setForeground(new Color(111, 91, 82));
        textIcon.setFont(new Font("Times new roman", Font.ROMAN_BASELINE, 14));
        textIcon.setBounds(66, 28, 100, 30);

        JLabel textIcon2 = new JLabel("Beuty");
        textIcon2.setForeground(new Color(111, 91, 82));
        textIcon2.setFont(new Font("Times new roman", Font.ROMAN_BASELINE, 14));
        textIcon2.setBounds(66, 44, 100, 30);

        JLabel titlePanel3 = new JLabel("DIAGNOSTICS");
        titlePanel3.setForeground(new Color(74, 56, 54));
        titlePanel3.setFont(new Font("Times new roman", Font.ROMAN_BASELINE, 29));
        titlePanel3.setBounds(40, 89, 210, 50);

        JLabel titlePanel4 = new JLabel("  graphic analysis");
        titlePanel4.setForeground(new Color(74, 56, 54));
        titlePanel4.setFont(new Font("Agatha", Font.ITALIC, 32));
        titlePanel4.setBounds(34, 121, 300, 50);

        JLabel titlePanel5 = new JLabel("🍂");
        titlePanel5.setForeground(new Color(74, 56, 54));
        titlePanel5.setFont(new Font("serif", Font.ITALIC, 20));
        titlePanel5.setBounds(170, 139, 50, 30);

        panel.add(title);
        panel.add(title2);
        panel.add(textButton);
        panel.add(textSelectGraph);
        panel.add(textDischarge);
        panel3.add(icon);
        panel3.add(textIcon);
        panel3.add(textIcon2);
        panel3.add(titlePanel3);
        panel3.add(titlePanel4);
        panel3.add(titlePanel5);
    }

    private void changeButtons() {
        JButton button = new JButton("📝");
        button.setFont(new Font("serif", Font.ROMAN_BASELINE, 26));
        button.setBounds(85, 314, 50, 50);
        button.addActionListener(e -> {
            cardLayout.show(panelSetting, "Ingreso datos");
        });

        JButton selectGraph = new JButton("📊");
        selectGraph.setFont(new Font("serif", Font.LAYOUT_RIGHT_TO_LEFT, 25));
        selectGraph.setBounds(244, 314, 50, 50);
        selectGraph.addActionListener(e -> {
            grafico = new BarGraph();
            graficoLine = new LineGraph();
            graficoCircular = new PieChart();
            if (pacientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se ha ingresado datos para la grafica.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            charTypeSelection();
        });

        JButton discharge = new JButton("📥");
        discharge.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        discharge.setBounds(400, 314, 50, 50);
        discharge.addActionListener(e -> {
            if (pacientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay datos para descargar el archivo csv",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }
            generateCsv();
        });

        SwingUtilities.invokeLater(() -> panel3.requestFocusInWindow());
        panel.add(button);
        panel.add(selectGraph);
        panel.add(discharge);
    }

    private void resetForm() {
        fecha.setText("DD/MM/AAAA");
        edad.setText("");
        sexo.setSelectedIndex(-1);
        diagnostico.setSelectedIndex(-1);
        principal.setSelectedIndex(-1);
        tipo.setSelectedIndex(-1);
        clase.setSelectedIndex(-1);
        especialidad.setSelectedIndex(-1);
    }

    private void charTypeSelection() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(300, 73));

        labelsSelectionGraphs(panel);

        JRadioButton barras = new JRadioButton("📊");
        barras.setFont(new Font("serif", Font.ROMAN_BASELINE, 34));
        barras.setBounds(6, 32, 100, 30);
        panel.add(barras);

        JRadioButton Lineas = new JRadioButton("📈");
        Lineas.setFont(new Font("serif", Font.ROMAN_BASELINE, 34));
        Lineas.setBounds(108, 32, 100, 30);
        panel.add(Lineas);

        JRadioButton circular = new JRadioButton("◕");
        circular.setFont(new Font("serif", Font.ROMAN_BASELINE, 45));
        circular.setBounds(210, 27, 100, 36);
        panel.add(circular);

        ButtonGroup group = new ButtonGroup();
        group.add(barras);
        group.add(Lineas);
        group.add(circular);

        int opcion = JOptionPane.showConfirmDialog(null, panel, "Tipos de gráfica", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            if (barras.isSelected()) {
                grafico.generateChart(pacientes);
                grafico.setVisible(true);
            } else if (Lineas.isSelected()) {
                graficoLine.generateChart(pacientes);
                graficoLine.setVisible(true);
            } else if (circular.isSelected()) {
                graficoCircular.generateChart(pacientes);
                graficoCircular.setVisible(true);
            }
        }

    }

    private void labelsSelectionGraphs(JPanel panel) {
        JLabel textBarras = new JLabel("Bar graph");
        textBarras.setForeground(null);
        textBarras.setBounds(18, 0, 80, 30);

        JLabel textLineas = new JLabel("Scatter plot");
        textLineas.setForeground(null);
        textLineas.setBounds(116, 0, 80, 30);

        JLabel textCircular = new JLabel("Circular graph");
        textCircular.setForeground(null);
        textCircular.setBounds(214, 0, 80, 30);

        panel.add(textBarras);
        panel.add(textLineas);
        panel.add(textCircular);
    }

    private void createForm() {
        labelsForm();

        fecha = new JTextField("DD/MM/AAAA");
        fecha.setBounds(30, 77, 480, 25);
        fecha.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (fecha.getText().equals("DD/MM/AAAA")) {
                    fecha.setText("");
                    fecha.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(fecha.getText().isEmpty()) {
                    fecha.setText("DD/MM/AAAA");
                    fecha.setForeground(new Color(236,236,236,120));
                }
               
            }

        });

        edad = new JTextField();
        edad.setForeground(Color.WHITE);
        edad.setBounds(30, 138, 190, 25);

        sexo = new JComboBox<>(new String[] { "Masculino", "Femenino" });
        sexo.setSelectedIndex(-1);
        sexo.setBounds(300, 139, 190, 25);

        diagnostico = new JComboBox<>(new String[] { "Acne Quistico", "Dermatitis Seborreica",
                "Rosacea", "Lentigo Solar", "Fotoenvejecimiento" });
        diagnostico.setSelectedIndex(-1);
        diagnostico.setBounds(30, 246, 190, 25);

        principal = new JComboBox<>(new String[] { "Si", "No", "Formas y causas no especificada",
                "Debido a cosmeticos", "Debido a otros agentes", "Debido a droguas en contacto con la piel" });
        principal.setSelectedIndex(-1);
        principal.setBounds(300, 246, 190, 25);

        tipo = new JComboBox<>(new String[] { "Presuntivo", "Definitivo" });
        tipo.setSelectedIndex(-1);
        tipo.setBounds(30, 317, 130, 25);

        clase = new JComboBox<>(new String[] { "Confirmado nuevo", "Confirmado repetido", "Impresion diagnostica" });
        clase.setSelectedIndex(-1);
        clase.setBounds(190, 317, 130, 25);

        especialidad = new JComboBox<>(new String[] { "Dermatologia", "Cirugia Plastica",
                "Dermatopediatria", "Cirugia dermatologica", "Hansen", "Ulceras", "Cirugia vascular periferica",
                "Fisioterapia", "Actividad fototerapia", "Consulta prequirurgica", "Leishmaniasis" });
        especialidad.setSelectedIndex(-1);
        especialidad.setBounds(350, 317, 170, 25);

        JButton backButton = new JButton("Regresar");
        backButton.setBackground(new Color(20, 20, 20));
        backButton.setBounds(40, 363, 100, 30);
        backButton.addActionListener(e -> {
            cardLayout.show(panelSetting, "home");
        });

        JButton login = new JButton("Login");
        login.setBackground(new Color(20, 20, 20));
        login.setBounds(390, 363, 100, 30);
        login.addActionListener(e -> {
            informationEntered();
        });

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
        title2.setForeground(Color.WHITE);
        title2.setFont(new Font("Times new roman", Font.ITALIC, 16));
        title2.setBounds(30, 8, 120, 30);

        JSeparator separator = new JSeparator(SwingConstants.CENTER);
        separator.setBounds(30, 40, 490, 190);

        JLabel textFecha = new JLabel("Fecha");
        textFecha.setForeground(Color.WHITE);
        textFecha.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textFecha.setBounds(30, 44, 80, 30);

        JLabel textEdad = new JLabel("Edad");
        textEdad.setForeground(Color.WHITE);
        textEdad.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textEdad.setBounds(30, 107, 70, 30);

        JLabel textSexo = new JLabel("Sexo");
        textSexo.setForeground(Color.WHITE);
        textSexo.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textSexo.setBounds(300, 107, 70, 30);

        JLabel title3 = new JLabel("Datos medicos");
        title3.setForeground(Color.WHITE);
        title3.setFont(new Font("Times new roman", Font.ITALIC, 16));
        title3.setBounds(30, 175, 120, 30);

        JSeparator separator2 = new JSeparator(SwingConstants.CENTER);
        separator2.setBounds(30, 206, 490, 190);

        JLabel textDiagnostico = new JLabel("Diagnostico");
        textDiagnostico.setForeground(Color.WHITE);
        textDiagnostico.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textDiagnostico.setBounds(30, 212, 80, 30);

        JLabel textPrincipal = new JLabel("Principal");
        textPrincipal.setForeground(Color.WHITE);
        textPrincipal.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textPrincipal.setBounds(300, 212, 80, 30);

        JLabel textTipo = new JLabel("Tipo");
        textTipo.setForeground(Color.WHITE);
        textTipo.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textTipo.setBounds(30, 283, 80, 30);

        JLabel textClase = new JLabel("Clase");
        textClase.setForeground(Color.WHITE);
        textClase.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textClase.setBounds(190, 283, 70, 30);

        JLabel textEspecialidad = new JLabel("Especialidad");
        textEspecialidad.setForeground(Color.WHITE);
        textEspecialidad.setFont(new Font("serif", Font.ROMAN_BASELINE, 13));
        textEspecialidad.setBounds(350, 283, 80, 30);

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

    private void informationEntered() {
        String diagnosticoSeleccionado = (String) diagnostico.getSelectedItem();
        String fechaVal = fecha.getText();
        String edadVal = edad.getText();
        String sexoVal = (String) sexo.getSelectedItem();
        String principalVal = (String) principal.getSelectedItem();
        String tipoVal = (String) tipo.getSelectedItem();
        String claseVal = (String) clase.getSelectedItem();
        String especialidadVal = (String) especialidad.getSelectedItem();
        int edadIngresada;
        String[] validar = fechaVal.split("/");
        int año, mes, dia;

        if (fechaVal.isEmpty() || sexo.getSelectedIndex() == -1 || diagnostico.getSelectedIndex() == -1
                || principal.getSelectedIndex() == -1 || tipo.getSelectedIndex() == -1 || clase.getSelectedIndex() == -1
                || especialidad.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else if (validar.length != 3) {
            JOptionPane.showMessageDialog(this, "Formato de fecha invalido!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            edadIngresada = Integer.parseInt(edad.getText());
            if(edadIngresada < 1 || edadIngresada > 110) {
                JOptionPane.showMessageDialog(this, "Edad ingresada no valida!", "Error",
                JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para la edad", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            dia = Integer.parseInt(validar[0]);
            mes = Integer.parseInt(validar[1]);
            año = Integer.parseInt(validar[2]);
            if((dia < 1 || dia > 31) || (mes < 1 || mes > 12) || (año < 1000 || año > 2024)) {
                JOptionPane.showMessageDialog(this, "Fecha ingresada no valida!", "Error",
                JOptionPane.ERROR_MESSAGE);
                return;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingresar numeros enteros para la fecha", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String fechaComplet = String.format("%02d/%02d/%02d", dia, mes, año);

        Paciente pacient = new Paciente(diagnosticoSeleccionado, edadIngresada);
        pacientes.add(pacient);

        ArrayList<String> fila = new ArrayList<>();

        fila.add(fechaComplet);
        fila.add(edadVal);
        fila.add(sexoVal);
        fila.add(codigo(diagnosticoSeleccionado));
        fila.add(diagnosticoSeleccionado);
        fila.add(principalVal);
        fila.add(tipoVal);
        fila.add(claseVal);
        fila.add(especialidadVal);
        save.add(fila);

        if (!pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Datos ingresados con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }

        resetForm();
    }

    private void generateCsv() {
        String[] columna = { "Fecha", "Edad", "Sexo", "Codigo", "Diagnostico", "Principal", "Tipo", "Clase",
                "Especialidad" };

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Diagnostico por edad");
        fileChooser.setSelectedFile(new File("datos.csv"));

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.join("-", columna));
                writer.newLine();

                for (ArrayList<String> fila : save) {
                    writer.write(String.join("-", fila));
                    writer.newLine();
                }

                JOptionPane.showMessageDialog(this, "Archivo CSV guardado exitosamente.");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + ex.getMessage());
            }

        }

    }

    private String codigo(String diagnostico) {
        switch (diagnostico) {
            case "Acne Quistico":
                return "L70. 0";
            case "Dermatitis Seborreica":
                return "L21. 9";
            case "Rosacea":
                return "L71. 9";
            case "Lentigo Solar":
                return "L81. 0";
            case "Fotoenvejecimiento":
                return "L67. 3";
            default:
                return "null";
        }

    }

}
