package fr.eql.autom.orangehrm.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageTest{

	protected final WebDriver d;
	
	@FindBy(how = How.XPATH, using="//*[@id=\"txtUsername\"]")
	private WebElement userName;
	@FindBy(how = How.XPATH, using="//*[@id=\"txtPassword\"]")
	private WebElement password;
	@FindBy(how = How.XPATH, using="//*[@id=\"btnLogin\"]")
	private WebElement boutonLogin;
	
	
	
	public LoginPageTest(WebDriver d) {
		super();
		this.d = d;
	}

	public HomePageTest fournirLoginInfo(String user, String mdp) {
		userName.sendKeys(user);
		password.sendKeys(mdp);
		boutonLogin.click();
		return PageFactory.initElements(d, HomePageTest.class);
	}
	
	
	
	
}
