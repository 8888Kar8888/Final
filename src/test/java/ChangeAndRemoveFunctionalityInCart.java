import org.example.CategoryPage;
import org.example.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotListener.class)
public class ChangeAndRemoveFunctionalityInCart extends BaseTest
{

    @Test
    public void addQuantityOfProduct() throws InterruptedException
    {
        CategoryPage categoryPage = homePage.clickCategoryButton();
        categoryPage.click_on_bread_option();
        ProductPage productPage = categoryPage.third_bread_button();

        int numberOfIncrements = 10;
        productPage.incrementWithQuantity(numberOfIncrements);

        Assert.assertEquals(productPage.revealing_quantityforT1(), numberOfIncrements+1);
    }

    @Test
    public void TryingToDecreaseProductQuantity() throws InterruptedException {
        CategoryPage categoryPage = homePage.clickCategoryButton();
        categoryPage.click_on_pastry_option();
        ProductPage productPage = categoryPage.click_on_pastry_2_button();
        int numberOfDecrements = 10;
        productPage.decreaseWithQuantity(numberOfDecrements);

        Assert.assertEquals(productPage.revealing_quantityforT2(), 1);
    }

    @Test
    public void TryingToIncreaseAndDecreaseProductQuantity() throws InterruptedException {
        CategoryPage categoryPage = homePage.clickCategoryButton();
        categoryPage.click_on_pastry_option();
        ProductPage productPage = categoryPage.click_on_pastry_2_button();

        int numberOfIncrements = 10;
        productPage.incrementWithQuantity(numberOfIncrements);
        int numberOfDecrements = 3;
        productPage.decreaseWithQuantity(numberOfDecrements);

        Assert.assertEquals(productPage.revealing_quantityforT2(), (numberOfIncrements-numberOfDecrements)+1);
    }


    @Test
    public void setProductQuantityDirectly() throws InterruptedException {
        CategoryPage categoryPage = homePage.clickCategoryButton();
        categoryPage.click_on_pastry_option();
        ProductPage productPage = categoryPage.click_on_pastry_2_button();

        String desiredQuantity = "5";

        productPage.setProductQuantity(desiredQuantity);

        productPage.waitForQuantityUpdate(desiredQuantity);

        Assert.assertEquals(productPage.getCurrentQuantity(), Integer.parseInt(desiredQuantity));
    }




}
