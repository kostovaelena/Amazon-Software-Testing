import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderInfo extends BasePage{
    public OrderInfo(WebDriver driver) {
        super(driver);
    }


    public void orderInfo() throws InterruptedException{

        driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
        Thread.sleep(2000);
        try{
            WebElement select = driver.findElement(By.id("select-all"));
            System.out.printf("Postoi link za selektiranje na site produkti vo cart odednash");
            select.click();
            Thread.sleep(2000);
        }
        catch (NoSuchElementException e)
        {
            driver.findElement(By.id("deselect-all"));
            System.out.printf("Postoi link za deselektiranje na site produkti vo cart odednash");
            Thread.sleep(2000);
        }

        driver.findElement(By.className("a-dropdown-container")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("quantity_0")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("a-button-inner")).click();
        Thread.sleep(2000);

        try{
            driver.findElement(By.xpath("//*[@id=\"address-book-entry-0\"]/div[2]/span/a")).click();
            Thread.sleep(40000);

        }
        catch (NoSuchElementException e) {

            driver.findElement(By.className("a-dropdown-container")).click();
            driver.findElement(By.xpath("//*[@id=\"1_dropdown_combobox\"]/li[235]/a")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("address-ui-widgets-enterAddressFullName")).sendKeys("Trio Skit");
            Thread.sleep(2000);
            driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("Palmar 2313-2291");
            Thread.sleep(2000);
            driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("11200 Montevideo, Departamento de Montevideo, Uruguay");
            Thread.sleep(2000);
            driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("Montevideo");
            Thread.sleep(2000);
            driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion")).sendKeys("Uruguay");
            Thread.sleep(2000);
            driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("11100");
            Thread.sleep(2000);
            driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("+598 2204 5199");
            driver.findElement(By.id("address-ui-widgets-form-submit-button")).click();
            Thread.sleep(1000);

        }

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"apx-add-credit-card-action-test-id\"]")));
        el.getText();
        driver.findElement(By.xpath("//*[@id=\"apx-add-credit-card-action-test-id\"]")).click();
        Thread.sleep(2000);

        try{
            driver.findElement(By.name("delete.1")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("continueMultiAddress")).click();
        }
        catch (NoSuchElementException e){

            Thread.sleep(2000);
            driver.switchTo().frame(0);
            WebDriverWait wait1 = new WebDriverWait(driver, 50);
            WebElement el1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.name("addCreditCardNumber")));
            el1.getText();
            driver.findElement(By.name("addCreditCardNumber")).sendKeys("2001 2325 1234 2536");
            Thread.sleep(2000);
            driver.findElement(By.name("ppw-accountHolderName")).sendKeys("Petar Petreski");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"add-credit-card-expiry-date-input-id\"]/span[1]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"a-popover-2\"]/div/div/ul/li[3]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"add-credit-card-expiry-date-input-id\"]/span[3]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"a-popover-4\"]/div/div/ul/li[4]")).click();
            Thread.sleep(2000);
            WebElement checkbox = driver.findElement(By.name("ppw-updateEverywhereAddCreditCard"));

            if(checkbox.isSelected())
            {
                checkbox.click();
                Thread.sleep(2000);
                checkbox.click();
            }
            Thread.sleep(2000);

            driver.findElement(By.name("ppw-widgetEvent:AddCreditCardEvent")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("ppw-widgetEvent:CancelAddCreditCardEvent"));
            Thread.sleep(1000);
        }
    }
}
