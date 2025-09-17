package pageObjects;

import basePackage.baseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class productCatalogue extends baseClass {

    WebDriver driver;
    public productCatalogue(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

//    WebElement loginSuccessMessage= driver.findElement(By.id("toast-container"));
//
//        System.out.println(loginSuccessMessage.getText());
//        Assert.assertTrue(loginSuccessMessage.getText().contains("Login Successfully"));
//        wait.until(ExpectedConditions.invisibilityOf(loginSuccessMessage));
//
//
//    List<WebElement> products=driver.findElements(By.xpath("//h5"));
//    List<WebElement> AddToCartButtons=driver.findElements(By.xpath("//button[text()=' Add To Cart']"));
//
//        for (int i = 0; i < products.size(); i++) {
//        String currentProductName = products.get(i).getText();
//        System.out.println(currentProductName);
//
//        if (currentProductName.equals(productName)) {
//            wait.until(ExpectedConditions.elementToBeClickable(AddToCartButtons.get(i)));
//            AddToCartButtons.get(i).click();
//            break;  // stop loop after clicking
//        }
//    }

    @FindBy(id="toast-container")
    WebElement loginSuccessMessage;

    @FindBy(xpath="//div[@id='toast-container']//div[text()=' Product Added To Cart ']")
    WebElement successMessage;

    @FindBy(xpath="//h5")
    List<WebElement> products;
    By productsLocator=By.xpath("//h5");

    @FindBy(xpath="//button[text()=' Add To Cart']")
    List<WebElement> AddToCartButtons;
    By addToCartButtonsLocator=By.xpath("//button[text()=' Add To Cart']");

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement cartIcon;


    public void loginModalInvisibility(){
        waitForElementToBeVisible(loginSuccessMessage);
        System.out.println(loginSuccessMessage.getText());
        Assert.assertTrue(loginSuccessMessage.getText().contains("Login Successfully"));
        waitForElementToBeInvisible(loginSuccessMessage);
    }

    public void successModalVisibility(){
        waitForElementToBeVisible(successMessage);
        System.out.println(successMessage.getText());
        Assert.assertTrue(successMessage.getText().contains("Product Added To Cart"));
        waitForElementToBeInvisible(successMessage);
    }

    public List<WebElement> getProducts(){
    waitForElementToBeVisible(productsLocator);
    return products;
    }

    public List<WebElement> getAddToCartButtons(){
        waitForElementToBeVisible(addToCartButtonsLocator);
        return AddToCartButtons;
    }

    public void clickCartIcon(){
        click(cartIcon);
    }




}
