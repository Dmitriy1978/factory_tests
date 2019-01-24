package ua.org.page.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ua.org.page.appmanager.LoginPage;
import ua.org.page.appmanager.MailBoxPage;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MailBoxPage mailBoxPage;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/lukhovytskyi/Downloads/Microsoft.SkypeApp_kzf8qxf38zg5c!App/All/Screenshoter/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mailBoxPage = new MailBoxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.google.com/");

    }

    @Test
    public void loginTest(){
        loginPage.inputLogin("cro.gen.idealflatmate@gmail.com");
        loginPage.inputPassword("qqqqqq666D");
        loginPage.clickLoginButton();
        String  mailUser = mailBoxPage.getUserMail();
        Assert.assertEquals("", mailUser);

    }

    @AfterClass
    public static void tearDown(){
        mailBoxPage.entryMenu();
        mailBoxPage.userLogout();
        driver.quit();

    }


}
