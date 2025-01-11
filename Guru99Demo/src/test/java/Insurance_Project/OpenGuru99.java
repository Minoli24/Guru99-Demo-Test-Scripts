package Insurance_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenGuru99 {
    @Test

    public void guru99Test() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/");
        driver.quit();

    }
}
