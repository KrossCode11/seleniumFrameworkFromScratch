import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class eCommerceTest {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys("akhilxaxa@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Akhil1234");
        driver.findElement(By.id("login")).click();
        String productName="ZARA COAT 3";

        WebElement loginSuccessMessage= driver.findElement(By.id("toast-container"));

        System.out.println(loginSuccessMessage.getText());
        Assert.assertTrue(loginSuccessMessage.getText().contains("Login Successfully"));
        wait.until(ExpectedConditions.invisibilityOf(loginSuccessMessage));


        List<WebElement> products=driver.findElements(By.xpath("//h5"));
        List<WebElement> AddToCartButtons=driver.findElements(By.xpath("//button[text()=' Add To Cart']"));

        for (int i = 0; i < products.size(); i++) {
            String currentProductName = products.get(i).getText();
            System.out.println(currentProductName);

            if (currentProductName.equals(productName)) {
                wait.until(ExpectedConditions.elementToBeClickable(AddToCartButtons.get(i)));
                AddToCartButtons.get(i).click();
                break;  // stop loop after clicking
            }
        }

       WebElement successMessage= driver.findElement(By.id("toast-container"));

        wait.until(ExpectedConditions.visibilityOf(successMessage));
        System.out.println(successMessage.getText());
        Assert.assertTrue(successMessage.getText().contains("Product Added To Cart"));

        WebElement cartIcon= driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']"));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();

        WebElement cartText= driver.findElement(By.xpath("//div[@class='heading cf']"));
        wait.until(ExpectedConditions.visibilityOf(cartText));
        System.out.println(cartText.getText());
        Assert.assertTrue(cartText.getText().contains("Cart"));

        WebElement itemInCart= driver.findElement(By.xpath("//div[@class='cart']//h3"));
        wait.until(ExpectedConditions.visibilityOf(itemInCart));
        System.out.println(itemInCart.getText());
        Assert.assertTrue(itemInCart.getText().contains(productName));

        WebElement checkoutButton= driver.findElement(By.xpath("//button[text()='Checkout']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();

        WebElement selectCountryInput= driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectCountryInput));
        selectCountryInput.sendKeys("india");

        List<WebElement> countryOptions=driver.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));
        for (int i = 0; i < countryOptions.size(); i++) {
            String currentCountryName = countryOptions.get(i).getText();
            System.out.println(currentCountryName);
            if (currentCountryName.equals("India")) {
                countryOptions.get(i).click();
                break;  // stop loop after clicking
            }
        }


        driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();

        WebElement orderId= driver.findElement(By.xpath("//label[@class='ng-star-inserted']"));
        wait.until(ExpectedConditions.visibilityOf(orderId));
        System.out.println(orderId.getText());

        driver.quit();


    }
}
