package edu.ucsd.spendingtracker.view.charts;

public class PieChartProvider implements IChartProvider {
    @Override
    public javafx.scene.Node createChart(java.util.Map<edu.ucsd.spendingtracker.model.Category, Double> data) {
        javafx.scene.chart.PieChart pieChart = new javafx.scene.chart.PieChart();

        data.forEach((cat, sum) -> {
            javafx.scene.chart.PieChart.Data slice = new javafx.scene.chart.PieChart.Data(cat.name(), sum);
            pieChart.getData().add(slice);
        });

        for(javafx.scene.chart.PieChart.Data entry : pieChart.getData()) {
            String color = edu.ucsd.spendingtracker.model.Category.valueOf(entry.getName()).color;
            javafx.scene.Node node = entry.getNode();
            if(node != null) {
                node.setStyle("-fx-pie-color: " + color + ";");
            }
        }

        pieChart.setLegendVisible(false);
        return pieChart;
    }

    @Override
    public String getDisplayName() {
        return "Pie Chart";
    }
    
}
