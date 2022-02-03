import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Tests {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void testLinks() {
        Page page = new Page(driver);
        CheckLinks checkLinks=new CheckLinks(driver);
        page.amazonHomePage();
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total links are "+links.size());
        for(int i=0;i<links.size();i++)
        {
            WebElement ele= links.get(i);
            String url=ele.getAttribute("href");
            checkLinks.verifyLinkActive(url);
        }
    }

    @Test
    public void testLinksSelenium() throws Exception {
        Page page = new Page(driver);
        page.amazonHomePage();
        CheckLinks checkLinks=new CheckLinks(driver);
        List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println("Total links are "+links.size());
        checkLinks.seleniumLinks();
    }

    @Test
    public void testImages() throws Exception {
        Page page = new Page(driver);
        CheckLinks checkLinks=new CheckLinks(driver);
        page.amazonHomePage();
        checkLinks.VerifyBrokenImagesUsingSelenium();
    }

    @Test
    public void testLoginLogout() throws InterruptedException{
        Page page = new Page(driver);
        LoginPage loginPage=new LoginPage(driver);
        page.openLoginPage();
        assertTrue(page.isLoaded());
        loginPage.logOut("trioskit3@gmail.com", "Trioskit12345");
        assertTrue(page.isLoaded());
    }

    @Test
    public void testLoginWithEmptyName() throws InterruptedException {
        Page page = new Page(driver);
        LoginPage loginPage=new LoginPage(driver);
        page.openLoginPage();
        assertTrue(page.isLoaded());
        loginPage.loginUser("");
        String errorMessage = page.getErrorMessage();
        assertEquals(errorMessage, "Enter your email or mobile phone number");
    }

    @Test
    public void testLoginWithEmptyPassword() throws InterruptedException {
        Page page = new Page(driver);
        LoginPage loginPage=new LoginPage(driver);
        page.openLoginPage();
        assertTrue(page.isLoaded());
        loginPage.login("trioskit3@gmail.com", "");
        String errorMessage = page.getErrorMessage2();
        assertEquals(errorMessage, "Enter your password");
    }

    @Test
    public void testLoginWithWrongPassword() throws InterruptedException {
        Page page = new Page(driver);
        LoginPage loginPage=new LoginPage(driver);
        page.openLoginPage();
        assertTrue(page.isLoaded());
        loginPage.login("trioskit3@gmail.com", "Password123");
        String errorMessage = page.getErrorMessage3();
        assertEquals(errorMessage, "Your password is incorrect");
    }

    @Test
    public void testForgetPassword() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        String host = "pop.gmail.com";// change accordingly
        String mailStoreType = "pop3";
        String email = "trioskit3@gmail.com";
        String password = "Trioskit12345";
        String code = loginPage.check(host,mailStoreType,email,password);
    }

    @Test
    public void testRegisterWithValidEmail() throws InterruptedException {
        Page page = new Page(driver);
        LoginPage loginPage=new LoginPage(driver);
        page.amazonHomePage();
        assertTrue(new ProductPage(driver).isLoaded());
        loginPage.registerNewUser("Trio Skit","trioskit3@gmail.com","Trioskit12345","Trioskit12345");
        String errorMessage = page.getErrorMessage4();
        assertEquals(errorMessage, "You indicated you're a new customer, but an account already exists with the email address trioskit3@gmail.com.");
    }

    @Test
    public void testNavbar() throws  InterruptedException{
        Page page = new Page(driver);
        LoginPage loginPage=new LoginPage(driver);
        Search search=new Search(driver);
        page.openLoginPage();
        loginPage.login("trioskit3@gmail.com", "Trioskit12345");
        page.getMenuHomepage();
        page.getNavBar();
        page.amazonHomePage();
        page.getBeautyPage();
        page.getCartHomepage();
        assertEquals(loginPage.existName(),"Hello, Trio");
        assertTrue(search.existSearch());
        assertTrue(new ProductPage(driver).isLoaded());
    }

    @Test
    public void testCustomerService() throws InterruptedException{
        Page page = new Page(driver);
        LoginPage loginPage=new LoginPage(driver);
        CustomerService customerService=new CustomerService(driver);
        page.openLoginPage();
        loginPage.login("trioskit3@gmail.com", "Trioskit12345");
        assertEquals(customerService.customerService("Trio Skit"),"Success");
        assertTrue(new ProductPage(driver).isLoaded());
    }


    @Test
    public void testSearchBar()throws InterruptedException{
        Page page =new Page(driver);
        Search search=new Search(driver);
        page.amazonHomePage();
        search.search("tea"); // spored ime na produkot
        //search.search("5626"); // spored broevi
        //search.search("AVON"); // spored brend
        //search.search("movies"); // spored kategorija
        //search.search("matte red lipstick"); // spored specifikacija na produktot
        assertTrue(new ProductPage(driver).isLoaded());
    }

    @Test
    public void testSearchSuggestionFilter()throws InterruptedException{
        Page page =new Page(driver);
        Search search=new Search(driver);
        page.amazonHomePage();
        search.searchSuggestion("phone");
        assertTrue(new ProductPage(driver).isLoaded());
        search.searchFilter("bags");
        assertTrue(new ProductPage(driver).isLoaded());
    }

    @Test
    public void testProductPage() throws InterruptedException{
        Page page = new Page(driver);
        Search search=new Search(driver);
        Product product=new Product(driver);
        page.amazonHomePage();
        search.searchProduct("bags");
        product.productPage();
        assertTrue(new ProductPage(driver).isLoaded());
    }

    @Test
    public void testAddToCart() throws InterruptedException{
        Page page = new Page(driver);
        Cart cart=new Cart(driver);
        LoginPage loginPage=new LoginPage(driver);
        Search search=new Search(driver);
        page.openLoginPage();
        loginPage.login("trioskit3@gmail.com", "Trioskit12345");
        search.searchProduct("sunglasses");
        cart.addToCart();
        assertTrue(new ProductPage(driver).isLoaded());
    }

    @Test
    public void testCart() throws InterruptedException{
        Page page = new Page(driver);
        Cart cart=new Cart(driver);
        LoginPage loginPage=new LoginPage(driver);
        page.openLoginPage();
        loginPage.login("trioskit3@gmail.com", "Trioskit12345");
        cart.cart("9");
        assertTrue(new ProductPage(driver).isLoaded());
    }

    @Test
    public void testOrderInfoTest() throws InterruptedException{
        Page page =new Page(driver);
        LoginPage loginPage=new LoginPage(driver);
        OrderInfo order=new OrderInfo(driver);
        page.openLoginPage();
        loginPage.login("trioskit3@gmail.com","Trioskit12345");
        order.orderInfo();
        String errorMessage = page.getErrorMessage5();
        assertEquals(errorMessage, "Card number is not correct.");
    }


    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/x/Downloads/AmazonSoftwareTesting/src/main/resources/drivers/chromedriver");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}

