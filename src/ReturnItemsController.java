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

public class ReturnItemsController implements Initializable{
	
	@FXML
	public String selected;
	public ListView<String> list;
	ObservableList<String> items = FXCollections.observableArrayList();
	public Label username;
	
	private User accountHolder = (User) Library.getCurrentLogin(); // saves referencing all the time	
	
	public void setName(String name) {
		username.setText(name);
	}
	
	public void fillLists(List<Copy> listReference, ObservableList<String> observeReference) {
		for (Copy item : listReference) {
			if (item.getBook() != null) {
				observeReference.add(item.getBook().getTitle());

			} else if (item.getDVD() != null) {
				observeReference.add(item.getDVD().getTitle());

			} else if (item.getLaptop() != null) {
				observeReference.add(item.getLaptop().getTitle());
			}
		}
	}
	
	@FXML
	public void listButtonPushed(MouseEvent event) throws IOException{
		selected = list.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	public void handleReturns(ActionEvent event) throws IOException {
		// find reserved copy & send for collecting, confirm collection
		Copy userReturnCopy = null;

		for (Copy borrowedCopy : accountHolder.getBorrowedItems()) {
			if (borrowedCopy.getBook() != null) {
				Book reservedBook = (Book) borrowedCopy.getBook();

				if (reservedBook.getTitle().equalsIgnoreCase(selected)) {
					userReturnCopy = borrowedCopy;
				}

			} else if (borrowedCopy.getDVD() != null) {
				DVD reservedDVD = (DVD) borrowedCopy.getDVD();

				if (reservedDVD.getTitle().equalsIgnoreCase(selected)) {
					userReturnCopy = borrowedCopy;
				}

			} else if (borrowedCopy.getLaptop() != null) {
				Laptop reservedLaptop = (Laptop) borrowedCopy.getLaptop();

				if (reservedLaptop.getTitle().equalsIgnoreCase(selected)) {
					userReturnCopy = borrowedCopy;
				}
			}
		}

		if (userReturnCopy != null) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Are you sure?");
			alert.setHeaderText(null);
			alert.setContentText("Would you like to deposit this copy now?");
			alert.showAndWait();
			if (alert.getResult().getText().equalsIgnoreCase("Ok")) {
				Library.userCollecting(userReturnCopy, accountHolder);
			}
		}
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
	


	@Override
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		
		fillLists(accountHolder.getBorrowedItems(), items);
		
		list.setItems(items);
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}
}
