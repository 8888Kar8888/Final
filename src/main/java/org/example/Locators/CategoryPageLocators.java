package org.example.Locators;

import org.openqa.selenium.By;

public class CategoryPageLocators
{
    public static By SortLowToHighButton = By.xpath("//option[contains(text(),'Sort by price: low to high')]");
    public static By SortHighToLowButton = By.xpath("//option[contains(text(),'Sort by price: high to low')]\n");
    public static By SortDropdown = By.name("orderby");
    public static final By CROISSANTS_OPTION_BUTTON = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]/span[1]");
    public static final By CROISSANTS_1_BUTTON = By.xpath("//a[contains(text(),'Դասական կրուասան')]");
    public static final By CATEGORY_PAGE_PASTRY_BUTTON = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]/span[1]");
    public static final By PASTRY_2_BUTTON = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]/a[1]/img[1]");
    public static final By CATEGORY_PAGE_BREAD_BUTTON = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]/span[1]");
    public static final By PRICE_ELEMENTS =By.cssSelector(".products.elements-grid .woocommerce-Price-amount.amount > bdi");

    public static final By FIRST_ELEMENT_OF_LOW_TO_HIGH_SORT =By.xpath("//a[contains(text(),'Կարկանդակ պանրով և թթխմորով')]");
    public static final By FIRST_ELEMENT_OF_HIGH_TO_LOW_SORT =By.xpath("//a[contains(text(),'Միքս շոկոլադային')]"  );

    public static final By Third_Bread_button =(By.xpath("//a[@href='https://marush.am/product/tarekani-alyurov-hac/' and text()='Պումպերնիկել']"));
}
