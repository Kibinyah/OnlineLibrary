
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class LibUserSearchController implements Initializable{

	ObservableList<String> list = FXCollections.observableArrayList();	
	public Button button;
	public Label username;
	public ListView<String> listOfItems;
	public String selected;
	public TextField textInput;
	
	private Librarian accountHolder = (Librarian) Library.getCurrentLogin(); // saves referencing all the time
	
	public void setName(String name) {
		username.setText(name);
	}
	
	public void fillLists(List<Controller> userList, ObservableList<String> observeReference) {
		for (Controller item : userList) {
			observeReference.add(item.getUsername());
		}
	}	
	
	@FXML
	public void handleHome(ActionEvent event) throws IOException {
	
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibrarianHome.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibHomeController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	public void handleItemHistory(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CheckItemHistory.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		CheckItemHistoryController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	public void handleCreateResource(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CreateResource.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		CreateResourceController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	public void handleResource(ActionEvent event) throws IOException {
	
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibResourceSearch.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibResourceSearchController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	public void handleAccount(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibProfile.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibProfileController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	public void handleManageUser(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibUserSearch.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibUserSearchController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	public void handleUserType(ActionEvent event) throws IOException {
		
		if(selected == "User"){
			String name = username.getText();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("LookUser.fxml"));
			Parent root = loader.load();
	
			Scene scene = new Scene(root);
			LookUserController display = loader.getController();
			display.setName(name);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
		else if (selected == "Librarian"){
			String name = username.getText();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("LookLib.fxml"));
			Parent root = loader.load();
	
			Scene scene = new Scene(root);
			LookLibController display = loader.getController();
			display.setName(name);
			
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		}
	}
	
	@FXML
	public void handleIssueDesk(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("LibIssueDesk.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LibIssueDeskController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	@FXML
	public void handleCreateAccount(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("CreateUser.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		CreateUserController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	

	@FXML
	public void handleSignOut(ActionEvent event) throws IOException{
	
/*		Platform.exit();
		System.exit(0);
*/		
		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void listButtonPushed(MouseEvent event) throws IOException{
		selected = listOfItems.getSelectionModel().getSelectedItem();
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		fillLists(Library.userList, list);
		
		listOfItems.setItems(list);
		listOfItems.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}
}
