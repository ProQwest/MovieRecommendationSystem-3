package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class loginController implements Initializable {
	public LoginModel lmodel = new LoginModel();
	@FXML
	private Label isConnected;
	
	@FXML
	private TextField txtusername;
	
	@FXML
	private TextField txtpassword;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			if(lmodel.isBDConnected()) {
				isConnected.setText("Connected");
			}	
			else {
				isConnected.setText("Not Connected");
				}
	}
	
	public void login(ActionEvent event) {
		try {
			if(lmodel.isLogin(txtusername.getText(), txtpassword.getText())) {
				isConnected.setText("UserName and Password is Correct");
				
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root = loader.load(getClass().getResource("/application/User.fxml").openStream());
				
				UserController uc = (UserController)loader.getController();
				uc.GetUser(txtusername.getText());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				
				
			}
			else {
				isConnected.setText("UserName and Password is NotCorrect");			
				}
		} catch (SQLException e) {
			isConnected.setText("UserName and Password is NotCorrect");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
