package Apps.ACS;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

abstract class Method {
	static WebDriverWait wait;
	static ProfilesIni profile = new ProfilesIni();
	static FirefoxProfile myprofile = profile.getProfile("seleniumprofile");
	static WebDriver driver = new FirefoxDriver(myprofile);
	static Properties p = new Properties();
	String Actualtext;
	static String weblogin;
	static String[] tokens;
	static String Contactid;

	public static void javascript(String s) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(s);

	}

	protected void logMessage(String message) {
		Reporter.log(message, true);
	}

	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	protected void handleAlert() {
		try {
			switchToAlert().accept();
			logMessage("Alert handled..");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("No Alert window appeared...");
		}
	}

	protected void windowhandle() {
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		driver.switchTo().window(parentWindowHandler);
	}

	public void data() throws IOException {
		FileInputStream fin = new FileInputStream(
				"C:\\Users\\durgeshsharma\\workspace\\ACS-Apps\\src\\test\\java\\Apps\\ACS\\data.properties");
		p.load(fin);
	}

	public void scrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void hoverClick(WebElement element) {
		Actions hoverClick = new Actions(driver);
		hoverClick.moveToElement(element).click().build().perform();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void switchToFrame(int i) {
		driver.switchTo().frame(i);
	}

	public WebElement waitForElementToBeVisible(WebElement element) {
		return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToFrame(String id) {
		driver.switchTo().frame(id);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void screenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:\\Users\\durgeshsharma\\workspace\\test\\Screenshots\\screenshot.png"));
	}

	public void time(long s) {
		driver.manage().timeouts().implicitlyWait(s, TimeUnit.SECONDS);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void hardwait(long s) throws InterruptedException {
		Thread.sleep(s * 1000);
	}
}
