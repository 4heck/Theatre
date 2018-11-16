package Popularity;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.stage.Stage;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class StatisticsGenresController implements Initializable {
@FXML
private BarChart<?,?> PopularityChart;
@FXML
private CategoryAxis x;
@FXML
private NumberAxis y;

   @Override
   public void initialize(URL url, ResourceBundle rb) {
       XYChart.Series set1 = new XYChart.Series<>();
       set1.getData().add(new  XYChart.Data("Комедия",1854));
       set1.getData().add(new  XYChart.Data("Драма",1665));
       set1.getData().add(new  XYChart.Data("Водевиль",412));
       set1.getData().add(new  XYChart.Data("Мелодрама",986));
       set1.getData().add(new  XYChart.Data("Мим",350));
       set1.getData().add(new  XYChart.Data("Мистерия",144));
       set1.getData().add(new  XYChart.Data("Монодрама",213));
       set1.getData().add(new  XYChart.Data("Моралите",98));
       set1.getData().add(new  XYChart.Data("Мюзикл",1423));
       set1.getData().add(new  XYChart.Data("Пародия",951));
       set1.getData().add(new  XYChart.Data("Пастораль",265));
       set1.getData().add(new  XYChart.Data("Соти",71));
       set1.getData().add(new  XYChart.Data("Трагедия",1740));
       set1.getData().add(new  XYChart.Data("Трагикомедия",1350));
       set1.getData().add(new  XYChart.Data("Фарс",431));
       set1.getData().add(new  XYChart.Data("Феерия",209));
       set1.getData().add(new  XYChart.Data("Флиаки",46));
       PopularityChart.getData().addAll(set1);
   }
}