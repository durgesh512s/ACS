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
		logMessage("Launch Iweb Successfully For Active Renewed No Response ");
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
		logMessage("Member Status= Active Renewed-no Response");

		javascript("document.getElementById('ValueDropDownList4').value='99520115-cfba-4d82-93fc-0db58992acef'"); // Active_Renewed-no_Response

		javascript("document.getElementById('ValueDropDownList13').value='Brazil'");
		driver.findElement(By.id("ButtonSearch")).click();
	}

	@Test(dependsOnMethods = "FindMembershipR")
	public void IndividualR() throws Exception {
		time(15);
		driver.findElement(By.xpath("(//td[contains(text(),'Individual')])[10]")).click();
		driver.findElement(By.id("F1_HYPERLINK_4")).click(); // Costumer name
		logMessage("Contact Id=");
		contactid = driver.findElement(By.id("F1_cst_id")).getText();
		System.out.println(contactid);
		logMessage("Web Login=");
		weblogin = driver.findElement(By.id("F1_cst_web_login")).getText();
		p.setProperty("Web LoginR", weblogin);
		saveProperties(p);
		logMessage("Customer Name=");
		String Name = driver.findElement(By.id("ChildDivDataFormHeader")).getText();
		System.out.println(Name);
		tokens = Name.split(" ");
		logMessage("Address=");
		String Address = driver.findElement(By.id("F1_cxa_mailing_label_html")).getText();
		System.out.println(Address);
		javascript("document.getElementById('Link4a8ea18e-56b2-4a57-a652-7ebfee57ba88').click()"); // InvoicesDetails
		hardwait(5);
		logMessage("Invoice No=");
		driver.findElement(By.xpath("(//i[@class='icon-chevron-down'])[1]")).click();
		String InvoiceNo = driver.findElement(By.id("UP24")).getText();
		System.out.println(InvoiceNo);
		logMessage("Date=");
		String Date = driver.findElement(By.id("UP34")).getText();
		System.out.println(Date);
		javascript("document.getElementById('Link8fcfc111-a8ab-453c-973f-71ccd5cd21e2').click()"); // MembershipDetails
		hardwait(5);
		javascript("document.getElementsByClassName('icon-chevron-down')[0].click()");
		logMessage("Join=");
		String join = driver.findElement(By.id("UP34")).getText();
		System.out.println(join);
		logMessage("Expire=");
		String Expire = driver.findElement(By.id("UP40")).getText();
		System.out.println(Expire);
	}

}
