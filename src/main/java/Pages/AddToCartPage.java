package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.openqa.selenium.By.xpath;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AddToCartPage {
    WebDriver driver;
    public AddToCartPage(WebDriver driver){
        this.driver = driver;

    }
    public void clickCart(){
        driver.findElement(By.className("icon_bag_alt")).click();
    }
    public void clickReturn(){
        driver.findElement(xpath("/html/body/div[1]/div[2]/main/article/div/div/p[2]/a")).click();
    }
    public String getCartTitle(){
        String storeTitle = driver.getTitle();
        return storeTitle;

    }
    public void selectSecondItem()throws InterruptedException{
        clickCart();
        //Scroll down the page
        Actions at = new Actions(driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
        //Navigate to the third page

        driver.findElement(By.className("continue shopping")).click();
        //Verify that item is selected by page title
        String Actual_title = driver.getTitle();
        String Expected_title = "Products &#8211; ToolsQA Demo Site";
        Assert.assertEquals(Expected_title,Actual_title);
        driver.findElement(xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/nav/ul/li[4]/span")).click();
        String Actual_title1 = driver.getTitle();
        String Expected_title1 = "Products &#8211; Page 3 &#8211; ToolsQA Demo Site";
        driver.findElement(xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div/div/h3/a")).click();
        Select color = new Select(driver.findElement(By.id("pa_color"))); // Select color dropdown
        color.selectByVisibleText("Yellow");
        Thread.sleep(2000);
        Select size = new Select(driver.findElement(By.id("pa_size")));
        size.selectByVisibleText("Large");
        Thread.sleep(2000);
        driver.findElement(xpath("single_add_to_cart_button button alt wp-element-button")).click();
        Thread.sleep(2000);
        driver.findElement(xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")).click();
        Thread.sleep(2000);

    }
    public void selectItem()throws InterruptedException{
        driver.findElement(By.className("noo-product-thumbnail")).click();
        //Verify that item is selected by page title
        String Expected_title = "Black Cross Back Maxi Dress &#8211; ToolsQA Demo Site";
        String actualTitle = driver.getTitle();
        String expectedTitle = "Title of Page";
        //Assert.assertEquals(expectedTitle,actualTitle);
        //Verify selected item
        Select color = new Select(driver.findElement(xpath("//*[@id=\"pa_color\"]"))); // Select color dropdown
        color.selectByVisibleText("Beige");
        Thread.sleep(2000);
        Select size = new Select(driver.findElement(By.id("pa_size")));
        size.selectByVisibleText("Small");
        Thread.sleep(2000);
        driver.findElement(xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")).click();
        //Verify item selected
        Thread.sleep(2000);
        //Go to My Account
        driver.findElement(xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click();



    }

}
