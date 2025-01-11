package Insurance_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class InsuranceRegister {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openInsurance() { // TC_001 - Verify navigation to "Insurance Project" page
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
    }

    @Test
    public void navigateInsuranceRegister() { // TC_002 - Verify navigation to "Insurance Project Register" page
        driver.get("https://demo.guru99.com/insurance/v1/register.php");
    }

    @Test
    public void insuranceRegister() { // Valid Registration
        driver.get("https://demo.guru99.com/insurance/v1/register.php");

        // 1) Title (Dropdown)
        Select titleDropdown = new Select(driver.findElement(By.id("user_title")));
        titleDropdown.selectByVisibleText("Ms");

        // 2) First Name
        WebElement fname = driver.findElement(By.id("user_firstname"));
        fname.sendKeys("Minoli");

        // 3) Surname
        WebElement sname = driver.findElement(By.id("user_surname"));
        sname.sendKeys("Kudage");

        // 4) Phone
        WebElement phone = driver.findElement(By.id("user_phone"));
        phone.sendKeys("0706959277");

        // 5) DOB
        Select DOBDropdown1 = new Select(driver.findElement(By.id("user_dateofbirth_1i")));
        DOBDropdown1.selectByVisibleText("1995");

        Select DOBDropdown2 = new Select(driver.findElement(By.id("user_dateofbirth_2i")));
        DOBDropdown2.selectByVisibleText("December");

        Select DOBDropdown3 = new Select(driver.findElement(By.id("user_dateofbirth_3i")));
        DOBDropdown3.selectByVisibleText("21");

        // 6) Licence Type (Radio Button)
        WebElement licenceType = driver.findElement(By.id("licencetype_t"));
        licenceType.click();

        // 7) Licence Period (Dropdown)
        Select licencePeriod = new Select(driver.findElement(By.id("user_licenceperiod")));
        licencePeriod.selectByVisibleText("1");

        // 8) Occupation (Dropdown)
        Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
        occupation.selectByVisibleText("Student");

        // 9) Address
        WebElement street = driver.findElement(By.id("user_address_attributes_street"));
        street.sendKeys("Welivita Road");

        WebElement city = driver.findElement(By.id("user_address_attributes_city"));
        city.sendKeys("Malabe");

        WebElement country = driver.findElement(By.id("user_address_attributes_county"));
        country.sendKeys("Sri Lanka");

        // 10) Post Code
        WebElement postcode = driver.findElement(By.id("user_address_attributes_postcode"));
        postcode.sendKeys("10115");

        // 11) Email
        WebElement email = driver.findElement(By.id("user_user_detail_attributes_email"));
        email.sendKeys("minolirashmitha228@gmail.com");

        // 12) Password
        WebElement pwd = driver.findElement(By.id("user_user_detail_attributes_password"));
        pwd.sendKeys("200055");

        // 13) Confirm Password
        WebElement confirmpwd = driver.findElement(By.id("user_user_detail_attributes_password_confirmation"));
        confirmpwd.sendKeys("200055");

        // Click Create button
        WebElement createButton = driver.findElement(By.name("submit"));
        createButton.click();
    }

    @Test
    public void ResetFields(){
        driver.get("https://demo.guru99.com/insurance/v1/register.php");

        // 1) Title (Dropdown)
        Select titleDropdown = new Select(driver.findElement(By.id("user_title")));
        titleDropdown.selectByVisibleText("Ms");

        // 2) First Name
        WebElement fname = driver.findElement(By.id("user_firstname"));
        fname.sendKeys("Minoli");

        // 3) Surname
        WebElement sname = driver.findElement(By.id("user_surname"));
        sname.sendKeys("Kudage");

        // 4) Phone
        WebElement phone = driver.findElement(By.id("user_phone"));
        phone.sendKeys("0706959277");

        // 5) DOB
        Select DOBDropdown1 = new Select(driver.findElement(By.id("user_dateofbirth_1i")));
        DOBDropdown1.selectByVisibleText("1995");

        Select DOBDropdown2 = new Select(driver.findElement(By.id("user_dateofbirth_2i")));
        DOBDropdown2.selectByVisibleText("December");

        Select DOBDropdown3 = new Select(driver.findElement(By.id("user_dateofbirth_3i")));
        DOBDropdown3.selectByVisibleText("21");

        // 6) Licence Type (Radio Button)
        WebElement licenceType = driver.findElement(By.id("licencetype_t"));
        licenceType.click();

        // 7) Licence Period (Dropdown)
        Select licencePeriod = new Select(driver.findElement(By.id("user_licenceperiod")));
        licencePeriod.selectByVisibleText("1");

        // 8) Occupation (Dropdown)
        Select occupation = new Select(driver.findElement(By.id("user_occupation_id")));
        occupation.selectByVisibleText("Student");

        // 9) Address
        WebElement street = driver.findElement(By.id("user_address_attributes_street"));
        street.sendKeys("Welivita Road");

        WebElement city = driver.findElement(By.id("user_address_attributes_city"));
        city.sendKeys("Malabe");

        WebElement country = driver.findElement(By.id("user_address_attributes_county"));
        country.sendKeys("Sri Lanka");

        // 10) Post Code
        WebElement postcode = driver.findElement(By.id("user_address_attributes_postcode"));
        postcode.sendKeys("10115");

        // 11) Email
        WebElement email = driver.findElement(By.id("user_user_detail_attributes_email"));
        email.sendKeys("minolirashmitha228@gmail.com");

        // 12) Password
        WebElement pwd = driver.findElement(By.id("user_user_detail_attributes_password"));
        pwd.sendKeys("200055");

        // 13) Confirm Password
        WebElement confirmpwd = driver.findElement(By.id("user_user_detail_attributes_password_confirmation"));
        confirmpwd.sendKeys("200055");

        // Click Reset button
        WebElement resetButton = driver.findElement(By.id("resetform"));
        resetButton.click();
    }

    @Test
    public void verifyEmptyFieldsRegistration() {
        driver.get("https://demo.guru99.com/insurance/v1/register.php");
        // Click Create button without filling any details
        WebElement createButton = driver.findElement(By.name("submit"));
        createButton.click();

        // error message
        String expectedMsg = "Fill the details first";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");

    }

    @Test
    public void InvalidPhone(){

        // Click Register Button
        WebElement registerButton = driver.findElement(By.xpath("/html/body/div[3]/a"));
        registerButton.click();

        // Locate Phone field
        WebElement phone = driver.findElement(By.id("user_phone"));
        phone.sendKeys("070695927777");


        // Display Error message
        String expectedMsg = "Invalid Phone Number";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");

    }

    @Test
    public void InvalidEmail(){

        // Click Register Button
        WebElement registerButton = driver.findElement(By.xpath("/html/body/div[3]/a"));
        registerButton.click();

        // Locate Email field
        WebElement email = driver.findElement(By.id("user_user_detail_attributes_email"));
        email.sendKeys("minolirashmitha228");

        // Display Error message
        String expectedMsg = "Invalid Email";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");

    }

    @Test
    public void InvalidCity(){

        // Click Register Button
        WebElement registerButton = driver.findElement(By.xpath("/html/body/div[3]/a"));
        registerButton.click();

         // Locate City field
        WebElement city = driver.findElement(By.id("user_address_attributes_city"));
        city.sendKeys("12345");

        // Display Error message
        String expectedMsg = "Invalid Email";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");

    }

    @Test
    public void InvalidCountry(){

        // Click Register Button
        WebElement registerButton = driver.findElement(By.xpath("/html/body/div[3]/a"));
        registerButton.click();

        // Locate Country field
        WebElement country = driver.findElement(By.id("user_address_attributes_county"));
        country.sendKeys("67890");

        // Display Error message
        String expectedMsg = "Invalid Email";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");

    }

    @Test
    public void InvalidPostCode(){

        // Click Register Button
        WebElement registerButton = driver.findElement(By.xpath("/html/body/div[3]/a"));
        registerButton.click();

        // 10) Post Code
        WebElement postcode = driver.findElement(By.id("user_address_attributes_postcode"));
        postcode.sendKeys("abcde");

        // Display Error message
        String expectedMsg = "Invalid Email";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");

    }

    @AfterMethod
    public void close() {
        // Close the browser
        driver.quit();
    }

}












