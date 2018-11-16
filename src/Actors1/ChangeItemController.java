package Actors1;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class ChangeItemController implements Initializable {
        private final ObservableList <String> ForComboBox = FXCollections.observableArrayList();
	//TextFields for editing actors
    @FXML
    private TextField ActorsOneField;
    @FXML
    private TextField ActorsTwoField;
    @FXML
    private TextField ActorsThreeField;
    @FXML
    private TextField ActorsAgeField;
		//dialogStage, actor, okClicked
		private Stage dialogStage;
		private Actors actor;
		private boolean okClicked = false;
			//setDialogStage
			public void setDialogStage(Stage dialogStage){
				this.dialogStage = dialogStage;
			}
				//setactor
				public void setActor(Actors actor){
					this.actor=actor;
					ActorsOneField.setText(actor.getActorsOne());
					ActorsTwoField.setText(actor.getActorsTwo());
                                        ActorsThreeField.setText(actor.getActorsThree());
					ActorsAgeField.setText(actor.getActorsAge());
                                        
				}
					//isOkClicked
					public boolean isOkClicked(){
						return this.okClicked;
					}
//checking validing actors
private boolean isInputValid(){
	String errorMessage="";
	if (ActorsOneField.getText().isEmpty())
		errorMessage+="Нет доступного имени\n";
	if (ActorsTwoField.getText().isEmpty())
		errorMessage+="Нет доступной фамилии\n";
	if (ActorsThreeField.getText().isEmpty())
		errorMessage+="Нет доступного отчества \n";
	if (ActorsAgeField.getText().isEmpty())
		errorMessage+="Нет доступного возраста\n";
	if(errorMessage.isEmpty())
		return true;
	else{
		Alert alert=new Alert(AlertType.ERROR);
		alert.initOwner(dialogStage);
		alert.setTitle("Некорректные поля");
		alert.setHeaderText("Внесите корректную информацию");
		alert.setContentText(errorMessage);
		alert.showAndWait();
		return false;
		}
	}
	//method for button OK
    @FXML
    private void handleOk(){
        if (isInputValid()){
            actor.setActorsOne(ActorsOneField.getText());
            actor.setActorsTwo(ActorsTwoField.getText());
            actor.setActorsThree(ActorsThreeField.getText());
            actor.setActorsAge(ActorsAgeField.getText());
            Actors.addactor(actor);
            this.okClicked=true;
            dialogStage.close();
        }
    }
		//method for buttun Cancel
		@FXML
		private void handleCancel(){
			dialogStage.close();
		}
			//initializing
			@Override
			public void initialize(URL url, ResourceBundle rb) {
                                             
			}      
}
