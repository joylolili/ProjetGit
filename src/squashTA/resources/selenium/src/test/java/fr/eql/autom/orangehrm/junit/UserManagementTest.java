package fr.eql.autom.orangehrm.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fr.eql.autom.orangehrm.pageObject.HomePageTest;
import fr.eql.autom.orangehrm.pageObject.IvalideTableRowNumberException;
import fr.eql.autom.orangehrm.pageObject.LoginPageTest;
import fr.eql.autom.orangehrm.pageObject.MenuPageTest;
import fr.eql.autom.orangehrm.pageObject.UserInfoPageTest;
import fr.eql.autom.orangehrm.pageObject.UserManagementPageTest;

public class UserManagementTest {
	
	private WebDriver d ;

	@Before
	public void connexion() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\formation\\geckodriver.exe");
		this.d = new FirefoxDriver();
		this.d.get("http://127.0.0.1/orangehrm-4.0/symfony/web/index.php/auth/login");
	}
	
	@After
	public void fermertureNavigateur() {
		this.d.quit();
	}
	
	@Ignore
	@Test
	public void afficherLoginPage() {
		LoginPageTest loginPage =  PageFactory.initElements(d, LoginPageTest.class);
		HomePageTest h = loginPage.fournirLoginInfo("admin", "admin");
		assertEquals("verifier login succès et redirigé à HomePage", "Dashboard", h.getTitreDashboard().getText());
		
		// rediriger à Page User Management
		UserManagementPageTest u = h.cliqueLenuAdmin();
		WebDriverWait wait = new WebDriverWait(d, 15);
		Boolean b = wait.until(ExpectedConditions.urlContains("viewSystemUser"));
		if (b == true) {
			assertEquals("verifier redirection à User management", "Status", u.getLabelStatus().getText());
		}
		
		// recherche par role tous
		u.rechercheParRole("Admin");
		String nomUser = u.getChoisiAll();
		assertEquals("utilisateur admin trouvé", "admin", nomUser);
		
		// recherche par role Ess
		u.rechercheParRole("ESS");
		String message = u.getChoisiEss();
		assertEquals("message pas d'utilisateur trouvé", "No Records Found", message);		
	}
	
	@Test
	public void trouverEEE() throws IvalideTableRowNumberException {
		LoginPageTest loginPage =  PageFactory.initElements(this.d, LoginPageTest.class);
		HomePageTest h = loginPage.fournirLoginInfo("admin", "admin");
		assertEquals("verifier login succès et redirigé à HomePage", "Dashboard", h.getTitreDashboard().getText());
		UserManagementPageTest u = h.cliqueLenuAdmin();
		
		// wait pour évider le chargement de page trop long
		WebDriverWait wait = new WebDriverWait(this.d, 60);
		Boolean b = wait.until(ExpectedConditions.urlContains("viewSystemUser"));
		if (b == true) {
			assertEquals("verifier redirection à User management", "Status", u.getLabelStatus().getText());
		}
		
		// Test user détait en cliquant sur admin2 pour vérifier les champs de saisie dans page User Infos
		UserInfoPageTest uI = u.cliquerSurAdmin2("E E E");
		assertTrue(uI.formulaireInactif());
		
		// vérifier menu déroulant est non modifiable
		assertEquals("vérifier si menu déroulant User Role est disabled","true", uI.getMenuDeroulantUserRole().getAttribute("disabled"));
		
		// cliquer "edit" et choisir un autre valeur de checkbox ex. Role = ESS
		uI.getBoutonEdit().click();
		List<WebElement> checkboxOptions = uI.getMenuDeroulantUserRole().findElements(By.xpath("//*[@id='systemUser_userType']/option"));
		uI.getMenuDeroulantUserRole().click();
		checkboxOptions.get(1).click();
		uI.getBoutonEdit().click();
		
		// mouse over Recrutement -> Candidate
//		MenuPageTest m = PageFactory.initElements(d, MenuPageTest.class);
//		m.mouseOverTest(d);
	}
	
	
}
