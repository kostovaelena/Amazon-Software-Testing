import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

public class CheckLinks extends BasePage{
    public CheckLinks(WebDriver driver) {
        super(driver);
    }


    public static void verifyLinkActive(String linkUrl)
    {
        try
        {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {

        }
    }

    public void seleniumLinks() {

        String homePage = "http://www.amazon.com";
        String url = "";
        int respCode = 200;
        driver.get(homePage);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {
            url = it.next().getAttribute("href");
            try {
                HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode == HttpURLConnection.HTTP_NOT_FOUND ) {
                    System.out.println(url + " NOT FOUND " + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
                }
                else {
                    System.out.println(url + " OK ");
                }

            } catch (Exception e) {

            }
        }

        driver.quit();
    }

    public void VerifyBrokenImagesUsingSelenium() throws Exception {

        driver.get("https://www.amazon.com/s?k=jackets&crid=13PF6F18X4EYK&sprefix=jackets%2Caps%2C181&ref=nb_sb_noss_1");
        Thread.sleep(5000);

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println(images.size());

        for (WebElement image : images) {
            String imageSrc = image.getAttribute("src");

            try {
                URL url = new URL(imageSrc);
                URLConnection urlConnection = url.openConnection();
                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();

                if(httpURLConnection.getResponseCode() == 200)
                    System.out.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> " +httpURLConnection.getResponseMessage());
                else
                    System.err.println(imageSrc + " >> " + httpURLConnection.getResponseCode() + " >> " +httpURLConnection.getResponseMessage());

                httpURLConnection.disconnect();
            } catch (Exception e) {
                System.err.println(imageSrc);
            }
        }
        driver.quit();
    }
}
