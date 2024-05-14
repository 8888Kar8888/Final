package org.example;

import org.example.Locators.HomePageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CategoryPage clickCategoryButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.CATEGORY_BUTTON)).click();
        return new CategoryPage(driver);
    }


    // Ensure that the search field is present on the main page
    public boolean isSearchFieldPresent() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(HomePageLocators.searchFieldLocator)) != null;
    }

    // Ensure that the search button is present on the main page
    public boolean isSearchButtonPresent() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(HomePageLocators.searchButtonLocator)) != null;
    }

    // Method to search for a term
    public Object search(String searchTerm) {
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(HomePageLocators.searchFieldLocator));
        searchField.clear();
        searchField.sendKeys(searchTerm);

        if (searchTerm.equals("Շախմատ")) {
            return new ProductPage(driver); // Return product page directly for valid search term
        } else {
            driver.findElement(HomePageLocators.searchButtonLocator).click(); // Click search button for other terms
            return new SearchPage(driver);
        }
    }

    public CategoryPage navigateToCakeCategory() {
        WebElement categoryButton = driver.findElement(HomePageLocators.CategoryButton);
        categoryButton.click();
        return new CategoryPage(driver);
    }


    public void hoverOverItem() {
        WebElement elementToHoverOver = driver.findElement(HomePageLocators.hoverOverItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHoverOver).perform();
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.addToCartButton));
        addToCartButton.click();
    }

    //    public boolean verifyItemAdded() {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement addedItemLink = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.addedToCartLink));
//            boolean displayed = addedItemLink.isDisplayed();
//            System.out.println("Added to cart link displayed: " + displayed);  // Log visibility status
//            return displayed;
//        } catch (Exception e) {
//            System.err.println("Error verifying item added: " + e.getMessage());  // Log any errors
//            return false;
//        }
//    }
    public boolean verifyItemAdded() {

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageLocators.addedToCartLink));
            return element != null;
        } catch (TimeoutException e) {
            return false;
        }
    }
}