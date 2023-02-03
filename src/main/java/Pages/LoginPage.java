package Pages;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import Pages.LoginPage;

import org.openqa.selenium.By;


public class LoginPage {

    WebDriver driver;

    By userName = By.id("username");

    By password = By.id("password");

    //By title =By.xpath("/html/head/title");

    By loginButton = By.name("login");

    public LoginPage(WebDriver driver){
        this.driver = driver;

    }
    public void clickMyAccount(){
        driver.findElement(By.linkText("My Account")).click();
    }

    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }


    public void setPassword(String strPassword){

        driver.findElement(password).sendKeys(strPassword);

    }

    //Click on login button

    public void clickButton(){

        driver.findElement(loginButton).click();

    }
    public String getLoginTitle(){
        String storeTitle = driver.getTitle();
        return storeTitle;

    }


    public void loginToSite(String strUserName,String strPassword){
        this.clickMyAccount();
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickButton();
    }

    public void failedLogin(String strUserName,String strPassword){
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickButton();
        driver.close();
    }

}