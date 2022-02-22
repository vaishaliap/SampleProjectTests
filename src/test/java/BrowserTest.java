import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class BrowserTest {

    @Test
    public void launchBrowserTest(){
        System.out.println("@@@@@@@@@@@@@@@@@@ Test Browser Invocation @@@@@@@@@@@@@@@@@@@@@@@@");
            String OSName = System.getProperty("os.name").toLowerCase();
            System.out.println("@@@@@@@@@ Operating System is: "+OSName);
            WebDriver driver;

            System.out.println("================================= Opening Browser ===========================");

            //System.setProperty("webdriver.chrome.driver",driverPath);
            //WebDriverManager.chromedriver().setup();

            WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                //ffOptions.addArguments("-headless");
            driver = new FirefoxDriver(ffOptions);
            //ChromeOptions chOptions = new ChromeOptions();
            //chOptions.addArguments("--headless");
            //driver = new ChromeDriver(chOptions);

            driver.manage().window().maximize();
            driver.get("http://google.com");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            String title = driver.getTitle();
            System.out.println("################ Browser Opened Page Title:"+title);
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
