package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {
    WebDriver driver;
    public CheckOut(WebDriver driver) {
        this.driver = driver;
    }
        public void checkout()throws InterruptedException{
            //Verify page
            driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[6]/a")).click();
            Thread.sleep(2000);
            driver.close();
        }
        public void final_checkout(){

        }
    }

