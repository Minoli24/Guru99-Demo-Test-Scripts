package Telecom_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PayBilling {

    WebDriver driver;

    @BeforeMethod
    public void Setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/telecom/index.html");

    }
    @Test
    public void TC_001(){ // Verify that user can navigate to the pay billing page
        driver.get("https://demo.guru99.com/telecom/billing.php");

    }

    @Test
    public void TC_002(){ // Verify that user can get the billing details after giving valid customer ID
        // Naviage to Pay Billing
        driver.get("https://demo.guru99.com/telecom/billing.php");

        // Locate Customer ID
        WebElement cusID = driver.findElement(By.xpath("//input[@id='customer_id']"));
        cusID.sendKeys("171741");

        // Click on Submit Button
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();

    }

    @Test
    public void TC_003(){ // Verify that user cannot give  ID with invalid characters to "customer ID" field

        // Naviage to Pay Billing
        driver.get("https://demo.guru99.com/telecom/billing.php");

        // Locate Customer ID
        WebElement cusID = driver.findElement(By.xpath("//input[@id='customer_id']"));
        cusID.sendKeys("mf171742");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message2']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_004(){ // Verify that user cannot give invalid ID to  "customer ID" field

        // Naviage to Pay Billing
        driver.get("https://demo.guru99.com/telecom/billing.php");

        // Locate Customer ID
        WebElement cusID = driver.findElement(By.xpath("//input[@id='customer_id']"));
        cusID.sendKeys("1717");

        // Click on Submit Button
        WebElement submit = driver.findElement(By.xpath("//input[@name='submit']"));
        submit.click();

    }

    @Test
    public void TC_005(){ // Verify that user cannot keep "customer ID" field empty

        // Naviage to Pay Billing
        driver.get("https://demo.guru99.com/telecom/billing.php");

        // Locate Customer ID
        WebElement cusID = driver.findElement(By.xpath("//input[@id='customer_id']"));
        cusID.sendKeys("1717");
        cusID.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message2']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void close(){
        // Close Browser
        this.driver.quit();
    }

}



