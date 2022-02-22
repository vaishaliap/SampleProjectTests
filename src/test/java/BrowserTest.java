import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class BrowserTest {

    @Test
    public void launchBrowserTest(){
        System.out.println("@@@@@@@@@@@@@@@@@@ Test Browser Invocation @@@@@@@@@@@@@@@@@@@@@@@@");
            String OSName = System.getProperty("os.name").toLowerCase();
            System.out.println("@@@@@@@@@ Operating System is: "+OSName);
            WebDriver driver;

            System.out.println("================================= Opening Browser ===========================");

            //System.setProperty("webdriver.chrome.driver",driverPath);
            WebDriverManager.chromedriver().setup();
            //WebDriverManager.firefoxdriver().setup();
            //driver = new FirefoxDriver();
            driver = new ChromeDriver();
            driver.get("http://google.com");
            String title = driver.getTitle();
            System.out.println("################ Browser Opened Page Title:"+title);

            driver.findElement(By.name("q")).sendKeys("Testing Browser");

                        try {
                            Thread.sleep(20000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
            boolean result = title.equalsIgnoreCase("Google");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%% Boolean Value:"+result);
            Assert.assertTrue(result);
            System.out.println("================================= Closing Browser ===========================");
            driver.quit();
    }
}