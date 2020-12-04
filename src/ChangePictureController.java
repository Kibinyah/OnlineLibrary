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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class ChangePictureController implements Initializable {

	ObservableList<String> pictures = FXCollections.observableArrayList("Picture 1", "Picture 2", "Picture 3", "Picture 4", "Picture 5", "Picture 6");
	public String selected;
	
	@FXML
	public Button save;
	public Button drawPicture;
	public ChoiceBox<String> pic;
	public Label username;
	public ImageView picture;
	public Image image;
	public String imageURL;

	public void handlePicturePushed(ActionEvent event) throws IOException {
		selected = pic.getSelectionModel().getSelectedItem();
		if (selected == "Picture 1") {
			imageURL = "templates/TAWE-Lib User.png";//"cd-dvd.jpg";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 2") {
			imageURL = "templates/TAWE-Lib Triangle.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 3") {
			imageURL = "templates/TAWE-Lib Star.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 4") {
			imageURL = "templates/TAWE-Lib Lines.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 5") {
			imageURL = "templates/TAWE-Lib Hex.png";
			image = new Image(imageURL);
			picture.setImage(image);
			
		} else if (selected == "Picture 6") {
			imageURL = "templates/TAWE-Lib Circle.png";
			image = new Image(imageURL);
			picture.setImage(image);
		}
	}

	public void handleDrawPicture(ActionEvent event) throws IOException {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		Drawing newTemplate = new Drawing();
		newTemplate.start(window);
	}

	public void handleSave(ActionEvent event) {
		Controller currentLogin = Library.getCurrentLogin();
		currentLogin.setPicture(imageURL);

		Stage stage = (Stage) save.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		System.out.println("Working...");
		
		pic.setValue("Picture 1");
		pic.setItems(pictures);
	}
}
