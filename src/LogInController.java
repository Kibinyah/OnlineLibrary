
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class LogInController implements Initializable {

	// LogIn Screen
	public Button button;
	public Label label;
	public TextField text;

	@FXML
	public void handleLogIn(ActionEvent event) throws IOException {
		Boolean login = Library.login(text.getText().trim());
		
		if (login == true) {
			Controller loggedIn = Library.getCurrentLogin();

			// How to decide which interface they should get!
			if (loggedIn.getClass().getName().equalsIgnoreCase("Librarian")) {
				String name = loggedIn.getUsername();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("LibrarianHome.fxml"));
				Parent root = loader.load();
				Scene scene = new Scene(root);
				LibHomeController display = loader.getController();
				display.setName(name);

				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(scene);
				window.show();

			} else if (loggedIn.getClass().getName().equalsIgnoreCase("User")) {
				String name = loggedIn.getUsername();
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
		} else {
			// couldn't log in
			text.setText("");
			
			// fire "unable to login" alert
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Login failed");
			alert.setHeaderText(null);
			alert.setContentText("Unable to login, please try again.");
			alert.showAndWait();
		}

	}

	@FXML
	public void handleQuit(ActionEvent event) throws IOException {
		System.exit(0);
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		try {
			Library.forceOut();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
