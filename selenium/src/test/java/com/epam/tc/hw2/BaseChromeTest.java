package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseChromeTest {

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}
