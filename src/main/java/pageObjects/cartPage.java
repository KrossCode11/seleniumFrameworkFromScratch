package pageObjects;

import basePackage.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class cartPage extends baseClass {

    WebDriver driver;
    public cartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class='heading cf']")
    WebElement cartText;

    @FindBy(xpath = "//div[@class='cart']//h3")
    WebElement itemInCart;

    @FindBy(xpath = "//button[text()='Checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement selectCountryInput;

    @FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted']")
    List<WebElement> countryOptions;

    @FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
            WebElement proceedCTA;

//    List<WebElement> countryOptions=driver.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));


    public String cartTextVisibility(){
        waitForElementToBeVisible(cartText);
        return cartText.getText();
    }

    public String itemInCartVisibility(){
        waitForElementToBeVisible(itemInCart);
        return itemInCart.getText();
    }

    public void clickOnCheckoutButton(){
        waitForElementToBeClickable(checkoutButton);
        checkoutButton.click();
    }
    public List<WebElement> getCountry(){
        waitForElementToBeVisible(countryOptions);
        return countryOptions;
    }
        public void selectCountry(String countryName){
            waitForElementToBeClickable(selectCountryInput);
            selectCountryInput.sendKeys(countryName);
            List<WebElement>getCountryList=getCountry();
            for (int i = 0; i < getCountryList.size(); i++) {
                String currentCountryName = getCountryList.get(i).getText();
                System.out.println(currentCountryName);
                if (currentCountryName.equals("India")) {
                    getCountryList.get(i).click();
                    break;  // stop loop after clicking
                }
            }
        }

    public void clickOnProceedButton(){
        waitForElementToBeClickable(proceedCTA);
        proceedCTA.click();
    }
}
