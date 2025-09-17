package basePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class baseClass {
    WebDriver driver;

    public  baseClass(WebDriver driver) {
        this.driver=driver;
    }

    public void waitForElementToBeVisible( By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToBeVisible( WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeVisible( List<WebElement> elements){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForElementToBeInvisible( WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeClickable( WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    // Finds the index of an item by its name in a list
    public int findItemIndexByName(String itemName, List<WebElement> items) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().equals(itemName)) {
                return i;
            }
        }
        return -1; // Not found
    }

    // Waits for a button at a given index to be clickable and clicks it
    public boolean waitAndClickButtonByIndex(List<WebElement> buttons,List<WebElement> items, String itemName) {
        int index=findItemIndexByName(itemName,  items);
        if (index >= 0 && index < buttons.size()) {
            waitForElementToBeClickable(buttons.get(index));
            buttons.get(index).click();
            return true;
        }
        return false;
    }

    public String getText(WebElement element){
        waitForElementToBeVisible(element);
        return element.getText();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

}
