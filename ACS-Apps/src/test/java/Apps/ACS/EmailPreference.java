package Apps.ACS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EmailPreference extends Method {

	@Test()
	public void EmailLaunch() throws IOException {
		loadProperties(p);
		driver.get(p.getProperty("EmailP"));
		logMessage("---------Launch Email Preference Successfully----------");
	}

	@Test(dependsOnMethods = "EmailLaunch")
	public void LoginApp() throws InterruptedException, IOException {
		driver.findElement(By.id("tbCredential1")).sendKeys(p.getProperty("Web Login"));
		driver.findElement(By.id("tbCredential2")).sendKeys(p.getProperty("Pass"));
		driver.findElement(By.id("btnLogin")).click();
		logMessage("++++++++++Logged In Email Preference Successfully++++++++++");
	}

}
