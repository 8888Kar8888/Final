import org.example.AssertionMessages.HomePageAssertionMessages;
import org.example.AssertionMessages.ProductPageAssertionMessages;
import org.example.CategoryPage;
import org.example.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(ScreenshotListener.class)
public class AddToCartTest extends BaseTest
{
    WebDriver wait;
    @Test
    public void TestingCartFunctionality() throws InterruptedException {
        CategoryPage categoryPage = homePage.clickCategoryButton();
        categoryPage.click_on_croissants_option();
        ProductPage productPage = categoryPage.click_on_croissants_1_button();
        productPage.click_on_add_to_cart_button();

        Assert.assertTrue(
                productPage.isElementPresent(),
                ProductPageAssertionMessages.ELEMENT_WITH_TEXT_NOT_DISPLAYED
        );
    }

    @Test
    public void testAddToCartFromHomePage() {
        homePage.hoverOverItem();
        homePage.clickAddToCart();

         homePage.verifyItemAdded();
        Assert.assertEquals(homePage.verifyItemAdded(), HomePageAssertionMessages.ItemIsPresent);
    }

    @Test
    public void testAddingZeroQuantityProductToCart() throws InterruptedException {
        CategoryPage categoryPage = homePage.clickCategoryButton();
        categoryPage.click_on_pastry_option();
        ProductPage productPage = categoryPage.click_on_pastry_2_button();
        productPage.setProductQuantity("0");
        productPage.click_on_add_to_cart_button();
        productPage.Cart_logo_click();
        Assert.assertEquals(productPage.No_Product_InCart_Message_finder(), ProductPageAssertionMessages.NoProductMessage);
    }

    @Test
    public void RemoveItemFunctionality() throws InterruptedException {
        CategoryPage categoryPage = homePage.clickCategoryButton();
        categoryPage.click_on_croissants_option();
        ProductPage productPage = categoryPage.click_on_croissants_1_button();
        productPage.setProductQuantity("10");
        productPage.click_on_add_to_cart_button();
        productPage.Remove_item_from_cart();
        Assert.assertEquals(productPage.No_Product_InCart_Message_finder(), ProductPageAssertionMessages.NoProductMessage);
    }

}





