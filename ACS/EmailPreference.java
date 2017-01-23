package Apps.ACS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EmailPreference extends Iweb_Regular_Active_Member {

	@Test()
	public void EmailLaunch() throws IOException {
		data();
		driver.get(p.getProperty("EmailP"));
		logMessage("Launch Email Preference Successfully");
	}

	@Test(dependsOnMethods = "EmailLaunch")
	public void LoginApp() throws InterruptedException, IOException {
		data();
		driver.findElement(By.id("tbCredential1")).sendKeys(weblogin);
		driver.findElement(By.id("tbCredential2")).sendKeys(p.getProperty("Pass"));
		driver.findElement(By.id("btnLogin")).click();
		logMessage("Logged In Email Preference Successfully");
	}

}
