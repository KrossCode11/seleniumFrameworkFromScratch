package pageObjects;

import basePackage.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage extends baseClass {
//   driver.findElement(By.id("userEmail")).sendKeys("akhilxaxa@gmail.com");
//        driver.findElement(By.id("userPassword")).sendKeys("Akhil1234");
//        driver.findElement(By.id("login")).click();

    WebDriver driver;
    public landingPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    /*Page Factory*/
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement loginButton;

    public void login(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginButton.click();
    }

    public void goTo(){
        driver.get("https://www.rahulshettyacademy.com/client");
    }
}
