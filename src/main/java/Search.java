import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Search extends BasePage{
    public Search(WebDriver driver) {
        super(driver);
    }


    public boolean existSearch() {
        try {
            driver.findElement(By.id("twotabsearchtextbox")).getText();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void search(String product) throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        Thread.sleep(2000);
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
    }

    public void searchSuggestion(String product) throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    public void searchProduct(String product) throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        Thread.sleep(2000);
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[2]")).click();
        Thread.sleep(2000);
    }

    public void searchFilter(String product) throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).clear();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        Thread.sleep(2000);
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.id("s-result-sort-select")));
        //dropdown.selectByVisibleText("Price: Low to High");
        dropdown.selectByVisibleText("Price: High to Low");
        //dropdown.selectByVisibleText("Avg. Customer Review");
        //dropdown.selectByVisibleText("Newest Arrivals");
        //dropdown.selectByVisibleText("Featured");
        Thread.sleep(5000);
    }


}
