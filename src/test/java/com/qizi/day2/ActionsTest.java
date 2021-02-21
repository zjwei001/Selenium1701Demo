package com.qizi.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ActionsTest {
    WebDriver webDriver;

    /**
     * 点击百度首页的新闻 button
     */
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        webDriver = new ChromeDriver();

    }

    @Test
    public void rightClickTest() {
        webDriver.get("https://www.baidu.com");
        WebElement buttonbaidu = webDriver.findElement(By.id("su"));
        //实例化Actions class
        Actions actions = new Actions(webDriver);
        actions.contextClick(buttonbaidu).perform();//rightclick
    }

    @Test
    public void doubleClickTest() {
        webDriver.get("https://www.baidu.com");
        WebElement buttonbaidu = webDriver.findElement(By.id("su"));
        //实例化Actions class
        Actions actions = new Actions(webDriver);
        actions.doubleClick(buttonbaidu).perform();//rightclick
        actions.moveToElement(buttonbaidu).perform();
       /*String text= webDriver.findElement(By.xpath("//*[text()=\"Hello World!\"]")).getText();
        Assert.assertEquals(text,"Hello World!");
       WebElement element= webDriver.findElement(By.id("drag"));
        actions.dragAndDropBy(element,500,500).perform();
        WebElement source=webDriver.findElement(By.id(""));
        WebElement target=webDriver.findElement(By.id(""));
        actions.clickAndHold(source).moveToElement(target).release(source).perform();
        List<WebElement> list = webDriver.findElements(By.xpath(""));
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(2)).keyUp(Keys.SHIFT).perform();*/
    }

    @Test
    public void robotTest() throws AWTException, InterruptedException {
        webDriver.get("https://www.baidu.com");
        Robot robot = new Robot();
        //按住Ctrl键
        robot.keyPress(KeyEvent.VK_CONTROL);
        //按住S键
        robot.keyPress(KeyEvent.VK_S);
        //得到S的ASCII 码值
        int keyS= new Character('S');
        System.out.println(keyS);
        Thread.sleep(2000);
        //按住Enter键
        robot.keyPress(KeyEvent.VK_ENTER);

//释放control键
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    @Test
    public void downloadTest() throws InterruptedException {
        webDriver.get("http://pcsoft.hrbapjy.cn/shadu/mgr3/f17.shtml?sfrom=206&keyID=5575");
        webDriver.findElement(By.xpath("//*[text()='安全下载']")).click();
        //System.out.println(element);
        Thread.sleep(5000);


    }

    @Test
    public void clickNews() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //WebElement element= webDriver.findElement(By.xpath("//div[@id='s-top-left']/a[0]/font/font"));
        webDriver.findElement(By.xpath("//*[@id='s-top-left']/a[1]")).click();
        //System.out.println(element.getText());
        //webDriver.manage().window().maximize();
        Thread.sleep(3000);

        //得到所有窗口句柄
        //webDriver.getWindowHandle();
        Set<String> ur = webDriver.getWindowHandles();
        //存放到list里面
        ArrayList<String> list = new ArrayList<>(ur);

        System.out.println(list.size());
        //获取第二个窗口
        webDriver.switchTo().window(list.get(1));
        //获取当前窗口url
        String u = webDriver.getCurrentUrl();
        System.out.println("actu" + webDriver.getCurrentUrl());
        Assert.assertEquals(u, "http://news.baidu.com/");

    }

    /**
     * 打开百度首页
     * 输入selenium
     * 点击百度一下搜索
     * 效验head下面的title
     */
    @Test
    public void searchTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);
        webDriver.findElement(By.id("kw")).sendKeys("selenium");
        webDriver.findElement(By.id("su")).click();
        Set<String> ur = webDriver.getWindowHandles();
        Thread.sleep(3000);
        String title = webDriver.getTitle();
        Assert.assertEquals(title, "selenium_百度搜索");
    }

    /**
     * 打开百度网址
     * 输入selenium
     * 等待
     */
    @Test
    public void clearTest() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);

        WebElement element = webDriver.findElement(By.id("kw"));
        element.sendKeys("selenium");
        Thread.sleep(3000);
        element.clear();

    }

    /**
     * 打开百度首页
     * 获取新闻文本
     * 校验
     */
    @Test
    public void Test() throws InterruptedException {
        webDriver.get("https://www.baidu.com");
        Thread.sleep(3000);

        String element = webDriver.findElement(By.xpath("//div[@id='s-top-left']/a[1]")).getText();
        Assert.assertEquals(element, "新闻");


    }

    /**
     * 打开百度页面
     * 获取文本框的tagName
     * 校验tagName是否是input
     */
    @Test
    public void tagNameTest() {
        webDriver.get("https://www.baidu.com");
        String tag = webDriver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tag, "input");

    }

    /**
     * 打开百度
     * 判断按钮显示的文本值 是百度一下
     */
    @Test
    public void getText() {
        webDriver.get("https://www.baidu.com");
        String attribute = webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute, "百度一下");
    }

    /**
     * 打开百度
     * 截图百度首页
     */
    @Test
    public void screenshotTest() {
        webDriver.get("https://www.baidu.com");
        File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("D:\\test1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开百度
     * 判断是否有百度一下按钮
     */
    @Test
    public void isDiaplayedTest() {
        webDriver.get("https://www.baidu.com");
        boolean display = webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(display);
    }

    @AfterMethod
    public void closeBrowser() {
        webDriver.quit();
    }
}
