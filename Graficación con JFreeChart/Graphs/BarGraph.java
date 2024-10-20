
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarGraph extends JFrame {

    public BarGraph() {
        setSize(700, 500);
        setLocationRelativeTo(null);
    }

    public void generateChart(ArrayList<Paciente> pacientes) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Map<Integer, Integer>> datosPorEnfermedad = new HashMap<>();

        for (Paciente p : pacientes) {
            String diagnostico = p.getDiagnostico();
            int edad = p.getEdad();

            datosPorEnfermedad.putIfAbsent(diagnostico, new HashMap<>());

            Map<Integer, Integer> edadContador = datosPorEnfermedad.get(diagnostico);
            edadContador.put(edad, edadContador.getOrDefault(edad, 0) + 1);
        }

        for (Map.Entry<String, Map<Integer, Integer>> entry : datosPorEnfermedad.entrySet()) {
            String enfermedad = entry.getKey();
            Map<Integer, Integer> edadContador = entry.getValue();

            for (Map.Entry<Integer, Integer> edadEntry : edadContador.entrySet()) {
                int edad = edadEntry.getKey();
                int cantidad = edadEntry.getValue();
                dataset.addValue(cantidad, enfermedad, String.valueOf(edad));
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart(
                "Edad por diagnostico",
                "Diagnostico",
                "edad",
                dataset, PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chart = new ChartPanel(barChart);
        add(chart);
    }

}
