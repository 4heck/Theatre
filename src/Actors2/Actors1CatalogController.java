package Actors2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
//Controller for Catalog for Admin
public class Actors1CatalogController implements Initializable {
	//ArrayList ActorData for TableView
    private final ObservableList <Actors> ActorsData = FXCollections.observableArrayList();
		//TableView for Actors
		@FXML
		private TableView <Actors> catalogTable;
			//TableColumns for display Actors
			@FXML
			private TableColumn <Actors, String> ActorsOneCol;
			@FXML
			private TableColumn <Actors, String> ActorsTwoCol;
			@FXML
			private TableColumn <Actors, String> ActorsThreeCol;
			@FXML
			private TableColumn <Actors, String> ActorsAgeCol;
				//method for deleting Actors from catalogTable
				@FXML
				private void handleDeleteAction(){
				int selectedIndex=catalogTable.getSelectionModel().getSelectedIndex();
				if (selectedIndex<0){
					Alert alert=new Alert(AlertType.WARNING);
					alert.initOwner(null);
					alert.setTitle("Не выделено");
					alert.setHeaderText("Не выбран актер");
					alert.setContentText("Выберите актера из списка");
					alert.showAndWait();
				}
				else{
					catalogTable.getItems().remove(selectedIndex);
				}
				Actors.Rebuildfile(ActorsData);
				}
//method for editing Actors from catalogTable

public boolean showActorAddDialog(Actors Actor){
try{
	FXMLLoader loader=new FXMLLoader();
	loader.setLocation(ChangeItemController.class.getResource("ChangeItem.fxml"));
	AnchorPane page = (AnchorPane) loader.load();
	Stage stage = new Stage();
	stage.getIcons().add(new Image("file:resources/images/edit.png"));
	stage.setTitle("Добавление нового актера");
	stage.initModality(Modality.WINDOW_MODAL);
	Scene scene = new Scene(page);
	stage.setScene(scene);
	ChangeItemController controller = loader.getController();
	controller.setDialogStage(stage);
	controller.setActor(Actor);
	stage.showAndWait();
	return controller.isOkClicked();
}
catch(IOException e){
	e.printStackTrace();
	return false;
}
}
	//method for adding new Actors to catalogTable
	@FXML
	private void handleNewActor() throws IOException{
		Actors tempActor = new Actors();
		boolean okClicked = showActorAddDialog(tempActor);
		if (okClicked)
			ActorsData.add(tempActor);
	}
		//method for checking isOkeying and editing Actors

			//initializing Controller
			@Override
			public void initialize(URL url, ResourceBundle rb) {
				File actors=new File("actors2.txt");
						try{BufferedReader brr=new BufferedReader(new FileReader(actors.getAbsoluteFile()));
				try{
					String s;
					String[] dat;
					String addcount,addid,addprc, addname;
					while ((s=brr.readLine())!=null){
						dat=s.split(":");
                                                addid=dat[1];
						addname=dat[0];
						addprc=dat[2];
						addcount=dat[3];
						ActorsData.add(new Actors(addid,addname,addprc,addcount));
					}}finally{brr.close();}}
					catch (IOException e){
						throw new RuntimeException(e);    
					}
						//filling the catalogTable with the required data
						ActorsOneCol.setCellValueFactory(new PropertyValueFactory<>("ActorsOne"));
                                                ActorsTwoCol.setCellValueFactory(new PropertyValueFactory<>("ActorsTwo"));
						ActorsThreeCol.setCellValueFactory(new PropertyValueFactory<>("ActorsThree"));
						ActorsAgeCol.setCellValueFactory(new PropertyValueFactory<>("ActorsAge"));
						catalogTable.setItems(ActorsData);
						
					
						}    
}
