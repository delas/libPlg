package plg.utils;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;

import java.io.FileReader;

/**
 * Constants used by PLG
 * 
 * @author Andrea Burattin
 */
public class PlgConstants {

	/**
	 * The name of the libPlg
	 */
	public static final String LibPLG_NAME = "libPlg";
	
	/**
	 * Current version of libPlg
	 */
	public static final String libPLG_VERSION = readVersionFromPomFile();
	
	/**
	 * Signature of the libPlg (typically name and version number)
	 */
	public static final String libPLG_SIGNATURE = LibPLG_NAME + " v." + libPLG_VERSION;

	private static String readVersionFromPomFile() {
		try {
			// Create a MavenXpp3Reader to parse the pom.xml file
			MavenXpp3Reader reader = new MavenXpp3Reader();
			Model model;

			try (FileReader fileReader = new FileReader("pom.xml")) {
				model = reader.read(fileReader);
			}
			return model.getVersion();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERR";
	}
}

