package recommendations;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.DBconnection;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import preferences.PreferencesState;

public class RecommendationsView implements Initializable {
	
	@FXML
	private Button btnPreferences;
	
	@FXML
	private ListView<String> lvGenrers;
	
	@FXML
	private ListView<String> lvMovies;
	
	private RecommendationsModel model;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		initGenrerPreferences();
		model = new RecommendationsModel(DBconnection.Connector());
		
		lvGenrers.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				
				System.out.println("clicked on " + lvGenrers.getSelectionModel().getSelectedItem());
				
				try {
					
					List<String> movies = model.getMoviesByGenrer(lvGenrers.getSelectionModel().getSelectedItem());
					System.out.println(movies);
					fillMovieList(movies);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		});
		
	}
	
	private void initGenrerPreferences() {
		
		String[] genrersArray = PreferencesState.getGenrers();
		setGenrerList(genrersArray);
		
	}
	
	public void onPreferencesClicked() throws IOException {
		
		System.out.println("Opening Main Recommendations Screen");
		Parent rootParent = FXMLLoader.load(getClass().getResource("/Preferences.fxml"));
		Scene scene = new Scene(rootParent,400,400);
		Main.mainStage.setScene(scene);
		
	}
	
	private void setGenrerList(String[] favoriteGenrers) {
		
		ObservableList<String> observableList = FXCollections.observableArrayList();
		observableList.addAll(favoriteGenrers);		
		lvGenrers.setItems(observableList);
		
	}
	
	private void fillMovieList(List<String> movieList) {
		
		ObservableList<String> observableList = FXCollections.observableArrayList();
		observableList.addAll(movieList);		
		lvMovies.setItems(observableList);
		
	}

}
