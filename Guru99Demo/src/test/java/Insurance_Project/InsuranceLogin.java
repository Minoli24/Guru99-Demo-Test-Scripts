package Insurance_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InsuranceLogin {

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
        String expectedTitle = "Insurance Broker System - Login";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Page title does not match!");
    }

    @Test
    public void navigateInsuranceLogin() { // TC_002 - Verify navigation to "Insurance Project Login" page
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
        String expectedUrl = "https://demo.guru99.com/insurance/v1/index.php";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL does not match!");
    }

    @Test
    public void insuranceLogin() { // Valid login
        driver.get("https://demo.guru99.com/insurance/v1/index.php");

        // Enter Email
        driver.findElement(By.id("email")).sendKeys("minolirashmitha228@gmail.com");

        // Enter Password
        driver.findElement(By.id("password")).sendKeys("200055");

        // Click Login Button
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

        // Verify login success
        String expectedUrl = "https://demo.guru99.com/insurance/v1/header.php";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed!");
    }

    @Test
    public void insuranceInvalidLogin() { // Invalid login test
        driver.get("https://demo.guru99.com/insurance/v1/index.php");

        // Enter invalid email
        driver.findElement(By.id("email")).sendKeys("invalidEmail.com");

        // Enter invalid password
        driver.findElement(By.id("password")).sendKeys("wrongpassword");

        // Click Login Button
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

    }

    @Test
    public void verifyLogout() { // Verify logout functionality
        driver.get("https://demo.guru99.com/insurance/v1/index.php");

        // Login with valid credentials
        driver.findElement(By.id("email")).sendKeys("minolirashmitha228@gmail.com");
        driver.findElement(By.id("password")).sendKeys("200055");
        driver.findElement(By.name("submit")).click();

        // Verify successful login
        String expectedDashboardUrl = "https://demo.guru99.com/insurance/v1/header.php";
        Assert.assertEquals(driver.getCurrentUrl(), expectedDashboardUrl, "Login failed!");

        // Click Logout Button
        WebElement logoutButton = driver.findElement(By.xpath("//input[@value='Log out']"));
        logoutButton.click();

        // Verify successful logout by checking the URL
        String expectedLoginUrl = "https://demo.guru99.com/insurance/v1/index.php";
        Assert.assertEquals(driver.getCurrentUrl(), expectedLoginUrl, "Logout failed!");
    }

    @AfterMethod
    public void close() {
        // Close the browser
            driver.quit();
        }
    }

