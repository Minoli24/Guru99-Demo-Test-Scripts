package Telecom_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddTariffPlanToCustomer {

    WebDriver driver;

    @BeforeMethod
    public void Setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/telecom/index.html");

    }

    @Test
    public void TC_001(){ // Verify that user can navigate to the Add tariff plan to customer page
        driver.get("https://demo.guru99.com/telecom/assigntariffplantocustomer.php");

    }

    @Test
    public void TC_002(){ // Verify that user can get the tariff plans after giving valid customer ID

        // Navigate to Add Tariff Plan To Customer
        driver.get("https://demo.guru99.com/telecom/assigntariffplantocustomer.php");

        // Locate Customer ID
        WebElement CusID = driver.findElement(By.cssSelector("#customer_id"));
        CusID.sendKeys("171741");

        // Click on "Submit" Button
        WebElement submitBtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitBtn.click();

    }

    @Test
    public void TC_003(){ // Verify that user cannot give invalid ID to "customer ID" field

        // Navigate to Add Tariff Plan To Customer
        driver.get("https://demo.guru99.com/telecom/assigntariffplantocustomer.php");

        // Locate Customer ID
        WebElement CusID = driver.findElement(By.cssSelector("#customer_id"));
        CusID.sendKeys("171745");

        // Click on "Submit" Button
        WebElement submitBtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitBtn.click();

    }

    @Test
    public void TC_004(){ // Verify that user cannot keep "customer ID" field empty

        // Navigate to Add Tariff Plan To Customer
        driver.get("https://demo.guru99.com/telecom/assigntariffplantocustomer.php");

        // Locate Customer ID
        WebElement CusID = driver.findElement(By.cssSelector("#customer_id"));
        CusID.sendKeys("171741");
        CusID.clear();

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message2']"));

        // Validate the error message
        String expectedMessage = "Number must not be blank";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_005(){ // Verify that user cannot enter invalid characters to "customer ID" field

        // Navigate to Add Tariff Plan To Customer
        driver.get("https://demo.guru99.com/telecom/assigntariffplantocustomer.php");

        // Locate Customer ID
        WebElement CusID = driver.findElement(By.cssSelector("#customer_id"));
        CusID.sendKeys("mngr602891");

        // Locate the validation message
        WebElement validationMessage = driver.findElement(By.xpath("//label[@id='message2']"));

        // Validate the error message
        String expectedMessage = "Characters are not allowed";
        String actualMessage = validationMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Validation message text does not match.");

    }

    @Test
    public void TC_006(){ // Verify that user can add tariff plan after selecting an approved plan

        // Navigate to Add Tariff Plan To Customer
        driver.get("https://demo.guru99.com/telecom/assigntariffplantocustomer.php");

        // Locate Customer ID
        WebElement CusID = driver.findElement(By.cssSelector("#customer_id"));
        CusID.sendKeys("171741");

        // Click on "Submit" Button
        WebElement submitBtn = driver.findElement(By.cssSelector("input[value='submit']"));
        submitBtn.click();

        // Click on "Add Tariff Plan"
        WebElement addTariffPlan = driver.findElement(By.xpath("//input[@name='submit']"));
        addTariffPlan.click();

    }

    @Test
    public void TC_007(){ // Verify that user cannot add tariff plan before selecting an approved plan


        // Navigate to Add Tariff Plan To Customer
        driver.get("https://demo.guru99.com/telecom/assigntariffplantocustomer.php");

        // Click on "Add Tariff Plan"
        WebElement addTariffPlan = driver.findElement(By.xpath("//input[@name='submit']"));
        addTariffPlan.click();

        // Error Message
        String expectedMsg = "Cannot Add Tariff Plan";
        WebElement msg = this.driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg, "Error message");

    }

    @Test
    public void close(){
        // Close Browser
        this.driver.quit();
    }
}
