package Pages;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private HomePage Home;
    private ComputerPageTestcase ClickComputer;

    WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (Home == null) {
            Home = new HomePage(driver);
        }
        return Home;
    }

    public ComputerPageTestcase getComputerclick() {
        if (ClickComputer == null) {
            ClickComputer = new ComputerPageTestcase(driver);
        }
        return ClickComputer;
    }
}


