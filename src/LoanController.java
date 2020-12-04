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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class LoanController implements Initializable {

	public String selected; // find out what this does
	public ListView<String> list;
	ObservableList<String> items = FXCollections.observableArrayList();

	@FXML
	public Label username;
	public Label date;
	public Label fine;

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

	public void listButtonPushed(MouseEvent event) throws IOException {
		selected = list.getSelectionModel().getSelectedItem();
	}
	
	@FXML
	public void handleSelection(ActionEvent event) throws IOException {
		for (Copy item : accountHolder.getBorrowedItems()) {
			if (item.getBook() != null) {
				if (item.getBook().getTitle().trim().equalsIgnoreCase(selected.trim())) {
					date.setText(item.getDueDate());
					fine.setText("0.00");
				}

			} else if (item.getDVD() != null) {
				if (item.getDVD().getTitle().trim().equalsIgnoreCase(selected.trim())) {
					date.setText(item.getDueDate());
					fine.setText("0.00");
				}

			} else if (item.getLaptop() != null) {
				if (item.getLaptop().getTitle().trim().equalsIgnoreCase(selected.trim())) {
					date.setText(item.getDueDate());
					fine.setText("0.00");
				}
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	public void handleSignOut(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
		Library.logOut();
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		fillLists(accountHolder.getBorrowedItems(), items);

		list.setItems(items);
		list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // what does this do?
	}
}
