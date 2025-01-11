package Insurance_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RetrieveQuotation {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/");
    }

    @Test
    public void Login(){

        // Navigate to Login Page
        driver.get("https://demo.guru99.com/insurance/v1/index.php");

        // 1) Email
        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("minolirashmitha228@gmail.com");

        // 2) Password
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("200055");

        // 3) Login Button
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

    }

    @Test
    public void NavigateToRetrieveQuotation(){

        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-3");
        String expectedUrl = "https://demo.guru99.com/insurance/v1/header.php#tabs-3";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Page URL does not match!");
    }

    @Test
    public void RetrieveQuotation(){

        // Navigate Retrieve Quotation
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-3");

        // Locate Identification Number
        WebElement id = driver.findElement(By.xpath("//*[@id=\"tabs-3\"]/form/input[1]"));
        id.sendKeys("42596");

        // Click on Retrieve Button
        WebElement retrieveBtn = driver.findElement(By.xpath("//*[@id=\"tabs-3\"]/form/input[1]"));
        retrieveBtn.click();

        // Get Identification number
        driver.get("https://demo.guru99.com/insurance/v1/new_quotation.php");
        String expectedUrl = "https://demo.guru99.com/insurance/v1/new_quotation.php";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Page URL does not match!");

    }

    @AfterMethod
    public void close() {
        // Close the browser
        driver.quit();
    }


}
