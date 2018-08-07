package fr.eql.autom.orangehrm.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageTest extends MenuPageTest{

	
	@FindBy(how = How.XPATH, using="//*[@id=\"menu_admin_viewSystemUsers\"]")
	WebElement ongletUser;
	@FindBy(how = How.XPATH, using="//*[@id=\"content\"]/div/div[1]/h1")
	WebElement titreDashboard;
//	@FindBy(how = How.XPATH, using="//*[@id=\"menu_admin_viewAdminModule\"]/b")
//	WebElement ongletAdmin;
	
	public HomePageTest(WebDriver d) {
		super(d);
	}

	public UserManagementPageTest RedirectUserPage() {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]")))
//			.moveToElement(ongletUser)
//				.click()
//				.build()
//				.perform();
		super.cliqueLenuAdmin();
		return PageFactory.initElements(driver, UserManagementPageTest.class);
	}

	public WebElement getTitreDashboard() {
		return titreDashboard;
	}

	
	
}
