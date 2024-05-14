package org.example;

import org.example.Locators.HomePageLocators;
import org.example.Locators.ProductPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class ProductPage {
    private final WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click_on_product_page_increase() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageLocators.PRODUCT_PAGE_INCREASE_QUANTITY_BUTTON)).click();
    }

    public void click_on_product_page_decrease() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageLocators.PRODUCT_PAGE_DECREASE_QUANTITY_BUTTON)).click();
    }

    public void click_on_add_to_cart_button() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageLocators.PRODUCT_PAGE_ADD_TO_CART_BUTTON)).click();
    }



    public boolean isTextPresentOnPage() {
        By textLocator = By.xpath("//h1[contains(text(),'" + "Շախմատ" + "')]");
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void incrementWithQuantity(int a) throws InterruptedException {
        for (int i = 0; i < a; i++) {
            click_on_product_page_increase();
        }
    }

    public void decreaseWithQuantity(int a) throws InterruptedException {
        for (int i = 0; i < a; i++) {
            click_on_product_page_decrease();
        }
    }

    public int revealing_quantityforT1() {
        WebElement quantityInput = driver.findElement(ProductPageLocators.QuantityLocatorForTest1);
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }

    public int revealing_quantityforT2() {
        WebElement quantityInput = driver.findElement(ProductPageLocators.quantityFieldLocatorForTest2);
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }

    public void setProductQuantity(String quantity) throws InterruptedException {
        WebElement quantityInput = driver.findElement(ProductPageLocators.quantityFieldLocatorForTest2);
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void waitForQuantityUpdate(String expectedQuantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(ProductPageLocators.quantityFieldLocatorForTest2, "value", expectedQuantity));
    }

    public int getCurrentQuantity() {
        WebElement quantityInput = driver.findElement(ProductPageLocators.quantityFieldLocatorForTest2);
        return Integer.parseInt(quantityInput.getAttribute("value"));
    }

    public boolean isElementPresent() {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Ցուցադրել')]")));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void Cart_logo_click()
    {
        wait.until(ExpectedConditions.elementToBeClickable(ProductPageLocators.CART_LOGO_BUTTON)).click();
    }

    public String No_Product_InCart_Message_finder()
    {
        WebElement emptyCartMessage = (wait.until(ExpectedConditions.visibilityOfElementLocated(ProductPageLocators.CART_MESSAGE_LOCATOR)));
        String messageText = emptyCartMessage.getText();
        return messageText;
    }

    public void Remove_item_from_cart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(ProductPageLocators.REMOVE_BUTTON_OF_CART)).click();
    }
}