package com.example.justparktask;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class ParkingPage {
    WebDriver driver;

    //  Constructor that will be automatically called as soon as the object of the class is created
    public ParkingPage(WebDriver driver) {
        this.driver = driver;
    }
    
    //  Find the elements I will to interact with on this page
    By DatePickTo = new By.ByClassName("c-booking-date__native-input--to");
    By SearchBtn = new By.ByClassName("c-searchform__submit");
    By MonthChevronRight = new By.ByClassName("c-chevron-icon--right");
    By DateCloseBtn = new By.ByClassName("c-datepicker__close-bt");
    By ModalCloseBtn = new By.ByClassName("c-button__text");
    By DateSelector = new By.ByXPath("//*[@id=\"content\"]/div/div[2]/main/div[2]/form/div[4]/div/div/div[1]/div/div/div/div/div/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[5]/td[5]");

    public void openDateTo() throws InterruptedException {

        //  Click to open the date picker
        driver.findElement(DatePickTo).click();

        //  Switch to next month in the date picker
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MonthChevronRight).click();


        //  Select a day at least 28 days from start date
        Thread.sleep(3000);
        driver.findElement(DateSelector).click();

        //  Close date picker with 'done' button
        driver.findElement(DateCloseBtn).click();

    }

    public void search(){

        //  Search with new dates
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(SearchBtn).click();

    }

    public void verifyModal(){

        //  Verify that the modal element is present and displayed.
        try{
            Boolean Display = driver.findElement(By.className("c-monthlyUpgradeModal")).isDisplayed();
            System.out.println("Modal is Present");
        }catch (NoSuchElementException e){
            System.out.println("Modal is not Present");
        }

    }

    public void closeModal() {

        //  Close the modal using the 'use my current dates button'
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(ModalCloseBtn).click();

    }
}
