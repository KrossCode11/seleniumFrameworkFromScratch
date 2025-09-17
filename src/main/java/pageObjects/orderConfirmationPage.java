package pageObjects;

import basePackage.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class orderConfirmationPage extends baseClass {

    WebDriver driver;
    public orderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@class='ng-star-inserted']")
    WebElement orderId;

    public void getOrderId(){
        waitForElementToBeVisible(orderId);
        System.out.println(orderId.getText());
    }


}
