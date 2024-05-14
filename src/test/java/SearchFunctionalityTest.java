import org.example.AssertionMessages.HomePageAssertionMessages;
import org.example.AssertionMessages.ProductPageAssertionMessages;
import org.example.AssertionMessages.SearchPageAssertionMessages;
import org.example.ProductPage;
import org.example.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class SearchFunctionalityTest extends BaseTest
{

    @Test
    public void testMainPageFunctionality()
    {

        Assert.assertEquals(homePage.isSearchFieldPresent(), HomePageAssertionMessages.SearchFieldPresent);
        Assert.assertEquals(homePage.isSearchButtonPresent(), HomePageAssertionMessages.SearchButtonPresent);

    }
    @Test
    public void testValidSearch() {
        ProductPage productPage = (ProductPage) homePage.search("Շախմատ");

        Assert.assertNotNull(productPage, "Test Failed: Did not navigate to product page for 'Շախմատ'");

        Assert.assertEquals(productPage.isTextPresentOnPage(), ProductPageAssertionMessages.Visibility_OF_ELEMENT_WITH_TEXT);
    }

    @Test
    public void testInvalidSearch() {
        Object resultPage = homePage.search("invalidProduct123");

        Assert.assertTrue(resultPage instanceof SearchPage, "Test Failed: Did not navigate to search page for 'invalidProduct123'");

        SearchPage searchPage = (SearchPage) resultPage;
        Assert.assertEquals(searchPage.isNoResultsMessageDisplayed(), SearchPageAssertionMessages.NoResultMessageFound);
    }

    @Test
    public void testValidSearchUsingMainField() {
        Object resultPage = homePage.search("Շախմատ");

        Assert.assertTrue(resultPage instanceof ProductPage, "Test Failed: Did not navigate to product page for 'Շախմատ'");

        ProductPage productPage = (ProductPage) resultPage;
        Assert.assertEquals( productPage.isTextPresentOnPage(), ProductPageAssertionMessages.Visibility_OF_ELEMENT_WITH_TEXT);
    }

    @Test
    public void testInvalidSearchUsingMainField() {
        Object resultPage = homePage.search("invalidProduct123");

        Assert.assertTrue(resultPage instanceof SearchPage, "Test Failed: Did not navigate to search page for 'invalidProduct123'");

        SearchPage searchPage = (SearchPage) resultPage;
        Assert.assertEquals(searchPage.isNoResultsMessageDisplayed(), SearchPageAssertionMessages.NoResultMessageFound);
    }

    @Test
    public void testValidSearchUsingN1() {
        Object resultPage = homePage.search("invalidProduct123");

        Assert.assertTrue(resultPage instanceof SearchPage, "Test Failed: Did not navigate to search page for 'invalidProduct123'");

        SearchPage searchPage = (SearchPage) resultPage;
        resultPage = searchPage.searchUsingN1("Շախմատ");

        Assert.assertTrue(resultPage instanceof ProductPage, "Test Failed: Did not navigate to product page for 'Շախմատ'");

        ProductPage productPage = (ProductPage) resultPage;
        Assert.assertEquals( productPage.isTextPresentOnPage(), ProductPageAssertionMessages.Visibility_OF_ELEMENT_WITH_TEXT);
    }

    @Test
    public void testInvalidSearchUsingN1() {
        Object resultPage = homePage.search("invalidProduct123");

        Assert.assertTrue(resultPage instanceof SearchPage, "Test Failed: Did not navigate to search page for 'invalidProduct123'");

        SearchPage searchPage = (SearchPage) resultPage;
        resultPage = searchPage.searchUsingN1("invalidProduct123");

        Assert.assertNull(resultPage, "Test Failed: Unexpected page returned for 'invalidProduct123'");
        Assert.assertEquals(searchPage.isNoResultsMessageDisplayed(), SearchPageAssertionMessages.NoResultMessageFound);
    }

    @Test
    public void testValidSearchUsingN2() {
        Object resultPage = homePage.search("invalidProduct123");

        Assert.assertTrue(resultPage instanceof SearchPage, "Test Failed: Did not navigate to search page for 'invalidProduct123'");

        SearchPage searchPage = (SearchPage) resultPage;
        resultPage = searchPage.searchUsingN2("Շախմատ");

        Assert.assertTrue(resultPage instanceof ProductPage, "Test Failed: Did not navigate to product page for 'Շախմատ'");

        ProductPage productPage = (ProductPage) resultPage;
        Assert.assertEquals( productPage.isTextPresentOnPage(), ProductPageAssertionMessages.Visibility_OF_ELEMENT_WITH_TEXT);
    }

    @Test
    public void testInvalidSearchUsingN2() {
        Object resultPage = homePage.search("invalidProduct123");

        Assert.assertTrue(resultPage instanceof SearchPage, "Test Failed: Did not navigate to search page for 'invalidProduct123'");

        SearchPage searchPage = (SearchPage) resultPage;
        resultPage = searchPage.searchUsingN2("invalidProduct123");

        Assert.assertNull(resultPage, "Test Failed: Unexpected page returned for 'invalidProduct123'");

        Assert.assertEquals(searchPage.isNoResultsMessageDisplayed(), SearchPageAssertionMessages.NoResultMessageFound);
    }

    @Test
    public void EmptySearch() throws InterruptedException
    {
        SearchPage searchPage = (SearchPage) homePage.search("");
        String messageText = searchPage.getSearchResultsMessageText();
        org.junit.Assert.assertEquals(messageText, SearchPageAssertionMessages.EmptySearchMessage);
    }
}

