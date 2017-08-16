package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class UserController implements Initializable {

	@FXML 
	private Label userlabl;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
	}
	
	public void GetUser(String user) {
		userlabl.setText(user);
	}	
}
