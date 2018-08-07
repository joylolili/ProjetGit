package fr.eql.autom.orangehrm.pageObject;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPageTest {

//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\geckodriver.exe");
	protected final WebDriver driver;
	
	@FindBy(id="menu_admin_viewAdminModule")
	private WebElement menuAdmin;
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	private WebElement menuRecrutement;
	@FindBy(id="menu_recruitment_viewJobVacancy")
	private WebElement sousmenuVacanciers;
	
	
	public MenuPageTest (WebDriver d) {
		super();
		this.driver = d;
	}
	
	public UserManagementPageTest cliqueLenuAdmin() {
		this.menuAdmin.click();
		return PageFactory.initElements(driver, UserManagementPageTest.class);
	}
	
//	public VacancierPageTest mouseOverTest(WebDriver d) {
//		Actions actions = new Actions(d);
//		actions.moveToElement(menuRecrutement)
//				.click()
//				.build()
//				.perform();
//		// Fluent Wait
////		FluentWait<WebDriver> sousmenuWait = new FluentWait<WebDriver>(d);
////		sousmenuWait.withTimeout(Duration.ofSeconds(30));
////		WebElement sousmenu = sousmenuWait.until(new Function<WebDriver, WebElement>() {
////			public WebElement apply(WebDriver d) {
////				return d.findElement(By.id("menu_recruitment_viewCandidates"));
////			}
////		});
////		if (sousmenu.isDisplayed()) {
////			sousmenuVacanciers.click();
////			
////		}
//		
//		// Explicite Wait
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		
//		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfAllElements(sousmenuVacanciers)
//				, ExpectedConditions.elementToBeClickable(sousmenuVacanciers)));
//		sousmenuVacanciers.click();
//		return PageFactory.initElements(driver, VacancierPageTest.class);
//		
//
//	}
	
	
}
