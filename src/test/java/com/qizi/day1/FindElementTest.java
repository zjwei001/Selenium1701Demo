package com.qizi.day1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Handler;

public class FindElementTest {
    WebDriver webDriver;

    /**
     * 打开百度页面
     * 定位搜索文本框
     */
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();

    }

    @Test
    public void byIDTest() {
        webDriver.get("https://www.baidu.com");
        WebElement key = webDriver.findElement(By.id("kw"));
        //Skey.sendKeys("testing");
    }

    @Test
    public void byNameTest() {
        webDriver.get("https://www.baidu.com");
        WebElement key = webDriver.findElement(By.name("wd"));
    }

    @Test
    public void byClassTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        WebElement key = webDriver.findElement(By.className("se-bn "));
    }

    @Test
    public void byLinkTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        WebElement key = webDriver.findElement(By.linkText(""));
    }

    @Test
    public void byTagNameTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        List<WebElement> key = webDriver.findElements(By.tagName("input"));

        System.out.println(key.size());
    }

    @Test
    public void xPathTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        // webDriver.findElement(By.xpath(".//*[@id='su']"));
        webDriver.findElement(By.xpath(".//input[@id='su']"));
    }

    @Test
    public void cssTest() {
        webDriver.get("https://www.baidu.com");

        // webDriver.findElement(By.xpath(".//*[@id='su']"));
        webDriver.findElement(By.cssSelector("#lg > map > area"));
    }

    /**
     * 获得所有的标签
     */
    @Test
    public void getAllMark() {
        //*[@id="s-top-left"]/a[1]/font/font
        webDriver.get("https://www.baidu.com");
        List<WebElement> list = webDriver.findElements(By.xpath("//div[@id='s-top-left']/a[1]"));
        String text = list.get(0).getText();
        System.out.println(text);
        for (int i = 0; i < list.size(); i++) {
            String text1 = list.get(i).getText();
            System.out.println(text1);
        }

    }
    @Test
    public void contentFromOtherpage() throws InterruptedException {
        webDriver.get("https://www.baidu.com");//*[@id="s-top-left"]/a[1]));
        webDriver.findElement(By.xpath("//*[text()='新闻']")).click();
        //获取当前页面句柄
     String handler= webDriver.getWindowHandle();
        //获取所有页面的句柄，并判断不是当前句柄，跳出循环，switchTo当前页面句柄
        for (String handlers:webDriver.getWindowHandles()) {
            if (handlers.equals(handler)){
                continue;
            }
            webDriver.switchTo().window(handlers);

        }
        Thread.sleep(3000);
        String title =webDriver.getCurrentUrl();
        WebDriverWait wait=new WebDriverWait(webDriver,3000);
        //wait.until();
        Assert.assertEquals(title,"http://news.baidu.com/");

    }
    @Test
    public void jsTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        //将driver转换 成JavascriptExecutor类型
        JavascriptExecutor js= (JavascriptExecutor)webDriver;
        //执行js
        js.executeScript("document.getElementById(\"id\").setAttribute(\"value\",\"selenium\")");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}
