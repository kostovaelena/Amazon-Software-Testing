import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Product extends BasePage{
    public Product(WebDriver driver) {
        super(driver);
    }
    public void productPage() throws InterruptedException {
        driver.findElement(By.xpath("(//li/span/span[starts-with(@id,'a-autoid')])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li/span/span[starts-with(@id,'a-autoid')])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//li/span/span[starts-with(@id,'a-autoid')])[4]")).click();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //Hovering over image
        Actions act = new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("(//li/span/span[starts-with(@id,'a-autoid')])[4]"))).build().perform();

        String x;

        try {
            WebElement ele_zoom = driver.findElement(By.id("magnifierLens"));
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOf(ele_zoom));
            System.out.println("The zoom is visible");
        }
        catch (NoSuchElementException e)
        {
            System.out.println("The zoom is not visible");
        }

        try {
            x = driver.findElement(By.xpath("//*[@id=\"corePrice_desktop\"]/div/table/tbody/tr/td[1]")).getText();
            System.out.println("Cenata e prikazana gore");
        }
        catch (NoSuchElementException e) {
            System.out.println("Cenata ne e prikazana gore");
        }

        try{
            x = driver.findElement(By.id("_price")).getText();
            System.out.println("Cenata e prikazana pod slikite");
        }
        catch (NoSuchElementException e) {
            System.out.println("Cenata ne e prikazana pod slikite ");
        }

        try{
            x = driver.findElement(By.xpath("//*[@id=\"acrCustomerReviewText\"]")).getText();
            System.out.println("Brojot na lugje koi shto postavile rating e prikazan");
        }
        catch (NoSuchElementException e) {
            System.out.println("Brojot na lugje koi shto postavile rating ne e prikazan");
        }

        try{
            x = driver.findElement(By.xpath("//*[@id=\"askATFLink\"]/span")).getText();
            System.out.println("Brojot na odgovoreni prashanja e prikazan");
        }
        catch (NoSuchElementException e) {
            System.out.println("Brojot na odgovoreni prashanja ne e prikazan");
        }

        try{
            x = driver.findElement(By.xpath("//*[@id=\"aplus\"]/h2")).getText();
            System.out.println("Postoi opis za produktot");
        }
        catch (NoSuchElementException e) {
            System.out.println("Ne postoi opis za produktot");
        }

        try{
            x = driver.findElement(By.xpath("//*[@id=\"detailBulletsWrapper_feature_div\"]/h2")).getText();
            System.out.println("Postoi detali za produktot");
        }
        catch (NoSuchElementException e) {
            System.out.println("Ne postojat detali za produktot");
        }

        try{
            x = driver.findElement(By.xpath("//*[@id=\"availability\"]/span")).getText();
            System.out.println("Produktot ne e dostapen");
        }
        catch (NoSuchElementException e) {
            System.out.println("Produktot e dostapen");
        }

        try{
            x = driver.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[1]")).getText();
            System.out.println("Postoi popust na produktot");
        }
        catch (NoSuchElementException e) {
            System.out.println("Ne postoi popust na produktot");
        }

        try {
            x = driver.findElement(By.xpath("//*[@id=\"acrPopover\"]/span[1]/a")).getText();
        } catch (NoSuchElementException e) {
            System.out.println("Rating-ot ne e prikazan.");
        }
        System.out.println("Rating-ot e prikazan.");
        Actions builder = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//*[@id=\"acrPopover\"]/span[1]/a"));
        Thread.sleep(2000);
        builder.moveToElement(we).perform();
        By locator = By.xpath("//*[@id=\"acrPopover\"]/span[1]/a");
        Thread.sleep(2000);
        driver.findElement(locator).click();
        Thread.sleep(3000);

    }
}
