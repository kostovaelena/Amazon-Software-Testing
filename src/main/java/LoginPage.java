import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

import javax.mail.*;
import java.io.ByteArrayOutputStream;
import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(user);
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(2000);
    }

    public void loginUser(String user) throws InterruptedException {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(user);
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
    }

    public void logOut(String user, String password) throws InterruptedException {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(user);
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("signInSubmit")).click();
        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        WebElement we = driver.findElement(By.id("nav-link-accountList"));
        Thread.sleep(2000);
        builder.moveToElement(we).perform();
        By locator = By.id("nav-item-signout");
        Thread.sleep(2000);
        driver.findElement(locator).click();
    }
    public String existName() {
        String x;
        try {
            x = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
        return x;
    }

    public void registerNewUser(String user, String email, String password, String repeatPassword) throws InterruptedException{
        Actions builder = new Actions(driver);
        WebElement we = driver.findElement(By.id("nav-link-accountList"));
        Thread.sleep(2000);
        builder.moveToElement(we).perform();
        By locator = By.cssSelector("#nav-flyout-ya-newCust > a");
        Thread.sleep(2000);
        driver.findElement(locator).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ap_customer_name")).clear();
        driver.findElement(By.id("ap_customer_name")).sendKeys(user);
        Thread.sleep(2000);
        driver.findElement(By.id("ap_email")).sendKeys(email);
        Thread.sleep(2000);
        driver.findElement(By.id("ap_password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("ap_password_check")).sendKeys(repeatPassword);
        Thread.sleep(2000);
        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
    }


    public static String check(String host, String storeType, String user,
                               String password)
    {
        String otpCode=new String();
        try {

            //create properties field
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, user, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);


            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);

                if(message.getFrom()[0].toString().equals("\"Amazon.com\" <account-update@amazon.com>") &&
                        message.getSubject().equals("Amazon password assistance")){
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    message.writeTo(stream);
                    String temp = stream.toString();
                    int index = temp.indexOf("<p class=\"otp\">");
                    otpCode=temp.substring(index+15,index+15+6);
                    //System.out.println(temp.substring(index+15,index+15+6));
                }

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otpCode;
    }





}
