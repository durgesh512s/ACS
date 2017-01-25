package Apps.ACS;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Objects {

	static WebDriverWait wait;
	static ProfilesIni profile = new ProfilesIni();
	static FirefoxProfile myprofile = profile.getProfile("seleniumprofile");
	static WebDriver driver = new FirefoxDriver(myprofile);
	static Properties p = new Properties();
	String Actualtext;
	static String expire;
	static String weblogin;
	static String[] tokens;
	static File file = new File("C:\\Users\\durgeshsharma\\workspace\\ACS-Apps\\Property\\data.properties");
}
