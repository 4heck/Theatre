package Popularity;
import ShowCatalog.Performance;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class StatisticsController implements Initializable {
        private final ObservableList <Performance> PerformanceData = FXCollections.observableArrayList();
@FXML
private BarChart<?,?> PopularityChart;
@FXML
private CategoryAxis x;
@FXML
private NumberAxis y;

   @Override
   public void initialize(URL url, ResourceBundle rb) {
       File performances=new File("performances.txt");
        try{BufferedReader brr=new BufferedReader(new FileReader(performances.getAbsoluteFile()));
        try{
            String s;
            String[] dat;
            String name;
            Integer count;
            while ((s=brr.readLine())!=null){
                    dat=s.split(":");
                    name=dat[0];
                    count=Integer.parseInt(dat[5]);
                    XYChart.Series set1 = new XYChart.Series<>();
                    set1.getData().add(new  XYChart.Data(name,count));
                    PopularityChart.getData().addAll(set1);
            }}finally{brr.close();}}
            catch (IOException e){
                    throw new RuntimeException(e);    
            }
   }
}