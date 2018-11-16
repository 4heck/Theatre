package theatre;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class SureExitController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Button sure;
    @FXML
    private Button notsure;
    @FXML
    private void sure(ActionEvent event) throws IOException{
        System.exit(1);
    }
    @FXML
    private void notsure(ActionEvent event) throws IOException{
       Stage stage=new Stage();
       stage=(Stage) sure.getScene().getWindow();
       stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
      
    }

