package ua.org.page.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxPage {

    public MailBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;

    @FindBy(className = "login-button__user")
    private WebElement userProfile;

    @FindBy(className = "login-button__menu-icon")
    private WebElement userMenu;

    @FindBy(id = "login__logout")
    private WebElement buttonLogout;

    public String getUserMail() {
        String userMail = userProfile.getText();
        return userMail;
    }

    public void entryMenu() {
        userMenu.click();
    }

    public void userLogout() {
        buttonLogout.click();
    }

}
