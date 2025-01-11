package Telecom_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCustomer {

    WebDriver driver;

    @BeforeMethod
    public void TC_001() { // Verify that user can navigate to the Add Customer page
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/telecom/index.html");

    }

    @Test
    public void TC_002(){ //Verify that user can submit the customer details form with filling all the fields

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Fill the Form

       // Background Check
        WebElement BackgroundCheck = driver.findElement(By.xpath("label[for='done']"));
        BackgroundCheck.click();

        // Billing Address
        // First Name
        WebElement firstName =  driver.findElement(By.name("fname"));
        firstName.sendKeys("Nimesha");

        // Last Name
        WebElement lastName =  driver.findElement(By.name("lname"));
        lastName.sendKeys("Perera");

        // Email
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimesha@gmail.com");

        // Address
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("Matara");

        // Mobile Number
        WebElement mobile = driver.findElement(By.name("telephoneno"));
        mobile.sendKeys("0779898223");

        // Click Submit Button
        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

        // Navigate to Access Details Page
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);
        Assert.assertTrue(actualURL.contains("https://demo.guru99.com/telecom/access.php?"),"Submission Failed!");

    }
    @Test
    public void TC_003(){

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Fill the Form

        // Background Check
        WebElement BackgroundCheck = driver.findElement(By.cssSelector("label[for='done']"));
        BackgroundCheck.click();

        // Billing Address
        // First Name
        WebElement firstName =  driver.findElement(By.name("fname"));
        firstName.sendKeys("Nimesha");

        // Last Name
        WebElement lastName =  driver.findElement(By.name("lname"));
        lastName.sendKeys("Perera");

        // Email
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimesha@gmail.com");

        // Address
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("Matara");

        // Mobile Number
        WebElement mobile = driver.findElement(By.name("telephoneno"));
        mobile.sendKeys("0779898223");

        // Click Submit Button
        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();
    }

    @Test
    public void TC_004(){ //Verify that user cannot submit the customer details form with keeping all the fields empty in form

        // Navigate to Add Customer page
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Locate and click the Submit button without filling any fields
        WebElement submitBtn = driver.findElement(By.name("submit"));
        submitBtn.click();

    }

    @Test
    public void TC_005(){ //Verify that user cannot submit the form with giving numbers to "First name"  field

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // First Name
        WebElement firstName =  driver.findElement(By.name("fname"));
        firstName.sendKeys("123234 ");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//*[@id=\"message\"]"));

        // Validate the error message
        String expectedMessage = "Numbers are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_006(){ //Verify that user cannot submit the form with giving special characters to the "First name" filed

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // First Name
        WebElement firstName =  driver.findElement(By.name("fname"));
        firstName.sendKeys("@#$ ");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//*[@id=\"message\"]"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_007(){ //Verify that user cannot submit the form with giving alphanumerical value to the "First name" field

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // First Name
        WebElement firstName =  driver.findElement(By.name("fname"));
        firstName.sendKeys("nim123");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//*[@id=\"message\"]"));

        // Validate the error message
        String expectedMessage = "Numbers are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_008(){ // Verify that user cannot submit the form when "First name" field empty

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // First Name
        WebElement firstName =  driver.findElement(By.name("fname"));
        firstName.sendKeys("Minoli");
        firstName.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message"));

        // Validate the error message
        String expectedMessage = "Customer name must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_009(){ //Verify that user cannot submit the form with giving numbers to "Last name"  field

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Last Name
        WebElement lastName =  driver.findElement(By.name("lname"));
        lastName.sendKeys("123234");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message50"));

        // Validate the error message
        String expectedMessage = "Numbers are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_010(){ //Verify that user cannot submit the form with giving special characters to the "Last name" filed

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Last Name
        WebElement lastName =  driver.findElement(By.name("lname"));
        lastName.sendKeys("@#$");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message50"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_011(){ // Verify that user cannot submit the form with giving alphanumerical value to the "Last name" field

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Last Name
        WebElement lastName =  driver.findElement(By.name("lname"));
        lastName.sendKeys("nime123");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message50"));

        // Validate the error message
        String expectedMessage = "Numbers are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_012(){ // Verify that user cannot submit the form when "Last name" field empty

        // Navigate Add customer
        //driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Last Name
        WebElement lastName =  driver.findElement(By.name("lname"));
        lastName.sendKeys("Perera");
        lastName.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message9"));

        // Validate the error message
        String expectedMessage = "Customer name must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_013(){ // Verify that user cannot submit the form with invalid email

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Email
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimeshagmail.com");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message9"));

        // Validate the error message
        String expectedMessage = "Email-ID is not valid";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_014(){ // Verify that user cannot submit the form with empty email

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Email
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimesha@gmail.com");
        email.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message9"));

        // Validate the error message
        String expectedMessage = "Email-ID must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_015(){ //Verify that user cannot submit the form with empty address

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Address
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("Matara");
        address.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message3"));

        // Validate the error message
        String expectedMessage = "Address Field must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_016(){ //Verify that user can fill the address field with address special characters

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Address
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("No 12, Galle Road, Matara.");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message3"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_017(){ //Verify that user cannot submit the form with giving only numerical value to address

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Address
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("2343534");

        // Error Message
        String expectedMsg = "Invalid Address";
        WebElement msg = this.driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg, "Error message");

    }

    @Test
    public void TC_018(){ //Verify that user cannot submit the form with invalid phone no.

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Mobile Number
        WebElement mobile = driver.findElement(By.name("telephoneno"));
        mobile.sendKeys("077989");

        // Error Message
        String expectedMsg = "Invalid Mobile Number";
        WebElement msg = this.driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg, "Error message");

    }

    @Test
    public void TC_019(){ // Verify that user cannot submit the form with empty phone no.

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Mobile Number
        WebElement mobile = driver.findElement(By.name("telephoneno"));
        mobile.sendKeys("0779898223");
        mobile.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.id("message7"));

        // Validate the error message
        String expectedMessage = "Mobile no must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");
    }

    @Test
    public void TC_020(){ //Verify that user can reset the form after filling all the fields

        // Navigate Add customer
        driver.get("https://demo.guru99.com/telecom/addcustomer.php");

        // Fill the Form

        // Background Check
        WebElement BackgroundCheck = driver.findElement(By.cssSelector("label[for='done']"));
        BackgroundCheck.click();

        // Billing Address
        // First Name
        WebElement firstName =  driver.findElement(By.name("fname"));
        firstName.sendKeys("Nimesha");

        // Last Name
        WebElement lastName =  driver.findElement(By.name("lname"));
        lastName.sendKeys("Perera");

        // Email
        WebElement email = driver.findElement(By.name("emailid"));
        email.sendKeys("nimesha@gmail.com");

        // Address
        WebElement address = driver.findElement(By.name("addr"));
        address.sendKeys("Matara");

        // Mobile Number
        WebElement mobile = driver.findElement(By.name("telephoneno"));
        mobile.sendKeys("0779898223");

        // Click Reset Button
        WebElement resetBtn = driver.findElement(By.cssSelector("input[value='Reset']"));
        resetBtn.click();
    }

    @Test
    public void close(){
        // Close Browser
        this.driver.quit();
    }

}






