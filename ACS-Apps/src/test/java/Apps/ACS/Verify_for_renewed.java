package Apps.ACS;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Verify_for_renewed extends Method {
	@Test
	public void LaunchR() throws InterruptedException, IOException {
		maximize();
		loadProperties(p);
		driver.get(p.getProperty("iweb"));
		logMessage("**********Launch Iweb Successfully for Verification**********");
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
		time(15);
		driver.findElement(By.xpath("(//td[contains(text(),'Individual')])[8]")).click();
		driver.findElement(By.id("F1_HYPERLINK_4")).click(); // Costumer name
		javascript("document.getElementsByClassName('icon-chevron-down')[0].click()");
		String Expire = driver.findElement(By.id("UP40")).getText();
		logMessage("Expire=" + Expire);
		Assert.assertEquals(Expire, expire);
	}

}
