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
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class HomePageController implements Initializable{
	
	public ListView<String> listOfBorrowed;
	public ListView<String> listOfRequested;
	public ListView<String> listOfReserved;
	public ListView<String> listOfTransactions;
	
	ObservableList<String> borrowed = FXCollections.observableArrayList();
	ObservableList<String> requested = FXCollections.observableArrayList();
	ObservableList<String> reserved = FXCollections.observableArrayList();
	ObservableList<String> transactions = FXCollections.observableArrayList();
	
	private User accountHolder = (User) Library.getCurrentLogin(); // saves referencing all the time
	
	public double userBalance = accountHolder.getBalance();
	public String stringBal = "£" + Double.toString(userBalance);
	
	@FXML
	public Label username;
	@FXML
	public Label balance;
	
	public void setName(String name) {
		username.setText(name);
	}
	
	public void fillLists(List<Copy> listReference, ObservableList<String> observeReference) {
		for (Copy item : listReference) {
			if (item.getBook() != null) {
				observeReference.add(item.getBook().getTitle());
				System.out.println("book");
				
			} else if (item.getDVD() != null) {
				observeReference.add(item.getDVD().getTitle());
				System.out.println("dvd");
				
			} else if (item.getLaptop() != null) {
				observeReference.add(item.getLaptop().getTitle());
				System.out.println("laptop");
			}
		}
	}
	
	public void listTransaction(List<String> listReference, ObservableList<String> observeReference) {
		for (String transaction : listReference) {
			observeReference.add(transaction);
		}
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
		fillLists(accountHolder.getBorrowedItems(), borrowed);
		fillLists(accountHolder.getRequestedItems(), requested);
		fillLists(accountHolder.getReservedItems(), reserved);
		listTransaction(accountHolder.getTransactionalHistory(), transactions);
		
		listOfBorrowed.setItems(borrowed);
		listOfRequested.setItems(requested);
		listOfReserved.setItems(reserved);
		listOfTransactions.setItems(transactions);
		balance.setText(stringBal);
		
	}
}
