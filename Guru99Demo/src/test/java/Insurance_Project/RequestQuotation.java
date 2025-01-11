package Insurance_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RequestQuotation {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Setup WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/insurance/v1/index.php");
    }

    @Test
    public void NavigateRequestQuotation() {
        // Valid login
        // 1) Email
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("minolirashmitha228@gmail.com");

        // 2) Password
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("200055");

        // 3) Click Login Button
        WebElement loginButton = driver.findElement(By.name("submit"));
        loginButton.click();

        //4) Navigate RequestQuotation
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-2");

    }


    @Test
    public void fillQuotationForm() {

        // Navigate RequestQuotation
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-2");

        // Select Breakdown Cover
        Select breakdownCoverSelect = new Select(driver.findElement(By.xpath("//*[@id=\"quotation_breakdowncover\"]")));
        breakdownCoverSelect.selectByVisibleText("Roadside");

        // Select Windscreen Repair
        WebElement windscreenRepairYes = driver.findElement(By.id("quotation_windscreenrepair_t"));
        windscreenRepairYes.click();

        // Enter Incidents
        WebElement incidents = driver.findElement(By.id("quotation_incidents"));
        incidents.sendKeys("Minor accident in 2021");

        // Enter Registration
        WebElement registration = driver.findElement(By.id("quotation_vehicle_attributes_registration"));
        registration.sendKeys("AB123CD");

        // Enter Annual Mileage
        WebElement annualMileage = driver.findElement(By.name("mileage"));
        annualMileage.sendKeys("15000");

        // Enter Estimated Value
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("20000");

        // Select Parking Location
        Select parkingLocationSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")));
        parkingLocationSelect.selectByVisibleText("Public Place");

        // Select Start of Policy
        Select startYearSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")));
        startYearSelect.selectByValue("2014");

        Select startMonthSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")));
        startMonthSelect.selectByVisibleText("February");

        Select startDaySelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")));
        startDaySelect.selectByIndex(7);

    }

    @Test
    public void saveQuotationForm(){
        // Navigate RequestQuotation
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-2");

        // Select Breakdown Cover
        Select breakdownCoverSelect = new Select(driver.findElement(By.xpath("//*[@id=\"quotation_breakdowncover\"]")));
        breakdownCoverSelect.selectByVisibleText("");

        // Select Windscreen Repair
        WebElement windscreenRepairYes = driver.findElement(By.id("quotation_windscreenrepair_t"));
        windscreenRepairYes.click();

        // Enter Incidents
        WebElement incidents = driver.findElement(By.id("quotation_incidents"));
        incidents.sendKeys("21");

        // Enter Registration
        WebElement registration = driver.findElement(By.id("quotation_vehicle_attributes_registration"));
        registration.sendKeys("AB123CD");

        // Enter Annual Mileage
        WebElement annualMileage = driver.findElement(By.name("mileage"));
        annualMileage.sendKeys("15000");

        // Enter Estimated Value
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("20000");

        // Select Parking Location
        Select parkingLocationSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")));
        parkingLocationSelect.selectByVisibleText("Public Place");

        // Select Start of Policy
        Select startYearSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")));
        startYearSelect.selectByValue("2014");

        Select startMonthSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")));
        startMonthSelect.selectByVisibleText("February");

        Select startDaySelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")));
        startDaySelect.selectByIndex(7);

        // Click Save Quotation Button
        WebElement saveQuotation = driver.findElement(By.xpath("//*[@id=\"new_quotation\"]/div[8]/input[3]"));
        saveQuotation.click();

        // Navigate to success page
        driver.get("https://demo.guru99.com/insurance/v1/new_quotation.php");

    }

    @Test
    public void calculatePremium(){

        // Navigate RequestQuotation
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-2");

        // Select Breakdown Cover
        Select breakdownCoverSelect = new Select(driver.findElement(By.xpath("//*[@id=\"quotation_breakdowncover\"]")));
        breakdownCoverSelect.selectByVisibleText("");

        // Select Windscreen Repair
        WebElement windscreenRepairYes = driver.findElement(By.id("quotation_windscreenrepair_t"));
        windscreenRepairYes.click();

        // Enter Incidents
        WebElement incidents = driver.findElement(By.id("quotation_incidents"));
        incidents.sendKeys("21");

        // Enter Registration
        WebElement registration = driver.findElement(By.id("quotation_vehicle_attributes_registration"));
        registration.sendKeys("AB123CD");

        // Enter Annual Mileage
        WebElement annualMileage = driver.findElement(By.name("mileage"));
        annualMileage.sendKeys("15000");

        // Enter Estimated Value
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("20000");

        // Select Parking Location
        Select parkingLocationSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")));
        parkingLocationSelect.selectByVisibleText("Public Place");

        // Select Start of Policy
        Select startYearSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")));
        startYearSelect.selectByValue("2014");

        Select startMonthSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")));
        startMonthSelect.selectByVisibleText("February");

        Select startDaySelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")));
        startDaySelect.selectByIndex(7);

        // Click Calculate Premium
        WebElement calculatePremium = driver.findElement(By.xpath("//*[@id=\"new_quotation\"]/div[8]/input[1]"));
        calculatePremium.click();

        // Verify Premium Calculation
        String expectedMsg = "Successfully Calculated Premium";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Premium Calculated!!");

    }

    @Test
    public void InvalidMileage (){

        // Navigate Request Quotation
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-2");

        // Enter Annual Mileage
        WebElement annualMileage = driver.findElement(By.name("mileage"));
        annualMileage.sendKeys("CD");

        // Display Error message
        String expectedMsg = "Invalid Mileage";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Please fill with Valid Mileage!");

    }

    @Test
    public void invalidEstimatedValue(){

        // Navigate Request Quotation
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-2");

        // Enter Estimated Value
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("ASD");

        // Display Error message
        String expectedMsg = "Invalid Estimated Value";
        WebElement msg =  driver.findElement(By.xpath("//*[contains(text(),'" + expectedMsg + "')]"));
        boolean isMsg = msg.isDisplayed();
        Assert.assertTrue(isMsg,"Please fill with Valid Value!");

    }

    @Test
    public void resetForm() {

        // Navigate RequestQuotation
        driver.get("https://demo.guru99.com/insurance/v1/header.php#tabs-2");

        // Select Breakdown Cover
        Select breakdownCoverSelect = new Select(driver.findElement(By.xpath("//*[@id=\"quotation_breakdowncover\"]")));
        breakdownCoverSelect.selectByVisibleText("Roadside");

        // Select Windscreen Repair
        WebElement windscreenRepairYes = driver.findElement(By.id("quotation_windscreenrepair_t"));
        windscreenRepairYes.click();

        // Enter Incidents
        WebElement incidents = driver.findElement(By.id("quotation_incidents"));
        incidents.sendKeys("Minor accident in 2021");

        // Enter Registration
        WebElement registration = driver.findElement(By.id("quotation_vehicle_attributes_registration"));
        registration.sendKeys("AB123CD");

        // Enter Annual Mileage
        WebElement annualMileage = driver.findElement(By.name("mileage"));
        annualMileage.sendKeys("15000");

        // Enter Estimated Value
        WebElement estimatedValue = driver.findElement(By.id("quotation_vehicle_attributes_value"));
        estimatedValue.sendKeys("20000");

        // Select Parking Location
        Select parkingLocationSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_parkinglocation")));
        parkingLocationSelect.selectByVisibleText("Public Place");

        // Select Start of Policy
        Select startYearSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_1i")));
        startYearSelect.selectByValue("2014");

        Select startMonthSelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_2i")));
        startMonthSelect.selectByVisibleText("February");

        Select startDaySelect = new Select(driver.findElement(By.id("quotation_vehicle_attributes_policystart_3i")));
        startDaySelect.selectByIndex(7);

        // Click Reset Button
        WebElement resetButton = driver.findElement(By.xpath("//*[@id=\"resetquote\"]"));
        resetButton.click();

    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
