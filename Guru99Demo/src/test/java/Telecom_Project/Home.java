package Telecom_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Home {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/");

    }

    @Test
    public void TC_001(){ // Verify that user can login to the system with giving proper email

        //Locate email field
        WebElement email = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"));
        email.sendKeys("nimesha@gmail.com");

        // Click on Submit button
        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input"));
        submitButton.click();

        // Verify login success
        String expectedTitle = "Guru99 Bank Home Page";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Access Denied!");
    }

    @Test
    public void TC_002(){ //Verify that user cannot login to the system with invalid email

        //Locate email field
        WebElement email = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"));
        email.sendKeys("123");

        // Click on Submit button
        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input"));
        submitButton.click();

        //Error Message
        String ExpectedErrorMessage = "Email ID is not valid";
        String ActualTest = driver.findElement(By.cssSelector("#message9")).getText();
        Assert.assertEquals(ActualTest, ExpectedErrorMessage, "Missing error message when email is invalid");

    }

    @Test
    public void TC_003(){ //Verify that user cannot login to the system with empty email

        //Locate email field
        WebElement email = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input"));
        email.sendKeys("");

        // Click on Submit button
        WebElement submitButton = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input"));
        submitButton.click();

        //Error Message
        String ExpectedErrorMessage = "Email ID must not be blank";
        String ActualTest = driver.findElement(By.cssSelector("#message9")).getText();
        Assert.assertEquals(ActualTest, ExpectedErrorMessage, "Missing error message when email is invalid");

    }

    @Test
    public void TC_004(){ //Verify that user can navigate to the telecom project page

        driver.get("https://demo.guru99.com/telecom/index.html");
        String expectedUrl = "https://demo.guru99.com/telecom/index.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL does not match!");

    }

    @AfterMethod
    public void close() {
        // Close the browser
        driver.quit();
    }


}



