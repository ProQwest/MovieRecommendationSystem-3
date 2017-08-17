package preferences;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class PreferencesView implements Initializable {
	
	@FXML
	private Button btnAccept;
	@FXML
	private CheckBox cbAction;
	@FXML
	private CheckBox cbComedy;
	@FXML
	private CheckBox cbHorror;
	@FXML
	private CheckBox cbScifi;
	@FXML
	private CheckBox cbMusical;
	@FXML
	private CheckBox cbDrama;
	@FXML
	private CheckBox cbAnimation;
	@FXML
	private CheckBox cbThriller;
	@FXML
	private Label lError;
	
	public void onAcceptClicked() throws IOException {
		
		if (isGenreSelected()) {
			
			System.out.println("Opening Main Recommendations Screen");
			Parent rootParent = FXMLLoader.load(getClass().getResource("/Recommendations.fxml"));
			Scene scene = new Scene(rootParent,400,400);
			Main.mainStage.setScene(scene);
			
		} else {
			lError.setVisible(true);
		}
		
	}
	
	private boolean isGenreSelected() {
		
		if (cbAction.isSelected() || cbComedy.isSelected() || cbHorror.isSelected() || cbThriller.isSelected() ||
				cbScifi.isSelected() || cbDrama.isSelected() || cbAnimation.isSelected() || cbMusical.isSelected()) {
			
			PreferencesState.removeGenrer(cbAction.getText());
			PreferencesState.removeGenrer(cbComedy.getText());
			PreferencesState.removeGenrer(cbHorror.getText());
			PreferencesState.removeGenrer(cbThriller.getText());
			
			PreferencesState.removeGenrer(cbScifi.getText());
			PreferencesState.removeGenrer(cbDrama.getText());
			PreferencesState.removeGenrer(cbAnimation.getText());
			PreferencesState.removeGenrer(cbMusical.getText());
			
			if (cbAction.isSelected()) {
				PreferencesState.addGenrer(cbAction.getText());
			}
			
			if (cbComedy.isSelected()) {
				PreferencesState.addGenrer(cbComedy.getText());
			}
			
			if (cbHorror.isSelected()) {
				PreferencesState.addGenrer(cbHorror.getText());
			}
			
			if (cbThriller.isSelected()) {
				PreferencesState.addGenrer(cbThriller.getText());
			}
			
			if (cbScifi.isSelected()) {
				PreferencesState.addGenrer(cbScifi.getText());
			}
			
			if (cbDrama.isSelected()) {
				PreferencesState.addGenrer(cbDrama.getText());
			}
			
			if (cbAnimation.isSelected()) {
				PreferencesState.addGenrer(cbAnimation.getText());
			}
			
			if (cbMusical.isSelected()) {
				PreferencesState.addGenrer(cbMusical.getText());
			}
			
			return true;
		}
		
		return false;
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initGenrerPreferences();
	}
	
	private void initGenrerPreferences() {
		
		String[] genrersArray = PreferencesState.getGenrers();
		setGenrerList(genrersArray);
		
	}
	
	private void setGenrerList(String[] favoriteGenrers) {
		
		List<String> genrers = Arrays.asList(favoriteGenrers);
		
		if (genrers.contains("Action")) {
			cbAction.setSelected(true);
		} 
		
		if (genrers.contains("Comedy")) {
			cbComedy.setSelected(true);
		} 
		
		if (genrers.contains("Horror")) {
			cbHorror.setSelected(true);
		} 
		
		if (genrers.contains("Thriller")) {
			cbThriller.setSelected(true);
		} 
		
		if (genrers.contains("Animation")) {
			cbAnimation.setSelected(true);
		} 
		
		if (genrers.contains("Drama")) {
			cbDrama.setSelected(true);
		} 
		
		if (genrers.contains("Musical")) {
			cbMusical.setSelected(true);
		} 
		
		if (genrers.contains("Sci-Fi")) {
			cbScifi.setSelected(true);
		} 
		
	}

}
