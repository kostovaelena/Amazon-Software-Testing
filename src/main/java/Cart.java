import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Cart extends BasePage{
    public Cart(WebDriver driver) {
        super(driver);
    }


    public boolean isAvailable() {
        WebElement add = driver.findElement(By.id("add-to-cart-button"));
        if (add.isDisplayed())
        {
            return true;
        }
        else
            return false;
    }
    public void addToCart() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"contextualIngressPtLabel_deliveryShortLine\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"GLUXCountryValue\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"GLUXCountryList_235\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("glowDoneButton")).click();
        Thread.sleep(2000);

        for(int i=2; i<5; i++)
        {
            try {
                driver.findElement(By.xpath("//*[@id=\"tp-inline-twister-dim-values-container\"]/ul/li[" + i +"]")).click();
                Thread.sleep(2000);
            }
            catch (NoSuchElementException e){
                driver.findElement(By.xpath("(//*[starts-with(@id,'color_name_')])["+i+"]")).click();
                Thread.sleep(2000);
            }
            boolean c=isAvailable();
            if(c) {
                driver.findElement(By.id("add-to-cart-button")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    public void cart(String num) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("a-dropdown-container")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("quantity_4")).click();
        Thread.sleep(2000);
        Select dropdown = new Select(driver.findElement(By.name("quantity")));
        dropdown.selectByVisibleText("10+");
        Thread.sleep(2000);
        WebElement toClear = driver.findElement(By.name("quantityBox"));
        toClear.sendKeys(Keys.CONTROL + "A");
        toClear.sendKeys(Keys.DELETE);
        driver.findElement(By.name("quantityBox")).sendKeys(num);
        Thread.sleep(2000);
        driver.findElement(By.className("a-spacing-top-small")).click();
        Thread.sleep(2000);

        try{
            driver.findElement(By.id("nav-cart-count"));
            System.out.println("Brojot na elementi vo koshnicka e prikazan.");
        }
        catch (NoSuchElementException e){
            System.out.println("Brojot na elementi vo koshnicka ne e prikazan.");
        }

        driver.findElement(By.className("a-dropdown-container")).click();
        Thread.sleep(2000);
        Select delete = new Select(driver.findElement(By.name("quantity")));
        delete.selectByVisibleText("0 (Delete)");

        try{
            driver.findElement(By.className("a-spacing-mini"));
            System.out.println("Prikazani se cenite na site produkti vo koshnickata oddelno");
        }
        catch (NoSuchElementException e){
            System.out.println("Cenite na produktite vo koshnickata ne se prikazani");
        }

        String text = driver.findElement(By.id("sc-subtotal-label-buybox")).getText().toString();
        if(text.equals(" No items selected")){
            System.out.println("Nema selektirano produkti vo koshnickata");
        }
        else{
            System.out.println("Postojat produkti od koshnickata koi se selektirani");
        }
    }
}
