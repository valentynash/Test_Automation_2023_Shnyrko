package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.BaseChromeTest;
import java.time.Duration;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exercise1Test extends BaseChromeTest {

    public SoftAssertions softly = new SoftAssertions();
    private static final int ITEMS_IN_HEADER = 4;
    private static final int NUMBER_OF_IMAGES = 4;
    private static final int NUMBER_OF_ITEMS_IN_LEFT_SIDE_BAR = 5;

    @Test(groups = {"HW2"})
    public void exercise1() {

        softly.assertThat(driver.getTitle()).as("Browser title is incorrect").isEqualTo("Home Page");

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.uui-profile-menu"))).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        /* Assert Username is loggined.*/
        softly.assertThat(driver.findElement(By.id("user-name")).getText()).as("Roman Iovlev is not logged")
                .isEqualTo("ROMAN IOVLEV");

        /* Assert that there are 4 items on the header section are displayed and they have proper texts. */
        List<WebElement> items = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8>li"));
        softly.assertThat(items.size() == ITEMS_IN_HEADER).as("Incorrect number of items").isTrue();

        for (int i = 0; i < items.size(); i++) {
            softly.assertThat(items.get(i).isDisplayed()).as("Element is not displayed");
        }
        List<String> expectedHeaderItems = List.of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        for (int i = 0; i < items.size(); i++) {
            softly.assertThat(items.get(i).getText()).as("Text is incorrect").isEqualTo(expectedHeaderItems
                    .get(i));
        }

        /* Assert that there are 4 images on the Index Page and they are displayed.*/
        List<WebElement> icons = driver.findElements(By.className("benefit-icon"));
        softly.assertThat(icons.size() == NUMBER_OF_IMAGES).as("Incorrect number of images")
                .isTrue();
        for (int i = 0; i < icons.size(); i++) {
            softly.assertThat(items.get(i).isDisplayed()).as("Image is displayed");
        }

        /* Assert that there are 4 texts on the Index Page under icons and they have proper text. */
        List<String> listOfTextUnderImages = List.of("To include good practices\n"
                + "and ideas from successful\n" + "EPAM project", "To be flexible and\n"
                + "customizable", "To be multiplatform", "Already have good base\n"
                + "(about 20 internal and\n" + "some external projects),\n" + "wish to get more…");
        List<WebElement> textElementsUnderImages = driver.findElements(By.className("benefit-txt"));

        for (int i = 0; i < textElementsUnderImages.size(); i++) {
            softly.assertThat(textElementsUnderImages.get(i).getText()).as("Text is incorrect")
                    .isEqualTo(listOfTextUnderImages.get(i));
        }

        for (int i = 0; i < textElementsUnderImages.size(); i++) {
            softly.assertThat(textElementsUnderImages.get(i).isDisplayed()).as("Text is not displayed");
        }

        /* Assert that there is the iframe with “Frame Button” exist. */
        driver.findElement(By.id("frame"));
        softly.assertThat(driver.findElement(By.id("frame")).isDisplayed()).as("There is no button");

        /* Switch to the iframe and check that there is “Frame Button” in the iframe. */
        driver.switchTo().frame("frame");
        softly.assertThat(driver.findElement(By.id("frame-button")).isDisplayed()).as("There is no button "
                + "in the frame");

        /* Switch to original window back. */
        driver.switchTo().defaultContent();

        /* Assert that there are 5 items in the Left Section are displayed and they have proper text. */
        List<String> textOfItemsLeftSideBar = List.of("Home", "Contact form", "Service", "Metals & Colors",
                "Elements packs");
        List<WebElement> listOfItemsElementsLeftSideBar = driver.findElements(By.cssSelector(".sidebar-menu>li"));
        softly.assertThat(listOfItemsElementsLeftSideBar.size() == NUMBER_OF_ITEMS_IN_LEFT_SIDE_BAR)
                .as("Wrong number of items in the left side bar")
                .isTrue();
        for (int i = 0; i < listOfItemsElementsLeftSideBar.size(); i++) {
            softly.assertThat(listOfItemsElementsLeftSideBar.get(i).isDisplayed()).as("Item is not displayed "
                    + "in the left side bar");
        }
        for (int i = 0; i < textOfItemsLeftSideBar.size(); i++) {
            softly.assertThat(listOfItemsElementsLeftSideBar.get(i).getText()).as("Text is incorrect")
                    .isEqualTo(textOfItemsLeftSideBar.get(i));
        }

        softly.assertAll();
    }
}
