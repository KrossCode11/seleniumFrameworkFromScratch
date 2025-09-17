import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.cartPage;
import pageObjects.landingPage;
import pageObjects.orderConfirmationPage;
import pageObjects.productCatalogue;

import java.time.Duration;
import java.util.List;

public class eCommerceTest {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        landingPage landingPage = new landingPage(driver);
        productCatalogue productCatalogue = new productCatalogue(driver);
        cartPage cartPage = new cartPage(driver);
        orderConfirmationPage orderConfirmationPage = new orderConfirmationPage(driver);
        String productName="ZARA COAT 3";


        landingPage.goTo();
        landingPage.login("akhilxaxa@gmail.com", "Akhil1234");

        productCatalogue.loginModalInvisibility();

        List<WebElement> products=productCatalogue.getProducts();
        List<WebElement> AddToCartButtons=productCatalogue.getAddToCartButtons();

        productCatalogue.waitAndClickButtonByIndex(AddToCartButtons,products, productName);
        productCatalogue.successModalVisibility();
        productCatalogue.clickCartIcon();
        Assert.assertTrue(cartPage.cartTextVisibility().contains("Cart"));
        Assert.assertTrue(cartPage.itemInCartVisibility().contains(productName));
        cartPage.clickOnCheckoutButton();
        cartPage.selectCountry("india");
        cartPage.clickOnProceedButton();

        orderConfirmationPage.getOrderId();

        driver.quit();
//        baseClass.closeBrowser();

//        for (int i = 0; i < products.size(); i++) {
//            String currentProductName = products.get(i).getText();
//            System.out.println(currentProductName);
//
//            if (currentProductName.equals(productName)) {
//                wait.until(ExpectedConditions.elementToBeClickable(AddToCartButtons.get(i)));
//                AddToCartButtons.get(i).click();
//                break;  // stop loop after clicking
//            }
//        }

//       WebElement successMessage= driver.findElement(By.id("toast-container"));
//
//        wait.until(ExpectedConditions.visibilityOf(successMessage));
//        System.out.println(successMessage.getText());
//        Assert.assertTrue(successMessage.getText().contains("Product Added To Cart"));

//        WebElement cartIcon= driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));

//        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
//        cartIcon.click();

//        WebElement cartText= driver.findElement(By.xpath("//div[@class='heading cf']"));
//        wait.until(ExpectedConditions.visibilityOf(cartText));
//        System.out.println(cartText.getText());





//        WebElement selectCountryInput= driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
//        wait.until(ExpectedConditions.elementToBeClickable(selectCountryInput));
//        selectCountryInput.sendKeys("india");
//
//        List<WebElement> countryOptions=driver.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));
//        for (int i = 0; i < countryOptions.size(); i++) {
//            String currentCountryName = countryOptions.get(i).getText();
//            System.out.println(currentCountryName);
//            if (currentCountryName.equals("India")) {
//                countryOptions.get(i).click();
//                break;  // stop loop after clicking
//            }
//        }

//
//        driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
//
//        WebElement orderId= driver.findElement(By.xpath("//label[@class='ng-star-inserted']"));
//        wait.until(ExpectedConditions.visibilityOf(orderId));
//        System.out.println(orderId.getText());




    }
}
