package com.qizi.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.po.page.*;

public class register {

    static WebDriver webDriver;


   @BeforeMethod
    public static void openBrowser() throws InterruptedException {
         SeleniumDriver.initDriver("chrome");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public static void registerCase() throws InterruptedException {


        webDriver.findElement(By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]")).click();
        Thread.sleep(3000);
        String handle = webDriver.getWindowHandle();
        for (String handles : webDriver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }
            webDriver.switchTo().window(handles);

        }
        System.out.println(webDriver.getCurrentUrl());
        String title = webDriver.findElement(By.xpath("//div[@class='title']/h2")).getText();
        System.out.println(title);
        Assert.assertEquals(title, "欢迎注册网易邮箱");
        String s = String.valueOf(System.currentTimeMillis()); //获取每次注册唯一的用户名
        //        System.out.println(s);
        //        String s2 = (String) String.valueOf(System.currentTimeMillis() / 100); //获取每次唯一手机号码
        //        System.out.println(s2);
        webDriver.findElement(By.id("username")).sendKeys("email" + s);
        webDriver.findElement(By.id("password")).sendKeys("4663050qqa");
        webDriver.findElement(By.id("phone")).sendKeys("1342637940323");
        Thread.sleep(2000);
        //webDriver.findElement(By.xpath("//input[@type='checkbox' and @id='service']")).click();
        // Thread.sleep(3000);
        webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[4]")).click();
        // String text=webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]")).getText();
        String text = webDriver.findElement(By.xpath("//*[@class='phone-desc f-dn']")).getText();
        System.out.println(text);


    }

    @Test
    public static void registerCaseWithPO() throws InterruptedException {


        webDriver.findElement(RegisterPage.registerButton).click();
        Thread.sleep(3000);
        String handle = webDriver.getWindowHandle();
        for (String handles : webDriver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }
            webDriver.switchTo().window(handles);

        }
        System.out.println(webDriver.getCurrentUrl());
        String title = webDriver.findElement(RegisterPage.titleInput).getText();
        System.out.println(title);
        Assert.assertEquals(title, "欢迎注册网易邮箱");
        String s = String.valueOf(System.currentTimeMillis()); //获取每次注册唯一的用户名
        //        System.out.println(s);
        //        String s2 = (String) String.valueOf(System.currentTimeMillis() / 100); //获取每次唯一手机号码
        //        System.out.println(s2);
        webDriver.findElement(RegisterPage.usernameInput).sendKeys("email" + s);
        webDriver.findElement(RegisterPage.paswwordInput).sendKeys("4663050qqa");
        webDriver.findElement(RegisterPage.phoneInput).sendKeys("1342637940323");
        Thread.sleep(2000);
        //webDriver.findElement(By.xpath("//input[@type='checkbox' and @id='service']")).click();
        // Thread.sleep(3000);
        webDriver.findElement(RegisterPage.buttonForregister).click();
        // String text=webDriver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[3]/div[2]")).getText();
        String text = webDriver.findElement(RegisterPage.messgeForWrongphone).getText();
        System.out.println(text);


    }


    @Test
    public static void loginSucess() throws InterruptedException {
        // webDriver.switchTo().frame(0);
        // webDriver.findElement(By.name("email")).sendKeys("wzjg13002");
        //webDriver.findElement(By.name("password")).sendKeys("wzj4663050");

        //webDriver.findElement(By.id("dologin")).click();
        //loginpo("wzjg13002", "wzj4663050");
        loginPO("wzjg13002", "wzj4663050");
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(webDriver, 3000);
        String text = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("spnUid"))).getText();
        //String text= webDriver.findElement(By.id("spnUid")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "wzjg13002@163.com");
        webDriver.findElement(By.id("spnUid")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("_mail_component_72_72"))).click();
    }

    @Test
    public static void loginError() throws InterruptedException {
        // webDriver.switchTo().frame(0);
        //        webDriver.findElement(By.name("email")).sendKeys("wzjg13002");
        //       webDriver.findElement(By.name("password")).sendKeys("123456");

        //webDriver.findElement(By.id("dologin")).click();
        loginPO("wzjg13002", "123456");
        Thread.sleep(3000);
        String text = webDriver.findElement(By.xpath("//*[@id='nerror']/div[2]")).getText();
        System.out.println(text);
        Assert.assertEquals(text, "帐号或密码错误");


    }


    public static void login(String email, String password) {
        webDriver.switchTo().frame(0);
        webDriver.findElement(By.name("email")).sendKeys(email);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.id("dologin")).click();
    }
    public static void loginPO(String email, String password) {
        webDriver.switchTo().frame(0);
        webDriver.findElement(emailLoginPage1.emailInput).sendKeys(email);
        webDriver.findElement(emailLoginPage1.passwordInput).sendKeys(password);
        webDriver.findElement(emailLoginPage1.loginBUtton).click();
    }


    public static void registerCase(String userName, String password, String phoneNumber) throws InterruptedException {


        webDriver.findElement(RegisterPage.registerButton).click();
        Thread.sleep(3000);
        String handle = webDriver.getWindowHandle();
        for (String handles : webDriver.getWindowHandles()) {
            if (handles.equals(handle)) {
                continue;
            }
            webDriver.switchTo().window(handles);

        }
        System.out.println(webDriver.getCurrentUrl());
        String title = webDriver.findElement(RegisterPage.titleInput).getText();
        System.out.println(title);
        Assert.assertEquals(title, "欢迎注册网易邮箱");
        String s = String.valueOf(System.currentTimeMillis());

        webDriver.findElement(RegisterPage.usernameInput).sendKeys(userName);
        webDriver.findElement(RegisterPage.paswwordInput).sendKeys(password);
        webDriver.findElement(RegisterPage.phoneInput).sendKeys(phoneNumber);
        Thread.sleep(2000);

        webDriver.findElement(RegisterPage.buttonForregister).click();

        String text = webDriver.findElement(RegisterPage.messgeForWrongphone).getText();
        System.out.println(text);


    }
@Test
public static void testOpen() throws InterruptedException {
        openBrowser1("https://www.baidu.com");
}
public static void openBrowser1(String url) throws InterruptedException {
    SeleniumDriver.initDriver("chrome");
    webDriver = new ChromeDriver();
    webDriver.get(url);
    webDriver.manage().window().maximize();
    Thread.sleep(3000);
}

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
    public static  void closeBrowserAll() {
        webDriver.quit();
    }
}
