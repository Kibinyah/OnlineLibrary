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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class LibHomeController implements Initializable{
		
	@FXML
	public Label username;
	public ListView<String> listOfBorrowed;
	public ListView<String> listOfRequested;
	ObservableList<String> borrowed = FXCollections.observableArrayList();
	ObservableList<String> requested = FXCollections.observableArrayList();
	//TableView<String> would be TableView<(class name)>
	public TableView<String> tableView;
	//TableColumn<String,String> would be TableColumn<class name,String>
	public TableColumn<String,String> copyid;
	public TableColumn<String,String> uname;
	public TableColumn<String,String> days;
	
	// get kevin to help with this one ^^
	
	private Librarian accountHolder = (Librarian) Library.getCurrentLogin(); // saves referencing all the time
	
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

	public void listLoans(List<OnLoan> listReference, ObservableList<String> observeReference) {
		for (OnLoan item : listReference) {
			Copy borrowedCopy = item.getResourceCopy();
			
			if (borrowedCopy.getBook() != null) {
				observeReference.add(borrowedCopy.getBook().getTitle());
				System.out.println("book");
				
			} else if (borrowedCopy.getDVD() != null) {
				observeReference.add(borrowedCopy.getDVD().getTitle());
				System.out.println("dvd");
				
			} else if (borrowedCopy.getLaptop() != null) {
				observeReference.add(borrowedCopy.getLaptop().getTitle());
				System.out.println("laptop");
			}
		}
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
		listLoans(Library.loans, borrowed);
		fillLists(Library.requestCopies, requested);
		
		listOfBorrowed.setItems(borrowed);
		listOfRequested.setItems(requested);
		
		/*copyid = new TableColumn("CopyID");
		uname = new TableColumn("Borrower");
		days = new TableColumn("Days Overdue");
	    tableView.getColumns().addAll(copyid,uname,days);*/
	     
	}
}
