
package SmallHall;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class SmallHallController implements Initializable {
    @FXML
    private void red (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Красный сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/SmallHallPrices/red.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void orange (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Оранжевый сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/SmallHallPrices/orange.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void yellow (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Желтый сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/SmallHallPrices/yellow.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void green (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Зеленый сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/SmallHallPrices/green.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void pink (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Розовый сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/SmallHallPrices/pink.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void blue (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Голубой сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/SmallHallPrices/blue.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void vip (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("VIP-ЛОЖА");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/SmallHallPrices/vip.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
