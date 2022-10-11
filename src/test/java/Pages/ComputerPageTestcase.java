package Pages;
import net.jodah.failsafe.internal.util.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinition.BaseCLass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class ComputerPageTestcase extends BaseCLass {
    WebDriver driver;
    WebDriverWait wait;
    Properties prop;
    By ClickOnComputer = By.xpath("//a[text()='Computers ']");
    By ClickOnNotebook = By.xpath("//a[text()=' Notebooks ']");
     By Pricedropdown = By.xpath("//select[@name='products-orderby']");
    By SortingByPrice  =By.xpath("//option[@value='10']");
    By ClickingOnItem = By.xpath("//a[contains(text(),'Lenovo Thinkpad X1 Carbon Laptop')]");
    By ClickOnCopmp = By.xpath("//a[contains(text(),'Asus N551JK-XO076H Laptop')]");
    By AddingItemTocart = By.xpath("//button[@id='add-to-cart-button-5']");
    By VerifyingItem = By.xpath("//h1[contains(text(),'Asus N551JK-XO076H Laptop')]");
    By ShoppingCart = By.xpath("//a[@class='ico-cart']");
    By VerifyingCartitem = By.xpath("//span[@class='sku-number']");
    By AgreeCheckbox = By.xpath("//input[contains(@name,'termsofservice')]");
    private static String submit = "(//button[@type='%s'])[%d]";
    By RegisterButton =By.xpath("//button[text()='Register']");
    By ClickonGender= By.xpath("//span[@class='female']");
    By EnterFirstName = By.xpath("//input[@name='FirstName']");
    By EnterLastname=By.xpath("//input[@name='LastName']");
    By ClickonDay=By.xpath("//select[@name='DateOfBirthDay']");
    By ChooseDate=By.xpath("//*[contains(text(),'9')]");
    By ClickonMonth=By.xpath("//select[@name='DateOfBirthMonth']");
    By ChooseMonthName=By.xpath("//*[contains(text(),'March')]");
    By ClickonYear=By.xpath("//select[@name='DateOfBirthYear']");
    By ChooseYearNo=By.xpath("//*[contains(text(),'2001')]");
    By EnterEmail=By.xpath("//input[@name='Email']");
    By EnterCompany=By.xpath("//input[@name='Company']");
    By EnterPassword=By.xpath("//input[@name='Password']");
    By EnterConfPassword = By.xpath("//input[@name='ConfirmPassword']");
    By ClickOnRegisterbutton =By.xpath("//button[@name='register-button']");
    By IncreasingQuantity =By.xpath("//input[@class='qty-input']");
    By Enteremail = By.xpath("//input[@name='Email']");
    By EnterPass = By.xpath("//input[@name='Password']");
    By LoginButton = By.xpath("//button[contains(text(),'Log in')]");
    By ClickingOnCountyr = By.xpath("//select[@name='BillingNewAddress.CountryId']");

    public ComputerPageTestcase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(9000));
    }
    public void ClickOnComputer() {
        driver.findElement(ClickOnComputer).click();
        driver.findElement(ClickOnNotebook).click();

    }
    public void SortitemsByPrice() {
         driver.findElement(Pricedropdown).click();
         driver.findElement(SortingByPrice).click();
    }
    public void AddItemTocart() throws InterruptedException {
     Thread.sleep(9000);
        driver.findElement(ClickingOnItem).click();
        driver.findElement(ClickOnCopmp).click();
        driver.findElement(AddingItemTocart).click();
        String actual = driver.findElement(VerifyingItem).getText();
        Assert.isTrue(actual.equals("Asus N551JK-XO076H Laptop"), "Expected result does not match with actual result");
        driver.findElement(ShoppingCart).click();
        actual = driver.findElement(VerifyingCartitem).getText();
        Assert.isTrue(actual.equals("AS_551_LP"), "Expected result does not match with actual result");
        driver.findElement(AgreeCheckbox).click();
        driver.findElement(By.xpath(String.format(submit, "submit", 6))).click();
    }
    public void AddUserdetails() throws IOException {
        driver.findElement(RegisterButton).click();

        String path = System.getProperty("user.dir") + "//src//test//java//TestData//Nopcomdtadriven.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String Fname    = sheet.getRow(1).getCell(0).getStringCellValue();
        String Lname    = sheet.getRow(1).getCell(1).getStringCellValue();
        String email    = sheet.getRow(1).getCell(2).getStringCellValue();
        String company  = sheet.getRow(1).getCell(3).getStringCellValue();
        String password   =sheet.getRow(1).getCell(4).getStringCellValue();
        String conpassword   =sheet.getRow(1).getCell(5).getStringCellValue();
        driver.findElement(ClickonGender).click();
        driver.findElement(EnterFirstName).sendKeys(Fname);
        driver.findElement(EnterLastname).sendKeys(Lname);
        driver.findElement(ClickonDay).click();
        driver.findElement(ChooseDate).click();
        driver.findElement(ClickonMonth).click();
        driver.findElement(ChooseMonthName).click();
        driver.findElement(ClickonYear).click();
        driver.findElement(ChooseYearNo).click();
        driver.findElement(EnterEmail).sendKeys(email);
        driver.findElement(EnterCompany).sendKeys(company);
        driver.findElement(EnterPassword).sendKeys(password);
        driver.findElement(EnterConfPassword).sendKeys(conpassword);
        driver.findElement(ClickOnRegisterbutton).click();
        driver.findElement(ShoppingCart).click();
        driver.findElement(IncreasingQuantity).clear();
        driver.findElement(IncreasingQuantity).sendKeys("4");
        driver.findElement(AgreeCheckbox).click();
        driver.findElement(By.xpath(String.format(submit, "submit", 6))).click();
    }
    public void login()
    {
        driver.findElement(Enteremail).click();
        try {
            prop = new Properties();
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//TestData//Resource.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(Enteremail).sendKeys(prop.getProperty("Email"));
        driver.findElement(EnterPass).sendKeys(prop.getProperty("Pass"));
        driver.findElement(LoginButton).click();
        driver.findElement(ClickingOnCountyr).click();

    }
}

