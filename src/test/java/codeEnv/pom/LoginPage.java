package codeEnv.pom;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends PomTemplate {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public LoginPage(WebDriver driver,int timeOut){
        super(driver,timeOut);
    }
    @FindBy(how=How.ID,using = "email")
    WebElement userName;
    @FindBy(how=How.ID,using = "pass")
    WebElement password;
    @FindBy(how=How.ID,using = "loginbutton")
    WebElement loginButton;
    @FindBy(how=How.XPATH,using = "//div[@id='js_7b']/div/div/ul/li[14]/a/span/span")
    WebElement logout;
    @FindBy(how=How.ID,using = "userNavigationLabel")
    WebElement navigationArrow;

    public void enterCredential(String str_userName,String str_Password){
        $(userName).sendKeys(str_userName);
        $(password).sendKeys(str_Password);
    }
    public void clickLoginBtn(){
        $(loginButton).click();
    }
    public void verifyLogin(){
        $(navigationArrow).click();
        Assert.assertTrue($(logout).isPresent());
        $(logout).click();
    }
}
