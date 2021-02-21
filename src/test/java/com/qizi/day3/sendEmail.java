package com.qizi.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.po.page.*;

public class sendEmail {
   static WebDriver webDriver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaProjects\\SeleniumDemo1701\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
    }


    public static void sendEmailPO(String sender,String title, String picture,String content) {
        register.login("wzjg13002", "wzj4663050");
        WebDriverWait wait = new WebDriverWait(webDriver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(sendEmailPage.writerButton)).click();
        webDriver.findElement(sendEmailPage.senderInput1).sendKeys("wzjg13002@163.com");
        webDriver.findElement(sendEmailPage.titleInput).sendKeys("testing");
        webDriver.findElement(sendEmailPage.pictuteAttachedButton).sendKeys("C:\\Users\\86134\\Pictures\\王忠杰.jpg");
        WebElement element = webDriver.findElement(sendEmailPage.switchFrameToSendButton);
        webDriver.switchTo().frame(element);
        webDriver.findElement(sendEmailPage.contentInput).sendKeys("This is qizi!!! I love you!!");
        webDriver.switchTo().defaultContent();
        webDriver.findElement(sendEmailPage.sendButton).click();
       boolean b = webDriver.findElement(By.xpath(".//*[@text()='发送成功']")).isDisplayed();

        System.out.println(b);
        //Assert.assertTrue(b);

    }
    @Test
    public static  void sendEmail() {
        register.login("wzjg13002", "wzj4663050");
        WebDriverWait wait = new WebDriverWait(webDriver, 3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='dvNavTop']/ul/li[2]/span[2]"))).click();
        webDriver.findElement(sendEmailPage.senderInput1).sendKeys("wzjg13002@163.com");
        webDriver.findElement(By.xpath("//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("qizi");
        webDriver.findElement(By.xpath("//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("C:\\Users\\86134\\Pictures\\王忠杰.jpg");
        WebElement element = webDriver.findElement(By.className("APP-editor-iframe"));
        webDriver.switchTo().frame(element);
        webDriver.findElement(By.xpath("/html/body")).sendKeys("Thi is life!");
        webDriver.switchTo().defaultContent();
        webDriver.findElement(By.xpath("//*[@class='js-component-button nui-mainBtn nui-btn nui-btn-hasIcon nui-mainBtn-hasIcon  ']/span[2]")).click();
        boolean b = webDriver.findElement(By.xpath(".//*[@text()='发送成功']")).isDisplayed();

        System.out.println(b);
        //Assert.assertTrue(b);
    }
    @AfterMethod
    public void closeBrowser(){
        webDriver.quit();
    }
}
