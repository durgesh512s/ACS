package Apps.ACS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Iweb_Regular_Active_Member extends Method {

	@Test
	public void IwebLaunch() throws InterruptedException, IOException {
		maximize();
		data();
		driver.get(p.getProperty("iweb"));
		logMessage("Launch Iweb Successfully For Regular Active Members ");
	}

	@Test(dependsOnMethods = "IwebLaunch")
	public void MembershipA() throws Exception {
		time(15);
		javascript("document.getElementsByClassName('iconpad')[0].click()");
		javascript("document.getElementById('UI_88').click()");
	}

	@Test(dependsOnMethods = "MembershipA")
	public void FindMembersA() throws IOException {
		driver.findElement(By.xpath(".//a[@id='F1_HYPERLINK_8']")).click();
	}

	@Test(dependsOnMethods = "FindMembersA")
	public void FindMembershipA() throws Exception {
		logMessage("Member Status= Active Regular Members");

		javascript("document.getElementById('ValueDropDownList3').value='455fef87-5fc0-42dd-92a5-77194f1e1708'"); // RegularMember
																												
		javascript("document.getElementById('ValueDropDownList4').value='fb6da915-043e-41cd-ac68-65dc06cd49bb'"); // Active
		driver.findElement(By.id("ButtonSearch")).click();
	}

	@Test(dependsOnMethods = "FindMembershipA")
	public void IndividualA() throws Exception {
		time(10);
		driver.findElement(By.xpath("(//td[contains(text(),'Individual')])[7]")).click();
		driver.findElement(By.id("F1_HYPERLINK_4")).click(); // Costumer name
		logMessage("Contact Id=");
		Contactid = driver.findElement(By.id("F1_cst_id")).getText();
		System.out.println(Contactid);
		logMessage("Web Login=");
		weblogin = driver.findElement(By.id("F1_cst_web_login")).getText();
		System.out.println(weblogin);
	}

}
