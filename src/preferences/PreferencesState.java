package preferences;

import java.util.ArrayList;
import java.util.List;

public class PreferencesState {
	
	private static PreferencesState INSTANCE = new PreferencesState();
	private static List<String> favoriteGenrers = new ArrayList<String>();
	
	private PreferencesState() {
		//NO-OP
	}
	
	public PreferencesState getInstance() {
		return INSTANCE;
	}
	
	public static void addGenrer(String genrer) {
		favoriteGenrers.add(genrer);
	}
	
	public static String[] getGenrers() {
		
		String[] genrersArray = new String[favoriteGenrers.size()];
		return favoriteGenrers.toArray(genrersArray);
		
	}
	
	public static void removeGenrer(String genrer) {
		favoriteGenrers.remove(genrer);
	}

}
