package org.example;

import org.example.Locators.SearchPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage
{
    private final WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isNoResultsMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(SearchPageLocators.noResultsMessageLocator)) != null;
    }

    public Object searchUsingN1(String searchTerm) {
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(SearchPageLocators.SearchFieldN1));
        searchField.clear();
        searchField.sendKeys(searchTerm);
        driver.findElement(SearchPageLocators.SearchButtonN1).click();

        if (searchTerm.equals("Շախմատ")) {
            return new ProductPage(driver);
        }
        return null;
    }

    // Perform search using the second search field (N2)
    public Object searchUsingN2(String searchTerm) {
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(SearchPageLocators.SearchFieldN2));
        searchField.clear();
        searchField.sendKeys(searchTerm);
        driver.findElement(SearchPageLocators.SearchButtonN2).click();

        if (searchTerm.equals("Շախմատ")) {
            return new ProductPage(driver);
        }
        return null;
    }

    // Perform search using the main search field
    public Object searchUsingMain(String searchTerm) {
        WebElement searchField = wait.until(ExpectedConditions.presenceOfElementLocated(SearchPageLocators.MainSearchField));
        searchField.clear();
        searchField.sendKeys(searchTerm);
        driver.findElement(SearchPageLocators.MainSearchButton).click();

        if (searchTerm.equals("Շախմատ")) {
            return new ProductPage(driver);
        }
        return null;
    }

    public String getSearchResultsMessageText() {
        WebElement searchResultsMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Search results for “”')]")));
        return searchResultsMessage.getText();
    }
}
