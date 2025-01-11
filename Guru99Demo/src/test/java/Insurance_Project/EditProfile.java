package Insurance_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProfile {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/index.php"); // Navigate to "Login" page

        // Perform login as a precondition
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("minolirashmitha228@gmail.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("200055");

        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

    }

    @Test
    public void VerifyEditProfile(){

        //Navigate to Edit profile
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-5"); // Navigate to "Edit Profile" page

        // 1) Update Title
        Select titleDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"user_title\"]")));
        titleDropdown.selectByVisibleText("Miss");

        // 2) Update Surname
        WebElement surname = driver.findElement(By.xpath("//*[@id=\"user_surname\"]"));
        surname.sendKeys("New Surname");

        // 3) Update Firstname
        WebElement firstname = driver.findElement(By.xpath("//*[@id=\"user_firstname\"]"));
        firstname.sendKeys("New First name");

        // 4) Update Phone
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"user_phone\"]"));
        phone.sendKeys("0712345678");

        // 5) Update Date of Birth
        Select dobYear = new Select(driver.findElement(By.xpath("//*[@id=\"user_phone\"]")));
        dobYear.selectByVisibleText("1990");

        Select dobMonth = new Select(driver.findElement(By.xpath("//*[@id=\"user_dateofbirth_2i\"]")));
        dobMonth.selectByVisibleText("July");

        Select dobDay = new Select(driver.findElement(By.xpath("//*[@id=\"user_dateofbirth_3i\"]")));
        dobDay.selectByVisibleText("15");

        // 6) Update Licence Type
        WebElement licenceType = driver.findElement(By.xpath("//*[@id=\"user_licencetype_t\"]")); // Full Licence
        licenceType.click();

        // 7) Update Licence Period
        Select licencePeriod = new Select(driver.findElement(By.xpath("//*[@id=\"user_licenceperiod\"]")));
        licencePeriod.selectByVisibleText("5");

        // 8) Update Occupation
        Select occupationDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"user_occupation_id\"]")));
        occupationDropdown.selectByVisibleText("Doctor");

        // 9) Update Address
        WebElement street = driver.findElement(By.xpath("//*[@id=\"user_address_attributes_street\"]"));
        street.sendKeys("New Street");

        WebElement city = driver.findElement(By.xpath("//*[@id=\"user_address_attributes_city\"]"));
        city.sendKeys("New City");

        WebElement country = driver.findElement(By.xpath("//*[@id=\"user_address_attributes_county\"]"));
        country.sendKeys("New County");

        WebElement postcode = driver.findElement(By.xpath("//*[@id=\"user_address_attributes_postcode\"]"));
        postcode.sendKeys("12345");

        // Click Update button
        WebElement updateUserButton = driver.findElement(By.xpath("//*[@id=\"edit_user_\"]/div[14]/input")); //tagname[@attribute='value']
        updateUserButton.click();

    }

    @Test
    public void invalidPhone(){

        // Click Edit Profile tab
        WebElement editProfileButton = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));
        editProfileButton.click();

        // Locate Phone field
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"user_phone\"]"));
        phone.sendKeys("070abcdefg255");

        // Display Error message
        String expectedMsg = "Invalid Phone Number";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");
    }

    @Test
    public void invalidCountry(){

        // Click Edit Profile tab
        WebElement editProfileButton = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));
        editProfileButton.click();

        // Locate Country Field
        WebElement country = driver.findElement(By.xpath("//*[@id=\"user_address_attributes_county\"]"));
        country.sendKeys("67890");

        // Display Error message
        String expectedMsg = "Invalid Format";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");

    }

    @Test
    public void invalidPostCode(){

        // Click Edit Profile tab
        WebElement editProfileButton = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));
        editProfileButton.click();

        // Locate Post Code
        WebElement postcode = driver.findElement(By.xpath("//*[@id=\"user_address_attributes_postcode\"]"));
        postcode.sendKeys("12345");

        // Display Error message
        String expectedMsg = "Invalid Format";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Error message");

    }

}


