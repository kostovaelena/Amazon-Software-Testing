import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Page extends BasePage {


    public Page(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
    }

    public void amazonHomePage(){
        driver.get("https://www.amazon.com/");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).isDisplayed();
    }


    public void getNavBar() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("nav-your-amazon")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("p13n-asin-index-3")).click();
        Thread.sleep(5000);
    }

    public void getOrdersHomepage() throws  InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-orders")).click();
        Thread.sleep(4000);
    }

    public void getCartHomepage() throws  InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav-cart")).click();
        Thread.sleep(5000);
    }

    public void getBeautyPage() throws  InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,800)");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#desktop-grid-7")).click();
        Thread.sleep(3000);
    }

    public void getMenuHomepage() throws  InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#nav-hamburger-menu")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(15) > a")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(6) > a")).click();
        Thread.sleep(5000);
    }

    public void pagination(String product) throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        Thread.sleep(2000);
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,2500)");
        Thread.sleep(1000);
        jse.executeScript("window.scrollBy(0,2300)");
        Thread.sleep(5000);
        jse.executeScript("window.scrollBy(0,2300)");
        jse.executeScript("window.scrollBy(0,2000)");
        driver.findElement(By.className("s-pagination-strip"));
        Thread.sleep(4000);
        //driver.findElement(By.cssSelector("#search > div.s-desktop-width-max.s-desktop-content.s-opposite-dir.sg-row > div.s-matching-dir.sg-col-16-of-20.sg-col.sg-col-8-of-12.sg-col-12-of-16 > div > span:nth-child(4) > div.s-main-slot.s-result-list.s-search-results.sg-row > div:nth-child(61) > span > div > span > a.s-pagination-item.s-pagination-next.s-pagination-button.s-pagination-separator")).click();
        driver.findElement(By.className("s-pagination-item s-pagination-next s-pagination-button s-pagination-separator")).click();
        //driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[61]/span/div/span/a[3]")).click();
        Thread.sleep(3000);
    }


    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.id("auth-email-missing-alert"));
        return errorPage.getText();
    }

    public String getErrorMessage2() {
        WebElement errorPage = driver.findElement(By.id("auth-password-missing-alert"));
        return errorPage.getText();
    }

    public String getErrorMessage3() {
        WebElement errorPage = driver.findElement(By.className("a-list-item"));
        return errorPage.getText();
    }

    public String getErrorMessage4(){
        WebElement errorPage=driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div > div.a-section.a-spacing-large > div > div > div"));
        return errorPage.getText();
    }

    public String getErrorMessage5(){
        WebElement errorPage=driver.findElement(By.className("a-alert-content"));
        return errorPage.getText();
    }
}