//package stepDefinition;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import Pages.PageFactory;
//
//public class BaseCLass {
//    static WebDriver driver;
//    public PageFactory pageFactory;
//
//    public void setUpDriver() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://demo.nopcommerce.com/");
//        pageFactory = new PageFactory(driver);
//    }
//
//    public void close() {
//        driver.close();
//    }
//}
//

package stepDefinition;
import Pages.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class BaseCLass {
    WebDriver driver;
  public PageFactory pageFactory;

    public void Setup() throws IOException {
        FileReader reader = new FileReader("src/test/java/TestData/Resource.Properties");
        Properties data = new Properties();
        data.load(reader);
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get(data.getProperty("URL"));
        pageFactory = new PageFactory(driver);
        driver.manage().window().maximize();
    }
    public void close() {
        driver.quit();
    }
}