package Apps.ACS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OMR extends Method {

	@Test()
	public void OMRLaunch() throws IOException {
		loadProperties(p);
		driver.get(p.getProperty("eweb"));
		logMessage("******OMR Launch Successfully******");
		driver.switchTo().frame("eWebFrame");
		driver.findElement(By.xpath("(//input[@type='radio'])[3]")).click();
		driver.findElement(By.xpath("//input[@class='input-user-name']")).sendKeys(p.getProperty("Web LoginR"));
		driver.findElement(By.xpath("//input[@class='input-password']")).sendKeys(p.getProperty("Pass"));
		driver.findElement(By.xpath("//input[@value='Verify']")).click();
		driver.switchTo().defaultContent();
		logMessage("********OMR Logged In Successfully**********");
	}

	@Test(dependsOnMethods = "OMRLaunch")
	public void Payment() {
		time(20);
		driver.switchTo().frame("eWebFrame");
		// driver.findElement(By.xpath("//a[contains(text(),'[ edit
		// ]')]")).click();
		driver.findElement(By.xpath("//select[@class='cc']//option[contains(text(),'Visa/MC')]")).click();
		driver.findElement(By.id("e6401c55_2c7c_49c4_bbd4_7ea7d0148393_userControlBillingInformation_tbCardholderName"))
		.sendKeys("ACS TEST");
		driver.findElement(
				By.id("e6401c55_2c7c_49c4_bbd4_7ea7d0148393_userControlBillingInformation_tbCreditCardNumber"))
		.sendKeys("4111111111111111");
		driver.findElement(By.id("e6401c55_2c7c_49c4_bbd4_7ea7d0148393_userControlBillingInformation_tbCcvNumber"))
		.sendKeys("123");
		driver.findElement(By.id("btnContinue")).click();
		switchToFrame("eWebFrame");
		driver.findElement(By.id("btnSubmitOmrPayment")).click();
		switchToDefaultContent();
		switchToFrame("eWebFrame");
		String s = driver.findElement(By.id("c5824dae_279c_4392_b6d0_3efa2906fbab_lblMembershipExpirationDate"))
				.getText();
		logMessage("New Expire Date ="+s);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@href='../logout']")).click();
	}
	/*
	 * @AfterTest public void Close(){ driver.close();
	 */
}
