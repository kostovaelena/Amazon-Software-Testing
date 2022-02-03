import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerService extends BasePage{
    public CustomerService(WebDriver driver) {
        super(driver);
    }


    public String customerService(String username) throws InterruptedException {
        //driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")));
        el.getText();*/
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[4]/div/div[1]/div[1]/div[1]/a/div/div/div/div[2]/h3")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("a-dropdown-container")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"a-popover-1\"]/div/div/ul/li[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[4]/div/div[1]/div[3]/div[1]/a/div/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div/div/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("auth-cnep-edit-name-button")).click();
        Thread.sleep(2000);
        WebElement toClear = driver.findElement(By.id("ap_customer_name"));
        toClear.sendKeys(Keys.CONTROL + "A");
        toClear.sendKeys(Keys.DELETE);
        driver.findElement(By.id("ap_customer_name")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.id("cnep_1C_submit_button")).click();
        Thread.sleep(2000);
        return driver.findElement(By.xpath("//*[@id=\"auth-success-message-box\"]/div/h4")).getText();
    }
}
