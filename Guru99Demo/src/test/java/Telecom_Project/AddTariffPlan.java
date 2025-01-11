package Telecom_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTariffPlan {

    WebDriver driver;

    @BeforeMethod
    public void Setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/telecom/index.html");

    }

    @Test
    public void TC_001(){ // Verify that user can navigate to the Add Tariff plan page
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");
    }

    @Test
    public void TC_002(){ // Verify that user can add tariff plan after filling all the fields with valid values

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Monthly Rental
        WebElement monthlyRental = driver.findElement(By.cssSelector("#rental1"));
        monthlyRental.sendKeys("1200");

        // Free Local Minutes
        WebElement Local_minutes = driver.findElement(By.id("local_minutes"));
        Local_minutes.sendKeys("500");

        //Free International Minutes
        WebElement International_minutes= driver.findElement(By.id("inter_minutes"));
        International_minutes.sendKeys("100");

        // Free SMS Pack
        WebElement sms = driver.findElement(By.id("sms_pack"));
        sms.sendKeys("50");

        // Local Per Minutes Charges
        WebElement minutes_charges1 = driver.findElement(By.id("minutes_charges"));
        minutes_charges1.sendKeys("1");

        // International Per Minutes Charges
        WebElement minutes_charges2 = driver.findElement(By.id("inter_charges"));
        minutes_charges2.sendKeys("2");

        // SMS Per Charges
        WebElement sms_charges = driver.findElement(By.id("sms_charges"));
        sms_charges.sendKeys("2");

        // Click Submit Button
        WebElement submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));
        submitBtn.click();

    }

    @Test
    public void TC_003(){ // Verify that all the fields are mandatory in the add tariff plan form

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Locate and click the Submit button without filling any fields
        WebElement submitBtn = driver.findElement(By.xpath("//input[@name='submit']"));
        submitBtn.click();

    }

    @Test
    public void TC_004(){ // Verify that user cannot give special characters for the "Monthly Rental" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Monthly Rental
        WebElement monthlyRental = driver.findElement(By.cssSelector("#rental1"));
        monthlyRental.sendKeys("@#$");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message2']"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_005(){ // Verify that user cannot give letters for the "Monthly Rental" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Monthly Rental
        WebElement monthlyRental = driver.findElement(By.cssSelector("#rental1"));
        monthlyRental.sendKeys("fdfdg");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message2']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_006(){ // Verify that user cannot keep "Monthly Rental" field empty

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Monthly Rental
        WebElement monthlyRental = driver.findElement(By.cssSelector("#rental1"));
        monthlyRental.sendKeys("1200");
        monthlyRental.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message2']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_007(){ // Verify that user cannot give special characters for the "Free Local Minutes" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free Local Minutes
        WebElement Local_minutes = driver.findElement(By.id("local_minutes"));
        Local_minutes.sendKeys("@#$");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message3']"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_008(){ // Verify that user cannot give letters for the "Free Local Minutes" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free Local Minutes
        WebElement Local_minutes = driver.findElement(By.id("local_minutes"));
        Local_minutes.sendKeys("fgdfgdsf");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message3']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_009(){ // Verify that user cannot keep "Free Local Minutes" field empty

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free Local Minutes
        WebElement Local_minutes = driver.findElement(By.id("local_minutes"));
        Local_minutes.sendKeys("500");
        Local_minutes.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message3']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_010(){ // Verify that user cannot give special characters for the "Free International Minutes" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free International Minutes
        WebElement International_minutes= driver.findElement(By.id("inter_minutes"));
        International_minutes.sendKeys("##$%");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message4']"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_011(){ // Verify that user cannot give letters for the "Free International Minutes" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free International Minutes
        WebElement International_minutes= driver.findElement(By.id("inter_minutes"));
        International_minutes.sendKeys("ftgf");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message4']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_012(){ // Verify that user cannot keep "Free International Minutes" field empty

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free International Minutes
        WebElement International_minutes= driver.findElement(By.id("inter_minutes"));
        International_minutes.sendKeys("500");
        International_minutes.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message4']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_013(){ // Verify that user cannot give special characters for the "Free SMS Pack" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free SMS Pack
        WebElement sms = driver.findElement(By.id("sms_pack"));
        sms.sendKeys("@#50");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message5']"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_014(){ // Verify that user cannot give letters for the "Free SMS Pack" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free SMS Pack
        WebElement sms = driver.findElement(By.id("sms_pack"));
        sms.sendKeys("abcd");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message5']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_015(){ // Verify that user cannot keep "Free SMS Pack" field empty

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Free SMS Pack
        WebElement sms = driver.findElement(By.id("sms_pack"));
        sms.sendKeys("50");
        sms.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message5']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_016(){ // Verify that user cannot give special characters for the "Local Per Minutes Charges" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Local Per Minutes Charges
        WebElement minutes_charges1 = driver.findElement(By.id("minutes_charges"));
        minutes_charges1.sendKeys("@#$");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message6']"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_017(){ // Verify that user cannot give letters for the "Local Per Minutes Charges" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Local Per Minutes Charges
        WebElement minutes_charges1 = driver.findElement(By.id("minutes_charges"));
        minutes_charges1.sendKeys("abc");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message6']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_018(){ // Verify that user cannot keep "Local Per Minutes Charges" field empty

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Local Per Minutes Charges
        WebElement minutes_charges1 = driver.findElement(By.id("minutes_charges"));
        minutes_charges1.sendKeys("50");
        minutes_charges1.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message6']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_019(){ // Verify that user cannot give special characters for the "International Per Minutes Charges" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // International Per Minutes Charges
        WebElement minutes_charges2 = driver.findElement(By.id("inter_charges"));
        minutes_charges2.sendKeys("@#");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message7']"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_020(){ // Verify that user cannot give letters for the "International Per Minutes Charges" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // International Per Minutes Charges
        WebElement minutes_charges2 = driver.findElement(By.id("inter_charges"));
        minutes_charges2.sendKeys("abcd");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message7']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_021(){ // Verify that user cannot keep "International Per Minutes Charges" field empty

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // International Per Minutes Charges
        WebElement minutes_charges2 = driver.findElement(By.id("inter_charges"));
        minutes_charges2.sendKeys("50");
        minutes_charges2.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message7']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_022(){ // Verify that user cannot give special characters for the "SMS Per Charges" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // SMS Per Charges
        WebElement sms_charges = driver.findElement(By.id("sms_charges"));
        sms_charges.sendKeys("***");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message8']"));

        // Validate the error message
        String expectedMessage = "Special characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_023(){ // Verify that user cannot give letters for the "SMS Per Charges" field

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // SMS Per Charges
        WebElement sms_charges = driver.findElement(By.id("sms_charges"));
        sms_charges.sendKeys("abcde");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message8']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_024(){ // Verify that user cannot keep "SMS Per Charges" field empty

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // SMS Per Charges
        WebElement sms_charges = driver.findElement(By.id("sms_charges"));
        sms_charges.sendKeys("2");
        sms_charges.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message8']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_025(){ // Verify that user can reset the form after filling  all the fields in the form

        // Navigate to Add Tariff Plan
        driver.get("https://demo.guru99.com/telecom/addtariffplans.php");

        // Monthly Rental
        WebElement monthlyRental = driver.findElement(By.cssSelector("#rental1"));
        monthlyRental.sendKeys("1200");

        // Free Local Minutes
        WebElement Local_minutes = driver.findElement(By.id("local_minutes"));
        Local_minutes.sendKeys("500");

        //Free International Minutes
        WebElement International_minutes= driver.findElement(By.id("inter_minutes"));
        International_minutes.sendKeys("100");

        // Free SMS Pack
        WebElement sms = driver.findElement(By.id("sms_pack"));
        sms.sendKeys("50");

        // Local Per Minutes Charges
        WebElement minutes_charges1 = driver.findElement(By.id("minutes_charges"));
        minutes_charges1.sendKeys("1");

        // International Per Minutes Charges
        WebElement minutes_charges2 = driver.findElement(By.id("inter_charges"));
        minutes_charges2.sendKeys("2");

        // SMS Per Charges
        WebElement sms_charges = driver.findElement(By.id("sms_charges"));
        sms_charges.sendKeys("2");

        // Click Reset Button
        WebElement resetBtn = driver.findElement(By.xpath("//input[@value='Reset']"));
        resetBtn.click();

    }

    @Test
    public void close(){
        // Close Browser
        this.driver.quit();
    }


}
