package com.demoblaze.adidasPages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePageForAdidas{
    int expectedBill = 0 ;

    @FindBy(linkText = "Add to cart")
    public WebElement addToCart;


       public void navigateTo(String category, String item){
        Driver.getDriver().findElement(By.linkText(category)).click();
        Driver.getDriver().findElement(By.linkText(item)).click();
    }


    public void addToCart(){
        expectedBill += billCalculator();
        addToCart.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }



    public void deleteItem(String itemName){
           WebElement deleteLink = Driver.getDriver().findElement(By.xpath("(//*[.='" + itemName + "'])/../td[4]/a"));
           int itemPrice = Integer.parseInt(Driver.getDriver().findElement(By.xpath("(//*[.='" + itemName +"'])/../td[3]")).getText());
           expectedBill -= itemPrice;
           deleteLink.click();
           BrowserUtils.waitFor(2);
    }

    public int getActualPrice(){
        String cheque = Driver.getDriver().findElement(By.xpath("//p[@style='display: block;']")).getText();
        String price = cheque.substring(cheque.indexOf("t:") + 2, cheque.indexOf("USD"));
        return Integer.parseInt(price.trim());
    }


    public void verifyPrice(int expectedPrice, int actualPrice){
        Assert.assertEquals("Price has failed to verify", expectedPrice, actualPrice);
    }

    public int billCalculator(){
        String priceText = Driver.getDriver().findElement(By.xpath("//*[@id='tbodyid']/h3")).getText();
        String priceInString = "";
        for (int i = 0; i < priceText.length(); i ++ ){
            if (Character.isDigit(priceText.charAt(i))){
                priceInString += priceText.charAt(i);
            }
        }
        return  Integer.parseInt(priceInString);
    }

    public int getExpectedBill(){
        return expectedBill;
    }

}
