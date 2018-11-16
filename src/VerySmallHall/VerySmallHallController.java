
package VerySmallHall;

import SmallHall.*;
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
public class VerySmallHallController implements Initializable {
    @FXML
    private void red (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Красный сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/VerySmallHallPrices/red.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @FXML
    private void green (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Зеленый сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/VerySmallHallPrices/green.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private void blue (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Голубой сектор");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/VerySmallHallPrices/blue.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void vip (ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("VIP-ЛОЖА");
	stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/VerySmallHallPrices/vip.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
