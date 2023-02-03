package Tests;
import Pages.CheckOut;
import Pages.LoginPage;
import Pages.AddToCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseTest{

    WebDriver driver;

    LoginPage objLogin;
    AddToCartPage objCart;

    CheckOut objCheckout;
    //HomePage objHomePage;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://shop.demoqa.com/shop/");
        driver.manage().window().maximize();
        driver.findElement(By.className("woocommerce-store-notice__dismiss-link")).click();
    }
    @DataProvider(name="LoginData")
    public Object[][] getData() {
        String loginData[][] = {{"Rosina", "7777Love#2", "valid"},
                {"Rosina", "Love7777#2", "invalid"}};
        return loginData;
        //String path = ".\\datafiles\\loginData.xlsx";
    }
        /*XLUtility xlutil=new XLUtility(path);

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalrows][totalcols];


        for(int i=1;i<=totalrows;i++) //1
        {
            for(int j=0;j<totalcols;j++) //0
            {
                loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
            }

        }

        return loginData;
    }*/

    @org.testng.annotations.Test(priority = 1,dataProvider = "LoginData")
    public void Login(String user, String password,String result) throws InterruptedException {
        objLogin = new LoginPage(driver);
        String loginPageTitle = objLogin.getLoginTitle();
        String Expected_title = "ToolsQA Demo Site";
        //Assert.assertEquals(Expected_title,loginPageTitle);
        //Verify data from excel is correct
        objLogin.loginToSite("Rosina", "7777Love#2");
        if(result.equals(("valid"))){
            Assert.assertTrue(true);
        }


    }
    @org.testng.annotations.Test(priority = 0)
    public void failedLogin(){
        objLogin = new LoginPage(driver);
        objLogin.loginToSite("Rosina", "777Love#2");
        //Verify error message
        //expected error text
        String exp = "ERROR: The username or password you entered is incorrect. Lost your password?";
        //identify actual error message
        WebElement m = driver.findElement(By.className("woocommerce-error"));
        String act = m.getText();
        //verify error message with Assertion
        //Assert.assertEquals(exp, act);


    }

    @org.testng.annotations.Test(priority = 2)
    public void cartTest()throws  InterruptedException{
        objCart = new AddToCartPage(driver);
        objCheckout = new CheckOut(driver);
        objCart.clickCart();
        objCart.clickReturn();
        objCart.selectItem();
        objCheckout.checkout();
    }
    @Test(priority = 3)
    public void second_login() throws InterruptedException {
        BaseTest base = new BaseTest();
        base.Login("Rosina","7777Love#2","valid");
        objCart.selectSecondItem();

    }

    /*@AfterClass
    public void teardown(){
        driver.close();
    }*/
}