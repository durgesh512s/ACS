package Apps.ACS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OMR extends Method {

	@Test()
	public void OMRLaunch() throws IOException {
		time(10);
		loadProperties(p);
		driver.get(p.getProperty("eweb"));
		logMessage("******OMR Launch Successfully******");
		driver.switchTo().frame("eWebFrame");
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		driver.findElement(By.xpath("//input[@class='input-user-name']")).sendKeys(tokens[tokens.length - 1]);
		driver.findElement(By.xpath("//input[@class='input-password']")).sendKeys(p.getProperty("ContactId"));
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
		driver.findElement(By.xpath("//option[@value='e4cc52c6-66d3-414c-a0b6-8c9dcf710c47']")).click();
		driver.findElement(By.id("e6401c55_2c7c_49c4_bbd4_7ea7d0148393_userControlBillingInformation_tbCardholderName"))
				.sendKeys(p.getProperty("Cardholder"));
		driver.findElement(
				By.id("e6401c55_2c7c_49c4_bbd4_7ea7d0148393_userControlBillingInformation_tbCreditCardNumber"))
				.sendKeys(p.getProperty("Cardno"));
		driver.findElement(By.xpath(".//*[@value='2020']")).click();
		driver.findElement(By.id("e6401c55_2c7c_49c4_bbd4_7ea7d0148393_userControlBillingInformation_tbCcvNumber"))
				.sendKeys(p.getProperty("Cvv"));
		time(2);
		try {
			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		} catch (Exception E) {
		}
		try {
			driver.findElement(By.id("cbPubSciEula")).click();
		} catch (Exception E) {
		}
		time(20);
		driver.findElement(By.id("btnContinue")).click();
		switchToFrame("eWebFrame");
		driver.findElement(By.id("btnSubmitOmrPayment")).click();
		switchToDefaultContent();
		switchToFrame("eWebFrame");
		expire = driver.findElement(By.id("c5824dae_279c_4392_b6d0_3efa2906fbab_lblMembershipExpirationDate"))
				.getText();
		logMessage("New Expire Date =" + expire);
		String notice = driver
				.findElement(
						By.id("c5824dae_279c_4392_b6d0_3efa2906fbab_userControlMembershipAccountView_lblRenewalNumber"))
				.getText();
		logMessage("Notice No=" + notice);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[@href='../logout']")).click();
	}
	/*
	 * @AfterTest public void Close(){ driver.close();
	 */
}
