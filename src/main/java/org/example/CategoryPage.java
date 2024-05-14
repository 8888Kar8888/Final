package org.example;

import org.example.Locators.CategoryPageLocators;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryPage
{
    private final WebDriver driver;
    WebDriverWait wait;

    public CategoryPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click_on_croissants_option()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CategoryPageLocators.CROISSANTS_OPTION_BUTTON)).click();
    }

    public void click_on_pastry_option()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CategoryPageLocators.CATEGORY_PAGE_PASTRY_BUTTON)).click();
    }



    public ProductPage click_on_croissants_1_button() {
        try {
            WebElement croissantButton = wait.until(ExpectedConditions.elementToBeClickable(CategoryPageLocators.CROISSANTS_1_BUTTON));
            System.out.println("Element is clickable.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", croissantButton);
            System.out.println("Clicked on the croissants 1 button using JavaScript.");
            return new ProductPage(driver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ProductPage click_on_pastry_2_button() {
        try {
            WebElement pastryButton = wait.until(ExpectedConditions.elementToBeClickable(CategoryPageLocators.PASTRY_2_BUTTON));
            System.out.println("Pastry 2 button is clickable.");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pastryButton);
            System.out.println("Clicked on the pastry 2 button using JavaScript.");
            return new ProductPage(driver);
        } catch (Exception e) {
            System.out.println("Failed to click on the pastry 2 button: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void click_on_bread_option() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CategoryPageLocators.CATEGORY_PAGE_BREAD_BUTTON)).click();

    }




    public ProductPage third_bread_button()
    {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'tarekani-alyurov-hac/') and text()='Պումպերնիկել']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return new ProductPage(driver);
    }

    public void sortLowToHigh() {
        // Locating the dropdown and selecting the option by value
        Select sortDropdown = new Select(driver.findElement(CategoryPageLocators.SortDropdown));
        sortDropdown.selectByValue("price");  // "Sort by price: low to high"
    }

    public void sortHighToLow() {
        // Locating the dropdown and selecting the option by value
        Select sortDropdown = new Select(driver.findElement(CategoryPageLocators.SortDropdown));
        sortDropdown.selectByValue("price-desc");  // "Sort by price: high to low"
    }

    public List<Double> extractPrices() {
        // Only extract prices from the specified product grid
        List<WebElement> priceElements = driver.findElements(CategoryPageLocators.PRICE_ELEMENTS);
        List<Double> prices = new ArrayList<>();
        for (WebElement element : priceElements) {
            String priceText = element.getText()
                    .replace("AMD", "") // Remove currency symbol
                    .replaceAll("\\D", ""); // Remove all non-digit characters, including non-breaking spaces
            try {
                // Convert the cleaned price text to a double
                double price = Double.parseDouble(priceText);
                prices.add(price);
            } catch (NumberFormatException e) {
                System.err.println("Failed to parse price: " + priceText); // Log errors in parsing
            }
        }
        System.out.println("Extracted prices: " + prices); // Output for debugging
        return prices;
    }

    public boolean assertPricesSorted(boolean ascending)
    {
        if (ascending) {
            wait.until(ExpectedConditions.presenceOfElementLocated(CategoryPageLocators.FIRST_ELEMENT_OF_LOW_TO_HIGH_SORT));
        }
        else
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(CategoryPageLocators.FIRST_ELEMENT_OF_HIGH_TO_LOW_SORT));
        }
        List<Double> prices = extractPrices();  // Use the class member
        if (ascending) {

            for (int i = 0; i < prices.size() - 1; i++) {
                Assert.assertTrue("Prices are not sorted low to high.", prices.get(i) <= prices.get(i + 1));
            }
            return true;
        } else {

            for (int i = 0; i < prices.size() - 1; i++) {
                Assert.assertTrue("Prices are not sorted high to low.", prices.get(i) >= prices.get(i + 1));
            }
            return true;
        }
    }






}



