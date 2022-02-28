package com.example.justparktask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ParkingTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/marcus/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.justpark.com");

        HomePage home = new HomePage(driver);
        ParkingPage parking = new ParkingPage(driver);

        //  Navigate from the home page to the find parking page
        home.enterLocation();
        home.changeFromDate();
        home.showParking();

        //  Wait for parking page to load before beginning parking page methods
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //  Start by verifying that the modal element is not present, change the date to >28 days, re-search
        parking.verifyModal();
        parking.openDateTo();
        parking.search();

        //  Wait for enough time so the modal shows, verify the element is present
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        parking.verifyModal();

        //  Close the modal
        parking.closeModal();


        //  Run the search again with the >28 day duration
        parking.search();

        //  Verify that on the 2nd search, the modal does not show
        parking.verifyModal();

        driver.quit();

    }

}
