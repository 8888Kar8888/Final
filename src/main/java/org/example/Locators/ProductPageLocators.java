package org.example.Locators;

import org.openqa.selenium.By;

public class ProductPageLocators
{
    public static final By QuantityLocatorForTest1 = By.cssSelector("div.quantity input.input-text.qty.text");
    public static final By quantityFieldLocatorForTest2 = By.cssSelector("div.quantity input.input-text.qty.text");
    public static final By WishlistButton = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]");
    public static final By PRODUCT_PAGE_INCREASE_QUANTITY_BUTTON = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[3]");
    public static final By PRODUCT_PAGE_DECREASE_QUANTITY_BUTTON = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]");
    public static final By PRODUCT_PAGE_ADD_TO_CART_BUTTON = By.xpath("//button[contains(text(),'Ավելացնել զամբյուղ')]");
    public static final By CART_LOGO_BUTTON = By.xpath("//header/div[1]/div[2]/div[1]/div[1]/div[3]/div[4]/a[1]/span[1]");
    public static final By CART_MESSAGE_LOCATOR =  By.xpath("//p[contains(text(),'No products in the cart.')]");
    public static final By REMOVE_BUTTON_OF_CART = By.xpath("//a[contains(text(),'×')]");
}
