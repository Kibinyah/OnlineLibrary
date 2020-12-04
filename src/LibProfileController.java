import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

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
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class LibProfileController implements Initializable {
	@FXML
	public Label username;
	public Label uname;
	public TextField firstName;
	public TextField lastName;
	public TextField mobNum;
	public TextField telNum;
	public TextField address;
	public Label employDate;
	public Label staffNum;
	public ImageView image;
	public ImageView profilePic;
	
	private Librarian accountHolder = (Librarian) Library.getCurrentLogin(); // saves referencing all the time	

	public void setName(String name) {
		username.setText(name);
	}

	@FXML
	public void handleChangePicture(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangePicture.fxml"));
		Parent root = (Parent) loader.load();
		Stage window = new Stage();
		window.setTitle("Profile Picture");
		window.setScene(new Scene(root));
		window.show();
	}

	@FXML
	public void handleSave(ActionEvent event) throws IOException {
		// save currentData
		if (!uname.getText().equalsIgnoreCase(accountHolder.getUsername())) {
			Library.changeLoginName(accountHolder.getUsername(), uname.getText());
			accountHolder.setUsername(uname.getText());
		}
		
		if (!firstName.getText().equalsIgnoreCase(accountHolder.getFirstName())) {
			accountHolder.setFirstName(firstName.getText());
		}
		
		if (!lastName.getText().equalsIgnoreCase(accountHolder.getLastName())) {
			accountHolder.setLastName(lastName.getText());
		}
		
		if (!mobNum.getText().equalsIgnoreCase(accountHolder.getPhoneNumber())) {
			accountHolder.setPhoneNumber(mobNum.getText());
		}
		
		if (!telNum.getText().equalsIgnoreCase(accountHolder.getTelephone())) {
			accountHolder.setTelephone(telNum.getText());
		}
		
		if (!address.getText().equalsIgnoreCase(accountHolder.getAddress())) {
			accountHolder.setAddress(address.getText());
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success");
		alert.setHeaderText(null);
		alert.setContentText("Update librarian information.");
		alert.showAndWait();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
		System.out.println(accountHolder.getProfilePicture().getPictureURL());
		
		uname.setText(accountHolder.getUsername());
		firstName.setText(accountHolder.getFirstName());
		lastName.setText(accountHolder.getLastName());
		mobNum.setText(accountHolder.getPhoneNumber());
		telNum.setText(accountHolder.getTelephone());
		address.setText(accountHolder.getAddress());
		employDate.setText(accountHolder.getEmploymentStart());
		staffNum.setText(Integer.toString(accountHolder.getStaffNumber()));
		profilePic.setImage(new Image(accountHolder.getProfilePicture().getPictureURL()));
	}
}
