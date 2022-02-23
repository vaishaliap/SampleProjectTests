import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class BrowserTest {


    @Test
    @Parameters({"browser"})
    public void launchBrowserTest(String browser){
        System.out.println("@@@@@@@@@@@@@@@@@@ Test Browser Invocation @@@@@@@@@@@@@@@@@@@@@@@@");
            String OSName = System.getProperty("os.name").toLowerCase();
            System.out.println("@@@@@@@@@ Operating System is: "+OSName);
            WebDriver driver=null;

            System.out.println("================================= Opening Browser : "+browser+" ===========================");

            if(browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                //ffOptions.addArguments("-headless");
                driver = new FirefoxDriver(ffOptions);
            }else if(browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chOptions = new ChromeOptions();
                //chOptions.addArguments("--headless");
                driver = new ChromeDriver(chOptions);
            }else if(browser.equalsIgnoreCase("internetexplorer")){
                WebDriverManager.iedriver().setup();
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                //ieOptions.addCommandSwitches("--headless");
                driver = new InternetExplorerDriver(ieOptions);
            }else if(browser.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                //edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().window().maximize();
            driver.get("http://google.com");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
