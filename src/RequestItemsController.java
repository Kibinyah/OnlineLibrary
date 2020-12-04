import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class RequestItemsController implements Initializable{
	
	@FXML
	ObservableList<String> resourceTypeList = FXCollections.observableArrayList("All","Book","DVD","Laptop");
	ObservableList<String>	entries = FXCollections.observableArrayList();	
    public ChoiceBox resType = new ChoiceBox();
	public Button button;
	public Label username;
	public ListView<String> listOfItems = new ListView<String>();
	public static String selected = null;
	public TextField textInput;
	
	private User accountHolder = (User) Library.getCurrentLogin(); // saves referencing all the time
	
	public void setName(String name) {
		username.setText(name);
	}
	
	@FXML
	public void handleHome(ActionEvent event) throws IOException {
	
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Homepage.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		HomePageController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	public void handleResource(ActionEvent event) throws IOException {
	
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Searching.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		SearchController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	public void handleAccount(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Profile.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		ProfileController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	public void handleAddFunds(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("AddFunds.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		AddFundsController display = loader.getController();
		display.setName(name);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	@FXML
	public void handleLoans(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Loans.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LoanController display = loader.getController();
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
	public void handleIssueDesk(ActionEvent event) throws IOException {
		
		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("IssueDesk.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		IssueDeskController display = loader.getController();
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
	public void handleRequestButton(ActionEvent event) throws IOException{
		for (Resource item : Library.resourceList) {
			if (item.toString().equalsIgnoreCase(selected)) {
				// go through the copy list and find the next available, if no available, requesttoreserve
				
				if ((Book) item != null) {
					Book bookItem = (Book) item;
					
					if (Library.createNewRequest("Book", bookItem, accountHolder)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("You have successfully requested to borrow: " + bookItem.getTitle());
						alert.showAndWait();							
						return;
					}
			
				} else if ((DVD) item != null) {
					DVD dvdItem = (DVD) item;
					
					if (Library.createNewRequest("Book", dvdItem, accountHolder)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("You have successfully requested to borrow: " + dvdItem.getTitle());
						alert.showAndWait();							
						return;
					}
					
				} else if ((Laptop) item != null) {
					Laptop laptopItem = (Laptop) item;
					
					if (Library.createNewRequest("Book", laptopItem, accountHolder)) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Success");
						alert.setHeaderText(null);
						alert.setContentText("You have successfully requested to borrow: " + laptopItem.getTitle());
						alert.showAndWait();							
						return;
					}
				}
			}
		}
	}
	
	public void listButtonPushed(MouseEvent event) throws IOException{
		selected = listOfItems.getSelectionModel().getSelectedItem();
	}

	@FXML
	public void handleSignOut(ActionEvent event) throws IOException{
		
		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		Library.logOut();
	}
	


	@Override
	public void initialize(URL url, ResourceBundle resources) {
		 
		System.out.println("Working...");
		if(Library.resourceList.size() == 0) {
			Library.preloadResources();
			}
			
			System.out.println("Working...");
			resType.setValue("All");
			resType.setItems(resourceTypeList);
			System.out.println(Library.resourceList.size());
			for(int i = 0; i<Library.resourceList.size(); i++) {

			entries.add(Library.resourceList.get(i).toString());
			}
			listOfItems.setItems(entries);
			listOfItems.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			textInput.textProperty().addListener(new ChangeListener() {
				
				public void changed(ObservableValue observable, Object oldVal, Object newVal) {
					if((String)resType.getValue() != "All")
					handleSearchByKey((String)resType.getValue() +" " +  (String) oldVal, (String)resType.getValue() +" "+ (String) newVal);
					else handleSearchByKey((String) oldVal, (String) newVal);
				}
			});
			resType.setOnAction((Event ev) -> {
	        	if((String)resType.getValue() != "All") {
	        	handleSearchByKey((String)resType.getValue() + textInput.getText(), (String)resType.getValue() + " " + textInput.getText());
	        	}
	        	else {
	        		handleSearchByKey("", " ");
	        	}
			});
			
		}
	public void handleSearchByKey(String oldVal, String newVal) {
		// If the number of characters in the text box is less than last time
		// it must be because the user pressed delete
		if (oldVal != null && (newVal.length() != oldVal.length())) {
			// Restore the lists original set of entries
			// and start from the beginning
			listOfItems.setItems(entries);
		}

		// Break out all of the parts of the search text
		// by splitting on white space
		String[] parts = newVal.toUpperCase().split(" ");

		// Filter out the entries that don't contain the entered text
		ObservableList<String> subentries = FXCollections.observableArrayList();

		for (Object entry : listOfItems.getItems()) {
			boolean match = true;
			String entryText = (String) entry;
			for (String part : parts) {
				// The entry needs to contain all portions of the
				// search string but in any order
				if (!(entryText).toUpperCase().contains(part)) {
					match = false;
					break;
				}
			}

			if (match) {
				subentries.add(entryText);
			}
		}
		listOfItems.setItems(subentries);
		//return (String) list.getItems;
	}

}
