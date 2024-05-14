package org.example.Locators;

import org.openqa.selenium.By;

public class SearchPageLocators
{
    public static By noResultsMessageLocator = By.xpath("//p[contains(text(),'No products were found matching your selection.')]");
    public static By SearchFieldN1 = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/aside[1]/div[2]/div[1]/div[1]/div[1]/form[1]/input[1]");
    public static By SearchButtonN1 = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/aside[1]/div[2]/div[1]/div[1]/div[1]/form[1]/button[1]");
    public static By SearchFieldN2 = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/form[1]/input[1]\n");
    public static By SearchButtonN2 = By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[1]/form[1]/button[1]");

    public static By MainSearchField = By.xpath("//header/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/input[1]");
    public static By MainSearchButton = By.xpath("//header/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/form[1]/button[1]");

}
