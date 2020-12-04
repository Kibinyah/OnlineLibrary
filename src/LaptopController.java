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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class LaptopController implements Initializable {

	@FXML
	public Label username;
	public Label title;
	public Label year;
	public Label manufacturer;
	public Label model;
	public Label copies;
	public Image image;
	public Label os;
	// TableView<String> would be TableView<(class name)>
	public TableView<Copy> tableView;
	// TableColumn<String,String> would be TableColumn<class name,String>
	public TableColumn copyID;
	public TableColumn available;
	public ObservableList<Copy> data = FXCollections.observableArrayList();

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
	public void handleLoans(ActionEvent event) throws IOException {

		String name = username.getText();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Loans.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		LoanController display = loader.getController();
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
	public void handleSignOut(ActionEvent event) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		copyID.setCellValueFactory(new PropertyValueFactory<>("copyID"));
		available.setCellValueFactory(new PropertyValueFactory<>("available"));
		System.out.println("Working...");
		String tit = SearchController.selected.substring(9);
		String finalTit = tit.substring(0, tit.indexOf(","));
		title.setText(finalTit);
		System.out.println(Library.resourceList.size());
		for (int i = 0; i < Library.resourceList.size(); i++) {
			if (Library.resourceList.get(i).getTitle().trim().equals(finalTit)) {
				Laptop someLaptop = (Laptop) Library.resourceList.get(i);
				year.setText("" + someLaptop.getYear());
				manufacturer.setText(someLaptop.getManufacturer());
				model.setText("" + someLaptop.getModel());
				os.setText(someLaptop.getOS());
				copies.setText("" + someLaptop.copies.size());
				for (int j = 0; j < someLaptop.copies.size(); j++) {
					data.add(someLaptop.copies.get(j));
				}
			}
			tableView.setItems(data);

		}
	}
}
