package fr.eql.autom.orangehrm.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserManagementPageTest extends MenuPageTest{

	@FindBy(how = How.XPATH, using="//*[@id=\"search_form\"]/fieldset/ol/li[4]/label")
	private WebElement labelStatus;
	@FindBy(id="searchSystemUser_userType")
	private WebElement menuDeroulant;
	@FindBy(xpath="(//table[@id='resultTable']//td)[2]")
	private WebElement choisiAll;
	@FindBy(xpath="//table[@id='resultTable']//td")
	private WebElement choisiEss;
	@FindBy(id="searchBtn")
	private WebElement boutonRecherche;
	@FindBy(id="searchSystemUser_userName")
	private WebElement inputUserName;
	
	
	public UserManagementPageTest(WebDriver d) {
		super(d);
	}

	public WebElement getLabelStatus() {
		return labelStatus;
	}
	
	public void rechercheParRole(String role) {
		Select menu = new Select(menuDeroulant);
		menu.selectByVisibleText(role);
		boutonRecherche.click();
	}
	
	public String getChoisiAll() {
		return this.choisiAll.getText();
	}
	
	public String getChoisiEss() {
		return this.choisiEss.getText();
	}
	

	public WebElement getInputUserName() {
		return inputUserName;
	}
	
	public int numeroDeColonneParEntete(String header) {
		
		int ligneTrouvee = -1;
		int ligneCourant = 0;
		
		List<WebElement> entetes = this.driver.findElements(By.xpath("//table[@id='resultTable']/thead/tr/th"));
		for(WebElement entete : entetes) {
			if(header.equals(entete.getText())) {
				ligneTrouvee = ligneCourant;
				return ligneTrouvee;
			}
			ligneCourant++;
		}
		return ligneTrouvee;
	}

	public int trouverLigneContenantUtilisateurParNom(String nom) {
		List<WebElement> lignes = this.driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

		int numeroDeLigne = -1;
		int ligneCourante = 0;
		
		int numeroColonne = this.numeroDeColonneParEntete("Employee Name");
		
		for (WebElement ligne : lignes) {
			WebElement caseDemande = ligne.findElement(By.xpath("td["+(numeroColonne+1)+"]"));
			if (nom.equals(caseDemande.getText())) {
				numeroDeLigne = ligneCourante;
				return numeroDeLigne;
			}
			ligneCourante++;
		}
		return numeroDeLigne;
	}
	
	// cliquer sur admin2
	public UserInfoPageTest cliquerSurAdmin2(String nom) throws IvalideTableRowNumberException {
		int numeroligne = this.trouverLigneContenantUtilisateurParNom(nom); 
		if (numeroligne != -1) {
			WebElement ligne = this.driver.findElement(By.xpath("(//table[@id='resultTable']/tbody/tr)["+numeroligne+"]"));
			WebElement caseUserName = ligne.findElement(By.xpath("td[2]/a"));
			caseUserName.click();
			return PageFactory.initElements(driver, UserInfoPageTest.class);
		}
		throw new IvalideTableRowNumberException();
		
	}
	
}
