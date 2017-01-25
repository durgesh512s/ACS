package Apps.ACS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Iweb_Active_Renewed_NoResponse extends Method {

	@Test
	public void LaunchR() throws InterruptedException, IOException {
		maximize();
		loadProperties(p);
		driver.get(p.getProperty("iweb"));
		logMessage("**********Launch Iweb Successfully For Active Renewed No Response**********");
	}

	@Test(dependsOnMethods = "LaunchR")
	public void MembershipR() throws Exception {
		time(15);
		javascript("document.getElementsByClassName('iconpad')[0].click()");
		javascript("document.getElementById('UI_88').click()");

	}

	@Test(dependsOnMethods = "MembershipR")
	public void FindMembersR() throws IOException {
		driver.findElement(By.xpath(".//a[@id='F1_HYPERLINK_8']")).click();
	}

	@Test(dependsOnMethods = "FindMembersR")
	public void FindMembershipR() throws Exception {
		logMessage("****Member Status= Active Renewed-no Response*****");

		javascript("document.getElementById('ValueDropDownList4').value='99520115-cfba-4d82-93fc-0db58992acef'"); // Active_Renewed-no_Response

		javascript("document.getElementById('ValueDropDownList13').value='Nigeria'");
		driver.findElement(By.id("ButtonSearch")).click();
	}

	@Test(dependsOnMethods = "FindMembershipR")
	public void IndividualR() throws Exception {
		time(20);
		driver.findElement(By.xpath("(//td[contains(text(),'Individual')])[8]")).click();
		driver.findElement(By.id("F1_HYPERLINK_4")).click(); // Costumer name
		String contactid = driver.findElement(By.id("F1_cst_id")).getText();
		logMessage("Contact Id=" + contactid);
		weblogin = driver.findElement(By.id("F1_cst_web_login")).getText();
		logMessage("Web Login=" + weblogin);
		p.setProperty("Web LoginR", weblogin);
		saveProperties(p);
		String Name = driver.findElement(By.id("ChildDivDataFormHeader")).getText();
		logMessage("Customer Name=" + Name);
		tokens = Name.split(" ");
		String Address = driver.findElement(By.id("F1_cxa_mailing_label_html")).getText();
		logMessage("Address=" + Address);
		javascript("document.getElementById('Link4a8ea18e-56b2-4a57-a652-7ebfee57ba88').click()"); // InvoicesDetails
		hardwait(5);
		driver.findElement(By.xpath("(//i[@class='icon-chevron-down'])[1]")).click();
		String InvoiceNo = driver.findElement(By.id("UP24")).getText();
		logMessage("Invoice No=" + InvoiceNo);
		String Date = driver.findElement(By.id("UP34")).getText();
		logMessage("Date=" + Date);
		javascript("document.getElementById('Link8fcfc111-a8ab-453c-973f-71ccd5cd21e2').click()"); // MembershipDetails
		hardwait(5);
		javascript("document.getElementsByClassName('icon-chevron-down')[0].click()");
		String join = driver.findElement(By.id("UP34")).getText();
		logMessage("Join=" + join);
		expire = driver.findElement(By.id("UP40")).getText();
		logMessage("Expire=" + expire);
		/*javascript("document.getElementById('Link757be236-feb2-475e-8367-2dad2e530267').click()"); // PaymentDetails
		hardwait(5);
		javascript("document.getElementById('IB_5ced3b9f-c104-4784-b601-e1e8ecb52bc5refresh').click()");
		String payment = driver.findElement(By.id("UP24")).getText();
		logMessage("Last Payment=" + payment);*/

	}

}
