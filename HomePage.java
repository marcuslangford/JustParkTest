package com.example.justparktask;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    //  Find the elements I will to interact with on this page
    By LocationSearch = By.id("search-box");
    By DateFrom = new By.ByClassName("c-booking-date__native-input--from");
    By SearchSubmit = new By.ByClassName("c-searchform__submit");
    By CloseDatePicker = new By.ByClassName("c-datepicker__close-bt");

    public void enterLocation() throws InterruptedException {
        //  As per the task instructions, London is the location we are using
        driver.findElement(LocationSearch).click();
        driver.findElement(LocationSearch).sendKeys("London,UK");

        //  Wait for the autocomplete drop-down to appear, send ENTER to pick the first option
        //  Using Thread.sleep as I couldn't get this working with an implicit or explicit wait
        Thread.sleep(3000);
        driver.findElement(LocationSearch).sendKeys(Keys.ENTER);

    }

    public void changeFromDate() throws InterruptedException {
        //  Open the date picker
        driver.findElement(DateFrom).click();

        //  Since the initial search is just any short term,
        //  we can use the default dates when you close the picker(Today -> Today + 2 hours)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(CloseDatePicker).click();
    }

    public void showParking() throws InterruptedException {
        //  Click the button to move to the parking results
        Thread.sleep(2000);
        driver.findElement(SearchSubmit).click();


    }

}
