package fr.eql.autom.orangehrm.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserInfoPageTest {

	@FindBy(id="systemUser_status")
	private WebElement selectStatus;
	
	@FindBy(id="systemUser_employeeName_empName")
	private WebElement inputEmployeeName;
	
	@FindBy(how = How.XPATH, using ="//*[@id=\"systemUser_employeeName_empName\"]")
	private WebElement inputUserName;
	@FindBy(how = How.XPATH, using="//*[@id=\"systemUser_userType\"]")
	private WebElement selectUserRole;
	@FindBy(id="btnSave")
	private WebElement boutonEdit;

	public boolean formulaireInactif() {
		return !this.selectUserRole.isEnabled()
				&& !this.inputEmployeeName.isEnabled()
				&& !this.inputUserName.isEnabled()
				&& !this.selectStatus.isEnabled();
	}
	
	public WebElement getInputUserName() {
		return inputUserName;
	}

	public void setInputUserName(WebElement inputUserName) {
		this.inputUserName = inputUserName;
	}

	public WebElement getMenuDeroulantUserRole() {
		return selectUserRole;
	}

	public WebElement getBoutonEdit() {
		return boutonEdit;
	}
	
	
}
