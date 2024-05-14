package org.example.Locators;

import org.openqa.selenium.By;

public class HomePageLocators
{
    public static final By CATEGORY_BUTTON = By.xpath("//header/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]");

    public static By searchFieldLocator = By.xpath("//header/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/input[1]");
    public static By searchButtonLocator = By.xpath("//header/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/button[1]");
    public static By CategoryButton = By.xpath("//span[contains(text(),'Տեսականի')]");
    public static final By addToCartButton = By.xpath("//div[@class='woodmart-add-btn wd-add-btn-replace']//a[@aria-label='Add “Ելակով թխվածք” to your cart']");
    public static final By addedToCartLink = By.xpath("//a[contains(@href, 'yelakov-tort/') and contains(@class, 'cart-item-link')]");
    public static final By hoverOverItem = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]");
}
