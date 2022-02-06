package com.demoblaze.adidasPages;

import com.demoblaze.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePageForAdidas {
    public BasePageForAdidas(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//li/a)[1]")
    public WebElement homeLink;


    @FindBy(xpath = "(//li/a)[4]")
    public WebElement cartPage;

    public void navigateTo(String str){
        Driver.getDriver().findElement(By.xpath("//a[contains(.,'" + str + "')]")).click();
    }
}
