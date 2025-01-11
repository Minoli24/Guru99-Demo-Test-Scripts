package Insurance_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Profile {

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
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("minolirashmitha228@gmail.com");

        // 2) Password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("200055");

        // 3) Login Button
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

    }

    @Test
    public void NavigateToProfile(){

        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-4");
        String expectedUrl = "https://demo.guru99.com/insurance/v1/header.php#tabs-4";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Page URL does not match!");
    }

    @AfterMethod
    public void close() {
        // Close the browser
        driver.quit();
    }

}


