import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineGraph extends JFrame {

    public LineGraph() {
        setSize(700, 500);
        setLocationRelativeTo(null);
    }

    public void generateChart(ArrayList<Paciente> pacientes) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("% edades con diagnosticos ");

        Map<Integer, Integer> edadContador = new HashMap<>();
        for (Paciente p : pacientes) {
            int edad = p.getEdad();
            edadContador.put(edad, edadContador.getOrDefault(edad, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : edadContador.entrySet()) {
            series.add(entry.getKey(), entry.getValue()); 
        }

        dataset.addSeries(series);

        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Diagnostico por edad",
                "Edad",
                "Cantidad",
                dataset
        );

        XYPlot plot = lineChart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
        plot.setRenderer(renderer);
        
        ChartPanel chartPanel = new ChartPanel(lineChart);
        add(chartPanel);
    }
}
