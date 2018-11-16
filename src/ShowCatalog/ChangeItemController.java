package ShowCatalog;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class ChangeItemController implements Initializable {
        private final ObservableList <String> ForComboBox = FXCollections.observableArrayList();
                private final ObservableList <String> ForComboBox2 = FXCollections.observableArrayList();
                        private final ObservableList <String> ForComboBox3 = FXCollections.observableArrayList();
                                private final ObservableList <String> ForComboBox4 = FXCollections.observableArrayList();
	//TextFields for editing products
    @FXML
    private TextField PerformanceNameField;
    @FXML
    private ComboBox<String> PerformanceGenreField;
    @FXML
    private ComboBox<String> PerformanceActorsField;
    @FXML
    private ComboBox<String> PerformanceAgeField;
    @FXML
    private ComboBox<String> PerformanceHallField;
    @FXML
    private TextField PerformanceCountField;
		//dialogStage, product, okClicked
		private Stage dialogStage;
		private Performance show;
		private boolean okClicked = false;
			//setDialogStage
			public void setDialogStage(Stage dialogStage){
				this.dialogStage = dialogStage;
			}
                        
				//setProduct
				public void setProduct(Performance show){
					this.show=show;
					PerformanceNameField.setText(show.getPerformanceName());
					PerformanceGenreField.setValue(show.getPerformanceGenre());
                                        PerformanceActorsField.setValue(show.getPerformanceActors());
					PerformanceAgeField.setValue(show.getPerformanceAge());
                                        PerformanceHallField.setValue(show.getPerformanceHall());
                                        PerformanceCountField.setText(show.getPerformanceCount().toString());
                                        PerformanceActorsField.setDisable(false);
                                        PerformanceHallField.setDisable(false);
                                        PerformanceGenreField.setDisable(false);
                                        PerformanceAgeField.setDisable(false);
				}
					//isOkClicked
					public boolean isOkClicked(){
						return this.okClicked;
					}
//checking validing products
//тут я пытался прописать функцию для isNumeric, чтобы он выводил сообщение, что введено не число, а что-то другое
/*public static boolean isNumeric(String str){
for (char c : str.toCharArray())
{
if (!Character.isDigit(c)) return false;
}
return false;
}*/

        private boolean isInputValid(){
	String errorMessage="";
	if (PerformanceNameField.getText().isEmpty())
		errorMessage+="Нет доступного наименования\n";
        //функция isNumeric() тут не выдавла у меня правильного ответа, поэтому я оставил isEmpty()
        if (PerformanceCountField.getText().isEmpty())
		errorMessage+="Нет доступного количества билетов\n";
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
            show.setPerformanceName(PerformanceNameField.getText());
            show.setPerformanceGenre(PerformanceGenreField.getValue());
            show.setPerformanceActors(PerformanceActorsField.getValue());
            show.setPerformanceAge(PerformanceAgeField.getValue());
            show.setPerformanceHall(PerformanceHallField.getValue());
            show.setPerformanceCount(Integer.parseInt(PerformanceCountField.getText()));
            Performance.addProduct(show);
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
                                                PerformanceActorsField.setDisable(true);
                                                ForComboBox.add("Красная труппа");
                                                ForComboBox.add("Синяя труппа");
                                                ForComboBox.add("Зеленая труппа");
                                                PerformanceActorsField.setItems(ForComboBox);
                                                
                                                    PerformanceHallField.setDisable(true);
                                                    ForComboBox2.add("Большой зал");
                                                    ForComboBox2.add("Малый зал");
                                                    PerformanceHallField.setItems(ForComboBox2);
                                                    
                                                        PerformanceGenreField.setDisable(true);
                                                        ForComboBox3.add("Комедия");
                                                        ForComboBox3.add("Драма");
                                                        ForComboBox3.add("Водевиль");
                                                        ForComboBox3.add("Мелодрама");
                                                        ForComboBox3.add("Мим");
                                                        ForComboBox3.add("Мистерия");
                                                        ForComboBox3.add("Монодрама");
                                                        ForComboBox3.add("Моралите");
                                                        ForComboBox3.add("Мюзикл");
                                                        ForComboBox3.add("Пародия");
                                                        ForComboBox3.add("Пастораль");
                                                        ForComboBox3.add("Соти");
                                                        ForComboBox3.add("Трагедия");
                                                        ForComboBox3.add("Трагикомедия");
                                                        ForComboBox3.add("Фарс");
                                                        ForComboBox3.add("Феерия");
                                                        ForComboBox3.add("Флиаки");
                                                        PerformanceGenreField.setItems(ForComboBox3);
                                                        
                                                    PerformanceAgeField.setDisable(true);
                                                    ForComboBox4.add("0+");
                                                    ForComboBox4.add("6+");
                                                    ForComboBox4.add("12+");
                                                    ForComboBox4.add("16+");
                                                    ForComboBox4.add("18+");
                                                    PerformanceAgeField.setItems(ForComboBox4);
			}      
}
