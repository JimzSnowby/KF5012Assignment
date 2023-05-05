/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.kf5012assessment; 

/**
 *
 * @author nihal
 */
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChoresBarChart {
    private ChoresDatabase choresDB = new ChoresDatabase();
    private ArrayList<Chore> chores = new ArrayList();
    
    public static void main(String[] args) {
        try {
           choreList = choresDB.
       } catch (Exception e) {
           System.out.println("Error: " + e);
       }
        
        // some  dummydata
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(15, "Week 1", "User 1");
        dataset.addValue(20, "Week 2", "User 1");
        dataset.addValue(10, "Week 3", "User 1");
        dataset.addValue(30, "Week 1", "User 2");
        dataset.addValue(25, "Week 2", "User 2");
        dataset.addValue(35, "Week 3", "User 2");

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
            "Time Spent on Chores Each Week", // the chart Chart title
            "User",                          // the X-axis label
            "Time Spent (hours)",            // Y-axiss label
            dataset,                         // Dataset
            PlotOrientation.VERTICAL,        // Orientation
            true,                            // Show legend
            true,                            // Use tooltips
            false                            // Configure chart to generate URLs?
        );

        // Customize chart
        chart.getCategoryPlot().getRenderer().setSeriesPaint(0, Color.GREEN);
        chart.getCategoryPlot().getRenderer().setSeriesPaint(1, Color.BLUE);

        //  panel to display thechart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 400));

        // Create window to display panel
        
        JFrame frame = new JFrame("Chores Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
