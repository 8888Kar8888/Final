import org.example.AssertionMessages.CategoryPageAssertionMessages;
import org.example.CategoryPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class CategorySortTest extends BaseTest {
    private CategoryPage categoryPage;

    @Test
    public void testSortLowToHigh() throws InterruptedException {
        categoryPage = homePage.navigateToCakeCategory();
        categoryPage.sortLowToHigh();
        Assert.assertEquals(categoryPage.assertPricesSorted(true), CategoryPageAssertionMessages.productsSortedCorrectly);
    }

    @Test
    public void testSortHighToLow() throws InterruptedException {
        categoryPage = homePage.navigateToCakeCategory();
        categoryPage.sortHighToLow();
        Assert.assertEquals(categoryPage.assertPricesSorted(false),  CategoryPageAssertionMessages.productsSortedCorrectly);
    }




}
