package ShowCatalog;
import ShowCatalog.ChangeItemController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
public class ShowCatalogController implements Initializable {
	//ArrayList productData for TableView
    private final ObservableList <Performance> PerformanceData = FXCollections.observableArrayList();
		//TableView for products
		@FXML
		private TableView <Performance> catalogTable;
			//TableColumns for display products
			@FXML
			private TableColumn <Performance, String> PerformanceNameCol;
			@FXML
			private TableColumn <Performance, String> PerformanceGenreCol;
			@FXML
			private TableColumn <Performance, String> PerformanceActorsCol;
			@FXML
			private TableColumn <Performance, String> PerformanceAgeCol;
                        @FXML
			private TableColumn <Performance, String> PerformanceHallCol;
				//Labels for display ShowDetails
				@FXML
				private Label PerformanceNameLabel;
				@FXML
				private Label PerformanceGenreLabel;
				@FXML
				private Label PerformanceActorsLabel;
				@FXML
				private Label PerformanceAgeLabel;
                                @FXML
				private Label PerformanceHallLabel;
                                @FXML
                                private Label PerformanceCountLabel;
					//This method is displaying product details
					private void showProductDetails (Performance show){
					if (show!=null){
						PerformanceNameLabel.setText(show.getPerformanceName().toUpperCase());
						PerformanceGenreLabel.setText(show.getPerformanceGenre());
						PerformanceActorsLabel.setText(show.getPerformanceActors());
						PerformanceAgeLabel.setText(show.getPerformanceAge());
                                                PerformanceHallLabel.setText(show.getPerformanceHall());
					}
					else{
						PerformanceNameLabel.setText("");
						PerformanceGenreLabel.setText("");
						PerformanceActorsLabel.setText("");
						PerformanceAgeLabel.setText("");
                                                PerformanceHallLabel.setText("");
					}
					}
				//method for deleting products from catalogTable
				@FXML
				private void handleDeleteAction(){
				int selectedIndex=catalogTable.getSelectionModel().getSelectedIndex();
				if (selectedIndex<0){
					Alert alert=new Alert(AlertType.WARNING);
					alert.initOwner(null);
					alert.setTitle("Не выделено");
					alert.setHeaderText("Не выбран спектакль");
					alert.setContentText("Выберите спектакль из списка");
					alert.showAndWait();
				}
				else{
					catalogTable.getItems().remove(selectedIndex);
				}
				Performance.RebuildShowfile(PerformanceData);
				}

public boolean showProductAddDialog(Performance product){
try{
	FXMLLoader loader=new FXMLLoader();
	loader.setLocation(ChangeItemController.class.getResource("ChangeItem.fxml"));
	AnchorPane page = (AnchorPane) loader.load();
	Stage stage = new Stage();
	stage.getIcons().add(new Image("file:resources/images/edit.png"));
	stage.setTitle("Новый спектакль");
	stage.initModality(Modality.WINDOW_MODAL);
	Scene scene = new Scene(page);
	stage.setScene(scene);
	ChangeItemController controller = loader.getController();
	controller.setDialogStage(stage);
	controller.setProduct(product);
	stage.showAndWait();
	return controller.isOkClicked();
}
catch(IOException e){
	e.printStackTrace();
	return false;
}
}
    @FXML
    private void showActors(ActionEvent event) throws IOException{
    int selectedIndex=catalogTable.getSelectionModel().getSelectedIndex();
    if (selectedIndex<0){
            Alert alert=new Alert(AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран спектакль");
            alert.setContentText("Выберите спектакль из списка");
            alert.showAndWait();
    }
    else{
            if(PerformanceData.get(selectedIndex).getPerformanceActors().equals("Зеленая труппа")){
                Stage stage=new Stage();
                stage.setTitle("Актеры спекткаля "+PerformanceData.get(selectedIndex).getPerformanceName().toUpperCase());
                stage.getIcons().add(new Image("file:resources/images/actors.png"));
                Parent root=FXMLLoader.load(getClass().getResource("/Actors1/Actors1Catalog.fxml"));
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            
                if(PerformanceData.get(selectedIndex).getPerformanceActors().equals("Синяя труппа")){
                Stage stage=new Stage();
                stage.setTitle("Актеры спекткаля "+PerformanceData.get(selectedIndex).getPerformanceName().toUpperCase());
                stage.getIcons().add(new Image("file:resources/images/actors.png"));
                Parent root=FXMLLoader.load(getClass().getResource("/Actors2/Actors1Catalog.fxml"));
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
                
                if(PerformanceData.get(selectedIndex).getPerformanceActors().equals("Красная труппа")){
                Stage stage=new Stage();
                stage.setTitle("Актеры спекткаля "+PerformanceData.get(selectedIndex).getPerformanceName().toUpperCase());
                stage.getIcons().add(new Image("file:resources/images/actors.png"));
                Parent root=FXMLLoader.load(getClass().getResource("/Actors3/Actors1Catalog.fxml"));
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
    }
				
    }
        @FXML
    private void showHall(ActionEvent event) throws IOException{
            int selectedIndex=catalogTable.getSelectionModel().getSelectedIndex();
    if (selectedIndex<0){
            Alert alert=new Alert(AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран спектакль");
            alert.setContentText("Выберите спектакль из списка");
            alert.showAndWait();
    }
    else{
            if(PerformanceData.get(selectedIndex).getPerformanceHall().equals("Большой зал")){
                Stage stage=new Stage();
                stage.setTitle("Схема зала для спектакля "+PerformanceData.get(selectedIndex).getPerformanceName().toUpperCase());
                stage.getIcons().add(new Image("file:resources/images/actors.png"));
                Parent root=FXMLLoader.load(getClass().getResource("/SmallHall/SmallHall.fxml"));
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            if(PerformanceData.get(selectedIndex).getPerformanceHall().equals("Малый зал")){
                Stage stage=new Stage();
                stage.setTitle("Схема зала для спектакля "+PerformanceData.get(selectedIndex).getPerformanceName().toUpperCase());
                stage.getIcons().add(new Image("file:resources/images/actors.png"));
                Parent root=FXMLLoader.load(getClass().getResource("/VerySmallHall/VerySmallHall.fxml"));
                Scene scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }  
    }}
	//method for adding new products to catalogTable
	@FXML
	private void handleNewProduct() throws IOException{
		Performance tempProduct = new Performance();
		boolean okClicked = showProductAddDialog(tempProduct);
		if (okClicked)
			PerformanceData.add(tempProduct);
	}
		//method for checking isOkeying and editing products
		@FXML
		private void handleEditProduct() throws IOException{
			int selectedIndex=catalogTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex<0){
			Alert alert=new Alert(AlertType.WARNING);
			alert.initOwner(null);
			alert.setTitle("Не выделено");
			alert.setHeaderText("Не выбран спектакль");
			alert.setContentText("Выберите спектакль в таблице");
			alert.showAndWait();
		}
		else{
			Performance tempProduct = PerformanceData.get(selectedIndex);
			boolean okClicked = this.showProductAddDialog(tempProduct);
			if (okClicked){;
				PerformanceNameCol.setCellFactory(TextFieldTableCell.<Performance>forTableColumn());
				PerformanceNameLabel.setText(tempProduct.getPerformanceName());
				PerformanceGenreLabel.setText(tempProduct.getPerformanceGenre());
				PerformanceActorsLabel.setText(tempProduct.getPerformanceActors());
				PerformanceAgeLabel.setText(tempProduct.getPerformanceAge());
                                PerformanceHallLabel.setText(tempProduct.getPerformanceHall());
			}
			Performance.RebuildShowfile(PerformanceData);
		}
		}

                
        //HEADERSETTINGS
        //
        //
        @FXML
        private void closeMainMenu(ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Выход из системы");
        stage.getIcons().add(new Image("file:resources/images/exit.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/theatre/SureExit.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
                
        @FXML
        private void info(ActionEvent event) throws IOException{
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("О программе");
        alert.setTitle("О программе");
        alert.setContentText("Ruslan M. \nvk.com/4heck");
        alert.showAndWait();
        }
        
        @FXML
        private void showSmallHall(ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Большой зал");
        stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/SmallHall/SmallHall.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        
        @FXML
        private void showVerySmallHall(ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Малый зал");
        stage.getIcons().add(new Image("file:resources/images/seats-at-the-hall.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/VerySmallHall/VerySmallHall.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        
        @FXML
        private void showActors1(ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Зеленая труппа");
        stage.getIcons().add(new Image("file:resources/images/theater-masks.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/Actors1/Actors1Catalog.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        
        @FXML
        private void showActors2(ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Синяя труппа");
        stage.getIcons().add(new Image("file:resources/images/theater-masks.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/Actors2/Actors1Catalog.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        
        @FXML
        private void showActors3(ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Красная труппа");
        stage.getIcons().add(new Image("file:resources/images/theater-masks.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/Actors3/Actors1Catalog.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        
        @FXML
        private void showStatistics(ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Cтатистика");
        stage.getIcons().add(new Image("file:resources/images/bar-chart.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/Popularity/Statistics.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
        
        @FXML
        private void showStatisticsGenres(ActionEvent event) throws IOException{
        Stage stage=new Stage();
        stage.setTitle("Cтатистика");
        stage.getIcons().add(new Image("file:resources/images/bar-chart.png"));
        Parent root=FXMLLoader.load(getClass().getResource("/Popularity/StatisticsGenres.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
			//initializing Controller
			@Override
			public void initialize(URL url, ResourceBundle rb) {
				File performances=new File("performances.txt");
						try{BufferedReader brr=new BufferedReader(new FileReader(performances.getAbsoluteFile()));
				try{
					String s;
					String[] dat;
					String name,genre,actors,age,hall;
                                        Integer count;
					while ((s=brr.readLine())!=null){
						dat=s.split(":");
                                                name=dat[1];
						genre=dat[0];
						actors=dat[2];
						age=dat[3];
                                                hall=dat[4];
                                                count=Integer.parseInt(dat[5]);
						PerformanceData.add(new Performance(name,genre,actors,age,hall,count));
					}}finally{brr.close();}}
					catch (IOException e){
						throw new RuntimeException(e);    
					}
						//filling the catalogTable with the required data
						PerformanceNameCol.setCellValueFactory(new PropertyValueFactory<>("PerformanceName"));
                                                PerformanceGenreCol.setCellValueFactory(new PropertyValueFactory<>("PerformanceGenre"));
						PerformanceActorsCol.setCellValueFactory(new PropertyValueFactory<>("PerformanceActors"));
						PerformanceAgeCol.setCellValueFactory(new PropertyValueFactory<>("PerformanceAge"));
                                                PerformanceHallCol.setCellValueFactory(new PropertyValueFactory<>("PerformanceHall"));
						catalogTable.setItems(PerformanceData);
						showProductDetails(null);
						catalogTable.getSelectionModel().selectedItemProperty().addListener(
						(observable, oldValue, newValue) -> showProductDetails(newValue));
						}    
}
